package com.wear.widget.control;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.lovense.wear.R;
import dc.ce3;
import dc.gg3;

/* loaded from: classes4.dex */
public class FingerCircleView extends View {
    public int a;
    public float b;
    public float c;
    public int d;
    public int e;
    public int f;
    public Bitmap g;
    public Paint h;

    public FingerCircleView(Context context) {
        super(context);
        this.b = 0.0f;
        this.c = -1.0f;
        this.f = Color.parseColor("#80ffffff");
        this.h = new Paint();
        a(context);
    }

    public final void a(Context context) {
        this.d = gg3.e(context);
        this.e = ce3.a(context, 121.0f) / 2;
        this.b = (this.d / 2) - r2;
        this.g = BitmapFactory.decodeResource(getResources(), R.drawable.touch_btn);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.a = getMeasuredHeight();
        float f = this.c;
        if (f == -1.0f) {
            this.h.setColor(this.f);
            int i = this.a;
            canvas.drawLine(0.0f, i - 1.0f, this.d, i - 1.0f, this.h);
            this.h.setColor(-1);
            canvas.drawBitmap(this.g, this.d / 2, this.a - this.e, this.h);
            return;
        }
        if (f < 0.0f) {
            this.c = 0.0f;
        }
        if (this.c > r0 - 1) {
            this.c = r0 - 1;
        }
        this.h.setColor(this.f);
        float f2 = this.c;
        canvas.drawLine(0.0f, f2, this.d, f2, this.h);
        this.h.setColor(-1);
        Bitmap bitmap = this.g;
        float f3 = this.b;
        int i2 = this.e;
        canvas.drawBitmap(bitmap, f3 - i2, this.c - i2, this.h);
    }

    public void setColor4(int i) {
        this.f = i;
    }

    public void setTouch_btn_1(Bitmap bitmap) {
        this.g = bitmap;
        this.e = bitmap.getWidth() / 2;
        this.b = (this.d / 2) - r2;
    }

    public FingerCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0.0f;
        this.c = -1.0f;
        this.f = Color.parseColor("#80ffffff");
        this.h = new Paint();
        a(context);
    }

    public FingerCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 0.0f;
        this.c = -1.0f;
        this.f = Color.parseColor("#80ffffff");
        this.h = new Paint();
        a(context);
    }
}
