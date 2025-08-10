package org.jivesoftware.smack.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public class MultiMap<K, V> {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DEFAULT_MAP_SIZE = 6;
    private static final int ENTRY_SET_SIZE = 3;
    private final Map<K, Set<V>> map;

    public static class SimpleMapEntry<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;

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

        private SimpleMapEntry(K k, V v) {
            this.key = k;
            this.value = v;
        }
    }

    public MultiMap() {
        this(6);
    }

    public void clear() {
        this.map.clear();
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        Iterator<Set<V>> it = this.map.values().iterator();
        while (it.hasNext()) {
            if (it.next().contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(size());
        for (Map.Entry<K, Set<V>> entry : this.map.entrySet()) {
            K key = entry.getKey();
            Iterator<V> it = entry.getValue().iterator();
            while (it.hasNext()) {
                linkedHashSet.add(new SimpleMapEntry(key, it.next()));
            }
        }
        return linkedHashSet;
    }

    public Set<V> getAll(Object obj) {
        Set<V> set = this.map.get(obj);
        return set == null ? Collections.emptySet() : set;
    }

    public V getFirst(Object obj) {
        Set<V> all = getAll(obj);
        if (all.isEmpty()) {
            return null;
        }
        return all.iterator().next();
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public Set<K> keySet() {
        return this.map.keySet();
    }

    public boolean put(K k, V v) {
        Set<V> set = this.map.get(k);
        if (set != null) {
            set.add(v);
            return true;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(3);
        linkedHashSet.add(v);
        this.map.put(k, linkedHashSet);
        return false;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public V remove(Object obj) {
        Set<V> setRemove = this.map.remove(obj);
        if (setRemove == null) {
            return null;
        }
        return setRemove.iterator().next();
    }

    public boolean removeOne(Object obj, V v) {
        Set<V> set = this.map.get(obj);
        if (set == null) {
            return false;
        }
        boolean zRemove = set.remove(v);
        if (set.isEmpty()) {
            this.map.remove(obj);
        }
        return zRemove;
    }

    public int size() {
        Iterator<Set<V>> it = this.map.values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += it.next().size();
        }
        return size;
    }

    public List<V> values() {
        ArrayList arrayList = new ArrayList(size());
        Iterator<Set<V>> it = this.map.values().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next());
        }
        return arrayList;
    }

    public MultiMap(int i) {
        this.map = new LinkedHashMap(i);
    }
}
