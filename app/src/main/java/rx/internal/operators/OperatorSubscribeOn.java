package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;

/* loaded from: classes5.dex */
public final class OperatorSubscribeOn<T> implements Observable.OnSubscribe<T> {
    public final boolean requestOn;
    public final Scheduler scheduler;
    public final Observable<T> source;

    public static final class SubscribeOnSubscriber<T> extends Subscriber<T> implements Action0 {
        public final Subscriber<? super T> actual;
        public final boolean requestOn;
        public Observable<T> source;
        public Thread t;
        public final Scheduler.Worker worker;

        public SubscribeOnSubscriber(Subscriber<? super T> subscriber, boolean z, Scheduler.Worker worker, Observable<T> observable) {
            this.actual = subscriber;
            this.requestOn = z;
            this.worker = worker;
            this.source = observable;
        }

        @Override // rx.functions.Action0
        public void call() {
            Observable<T> observable = this.source;
            this.source = null;
            this.t = Thread.currentThread();
            observable.unsafeSubscribe(this);
        }

        @Override // rx.Observer
        public void onCompleted() {
            try {
                this.actual.onCompleted();
            } finally {
                this.worker.unsubscribe();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            try {
                this.actual.onError(th);
            } finally {
                this.worker.unsubscribe();
            }
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // rx.Subscriber, rx.observers.AssertableSubscriber
        public void setProducer(final Producer producer) {
            this.actual.setProducer(new Producer() { // from class: rx.internal.operators.OperatorSubscribeOn.SubscribeOnSubscriber.1
                @Override // rx.Producer
                public void request(final long j) {
                    if (SubscribeOnSubscriber.this.t != Thread.currentThread()) {
                        SubscribeOnSubscriber subscribeOnSubscriber = SubscribeOnSubscriber.this;
                        if (subscribeOnSubscriber.requestOn) {
                            subscribeOnSubscriber.worker.schedule(new Action0() { // from class: rx.internal.operators.OperatorSubscribeOn.SubscribeOnSubscriber.1.1
                                @Override // rx.functions.Action0
                                public void call() {
                                    producer.request(j);
                                }
                            });
                            return;
                        }
                    }
                    producer.request(j);
                }
            });
        }
    }

    public OperatorSubscribeOn(Observable<T> observable, Scheduler scheduler, boolean z) {
        this.scheduler = scheduler;
        this.source = observable;
        this.requestOn = z;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        Scheduler.Worker workerCreateWorker = this.scheduler.createWorker();
        SubscribeOnSubscriber subscribeOnSubscriber = new SubscribeOnSubscriber(subscriber, this.requestOn, workerCreateWorker, this.source);
        subscriber.add(subscribeOnSubscriber);
        subscriber.add(workerCreateWorker);
        workerCreateWorker.schedule(subscribeOnSubscriber);
    }
}
