package dc;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* compiled from: LinkedHashTreeMap.java */
/* loaded from: classes3.dex */
public final class wf1<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final Comparator<Comparable> a = new a();
    public Comparator<? super K> comparator;
    private wf1<K, V>.d entrySet;
    public final g<K, V> header;
    private wf1<K, V>.e keySet;
    public int modCount;
    public int size;
    public g<K, V>[] table;
    public int threshold;

    /* compiled from: LinkedHashTreeMap.java */
    public class a implements Comparator<Comparable> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* compiled from: LinkedHashTreeMap.java */
    public static final class b<K, V> {
        public g<K, V> a;
        public int b;
        public int c;
        public int d;

        public void a(g<K, V> gVar) {
            gVar.c = null;
            gVar.a = null;
            gVar.b = null;
            gVar.i = 1;
            int i = this.b;
            if (i > 0) {
                int i2 = this.d;
                if ((i2 & 1) == 0) {
                    this.d = i2 + 1;
                    this.b = i - 1;
                    this.c++;
                }
            }
            gVar.a = this.a;
            this.a = gVar;
            int i3 = this.d + 1;
            this.d = i3;
            int i4 = this.b;
            if (i4 > 0 && (i3 & 1) == 0) {
                this.d = i3 + 1;
                this.b = i4 - 1;
                this.c++;
            }
            int i5 = 4;
            while (true) {
                int i6 = i5 - 1;
                if ((this.d & i6) != i6) {
                    return;
                }
                int i7 = this.c;
                if (i7 == 0) {
                    g<K, V> gVar2 = this.a;
                    g<K, V> gVar3 = gVar2.a;
                    g<K, V> gVar4 = gVar3.a;
                    gVar3.a = gVar4.a;
                    this.a = gVar3;
                    gVar3.b = gVar4;
                    gVar3.c = gVar2;
                    gVar3.i = gVar2.i + 1;
                    gVar4.a = gVar3;
                    gVar2.a = gVar3;
                } else if (i7 == 1) {
                    g<K, V> gVar5 = this.a;
                    g<K, V> gVar6 = gVar5.a;
                    this.a = gVar6;
                    gVar6.c = gVar5;
                    gVar6.i = gVar5.i + 1;
                    gVar5.a = gVar6;
                    this.c = 0;
                } else if (i7 == 2) {
                    this.c = 0;
                }
                i5 *= 2;
            }
        }

        public void b(int i) {
            this.b = ((Integer.highestOneBit(i) * 2) - 1) - i;
            this.d = 0;
            this.c = 0;
            this.a = null;
        }

        public g<K, V> c() {
            g<K, V> gVar = this.a;
            if (gVar.a == null) {
                return gVar;
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: LinkedHashTreeMap.java */
    public static class c<K, V> {
        public g<K, V> a;

        public g<K, V> a() {
            g<K, V> gVar = this.a;
            if (gVar == null) {
                return null;
            }
            g<K, V> gVar2 = gVar.a;
            gVar.a = null;
            g<K, V> gVar3 = gVar.c;
            while (true) {
                g<K, V> gVar4 = gVar2;
                gVar2 = gVar3;
                if (gVar2 == null) {
                    this.a = gVar4;
                    return gVar;
                }
                gVar2.a = gVar4;
                gVar3 = gVar2.b;
            }
        }

        public void b(g<K, V> gVar) {
            g<K, V> gVar2 = null;
            while (gVar != null) {
                gVar.a = gVar2;
                gVar2 = gVar;
                gVar = gVar.b;
            }
            this.a = gVar2;
        }
    }

    /* compiled from: LinkedHashTreeMap.java */
    public final class d extends AbstractSet<Map.Entry<K, V>> {

        /* compiled from: LinkedHashTreeMap.java */
        public class a extends wf1<K, V>.f<Map.Entry<K, V>> {
            public a(d dVar) {
                super();
            }

            @Override // java.util.Iterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        public d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            wf1.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && wf1.this.e((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            g<K, V> gVarE;
            if (!(obj instanceof Map.Entry) || (gVarE = wf1.this.e((Map.Entry) obj)) == null) {
                return false;
            }
            wf1.this.h(gVarE, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return wf1.this.size;
        }
    }

    /* compiled from: LinkedHashTreeMap.java */
    public final class e extends AbstractSet<K> {

        /* compiled from: LinkedHashTreeMap.java */
        public class a extends wf1<K, V>.f<K> {
            public a(e eVar) {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f;
            }
        }

        public e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            wf1.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return wf1.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return wf1.this.i(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return wf1.this.size;
        }
    }

    /* compiled from: LinkedHashTreeMap.java */
    public abstract class f<T> implements Iterator<T> {
        public g<K, V> a;
        public g<K, V> b = null;
        public int c;

        public f() {
            this.a = wf1.this.header.d;
            this.c = wf1.this.modCount;
        }

        public final g<K, V> a() {
            g<K, V> gVar = this.a;
            wf1 wf1Var = wf1.this;
            if (gVar == wf1Var.header) {
                throw new NoSuchElementException();
            }
            if (wf1Var.modCount != this.c) {
                throw new ConcurrentModificationException();
            }
            this.a = gVar.d;
            this.b = gVar;
            return gVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.a != wf1.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            g<K, V> gVar = this.b;
            if (gVar == null) {
                throw new IllegalStateException();
            }
            wf1.this.h(gVar, true);
            this.b = null;
            this.c = wf1.this.modCount;
        }
    }

    public wf1() {
        this(null);
    }

    public static <K, V> g<K, V>[] b(g<K, V>[] gVarArr) {
        int length = gVarArr.length;
        g<K, V>[] gVarArr2 = new g[length * 2];
        c cVar = new c();
        b bVar = new b();
        b bVar2 = new b();
        for (int i = 0; i < length; i++) {
            g<K, V> gVar = gVarArr[i];
            if (gVar != null) {
                cVar.b(gVar);
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    g<K, V> gVarA = cVar.a();
                    if (gVarA == null) {
                        break;
                    }
                    if ((gVarA.g & length) == 0) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                bVar.b(i2);
                bVar2.b(i3);
                cVar.b(gVar);
                while (true) {
                    g<K, V> gVarA2 = cVar.a();
                    if (gVarA2 == null) {
                        break;
                    }
                    if ((gVarA2.g & length) == 0) {
                        bVar.a(gVarA2);
                    } else {
                        bVar2.a(gVarA2);
                    }
                }
                gVarArr2[i] = i2 > 0 ? bVar.c() : null;
                gVarArr2[i + length] = i3 > 0 ? bVar2.c() : null;
            }
        }
        return gVarArr2;
    }

    public static int m(int i) {
        int i2 = i ^ ((i >>> 20) ^ (i >>> 12));
        return (i2 >>> 4) ^ ((i2 >>> 7) ^ i2);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    public final void a() {
        g<K, V>[] gVarArrB = b(this.table);
        this.table = gVarArrB;
        this.threshold = (gVarArrB.length / 2) + (gVarArrB.length / 4);
    }

    public final boolean c(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.table, (Object) null);
        this.size = 0;
        this.modCount++;
        g<K, V> gVar = this.header;
        g<K, V> gVar2 = gVar.d;
        while (gVar2 != gVar) {
            g<K, V> gVar3 = gVar2.d;
            gVar2.e = null;
            gVar2.d = null;
            gVar2 = gVar3;
        }
        gVar.e = gVar;
        gVar.d = gVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return f(obj) != null;
    }

    public g<K, V> d(K k, boolean z) {
        g<K, V> gVar;
        int i;
        g<K, V> gVar2;
        Comparator<? super K> comparator = this.comparator;
        g<K, V>[] gVarArr = this.table;
        int iM = m(k.hashCode());
        int length = (gVarArr.length - 1) & iM;
        g<K, V> gVar3 = gVarArr[length];
        if (gVar3 != null) {
            Comparable comparable = comparator == a ? (Comparable) k : null;
            while (true) {
                int iCompareTo = comparable != null ? comparable.compareTo(gVar3.f) : comparator.compare(k, gVar3.f);
                if (iCompareTo == 0) {
                    return gVar3;
                }
                g<K, V> gVar4 = iCompareTo < 0 ? gVar3.b : gVar3.c;
                if (gVar4 == null) {
                    gVar = gVar3;
                    i = iCompareTo;
                    break;
                }
                gVar3 = gVar4;
            }
        } else {
            gVar = gVar3;
            i = 0;
        }
        if (!z) {
            return null;
        }
        g<K, V> gVar5 = this.header;
        if (gVar != null) {
            gVar2 = new g<>(gVar, k, iM, gVar5, gVar5.e);
            if (i < 0) {
                gVar.b = gVar2;
            } else {
                gVar.c = gVar2;
            }
            g(gVar, true);
        } else {
            if (comparator == a && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            }
            gVar2 = new g<>(gVar, k, iM, gVar5, gVar5.e);
            gVarArr[length] = gVar2;
        }
        int i2 = this.size;
        this.size = i2 + 1;
        if (i2 > this.threshold) {
            a();
        }
        this.modCount++;
        return gVar2;
    }

    public g<K, V> e(Map.Entry<?, ?> entry) {
        g<K, V> gVarF = f(entry.getKey());
        if (gVarF != null && c(gVarF.h, entry.getValue())) {
            return gVarF;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        wf1<K, V>.d dVar = this.entrySet;
        if (dVar != null) {
            return dVar;
        }
        wf1<K, V>.d dVar2 = new d();
        this.entrySet = dVar2;
        return dVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g<K, V> f(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return d(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public final void g(g<K, V> gVar, boolean z) {
        while (gVar != null) {
            g<K, V> gVar2 = gVar.b;
            g<K, V> gVar3 = gVar.c;
            int i = gVar2 != null ? gVar2.i : 0;
            int i2 = gVar3 != null ? gVar3.i : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                g<K, V> gVar4 = gVar3.b;
                g<K, V> gVar5 = gVar3.c;
                int i4 = (gVar4 != null ? gVar4.i : 0) - (gVar5 != null ? gVar5.i : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    k(gVar);
                } else {
                    l(gVar3);
                    k(gVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                g<K, V> gVar6 = gVar2.b;
                g<K, V> gVar7 = gVar2.c;
                int i5 = (gVar6 != null ? gVar6.i : 0) - (gVar7 != null ? gVar7.i : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    l(gVar);
                } else {
                    k(gVar2);
                    l(gVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                gVar.i = i + 1;
                if (z) {
                    return;
                }
            } else {
                gVar.i = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            gVar = gVar.a;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        g<K, V> gVarF = f(obj);
        if (gVarF != null) {
            return gVarF.h;
        }
        return null;
    }

    public void h(g<K, V> gVar, boolean z) {
        int i;
        if (z) {
            g<K, V> gVar2 = gVar.e;
            gVar2.d = gVar.d;
            gVar.d.e = gVar2;
            gVar.e = null;
            gVar.d = null;
        }
        g<K, V> gVar3 = gVar.b;
        g<K, V> gVar4 = gVar.c;
        g<K, V> gVar5 = gVar.a;
        int i2 = 0;
        if (gVar3 == null || gVar4 == null) {
            if (gVar3 != null) {
                j(gVar, gVar3);
                gVar.b = null;
            } else if (gVar4 != null) {
                j(gVar, gVar4);
                gVar.c = null;
            } else {
                j(gVar, null);
            }
            g(gVar5, false);
            this.size--;
            this.modCount++;
            return;
        }
        g<K, V> gVarB = gVar3.i > gVar4.i ? gVar3.b() : gVar4.a();
        h(gVarB, false);
        g<K, V> gVar6 = gVar.b;
        if (gVar6 != null) {
            i = gVar6.i;
            gVarB.b = gVar6;
            gVar6.a = gVarB;
            gVar.b = null;
        } else {
            i = 0;
        }
        g<K, V> gVar7 = gVar.c;
        if (gVar7 != null) {
            i2 = gVar7.i;
            gVarB.c = gVar7;
            gVar7.a = gVarB;
            gVar.c = null;
        }
        gVarB.i = Math.max(i, i2) + 1;
        j(gVar, gVarB);
    }

    public g<K, V> i(Object obj) {
        g<K, V> gVarF = f(obj);
        if (gVarF != null) {
            h(gVarF, true);
        }
        return gVarF;
    }

    public final void j(g<K, V> gVar, g<K, V> gVar2) {
        g<K, V> gVar3 = gVar.a;
        gVar.a = null;
        if (gVar2 != null) {
            gVar2.a = gVar3;
        }
        if (gVar3 == null) {
            int i = gVar.g;
            this.table[i & (r0.length - 1)] = gVar2;
        } else if (gVar3.b == gVar) {
            gVar3.b = gVar2;
        } else {
            gVar3.c = gVar2;
        }
    }

    public final void k(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.b;
        g<K, V> gVar3 = gVar.c;
        g<K, V> gVar4 = gVar3.b;
        g<K, V> gVar5 = gVar3.c;
        gVar.c = gVar4;
        if (gVar4 != null) {
            gVar4.a = gVar;
        }
        j(gVar, gVar3);
        gVar3.b = gVar;
        gVar.a = gVar3;
        int iMax = Math.max(gVar2 != null ? gVar2.i : 0, gVar4 != null ? gVar4.i : 0) + 1;
        gVar.i = iMax;
        gVar3.i = Math.max(iMax, gVar5 != null ? gVar5.i : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        wf1<K, V>.e eVar = this.keySet;
        if (eVar != null) {
            return eVar;
        }
        wf1<K, V>.e eVar2 = new e();
        this.keySet = eVar2;
        return eVar2;
    }

    public final void l(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.b;
        g<K, V> gVar3 = gVar.c;
        g<K, V> gVar4 = gVar2.b;
        g<K, V> gVar5 = gVar2.c;
        gVar.b = gVar5;
        if (gVar5 != null) {
            gVar5.a = gVar;
        }
        j(gVar, gVar2);
        gVar2.c = gVar;
        gVar.a = gVar2;
        int iMax = Math.max(gVar3 != null ? gVar3.i : 0, gVar5 != null ? gVar5.i : 0) + 1;
        gVar.i = iMax;
        gVar2.i = Math.max(iMax, gVar4 != null ? gVar4.i : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        Objects.requireNonNull(k, "key == null");
        g<K, V> gVarD = d(k, true);
        V v2 = gVarD.h;
        gVarD.h = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        g<K, V> gVarI = i(obj);
        if (gVarI != null) {
            return gVarI.h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public wf1(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator == null ? a : comparator;
        this.header = new g<>();
        g<K, V>[] gVarArr = new g[16];
        this.table = gVarArr;
        this.threshold = (gVarArr.length / 2) + (gVarArr.length / 4);
    }

    /* compiled from: LinkedHashTreeMap.java */
    public static final class g<K, V> implements Map.Entry<K, V> {
        public g<K, V> a;
        public g<K, V> b;
        public g<K, V> c;
        public g<K, V> d;
        public g<K, V> e;
        public final K f;
        public final int g;
        public V h;
        public int i;

        public g() {
            this.f = null;
            this.g = -1;
            this.e = this;
            this.d = this;
        }

        public g<K, V> a() {
            g<K, V> gVar = this;
            for (g<K, V> gVar2 = this.b; gVar2 != null; gVar2 = gVar2.b) {
                gVar = gVar2;
            }
            return gVar;
        }

        public g<K, V> b() {
            g<K, V> gVar = this;
            for (g<K, V> gVar2 = this.c; gVar2 != null; gVar2 = gVar2.c) {
                gVar = gVar2;
            }
            return gVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k = this.f;
            if (k == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k.equals(entry.getKey())) {
                return false;
            }
            V v = this.h;
            if (v == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f;
            int iHashCode = k == null ? 0 : k.hashCode();
            V v = this.h;
            return iHashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.h;
            this.h = v;
            return v2;
        }

        public String toString() {
            return this.f + "=" + this.h;
        }

        public g(g<K, V> gVar, K k, int i, g<K, V> gVar2, g<K, V> gVar3) {
            this.a = gVar;
            this.f = k;
            this.g = i;
            this.i = 1;
            this.d = gVar2;
            this.e = gVar3;
            gVar3.d = this;
            gVar2.e = this;
        }
    }
}
