package dc;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.google.firebase.database.core.ValidationPath;

/* compiled from: WaterMarkFilter.java */
/* loaded from: classes4.dex */
public class sh3 extends ph3 {
    public int q;
    public int r;
    public Bitmap s;
    public ph3 t;
    public int[] u;

    /* compiled from: WaterMarkFilter.java */
    public class a extends ph3 {
        public a(sh3 sh3Var, Resources resources) {
            super(resources);
        }

        @Override // dc.ph3, dc.mh3
        public void m() {
        }
    }

    public sh3(Resources resources) {
        super(resources);
        this.u = new int[1];
        this.t = new a(this, resources);
    }

    public void A(int i, int i2, int i3, int i4) {
    }

    @Override // dc.mh3
    public void d() {
        super.d();
        GLES20.glDisable(2929);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(ValidationPath.MAX_PATH_LENGTH_BYTES, 772);
        this.t.d();
        GLES20.glDisable(3042);
        GLES20.glViewport(0, 0, this.q, this.r);
    }

    @Override // dc.ph3, dc.mh3
    public void n() {
        super.n();
        this.t.a();
        z();
    }

    @Override // dc.ph3, dc.mh3
    public void q(int i, int i2) {
        this.q = i;
        this.r = i2;
        this.t.u(i, i2);
    }

    public final void z() {
        if (this.s != null) {
            GLES20.glGenTextures(1, this.u, 0);
            GLES20.glBindTexture(3553, this.u[0]);
            GLES20.glTexParameterf(3553, 10241, 9728.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, this.s, 0);
            ui3.flip(this.t.f(), false, true);
            this.t.v(this.u[0]);
        }
    }
}
