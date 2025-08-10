package kotlin.reflect.jvm.internal.pcollections;

import org.jetbrains.annotations.NotNull;

/* loaded from: classes4.dex */
public final class HashPMap<K, V> {
    private static final HashPMap<Object, Object> EMPTY = new HashPMap<>(IntTreePMap.empty(), 0);
    private final IntTreePMap<ConsPStack<MapEntry<K, V>>> intMap;
    private final int size;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[2];
        objArr[0] = "kotlin/reflect/jvm/internal/pcollections/HashPMap";
        if (i != 1) {
            objArr[1] = "empty";
        } else {
            objArr[1] = "minus";
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", objArr));
    }

    private HashPMap(IntTreePMap<ConsPStack<MapEntry<K, V>>> intTreePMap, int i) {
        this.intMap = intTreePMap;
        this.size = i;
    }

    @NotNull
    public static <K, V> HashPMap<K, V> empty() {
        HashPMap<K, V> hashPMap = (HashPMap<K, V>) EMPTY;
        if (hashPMap == null) {
            $$$reportNull$$$0(0);
        }
        return hashPMap;
    }

    private ConsPStack<MapEntry<K, V>> getEntries(int i) {
        ConsPStack<MapEntry<K, V>> consPStack = this.intMap.get(i);
        return consPStack == null ? ConsPStack.empty() : consPStack;
    }

    private static <K, V> int keyIndexIn(ConsPStack<MapEntry<K, V>> consPStack, Object obj) {
        int i = 0;
        while (consPStack != null && consPStack.size() > 0) {
            if (consPStack.first.key.equals(obj)) {
                return i;
            }
            consPStack = consPStack.rest;
            i++;
        }
        return -1;
    }

    public boolean containsKey(Object obj) {
        return keyIndexIn(getEntries(obj.hashCode()), obj) != -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V get(Object obj) {
        for (ConsPStack entries = getEntries(obj.hashCode()); entries != null && entries.size() > 0; entries = entries.rest) {
            MapEntry mapEntry = (MapEntry) entries.first;
            if (mapEntry.key.equals(obj)) {
                return mapEntry.value;
            }
        }
        return null;
    }

    @NotNull
    public HashPMap<K, V> minus(Object obj) {
        ConsPStack<MapEntry<K, V>> entries = getEntries(obj.hashCode());
        int iKeyIndexIn = keyIndexIn(entries, obj);
        if (iKeyIndexIn == -1) {
            return this;
        }
        ConsPStack<MapEntry<K, V>> consPStackMinus = entries.minus(iKeyIndexIn);
        return consPStackMinus.size() == 0 ? new HashPMap<>(this.intMap.minus(obj.hashCode()), this.size - 1) : new HashPMap<>(this.intMap.plus(obj.hashCode(), consPStackMinus), this.size - 1);
    }

    @NotNull
    public HashPMap<K, V> plus(K k, V v) {
        ConsPStack<MapEntry<K, V>> entries = getEntries(k.hashCode());
        int size = entries.size();
        int iKeyIndexIn = keyIndexIn(entries, k);
        if (iKeyIndexIn != -1) {
            entries = entries.minus(iKeyIndexIn);
        }
        ConsPStack<MapEntry<K, V>> consPStackPlus = entries.plus(new MapEntry<>(k, v));
        return new HashPMap<>(this.intMap.plus(k.hashCode(), consPStackPlus), (this.size - size) + consPStackPlus.size());
    }

    public int size() {
        return this.size;
    }
}
