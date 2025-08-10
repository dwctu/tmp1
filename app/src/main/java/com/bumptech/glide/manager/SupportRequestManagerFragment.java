package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import dc.in;
import dc.kf;
import dc.rf;
import dc.un;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class SupportRequestManagerFragment extends Fragment {
    public final in a;
    public final un b;
    public final Set<SupportRequestManagerFragment> c;

    @Nullable
    public SupportRequestManagerFragment d;

    @Nullable
    public rf e;

    @Nullable
    public Fragment f;

    public class a implements un {
        public a() {
        }

        @Override // dc.un
        @NonNull
        public Set<rf> a() {
            Set<SupportRequestManagerFragment> setU = SupportRequestManagerFragment.this.u();
            HashSet hashSet = new HashSet(setU.size());
            for (SupportRequestManagerFragment supportRequestManagerFragment : setU) {
                if (supportRequestManagerFragment.A() != null) {
                    hashSet.add(supportRequestManagerFragment.A());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
        }
    }

    public SupportRequestManagerFragment() {
        this(new in());
    }

    @Nullable
    public static FragmentManager C(@NonNull Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    @Nullable
    public rf A() {
        return this.e;
    }

    @NonNull
    public un B() {
        return this.b;
    }

    public final boolean D(@NonNull Fragment fragment) {
        Fragment fragmentY = y();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(fragmentY)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    public final void E(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        K();
        SupportRequestManagerFragment supportRequestManagerFragmentR = kf.c(context).m().r(context, fragmentManager);
        this.d = supportRequestManagerFragmentR;
        if (equals(supportRequestManagerFragmentR)) {
            return;
        }
        this.d.t(this);
    }

    public final void F(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.c.remove(supportRequestManagerFragment);
    }

    public void I(@Nullable Fragment fragment) {
        FragmentManager fragmentManagerC;
        this.f = fragment;
        if (fragment == null || fragment.getContext() == null || (fragmentManagerC = C(fragment)) == null) {
            return;
        }
        E(fragment.getContext(), fragmentManagerC);
    }

    public void J(@Nullable rf rfVar) {
        this.e = rfVar;
    }

    public final void K() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.d;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.F(this);
            this.d = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentManager fragmentManagerC = C(this);
        if (fragmentManagerC == null) {
            Log.isLoggable("SupportRMFragment", 5);
            return;
        }
        try {
            E(getContext(), fragmentManagerC);
        } catch (IllegalStateException unused) {
            Log.isLoggable("SupportRMFragment", 5);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.a.c();
        K();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f = null;
        K();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.a.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.a.e();
    }

    public final void t(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.c.add(supportRequestManagerFragment);
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + y() + "}";
    }

    @NonNull
    public Set<SupportRequestManagerFragment> u() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.d;
        if (supportRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (equals(supportRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.c);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment supportRequestManagerFragment2 : this.d.u()) {
            if (D(supportRequestManagerFragment2.y())) {
                hashSet.add(supportRequestManagerFragment2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @NonNull
    public in v() {
        return this.a;
    }

    @Nullable
    public final Fragment y() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f;
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public SupportRequestManagerFragment(@NonNull in inVar) {
        this.b = new a();
        this.c = new HashSet();
        this.a = inVar;
    }
}
