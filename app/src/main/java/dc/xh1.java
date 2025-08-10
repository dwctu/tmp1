package dc;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ALog.kt */
/* loaded from: classes3.dex */
public final class xh1 {
    public static boolean a;

    @Nullable
    public static ai1 b;
    public static final xh1 c = new xh1();

    public final void a(@NotNull String tag, @NotNull String msg) {
        ai1 ai1Var;
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        if (!a || (ai1Var = b) == null) {
            return;
        }
        ai1Var.b(tag, msg);
    }

    public final void b(@NotNull String tag, @NotNull String msg) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        ai1 ai1Var = b;
        if (ai1Var != null) {
            ai1Var.a(tag, msg);
        }
    }

    public final void c(@NotNull String tag, @NotNull String msg, @NotNull Throwable tr) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        Intrinsics.checkParameterIsNotNull(tr, "tr");
        ai1 ai1Var = b;
        if (ai1Var != null) {
            ai1Var.c(tag, msg, tr);
        }
    }

    public final void d(@NotNull String tag, @NotNull String msg) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        ai1 ai1Var = b;
        if (ai1Var != null) {
            ai1Var.d(tag, msg);
        }
    }
}
