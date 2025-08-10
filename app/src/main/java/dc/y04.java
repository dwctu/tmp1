package dc;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;

/* compiled from: Executors.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0016J\u001c\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J.\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010#*\u00020$2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006%"}, d2 = {"Lkotlinx/coroutines/ExecutorCoroutineDispatcherImpl;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "executor", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Executor;)V", "getExecutor", "()Ljava/util/concurrent/Executor;", "cancelJobOnRejection", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "Ljava/util/concurrent/RejectedExecutionException;", Close.ELEMENT, "dispatch", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "equals", "", "other", "", "hashCode", "", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "", "scheduleBlock", "Ljava/util/concurrent/ScheduledFuture;", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class y04 extends x04 implements g04 {

    @NotNull
    public final Executor a;

    public y04(@NotNull Executor executor) {
        this.a = executor;
        t54.a(getA());
    }

    @NotNull
    /* renamed from: I, reason: from getter */
    public Executor getA() {
        return this.a;
    }

    public final ScheduledFuture<?> O(ScheduledExecutorService scheduledExecutorService, Runnable runnable, CoroutineContext coroutineContext, long j) {
        try {
            return scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            y(coroutineContext, e);
            return null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor a = getA();
        ExecutorService executorService = a instanceof ExecutorService ? (ExecutorService) a : null;
        if (executorService == null) {
            return;
        }
        executorService.shutdown();
    }

    @Override // dc.qz3
    public void dispatch(@NotNull CoroutineContext context, @NotNull Runnable block) {
        Runnable runnableH;
        try {
            Executor a = getA();
            my3 my3VarA = ny3.a();
            if (my3VarA == null || (runnableH = my3VarA.h(block)) == null) {
                runnableH = block;
            }
            a.execute(runnableH);
        } catch (RejectedExecutionException e) {
            my3 my3VarA2 = ny3.a();
            if (my3VarA2 != null) {
                my3VarA2.e();
            }
            y(context, e);
            n04.b().dispatch(context, block);
        }
    }

    public boolean equals(@Nullable Object other) {
        return (other instanceof y04) && ((y04) other).getA() == getA();
    }

    @Override // dc.g04
    public void f(long j, @NotNull yy3<? super Unit> yy3Var) {
        Executor a = getA();
        ScheduledExecutorService scheduledExecutorService = a instanceof ScheduledExecutorService ? (ScheduledExecutorService) a : null;
        ScheduledFuture<?> scheduledFutureO = scheduledExecutorService != null ? O(scheduledExecutorService, new a24(this, yy3Var), yy3Var.getB(), j) : null;
        if (scheduledFutureO != null) {
            k14.e(yy3Var, scheduledFutureO);
        } else {
            c04.f.f(j, yy3Var);
        }
    }

    public int hashCode() {
        return System.identityHashCode(getA());
    }

    @Override // dc.qz3
    @NotNull
    public String toString() {
        return getA().toString();
    }

    public final void y(CoroutineContext coroutineContext, RejectedExecutionException rejectedExecutionException) {
        k14.c(coroutineContext, w04.a("The task was rejected", rejectedExecutionException));
    }
}
