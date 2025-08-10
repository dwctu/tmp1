package dc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: EncoderRegistry.java */
/* renamed from: dc.do, reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo {
    public final List<a<?>> a = new ArrayList();

    /* compiled from: EncoderRegistry.java */
    /* renamed from: dc.do$a */
    public static final class a<T> {
        public final Class<T> a;
        public final vg<T> b;

        public a(@NonNull Class<T> cls, @NonNull vg<T> vgVar) {
            this.a = cls;
            this.b = vgVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.a.isAssignableFrom(cls);
        }
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull vg<T> vgVar) {
        this.a.add(new a<>(cls, vgVar));
    }

    @Nullable
    public synchronized <T> vg<T> b(@NonNull Class<T> cls) {
        for (a<?> aVar : this.a) {
            if (aVar.a(cls)) {
                return (vg<T>) aVar.b;
            }
        }
        return null;
    }
}
