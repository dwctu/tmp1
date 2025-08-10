package dc;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"kotlinx/coroutines/JobKt__FutureKt", "kotlinx/coroutines/JobKt__JobKt"}, k = 4, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class k14 {
    @NotNull
    public static final hz3 a(@Nullable h14 h14Var) {
        return m14.a(h14Var);
    }

    public static final void c(@NotNull CoroutineContext coroutineContext, @Nullable CancellationException cancellationException) {
        m14.c(coroutineContext, cancellationException);
    }

    public static final void e(@NotNull yy3<?> yy3Var, @NotNull Future<?> future) {
        l14.a(yy3Var, future);
    }

    public static final void f(@NotNull CoroutineContext coroutineContext) {
        m14.e(coroutineContext);
    }

    public static final void g(@NotNull h14 h14Var) {
        m14.f(h14Var);
    }
}
