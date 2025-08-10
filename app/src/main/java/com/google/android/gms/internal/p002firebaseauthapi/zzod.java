package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
@Deprecated
/* loaded from: classes2.dex */
public final class zzod extends zzach implements zzadn {
    private static final zzod zzb;
    private String zze = "";
    private zzacm zzf = zzach.zzy();

    static {
        zzod zzodVar = new zzod();
        zzb = zzodVar;
        zzach.zzE(zzod.class, zzodVar);
    }

    private zzod() {
    }

    public static zzod zzb() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zze", "zzf", zznc.class});
        }
        if (i2 == 3) {
            return new zzod();
        }
        zzob zzobVar = null;
        if (i2 == 4) {
            return new zzoc(zzobVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
