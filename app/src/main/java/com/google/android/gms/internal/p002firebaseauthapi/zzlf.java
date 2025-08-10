package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzlf extends zzach implements zzadn {
    private static final zzlf zzb;
    private int zze;
    private zzli zzf;
    private zzabe zzg = zzabe.zzb;

    static {
        zzlf zzlfVar = new zzlf();
        zzb = zzlfVar;
        zzach.zzE(zzlf.class, zzlfVar);
    }

    private zzlf() {
    }

    public static zzle zzb() {
        return (zzle) zzb.zzt();
    }

    public static zzlf zzd(zzabe zzabeVar, zzabu zzabuVar) throws zzacp {
        return (zzlf) zzach.zzw(zzb, zzabeVar, zzabuVar);
    }

    public static /* synthetic */ void zzh(zzlf zzlfVar, zzli zzliVar) {
        zzliVar.getClass();
        zzlfVar.zzf = zzliVar;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzli zze() {
        zzli zzliVar = this.zzf;
        return zzliVar == null ? zzli.zze() : zzliVar;
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
            return new zzlf();
        }
        zzld zzldVar = null;
        if (i2 == 4) {
            return new zzle(zzldVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
