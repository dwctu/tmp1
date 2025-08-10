package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzhz implements Runnable {
    public final /* synthetic */ boolean zza;
    public final /* synthetic */ zzid zzb;

    public zzhz(zzid zzidVar, boolean z) {
        this.zzb = zzidVar;
        this.zza = z;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        boolean zZzJ = this.zzb.zzs.zzJ();
        boolean zZzI = this.zzb.zzs.zzI();
        this.zzb.zzs.zzF(this.zza);
        if (zZzI == this.zza) {
            this.zzb.zzs.zzay().zzj().zzb("Default data collection state already set to", Boolean.valueOf(this.zza));
        }
        if (this.zzb.zzs.zzJ() == zZzJ || this.zzb.zzs.zzJ() != this.zzb.zzs.zzI()) {
            this.zzb.zzs.zzay().zzl().zzc("Default data collection is different than actual status", Boolean.valueOf(this.zza), Boolean.valueOf(zZzJ));
        }
        this.zzb.zzab();
    }
}
