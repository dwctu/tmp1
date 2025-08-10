package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzfc extends zzgu {
    public zzfc() {
        super(zzmm.class, zzmp.class, new zzfa(zzau.class));
    }

    public static /* bridge */ /* synthetic */ zzfz zzh(int i, int i2, int i3, int i4) {
        zzmi zzmiVarZza = zzmj.zza();
        zzmiVarZza.zzc(i);
        zzmiVarZza.zzb(i2);
        zzmiVarZza.zza(i3);
        zzmj zzmjVar = (zzmj) zzmiVarZza.zzk();
        zzmf zzmfVarZza = zzmg.zza();
        zzmfVarZza.zza(zzmjVar);
        return new zzfz((zzmg) zzmfVarZza.zzk(), i4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final zzga zza() {
        return new zzfb(this, zzmg.class);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final zzmt zzb() {
        return zzmt.ASYMMETRIC_PRIVATE;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* synthetic */ zzadm zzc(zzabe zzabeVar) throws zzacp {
        return zzmm.zzd(zzabeVar, zzabu.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.HpkePrivateKey";
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgb
    public final /* bridge */ /* synthetic */ void zze(zzadm zzadmVar) throws GeneralSecurityException {
        zzmm zzmmVar = (zzmm) zzadmVar;
        if (zzmmVar.zzf().zzs()) {
            throw new GeneralSecurityException("Private key is empty.");
        }
        if (!zzmmVar.zzk()) {
            throw new GeneralSecurityException("Missing public key.");
        }
        zzpu.zzc(zzmmVar.zza(), 0);
        zzff.zza(zzmmVar.zze().zzb());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgu
    public final /* synthetic */ zzadm zzg(zzadm zzadmVar) throws GeneralSecurityException {
        return ((zzmm) zzadmVar).zze();
    }
}
