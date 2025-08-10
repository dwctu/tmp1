package dc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: ThreadPoolFactory.java */
/* loaded from: classes4.dex */
public class vg3 {
    public static vg3 b = new vg3();
    public ExecutorService a = Executors.newCachedThreadPool();

    public static vg3 b() {
        return b;
    }

    public void a(Runnable runnable) {
        this.a.submit(runnable);
    }

    public ExecutorService c() {
        return this.a;
    }
}
