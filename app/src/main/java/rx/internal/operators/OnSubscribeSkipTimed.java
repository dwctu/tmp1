package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;

/* loaded from: classes5.dex */
public final class OnSubscribeSkipTimed<T> implements Observable.OnSubscribe<T> {
    public final Scheduler scheduler;
    public final Observable<T> source;
    public final long time;
    public final TimeUnit unit;

    public static final class SkipTimedSubscriber<T> extends Subscriber<T> implements Action0 {
        public final Subscriber<? super T> child;
        public volatile boolean gate;

        public SkipTimedSubscriber(Subscriber<? super T> subscriber) {
            this.child = subscriber;
        }

        @Override // rx.functions.Action0
        public void call() {
            this.gate = true;
        }

        @Override // rx.Observer
        public void onCompleted() {
            try {
                this.child.onCompleted();
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            try {
                this.child.onError(th);
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (this.gate) {
                this.child.onNext(t);
            }
        }
    }

    public OnSubscribeSkipTimed(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.source = observable;
        this.time = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        Scheduler.Worker workerCreateWorker = this.scheduler.createWorker();
        SkipTimedSubscriber skipTimedSubscriber = new SkipTimedSubscriber(subscriber);
        skipTimedSubscriber.add(workerCreateWorker);
        subscriber.add(skipTimedSubscriber);
        workerCreateWorker.schedule(skipTimedSubscriber, this.time, this.unit);
        this.source.unsafeSubscribe(skipTimedSubscriber);
    }
}
