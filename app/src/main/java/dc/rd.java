package dc;

import java.util.concurrent.CountDownLatch;

/* compiled from: CancelableCountDownLatch.java */
/* loaded from: classes.dex */
public class rd extends CountDownLatch {
    public rd(int i) {
        super(i);
    }

    public void a() {
        while (getCount() > 0) {
            countDown();
        }
    }
}
