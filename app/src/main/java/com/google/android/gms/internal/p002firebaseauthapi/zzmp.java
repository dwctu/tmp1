package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzmp extends zzach implements zzadn {
    private static final zzmp zzb;
    private int zze;
    private zzmj zzf;
    private zzabe zzg = zzabe.zzb;

    static {
        zzmp zzmpVar = new zzmp();
        zzb = zzmpVar;
        zzach.zzE(zzmp.class, zzmpVar);
    }

    private zzmp() {
    }

    public static zzmo zzc() {
        return (zzmo) zzb.zzt();
    }

    public static zzmp zze() {
        return zzb;
    }

    public static zzmp zzf(zzabe zzabeVar, zzabu zzabuVar) throws zzacp {
        return (zzmp) zzach.zzw(zzb, zzabeVar, zzabuVar);
    }

    public static /* synthetic */ void zzi(zzmp zzmpVar, zzmj zzmjVar) {
        zzmjVar.getClass();
        zzmpVar.zzf = zzmjVar;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzmj zzb() {
        zzmj zzmjVar = this.zzf;
        return zzmjVar == null ? zzmj.zzc() : zzmjVar;
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
            return new zzmp();
        }
        zzmn zzmnVar = null;
        if (i2 == 4) {
            return new zzmo(zzmnVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final boolean zzl() {
        return this.zzf != null;
    }
}
