package dc;

import android.content.res.Resources;
import android.opengl.GLES20;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: GroupFilter.java */
/* loaded from: classes4.dex */
public class oh3 extends mh3 {
    public Queue<mh3> q;
    public List<mh3> r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int[] w;
    public int[] x;
    public int[] y;
    public int z;

    public oh3(Resources resources) {
        super(resources);
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 2;
        this.w = new int[1];
        this.x = new int[1];
        this.y = new int[2];
        this.z = 0;
        this.r = new ArrayList();
        this.q = new ConcurrentLinkedQueue();
    }

    public final boolean A() {
        GLES20.glGenFramebuffers(1, this.w, 0);
        GLES20.glGenRenderbuffers(1, this.x, 0);
        B();
        GLES20.glBindFramebuffer(36160, this.w[0]);
        GLES20.glBindRenderbuffer(36161, this.x[0]);
        GLES20.glRenderbufferStorage(36161, 33189, this.s, this.t);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.y[0], 0);
        GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.x[0]);
        C();
        return false;
    }

    public final void B() {
        GLES20.glGenTextures(this.v, this.y, 0);
        for (int i = 0; i < this.v; i++) {
            GLES20.glBindTexture(3553, this.y[i]);
            GLES20.glTexImage2D(3553, 0, 6408, this.s, this.t, 0, 6408, 5121, null);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10241, 9729);
        }
    }

    public final void C() {
        GLES20.glBindRenderbuffer(36161, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    public final void D() {
        while (true) {
            mh3 mh3VarPoll = this.q.poll();
            if (mh3VarPoll == null) {
                return;
            }
            mh3VarPoll.a();
            mh3VarPoll.u(this.s, this.t);
            this.r.add(mh3VarPoll);
            this.u++;
        }
    }

    @Override // dc.mh3
    public void d() {
        D();
        this.z = 0;
        GLES20.glViewport(0, 0, this.s, this.t);
        for (mh3 mh3Var : this.r) {
            GLES20.glBindFramebuffer(36160, this.w[0]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.y[this.z % 2], 0);
            GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.x[0]);
            int i = this.z;
            if (i == 0) {
                mh3Var.v(h());
            } else {
                mh3Var.v(this.y[(i - 1) % 2]);
            }
            mh3Var.d();
            C();
            this.z++;
        }
    }

    @Override // dc.mh3
    public int g() {
        return this.u == 0 ? h() : this.y[(this.z - 1) % 2];
    }

    @Override // dc.mh3
    public void k() {
    }

    @Override // dc.mh3
    public void n() {
    }

    @Override // dc.mh3
    public void q(int i, int i2) {
        this.s = i;
        this.t = i2;
        D();
        A();
    }

    public void z(mh3 mh3Var) {
        this.q.add(mh3Var);
    }
}
