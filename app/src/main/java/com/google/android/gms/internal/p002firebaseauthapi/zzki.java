package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzki extends zzach implements zzadn {
    private static final zzki zzb;
    private int zze;
    private zzabe zzf = zzabe.zzb;

    static {
        zzki zzkiVar = new zzki();
        zzb = zzkiVar;
        zzach.zzE(zzki.class, zzkiVar);
    }

    private zzki() {
    }

    public static zzkh zzb() {
        return (zzkh) zzb.zzt();
    }

    public static zzki zzd(zzabe zzabeVar, zzabu zzabuVar) throws zzacp {
        return (zzki) zzach.zzw(zzb, zzabeVar, zzabuVar);
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
            return zzach.zzD(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzki();
        }
        zzkg zzkgVar = null;
        if (i2 == 4) {
            return new zzkh(zzkgVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
