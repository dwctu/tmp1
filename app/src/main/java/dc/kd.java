package dc;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: LottieValueCallback.java */
/* loaded from: classes.dex */
public class kd<T> {
    public final jd<T> a = new jd<>();

    @Nullable
    public T b;

    public kd(@Nullable T t) {
        this.b = null;
        this.b = t;
    }

    @Nullable
    public T a(jd<T> jdVar) {
        return this.b;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final T b(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        jd<T> jdVar = this.a;
        jdVar.a(f, f2, t, t2, f3, f4, f5);
        return a(jdVar);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void c(@Nullable p8<?, ?> p8Var) {
    }
}
