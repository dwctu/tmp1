package org.jxmpp.util.cache;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes5.dex */
public class LruCache<K, V> extends LinkedHashMap<K, V> implements Cache<K, V> {
    private static final int DEFAULT_INITIAL_SIZE = 50;
    private static final long serialVersionUID = -4980809402073634607L;
    private final AtomicLong cacheHits;
    private final AtomicLong cacheMisses;
    private int maxCacheSize;

    public LruCache(int i) {
        super(i < 50 ? i : 50, 0.75f, true);
        this.cacheHits = new AtomicLong();
        this.cacheMisses = new AtomicLong();
        if (i == 0) {
            throw new IllegalArgumentException("Max cache size cannot be 0.");
        }
        this.maxCacheSize = i;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        synchronized (this) {
            super.clear();
        }
        this.cacheHits.set(0L);
        this.cacheMisses.set(0L);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final synchronized boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final synchronized boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final synchronized Set<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map, org.jxmpp.util.cache.Cache
    public final V get(Object obj) {
        V v;
        synchronized (this) {
            v = (V) super.get(obj);
        }
        if (v == null) {
            this.cacheMisses.incrementAndGet();
            return null;
        }
        this.cacheHits.incrementAndGet();
        return v;
    }

    public final long getCacheHits() {
        return this.cacheHits.longValue();
    }

    public final long getCacheMisses() {
        return this.cacheMisses.longValue();
    }

    @Override // org.jxmpp.util.cache.Cache
    public final int getMaxCacheSize() {
        return this.maxCacheSize;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final synchronized boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final synchronized Set<K> keySet() {
        return super.keySet();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map, org.jxmpp.util.cache.Cache
    public final synchronized V put(K k, V v) {
        return (V) super.put(k, v);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final synchronized void putAll(Map<? extends K, ? extends V> map) {
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final synchronized V remove(Object obj) {
        return (V) super.remove(obj);
    }

    @Override // java.util.LinkedHashMap
    public final boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return size() > this.maxCacheSize;
    }

    @Override // org.jxmpp.util.cache.Cache
    public final void setMaxCacheSize(int i) {
        this.maxCacheSize = i;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final synchronized int size() {
        return super.size();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final synchronized Collection<V> values() {
        return super.values();
    }
}
