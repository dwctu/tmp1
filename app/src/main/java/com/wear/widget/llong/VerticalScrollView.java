package com.wear.widget.llong;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/* loaded from: classes4.dex */
public class VerticalScrollView extends ScrollView {
    public float a;
    public float b;

    public VerticalScrollView(Context context) {
        super(context);
        this.a = 0.0f;
        this.b = 0.0f;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.a = x;
            this.b = y;
        } else if (action == 2 && Math.abs(x - this.a) > Math.abs(y - this.b)) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public VerticalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0.0f;
        this.b = 0.0f;
    }

    public VerticalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0.0f;
        this.b = 0.0f;
    }
}
