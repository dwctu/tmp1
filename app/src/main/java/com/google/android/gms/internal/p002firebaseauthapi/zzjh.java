package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzjh extends zzach implements zzadn {
    private static final zzjh zzb;
    private zzjk zze;
    private int zzf;

    static {
        zzjh zzjhVar = new zzjh();
        zzb = zzjhVar;
        zzach.zzE(zzjh.class, zzjhVar);
    }

    private zzjh() {
    }

    public static zzjg zzb() {
        return (zzjg) zzb.zzt();
    }

    public static zzjh zzd() {
        return zzb;
    }

    public static zzjh zze(zzabe zzabeVar, zzabu zzabuVar) throws zzacp {
        return (zzjh) zzach.zzw(zzb, zzabeVar, zzabuVar);
    }

    public static /* synthetic */ void zzg(zzjh zzjhVar, zzjk zzjkVar) {
        zzjkVar.getClass();
        zzjhVar.zze = zzjkVar;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzjk zzf() {
        zzjk zzjkVar = this.zze;
        return zzjkVar == null ? zzjk.zzd() : zzjkVar;
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
            return new zzjh();
        }
        zzjf zzjfVar = null;
        if (i2 == 4) {
            return new zzjg(zzjfVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
