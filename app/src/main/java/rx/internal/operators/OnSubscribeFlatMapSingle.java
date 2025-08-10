package rx.internal.operators;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.util.ExceptionsUtils;
import rx.internal.util.atomic.MpscLinkedAtomicQueue;
import rx.internal.util.unsafe.MpscLinkedQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

/* loaded from: classes5.dex */
public final class OnSubscribeFlatMapSingle<T, R> implements Observable.OnSubscribe<R> {
    public final boolean delayErrors;
    public final Func1<? super T, ? extends Single<? extends R>> mapper;
    public final int maxConcurrency;
    public final Observable<T> source;

    public static final class FlatMapSingleSubscriber<T, R> extends Subscriber<T> {
        public final Subscriber<? super R> actual;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final Func1<? super T, ? extends Single<? extends R>> mapper;
        public final int maxConcurrency;
        public final Queue<Object> queue;
        public final AtomicInteger wip = new AtomicInteger();
        public final AtomicReference<Throwable> errors = new AtomicReference<>();
        public final FlatMapSingleSubscriber<T, R>.Requested requested = new Requested();
        public final CompositeSubscription set = new CompositeSubscription();
        public final AtomicInteger active = new AtomicInteger();

        public final class InnerSubscriber extends SingleSubscriber<R> {
            public InnerSubscriber() {
            }

            @Override // rx.SingleSubscriber
            public void onError(Throwable th) {
                FlatMapSingleSubscriber.this.innerError(this, th);
            }

            @Override // rx.SingleSubscriber
            public void onSuccess(R r) {
                FlatMapSingleSubscriber.this.innerSuccess(this, r);
            }
        }

        public final class Requested extends AtomicLong implements Producer, Subscription {
            private static final long serialVersionUID = -887187595446742742L;

            public Requested() {
            }

            @Override // rx.Subscription
            public boolean isUnsubscribed() {
                return FlatMapSingleSubscriber.this.cancelled;
            }

            public void produced(long j) {
                BackpressureUtils.produced(this, j);
            }

            @Override // rx.Producer
            public void request(long j) {
                if (j > 0) {
                    BackpressureUtils.getAndAddRequest(this, j);
                    FlatMapSingleSubscriber.this.drain();
                }
            }

            @Override // rx.Subscription
            public void unsubscribe() {
                FlatMapSingleSubscriber.this.cancelled = true;
                FlatMapSingleSubscriber.this.unsubscribe();
                if (FlatMapSingleSubscriber.this.wip.getAndIncrement() == 0) {
                    FlatMapSingleSubscriber.this.queue.clear();
                }
            }
        }

        public FlatMapSingleSubscriber(Subscriber<? super R> subscriber, Func1<? super T, ? extends Single<? extends R>> func1, boolean z, int i) {
            this.actual = subscriber;
            this.mapper = func1;
            this.delayErrors = z;
            this.maxConcurrency = i;
            if (UnsafeAccess.isUnsafeAvailable()) {
                this.queue = new MpscLinkedQueue();
            } else {
                this.queue = new MpscLinkedAtomicQueue();
            }
            request(i != Integer.MAX_VALUE ? i : Long.MAX_VALUE);
        }

        public void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.actual;
            Queue<Object> queue = this.queue;
            boolean z = this.delayErrors;
            AtomicInteger atomicInteger = this.active;
            int iAddAndGet = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    if (this.cancelled) {
                        queue.clear();
                        return;
                    }
                    boolean z2 = this.done;
                    if (!z && z2 && this.errors.get() != null) {
                        queue.clear();
                        subscriber.onError(ExceptionsUtils.terminate(this.errors));
                        return;
                    }
                    Object objPoll = queue.poll();
                    boolean z3 = objPoll == null;
                    if (z2 && atomicInteger.get() == 0 && z3) {
                        if (this.errors.get() != null) {
                            subscriber.onError(ExceptionsUtils.terminate(this.errors));
                            return;
                        } else {
                            subscriber.onCompleted();
                            return;
                        }
                    }
                    if (z3) {
                        break;
                    }
                    subscriber.onNext((Object) NotificationLite.getValue(objPoll));
                    j2++;
                }
                if (j2 == j) {
                    if (this.cancelled) {
                        queue.clear();
                        return;
                    }
                    if (this.done) {
                        if (z) {
                            if (atomicInteger.get() == 0 && queue.isEmpty()) {
                                if (this.errors.get() != null) {
                                    subscriber.onError(ExceptionsUtils.terminate(this.errors));
                                    return;
                                } else {
                                    subscriber.onCompleted();
                                    return;
                                }
                            }
                        } else if (this.errors.get() != null) {
                            queue.clear();
                            subscriber.onError(ExceptionsUtils.terminate(this.errors));
                            return;
                        } else if (atomicInteger.get() == 0 && queue.isEmpty()) {
                            subscriber.onCompleted();
                            return;
                        }
                    }
                }
                if (j2 != 0) {
                    this.requested.produced(j2);
                    if (!this.done && this.maxConcurrency != Integer.MAX_VALUE) {
                        request(j2);
                    }
                }
                iAddAndGet = this.wip.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        public void innerError(FlatMapSingleSubscriber<T, R>.InnerSubscriber innerSubscriber, Throwable th) {
            if (this.delayErrors) {
                ExceptionsUtils.addThrowable(this.errors, th);
                this.set.remove(innerSubscriber);
                if (!this.done && this.maxConcurrency != Integer.MAX_VALUE) {
                    request(1L);
                }
            } else {
                this.set.unsubscribe();
                unsubscribe();
                if (!this.errors.compareAndSet(null, th)) {
                    RxJavaHooks.onError(th);
                    return;
                }
                this.done = true;
            }
            this.active.decrementAndGet();
            drain();
        }

        public void innerSuccess(FlatMapSingleSubscriber<T, R>.InnerSubscriber innerSubscriber, R r) {
            this.queue.offer(NotificationLite.next(r));
            this.set.remove(innerSubscriber);
            this.active.decrementAndGet();
            drain();
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.done = true;
            drain();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (this.delayErrors) {
                ExceptionsUtils.addThrowable(this.errors, th);
            } else {
                this.set.unsubscribe();
                if (!this.errors.compareAndSet(null, th)) {
                    RxJavaHooks.onError(th);
                    return;
                }
            }
            this.done = true;
            drain();
        }

        @Override // rx.Observer
        public void onNext(T t) {
            try {
                Single<? extends R> singleCall = this.mapper.call(t);
                if (singleCall == null) {
                    throw new NullPointerException("The mapper returned a null Single");
                }
                InnerSubscriber innerSubscriber = new InnerSubscriber();
                this.set.add(innerSubscriber);
                this.active.incrementAndGet();
                singleCall.subscribe(innerSubscriber);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                unsubscribe();
                onError(th);
            }
        }
    }

    public OnSubscribeFlatMapSingle(Observable<T> observable, Func1<? super T, ? extends Single<? extends R>> func1, boolean z, int i) {
        Objects.requireNonNull(func1, "mapper is null");
        if (i <= 0) {
            throw new IllegalArgumentException("maxConcurrency > 0 required but it was " + i);
        }
        this.source = observable;
        this.mapper = func1;
        this.delayErrors = z;
        this.maxConcurrency = i;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super R> subscriber) {
        FlatMapSingleSubscriber flatMapSingleSubscriber = new FlatMapSingleSubscriber(subscriber, this.mapper, this.delayErrors, this.maxConcurrency);
        subscriber.add(flatMapSingleSubscriber.set);
        subscriber.add(flatMapSingleSubscriber.requested);
        subscriber.setProducer(flatMapSingleSubscriber.requested);
        this.source.unsafeSubscribe(flatMapSingleSubscriber);
    }
}
