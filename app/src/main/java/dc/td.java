package dc;

import androidx.annotation.NonNull;
import com.alibaba.android.arouter.facade.template.ILogger;
import java.lang.Thread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: DefaultThreadFactory.java */
/* loaded from: classes.dex */
public class td implements ThreadFactory {
    public static final AtomicInteger d = new AtomicInteger(1);
    public final AtomicInteger a = new AtomicInteger(1);
    public final ThreadGroup b;
    public final String c;

    /* compiled from: DefaultThreadFactory.java */
    public class a implements Thread.UncaughtExceptionHandler {
        public a(td tdVar) {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            pd.c.info(ILogger.defaultTag, "Running task appeared exception! Thread [" + thread.getName() + "], because [" + th.getMessage() + "]");
        }
    }

    public td() {
        SecurityManager securityManager = System.getSecurityManager();
        this.b = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.c = "ARouter task pool No." + d.getAndIncrement() + ", thread No.";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(@NonNull Runnable runnable) {
        String str = this.c + this.a.getAndIncrement();
        pd.c.info(ILogger.defaultTag, "Thread production, name is [" + str + "]");
        Thread thread = new Thread(this.b, runnable, str, 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        thread.setUncaughtExceptionHandler(new a(this));
        return thread;
    }
}
