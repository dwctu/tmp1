package org.greenrobot.eventbus;

/* loaded from: classes5.dex */
public final class Subscription {
    public volatile boolean active = true;
    public final Object subscriber;
    public final SubscriberMethod subscriberMethod;

    public Subscription(Object obj, SubscriberMethod subscriberMethod) {
        this.subscriber = obj;
        this.subscriberMethod = subscriberMethod;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Subscription)) {
            return false;
        }
        Subscription subscription = (Subscription) obj;
        return this.subscriber == subscription.subscriber && this.subscriberMethod.equals(subscription.subscriberMethod);
    }

    public int hashCode() {
        return this.subscriber.hashCode() + this.subscriberMethod.methodString.hashCode();
    }
}
