package com.huawei.hms.scankit.p;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.view.TextureView;
import com.huawei.hms.mlkit.common.ha.HianalyticsLogProvider;
import com.huawei.hms.scankit.p.C0342f;
import com.lovense.wear.R;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: CameraManager.java */
/* renamed from: com.huawei.hms.scankit.p.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0338e {
    private final boolean a;
    private C0326b b;
    private c c;
    private a d;
    private Camera.PreviewCallback e;
    private WeakReference<Context> f;
    private C0366l g;
    private C0362k h;
    private C0374n i;
    private C0370m j;
    private Camera k;
    private C0358j l;
    private C0378o m;
    private String n;
    private b o = b.CAMERA_CLOSED;
    private boolean p = false;
    private int q = -1;

    /* compiled from: CameraManager.java */
    /* renamed from: com.huawei.hms.scankit.p.e$a */
    public interface a {
        void a(Point point);
    }

    /* compiled from: CameraManager.java */
    /* renamed from: com.huawei.hms.scankit.p.e$b */
    public enum b {
        CAMERA_CLOSED(1),
        CAMERA_OPENED(2),
        CAMERA_INITIALED(3),
        PREVIEW_STARTED(4),
        PREVIEW_STOPPED(5);

        private final int g;

        b(int i) {
            this.g = i;
        }

        public final int a() {
            return this.g;
        }
    }

    /* compiled from: CameraManager.java */
    /* renamed from: com.huawei.hms.scankit.p.e$c */
    public interface c {
        void a();

        void b();

        void onClosed();
    }

    /* compiled from: CameraManager.java */
    /* renamed from: com.huawei.hms.scankit.p.e$d */
    public interface d {
        void a(byte[] bArr);
    }

    /* compiled from: CameraManager.java */
    /* renamed from: com.huawei.hms.scankit.p.e$e, reason: collision with other inner class name */
    public static class C0053e implements Camera.PreviewCallback {
        private C0053e() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
        }
    }

    public C0338e(Context context, C0326b c0326b) {
        if (context == null || c0326b == null) {
            throw new IllegalArgumentException("CameraManager constructor param invalid");
        }
        this.f = new WeakReference<>(context);
        this.b = c0326b;
        this.n = c0326b.f();
        this.l = new C0358j();
        this.h = new C0362k();
        this.i = new C0374n();
        this.j = new C0370m();
        this.m = new C0378o(context);
        this.a = c0326b.g();
        r();
    }

    private void q() {
        if (this.a || HianalyticsLogProvider.getInstance().sdkForbiddenHiLog(this.f.get())) {
            return;
        }
        HianalyticsLogProvider.getInstance().reportAndCancelTimer("MLKitCamera");
        if (this.p) {
            Handler handler = this.m.b;
            if (handler != null) {
                Message.obtain(handler, R.integer.animation_default_duration).sendToTarget();
            }
            this.p = false;
        }
    }

    private void r() {
        if (this.a || HianalyticsLogProvider.getInstance().sdkForbiddenHiLog(this.f.get())) {
            return;
        }
        HianalyticsLogProvider.getInstance().initTimer("MLKitCamera");
        if (this.p) {
            return;
        }
        this.m.start();
        this.p = true;
    }

    public synchronized void a(d dVar) {
        if (dVar == null) {
            throw new IllegalArgumentException("CameraManager::setFrameCallback param invalid");
        }
        this.e = new C0382p(this.m, dVar);
    }

    public synchronized C0330c b() {
        if (this.k != null && this.o.a() != b.CAMERA_CLOSED.a()) {
            return this.h.a();
        }
        return null;
    }

    public synchronized void c(int i) {
        if (this.k != null && this.o.a() != b.CAMERA_CLOSED.a()) {
            this.i.a(i);
        }
    }

    public synchronized int d() {
        return this.b.d();
    }

    public synchronized Point e() {
        return this.l.b;
    }

    public synchronized b f() {
        return this.o;
    }

    public synchronized C0346g g() {
        if (this.k != null && this.o.a() != b.CAMERA_CLOSED.a()) {
            return this.i.a();
        }
        return null;
    }

    public synchronized String h() {
        return this.n;
    }

    public synchronized boolean i() {
        return this.i.b();
    }

    public synchronized void j() {
        q();
        this.d = null;
    }

    public synchronized void k() {
        try {
            if (this.o.a() == b.PREVIEW_STARTED.a()) {
                a();
                p();
                this.o = b.PREVIEW_STOPPED;
            }
            if (h().equals("torch")) {
                a("off");
            }
            if (this.o.a() >= b.CAMERA_OPENED.a()) {
                this.o = b.CAMERA_CLOSED;
                Camera camera = this.k;
                if (camera != null) {
                    camera.release();
                    this.k = null;
                }
                c cVar = this.c;
                if (cVar != null) {
                    cVar.onClosed();
                }
            }
        } catch (RuntimeException unused) {
        }
    }

    public synchronized void l() {
        b bVar = this.o;
        if (bVar == b.CAMERA_CLOSED || bVar == b.PREVIEW_STOPPED) {
            try {
                this.k = Camera.open(d(this.b.b()));
            } catch (RuntimeException e) {
                String str = "CameraManager::Camera open failed, " + e.getMessage();
            }
            if (this.k == null) {
                c cVar = this.c;
                if (cVar != null) {
                    cVar.b();
                }
            } else {
                c cVar2 = this.c;
                if (cVar2 != null) {
                    cVar2.a();
                }
                this.o = b.CAMERA_OPENED;
            }
        }
    }

    public synchronized void m() {
        Camera camera;
        if (this.o.a() < b.CAMERA_OPENED.a()) {
            return;
        }
        if (this.b.c() != 0 && (camera = this.k) != null) {
            camera.setPreviewCallback(new C0053e());
        }
    }

    public synchronized void n() {
        if (this.b.c() == 1) {
            if (this.o == b.PREVIEW_STOPPED) {
                return;
            }
            Camera camera = this.k;
            if (camera != null) {
                camera.setOneShotPreviewCallback(this.e);
            }
        } else if (this.b.c() == 0) {
            if (this.o == b.PREVIEW_STOPPED) {
                o();
            }
        } else if (this.b.c() == 2) {
            if (this.o == b.PREVIEW_STOPPED) {
                return;
            }
            Camera camera2 = this.k;
            if (camera2 != null) {
                camera2.setPreviewCallback(this.e);
            }
        }
    }

    public synchronized void o() {
        try {
            if (this.o.a() < b.CAMERA_INITIALED.a()) {
                return;
            }
            Camera camera = this.k;
            if (camera != null) {
                camera.startPreview();
                this.o = b.PREVIEW_STARTED;
            }
        } catch (RuntimeException unused) {
        }
    }

    public synchronized void p() {
        try {
            if (this.o.a() < b.PREVIEW_STARTED.a()) {
                return;
            }
            Camera camera = this.k;
            if (camera != null) {
                camera.setPreviewCallback(null);
                this.k.stopPreview();
                this.o = b.PREVIEW_STOPPED;
            }
        } catch (RuntimeException unused) {
        }
    }

    private int d(int i) {
        if (i != 0 && i != 1) {
            return 0;
        }
        int numberOfCameras = Camera.getNumberOfCameras();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == i) {
                "findCameraId: ".concat(String.valueOf(i2));
                return i2;
            }
        }
        return 0;
    }

    public synchronized void a(c cVar) {
        if (cVar != null) {
            this.c = cVar;
        } else {
            throw new IllegalArgumentException("CameraManager::setCameraStatusListener param invalid");
        }
    }

    public synchronized void b(int i) {
        if (this.k != null && this.o.a() != b.CAMERA_CLOSED.a()) {
            this.h.a(i);
        }
    }

    public synchronized C0342f c() {
        if (this.k != null && this.o.a() != b.CAMERA_CLOSED.a()) {
            return this.j.a();
        }
        return null;
    }

    public synchronized void a(TextureView textureView) throws IOException {
        if (textureView != null) {
            if (this.o.a() != b.CAMERA_OPENED.a()) {
                l();
            }
            this.h.a(this.k);
            this.i.a(this.k);
            this.j.a(this.k);
            Camera camera = this.k;
            if (camera != null) {
                camera.setPreviewTexture(textureView.getSurfaceTexture());
            }
            this.l.a(this.k, this.b);
            Camera camera2 = this.k;
            if (camera2 != null) {
                camera2.setDisplayOrientation(this.b.d());
            }
            a aVar = this.d;
            if (aVar != null) {
                aVar.a(this.l.b);
            }
            this.o = b.CAMERA_INITIALED;
        } else {
            throw new IllegalArgumentException("CameraManager::initCamera SurfaceHolder is null");
        }
    }

    public synchronized void a(String str) {
        try {
            if (this.k == null || this.o.a() == b.CAMERA_CLOSED.a()) {
                return;
            }
            if ("off".equals(str) || "torch".equals(str)) {
                Camera.Parameters parameters = this.k.getParameters();
                parameters.setFlashMode(str);
                this.k.setParameters(parameters);
                this.n = str;
            }
        } catch (RuntimeException unused) {
        }
    }

    public synchronized void a() {
        C0366l c0366l = this.g;
        if (c0366l != null) {
            c0366l.a();
            throw null;
        }
    }

    public synchronized void a(List<C0342f.a> list) {
        if (this.k != null && this.o.a() != b.CAMERA_CLOSED.a()) {
            this.j.a(list);
        }
    }

    public synchronized void a(int i) {
        if (this.b != null && this.k != null && this.o.a() >= b.CAMERA_OPENED.a()) {
            this.b.a(i);
            this.k.setDisplayOrientation(i);
        }
    }
}
