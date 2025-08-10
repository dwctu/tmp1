package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Func1;

/* loaded from: classes5.dex */
public final class OperatorTakeLastTimed<T> implements Observable.Operator<T, T> {
    public final long ageMillis;
    public final int count;
    public final Scheduler scheduler;

    public static final class TakeLastTimedSubscriber<T> extends Subscriber<T> implements Func1<Object, T> {
        public final Subscriber<? super T> actual;
        public final long ageMillis;
        public final int count;
        public final Scheduler scheduler;
        public final AtomicLong requested = new AtomicLong();
        public final ArrayDeque<Object> queue = new ArrayDeque<>();
        public final ArrayDeque<Long> queueTimes = new ArrayDeque<>();

        public TakeLastTimedSubscriber(Subscriber<? super T> subscriber, int i, long j, Scheduler scheduler) {
            this.actual = subscriber;
            this.count = i;
            this.ageMillis = j;
            this.scheduler = scheduler;
        }

        @Override // rx.functions.Func1
        public T call(Object obj) {
            return (T) NotificationLite.getValue(obj);
        }

        public void evictOld(long j) {
            long j2 = j - this.ageMillis;
            while (true) {
                Long lPeek = this.queueTimes.peek();
                if (lPeek == null || lPeek.longValue() >= j2) {
                    return;
                }
                this.queue.poll();
                this.queueTimes.poll();
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            evictOld(this.scheduler.now());
            this.queueTimes.clear();
            BackpressureUtils.postCompleteDone(this.requested, this.queue, this.actual, this);
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.queue.clear();
            this.queueTimes.clear();
            this.actual.onError(th);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (this.count != 0) {
                long jNow = this.scheduler.now();
                if (this.queue.size() == this.count) {
                    this.queue.poll();
                    this.queueTimes.poll();
                }
                evictOld(jNow);
                this.queue.offer(NotificationLite.next(t));
                this.queueTimes.offer(Long.valueOf(jNow));
            }
        }

        public void requestMore(long j) {
            BackpressureUtils.postCompleteRequest(this.requested, j, this.queue, this.actual, this);
        }
    }

    public OperatorTakeLastTimed(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.ageMillis = timeUnit.toMillis(j);
        this.scheduler = scheduler;
        this.count = -1;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final TakeLastTimedSubscriber takeLastTimedSubscriber = new TakeLastTimedSubscriber(subscriber, this.count, this.ageMillis, this.scheduler);
        subscriber.add(takeLastTimedSubscriber);
        subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OperatorTakeLastTimed.1
            @Override // rx.Producer
            public void request(long j) {
                takeLastTimedSubscriber.requestMore(j);
            }
        });
        return takeLastTimedSubscriber;
    }

    public OperatorTakeLastTimed(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        if (i >= 0) {
            this.ageMillis = timeUnit.toMillis(j);
            this.scheduler = scheduler;
            this.count = i;
            return;
        }
        throw new IndexOutOfBoundsException("count could not be negative");
    }
}
