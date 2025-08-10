package rx.internal.operators;

import java.util.concurrent.TimeoutException;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.internal.producers.ProducerArbiter;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

/* loaded from: classes5.dex */
public class OperatorTimeoutBase<T> implements Observable.Operator<T, T> {
    public final FirstTimeoutStub<T> firstTimeoutStub;
    public final Observable<? extends T> other;
    public final Scheduler scheduler;
    public final TimeoutStub<T> timeoutStub;

    public interface FirstTimeoutStub<T> extends Func3<TimeoutSubscriber<T>, Long, Scheduler.Worker, Subscription> {
    }

    public interface TimeoutStub<T> extends Func4<TimeoutSubscriber<T>, Long, T, Scheduler.Worker, Subscription> {
    }

    public static final class TimeoutSubscriber<T> extends Subscriber<T> {
        public long actual;
        public final ProducerArbiter arbiter = new ProducerArbiter();
        public final Scheduler.Worker inner;
        public final Observable<? extends T> other;
        public final SerialSubscription serial;
        public final SerializedSubscriber<T> serializedSubscriber;
        public boolean terminated;
        public final TimeoutStub<T> timeoutStub;

        public TimeoutSubscriber(SerializedSubscriber<T> serializedSubscriber, TimeoutStub<T> timeoutStub, SerialSubscription serialSubscription, Observable<? extends T> observable, Scheduler.Worker worker) {
            this.serializedSubscriber = serializedSubscriber;
            this.timeoutStub = timeoutStub;
            this.serial = serialSubscription;
            this.other = observable;
            this.inner = worker;
        }

        @Override // rx.Observer
        public void onCompleted() {
            boolean z;
            synchronized (this) {
                z = true;
                if (this.terminated) {
                    z = false;
                } else {
                    this.terminated = true;
                }
            }
            if (z) {
                this.serial.unsubscribe();
                this.serializedSubscriber.onCompleted();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            boolean z;
            synchronized (this) {
                z = true;
                if (this.terminated) {
                    z = false;
                } else {
                    this.terminated = true;
                }
            }
            if (z) {
                this.serial.unsubscribe();
                this.serializedSubscriber.onError(th);
            }
        }

        @Override // rx.Observer
        public void onNext(T t) {
            long j;
            boolean z;
            synchronized (this) {
                if (this.terminated) {
                    j = this.actual;
                    z = false;
                } else {
                    j = this.actual + 1;
                    this.actual = j;
                    z = true;
                }
            }
            if (z) {
                this.serializedSubscriber.onNext(t);
                this.serial.set(this.timeoutStub.call(this, Long.valueOf(j), t, this.inner));
            }
        }

        public void onTimeout(long j) {
            boolean z;
            synchronized (this) {
                z = true;
                if (j != this.actual || this.terminated) {
                    z = false;
                } else {
                    this.terminated = true;
                }
            }
            if (z) {
                if (this.other == null) {
                    this.serializedSubscriber.onError(new TimeoutException());
                    return;
                }
                Subscriber<T> subscriber = new Subscriber<T>() { // from class: rx.internal.operators.OperatorTimeoutBase.TimeoutSubscriber.1
                    @Override // rx.Observer
                    public void onCompleted() {
                        TimeoutSubscriber.this.serializedSubscriber.onCompleted();
                    }

                    @Override // rx.Observer
                    public void onError(Throwable th) {
                        TimeoutSubscriber.this.serializedSubscriber.onError(th);
                    }

                    @Override // rx.Observer
                    public void onNext(T t) {
                        TimeoutSubscriber.this.serializedSubscriber.onNext(t);
                    }

                    @Override // rx.Subscriber, rx.observers.AssertableSubscriber
                    public void setProducer(Producer producer) {
                        TimeoutSubscriber.this.arbiter.setProducer(producer);
                    }
                };
                this.other.unsafeSubscribe(subscriber);
                this.serial.set(subscriber);
            }
        }

        @Override // rx.Subscriber, rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            this.arbiter.setProducer(producer);
        }
    }

    public OperatorTimeoutBase(FirstTimeoutStub<T> firstTimeoutStub, TimeoutStub<T> timeoutStub, Observable<? extends T> observable, Scheduler scheduler) {
        this.firstTimeoutStub = firstTimeoutStub;
        this.timeoutStub = timeoutStub;
        this.other = observable;
        this.scheduler = scheduler;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Scheduler.Worker workerCreateWorker = this.scheduler.createWorker();
        subscriber.add(workerCreateWorker);
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        SerialSubscription serialSubscription = new SerialSubscription();
        serializedSubscriber.add(serialSubscription);
        TimeoutSubscriber timeoutSubscriber = new TimeoutSubscriber(serializedSubscriber, this.timeoutStub, serialSubscription, this.other, workerCreateWorker);
        serializedSubscriber.add(timeoutSubscriber);
        serializedSubscriber.setProducer(timeoutSubscriber.arbiter);
        serialSubscription.set(this.firstTimeoutStub.call(timeoutSubscriber, 0L, workerCreateWorker));
        return timeoutSubscriber;
    }
}
