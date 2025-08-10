package com.youth.banner.transformer;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: classes4.dex */
public class MZScaleInTransformer extends BasePageTransformer {
    private static final float DEFAULT_MIN_SCALE = 0.85f;
    private float mMinScale;

    public MZScaleInTransformer() {
        this.mMinScale = 0.85f;
    }

    private ViewPager2 requireViewPager(@NonNull View view) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
            return (ViewPager2) parent2;
        }
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f) {
        float paddingLeft = requireViewPager(view).getPaddingLeft();
        float measuredWidth = f - (paddingLeft / ((r0.getMeasuredWidth() - paddingLeft) - r0.getPaddingRight()));
        float width = view.getWidth();
        float f2 = this.mMinScale;
        float f3 = ((1.0f - f2) * width) / 2.0f;
        if (measuredWidth <= -1.0f) {
            view.setTranslationX(f3);
            view.setScaleX(this.mMinScale);
            view.setScaleY(this.mMinScale);
            return;
        }
        double d = measuredWidth;
        if (d > 1.0d) {
            view.setScaleX(f2);
            view.setScaleY(this.mMinScale);
            view.setTranslationX(-f3);
            return;
        }
        float fAbs = (1.0f - f2) * Math.abs(1.0f - Math.abs(measuredWidth));
        float f4 = (-f3) * measuredWidth;
        if (d <= -0.5d) {
            view.setTranslationX(f4 + (Math.abs(Math.abs(measuredWidth) - 0.5f) / 0.5f));
        } else if (measuredWidth > 0.0f && d >= 0.5d) {
            view.setTranslationX(f4 - (Math.abs(Math.abs(measuredWidth) - 0.5f) / 0.5f));
        } else {
            view.setTranslationX(f4);
        }
        view.setScaleX(this.mMinScale + fAbs);
        view.setScaleY(fAbs + this.mMinScale);
    }

    public MZScaleInTransformer(float f) {
        this.mMinScale = 0.85f;
        this.mMinScale = f;
    }
}
