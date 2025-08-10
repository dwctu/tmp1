package dc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: ActivityStack.java */
/* loaded from: classes2.dex */
public final class s61 implements Application.ActivityLifecycleCallbacks {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile s61 b;
    public Activity a;

    public static s61 b() {
        if (b == null) {
            synchronized (s61.class) {
                if (b == null) {
                    b = new s61();
                }
            }
        }
        return b;
    }

    public Activity a() {
        return this.a;
    }

    public void c(Application application) {
        if (application == null) {
            return;
        }
        application.registerActivityLifecycleCallbacks(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (this.a != activity) {
            return;
        }
        this.a = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.a = activity;
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
}
