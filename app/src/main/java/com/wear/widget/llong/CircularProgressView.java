package com.wear.widget.llong;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import dc.vi1;

/* loaded from: classes4.dex */
public class CircularProgressView extends View {
    public Paint a;
    public Paint b;
    public RectF c;
    public int[] d;
    public int e;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CircularProgressView.this.e = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            CircularProgressView.this.invalidate();
        }
    }

    public CircularProgressView(Context context) {
        this(context, null);
    }

    public int getProgress() {
        return this.e;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.c, 0.0f, 360.0f, false, this.a);
        canvas.drawArc(this.c, 275.0f, (this.e * 360) / 100, false, this.b);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int strokeWidth = (int) ((measuredWidth > measuredHeight ? measuredHeight : measuredWidth) - (this.a.getStrokeWidth() > this.b.getStrokeWidth() ? this.a : this.b).getStrokeWidth());
        this.c = new RectF(getPaddingLeft() + ((measuredWidth - strokeWidth) / 2), getPaddingTop() + ((measuredHeight - strokeWidth) / 2), r1 + strokeWidth, r9 + strokeWidth);
        int[] iArr = this.d;
        if (iArr == null || iArr.length <= 1) {
            return;
        }
        this.b.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredWidth(), this.d, (float[]) null, Shader.TileMode.MIRROR));
    }

    public void setBackColor(int i) {
        this.a.setColor(i);
        invalidate();
    }

    public void setBackWidth(int i) {
        this.a.setStrokeWidth(i);
        invalidate();
    }

    public void setProgColor(int i) {
        this.b.setColor(i);
        this.b.setShader(null);
        invalidate();
    }

    public void setProgWidth(int i) {
        this.b.setStrokeWidth(i);
        invalidate();
    }

    public void setProgress(int i) {
        this.e = i;
        invalidate();
    }

    public CircularProgressView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircularProgressView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vi1.CircularProgressView);
        Paint paint = new Paint();
        this.a = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.a.setStrokeCap(Paint.Cap.ROUND);
        this.a.setAntiAlias(true);
        this.a.setDither(true);
        this.a.setStrokeWidth(typedArrayObtainStyledAttributes.getDimension(1, 5.0f));
        this.a.setColor(typedArrayObtainStyledAttributes.getColor(0, -3355444));
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.b.setStrokeCap(Paint.Cap.ROUND);
        this.b.setAntiAlias(true);
        this.b.setDither(true);
        this.b.setStrokeWidth(typedArrayObtainStyledAttributes.getDimension(5, 10.0f));
        this.b.setColor(typedArrayObtainStyledAttributes.getColor(2, -16776961));
        int color = typedArrayObtainStyledAttributes.getColor(4, -1);
        int color2 = typedArrayObtainStyledAttributes.getColor(3, -1);
        if (color != -1 && color2 != -1) {
            this.d = new int[]{color, color2};
        } else {
            this.d = null;
        }
        this.e = typedArrayObtainStyledAttributes.getInteger(6, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setProgress(int i, long j) {
        if (j <= 0) {
            setProgress(i);
            return;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.e, i);
        valueAnimatorOfInt.addUpdateListener(new a());
        valueAnimatorOfInt.setInterpolator(new OvershootInterpolator());
        valueAnimatorOfInt.setDuration(j);
        valueAnimatorOfInt.start();
    }

    public void setProgColor(@ColorRes int i, @ColorRes int i2) {
        this.d = new int[]{ContextCompat.getColor(getContext(), i), ContextCompat.getColor(getContext(), i2)};
        this.b.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredWidth(), this.d, (float[]) null, Shader.TileMode.MIRROR));
        invalidate();
    }

    public void setProgColor(@ColorRes int[] iArr) {
        if (iArr == null || iArr.length < 2) {
            return;
        }
        this.d = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            this.d[i] = ContextCompat.getColor(getContext(), iArr[i]);
        }
        this.b.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredWidth(), this.d, (float[]) null, Shader.TileMode.MIRROR));
        invalidate();
    }
}
