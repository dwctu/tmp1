package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzkc extends zzach implements zzadn {
    private static final zzkc zzb;
    private int zze;
    private zzabe zzf = zzabe.zzb;

    static {
        zzkc zzkcVar = new zzkc();
        zzb = zzkcVar;
        zzach.zzE(zzkc.class, zzkcVar);
    }

    private zzkc() {
    }

    public static zzkb zzb() {
        return (zzkb) zzb.zzt();
    }

    public static zzkc zzd(zzabe zzabeVar, zzabu zzabuVar) throws zzacp {
        return (zzkc) zzach.zzw(zzb, zzabeVar, zzabuVar);
    }

    public final int zza() {
        return this.zze;
    }

    public final zzabe zze() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzkc();
        }
        zzka zzkaVar = null;
        if (i2 == 4) {
            return new zzkb(zzkaVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
