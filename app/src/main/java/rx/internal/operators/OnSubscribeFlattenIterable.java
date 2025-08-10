package rx.internal.operators;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Func1;
import rx.internal.operators.OnSubscribeFromIterable;
import rx.internal.util.ExceptionsUtils;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.atomic.SpscLinkedArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.plugins.RxJavaHooks;

/* loaded from: classes5.dex */
public final class OnSubscribeFlattenIterable<T, R> implements Observable.OnSubscribe<R> {
    public final Func1<? super T, ? extends Iterable<? extends R>> mapper;
    public final int prefetch;
    public final Observable<? extends T> source;

    public static final class FlattenIterableSubscriber<T, R> extends Subscriber<T> {
        public Iterator<? extends R> active;
        public final Subscriber<? super R> actual;
        public volatile boolean done;
        public final long limit;
        public final Func1<? super T, ? extends Iterable<? extends R>> mapper;
        public long produced;
        public final Queue<Object> queue;
        public final AtomicReference<Throwable> error = new AtomicReference<>();
        public final AtomicInteger wip = new AtomicInteger();
        public final AtomicLong requested = new AtomicLong();

        public FlattenIterableSubscriber(Subscriber<? super R> subscriber, Func1<? super T, ? extends Iterable<? extends R>> func1, int i) {
            this.actual = subscriber;
            this.mapper = func1;
            if (i == Integer.MAX_VALUE) {
                this.limit = Long.MAX_VALUE;
                this.queue = new SpscLinkedArrayQueue(RxRingBuffer.SIZE);
            } else {
                this.limit = i - (i >> 2);
                if (UnsafeAccess.isUnsafeAvailable()) {
                    this.queue = new SpscArrayQueue(i);
                } else {
                    this.queue = new SpscAtomicArrayQueue(i);
                }
            }
            request(i);
        }

        public boolean checkTerminated(boolean z, boolean z2, Subscriber<?> subscriber, Queue<?> queue) {
            if (subscriber.isUnsubscribed()) {
                queue.clear();
                this.active = null;
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.error.get() == null) {
                if (!z2) {
                    return false;
                }
                subscriber.onCompleted();
                return true;
            }
            Throwable thTerminate = ExceptionsUtils.terminate(this.error);
            unsubscribe();
            queue.clear();
            this.active = null;
            subscriber.onError(thTerminate);
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0063  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void drain() {
            /*
                Method dump skipped, instructions count: 217
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OnSubscribeFlattenIterable.FlattenIterableSubscriber.drain():void");
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.done = true;
            drain();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (!ExceptionsUtils.addThrowable(this.error, th)) {
                RxJavaHooks.onError(th);
            } else {
                this.done = true;
                drain();
            }
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

        public void requestMore(long j) {
            if (j > 0) {
                BackpressureUtils.getAndAddRequest(this.requested, j);
                drain();
            } else {
                if (j >= 0) {
                    return;
                }
                throw new IllegalStateException("n >= 0 required but it was " + j);
            }
        }
    }

    public static final class OnSubscribeScalarFlattenIterable<T, R> implements Observable.OnSubscribe<R> {
        public final Func1<? super T, ? extends Iterable<? extends R>> mapper;
        public final T value;

        public OnSubscribeScalarFlattenIterable(T t, Func1<? super T, ? extends Iterable<? extends R>> func1) {
            this.value = t;
            this.mapper = func1;
        }

        @Override // rx.functions.Action1
        public void call(Subscriber<? super R> subscriber) {
            try {
                Iterator<? extends R> it = this.mapper.call(this.value).iterator();
                if (it.hasNext()) {
                    subscriber.setProducer(new OnSubscribeFromIterable.IterableProducer(subscriber, it));
                } else {
                    subscriber.onCompleted();
                }
            } catch (Throwable th) {
                Exceptions.throwOrReport(th, subscriber, this.value);
            }
        }
    }

    public OnSubscribeFlattenIterable(Observable<? extends T> observable, Func1<? super T, ? extends Iterable<? extends R>> func1, int i) {
        this.source = observable;
        this.mapper = func1;
        this.prefetch = i;
    }

    public static <T, R> Observable<R> createFrom(Observable<? extends T> observable, Func1<? super T, ? extends Iterable<? extends R>> func1, int i) {
        return observable instanceof ScalarSynchronousObservable ? Observable.unsafeCreate(new OnSubscribeScalarFlattenIterable(((ScalarSynchronousObservable) observable).get(), func1)) : Observable.unsafeCreate(new OnSubscribeFlattenIterable(observable, func1, i));
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super R> subscriber) {
        final FlattenIterableSubscriber flattenIterableSubscriber = new FlattenIterableSubscriber(subscriber, this.mapper, this.prefetch);
        subscriber.add(flattenIterableSubscriber);
        subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OnSubscribeFlattenIterable.1
            @Override // rx.Producer
            public void request(long j) {
                flattenIterableSubscriber.requestMore(j);
            }
        });
        this.source.unsafeSubscribe(flattenIterableSubscriber);
    }
}
