package dc;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FactoryPools.java */
/* loaded from: classes.dex */
public final class xp {
    public static final g<Object> a = new a();

    /* compiled from: FactoryPools.java */
    public class a implements g<Object> {
        @Override // dc.xp.g
        public void a(@NonNull Object obj) {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FactoryPools.java */
    public class b<T> implements d<List<T>> {
        @Override // dc.xp.d
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public List<T> a() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FactoryPools.java */
    public class c<T> implements g<List<T>> {
        @Override // dc.xp.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NonNull List<T> list) {
            list.clear();
        }
    }

    /* compiled from: FactoryPools.java */
    public interface d<T> {
        T a();
    }

    /* compiled from: FactoryPools.java */
    public static final class e<T> implements Pools.Pool<T> {
        public final d<T> a;
        public final g<T> b;
        public final Pools.Pool<T> c;

        public e(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar, @NonNull g<T> gVar) {
            this.c = pool;
            this.a = dVar;
            this.b = gVar;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T tAcquire = this.c.acquire();
            if (tAcquire == null) {
                tAcquire = this.a.a();
                if (Log.isLoggable("FactoryPools", 2)) {
                    String str = "Created new " + tAcquire.getClass();
                }
            }
            if (tAcquire instanceof f) {
                tAcquire.d().b(false);
            }
            return (T) tAcquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t) {
            if (t instanceof f) {
                ((f) t).d().b(true);
            }
            this.b.a(t);
            return this.c.release(t);
        }
    }

    /* compiled from: FactoryPools.java */
    public interface f {
        @NonNull
        zp d();
    }

    /* compiled from: FactoryPools.java */
    public interface g<T> {
        void a(@NonNull T t);
    }

    @NonNull
    public static <T extends f> Pools.Pool<T> a(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar) {
        return b(pool, dVar, c());
    }

    @NonNull
    public static <T> Pools.Pool<T> b(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar, @NonNull g<T> gVar) {
        return new e(pool, dVar, gVar);
    }

    @NonNull
    public static <T> g<T> c() {
        return (g<T>) a;
    }

    @NonNull
    public static <T extends f> Pools.Pool<T> d(int i, @NonNull d<T> dVar) {
        return a(new Pools.SynchronizedPool(i), dVar);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> e() {
        return f(20);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> f(int i) {
        return b(new Pools.SynchronizedPool(i), new b(), new c());
    }
}
