package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
public final class zza implements Runnable {
    public final /* synthetic */ LifecycleCallback zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzb zzc;

    public zza(zzb zzbVar, LifecycleCallback lifecycleCallback, String str) {
        this.zzc = zzbVar;
        this.zza = lifecycleCallback;
        this.zzb = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzb zzbVar = this.zzc;
        if (zzbVar.zzc > 0) {
            this.zza.onCreate(zzbVar.zzd != null ? zzbVar.zzd.getBundle(this.zzb) : null);
        }
        if (this.zzc.zzc >= 2) {
            this.zza.onStart();
        }
        if (this.zzc.zzc >= 3) {
            this.zza.onResume();
        }
        if (this.zzc.zzc >= 4) {
            this.zza.onStop();
        }
        if (this.zzc.zzc >= 5) {
            this.zza.onDestroy();
        }
    }
}
