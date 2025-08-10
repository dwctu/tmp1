package com.wear.widget.control;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import dc.gg3;

/* loaded from: classes4.dex */
public class FingerLineView extends View {
    public int a;
    public float b;
    public int c;
    public int d;
    public Paint e;

    public FingerLineView(Context context) {
        super(context);
        this.b = -1.0f;
        this.d = Color.parseColor("#5344c6");
        this.e = new Paint();
        a(context);
    }

    public final void a(Context context) {
        this.c = gg3.e(context);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.a = getMeasuredHeight();
        float f = this.b;
        if (f == -1.0f) {
            this.e.setColor(this.d);
            int i = this.a;
            canvas.drawLine(0.0f, i + 10.0f, this.c, i + 10.0f, this.e);
            return;
        }
        if (f < 0.0f) {
            this.b = 0.0f;
        }
        if (this.b > r0 - 1) {
            this.b = r0 + 10;
        }
        this.e.setColor(this.d);
        float f2 = this.b;
        canvas.drawLine(0.0f, f2, this.c, f2, this.e);
    }

    public void setColor4(int i) {
        this.d = i;
    }

    public FingerLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = -1.0f;
        this.d = Color.parseColor("#5344c6");
        this.e = new Paint();
        a(context);
    }

    public FingerLineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = -1.0f;
        this.d = Color.parseColor("#5344c6");
        this.e = new Paint();
        a(context);
    }
}
