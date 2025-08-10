package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzjn implements Runnable {
    public final /* synthetic */ ComponentName zza;
    public final /* synthetic */ zzjr zzb;

    public zzjn(zzjr zzjrVar, ComponentName componentName) {
        this.zzb = zzjrVar;
        this.zza = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjs.zzo(this.zzb.zza, this.zza);
    }
}
