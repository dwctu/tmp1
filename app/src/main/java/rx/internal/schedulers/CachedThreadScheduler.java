package rx.internal.schedulers;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.util.RxThreadFactory;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

/* loaded from: classes5.dex */
public final class CachedThreadScheduler extends Scheduler implements SchedulerLifecycle {
    private static final long KEEP_ALIVE_TIME;
    private static final TimeUnit KEEP_ALIVE_UNIT = TimeUnit.SECONDS;
    public static final CachedWorkerPool NONE;
    public static final ThreadWorker SHUTDOWN_THREADWORKER;
    public final AtomicReference<CachedWorkerPool> pool = new AtomicReference<>(NONE);
    public final ThreadFactory threadFactory;

    public static final class CachedWorkerPool {
        private final CompositeSubscription allWorkers;
        private final ScheduledExecutorService evictorService;
        private final Future<?> evictorTask;
        private final ConcurrentLinkedQueue<ThreadWorker> expiringWorkerQueue;
        private final long keepAliveTime;
        private final ThreadFactory threadFactory;

        public CachedWorkerPool(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
            this.threadFactory = threadFactory;
            long nanos = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.keepAliveTime = nanos;
            this.expiringWorkerQueue = new ConcurrentLinkedQueue<>();
            this.allWorkers = new CompositeSubscription();
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = null;
            if (timeUnit != null) {
                scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new ThreadFactory() { // from class: rx.internal.schedulers.CachedThreadScheduler.CachedWorkerPool.1
                    @Override // java.util.concurrent.ThreadFactory
                    public Thread newThread(Runnable runnable) {
                        Thread threadNewThread = threadFactory.newThread(runnable);
                        threadNewThread.setName(threadNewThread.getName() + " (Evictor)");
                        return threadNewThread;
                    }
                });
                NewThreadWorker.tryEnableCancelPolicy(scheduledExecutorServiceNewScheduledThreadPool);
                scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(new Runnable() { // from class: rx.internal.schedulers.CachedThreadScheduler.CachedWorkerPool.2
                    @Override // java.lang.Runnable
                    public void run() {
                        CachedWorkerPool.this.evictExpiredWorkers();
                    }
                }, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledFutureScheduleWithFixedDelay = null;
            }
            this.evictorService = scheduledExecutorServiceNewScheduledThreadPool;
            this.evictorTask = scheduledFutureScheduleWithFixedDelay;
        }

        public void evictExpiredWorkers() {
            if (this.expiringWorkerQueue.isEmpty()) {
                return;
            }
            long jNow = now();
            Iterator<ThreadWorker> it = this.expiringWorkerQueue.iterator();
            while (it.hasNext()) {
                ThreadWorker next = it.next();
                if (next.getExpirationTime() > jNow) {
                    return;
                }
                if (this.expiringWorkerQueue.remove(next)) {
                    this.allWorkers.remove(next);
                }
            }
        }

        public ThreadWorker get() {
            if (this.allWorkers.isUnsubscribed()) {
                return CachedThreadScheduler.SHUTDOWN_THREADWORKER;
            }
            while (!this.expiringWorkerQueue.isEmpty()) {
                ThreadWorker threadWorkerPoll = this.expiringWorkerQueue.poll();
                if (threadWorkerPoll != null) {
                    return threadWorkerPoll;
                }
            }
            ThreadWorker threadWorker = new ThreadWorker(this.threadFactory);
            this.allWorkers.add(threadWorker);
            return threadWorker;
        }

        public long now() {
            return System.nanoTime();
        }

        public void release(ThreadWorker threadWorker) {
            threadWorker.setExpirationTime(now() + this.keepAliveTime);
            this.expiringWorkerQueue.offer(threadWorker);
        }

        public void shutdown() {
            try {
                Future<?> future = this.evictorTask;
                if (future != null) {
                    future.cancel(true);
                }
                ScheduledExecutorService scheduledExecutorService = this.evictorService;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                }
            } finally {
                this.allWorkers.unsubscribe();
            }
        }
    }

    public static final class EventLoopWorker extends Scheduler.Worker implements Action0 {
        private final CompositeSubscription innerSubscription = new CompositeSubscription();
        public final AtomicBoolean once = new AtomicBoolean();
        private final CachedWorkerPool pool;
        private final ThreadWorker threadWorker;

        public EventLoopWorker(CachedWorkerPool cachedWorkerPool) {
            this.pool = cachedWorkerPool;
            this.threadWorker = cachedWorkerPool.get();
        }

        @Override // rx.functions.Action0
        public void call() {
            this.pool.release(this.threadWorker);
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.innerSubscription.isUnsubscribed();
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action0) {
            return schedule(action0, 0L, null);
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.threadWorker.schedule(this);
            }
            this.innerSubscription.unsubscribe();
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(final Action0 action0, long j, TimeUnit timeUnit) {
            if (this.innerSubscription.isUnsubscribed()) {
                return Subscriptions.unsubscribed();
            }
            ScheduledAction scheduledActionScheduleActual = this.threadWorker.scheduleActual(new Action0() { // from class: rx.internal.schedulers.CachedThreadScheduler.EventLoopWorker.1
                @Override // rx.functions.Action0
                public void call() {
                    if (EventLoopWorker.this.isUnsubscribed()) {
                        return;
                    }
                    action0.call();
                }
            }, j, timeUnit);
            this.innerSubscription.add(scheduledActionScheduleActual);
            scheduledActionScheduleActual.addParent(this.innerSubscription);
            return scheduledActionScheduleActual;
        }
    }

    public static final class ThreadWorker extends NewThreadWorker {
        private long expirationTime;

        public ThreadWorker(ThreadFactory threadFactory) {
            super(threadFactory);
            this.expirationTime = 0L;
        }

        public long getExpirationTime() {
            return this.expirationTime;
        }

        public void setExpirationTime(long j) {
            this.expirationTime = j;
        }
    }

    static {
        ThreadWorker threadWorker = new ThreadWorker(RxThreadFactory.NONE);
        SHUTDOWN_THREADWORKER = threadWorker;
        threadWorker.unsubscribe();
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(null, 0L, null);
        NONE = cachedWorkerPool;
        cachedWorkerPool.shutdown();
        KEEP_ALIVE_TIME = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    public CachedThreadScheduler(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
        start();
    }

    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.pool.get());
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void shutdown() {
        CachedWorkerPool cachedWorkerPool;
        CachedWorkerPool cachedWorkerPool2;
        do {
            cachedWorkerPool = this.pool.get();
            cachedWorkerPool2 = NONE;
            if (cachedWorkerPool == cachedWorkerPool2) {
                return;
            }
        } while (!this.pool.compareAndSet(cachedWorkerPool, cachedWorkerPool2));
        cachedWorkerPool.shutdown();
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void start() {
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(this.threadFactory, KEEP_ALIVE_TIME, KEEP_ALIVE_UNIT);
        if (this.pool.compareAndSet(NONE, cachedWorkerPool)) {
            return;
        }
        cachedWorkerPool.shutdown();
    }
}
