package com.wear.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes4.dex */
public class NoScrollViewPager extends ViewPager {
    public boolean a;

    public NoScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.a) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        String str = "onTouchEvent: " + this.a;
        if (this.a) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setScroll(boolean z) {
        this.a = z;
    }

    public NoScrollViewPager(Context context) {
        super(context);
        this.a = true;
    }
}
