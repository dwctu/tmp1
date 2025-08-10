package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzkw extends zzach implements zzadn {
    private static final zzkw zzb;
    private zzmz zze;

    static {
        zzkw zzkwVar = new zzkw();
        zzb = zzkwVar;
        zzach.zzE(zzkw.class, zzkwVar);
    }

    private zzkw() {
    }

    public static zzkv zza() {
        return (zzkv) zzb.zzt();
    }

    public static zzkw zzc() {
        return zzb;
    }

    public static /* synthetic */ void zze(zzkw zzkwVar, zzmz zzmzVar) {
        zzmzVar.getClass();
        zzkwVar.zze = zzmzVar;
    }

    public final zzmz zzd() {
        zzmz zzmzVar = this.zze;
        return zzmzVar == null ? zzmz.zzc() : zzmzVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"zze"});
        }
        if (i2 == 3) {
            return new zzkw();
        }
        zzku zzkuVar = null;
        if (i2 == 4) {
            return new zzkv(zzkuVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
