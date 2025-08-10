package com.wear.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatSeekBar;

/* loaded from: classes4.dex */
public class UnDragSeekBar extends AppCompatSeekBar {
    public boolean a;

    public UnDragSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.a) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setTouch(boolean z) {
        this.a = z;
    }

    public UnDragSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = false;
    }
}
