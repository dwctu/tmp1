package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzjz extends zzach implements zzadn {
    private static final zzjz zzb;
    private int zze;
    private int zzf;

    static {
        zzjz zzjzVar = new zzjz();
        zzb = zzjzVar;
        zzach.zzE(zzjz.class, zzjzVar);
    }

    private zzjz() {
    }

    public static zzjy zzb() {
        return (zzjy) zzb.zzt();
    }

    public static zzjz zzd(zzabe zzabeVar, zzabu zzabuVar) throws zzacp {
        return (zzjz) zzach.zzw(zzb, zzabeVar, zzabuVar);
    }

    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzjz();
        }
        zzjx zzjxVar = null;
        if (i2 == 4) {
            return new zzjy(zzjxVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
