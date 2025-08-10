package io.reactivex.internal.schedulers;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class SchedulerPoolFactory {
    public static final boolean PURGE_ENABLED;
    public static final String PURGE_ENABLED_KEY = "rx2.purge-enabled";
    public static final int PURGE_PERIOD_SECONDS;
    public static final String PURGE_PERIOD_SECONDS_KEY = "rx2.purge-period-seconds";
    public static final AtomicReference<ScheduledExecutorService> PURGE_THREAD = new AtomicReference<>();
    public static final Map<ScheduledThreadPoolExecutor, Object> POOLS = new ConcurrentHashMap();

    public static final class ScheduledTask implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(SchedulerPoolFactory.POOLS.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    SchedulerPoolFactory.POOLS.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    public static final class SystemPropertyAccessor implements Function<String, String> {
        @Override // io.reactivex.functions.Function
        public String apply(String str) throws Exception {
            return System.getProperty(str);
        }
    }

    static {
        SystemPropertyAccessor systemPropertyAccessor = new SystemPropertyAccessor();
        boolean booleanProperty = getBooleanProperty(true, PURGE_ENABLED_KEY, true, true, systemPropertyAccessor);
        PURGE_ENABLED = booleanProperty;
        PURGE_PERIOD_SECONDS = getIntProperty(booleanProperty, PURGE_PERIOD_SECONDS_KEY, 1, 1, systemPropertyAccessor);
        start();
    }

    private SchedulerPoolFactory() {
        throw new IllegalStateException("No instances!");
    }

    public static ScheduledExecutorService create(ThreadFactory threadFactory) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        tryPutIntoPool(PURGE_ENABLED, scheduledExecutorServiceNewScheduledThreadPool);
        return scheduledExecutorServiceNewScheduledThreadPool;
    }

    public static boolean getBooleanProperty(boolean z, String str, boolean z2, boolean z3, Function<String, String> function) {
        if (!z) {
            return z3;
        }
        try {
            String strApply = function.apply(str);
            return strApply == null ? z2 : "true".equals(strApply);
        } catch (Throwable unused) {
            return z2;
        }
    }

    public static int getIntProperty(boolean z, String str, int i, int i2, Function<String, String> function) {
        if (!z) {
            return i2;
        }
        try {
            String strApply = function.apply(str);
            return strApply == null ? i : Integer.parseInt(strApply);
        } catch (Throwable unused) {
            return i;
        }
    }

    public static void shutdown() {
        ScheduledExecutorService andSet = PURGE_THREAD.getAndSet(null);
        if (andSet != null) {
            andSet.shutdownNow();
        }
        POOLS.clear();
    }

    public static void start() {
        tryStart(PURGE_ENABLED);
    }

    public static void tryPutIntoPool(boolean z, ScheduledExecutorService scheduledExecutorService) {
        if (z && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            POOLS.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    public static void tryStart(boolean z) {
        if (!z) {
            return;
        }
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = PURGE_THREAD;
            ScheduledExecutorService scheduledExecutorService = atomicReference.get();
            if (scheduledExecutorService != null) {
                return;
            }
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
            if (atomicReference.compareAndSet(scheduledExecutorService, scheduledExecutorServiceNewScheduledThreadPool)) {
                ScheduledTask scheduledTask = new ScheduledTask();
                int i = PURGE_PERIOD_SECONDS;
                scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(scheduledTask, i, i, TimeUnit.SECONDS);
                return;
            }
            scheduledExecutorServiceNewScheduledThreadPool.shutdownNow();
        }
    }
}
