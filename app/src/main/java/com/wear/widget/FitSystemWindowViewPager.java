package com.wear.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes4.dex */
public class FitSystemWindowViewPager extends ViewPager {

    public class a implements OnApplyWindowInsetsListener {
        public final Rect a = new Rect();

        public a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            WindowInsetsCompat windowInsetsCompatOnApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
            if (windowInsetsCompatOnApplyWindowInsets.isConsumed()) {
                return windowInsetsCompatOnApplyWindowInsets;
            }
            Rect rect = this.a;
            rect.left = windowInsetsCompatOnApplyWindowInsets.getSystemWindowInsetLeft();
            rect.top = windowInsetsCompatOnApplyWindowInsets.getSystemWindowInsetTop();
            rect.right = windowInsetsCompatOnApplyWindowInsets.getSystemWindowInsetRight();
            rect.bottom = windowInsetsCompatOnApplyWindowInsets.getSystemWindowInsetBottom();
            int childCount = FitSystemWindowViewPager.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                WindowInsetsCompat windowInsetsCompatDispatchApplyWindowInsets = ViewCompat.dispatchApplyWindowInsets(FitSystemWindowViewPager.this.getChildAt(i), windowInsetsCompatOnApplyWindowInsets);
                rect.left = Math.min(windowInsetsCompatDispatchApplyWindowInsets.getSystemWindowInsetLeft(), rect.left);
                rect.top = Math.min(windowInsetsCompatDispatchApplyWindowInsets.getSystemWindowInsetTop(), rect.top);
                rect.right = Math.min(windowInsetsCompatDispatchApplyWindowInsets.getSystemWindowInsetRight(), rect.right);
                rect.bottom = Math.min(windowInsetsCompatDispatchApplyWindowInsets.getSystemWindowInsetBottom(), rect.bottom);
            }
            return windowInsetsCompatOnApplyWindowInsets.replaceSystemWindowInsets(rect.left, rect.top, rect.right, rect.bottom).consumeSystemWindowInsets();
        }
    }

    public FitSystemWindowViewPager(Context context) {
        this(context, null);
    }

    public final void a() {
        ViewCompat.setOnApplyWindowInsetsListener(this, new a());
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (Build.VERSION.SDK_INT >= 20) {
            requestApplyInsets();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i) throws Resources.NotFoundException {
        super.setCurrentItem(i, false);
    }

    public FitSystemWindowViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
