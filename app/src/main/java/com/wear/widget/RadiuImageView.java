package com.wear.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import dc.vi1;

/* loaded from: classes4.dex */
public class RadiuImageView extends AppCompatImageView {
    public float a;
    public float b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;

    public RadiuImageView(Context context) {
        this(context, null);
        init(context, null);
    }

    public final void init(Context context, AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vi1.RoundCornerImageView);
        this.d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, this.c);
        this.e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, this.c);
        this.f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(4, this.c);
        this.g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, this.c);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, this.c);
        this.h = dimensionPixelOffset;
        int i = this.c;
        if (i == this.e) {
            this.e = this.d;
        }
        if (i == this.f) {
            this.f = this.d;
        }
        if (i == this.g) {
            this.g = this.d;
        }
        if (i == dimensionPixelOffset) {
            this.h = this.d;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int iMax = Math.max(this.e, this.h) + Math.max(this.f, this.g);
        int iMax2 = Math.max(this.e, this.f) + Math.max(this.h, this.g);
        if (this.a >= iMax && this.b > iMax2) {
            Path path = new Path();
            path.moveTo(this.e, 0.0f);
            path.lineTo(this.a - this.f, 0.0f);
            float f = this.a;
            path.quadTo(f, 0.0f, f, this.f);
            path.lineTo(this.a, this.b - this.g);
            float f2 = this.a;
            float f3 = this.b;
            path.quadTo(f2, f3, f2 - this.g, f3);
            path.lineTo(this.h, this.b);
            float f4 = this.b;
            path.quadTo(0.0f, f4, 0.0f, f4 - this.h);
            path.lineTo(0.0f, this.e);
            path.quadTo(0.0f, 0.0f, this.e, 0.0f);
            canvas.clipPath(path);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.a = getWidth();
        this.b = getHeight();
    }

    public RadiuImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        init(context, attributeSet);
    }

    public RadiuImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 0;
        init(context, attributeSet);
    }
}
