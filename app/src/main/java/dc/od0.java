package dc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* compiled from: CollectionUtils.java */
/* loaded from: classes.dex */
public final class od0 {
    public static Collection a(Collection collection, Collection collection2) {
        if (collection == null && collection2 == null) {
            return new ArrayList();
        }
        if (collection == null) {
            return new ArrayList(collection2);
        }
        if (collection2 == null) {
            return new ArrayList(collection);
        }
        ArrayList arrayList = new ArrayList();
        Map<Object, Integer> mapB = b(collection);
        Map<Object, Integer> mapB2 = b(collection2);
        HashSet hashSet = new HashSet(collection);
        hashSet.addAll(collection2);
        for (Object obj : hashSet) {
            int iMax = Math.max(c(obj, mapB), c(obj, mapB2)) - Math.min(c(obj, mapB), c(obj, mapB2));
            for (int i = 0; i < iMax; i++) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static Map<Object, Integer> b(Collection collection) {
        HashMap map = new HashMap();
        if (collection == null) {
            return map;
        }
        for (Object obj : collection) {
            Integer num = (Integer) map.get(obj);
            if (num == null) {
                map.put(obj, 1);
            } else {
                map.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
        return map;
    }

    public static int c(Object obj, Map map) {
        Integer num = (Integer) map.get(obj);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
