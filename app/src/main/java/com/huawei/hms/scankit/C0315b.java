package com.huawei.hms.scankit;

import android.os.RemoteException;
import com.huawei.hms.scankit.p.C0338e;

/* compiled from: CaptureHelper.java */
/* renamed from: com.huawei.hms.scankit.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0315b implements C0338e.c {
    public final /* synthetic */ C0318e a;

    public C0315b(C0318e c0318e) {
        this.a = c0318e;
    }

    @Override // com.huawei.hms.scankit.p.C0338e.c
    public void a() {
    }

    @Override // com.huawei.hms.scankit.p.C0338e.c
    public void b() {
        if (this.a.G != null) {
            try {
                this.a.G.onError(-1000);
            } catch (RemoteException unused) {
                com.huawei.hms.scankit.util.a.b(C0318e.a, "RemoteException");
            }
        }
    }

    @Override // com.huawei.hms.scankit.p.C0338e.c
    public void onClosed() {
    }
}
