package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.observers.Subscribers;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;
import rx.subscriptions.Subscriptions;

/* loaded from: classes5.dex */
public final class OnSubscribeDelaySubscriptionOther<T, U> implements Observable.OnSubscribe<T> {
    public final Observable<? extends T> main;
    public final Observable<U> other;

    public OnSubscribeDelaySubscriptionOther(Observable<? extends T> observable, Observable<U> observable2) {
        this.main = observable;
        this.other = observable2;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        final SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.add(serialSubscription);
        final Subscriber subscriberWrap = Subscribers.wrap(subscriber);
        Subscriber<U> subscriber2 = new Subscriber<U>() { // from class: rx.internal.operators.OnSubscribeDelaySubscriptionOther.1
            public boolean done;

            @Override // rx.Observer
            public void onCompleted() {
                if (this.done) {
                    return;
                }
                this.done = true;
                serialSubscription.set(Subscriptions.unsubscribed());
                OnSubscribeDelaySubscriptionOther.this.main.unsafeSubscribe(subscriberWrap);
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                if (this.done) {
                    RxJavaHooks.onError(th);
                } else {
                    this.done = true;
                    subscriberWrap.onError(th);
                }
            }

            @Override // rx.Observer
            public void onNext(U u) {
                onCompleted();
            }
        };
        serialSubscription.set(subscriber2);
        this.other.unsafeSubscribe(subscriber2);
    }
}
