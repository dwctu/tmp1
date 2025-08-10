package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
/* loaded from: classes2.dex */
public final class zzhw implements Runnable {
    public final /* synthetic */ Boolean zza;
    public final /* synthetic */ zzid zzb;

    public zzhw(zzid zzidVar, Boolean bool) {
        this.zzb = zzidVar;
        this.zza = bool;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.zzb.zzaa(this.zza, true);
    }
}
