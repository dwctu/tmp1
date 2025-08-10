package com.wear.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.wear.widget.MediumBoldTextView;
import com.wear.widget.MyActionBar;
import com.wear.widget.viewpager.ContentViewPager;
import skin.support.constraint.SkinCompatConstraintLayout;

/* loaded from: classes3.dex */
public abstract class ActivityToyFunctionBinding extends ViewDataBinding {

    @NonNull
    public final MyActionBar a;

    @NonNull
    public final CoordinatorLayout b;

    @NonNull
    public final NestedScrollView c;

    @NonNull
    public final CollapsingToolbarLayout d;

    @NonNull
    public final MediumBoldTextView e;

    @NonNull
    public final MediumBoldTextView f;

    @NonNull
    public final ViewPager g;

    @NonNull
    public final ContentViewPager h;

    @NonNull
    public final SkinCompatConstraintLayout i;

    public ActivityToyFunctionBinding(Object obj, View view, int i, MyActionBar myActionBar, CoordinatorLayout coordinatorLayout, ImageView imageView, NestedScrollView nestedScrollView, CollapsingToolbarLayout collapsingToolbarLayout, MediumBoldTextView mediumBoldTextView, MediumBoldTextView mediumBoldTextView2, ViewPager viewPager, ContentViewPager contentViewPager, SkinCompatConstraintLayout skinCompatConstraintLayout) {
        super(obj, view, i);
        this.a = myActionBar;
        this.b = coordinatorLayout;
        this.c = nestedScrollView;
        this.d = collapsingToolbarLayout;
        this.e = mediumBoldTextView;
        this.f = mediumBoldTextView2;
        this.g = viewPager;
        this.h = contentViewPager;
        this.i = skinCompatConstraintLayout;
    }
}
