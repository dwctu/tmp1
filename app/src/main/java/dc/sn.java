package dc;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: RequestManagerFragment.java */
@Deprecated
/* loaded from: classes.dex */
public class sn extends Fragment {
    public final in a;
    public final un b;
    public final Set<sn> c;

    @Nullable
    public rf d;

    @Nullable
    public sn e;

    @Nullable
    public Fragment f;

    /* compiled from: RequestManagerFragment.java */
    public class a implements un {
        public a() {
        }

        @Override // dc.un
        @NonNull
        public Set<rf> a() {
            Set<sn> setB = sn.this.b();
            HashSet hashSet = new HashSet(setB.size());
            for (sn snVar : setB) {
                if (snVar.e() != null) {
                    hashSet.add(snVar.e());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + sn.this + "}";
        }
    }

    public sn() {
        this(new in());
    }

    public final void a(sn snVar) {
        this.c.add(snVar);
    }

    @NonNull
    @TargetApi(17)
    public Set<sn> b() {
        if (equals(this.e)) {
            return Collections.unmodifiableSet(this.c);
        }
        if (this.e == null || Build.VERSION.SDK_INT < 17) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (sn snVar : this.e.b()) {
            if (g(snVar.getParentFragment())) {
                hashSet.add(snVar);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @NonNull
    public in c() {
        return this.a;
    }

    @Nullable
    @TargetApi(17)
    public final Fragment d() {
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        return parentFragment != null ? parentFragment : this.f;
    }

    @Nullable
    public rf e() {
        return this.d;
    }

    @NonNull
    public un f() {
        return this.b;
    }

    @TargetApi(17)
    public final boolean g(@NonNull Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    public final void h(@NonNull Activity activity) {
        l();
        sn snVarP = kf.c(activity).m().p(activity);
        this.e = snVarP;
        if (equals(snVarP)) {
            return;
        }
        this.e.a(this);
    }

    public final void i(sn snVar) {
        this.c.remove(snVar);
    }

    public void j(@Nullable Fragment fragment) {
        this.f = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        h(fragment.getActivity());
    }

    public void k(@Nullable rf rfVar) {
        this.d = rfVar;
    }

    public final void l() {
        sn snVar = this.e;
        if (snVar != null) {
            snVar.i(this);
            this.e = null;
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            h(activity);
        } catch (IllegalStateException unused) {
            Log.isLoggable("RMFragment", 5);
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.a.c();
        l();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        l();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.a.d();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.a.e();
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + d() + "}";
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public sn(@NonNull in inVar) {
        this.b = new a();
        this.c = new HashSet();
        this.a = inVar;
    }
}
