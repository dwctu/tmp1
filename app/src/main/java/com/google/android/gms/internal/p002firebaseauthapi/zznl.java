package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zznl extends zzach implements zzadn {
    private static final zznl zzb;
    private String zze = "";
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zznl zznlVar = new zznl();
        zzb = zznlVar;
        zzach.zzE(zznl.class, zznlVar);
    }

    private zznl() {
    }

    public static zznk zzb() {
        return (zznk) zzb.zzt();
    }

    public static /* synthetic */ void zzd(zznl zznlVar, String str) {
        str.getClass();
        zznlVar.zze = str;
    }

    public final int zza() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zznl();
        }
        zzni zzniVar = null;
        if (i2 == 4) {
            return new zznk(zzniVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
