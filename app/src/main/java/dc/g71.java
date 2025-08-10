package dc;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

/* compiled from: WindowLifecycle.java */
/* loaded from: classes2.dex */
public final class g71 implements Application.ActivityLifecycleCallbacks {
    public Activity a;
    public Application b;
    public b71 c;

    public g71(Activity activity) {
        this.a = activity;
    }

    public WindowManager a() {
        Activity activity = this.a;
        if (activity != null) {
            if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
                return this.a.getWindowManager();
            }
            return null;
        }
        Application application = this.b;
        if (application != null) {
            return (WindowManager) application.getSystemService("window");
        }
        return null;
    }

    public void b(b71 b71Var) {
        this.c = b71Var;
        Activity activity = this.a;
        if (activity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            activity.registerActivityLifecycleCallbacks(this);
        } else {
            activity.getApplication().registerActivityLifecycleCallbacks(this);
        }
    }

    public void c() {
        this.c = null;
        Activity activity = this.a;
        if (activity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            activity.unregisterActivityLifecycleCallbacks(this);
        } else {
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (this.a != activity) {
            return;
        }
        b71 b71Var = this.c;
        if (b71Var != null) {
            b71Var.g();
        }
        c();
        this.a = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        b71 b71Var;
        if (this.a == activity && (b71Var = this.c) != null) {
            b71Var.g();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public g71(Application application) {
        this.b = application;
    }
}
