package org.jxmpp.util.cache;

/* loaded from: classes5.dex */
public interface Cache<K, V> {
    V get(Object obj);

    int getMaxCacheSize();

    V put(K k, V v);

    void setMaxCacheSize(int i);
}
