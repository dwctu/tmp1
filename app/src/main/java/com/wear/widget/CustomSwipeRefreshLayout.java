package com.wear.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import dc.xe3;

/* loaded from: classes4.dex */
public class CustomSwipeRefreshLayout extends SwipeRefreshLayout {
    public a a;
    public int b;
    public float c;
    public boolean d;
    public float e;

    public interface a {
        boolean E2();

        boolean I2(MotionEvent motionEvent);
    }

    public CustomSwipeRefreshLayout(@NonNull Context context) {
        super(context);
        this.b = HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION;
        this.d = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.a == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.c = motionEvent.getY();
            this.d = true;
            xe3.a("CustomSwipeRefreshLayout", "按下");
        } else if (action == 1) {
            xe3.a("CustomSwipeRefreshLayout", "抬起");
        } else if (action == 2) {
            xe3.a("CustomSwipeRefreshLayout", "滑动");
            float y = motionEvent.getY();
            this.e = y;
            if (this.d) {
                if (this.c - y > this.b) {
                    if (!this.a.E2()) {
                        this.d = false;
                    }
                } else if (this.a.I2(motionEvent)) {
                    this.d = false;
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            xe3.a("CustomSwipeRefreshLayout", "onTouchEvent按下");
        } else if (action == 1) {
            xe3.a("CustomSwipeRefreshLayout", "onTouchEvent抬起");
        } else if (action == 2) {
            xe3.a("CustomSwipeRefreshLayout", "onTouchEvent滑动");
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListener(a aVar) {
        this.a = aVar;
    }

    public CustomSwipeRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION;
        this.d = false;
    }
}
