package dc;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.lang.Thread;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ThreadUtils.java */
/* loaded from: classes.dex */
public final class se0 {
    public static final Handler a = new Handler(Looper.getMainLooper());
    public static final Map<Integer, Map<Integer, ExecutorService>> b = new HashMap();
    public static final int c;

    /* compiled from: ThreadUtils.java */
    public static final class b extends ThreadPoolExecutor {
        public final AtomicInteger a;
        public a b;

        public b(int i, int i2, long j, TimeUnit timeUnit, a aVar, ThreadFactory threadFactory) {
            super(i, i2, j, timeUnit, aVar, threadFactory);
            this.a = new AtomicInteger();
            aVar.mPool = this;
            this.b = aVar;
        }

        public static ExecutorService b(int i, int i2) {
            if (i == -8) {
                return new b(se0.c + 1, (se0.c * 2) + 1, 30L, TimeUnit.SECONDS, new a(true), new c("cpu", i2));
            }
            if (i == -4) {
                return new b((se0.c * 2) + 1, (se0.c * 2) + 1, 30L, TimeUnit.SECONDS, new a(), new c("io", i2));
            }
            if (i == -2) {
                return new b(0, 128, 60L, TimeUnit.SECONDS, new a(true), new c("cached", i2));
            }
            if (i == -1) {
                return new b(1, 1, 0L, TimeUnit.MILLISECONDS, new a(), new c("single", i2));
            }
            return new b(i, i, 0L, TimeUnit.MILLISECONDS, new a(), new c("fixed(" + i + ")", i2));
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public void afterExecute(Runnable runnable, Throwable th) {
            this.a.decrementAndGet();
            super.afterExecute(runnable, th);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            if (isShutdown()) {
                return;
            }
            this.a.incrementAndGet();
            try {
                super.execute(runnable);
            } catch (RejectedExecutionException unused) {
                de0.l("ThreadUtils", "This will not happen!");
                this.b.offer(runnable);
            } catch (Throwable unused2) {
                this.a.decrementAndGet();
            }
        }
    }

    /* compiled from: ThreadUtils.java */
    public static final class c extends AtomicLong implements ThreadFactory {
        public static final AtomicInteger a = new AtomicInteger(1);
        private static final long serialVersionUID = -9209200509960368598L;
        private final boolean isDaemon;
        private final String namePrefix;
        private final int priority;

        /* compiled from: ThreadUtils.java */
        public class a extends Thread {
            public a(c cVar, Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    super.run();
                } catch (Throwable th) {
                    de0.l("ThreadUtils", "Request threw uncaught throwable", th);
                }
            }
        }

        /* compiled from: ThreadUtils.java */
        public class b implements Thread.UncaughtExceptionHandler {
            public b(c cVar) {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                System.out.println(th);
            }
        }

        public c(String str, int i) {
            this(str, i, false);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            a aVar = new a(this, runnable, this.namePrefix + getAndIncrement());
            aVar.setDaemon(this.isDaemon);
            aVar.setUncaughtExceptionHandler(new b(this));
            aVar.setPriority(this.priority);
            return aVar;
        }

        public c(String str, int i, boolean z) {
            this.namePrefix = str + "-pool-" + a.getAndIncrement() + "-thread-";
            this.priority = i;
            this.isDaemon = z;
        }
    }

    static {
        new ConcurrentHashMap();
        c = Runtime.getRuntime().availableProcessors();
        new Timer();
    }

    public static ExecutorService b() {
        return d(-2);
    }

    public static ExecutorService c() {
        return d(-4);
    }

    public static ExecutorService d(int i) {
        return e(i, 5);
    }

    public static ExecutorService e(int i, int i2) {
        ExecutorService executorServiceB;
        Map<Integer, Map<Integer, ExecutorService>> map = b;
        synchronized (map) {
            Map<Integer, ExecutorService> map2 = map.get(Integer.valueOf(i));
            if (map2 == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                executorServiceB = b.b(i, i2);
                concurrentHashMap.put(Integer.valueOf(i2), executorServiceB);
                map.put(Integer.valueOf(i), concurrentHashMap);
            } else {
                executorServiceB = map2.get(Integer.valueOf(i2));
                if (executorServiceB == null) {
                    executorServiceB = b.b(i, i2);
                    map2.put(Integer.valueOf(i2), executorServiceB);
                }
            }
        }
        return executorServiceB;
    }

    public static void f(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            a.post(runnable);
        }
    }

    public static void g(Runnable runnable, long j) {
        a.postDelayed(runnable, j);
    }

    /* compiled from: ThreadUtils.java */
    public static final class a extends LinkedBlockingQueue<Runnable> {
        private int mCapacity;
        private volatile b mPool;

        public a() {
            this.mCapacity = Integer.MAX_VALUE;
        }

        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean offer(@NonNull Runnable runnable) {
            if (this.mCapacity > size() || this.mPool == null || this.mPool.getPoolSize() >= this.mPool.getMaximumPoolSize()) {
                return super.offer(runnable);
            }
            return false;
        }

        public a(boolean z) {
            this.mCapacity = Integer.MAX_VALUE;
            if (z) {
                this.mCapacity = 0;
            }
        }
    }
}
