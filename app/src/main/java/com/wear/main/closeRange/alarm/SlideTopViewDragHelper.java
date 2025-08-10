package com.wear.main.closeRange.alarm;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.customview.widget.ViewDragHelper;
import dc.ce3;

/* loaded from: classes3.dex */
public class SlideTopViewDragHelper extends LinearLayout {
    public static int g = 400;
    public ViewDragHelper a;
    public View b;
    public Point c;
    public Point d;
    public b e;
    public int f;

    public class a extends ViewDragHelper.Callback {
        public a() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i, int i2) {
            SlideTopViewDragHelper.this.f = i;
            return Math.min(0, i);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f, float f2) {
            String str = f2 + "";
            if (SlideTopViewDragHelper.this.f < (-SlideTopViewDragHelper.g)) {
                SlideTopViewDragHelper.this.a.settleCapturedViewAt(SlideTopViewDragHelper.this.d.x, SlideTopViewDragHelper.this.d.y);
                SlideTopViewDragHelper.this.invalidate();
                if (SlideTopViewDragHelper.this.e != null) {
                    SlideTopViewDragHelper.this.e.onReleased();
                }
            } else {
                SlideTopViewDragHelper.this.a.settleCapturedViewAt(SlideTopViewDragHelper.this.c.x, SlideTopViewDragHelper.this.c.y);
                SlideTopViewDragHelper.this.invalidate();
            }
            super.onViewReleased(view, f, f2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            return true;
        }
    }

    public interface b {
        void onReleased();
    }

    public SlideTopViewDragHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new Point();
        this.d = new Point();
        g = ce3.a(context, 150.0f);
        this.a = ViewDragHelper.create(this, 1.0f, new a());
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.a.continueSettling(true)) {
            invalidate();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.b = getChildAt(0);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.a.shouldInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.c.x = this.b.getLeft();
        this.c.y = this.b.getTop();
        this.d.x = this.b.getLeft();
        this.d.y = -this.b.getBottom();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.a.processTouchEvent(motionEvent);
        return true;
    }

    public void setOnReleasedListener(b bVar) {
        this.e = bVar;
    }
}
