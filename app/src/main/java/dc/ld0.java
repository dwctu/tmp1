package dc;

import androidx.annotation.NonNull;
import androidx.collection.LruCache;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CacheMemoryUtils.java */
/* loaded from: classes.dex */
public final class ld0 {
    public static final Map<String, ld0> c = new HashMap();
    public final String a;
    public final LruCache<String, a> b;

    /* compiled from: CacheMemoryUtils.java */
    public static final class a {
        public Object a;

        public a(long j, Object obj) {
            this.a = obj;
        }
    }

    public ld0(String str, LruCache<String, a> lruCache) {
        this.a = str;
        this.b = lruCache;
    }

    public static ld0 a() {
        return b(256);
    }

    public static ld0 b(int i) {
        return c(String.valueOf(i), i);
    }

    public static ld0 c(String str, int i) {
        Map<String, ld0> map = c;
        ld0 ld0Var = map.get(str);
        if (ld0Var == null) {
            synchronized (ld0.class) {
                ld0Var = map.get(str);
                if (ld0Var == null) {
                    ld0Var = new ld0(str, new LruCache(i));
                    map.put(str, ld0Var);
                }
            }
        }
        return ld0Var;
    }

    public void d(@NonNull String str, Object obj) {
        e(str, obj, -1);
    }

    public void e(@NonNull String str, Object obj, int i) {
        if (obj == null) {
            return;
        }
        this.b.put(str, new a(i < 0 ? -1L : System.currentTimeMillis() + (i * 1000), obj));
    }

    public Object f(@NonNull String str) {
        a aVarRemove = this.b.remove(str);
        if (aVarRemove == null) {
            return null;
        }
        return aVarRemove.a;
    }

    public String toString() {
        return this.a + "@" + Integer.toHexString(hashCode());
    }
}
