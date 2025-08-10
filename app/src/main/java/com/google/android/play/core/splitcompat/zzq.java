package com.google.android.play.core.splitcompat;

import java.util.Set;

/* compiled from: com.google.android.play:core@@1.10.3 */
/* loaded from: classes2.dex */
public final class zzq implements Runnable {
    public final /* synthetic */ Set zza;
    public final /* synthetic */ SplitCompat zzb;

    public zzq(SplitCompat splitCompat, Set set) {
        this.zzb = splitCompat;
        this.zza = set;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzb.zzg(this.zza);
        } catch (Exception unused) {
        }
    }
}
