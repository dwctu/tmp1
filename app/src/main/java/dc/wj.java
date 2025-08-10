package dc;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: GlideExecutor.java */
/* loaded from: classes.dex */
public final class wj implements ExecutorService {
    public static final long b = TimeUnit.SECONDS.toMillis(10);
    public static volatile int c;
    public final ExecutorService a;

    /* compiled from: GlideExecutor.java */
    public static final class a {
        public final boolean a;
        public int b;
        public int c;

        @NonNull
        public c d = c.b;
        public String e;
        public long f;

        public a(boolean z) {
            this.a = z;
        }

        public wj a() {
            if (TextUtils.isEmpty(this.e)) {
                throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.e);
            }
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.b, this.c, this.f, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new b(this.e, this.d, this.a));
            if (this.f != 0) {
                threadPoolExecutor.allowCoreThreadTimeOut(true);
            }
            return new wj(threadPoolExecutor);
        }

        public a b(String str) {
            this.e = str;
            return this;
        }

        public a c(@IntRange(from = 1) int i) {
            this.b = i;
            this.c = i;
            return this;
        }
    }

    /* compiled from: GlideExecutor.java */
    public static final class b implements ThreadFactory {
        public final String a;
        public final c b;
        public final boolean c;
        public int d;

        /* compiled from: GlideExecutor.java */
        public class a extends Thread {
            public a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws SecurityException, IllegalArgumentException {
                Process.setThreadPriority(9);
                if (b.this.c) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th) {
                    b.this.b.a(th);
                }
            }
        }

        public b(String str, c cVar, boolean z) {
            this.a = str;
            this.b = cVar;
            this.c = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(@NonNull Runnable runnable) {
            a aVar;
            aVar = new a(runnable, "glide-" + this.a + "-thread-" + this.d);
            this.d = this.d + 1;
            return aVar;
        }
    }

    /* compiled from: GlideExecutor.java */
    public interface c {
        public static final c a;
        public static final c b;

        /* compiled from: GlideExecutor.java */
        public class a implements c {
            @Override // dc.wj.c
            public void a(Throwable th) {
                if (th != null) {
                    Log.isLoggable("GlideExecutor", 6);
                }
            }
        }

        static {
            a aVar = new a();
            a = aVar;
            b = aVar;
        }

        void a(Throwable th);
    }

    @VisibleForTesting
    public wj(ExecutorService executorService) {
        this.a = executorService;
    }

    public static int a() {
        if (c == 0) {
            c = Math.min(4, xj.a());
        }
        return c;
    }

    public static a b() {
        int i = a() >= 4 ? 2 : 1;
        a aVar = new a(true);
        aVar.c(i);
        aVar.b("animation");
        return aVar;
    }

    public static wj c() {
        return b().a();
    }

    public static a d() {
        a aVar = new a(true);
        aVar.c(1);
        aVar.b("disk-cache");
        return aVar;
    }

    public static wj e() {
        return d().a();
    }

    public static a f() {
        a aVar = new a(false);
        aVar.c(a());
        aVar.b("source");
        return aVar;
    }

    public static wj g() {
        return f().a();
    }

    public static wj h() {
        return new wj(new ThreadPoolExecutor(0, Integer.MAX_VALUE, b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new b("source-unlimited", c.b, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.a.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return (T) this.a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        return this.a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.a.submit(runnable);
    }

    public String toString() {
        return this.a.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.a.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) this.a.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t) {
        return this.a.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.a.submit(callable);
    }
}
