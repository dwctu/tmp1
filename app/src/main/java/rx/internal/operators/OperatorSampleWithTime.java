package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;

/* loaded from: classes5.dex */
public final class OperatorSampleWithTime<T> implements Observable.Operator<T, T> {
    public final Scheduler scheduler;
    public final long time;
    public final TimeUnit unit;

    public static final class SamplerSubscriber<T> extends Subscriber<T> implements Action0 {
        private static final Object EMPTY_TOKEN = new Object();
        private final Subscriber<? super T> subscriber;
        public final AtomicReference<Object> value = new AtomicReference<>(EMPTY_TOKEN);

        public SamplerSubscriber(Subscriber<? super T> subscriber) {
            this.subscriber = subscriber;
        }

        private void emitIfNonEmpty() {
            AtomicReference<Object> atomicReference = this.value;
            Object obj = EMPTY_TOKEN;
            Object andSet = atomicReference.getAndSet(obj);
            if (andSet != obj) {
                try {
                    this.subscriber.onNext(andSet);
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, this);
                }
            }
        }

        @Override // rx.functions.Action0
        public void call() {
            emitIfNonEmpty();
        }

        @Override // rx.Observer
        public void onCompleted() {
            emitIfNonEmpty();
            this.subscriber.onCompleted();
            unsubscribe();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.subscriber.onError(th);
            unsubscribe();
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.value.set(t);
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    public OperatorSampleWithTime(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.time = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        Scheduler.Worker workerCreateWorker = this.scheduler.createWorker();
        subscriber.add(workerCreateWorker);
        SamplerSubscriber samplerSubscriber = new SamplerSubscriber(serializedSubscriber);
        subscriber.add(samplerSubscriber);
        long j = this.time;
        workerCreateWorker.schedulePeriodically(samplerSubscriber, j, j, this.unit);
        return samplerSubscriber;
    }
}
