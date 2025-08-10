package com.wear.util.camera.record.widget;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.wear.util.MyApplication;
import dc.ih3;
import dc.lh3;
import dc.th3;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes4.dex */
public class CameraView extends GLSurfaceView implements GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener {
    public lh3 a;
    public ih3 b;
    public int c;
    public int d;
    public boolean e;
    public int f;
    public d g;

    public class a implements Runnable {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraView.this.a.b(this.a);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraView.this.a.j();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraView.this.a.k();
        }
    }

    public interface d {
        void l1();
    }

    public CameraView(Context context) {
        this(context, null);
    }

    public void b(int i) {
        queueEvent(new a(i));
    }

    public void c() {
        setEGLContextClientVersion(2);
        setRenderer(this);
        setRenderMode(0);
        setPreserveEGLContextOnPause(true);
        setCameraDistance(100.0f);
        this.a = new lh3(getResources());
        this.b = new ih3();
    }

    public void d(Point point, Camera.AutoFocusCallback autoFocusCallback) {
        this.b.f(point, autoFocusCallback);
    }

    public void e(MotionEvent motionEvent) {
    }

    public final void f(int i) {
        this.b.a();
        this.b.j(getWidth(), getHeight());
        this.b.g(i);
        this.a.f(i);
        try {
            Point pointD = this.b.d();
            this.c = pointD.x;
            this.d = pointD.y;
            String str = "open dataWidth: " + this.c + ", dataHeight:" + this.d;
            SurfaceTexture surfaceTextureE = this.a.e();
            surfaceTextureE.setOnFrameAvailableListener(this);
            this.b.i(surfaceTextureE);
            this.b.h();
        } catch (Exception e) {
            FirebaseCrashlytics.getInstance().recordException(new Throwable("previewSize为空", e));
            MyApplication.H().finish();
        }
    }

    public void g() {
        queueEvent(new b());
    }

    public int getBeautyLevel() {
        return this.a.d();
    }

    public int getCameraId() {
        return this.f;
    }

    public int getDataHeight() {
        return this.d;
    }

    public int getDataWidth() {
        return this.c;
    }

    public ih3 getmCamera() {
        return this.b;
    }

    public final void h() {
        if (this.e || this.c <= 0 || this.d <= 0) {
            return;
        }
        this.e = true;
    }

    public void i() {
        queueEvent(new c());
    }

    public void j(int i) {
        this.f = i;
        f(i);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        if (this.e) {
            this.a.onDrawFrame(gl10);
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        requestRender();
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        super.onPause();
        ih3 ih3Var = this.b;
        if (ih3Var != null) {
            ih3Var.a();
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        if (this.e) {
            f(this.f);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.a.onSurfaceChanged(gl10, i, i2);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.a.onSurfaceCreated(gl10, eGLConfig);
        if (!this.e) {
            f(this.f);
            h();
        }
        this.a.h(this.c, this.d);
        d dVar = this.g;
        if (dVar != null) {
            dVar.l1();
        }
    }

    public void setCameraId(int i) {
        this.f = i;
    }

    public void setOnFilterChangeListener(th3.a aVar) {
        this.a.g(aVar);
    }

    public void setOnSurfaceCreatedListener(d dVar) {
        this.g = dVar;
    }

    public void setSavePath(String str) {
        this.a.i(str);
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0;
        this.d = 0;
        this.e = false;
        c();
    }
}
