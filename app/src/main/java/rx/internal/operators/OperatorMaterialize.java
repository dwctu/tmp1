package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.plugins.RxJavaHooks;

/* loaded from: classes5.dex */
public final class OperatorMaterialize<T> implements Observable.Operator<Notification<T>, T> {

    public static final class Holder {
        public static final OperatorMaterialize<Object> INSTANCE = new OperatorMaterialize<>();
    }

    public static class ParentSubscriber<T> extends Subscriber<T> {
        private boolean busy;
        private final Subscriber<? super Notification<T>> child;
        private boolean missed;
        private final AtomicLong requested = new AtomicLong();
        private volatile Notification<T> terminalNotification;

        public ParentSubscriber(Subscriber<? super Notification<T>> subscriber) {
            this.child = subscriber;
        }

        private void decrementRequested() {
            long j;
            AtomicLong atomicLong = this.requested;
            do {
                j = atomicLong.get();
                if (j == Long.MAX_VALUE) {
                    return;
                }
            } while (!atomicLong.compareAndSet(j, j - 1));
        }

        private void drain() {
            synchronized (this) {
                if (this.busy) {
                    this.missed = true;
                    return;
                }
                AtomicLong atomicLong = this.requested;
                while (!this.child.isUnsubscribed()) {
                    Notification<T> notification = this.terminalNotification;
                    if (notification != null && atomicLong.get() > 0) {
                        this.terminalNotification = null;
                        this.child.onNext(notification);
                        if (this.child.isUnsubscribed()) {
                            return;
                        }
                        this.child.onCompleted();
                        return;
                    }
                    synchronized (this) {
                        if (!this.missed) {
                            this.busy = false;
                            return;
                        }
                    }
                }
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.terminalNotification = Notification.createOnCompleted();
            drain();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.terminalNotification = Notification.createOnError(th);
            RxJavaHooks.onError(th);
            drain();
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.child.onNext(Notification.createOnNext(t));
            decrementRequested();
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(0L);
        }

        public void requestMore(long j) {
            BackpressureUtils.getAndAddRequest(this.requested, j);
            request(j);
            drain();
        }
    }

    public static <T> OperatorMaterialize<T> instance() {
        return (OperatorMaterialize<T>) Holder.INSTANCE;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super Notification<T>> subscriber) {
        final ParentSubscriber parentSubscriber = new ParentSubscriber(subscriber);
        subscriber.add(parentSubscriber);
        subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OperatorMaterialize.1
            @Override // rx.Producer
            public void request(long j) {
                if (j > 0) {
                    parentSubscriber.requestMore(j);
                }
            }
        });
        return parentSubscriber;
    }
}
