package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzcv extends zzgb {
    public zzcv() {
        super(zzkc.class, new zzct(zzap.class));
    }

    public static void zzg(boolean z) throws GeneralSecurityException {
        if (zzi()) {
            zzbz.zzn(new zzcv(), true);
        }
    }

    public static /* bridge */ /* synthetic */ zzfz zzh(int i, int i2) {
        zzke zzkeVarZzb = zzkf.zzb();
        zzkeVarZzb.zza(i);
        return new zzfz((zzkf) zzkeVarZzb.zzk(), i2);
    }

    private static boolean zzi() throws NoSuchPaddingException, NoSuchAlgorithmException {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final zzga zza() {
        return new zzcu(this, zzkf.class);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final zzmt zzb() {
        return zzmt.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* synthetic */ zzadm zzc(zzabe zzabeVar) throws zzacp {
        return zzkc.zzd(zzabeVar, zzabu.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* bridge */ /* synthetic */ void zze(zzadm zzadmVar) throws GeneralSecurityException {
        zzkc zzkcVar = (zzkc) zzadmVar;
        zzpu.zzc(zzkcVar.zza(), 0);
        zzpu.zzb(zzkcVar.zze().zzd());
    }
}
