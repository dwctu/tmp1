package com.wear.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/* loaded from: classes4.dex */
public class ScrollListView extends ListView {
    public float a;

    public ScrollListView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            super.onInterceptTouchEvent(motionEvent);
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            if (getFirstVisiblePosition() == 0 && motionEvent.getY() - this.a > 0.0f) {
                getParent().requestDisallowInterceptTouchEvent(false);
            } else if (getLastVisiblePosition() != getCount() - 1 || motionEvent.getY() - this.a >= 0.0f) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        this.a = motionEvent.getY();
        return super.dispatchTouchEvent(motionEvent);
    }

    public ScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
