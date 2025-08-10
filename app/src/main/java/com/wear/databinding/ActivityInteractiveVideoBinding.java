package com.wear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.lovense.wear.R;
import com.wear.widget.MyActionBar;
import skin.support.design.widget.SkinMaterialTabLayout;

/* loaded from: classes3.dex */
public final class ActivityInteractiveVideoBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    @NonNull
    public final MyActionBar b;

    @NonNull
    public final SkinMaterialTabLayout c;

    @NonNull
    public final ViewPager2 d;

    public ActivityInteractiveVideoBinding(@NonNull ConstraintLayout constraintLayout, @NonNull MyActionBar myActionBar, @NonNull SkinMaterialTabLayout skinMaterialTabLayout, @NonNull ViewPager2 viewPager2) {
        this.a = constraintLayout;
        this.b = myActionBar;
        this.c = skinMaterialTabLayout;
        this.d = viewPager2;
    }

    @NonNull
    public static ActivityInteractiveVideoBinding a(@NonNull View view) {
        int i = R.id.actionbar;
        MyActionBar myActionBar = (MyActionBar) view.findViewById(R.id.actionbar);
        if (myActionBar != null) {
            i = R.id.tab_layout;
            SkinMaterialTabLayout skinMaterialTabLayout = (SkinMaterialTabLayout) view.findViewById(R.id.tab_layout);
            if (skinMaterialTabLayout != null) {
                i = R.id.viewpager;
                ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.viewpager);
                if (viewPager2 != null) {
                    return new ActivityInteractiveVideoBinding((ConstraintLayout) view, myActionBar, skinMaterialTabLayout, viewPager2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ActivityInteractiveVideoBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityInteractiveVideoBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_interactive_video, viewGroup, false);
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
