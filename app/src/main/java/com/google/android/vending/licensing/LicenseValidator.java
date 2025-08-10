package com.google.android.vending.licensing;

import android.text.TextUtils;
import com.google.android.vending.licensing.util.Base64;
import com.google.android.vending.licensing.util.Base64DecoderException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

/* loaded from: classes2.dex */
public class LicenseValidator {
    private static final int ERROR_CONTACTING_SERVER = 257;
    private static final int ERROR_INVALID_PACKAGE_NAME = 258;
    private static final int ERROR_NON_MATCHING_UID = 259;
    private static final int ERROR_NOT_MARKET_MANAGED = 3;
    private static final int ERROR_OVER_QUOTA = 5;
    private static final int ERROR_SERVER_FAILURE = 4;
    private static final int LICENSED = 0;
    private static final int LICENSED_OLD_KEY = 2;
    private static final int NOT_LICENSED = 1;
    private static final String SIGNATURE_ALGORITHM = "SHA1withRSA";
    private static final String TAG = "LicenseValidator";
    private final LicenseCheckerCallback mCallback;
    private final DeviceLimiter mDeviceLimiter;
    private final int mNonce;
    private final String mPackageName;
    private final Policy mPolicy;
    private final String mVersionCode;

    public LicenseValidator(Policy policy, DeviceLimiter deviceLimiter, LicenseCheckerCallback licenseCheckerCallback, int i, String str, String str2) {
        this.mPolicy = policy;
        this.mDeviceLimiter = deviceLimiter;
        this.mCallback = licenseCheckerCallback;
        this.mNonce = i;
        this.mPackageName = str;
        this.mVersionCode = str2;
    }

    private void handleApplicationError(int i) {
        this.mCallback.applicationError(i);
    }

    private void handleInvalidResponse() {
        this.mCallback.dontAllow(Policy.NOT_LICENSED);
    }

    private void handleResponse(int i, ResponseData responseData) {
        this.mPolicy.processServerResponse(i, responseData);
        if (this.mPolicy.allowAccess()) {
            this.mCallback.allow(i);
        } else {
            this.mCallback.dontAllow(i);
        }
    }

    public LicenseCheckerCallback getCallback() {
        return this.mCallback;
    }

    public int getNonce() {
        return this.mNonce;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public void verify(PublicKey publicKey, int i, String str, String str2) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        ResponseData responseData;
        String str3 = null;
        if (i == 0 || i == 1 || i == 2) {
            try {
                if (TextUtils.isEmpty(str)) {
                    handleInvalidResponse();
                    return;
                }
                Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
                signature.initVerify(publicKey);
                signature.update(str.getBytes());
                if (!signature.verify(Base64.decode(str2))) {
                    handleInvalidResponse();
                    return;
                }
                try {
                    ResponseData responseData2 = ResponseData.parse(str);
                    if (responseData2.responseCode != i) {
                        handleInvalidResponse();
                        return;
                    }
                    if (responseData2.nonce != this.mNonce) {
                        handleInvalidResponse();
                        return;
                    }
                    if (!responseData2.packageName.equals(this.mPackageName)) {
                        handleInvalidResponse();
                        return;
                    }
                    if (!responseData2.versionCode.equals(this.mVersionCode)) {
                        handleInvalidResponse();
                        return;
                    }
                    String str4 = responseData2.userId;
                    if (TextUtils.isEmpty(str4)) {
                        handleInvalidResponse();
                        return;
                    } else {
                        str3 = str4;
                        responseData = responseData2;
                    }
                } catch (IllegalArgumentException unused) {
                    handleInvalidResponse();
                    return;
                }
            } catch (Base64DecoderException unused2) {
                handleInvalidResponse();
                return;
            } catch (InvalidKeyException unused3) {
                handleApplicationError(5);
                return;
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            } catch (SignatureException e2) {
                throw new RuntimeException(e2);
            }
        } else {
            responseData = null;
        }
        if (i != 0) {
            if (i == 1) {
                handleResponse(Policy.NOT_LICENSED, responseData);
                return;
            }
            if (i != 2) {
                if (i == 3) {
                    handleApplicationError(3);
                    return;
                }
                if (i == 4) {
                    handleResponse(Policy.RETRY, responseData);
                    return;
                }
                if (i == 5) {
                    handleResponse(Policy.RETRY, responseData);
                    return;
                }
                switch (i) {
                    case 257:
                        handleResponse(Policy.RETRY, responseData);
                        return;
                    case 258:
                        handleApplicationError(1);
                        return;
                    case ERROR_NON_MATCHING_UID /* 259 */:
                        handleApplicationError(2);
                        return;
                    default:
                        handleInvalidResponse();
                        return;
                }
            }
        }
        handleResponse(this.mDeviceLimiter.isDeviceAllowed(str3), responseData);
    }
}
