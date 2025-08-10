package dc;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: DealCommandQueueSchedule.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/component/dxtoy/command/DealCommandQueueSchedule;", "Lcom/component/dxtoy/core/api/schedule/base/BaseCoroutineScopeLoop;", "()V", "isSendingOrder", "Ljava/util/concurrent/atomic/AtomicBoolean;", "add", "", "command", "Lcom/component/dxtoy/command/code/ToyCommandCode;", "getLoopDelayTime", "", "loopBody", "startSchedule", "stopSchedule", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class k40 extends r90 {

    @NotNull
    public final AtomicBoolean c;

    public k40() {
        super(xz3.a(n04.b()));
        this.c = new AtomicBoolean(false);
    }

    @Override // dc.r90
    public long a() {
        return 10L;
    }

    @Override // dc.r90
    public void b() {
        Iterator<Map.Entry<String, ConcurrentLinkedQueue<b90>>> it = l40.a.b().entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            b90 b90VarPoll = it.next().getValue().poll();
            if (b90VarPoll != null && b90VarPoll.g()) {
                f90.a.k(b90VarPoll);
                z = true;
            }
        }
        if (z) {
            return;
        }
        g();
    }

    public final void e(@NotNull b90 command) {
        Intrinsics.checkNotNullParameter(command, "command");
        l40 l40Var = l40.a;
        if (l40Var.b().get(command.getB()) == null) {
            l40Var.b().put(command.getB(), new ConcurrentLinkedQueue<>());
        }
        ConcurrentLinkedQueue<b90> concurrentLinkedQueue = l40Var.b().get(command.getB());
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.offer(command);
        }
        f();
    }

    public final void f() {
        if (this.c.compareAndSet(false, true)) {
            c();
        }
    }

    public final void g() {
        d();
        this.c.set(false);
    }
}
