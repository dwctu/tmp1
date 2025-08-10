package dc;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: LazyList.java */
/* loaded from: classes2.dex */
public class f51<E> extends AbstractList<E> {
    public static final g51 c = g51.a(f51.class);
    public List<E> a;
    public Iterator<E> b;

    /* compiled from: LazyList.java */
    public class a implements Iterator<E> {
        public int a = 0;

        public a() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < f51.this.a.size() || f51.this.b.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.a >= f51.this.a.size()) {
                f51 f51Var = f51.this;
                f51Var.a.add(f51Var.b.next());
                return (E) next();
            }
            List<E> list = f51.this.a;
            int i = this.a;
            this.a = i + 1;
            return list.get(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public f51(List<E> list, Iterator<E> it) {
        this.a = list;
        this.b = it;
    }

    public final void a() {
        c.b("blowup running");
        while (this.b.hasNext()) {
            this.a.add(this.b.next());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        if (this.a.size() > i) {
            return this.a.get(i);
        }
        if (!this.b.hasNext()) {
            throw new NoSuchElementException();
        }
        this.a.add(this.b.next());
        return get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new a();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        c.b("potentially expensive size() call");
        a();
        return this.a.size();
    }
}
