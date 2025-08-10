package dc;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.lifecycle.Lifecycle;
import com.samsung.android.sdk.bt.gatt.BluetoothGatt;
import dc.ve0;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: UtilsActivityLifecycleImpl.java */
/* loaded from: classes.dex */
public final class we0 implements Application.ActivityLifecycleCallbacks {
    public static final we0 g = new we0();
    public static final Activity h = new Activity();
    public final LinkedList<WeakReference<Activity>> a = new LinkedList<>();
    public final List<ve0.c> b = new CopyOnWriteArrayList();
    public final Map<Activity, List<ve0.a>> c = new ConcurrentHashMap();
    public int d = 0;
    public int e = 0;
    public boolean f = false;

    /* compiled from: UtilsActivityLifecycleImpl.java */
    public class a implements Runnable {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ ve0.a b;

        public a(Activity activity, ve0.a aVar) {
            this.a = activity;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            we0.this.e(this.a, this.b);
        }
    }

    /* compiled from: UtilsActivityLifecycleImpl.java */
    public class b implements Runnable {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ ve0.a b;

        public b(Activity activity, ve0.a aVar) {
            this.a = activity;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            we0.this.w(this.a, this.b);
        }
    }

    /* compiled from: UtilsActivityLifecycleImpl.java */
    public class c implements Runnable {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ Object b;

        public c(we0 we0Var, Activity activity, Object obj) {
            this.a = activity;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Window window = this.a.getWindow();
                if (window != null) {
                    window.setSoftInputMode(((Integer) this.b).intValue());
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void y() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        if (Build.VERSION.SDK_INT < 26 || !ValueAnimator.areAnimatorsEnabled()) {
            try {
                Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
                declaredField.setAccessible(true);
                if (((Float) declaredField.get(null)).floatValue() == 0.0f) {
                    declaredField.set(null, Float.valueOf(1.0f));
                    de0.v("UtilsActivityLifecycle", "setAnimatorsEnabled: Animators are enabled now!");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void A(Application application) {
        this.a.clear();
        application.unregisterActivityLifecycleCallbacks(this);
    }

    public void c(Activity activity, ve0.a aVar) {
        if (activity == null || aVar == null) {
            return;
        }
        xe0.Q(new a(activity, aVar));
    }

    public void d(ve0.a aVar) {
        c(h, aVar);
    }

    public final void e(Activity activity, ve0.a aVar) {
        List<ve0.a> copyOnWriteArrayList = this.c.get(activity);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.c.put(activity, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(aVar)) {
            return;
        }
        copyOnWriteArrayList.add(aVar);
    }

    public void f(ve0.c cVar) {
        this.b.add(cVar);
    }

    public final void g(Activity activity, Lifecycle.Event event) {
        h(activity, event, this.c.get(activity));
        h(activity, event, this.c.get(h));
    }

    public final void h(Activity activity, Lifecycle.Event event, List<ve0.a> list) {
        if (list == null) {
            return;
        }
        for (ve0.a aVar : list) {
            aVar.g(activity, event);
            if (event.equals(Lifecycle.Event.ON_CREATE)) {
                aVar.a(activity);
            } else if (event.equals(Lifecycle.Event.ON_START)) {
                aVar.e(activity);
            } else if (event.equals(Lifecycle.Event.ON_RESUME)) {
                aVar.d(activity);
            } else if (event.equals(Lifecycle.Event.ON_PAUSE)) {
                aVar.c(activity);
            } else if (event.equals(Lifecycle.Event.ON_STOP)) {
                aVar.f(activity);
            } else if (event.equals(Lifecycle.Event.ON_DESTROY)) {
                aVar.b(activity);
            }
        }
        if (event.equals(Lifecycle.Event.ON_DESTROY)) {
            this.c.remove(activity);
        }
    }

    public final List<WeakReference<Activity>> i() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        Object objK;
        LinkedList linkedList = new LinkedList();
        Activity activity = null;
        try {
            objK = k();
        } catch (Exception e) {
            de0.l("UtilsActivityLifecycle", "getActivitiesByReflect: " + e.getMessage());
        }
        if (objK == null) {
            return linkedList;
        }
        Field declaredField = objK.getClass().getDeclaredField("mActivities");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(objK);
        if (!(obj instanceof Map)) {
            return linkedList;
        }
        for (Object obj2 : ((Map) obj).values()) {
            Class<?> cls = obj2.getClass();
            Field declaredField2 = cls.getDeclaredField(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            declaredField2.setAccessible(true);
            Activity activity2 = (Activity) declaredField2.get(obj2);
            if (activity == null) {
                Field declaredField3 = cls.getDeclaredField("paused");
                declaredField3.setAccessible(true);
                if (declaredField3.getBoolean(obj2)) {
                    linkedList.addFirst(new WeakReference(activity2));
                } else {
                    activity = activity2;
                }
            } else {
                linkedList.addFirst(new WeakReference(activity2));
            }
        }
        if (activity != null) {
            linkedList.addFirst(new WeakReference(activity));
        }
        return linkedList;
    }

    public List<WeakReference<Activity>> j() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        if (!this.a.isEmpty()) {
            return new LinkedList(this.a);
        }
        this.a.addAll(i());
        return new LinkedList(this.a);
    }

    public final Object k() throws NoSuchFieldException {
        Object objL = l();
        return objL != null ? objL : m();
    }

    public final Object l() throws NoSuchFieldException {
        try {
            Field declaredField = Class.forName("android.app.ActivityThread").getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            de0.l("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticField: " + e.getMessage());
            return null;
        }
    }

    public final Object m() {
        try {
            return Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            de0.l("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticMethod: " + e.getMessage());
            return null;
        }
    }

    public Application n() throws ClassNotFoundException {
        Object objInvoke;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objK = k();
            if (objK == null || (objInvoke = cls.getMethod("getApplication", new Class[0]).invoke(objK, new Object[0])) == null) {
                return null;
            }
            return (Application) objInvoke;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Activity o() {
        for (WeakReference<Activity> weakReference : j()) {
            if (weakReference != null && weakReference.get() != null && xe0.E(weakReference.get())) {
                return weakReference.get();
            }
        }
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, Bundle bundle) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        if (this.a.size() == 0) {
            r(activity, true);
        }
        ce0.a(activity);
        y();
        z(activity);
        g(activity, Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
        t(activity);
        xe0.i(activity);
        g(activity, Lifecycle.Event.ON_DESTROY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
        g(activity, Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostDestroyed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostPaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostSaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStarted(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStopped(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreDestroyed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPrePaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreResumed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreSaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStarted(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStopped(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
        if (this.f) {
            this.f = false;
            r(activity, true);
        }
        s(activity, false);
        g(activity, Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
        int i = this.e;
        if (i < 0) {
            this.e = i + 1;
        } else {
            this.d++;
        }
        g(activity, Lifecycle.Event.ON_START);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (activity.isChangingConfigurations()) {
            this.e--;
        } else {
            int i = this.d - 1;
            this.d = i;
            if (i <= 0) {
                this.f = true;
                r(activity, false);
            }
        }
        s(activity, true);
        g(activity, Lifecycle.Event.ON_STOP);
    }

    public void p(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    public boolean q() {
        return !this.f;
    }

    public final void r(Activity activity, boolean z) {
        if (this.b.isEmpty()) {
            return;
        }
        for (ve0.c cVar : this.b) {
            if (z) {
                cVar.a(activity);
            } else {
                cVar.b(activity);
            }
        }
    }

    public final void s(Activity activity, boolean z) {
        try {
            if (z) {
                Window window = activity.getWindow();
                window.getDecorView().setTag(BluetoothGatt.GATT_ERROR, Integer.valueOf(window.getAttributes().softInputMode));
                window.setSoftInputMode(3);
            } else {
                Object tag = activity.getWindow().getDecorView().getTag(BluetoothGatt.GATT_ERROR);
                if (!(tag instanceof Integer)) {
                } else {
                    xe0.R(new c(this, activity, tag), 100L);
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void t(Activity activity) {
        Iterator<WeakReference<Activity>> it = this.a.iterator();
        while (it.hasNext()) {
            WeakReference<Activity> next = it.next();
            if (next == null || next.get() == null || next.get() == activity) {
                it.remove();
            }
        }
    }

    public void u(Activity activity, ve0.a aVar) {
        if (activity == null || aVar == null) {
            return;
        }
        xe0.Q(new b(activity, aVar));
    }

    public void v(ve0.a aVar) {
        u(h, aVar);
    }

    public final void w(Activity activity, ve0.a aVar) {
        List<ve0.a> list = this.c.get(activity);
        if (list == null || list.isEmpty()) {
            return;
        }
        list.remove(aVar);
    }

    public void x(ve0.c cVar) {
        this.b.remove(cVar);
    }

    public final void z(Activity activity) {
        this.a.addFirst(new WeakReference<>(activity));
    }
}
