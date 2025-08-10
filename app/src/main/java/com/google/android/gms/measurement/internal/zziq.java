package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* loaded from: classes2.dex */
public final class zziq implements Runnable {
    public final /* synthetic */ zzik zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ zzis zzc;

    public zziq(zzis zzisVar, zzik zzikVar, long j) {
        this.zzc = zzisVar;
        this.zza = zzikVar;
        this.zzb = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zzB(this.zza, false, this.zzb);
        zzis zzisVar = this.zzc;
        zzisVar.zza = null;
        zzisVar.zzs.zzt().zzG(null);
    }
}
