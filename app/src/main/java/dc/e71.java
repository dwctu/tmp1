package dc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import com.google.android.gms.common.ConnectionResult;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ToastStrategy.java */
/* loaded from: classes2.dex */
public class e71 implements k71 {
    public static final Handler f = new Handler(Looper.getMainLooper());
    public Application a;
    public WeakReference<i71> b;
    public final int c;
    public final Object d;
    public volatile long e;

    /* compiled from: ToastStrategy.java */
    public class b implements Runnable {
        public final d71 a;

        @Override // java.lang.Runnable
        public void run() {
            i71 i71Var = e71.this.b != null ? (i71) e71.this.b.get() : null;
            if (i71Var != null) {
                i71Var.cancel();
            }
            i71 i71VarF = e71.this.f(this.a);
            e71.this.b = new WeakReference(i71VarF);
            i71VarF.setDuration(this.a.b);
            i71VarF.setText(this.a.a);
            i71VarF.show();
        }

        public b(d71 d71Var) {
            this.a = d71Var;
        }
    }

    public e71() {
        this(0);
    }

    @Override // dc.k71
    public void a(d71 d71Var) {
        int i = this.c;
        if (i == 0) {
            Handler handler = f;
            handler.removeCallbacksAndMessages(this.d);
            handler.postAtTime(new b(d71Var), this.d, SystemClock.uptimeMillis() + d71Var.c + (d71Var.d ? 0 : 200));
        } else {
            if (i != 1) {
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis() + d71Var.c + (d71Var.d ? 0 : 200);
            long jH = h(d71Var);
            if (jUptimeMillis < this.e + jH) {
                jUptimeMillis = this.e + jH;
            }
            f.postAtTime(new b(d71Var), this.d, jUptimeMillis);
            this.e = jUptimeMillis;
        }
    }

    @Override // dc.k71
    public void b(Application application) {
        this.a = application;
    }

    @SuppressLint({"PrivateApi"})
    public boolean e(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return ((NotificationManager) context.getSystemService(NotificationManager.class)).areNotificationsEnabled();
        }
        if (i >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            try {
                Class<?> cls = appOpsManager.getClass();
                Class<?> cls2 = Integer.TYPE;
                return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) appOpsManager.getClass().getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(context.getApplicationInfo().uid), context.getPackageName())).intValue() == 0;
            } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public i71 f(d71 d71Var) {
        Activity activityI = i();
        int i = Build.VERSION.SDK_INT;
        i71 z61Var = (i < 23 || !Settings.canDrawOverlays(this.a)) ? (d71Var.d || !j(activityI)) ? i == 25 ? new z61(this.a) : (i >= 29 || e(this.a)) ? new a71(this.a) : new x61(this.a) : new t61(activityI) : new v61(this.a);
        if (l(z61Var) || !m()) {
            g(z61Var, d71Var.e);
        }
        return z61Var;
    }

    public void g(i71 i71Var, m71<?> m71Var) {
        i71Var.setView(m71Var.b(this.a));
        i71Var.setGravity(m71Var.d(), m71Var.e(), m71Var.f());
        i71Var.setMargin(m71Var.a(), m71Var.c());
    }

    public int h(d71 d71Var) {
        int i = d71Var.b;
        if (i == 0) {
            return 1000;
        }
        if (i == 1) {
            return ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
        }
        return 0;
    }

    public Activity i() {
        return s61.b().a();
    }

    public boolean j(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            return !activity.isDestroyed();
        }
        return true;
    }

    @SuppressLint({"PrivateApi"})
    public boolean k(long j) throws NoSuchMethodException, SecurityException {
        if (Build.VERSION.SDK_INT < 30) {
            return true;
        }
        try {
            Method method = Class.forName("android.app.compat.CompatChanges").getMethod("isChangeEnabled", Long.TYPE);
            method.setAccessible(true);
            return Boolean.parseBoolean(String.valueOf(method.invoke(null, Long.valueOf(j))));
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean l(i71 i71Var) {
        return (i71Var instanceof u61) || Build.VERSION.SDK_INT < 30 || this.a.getApplicationInfo().targetSdkVersion < 30;
    }

    public boolean m() {
        return k(147798919L);
    }

    public e71(int i) {
        this.d = new Object();
        this.c = i;
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("Please don't pass non-existent toast show strategy");
        }
    }
}
