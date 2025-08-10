package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzcl extends zzga {
    public final /* synthetic */ zzcm zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcl(zzcm zzcmVar, Class cls) {
        super(cls);
        this.zza = zzcmVar;
    }

    public static final zzje zzf(zzjh zzjhVar) throws GeneralSecurityException {
        zzjd zzjdVarZzb = zzje.zzb();
        zzjdVarZzb.zzb(zzjhVar.zzf());
        zzjdVarZzb.zza(zzabe.zzn(zzps.zza(zzjhVar.zza())));
        zzjdVarZzb.zzc(0);
        return (zzje) zzjdVarZzb.zzk();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final /* bridge */ /* synthetic */ zzadm zza(zzadm zzadmVar) throws GeneralSecurityException {
        return zzf((zzjh) zzadmVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    public final /* synthetic */ zzadm zzb(zzabe zzabeVar) throws zzacp {
        return zzjh.zze(zzabeVar, zzabu.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzga
    /* renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final void zzd(zzjh zzjhVar) throws GeneralSecurityException {
        zzpu.zzb(zzjhVar.zza());
        zzcm zzcmVar = this.zza;
        zzcm.zzi(zzjhVar.zzf());
    }
}
