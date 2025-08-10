package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzcj extends zzgb {
    public zzcj() {
        super(zziy.class, new zzch(zzap.class));
    }

    public static /* bridge */ /* synthetic */ zzfz zzg(int i, int i2, int i3, int i4, int i5, int i6) {
        zzjg zzjgVarZzb = zzjh.zzb();
        zzjj zzjjVarZzb = zzjk.zzb();
        zzjjVarZzb.zza(16);
        zzjgVarZzb.zzb((zzjk) zzjjVarZzb.zzk());
        zzjgVarZzb.zza(i);
        zzjh zzjhVar = (zzjh) zzjgVarZzb.zzk();
        zzlx zzlxVarZzb = zzly.zzb();
        zzma zzmaVarZzb = zzmb.zzb();
        zzmaVarZzb.zzb(5);
        zzmaVarZzb.zza(i4);
        zzlxVarZzb.zzb((zzmb) zzmaVarZzb.zzk());
        zzlxVarZzb.zza(32);
        zzly zzlyVar = (zzly) zzlxVarZzb.zzk();
        zzja zzjaVarZza = zzjb.zza();
        zzjaVarZza.zza(zzjhVar);
        zzjaVarZza.zzb(zzlyVar);
        return new zzfz((zzjb) zzjaVarZza.zzk(), i6);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final zzga zza() {
        return new zzci(this, zzjb.class);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final zzmt zzb() {
        return zzmt.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* synthetic */ zzadm zzc(zzabe zzabeVar) throws zzacp {
        return zziy.zzd(zzabeVar, zzabu.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* bridge */ /* synthetic */ void zze(zzadm zzadmVar) throws GeneralSecurityException {
        zziy zziyVar = (zziy) zzadmVar;
        zzpu.zzc(zziyVar.zza(), 0);
        new zzcm();
        zzcm.zzh(zziyVar.zze());
        new zzhu();
        zzhu.zzh(zziyVar.zzf());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final int zzf() {
        return 2;
    }
}
