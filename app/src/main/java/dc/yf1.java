package dc;

import dc.nf1;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* compiled from: Moshi.java */
/* loaded from: classes3.dex */
public final class yf1 {
    public static final List<nf1.d> d;
    public final List<nf1.d> a;
    public final ThreadLocal<c> b = new ThreadLocal<>();
    public final Map<Object, nf1<?>> c = new LinkedHashMap();

    /* compiled from: Moshi.java */
    public static final class a {
        public final List<nf1.d> a = new ArrayList();

        public a a(nf1.d dVar) {
            if (dVar == null) {
                throw new IllegalArgumentException("factory == null");
            }
            this.a.add(dVar);
            return this;
        }

        public yf1 b() {
            return new yf1(this);
        }
    }

    /* compiled from: Moshi.java */
    public static final class b<T> extends nf1<T> {
        public final Type a;
        public final String b;
        public final Object c;
        public nf1<T> d;

        public b(Type type, String str, Object obj) {
            this.a = type;
            this.b = str;
            this.c = obj;
        }

        @Override // dc.nf1
        public T b(qf1 qf1Var) throws IOException {
            nf1<T> nf1Var = this.d;
            if (nf1Var != null) {
                return nf1Var.b(qf1Var);
            }
            throw new IllegalStateException("JsonAdapter isn't ready");
        }

        @Override // dc.nf1
        public void h(vf1 vf1Var, T t) throws IOException {
            nf1<T> nf1Var = this.d;
            if (nf1Var == null) {
                throw new IllegalStateException("JsonAdapter isn't ready");
            }
            nf1Var.h(vf1Var, t);
        }

        public String toString() {
            nf1<T> nf1Var = this.d;
            return nf1Var != null ? nf1Var.toString() : super.toString();
        }
    }

    /* compiled from: Moshi.java */
    public final class c {
        public final List<b<?>> a = new ArrayList();
        public final Deque<b<?>> b = new ArrayDeque();
        public boolean c;

        public c() {
        }

        public <T> void a(nf1<T> nf1Var) {
            this.b.getLast().d = nf1Var;
        }

        public IllegalArgumentException b(IllegalArgumentException illegalArgumentException) {
            if (this.c) {
                return illegalArgumentException;
            }
            this.c = true;
            if (this.b.size() == 1 && this.b.getFirst().b == null) {
                return illegalArgumentException;
            }
            StringBuilder sb = new StringBuilder(illegalArgumentException.getMessage());
            Iterator<b<?>> itDescendingIterator = this.b.descendingIterator();
            while (itDescendingIterator.hasNext()) {
                b<?> next = itDescendingIterator.next();
                sb.append("\nfor ");
                sb.append(next.a);
                if (next.b != null) {
                    sb.append(' ');
                    sb.append(next.b);
                }
            }
            return new IllegalArgumentException(sb.toString(), illegalArgumentException);
        }

        public void c(boolean z) {
            this.b.removeLast();
            if (this.b.isEmpty()) {
                yf1.this.b.remove();
                if (z) {
                    synchronized (yf1.this.c) {
                        int size = this.a.size();
                        for (int i = 0; i < size; i++) {
                            b<?> bVar = this.a.get(i);
                            nf1<T> nf1Var = (nf1) yf1.this.c.put(bVar.c, bVar.d);
                            if (nf1Var != 0) {
                                bVar.d = nf1Var;
                                yf1.this.c.put(bVar.c, nf1Var);
                            }
                        }
                    }
                }
            }
        }

        public <T> nf1<T> d(Type type, String str, Object obj) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                b<?> bVar = this.a.get(i);
                if (bVar.c.equals(obj)) {
                    this.b.add(bVar);
                    nf1<T> nf1Var = (nf1<T>) bVar.d;
                    return nf1Var != null ? nf1Var : bVar;
                }
            }
            b<?> bVar2 = new b<>(type, str, obj);
            this.a.add(bVar2);
            this.b.add(bVar2);
            return null;
        }
    }

    static {
        ArrayList arrayList = new ArrayList(5);
        d = arrayList;
        arrayList.add(zf1.a);
        arrayList.add(lf1.b);
        arrayList.add(xf1.c);
        arrayList.add(if1.c);
        arrayList.add(kf1.d);
    }

    public yf1(a aVar) {
        int size = aVar.a.size();
        List<nf1.d> list = d;
        ArrayList arrayList = new ArrayList(size + list.size());
        arrayList.addAll(aVar.a);
        arrayList.addAll(list);
        this.a = Collections.unmodifiableList(arrayList);
    }

    public <T> nf1<T> c(Class<T> cls) {
        return e(cls, cg1.a);
    }

    public <T> nf1<T> d(Type type) {
        return e(type, cg1.a);
    }

    public <T> nf1<T> e(Type type, Set<? extends Annotation> set) {
        return f(type, set, null);
    }

    public <T> nf1<T> f(Type type, Set<? extends Annotation> set, String str) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(set, "annotations == null");
        Type typeM = cg1.m(cg1.a(type));
        Object objG = g(typeM, set);
        synchronized (this.c) {
            nf1<T> nf1Var = (nf1) this.c.get(objG);
            if (nf1Var != null) {
                return nf1Var;
            }
            c cVar = this.b.get();
            if (cVar == null) {
                cVar = new c();
                this.b.set(cVar);
            }
            nf1<T> nf1VarD = cVar.d(typeM, str, objG);
            try {
                if (nf1VarD != null) {
                    return nf1VarD;
                }
                try {
                    int size = this.a.size();
                    for (int i = 0; i < size; i++) {
                        nf1<T> nf1Var2 = (nf1<T>) this.a.get(i).a(typeM, set, this);
                        if (nf1Var2 != null) {
                            cVar.a(nf1Var2);
                            cVar.c(true);
                            return nf1Var2;
                        }
                    }
                    throw new IllegalArgumentException("No JsonAdapter for " + cg1.r(typeM, set));
                } catch (IllegalArgumentException e) {
                    throw cVar.b(e);
                }
            } finally {
                cVar.c(false);
            }
        }
    }

    public final Object g(Type type, Set<? extends Annotation> set) {
        return set.isEmpty() ? type : Arrays.asList(type, set);
    }
}
