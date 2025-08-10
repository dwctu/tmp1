package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;

/* loaded from: classes5.dex */
public final class OnSubscribeTimerPeriodically implements Observable.OnSubscribe<Long> {
    public final long initialDelay;
    public final long period;
    public final Scheduler scheduler;
    public final TimeUnit unit;

    public OnSubscribeTimerPeriodically(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        this.initialDelay = j;
        this.period = j2;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    @Override // rx.functions.Action1
    public void call(final Subscriber<? super Long> subscriber) {
        final Scheduler.Worker workerCreateWorker = this.scheduler.createWorker();
        subscriber.add(workerCreateWorker);
        workerCreateWorker.schedulePeriodically(new Action0() { // from class: rx.internal.operators.OnSubscribeTimerPeriodically.1
            public long counter;

            @Override // rx.functions.Action0
            public void call() {
                try {
                    Subscriber subscriber2 = subscriber;
                    long j = this.counter;
                    this.counter = 1 + j;
                    subscriber2.onNext(Long.valueOf(j));
                } catch (Throwable th) {
                    try {
                        workerCreateWorker.unsubscribe();
                    } finally {
                        Exceptions.throwOrReport(th, subscriber);
                    }
                }
            }
        }, this.initialDelay, this.period, this.unit);
    }
}
