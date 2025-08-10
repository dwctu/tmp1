package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzkf extends zzach implements zzadn {
    private static final zzkf zzb;
    private int zze;
    private int zzf;

    static {
        zzkf zzkfVar = new zzkf();
        zzb = zzkfVar;
        zzach.zzE(zzkf.class, zzkfVar);
    }

    private zzkf() {
    }

    public static zzke zzb() {
        return (zzke) zzb.zzt();
    }

    public static zzkf zzd(zzabe zzabeVar, zzabu zzabuVar) throws zzacp {
        return (zzkf) zzach.zzw(zzb, zzabeVar, zzabuVar);
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
            return zzach.zzD(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zzf", "zze"});
        }
        if (i2 == 3) {
            return new zzkf();
        }
        zzkd zzkdVar = null;
        if (i2 == 4) {
            return new zzke(zzkdVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
