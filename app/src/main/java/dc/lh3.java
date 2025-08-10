package dc;

import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import com.wear.ui.longDistance.CameraNewActivity;
import dc.oi3;
import dc.th3;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: CameraDrawer.java */
/* loaded from: classes4.dex */
public class lh3 implements GLSurfaceView.Renderer {
    public float[] a;
    public final mh3 b;
    public final mh3 c;
    public final oh3 d;
    public final oh3 e;
    public mh3 f;
    public SurfaceTexture i;
    public oi3 n;
    public boolean o;
    public int p;
    public String q;
    public int r;
    public int j = 0;
    public int k = 0;
    public int l = 0;
    public int m = 0;
    public int[] s = new int[1];
    public int[] t = new int[1];
    public float[] u = new float[16];
    public boolean v = false;
    public xh3 g = new xh3();
    public th3 h = new th3();

    public lh3(Resources resources) {
        this.b = new ph3(resources);
        this.c = new nh3(resources);
        this.f = new rh3(resources);
        this.d = new oh3(resources);
        this.e = new oh3(resources);
        float[] originalMatrix = ui3.getOriginalMatrix();
        this.a = originalMatrix;
        ui3.flip(originalMatrix, false, true);
        sh3 sh3Var = new sh3(resources);
        sh3Var.A(0, 0, 0, 0);
        a(sh3Var);
        this.o = false;
    }

    public final void a(mh3 mh3Var) {
        this.d.z(mh3Var);
    }

    public void b(int i) {
        this.g.r(i);
    }

    public final int c() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        return iArr[0];
    }

    public int d() {
        return this.g.q();
    }

    public SurfaceTexture e() {
        return this.i;
    }

    public void f(int i) {
        this.c.s(i);
    }

    public void g(th3.a aVar) {
        this.h.s(aVar);
    }

    public void h(int i, int i2) {
        if (this.j == i && this.k == i2) {
            return;
        }
        this.j = i;
        this.k = i2;
    }

    public void i(String str) {
        this.q = str;
    }

    public void j() {
        this.o = true;
    }

    public void k() {
        this.o = false;
    }

    public void l() {
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        if (this.v) {
            this.i.updateTexImage();
            si3.bindFrameTexture(this.s[0], this.t[0]);
            GLES20.glViewport(0, 0, this.j, this.k);
            this.c.d();
            si3.unBindFrameBuffer();
            this.d.v(this.t[0]);
            this.d.d();
            xh3 xh3Var = this.g;
            if (xh3Var == null || xh3Var.q() == 0) {
                this.f.v(this.d.g());
            } else {
                si3.bindFrameTexture(this.s[0], this.t[0]);
                GLES20.glViewport(0, 0, this.j, this.k);
                this.g.i(this.d.g());
                si3.unBindFrameBuffer();
                this.f.v(this.t[0]);
            }
            this.f.d();
            this.h.l(this.f.g());
            this.e.v(this.h.g());
            this.e.d();
            if (this.o) {
                int i = this.p;
                if (i == 0) {
                    this.n = new oi3();
                    String str = "onDrawFrame: " + this.j + "  " + this.k;
                    String str2 = "CameraNewActivity.mSensorRotation: " + CameraNewActivity.C;
                    this.n.t(this.j, this.k);
                    this.n.v(CameraNewActivity.C);
                    int i2 = CameraNewActivity.C;
                    if (i2 % 180 == 0 || i2 == -1) {
                        oi3 oi3Var = this.n;
                        String str3 = this.q;
                        int i3 = this.j;
                        int i4 = this.k;
                        oi3Var.w(new oi3.a(str3, i3, i4, i3 * i4 * 2, EGL14.eglGetCurrentContext(), null));
                    } else {
                        oi3 oi3Var2 = this.n;
                        String str4 = this.q;
                        int i5 = this.k;
                        int i6 = this.j;
                        oi3Var2.w(new oi3.a(str4, i5, i6, i6 * i5 * 2, EGL14.eglGetCurrentContext(), null));
                    }
                    this.p = 1;
                } else if (i != 1) {
                    if (i == 2) {
                        this.n.y(EGL14.eglGetCurrentContext());
                        this.n.s();
                        this.p = 1;
                    } else if (i == 3) {
                        this.n.p();
                        this.p = 5;
                    } else if (i == 4) {
                        this.n.s();
                        this.p = 1;
                    } else if (i != 5) {
                        throw new RuntimeException("unknown recording status " + this.p);
                    }
                }
            } else {
                int i7 = this.p;
                if (i7 != 0) {
                    if (i7 != 1 && i7 != 2 && i7 != 3 && i7 != 4 && i7 != 5) {
                        throw new RuntimeException("unknown recording status " + this.p);
                    }
                    this.n.x();
                    this.p = 0;
                }
            }
            GLES20.glViewport(0, 0, this.l, this.m);
            this.b.v(this.e.g());
            this.b.d();
            oi3 oi3Var3 = this.n;
            if (oi3Var3 != null && this.o && this.p == 1) {
                oi3Var3.u(this.e.g());
                this.n.h(this.i);
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.l = i;
        this.m = i2;
        GLES20.glDeleteFramebuffers(1, this.s, 0);
        GLES20.glDeleteTextures(1, this.t, 0);
        GLES20.glGenFramebuffers(1, this.s, 0);
        GLES20.glGenTextures(1, this.t, 0);
        GLES20.glBindTexture(3553, this.t[0]);
        GLES20.glTexImage2D(3553, 0, 6408, this.j, this.k, 0, 6408, 5121, null);
        l();
        GLES20.glBindTexture(3553, 0);
        this.f.u(this.j, this.k);
        this.d.u(this.j, this.k);
        this.e.u(this.j, this.k);
        this.c.u(this.j, this.k);
        this.g.f(this.j, this.k);
        this.g.l(this.j, this.k);
        this.h.p(this.j, this.k);
        ui3.getShowMatrix(this.u, this.j, this.k, this.l, this.m);
        this.b.t(this.u);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.r = c();
        this.i = new SurfaceTexture(this.r);
        this.c.a();
        this.c.v(this.r);
        this.f.a();
        this.b.a();
        this.d.a();
        this.e.a();
        this.g.c();
        this.h.j();
        if (this.o) {
            this.p = 2;
        } else {
            this.p = 0;
        }
        this.v = true;
    }
}
