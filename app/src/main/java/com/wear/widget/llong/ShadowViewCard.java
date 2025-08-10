package com.wear.widget.llong;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.lovense.wear.R;
import dc.vi1;

/* loaded from: classes4.dex */
public class ShadowViewCard extends LinearLayout {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;

    public ShadowViewCard(Context context) {
        this(context, null);
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void b(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vi1.ShadowViewCard);
        this.a = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.b = typedArrayObtainStyledAttributes.getColor(2, getResources().getColor(R.color.shadow_default_color));
        this.c = typedArrayObtainStyledAttributes.getColor(1, getResources().getColor(R.color.shadow_card_default_color));
        this.f = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, a(getContext(), 5.0f));
        this.h = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, a(getContext(), 5.0f));
        this.g = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, a(getContext(), 5.0f));
        this.i = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, a(getContext(), 5.0f));
        typedArrayObtainStyledAttributes.getDimensionPixelSize(5, a(getContext(), 0.0f));
        this.e = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, a(getContext(), 1.0f));
        this.d = typedArrayObtainStyledAttributes.getInteger(6, 5);
        typedArrayObtainStyledAttributes.recycle();
        setPadding(this.g, this.f, this.h, this.i);
        setLayerType(1, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(this.c);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        float f = this.g;
        float f2 = this.f;
        float width = getWidth() - this.h;
        float height = getHeight() - this.i;
        float f3 = this.d;
        int i = this.e;
        paint.setShadowLayer(f3, i, i, this.b);
        RectF rectF = new RectF(f, f2, width, height);
        int i2 = this.a;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        canvas.save();
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setShadowCardColor(int i) {
        this.c = i;
    }

    public void setShadowColor(int i) {
        this.b = i;
        invalidate();
    }

    public ShadowViewCard(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowViewCard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet);
    }
}
