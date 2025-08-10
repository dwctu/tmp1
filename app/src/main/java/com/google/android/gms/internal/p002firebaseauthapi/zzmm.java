package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzmm extends zzach implements zzadn {
    private static final zzmm zzb;
    private int zze;
    private zzmp zzf;
    private zzabe zzg = zzabe.zzb;

    static {
        zzmm zzmmVar = new zzmm();
        zzb = zzmmVar;
        zzach.zzE(zzmm.class, zzmmVar);
    }

    private zzmm() {
    }

    public static zzml zzb() {
        return (zzml) zzb.zzt();
    }

    public static zzmm zzd(zzabe zzabeVar, zzabu zzabuVar) throws zzacp {
        return (zzmm) zzach.zzw(zzb, zzabeVar, zzabuVar);
    }

    public static /* synthetic */ void zzh(zzmm zzmmVar, zzmp zzmpVar) {
        zzmpVar.getClass();
        zzmmVar.zzf = zzmpVar;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzmp zze() {
        zzmp zzmpVar = this.zzf;
        return zzmpVar == null ? zzmp.zze() : zzmpVar;
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
            return new zzmm();
        }
        zzmk zzmkVar = null;
        if (i2 == 4) {
            return new zzml(zzmkVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final boolean zzk() {
        return this.zzf != null;
    }
}
