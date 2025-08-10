package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzoj extends zzach implements zzadn {
    private static final zzoj zzb;
    private int zze;

    static {
        zzoj zzojVar = new zzoj();
        zzb = zzojVar;
        zzach.zzE(zzoj.class, zzojVar);
    }

    private zzoj() {
    }

    public static zzoj zzb() {
        return zzb;
    }

    public static zzoj zzc(zzabe zzabeVar, zzabu zzabuVar) throws zzacp {
        return (zzoj) zzach.zzw(zzb, zzabeVar, zzabuVar);
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
            return new zzoj();
        }
        zzoh zzohVar = null;
        if (i2 == 4) {
            return new zzoi(zzohVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
