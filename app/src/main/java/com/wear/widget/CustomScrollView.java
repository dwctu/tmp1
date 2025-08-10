package com.wear.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.widget.NestedScrollView;

/* loaded from: classes4.dex */
public class CustomScrollView extends NestedScrollView {
    public boolean a;

    public CustomScrollView(Context context) {
        super(context);
        this.a = true;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.a) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setScroll(boolean z) {
        this.a = z;
    }

    public CustomScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
    }

    public CustomScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = true;
    }
}
