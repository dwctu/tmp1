package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzlv extends zzach implements zzadn {
    private static final zzlv zzb;
    private int zze;
    private zzmb zzf;
    private zzabe zzg = zzabe.zzb;

    static {
        zzlv zzlvVar = new zzlv();
        zzb = zzlvVar;
        zzach.zzE(zzlv.class, zzlvVar);
    }

    private zzlv() {
    }

    public static zzlu zzb() {
        return (zzlu) zzb.zzt();
    }

    public static zzlv zzd() {
        return zzb;
    }

    public static zzlv zze(zzabe zzabeVar, zzabu zzabuVar) throws zzacp {
        return (zzlv) zzach.zzw(zzb, zzabeVar, zzabuVar);
    }

    public static /* synthetic */ void zzi(zzlv zzlvVar, zzmb zzmbVar) {
        zzmbVar.getClass();
        zzlvVar.zzf = zzmbVar;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzmb zzf() {
        zzmb zzmbVar = this.zzf;
        return zzmbVar == null ? zzmb.zzd() : zzmbVar;
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
            return new zzlv();
        }
        zzlt zzltVar = null;
        if (i2 == 4) {
            return new zzlu(zzltVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
