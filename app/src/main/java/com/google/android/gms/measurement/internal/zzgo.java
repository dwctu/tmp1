package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzgo implements Runnable {
    public final /* synthetic */ zzq zza;
    public final /* synthetic */ zzgq zzb;

    public zzgo(zzgq zzgqVar, zzq zzqVar) {
        this.zzb = zzgqVar;
        this.zza = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzA();
        this.zzb.zza.zzL(this.zza);
    }
}
