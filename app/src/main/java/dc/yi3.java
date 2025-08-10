package dc;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: OutputSurface.java */
@TargetApi(16)
/* loaded from: classes4.dex */
public class yi3 implements SurfaceTexture.OnFrameAvailableListener {
    public EGL10 a;
    public EGLDisplay b;
    public EGLContext c;
    public EGLSurface d;
    public SurfaceTexture e;
    public Surface f;
    public final Object g;
    public boolean h;
    public aj3 i;
    public int j;
    public int k;
    public int l;
    public ByteBuffer m;

    public yi3(int i, int i2, int i3) {
        this.b = null;
        this.c = null;
        this.d = null;
        this.g = new Object();
        this.l = 0;
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.j = i;
        this.k = i2;
        this.l = i3;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(i * i2 * 4);
        this.m = byteBufferAllocateDirect;
        byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        d(i, i2);
        g();
        i();
    }

    public void a() {
        synchronized (this.g) {
            while (!this.h) {
                try {
                    this.g.wait(5000L);
                    if (!this.h) {
                        throw new RuntimeException("Surface frame wait timed out");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            this.h = false;
        }
        this.i.a("before updateTexImage");
        this.e.updateTexImage();
    }

    public final void b(String str) {
        if (this.a.eglGetError() != 12288) {
            throw new RuntimeException("EGL error encountered (see log)");
        }
    }

    public void c(boolean z) {
        this.i.c(this.e, z);
    }

    public final void d(int i, int i2) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.a = egl10;
        EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.b = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL10 display");
        }
        if (!this.a.eglInitialize(eGLDisplayEglGetDisplay, null)) {
            this.b = null;
            throw new RuntimeException("unable to initialize EGL10");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!this.a.eglChooseConfig(this.b, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12339, 1, 12352, 4, 12344}, eGLConfigArr, 1, new int[1])) {
            throw new RuntimeException("unable to find RGB888+pbuffer EGL config");
        }
        this.c = this.a.eglCreateContext(this.b, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
        b("eglCreateContext");
        if (this.c == null) {
            throw new RuntimeException("null context");
        }
        this.d = this.a.eglCreatePbufferSurface(this.b, eGLConfigArr[0], new int[]{12375, i, 12374, i2, 12344});
        b("eglCreatePbufferSurface");
        if (this.d == null) {
            throw new RuntimeException("surface was null");
        }
    }

    public ByteBuffer e() {
        this.m.rewind();
        GLES20.glReadPixels(0, 0, this.j, this.k, 6408, 5121, this.m);
        return this.m;
    }

    public Surface f() {
        return this.f;
    }

    public void g() {
        if (this.a == null) {
            throw new RuntimeException("not configured for makeCurrent");
        }
        b("before makeCurrent");
        EGL10 egl10 = this.a;
        EGLDisplay eGLDisplay = this.b;
        EGLSurface eGLSurface = this.d;
        if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.c)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void h() {
        EGL10 egl10 = this.a;
        if (egl10 != null) {
            if (egl10.eglGetCurrentContext().equals(this.c)) {
                EGL10 egl102 = this.a;
                EGLDisplay eGLDisplay = this.b;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            }
            this.a.eglDestroySurface(this.b, this.d);
            this.a.eglDestroyContext(this.b, this.c);
        }
        this.f.release();
        this.b = null;
        this.c = null;
        this.d = null;
        this.a = null;
        this.i = null;
        this.f = null;
        this.e = null;
    }

    public final void i() {
        aj3 aj3Var = new aj3(this.l);
        this.i = aj3Var;
        aj3Var.f();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.i.d());
        this.e = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.f = new Surface(this.e);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.g) {
            if (this.h) {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
            this.h = true;
            this.g.notifyAll();
        }
    }

    public yi3() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.g = new Object();
        this.l = 0;
        i();
    }
}
