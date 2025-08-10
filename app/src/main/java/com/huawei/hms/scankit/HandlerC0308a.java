package com.huawei.hms.scankit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.EnumC0312d;
import com.huawei.hms.scankit.p.C0338e;
import com.huawei.hms.scankit.p.Fb;
import java.util.Collection;
import java.util.Map;

/* compiled from: CaptureHandler.java */
/* renamed from: com.huawei.hms.scankit.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class HandlerC0308a extends Handler implements com.huawei.hms.scankit.aiscan.common.A {
    private final B a;
    private final m b;
    private final int c;
    private EnumC0052a d;
    private Context e;
    private final C0338e f;
    private final ViewfinderView g;
    private boolean h;
    private boolean i;
    private boolean j;
    private A k;
    private boolean l;

    /* compiled from: CaptureHandler.java */
    /* renamed from: com.huawei.hms.scankit.a$a, reason: collision with other inner class name */
    public enum EnumC0052a {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public HandlerC0308a(Context context, ViewfinderView viewfinderView, B b, Collection<BarcodeFormat> collection, Map<EnumC0312d, ?> map, String str, C0338e c0338e, Rect rect, int i, boolean z, boolean z2) {
        this.g = viewfinderView;
        this.a = b;
        this.c = i;
        this.e = context;
        m mVar = new m(context, c0338e, this, collection, map, str, this);
        this.b = mVar;
        mVar.a(rect);
        mVar.a(z2);
        mVar.start();
        this.l = z;
        c0338e.a(new C(mVar));
        this.d = EnumC0052a.SUCCESS;
        this.f = c0338e;
        c0338e.o();
        com.huawei.hms.scankit.util.a.a("scan-time", "start preview time:" + System.currentTimeMillis());
        f();
        Fb.c(null);
    }

    public void a(A a) {
        this.k = a;
    }

    public int b() {
        return this.c;
    }

    public void c(boolean z) {
        this.h = z;
    }

    public boolean d() {
        return this.j;
    }

    public void e() {
        this.d = EnumC0052a.DONE;
        this.f.p();
        Message.obtain(this.b.a(), R.id.scankit_quit).sendToTarget();
        try {
            this.b.b();
            this.b.join(50L);
        } catch (InterruptedException unused) {
            com.huawei.hms.scankit.util.a.d("CaptureHandler", "quitSynchronously   wait interrupt");
        }
        removeMessages(R.id.scankit_decode_succeeded);
        removeMessages(R.id.scankit_decode_failed);
    }

    public void f() {
        if (this.d == EnumC0052a.SUCCESS) {
            this.d = EnumC0052a.PREVIEW;
            this.f.n();
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        if (i == R.id.scankit_restart_preview) {
            f();
            return;
        }
        if (i != R.id.scankit_decode_succeeded) {
            if (i == R.id.scankit_decode_failed) {
                this.d = EnumC0052a.PREVIEW;
                this.f.n();
                return;
            }
            return;
        }
        this.d = EnumC0052a.SUCCESS;
        Object obj = message.obj;
        if (obj instanceof HmsScan[]) {
            HmsScan[] hmsScanArr = (HmsScan[]) obj;
            if (hmsScanArr.length <= 0 || hmsScanArr[0] == null || TextUtils.isEmpty(hmsScanArr[0].originalValue)) {
                com.huawei.hms.scankit.util.a.c("CaptureHandler", "retrieve  HmsScan lenth is 0");
            } else {
                com.huawei.hms.scankit.util.a.c("CaptureHandler", "scan successful");
                Bitmap bitmapDecodeByteArray = null;
                float f = 0.0f;
                if (this.i) {
                    com.huawei.hms.scankit.util.a.c("CaptureHandler", "scan successful & return bitmap");
                    Bundle data = message.getData();
                    if (data != null) {
                        byte[] byteArray = data.getByteArray("barcode_bitmap");
                        f = data.getFloat("barcode_scaled_factor", 0.0f);
                        if (byteArray != null && byteArray.length > 0) {
                            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                        }
                    }
                    this.a.a(hmsScanArr, bitmapDecodeByteArray, f);
                } else {
                    this.a.a(hmsScanArr, null, 0.0f);
                }
                if (!this.l) {
                    return;
                }
            }
            f();
        }
    }

    private com.huawei.hms.scankit.aiscan.common.z b(com.huawei.hms.scankit.aiscan.common.z zVar) {
        float fB;
        float fC;
        int iMax;
        Point pointA = com.huawei.hms.scankit.util.c.a(this.e);
        Point pointE = this.f.e();
        int i = pointA.x;
        int i2 = pointA.y;
        if (i < i2) {
            fB = (zVar.b() * ((i * 1.0f) / pointE.y)) - (Math.max(pointA.x, pointE.y) / 2.0f);
            fC = zVar.c() * ((i2 * 1.0f) / pointE.x);
            iMax = Math.min(pointA.y, pointE.x);
        } else {
            fB = (zVar.b() * ((i * 1.0f) / pointE.x)) - (Math.min(pointA.y, pointE.y) / 2.0f);
            fC = zVar.c() * ((i2 * 1.0f) / pointE.y);
            iMax = Math.max(pointA.x, pointE.x);
        }
        return new com.huawei.hms.scankit.aiscan.common.z(fB, fC - (iMax / 2.0f));
    }

    public boolean a() {
        A a = this.k;
        if (a != null) {
            return a.a();
        }
        return false;
    }

    public boolean c() {
        return this.i;
    }

    @Override // com.huawei.hms.scankit.aiscan.common.A
    public void a(com.huawei.hms.scankit.aiscan.common.z zVar) {
        if (this.g != null) {
            this.g.a(b(zVar));
        }
    }

    public void a(boolean z) {
        this.i = z;
    }

    public void b(boolean z) {
        this.j = z;
    }
}
