package dc;

import android.opengl.EGL14;
import android.opengl.EGLSurface;

/* compiled from: EglSurfaceBase.java */
/* loaded from: classes4.dex */
public class ni3 {
    public mi3 a;
    public EGLSurface b = EGL14.EGL_NO_SURFACE;

    public ni3(mi3 mi3Var) {
        this.a = mi3Var;
    }

    public void a(Object obj) {
        if (this.b != EGL14.EGL_NO_SURFACE) {
            throw new IllegalStateException("surface already created");
        }
        this.b = this.a.b(obj);
    }

    public void b() {
        this.a.d(this.b);
    }

    public void c() {
        this.a.f(this.b);
        this.b = EGL14.EGL_NO_SURFACE;
    }

    public void d(long j) {
        this.a.g(this.b, j);
    }

    public boolean e() {
        return this.a.h(this.b);
    }
}
