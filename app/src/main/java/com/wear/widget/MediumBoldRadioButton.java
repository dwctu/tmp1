package com.wear.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import dc.vi1;
import skin.support.widget.SkinCompatRadioButton;

/* loaded from: classes4.dex */
public class MediumBoldRadioButton extends SkinCompatRadioButton {
    public static int e = 0;
    public static int f = 1;
    public static int g = 2;
    public float d;

    public MediumBoldRadioButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (isChecked()) {
            setStrokeWidthType(g);
        } else {
            setStrokeWidthType(e);
        }
        if (this.d != 0.0f) {
            TextPaint paint = getPaint();
            paint.setStrokeWidth(this.d);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
        } else {
            TextPaint paint2 = getPaint();
            paint2.setStrokeWidth(this.d);
            paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        if (z) {
            setStrokeWidthType(g);
        } else {
            setStrokeWidthType(e);
        }
        invalidate();
    }

    public void setStrokeWidthType(int i) {
        if (i == e) {
            this.d = 0.0f;
        } else if (i == f) {
            this.d = 1.2f;
        } else if (i == g) {
            this.d = 1.6f;
        }
    }

    public MediumBoldRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediumBoldRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 0.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vi1.MediumBoldTextView, i, 0);
        int i2 = typedArrayObtainStyledAttributes.getInt(0, 0);
        if (i2 == e) {
            this.d = 0.0f;
        } else if (i2 == f) {
            this.d = 1.2f;
        } else if (i2 == g) {
            this.d = 1.6f;
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
