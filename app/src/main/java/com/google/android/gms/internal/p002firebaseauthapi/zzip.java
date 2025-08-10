package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzip extends zzach implements zzadn {
    private static final zzip zzb;
    private int zze;
    private zzabe zzf = zzabe.zzb;
    private zziv zzg;

    static {
        zzip zzipVar = new zzip();
        zzb = zzipVar;
        zzach.zzE(zzip.class, zzipVar);
    }

    private zzip() {
    }

    public static zzio zzb() {
        return (zzio) zzb.zzt();
    }

    public static zzip zzd(zzabe zzabeVar, zzabu zzabuVar) throws zzacp {
        return (zzip) zzach.zzw(zzb, zzabeVar, zzabuVar);
    }

    public static /* synthetic */ void zzi(zzip zzipVar, zziv zzivVar) {
        zzivVar.getClass();
        zzipVar.zzg = zzivVar;
    }

    public final int zza() {
        return this.zze;
    }

    public final zziv zze() {
        zziv zzivVar = this.zzg;
        return zzivVar == null ? zziv.zzd() : zzivVar;
    }

    public final zzabe zzf() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzip();
        }
        zzin zzinVar = null;
        if (i2 == 4) {
            return new zzio(zzinVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
