package dc;

import java.util.concurrent.BlockingQueue;

/* compiled from: TaskExecutor.java */
/* loaded from: classes4.dex */
public class dk3 extends Thread {
    public BlockingQueue<ck3> a;
    public boolean b = true;

    public dk3(BlockingQueue<ck3> blockingQueue) {
        this.a = blockingQueue;
    }

    public void a() {
        this.b = false;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (this.b) {
            try {
                this.a.take().run();
            } catch (InterruptedException unused) {
                if (!this.b) {
                    interrupt();
                    return;
                }
            }
        }
    }
}
