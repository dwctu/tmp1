package com.huawei.hms.hmsscankit;

import android.os.RemoteException;
import com.huawei.hms.hmsscankit.api.IOnErrorCallback;

/* compiled from: OnErrorCallbackDelegate.java */
/* loaded from: classes3.dex */
public class c extends IOnErrorCallback.Stub {
    private final OnErrorCallback a;

    public c(OnErrorCallback onErrorCallback) {
        this.a = onErrorCallback;
    }

    @Override // com.huawei.hms.hmsscankit.api.IOnErrorCallback
    public void onError(int i) throws RemoteException {
        if (this.a != null) {
            String str = "onError: ErrorCode：" + i;
            this.a.onError(i);
        }
    }
}
