package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;

/* loaded from: classes5.dex */
public abstract class DeferredScalarSubscriber<T, R> extends Subscriber<T> {
    public static final int HAS_REQUEST_HAS_VALUE = 3;
    public static final int HAS_REQUEST_NO_VALUE = 1;
    public static final int NO_REQUEST_HAS_VALUE = 2;
    public static final int NO_REQUEST_NO_VALUE = 0;
    public final Subscriber<? super R> actual;
    public boolean hasValue;
    public final AtomicInteger state = new AtomicInteger();
    public R value;

    public static final class InnerProducer implements Producer {
        public final DeferredScalarSubscriber<?, ?> parent;

        public InnerProducer(DeferredScalarSubscriber<?, ?> deferredScalarSubscriber) {
            this.parent = deferredScalarSubscriber;
        }

        @Override // rx.Producer
        public void request(long j) {
            this.parent.downstreamRequest(j);
        }
    }

    public DeferredScalarSubscriber(Subscriber<? super R> subscriber) {
        this.actual = subscriber;
    }

    public final void complete() {
        this.actual.onCompleted();
    }

    public final void downstreamRequest(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }
        if (j != 0) {
            Subscriber<? super R> subscriber = this.actual;
            do {
                int i = this.state.get();
                if (i == 1 || i == 3 || subscriber.isUnsubscribed()) {
                    return;
                }
                if (i == 2) {
                    if (this.state.compareAndSet(2, 3)) {
                        subscriber.onNext(this.value);
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        subscriber.onCompleted();
                        return;
                    }
                    return;
                }
            } while (!this.state.compareAndSet(0, 1));
        }
    }

    @Override // rx.Observer
    public void onCompleted() {
        if (this.hasValue) {
            complete(this.value);
        } else {
            complete();
        }
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        this.value = null;
        this.actual.onError(th);
    }

    @Override // rx.Subscriber, rx.observers.AssertableSubscriber
    public final void setProducer(Producer producer) {
        producer.request(Long.MAX_VALUE);
    }

    public final void setupDownstream() {
        Subscriber<? super R> subscriber = this.actual;
        subscriber.add(this);
        subscriber.setProducer(new InnerProducer(this));
    }

    public final void subscribeTo(Observable<? extends T> observable) {
        setupDownstream();
        observable.unsafeSubscribe(this);
    }

    public final void complete(R r) {
        Subscriber<? super R> subscriber = this.actual;
        do {
            int i = this.state.get();
            if (i == 2 || i == 3 || subscriber.isUnsubscribed()) {
                return;
            }
            if (i == 1) {
                subscriber.onNext(r);
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onCompleted();
                }
                this.state.lazySet(3);
                return;
            }
            this.value = r;
        } while (!this.state.compareAndSet(0, 2));
    }
}
