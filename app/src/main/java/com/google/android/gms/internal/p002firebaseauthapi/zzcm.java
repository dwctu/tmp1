package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzcm extends zzgb {
    public zzcm() {
        super(zzje.class, new zzck(zzpm.class));
    }

    public static final void zzh(zzje zzjeVar) throws GeneralSecurityException {
        zzpu.zzc(zzjeVar.zza(), 0);
        zzpu.zzb(zzjeVar.zzg().zzd());
        zzi(zzjeVar.zzf());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zzi(zzjk zzjkVar) throws GeneralSecurityException {
        if (zzjkVar.zza() < 12 || zzjkVar.zza() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final zzga zza() {
        return new zzcl(this, zzjh.class);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final zzmt zzb() {
        return zzmt.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* synthetic */ zzadm zzc(zzabe zzabeVar) throws zzacp {
        return zzje.zze(zzabeVar, zzabu.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* bridge */ /* synthetic */ void zze(zzadm zzadmVar) throws GeneralSecurityException {
        zzh((zzje) zzadmVar);
    }
}
