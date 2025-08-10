package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes4.dex */
public final class FlowableWindowTimed<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    public final int bufferSize;
    public final long maxSize;
    public final boolean restartTimerOnMaxSize;
    public final Scheduler scheduler;
    public final long timeskip;
    public final long timespan;
    public final TimeUnit unit;

    public static final class WindowExactBoundedSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription {
        public final int bufferSize;
        public long count;
        public final long maxSize;
        public long producerIndex;
        public final boolean restartTimerOnMaxSize;
        public final Scheduler scheduler;
        public volatile boolean terminated;
        public final SequentialDisposable timer;
        public final long timespan;
        public final TimeUnit unit;
        public Subscription upstream;
        public UnicastProcessor<T> window;
        public final Scheduler.Worker worker;

        public static final class ConsumerIndexHolder implements Runnable {
            public final long index;
            public final WindowExactBoundedSubscriber<?> parent;

            public ConsumerIndexHolder(long j, WindowExactBoundedSubscriber<?> windowExactBoundedSubscriber) {
                this.index = j;
                this.parent = windowExactBoundedSubscriber;
            }

            @Override // java.lang.Runnable
            public void run() {
                WindowExactBoundedSubscriber<?> windowExactBoundedSubscriber = this.parent;
                if (windowExactBoundedSubscriber.cancelled) {
                    windowExactBoundedSubscriber.terminated = true;
                } else {
                    windowExactBoundedSubscriber.queue.offer(this);
                }
                if (windowExactBoundedSubscriber.enter()) {
                    windowExactBoundedSubscriber.drainLoop();
                }
            }
        }

        public WindowExactBoundedSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler, int i, long j2, boolean z) {
            super(subscriber, new MpscLinkedQueue());
            this.timer = new SequentialDisposable();
            this.timespan = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.bufferSize = i;
            this.maxSize = j2;
            this.restartTimerOnMaxSize = z;
            if (z) {
                this.worker = scheduler.createWorker();
            } else {
                this.worker = null;
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
        }

        public void disposeTimer() {
            this.timer.dispose();
            Scheduler.Worker worker = this.worker;
            if (worker != null) {
                worker.dispose();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0066  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void drainLoop() {
            /*
                Method dump skipped, instructions count: 289
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactBoundedSubscriber.drainLoop():void");
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.terminated) {
                return;
            }
            if (fastEnter()) {
                UnicastProcessor<T> unicastProcessor = this.window;
                unicastProcessor.onNext(t);
                long j = this.count + 1;
                if (j >= this.maxSize) {
                    this.producerIndex++;
                    this.count = 0L;
                    unicastProcessor.onComplete();
                    long jRequested = requested();
                    if (jRequested == 0) {
                        this.window = null;
                        this.upstream.cancel();
                        this.downstream.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                        disposeTimer();
                        return;
                    }
                    UnicastProcessor<T> unicastProcessorCreate = UnicastProcessor.create(this.bufferSize);
                    this.window = unicastProcessorCreate;
                    this.downstream.onNext(unicastProcessorCreate);
                    if (jRequested != Long.MAX_VALUE) {
                        produced(1L);
                    }
                    if (this.restartTimerOnMaxSize) {
                        this.timer.get().dispose();
                        Scheduler.Worker worker = this.worker;
                        ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
                        long j2 = this.timespan;
                        this.timer.replace(worker.schedulePeriodically(consumerIndexHolder, j2, j2, this.unit));
                    }
                } else {
                    this.count = j;
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(NotificationLite.next(t));
                if (!enter()) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            Disposable disposableSchedulePeriodicallyDirect;
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                Subscriber<? super V> subscriber = this.downstream;
                subscriber.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                UnicastProcessor<T> unicastProcessorCreate = UnicastProcessor.create(this.bufferSize);
                this.window = unicastProcessorCreate;
                long jRequested = requested();
                if (jRequested == 0) {
                    this.cancelled = true;
                    subscription.cancel();
                    subscriber.onError(new MissingBackpressureException("Could not deliver initial window due to lack of requests."));
                    return;
                }
                subscriber.onNext(unicastProcessorCreate);
                if (jRequested != Long.MAX_VALUE) {
                    produced(1L);
                }
                ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
                if (this.restartTimerOnMaxSize) {
                    Scheduler.Worker worker = this.worker;
                    long j = this.timespan;
                    disposableSchedulePeriodicallyDirect = worker.schedulePeriodically(consumerIndexHolder, j, j, this.unit);
                } else {
                    Scheduler scheduler = this.scheduler;
                    long j2 = this.timespan;
                    disposableSchedulePeriodicallyDirect = scheduler.schedulePeriodicallyDirect(consumerIndexHolder, j2, j2, this.unit);
                }
                if (this.timer.replace(disposableSchedulePeriodicallyDirect)) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }
    }

    public static final class WindowExactUnboundedSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements FlowableSubscriber<T>, Subscription, Runnable {
        public static final Object NEXT = new Object();
        public final int bufferSize;
        public final Scheduler scheduler;
        public volatile boolean terminated;
        public final SequentialDisposable timer;
        public final long timespan;
        public final TimeUnit unit;
        public Subscription upstream;
        public UnicastProcessor<T> window;

        public WindowExactUnboundedSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
            super(subscriber, new MpscLinkedQueue());
            this.timer = new SequentialDisposable();
            this.timespan = j;
            this.unit = timeUnit;
            this.scheduler = scheduler;
            this.bufferSize = i;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
        
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
        
            r10.timer.dispose();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
        
            r10.window = null;
            r0.clear();
            r0 = r10.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
        
            if (r0 == null) goto L11;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [io.reactivex.processors.UnicastProcessor<T>] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void drainLoop() {
            /*
                r10 = this;
                io.reactivex.internal.fuseable.SimplePlainQueue<U> r0 = r10.queue
                org.reactivestreams.Subscriber<? super V> r1 = r10.downstream
                io.reactivex.processors.UnicastProcessor<T> r2 = r10.window
                r3 = 1
            L7:
                boolean r4 = r10.terminated
                boolean r5 = r10.done
                java.lang.Object r6 = r0.poll()
                r7 = 0
                if (r5 == 0) goto L2e
                if (r6 == 0) goto L18
                java.lang.Object r5 = io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactUnboundedSubscriber.NEXT
                if (r6 != r5) goto L2e
            L18:
                r10.window = r7
                r0.clear()
                java.lang.Throwable r0 = r10.error
                if (r0 == 0) goto L25
                r2.onError(r0)
                goto L28
            L25:
                r2.onComplete()
            L28:
                io.reactivex.internal.disposables.SequentialDisposable r0 = r10.timer
                r0.dispose()
                return
            L2e:
                if (r6 != 0) goto L38
                int r3 = -r3
                int r3 = r10.leave(r3)
                if (r3 != 0) goto L7
                return
            L38:
                java.lang.Object r5 = io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactUnboundedSubscriber.NEXT
                if (r6 != r5) goto L87
                r2.onComplete()
                if (r4 != 0) goto L81
                int r2 = r10.bufferSize
                io.reactivex.processors.UnicastProcessor r2 = io.reactivex.processors.UnicastProcessor.create(r2)
                r10.window = r2
                long r4 = r10.requested()
                r8 = 0
                int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
                if (r6 == 0) goto L65
                r1.onNext(r2)
                r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r8 == 0) goto L7
                r4 = 1
                r10.produced(r4)
                goto L7
            L65:
                r10.window = r7
                io.reactivex.internal.fuseable.SimplePlainQueue<U> r0 = r10.queue
                r0.clear()
                org.reactivestreams.Subscription r0 = r10.upstream
                r0.cancel()
                io.reactivex.exceptions.MissingBackpressureException r0 = new io.reactivex.exceptions.MissingBackpressureException
                java.lang.String r2 = "Could not deliver first window due to lack of requests."
                r0.<init>(r2)
                r1.onError(r0)
                io.reactivex.internal.disposables.SequentialDisposable r0 = r10.timer
                r0.dispose()
                return
            L81:
                org.reactivestreams.Subscription r4 = r10.upstream
                r4.cancel()
                goto L7
            L87:
                java.lang.Object r4 = io.reactivex.internal.util.NotificationLite.getValue(r6)
                r2.onNext(r4)
                goto L7
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactUnboundedSubscriber.drainLoop():void");
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (this.terminated) {
                return;
            }
            if (fastEnter()) {
                this.window.onNext(t);
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(NotificationLite.next(t));
                if (!enter()) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.window = UnicastProcessor.create(this.bufferSize);
                Subscriber<? super V> subscriber = this.downstream;
                subscriber.onSubscribe(this);
                long jRequested = requested();
                if (jRequested == 0) {
                    this.cancelled = true;
                    subscription.cancel();
                    subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                    return;
                }
                subscriber.onNext(this.window);
                if (jRequested != Long.MAX_VALUE) {
                    produced(1L);
                }
                if (this.cancelled) {
                    return;
                }
                SequentialDisposable sequentialDisposable = this.timer;
                Scheduler scheduler = this.scheduler;
                long j = this.timespan;
                if (sequentialDisposable.replace(scheduler.schedulePeriodicallyDirect(this, j, j, this.unit))) {
                    subscription.request(Long.MAX_VALUE);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled) {
                this.terminated = true;
            }
            this.queue.offer(NEXT);
            if (enter()) {
                drainLoop();
            }
        }
    }

    public static final class WindowSkipSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription, Runnable {
        public final int bufferSize;
        public volatile boolean terminated;
        public final long timeskip;
        public final long timespan;
        public final TimeUnit unit;
        public Subscription upstream;
        public final List<UnicastProcessor<T>> windows;
        public final Scheduler.Worker worker;

        public final class Completion implements Runnable {
            private final UnicastProcessor<T> processor;

            public Completion(UnicastProcessor<T> unicastProcessor) {
                this.processor = unicastProcessor;
            }

            @Override // java.lang.Runnable
            public void run() {
                WindowSkipSubscriber.this.complete(this.processor);
            }
        }

        public static final class SubjectWork<T> {
            public final boolean open;
            public final UnicastProcessor<T> w;

            public SubjectWork(UnicastProcessor<T> unicastProcessor, boolean z) {
                this.w = unicastProcessor;
                this.open = z;
            }
        }

        public WindowSkipSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, long j2, TimeUnit timeUnit, Scheduler.Worker worker, int i) {
            super(subscriber, new MpscLinkedQueue());
            this.timespan = j;
            this.timeskip = j2;
            this.unit = timeUnit;
            this.worker = worker;
            this.bufferSize = i;
            this.windows = new LinkedList();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.cancelled = true;
        }

        public void complete(UnicastProcessor<T> unicastProcessor) {
            this.queue.offer(new SubjectWork(unicastProcessor, false));
            if (enter()) {
                drainLoop();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void drainLoop() {
            SimpleQueue simpleQueue = this.queue;
            Subscriber<? super V> subscriber = this.downstream;
            List<UnicastProcessor<T>> list = this.windows;
            int iLeave = 1;
            while (!this.terminated) {
                boolean z = this.done;
                Object objPoll = simpleQueue.poll();
                boolean z2 = objPoll == null;
                boolean z3 = objPoll instanceof SubjectWork;
                if (z && (z2 || z3)) {
                    simpleQueue.clear();
                    Throwable th = this.error;
                    if (th != null) {
                        Iterator<UnicastProcessor<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        Iterator<UnicastProcessor<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    list.clear();
                    this.worker.dispose();
                    return;
                }
                if (z2) {
                    iLeave = leave(-iLeave);
                    if (iLeave == 0) {
                        return;
                    }
                } else if (z3) {
                    SubjectWork subjectWork = (SubjectWork) objPoll;
                    if (!subjectWork.open) {
                        list.remove(subjectWork.w);
                        subjectWork.w.onComplete();
                        if (list.isEmpty() && this.cancelled) {
                            this.terminated = true;
                        }
                    } else if (!this.cancelled) {
                        long jRequested = requested();
                        if (jRequested != 0) {
                            UnicastProcessor<T> unicastProcessorCreate = UnicastProcessor.create(this.bufferSize);
                            list.add(unicastProcessorCreate);
                            subscriber.onNext(unicastProcessorCreate);
                            if (jRequested != Long.MAX_VALUE) {
                                produced(1L);
                            }
                            this.worker.schedule(new Completion(unicastProcessorCreate), this.timespan, this.unit);
                        } else {
                            subscriber.onError(new MissingBackpressureException("Can't emit window due to lack of requests"));
                        }
                    }
                } else {
                    Iterator<UnicastProcessor<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(objPoll);
                    }
                }
            }
            this.upstream.cancel();
            simpleQueue.clear();
            list.clear();
            this.worker.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.downstream.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            if (enter()) {
                drainLoop();
            }
            this.downstream.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            if (fastEnter()) {
                Iterator<UnicastProcessor<T>> it = this.windows.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (leave(-1) == 0) {
                    return;
                }
            } else {
                this.queue.offer(t);
                if (!enter()) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                long jRequested = requested();
                if (jRequested == 0) {
                    subscription.cancel();
                    this.downstream.onError(new MissingBackpressureException("Could not emit the first window due to lack of requests"));
                    return;
                }
                UnicastProcessor<T> unicastProcessorCreate = UnicastProcessor.create(this.bufferSize);
                this.windows.add(unicastProcessorCreate);
                this.downstream.onNext(unicastProcessorCreate);
                if (jRequested != Long.MAX_VALUE) {
                    produced(1L);
                }
                this.worker.schedule(new Completion(unicastProcessorCreate), this.timespan, this.unit);
                Scheduler.Worker worker = this.worker;
                long j = this.timeskip;
                worker.schedulePeriodically(this, j, j, this.unit);
                subscription.request(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            requested(j);
        }

        @Override // java.lang.Runnable
        public void run() {
            SubjectWork subjectWork = new SubjectWork(UnicastProcessor.create(this.bufferSize), true);
            if (!this.cancelled) {
                this.queue.offer(subjectWork);
            }
            if (enter()) {
                drainLoop();
            }
        }
    }

    public FlowableWindowTimed(Flowable<T> flowable, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, long j3, int i, boolean z) {
        super(flowable);
        this.timespan = j;
        this.timeskip = j2;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.maxSize = j3;
        this.bufferSize = i;
        this.restartTimerOnMaxSize = z;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        long j = this.timespan;
        long j2 = this.timeskip;
        if (j != j2) {
            this.source.subscribe((FlowableSubscriber) new WindowSkipSubscriber(serializedSubscriber, j, j2, this.unit, this.scheduler.createWorker(), this.bufferSize));
            return;
        }
        long j3 = this.maxSize;
        if (j3 == Long.MAX_VALUE) {
            this.source.subscribe((FlowableSubscriber) new WindowExactUnboundedSubscriber(serializedSubscriber, this.timespan, this.unit, this.scheduler, this.bufferSize));
        } else {
            this.source.subscribe((FlowableSubscriber) new WindowExactBoundedSubscriber(serializedSubscriber, j, this.unit, this.scheduler, this.bufferSize, j3, this.restartTimerOnMaxSize));
        }
    }
}
