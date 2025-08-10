package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

/* loaded from: classes5.dex */
public final class OperatorOnBackpressureLatest<T> implements Observable.Operator<T, T> {

    public static final class Holder {
        public static final OperatorOnBackpressureLatest<Object> INSTANCE = new OperatorOnBackpressureLatest<>();
    }

    public static final class LatestEmitter<T> extends AtomicLong implements Producer, Subscription, Observer<T> {
        public static final Object EMPTY = new Object();
        public static final long NOT_REQUESTED = -4611686018427387904L;
        private static final long serialVersionUID = -1364393685005146274L;
        public final Subscriber<? super T> child;
        public volatile boolean done;
        public boolean emitting;
        public boolean missed;
        public LatestSubscriber<? super T> parent;
        public Throwable terminal;
        public final AtomicReference<Object> value = new AtomicReference<>(EMPTY);

        public LatestEmitter(Subscriber<? super T> subscriber) {
            this.child = subscriber;
            lazySet(-4611686018427387904L);
        }

        public void emit() throws Throwable {
            boolean z;
            Object obj;
            synchronized (this) {
                boolean z2 = true;
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                this.missed = false;
                while (true) {
                    try {
                        long j = get();
                        if (j == Long.MIN_VALUE) {
                            return;
                        }
                        Object obj2 = this.value.get();
                        if (j > 0 && obj2 != (obj = EMPTY)) {
                            this.child.onNext(obj2);
                            this.value.compareAndSet(obj2, obj);
                            produced(1L);
                            obj2 = obj;
                        }
                        if (obj2 == EMPTY && this.done) {
                            Throwable th = this.terminal;
                            if (th != null) {
                                this.child.onError(th);
                            } else {
                                this.child.onCompleted();
                            }
                        }
                        try {
                            synchronized (this) {
                                try {
                                    if (!this.missed) {
                                        this.emitting = false;
                                        return;
                                    }
                                    this.missed = false;
                                } catch (Throwable th2) {
                                    th = th2;
                                    z2 = false;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            z = z2;
                            th = th4;
                            if (!z) {
                                synchronized (this) {
                                    this.emitting = false;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        z = false;
                    }
                }
            }
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // rx.Observer
        public void onCompleted() throws Throwable {
            this.done = true;
            emit();
        }

        @Override // rx.Observer
        public void onError(Throwable th) throws Throwable {
            this.terminal = th;
            this.done = true;
            emit();
        }

        @Override // rx.Observer
        public void onNext(T t) throws Throwable {
            this.value.lazySet(t);
            emit();
        }

        public long produced(long j) {
            long j2;
            long j3;
            do {
                j2 = get();
                if (j2 < 0) {
                    return j2;
                }
                j3 = j2 - j;
            } while (!compareAndSet(j2, j3));
            return j3;
        }

        @Override // rx.Producer
        public void request(long j) throws Throwable {
            long j2;
            long j3;
            if (j >= 0) {
                do {
                    j2 = get();
                    if (j2 == Long.MIN_VALUE) {
                        return;
                    }
                    if (j2 == -4611686018427387904L) {
                        j3 = j;
                    } else {
                        j3 = j2 + j;
                        if (j3 < 0) {
                            j3 = Long.MAX_VALUE;
                        }
                    }
                } while (!compareAndSet(j2, j3));
                if (j2 == -4611686018427387904L) {
                    this.parent.requestMore(Long.MAX_VALUE);
                }
                emit();
            }
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (get() >= 0) {
                getAndSet(Long.MIN_VALUE);
            }
        }
    }

    public static final class LatestSubscriber<T> extends Subscriber<T> {
        private final LatestEmitter<T> producer;

        public LatestSubscriber(LatestEmitter<T> latestEmitter) {
            this.producer = latestEmitter;
        }

        @Override // rx.Observer
        public void onCompleted() throws Throwable {
            this.producer.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th) throws Throwable {
            this.producer.onError(th);
        }

        @Override // rx.Observer
        public void onNext(T t) throws Throwable {
            this.producer.onNext(t);
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(0L);
        }

        public void requestMore(long j) {
            request(j);
        }
    }

    public static <T> OperatorOnBackpressureLatest<T> instance() {
        return (OperatorOnBackpressureLatest<T>) Holder.INSTANCE;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        LatestEmitter latestEmitter = new LatestEmitter(subscriber);
        LatestSubscriber<? super T> latestSubscriber = new LatestSubscriber<>(latestEmitter);
        latestEmitter.parent = latestSubscriber;
        subscriber.add(latestSubscriber);
        subscriber.add(latestEmitter);
        subscriber.setProducer(latestEmitter);
        return latestSubscriber;
    }
}
