package dc;

import androidx.annotation.NonNull;

/* compiled from: CacheMemoryStaticUtils.java */
/* loaded from: classes.dex */
public final class kd0 {
    public static ld0 a;

    public static ld0 a() {
        ld0 ld0Var = a;
        return ld0Var != null ? ld0Var : ld0.a();
    }

    public static void b(@NonNull String str, Object obj) {
        c(str, obj, a());
    }

    public static void c(@NonNull String str, Object obj, @NonNull ld0 ld0Var) {
        ld0Var.d(str, obj);
    }

    public static Object d(@NonNull String str) {
        return e(str, a());
    }

    public static Object e(@NonNull String str, @NonNull ld0 ld0Var) {
        return ld0Var.f(str);
    }
}
