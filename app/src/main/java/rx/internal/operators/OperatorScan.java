package rx.internal.operators;

import android.Manifest;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.functions.Func2;
import rx.internal.util.atomic.SpscLinkedAtomicQueue;
import rx.internal.util.unsafe.SpscLinkedQueue;
import rx.internal.util.unsafe.UnsafeAccess;

/* loaded from: classes5.dex */
public final class OperatorScan<R, T> implements Observable.Operator<R, T> {
    private static final Object NO_INITIAL_VALUE = new Object();
    public final Func2<R, ? super T, R> accumulator;
    private final Func0<R> initialValueFactory;

    public static final class InitialProducer<R> implements Producer, Observer<R> {
        public final Subscriber<? super R> child;
        public volatile boolean done;
        public boolean emitting;
        public Throwable error;
        public boolean missed;
        public long missedRequested;
        public volatile Producer producer;
        public final Queue<Object> queue;
        public final AtomicLong requested;

        public InitialProducer(R r, Subscriber<? super R> subscriber) {
            this.child = subscriber;
            Queue<Object> spscLinkedQueue = UnsafeAccess.isUnsafeAvailable() ? new SpscLinkedQueue<>() : new SpscLinkedAtomicQueue<>();
            this.queue = spscLinkedQueue;
            spscLinkedQueue.offer(NotificationLite.next(r));
            this.requested = new AtomicLong();
        }

        public boolean checkTerminated(boolean z, boolean z2, Subscriber<? super R> subscriber) {
            if (subscriber.isUnsubscribed()) {
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.error;
            if (th != null) {
                subscriber.onError(th);
                return true;
            }
            if (!z2) {
                return false;
            }
            subscriber.onCompleted();
            return true;
        }

        public void emit() {
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                } else {
                    this.emitting = true;
                    emitLoop();
                }
            }
        }

        public void emitLoop() {
            Subscriber<? super R> subscriber = this.child;
            Queue<Object> queue = this.queue;
            AtomicLong atomicLong = this.requested;
            long jProduced = atomicLong.get();
            while (!checkTerminated(this.done, queue.isEmpty(), subscriber)) {
                long j = 0;
                while (j != jProduced) {
                    boolean z = this.done;
                    Object objPoll = queue.poll();
                    boolean z2 = objPoll == null;
                    if (checkTerminated(z, z2, subscriber)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    Manifest manifest = (Object) NotificationLite.getValue(objPoll);
                    try {
                        subscriber.onNext(manifest);
                        j++;
                    } catch (Throwable th) {
                        Exceptions.throwOrReport(th, subscriber, manifest);
                        return;
                    }
                }
                if (j != 0 && jProduced != Long.MAX_VALUE) {
                    jProduced = BackpressureUtils.produced(atomicLong, j);
                }
                synchronized (this) {
                    if (!this.missed) {
                        this.emitting = false;
                        return;
                    }
                    this.missed = false;
                }
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.done = true;
            emit();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            emit();
        }

        @Override // rx.Observer
        public void onNext(R r) {
            this.queue.offer(NotificationLite.next(r));
            emit();
        }

        @Override // rx.Producer
        public void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j);
            }
            if (j != 0) {
                BackpressureUtils.getAndAddRequest(this.requested, j);
                Producer producer = this.producer;
                if (producer == null) {
                    synchronized (this.requested) {
                        producer = this.producer;
                        if (producer == null) {
                            this.missedRequested = BackpressureUtils.addCap(this.missedRequested, j);
                        }
                    }
                }
                if (producer != null) {
                    producer.request(j);
                }
                emit();
            }
        }

        public void setProducer(Producer producer) {
            long j;
            Objects.requireNonNull(producer);
            synchronized (this.requested) {
                if (this.producer != null) {
                    throw new IllegalStateException("Can't set more than one Producer!");
                }
                j = this.missedRequested;
                if (j != Long.MAX_VALUE) {
                    j--;
                }
                this.missedRequested = 0L;
                this.producer = producer;
            }
            if (j > 0) {
                producer.request(j);
            }
            emit();
        }
    }

    public OperatorScan(final R r, Func2<R, ? super T, R> func2) {
        this((Func0) new Func0<R>() { // from class: rx.internal.operators.OperatorScan.1
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public R call() {
                return (R) r;
            }
        }, (Func2) func2);
    }

    public OperatorScan(Func0<R> func0, Func2<R, ? super T, R> func2) {
        this.initialValueFactory = func0;
        this.accumulator = func2;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super R> subscriber) {
        R rCall = this.initialValueFactory.call();
        if (rCall == NO_INITIAL_VALUE) {
            return new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorScan.2
                public boolean once;
                public R value;

                @Override // rx.Observer
                public void onCompleted() {
                    subscriber.onCompleted();
                }

                @Override // rx.Observer
                public void onError(Throwable th) {
                    subscriber.onError(th);
                }

                @Override // rx.Observer
                public void onNext(T t) {
                    if (this.once) {
                        try {
                            t = OperatorScan.this.accumulator.call(this.value, t);
                        } catch (Throwable th) {
                            Exceptions.throwOrReport(th, subscriber, t);
                            return;
                        }
                    } else {
                        this.once = true;
                    }
                    this.value = (R) t;
                    subscriber.onNext(t);
                }
            };
        }
        InitialProducer initialProducer = new InitialProducer(rCall, subscriber);
        Subscriber<T> subscriber2 = new Subscriber<T>(rCall, initialProducer) { // from class: rx.internal.operators.OperatorScan.3
            public final /* synthetic */ Object val$initialValue;
            public final /* synthetic */ InitialProducer val$ip;
            private R value;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.val$initialValue = rCall;
                this.val$ip = initialProducer;
                this.value = rCall;
            }

            @Override // rx.Observer
            public void onCompleted() {
                this.val$ip.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                this.val$ip.onError(th);
            }

            @Override // rx.Observer
            public void onNext(T t) {
                try {
                    R rCall2 = OperatorScan.this.accumulator.call(this.value, t);
                    this.value = rCall2;
                    this.val$ip.onNext(rCall2);
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, this, t);
                }
            }

            @Override // rx.Subscriber, rx.observers.AssertableSubscriber
            public void setProducer(Producer producer) {
                this.val$ip.setProducer(producer);
            }
        };
        subscriber.add(subscriber2);
        subscriber.setProducer(initialProducer);
        return subscriber2;
    }

    public OperatorScan(Func2<R, ? super T, R> func2) {
        this(NO_INITIAL_VALUE, func2);
    }
}
