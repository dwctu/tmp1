package dc;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"kotlinx/coroutines/flow/FlowKt__BuildersKt", "kotlinx/coroutines/flow/FlowKt__ChannelsKt", "kotlinx/coroutines/flow/FlowKt__CollectKt", "kotlinx/coroutines/flow/FlowKt__CollectionKt", "kotlinx/coroutines/flow/FlowKt__ContextKt", "kotlinx/coroutines/flow/FlowKt__CountKt", "kotlinx/coroutines/flow/FlowKt__DelayKt", "kotlinx/coroutines/flow/FlowKt__DistinctKt", "kotlinx/coroutines/flow/FlowKt__EmittersKt", "kotlinx/coroutines/flow/FlowKt__ErrorsKt", "kotlinx/coroutines/flow/FlowKt__LimitKt", "kotlinx/coroutines/flow/FlowKt__MergeKt", "kotlinx/coroutines/flow/FlowKt__MigrationKt", "kotlinx/coroutines/flow/FlowKt__ReduceKt", "kotlinx/coroutines/flow/FlowKt__ShareKt", "kotlinx/coroutines/flow/FlowKt__TransformKt", "kotlinx/coroutines/flow/FlowKt__ZipKt"}, k = 4, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class v34 {
    @NotNull
    public static final <T> k44<T> a(@NotNull f44<T> f44Var) {
        return d44.a(f44Var);
    }

    @NotNull
    public static final <T> o44<T> b(@NotNull g44<T> g44Var) {
        return d44.b(g44Var);
    }

    @NotNull
    public static final <T> t34<T> c(@NotNull t34<? extends T> t34Var, int i, @NotNull s24 s24Var) {
        return z34.a(t34Var, i, s24Var);
    }

    @NotNull
    public static final <T> t34<T> e(@BuilderInference @NotNull Function2<? super f34<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return w34.a(function2);
    }

    @Nullable
    public static final Object f(@NotNull t34<?> t34Var, @NotNull Continuation<? super Unit> continuation) {
        return y34.a(t34Var, continuation);
    }

    @Nullable
    public static final <T> Object g(@NotNull t34<? extends T> t34Var, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull Continuation<? super Unit> continuation) {
        return y34.b(t34Var, function2, continuation);
    }

    @NotNull
    public static final <T> t34<T> h(@NotNull t34<? extends T> t34Var) {
        return a44.a(t34Var);
    }

    @Nullable
    public static final <T> Object i(@NotNull u34<? super T> u34Var, @NotNull h34<? extends T> h34Var, @NotNull Continuation<? super Unit> continuation) {
        return x34.b(u34Var, h34Var, continuation);
    }

    public static final void j(@NotNull u34<?> u34Var) {
        b44.b(u34Var);
    }

    @NotNull
    public static final <T> t34<T> k(@BuilderInference @NotNull Function2<? super u34<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return w34.b(function2);
    }

    @NotNull
    public static final <T> t34<T> l(T t) {
        return w34.c(t);
    }

    @NotNull
    public static final <T> t34<T> m(@NotNull t34<? extends T> t34Var, @NotNull CoroutineContext coroutineContext) {
        return z34.d(t34Var, coroutineContext);
    }

    @NotNull
    public static final <T> h14 n(@NotNull t34<? extends T> t34Var, @NotNull wz3 wz3Var) {
        return y34.c(t34Var, wz3Var);
    }

    @NotNull
    public static final <T, R> t34<R> o(@NotNull t34<? extends T> t34Var, @BuilderInference @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return c44.a(t34Var, function2);
    }

    @NotNull
    public static final <T> t34<T> p(@NotNull t34<? extends T> t34Var, @NotNull Function3<? super u34<? super T>, ? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return b44.d(t34Var, function3);
    }

    @NotNull
    public static final <T> t34<T> q(@NotNull t34<? extends T> t34Var, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return e44.a(t34Var, function2);
    }

    @NotNull
    public static final <T> t34<T> r(@NotNull t34<? extends T> t34Var, @NotNull Function2<? super u34<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return b44.e(t34Var, function2);
    }

    @NotNull
    public static final <T> t34<T> s(@NotNull h34<? extends T> h34Var) {
        return x34.d(h34Var);
    }

    @NotNull
    public static final <T, R> t34<R> t(@NotNull t34<? extends T> t34Var, @BuilderInference @NotNull Function3<? super u34<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3) {
        return c44.b(t34Var, function3);
    }
}
