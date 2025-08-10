package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.plugins.RxJavaHooks;

/* loaded from: classes5.dex */
public final class OnSubscribeDetach<T> implements Observable.OnSubscribe<T> {
    public final Observable<T> source;

    public static final class DetachProducer<T> implements Producer, Subscription {
        public final DetachSubscriber<T> parent;

        public DetachProducer(DetachSubscriber<T> detachSubscriber) {
            this.parent = detachSubscriber;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.parent.isUnsubscribed();
        }

        @Override // rx.Producer
        public void request(long j) {
            this.parent.innerRequest(j);
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.parent.innerUnsubscribe();
        }
    }

    public static final class DetachSubscriber<T> extends Subscriber<T> {
        public final AtomicReference<Subscriber<? super T>> actual;
        public final AtomicReference<Producer> producer = new AtomicReference<>();
        public final AtomicLong requested = new AtomicLong();

        public DetachSubscriber(Subscriber<? super T> subscriber) {
            this.actual = new AtomicReference<>(subscriber);
        }

        public void innerRequest(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
            Producer producer = this.producer.get();
            if (producer != null) {
                producer.request(j);
                return;
            }
            BackpressureUtils.getAndAddRequest(this.requested, j);
            Producer producer2 = this.producer.get();
            if (producer2 == null || producer2 == TerminatedProducer.INSTANCE) {
                return;
            }
            producer2.request(this.requested.getAndSet(0L));
        }

        public void innerUnsubscribe() {
            this.producer.lazySet(TerminatedProducer.INSTANCE);
            this.actual.lazySet(null);
            unsubscribe();
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.producer.lazySet(TerminatedProducer.INSTANCE);
            Subscriber<? super T> andSet = this.actual.getAndSet(null);
            if (andSet != null) {
                andSet.onCompleted();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.producer.lazySet(TerminatedProducer.INSTANCE);
            Subscriber<? super T> andSet = this.actual.getAndSet(null);
            if (andSet != null) {
                andSet.onError(th);
            } else {
                RxJavaHooks.onError(th);
            }
        }

        @Override // rx.Observer
        public void onNext(T t) {
            Subscriber<? super T> subscriber = this.actual.get();
            if (subscriber != null) {
                subscriber.onNext(t);
            }
        }

        @Override // rx.Subscriber, rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            if (this.producer.compareAndSet(null, producer)) {
                producer.request(this.requested.getAndSet(0L));
            } else if (this.producer.get() != TerminatedProducer.INSTANCE) {
                throw new IllegalStateException("Producer already set!");
            }
        }
    }

    public enum TerminatedProducer implements Producer {
        INSTANCE;

        @Override // rx.Producer
        public void request(long j) {
        }
    }

    public OnSubscribeDetach(Observable<T> observable) {
        this.source = observable;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        DetachSubscriber detachSubscriber = new DetachSubscriber(subscriber);
        DetachProducer detachProducer = new DetachProducer(detachSubscriber);
        subscriber.add(detachProducer);
        subscriber.setProducer(detachProducer);
        this.source.unsafeSubscribe(detachSubscriber);
    }
}
