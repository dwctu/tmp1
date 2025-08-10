package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Build;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzfp implements zzbk {
    private static final String zza = "zzfp";
    private KeyStore zzb;

    @RequiresApi(23)
    public zzfp() throws GeneralSecurityException, IOException {
        if (Build.VERSION.SDK_INT < 23) {
            throw new IllegalStateException("need Android Keystore on Android M or newer");
        }
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            this.zzb = keyStore;
        } catch (IOException | GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbk
    public final synchronized zzap zza(String str) throws GeneralSecurityException {
        zzfo zzfoVar;
        zzfoVar = new zzfo(zzpu.zza("android-keystore://", str), this.zzb);
        byte[] bArrZza = zzps.zza(10);
        byte[] bArr = new byte[0];
        if (!Arrays.equals(bArrZza, zzfoVar.zza(zzfoVar.zzb(bArrZza, bArr), bArr))) {
            throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
        }
        return zzfoVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbk
    @RequiresApi(23)
    public final synchronized boolean zzb(String str) {
        return str.toLowerCase(Locale.US).startsWith("android-keystore://");
    }

    public final synchronized boolean zzc(String str) throws GeneralSecurityException {
        String strZza;
        strZza = zzpu.zza("android-keystore://", str);
        try {
        } catch (NullPointerException unused) {
            try {
                Thread.sleep(20L);
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                this.zzb = keyStore;
                keyStore.load(null);
            } catch (IOException e) {
                throw new GeneralSecurityException(e);
            } catch (InterruptedException unused2) {
            }
            return this.zzb.containsAlias(strZza);
        }
        return this.zzb.containsAlias(strZza);
    }
}
