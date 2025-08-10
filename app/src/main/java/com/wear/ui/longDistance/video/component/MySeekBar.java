package com.wear.ui.longDistance.video.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatSeekBar;

/* loaded from: classes4.dex */
public class MySeekBar extends AppCompatSeekBar {
    public boolean a;

    public MySeekBar(Context context) {
        super(context);
        this.a = true;
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.a) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setCanDrag(boolean z) {
        this.a = z;
    }

    public MySeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
    }

    public MySeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = true;
    }
}
