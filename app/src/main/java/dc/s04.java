package dc;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.time.DurationKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: EventLoop.common.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b \u0018\u00002\u0002092\u00020::\u00044567B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0002J\u0017\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\n\u0010\u000b\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u00020\u00032\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u00020\u00112\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0002J\u000f\u0010\u0018\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u0018\u0010\u0002J\u001d\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001f\u0010 J#\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u00142\n\u0010\u000b\u001a\u00060\u0005j\u0002`\u0006H\u0004¢\u0006\u0004\b#\u0010$J%\u0010'\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00142\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030%H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u001aH\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0003H\u0016¢\u0006\u0004\b+\u0010\u0002R$\u0010-\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00118B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u00118TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b1\u0010.R\u0014\u00103\u001a\u00020\u00148TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0016¨\u00068"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase;", "<init>", "()V", "", "closeQueue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dequeue", "()Ljava/lang/Runnable;", "Lkotlin/coroutines/CoroutineContext;", "context", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "task", "enqueue", "(Ljava/lang/Runnable;)V", "", "enqueueImpl", "(Ljava/lang/Runnable;)Z", "", "processNextEvent", "()J", "rescheduleAllDelayed", "resetAll", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "schedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "", "scheduleImpl", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "scheduleInvokeOnTimeout", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "shouldUnpark", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)Z", "shutdown", "value", "isCompleted", "()Z", "setCompleted", "(Z)V", "isEmpty", "getNextTime", "nextTime", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class s04 extends t04 implements g04 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(s04.class, Object.class, "_queue");
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(s04.class, Object.class, "_delayed");

    @NotNull
    private volatile /* synthetic */ Object _queue = null;

    @NotNull
    private volatile /* synthetic */ Object _delayed = null;

    @NotNull
    private volatile /* synthetic */ int _isCompleted = 0;

    /* compiled from: EventLoop.common.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class a extends b {

        @NotNull
        public final yy3<Unit> d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(long j, @NotNull yy3<? super Unit> yy3Var) {
            super(j);
            this.d = yy3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.d.n(s04.this, Unit.INSTANCE);
        }

        @Override // dc.s04.b
        @NotNull
        public String toString() {
            return Intrinsics.stringPlus(super.toString(), this.d);
        }
    }

    /* compiled from: EventLoop.common.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0000H\u0096\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u0007J\b\u0010$\u001a\u00020%H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "nanoTime", "", "(J)V", "_heap", "", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", FirebaseAnalytics.Param.INDEX, "", "getIndex", "()I", "setIndex", "(I)V", "compareTo", "other", "dispose", "", "scheduleTask", "now", "delayed", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "eventLoop", "Lkotlinx/coroutines/EventLoopImplBase;", "timeToExecute", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class b implements Runnable, Comparable<b>, o04, z64 {

        @JvmField
        public long a;

        @Nullable
        public Object b;
        public int c = -1;

        public b(long j) {
            this.a = j;
        }

        @Override // dc.z64
        public void a(@Nullable y64<?> y64Var) {
            if (!(this.b != v04.a)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this.b = y64Var;
        }

        @Override // dc.z64
        @Nullable
        public y64<?> b() {
            Object obj = this.b;
            if (obj instanceof y64) {
                return (y64) obj;
            }
            return null;
        }

        @Override // java.lang.Comparable
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NotNull b bVar) {
            long j = this.a - bVar.a;
            if (j > 0) {
                return 1;
            }
            return j < 0 ? -1 : 0;
        }

        @Override // dc.o04
        public final synchronized void dispose() {
            Object obj = this.b;
            if (obj == v04.a) {
                return;
            }
            c cVar = obj instanceof c ? (c) obj : null;
            if (cVar != null) {
                cVar.g(this);
            }
            this.b = v04.a;
        }

        public final synchronized int e(long j, @NotNull c cVar, @NotNull s04 s04Var) {
            if (this.b == v04.a) {
                return 2;
            }
            synchronized (cVar) {
                b bVarB = cVar.b();
                if (s04Var.t0()) {
                    return 1;
                }
                if (bVarB == null) {
                    cVar.b = j;
                } else {
                    long j2 = bVarB.a;
                    if (j2 - j < 0) {
                        j = j2;
                    }
                    if (j - cVar.b > 0) {
                        cVar.b = j;
                    }
                }
                long j3 = this.a;
                long j4 = cVar.b;
                if (j3 - j4 < 0) {
                    this.a = j4;
                }
                cVar.a(this);
                return 0;
            }
        }

        public final boolean f(long j) {
            return j - this.a >= 0;
        }

        @Override // dc.z64
        /* renamed from: getIndex, reason: from getter */
        public int getC() {
            return this.c;
        }

        @Override // dc.z64
        public void setIndex(int i) {
            this.c = i;
        }

        @NotNull
        public String toString() {
            return "Delayed[nanos=" + this.a + ']';
        }
    }

    /* compiled from: EventLoop.common.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", "", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c extends y64<b> {

        @JvmField
        public long b;

        public c(long j) {
            this.b = j;
        }
    }

    public final boolean A0(b bVar) {
        c cVar = (c) this._delayed;
        return (cVar == null ? null : cVar.e()) == bVar;
    }

    @Override // dc.r04
    public long d0() {
        if (super.d0() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof i64)) {
                return obj == v04.b ? Long.MAX_VALUE : 0L;
            }
            if (!((i64) obj).g()) {
                return 0L;
            }
        }
        c cVar = (c) this._delayed;
        b bVarE = cVar == null ? null : cVar.e();
        if (bVarE == null) {
            return Long.MAX_VALUE;
        }
        long j = bVarE.a;
        my3 my3VarA = ny3.a();
        Long lValueOf = my3VarA != null ? Long.valueOf(my3VarA.a()) : null;
        return RangesKt___RangesKt.coerceAtLeast(j - (lValueOf == null ? System.nanoTime() : lValueOf.longValue()), 0L);
    }

    @Override // dc.qz3
    public final void dispatch(@NotNull CoroutineContext context, @NotNull Runnable block) {
        r0(block);
    }

    @Override // dc.g04
    public void f(long j, @NotNull yy3<? super Unit> yy3Var) {
        long jC = v04.c(j);
        if (jC < DurationKt.MAX_MILLIS) {
            my3 my3VarA = ny3.a();
            Long lValueOf = my3VarA == null ? null : Long.valueOf(my3VarA.a());
            long jNanoTime = lValueOf == null ? System.nanoTime() : lValueOf.longValue();
            a aVar = new a(jC + jNanoTime, yy3Var);
            bz3.a(yy3Var, aVar);
            x0(jNanoTime, aVar);
        }
    }

    @Override // dc.r04
    public long i0() {
        b bVarH;
        if (j0()) {
            return 0L;
        }
        c cVar = (c) this._delayed;
        if (cVar != null && !cVar.d()) {
            my3 my3VarA = ny3.a();
            Long lValueOf = my3VarA == null ? null : Long.valueOf(my3VarA.a());
            long jNanoTime = lValueOf == null ? System.nanoTime() : lValueOf.longValue();
            do {
                synchronized (cVar) {
                    b bVarB = cVar.b();
                    if (bVarB == null) {
                        bVarH = null;
                    } else {
                        b bVar = bVarB;
                        bVarH = bVar.f(jNanoTime) ? s0(bVar) : false ? cVar.h(0) : null;
                    }
                }
            } while (bVarH != null);
        }
        Runnable runnableQ0 = q0();
        if (runnableQ0 == null) {
            return d0();
        }
        runnableQ0.run();
        return 0L;
    }

    public final void p0() {
        if (a04.a() && !t0()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                if (d.compareAndSet(this, null, v04.b)) {
                    return;
                }
            } else if (obj instanceof i64) {
                ((i64) obj).d();
                return;
            } else {
                if (obj == v04.b) {
                    return;
                }
                i64 i64Var = new i64(8, true);
                Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                i64Var.a((Runnable) obj);
                if (d.compareAndSet(this, obj, i64Var)) {
                    return;
                }
            }
        }
    }

    public final Runnable q0() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof i64) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                i64 i64Var = (i64) obj;
                Object objJ = i64Var.j();
                if (objJ != i64.h) {
                    return (Runnable) objJ;
                }
                d.compareAndSet(this, obj, i64Var.i());
            } else {
                if (obj == v04.b) {
                    return null;
                }
                if (d.compareAndSet(this, obj, null)) {
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    return (Runnable) obj;
                }
            }
        }
    }

    public void r0(@NotNull Runnable runnable) {
        if (s0(runnable)) {
            n0();
        } else {
            c04.f.r0(runnable);
        }
    }

    public final boolean s0(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (t0()) {
                return false;
            }
            if (obj == null) {
                if (d.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof i64) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                i64 i64Var = (i64) obj;
                int iA = i64Var.a(runnable);
                if (iA == 0) {
                    return true;
                }
                if (iA == 1) {
                    d.compareAndSet(this, obj, i64Var.i());
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (obj == v04.b) {
                    return false;
                }
                i64 i64Var2 = new i64(8, true);
                Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                i64Var2.a((Runnable) obj);
                i64Var2.a(runnable);
                if (d.compareAndSet(this, obj, i64Var2)) {
                    return true;
                }
            }
        }
    }

    @Override // dc.r04
    public void shutdown() {
        g24.a.c();
        z0(true);
        p0();
        while (i0() <= 0) {
        }
        v0();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean t0() {
        return this._isCompleted;
    }

    public boolean u0() {
        if (!h0()) {
            return false;
        }
        c cVar = (c) this._delayed;
        if (cVar != null && !cVar.d()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof i64) {
                return ((i64) obj).g();
            }
            if (obj != v04.b) {
                return false;
            }
        }
        return true;
    }

    public final void v0() {
        my3 my3VarA = ny3.a();
        Long lValueOf = my3VarA == null ? null : Long.valueOf(my3VarA.a());
        long jNanoTime = lValueOf == null ? System.nanoTime() : lValueOf.longValue();
        while (true) {
            c cVar = (c) this._delayed;
            b bVarI = cVar == null ? null : cVar.i();
            if (bVarI == null) {
                return;
            } else {
                m0(jNanoTime, bVarI);
            }
        }
    }

    public final void w0() {
        this._queue = null;
        this._delayed = null;
    }

    public final void x0(long j, @NotNull b bVar) {
        int iY0 = y0(j, bVar);
        if (iY0 == 0) {
            if (A0(bVar)) {
                n0();
            }
        } else if (iY0 == 1) {
            m0(j, bVar);
        } else if (iY0 != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    public final int y0(long j, b bVar) {
        if (t0()) {
            return 1;
        }
        c cVar = (c) this._delayed;
        if (cVar == null) {
            e.compareAndSet(this, null, new c(j));
            Object obj = this._delayed;
            Intrinsics.checkNotNull(obj);
            cVar = (c) obj;
        }
        return bVar.e(j, cVar, this);
    }

    public final void z0(boolean z) {
        this._isCompleted = z ? 1 : 0;
    }
}
