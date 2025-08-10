package dc;

import java.util.TreeMap;

/* compiled from: UniqueKeyTreeMap.java */
/* loaded from: classes.dex */
public class md<K, V> extends TreeMap<K, V> {
    private String tipText;

    public md(String str) {
        this.tipText = str;
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (containsKey(k)) {
            throw new RuntimeException(String.format(this.tipText, k));
        }
        return (V) super.put(k, v);
    }
}
