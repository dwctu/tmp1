package com.wear.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import dc.vi1;
import skin.support.widget.SkinCompatTextView;

/* loaded from: classes4.dex */
public class MediumBoldTextView extends SkinCompatTextView {
    public static int f = 0;
    public static int g = 1;
    public static int h = 2;
    public float e;

    public MediumBoldTextView(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.e >= 0.0f) {
            TextPaint paint = getPaint();
            paint.setStrokeWidth(this.e);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
        }
        super.onDraw(canvas);
    }

    public void setStrokeWidth(float f2) {
        this.e = f2;
        invalidate();
    }

    public void setStrokeWidthType(int i, boolean z) {
        if (i == f) {
            this.e = 0.0f;
        } else if (i == g) {
            this.e = 1.2f;
        } else if (i == h) {
            this.e = 1.6f;
        }
        if (z) {
            postInvalidate();
        }
    }

    public MediumBoldTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediumBoldTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = -1.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vi1.MediumBoldTextView, i, 0);
        setStrokeWidthType(typedArrayObtainStyledAttributes.getInt(0, 0), false);
        typedArrayObtainStyledAttributes.recycle();
    }
}
