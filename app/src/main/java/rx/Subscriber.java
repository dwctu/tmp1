package rx;

import rx.internal.util.SubscriptionList;

/* loaded from: classes5.dex */
public abstract class Subscriber<T> implements Observer<T>, Subscription {
    private static final long NOT_SET = Long.MIN_VALUE;
    private Producer producer;
    private long requested;
    private final Subscriber<?> subscriber;
    private final SubscriptionList subscriptions;

    public Subscriber() {
        this(null, false);
    }

    private void addToRequested(long j) {
        long j2 = this.requested;
        if (j2 == Long.MIN_VALUE) {
            this.requested = j;
            return;
        }
        long j3 = j2 + j;
        if (j3 < 0) {
            this.requested = Long.MAX_VALUE;
        } else {
            this.requested = j3;
        }
    }

    public final void add(Subscription subscription) {
        this.subscriptions.add(subscription);
    }

    @Override // rx.Subscription
    public final boolean isUnsubscribed() {
        return this.subscriptions.isUnsubscribed();
    }

    public void onStart() {
    }

    public final void request(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("number requested cannot be negative: " + j);
        }
        synchronized (this) {
            Producer producer = this.producer;
            if (producer != null) {
                producer.request(j);
            } else {
                addToRequested(j);
            }
        }
    }

    public void setProducer(Producer producer) {
        long j;
        Subscriber<?> subscriber;
        boolean z;
        synchronized (this) {
            j = this.requested;
            this.producer = producer;
            subscriber = this.subscriber;
            z = subscriber != null && j == Long.MIN_VALUE;
        }
        if (z) {
            subscriber.setProducer(producer);
        } else if (j == Long.MIN_VALUE) {
            producer.request(Long.MAX_VALUE);
        } else {
            producer.request(j);
        }
    }

    @Override // rx.Subscription
    public final void unsubscribe() {
        this.subscriptions.unsubscribe();
    }

    public Subscriber(Subscriber<?> subscriber) {
        this(subscriber, true);
    }

    public Subscriber(Subscriber<?> subscriber, boolean z) {
        this.requested = Long.MIN_VALUE;
        this.subscriber = subscriber;
        this.subscriptions = (!z || subscriber == null) ? new SubscriptionList() : subscriber.subscriptions;
    }
}
