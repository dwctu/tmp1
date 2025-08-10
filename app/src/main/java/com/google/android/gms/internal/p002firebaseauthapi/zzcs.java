package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzcs extends zzgb {
    public zzcs() {
        super(zzjw.class, new zzcq(zzap.class));
    }

    public static /* bridge */ /* synthetic */ zzfz zzg(int i, int i2) {
        zzjy zzjyVarZzb = zzjz.zzb();
        zzjyVarZzb.zza(i);
        return new zzfz((zzjz) zzjyVarZzb.zzk(), i2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final zzga zza() {
        return new zzcr(this, zzjz.class);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final zzmt zzb() {
        return zzmt.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* synthetic */ zzadm zzc(zzabe zzabeVar) throws zzacp {
        return zzjw.zzd(zzabeVar, zzabu.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* bridge */ /* synthetic */ void zze(zzadm zzadmVar) throws GeneralSecurityException {
        zzjw zzjwVar = (zzjw) zzadmVar;
        zzpu.zzc(zzjwVar.zza(), 0);
        zzpu.zzb(zzjwVar.zze().zzd());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final int zzf() {
        return 2;
    }
}
