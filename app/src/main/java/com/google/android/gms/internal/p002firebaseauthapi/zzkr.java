package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzkr extends zzach implements zzadn {
    private static final zzkr zzb;

    static {
        zzkr zzkrVar = new zzkr();
        zzb = zzkrVar;
        zzach.zzE(zzkr.class, zzkrVar);
    }

    private zzkr() {
    }

    public static zzkr zzb() {
        return zzb;
    }

    public static zzkr zzc(zzabe zzabeVar, zzabu zzabuVar) throws zzacp {
        return (zzkr) zzach.zzw(zzb, zzabeVar, zzabuVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        zzkp zzkpVar = null;
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0000", null);
        }
        if (i2 == 3) {
            return new zzkr();
        }
        if (i2 == 4) {
            return new zzkq(zzkpVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
