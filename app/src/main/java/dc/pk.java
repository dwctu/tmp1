package dc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import dc.lk;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: MultiModelLoaderFactory.java */
/* loaded from: classes.dex */
public class pk {
    public static final c e = new c();
    public static final lk<Object, Object> f = new a();
    public final List<b<?, ?>> a;
    public final c b;
    public final Set<b<?, ?>> c;
    public final Pools.Pool<List<Throwable>> d;

    /* compiled from: MultiModelLoaderFactory.java */
    public static class a implements lk<Object, Object> {
        @Override // dc.lk
        public boolean a(@NonNull Object obj) {
            return false;
        }

        @Override // dc.lk
        @Nullable
        public lk.a<Object> b(@NonNull Object obj, int i, int i2, @NonNull ah ahVar) {
            return null;
        }
    }

    /* compiled from: MultiModelLoaderFactory.java */
    public static class b<Model, Data> {
        public final Class<Model> a;
        public final Class<Data> b;
        public final mk<? extends Model, ? extends Data> c;

        public b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull mk<? extends Model, ? extends Data> mkVar) {
            this.a = cls;
            this.b = cls2;
            this.c = mkVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.a.isAssignableFrom(cls);
        }

        public boolean b(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return a(cls) && this.b.isAssignableFrom(cls2);
        }
    }

    /* compiled from: MultiModelLoaderFactory.java */
    public static class c {
        @NonNull
        public <Model, Data> ok<Model, Data> a(@NonNull List<lk<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            return new ok<>(list, pool);
        }
    }

    public pk(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, e);
    }

    @NonNull
    public static <Model, Data> lk<Model, Data> f() {
        return (lk<Model, Data>) f;
    }

    public final <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull mk<? extends Model, ? extends Data> mkVar, boolean z) {
        b<?, ?> bVar = new b<>(cls, cls2, mkVar);
        List<b<?, ?>> list = this.a;
        list.add(z ? list.size() : 0, bVar);
    }

    public synchronized <Model, Data> void b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull mk<? extends Model, ? extends Data> mkVar) {
        a(cls, cls2, mkVar, true);
    }

    @NonNull
    public final <Model, Data> lk<Model, Data> c(@NonNull b<?, ?> bVar) {
        Object objB = bVar.c.b(this);
        vp.d(objB);
        return (lk) objB;
    }

    @NonNull
    public synchronized <Model, Data> lk<Model, Data> d(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b<?, ?> bVar : this.a) {
                if (this.c.contains(bVar)) {
                    z = true;
                } else if (bVar.b(cls, cls2)) {
                    this.c.add(bVar);
                    arrayList.add(c(bVar));
                    this.c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.b.a(arrayList, this.d);
            }
            if (arrayList.size() == 1) {
                return (lk) arrayList.get(0);
            }
            if (!z) {
                throw new Registry.NoModelLoaderAvailableException((Class<?>) cls, (Class<?>) cls2);
            }
            return f();
        } catch (Throwable th) {
            this.c.clear();
            throw th;
        }
    }

    @NonNull
    public synchronized <Model> List<lk<Model, ?>> e(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.a) {
                if (!this.c.contains(bVar) && bVar.a(cls)) {
                    this.c.add(bVar);
                    arrayList.add(c(bVar));
                    this.c.remove(bVar);
                }
            }
        } catch (Throwable th) {
            this.c.clear();
            throw th;
        }
        return arrayList;
    }

    @NonNull
    public synchronized List<Class<?>> g(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.a) {
            if (!arrayList.contains(bVar.b) && bVar.a(cls)) {
                arrayList.add(bVar.b);
            }
        }
        return arrayList;
    }

    @VisibleForTesting
    public pk(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull c cVar) {
        this.a = new ArrayList();
        this.c = new HashSet();
        this.d = pool;
        this.b = cVar;
    }
}
