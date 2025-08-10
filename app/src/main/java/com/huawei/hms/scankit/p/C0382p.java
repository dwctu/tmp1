package com.huawei.hms.scankit.p;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import com.huawei.hms.scankit.p.C0338e;
import com.lovense.wear.R;

/* compiled from: PreviewCallbackProxy.java */
/* renamed from: com.huawei.hms.scankit.p.p, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0382p implements Camera.PreviewCallback {
    private C0338e.d a;
    private C0378o b;

    public C0382p(C0378o c0378o, C0338e.d dVar) {
        this.a = dVar;
        this.b = c0378o;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        Handler handler = this.b.b;
        if (handler == null) {
            this.a.a(bArr);
            return;
        }
        Message.obtain(handler, R.integer.cancel_button_image_alpha, "MLKitCamera").sendToTarget();
        this.a.a(bArr);
        Message.obtain(handler, R.integer.config_navAnimTime).sendToTarget();
    }
}
