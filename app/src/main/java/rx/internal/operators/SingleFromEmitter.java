package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Single;
import rx.SingleEmitter;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.functions.Cancellable;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
import rx.plugins.RxJavaHooks;

/* loaded from: classes5.dex */
public final class SingleFromEmitter<T> implements Single.OnSubscribe<T> {
    public final Action1<SingleEmitter<T>> producer;

    public static final class SingleEmitterImpl<T> extends AtomicBoolean implements SingleEmitter<T>, Subscription {
        private static final long serialVersionUID = 8082834163465882809L;
        public final SingleSubscriber<? super T> actual;
        public final SequentialSubscription resource = new SequentialSubscription();

        public SingleEmitterImpl(SingleSubscriber<? super T> singleSubscriber) {
            this.actual = singleSubscriber;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return get();
        }

        @Override // rx.SingleEmitter
        public void onError(Throwable th) {
            if (th == null) {
                th = new NullPointerException();
            }
            if (!compareAndSet(false, true)) {
                RxJavaHooks.onError(th);
                return;
            }
            try {
                this.actual.onError(th);
            } finally {
                this.resource.unsubscribe();
            }
        }

        @Override // rx.SingleEmitter
        public void onSuccess(T t) {
            if (compareAndSet(false, true)) {
                try {
                    this.actual.onSuccess(t);
                } finally {
                    this.resource.unsubscribe();
                }
            }
        }

        @Override // rx.SingleEmitter
        public void setCancellation(Cancellable cancellable) {
            setSubscription(new CancellableSubscription(cancellable));
        }

        @Override // rx.SingleEmitter
        public void setSubscription(Subscription subscription) {
            this.resource.update(subscription);
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.resource.unsubscribe();
            }
        }
    }

    public SingleFromEmitter(Action1<SingleEmitter<T>> action1) {
        this.producer = action1;
    }

    @Override // rx.functions.Action1
    public void call(SingleSubscriber<? super T> singleSubscriber) {
        SingleEmitterImpl singleEmitterImpl = new SingleEmitterImpl(singleSubscriber);
        singleSubscriber.add(singleEmitterImpl);
        try {
            this.producer.call(singleEmitterImpl);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            singleEmitterImpl.onError(th);
        }
    }
}
