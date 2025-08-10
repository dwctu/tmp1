package dc;

import dc.q90;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ToySchedule.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0010\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/component/dxtoy/core/api/schedule/ToySchedule;", "Lcom/component/dxtoy/core/api/schedule/base/BaseCoroutineScopeLoop;", "Lcom/component/dxtoy/core/api/listenter/IToySchedule;", "()V", "scheduledTasks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/component/dxtoy/core/api/schedule/ToySchedule$ScheduledTask;", "addScheduledTask", "", "task", "Lcom/component/dxtoy/core/api/schedule/ToySchedule$Task;", "interval", "", "getLoopDelayTime", "loopBody", "removeScheduledTask", "ScheduledTask", "Task", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class q90 extends r90 {

    @NotNull
    public static final q90 c = new q90();

    @NotNull
    public static final CopyOnWriteArrayList<ScheduledTask> d = new CopyOnWriteArrayList<>();

    /* compiled from: ToySchedule.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0015\u001a\u00020\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0005R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\b\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/component/dxtoy/core/api/schedule/ToySchedule$ScheduledTask;", "", "task", "Lcom/component/dxtoy/core/api/schedule/ToySchedule$Task;", "interval", "", "(Lcom/component/dxtoy/core/api/schedule/ToySchedule$Task;J)V", "getInterval", "()J", "nextExecutionTime", "getNextExecutionTime", "setNextExecutionTime", "(J)V", "getTask", "()Lcom/component/dxtoy/core/api/schedule/ToySchedule$Task;", "component1", "component2", "copy", "equals", "", "other", "execute", "", "hashCode", "", "toString", "", "updateNextExecutionTime", "currentTime", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: dc.q90$a, reason: from toString */
    public static final /* data */ class ScheduledTask {

        /* renamed from: a, reason: from toString */
        @NotNull
        public final b task;

        /* renamed from: b, reason: from toString */
        public final long interval;
        public long c;

        public ScheduledTask(@NotNull b task, long j) {
            Intrinsics.checkNotNullParameter(task, "task");
            this.task = task;
            this.interval = j;
            this.c = System.currentTimeMillis() + j;
        }

        public static final void b(ScheduledTask this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.task.execute();
        }

        public final void a() {
            se0.b().execute(new Runnable() { // from class: dc.p90
                @Override // java.lang.Runnable
                public final void run() {
                    q90.ScheduledTask.b(this.a);
                }
            });
        }

        /* renamed from: c, reason: from getter */
        public final long getC() {
            return this.c;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final b getTask() {
            return this.task;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScheduledTask)) {
                return false;
            }
            ScheduledTask scheduledTask = (ScheduledTask) other;
            return Intrinsics.areEqual(this.task, scheduledTask.task) && this.interval == scheduledTask.interval;
        }

        public final void f(long j) {
            this.c = j + this.interval;
        }

        public int hashCode() {
            return (this.task.hashCode() * 31) + g.a(this.interval);
        }

        @NotNull
        public String toString() {
            return "ScheduledTask(task=" + this.task + ", interval=" + this.interval + ')';
        }
    }

    /* compiled from: ToySchedule.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/component/dxtoy/core/api/schedule/ToySchedule$Task;", "", "execute", "", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface b {
        void execute();
    }

    /* compiled from: ToySchedule.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/component/dxtoy/core/api/schedule/ToySchedule$ScheduledTask;", "kotlin.jvm.PlatformType", "invoke", "(Lcom/component/dxtoy/core/api/schedule/ToySchedule$ScheduledTask;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function1<ScheduledTask, Boolean> {
        public final /* synthetic */ b $task;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b bVar) {
            super(1);
            this.$task = bVar;
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(ScheduledTask scheduledTask) {
            return Boolean.valueOf(Intrinsics.areEqual(scheduledTask.getTask(), this.$task));
        }
    }

    public q90() {
        super(xz3.a(n04.b()));
    }

    @Override // dc.r90
    public long a() {
        return 1000L;
    }

    @Override // dc.r90
    public void b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Iterator<ScheduledTask> it = d.iterator();
        while (it.hasNext()) {
            ScheduledTask next = it.next();
            if (jCurrentTimeMillis >= next.getC()) {
                next.a();
                next.f(jCurrentTimeMillis);
            }
        }
    }

    public void e(@NotNull b task, long j) {
        Intrinsics.checkNotNullParameter(task, "task");
        f(task);
        CopyOnWriteArrayList<ScheduledTask> copyOnWriteArrayList = d;
        copyOnWriteArrayList.add(new ScheduledTask(task, j));
        if (copyOnWriteArrayList.size() > 0) {
            c();
        }
    }

    public void f(@NotNull b task) {
        Intrinsics.checkNotNullParameter(task, "task");
        CopyOnWriteArrayList<ScheduledTask> copyOnWriteArrayList = d;
        CollectionsKt__MutableCollectionsKt.removeAll((List) copyOnWriteArrayList, (Function1) new c(task));
        if (copyOnWriteArrayList.size() == 0) {
            d();
        }
    }
}
