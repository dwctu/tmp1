package dc;

import dc.nf1;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* compiled from: CollectionJsonAdapter.java */
/* loaded from: classes3.dex */
public abstract class lf1<C extends Collection<T>, T> extends nf1<C> {
    public static final nf1.d b = new a();
    public final nf1<T> a;

    /* compiled from: CollectionJsonAdapter.java */
    public class a implements nf1.d {
        @Override // dc.nf1.d
        public nf1<?> a(Type type, Set<? extends Annotation> set, yf1 yf1Var) {
            Class<?> clsG = ag1.g(type);
            if (!set.isEmpty()) {
                return null;
            }
            if (clsG == List.class || clsG == Collection.class) {
                return lf1.j(type, yf1Var).f();
            }
            if (clsG == Set.class) {
                return lf1.l(type, yf1Var).f();
            }
            return null;
        }
    }

    /* compiled from: CollectionJsonAdapter.java */
    public class b extends lf1<Collection<T>, T> {
        public b(nf1 nf1Var) {
            super(nf1Var, null);
        }

        @Override // dc.nf1
        public /* bridge */ /* synthetic */ Object b(qf1 qf1Var) throws IOException {
            return super.i(qf1Var);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.nf1
        public /* bridge */ /* synthetic */ void h(vf1 vf1Var, Object obj) throws IOException {
            super.m(vf1Var, (Collection) obj);
        }

        @Override // dc.lf1
        public Collection<T> k() {
            return new ArrayList();
        }
    }

    /* compiled from: CollectionJsonAdapter.java */
    public class c extends lf1<Set<T>, T> {
        public c(nf1 nf1Var) {
            super(nf1Var, null);
        }

        @Override // dc.nf1
        public /* bridge */ /* synthetic */ Object b(qf1 qf1Var) throws IOException {
            return super.i(qf1Var);
        }

        @Override // dc.nf1
        public /* bridge */ /* synthetic */ void h(vf1 vf1Var, Object obj) throws IOException {
            super.m(vf1Var, (Set) obj);
        }

        @Override // dc.lf1
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public Set<T> k() {
            return new LinkedHashSet();
        }
    }

    public /* synthetic */ lf1(nf1 nf1Var, a aVar) {
        this(nf1Var);
    }

    public static <T> nf1<Collection<T>> j(Type type, yf1 yf1Var) {
        return new b(yf1Var.d(ag1.c(type, Collection.class)));
    }

    public static <T> nf1<Set<T>> l(Type type, yf1 yf1Var) {
        return new c(yf1Var.d(ag1.c(type, Collection.class)));
    }

    public C i(qf1 qf1Var) throws IOException {
        C c2 = (C) k();
        qf1Var.b();
        while (qf1Var.p()) {
            c2.add(this.a.b(qf1Var));
        }
        qf1Var.f();
        return c2;
    }

    public abstract C k();

    /* JADX WARN: Multi-variable type inference failed */
    public void m(vf1 vf1Var, C c2) throws IOException {
        vf1Var.b();
        Iterator it = c2.iterator();
        while (it.hasNext()) {
            this.a.h(vf1Var, it.next());
        }
        vf1Var.j();
    }

    public String toString() {
        return this.a + ".collection()";
    }

    public lf1(nf1<T> nf1Var) {
        this.a = nf1Var;
    }
}
