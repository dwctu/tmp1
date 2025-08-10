package dc;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.vending.expansion.downloader.DownloaderClientMarshaller;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;

/* compiled from: CoroutineScheduler.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0000\u0018\u0000 X2\u00020\\2\u00020]:\u0003XYZB+\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\u0082\b¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001d\u001a\u00020\n2\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\u0082\b¢\u0006\u0004\b\u001f\u0010\u0011J\u0015\u0010!\u001a\b\u0018\u00010 R\u00020\u0000H\u0002¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0013H\u0082\b¢\u0006\u0004\b#\u0010\u0015J\u0010\u0010$\u001a\u00020\u0001H\u0082\b¢\u0006\u0004\b$\u0010\u0017J-\u0010&\u001a\u00020\u00132\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020\f¢\u0006\u0004\b&\u0010'J\u001b\u0010)\u001a\u00020\u00132\n\u0010(\u001a\u00060\u0018j\u0002`\u0019H\u0016¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0004H\u0082\b¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0001H\u0082\b¢\u0006\u0004\b-\u0010\u0017J\u001b\u0010/\u001a\u00020\u00012\n\u0010.\u001a\u00060 R\u00020\u0000H\u0002¢\u0006\u0004\b/\u00100J\u0015\u00101\u001a\b\u0018\u00010 R\u00020\u0000H\u0002¢\u0006\u0004\b1\u0010\"J\u0019\u00102\u001a\u00020\f2\n\u0010.\u001a\u00060 R\u00020\u0000¢\u0006\u0004\b2\u00103J)\u00106\u001a\u00020\u00132\n\u0010.\u001a\u00060 R\u00020\u00002\u0006\u00104\u001a\u00020\u00012\u0006\u00105\u001a\u00020\u0001¢\u0006\u0004\b6\u00107J\u0010\u00108\u001a\u00020\u0004H\u0082\b¢\u0006\u0004\b8\u0010,J\u0015\u00109\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b9\u0010:J\u0015\u0010<\u001a\u00020\u00132\u0006\u0010;\u001a\u00020\u0004¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\fH\u0002¢\u0006\u0004\b?\u0010@J\r\u0010A\u001a\u00020\u0013¢\u0006\u0004\bA\u0010\u0015J\u000f\u0010B\u001a\u00020\u0006H\u0016¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020\fH\u0082\b¢\u0006\u0004\bD\u0010EJ\u0019\u0010F\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\fH\u0002¢\u0006\u0004\bH\u0010EJ+\u0010I\u001a\u0004\u0018\u00010\n*\b\u0018\u00010 R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010%\u001a\u00020\fH\u0002¢\u0006\u0004\bI\u0010JR\u0015\u0010\u0010\u001a\u00020\u00018Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u0017R\u0014\u0010\u0002\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010LR\u0015\u0010\u001f\u001a\u00020\u00018Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bM\u0010\u0017R\u0014\u0010O\u001a\u00020N8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010Q\u001a\u00020N8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bQ\u0010PR\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010RR\u0011\u0010S\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\bS\u0010ER\u0014\u0010\u0003\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010LR\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010TR\u001e\u0010V\u001a\f\u0012\b\u0012\u00060 R\u00020\u00000U8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bV\u0010W¨\u0006["}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "addToGlobalQueue", "(Lkotlinx/coroutines/scheduling/Task;)Z", "state", "availableCpuPermits", "(J)I", "blockingTasks", "", Close.ELEMENT, "()V", "createNewWorker", "()I", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "createTask", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;)Lkotlinx/coroutines/scheduling/Task;", "createdWorkers", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "currentWorker", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "decrementBlockingTasks", "decrementCreatedWorkers", "tailDispatch", "dispatch", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "command", "execute", "(Ljava/lang/Runnable;)V", "incrementBlockingTasks", "()J", "incrementCreatedWorkers", "worker", "parkedWorkersStackNextIndex", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)I", "parkedWorkersStackPop", "parkedWorkersStackPush", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)Z", "oldIndex", "newIndex", "parkedWorkersStackTopUpdate", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;II)V", "releaseCpuPermit", "runSafely", "(Lkotlinx/coroutines/scheduling/Task;)V", "timeout", "shutdown", "(J)V", "skipUnpark", "signalBlockingWork", "(Z)V", "signalCpuWork", "toString", "()Ljava/lang/String;", "tryAcquireCpuPermit", "()Z", "tryCreateWorker", "(J)Z", "tryUnpark", "submitToLocalQueue", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "getAvailableCpuPermits", "I", "getCreatedWorkers", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalBlockingQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "J", "isTerminated", "Ljava/lang/String;", "Lkotlinx/coroutines/internal/ResizableAtomicArray;", "workers", "Lkotlinx/coroutines/internal/ResizableAtomicArray;", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class e74 implements Executor, Closeable {

    @NotNull
    private volatile /* synthetic */ int _isTerminated;

    @JvmField
    public final int a;

    @JvmField
    public final int b;

    @JvmField
    public final long c;

    @NotNull
    public volatile /* synthetic */ long controlState;

    @JvmField
    @NotNull
    public final String d;

    @JvmField
    @NotNull
    public final h74 e;

    @JvmField
    @NotNull
    public final h74 f;

    @JvmField
    @NotNull
    public final q64<b> g;

    @NotNull
    private volatile /* synthetic */ long parkedWorkersStack;

    @JvmField
    @NotNull
    public static final t64 k = new t64("NOT_IN_STACK");
    public static final /* synthetic */ AtomicLongFieldUpdater h = AtomicLongFieldUpdater.newUpdater(e74.class, "parkedWorkersStack");
    public static final /* synthetic */ AtomicLongFieldUpdater i = AtomicLongFieldUpdater.newUpdater(e74.class, "controlState");
    public static final /* synthetic */ AtomicIntegerFieldUpdater j = AtomicIntegerFieldUpdater.newUpdater(e74.class, "_isTerminated");

    /* compiled from: CoroutineScheduler.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            iArr[c.PARKING.ordinal()] = 1;
            iArr[c.BLOCKING.ordinal()] = 2;
            iArr[c.CPU_ACQUIRED.ordinal()] = 3;
            iArr[c.DORMANT.ordinal()] = 4;
            iArr[c.TERMINATED.ordinal()] = 5;
            a = iArr;
        }
    }

    /* compiled from: CoroutineScheduler.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum c {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public e74(int i2, int i3, long j2, @NotNull String str) {
        this.a = i2;
        this.b = i3;
        this.c = j2;
        this.d = str;
        if (!(i2 >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + i2 + " should be at least 1").toString());
        }
        if (!(i3 >= i2)) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should be greater than or equals to core pool size " + i2).toString());
        }
        if (!(i3 <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(j2 > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
        }
        this.e = new h74();
        this.f = new h74();
        this.parkedWorkersStack = 0L;
        this.g = new q64<>(i2 + 1);
        this.controlState = i2 << 42;
        this._isTerminated = 0;
    }

    public static /* synthetic */ boolean X(e74 e74Var, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = e74Var.controlState;
        }
        return e74Var.V(j2);
    }

    public static /* synthetic */ void p(e74 e74Var, Runnable runnable, m74 m74Var, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            m74Var = p74.f;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        e74Var.m(runnable, m74Var, z);
    }

    public final void A(@NotNull b bVar, int i2, int i3) {
        while (true) {
            long j2 = this.parkedWorkersStack;
            int iQ = (int) (2097151 & j2);
            long j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & (-2097152);
            if (iQ == i2) {
                iQ = i3 == 0 ? q(bVar) : i3;
            }
            if (iQ >= 0 && h.compareAndSet(this, j2, j3 | iQ)) {
                return;
            }
        }
    }

    public final void C(@NotNull l74 l74Var) {
        try {
            l74Var.run();
        } catch (Throwable th) {
            try {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
                my3 my3VarA = ny3.a();
                if (my3VarA == null) {
                }
            } finally {
                my3 my3VarA2 = ny3.a();
                if (my3VarA2 != null) {
                    my3VarA2.e();
                }
            }
        }
    }

    public final void I(long j2) throws InterruptedException {
        int i2;
        if (j.compareAndSet(this, 0, 1)) {
            b bVarJ = j();
            synchronized (this.g) {
                i2 = (int) (this.controlState & 2097151);
            }
            if (1 <= i2) {
                int i3 = 1;
                while (true) {
                    int i4 = i3 + 1;
                    b bVarB = this.g.b(i3);
                    Intrinsics.checkNotNull(bVarB);
                    b bVar = bVarB;
                    if (bVar != bVarJ) {
                        while (bVar.isAlive()) {
                            LockSupport.unpark(bVar);
                            bVar.join(j2);
                        }
                        c cVar = bVar.b;
                        if (a04.a()) {
                            if (!(cVar == c.TERMINATED)) {
                                throw new AssertionError();
                            }
                        }
                        bVar.a.g(this.f);
                    }
                    if (i3 == i2) {
                        break;
                    } else {
                        i3 = i4;
                    }
                }
            }
            this.f.b();
            this.e.b();
            while (true) {
                l74 l74VarF = bVarJ == null ? null : bVarJ.f(true);
                if (l74VarF == null && (l74VarF = this.e.d()) == null && (l74VarF = this.f.d()) == null) {
                    break;
                } else {
                    C(l74VarF);
                }
            }
            if (bVarJ != null) {
                bVarJ.s(c.TERMINATED);
            }
            if (a04.a()) {
                if (!(((int) ((this.controlState & 9223367638808264704L) >> 42)) == this.a)) {
                    throw new AssertionError();
                }
            }
            this.parkedWorkersStack = 0L;
            this.controlState = 0L;
        }
    }

    public final void K(boolean z) {
        long jAddAndGet = i.addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        if (z || b0() || V(jAddAndGet)) {
            return;
        }
        b0();
    }

    public final void L() {
        if (b0() || X(this, 0L, 1, null)) {
            return;
        }
        b0();
    }

    public final l74 O(b bVar, l74 l74Var, boolean z) {
        if (bVar == null || bVar.b == c.TERMINATED) {
            return l74Var;
        }
        if (l74Var.b.getA() == 0 && bVar.b == c.BLOCKING) {
            return l74Var;
        }
        bVar.f = true;
        return bVar.a.a(l74Var, z);
    }

    public final boolean V(long j2) {
        if (RangesKt___RangesKt.coerceAtLeast(((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21)), 0) < this.a) {
            int iE = e();
            if (iE == 1 && this.a > 1) {
                e();
            }
            if (iE > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(l74 l74Var) {
        return l74Var.b.getA() == 1 ? this.f.a(l74Var) : this.e.a(l74Var);
    }

    public final boolean b0() {
        b bVarX;
        do {
            bVarX = x();
            if (bVarX == null) {
                return false;
            }
        } while (!b.h.compareAndSet(bVarX, -1, 0));
        LockSupport.unpark(bVarX);
        return true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        I(10000L);
    }

    public final int e() {
        synchronized (this.g) {
            if (isTerminated()) {
                return -1;
            }
            long j2 = this.controlState;
            int i2 = (int) (j2 & 2097151);
            int iCoerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i2 - ((int) ((j2 & 4398044413952L) >> 21)), 0);
            if (iCoerceAtLeast >= this.a) {
                return 0;
            }
            if (i2 >= this.b) {
                return 0;
            }
            int i3 = ((int) (this.controlState & 2097151)) + 1;
            if (!(i3 > 0 && this.g.b(i3) == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            b bVar = new b(i3);
            this.g.c(i3, bVar);
            if (!(i3 == ((int) (2097151 & i.incrementAndGet(this))))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            bVar.start();
            return iCoerceAtLeast + 1;
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable command) {
        p(this, command, null, false, 6, null);
    }

    @NotNull
    public final l74 f(@NotNull Runnable runnable, @NotNull m74 m74Var) {
        long jA = p74.e.a();
        if (!(runnable instanceof l74)) {
            return new o74(runnable, jA, m74Var);
        }
        l74 l74Var = (l74) runnable;
        l74Var.a = jA;
        l74Var.b = m74Var;
        return l74Var;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final b j() {
        Thread threadCurrentThread = Thread.currentThread();
        b bVar = threadCurrentThread instanceof b ? (b) threadCurrentThread : null;
        if (bVar != null && Intrinsics.areEqual(e74.this, this)) {
            return bVar;
        }
        return null;
    }

    public final void m(@NotNull Runnable runnable, @NotNull m74 m74Var, boolean z) {
        my3 my3VarA = ny3.a();
        if (my3VarA != null) {
            my3VarA.d();
        }
        l74 l74VarF = f(runnable, m74Var);
        b bVarJ = j();
        l74 l74VarO = O(bVarJ, l74VarF, z);
        if (l74VarO != null && !b(l74VarO)) {
            throw new RejectedExecutionException(Intrinsics.stringPlus(this.d, " was terminated"));
        }
        boolean z2 = z && bVarJ != null;
        if (l74VarF.b.getA() != 0) {
            K(z2);
        } else {
            if (z2) {
                return;
            }
            L();
        }
    }

    public final int q(b bVar) {
        Object nextParkedWorker = bVar.getNextParkedWorker();
        while (nextParkedWorker != k) {
            if (nextParkedWorker == null) {
                return 0;
            }
            b bVar2 = (b) nextParkedWorker;
            int indexInArray = bVar2.getIndexInArray();
            if (indexInArray != 0) {
                return indexInArray;
            }
            nextParkedWorker = bVar2.getNextParkedWorker();
        }
        return -1;
    }

    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList();
        int iA = this.g.a();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 1;
        while (i7 < iA) {
            int i8 = i7 + 1;
            b bVarB = this.g.b(i7);
            if (bVarB != null) {
                int iF = bVarB.a.f();
                int i9 = a.a[bVarB.b.ordinal()];
                if (i9 == 1) {
                    i4++;
                } else if (i9 == 2) {
                    i3++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(iF);
                    sb.append('b');
                    arrayList.add(sb.toString());
                } else if (i9 == 3) {
                    i2++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(iF);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (i9 == 4) {
                    i5++;
                    if (iF > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(iF);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (i9 == 5) {
                    i6++;
                }
            }
            i7 = i8;
        }
        long j2 = this.controlState;
        return this.d + '@' + b04.b(this) + "[Pool Size {core = " + this.a + ", max = " + this.b + "}, Worker States {CPU = " + i2 + ", blocking = " + i3 + ", parked = " + i4 + ", dormant = " + i5 + ", terminated = " + i6 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.e.c() + ", global blocking queue size = " + this.f.c() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.a - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }

    public final b x() {
        while (true) {
            long j2 = this.parkedWorkersStack;
            b bVarB = this.g.b((int) (2097151 & j2));
            if (bVarB == null) {
                return null;
            }
            long j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & (-2097152);
            int iQ = q(bVarB);
            if (iQ >= 0 && h.compareAndSet(this, j2, iQ | j3)) {
                bVarB.p(k);
                return bVarB;
            }
        }
    }

    public final boolean y(@NotNull b bVar) {
        long j2;
        long j3;
        int indexInArray;
        if (bVar.getNextParkedWorker() != k) {
            return false;
        }
        do {
            j2 = this.parkedWorkersStack;
            int i2 = (int) (2097151 & j2);
            j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & (-2097152);
            indexInArray = bVar.getIndexInArray();
            if (a04.a()) {
                if (!(indexInArray != 0)) {
                    throw new AssertionError();
                }
            }
            bVar.p(this.g.b(i2));
        } while (!h.compareAndSet(this, j2, indexInArray | j3));
        return true;
    }

    /* compiled from: CoroutineScheduler.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\b\u0080\u0004\u0018\u00002\u00020GB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0015\u0010\tJ\u000f\u0010\u0016\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010\u001cJ\u000f\u0010 \u001a\u00020\u0007H\u0002¢\u0006\u0004\b \u0010\u001cJ\u000f\u0010!\u001a\u00020\u000fH\u0002¢\u0006\u0004\b!\u0010\u0017J\u000f\u0010\"\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\"\u0010\u001cJ\u0015\u0010%\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u0019\u0010(\u001a\u0004\u0018\u00010\u000b2\u0006\u0010'\u001a\u00020\u000fH\u0002¢\u0006\u0004\b(\u0010\u0012J\u000f\u0010)\u001a\u00020\u0007H\u0002¢\u0006\u0004\b)\u0010\u001cR*\u0010*\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00018\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010\tR\u0014\u00100\u001a\u00020/8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R$\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010+R\u0012\u0010B\u001a\u00020?8Æ\u0002¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0016\u0010C\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u00106¨\u0006F"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "", FirebaseAnalytics.Param.INDEX, "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "taskMode", "", "afterTask", "(I)V", "beforeTask", "Lkotlinx/coroutines/scheduling/Task;", "task", "executeTask", "(Lkotlinx/coroutines/scheduling/Task;)V", "", "scanLocalQueue", "findAnyTask", "(Z)Lkotlinx/coroutines/scheduling/Task;", "findTask", "mode", "idleReset", "inStack", "()Z", "upperBound", "nextInt", "(I)I", "park", "()V", "pollGlobalQueues", "()Lkotlinx/coroutines/scheduling/Task;", "run", "runWorker", "tryAcquireCpuPermit", "tryPark", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", DownloaderClientMarshaller.PARAM_NEW_STATE, "tryReleaseCpu", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "blockingOnly", "trySteal", "tryTerminateWorker", "indexInArray", "I", "getIndexInArray", "()I", "setIndexInArray", "Lkotlinx/coroutines/scheduling/WorkQueue;", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "mayHaveLocalTasks", "Z", "", "minDelayUntilStealableTaskNs", "J", "", "nextParkedWorker", "Ljava/lang/Object;", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "rngState", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "terminationDeadline", "kotlinx-coroutines-core", "Ljava/lang/Thread;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class b extends Thread {
        public static final /* synthetic */ AtomicIntegerFieldUpdater h = AtomicIntegerFieldUpdater.newUpdater(b.class, "workerCtl");

        @JvmField
        @NotNull
        public final r74 a;

        @JvmField
        @NotNull
        public c b;
        public long c;
        public long d;
        public int e;

        @JvmField
        public boolean f;
        private volatile int indexInArray;

        @Nullable
        private volatile Object nextParkedWorker;

        @NotNull
        public volatile /* synthetic */ int workerCtl;

        public b() {
            setDaemon(true);
            this.a = new r74();
            this.b = c.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = e74.k;
            this.e = Random.INSTANCE.nextInt();
        }

        public final void b(int i) {
            if (i == 0) {
                return;
            }
            e74.i.addAndGet(e74.this, -2097152L);
            c cVar = this.b;
            if (cVar != c.TERMINATED) {
                if (a04.a()) {
                    if (!(cVar == c.BLOCKING)) {
                        throw new AssertionError();
                    }
                }
                this.b = c.DORMANT;
            }
        }

        public final void c(int i) {
            if (i != 0 && s(c.BLOCKING)) {
                e74.this.L();
            }
        }

        public final void d(l74 l74Var) {
            int a = l74Var.b.getA();
            i(a);
            c(a);
            e74.this.C(l74Var);
            b(a);
        }

        public final l74 e(boolean z) {
            l74 l74VarM;
            l74 l74VarM2;
            if (z) {
                boolean z2 = k(e74.this.a * 2) == 0;
                if (z2 && (l74VarM2 = m()) != null) {
                    return l74VarM2;
                }
                l74 l74VarH = this.a.h();
                if (l74VarH != null) {
                    return l74VarH;
                }
                if (!z2 && (l74VarM = m()) != null) {
                    return l74VarM;
                }
            } else {
                l74 l74VarM3 = m();
                if (l74VarM3 != null) {
                    return l74VarM3;
                }
            }
            return t(false);
        }

        @Nullable
        public final l74 f(boolean z) {
            l74 l74VarD;
            if (q()) {
                return e(z);
            }
            if (!z || (l74VarD = this.a.h()) == null) {
                l74VarD = e74.this.f.d();
            }
            return l74VarD == null ? t(true) : l74VarD;
        }

        /* renamed from: g, reason: from getter */
        public final int getIndexInArray() {
            return this.indexInArray;
        }

        @Nullable
        /* renamed from: h, reason: from getter */
        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final void i(int i) {
            this.c = 0L;
            if (this.b == c.PARKING) {
                if (a04.a()) {
                    if (!(i == 1)) {
                        throw new AssertionError();
                    }
                }
                this.b = c.BLOCKING;
            }
        }

        public final boolean j() {
            return this.nextParkedWorker != e74.k;
        }

        public final int k(int i) {
            int i2 = this.e;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.e = i5;
            int i6 = i - 1;
            return (i6 & i) == 0 ? i5 & i6 : (i5 & Integer.MAX_VALUE) % i;
        }

        public final void l() {
            if (this.c == 0) {
                this.c = System.nanoTime() + e74.this.c;
            }
            LockSupport.parkNanos(e74.this.c);
            if (System.nanoTime() - this.c >= 0) {
                this.c = 0L;
                u();
            }
        }

        public final l74 m() {
            if (k(2) == 0) {
                l74 l74VarD = e74.this.e.d();
                return l74VarD == null ? e74.this.f.d() : l74VarD;
            }
            l74 l74VarD2 = e74.this.f.d();
            return l74VarD2 == null ? e74.this.e.d() : l74VarD2;
        }

        public final void n() {
            loop0: while (true) {
                boolean z = false;
                while (!e74.this.isTerminated() && this.b != c.TERMINATED) {
                    l74 l74VarF = f(this.f);
                    if (l74VarF != null) {
                        this.d = 0L;
                        d(l74VarF);
                    } else {
                        this.f = false;
                        if (this.d == 0) {
                            r();
                        } else if (z) {
                            s(c.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.d);
                            this.d = 0L;
                        } else {
                            z = true;
                        }
                    }
                }
                break loop0;
            }
            s(c.TERMINATED);
        }

        public final void o(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(e74.this.d);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public final void p(@Nullable Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean q() {
            boolean z;
            if (this.b != c.CPU_ACQUIRED) {
                e74 e74Var = e74.this;
                while (true) {
                    long j = e74Var.controlState;
                    if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                        z = false;
                        break;
                    }
                    if (e74.i.compareAndSet(e74Var, j, j - 4398046511104L)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    return false;
                }
                this.b = c.CPU_ACQUIRED;
            }
            return true;
        }

        public final void r() {
            if (!j()) {
                e74.this.y(this);
                return;
            }
            if (a04.a()) {
                if (!(this.a.f() == 0)) {
                    throw new AssertionError();
                }
            }
            this.workerCtl = -1;
            while (j() && this.workerCtl == -1 && !e74.this.isTerminated() && this.b != c.TERMINATED) {
                s(c.PARKING);
                Thread.interrupted();
                l();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            n();
        }

        public final boolean s(@NotNull c cVar) {
            c cVar2 = this.b;
            boolean z = cVar2 == c.CPU_ACQUIRED;
            if (z) {
                e74.i.addAndGet(e74.this, 4398046511104L);
            }
            if (cVar2 != cVar) {
                this.b = cVar;
            }
            return z;
        }

        public final l74 t(boolean z) {
            if (a04.a()) {
                if (!(this.a.f() == 0)) {
                    throw new AssertionError();
                }
            }
            int i = (int) (e74.this.controlState & 2097151);
            if (i < 2) {
                return null;
            }
            int iK = k(i);
            e74 e74Var = e74.this;
            long jMin = Long.MAX_VALUE;
            int i2 = 0;
            while (i2 < i) {
                i2++;
                iK++;
                if (iK > i) {
                    iK = 1;
                }
                b bVarB = e74Var.g.b(iK);
                if (bVarB != null && bVarB != this) {
                    if (a04.a()) {
                        if (!(this.a.f() == 0)) {
                            throw new AssertionError();
                        }
                    }
                    long jK = z ? this.a.k(bVarB.a) : this.a.l(bVarB.a);
                    if (jK == -1) {
                        return this.a.h();
                    }
                    if (jK > 0) {
                        jMin = Math.min(jMin, jK);
                    }
                }
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.d = jMin;
            return null;
        }

        public final void u() {
            e74 e74Var = e74.this;
            synchronized (e74Var.g) {
                if (e74Var.isTerminated()) {
                    return;
                }
                if (((int) (e74Var.controlState & 2097151)) <= e74Var.a) {
                    return;
                }
                if (h.compareAndSet(this, -1, 1)) {
                    int indexInArray = getIndexInArray();
                    o(0);
                    e74Var.A(this, indexInArray, 0);
                    int andDecrement = (int) (e74.i.getAndDecrement(e74Var) & 2097151);
                    if (andDecrement != indexInArray) {
                        b bVarB = e74Var.g.b(andDecrement);
                        Intrinsics.checkNotNull(bVarB);
                        b bVar = bVarB;
                        e74Var.g.c(indexInArray, bVar);
                        bVar.o(indexInArray);
                        e74Var.A(bVar, andDecrement, indexInArray);
                    }
                    e74Var.g.c(andDecrement, null);
                    Unit unit = Unit.INSTANCE;
                    this.b = c.TERMINATED;
                }
            }
        }

        public b(int i) {
            this();
            o(i);
        }
    }
}
