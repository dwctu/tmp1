package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzgv implements zzgx {
    private final String zza;
    private final zzpx zzb;
    private final zzabe zzc;
    private final zzmt zzd;
    private final zzoa zze;
    private final Integer zzf;

    private zzgv(String str, zzabe zzabeVar, zzmt zzmtVar, zzoa zzoaVar, Integer num) {
        this.zza = str;
        this.zzb = zzhg.zzb(str);
        this.zzc = zzabeVar;
        this.zzd = zzmtVar;
        this.zze = zzoaVar;
        this.zzf = num;
    }

    public static zzgv zza(String str, zzabe zzabeVar, zzmt zzmtVar, zzoa zzoaVar, Integer num) throws GeneralSecurityException {
        if (zzoaVar == zzoa.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new zzgv(str, zzabeVar, zzmtVar, zzoaVar, num);
    }

    public final zzmt zzb() {
        return this.zzd;
    }

    public final zzoa zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzgx
    public final zzpx zzd() {
        return this.zzb;
    }

    public final zzabe zze() {
        return this.zzc;
    }

    public final Integer zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zza;
    }
}
