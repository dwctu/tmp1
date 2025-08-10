package org.jxmpp.util.cache;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public class ExpirationCache<K, V> implements Cache<K, V>, Map<K, V> {
    private final LruCache<K, ExpireElement<V>> cache;
    private long defaultExpirationTime;

    public static class EntryImpl<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;

        public EntryImpl(K k, V v) {
            this.key = k;
            this.value = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.value;
            this.value = v;
            return v2;
        }
    }

    public static class ExpireElement<V> {
        public final V element;
        public final long expirationTimestamp;

        public ExpireElement(V v, long j) {
            this.element = v;
            this.expirationTimestamp = System.currentTimeMillis() + j;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ExpireElement) {
                return this.element.equals(((ExpireElement) obj).element);
            }
            return false;
        }

        public int hashCode() {
            return this.element.hashCode();
        }

        public boolean isExpired() {
            return System.currentTimeMillis() > this.expirationTimestamp;
        }
    }

    public ExpirationCache(int i, long j) {
        this.cache = new LruCache<>(i);
        setDefaultExpirationTime(j);
    }

    @Override // java.util.Map
    public void clear() {
        this.cache.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.cache.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.cache.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        HashSet hashSet = new HashSet();
        for (Map.Entry<K, ExpireElement<V>> entry : this.cache.entrySet()) {
            hashSet.add(new EntryImpl(entry.getKey(), entry.getValue().element));
        }
        return hashSet;
    }

    @Override // org.jxmpp.util.cache.Cache, java.util.Map
    public V get(Object obj) {
        ExpireElement<V> expireElement = this.cache.get(obj);
        if (expireElement == null) {
            return null;
        }
        if (!expireElement.isExpired()) {
            return expireElement.element;
        }
        remove(obj);
        return null;
    }

    @Override // org.jxmpp.util.cache.Cache
    public int getMaxCacheSize() {
        return this.cache.getMaxCacheSize();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.cache.isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return this.cache.keySet();
    }

    @Override // org.jxmpp.util.cache.Cache, java.util.Map
    public V put(K k, V v) {
        return put(k, v, this.defaultExpirationTime);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        ExpireElement<V> expireElementRemove = this.cache.remove(obj);
        if (expireElementRemove == null) {
            return null;
        }
        return expireElementRemove.element;
    }

    public void setDefaultExpirationTime(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException();
        }
        this.defaultExpirationTime = j;
    }

    @Override // org.jxmpp.util.cache.Cache
    public void setMaxCacheSize(int i) {
        this.cache.setMaxCacheSize(i);
    }

    @Override // java.util.Map
    public int size() {
        return this.cache.size();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        HashSet hashSet = new HashSet();
        Iterator<ExpireElement<V>> it = this.cache.values().iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().element);
        }
        return hashSet;
    }

    public V put(K k, V v, long j) {
        ExpireElement<V> expireElementPut = this.cache.put(k, new ExpireElement<>(v, j));
        if (expireElementPut == null) {
            return null;
        }
        return expireElementPut.element;
    }
}
