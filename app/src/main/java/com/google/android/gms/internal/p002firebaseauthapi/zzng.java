package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzng extends zzach implements zzadn {
    private static final zzng zzb;
    private zzmu zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zzng zzngVar = new zzng();
        zzb = zzngVar;
        zzach.zzE(zzng.class, zzngVar);
    }

    private zzng() {
    }

    public static zznf zzc() {
        return (zznf) zzb.zzt();
    }

    public static /* synthetic */ void zzf(zzng zzngVar, zzmu zzmuVar) {
        zzmuVar.getClass();
        zzngVar.zze = zzmuVar;
    }

    public final int zza() {
        return this.zzg;
    }

    public final zzmu zzb() {
        zzmu zzmuVar = this.zze;
        return zzmuVar == null ? zzmu.zzd() : zzmuVar;
    }

    public final zzoa zze() {
        zzoa zzoaVarZzb = zzoa.zzb(this.zzh);
        return zzoaVarZzb == null ? zzoa.UNRECOGNIZED : zzoaVarZzb;
    }

    public final boolean zzi() {
        return this.zze != null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzng();
        }
        zznd zzndVar = null;
        if (i2 == 4) {
            return new zznf(zzndVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final int zzk() {
        int i = this.zzf;
        int i2 = 3;
        if (i == 0) {
            i2 = 2;
        } else if (i != 1) {
            i2 = i != 2 ? i != 3 ? 0 : 5 : 4;
        }
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }
}
