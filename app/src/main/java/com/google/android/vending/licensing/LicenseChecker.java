package com.google.android.vending.licensing;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.vending.licensing.ILicensingService;
import com.google.android.vending.licensing.util.Base64;
import com.google.android.vending.licensing.util.Base64DecoderException;
import dc.ke;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/* loaded from: classes2.dex */
public class LicenseChecker implements ServiceConnection {
    private static final boolean DEBUG_LICENSE_ERROR = false;
    private static final String KEY_FACTORY_ALGORITHM = "RSA";
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final String TAG = "LicenseChecker";
    private static final int TIMEOUT_MS = 10000;
    private final Context mContext;
    private Handler mHandler;
    private final String mPackageName;
    private final Policy mPolicy;
    private PublicKey mPublicKey;
    private ILicensingService mService;
    private final String mVersionCode;
    private final Set<LicenseValidator> mChecksInProgress = new HashSet();
    private final Queue<LicenseValidator> mPendingChecks = new LinkedList();

    public class ResultListener extends ke.a {
        private static final int ERROR_CONTACTING_SERVER = 257;
        private static final int ERROR_INVALID_PACKAGE_NAME = 258;
        private static final int ERROR_NON_MATCHING_UID = 259;
        private Runnable mOnTimeout;
        private final LicenseValidator mValidator;

        public ResultListener(LicenseValidator licenseValidator) {
            this.mValidator = licenseValidator;
            this.mOnTimeout = new Runnable() { // from class: com.google.android.vending.licensing.LicenseChecker.ResultListener.1
                @Override // java.lang.Runnable
                public void run() {
                    ResultListener resultListener = ResultListener.this;
                    LicenseChecker.this.handleServiceConnectionError(resultListener.mValidator);
                    ResultListener resultListener2 = ResultListener.this;
                    LicenseChecker.this.finishCheck(resultListener2.mValidator);
                }
            };
            startTimeout();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimeout() {
            LicenseChecker.this.mHandler.removeCallbacks(this.mOnTimeout);
        }

        private void startTimeout() {
            LicenseChecker.this.mHandler.postDelayed(this.mOnTimeout, 10000L);
        }

        @Override // dc.ke
        public void verifyLicense(final int i, final String str, final String str2) {
            LicenseChecker.this.mHandler.post(new Runnable() { // from class: com.google.android.vending.licensing.LicenseChecker.ResultListener.2
                @Override // java.lang.Runnable
                public void run() throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
                    if (LicenseChecker.this.mChecksInProgress.contains(ResultListener.this.mValidator)) {
                        ResultListener.this.clearTimeout();
                        ResultListener.this.mValidator.verify(LicenseChecker.this.mPublicKey, i, str, str2);
                        ResultListener resultListener = ResultListener.this;
                        LicenseChecker.this.finishCheck(resultListener.mValidator);
                    }
                }
            });
        }
    }

    public LicenseChecker(Context context, Policy policy, String str) {
        this.mContext = context;
        this.mPolicy = policy;
        this.mPublicKey = generatePublicKey(str);
        String packageName = context.getPackageName();
        this.mPackageName = packageName;
        this.mVersionCode = getVersionCode(context, packageName);
        HandlerThread handlerThread = new HandlerThread("background thread");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
    }

    private void cleanupService() {
        if (this.mService != null) {
            try {
                this.mContext.unbindService(this);
            } catch (IllegalArgumentException unused) {
            }
            this.mService = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void finishCheck(LicenseValidator licenseValidator) {
        this.mChecksInProgress.remove(licenseValidator);
        if (this.mChecksInProgress.isEmpty()) {
            cleanupService();
        }
    }

    private int generateNonce() {
        return RANDOM.nextInt();
    }

    private static PublicKey generatePublicKey(String str) {
        try {
            return KeyFactory.getInstance(KEY_FACTORY_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(str)));
        } catch (Base64DecoderException e) {
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        } catch (InvalidKeySpecException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    private static String getVersionCode(Context context, String str) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(str, 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void handleServiceConnectionError(LicenseValidator licenseValidator) {
        this.mPolicy.processServerResponse(Policy.RETRY, null);
        if (this.mPolicy.allowAccess()) {
            licenseValidator.getCallback().allow(Policy.RETRY);
        } else {
            licenseValidator.getCallback().dontAllow(Policy.RETRY);
        }
    }

    private void runChecks() {
        while (true) {
            LicenseValidator licenseValidatorPoll = this.mPendingChecks.poll();
            if (licenseValidatorPoll == null) {
                return;
            }
            try {
                String str = "Calling checkLicense on service for " + licenseValidatorPoll.getPackageName();
                this.mService.a(licenseValidatorPoll.getNonce(), licenseValidatorPoll.getPackageName(), new ResultListener(licenseValidatorPoll));
                this.mChecksInProgress.add(licenseValidatorPoll);
            } catch (RemoteException unused) {
                handleServiceConnectionError(licenseValidatorPoll);
            }
        }
    }

    public synchronized void checkAccess(LicenseCheckerCallback licenseCheckerCallback) {
        if (this.mPolicy.allowAccess()) {
            licenseCheckerCallback.allow(256);
        } else {
            LicenseValidator licenseValidator = new LicenseValidator(this.mPolicy, new NullDeviceLimiter(), licenseCheckerCallback, generateNonce(), this.mPackageName, this.mVersionCode);
            if (this.mService == null) {
                try {
                    if (this.mContext.bindService(new Intent(new String(Base64.decode("Y29tLmFuZHJvaWQudmVuZGluZy5saWNlbnNpbmcuSUxpY2Vuc2luZ1NlcnZpY2U="))).setPackage(new String(Base64.decode("Y29tLmFuZHJvaWQudmVuZGluZw=="))), this, 1)) {
                        this.mPendingChecks.offer(licenseValidator);
                    } else {
                        handleServiceConnectionError(licenseValidator);
                    }
                } catch (Base64DecoderException e) {
                    e.printStackTrace();
                } catch (SecurityException unused) {
                    licenseCheckerCallback.applicationError(6);
                }
            } else {
                this.mPendingChecks.offer(licenseValidator);
                runChecks();
            }
        }
    }

    public synchronized void onDestroy() {
        cleanupService();
        this.mHandler.getLooper().quit();
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.mService = ILicensingService.a.d(iBinder);
        runChecks();
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceDisconnected(ComponentName componentName) {
        this.mService = null;
    }
}
