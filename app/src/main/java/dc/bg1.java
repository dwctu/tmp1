package dc;

import dc.qf1;
import java.io.IOException;

/* compiled from: NullSafeJsonAdapter.java */
/* loaded from: classes3.dex */
public final class bg1<T> extends nf1<T> {
    public final nf1<T> a;

    public bg1(nf1<T> nf1Var) {
        this.a = nf1Var;
    }

    @Override // dc.nf1
    public T b(qf1 qf1Var) throws IOException {
        return qf1Var.O() == qf1.b.NULL ? (T) qf1Var.I() : this.a.b(qf1Var);
    }

    @Override // dc.nf1
    public void h(vf1 vf1Var, T t) throws IOException {
        if (t == null) {
            vf1Var.y();
        } else {
            this.a.h(vf1Var, t);
        }
    }

    public String toString() {
        return this.a + ".nullSafe()";
    }
}
