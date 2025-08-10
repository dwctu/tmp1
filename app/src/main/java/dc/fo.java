package dc;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: LoadPathCache.java */
/* loaded from: classes.dex */
public class fo {
    public static final ri<?, ?, ?> c = new ri<>(Object.class, Object.class, Object.class, Collections.singletonList(new hi(Object.class, Object.class, Object.class, Collections.emptyList(), new hn(), null)), null);
    public final ArrayMap<up, ri<?, ?, ?>> a = new ArrayMap<>();
    public final AtomicReference<up> b = new AtomicReference<>();

    @Nullable
    public <Data, TResource, Transcode> ri<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ri<Data, TResource, Transcode> riVar;
        up upVarB = b(cls, cls2, cls3);
        synchronized (this.a) {
            riVar = (ri) this.a.get(upVarB);
        }
        this.b.set(upVarB);
        return riVar;
    }

    public final up b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        up andSet = this.b.getAndSet(null);
        if (andSet == null) {
            andSet = new up();
        }
        andSet.a(cls, cls2, cls3);
        return andSet;
    }

    public boolean c(@Nullable ri<?, ?, ?> riVar) {
        return c.equals(riVar);
    }

    public void d(Class<?> cls, Class<?> cls2, Class<?> cls3, @Nullable ri<?, ?, ?> riVar) {
        synchronized (this.a) {
            ArrayMap<up, ri<?, ?, ?>> arrayMap = this.a;
            up upVar = new up(cls, cls2, cls3);
            if (riVar == null) {
                riVar = c;
            }
            arrayMap.put(upVar, riVar);
        }
    }
}
