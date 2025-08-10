package com.epicgames.unreal;

import android.provider.Settings;
import com.google.android.vending.licensing.AESObfuscator;
import com.google.android.vending.licensing.LicenseChecker;
import com.google.android.vending.licensing.LicenseCheckerCallback;
import com.google.android.vending.licensing.ServerManagedPolicy;
import com.google.common.base.Ascii;

/* loaded from: classes.dex */
public class GooglePlayLicensing {
    public static GooglePlayLicensing GoogleLicensing;
    private static final byte[] SALT = {-46, 65, Ascii.RS, Byte.MIN_VALUE, -103, -57, 74, -64, 51, 88, -95, -45, 77, -117, -36, -113, -11, 32, -64, 89};
    private Logger Log;
    private GameActivity gameActivity;
    private LicenseChecker mChecker;
    private LicenseCheckerCallback mLicenseCheckerCallback;

    public class MyLicenseCheckerCallback implements LicenseCheckerCallback {
        private MyLicenseCheckerCallback() {
        }

        @Override // com.google.android.vending.licensing.LicenseCheckerCallback
        public void allow(int i) {
            if (GooglePlayLicensing.this.gameActivity.isFinishing()) {
                return;
            }
            GooglePlayLicensing.this.Log.debug("Game is Licensed version. Allowing access.");
        }

        @Override // com.google.android.vending.licensing.LicenseCheckerCallback
        public void applicationError(int i) {
            if (GooglePlayLicensing.this.gameActivity.isFinishing()) {
                return;
            }
            String string = Integer.toString(i);
            GooglePlayLicensing.this.Log.debug("ERROR: " + string);
        }

        @Override // com.google.android.vending.licensing.LicenseCheckerCallback
        public void dontAllow(int i) {
            if (GooglePlayLicensing.this.gameActivity.isFinishing()) {
                return;
            }
            GooglePlayLicensing.this.Log.debug("***************Game is not licensed!");
        }
    }

    public void CheckLicense(String str) {
        this.Log.debug("Attempting to validate Google Play License.");
        String string = Settings.Secure.getString(this.gameActivity.getApplicationContext().getContentResolver(), "android_id");
        this.mLicenseCheckerCallback = new MyLicenseCheckerCallback();
        LicenseChecker licenseChecker = new LicenseChecker(this.gameActivity.getApplicationContext(), new ServerManagedPolicy(this.gameActivity.getApplicationContext(), new AESObfuscator(SALT, this.gameActivity.getApplicationContext().getPackageName(), string)), str);
        this.mChecker = licenseChecker;
        licenseChecker.checkAccess(this.mLicenseCheckerCallback);
    }

    public void Init(GameActivity gameActivity, Logger logger) {
        this.gameActivity = gameActivity;
        this.Log = logger;
    }

    public void onDestroy() {
        LicenseChecker licenseChecker = this.mChecker;
        if (licenseChecker != null) {
            licenseChecker.onDestroy();
        }
    }
}
