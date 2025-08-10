package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.subscriptions.SerialSubscription;

/* loaded from: classes5.dex */
public final class CompletableOnSubscribeConcatArray implements Completable.OnSubscribe {
    public final Completable[] sources;

    public static final class ConcatInnerSubscriber extends AtomicInteger implements CompletableSubscriber {
        private static final long serialVersionUID = -7965400327305809232L;
        public final CompletableSubscriber actual;
        public int index;
        public final SerialSubscription sd = new SerialSubscription();
        public final Completable[] sources;

        public ConcatInnerSubscriber(CompletableSubscriber completableSubscriber, Completable[] completableArr) {
            this.actual = completableSubscriber;
            this.sources = completableArr;
        }

        public void next() {
            if (!this.sd.isUnsubscribed() && getAndIncrement() == 0) {
                Completable[] completableArr = this.sources;
                while (!this.sd.isUnsubscribed()) {
                    int i = this.index;
                    this.index = i + 1;
                    if (i == completableArr.length) {
                        this.actual.onCompleted();
                        return;
                    } else {
                        completableArr[i].unsafeSubscribe(this);
                        if (decrementAndGet() == 0) {
                            return;
                        }
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

    public CompletableOnSubscribeConcatArray(Completable[] completableArr) {
        this.sources = completableArr;
    }

    @Override // rx.functions.Action1
    public void call(CompletableSubscriber completableSubscriber) {
        ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(completableSubscriber, this.sources);
        completableSubscriber.onSubscribe(concatInnerSubscriber.sd);
        concatInnerSubscriber.next();
    }
}
