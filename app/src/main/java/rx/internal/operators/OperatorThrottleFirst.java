package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;

/* loaded from: classes5.dex */
public final class OperatorThrottleFirst<T> implements Observable.Operator<T, T> {
    public final Scheduler scheduler;
    public final long timeInMilliseconds;

    public OperatorThrottleFirst(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.timeInMilliseconds = timeUnit.toMillis(j);
        this.scheduler = scheduler;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorThrottleFirst.1
            private long lastOnNext = -1;

            @Override // rx.Observer
            public void onCompleted() {
                subscriber.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                subscriber.onError(th);
            }

            @Override // rx.Observer
            public void onNext(T t) {
                long jNow = OperatorThrottleFirst.this.scheduler.now();
                long j = this.lastOnNext;
                if (j == -1 || jNow < j || jNow - j >= OperatorThrottleFirst.this.timeInMilliseconds) {
                    this.lastOnNext = jNow;
                    subscriber.onNext(t);
                }
            }

            @Override // rx.Subscriber
            public void onStart() {
                request(Long.MAX_VALUE);
            }
        };
    }
}
