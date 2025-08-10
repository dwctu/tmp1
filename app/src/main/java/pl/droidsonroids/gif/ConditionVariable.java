package pl.droidsonroids.gif;

/* loaded from: classes5.dex */
public class ConditionVariable {
    private volatile boolean mCondition;

    public synchronized void block() throws InterruptedException {
        while (!this.mCondition) {
            wait();
        }
    }

    public synchronized void close() {
        this.mCondition = false;
    }

    public synchronized void open() {
        boolean z = this.mCondition;
        this.mCondition = true;
        if (!z) {
            notify();
        }
    }

    public synchronized void set(boolean z) {
        if (z) {
            open();
        } else {
            close();
        }
    }
}
