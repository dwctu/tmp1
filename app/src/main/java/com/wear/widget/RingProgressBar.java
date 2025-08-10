package com.wear.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import dc.vi1;

/* loaded from: classes4.dex */
public class RingProgressBar extends View {
    public Paint a;
    public Paint b;
    public Paint c;
    public int d;
    public int e;
    public int f;
    public float g;
    public float h;
    public int i;
    public int j;
    public boolean k;
    public int l;

    public RingProgressBar(Context context) {
        this(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vi1.RingProgressBar);
        this.d = typedArrayObtainStyledAttributes.getColor(1, -7829368);
        this.e = typedArrayObtainStyledAttributes.getColor(2, -16711936);
        this.f = typedArrayObtainStyledAttributes.getColor(5, -16711936);
        this.g = typedArrayObtainStyledAttributes.getDimension(7, 16.0f);
        this.h = typedArrayObtainStyledAttributes.getDimension(3, 5.0f);
        this.i = typedArrayObtainStyledAttributes.getInteger(0, 100);
        this.k = typedArrayObtainStyledAttributes.getBoolean(6, true);
        this.l = typedArrayObtainStyledAttributes.getInt(4, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void b() {
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(this.d);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.h);
        this.a.setAntiAlias(true);
        this.a.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setColor(this.e);
        this.b.setStrokeWidth(this.h);
        this.b.setAntiAlias(true);
        this.b.setStrokeCap(Paint.Cap.ROUND);
        int i = this.l;
        if (i == 0) {
            this.b.setStyle(Paint.Style.STROKE);
        } else if (i == 1) {
            this.b.setStyle(Paint.Style.FILL_AND_STROKE);
        }
        Paint paint3 = new Paint();
        this.c = paint3;
        paint3.setColor(this.f);
        this.c.setTextSize(this.g);
        this.c.setTypeface(Typeface.DEFAULT_BOLD);
    }

    public synchronized int getMax() {
        return this.i;
    }

    public synchronized int getProgress() {
        return this.j;
    }

    public int getRingColor() {
        return this.d;
    }

    public int getRingProgressColor() {
        return this.e;
    }

    public float getRingWidth() {
        return this.h;
    }

    public int getTextColor() {
        return this.f;
    }

    public float getTextSize() {
        return this.g;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        float f = width;
        float f2 = height;
        canvas.drawCircle(f, f2, (int) (f - (this.h / 2.0f)), this.a);
        RectF rectF = new RectF(width - r3, height - r3, width + r3, height + r3);
        int i2 = this.l;
        if (i2 == 0) {
            canvas.drawArc(rectF, -90.0f, (this.j * 360) / this.i, false, this.b);
        } else if (i2 == 1 && (i = this.j) != 0) {
            canvas.drawArc(rectF, -90.0f, (i * 360) / this.i, true, this.b);
        }
        String str = this.j + "%";
        float fMeasureText = this.c.measureText(str, 0, str.length());
        StringBuilder sb = new StringBuilder();
        sb.append(this.k);
        sb.append(",");
        sb.append(this.j);
        sb.append(this.l == 0);
        sb.toString();
        if (this.k && this.j >= 0 && this.l == 0) {
            canvas.drawText(str, f - (fMeasureText / 2.0f), f2 + (this.g / 2.0f), this.c);
        }
    }

    public synchronized void setMax(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("max not less than 0");
        }
        this.i = i;
    }

    public synchronized void setProgress(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("progress not less than 0");
        }
        int i2 = this.i;
        if (i > i2) {
            i = i2;
        }
        if (i <= i2) {
            this.j = i;
            postInvalidate();
        }
    }

    public void setRingColor(int i) {
        this.d = i;
    }

    public void setRingProgressColor(int i) {
        this.e = i;
    }

    public void setRingWidth(float f) {
        this.h = f;
    }

    public void setTextColor(int i) {
        this.f = i;
    }

    public void setTextSize(float f) {
        this.g = f;
    }

    public RingProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RingProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
        b();
    }
}
