package com.google.android.play.core.review;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.zzag;

/* compiled from: com.google.android.play:core@@1.10.3 */
/* loaded from: classes2.dex */
public final class zzh extends zzg {
    public final String zzd;

    public zzh(zzi zziVar, com.google.android.play.core.tasks.zzi zziVar2, String str) {
        super(zziVar, new zzag("OnRequestInstallCallback"), zziVar2);
        this.zzd = str;
    }

    @Override // com.google.android.play.core.review.zzg, com.google.android.play.core.internal.zzae
    public final void zzb(Bundle bundle) throws RemoteException {
        super.zzb(bundle);
        this.zzb.zze(new zza((PendingIntent) bundle.get("confirmation_intent"), bundle.getBoolean("is_review_no_op")));
    }
}
