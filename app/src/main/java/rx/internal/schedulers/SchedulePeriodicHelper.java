package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.subscriptions.SequentialSubscription;

/* loaded from: classes5.dex */
public final class SchedulePeriodicHelper {
    public static final long CLOCK_DRIFT_TOLERANCE_NANOS = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    public interface NowNanoSupplier {
        long nowNanos();
    }

    private SchedulePeriodicHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static Subscription schedulePeriodically(Scheduler.Worker worker, Action0 action0, long j, long j2, TimeUnit timeUnit, NowNanoSupplier nowNanoSupplier) {
        long nanos = timeUnit.toNanos(j2);
        long jNowNanos = nowNanoSupplier != null ? nowNanoSupplier.nowNanos() : TimeUnit.MILLISECONDS.toNanos(worker.now());
        long nanos2 = timeUnit.toNanos(j) + jNowNanos;
        SequentialSubscription sequentialSubscription = new SequentialSubscription();
        SequentialSubscription sequentialSubscription2 = new SequentialSubscription(sequentialSubscription);
        sequentialSubscription.replace(worker.schedule(new Action0(jNowNanos, nanos2, action0, sequentialSubscription2, nowNanoSupplier, worker, nanos) { // from class: rx.internal.schedulers.SchedulePeriodicHelper.1
            public long count;
            public long lastNowNanos;
            public long startInNanos;
            public final /* synthetic */ Action0 val$action;
            public final /* synthetic */ long val$firstNowNanos;
            public final /* synthetic */ long val$firstStartInNanos;
            public final /* synthetic */ SequentialSubscription val$mas;
            public final /* synthetic */ NowNanoSupplier val$nowNanoSupplier;
            public final /* synthetic */ long val$periodInNanos;
            public final /* synthetic */ Scheduler.Worker val$worker;

            {
                this.val$firstNowNanos = jNowNanos;
                this.val$firstStartInNanos = nanos2;
                this.val$action = action0;
                this.val$mas = sequentialSubscription2;
                this.val$nowNanoSupplier = nowNanoSupplier;
                this.val$worker = worker;
                this.val$periodInNanos = nanos;
                this.lastNowNanos = jNowNanos;
                this.startInNanos = nanos2;
            }

            /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
            @Override // rx.functions.Action0
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void call() {
                /*
                    r11 = this;
                    rx.functions.Action0 r0 = r11.val$action
                    r0.call()
                    rx.internal.subscriptions.SequentialSubscription r0 = r11.val$mas
                    boolean r0 = r0.isUnsubscribed()
                    if (r0 != 0) goto L62
                    rx.internal.schedulers.SchedulePeriodicHelper$NowNanoSupplier r0 = r11.val$nowNanoSupplier
                    if (r0 == 0) goto L16
                    long r0 = r0.nowNanos()
                    goto L22
                L16:
                    java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS
                    rx.Scheduler$Worker r1 = r11.val$worker
                    long r1 = r1.now()
                    long r0 = r0.toNanos(r1)
                L22:
                    long r2 = rx.internal.schedulers.SchedulePeriodicHelper.CLOCK_DRIFT_TOLERANCE_NANOS
                    long r4 = r0 + r2
                    long r6 = r11.lastNowNanos
                    r8 = 1
                    int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                    if (r10 < 0) goto L42
                    long r4 = r11.val$periodInNanos
                    long r6 = r6 + r4
                    long r6 = r6 + r2
                    int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                    if (r2 < 0) goto L37
                    goto L42
                L37:
                    long r2 = r11.startInNanos
                    long r6 = r11.count
                    long r6 = r6 + r8
                    r11.count = r6
                    long r6 = r6 * r4
                    long r2 = r2 + r6
                    goto L52
                L42:
                    long r2 = r11.val$periodInNanos
                    long r4 = r0 + r2
                    long r6 = r11.count
                    long r6 = r6 + r8
                    r11.count = r6
                    long r2 = r2 * r6
                    long r2 = r4 - r2
                    r11.startInNanos = r2
                    r2 = r4
                L52:
                    r11.lastNowNanos = r0
                    long r2 = r2 - r0
                    rx.internal.subscriptions.SequentialSubscription r0 = r11.val$mas
                    rx.Scheduler$Worker r1 = r11.val$worker
                    java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.NANOSECONDS
                    rx.Subscription r1 = r1.schedule(r11, r2, r4)
                    r0.replace(r1)
                L62:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: rx.internal.schedulers.SchedulePeriodicHelper.AnonymousClass1.call():void");
            }
        }, j, timeUnit));
        return sequentialSubscription2;
    }
}
