package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzbx extends zzaz implements zzbw {
    private final zzgu zza;
    private final zzgb zzb;

    public zzbx(zzgu zzguVar, zzgb zzgbVar, Class cls) {
        super(zzguVar, cls);
        this.zza = zzguVar;
        this.zzb = zzgbVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbw
    public final zzmu zzf(zzabe zzabeVar) throws GeneralSecurityException {
        try {
            zzadm zzadmVarZzc = this.zza.zzc(zzabeVar);
            this.zza.zze(zzadmVarZzc);
            zzadm zzadmVarZzg = this.zza.zzg(zzadmVarZzc);
            this.zzb.zze(zzadmVarZzg);
            zzmr zzmrVarZza = zzmu.zza();
            zzmrVarZza.zzb(this.zzb.zzd());
            zzmrVarZza.zzc(zzadmVarZzg.zzo());
            zzmrVarZza.zza(this.zzb.zzb());
            return (zzmu) zzmrVarZza.zzk();
        } catch (zzacp e) {
            throw new GeneralSecurityException("expected serialized proto of type ", e);
        }
    }
}
