package dc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ModelLoaderRegistry.java */
/* loaded from: classes.dex */
public class nk {
    public final pk a;
    public final a b;

    /* compiled from: ModelLoaderRegistry.java */
    public static class a {
        public final Map<Class<?>, C0203a<?>> a = new HashMap();

        /* compiled from: ModelLoaderRegistry.java */
        /* renamed from: dc.nk$a$a, reason: collision with other inner class name */
        public static class C0203a<Model> {
            public final List<lk<Model, ?>> a;

            public C0203a(List<lk<Model, ?>> list) {
                this.a = list;
            }
        }

        public void a() {
            this.a.clear();
        }

        @Nullable
        public <Model> List<lk<Model, ?>> b(Class<Model> cls) {
            C0203a<?> c0203a = this.a.get(cls);
            if (c0203a == null) {
                return null;
            }
            return (List<lk<Model, ?>>) c0203a.a;
        }

        public <Model> void c(Class<Model> cls, List<lk<Model, ?>> list) {
            if (this.a.put(cls, new C0203a<>(list)) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }
    }

    public nk(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(new pk(pool));
    }

    @NonNull
    public static <A> Class<A> b(@NonNull A a2) {
        return (Class<A>) a2.getClass();
    }

    public synchronized <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull mk<? extends Model, ? extends Data> mkVar) {
        this.a.b(cls, cls2, mkVar);
        this.b.a();
    }

    @NonNull
    public synchronized List<Class<?>> c(@NonNull Class<?> cls) {
        return this.a.g(cls);
    }

    @NonNull
    public <A> List<lk<A, ?>> d(@NonNull A a2) {
        List<lk<A, ?>> listE = e(b(a2));
        if (listE.isEmpty()) {
            throw new Registry.NoModelLoaderAvailableException(a2);
        }
        int size = listE.size();
        List<lk<A, ?>> listEmptyList = Collections.emptyList();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            lk<A, ?> lkVar = listE.get(i);
            if (lkVar.a(a2)) {
                if (z) {
                    listEmptyList = new ArrayList<>(size - i);
                    z = false;
                }
                listEmptyList.add(lkVar);
            }
        }
        if (listEmptyList.isEmpty()) {
            throw new Registry.NoModelLoaderAvailableException(a2, listE);
        }
        return listEmptyList;
    }

    @NonNull
    public final synchronized <A> List<lk<A, ?>> e(@NonNull Class<A> cls) {
        List<lk<A, ?>> listB;
        listB = this.b.b(cls);
        if (listB == null) {
            listB = Collections.unmodifiableList(this.a.e(cls));
            this.b.c(cls, listB);
        }
        return listB;
    }

    public nk(@NonNull pk pkVar) {
        this.b = new a();
        this.a = pkVar;
    }
}
