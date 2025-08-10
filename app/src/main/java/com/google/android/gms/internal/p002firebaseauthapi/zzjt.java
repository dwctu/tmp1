package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzjt extends zzach implements zzadn {
    private static final zzjt zzb;
    private int zze;

    static {
        zzjt zzjtVar = new zzjt();
        zzb = zzjtVar;
        zzach.zzE(zzjt.class, zzjtVar);
    }

    private zzjt() {
    }

    public static zzjs zzb() {
        return (zzjs) zzb.zzt();
    }

    public static zzjt zzd() {
        return zzb;
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
            return zzach.zzD(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zze"});
        }
        if (i2 == 3) {
            return new zzjt();
        }
        zzjr zzjrVar = null;
        if (i2 == 4) {
            return new zzjs(zzjrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
