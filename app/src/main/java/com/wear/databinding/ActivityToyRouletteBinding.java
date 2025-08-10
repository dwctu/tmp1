package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;

/* loaded from: classes3.dex */
public final class ActivityToyRouletteBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    @NonNull
    public final MyActionBar b;

    @NonNull
    public final FragmentContainerView c;

    public ActivityToyRouletteBinding(@NonNull ConstraintLayout constraintLayout, @NonNull MyActionBar myActionBar, @NonNull FragmentContainerView fragmentContainerView) {
        this.a = constraintLayout;
        this.b = myActionBar;
        this.c = fragmentContainerView;
    }

    @NonNull
    public static ActivityToyRouletteBinding a(@NonNull View view) {
        int i = R.id.actionbar;
        MyActionBar myActionBar = (MyActionBar) view.findViewById(R.id.actionbar);
        if (myActionBar != null) {
            i = R.id.nav_host_fragment_roulette;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(R.id.nav_host_fragment_roulette);
            if (fragmentContainerView != null) {
                return new ActivityToyRouletteBinding((ConstraintLayout) view, myActionBar, fragmentContainerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ActivityToyRouletteBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityToyRouletteBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_toy_roulette, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
