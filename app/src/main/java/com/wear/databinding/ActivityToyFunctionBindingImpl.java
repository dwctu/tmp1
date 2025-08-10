package com.wear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.lovense.wear.R;
import com.wear.widget.MediumBoldTextView;
import com.wear.widget.MyActionBar;
import com.wear.widget.viewpager.ContentViewPager;
import skin.support.constraint.SkinCompatConstraintLayout;

/* loaded from: classes3.dex */
public class ActivityToyFunctionBindingImpl extends ActivityToyFunctionBinding {

    @Nullable
    public static final ViewDataBinding.IncludedLayouts l = null;

    @Nullable
    public static final SparseIntArray m;

    @NonNull
    public final LinearLayout j;
    public long k;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        m = sparseIntArray;
        sparseIntArray.put(R.id.app_bar, 1);
        sparseIntArray.put(R.id.warn_toys_tips, 2);
        sparseIntArray.put(R.id.icon_warn, 3);
        sparseIntArray.put(R.id.coordinatorLayout, 4);
        sparseIntArray.put(R.id.tv_mode_position, 5);
        sparseIntArray.put(R.id.tv_mode_speed, 6);
        sparseIntArray.put(R.id.toolbarLayout, 7);
        sparseIntArray.put(R.id.viewPager, 8);
        sparseIntArray.put(R.id.scrollView, 9);
        sparseIntArray.put(R.id.viewPagerBottom, 10);
    }

    public ActivityToyFunctionBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, l, m));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.k = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.k != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.k = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    public ActivityToyFunctionBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (MyActionBar) objArr[1], (CoordinatorLayout) objArr[4], (ImageView) objArr[3], (NestedScrollView) objArr[9], (CollapsingToolbarLayout) objArr[7], (MediumBoldTextView) objArr[5], (MediumBoldTextView) objArr[6], (ViewPager) objArr[8], (ContentViewPager) objArr[10], (SkinCompatConstraintLayout) objArr[2]);
        this.k = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.j = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
