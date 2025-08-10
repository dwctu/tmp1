package dc;

import com.wear.bean.SyncWsProtocol;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WorkQueue.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\b\u0000\u0018\u00002\u00020*B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J!\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\r*\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020#8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020#8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b'\u0010%¨\u0006)"}, d2 = {"Lkotlinx/coroutines/scheduling/WorkQueue;", "<init>", "()V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "fair", "add", "(Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "addLast", "(Lkotlinx/coroutines/scheduling/Task;)Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalQueue", "", "offloadAllWorkTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)V", "poll", "()Lkotlinx/coroutines/scheduling/Task;", "pollBuffer", SyncWsProtocol.DataBean.CONTROL_STATUS_QUEUE_TYPE_KEY, "pollTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)Z", "victim", "", "tryStealBlockingFrom", "(Lkotlinx/coroutines/scheduling/WorkQueue;)J", "tryStealFrom", "blockingOnly", "tryStealLastScheduled", "(Lkotlinx/coroutines/scheduling/WorkQueue;Z)J", "decrementIfBlocking", "(Lkotlinx/coroutines/scheduling/Task;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "", "getBufferSize$kotlinx_coroutines_core", "()I", "bufferSize", "getSize$kotlinx_coroutines_core", "size", "kotlinx-coroutines-core", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class r74 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(r74.class, Object.class, "lastScheduledTask");
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(r74.class, "producerIndex");
    public static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(r74.class, "consumerIndex");
    public static final /* synthetic */ AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(r74.class, "blockingTasksInBuffer");

    @NotNull
    public final AtomicReferenceArray<l74> a = new AtomicReferenceArray<>(128);

    @NotNull
    private volatile /* synthetic */ Object lastScheduledTask = null;

    @NotNull
    private volatile /* synthetic */ int producerIndex = 0;

    @NotNull
    private volatile /* synthetic */ int consumerIndex = 0;

    @NotNull
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    public static /* synthetic */ l74 b(r74 r74Var, l74 l74Var, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return r74Var.a(l74Var, z);
    }

    @Nullable
    public final l74 a(@NotNull l74 l74Var, boolean z) {
        if (z) {
            return c(l74Var);
        }
        l74 l74Var2 = (l74) b.getAndSet(this, l74Var);
        if (l74Var2 == null) {
            return null;
        }
        return c(l74Var2);
    }

    public final l74 c(l74 l74Var) {
        if (l74Var.b.getA() == 1) {
            e.incrementAndGet(this);
        }
        if (e() == 127) {
            return l74Var;
        }
        int i = this.producerIndex & 127;
        while (this.a.get(i) != null) {
            Thread.yield();
        }
        this.a.lazySet(i, l74Var);
        c.incrementAndGet(this);
        return null;
    }

    public final void d(l74 l74Var) {
        if (l74Var != null) {
            if (l74Var.b.getA() == 1) {
                int iDecrementAndGet = e.decrementAndGet(this);
                if (a04.a()) {
                    if (!(iDecrementAndGet >= 0)) {
                        throw new AssertionError();
                    }
                }
            }
        }
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final void g(@NotNull h74 h74Var) {
        l74 l74Var = (l74) b.getAndSet(this, null);
        if (l74Var != null) {
            h74Var.a(l74Var);
        }
        while (j(h74Var)) {
        }
    }

    @Nullable
    public final l74 h() {
        l74 l74Var = (l74) b.getAndSet(this, null);
        return l74Var == null ? i() : l74Var;
    }

    public final l74 i() {
        l74 andSet;
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            int i2 = i & 127;
            if (d.compareAndSet(this, i, i + 1) && (andSet = this.a.getAndSet(i2, null)) != null) {
                d(andSet);
                return andSet;
            }
        }
    }

    public final boolean j(h74 h74Var) {
        l74 l74VarI = i();
        if (l74VarI == null) {
            return false;
        }
        h74Var.a(l74VarI);
        return true;
    }

    public final long k(@NotNull r74 r74Var) {
        if (a04.a()) {
            if (!(e() == 0)) {
                throw new AssertionError();
            }
        }
        int i = r74Var.producerIndex;
        AtomicReferenceArray<l74> atomicReferenceArray = r74Var.a;
        for (int i2 = r74Var.consumerIndex; i2 != i; i2++) {
            int i3 = i2 & 127;
            if (r74Var.blockingTasksInBuffer == 0) {
                break;
            }
            l74 l74Var = atomicReferenceArray.get(i3);
            if (l74Var != null) {
                if ((l74Var.b.getA() == 1) && atomicReferenceArray.compareAndSet(i3, l74Var, null)) {
                    e.decrementAndGet(r74Var);
                    b(this, l74Var, false, 2, null);
                    return -1L;
                }
            }
        }
        return m(r74Var, true);
    }

    public final long l(@NotNull r74 r74Var) {
        if (a04.a()) {
            if (!(e() == 0)) {
                throw new AssertionError();
            }
        }
        l74 l74VarI = r74Var.i();
        if (l74VarI == null) {
            return m(r74Var, false);
        }
        l74 l74VarB = b(this, l74VarI, false, 2, null);
        if (!a04.a()) {
            return -1L;
        }
        if (l74VarB == null) {
            return -1L;
        }
        throw new AssertionError();
    }

    public final long m(r74 r74Var, boolean z) {
        l74 l74Var;
        do {
            l74Var = (l74) r74Var.lastScheduledTask;
            if (l74Var == null) {
                return -2L;
            }
            if (z) {
                if (!(l74Var.b.getA() == 1)) {
                    return -2L;
                }
            }
            long jA = p74.e.a() - l74Var.a;
            long j = p74.a;
            if (jA < j) {
                return j - jA;
            }
        } while (!b.compareAndSet(r74Var, l74Var, null));
        b(this, l74Var, false, 2, null);
        return -1L;
    }
}
