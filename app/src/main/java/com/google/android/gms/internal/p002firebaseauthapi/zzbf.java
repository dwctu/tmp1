package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzbf {
    private final zzmz zza;

    private zzbf(zzmz zzmzVar) {
        this.zza = zzmzVar;
    }

    public static zzbf zze(String str, byte[] bArr, int i) {
        zzmy zzmyVarZza = zzmz.zza();
        zzmyVarZza.zzb(str);
        zzmyVarZza.zzc(zzabe.zzn(bArr));
        int i2 = i - 1;
        zzmyVarZza.zza(i2 != 0 ? i2 != 1 ? i2 != 2 ? zzoa.CRUNCHY : zzoa.RAW : zzoa.LEGACY : zzoa.TINK);
        return new zzbf((zzmz) zzmyVarZza.zzk());
    }

    public final zzmz zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zza.zzf();
    }

    public final byte[] zzc() {
        return this.zza.zze().zzt();
    }

    public final int zzd() {
        zzoa zzoaVarZzd = this.zza.zzd();
        zzoa zzoaVar = zzoa.UNKNOWN_PREFIX;
        int iOrdinal = zzoaVarZzd.ordinal();
        int i = 1;
        if (iOrdinal != 1) {
            i = 2;
            if (iOrdinal != 2) {
                i = 3;
                if (iOrdinal != 3) {
                    if (iOrdinal == 4) {
                        return 4;
                    }
                    throw new IllegalArgumentException("Unknown output prefix type");
                }
            }
        }
        return i;
    }
}
