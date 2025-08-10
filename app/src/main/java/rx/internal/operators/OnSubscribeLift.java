package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.plugins.RxJavaHooks;

/* loaded from: classes5.dex */
public final class OnSubscribeLift<T, R> implements Observable.OnSubscribe<R> {
    public final Observable.Operator<? extends R, ? super T> operator;
    public final Observable.OnSubscribe<T> parent;

    public OnSubscribeLift(Observable.OnSubscribe<T> onSubscribe, Observable.Operator<? extends R, ? super T> operator) {
        this.parent = onSubscribe;
        this.operator = operator;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super R> subscriber) {
        try {
            Subscriber<? super T> subscriberCall = RxJavaHooks.onObservableLift(this.operator).call(subscriber);
            try {
                subscriberCall.onStart();
                this.parent.call(subscriberCall);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                subscriberCall.onError(th);
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            subscriber.onError(th2);
        }
    }
}
