package com.google.firebase.auth.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;

/* compiled from: com.google.firebase:firebase-auth@@21.0.8 */
/* loaded from: classes2.dex */
public final class zzbh implements BackgroundDetector.BackgroundStateChangeListener {
    public final /* synthetic */ zzbi zza;

    public zzbh(zzbi zzbiVar) {
        this.zza = zzbiVar;
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void onBackgroundStateChanged(boolean z) {
        if (z) {
            this.zza.zzc = true;
            this.zza.zzc();
        } else {
            this.zza.zzc = false;
            if (this.zza.zzg()) {
                this.zza.zzb.zzc();
            }
        }
    }
}
