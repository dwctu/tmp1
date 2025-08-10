package com.wear.widget.viewpager;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes4.dex */
public class ContentViewPager extends ViewPager {
    public int a;

    public ContentViewPager(Context context) {
        super(context);
        this.a = 0;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i, int i2) throws Resources.NotFoundException {
        int i3 = this.a;
        if (i3 > 0) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
            return;
        }
        int currentItem = getCurrentItem();
        PagerAdapter adapter = getAdapter();
        int measuredHeight = 0;
        if (adapter != null) {
            Object objInstantiateItem = adapter.instantiateItem((ViewGroup) this, currentItem);
            if (objInstantiateItem instanceof View) {
                View view = (View) objInstantiateItem;
                view.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
                measuredHeight = view.getMeasuredHeight();
            }
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }

    public void setControlHeight(int i) {
        this.a = i;
    }

    public ContentViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
    }
}
