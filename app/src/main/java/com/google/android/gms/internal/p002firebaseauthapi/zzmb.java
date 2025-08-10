package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzmb extends zzach implements zzadn {
    private static final zzmb zzb;
    private int zze;
    private int zzf;

    static {
        zzmb zzmbVar = new zzmb();
        zzb = zzmbVar;
        zzach.zzE(zzmb.class, zzmbVar);
    }

    private zzmb() {
    }

    public static zzma zzb() {
        return (zzma) zzb.zzt();
    }

    public static zzmb zzd() {
        return zzb;
    }

    public final int zza() {
        return this.zzf;
    }

    public final int zzf() {
        int iZzb = zzls.zzb(this.zze);
        if (iZzb == 0) {
            return 1;
        }
        return iZzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzmb();
        }
        zzlz zzlzVar = null;
        if (i2 == 4) {
            return new zzma(zzlzVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
