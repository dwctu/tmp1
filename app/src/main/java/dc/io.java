package dc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ResourceEncoderRegistry.java */
/* loaded from: classes.dex */
public class io {
    public final List<a<?>> a = new ArrayList();

    /* compiled from: ResourceEncoderRegistry.java */
    public static final class a<T> {
        public final Class<T> a;
        public final dh<T> b;

        public a(@NonNull Class<T> cls, @NonNull dh<T> dhVar) {
            this.a = cls;
            this.b = dhVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(@NonNull Class<Z> cls, @NonNull dh<Z> dhVar) {
        this.a.add(new a<>(cls, dhVar));
    }

    @Nullable
    public synchronized <Z> dh<Z> b(@NonNull Class<Z> cls) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            a<?> aVar = this.a.get(i);
            if (aVar.a(cls)) {
                return (dh<Z>) aVar.b;
            }
        }
        return null;
    }

    public synchronized <Z> void c(@NonNull Class<Z> cls, @NonNull dh<Z> dhVar) {
        this.a.add(0, new a<>(cls, dhVar));
    }
}
