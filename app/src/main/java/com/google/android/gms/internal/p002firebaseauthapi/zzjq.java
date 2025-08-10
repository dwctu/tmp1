package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzjq extends zzach implements zzadn {
    private static final zzjq zzb;
    private zzjt zze;
    private int zzf;

    static {
        zzjq zzjqVar = new zzjq();
        zzb = zzjqVar;
        zzach.zzE(zzjq.class, zzjqVar);
    }

    private zzjq() {
    }

    public static zzjp zzb() {
        return (zzjp) zzb.zzt();
    }

    public static zzjq zzd(zzabe zzabeVar, zzabu zzabuVar) throws zzacp {
        return (zzjq) zzach.zzw(zzb, zzabeVar, zzabuVar);
    }

    public static /* synthetic */ void zzf(zzjq zzjqVar, zzjt zzjtVar) {
        zzjtVar.getClass();
        zzjqVar.zze = zzjtVar;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzjt zze() {
        zzjt zzjtVar = this.zze;
        return zzjtVar == null ? zzjt.zzd() : zzjtVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzjq();
        }
        zzjo zzjoVar = null;
        if (i2 == 4) {
            return new zzjp(zzjoVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
