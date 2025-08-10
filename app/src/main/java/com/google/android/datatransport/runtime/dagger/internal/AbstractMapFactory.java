package com.google.android.datatransport.runtime.dagger.internal;

import dc.ox3;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class AbstractMapFactory<K, V, V2> implements Factory<Map<K, V2>> {
    private final Map<K, ox3<V>> contributingMap;

    public static abstract class Builder<K, V, V2> {
        public final LinkedHashMap<K, ox3<V>> map;

        public Builder(int i) {
            this.map = DaggerCollections.newLinkedHashMapWithExpectedSize(i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder<K, V, V2> put(K k, ox3<V> ox3Var) {
            this.map.put(Preconditions.checkNotNull(k, "key"), Preconditions.checkNotNull(ox3Var, "provider"));
            return this;
        }

        public Builder<K, V, V2> putAll(ox3<Map<K, V2>> ox3Var) {
            if (ox3Var instanceof DelegateFactory) {
                return putAll(((DelegateFactory) ox3Var).getDelegate());
            }
            this.map.putAll(((AbstractMapFactory) ox3Var).contributingMap);
            return this;
        }
    }

    public AbstractMapFactory(Map<K, ox3<V>> map) {
        this.contributingMap = Collections.unmodifiableMap(map);
    }

    public final Map<K, ox3<V>> contributingMap() {
        return this.contributingMap;
    }

    @Override // com.google.android.datatransport.runtime.dagger.internal.Factory, dc.ox3
    public abstract /* synthetic */ T get();
}
