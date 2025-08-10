package dc;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Registry;
import dc.kf;
import java.util.List;
import java.util.Map;

/* compiled from: GlideContext.java */
/* loaded from: classes.dex */
public class mf extends ContextWrapper {

    @VisibleForTesting
    public static final sf<?, ?> k = new jf();
    public final zi a;
    public final Registry b;
    public final zo c;
    public final kf.a d;
    public final List<po<Object>> e;
    public final Map<Class<?>, sf<?, ?>> f;
    public final ji g;
    public final boolean h;
    public final int i;

    @Nullable
    @GuardedBy("this")
    public qo j;

    public mf(@NonNull Context context, @NonNull zi ziVar, @NonNull Registry registry, @NonNull zo zoVar, @NonNull kf.a aVar, @NonNull Map<Class<?>, sf<?, ?>> map, @NonNull List<po<Object>> list, @NonNull ji jiVar, boolean z, int i) {
        super(context.getApplicationContext());
        this.a = ziVar;
        this.b = registry;
        this.c = zoVar;
        this.d = aVar;
        this.e = list;
        this.f = map;
        this.g = jiVar;
        this.h = z;
        this.i = i;
    }

    @NonNull
    public <X> dp<ImageView, X> a(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.c.a(imageView, cls);
    }

    @NonNull
    public zi b() {
        return this.a;
    }

    public List<po<Object>> c() {
        return this.e;
    }

    public synchronized qo d() {
        if (this.j == null) {
            this.j = this.d.build().P();
        }
        return this.j;
    }

    @NonNull
    public <T> sf<?, T> e(@NonNull Class<T> cls) {
        sf<?, T> sfVar = (sf) this.f.get(cls);
        if (sfVar == null) {
            for (Map.Entry<Class<?>, sf<?, ?>> entry : this.f.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    sfVar = (sf) entry.getValue();
                }
            }
        }
        return sfVar == null ? (sf<?, T>) k : sfVar;
    }

    @NonNull
    public ji f() {
        return this.g;
    }

    public int g() {
        return this.i;
    }

    @NonNull
    public Registry h() {
        return this.b;
    }

    public boolean i() {
        return this.h;
    }
}
