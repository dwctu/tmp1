package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzio implements Runnable {
    public final /* synthetic */ zzis zza;

    public zzio(zzis zzisVar) {
        this.zza = zzisVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzis zzisVar = this.zza;
        zzisVar.zza = zzisVar.zzh;
    }
}
