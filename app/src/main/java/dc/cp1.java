package dc;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import androidx.appcompat.widget.ActivityChooserModel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: NotificationTimer.java */
/* loaded from: classes3.dex */
public class cp1 implements Runnable {
    public static boolean g;
    public static boolean h;
    public final b a = new b(this);
    public ActivityManager b;
    public List<ActivityManager.RunningAppProcessInfo> c;
    public long d;
    public a e;
    public Thread f;

    /* compiled from: NotificationTimer.java */
    public interface a {
        void a(long j);
    }

    /* compiled from: NotificationTimer.java */
    public static class b extends Handler {
        public final WeakReference<cp1> a;

        public b(cp1 cp1Var) {
            this.a = new WeakReference<>(cp1Var);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<cp1> weakReference = this.a;
            if (weakReference != null) {
                weakReference.get();
                boolean unused = cp1.g = false;
                boolean unused2 = cp1.h = false;
            }
        }
    }

    public cp1(long j, Context context) {
        g = false;
        this.d = j;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.b = activityManager;
        this.c = activityManager.getRunningAppProcesses();
        new ArrayList();
        h = false;
    }

    public boolean c() {
        return h;
    }

    public int d() {
        return Process.myPid();
    }

    public void e(a aVar) {
        this.e = aVar;
    }

    public void f(boolean z) {
        g = z;
    }

    public void g(long j) {
        this.d = j;
    }

    public void h() {
        Thread thread = new Thread(this);
        this.f = thread;
        thread.start();
    }

    public final void i() {
        g = false;
        h = true;
        long jCurrentTimeMillis = System.currentTimeMillis() + this.d;
        this.e.a(System.currentTimeMillis());
        while (!g) {
            h = true;
            if (System.currentTimeMillis() > jCurrentTimeMillis) {
                jCurrentTimeMillis = System.currentTimeMillis() + this.d;
                this.e.a(System.currentTimeMillis());
            }
        }
        h = false;
        this.a.sendEmptyMessage(0);
    }

    @Override // java.lang.Runnable
    public void run() {
        i();
    }
}
