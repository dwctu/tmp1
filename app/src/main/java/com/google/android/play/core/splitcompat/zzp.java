package com.google.android.play.core.splitcompat;

/* compiled from: com.google.android.play:core@@1.10.3 */
/* loaded from: classes2.dex */
public final class zzp implements Runnable {
    public final /* synthetic */ SplitCompat zza;

    public zzp(SplitCompat splitCompat) {
        this.zza = splitCompat;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zza.zzc.zzk();
        } catch (Exception unused) {
        }
    }
}
