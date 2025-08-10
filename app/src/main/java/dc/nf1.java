package dc;

import com.squareup.moshi.JsonDataException;
import dc.qf1;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;

/* compiled from: JsonAdapter.java */
/* loaded from: classes3.dex */
public abstract class nf1<T> {

    /* compiled from: JsonAdapter.java */
    public class a extends nf1<T> {
        public final /* synthetic */ nf1 a;

        public a(nf1 nf1Var, nf1 nf1Var2) {
            this.a = nf1Var2;
        }

        @Override // dc.nf1
        public T b(qf1 qf1Var) throws IOException {
            return (T) this.a.b(qf1Var);
        }

        @Override // dc.nf1
        public boolean d() {
            return this.a.d();
        }

        @Override // dc.nf1
        public void h(vf1 vf1Var, T t) throws IOException {
            boolean zP = vf1Var.p();
            vf1Var.V(true);
            try {
                this.a.h(vf1Var, t);
            } finally {
                vf1Var.V(zP);
            }
        }

        public String toString() {
            return this.a + ".serializeNulls()";
        }
    }

    /* compiled from: JsonAdapter.java */
    public class b extends nf1<T> {
        public final /* synthetic */ nf1 a;

        public b(nf1 nf1Var, nf1 nf1Var2) {
            this.a = nf1Var2;
        }

        @Override // dc.nf1
        public T b(qf1 qf1Var) throws IOException {
            boolean zQ = qf1Var.q();
            qf1Var.f0(true);
            try {
                return (T) this.a.b(qf1Var);
            } finally {
                qf1Var.f0(zQ);
            }
        }

        @Override // dc.nf1
        public boolean d() {
            return true;
        }

        @Override // dc.nf1
        public void h(vf1 vf1Var, T t) throws IOException {
            boolean zQ = vf1Var.q();
            vf1Var.O(true);
            try {
                this.a.h(vf1Var, t);
            } finally {
                vf1Var.O(zQ);
            }
        }

        public String toString() {
            return this.a + ".lenient()";
        }
    }

    /* compiled from: JsonAdapter.java */
    public class c extends nf1<T> {
        public final /* synthetic */ nf1 a;

        public c(nf1 nf1Var, nf1 nf1Var2) {
            this.a = nf1Var2;
        }

        @Override // dc.nf1
        public T b(qf1 qf1Var) throws IOException {
            boolean zM = qf1Var.m();
            qf1Var.e0(true);
            try {
                return (T) this.a.b(qf1Var);
            } finally {
                qf1Var.e0(zM);
            }
        }

        @Override // dc.nf1
        public boolean d() {
            return this.a.d();
        }

        @Override // dc.nf1
        public void h(vf1 vf1Var, T t) throws IOException {
            this.a.h(vf1Var, t);
        }

        public String toString() {
            return this.a + ".failOnUnknown()";
        }
    }

    /* compiled from: JsonAdapter.java */
    public interface d {
        nf1<?> a(Type type, Set<? extends Annotation> set, yf1 yf1Var);
    }

    public final nf1<T> a() {
        return new c(this, this);
    }

    public abstract T b(qf1 qf1Var) throws IOException;

    public final T c(String str) throws IOException {
        nd4 nd4Var = new nd4();
        nd4Var.u0(str);
        qf1 qf1VarL = qf1.L(nd4Var);
        T tB = b(qf1VarL);
        if (d() || qf1VarL.O() == qf1.b.END_DOCUMENT) {
            return tB;
        }
        throw new JsonDataException("JSON document was not fully consumed.");
    }

    public boolean d() {
        return false;
    }

    public final nf1<T> e() {
        return new b(this, this);
    }

    public final nf1<T> f() {
        return this instanceof bg1 ? this : new bg1(this);
    }

    public final nf1<T> g() {
        return new a(this, this);
    }

    public abstract void h(vf1 vf1Var, T t) throws IOException;
}
