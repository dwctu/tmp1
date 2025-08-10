package dc;

import android.util.Log;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: LruArrayPool.java */
/* loaded from: classes.dex */
public final class hj implements zi {
    public final fj<a, Object> a = new fj<>();
    public final b b = new b();
    public final Map<Class<?>, NavigableMap<Integer, Integer>> c = new HashMap();
    public final Map<Class<?>, yi<?>> d = new HashMap();
    public final int e;
    public int f;

    /* compiled from: LruArrayPool.java */
    public static final class a implements kj {
        public final b a;
        public int b;
        public Class<?> c;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // dc.kj
        public void a() {
            this.a.c(this);
        }

        public void b(int i, Class<?> cls) {
            this.b = i;
            this.c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.b == aVar.b && this.c == aVar.c;
        }

        public int hashCode() {
            int i = this.b * 31;
            Class<?> cls = this.c;
            return i + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.b + "array=" + this.c + MessageFormatter.DELIM_STOP;
        }
    }

    /* compiled from: LruArrayPool.java */
    public static final class b extends bj<a> {
        @Override // dc.bj
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        public a e(int i, Class<?> cls) {
            a aVarB = b();
            aVarB.b(i, cls);
            return aVarB;
        }
    }

    public hj(int i) {
        this.e = i;
    }

    @Override // dc.zi
    public synchronized void a(int i) {
        try {
            if (i >= 40) {
                b();
            } else if (i >= 20 || i == 15) {
                h(this.e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // dc.zi
    public synchronized void b() {
        h(0);
    }

    @Override // dc.zi
    public synchronized <T> T c(int i, Class<T> cls) {
        Integer numCeilingKey;
        numCeilingKey = m(cls).ceilingKey(Integer.valueOf(i));
        return (T) l(p(i, numCeilingKey) ? this.b.e(numCeilingKey.intValue(), cls) : this.b.e(i, cls), cls);
    }

    @Override // dc.zi
    public synchronized <T> T d(int i, Class<T> cls) {
        return (T) l(this.b.e(i, cls), cls);
    }

    @Override // dc.zi
    @Deprecated
    public <T> void e(T t, Class<T> cls) {
        put(t);
    }

    public final void f(int i, Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMapM = m(cls);
        Integer num = (Integer) navigableMapM.get(Integer.valueOf(i));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapM.remove(Integer.valueOf(i));
                return;
            } else {
                navigableMapM.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
    }

    public final void g() {
        h(this.e);
    }

    public final void h(int i) {
        while (this.f > i) {
            Object objF = this.a.f();
            vp.d(objF);
            yi yiVarI = i(objF);
            this.f -= yiVarI.b(objF) * yiVarI.a();
            f(yiVarI.b(objF), objF.getClass());
            if (Log.isLoggable(yiVarI.getTag(), 2)) {
                yiVarI.getTag();
                String str = "evicted: " + yiVarI.b(objF);
            }
        }
    }

    public final <T> yi<T> i(T t) {
        return j(t.getClass());
    }

    public final <T> yi<T> j(Class<T> cls) {
        yi<T> ejVar = (yi) this.d.get(cls);
        if (ejVar == null) {
            if (cls.equals(int[].class)) {
                ejVar = new gj();
            } else {
                if (!cls.equals(byte[].class)) {
                    throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
                }
                ejVar = new ej();
            }
            this.d.put(cls, ejVar);
        }
        return ejVar;
    }

    @Nullable
    public final <T> T k(a aVar) {
        return (T) this.a.a(aVar);
    }

    public final <T> T l(a aVar, Class<T> cls) {
        yi<T> yiVarJ = j(cls);
        T t = (T) k(aVar);
        if (t != null) {
            this.f -= yiVarJ.b(t) * yiVarJ.a();
            f(yiVarJ.b(t), cls);
        }
        if (t != null) {
            return t;
        }
        if (Log.isLoggable(yiVarJ.getTag(), 2)) {
            yiVarJ.getTag();
            String str = "Allocated " + aVar.b + " bytes";
        }
        return yiVarJ.newArray(aVar.b);
    }

    public final NavigableMap<Integer, Integer> m(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.c.put(cls, treeMap);
        return treeMap;
    }

    public final boolean n() {
        int i = this.f;
        return i == 0 || this.e / i >= 2;
    }

    public final boolean o(int i) {
        return i <= this.e / 2;
    }

    public final boolean p(int i, Integer num) {
        return num != null && (n() || num.intValue() <= i * 8);
    }

    @Override // dc.zi
    public synchronized <T> void put(T t) {
        Class<?> cls = t.getClass();
        yi<T> yiVarJ = j(cls);
        int iB = yiVarJ.b(t);
        int iA = yiVarJ.a() * iB;
        if (o(iA)) {
            a aVarE = this.b.e(iB, cls);
            this.a.d(aVarE, t);
            NavigableMap<Integer, Integer> navigableMapM = m(cls);
            Integer num = (Integer) navigableMapM.get(Integer.valueOf(aVarE.b));
            Integer numValueOf = Integer.valueOf(aVarE.b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapM.put(numValueOf, Integer.valueOf(iIntValue));
            this.f += iA;
            g();
        }
    }
}
