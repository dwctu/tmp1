package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

/* loaded from: classes5.dex */
public class OperatorIgnoreElements<T> implements Observable.Operator<T, T> {

    public static final class Holder {
        public static final OperatorIgnoreElements<?> INSTANCE = new OperatorIgnoreElements<>();
    }

    public static <T> OperatorIgnoreElements<T> instance() {
        return (OperatorIgnoreElements<T>) Holder.INSTANCE;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        Subscriber<T> subscriber2 = new Subscriber<T>() { // from class: rx.internal.operators.OperatorIgnoreElements.1
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
            }
        };
        subscriber.add(subscriber2);
        return subscriber2;
    }
}
