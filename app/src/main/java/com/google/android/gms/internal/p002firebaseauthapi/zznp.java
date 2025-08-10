package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zznp extends zzach implements zzadn {
    private static final zznp zzb;
    private int zze;
    private zzns zzf;

    static {
        zznp zznpVar = new zznp();
        zzb = zznpVar;
        zzach.zzE(zznp.class, zznpVar);
    }

    private zznp() {
    }

    public static zzno zzb() {
        return (zzno) zzb.zzt();
    }

    public static zznp zzd(zzabe zzabeVar, zzabu zzabuVar) throws zzacp {
        return (zznp) zzach.zzw(zzb, zzabeVar, zzabuVar);
    }

    public static /* synthetic */ void zzg(zznp zznpVar, zzns zznsVar) {
        zznsVar.getClass();
        zznpVar.zzf = zznsVar;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzns zze() {
        zzns zznsVar = this.zzf;
        return zznsVar == null ? zzns.zzb() : zznsVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzach
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzach.zzD(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zze", "zzf"});
        }
        if (i2 == 3) {
            return new zznp();
        }
        zznn zznnVar = null;
        if (i2 == 4) {
            return new zzno(zznnVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
