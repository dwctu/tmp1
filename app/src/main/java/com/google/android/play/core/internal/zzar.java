package com.google.android.play.core.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* compiled from: com.google.android.play:core@@1.10.3 */
/* loaded from: classes2.dex */
public final class zzar implements ServiceConnection {
    public final /* synthetic */ zzas zza;

    public /* synthetic */ zzar(zzas zzasVar, zzaq zzaqVar) {
        this.zza = zzasVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.zza.zzc.zzd("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.zza.zzc().post(new zzao(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.zza.zzc.zzd("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.zza.zzc().post(new zzap(this));
    }
}
