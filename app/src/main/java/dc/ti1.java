package dc;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: AppStatusManager.java */
/* loaded from: classes3.dex */
public class ti1 implements Application.ActivityLifecycleCallbacks {
    public static ti1 c;
    public int a = -1;
    public int b;

    public ti1(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    public static ti1 b() {
        return c;
    }

    public static void c(Application application) {
        if (c == null) {
            c = new ti1(application);
        }
    }

    public int a() {
        return this.a;
    }

    public void d(int i) {
        this.a = i;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.b++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        this.b--;
    }
}
