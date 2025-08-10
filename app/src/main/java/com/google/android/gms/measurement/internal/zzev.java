package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzev implements Runnable {
    public final /* synthetic */ boolean zza;
    public final /* synthetic */ zzew zzb;

    public zzev(zzew zzewVar, boolean z) {
        this.zzb = zzewVar;
        this.zza = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb.zzJ(this.zza);
    }
}
