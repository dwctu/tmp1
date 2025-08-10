package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/* compiled from: com.google.android.play:core@@1.10.3 */
/* loaded from: classes2.dex */
public final class zzk extends ResultReceiver {
    public final /* synthetic */ com.google.android.play.core.tasks.zzi zza;
    public final /* synthetic */ zzl zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzk(zzl zzlVar, Handler handler, com.google.android.play.core.tasks.zzi zziVar) {
        super(handler);
        this.zzb = zzlVar;
        this.zza = zziVar;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 1) {
            this.zza.zze(-1);
            this.zzb.zzh.zzb(null);
        } else if (i != 2) {
            this.zza.zzd(new AssetPackException(-100));
        } else {
            this.zza.zze(0);
        }
    }
}
