package dc;

import android.content.Context;
import android.content.Intent;
import com.wear.crash.CrashActivity;
import com.wear.main.MainActivity;
import com.wear.util.MyApplication;
import java.lang.Thread;
import java.text.SimpleDateFormat;

/* compiled from: CrashHandler.java */
/* loaded from: classes3.dex */
public class tt1 implements Thread.UncaughtExceptionHandler {
    public static tt1 f = new tt1();
    public Thread.UncaughtExceptionHandler a;
    public Context b;
    public String c;
    public String d;
    public String e;

    public tt1() {
        new SimpleDateFormat("yyyyMMddHHmmss");
        this.c = null;
        this.d = null;
        this.e = ng3.a();
    }

    public static tt1 a() {
        return f;
    }

    public final boolean b(Throwable th) throws InterruptedException {
        if (th == null) {
            return false;
        }
        eg3.i(this.b, "crash_handler", Boolean.TRUE);
        ye3.N(th.getMessage());
        try {
            Thread.sleep(1000L);
        } catch (Exception unused) {
        }
        return true;
    }

    public void c(Context context) {
        this.b = context;
        this.a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        if (!b(th) && (uncaughtExceptionHandler = this.a) != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        Intent intent = new Intent(this.b, (Class<?>) CrashActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("fileName", this.c);
        intent.putExtra("crashMsg", this.d);
        intent.putExtra("logId", this.e);
        intent.putExtra("email", zt3.k);
        this.b.startActivity(intent);
        MainActivity mainActivity = MyApplication.M;
        if (mainActivity != null) {
            mainActivity.finish();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.a;
        if (uncaughtExceptionHandler2 != null) {
            uncaughtExceptionHandler2.uncaughtException(thread, th);
        }
        MyApplication.D();
    }
}
