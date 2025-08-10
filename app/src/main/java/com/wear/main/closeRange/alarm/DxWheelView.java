package com.wear.main.closeRange.alarm;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bigkoo.pickerview.lib.WheelView;
import dc.y02;

/* loaded from: classes3.dex */
public class DxWheelView extends WheelView {
    public y02 W;
    public boolean a0;

    public DxWheelView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.bigkoo.pickerview.lib.WheelView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        y02 y02Var;
        if (!this.a0) {
            return true;
        }
        if (motionEvent.getAction() == 0 && (y02Var = this.W) != null) {
            y02Var.z();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCanEnable(boolean z) {
        this.a0 = z;
    }

    public void setOptionsPickerView(y02 y02Var) {
        this.W = y02Var;
    }

    public DxWheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.W = null;
        this.a0 = true;
    }
}
