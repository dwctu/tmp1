package com.wear.widget;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import dc.ce3;

/* loaded from: classes4.dex */
public class MaxWidthTextView extends AppCompatTextView {
    public MaxWidthTextView(Context context) {
        super(context);
    }

    public final void b(int i, TextPaint textPaint, int i2) {
        setTextSize(i2);
        if (textPaint.measureText(getText().toString()) > i) {
            b(i, textPaint, i2 - 1);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int size = (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        String str = "onMeasure: " + size;
        if (!ce3.c(getContext())) {
            b(size, getPaint(), 16);
        }
        super.onMeasure(i, i2);
    }

    public MaxWidthTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MaxWidthTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
