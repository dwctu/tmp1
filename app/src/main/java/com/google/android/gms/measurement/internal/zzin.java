package com.google.android.gms.measurement.internal;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzin implements Runnable {
    public final /* synthetic */ zzik zza;
    public final /* synthetic */ zzik zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ zzis zze;

    public zzin(zzis zzisVar, zzik zzikVar, zzik zzikVar2, long j, boolean z) {
        this.zze = zzisVar;
        this.zza = zzikVar;
        this.zzb = zzikVar2;
        this.zzc = j;
        this.zzd = z;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.zze.zzA(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
