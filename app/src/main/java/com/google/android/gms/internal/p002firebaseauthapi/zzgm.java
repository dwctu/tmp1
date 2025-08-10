package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzgm {
    private static final zzgm zza = new zzgm();
    private final AtomicReference zzb = new AtomicReference(new zzhe(new zzgy(), null));

    public static zzgm zzb() {
        return zza;
    }

    public final zzaw zza(zzgv zzgvVar, zzca zzcaVar) {
        try {
            try {
                return ((zzhe) this.zzb.get()).zza(zzgvVar, zzcaVar);
            } catch (GeneralSecurityException unused) {
                return new zzgf(zzgvVar, zzcaVar);
            }
        } catch (GeneralSecurityException e) {
            throw new zzhf("Creating a LegacyProtoKey failed", e);
        }
    }

    public final synchronized void zzc(zzfv zzfvVar) throws GeneralSecurityException {
        zzgy zzgyVar = new zzgy((zzhe) this.zzb.get());
        zzgyVar.zza(zzfvVar);
        this.zzb.set(new zzhe(zzgyVar, null));
    }

    public final synchronized void zzd(zzfy zzfyVar) throws GeneralSecurityException {
        zzgy zzgyVar = new zzgy((zzhe) this.zzb.get());
        zzgyVar.zzb(zzfyVar);
        this.zzb.set(new zzhe(zzgyVar, null));
    }

    public final synchronized void zze(zzgp zzgpVar) throws GeneralSecurityException {
        zzgy zzgyVar = new zzgy((zzhe) this.zzb.get());
        zzgyVar.zzc(zzgpVar);
        this.zzb.set(new zzhe(zzgyVar, null));
    }

    public final synchronized void zzf(zzgs zzgsVar) throws GeneralSecurityException {
        zzgy zzgyVar = new zzgy((zzhe) this.zzb.get());
        zzgyVar.zzd(zzgsVar);
        this.zzb.set(new zzhe(zzgyVar, null));
    }
}
