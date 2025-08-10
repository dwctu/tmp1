package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class GenericScheduledExecutorService implements SchedulerLifecycle {
    public static final GenericScheduledExecutorService INSTANCE;
    private static final ScheduledExecutorService[] NONE = new ScheduledExecutorService[0];
    private static final ScheduledExecutorService SHUTDOWN;
    private static int roundRobin;
    private final AtomicReference<ScheduledExecutorService[]> executor = new AtomicReference<>(NONE);

    static {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(0);
        SHUTDOWN = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.shutdown();
        INSTANCE = new GenericScheduledExecutorService();
    }

    private GenericScheduledExecutorService() {
        start();
    }

    public static ScheduledExecutorService getInstance() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = INSTANCE.executor.get();
        if (scheduledExecutorServiceArr == NONE) {
            return SHUTDOWN;
        }
        int i = roundRobin + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        roundRobin = i;
        return scheduledExecutorServiceArr[i];
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void shutdown() {
        ScheduledExecutorService[] scheduledExecutorServiceArr;
        ScheduledExecutorService[] scheduledExecutorServiceArr2;
        do {
            scheduledExecutorServiceArr = this.executor.get();
            scheduledExecutorServiceArr2 = NONE;
            if (scheduledExecutorServiceArr == scheduledExecutorServiceArr2) {
                return;
            }
        } while (!this.executor.compareAndSet(scheduledExecutorServiceArr, scheduledExecutorServiceArr2));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            NewThreadWorker.deregisterExecutor(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    @Override // rx.internal.schedulers.SchedulerLifecycle
    public void start() {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        if (iAvailableProcessors > 4) {
            iAvailableProcessors /= 2;
        }
        if (iAvailableProcessors > 8) {
            iAvailableProcessors = 8;
        }
        ScheduledExecutorService[] scheduledExecutorServiceArr = new ScheduledExecutorService[iAvailableProcessors];
        int i = 0;
        for (int i2 = 0; i2 < iAvailableProcessors; i2++) {
            scheduledExecutorServiceArr[i2] = GenericScheduledExecutorServiceFactory.create();
        }
        if (!this.executor.compareAndSet(NONE, scheduledExecutorServiceArr)) {
            while (i < iAvailableProcessors) {
                scheduledExecutorServiceArr[i].shutdownNow();
                i++;
            }
        } else {
            while (i < iAvailableProcessors) {
                ScheduledExecutorService scheduledExecutorService = scheduledExecutorServiceArr[i];
                if (!NewThreadWorker.tryEnableCancelPolicy(scheduledExecutorService) && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
                    NewThreadWorker.registerExecutor((ScheduledThreadPoolExecutor) scheduledExecutorService);
                }
                i++;
            }
        }
    }
}
