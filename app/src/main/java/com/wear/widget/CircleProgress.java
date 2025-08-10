package com.wear.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.lovense.wear.R;
import dc.th4;
import dc.vi1;

/* loaded from: classes4.dex */
public class CircleProgress extends View {
    public static final String E = CircleProgress.class.getSimpleName();
    public float A;
    public boolean B;
    public int C;
    public int D;
    public Context a;
    public int b;
    public boolean c;
    public TextPaint d;
    public CharSequence e;
    public float f;
    public TextPaint g;
    public CharSequence h;
    public int i;
    public float j;
    public TextPaint k;
    public float l;
    public float m;
    public int n;
    public float o;
    public Paint p;
    public float q;
    public float r;
    public float s;
    public RectF t;
    public float u;
    public long v;
    public ValueAnimator w;
    public int x;
    public Point y;
    public float z;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CircleProgress.this.u = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            CircleProgress circleProgress = CircleProgress.this;
            circleProgress.l = circleProgress.u * CircleProgress.this.m;
            CircleProgress.this.invalidate();
        }
    }

    public CircleProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.B = true;
        j(context, attributeSet);
    }

    public static int e(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + ((f >= 0.0f ? 1 : -1) * 0.5f));
    }

    public static String i(int i) {
        return "%." + i + "f";
    }

    public static int m(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
    }

    public final void f(Canvas canvas) {
        canvas.save();
        float f = this.r;
        Point point = this.y;
        canvas.rotate(f, point.x, point.y);
        canvas.drawArc(this.t, 0.0f, this.s * this.u, false, this.p);
        canvas.restore();
    }

    public final void g(Canvas canvas) {
    }

    public long getAnimTime() {
        return this.v;
    }

    public CharSequence getHint() {
        return this.e;
    }

    public float getMaxValue() {
        return this.m;
    }

    public int getPrecision() {
        return this.n;
    }

    public CharSequence getUnit() {
        return this.h;
    }

    public float getValue() {
        return this.l;
    }

    public final float h(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f;
    }

    public final void j(Context context, AttributeSet attributeSet) {
        this.a = context;
        this.b = e(context, 150.0f);
        this.w = new ValueAnimator();
        this.t = new RectF();
        this.y = new Point();
        k(attributeSet);
        l();
        setValue(this.l);
    }

    public final void k(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = this.a.obtainStyledAttributes(attributeSet, vi1.CircleProgressBar);
        this.c = typedArrayObtainStyledAttributes.getBoolean(1, true);
        this.e = typedArrayObtainStyledAttributes.getString(7);
        typedArrayObtainStyledAttributes.getColor(8, ViewCompat.MEASURED_STATE_MASK);
        this.f = typedArrayObtainStyledAttributes.getDimension(9, 15.0f);
        this.l = typedArrayObtainStyledAttributes.getFloat(18, 50.0f);
        this.m = typedArrayObtainStyledAttributes.getFloat(10, 50.0f);
        int i = typedArrayObtainStyledAttributes.getInt(11, 0);
        this.n = i;
        i(i);
        typedArrayObtainStyledAttributes.getColor(19, ViewCompat.MEASURED_STATE_MASK);
        this.o = typedArrayObtainStyledAttributes.getDimension(20, 15.0f);
        this.h = typedArrayObtainStyledAttributes.getString(15);
        this.i = typedArrayObtainStyledAttributes.getColor(16, ViewCompat.MEASURED_STATE_MASK);
        this.j = typedArrayObtainStyledAttributes.getDimension(17, 30.0f);
        this.q = typedArrayObtainStyledAttributes.getDimension(3, 15.0f);
        this.r = typedArrayObtainStyledAttributes.getFloat(12, 270.0f);
        this.s = typedArrayObtainStyledAttributes.getFloat(13, 360.0f);
        this.x = typedArrayObtainStyledAttributes.getColor(2, SupportMenu.CATEGORY_MASK);
        typedArrayObtainStyledAttributes.getColor(4, SupportMenu.CATEGORY_MASK);
        this.A = typedArrayObtainStyledAttributes.getFloat(14, 0.33f);
        this.v = typedArrayObtainStyledAttributes.getInt(0, 1000);
        this.C = typedArrayObtainStyledAttributes.getColor(6, -16776961);
        this.D = typedArrayObtainStyledAttributes.getColor(5, -16776961);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void l() {
        TextPaint textPaint = new TextPaint();
        this.d = textPaint;
        textPaint.setAntiAlias(this.c);
        this.d.setTextSize(this.f);
        this.d.setColor(th4.b(getContext(), R.color.sound_db_hint_color));
        this.d.setTextAlign(Paint.Align.CENTER);
        TextPaint textPaint2 = new TextPaint();
        this.k = textPaint2;
        textPaint2.setAntiAlias(this.c);
        this.k.setTextSize(this.o);
        this.k.setColor(th4.b(getContext(), R.color.sound_db_color));
        this.k.setTypeface(Typeface.DEFAULT_BOLD);
        this.k.setTextAlign(Paint.Align.CENTER);
        TextPaint textPaint3 = new TextPaint();
        this.g = textPaint3;
        textPaint3.setAntiAlias(this.c);
        this.g.setTextSize(this.j);
        this.g.setColor(this.i);
        this.g.setTextAlign(Paint.Align.CENTER);
        Paint paint = new Paint();
        this.p = paint;
        paint.setAntiAlias(this.c);
        this.p.setStyle(Paint.Style.STROKE);
        this.p.setStrokeWidth(this.q);
        this.p.setStrokeCap(Paint.Cap.ROUND);
    }

    public final void n(float f, float f2, long j) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        this.w = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(j);
        this.w.addUpdateListener(new a());
        this.w.start();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        g(canvas);
        f(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(m(i, this.b), m(i2, this.b));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i;
        String str = "onSizeChanged: w = " + i + "; h = " + i2 + "; oldw = " + i3 + "; oldh = " + i4;
        float f2 = this.q;
        int i5 = ((int) f2) * 2;
        float fMin = Math.min(((i - getPaddingLeft()) - getPaddingRight()) - i5, ((i2 - getPaddingTop()) - getPaddingBottom()) - i5) / 2;
        this.z = fMin;
        Point point = this.y;
        int i6 = i / 2;
        point.x = i6;
        int i7 = i2 / 2;
        point.y = i7;
        RectF rectF = this.t;
        float f3 = f2 / 2.0f;
        rectF.left = (i6 - fMin) - f3;
        rectF.top = (i7 - fMin) - f3;
        rectF.right = i6 + fMin + f3;
        rectF.bottom = i7 + fMin + f3;
        h(this.k);
        int i8 = this.y.y;
        h(this.d);
        int i9 = this.y.y;
        h(this.g);
        if (!this.B) {
            this.p.setColor(this.x);
            return;
        }
        this.p.setShader(new LinearGradient(0.0f, 0.0f, f, i2, this.C, this.D, Shader.TileMode.CLAMP));
        String str2 = "onSizeChanged: 控件大小 = (" + i + ", " + i2 + ")圆心坐标 = " + this.y.toString() + ";圆半径 = " + this.z + ";圆的外接矩形 = " + this.t.toString();
    }

    public void setAnimTime(long j) {
        this.v = j;
    }

    public void setHint(CharSequence charSequence) {
        this.e = charSequence;
    }

    public void setMaxValue(float f) {
        this.m = f;
    }

    public void setPrecision(int i) {
        this.n = i;
        i(i);
    }

    public void setUnit(CharSequence charSequence) {
        this.h = charSequence;
    }

    public void setValue(float f) {
        float f2 = this.m;
        if (f > f2) {
            f = f2;
        }
        n(this.u, f / f2, 100L);
    }
}
