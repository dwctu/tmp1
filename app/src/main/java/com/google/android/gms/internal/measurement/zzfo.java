package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzfo extends zzke implements zzlm {
    private static final zzfo zza;
    private int zze;
    private int zzf;
    private zzgh zzg;
    private zzgh zzh;
    private boolean zzi;

    static {
        zzfo zzfoVar = new zzfo();
        zza = zzfoVar;
        zzke.zzbJ(zzfo.class, zzfoVar);
    }

    private zzfo() {
    }

    public static zzfn zzb() {
        return (zzfn) zza.zzbx();
    }

    public static /* synthetic */ void zzf(zzfo zzfoVar, int i) {
        zzfoVar.zze |= 1;
        zzfoVar.zzf = i;
    }

    public static /* synthetic */ void zzg(zzfo zzfoVar, zzgh zzghVar) {
        zzghVar.getClass();
        zzfoVar.zzg = zzghVar;
        zzfoVar.zze |= 2;
    }

    public static /* synthetic */ void zzh(zzfo zzfoVar, zzgh zzghVar) {
        zzfoVar.zzh = zzghVar;
        zzfoVar.zze |= 4;
    }

    public static /* synthetic */ void zzi(zzfo zzfoVar, boolean z) {
        zzfoVar.zze |= 8;
        zzfoVar.zzi = z;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzgh zzd() {
        zzgh zzghVar = this.zzg;
        return zzghVar == null ? zzgh.zzh() : zzghVar;
    }

    public final zzgh zze() {
        zzgh zzghVar = this.zzh;
        return zzghVar == null ? zzgh.zzh() : zzghVar;
    }

    public final boolean zzj() {
        return this.zzi;
    }

    public final boolean zzk() {
        return (this.zze & 1) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzke
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzke.zzbI(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzfo();
        }
        zzfj zzfjVar = null;
        if (i2 == 4) {
            return new zzfn(zzfjVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final boolean zzm() {
        return (this.zze & 8) != 0;
    }

    public final boolean zzn() {
        return (this.zze & 4) != 0;
    }
}
