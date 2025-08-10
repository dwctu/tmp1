package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzlc extends zzach implements zzadn {
    private static final zzlc zzb;
    private zzll zze;
    private zzkw zzf;
    private int zzg;

    static {
        zzlc zzlcVar = new zzlc();
        zzb = zzlcVar;
        zzach.zzE(zzlc.class, zzlcVar);
    }

    private zzlc() {
    }

    public static zzlb zzb() {
        return (zzlb) zzb.zzt();
    }

    public static zzlc zzd() {
        return zzb;
    }

    public static /* synthetic */ void zzf(zzlc zzlcVar, zzll zzllVar) {
        zzllVar.getClass();
        zzlcVar.zze = zzllVar;
    }

    public static /* synthetic */ void zzg(zzlc zzlcVar, zzkw zzkwVar) {
        zzkwVar.getClass();
        zzlcVar.zzf = zzkwVar;
    }

    public final zzkw zza() {
        zzkw zzkwVar = this.zzf;
        return zzkwVar == null ? zzkw.zzc() : zzkwVar;
    }

    public final zzll zze() {
        zzll zzllVar = this.zze;
        return zzllVar == null ? zzll.zzc() : zzllVar;
    }

    public final int zzh() {
        int i = this.zzg;
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

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzlc();
        }
        zzla zzlaVar = null;
        if (i2 == 4) {
            return new zzlb(zzlaVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
