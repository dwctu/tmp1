package com.wear.widget.control;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.SeekBar;
import dc.ce3;
import dc.de3;

/* loaded from: classes4.dex */
public class TraditionalSeekBarViewBg extends SeekBar {
    public int a;
    public int b;
    public int c;
    public Paint d;
    public Paint e;

    public TraditionalSeekBarViewBg(Context context) {
        super(context);
        this.a = Color.parseColor("#ffffff");
        this.b = Color.parseColor("#25252D");
        this.c = 0;
        this.d = new Paint(1);
        this.e = new Paint(1);
        a(context);
    }

    public final void a(Context context) {
        this.c = ce3.a(context, 3.0f);
        this.d.setColor(this.a);
        this.d.setAntiAlias(true);
        this.d.setStyle(Paint.Style.FILL);
        this.d.setStrokeWidth(this.c);
        this.e.setColor(this.b);
        this.e.setAntiAlias(true);
        this.e.setStyle(Paint.Style.FILL);
        this.e.setStrokeWidth(this.c);
        de3.a(context, 20.0f);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void onDraw(Canvas canvas) {
        canvas.rotate(-90.0f);
        canvas.translate(-getHeight(), 0.0f);
        super.onDraw(canvas);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i2, i);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i2, i, i4, i3);
    }

    public TraditionalSeekBarViewBg(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = Color.parseColor("#ffffff");
        this.b = Color.parseColor("#25252D");
        this.c = 0;
        this.d = new Paint(1);
        this.e = new Paint(1);
        a(context);
    }

    public TraditionalSeekBarViewBg(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = Color.parseColor("#ffffff");
        this.b = Color.parseColor("#25252D");
        this.c = 0;
        this.d = new Paint(1);
        this.e = new Paint(1);
        a(context);
    }
}
