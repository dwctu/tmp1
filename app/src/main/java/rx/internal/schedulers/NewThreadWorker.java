package rx.internal.schedulers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.internal.util.PlatformDependent;
import rx.internal.util.RxThreadFactory;
import rx.internal.util.SubscriptionList;
import rx.internal.util.SuppressAnimalSniffer;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

/* loaded from: classes5.dex */
public class NewThreadWorker extends Scheduler.Worker implements Subscription {
    private static final String PURGE_FORCE_KEY = "rx.scheduler.jdk6.purge-force";
    private static final String PURGE_THREAD_PREFIX = "RxSchedulerPurge-";
    private static final boolean SHOULD_TRY_ENABLE_CANCEL_POLICY;
    private static volatile Object cachedSetRemoveOnCancelPolicyMethod;
    private final ScheduledExecutorService executor;
    public volatile boolean isUnsubscribed;
    private static final Object SET_REMOVE_ON_CANCEL_POLICY_METHOD_NOT_SUPPORTED = new Object();
    private static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> EXECUTORS = new ConcurrentHashMap<>();
    private static final AtomicReference<ScheduledExecutorService> PURGE = new AtomicReference<>();
    private static final String FREQUENCY_KEY = "rx.scheduler.jdk6.purge-frequency-millis";
    public static final int PURGE_FREQUENCY = Integer.getInteger(FREQUENCY_KEY, 1000).intValue();

    static {
        boolean z = Boolean.getBoolean(PURGE_FORCE_KEY);
        int androidApiVersion = PlatformDependent.getAndroidApiVersion();
        SHOULD_TRY_ENABLE_CANCEL_POLICY = !z && (androidApiVersion == 0 || androidApiVersion >= 21);
    }

    public NewThreadWorker(ThreadFactory threadFactory) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (!tryEnableCancelPolicy(scheduledExecutorServiceNewScheduledThreadPool) && (scheduledExecutorServiceNewScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            registerExecutor((ScheduledThreadPoolExecutor) scheduledExecutorServiceNewScheduledThreadPool);
        }
        this.executor = scheduledExecutorServiceNewScheduledThreadPool;
    }

    public static void deregisterExecutor(ScheduledExecutorService scheduledExecutorService) {
        EXECUTORS.remove(scheduledExecutorService);
    }

    public static Method findSetRemoveOnCancelPolicyMethod(ScheduledExecutorService scheduledExecutorService) throws SecurityException {
        for (Method method : scheduledExecutorService.getClass().getMethods()) {
            if (method.getName().equals("setRemoveOnCancelPolicy")) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0] == Boolean.TYPE) {
                    return method;
                }
            }
        }
        return null;
    }

    @SuppressAnimalSniffer
    public static void purgeExecutors() {
        try {
            Iterator<ScheduledThreadPoolExecutor> it = EXECUTORS.keySet().iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor next = it.next();
                if (next.isShutdown()) {
                    it.remove();
                } else {
                    next.purge();
                }
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaHooks.onError(th);
        }
    }

    public static void registerExecutor(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = PURGE;
            if (atomicReference.get() != null) {
                break;
            }
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory(PURGE_THREAD_PREFIX));
            if (atomicReference.compareAndSet(null, scheduledExecutorServiceNewScheduledThreadPool)) {
                Runnable runnable = new Runnable() { // from class: rx.internal.schedulers.NewThreadWorker.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NewThreadWorker.purgeExecutors();
                    }
                };
                int i = PURGE_FREQUENCY;
                scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(runnable, i, i, TimeUnit.MILLISECONDS);
                break;
            }
            scheduledExecutorServiceNewScheduledThreadPool.shutdownNow();
        }
        EXECUTORS.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
    }

    public static boolean tryEnableCancelPolicy(ScheduledExecutorService scheduledExecutorService) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method methodFindSetRemoveOnCancelPolicyMethod;
        if (SHOULD_TRY_ENABLE_CANCEL_POLICY) {
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                Object obj = cachedSetRemoveOnCancelPolicyMethod;
                Object obj2 = SET_REMOVE_ON_CANCEL_POLICY_METHOD_NOT_SUPPORTED;
                if (obj == obj2) {
                    return false;
                }
                if (obj == null) {
                    methodFindSetRemoveOnCancelPolicyMethod = findSetRemoveOnCancelPolicyMethod(scheduledExecutorService);
                    if (methodFindSetRemoveOnCancelPolicyMethod != null) {
                        obj2 = methodFindSetRemoveOnCancelPolicyMethod;
                    }
                    cachedSetRemoveOnCancelPolicyMethod = obj2;
                } else {
                    methodFindSetRemoveOnCancelPolicyMethod = (Method) obj;
                }
            } else {
                methodFindSetRemoveOnCancelPolicyMethod = findSetRemoveOnCancelPolicyMethod(scheduledExecutorService);
            }
            if (methodFindSetRemoveOnCancelPolicyMethod != null) {
                try {
                    methodFindSetRemoveOnCancelPolicyMethod.invoke(scheduledExecutorService, Boolean.TRUE);
                    return true;
                } catch (IllegalAccessException e) {
                    RxJavaHooks.onError(e);
                } catch (IllegalArgumentException e2) {
                    RxJavaHooks.onError(e2);
                } catch (InvocationTargetException e3) {
                    RxJavaHooks.onError(e3);
                }
            }
        }
        return false;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.isUnsubscribed;
    }

    @Override // rx.Scheduler.Worker
    public Subscription schedule(Action0 action0) {
        return schedule(action0, 0L, null);
    }

    public ScheduledAction scheduleActual(Action0 action0, long j, TimeUnit timeUnit) {
        ScheduledAction scheduledAction = new ScheduledAction(RxJavaHooks.onScheduledAction(action0));
        scheduledAction.add(j <= 0 ? this.executor.submit(scheduledAction) : this.executor.schedule(scheduledAction, j, timeUnit));
        return scheduledAction;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.isUnsubscribed = true;
        this.executor.shutdownNow();
        deregisterExecutor(this.executor);
    }

    @Override // rx.Scheduler.Worker
    public Subscription schedule(Action0 action0, long j, TimeUnit timeUnit) {
        return this.isUnsubscribed ? Subscriptions.unsubscribed() : scheduleActual(action0, j, timeUnit);
    }

    public ScheduledAction scheduleActual(Action0 action0, long j, TimeUnit timeUnit, CompositeSubscription compositeSubscription) {
        Future<?> futureSchedule;
        ScheduledAction scheduledAction = new ScheduledAction(RxJavaHooks.onScheduledAction(action0), compositeSubscription);
        compositeSubscription.add(scheduledAction);
        if (j <= 0) {
            futureSchedule = this.executor.submit(scheduledAction);
        } else {
            futureSchedule = this.executor.schedule(scheduledAction, j, timeUnit);
        }
        scheduledAction.add(futureSchedule);
        return scheduledAction;
    }

    public ScheduledAction scheduleActual(Action0 action0, long j, TimeUnit timeUnit, SubscriptionList subscriptionList) {
        Future<?> futureSchedule;
        ScheduledAction scheduledAction = new ScheduledAction(RxJavaHooks.onScheduledAction(action0), subscriptionList);
        subscriptionList.add(scheduledAction);
        if (j <= 0) {
            futureSchedule = this.executor.submit(scheduledAction);
        } else {
            futureSchedule = this.executor.schedule(scheduledAction, j, timeUnit);
        }
        scheduledAction.add(futureSchedule);
        return scheduledAction;
    }
}
