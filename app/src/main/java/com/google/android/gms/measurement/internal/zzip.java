package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzip implements Runnable {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzis zzb;

    public zzip(zzis zzisVar, long j) {
        this.zzb = zzisVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzs.zzd().zzf(this.zza);
        this.zzb.zza = null;
    }
}
