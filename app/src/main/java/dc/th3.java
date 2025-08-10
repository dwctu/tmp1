package dc;

import android.opengl.GLES20;
import android.widget.Scroller;
import com.wear.util.MyApplication;

/* compiled from: SlideGpuFilterGroup.java */
/* loaded from: classes4.dex */
public class th3 {
    public uh3 b;
    public uh3 c;
    public uh3 d;
    public int e;
    public int f;
    public Scroller j;
    public a k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public hi3[] a = {hi3.NONE, hi3.WARM, hi3.ANTIQUE, hi3.INKWELL, hi3.BRANNAN, hi3.N1977, hi3.FREUD, hi3.HEFE, hi3.HUDSON, hi3.NASHVILLE, hi3.COOL};
    public int[] g = new int[1];
    public int[] h = new int[1];
    public int i = 0;

    /* compiled from: SlideGpuFilterGroup.java */
    public interface a {
        void a(hi3 hi3Var);
    }

    public th3() {
        k();
        this.j = new Scroller(MyApplication.N());
    }

    public final void a() {
        int i = this.i - 1;
        this.i = i;
        if (i < 0) {
            this.i = this.a.length - 1;
        }
    }

    public final void b(int i) {
        GLES20.glViewport(0, 0, this.e, this.f);
        GLES20.glEnable(3089);
        GLES20.glScissor(0, 0, this.m, this.f);
        this.c.i(i);
        GLES20.glDisable(3089);
        GLES20.glViewport(0, 0, this.e, this.f);
        GLES20.glEnable(3089);
        int i2 = this.m;
        GLES20.glScissor(i2, 0, this.e - i2, this.f);
        this.b.i(i);
        GLES20.glDisable(3089);
    }

    public final void c(int i) {
        GLES20.glViewport(0, 0, this.e, this.f);
        GLES20.glEnable(3089);
        GLES20.glScissor(0, 0, this.e - this.m, this.f);
        this.b.i(i);
        GLES20.glDisable(3089);
        GLES20.glViewport(0, 0, this.e, this.f);
        GLES20.glEnable(3089);
        int i2 = this.e;
        int i3 = this.m;
        GLES20.glScissor(i2 - i3, 0, i3, this.f);
        this.d.i(i);
        GLES20.glDisable(3089);
    }

    public final int d() {
        return this.i;
    }

    public final uh3 e(int i) {
        uh3 uh3VarA = gi3.a(this.a[i]);
        return uh3VarA == null ? new uh3() : uh3VarA;
    }

    public final int f() {
        int i = this.i - 1;
        return i < 0 ? this.a.length - 1 : i;
    }

    public int g() {
        return this.h[0];
    }

    public final int h() {
        int i = this.i + 1;
        if (i >= this.a.length) {
            return 0;
        }
        return i;
    }

    public final void i() {
        int i = this.i + 1;
        this.i = i;
        if (i >= this.a.length) {
            this.i = 0;
        }
    }

    public void j() {
        this.b.c();
        this.c.c();
        this.d.c();
    }

    public final void k() {
        this.b = e(d());
        this.c = e(f());
        this.d = e(h());
    }

    public void l(int i) {
        si3.bindFrameTexture(this.g[0], this.h[0]);
        int i2 = this.l;
        if (i2 == 0 && this.m == 0) {
            this.b.i(i);
        } else if (i2 == 1) {
            m(i);
        } else if (i2 == -1) {
            n(i);
        }
        si3.unBindFrameBuffer();
    }

    public final void m(int i) {
        if (this.n && this.j.computeScrollOffset()) {
            this.m = this.j.getCurrX();
            b(i);
            return;
        }
        b(i);
        if (this.n) {
            if (this.o) {
                r();
                a aVar = this.k;
                if (aVar != null) {
                    aVar.a(this.a[this.i]);
                }
            }
            this.m = 0;
            this.l = 0;
            this.n = false;
        }
    }

    public final void n(int i) {
        if (this.n && this.j.computeScrollOffset()) {
            this.m = this.j.getCurrX();
            c(i);
            return;
        }
        c(i);
        if (this.n) {
            if (this.o) {
                q();
                a aVar = this.k;
                if (aVar != null) {
                    aVar.a(this.a[this.i]);
                }
            }
            this.m = 0;
            this.l = 0;
            this.n = false;
        }
    }

    public final void o(int i, int i2) {
        this.b.l(i, i2);
        this.c.l(i, i2);
        this.d.l(i, i2);
        this.b.f(i, i2);
        this.c.f(i, i2);
        this.d.f(i, i2);
    }

    public void p(int i, int i2) {
        this.e = i;
        this.f = i2;
        GLES20.glGenFramebuffers(1, this.g, 0);
        si3.genTexturesWithParameter(1, this.h, 0, 6408, i, i2);
        o(i, i2);
    }

    public final void q() {
        i();
        this.c.a();
        this.c = this.b;
        this.b = this.d;
        uh3 uh3VarE = e(h());
        this.d = uh3VarE;
        uh3VarE.c();
        this.d.f(this.e, this.f);
        this.d.l(this.e, this.f);
        this.o = false;
    }

    public final void r() {
        a();
        this.d.a();
        this.d = this.b;
        this.b = this.c;
        uh3 uh3VarE = e(f());
        this.c = uh3VarE;
        uh3VarE.c();
        this.c.f(this.e, this.f);
        this.c.l(this.e, this.f);
        this.o = false;
    }

    public void s(a aVar) {
        this.k = aVar;
    }
}
