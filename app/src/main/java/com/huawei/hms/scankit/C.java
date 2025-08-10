package com.huawei.hms.scankit;

import com.huawei.hms.scankit.p.C0338e;

/* compiled from: PreviewCallback.java */
/* loaded from: classes3.dex */
public class C implements C0338e.d {
    private m a;

    public C(m mVar) {
        this.a = mVar;
    }

    @Override // com.huawei.hms.scankit.p.C0338e.d
    public void a(byte[] bArr) {
        com.huawei.hms.scankit.util.a.a("scan-time", "request frame time:" + System.currentTimeMillis());
        this.a.a().obtainMessage(R.id.scankit_decode, bArr).sendToTarget();
    }
}
