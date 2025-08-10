package com.huawei.hms.hmsscankit;

import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.hmsscankit.api.IOnResultCallback;
import com.huawei.hms.ml.scan.HmsScan;

/* compiled from: OnResultCallbackDelegate.java */
/* loaded from: classes3.dex */
public class e extends IOnResultCallback.Stub {
    private final OnResultCallback a;
    private String b;
    private boolean c;

    public e(OnResultCallback onResultCallback, boolean z) {
        this.c = true;
        this.a = onResultCallback;
        this.c = z;
    }

    @Override // com.huawei.hms.hmsscankit.api.IOnResultCallback
    public void onResult(HmsScan[] hmsScanArr) throws RemoteException {
        com.huawei.hms.scankit.util.a.c("OnResultCallbackDelegat", "result callback sdk continueScan" + this.c);
        if (this.c) {
            this.a.onResult(hmsScanArr);
            return;
        }
        if (hmsScanArr == null || hmsScanArr.length <= 0 || hmsScanArr[0] == null || TextUtils.equals(this.b, hmsScanArr[0].getOriginalValue())) {
            return;
        }
        this.b = hmsScanArr[0].getOriginalValue();
        com.huawei.hms.scankit.util.a.c("OnResultCallbackDelegat", "result callback sdk continueScan" + this.c);
        this.a.onResult(hmsScanArr);
    }
}
