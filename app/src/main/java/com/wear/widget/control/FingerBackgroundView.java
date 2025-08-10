package com.wear.widget.control;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.lovense.wear.R;
import dc.th4;

/* loaded from: classes4.dex */
public class FingerBackgroundView extends View {
    public int a;
    public float b;
    public boolean c;
    public float d;
    public boolean e;
    public float f;
    public boolean g;
    public Paint h;
    public Paint i;
    public Paint j;

    public FingerBackgroundView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = -1.0f;
        this.c = false;
        this.d = -1.0f;
        this.e = false;
        this.f = -1.0f;
        this.g = false;
        this.h = new Paint();
        this.i = new Paint();
        this.j = new Paint();
        this.h.setColor(th4.b(context, R.color.remote_control_line));
        this.i.setColor(th4.b(context, R.color.remote_control_line));
        this.j.setColor(th4.b(context, R.color.remote_control_line));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.c) {
            float f = this.b;
            canvas.drawLine(0.0f, f, this.a, f, this.h);
        }
        if (this.e) {
            float f2 = this.d;
            canvas.drawLine(0.0f, f2, this.a, f2, this.i);
        }
        if (this.g) {
            float f3 = this.f;
            canvas.drawLine(0.0f, f3, this.a, f3, this.i);
        }
    }

    public void setExpLastY(float f) {
        this.f = f;
    }

    public void setLayoutSize(int i, int i2) {
        this.a = i;
    }

    public void setOneLastY(float f) {
        this.b = f;
    }

    public void setTwoLastY(float f) {
        this.d = f;
    }

    public void setmOneLineColor(int i) {
        this.h.setColor(i);
    }

    public void setmTowLineColor(int i) {
        this.i.setColor(i);
    }
}
