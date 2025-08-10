package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzcb {
    public static final Charset zza = Charset.forName("UTF-8");

    public static zznm zza(zznh zznhVar) {
        zznj zznjVarZza = zznm.zza();
        zznjVarZza.zzb(zznhVar.zzb());
        for (zzng zzngVar : zznhVar.zzg()) {
            zznk zznkVarZzb = zznl.zzb();
            zznkVarZzb.zzc(zzngVar.zzb().zzf());
            zznkVarZzb.zzd(zzngVar.zzk());
            zznkVarZzb.zzb(zzngVar.zze());
            zznkVarZzb.zza(zzngVar.zza());
            zznjVarZza.zza((zznl) zznkVarZzb.zzk());
        }
        return (zznm) zznjVarZza.zzk();
    }

    public static void zzb(zznh zznhVar) throws GeneralSecurityException {
        int iZzb = zznhVar.zzb();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzng zzngVar : zznhVar.zzg()) {
            if (zzngVar.zzk() == 3) {
                if (!zzngVar.zzi()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzngVar.zza())));
                }
                if (zzngVar.zze() == zzoa.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzngVar.zza())));
                }
                if (zzngVar.zzk() == 2) {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzngVar.zza())));
                }
                if (zzngVar.zza() == iZzb) {
                    if (z) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z = true;
                }
                z2 &= zzngVar.zzb().zzb() == zzmt.ASYMMETRIC_PUBLIC;
                i++;
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
