package rx.schedulers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.schedulers.SchedulePeriodicHelper;
import rx.subscriptions.BooleanSubscription;
import rx.subscriptions.Subscriptions;

/* loaded from: classes5.dex */
public class TestScheduler extends Scheduler {
    public static long counter;
    public final Queue<TimedAction> queue = new PriorityQueue(11, new CompareActionsByTime());
    public long time;

    public static final class CompareActionsByTime implements Comparator<TimedAction> {
        @Override // java.util.Comparator
        public int compare(TimedAction timedAction, TimedAction timedAction2) {
            long j = timedAction.time;
            long j2 = timedAction2.time;
            if (j == j2) {
                if (timedAction.count < timedAction2.count) {
                    return -1;
                }
                return timedAction.count > timedAction2.count ? 1 : 0;
            }
            if (j < j2) {
                return -1;
            }
            return j > j2 ? 1 : 0;
        }
    }

    public static final class TimedAction {
        public final Action0 action;
        private final long count;
        public final Scheduler.Worker scheduler;
        public final long time;

        public TimedAction(Scheduler.Worker worker, long j, Action0 action0) {
            long j2 = TestScheduler.counter;
            TestScheduler.counter = 1 + j2;
            this.count = j2;
            this.time = j;
            this.action = action0;
            this.scheduler = worker;
        }

        public String toString() {
            return String.format("TimedAction(time = %d, action = %s)", Long.valueOf(this.time), this.action.toString());
        }
    }

    public void advanceTimeBy(long j, TimeUnit timeUnit) {
        advanceTimeTo(this.time + timeUnit.toNanos(j), TimeUnit.NANOSECONDS);
    }

    public void advanceTimeTo(long j, TimeUnit timeUnit) {
        triggerActions(timeUnit.toNanos(j));
    }

    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        return new InnerTestScheduler();
    }

    @Override // rx.Scheduler
    public long now() {
        return TimeUnit.NANOSECONDS.toMillis(this.time);
    }

    public void triggerActions() {
        triggerActions(this.time);
    }

    private void triggerActions(long j) {
        while (!this.queue.isEmpty()) {
            TimedAction timedActionPeek = this.queue.peek();
            long j2 = timedActionPeek.time;
            if (j2 > j) {
                break;
            }
            if (j2 == 0) {
                j2 = this.time;
            }
            this.time = j2;
            this.queue.remove();
            if (!timedActionPeek.scheduler.isUnsubscribed()) {
                timedActionPeek.action.call();
            }
        }
        this.time = j;
    }

    public final class InnerTestScheduler extends Scheduler.Worker implements SchedulePeriodicHelper.NowNanoSupplier {
        private final BooleanSubscription s = new BooleanSubscription();

        public InnerTestScheduler() {
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        @Override // rx.Scheduler.Worker
        public long now() {
            return TestScheduler.this.now();
        }

        @Override // rx.internal.schedulers.SchedulePeriodicHelper.NowNanoSupplier
        public long nowNanos() {
            return TestScheduler.this.time;
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action0, long j, TimeUnit timeUnit) {
            final TimedAction timedAction = new TimedAction(this, TestScheduler.this.time + timeUnit.toNanos(j), action0);
            TestScheduler.this.queue.add(timedAction);
            return Subscriptions.create(new Action0() { // from class: rx.schedulers.TestScheduler.InnerTestScheduler.1
                @Override // rx.functions.Action0
                public void call() {
                    TestScheduler.this.queue.remove(timedAction);
                }
            });
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedulePeriodically(Action0 action0, long j, long j2, TimeUnit timeUnit) {
            return SchedulePeriodicHelper.schedulePeriodically(this, action0, j, j2, timeUnit, this);
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.s.unsubscribe();
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action0) {
            final TimedAction timedAction = new TimedAction(this, 0L, action0);
            TestScheduler.this.queue.add(timedAction);
            return Subscriptions.create(new Action0() { // from class: rx.schedulers.TestScheduler.InnerTestScheduler.2
                @Override // rx.functions.Action0
                public void call() {
                    TestScheduler.this.queue.remove(timedAction);
                }
            });
        }
    }
}
