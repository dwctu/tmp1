package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.observers.SerializedSubscriber;
import rx.observers.Subscribers;
import rx.subjects.PublishSubject;

/* loaded from: classes5.dex */
public final class OperatorDelayWithSelector<T, V> implements Observable.Operator<T, T> {
    public final Func1<? super T, ? extends Observable<V>> itemDelay;
    public final Observable<? extends T> source;

    public OperatorDelayWithSelector(Observable<? extends T> observable, Func1<? super T, ? extends Observable<V>> func1) {
        this.source = observable;
        this.itemDelay = func1;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        final PublishSubject publishSubjectCreate = PublishSubject.create();
        subscriber.add(Observable.merge(publishSubjectCreate).unsafeSubscribe(Subscribers.from(serializedSubscriber)));
        return new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorDelayWithSelector.1
            @Override // rx.Observer
            public void onCompleted() {
                publishSubjectCreate.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                serializedSubscriber.onError(th);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.Observer
            public void onNext(final T t) {
                try {
                    publishSubjectCreate.onNext(OperatorDelayWithSelector.this.itemDelay.call(t).take(1).defaultIfEmpty(null).map(new Func1<V, T>() { // from class: rx.internal.operators.OperatorDelayWithSelector.1.1
                        @Override // rx.functions.Func1
                        public T call(V v) {
                            return (T) t;
                        }
                    }));
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, this);
                }
            }
        };
    }
}
