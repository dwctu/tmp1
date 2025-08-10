package dc;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IAnimListener.kt */
/* loaded from: classes3.dex */
public interface dh1 {

    /* compiled from: IAnimListener.kt */
    public static final class a {
        public static boolean a(dh1 dh1Var, @NotNull ng1 config) {
            Intrinsics.checkParameterIsNotNull(config, "config");
            return true;
        }
    }

    void a();

    void b();

    void c(int i, @Nullable String str);

    void d();

    void e(int i, @Nullable ng1 ng1Var);

    boolean f(@NotNull ng1 ng1Var);
}
