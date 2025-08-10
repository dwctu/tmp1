package com.wear.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import dc.vi1;

/* loaded from: classes4.dex */
public class CountDownView extends View {
    public int a;
    public int b;
    public int c;
    public float d;
    public float e;
    public float f;
    public Paint g;
    public Paint h;
    public Paint i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public String q;
    public int r;
    public CountDownTimer s;

    public interface a {
    }

    public CountDownView(Context context) {
        this(context, null);
    }

    public final void a() {
        Paint paint = new Paint();
        this.i = paint;
        paint.setColor(this.c);
        this.i.setStyle(Paint.Style.FILL);
        this.i.setDither(true);
        this.i.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.g = paint2;
        paint2.setColor(this.a);
        this.g.setStyle(Paint.Style.FILL);
        this.g.setDither(true);
        this.g.setAntiAlias(true);
        this.g.setTextSize(this.f);
        this.g.setTextAlign(Paint.Align.CENTER);
        this.g.setFakeBoldText(true);
        Paint paint3 = new Paint();
        this.h = paint3;
        paint3.setColor(this.b);
        this.h.setStyle(Paint.Style.STROKE);
        this.h.setStrokeCap(Paint.Cap.ROUND);
        this.h.setDither(true);
        this.h.setAntiAlias(true);
        this.h.setStrokeWidth(this.p);
    }

    public void b() {
        CountDownTimer countDownTimer = this.s;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.s = null;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.n;
        canvas.drawCircle(i, this.o, i, this.i);
        float f = (this.k - this.j) / 2;
        int i2 = this.m;
        float f2 = ((i2 - r2) / 2) - f;
        float f3 = this.l + f2;
        float f4 = i2 - f2;
        Rect rect = new Rect();
        Paint paint = this.g;
        String str = this.q;
        paint.getTextBounds(str, 0, str.length(), rect);
        rect.width();
        canvas.drawText(this.q, this.n, this.o + (rect.height() / 2), this.g);
        int i3 = this.j;
        int i4 = this.p;
        RectF rectF = new RectF(i3 + (i4 / 2), f3 + (i4 / 2), this.k - (i4 / 2), f4 - (i4 / 2));
        canvas.rotate(-90.0f, this.n, this.o);
        canvas.drawArc(rectF, 0.0f, 360 - this.r, false, this.h);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.j = i;
        this.l = i2;
        this.k = i3;
        this.m = i4;
        this.n = (i3 - i) / 2;
        this.o = (i4 - i2) / 2;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.d = View.MeasureSpec.getSize(i);
        this.e = View.MeasureSpec.getSize(i2);
        String str = "onMeasure: 倒计时View的宽高：width=" + this.d + "  height=" + this.e;
    }

    public void setOnTimerFinishListener(a aVar) {
    }

    @SuppressLint({"ResourceAsColor"})
    public CountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.p = 40;
        this.q = "10";
        this.r = 30;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vi1.CountDownView);
        this.a = typedArrayObtainStyledAttributes.getColor(3, -1);
        this.c = typedArrayObtainStyledAttributes.getColor(1, ViewCompat.MEASURED_STATE_MASK);
        this.b = typedArrayObtainStyledAttributes.getColor(2, -1);
        this.f = typedArrayObtainStyledAttributes.getDimension(4, 200.0f);
        this.p = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 40);
        typedArrayObtainStyledAttributes.recycle();
        a();
    }

    public CountDownView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.p = 40;
        this.q = "10";
        this.r = 30;
    }
}
