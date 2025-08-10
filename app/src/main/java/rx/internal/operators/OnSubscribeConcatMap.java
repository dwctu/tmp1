package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Func1;
import rx.internal.producers.ProducerArbiter;
import rx.internal.util.ExceptionsUtils;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.observers.SerializedSubscriber;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;

/* loaded from: classes5.dex */
public final class OnSubscribeConcatMap<T, R> implements Observable.OnSubscribe<R> {
    public static final int BOUNDARY = 1;
    public static final int END = 2;
    public static final int IMMEDIATE = 0;
    public final int delayErrorMode;
    public final Func1<? super T, ? extends Observable<? extends R>> mapper;
    public final int prefetch;
    public final Observable<? extends T> source;

    public static final class ConcatMapInnerScalarProducer<T, R> implements Producer {
        public boolean once;
        public final ConcatMapSubscriber<T, R> parent;
        public final R value;

        public ConcatMapInnerScalarProducer(R r, ConcatMapSubscriber<T, R> concatMapSubscriber) {
            this.value = r;
            this.parent = concatMapSubscriber;
        }

        @Override // rx.Producer
        public void request(long j) {
            if (this.once || j <= 0) {
                return;
            }
            this.once = true;
            ConcatMapSubscriber<T, R> concatMapSubscriber = this.parent;
            concatMapSubscriber.innerNext(this.value);
            concatMapSubscriber.innerCompleted(1L);
        }
    }

    public static final class ConcatMapInnerSubscriber<T, R> extends Subscriber<R> {
        public final ConcatMapSubscriber<T, R> parent;
        public long produced;

        public ConcatMapInnerSubscriber(ConcatMapSubscriber<T, R> concatMapSubscriber) {
            this.parent = concatMapSubscriber;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.parent.innerCompleted(this.produced);
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.parent.innerError(th, this.produced);
        }

        @Override // rx.Observer
        public void onNext(R r) {
            this.produced++;
            this.parent.innerNext(r);
        }

        @Override // rx.Subscriber, rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            this.parent.arbiter.setProducer(producer);
        }
    }

    public static final class ConcatMapSubscriber<T, R> extends Subscriber<T> {
        public volatile boolean active;
        public final Subscriber<? super R> actual;
        public final int delayErrorMode;
        public volatile boolean done;
        public final SerialSubscription inner;
        public final Func1<? super T, ? extends Observable<? extends R>> mapper;
        public final Queue<Object> queue;
        public final ProducerArbiter arbiter = new ProducerArbiter();
        public final AtomicInteger wip = new AtomicInteger();
        public final AtomicReference<Throwable> error = new AtomicReference<>();

        public ConcatMapSubscriber(Subscriber<? super R> subscriber, Func1<? super T, ? extends Observable<? extends R>> func1, int i, int i2) {
            this.actual = subscriber;
            this.mapper = func1;
            this.delayErrorMode = i2;
            this.queue = UnsafeAccess.isUnsafeAvailable() ? new SpscArrayQueue<>(i) : new SpscAtomicArrayQueue<>(i);
            this.inner = new SerialSubscription();
            request(i);
        }

        public void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            int i = this.delayErrorMode;
            while (!this.actual.isUnsubscribed()) {
                if (!this.active) {
                    if (i == 1 && this.error.get() != null) {
                        Throwable thTerminate = ExceptionsUtils.terminate(this.error);
                        if (ExceptionsUtils.isTerminated(thTerminate)) {
                            return;
                        }
                        this.actual.onError(thTerminate);
                        return;
                    }
                    boolean z = this.done;
                    Object objPoll = this.queue.poll();
                    boolean z2 = objPoll == null;
                    if (z && z2) {
                        Throwable thTerminate2 = ExceptionsUtils.terminate(this.error);
                        if (thTerminate2 == null) {
                            this.actual.onCompleted();
                            return;
                        } else {
                            if (ExceptionsUtils.isTerminated(thTerminate2)) {
                                return;
                            }
                            this.actual.onError(thTerminate2);
                            return;
                        }
                    }
                    if (!z2) {
                        try {
                            Observable<? extends R> observableCall = this.mapper.call((Object) NotificationLite.getValue(objPoll));
                            if (observableCall == null) {
                                drainError(new NullPointerException("The source returned by the mapper was null"));
                                return;
                            }
                            if (observableCall != Observable.empty()) {
                                if (observableCall instanceof ScalarSynchronousObservable) {
                                    this.active = true;
                                    this.arbiter.setProducer(new ConcatMapInnerScalarProducer(((ScalarSynchronousObservable) observableCall).get(), this));
                                } else {
                                    ConcatMapInnerSubscriber concatMapInnerSubscriber = new ConcatMapInnerSubscriber(this);
                                    this.inner.set(concatMapInnerSubscriber);
                                    if (concatMapInnerSubscriber.isUnsubscribed()) {
                                        return;
                                    }
                                    this.active = true;
                                    observableCall.unsafeSubscribe(concatMapInnerSubscriber);
                                }
                                request(1L);
                            } else {
                                request(1L);
                            }
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            drainError(th);
                            return;
                        }
                    }
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }

        public void drainError(Throwable th) {
            unsubscribe();
            if (!ExceptionsUtils.addThrowable(this.error, th)) {
                pluginError(th);
                return;
            }
            Throwable thTerminate = ExceptionsUtils.terminate(this.error);
            if (ExceptionsUtils.isTerminated(thTerminate)) {
                return;
            }
            this.actual.onError(thTerminate);
        }

        public void innerCompleted(long j) {
            if (j != 0) {
                this.arbiter.produced(j);
            }
            this.active = false;
            drain();
        }

        public void innerError(Throwable th, long j) {
            if (!ExceptionsUtils.addThrowable(this.error, th)) {
                pluginError(th);
                return;
            }
            if (this.delayErrorMode == 0) {
                Throwable thTerminate = ExceptionsUtils.terminate(this.error);
                if (!ExceptionsUtils.isTerminated(thTerminate)) {
                    this.actual.onError(thTerminate);
                }
                unsubscribe();
                return;
            }
            if (j != 0) {
                this.arbiter.produced(j);
            }
            this.active = false;
            drain();
        }

        public void innerNext(R r) {
            this.actual.onNext(r);
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.done = true;
            drain();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (!ExceptionsUtils.addThrowable(this.error, th)) {
                pluginError(th);
                return;
            }
            this.done = true;
            if (this.delayErrorMode != 0) {
                drain();
                return;
            }
            Throwable thTerminate = ExceptionsUtils.terminate(this.error);
            if (!ExceptionsUtils.isTerminated(thTerminate)) {
                this.actual.onError(thTerminate);
            }
            this.inner.unsubscribe();
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (this.queue.offer(NotificationLite.next(t))) {
                drain();
            } else {
                unsubscribe();
                onError(new MissingBackpressureException());
            }
        }

        public void pluginError(Throwable th) {
            RxJavaHooks.onError(th);
        }

        public void requestMore(long j) {
            if (j > 0) {
                this.arbiter.request(j);
            } else {
                if (j >= 0) {
                    return;
                }
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
        }
    }

    public OnSubscribeConcatMap(Observable<? extends T> observable, Func1<? super T, ? extends Observable<? extends R>> func1, int i, int i2) {
        this.source = observable;
        this.mapper = func1;
        this.prefetch = i;
        this.delayErrorMode = i2;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super R> subscriber) {
        final ConcatMapSubscriber concatMapSubscriber = new ConcatMapSubscriber(this.delayErrorMode == 0 ? new SerializedSubscriber<>(subscriber) : subscriber, this.mapper, this.prefetch, this.delayErrorMode);
        subscriber.add(concatMapSubscriber);
        subscriber.add(concatMapSubscriber.inner);
        subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OnSubscribeConcatMap.1
            @Override // rx.Producer
            public void request(long j) {
                concatMapSubscriber.requestMore(j);
            }
        });
        if (subscriber.isUnsubscribed()) {
            return;
        }
        this.source.unsafeSubscribe(concatMapSubscriber);
    }
}
