package rx.internal.operators;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.atomic.SpscExactAtomicArrayQueue;
import rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import rx.internal.util.unsafe.Pow2;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.subscriptions.CompositeSubscription;

/* loaded from: classes5.dex */
public final class OperatorMerge<T> implements Observable.Operator<T, Observable<? extends T>> {
    public final boolean delayErrors;
    public final int maxConcurrent;

    public static final class HolderDelayErrors {
        public static final OperatorMerge<Object> INSTANCE = new OperatorMerge<>(true, Integer.MAX_VALUE);
    }

    public static final class HolderNoDelay {
        public static final OperatorMerge<Object> INSTANCE = new OperatorMerge<>(false, Integer.MAX_VALUE);
    }

    public static final class InnerSubscriber<T> extends Subscriber<T> {
        public static final int LIMIT = RxRingBuffer.SIZE / 4;
        public volatile boolean done;
        public final long id;
        public int outstanding;
        public final MergeSubscriber<T> parent;
        public volatile RxRingBuffer queue;

        public InnerSubscriber(MergeSubscriber<T> mergeSubscriber, long j) {
            this.parent = mergeSubscriber;
            this.id = j;
        }

        @Override // rx.Observer
        public void onCompleted() throws Throwable {
            this.done = true;
            this.parent.emit();
        }

        @Override // rx.Observer
        public void onError(Throwable th) throws Throwable {
            this.done = true;
            this.parent.getOrCreateErrorQueue().offer(th);
            this.parent.emit();
        }

        @Override // rx.Observer
        public void onNext(T t) throws Throwable {
            this.parent.tryEmit(this, t);
        }

        @Override // rx.Subscriber
        public void onStart() {
            int i = RxRingBuffer.SIZE;
            this.outstanding = i;
            request(i);
        }

        public void requestMore(long j) {
            int i = this.outstanding - ((int) j);
            if (i > LIMIT) {
                this.outstanding = i;
                return;
            }
            int i2 = RxRingBuffer.SIZE;
            this.outstanding = i2;
            int i3 = i2 - i;
            if (i3 > 0) {
                request(i3);
            }
        }
    }

    public static final class MergeProducer<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -1214379189873595503L;
        public final MergeSubscriber<T> subscriber;

        public MergeProducer(MergeSubscriber<T> mergeSubscriber) {
            this.subscriber = mergeSubscriber;
        }

        public long produced(int i) {
            return addAndGet(-i);
        }

        @Override // rx.Producer
        public void request(long j) throws Throwable {
            if (j <= 0) {
                if (j < 0) {
                    throw new IllegalArgumentException("n >= 0 required");
                }
            } else {
                if (get() == Long.MAX_VALUE) {
                    return;
                }
                BackpressureUtils.getAndAddRequest(this, j);
                this.subscriber.emit();
            }
        }
    }

    public static final class MergeSubscriber<T> extends Subscriber<Observable<? extends T>> {
        public static final InnerSubscriber<?>[] EMPTY = new InnerSubscriber[0];
        public final Subscriber<? super T> child;
        public final boolean delayErrors;
        public volatile boolean done;
        public boolean emitting;
        public volatile ConcurrentLinkedQueue<Throwable> errors;
        public final Object innerGuard = new Object();
        public volatile InnerSubscriber<?>[] innerSubscribers = EMPTY;
        public long lastId;
        public int lastIndex;
        public final int maxConcurrent;
        public boolean missed;
        public MergeProducer<T> producer;
        public volatile Queue<Object> queue;
        public int scalarEmissionCount;
        public final int scalarEmissionLimit;
        public volatile CompositeSubscription subscriptions;
        public long uniqueId;

        public MergeSubscriber(Subscriber<? super T> subscriber, boolean z, int i) {
            this.child = subscriber;
            this.delayErrors = z;
            this.maxConcurrent = i;
            if (i == Integer.MAX_VALUE) {
                this.scalarEmissionLimit = Integer.MAX_VALUE;
                request(Long.MAX_VALUE);
            } else {
                this.scalarEmissionLimit = Math.max(1, i >> 1);
                request(i);
            }
        }

        private void reportError() {
            ArrayList arrayList = new ArrayList(this.errors);
            if (arrayList.size() == 1) {
                this.child.onError((Throwable) arrayList.get(0));
            } else {
                this.child.onError(new CompositeException(arrayList));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void addInner(InnerSubscriber<T> innerSubscriber) {
            getOrCreateComposite().add(innerSubscriber);
            synchronized (this.innerGuard) {
                InnerSubscriber<?>[] innerSubscriberArr = this.innerSubscribers;
                int length = innerSubscriberArr.length;
                InnerSubscriber<?>[] innerSubscriberArr2 = new InnerSubscriber[length + 1];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
                this.innerSubscribers = innerSubscriberArr2;
            }
        }

        public boolean checkTerminate() {
            if (this.child.isUnsubscribed()) {
                return true;
            }
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.errors;
            if (this.delayErrors || concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
                return false;
            }
            try {
                reportError();
                return true;
            } finally {
                unsubscribe();
            }
        }

        public void emit() throws Throwable {
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                } else {
                    this.emitting = true;
                    emitLoop();
                }
            }
        }

        public void emitEmpty() {
            int i = this.scalarEmissionCount + 1;
            if (i != this.scalarEmissionLimit) {
                this.scalarEmissionCount = i;
            } else {
                this.scalarEmissionCount = 0;
                requestMore(i);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x0071, code lost:
        
            if (r7 <= 0) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0073, code lost:
        
            if (r10 == false) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0075, code lost:
        
            r16 = Long.MAX_VALUE;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0078, code lost:
        
            r16 = r22.producer.produced(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0080, code lost:
        
            if (r16 == 0) goto L196;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0082, code lost:
        
            if (r0 != null) goto L45;
         */
        /* JADX WARN: Removed duplicated region for block: B:159:0x019b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void emitLoop() throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 420
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorMerge.MergeSubscriber.emitLoop():void");
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x004a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void emitScalar(rx.internal.operators.OperatorMerge.InnerSubscriber<T> r5, T r6, long r7) throws java.lang.Throwable {
            /*
                r4 = this;
                r0 = 1
                r1 = 0
                rx.Subscriber<? super T> r2 = r4.child     // Catch: java.lang.Throwable -> L8
                r2.onNext(r6)     // Catch: java.lang.Throwable -> L8
                goto L20
            L8:
                r6 = move-exception
                boolean r2 = r4.delayErrors     // Catch: java.lang.Throwable -> L46
                if (r2 != 0) goto L19
                rx.exceptions.Exceptions.throwIfFatal(r6)     // Catch: java.lang.Throwable -> L46
                r5.unsubscribe()     // Catch: java.lang.Throwable -> L17
                r5.onError(r6)     // Catch: java.lang.Throwable -> L17
                return
            L17:
                r5 = move-exception
                goto L48
            L19:
                java.util.Queue r2 = r4.getOrCreateErrorQueue()     // Catch: java.lang.Throwable -> L46
                r2.offer(r6)     // Catch: java.lang.Throwable -> L46
            L20:
                r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r6 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
                if (r6 == 0) goto L2e
                rx.internal.operators.OperatorMerge$MergeProducer<T> r6 = r4.producer     // Catch: java.lang.Throwable -> L46
                r6.produced(r0)     // Catch: java.lang.Throwable -> L46
            L2e:
                r6 = 1
                r5.requestMore(r6)     // Catch: java.lang.Throwable -> L46
                monitor-enter(r4)     // Catch: java.lang.Throwable -> L46
                boolean r5 = r4.missed     // Catch: java.lang.Throwable -> L43
                if (r5 != 0) goto L3c
                r4.emitting = r1     // Catch: java.lang.Throwable -> L43
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L43
                return
            L3c:
                r4.missed = r1     // Catch: java.lang.Throwable -> L43
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L43
                r4.emitLoop()
                return
            L43:
                r5 = move-exception
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L43
                throw r5     // Catch: java.lang.Throwable -> L17
            L46:
                r5 = move-exception
                r0 = 0
            L48:
                if (r0 != 0) goto L52
                monitor-enter(r4)
                r4.emitting = r1     // Catch: java.lang.Throwable -> L4f
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L4f
                goto L52
            L4f:
                r5 = move-exception
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L4f
                throw r5
            L52:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorMerge.MergeSubscriber.emitScalar(rx.internal.operators.OperatorMerge$InnerSubscriber, java.lang.Object, long):void");
        }

        public CompositeSubscription getOrCreateComposite() {
            CompositeSubscription compositeSubscription;
            CompositeSubscription compositeSubscription2 = this.subscriptions;
            if (compositeSubscription2 != null) {
                return compositeSubscription2;
            }
            boolean z = false;
            synchronized (this) {
                compositeSubscription = this.subscriptions;
                if (compositeSubscription == null) {
                    CompositeSubscription compositeSubscription3 = new CompositeSubscription();
                    this.subscriptions = compositeSubscription3;
                    compositeSubscription = compositeSubscription3;
                    z = true;
                }
            }
            if (z) {
                add(compositeSubscription);
            }
            return compositeSubscription;
        }

        public Queue<Throwable> getOrCreateErrorQueue() {
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.errors;
            if (concurrentLinkedQueue == null) {
                synchronized (this) {
                    concurrentLinkedQueue = this.errors;
                    if (concurrentLinkedQueue == null) {
                        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                        this.errors = concurrentLinkedQueue;
                    }
                }
            }
            return concurrentLinkedQueue;
        }

        @Override // rx.Observer
        public void onCompleted() throws Throwable {
            this.done = true;
            emit();
        }

        @Override // rx.Observer
        public void onError(Throwable th) throws Throwable {
            getOrCreateErrorQueue().offer(th);
            this.done = true;
            emit();
        }

        public void queueScalar(InnerSubscriber<T> innerSubscriber, T t) throws Throwable {
            RxRingBuffer spscInstance = innerSubscriber.queue;
            if (spscInstance == null) {
                spscInstance = RxRingBuffer.getSpscInstance();
                innerSubscriber.add(spscInstance);
                innerSubscriber.queue = spscInstance;
            }
            try {
                spscInstance.onNext(NotificationLite.next(t));
            } catch (IllegalStateException e) {
                if (innerSubscriber.isUnsubscribed()) {
                    return;
                }
                innerSubscriber.unsubscribe();
                innerSubscriber.onError(e);
            } catch (MissingBackpressureException e2) {
                innerSubscriber.unsubscribe();
                innerSubscriber.onError(e2);
            }
        }

        public void removeInner(InnerSubscriber<T> innerSubscriber) {
            RxRingBuffer rxRingBuffer = innerSubscriber.queue;
            if (rxRingBuffer != null) {
                rxRingBuffer.release();
            }
            this.subscriptions.remove(innerSubscriber);
            synchronized (this.innerGuard) {
                InnerSubscriber<?>[] innerSubscriberArr = this.innerSubscribers;
                int length = innerSubscriberArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (innerSubscriber.equals(innerSubscriberArr[i2])) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    this.innerSubscribers = EMPTY;
                    return;
                }
                InnerSubscriber<?>[] innerSubscriberArr2 = new InnerSubscriber[length - 1];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, i);
                System.arraycopy(innerSubscriberArr, i + 1, innerSubscriberArr2, i, (length - i) - 1);
                this.innerSubscribers = innerSubscriberArr2;
            }
        }

        public void requestMore(long j) {
            request(j);
        }

        public void tryEmit(InnerSubscriber<T> innerSubscriber, T t) throws Throwable {
            long j = this.producer.get();
            boolean z = false;
            if (j != 0) {
                synchronized (this) {
                    j = this.producer.get();
                    if (!this.emitting && j != 0) {
                        this.emitting = true;
                        z = true;
                    }
                }
            }
            if (!z) {
                queueScalar(innerSubscriber, t);
                emit();
                return;
            }
            RxRingBuffer rxRingBuffer = innerSubscriber.queue;
            if (rxRingBuffer == null || rxRingBuffer.isEmpty()) {
                emitScalar(innerSubscriber, t, j);
            } else {
                queueScalar(innerSubscriber, t);
                emitLoop();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.Observer
        public void onNext(Observable<? extends T> observable) throws Throwable {
            if (observable == null) {
                return;
            }
            if (observable == Observable.empty()) {
                emitEmpty();
                return;
            }
            if (observable instanceof ScalarSynchronousObservable) {
                tryEmit(((ScalarSynchronousObservable) observable).get());
                return;
            }
            long j = this.uniqueId;
            this.uniqueId = 1 + j;
            InnerSubscriber innerSubscriber = new InnerSubscriber(this, j);
            addInner(innerSubscriber);
            observable.unsafeSubscribe(innerSubscriber);
            emit();
        }

        public void queueScalar(T t) throws Throwable {
            Queue<Object> spscExactAtomicArrayQueue;
            Queue<Object> spscUnboundedAtomicArrayQueue = this.queue;
            if (spscUnboundedAtomicArrayQueue == null) {
                int i = this.maxConcurrent;
                if (i == Integer.MAX_VALUE) {
                    spscUnboundedAtomicArrayQueue = new SpscUnboundedAtomicArrayQueue<>(RxRingBuffer.SIZE);
                } else {
                    if (Pow2.isPowerOfTwo(i)) {
                        if (UnsafeAccess.isUnsafeAvailable()) {
                            spscExactAtomicArrayQueue = new SpscArrayQueue<>(i);
                        } else {
                            spscExactAtomicArrayQueue = new SpscAtomicArrayQueue<>(i);
                        }
                    } else {
                        spscExactAtomicArrayQueue = new SpscExactAtomicArrayQueue<>(i);
                    }
                    spscUnboundedAtomicArrayQueue = spscExactAtomicArrayQueue;
                }
                this.queue = spscUnboundedAtomicArrayQueue;
            }
            if (spscUnboundedAtomicArrayQueue.offer(NotificationLite.next(t))) {
                return;
            }
            unsubscribe();
            onError(OnErrorThrowable.addValueAsLastCause(new MissingBackpressureException(), t));
        }

        public void tryEmit(T t) throws Throwable {
            long j = this.producer.get();
            boolean z = false;
            if (j != 0) {
                synchronized (this) {
                    j = this.producer.get();
                    if (!this.emitting && j != 0) {
                        this.emitting = true;
                        z = true;
                    }
                }
            }
            if (z) {
                Queue<Object> queue = this.queue;
                if (queue != null && !queue.isEmpty()) {
                    queueScalar(t);
                    emitLoop();
                    return;
                } else {
                    emitScalar(t, j);
                    return;
                }
            }
            queueScalar(t);
            emit();
        }

        public void emitScalar(T t, long j) throws Throwable {
            boolean z = true;
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    this.child.onNext(t);
                } catch (Throwable th2) {
                    if (!this.delayErrors) {
                        Exceptions.throwIfFatal(th2);
                        unsubscribe();
                        onError(th2);
                        return;
                    }
                    getOrCreateErrorQueue().offer(th2);
                }
                if (j != Long.MAX_VALUE) {
                    this.producer.produced(1);
                }
                int i = this.scalarEmissionCount + 1;
                if (i == this.scalarEmissionLimit) {
                    this.scalarEmissionCount = 0;
                    requestMore(i);
                } else {
                    this.scalarEmissionCount = i;
                }
                synchronized (this) {
                    if (!this.missed) {
                        this.emitting = false;
                    } else {
                        this.missed = false;
                        emitLoop();
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                z = false;
                if (!z) {
                    synchronized (this) {
                        this.emitting = false;
                    }
                }
                throw th;
            }
        }
    }

    public OperatorMerge(boolean z, int i) {
        this.delayErrors = z;
        this.maxConcurrent = i;
    }

    public static <T> OperatorMerge<T> instance(boolean z) {
        return z ? (OperatorMerge<T>) HolderDelayErrors.INSTANCE : (OperatorMerge<T>) HolderNoDelay.INSTANCE;
    }

    @Override // rx.functions.Func1
    public Subscriber<Observable<? extends T>> call(Subscriber<? super T> subscriber) {
        MergeSubscriber mergeSubscriber = new MergeSubscriber(subscriber, this.delayErrors, this.maxConcurrent);
        MergeProducer<T> mergeProducer = new MergeProducer<>(mergeSubscriber);
        mergeSubscriber.producer = mergeProducer;
        subscriber.add(mergeSubscriber);
        subscriber.setProducer(mergeProducer);
        return mergeSubscriber;
    }

    public static <T> OperatorMerge<T> instance(boolean z, int i) {
        if (i > 0) {
            if (i == Integer.MAX_VALUE) {
                return instance(z);
            }
            return new OperatorMerge<>(z, i);
        }
        throw new IllegalArgumentException("maxConcurrent > 0 required but it was " + i);
    }
}
