package dc;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import javax.microedition.khronos.egl.EGL;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: EGLUtil.kt */
/* loaded from: classes3.dex */
public final class tg1 {
    public EGL10 a;
    public EGLDisplay b = EGL10.EGL_NO_DISPLAY;
    public EGLSurface c = EGL10.EGL_NO_SURFACE;
    public EGLContext d = EGL10.EGL_NO_CONTEXT;
    public EGLConfig e;
    public Surface f;

    public final EGLConfig a() {
        int[] iArr = new int[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArrC = c();
        EGL10 egl10 = this.a;
        if (egl10 == null || !egl10.eglChooseConfig(this.b, iArrC, eGLConfigArr, 1, iArr)) {
            return null;
        }
        return eGLConfigArr[0];
    }

    public final EGLContext b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        int[] iArr = {12440, 2, 12344};
        if (egl10 != null) {
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, iArr);
        }
        return null;
    }

    public final int[] c() {
        return new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};
    }

    public final void d() {
        EGL10 egl10 = this.a;
        if (egl10 != null) {
            EGLDisplay eGLDisplay = this.b;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            egl10.eglDestroySurface(this.b, this.c);
            egl10.eglDestroyContext(this.b, this.d);
            egl10.eglTerminate(this.b);
            Surface surface = this.f;
            if (surface != null) {
                surface.release();
            }
            this.f = null;
        }
    }

    public final void e(@NotNull SurfaceTexture surfaceTexture) {
        Intrinsics.checkParameterIsNotNull(surfaceTexture, "surfaceTexture");
        try {
            EGL egl = EGLContext.getEGL();
            if (egl == null) {
                throw new TypeCastException("null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
            }
            EGL10 egl10 = (EGL10) egl;
            this.a = egl10;
            EGLDisplay eGLDisplayEglGetDisplay = egl10 != null ? egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY) : null;
            this.b = eGLDisplayEglGetDisplay;
            int[] iArr = new int[2];
            EGL10 egl102 = this.a;
            if (egl102 != null) {
                egl102.eglInitialize(eGLDisplayEglGetDisplay, iArr);
            }
            this.e = a();
            Surface surface = new Surface(surfaceTexture);
            this.f = surface;
            EGL10 egl103 = this.a;
            this.c = egl103 != null ? egl103.eglCreateWindowSurface(this.b, this.e, surface, null) : null;
            this.d = b(this.a, this.b, this.e);
            EGLSurface eGLSurface = this.c;
            if (eGLSurface != null && !Intrinsics.areEqual(eGLSurface, EGL10.EGL_NO_SURFACE)) {
                EGL10 egl104 = this.a;
                if (egl104 != null) {
                    EGLDisplay eGLDisplay = this.b;
                    EGLSurface eGLSurface2 = this.c;
                    if (egl104.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, this.d)) {
                        return;
                    }
                    xh1 xh1Var = xh1.c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("make current error:");
                    EGL10 egl105 = this.a;
                    sb.append(Integer.toHexString(egl105 != null ? egl105.eglGetError() : 0));
                    xh1Var.b("AnimPlayer.EGLUtil", sb.toString());
                    return;
                }
                return;
            }
            xh1 xh1Var2 = xh1.c;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("error:");
            EGL10 egl106 = this.a;
            sb2.append(Integer.toHexString(egl106 != null ? egl106.eglGetError() : 0));
            xh1Var2.b("AnimPlayer.EGLUtil", sb2.toString());
        } catch (Throwable th) {
            xh1.c.c("AnimPlayer.EGLUtil", "error:" + th, th);
        }
    }

    public final void f() {
        EGLSurface eGLSurface;
        EGL10 egl10;
        EGLDisplay eGLDisplay = this.b;
        if (eGLDisplay == null || (eGLSurface = this.c) == null || (egl10 = this.a) == null) {
            return;
        }
        egl10.eglSwapBuffers(eGLDisplay, eGLSurface);
    }
}
