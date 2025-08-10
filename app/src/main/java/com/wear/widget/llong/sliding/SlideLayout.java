package com.wear.widget.llong.sliding;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
import dc.vi1;

/* loaded from: classes4.dex */
public class SlideLayout extends ViewGroup {
    public View a;
    public View b;
    public Scroller c;
    public int d;
    public boolean e;
    public int f;

    public SlideLayout(Context context) {
        this(context, null);
    }

    private int getSlideCriticalValue() {
        int i = this.f;
        if (i == 1 || i == 0) {
            if (this.d == 0) {
                this.d = this.b.getMeasuredWidth() / 2;
            }
        } else if (this.d == 0) {
            this.d = this.b.getMeasuredHeight() / 2;
        }
        return this.d;
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vi1.SlideLayout);
        this.f = typedArrayObtainStyledAttributes.getInt(1, 0);
        this.d = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.c = new Scroller(context);
    }

    public void b() {
        e(0, 0);
    }

    public void c() {
        int i = this.f;
        if (i == 0) {
            e(this.b.getMeasuredWidth(), 0);
            return;
        }
        if (i == 1) {
            e(-this.b.getMeasuredWidth(), 0);
        } else if (i == 2) {
            e(0, -this.b.getMeasuredHeight());
        } else {
            if (i != 3) {
                return;
            }
            e(0, this.b.getMeasuredHeight());
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.c.computeScrollOffset()) {
            scrollTo(this.c.getCurrX(), this.c.getCurrY());
            postInvalidate();
        }
    }

    public void d() {
        e(this.b.getMeasuredWidth(), 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void e(int i, int i2) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        this.c.startScroll(scrollX, scrollY, i - scrollX, i2 - scrollY, (int) (Math.abs(Math.sqrt((r3 * r3) + (r4 * r4))) * 3.0d));
        postInvalidate();
    }

    public int getSlideState() {
        if (this.e) {
            return 1;
        }
        int i = this.f;
        return ((i == 1 || i == 0) ? getScrollX() : getScrollY()) == 0 ? 0 : 2;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() != 2) {
            throw new IllegalArgumentException("SlideLayout only need contains two child (content and slide).");
        }
        this.a = getChildAt(0);
        this.b = getChildAt(1);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.e || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.a.layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        int i5 = this.f;
        if (i5 == 0) {
            this.b.layout(getMeasuredWidth(), 0, this.b.getMeasuredWidth() + getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        if (i5 == 1) {
            View view = this.b;
            view.layout(-view.getMeasuredWidth(), 0, 0, getMeasuredHeight());
        } else if (i5 == 2) {
            View view2 = this.b;
            view2.layout(0, -view2.getMeasuredHeight(), getMeasuredWidth(), 0);
        } else {
            if (i5 != 3) {
                return;
            }
            this.b.layout(0, getMeasuredHeight(), getMeasuredWidth(), this.b.getMeasuredHeight() + getMeasuredHeight());
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        measureChildren(i, i2);
        setMeasuredDimension(this.a.getMeasuredWidth(), this.a.getMeasuredHeight());
    }

    public SlideLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlideLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 0;
        this.e = false;
        a(context, attributeSet);
    }
}
