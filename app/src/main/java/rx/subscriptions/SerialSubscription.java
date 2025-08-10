package rx.subscriptions;

import rx.Subscription;
import rx.internal.subscriptions.SequentialSubscription;

/* loaded from: classes5.dex */
public final class SerialSubscription implements Subscription {
    public final SequentialSubscription state = new SequentialSubscription();

    public Subscription get() {
        return this.state.current();
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.state.isUnsubscribed();
    }

    public void set(Subscription subscription) {
        if (subscription == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        this.state.update(subscription);
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.state.unsubscribe();
    }
}
