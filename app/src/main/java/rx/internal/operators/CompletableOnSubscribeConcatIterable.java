package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.subscriptions.SerialSubscription;
import rx.subscriptions.Subscriptions;

/* loaded from: classes5.dex */
public final class CompletableOnSubscribeConcatIterable implements Completable.OnSubscribe {
    public final Iterable<? extends Completable> sources;

    public static final class ConcatInnerSubscriber extends AtomicInteger implements CompletableSubscriber {
        private static final long serialVersionUID = -7965400327305809232L;
        public final CompletableSubscriber actual;
        public final SerialSubscription sd = new SerialSubscription();
        public final Iterator<? extends Completable> sources;

        public ConcatInnerSubscriber(CompletableSubscriber completableSubscriber, Iterator<? extends Completable> it) {
            this.actual = completableSubscriber;
            this.sources = it;
        }

        public void next() {
            if (!this.sd.isUnsubscribed() && getAndIncrement() == 0) {
                Iterator<? extends Completable> it = this.sources;
                while (!this.sd.isUnsubscribed()) {
                    try {
                        if (!it.hasNext()) {
                            this.actual.onCompleted();
                            return;
                        }
                        try {
                            Completable next = it.next();
                            if (next == null) {
                                this.actual.onError(new NullPointerException("The completable returned is null"));
                                return;
                            } else {
                                next.unsafeSubscribe(this);
                                if (decrementAndGet() == 0) {
                                    return;
                                }
                            }
                        } catch (Throwable th) {
                            this.actual.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        this.actual.onError(th2);
                        return;
                    }
                }
            }
        }

        @Override // rx.CompletableSubscriber
        public void onCompleted() {
            next();
        }

        @Override // rx.CompletableSubscriber
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // rx.CompletableSubscriber
        public void onSubscribe(Subscription subscription) {
            this.sd.set(subscription);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends Completable> iterable) {
        this.sources = iterable;
    }

    @Override // rx.functions.Action1
    public void call(CompletableSubscriber completableSubscriber) {
        try {
            Iterator<? extends Completable> it = this.sources.iterator();
            if (it == null) {
                completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
                completableSubscriber.onError(new NullPointerException("The iterator returned is null"));
            } else {
                ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(completableSubscriber, it);
                completableSubscriber.onSubscribe(concatInnerSubscriber.sd);
                concatInnerSubscriber.next();
            }
        } catch (Throwable th) {
            completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
            completableSubscriber.onError(th);
        }
    }
}
