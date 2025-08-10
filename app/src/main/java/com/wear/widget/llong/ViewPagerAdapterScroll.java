package com.wear.widget.llong;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes4.dex */
public class ViewPagerAdapterScroll extends ViewPager {
    public int a;
    public int b;

    public ViewPagerAdapterScroll(Context context) {
        super(context);
        this.a = -1;
        this.b = -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int action = motionEvent.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            int iAbs = Math.abs(rawX - this.a) + 0;
            int iAbs2 = Math.abs(rawY - this.b) + 0;
            String str = "dealtX:=" + iAbs;
            String str2 = "dealtY:=" + iAbs2;
            if (iAbs >= iAbs2) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            this.a = rawX;
            this.b = rawY;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public ViewPagerAdapterScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = -1;
        this.b = -1;
    }
}
