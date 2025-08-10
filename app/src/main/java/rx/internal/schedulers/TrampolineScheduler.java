package rx.internal.schedulers;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.BooleanSubscription;
import rx.subscriptions.Subscriptions;

/* loaded from: classes5.dex */
public final class TrampolineScheduler extends Scheduler {
    public static final TrampolineScheduler INSTANCE = new TrampolineScheduler();

    public static final class InnerCurrentThreadScheduler extends Scheduler.Worker implements Subscription {
        public final AtomicInteger counter = new AtomicInteger();
        public final PriorityBlockingQueue<TimedAction> queue = new PriorityBlockingQueue<>();
        private final BooleanSubscription innerSubscription = new BooleanSubscription();
        private final AtomicInteger wip = new AtomicInteger();

        private Subscription enqueue(Action0 action0, long j) {
            if (this.innerSubscription.isUnsubscribed()) {
                return Subscriptions.unsubscribed();
            }
            final TimedAction timedAction = new TimedAction(action0, Long.valueOf(j), this.counter.incrementAndGet());
            this.queue.add(timedAction);
            if (this.wip.getAndIncrement() != 0) {
                return Subscriptions.create(new Action0() { // from class: rx.internal.schedulers.TrampolineScheduler.InnerCurrentThreadScheduler.1
                    @Override // rx.functions.Action0
                    public void call() {
                        InnerCurrentThreadScheduler.this.queue.remove(timedAction);
                    }
                });
            }
            do {
                TimedAction timedActionPoll = this.queue.poll();
                if (timedActionPoll != null) {
                    timedActionPoll.action.call();
                }
            } while (this.wip.decrementAndGet() > 0);
            return Subscriptions.unsubscribed();
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.innerSubscription.isUnsubscribed();
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action0) {
            return enqueue(action0, now());
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.innerSubscription.unsubscribe();
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action0, long j, TimeUnit timeUnit) {
            long jNow = now() + timeUnit.toMillis(j);
            return enqueue(new SleepingAction(action0, this, jNow), jNow);
        }
    }

    public static final class TimedAction implements Comparable<TimedAction> {
        public final Action0 action;
        public final int count;
        public final Long execTime;

        public TimedAction(Action0 action0, Long l, int i) {
            this.action = action0;
            this.execTime = l;
            this.count = i;
        }

        @Override // java.lang.Comparable
        public int compareTo(TimedAction timedAction) {
            int iCompareTo = this.execTime.compareTo(timedAction.execTime);
            return iCompareTo == 0 ? TrampolineScheduler.compare(this.count, timedAction.count) : iCompareTo;
        }
    }

    private TrampolineScheduler() {
    }

    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        return new InnerCurrentThreadScheduler();
    }
}
