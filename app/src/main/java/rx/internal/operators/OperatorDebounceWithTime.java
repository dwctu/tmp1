package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

/* loaded from: classes5.dex */
public final class OperatorDebounceWithTime<T> implements Observable.Operator<T, T> {
    public final Scheduler scheduler;
    public final long timeout;
    public final TimeUnit unit;

    /* renamed from: rx.internal.operators.OperatorDebounceWithTime$1, reason: invalid class name */
    public class AnonymousClass1 extends Subscriber<T> {
        public final Subscriber<?> self;
        public final DebounceState<T> state;
        public final /* synthetic */ SerializedSubscriber val$s;
        public final /* synthetic */ SerialSubscription val$serial;
        public final /* synthetic */ Scheduler.Worker val$worker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Subscriber subscriber, SerialSubscription serialSubscription, Scheduler.Worker worker, SerializedSubscriber serializedSubscriber) {
            super(subscriber);
            this.val$serial = serialSubscription;
            this.val$worker = worker;
            this.val$s = serializedSubscriber;
            this.state = new DebounceState<>();
            this.self = this;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.state.emitAndComplete(this.val$s, this);
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.val$s.onError(th);
            unsubscribe();
            this.state.clear();
        }

        @Override // rx.Observer
        public void onNext(T t) {
            final int next = this.state.next(t);
            SerialSubscription serialSubscription = this.val$serial;
            Scheduler.Worker worker = this.val$worker;
            Action0 action0 = new Action0() { // from class: rx.internal.operators.OperatorDebounceWithTime.1.1
                @Override // rx.functions.Action0
                public void call() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    anonymousClass1.state.emit(next, anonymousClass1.val$s, anonymousClass1.self);
                }
            };
            OperatorDebounceWithTime operatorDebounceWithTime = OperatorDebounceWithTime.this;
            serialSubscription.set(worker.schedule(action0, operatorDebounceWithTime.timeout, operatorDebounceWithTime.unit));
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    public static final class DebounceState<T> {
        public boolean emitting;
        public boolean hasValue;
        public int index;
        public boolean terminate;
        public T value;

        public synchronized void clear() {
            this.index++;
            this.value = null;
            this.hasValue = false;
        }

        public void emit(int i, Subscriber<T> subscriber, Subscriber<?> subscriber2) {
            synchronized (this) {
                if (!this.emitting && this.hasValue && i == this.index) {
                    T t = this.value;
                    this.value = null;
                    this.hasValue = false;
                    this.emitting = true;
                    try {
                        subscriber.onNext(t);
                        synchronized (this) {
                            if (this.terminate) {
                                subscriber.onCompleted();
                            } else {
                                this.emitting = false;
                            }
                        }
                    } catch (Throwable th) {
                        Exceptions.throwOrReport(th, subscriber2, t);
                    }
                }
            }
        }

        public void emitAndComplete(Subscriber<T> subscriber, Subscriber<?> subscriber2) {
            synchronized (this) {
                if (this.emitting) {
                    this.terminate = true;
                    return;
                }
                T t = this.value;
                boolean z = this.hasValue;
                this.value = null;
                this.hasValue = false;
                this.emitting = true;
                if (z) {
                    try {
                        subscriber.onNext(t);
                    } catch (Throwable th) {
                        Exceptions.throwOrReport(th, subscriber2, t);
                        return;
                    }
                }
                subscriber.onCompleted();
            }
        }

        public synchronized int next(T t) {
            int i;
            this.value = t;
            this.hasValue = true;
            i = this.index + 1;
            this.index = i;
            return i;
        }
    }

    public OperatorDebounceWithTime(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.timeout = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Scheduler.Worker workerCreateWorker = this.scheduler.createWorker();
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        SerialSubscription serialSubscription = new SerialSubscription();
        serializedSubscriber.add(workerCreateWorker);
        serializedSubscriber.add(serialSubscription);
        return new AnonymousClass1(subscriber, serialSubscription, workerCreateWorker, serializedSubscriber);
    }
}
