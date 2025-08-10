package dc;

import dc.s04;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DefaultExecutor.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0002J\u0014\u0010 \u001a\u00020\u001e2\n\u0010!\u001a\u00060\u0002j\u0002`\u0003H\u0016J\r\u0010\"\u001a\u00020\u001eH\u0000¢\u0006\u0002\b#J$\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\b2\n\u0010'\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0015H\u0002J\u0018\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020.H\u0014J\b\u0010/\u001a\u00020\u001eH\u0016J\b\u00100\u001a\u00020\u001eH\u0016J\b\u00101\u001a\u00020\u001eH\u0002J\u000e\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0004R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00118TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u00064"}, d2 = {"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "()V", "ACTIVE", "", "DEFAULT_KEEP_ALIVE_MS", "", "FRESH", "KEEP_ALIVE_NANOS", "SHUTDOWN", "SHUTDOWN_ACK", "SHUTDOWN_REQ", "THREAD_NAME", "", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "debugStatus", "isShutDown", "", "()Z", "isShutdownRequested", "isThreadPresent", "isThreadPresent$kotlinx_coroutines_core", "thread", "getThread", "()Ljava/lang/Thread;", "acknowledgeShutdownIfNeeded", "", "createThreadSync", "enqueue", "task", "ensureStarted", "ensureStarted$kotlinx_coroutines_core", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "block", "context", "Lkotlin/coroutines/CoroutineContext;", "notifyStartup", "reschedule", "now", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "run", "shutdown", "shutdownError", "shutdownForTests", "timeout", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class c04 extends s04 implements Runnable {

    @Nullable
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    @NotNull
    public static final c04 f;
    public static final long g;

    static {
        Long l;
        c04 c04Var = new c04();
        f = c04Var;
        r04.f0(c04Var, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        g = timeUnit.toNanos(l.longValue());
    }

    public final synchronized void B0() {
        if (E0()) {
            debugStatus = 3;
            w0();
            notifyAll();
        }
    }

    public final synchronized Thread C0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    public final boolean D0() {
        return debugStatus == 4;
    }

    public final boolean E0() {
        int i = debugStatus;
        return i == 2 || i == 3;
    }

    public final synchronized boolean F0() {
        if (E0()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    public final void G0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // dc.t04
    @NotNull
    /* renamed from: l0 */
    public Thread getF() {
        Thread thread = _thread;
        return thread == null ? C0() : thread;
    }

    @Override // dc.t04
    public void m0(long j, @NotNull s04.b bVar) {
        G0();
        throw null;
    }

    @Override // dc.s04
    public void r0(@NotNull Runnable runnable) {
        if (D0()) {
            G0();
            throw null;
        }
        super.r0(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        Unit unit;
        boolean zU0;
        g24.a.d(this);
        my3 my3VarA = ny3.a();
        if (my3VarA != null) {
            my3VarA.c();
        }
        try {
            if (!F0()) {
                if (zU0) {
                    return;
                } else {
                    return;
                }
            }
            long j = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jI0 = i0();
                if (jI0 == Long.MAX_VALUE) {
                    my3 my3VarA2 = ny3.a();
                    Long lValueOf = my3VarA2 == null ? null : Long.valueOf(my3VarA2.a());
                    long jNanoTime = lValueOf == null ? System.nanoTime() : lValueOf.longValue();
                    if (j == Long.MAX_VALUE) {
                        j = g + jNanoTime;
                    }
                    long j2 = j - jNanoTime;
                    if (j2 <= 0) {
                        _thread = null;
                        B0();
                        my3 my3VarA3 = ny3.a();
                        if (my3VarA3 != null) {
                            my3VarA3.g();
                        }
                        if (u0()) {
                            return;
                        }
                        getF();
                        return;
                    }
                    jI0 = RangesKt___RangesKt.coerceAtMost(jI0, j2);
                } else {
                    j = Long.MAX_VALUE;
                }
                if (jI0 > 0) {
                    if (E0()) {
                        _thread = null;
                        B0();
                        my3 my3VarA4 = ny3.a();
                        if (my3VarA4 != null) {
                            my3VarA4.g();
                        }
                        if (u0()) {
                            return;
                        }
                        getF();
                        return;
                    }
                    my3 my3VarA5 = ny3.a();
                    if (my3VarA5 == null) {
                        unit = null;
                    } else {
                        my3VarA5.b(this, jI0);
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        LockSupport.parkNanos(this, jI0);
                    }
                }
            }
        } finally {
            _thread = null;
            B0();
            my3 my3VarA6 = ny3.a();
            if (my3VarA6 != null) {
                my3VarA6.g();
            }
            if (!u0()) {
                getF();
            }
        }
    }

    @Override // dc.s04, dc.r04
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
