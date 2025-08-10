package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzjn extends zzach implements zzadn {
    private static final zzjn zzb;
    private int zze;
    private zzjt zzf;
    private zzabe zzg = zzabe.zzb;

    static {
        zzjn zzjnVar = new zzjn();
        zzb = zzjnVar;
        zzach.zzE(zzjn.class, zzjnVar);
    }

    private zzjn() {
    }

    public static zzjm zzb() {
        return (zzjm) zzb.zzt();
    }

    public static zzjn zzd(zzabe zzabeVar, zzabu zzabuVar) throws zzacp {
        return (zzjn) zzach.zzw(zzb, zzabeVar, zzabuVar);
    }

    public static /* synthetic */ void zzh(zzjn zzjnVar, zzjt zzjtVar) {
        zzjtVar.getClass();
        zzjnVar.zzf = zzjtVar;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzjt zze() {
        zzjt zzjtVar = this.zzf;
        return zzjtVar == null ? zzjt.zzd() : zzjtVar;
    }

    public final zzabe zzf() {
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
            return new zzjn();
        }
        zzjl zzjlVar = null;
        if (i2 == 4) {
            return new zzjm(zzjlVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
