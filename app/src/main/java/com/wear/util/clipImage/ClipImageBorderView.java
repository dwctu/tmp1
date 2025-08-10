package com.wear.util.clipImage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/* loaded from: classes4.dex */
public class ClipImageBorderView extends View {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public Paint f;

    public ClipImageBorderView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.c = getWidth() - (this.a * 2);
        this.b = (getHeight() - this.c) / 2;
        this.f.setColor(Color.parseColor("#aa000000"));
        this.f.setStyle(Paint.Style.FILL);
        canvas.drawRect(0.0f, 0.0f, this.a, getHeight(), this.f);
        canvas.drawRect(getWidth() - this.a, 0.0f, getWidth(), getHeight(), this.f);
        canvas.drawRect(this.a, 0.0f, getWidth() - this.a, this.b, this.f);
        canvas.drawRect(this.a, getHeight() - this.b, getWidth() - this.a, getHeight(), this.f);
        this.f.setColor(this.d);
        this.f.setStrokeWidth(this.e);
        this.f.setStyle(Paint.Style.STROKE);
        canvas.drawRect(this.a, this.b, getWidth() - this.a, getHeight() - this.b, this.f);
    }

    public void setHorizontalPadding(int i) {
        this.a = i;
    }

    public ClipImageBorderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClipImageBorderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = Color.parseColor("#FFFFFF");
        this.e = 1;
        this.e = (int) TypedValue.applyDimension(1, 1, getResources().getDisplayMetrics());
        Paint paint = new Paint();
        this.f = paint;
        paint.setAntiAlias(true);
    }
}
