package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.observers.SerializedSubscriber;

/* loaded from: classes5.dex */
public final class OperatorSampleWithObservable<T, U> implements Observable.Operator<T, T> {
    public static final Object EMPTY_TOKEN = new Object();
    public final Observable<U> sampler;

    public OperatorSampleWithObservable(Observable<U> observable) {
        this.sampler = observable;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        final AtomicReference atomicReference = new AtomicReference(EMPTY_TOKEN);
        final AtomicReference atomicReference2 = new AtomicReference();
        final Subscriber<U> subscriber2 = new Subscriber<U>() { // from class: rx.internal.operators.OperatorSampleWithObservable.1
            @Override // rx.Observer
            public void onCompleted() {
                onNext(null);
                serializedSubscriber.onCompleted();
                ((Subscription) atomicReference2.get()).unsubscribe();
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                serializedSubscriber.onError(th);
                ((Subscription) atomicReference2.get()).unsubscribe();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.Observer
            public void onNext(U u) {
                AtomicReference atomicReference3 = atomicReference;
                Object obj = OperatorSampleWithObservable.EMPTY_TOKEN;
                Object andSet = atomicReference3.getAndSet(obj);
                if (andSet != obj) {
                    serializedSubscriber.onNext(andSet);
                }
            }
        };
        Subscriber<T> subscriber3 = new Subscriber<T>() { // from class: rx.internal.operators.OperatorSampleWithObservable.2
            @Override // rx.Observer
            public void onCompleted() {
                subscriber2.onNext(null);
                serializedSubscriber.onCompleted();
                subscriber2.unsubscribe();
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                serializedSubscriber.onError(th);
                subscriber2.unsubscribe();
            }

            @Override // rx.Observer
            public void onNext(T t) {
                atomicReference.set(t);
            }
        };
        atomicReference2.lazySet(subscriber3);
        subscriber.add(subscriber3);
        subscriber.add(subscriber2);
        this.sampler.unsafeSubscribe(subscriber2);
        return subscriber3;
    }
}
