package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzmu extends zzach implements zzadn {
    private static final zzmu zzb;
    private String zze = "";
    private zzabe zzf = zzabe.zzb;
    private int zzg;

    static {
        zzmu zzmuVar = new zzmu();
        zzb = zzmuVar;
        zzach.zzE(zzmu.class, zzmuVar);
    }

    private zzmu() {
    }

    public static zzmr zza() {
        return (zzmr) zzb.zzt();
    }

    public static zzmu zzd() {
        return zzb;
    }

    public final zzmt zzb() {
        zzmt zzmtVarZzb = zzmt.zzb(this.zzg);
        return zzmtVarZzb == null ? zzmt.UNRECOGNIZED : zzmtVarZzb;
    }

    public final zzabe zze() {
        return this.zzf;
    }

    public final String zzf() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzmu();
        }
        zzmq zzmqVar = null;
        if (i2 == 4) {
            return new zzmr(zzmqVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
