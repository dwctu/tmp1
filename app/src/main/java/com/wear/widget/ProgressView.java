package com.wear.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;

/* loaded from: classes4.dex */
public class ProgressView extends View {
    public static final int[] i = {-16711936, InputDeviceCompat.SOURCE_ANY, SupportMenu.CATEGORY_MASK};
    public static final String[] j = {"安全", "低危", "中危", "高危"};
    public float a;
    public float b;
    public int c;
    public String d;
    public Paint e;
    public Paint f;
    public int g;
    public int h;

    public ProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b(context);
    }

    public final int a(int i2) {
        return (int) ((i2 * getContext().getResources().getDisplayMetrics().density) + ((i2 >= 0 ? 1 : -1) * 0.5f));
    }

    public final void b(Context context) {
        this.e = new Paint();
        this.f = new Paint();
    }

    public final void c() {
        this.e.setAntiAlias(true);
        this.e.setStrokeWidth(40.0f);
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setStrokeCap(Paint.Cap.ROUND);
        this.e.setColor(0);
        this.f.setAntiAlias(true);
        this.f.setStrokeWidth(3.0f);
        this.f.setTextAlign(Paint.Align.CENTER);
        this.f.setTextSize(50.0f);
        this.f.setColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public String getCrrentLevel() {
        return this.d;
    }

    public float getCurrentCount() {
        return this.b;
    }

    public float getMaxCount() {
        return this.a;
    }

    public int getScore() {
        return this.c;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c();
        RectF rectF = new RectF(20.0f, 20.0f, this.g - 20, this.h - 20);
        canvas.drawArc(rectF, 0.0f, 360.0f, false, this.e);
        this.e.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawText(this.c + "分", this.g / 2, this.h / 2, this.f);
        this.f.setTextSize(40.0f);
        String str = this.d;
        if (str != null) {
            canvas.drawText(str, this.g / 2, (this.h / 2) + 50, this.f);
        }
        float f = this.b / this.a;
        if (f > 0.33333334f) {
            int i2 = f <= 0.6666667f ? 2 : 3;
            int[] iArr = new int[i2];
            System.arraycopy(i, 0, iArr, 0, i2);
            float[] fArr = new float[i2];
            if (i2 == 2) {
                fArr[0] = 0.0f;
                fArr[1] = 1.0f - fArr[0];
            } else {
                fArr[0] = 0.0f;
                fArr[1] = (this.a / 3.0f) / this.b;
                fArr[2] = 1.0f - (fArr[0] * 2.0f);
            }
            fArr[i2 - 1] = 1.0f;
            this.e.setShader(new LinearGradient(3.0f, 3.0f, (this.g - 3) * f, this.h - 3, iArr, (float[]) null, Shader.TileMode.MIRROR));
        } else if (f != 0.0f) {
            this.e.setColor(i[0]);
        } else {
            this.e.setColor(0);
        }
        canvas.drawArc(rectF, 180.0f, f * 360.0f, false, this.e);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode == 1073741824 || mode == Integer.MIN_VALUE) {
            this.g = size;
        } else {
            this.g = 0;
        }
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            this.h = a(15);
        } else {
            this.h = size2;
        }
        setMeasuredDimension(this.g, this.h);
    }

    public void setCrrentLevel(String str) {
        this.d = str;
    }

    public void setCurrentCount(float f) {
        float f2 = this.a;
        if (f > f2) {
            f = f2;
        }
        this.b = f;
        invalidate();
    }

    public void setMaxCount(float f) {
        this.a = f;
    }

    public void setScore(int i2) {
        this.c = i2;
        if (i2 == 100) {
            this.d = j[0];
        } else if (i2 >= 70 && i2 < 100) {
            this.d = j[1];
        } else if (i2 < 30 || i2 >= 70) {
            this.d = j[3];
        } else {
            this.d = j[2];
        }
        invalidate();
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProgressView(Context context) {
        this(context, null);
    }
}
