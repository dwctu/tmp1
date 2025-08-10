package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzgh implements Runnable {
    public final /* synthetic */ zzq zza;
    public final /* synthetic */ zzgq zzb;

    public zzgh(zzgq zzgqVar, zzq zzqVar) {
        this.zzb = zzgqVar;
        this.zza = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzA();
        zzkz zzkzVar = this.zzb.zza;
        zzq zzqVar = this.zza;
        zzkzVar.zzaz().zzg();
        zzkzVar.zzB();
        Preconditions.checkNotEmpty(zzqVar.zza);
        zzkzVar.zzd(zzqVar);
    }
}
