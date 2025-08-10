package dc;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"kotlinx/coroutines/BuildersKt__BuildersKt", "kotlinx/coroutines/BuildersKt__Builders_commonKt"}, k = 4, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class sy3 {
    @NotNull
    public static final <T> e04<T> a(@NotNull wz3 wz3Var, @NotNull CoroutineContext coroutineContext, @NotNull yz3 yz3Var, @NotNull Function2<? super wz3, ? super Continuation<? super T>, ? extends Object> function2) {
        return uy3.a(wz3Var, coroutineContext, yz3Var, function2);
    }

    @NotNull
    public static final h14 c(@NotNull wz3 wz3Var, @NotNull CoroutineContext coroutineContext, @NotNull yz3 yz3Var, @NotNull Function2<? super wz3, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return uy3.c(wz3Var, coroutineContext, yz3Var, function2);
    }

    public static final <T> T e(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super wz3, ? super Continuation<? super T>, ? extends Object> function2) throws InterruptedException {
        return (T) ty3.a(coroutineContext, function2);
    }

    @Nullable
    public static final <T> Object g(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super wz3, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return uy3.e(coroutineContext, function2, continuation);
    }
}
