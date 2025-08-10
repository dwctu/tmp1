package com.koushikdutta.async.util;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap<K, V> map;
    private long maxSize;
    private int missCount;
    private int putCount;
    private long size;

    public LruCache(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = j;
        this.map = new LinkedHashMap<>(0, 0.75f, true);
    }

    private long safeSizeOf(K k, V v) {
        long jSizeOf = sizeOf(k, v);
        if (jSizeOf >= 0) {
            return jSizeOf;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0078, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void trimToSize(long r7) {
        /*
            r6 = this;
        L0:
            monitor-enter(r6)
            long r0 = r6.size     // Catch: java.lang.Throwable -> L79
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L5a
            java.util.LinkedHashMap<K, V> r0 = r6.map     // Catch: java.lang.Throwable -> L79
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L79
            if (r0 == 0) goto L17
            long r0 = r6.size     // Catch: java.lang.Throwable -> L79
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L5a
        L17:
            long r0 = r6.size     // Catch: java.lang.Throwable -> L79
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 <= 0) goto L58
            java.util.LinkedHashMap<K, V> r0 = r6.map     // Catch: java.lang.Throwable -> L79
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L79
            if (r0 == 0) goto L26
            goto L58
        L26:
            java.util.LinkedHashMap<K, V> r0 = r6.map     // Catch: java.lang.Throwable -> L79
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L79
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L79
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L79
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L79
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L79
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L79
            java.util.LinkedHashMap<K, V> r2 = r6.map     // Catch: java.lang.Throwable -> L79
            r2.remove(r1)     // Catch: java.lang.Throwable -> L79
            long r2 = r6.size     // Catch: java.lang.Throwable -> L79
            long r4 = r6.safeSizeOf(r1, r0)     // Catch: java.lang.Throwable -> L79
            long r2 = r2 - r4
            r6.size = r2     // Catch: java.lang.Throwable -> L79
            int r2 = r6.evictionCount     // Catch: java.lang.Throwable -> L79
            r3 = 1
            int r2 = r2 + r3
            r6.evictionCount = r2     // Catch: java.lang.Throwable -> L79
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L79
            r2 = 0
            r6.entryRemoved(r3, r1, r0, r2)
            goto L0
        L58:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L79
            return
        L5a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L79
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L79
            r8.<init>()     // Catch: java.lang.Throwable -> L79
            java.lang.Class r0 = r6.getClass()     // Catch: java.lang.Throwable -> L79
            java.lang.String r0 = r0.getName()     // Catch: java.lang.Throwable -> L79
            r8.append(r0)     // Catch: java.lang.Throwable -> L79
            java.lang.String r0 = ".sizeOf() is reporting inconsistent results!"
            r8.append(r0)     // Catch: java.lang.Throwable -> L79
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L79
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L79
            throw r7     // Catch: java.lang.Throwable -> L79
        L79:
            r7 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L79
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.util.LruCache.trimToSize(long):void");
    }

    public V create(K k) {
        return null;
    }

    public final synchronized int createCount() {
        return this.createCount;
    }

    public void entryRemoved(boolean z, K k, V v, V v2) {
    }

    public final void evictAll() {
        trimToSize(-1L);
    }

    public final synchronized int evictionCount() {
        return this.evictionCount;
    }

    public final V get(K k) {
        V v;
        Objects.requireNonNull(k, "key == null");
        synchronized (this) {
            V v2 = this.map.get(k);
            if (v2 != null) {
                this.hitCount++;
                return v2;
            }
            this.missCount++;
            V vCreate = create(k);
            if (vCreate == null) {
                return null;
            }
            synchronized (this) {
                this.createCount++;
                v = (V) this.map.put(k, vCreate);
                if (v != null) {
                    this.map.put(k, v);
                } else {
                    this.size += safeSizeOf(k, vCreate);
                }
            }
            if (v != null) {
                entryRemoved(false, k, vCreate, v);
                return v;
            }
            trimToSize(this.maxSize);
            return vCreate;
        }
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final synchronized long maxSize() {
        return this.maxSize;
    }

    public final synchronized int missCount() {
        return this.missCount;
    }

    public final V put(K k, V v) {
        V vPut;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.putCount++;
            this.size += safeSizeOf(k, v);
            vPut = this.map.put(k, v);
            if (vPut != null) {
                this.size -= safeSizeOf(k, vPut);
            }
        }
        if (vPut != null) {
            entryRemoved(false, k, vPut, v);
        }
        trimToSize(this.maxSize);
        return vPut;
    }

    public final synchronized int putCount() {
        return this.putCount;
    }

    public final V remove(K k) {
        V vRemove;
        Objects.requireNonNull(k, "key == null");
        synchronized (this) {
            vRemove = this.map.remove(k);
            if (vRemove != null) {
                this.size -= safeSizeOf(k, vRemove);
            }
        }
        if (vRemove != null) {
            entryRemoved(false, k, vRemove, null);
        }
        return vRemove;
    }

    public void setMaxSize(long j) {
        this.maxSize = j;
    }

    public final synchronized long size() {
        return this.size;
    }

    public long sizeOf(K k, V v) {
        return 1L;
    }

    public final synchronized Map<K, V> snapshot() {
        return new LinkedHashMap(this.map);
    }

    public final synchronized String toString() {
        int i;
        int i2;
        i = this.hitCount;
        i2 = this.missCount + i;
        return String.format(Locale.ENGLISH, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Long.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }
}
