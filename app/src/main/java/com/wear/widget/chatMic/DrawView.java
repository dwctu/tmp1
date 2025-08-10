package com.wear.widget.chatMic;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.lovense.wear.R;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class DrawView extends View {
    public final Path a;
    public int b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public boolean h;
    public ArrayList<Paint> i;
    public int j;
    public int k;
    public float l;
    public float m;
    public boolean n;
    public int o;

    public DrawView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.h) {
            return;
        }
        this.h = true;
        int i = 0;
        while (true) {
            int i2 = this.b;
            if (i >= i2) {
                break;
            }
            float f = (((1.0f - (i / i2)) * 1.5f) - 0.5f) * this.m;
            this.a.reset();
            float f2 = 0.0f;
            while (f2 < this.j + this.d) {
                double dSin = ((-Math.pow((f2 / this.l) - 1.0f, 2.0d)) + 1.0d) * this.g * f * Math.sin(((f2 / this.j) * 6.282d * this.c) + this.f);
                int i3 = this.k;
                double d = dSin + (i3 / 2.0d);
                if (this.n) {
                    d = i3 / 2.0d;
                }
                if (f2 == 0.0f) {
                    this.a.moveTo(f2, (float) d);
                } else {
                    this.a.lineTo(f2, (float) d);
                }
                f2 += this.d;
            }
            canvas.drawPath(this.a, this.i.get(i));
            if (this.n) {
                break;
            } else {
                i++;
            }
        }
        this.h = false;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.j = i;
        this.k = i2;
        this.l = i / 2.0f;
        this.g = (i2 / 2.0f) - 4.0f;
        this.o = i2 / 2;
        int i5 = this.k;
        int i6 = this.o;
        LinearGradient linearGradient = new LinearGradient(0.0f, (i5 / 2) - i6, 0.0f, (i5 / 2) + i6, getResources().getColor(R.color.color_accent), getResources().getColor(R.color.color_accent_second), Shader.TileMode.CLAMP);
        Iterator<Paint> it = this.i.iterator();
        while (it.hasNext()) {
            it.next().setShader(linearGradient);
        }
    }

    public void setPause(boolean z) {
        this.n = z;
    }

    public DrawView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 5;
        this.c = 1.2f;
        this.d = 1.0f;
        this.e = -0.25f;
        this.f = 0.0f;
        this.g = 0.0f;
        int i2 = 0;
        this.h = false;
        this.i = new ArrayList<>();
        new ArrayList();
        this.j = 0;
        this.k = 0;
        this.l = 0.0f;
        this.m = 1.0f;
        this.n = true;
        this.o = 100;
        Resources resources = getResources();
        while (true) {
            int i3 = this.b;
            if (i2 < i3) {
                float fMin = Math.min(1.0f, (((1.0f - (i2 / i3)) / 3.0f) * 2.0f) + 0.33333334f);
                if (i2 == 0) {
                    Paint paint = new Paint(1);
                    paint.setStrokeWidth(resources.getDimension(R.dimen.waver_width));
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setColor(getResources().getColor(R.color.color_accent_second));
                    this.i.add(paint);
                } else {
                    Paint paint2 = new Paint(1);
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    double d = fMin * 1.0f;
                    sb.append((int) (0.4d * d * 255.0d));
                    sb.toString();
                    paint2.setColor(-1);
                    paint2.setAlpha((int) (d * 0.6d * 255.0d));
                    paint2.setStrokeWidth(resources.getDimension(R.dimen.waver_width_min));
                    paint2.setStyle(Paint.Style.STROKE);
                    this.i.add(paint2);
                }
                i2++;
            } else {
                this.a = new Path();
                return;
            }
        }
    }
}
