package com.wear.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import com.google.android.gms.common.ConnectionResult;
import com.lovense.wear.R;
import dc.od3;
import dc.th4;
import dc.vi1;
import skin.support.widget.SkinCompatFrameLayout;

/* loaded from: classes4.dex */
public class ShimmerLayout extends SkinCompatFrameLayout {
    public int b;
    public Rect c;
    public Paint d;
    public ValueAnimator e;
    public Bitmap f;
    public Bitmap g;
    public Canvas h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public float o;
    public float p;
    public ViewTreeObserver.OnPreDrawListener q;

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ShimmerLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ShimmerLayout.this.m();
            return true;
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        public b(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ShimmerLayout.this.b = this.a + ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (ShimmerLayout.this.b + this.b >= 0) {
                ShimmerLayout.this.invalidate();
            }
        }
    }

    public ShimmerLayout(Context context) {
        this(context, null);
    }

    private float[] getGradientColorDistribution() {
        float f = this.p;
        return new float[]{0.0f, 0.5f - (f / 2.0f), (f / 2.0f) + 0.5f, 1.0f};
    }

    private Bitmap getMaskBitmap() {
        if (this.g == null) {
            this.g = e(this.c.width(), getHeight());
        }
        return this.g;
    }

    private Animator getShimmerAnimation() {
        ValueAnimator valueAnimator = this.e;
        if (valueAnimator != null) {
            return valueAnimator;
        }
        if (this.c == null) {
            this.c = c();
        }
        int width = getWidth();
        int i = getWidth() > this.c.width() ? -width : -this.c.width();
        int iWidth = this.c.width();
        int i2 = width - i;
        ValueAnimator valueAnimatorOfInt = this.i ? ValueAnimator.ofInt(i2, 0) : ValueAnimator.ofInt(0, i2);
        this.e = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(this.l);
        this.e.setRepeatCount(-1);
        this.e.addUpdateListener(new b(i, iWidth));
        return this.e;
    }

    public final Rect c() {
        return new Rect(0, 0, d(), getHeight());
    }

    public final int d() {
        return (int) ((((getWidth() / 2) * this.o) / Math.cos(Math.toRadians(Math.abs(this.n)))) + (getHeight() * Math.tan(Math.toRadians(Math.abs(this.n)))));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (!this.j || getWidth() <= 0 || getHeight() <= 0) {
            super.dispatchDraw(canvas);
        } else {
            g(canvas);
        }
    }

    public final Bitmap e(int i, int i2) {
        try {
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ALPHA_8);
        } catch (OutOfMemoryError unused) {
            System.gc();
            return null;
        }
    }

    public final void f() {
        if (this.d == null) {
            int i = i(this.m);
            float width = (getWidth() / 2) * this.o;
            float height = this.n >= 0 ? getHeight() : 0.0f;
            float fCos = ((float) Math.cos(Math.toRadians(this.n))) * width;
            float fSin = height + (((float) Math.sin(Math.toRadians(this.n))) * width);
            int i2 = this.m;
            LinearGradient linearGradient = new LinearGradient(0.0f, height, fCos, fSin, new int[]{i, i2, i2, i}, getGradientColorDistribution(), Shader.TileMode.CLAMP);
            Bitmap bitmap = this.f;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            ComposeShader composeShader = new ComposeShader(linearGradient, new BitmapShader(bitmap, tileMode, tileMode), PorterDuff.Mode.DST_IN);
            Paint paint = new Paint();
            this.d = paint;
            paint.setAntiAlias(true);
            this.d.setDither(true);
            this.d.setFilterBitmap(true);
            this.d.setShader(composeShader);
        }
    }

    public final void g(Canvas canvas) {
        super.dispatchDraw(canvas);
        Bitmap maskBitmap = getMaskBitmap();
        this.f = maskBitmap;
        if (maskBitmap != null) {
            if (this.h == null) {
                this.h = new Canvas(this.f);
            }
            this.h.drawColor(0, PorterDuff.Mode.CLEAR);
            this.h.save();
            this.h.translate(-this.b, 0.0f);
            super.dispatchDraw(this.h);
            this.h.restore();
            h(canvas);
            this.f = null;
        }
    }

    public final void h(Canvas canvas) {
        f();
        canvas.save();
        canvas.translate(this.b, 0.0f);
        Rect rect = this.c;
        canvas.drawRect(rect.left, 0.0f, rect.width(), this.c.height(), this.d);
        canvas.restore();
    }

    public final int i(int i) {
        return Color.argb(0, Color.red(i), Color.green(i), Color.blue(i));
    }

    public final void j() {
        this.h = null;
        Bitmap bitmap = this.g;
        if (bitmap != null) {
            bitmap.recycle();
            this.g = null;
        }
    }

    public final void k() {
        if (this.j) {
            l();
            m();
        }
    }

    public final void l() {
        ValueAnimator valueAnimator = this.e;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.e.removeAllUpdateListeners();
        }
        this.e = null;
        this.d = null;
        this.j = false;
        j();
    }

    public void m() {
        if (this.j) {
            return;
        }
        if (getWidth() == 0) {
            this.q = new a();
            getViewTreeObserver().addOnPreDrawListener(this.q);
        } else {
            getShimmerAnimation().start();
            this.j = true;
        }
    }

    public void n() {
        if (this.q != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.q);
        }
        l();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        l();
        super.onDetachedFromWindow();
    }

    public void setAnimationReversed(boolean z) {
        this.i = z;
        k();
    }

    public void setGradientCenterColorWidth(float f) {
        if (f <= 0.0f || 1.0f <= f) {
            throw new IllegalArgumentException(String.format("gradientCenterColorWidth value must be higher than %d and less than %d", 0, 1));
        }
        this.p = f;
        k();
    }

    public void setMaskWidth(float f) {
        if (f <= 0.0f || 1.0f < f) {
            throw new IllegalArgumentException(String.format("maskWidth value must be higher than %d and less or equal to %d", 0, 1));
        }
        this.o = f;
        k();
    }

    public void setShimmerAngle(int i) {
        if (i < -45 || 45 < i) {
            throw new IllegalArgumentException(String.format("shimmerAngle value must be between %d and %d", -45, 45));
        }
        this.n = i;
        k();
    }

    public void setShimmerAnimationDuration(int i) {
        this.l = i;
        k();
    }

    public void setShimmerColor(int i) {
        this.m = i;
        k();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i != 0) {
            n();
        } else if (this.k) {
            m();
        }
    }

    public ShimmerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShimmerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, vi1.ShimmerLayout, 0, 0);
        try {
            this.n = typedArrayObtainStyledAttributes.getInteger(0, 20);
            this.l = typedArrayObtainStyledAttributes.getInteger(1, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
            try {
                this.m = th4.b(context, od3.a(attributeSet, "shimmer_color"));
            } catch (Exception unused) {
                this.m = typedArrayObtainStyledAttributes.getColor(3, th4.b(context, R.color.shimmer_color));
            }
            this.k = typedArrayObtainStyledAttributes.getBoolean(2, false);
            this.o = typedArrayObtainStyledAttributes.getFloat(5, 0.5f);
            this.p = typedArrayObtainStyledAttributes.getFloat(4, 0.1f);
            this.i = typedArrayObtainStyledAttributes.getBoolean(6, false);
            typedArrayObtainStyledAttributes.recycle();
            setMaskWidth(this.o);
            setGradientCenterColorWidth(this.p);
            setShimmerAngle(this.n);
            if (this.k && getVisibility() == 0) {
                m();
            }
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }
}
