package com.huawei.hms.scankit;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.TextureView;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.api.IOnErrorCallback;
import com.huawei.hms.hmsscankit.api.IOnResultCallback;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.EnumC0312d;
import com.huawei.hms.scankit.p.C0326b;
import com.huawei.hms.scankit.p.C0338e;
import com.huawei.hms.scankit.p.C0342f;
import com.huawei.hms.scankit.p.C0344fb;
import com.huawei.hms.scankit.p.C0346g;
import com.huawei.hms.scankit.p.C0356ib;
import io.agora.rtc2.Constants;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.bouncycastle.crypto.tls.CipherSuite;

/* compiled from: CaptureHelper.java */
/* renamed from: com.huawei.hms.scankit.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0318e implements InterfaceC0319f, InterfaceC0321h, InterfaceC0320g {
    public static final String a = "e";
    public static volatile C0356ib b;
    private IObjectWrapper A;
    private A B;
    private IOnResultCallback C;
    private boolean F;
    private IOnErrorCallback G;
    private final Rect d;
    private final int e;
    private final boolean f;
    private Context g;
    private HandlerC0308a h;
    private B i;
    private C0338e j;
    private ViewfinderView k;
    private TextureView l;
    private TextureView.SurfaceTextureListener m;
    private Collection<BarcodeFormat> n;
    private Map<EnumC0312d, ?> o;
    private String p;
    private String r;
    private float t;
    private boolean x;
    private boolean y;
    private boolean z;
    public volatile C0344fb c = null;
    private boolean s = true;
    private boolean u = true;
    private boolean v = false;
    private boolean w = true;
    private boolean D = false;
    private boolean E = false;
    private boolean H = true;
    private boolean q = false;

    public C0318e(Context context, TextureView textureView, ViewfinderView viewfinderView, Rect rect, int i, IObjectWrapper iObjectWrapper, boolean z, String str, boolean z2) {
        this.F = false;
        this.g = context;
        this.k = viewfinderView;
        this.A = iObjectWrapper;
        this.l = textureView;
        this.d = rect;
        this.e = i;
        this.f = z;
        this.r = str;
        this.F = false;
        this.y = z2;
    }

    private void i() {
        HandlerC0308a handlerC0308a = this.h;
        if (handlerC0308a != null) {
            handlerC0308a.e();
            this.h = null;
        }
        if (!this.q) {
            this.l.setSurfaceTextureListener(null);
        }
        this.j.k();
    }

    public void e() {
        TextureView textureView;
        TextureView textureView2;
        this.F = false;
        try {
            this.c = new C0344fb((Bundle) ObjectWrapper.unwrap(this.A), this.r);
            this.c.b();
        } catch (RuntimeException unused) {
            com.huawei.hms.scankit.util.a.b(a, "RuntimeException");
        } catch (Exception unused2) {
            com.huawei.hms.scankit.util.a.b(a, "Exception");
        }
        if (!this.D && !this.q && (textureView2 = this.l) != null) {
            textureView2.setSurfaceTextureListener(this.m);
            if (this.q) {
                a(this.l);
            } else {
                this.l.setSurfaceTextureListener(this.m);
            }
        }
        if (this.E && this.g.checkPermission("android.permission.CAMERA", Process.myPid(), Process.myUid()) == 0 && (textureView = this.l) != null) {
            this.E = false;
            a(textureView);
        }
    }

    public void f() {
        this.F = false;
        TextureView textureView = this.l;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(this.m);
            this.D = true;
            if (this.q) {
                a(this.l);
            } else {
                this.l.setSurfaceTextureListener(this.m);
            }
        }
    }

    public void g() {
        this.F = true;
        if (this.c != null) {
            this.c.c();
        }
        this.c = null;
        if (this.D) {
            i();
        }
    }

    public void h() {
        try {
            C0338e c0338e = this.j;
            if (c0338e != null) {
                c0338e.c(1);
            }
        } catch (RuntimeException unused) {
            com.huawei.hms.scankit.util.a.b(a, "RuntimeException in reset zoomValue");
        } catch (Exception unused2) {
            com.huawei.hms.scankit.util.a.b(a, "Exception in reset zoomValue");
        }
    }

    public void c() {
        this.F = true;
        this.j.j();
        b = null;
    }

    public void d() {
        this.F = true;
        if (this.D) {
            return;
        }
        i();
    }

    public void b() {
        this.F = false;
        try {
            b = new C0356ib((Bundle) ObjectWrapper.unwrap(this.A), this.r);
            b.a("single");
        } catch (RuntimeException unused) {
            com.huawei.hms.scankit.util.a.b(a, "RuntimeException");
        } catch (Exception unused2) {
            com.huawei.hms.scankit.util.a.b(a, "Exception");
        }
        if (this.g.getPackageManager() == null || this.g.getPackageManager().hasSystemFeature("android.hardware.camera")) {
            C0338e c0338e = new C0338e(this.g, a(this.g));
            this.j = c0338e;
            c0338e.a(new C0315b(this));
            this.m = new TextureViewSurfaceTextureListenerC0316c(this);
            this.i = new C0317d(this);
        }
    }

    public boolean a(MotionEvent motionEvent) {
        if (!this.s || this.j.f().a() < C0338e.b.CAMERA_OPENED.a() || motionEvent.getPointerCount() <= 1) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 2) {
            float fB = b(motionEvent);
            float f = this.t;
            if (fB > f + 6.0f) {
                a(true, this.j);
            } else if (fB < f - 6.0f) {
                a(false, this.j);
            } else {
                com.huawei.hms.scankit.util.a.c("CaptureHelper", "MotionEvent.ACTION_MOVE no handleZoom");
            }
            this.t = fB;
        } else if (action == 5) {
            this.t = b(motionEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextureView textureView) {
        if (textureView != null && textureView.getSurfaceTexture() != null) {
            try {
                this.j.a(textureView);
                this.j.a(Collections.singletonList(new C0342f.a(new Rect(-150, -150, CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA), 1000)));
                this.j.b(1);
                try {
                    this.j.m();
                } catch (Exception e) {
                    com.huawei.hms.scankit.util.a.b(a, "initCamera() get exception");
                    e.printStackTrace();
                }
                if (this.h == null) {
                    HandlerC0308a handlerC0308a = new HandlerC0308a(this.g, this.k, this.i, this.n, this.o, this.p, this.j, this.d, this.e, this.y, this.H);
                    this.h = handlerC0308a;
                    handlerC0308a.c(this.x);
                    this.h.a(this.z);
                    this.h.b(this.u);
                    this.h.a(this.B);
                    return;
                }
                return;
            } catch (Exception e2) {
                if (this.c != null) {
                    this.c.c(-1002);
                }
                com.huawei.hms.scankit.util.a.a(a, "initCamera IOException", e2);
                e2.printStackTrace();
                return;
            }
        }
        com.huawei.hms.scankit.util.a.d(a, "initCamera() no surface view");
    }

    private float b(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        double dSqrt = Math.sqrt((x * x) + (y * y));
        if (Double.isInfinite(dSqrt) || Double.isNaN(dSqrt)) {
            return 0.0f;
        }
        return BigDecimal.valueOf(dSqrt).floatValue();
    }

    public void b(boolean z) {
        this.H = z;
    }

    private void a(boolean z, C0338e c0338e) {
        try {
            C0346g c0346gG = c0338e.g();
            if (c0338e.i()) {
                int iC = c0346gG.c();
                int iB = c0346gG.b();
                if (z && iB < iC) {
                    iB++;
                } else if (iB > 0) {
                    iB--;
                } else {
                    com.huawei.hms.scankit.util.a.c(a, "handleZoom  zoom not change");
                }
                c0338e.c(iB);
                return;
            }
            com.huawei.hms.scankit.util.a.c(a, "zoom not supported");
        } catch (RuntimeException unused) {
        }
    }

    public void a(HmsScan[] hmsScanArr, Bitmap bitmap) {
        com.huawei.hms.scankit.util.a.a("scan-time", "decode time:" + System.currentTimeMillis());
        try {
            String str = a;
            com.huawei.hms.scankit.util.a.c(str, "result onResult");
            if (this.B.a()) {
                com.huawei.hms.scankit.util.a.c(str, "result intercepted");
                return;
            }
            if (this.c != null) {
                this.c.a(hmsScanArr);
            }
            if (!this.f) {
                hmsScanArr = com.huawei.hms.scankit.util.b.a(hmsScanArr);
            }
            if (this.B != null) {
                if (this.k != null && hmsScanArr.length > 0 && hmsScanArr[0] != null) {
                    com.huawei.hms.scankit.util.a.c(str, "result draw result point");
                    if (this.g instanceof Activity) {
                        this.k.a(hmsScanArr[0].getBorderRect(), com.huawei.hms.scankit.util.b.c((Activity) this.g), this.j.e());
                    }
                    this.F = false;
                }
                this.B.a(hmsScanArr);
            }
            if (this.C != null) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("result callback end: pauseStatus");
                    sb.append(this.F);
                    com.huawei.hms.scankit.util.a.c(str, sb.toString());
                    if (this.F) {
                        return;
                    }
                    if (this.z && hmsScanArr != null && hmsScanArr.length > 0 && hmsScanArr[0] != null) {
                        Context context = this.g;
                        if (context instanceof Activity) {
                            hmsScanArr[0].originalBitmap = com.huawei.hms.scankit.util.b.a(bitmap, ((Activity) context).getWindowManager().getDefaultDisplay().getRotation());
                        }
                    }
                    this.C.onResult(hmsScanArr);
                } catch (RemoteException e) {
                    if (this.c != null) {
                        this.c.c(-1003);
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onResult  RemoteException  e:");
                    sb2.append(e);
                    com.huawei.hms.scankit.util.a.d("CaptureHelper", sb2.toString());
                }
            }
        } catch (RuntimeException e2) {
            String str2 = "onResult:RuntimeException " + e2;
        } catch (Exception e3) {
            String str3 = "onResult:Exception: " + e3;
        }
    }

    public C0318e a(boolean z) {
        this.z = z;
        HandlerC0308a handlerC0308a = this.h;
        if (handlerC0308a != null) {
            handlerC0308a.a(z);
        }
        return this;
    }

    public C0318e a(A a2) {
        this.B = a2;
        return this;
    }

    public void a(IOnResultCallback iOnResultCallback) {
        this.C = iOnResultCallback;
    }

    public C0338e a() {
        return this.j;
    }

    public void a(IOnErrorCallback iOnErrorCallback) {
        this.G = iOnErrorCallback;
    }

    private C0326b a(Context context) {
        C0326b c0326bA;
        int rotation = ((Activity) context).getWindowManager().getDefaultDisplay().getRotation();
        String str = "initCameraConfig:true";
        if (rotation == 0) {
            c0326bA = new C0326b.a().a(new Point(1920, 1080)).a(1).b(90).b(true).a(true).a();
        } else if (rotation == 1) {
            c0326bA = new C0326b.a().a(new Point(1920, 1080)).a(1).b(0).b(true).a(true).a();
        } else if (rotation == 2) {
            c0326bA = new C0326b.a().a(new Point(1920, 1080)).a(1).b(Constants.VIDEO_ORIENTATION_270).b(true).a(true).a();
        } else if (rotation != 3) {
            c0326bA = new C0326b.a().a(new Point(1920, 1080)).a(1).b(90).b(true).a(true).a();
        } else {
            c0326bA = new C0326b.a().a(new Point(1920, 1080)).a(1).b(180).b(true).a(true).a();
        }
        return "ceres-c3".equals(Build.DEVICE) ? new C0326b.a().a(new Point(1080, 1920)).a(1).b(true).a(true).a() : c0326bA;
    }
}
