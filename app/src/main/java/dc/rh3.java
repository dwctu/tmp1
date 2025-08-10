package dc;

import android.content.res.Resources;
import android.opengl.GLES20;

/* compiled from: ProcessFilter.java */
/* loaded from: classes4.dex */
public class rh3 extends mh3 {
    public mh3 q;
    public int[] r;
    public int[] s;
    public int[] t;
    public int u;
    public int v;

    public rh3(Resources resources) {
        super(resources);
        this.r = new int[1];
        this.s = new int[1];
        this.t = new int[1];
        this.q = new ph3(resources);
        float[] originalMatrix = ui3.getOriginalMatrix();
        ui3.flip(originalMatrix, false, true);
        this.q.t(originalMatrix);
    }

    @Override // dc.mh3
    public void d() {
        boolean zGlIsEnabled = GLES20.glIsEnabled(2884);
        if (zGlIsEnabled) {
            GLES20.glDisable(2884);
        }
        GLES20.glViewport(0, 0, this.u, this.v);
        si3.bindFrameTexture(this.r[0], this.t[0]);
        GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.s[0]);
        this.q.v(h());
        this.q.d();
        si3.unBindFrameBuffer();
        if (zGlIsEnabled) {
            GLES20.glEnable(2884);
        }
    }

    @Override // dc.mh3
    public int g() {
        return this.t[0];
    }

    @Override // dc.mh3
    public void k() {
    }

    @Override // dc.mh3
    public void n() {
        this.q.a();
    }

    @Override // dc.mh3
    public void q(int i, int i2) {
        if (this.u == i || this.v == i2) {
            return;
        }
        this.u = i;
        this.v = i2;
        this.q.u(i, i2);
        z();
        GLES20.glGenFramebuffers(1, this.r, 0);
        GLES20.glGenRenderbuffers(1, this.s, 0);
        GLES20.glBindRenderbuffer(36161, this.s[0]);
        GLES20.glRenderbufferStorage(36161, 33189, i, i2);
        GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.s[0]);
        GLES20.glBindRenderbuffer(36161, 0);
        si3.genTexturesWithParameter(1, this.t, 0, 6408, i, i2);
    }

    public final void z() {
        GLES20.glDeleteRenderbuffers(1, this.s, 0);
        GLES20.glDeleteFramebuffers(1, this.r, 0);
        GLES20.glDeleteTextures(1, this.t, 0);
    }
}
