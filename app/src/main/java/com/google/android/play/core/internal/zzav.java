package com.google.android.play.core.internal;

import java.util.List;

/* compiled from: com.google.android.play:core@@1.10.3 */
/* loaded from: classes2.dex */
public final class zzav implements Runnable {
    public final /* synthetic */ List zza;
    public final /* synthetic */ com.google.android.play.core.splitinstall.zzf zzb;
    public final /* synthetic */ zzaw zzc;

    public zzav(zzaw zzawVar, List list, com.google.android.play.core.splitinstall.zzf zzfVar) {
        this.zzc = zzawVar;
        this.zza = list;
        this.zzb = zzfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.zzc.zzc.zzb(this.zza)) {
                zzaw.zzc(this.zzc, this.zzb);
            } else {
                zzaw.zzb(this.zzc, this.zza, this.zzb);
            }
        } catch (Exception unused) {
            this.zzb.zzb(-11);
        }
    }
}
