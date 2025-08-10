package dc;

import dc.nf1;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;

/* compiled from: ArrayJsonAdapter.java */
/* loaded from: classes3.dex */
public final class if1 extends nf1<Object> {
    public static final nf1.d c = new a();
    public final Class<?> a;
    public final nf1<Object> b;

    /* compiled from: ArrayJsonAdapter.java */
    public class a implements nf1.d {
        @Override // dc.nf1.d
        public nf1<?> a(Type type, Set<? extends Annotation> set, yf1 yf1Var) {
            Type typeA = ag1.a(type);
            if (typeA != null && set.isEmpty()) {
                return new if1(ag1.g(typeA), yf1Var.d(typeA)).f();
            }
            return null;
        }
    }

    public if1(Class<?> cls, nf1<Object> nf1Var) {
        this.a = cls;
        this.b = nf1Var;
    }

    @Override // dc.nf1
    public Object b(qf1 qf1Var) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        ArrayList arrayList = new ArrayList();
        qf1Var.b();
        while (qf1Var.p()) {
            arrayList.add(this.b.b(qf1Var));
        }
        qf1Var.f();
        Object objNewInstance = Array.newInstance(this.a, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(objNewInstance, i, arrayList.get(i));
        }
        return objNewInstance;
    }

    @Override // dc.nf1
    public void h(vf1 vf1Var, Object obj) throws IOException {
        vf1Var.b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.b.h(vf1Var, Array.get(obj, i));
        }
        vf1Var.j();
    }

    public String toString() {
        return this.b + ".array()";
    }
}
