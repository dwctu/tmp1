package com.wear.widget.seekbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import dc.at3;
import dc.bt3;
import dc.vi1;

/* loaded from: classes4.dex */
public class VerticalRangeSeekBar extends RangeSeekBar {
    public int d0;
    public int e0;
    public int f0;

    public VerticalRangeSeekBar(Context context) {
        this(context, null);
    }

    private void e(AttributeSet attributeSet) {
        try {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, vi1.VerticalRangeSeekBar);
            this.d0 = typedArrayObtainStyledAttributes.getInt(1, 1);
            this.e0 = typedArrayObtainStyledAttributes.getInt(2, 1);
            typedArrayObtainStyledAttributes.recycle();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.wear.widget.seekbar.RangeSeekBar
    public float c(MotionEvent motionEvent) {
        return this.d0 == 1 ? getHeight() - motionEvent.getY() : motionEvent.getY();
    }

    @Override // com.wear.widget.seekbar.RangeSeekBar
    public float d(MotionEvent motionEvent) {
        return this.d0 == 1 ? motionEvent.getX() : (-motionEvent.getX()) + getWidth();
    }

    public int getOrientation() {
        return this.d0;
    }

    public int getTickMarkDirection() {
        return this.e0;
    }

    @Override // com.wear.widget.seekbar.RangeSeekBar
    public int getTickMarkRawHeight() {
        int tickMarkTextMargin;
        int i;
        if (this.f0 > 0) {
            tickMarkTextMargin = getTickMarkTextMargin();
            i = this.f0;
        } else {
            if (getTickMarkTextArray() == null || getTickMarkTextArray().length <= 0) {
                return 0;
            }
            int length = getTickMarkTextArray().length;
            this.f0 = at3.g(String.valueOf(getTickMarkTextArray()[0]), getTickMarkTextSize()).width();
            for (int i2 = 1; i2 < length; i2++) {
                int iWidth = at3.g(String.valueOf(getTickMarkTextArray()[i2]), getTickMarkTextSize()).width();
                if (this.f0 < iWidth) {
                    this.f0 = iWidth;
                }
            }
            tickMarkTextMargin = getTickMarkTextMargin();
            i = this.f0;
        }
        return tickMarkTextMargin + i;
    }

    public void h(AttributeSet attributeSet) {
        this.S = new bt3(this, attributeSet, true);
        bt3 bt3Var = new bt3(this, attributeSet, false);
        this.T = bt3Var;
        bt3Var.S(getSeekBarMode() != 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x011d A[SYNTHETIC] */
    @Override // com.wear.widget.seekbar.RangeSeekBar
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m(android.graphics.Canvas r13, android.graphics.Paint r14) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.seekbar.VerticalRangeSeekBar.m(android.graphics.Canvas, android.graphics.Paint):void");
    }

    @Override // com.wear.widget.seekbar.RangeSeekBar, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.d0 == 1) {
            canvas.rotate(-90.0f);
            canvas.translate(-getHeight(), 0.0f);
        } else {
            canvas.rotate(90.0f);
            canvas.translate(0.0f, -getWidth());
        }
        super.onDraw(canvas);
    }

    @Override // com.wear.widget.seekbar.RangeSeekBar, android.view.View
    public void onMeasure(int i, int i2) {
        int iMakeMeasureSpec;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (mode == 1073741824) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        } else if (mode == Integer.MIN_VALUE && (getParent() instanceof ViewGroup) && size == -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(((ViewGroup) getParent()).getMeasuredHeight(), Integer.MIN_VALUE);
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getGravity() == 2 ? (getProgressTop() * 2) + getProgressHeight() : (int) getRawHeight(), 1073741824);
        }
        super.onMeasure(iMakeMeasureSpec, i2);
    }

    @Override // com.wear.widget.seekbar.RangeSeekBar, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i2, i, i4, i3);
    }

    public void setOrientation(int i) {
        this.d0 = i;
    }

    public void setTickMarkDirection(int i) {
        this.e0 = i;
    }

    @Override // com.wear.widget.seekbar.RangeSeekBar
    public void setTickMarkTextArray(CharSequence[] charSequenceArr) {
        super.setTickMarkTextArray(charSequenceArr);
        this.f0 = 0;
    }

    @Override // com.wear.widget.seekbar.RangeSeekBar
    public void setTickMarkTextSize(int i) {
        super.setTickMarkTextSize(i);
        this.f0 = 0;
    }

    public VerticalRangeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d0 = 1;
        this.e0 = 1;
        e(attributeSet);
        h(attributeSet);
    }

    @Override // com.wear.widget.seekbar.RangeSeekBar
    public bt3 getLeftSeekBar() {
        return (bt3) this.S;
    }

    @Override // com.wear.widget.seekbar.RangeSeekBar
    public bt3 getRightSeekBar() {
        return (bt3) this.T;
    }
}
