package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.producers.SingleDelayedProducer;
import rx.plugins.RxJavaHooks;

/* loaded from: classes5.dex */
public final class OperatorAll<T> implements Observable.Operator<Boolean, T> {
    public final Func1<? super T, Boolean> predicate;

    public OperatorAll(Func1<? super T, Boolean> func1) {
        this.predicate = func1;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super Boolean> subscriber) {
        final SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(subscriber);
        Subscriber<T> subscriber2 = new Subscriber<T>() { // from class: rx.internal.operators.OperatorAll.1
            public boolean done;

            @Override // rx.Observer
            public void onCompleted() {
                if (this.done) {
                    return;
                }
                this.done = true;
                singleDelayedProducer.setValue(Boolean.TRUE);
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                if (this.done) {
                    RxJavaHooks.onError(th);
                } else {
                    this.done = true;
                    subscriber.onError(th);
                }
            }

            @Override // rx.Observer
            public void onNext(T t) {
                if (this.done) {
                    return;
                }
                try {
                    if (OperatorAll.this.predicate.call(t).booleanValue()) {
                        return;
                    }
                    this.done = true;
                    singleDelayedProducer.setValue(Boolean.FALSE);
                    unsubscribe();
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, this, t);
                }
            }
        };
        subscriber.add(subscriber2);
        subscriber.setProducer(singleDelayedProducer);
        return subscriber2;
    }
}
