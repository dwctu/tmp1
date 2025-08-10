package rx.internal.operators;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

/* loaded from: classes5.dex */
public class OperatorUnsubscribeOn<T> implements Observable.Operator<T, T> {
    public final Scheduler scheduler;

    public OperatorUnsubscribeOn(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        final Subscriber<T> subscriber2 = new Subscriber<T>() { // from class: rx.internal.operators.OperatorUnsubscribeOn.1
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
                subscriber.onNext(t);
            }
        };
        subscriber.add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.OperatorUnsubscribeOn.2
            @Override // rx.functions.Action0
            public void call() {
                final Scheduler.Worker workerCreateWorker = OperatorUnsubscribeOn.this.scheduler.createWorker();
                workerCreateWorker.schedule(new Action0() { // from class: rx.internal.operators.OperatorUnsubscribeOn.2.1
                    @Override // rx.functions.Action0
                    public void call() {
                        subscriber2.unsubscribe();
                        workerCreateWorker.unsubscribe();
                    }
                });
            }
        }));
        return subscriber2;
    }
}
