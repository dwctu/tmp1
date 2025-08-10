package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzko extends zzach implements zzadn {
    private static final zzko zzb;
    private int zze;
    private zzabe zzf = zzabe.zzb;

    static {
        zzko zzkoVar = new zzko();
        zzb = zzkoVar;
        zzach.zzE(zzko.class, zzkoVar);
    }

    private zzko() {
    }

    public static zzkn zzb() {
        return (zzkn) zzb.zzt();
    }

    public static zzko zzd(zzabe zzabeVar, zzabu zzabuVar) throws zzacp {
        return (zzko) zzach.zzw(zzb, zzabeVar, zzabuVar);
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
            return new zzko();
        }
        zzkm zzkmVar = null;
        if (i2 == 4) {
            return new zzkn(zzkmVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
