package dc;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: ArrayMap.java */
/* loaded from: classes5.dex */
public class mh4<K, V> extends ph4<K, V> implements Map<K, V> {
    public oh4<K, V> h;

    /* compiled from: ArrayMap.java */
    public class a extends oh4<K, V> {
        public a() {
        }

        @Override // dc.oh4
        public void a() {
            mh4.this.clear();
        }

        @Override // dc.oh4
        public Object b(int i, int i2) {
            return mh4.this.b[(i << 1) + i2];
        }

        @Override // dc.oh4
        public Map<K, V> c() {
            return mh4.this;
        }

        @Override // dc.oh4
        public int d() {
            return mh4.this.c;
        }

        @Override // dc.oh4
        public int e(Object obj) {
            return mh4.this.f(obj);
        }

        @Override // dc.oh4
        public int f(Object obj) {
            return mh4.this.h(obj);
        }

        @Override // dc.oh4
        public void g(K k, V v) {
            mh4.this.put(k, v);
        }

        @Override // dc.oh4
        public void h(int i) {
            mh4.this.j(i);
        }

        @Override // dc.oh4
        public V i(int i, V v) {
            return mh4.this.k(i, v);
        }
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return m().l();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return m().m();
    }

    public final oh4<K, V> m() {
        if (this.h == null) {
            this.h = new a();
        }
        return this.h;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        c(this.c + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return m().n();
    }
}
