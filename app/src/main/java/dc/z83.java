package dc;

import androidx.annotation.NonNull;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: CommonExecutor.java */
/* loaded from: classes4.dex */
public class z83 {
    public static volatile z83 b;
    public ExecutorService a = Executors.newCachedThreadPool(new a(this));

    /* compiled from: CommonExecutor.java */
    public class a implements ThreadFactory {
        public a(z83 z83Var) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("CommonExecutor");
            return thread;
        }
    }

    public static z83 b() {
        if (b == null) {
            synchronized (z83.class) {
                if (b == null) {
                    b = new z83();
                }
            }
        }
        return b;
    }

    public void a(Runnable runnable) {
        this.a.execute(runnable);
    }
}
