package com.wear.main.account.finger;

import android.os.Handler;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;

/* loaded from: classes3.dex */
public class FingerAuthCallback extends FingerprintManagerCompat.AuthenticationCallback {
    public Handler a;

    public FingerAuthCallback(Handler handler) {
        this.a = null;
        this.a = handler;
    }

    @Override // androidx.core.hardware.fingerprint.FingerprintManagerCompat.AuthenticationCallback
    public void onAuthenticationError(int i, CharSequence charSequence) {
        super.onAuthenticationError(i, charSequence);
        Handler handler = this.a;
        if (handler != null) {
            handler.obtainMessage(102, i, 0).sendToTarget();
        }
    }

    @Override // androidx.core.hardware.fingerprint.FingerprintManagerCompat.AuthenticationCallback
    public void onAuthenticationFailed() {
        super.onAuthenticationFailed();
        Handler handler = this.a;
        if (handler != null) {
            handler.obtainMessage(101).sendToTarget();
        }
    }

    @Override // androidx.core.hardware.fingerprint.FingerprintManagerCompat.AuthenticationCallback
    public void onAuthenticationHelp(int i, CharSequence charSequence) {
        super.onAuthenticationHelp(i, charSequence);
        Handler handler = this.a;
        if (handler != null) {
            handler.obtainMessage(103, i, 0).sendToTarget();
        }
    }

    @Override // androidx.core.hardware.fingerprint.FingerprintManagerCompat.AuthenticationCallback
    public void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult authenticationResult) {
        super.onAuthenticationSucceeded(authenticationResult);
        Handler handler = this.a;
        if (handler != null) {
            handler.obtainMessage(100).sendToTarget();
        }
    }
}
