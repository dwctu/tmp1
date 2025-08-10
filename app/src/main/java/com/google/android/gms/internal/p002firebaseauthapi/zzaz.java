package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public class zzaz implements zzax {
    private final zzgb zza;
    private final Class zzb;

    public zzaz(zzgb zzgbVar, Class cls) {
        if (!zzgbVar.zzm().contains(cls) && !Void.class.equals(cls)) {
            throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", zzgbVar.toString(), cls.getName()));
        }
        this.zza = zzgbVar;
        this.zzb = cls;
    }

    private final zzay zzf() {
        return new zzay(this.zza.zza());
    }

    private final Object zzg(zzadm zzadmVar) throws GeneralSecurityException {
        if (Void.class.equals(this.zzb)) {
            throw new GeneralSecurityException("Cannot create a primitive for Void");
        }
        this.zza.zze(zzadmVar);
        return this.zza.zzl(zzadmVar, this.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzax
    public final zzmu zza(zzabe zzabeVar) throws GeneralSecurityException {
        try {
            zzadm zzadmVarZza = zzf().zza(zzabeVar);
            zzmr zzmrVarZza = zzmu.zza();
            zzmrVarZza.zzb(this.zza.zzd());
            zzmrVarZza.zzc(zzadmVarZza.zzo());
            zzmrVarZza.zza(this.zza.zzb());
            return (zzmu) zzmrVarZza.zzk();
        } catch (zzacp e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzax
    public final zzadm zzb(zzabe zzabeVar) throws GeneralSecurityException {
        try {
            return zzf().zza(zzabeVar);
        } catch (zzacp e) {
            throw new GeneralSecurityException("Failures parsing proto of type ".concat(String.valueOf(this.zza.zza().zzg().getName())), e);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzax
    public final Object zzc(zzabe zzabeVar) throws GeneralSecurityException {
        try {
            return zzg(this.zza.zzc(zzabeVar));
        } catch (zzacp e) {
            throw new GeneralSecurityException("Failures parsing proto of type ".concat(String.valueOf(this.zza.zzk().getName())), e);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzax
    public final Object zzd(zzadm zzadmVar) throws GeneralSecurityException {
        String strConcat = "Expected proto of type ".concat(String.valueOf(this.zza.zzk().getName()));
        if (this.zza.zzk().isInstance(zzadmVar)) {
            return zzg(zzadmVar);
        }
        throw new GeneralSecurityException(strConcat);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzax
    public final String zze() {
        return this.zza.zzd();
    }
}
