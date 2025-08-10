package dc;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineContext.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0014J\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bR\"\u0010\b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/UndispatchedCoroutine;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/ScopeCoroutine;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "threadStateToRecover", "Ljava/lang/ThreadLocal;", "Lkotlin/Pair;", "", "afterResume", "", "state", "clearThreadContext", "", "saveThreadContext", "oldValue", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class i24<T> extends r64<T> {

    @NotNull
    public ThreadLocal<Pair<CoroutineContext, Object>> d;

    /* JADX WARN: Illegal instructions before constructor call */
    public i24(@NotNull CoroutineContext coroutineContext, @NotNull Continuation<? super T> continuation) {
        j24 j24Var = j24.a;
        super(coroutineContext.get(j24Var) == null ? coroutineContext.plus(j24Var) : coroutineContext, continuation);
        this.d = new ThreadLocal<>();
    }

    @Override // dc.r64, dc.ly3
    public void K0(@Nullable Object obj) {
        Pair<CoroutineContext, Object> pair = this.d.get();
        if (pair != null) {
            x64.a(pair.component1(), pair.component2());
            this.d.set(null);
        }
        Object objA = mz3.a(obj, this.c);
        Continuation<T> continuation = this.c;
        CoroutineContext b = continuation.getB();
        Object objC = x64.c(b, null);
        i24<?> i24VarG = objC != x64.a ? pz3.g(continuation, b, objC) : null;
        try {
            this.c.resumeWith(objA);
            Unit unit = Unit.INSTANCE;
        } finally {
            if (i24VarG == null || i24VarG.P0()) {
                x64.a(b, objC);
            }
        }
    }

    public final boolean P0() {
        if (this.d.get() == null) {
            return false;
        }
        this.d.set(null);
        return true;
    }

    public final void Q0(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        this.d.set(TuplesKt.to(coroutineContext, obj));
    }
}
