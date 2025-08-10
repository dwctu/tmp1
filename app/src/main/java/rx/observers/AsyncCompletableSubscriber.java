package rx.observers;

import java.util.concurrent.atomic.AtomicReference;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.plugins.RxJavaHooks;

/* loaded from: classes5.dex */
public abstract class AsyncCompletableSubscriber implements CompletableSubscriber, Subscription {
    public static final Unsubscribed UNSUBSCRIBED = new Unsubscribed();
    private final AtomicReference<Subscription> upstream = new AtomicReference<>();

    public static final class Unsubscribed implements Subscription {
        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return true;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
        }
    }

    public final void clear() {
        this.upstream.set(UNSUBSCRIBED);
    }

    @Override // rx.Subscription
    public final boolean isUnsubscribed() {
        return this.upstream.get() == UNSUBSCRIBED;
    }

    public void onStart() {
    }

    @Override // rx.CompletableSubscriber
    public final void onSubscribe(Subscription subscription) {
        if (this.upstream.compareAndSet(null, subscription)) {
            onStart();
            return;
        }
        subscription.unsubscribe();
        if (this.upstream.get() != UNSUBSCRIBED) {
            RxJavaHooks.onError(new IllegalStateException("Subscription already set!"));
        }
    }

    @Override // rx.Subscription
    public final void unsubscribe() {
        Subscription andSet;
        Subscription subscription = this.upstream.get();
        Unsubscribed unsubscribed = UNSUBSCRIBED;
        if (subscription == unsubscribed || (andSet = this.upstream.getAndSet(unsubscribed)) == null || andSet == unsubscribed) {
            return;
        }
        andSet.unsubscribe();
    }
}
