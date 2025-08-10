package com.huawei.hms.hmsscankit;

import android.os.RemoteException;
import com.huawei.hms.hmsscankit.api.IOnLightCallback;

/* compiled from: OnLightVisibleCallBackDelegata.java */
/* loaded from: classes3.dex */
public class d extends IOnLightCallback.Stub {
    private final OnLightVisibleCallBack a;

    public d(OnLightVisibleCallBack onLightVisibleCallBack) {
        this.a = onLightVisibleCallBack;
    }

    @Override // com.huawei.hms.hmsscankit.api.IOnLightCallback
    public void onVisibleChanged(boolean z) throws RemoteException {
        this.a.onVisibleChanged(z);
    }
}
