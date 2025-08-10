package dc;

import android.os.Handler;
import android.os.Looper;

/* compiled from: WorkThread.java */
/* loaded from: classes4.dex */
public class gh3 extends Thread {
    public Handler a;

    public gh3() {
        a();
    }

    public final void a() {
        start();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        Looper.prepare();
        this.a = new Handler();
        Looper.loop();
    }
}
