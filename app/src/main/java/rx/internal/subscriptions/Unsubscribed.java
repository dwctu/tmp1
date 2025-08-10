package rx.internal.subscriptions;

import rx.Subscription;

/* loaded from: classes5.dex */
public enum Unsubscribed implements Subscription {
    INSTANCE;

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
    }
}
