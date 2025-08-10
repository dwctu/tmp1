package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzns extends zzach implements zzadn {
    private static final zzns zzb;
    private String zze = "";

    static {
        zzns zznsVar = new zzns();
        zzb = zznsVar;
        zzach.zzE(zzns.class, zznsVar);
    }

    private zzns() {
    }

    public static zzns zzb() {
        return zzb;
    }

    public static zzns zzc(zzabe zzabeVar, zzabu zzabuVar) throws zzacp {
        return (zzns) zzach.zzw(zzb, zzabeVar, zzabuVar);
    }

    public final String zzd() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zze"});
        }
        if (i2 == 3) {
            return new zzns();
        }
        zznq zznqVar = null;
        if (i2 == 4) {
            return new zznr(zznqVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
