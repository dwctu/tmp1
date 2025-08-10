package dc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: LruCache.java */
/* loaded from: classes.dex */
public class sp<T, Y> {
    public final Map<T, Y> a = new LinkedHashMap(100, 0.75f, true);
    public long b;
    public long c;

    public sp(long j) {
        this.b = j;
    }

    public void b() {
        m(0L);
    }

    public final void f() {
        m(this.b);
    }

    @Nullable
    public synchronized Y g(@NonNull T t) {
        return this.a.get(t);
    }

    public synchronized long h() {
        return this.b;
    }

    public int i(@Nullable Y y) {
        return 1;
    }

    public void j(@NonNull T t, @Nullable Y y) {
    }

    @Nullable
    public synchronized Y k(@NonNull T t, @Nullable Y y) {
        long jI = i(y);
        if (jI >= this.b) {
            j(t, y);
            return null;
        }
        if (y != null) {
            this.c += jI;
        }
        Y yPut = this.a.put(t, y);
        if (yPut != null) {
            this.c -= i(yPut);
            if (!yPut.equals(y)) {
                j(t, yPut);
            }
        }
        f();
        return yPut;
    }

    @Nullable
    public synchronized Y l(@NonNull T t) {
        Y yRemove;
        yRemove = this.a.remove(t);
        if (yRemove != null) {
            this.c -= i(yRemove);
        }
        return yRemove;
    }

    public synchronized void m(long j) {
        while (this.c > j) {
            Iterator<Map.Entry<T, Y>> it = this.a.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.c -= i(value);
            T key = next.getKey();
            it.remove();
            j(key, value);
        }
    }
}
