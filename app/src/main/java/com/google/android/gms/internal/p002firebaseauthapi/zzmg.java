package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzmg extends zzach implements zzadn {
    private static final zzmg zzb;
    private zzmj zze;

    static {
        zzmg zzmgVar = new zzmg();
        zzb = zzmgVar;
        zzach.zzE(zzmg.class, zzmgVar);
    }

    private zzmg() {
    }

    public static zzmf zza() {
        return (zzmf) zzb.zzt();
    }

    public static zzmg zzc(zzabe zzabeVar, zzabu zzabuVar) throws zzacp {
        return (zzmg) zzach.zzw(zzb, zzabeVar, zzabuVar);
    }

    public static /* synthetic */ void zze(zzmg zzmgVar, zzmj zzmjVar) {
        zzmjVar.getClass();
        zzmgVar.zze = zzmjVar;
    }

    public final zzmj zzd() {
        zzmj zzmjVar = this.zze;
        return zzmjVar == null ? zzmj.zzc() : zzmjVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zze"});
        }
        if (i2 == 3) {
            return new zzmg();
        }
        zzme zzmeVar = null;
        if (i2 == 4) {
            return new zzmf(zzmeVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
