package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzis extends zzach implements zzadn {
    private static final zzis zzb;
    private int zze;
    private zziv zzf;

    static {
        zzis zzisVar = new zzis();
        zzb = zzisVar;
        zzach.zzE(zzis.class, zzisVar);
    }

    private zzis() {
    }

    public static zzir zzb() {
        return (zzir) zzb.zzt();
    }

    public static zzis zzd(zzabe zzabeVar, zzabu zzabuVar) throws zzacp {
        return (zzis) zzach.zzw(zzb, zzabeVar, zzabuVar);
    }

    public static /* synthetic */ void zzg(zzis zzisVar, zziv zzivVar) {
        zzivVar.getClass();
        zzisVar.zzf = zzivVar;
    }

    public final int zza() {
        return this.zze;
    }

    public final zziv zze() {
        zziv zzivVar = this.zzf;
        return zzivVar == null ? zziv.zzd() : zzivVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzis();
        }
        zziq zziqVar = null;
        if (i2 == 4) {
            return new zzir(zziqVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
