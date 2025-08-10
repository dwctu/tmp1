package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;

/* loaded from: classes5.dex */
public final class OperatorTakeTimed<T> implements Observable.Operator<T, T> {
    public final Scheduler scheduler;
    public final long time;
    public final TimeUnit unit;

    public static final class TakeSubscriber<T> extends Subscriber<T> implements Action0 {
        public final Subscriber<? super T> child;

        public TakeSubscriber(Subscriber<? super T> subscriber) {
            super(subscriber);
            this.child = subscriber;
        }

        @Override // rx.functions.Action0
        public void call() {
            onCompleted();
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.child.onCompleted();
            unsubscribe();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.child.onError(th);
            unsubscribe();
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.child.onNext(t);
        }
    }

    public OperatorTakeTimed(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.time = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Scheduler.Worker workerCreateWorker = this.scheduler.createWorker();
        subscriber.add(workerCreateWorker);
        TakeSubscriber takeSubscriber = new TakeSubscriber(new SerializedSubscriber(subscriber));
        workerCreateWorker.schedule(takeSubscriber, this.time, this.unit);
        return takeSubscriber;
    }
}
