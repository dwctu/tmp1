package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
@Deprecated
/* loaded from: classes2.dex */
public final class zznc extends zzach implements zzadn {
    private static final zznc zzb;
    private int zzg;
    private boolean zzh;
    private String zze = "";
    private String zzf = "";
    private String zzi = "";

    static {
        zznc zzncVar = new zznc();
        zzb = zzncVar;
        zzach.zzE(zznc.class, zzncVar);
    }

    private zznc() {
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zznc();
        }
        zzna zznaVar = null;
        if (i2 == 4) {
            return new zznb(zznaVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
