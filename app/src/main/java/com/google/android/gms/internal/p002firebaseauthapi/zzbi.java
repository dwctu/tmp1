package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzbi {
    private final zzne zza;

    private zzbi(zzne zzneVar) {
        this.zza = zzneVar;
    }

    public static zzbi zze() {
        return new zzbi(zznh.zzc());
    }

    public static zzbi zzf(zzbh zzbhVar) {
        return new zzbi((zzne) zzbhVar.zzc().zzu());
    }

    private final synchronized int zzg() {
        int iZza;
        iZza = zzhg.zza();
        while (zzj(iZza)) {
            iZza = zzhg.zza();
        }
        return iZza;
    }

    private final synchronized zzng zzh(zzmu zzmuVar, zzoa zzoaVar) throws GeneralSecurityException {
        zznf zznfVarZzc;
        int iZzg = zzg();
        if (zzoaVar == zzoa.UNKNOWN_PREFIX) {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        zznfVarZzc = zzng.zzc();
        zznfVarZzc.zza(zzmuVar);
        zznfVarZzc.zzb(iZzg);
        zznfVarZzc.zzd(3);
        zznfVarZzc.zzc(zzoaVar);
        return (zzng) zznfVarZzc.zzk();
    }

    private final synchronized zzng zzi(zzmz zzmzVar) throws GeneralSecurityException {
        return zzh(zzbz.zzc(zzmzVar), zzmzVar.zzd());
    }

    private final synchronized boolean zzj(int i) {
        boolean z;
        Iterator it = this.zza.zze().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (((zzng) it.next()).zza() == i) {
                z = true;
                break;
            }
        }
        return z;
    }

    @Deprecated
    public final synchronized int zza(zzmz zzmzVar, boolean z) throws GeneralSecurityException {
        zzng zzngVarZzi;
        zzngVarZzi = zzi(zzmzVar);
        this.zza.zzb(zzngVarZzi);
        return zzngVarZzi.zza();
    }

    public final synchronized zzbh zzb() throws GeneralSecurityException {
        return zzbh.zza((zznh) this.zza.zzk());
    }

    public final synchronized zzbi zzc(zzbf zzbfVar) throws GeneralSecurityException {
        zza(zzbfVar.zza(), false);
        return this;
    }

    public final synchronized zzbi zzd(int i) throws GeneralSecurityException {
        for (int i2 = 0; i2 < this.zza.zza(); i2++) {
            zzng zzngVarZzd = this.zza.zzd(i2);
            if (zzngVarZzd.zza() == i) {
                if (zzngVarZzd.zzk() != 3) {
                    throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + i);
                }
                this.zza.zzc(i);
            }
        }
        throw new GeneralSecurityException("key not found: " + i);
        return this;
    }
}
