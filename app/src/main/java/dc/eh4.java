package dc;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: SkinActivityLifecycle.java */
/* loaded from: classes5.dex */
public class eh4 implements Application.ActivityLifecycleCallbacks {
    public static volatile eh4 d;
    public WeakHashMap<Context, gh4> a;
    public WeakHashMap<Context, a> b;
    public WeakReference<Activity> c;

    /* compiled from: SkinActivityLifecycle.java */
    public class a implements li4 {
        public final Context a;
        public boolean b = false;

        public a(Context context) {
            this.a = context;
        }

        @Override // dc.li4
        public void a(ki4 ki4Var, Object obj) {
            if (eh4.this.c == null || this.a == eh4.this.c.get() || !(this.a instanceof Activity)) {
                b();
            } else {
                this.b = true;
            }
        }

        public void b() {
            if (pi4.a) {
                pi4.a("SkinActivityLifecycle", "Context: " + this.a + " updateSkinForce");
            }
            Context context = this.a;
            if (context == null) {
                return;
            }
            if ((context instanceof Activity) && eh4.this.i(context)) {
                eh4.this.j((Activity) this.a);
            }
            eh4.this.f(this.a).a();
            Object obj = this.a;
            if (obj instanceof aj4) {
                ((aj4) obj).P1();
            }
            this.b = false;
        }

        public void c() {
            if (this.b) {
                b();
            }
        }
    }

    public eh4(Application application) {
        application.registerActivityLifecycleCallbacks(this);
        h(application);
        zg4.m().a(e(application));
    }

    public static eh4 g(Application application) {
        if (d == null) {
            synchronized (eh4.class) {
                if (d == null) {
                    d = new eh4(application);
                }
            }
        }
        return d;
    }

    public final a e(Context context) {
        if (this.b == null) {
            this.b = new WeakHashMap<>();
        }
        a aVar = this.b.get(context);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(context);
        this.b.put(context, aVar2);
        return aVar2;
    }

    public final gh4 f(Context context) {
        if (this.a == null) {
            this.a = new WeakHashMap<>();
        }
        gh4 gh4Var = this.a.get(context);
        if (gh4Var != null) {
            return gh4Var;
        }
        gh4 gh4VarB = gh4.b(context);
        this.a.put(context, gh4VarB);
        return gh4VarB;
    }

    public final void h(Context context) {
        try {
            qi4.b(LayoutInflater.from(context), f(context));
        } catch (Throwable unused) {
            pi4.a("SkinActivity", "A factory has already been set on this LayoutInflater");
        }
    }

    public final boolean i(Context context) {
        return zg4.m().t() || context.getClass().getAnnotation(dh4.class) != null || (context instanceof aj4);
    }

    public final void j(Activity activity) {
        Drawable drawableD;
        if (zg4.m().u()) {
            int iH = uh4.h(activity);
            if (vi4.a(iH) == 0 || (drawableD = th4.d(activity, iH)) == null) {
                return;
            }
            activity.getWindow().setBackgroundDrawable(drawableD);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        LayoutInflater.from(activity);
        if (i(activity)) {
            h(activity);
            j(activity);
            if (activity instanceof aj4) {
                ((aj4) activity).P1();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (i(activity)) {
            zg4.m().b(e(activity));
            this.b.remove(activity);
            this.a.remove(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.c = new WeakReference<>(activity);
        if (i(activity)) {
            a aVarE = e(activity);
            zg4.m().a(aVarE);
            aVarE.c();
        }
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
