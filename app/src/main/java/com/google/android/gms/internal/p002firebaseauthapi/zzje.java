package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzje extends zzach implements zzadn {
    private static final zzje zzb;
    private int zze;
    private zzjk zzf;
    private zzabe zzg = zzabe.zzb;

    static {
        zzje zzjeVar = new zzje();
        zzb = zzjeVar;
        zzach.zzE(zzje.class, zzjeVar);
    }

    private zzje() {
    }

    public static zzjd zzb() {
        return (zzjd) zzb.zzt();
    }

    public static zzje zzd() {
        return zzb;
    }

    public static zzje zze(zzabe zzabeVar, zzabu zzabuVar) throws zzacp {
        return (zzje) zzach.zzw(zzb, zzabeVar, zzabuVar);
    }

    public static /* synthetic */ void zzi(zzje zzjeVar, zzjk zzjkVar) {
        zzjkVar.getClass();
        zzjeVar.zzf = zzjkVar;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzjk zzf() {
        zzjk zzjkVar = this.zzf;
        return zzjkVar == null ? zzjk.zzd() : zzjkVar;
    }

    public final zzabe zzg() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzje();
        }
        zzjc zzjcVar = null;
        if (i2 == 4) {
            return new zzjd(zzjcVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
