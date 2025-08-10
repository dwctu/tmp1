package com.huawei.hms.scankit;

import android.os.RemoteException;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate;
import com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate;

/* loaded from: classes3.dex */
public class Creator extends IRemoteCreator.Stub {
    private static final String TAG = "Creator";
    private q iRemoteViewDelegate = null;
    private BinderC0424r iRemoteDecoderDelegate = null;
    private t iRemoteHmsDecoderDelegate = null;

    @Override // com.huawei.hms.hmsscankit.api.IRemoteCreator
    public IRemoteDecoderDelegate newRemoteDecoderDelegate() throws RemoteException {
        com.huawei.hms.scankit.util.a.c(TAG, "newRemoteDecoderDelegate()");
        BinderC0424r binderC0424rA = BinderC0424r.a();
        this.iRemoteDecoderDelegate = binderC0424rA;
        return binderC0424rA;
    }

    @Override // com.huawei.hms.hmsscankit.api.IRemoteCreator
    public IRemoteHmsDecoderDelegate newRemoteHmsDecoderDelegate() throws RemoteException {
        com.huawei.hms.scankit.util.a.c(TAG, "newRemoteHmsDecoderDelegate()");
        t tVarA = t.a();
        this.iRemoteHmsDecoderDelegate = tVarA;
        return tVarA;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a6  */
    @Override // com.huawei.hms.hmsscankit.api.IRemoteCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.hmsscankit.api.IRemoteViewDelegate newRemoteViewDelegate(com.huawei.hms.feature.dynamic.IObjectWrapper r13, com.huawei.hms.feature.dynamic.IObjectWrapper r14) throws android.os.RemoteException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.Creator.newRemoteViewDelegate(com.huawei.hms.feature.dynamic.IObjectWrapper, com.huawei.hms.feature.dynamic.IObjectWrapper):com.huawei.hms.hmsscankit.api.IRemoteViewDelegate");
    }
}
