package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.exoplayer2.ExoPlayer;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzke {
    public final /* synthetic */ zzki zza;
    private zzkd zzb;

    public zzke(zzki zzkiVar) {
        this.zza = zzkiVar;
    }

    @WorkerThread
    public final void zza(long j) {
        this.zzb = new zzkd(this, this.zza.zzs.zzav().currentTimeMillis(), j);
        this.zza.zzd.postDelayed(this.zzb, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    @WorkerThread
    public final void zzb() {
        this.zza.zzg();
        zzkd zzkdVar = this.zzb;
        if (zzkdVar != null) {
            this.zza.zzd.removeCallbacks(zzkdVar);
        }
        this.zza.zzs.zzm().zzl.zza(false);
    }
}
