package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzhk extends zzgb {
    public zzhk() {
        super(zzip.class, new zzhi(zzbm.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzi(zziv zzivVar) throws GeneralSecurityException {
        if (zzivVar.zza() < 10) {
            throw new GeneralSecurityException("tag size too short");
        }
        if (zzivVar.zza() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzn(int i) throws GeneralSecurityException {
        if (i != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final zzga zza() {
        return new zzhj(this, zzis.class);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final zzmt zzb() {
        return zzmt.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* synthetic */ zzadm zzc(zzabe zzabeVar) throws zzacp {
        return zzip.zzd(zzabeVar, zzabu.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* bridge */ /* synthetic */ void zze(zzadm zzadmVar) throws GeneralSecurityException {
        zzip zzipVar = (zzip) zzadmVar;
        zzpu.zzc(zzipVar.zza(), 0);
        zzn(zzipVar.zzf().zzd());
        zzi(zzipVar.zze());
    }
}
