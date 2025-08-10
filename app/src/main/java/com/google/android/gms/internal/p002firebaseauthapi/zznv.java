package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zznv extends zzach implements zzadn {
    private static final zznv zzb;
    private int zze;
    private zzny zzf;

    static {
        zznv zznvVar = new zznv();
        zzb = zznvVar;
        zzach.zzE(zznv.class, zznvVar);
    }

    private zznv() {
    }

    public static zznu zzb() {
        return (zznu) zzb.zzt();
    }

    public static zznv zzd(zzabe zzabeVar, zzabu zzabuVar) throws zzacp {
        return (zznv) zzach.zzw(zzb, zzabeVar, zzabuVar);
    }

    public static /* synthetic */ void zzg(zznv zznvVar, zzny zznyVar) {
        zznyVar.getClass();
        zznvVar.zzf = zznyVar;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzny zze() {
        zzny zznyVar = this.zzf;
        return zznyVar == null ? zzny.zzc() : zznyVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zze", "zzf"});
        }
        if (i2 == 3) {
            return new zznv();
        }
        zznt zzntVar = null;
        if (i2 == 4) {
            return new zznu(zzntVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
