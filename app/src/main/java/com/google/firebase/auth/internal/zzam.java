package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.FirebaseApp;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzam {
    private static final Logger zzg = new Logger("TokenRefresher", "FirebaseAuth:");

    @VisibleForTesting
    public volatile long zza;

    @VisibleForTesting
    public volatile long zzb;

    @VisibleForTesting
    public final long zzc;

    @VisibleForTesting
    public final HandlerThread zzd;

    @VisibleForTesting
    public final Handler zze;

    @VisibleForTesting
    public final Runnable zzf;
    private final FirebaseApp zzh;

    public zzam(FirebaseApp firebaseApp) {
        zzg.v("Initializing TokenRefresher", new Object[0]);
        FirebaseApp firebaseApp2 = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        this.zzh = firebaseApp2;
        HandlerThread handlerThread = new HandlerThread("TokenRefresher", 10);
        this.zzd = handlerThread;
        handlerThread.start();
        this.zze = new com.google.android.gms.internal.p002firebaseauthapi.zzg(handlerThread.getLooper());
        this.zzf = new zzal(this, firebaseApp2.getName());
        this.zzc = 300000L;
    }

    public final void zzb() {
        this.zze.removeCallbacks(this.zzf);
    }

    public final void zzc() {
        zzg.v("Scheduling refresh for " + (this.zza - this.zzc), new Object[0]);
        zzb();
        this.zzb = Math.max((this.zza - DefaultClock.getInstance().currentTimeMillis()) - this.zzc, 0L) / 1000;
        this.zze.postDelayed(this.zzf, this.zzb * 1000);
    }

    public final void zzd() {
        long j;
        int i = (int) this.zzb;
        if (i == 30 || i == 60 || i == 120 || i == 240 || i == 480) {
            long j2 = this.zzb;
            j = j2 + j2;
        } else {
            j = i != 960 ? 30L : 960L;
        }
        this.zzb = j;
        this.zza = DefaultClock.getInstance().currentTimeMillis() + (this.zzb * 1000);
        zzg.v("Scheduling refresh for " + this.zza, new Object[0]);
        this.zze.postDelayed(this.zzf, this.zzb * 1000);
    }
}
