package dc;

import androidx.annotation.NonNull;
import dc.jh;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: DataRewinderRegistry.java */
/* loaded from: classes.dex */
public class kh {
    public static final jh.a<?> b = new a();
    public final Map<Class<?>, jh.a<?>> a = new HashMap();

    /* compiled from: DataRewinderRegistry.java */
    public class a implements jh.a<Object> {
        @Override // dc.jh.a
        @NonNull
        public jh<Object> a(@NonNull Object obj) {
            return new b(obj);
        }

        @Override // dc.jh.a
        @NonNull
        public Class<Object> getDataClass() {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    /* compiled from: DataRewinderRegistry.java */
    public static final class b implements jh<Object> {
        public final Object a;

        public b(@NonNull Object obj) {
            this.a = obj;
        }

        @Override // dc.jh
        public void a() {
        }

        @Override // dc.jh
        @NonNull
        public Object b() {
            return this.a;
        }
    }

    @NonNull
    public synchronized <T> jh<T> a(@NonNull T t) {
        jh.a<?> aVar;
        vp.d(t);
        aVar = this.a.get(t.getClass());
        if (aVar == null) {
            Iterator<jh.a<?>> it = this.a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                jh.a<?> next = it.next();
                if (next.getDataClass().isAssignableFrom(t.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = b;
        }
        return (jh<T>) aVar.a(t);
    }

    public synchronized void b(@NonNull jh.a<?> aVar) {
        this.a.put(aVar.getDataClass(), aVar);
    }
}
