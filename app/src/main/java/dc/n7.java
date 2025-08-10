package dc;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: LottieResult.java */
/* loaded from: classes.dex */
public final class n7<V> {

    @Nullable
    public final V a;

    @Nullable
    public final Throwable b;

    public n7(V v) {
        this.a = v;
        this.b = null;
    }

    @Nullable
    public Throwable a() {
        return this.b;
    }

    @Nullable
    public V b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n7)) {
            return false;
        }
        n7 n7Var = (n7) obj;
        if (b() != null && b().equals(n7Var.b())) {
            return true;
        }
        if (a() == null || n7Var.a() == null) {
            return false;
        }
        return a().toString().equals(a().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }

    public n7(Throwable th) {
        this.b = th;
        this.a = null;
    }
}
