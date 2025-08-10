package dc;

import com.alibaba.android.arouter.facade.template.ILogger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DefaultPoolExecutor.java */
/* loaded from: classes.dex */
public class sd extends ThreadPoolExecutor {
    public static final int a;
    public static final int b;
    public static final int c;
    public static volatile sd d;

    /* compiled from: DefaultPoolExecutor.java */
    public class a implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            pd.c.error(ILogger.defaultTag, "Task rejected, too many task!");
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        a = iAvailableProcessors;
        int i = iAvailableProcessors + 1;
        b = i;
        c = i;
    }

    public sd(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, new a());
    }

    public static sd a() {
        if (d == null) {
            synchronized (sd.class) {
                if (d == null) {
                    d = new sd(b, c, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(64), new td());
                }
            }
        }
        return d;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) throws ExecutionException, InterruptedException {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future)) {
            try {
                ((Future) runnable).get();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (CancellationException e) {
                th = e;
            } catch (ExecutionException e2) {
                th = e2.getCause();
            }
        }
        if (th != null) {
            pd.c.warning(ILogger.defaultTag, "Running task appeared exception! Thread [" + Thread.currentThread().getName() + "], because [" + th.getMessage() + "]\n" + yd.a(th.getStackTrace()));
        }
    }
}
