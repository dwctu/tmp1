package com.wear.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.lovense.wear.R;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes4.dex */
public class WaveBezier extends View implements View.OnClickListener {
    public Paint a;
    public Path b;
    public Path c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public ValueAnimator k;
    public int l;
    public float m;
    public float n;
    public Timer o;
    public int p;
    public int q;
    public int r;

    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (WaveBezier.this.i > 0) {
                WaveBezier waveBezier = WaveBezier.this;
                if (waveBezier.q > 0) {
                    int i = waveBezier.r;
                    int i2 = waveBezier.p;
                    waveBezier.p = i2 + 1;
                    waveBezier.q = i - (i2 % (i + 1));
                    float f = waveBezier.m;
                    WaveBezier waveBezier2 = WaveBezier.this;
                    waveBezier.n = (f / waveBezier2.r) * waveBezier2.q;
                    System.out.println("currentHeightNumber=" + WaveBezier.this.q + " -mOffsetY " + WaveBezier.this.n + " an=" + WaveBezier.this.p + "");
                    WaveBezier.this.postInvalidate();
                }
            }
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaveBezier.this.e = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            WaveBezier.this.postInvalidate();
        }
    }

    public WaveBezier(Context context) {
        super(context);
        this.d = 1000;
        this.l = 100;
        this.m = 100;
        this.n = 100;
        this.p = 0;
        this.q = 0;
        this.r = 10;
    }

    public final void f() {
        g(this.l);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, this.d);
        this.k = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(1000L);
        this.k.setRepeatCount(-1);
        this.k.setInterpolator(new LinearInterpolator());
        this.k.addUpdateListener(new b());
        this.k.start();
    }

    public void g(float f) {
        this.m = f;
        this.p = 0;
        this.q = 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g(this.l);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.b.reset();
        this.b.moveTo((-this.d) + this.e, this.j);
        for (int i = 0; i < this.i; i++) {
            Path path = this.b;
            int i2 = this.d;
            int i3 = this.e;
            int i4 = this.j;
            path.quadTo((((-i2) * 3) / 4) + (i * i2) + i3, i4 + this.n, ((-i2) / 2) + (i2 * i) + i3, i4);
            Path path2 = this.b;
            int i5 = this.d;
            int i6 = this.e;
            int i7 = this.j;
            path2.quadTo(((-i5) / 4) + (i * i5) + i6, i7 - this.n, (i5 * i) + i6, i7);
        }
        canvas.drawPath(this.b, this.a);
        for (int i8 = 1; i8 <= 2; i8++) {
            this.f = (this.e * i8) / 3;
            this.c.reset();
            this.c.moveTo((-this.d) + this.f, this.j);
            for (int i9 = 0; i9 < this.i; i9++) {
                Path path3 = this.c;
                int i10 = this.d;
                int i11 = this.f;
                int i12 = this.j;
                path3.quadTo((((-i10) * 3) / 4) + (i9 * i10) + i11, i12 - this.n, ((-i10) / 2) + (i10 * i9) + i11, i12);
                Path path4 = this.c;
                int i13 = this.d;
                int i14 = this.f;
                int i15 = this.j;
                path4.quadTo(((-i13) / 4) + (i9 * i13) + i14, i15 + this.n, (i13 * i9) + i14, i15);
            }
            canvas.drawPath(this.c, this.a);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.g = i2;
        this.h = i;
        this.i = (int) Math.round((i / this.d) + 1.5d);
        int i5 = this.g;
        this.j = i5 / 2;
        this.l = i5 / 2;
        int i6 = this.g;
        int i7 = this.l;
        this.a.setShader(new LinearGradient(0.0f, (i6 / 2) - i7, 0.0f, (i6 / 2) + i7, getResources().getColor(R.color.color_accent), getResources().getColor(R.color.color_accent_second), Shader.TileMode.CLAMP));
        f();
    }

    public WaveBezier(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 1000;
        this.l = 100;
        this.m = 100;
        this.n = 100;
        this.p = 0;
        this.q = 0;
        this.r = 10;
    }

    public WaveBezier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 1000;
        this.l = 100;
        this.m = 100;
        this.n = 100;
        this.p = 0;
        this.q = 0;
        this.r = 10;
        this.b = new Path();
        this.c = new Path();
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setColor(getResources().getColor(R.color.color_accent));
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(5.0f);
        this.a.setAntiAlias(true);
        setOnClickListener(this);
        Timer timer = new Timer();
        this.o = timer;
        timer.scheduleAtFixedRate(new a(), 100L, 100L);
    }
}
