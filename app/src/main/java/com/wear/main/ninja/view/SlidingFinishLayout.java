package com.wear.main.ninja.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Scroller;

/* loaded from: classes3.dex */
public class SlidingFinishLayout extends RelativeLayout {
    public int a;
    public Scroller b;
    public ViewGroup c;
    public int d;
    public int e;
    public int f;
    public int g;
    public boolean h;
    public a i;
    public boolean j;

    public interface a {
        void g0();
    }

    public SlidingFinishLayout(Context context) {
        super(context);
        this.a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.b = new Scroller(getContext());
    }

    public final void a() {
        int scrollX = this.c.getScrollX();
        this.b.startScroll(this.c.getScrollX(), 0, -scrollX, 0, Math.abs(scrollX));
        postInvalidate();
    }

    public final void b() {
        int scrollX = this.g + this.c.getScrollX();
        this.b.startScroll(this.c.getScrollX(), 0, (-scrollX) + 1, 0, Math.abs(scrollX));
        postInvalidate();
    }

    @Override // android.view.View
    public void computeScroll() {
        a aVar;
        if (this.b.computeScrollOffset()) {
            this.c.scrollTo(this.b.getCurrX(), this.b.getCurrY());
            postInvalidate();
            if (this.b.isFinished() && (aVar = this.i) != null && this.j) {
                aVar.g0();
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.c = (ViewGroup) getParent();
            this.g = getWidth();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            int rawX = (int) motionEvent.getRawX();
            this.f = rawX;
            this.d = rawX;
            this.e = (int) motionEvent.getRawY();
        } else if (actionMasked == 1) {
            this.h = false;
            if (this.c.getScrollX() <= (-this.g) / 4) {
                this.j = true;
                b();
            } else {
                a();
                this.j = false;
            }
        } else if (actionMasked == 2) {
            int rawX2 = (int) motionEvent.getRawX();
            int i = this.f - rawX2;
            this.f = rawX2;
            if (Math.abs(rawX2 - this.d) > this.a && Math.abs(((int) motionEvent.getRawY()) - this.e) < this.a) {
                this.h = true;
            }
            if (rawX2 - this.d >= 0 && this.h) {
                this.c.scrollBy(i, 0);
            }
        }
        return true;
    }

    public void setOnSlidingFinishListener(a aVar) {
        this.i = aVar;
    }

    public SlidingFinishLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.b = new Scroller(getContext());
    }
}
