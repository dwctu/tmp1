package dc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* compiled from: EventThread.java */
/* loaded from: classes4.dex */
public class jx3 extends Thread {
    public static jx3 c;
    public static ExecutorService d;
    public static final Logger a = Logger.getLogger(jx3.class.getName());
    public static final ThreadFactory b = new a();
    public static int e = 0;

    /* compiled from: EventThread.java */
    public class a implements ThreadFactory {

        /* compiled from: EventThread.java */
        /* renamed from: dc.jx3$a$a, reason: collision with other inner class name */
        public class C0192a extends Handler {
            public C0192a(a aVar) {
            }

            @Override // java.util.logging.Handler
            public void close() throws SecurityException {
            }

            @Override // java.util.logging.Handler
            public void flush() {
            }

            @Override // java.util.logging.Handler
            public void publish(LogRecord logRecord) {
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) throws SecurityException {
            jx3 unused = jx3.c = new jx3(runnable, null);
            jx3.c.setName("EventThread");
            jx3.c.setDaemon(Thread.currentThread().isDaemon());
            jx3.a.setLevel(Level.FINEST);
            jx3.a.addHandler(new C0192a(this));
            return jx3.c;
        }
    }

    /* compiled from: EventThread.java */
    public class b implements Runnable {
        public final /* synthetic */ Runnable a;

        public b(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.run();
                synchronized (jx3.class) {
                    jx3.e();
                    if (jx3.e == 0) {
                        jx3.d.shutdown();
                        ExecutorService unused = jx3.d = null;
                        jx3 unused2 = jx3.c = null;
                    }
                }
            } catch (Throwable th) {
                try {
                    jx3.a.log(Level.SEVERE, "Task threw exception", th);
                    throw th;
                } catch (Throwable th2) {
                    synchronized (jx3.class) {
                        jx3.e();
                        if (jx3.e == 0) {
                            jx3.d.shutdown();
                            ExecutorService unused3 = jx3.d = null;
                            jx3 unused4 = jx3.c = null;
                        }
                        throw th2;
                    }
                }
            }
        }
    }

    public /* synthetic */ jx3(Runnable runnable, a aVar) {
        this(runnable);
    }

    public static /* synthetic */ int e() {
        int i = e;
        e = i - 1;
        return i;
    }

    public static void h(Runnable runnable) {
        if (i()) {
            ej4.a("直接运行");
            runnable.run();
        } else {
            ej4.a("进入下个tick");
            j(runnable);
        }
    }

    public static boolean i() {
        return Thread.currentThread() == c;
    }

    public static void j(Runnable runnable) {
        ExecutorService executorService;
        synchronized (jx3.class) {
            e++;
            if (d == null) {
                d = Executors.newSingleThreadExecutor(b);
            }
            executorService = d;
        }
        executorService.execute(new b(runnable));
    }

    public jx3(Runnable runnable) {
        super(runnable);
    }
}
