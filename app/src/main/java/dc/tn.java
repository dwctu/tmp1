package dc;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.manager.SupportRequestManagerFragment;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RequestManagerRetriever.java */
/* loaded from: classes.dex */
public class tn implements Handler.Callback {
    public static final b i = new a();
    public volatile rf a;
    public final Handler d;
    public final b e;

    @VisibleForTesting
    public final Map<FragmentManager, sn> b = new HashMap();

    @VisibleForTesting
    public final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> c = new HashMap();
    public final ArrayMap<View, Fragment> f = new ArrayMap<>();
    public final ArrayMap<View, android.app.Fragment> g = new ArrayMap<>();
    public final Bundle h = new Bundle();

    /* compiled from: RequestManagerRetriever.java */
    public class a implements b {
        @Override // dc.tn.b
        @NonNull
        public rf a(@NonNull kf kfVar, @NonNull pn pnVar, @NonNull un unVar, @NonNull Context context) {
            return new rf(kfVar, pnVar, unVar, context);
        }
    }

    /* compiled from: RequestManagerRetriever.java */
    public interface b {
        @NonNull
        rf a(@NonNull kf kfVar, @NonNull pn pnVar, @NonNull un unVar, @NonNull Context context);
    }

    public tn(@Nullable b bVar) {
        this.e = bVar == null ? i : bVar;
        this.d = new Handler(Looper.getMainLooper(), this);
    }

    @TargetApi(17)
    public static void a(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @Nullable
    public static Activity b(@NonNull Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static void e(@Nullable Collection<Fragment> collection, @NonNull Map<View, Fragment> map) {
        if (collection == null) {
            return;
        }
        for (Fragment fragment : collection) {
            if (fragment != null && fragment.getView() != null) {
                map.put(fragment.getView(), fragment);
                e(fragment.getChildFragmentManager().getFragments(), map);
            }
        }
    }

    public static boolean t(Context context) {
        Activity activityB = b(context);
        return activityB == null || !activityB.isFinishing();
    }

    @TargetApi(26)
    @Deprecated
    public final void c(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        if (Build.VERSION.SDK_INT < 26) {
            d(fragmentManager, arrayMap);
            return;
        }
        for (android.app.Fragment fragment : fragmentManager.getFragments()) {
            if (fragment.getView() != null) {
                arrayMap.put(fragment.getView(), fragment);
                c(fragment.getChildFragmentManager(), arrayMap);
            }
        }
    }

    @Deprecated
    public final void d(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            this.h.putInt("key", i2);
            android.app.Fragment fragment = null;
            try {
                fragment = fragmentManager.getFragment(this.h, "key");
            } catch (Exception unused) {
            }
            if (fragment == null) {
                return;
            }
            if (fragment.getView() != null) {
                arrayMap.put(fragment.getView(), fragment);
                if (Build.VERSION.SDK_INT >= 17) {
                    c(fragment.getChildFragmentManager(), arrayMap);
                }
            }
            i2 = i3;
        }
    }

    @Nullable
    @Deprecated
    public final android.app.Fragment f(@NonNull View view, @NonNull Activity activity) {
        this.g.clear();
        c(activity.getFragmentManager(), this.g);
        View viewFindViewById = activity.findViewById(R.id.content);
        android.app.Fragment fragment = null;
        while (!view.equals(viewFindViewById) && (fragment = this.g.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.g.clear();
        return fragment;
    }

    @Nullable
    public final Fragment g(@NonNull View view, @NonNull FragmentActivity fragmentActivity) {
        this.f.clear();
        e(fragmentActivity.getSupportFragmentManager().getFragments(), this.f);
        View viewFindViewById = fragmentActivity.findViewById(R.id.content);
        Fragment fragment = null;
        while (!view.equals(viewFindViewById) && (fragment = this.f.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f.clear();
        return fragment;
    }

    @NonNull
    @Deprecated
    public final rf h(@NonNull Context context, @NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z) {
        sn snVarQ = q(fragmentManager, fragment, z);
        rf rfVarE = snVarQ.e();
        if (rfVarE != null) {
            return rfVarE;
        }
        rf rfVarA = this.e.a(kf.c(context), snVarQ.c(), snVarQ.f(), context);
        snVarQ.k(rfVarA);
        return rfVarA;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        Object objRemove;
        Object obj2;
        int i2 = message.what;
        Object obj3 = null;
        boolean z = true;
        if (i2 == 1) {
            obj = (FragmentManager) message.obj;
            objRemove = this.b.remove(obj);
        } else {
            if (i2 != 2) {
                z = false;
                obj2 = null;
                if (z && obj3 == null && Log.isLoggable("RMRetriever", 5)) {
                    String str = "Failed to remove expected request manager fragment, manager: " + obj2;
                }
                return z;
            }
            obj = (androidx.fragment.app.FragmentManager) message.obj;
            objRemove = this.c.remove(obj);
        }
        Object obj4 = obj;
        obj3 = objRemove;
        obj2 = obj4;
        if (z) {
            String str2 = "Failed to remove expected request manager fragment, manager: " + obj2;
        }
        return z;
    }

    @NonNull
    public rf i(@NonNull Activity activity) {
        if (wp.q()) {
            return k(activity.getApplicationContext());
        }
        a(activity);
        return h(activity, activity.getFragmentManager(), null, t(activity));
    }

    @NonNull
    @TargetApi(17)
    @Deprecated
    public rf j(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        }
        if (wp.q() || Build.VERSION.SDK_INT < 17) {
            return k(fragment.getActivity().getApplicationContext());
        }
        return h(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    @NonNull
    public rf k(@NonNull Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (wp.r() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return n((FragmentActivity) context);
            }
            if (context instanceof Activity) {
                return i((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return k(contextWrapper.getBaseContext());
                }
            }
        }
        return o(context);
    }

    @NonNull
    public rf l(@NonNull View view) {
        if (wp.q()) {
            return k(view.getContext().getApplicationContext());
        }
        vp.d(view);
        vp.e(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity activityB = b(view.getContext());
        if (activityB == null) {
            return k(view.getContext().getApplicationContext());
        }
        if (!(activityB instanceof FragmentActivity)) {
            android.app.Fragment fragmentF = f(view, activityB);
            return fragmentF == null ? i(activityB) : j(fragmentF);
        }
        FragmentActivity fragmentActivity = (FragmentActivity) activityB;
        Fragment fragmentG = g(view, fragmentActivity);
        return fragmentG != null ? m(fragmentG) : n(fragmentActivity);
    }

    @NonNull
    public rf m(@NonNull Fragment fragment) {
        vp.e(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (wp.q()) {
            return k(fragment.getContext().getApplicationContext());
        }
        return u(fragment.getContext(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    @NonNull
    public rf n(@NonNull FragmentActivity fragmentActivity) {
        if (wp.q()) {
            return k(fragmentActivity.getApplicationContext());
        }
        a(fragmentActivity);
        return u(fragmentActivity, fragmentActivity.getSupportFragmentManager(), null, t(fragmentActivity));
    }

    @NonNull
    public final rf o(@NonNull Context context) {
        if (this.a == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = this.e.a(kf.c(context.getApplicationContext()), new jn(), new on(), context.getApplicationContext());
                }
            }
        }
        return this.a;
    }

    @NonNull
    @Deprecated
    public sn p(Activity activity) {
        return q(activity.getFragmentManager(), null, t(activity));
    }

    @NonNull
    public final sn q(@NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z) {
        sn snVar = (sn) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (snVar == null && (snVar = this.b.get(fragmentManager)) == null) {
            snVar = new sn();
            snVar.j(fragment);
            if (z) {
                snVar.c().d();
            }
            this.b.put(fragmentManager, snVar);
            fragmentManager.beginTransaction().add(snVar, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.d.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return snVar;
    }

    @NonNull
    public SupportRequestManagerFragment r(Context context, androidx.fragment.app.FragmentManager fragmentManager) {
        return s(fragmentManager, null, t(context));
    }

    @NonNull
    public final SupportRequestManagerFragment s(@NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.c.get(fragmentManager)) == null) {
            supportRequestManagerFragment = new SupportRequestManagerFragment();
            supportRequestManagerFragment.I(fragment);
            if (z) {
                supportRequestManagerFragment.v().d();
            }
            this.c.put(fragmentManager, supportRequestManagerFragment);
            fragmentManager.beginTransaction().add(supportRequestManagerFragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.d.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return supportRequestManagerFragment;
    }

    @NonNull
    public final rf u(@NonNull Context context, @NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        SupportRequestManagerFragment supportRequestManagerFragmentS = s(fragmentManager, fragment, z);
        rf rfVarA = supportRequestManagerFragmentS.A();
        if (rfVarA != null) {
            return rfVarA;
        }
        rf rfVarA2 = this.e.a(kf.c(context), supportRequestManagerFragmentS.v(), supportRequestManagerFragmentS.B(), context);
        supportRequestManagerFragmentS.J(rfVarA2);
        return rfVarA2;
    }
}
