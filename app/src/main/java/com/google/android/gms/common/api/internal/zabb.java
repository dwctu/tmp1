package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes2.dex */
public final class zabb implements ResultCallback<Status> {
    public final /* synthetic */ StatusPendingResult zaa;
    public final /* synthetic */ boolean zab;
    public final /* synthetic */ GoogleApiClient zac;
    public final /* synthetic */ zabe zad;

    public zabb(zabe zabeVar, StatusPendingResult statusPendingResult, boolean z, GoogleApiClient googleApiClient) {
        this.zad = zabeVar;
        this.zaa = statusPendingResult;
        this.zab = z;
        this.zac = googleApiClient;
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final /* bridge */ /* synthetic */ void onResult(@NonNull Result result) {
        Status status = (Status) result;
        Storage.getInstance(this.zad.zan).zac();
        if (status.isSuccess() && this.zad.isConnected()) {
            zabe zabeVar = this.zad;
            zabeVar.disconnect();
            zabeVar.connect();
        }
        this.zaa.setResult(status);
        if (this.zab) {
            this.zac.disconnect();
        }
    }
}
