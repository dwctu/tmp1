package io.supercharge.shimmerlayout;

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
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.common.ConnectionResult;
import dc.mx3;
import dc.nx3;

/* loaded from: classes4.dex */
public class ShimmerLayout extends FrameLayout {
    public int a;
    public Rect b;
    public Paint c;
    public ValueAnimator d;
    public Bitmap e;
    public Bitmap f;
    public Canvas g;
    public boolean h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public float n;
    public float o;
    public ViewTreeObserver.OnPreDrawListener p;

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ShimmerLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ShimmerLayout.this.n();
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
            ShimmerLayout.this.a = this.a + ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (ShimmerLayout.this.a + this.b >= 0) {
                ShimmerLayout.this.invalidate();
            }
        }
    }

    public ShimmerLayout(Context context) {
        this(context, null);
    }

    private float[] getGradientColorDistribution() {
        float[] fArr = {0.0f, 0.5f - (f / 2.0f), (f / 2.0f) + 0.5f, 1.0f};
        float f = this.o;
        return fArr;
    }

    private Bitmap getMaskBitmap() {
        if (this.f == null) {
            this.f = e(this.b.width(), getHeight());
        }
        return this.f;
    }

    private Animator getShimmerAnimation() {
        ValueAnimator valueAnimator = this.d;
        if (valueAnimator != null) {
            return valueAnimator;
        }
        if (this.b == null) {
            this.b = c();
        }
        int width = getWidth();
        int i = getWidth() > this.b.width() ? -width : -this.b.width();
        int iWidth = this.b.width();
        int i2 = width - i;
        ValueAnimator valueAnimatorOfInt = this.h ? ValueAnimator.ofInt(i2, 0) : ValueAnimator.ofInt(0, i2);
        this.d = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(this.k);
        this.d.setRepeatCount(-1);
        this.d.addUpdateListener(new b(i, iWidth));
        return this.d;
    }

    public final Rect c() {
        return new Rect(0, 0, d(), getHeight());
    }

    public final int d() {
        return (int) ((((getWidth() / 2) * this.n) / Math.cos(Math.toRadians(Math.abs(this.m)))) + (getHeight() * Math.tan(Math.toRadians(Math.abs(this.m)))));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (!this.i || getWidth() <= 0 || getHeight() <= 0) {
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
        if (this.c != null) {
            return;
        }
        int iJ = j(this.l);
        float width = (getWidth() / 2) * this.n;
        float height = this.m >= 0 ? getHeight() : 0.0f;
        float fCos = ((float) Math.cos(Math.toRadians(this.m))) * width;
        float fSin = height + (((float) Math.sin(Math.toRadians(this.m))) * width);
        int i = this.l;
        LinearGradient linearGradient = new LinearGradient(0.0f, height, fCos, fSin, new int[]{iJ, i, i, iJ}, getGradientColorDistribution(), Shader.TileMode.CLAMP);
        Bitmap bitmap = this.e;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        ComposeShader composeShader = new ComposeShader(linearGradient, new BitmapShader(bitmap, tileMode, tileMode), PorterDuff.Mode.DST_IN);
        Paint paint = new Paint();
        this.c = paint;
        paint.setAntiAlias(true);
        this.c.setDither(true);
        this.c.setFilterBitmap(true);
        this.c.setShader(composeShader);
    }

    public final void g(Canvas canvas) {
        super.dispatchDraw(canvas);
        Bitmap maskBitmap = getMaskBitmap();
        this.e = maskBitmap;
        if (maskBitmap == null) {
            return;
        }
        if (this.g == null) {
            this.g = new Canvas(this.e);
        }
        this.g.drawColor(0, PorterDuff.Mode.CLEAR);
        this.g.save();
        this.g.translate(-this.a, 0.0f);
        super.dispatchDraw(this.g);
        this.g.restore();
        h(canvas);
        this.e = null;
    }

    public final void h(Canvas canvas) {
        f();
        canvas.save();
        canvas.translate(this.a, 0.0f);
        Rect rect = this.b;
        canvas.drawRect(rect.left, 0.0f, rect.width(), this.b.height(), this.c);
        canvas.restore();
    }

    public final int i(int i) {
        return Build.VERSION.SDK_INT >= 23 ? getContext().getColor(i) : getResources().getColor(i);
    }

    public final int j(int i) {
        return Color.argb(0, Color.red(i), Color.green(i), Color.blue(i));
    }

    public final void k() {
        this.g = null;
        Bitmap bitmap = this.f;
        if (bitmap != null) {
            bitmap.recycle();
            this.f = null;
        }
    }

    public final void l() {
        if (this.i) {
            m();
            n();
        }
    }

    public final void m() {
        ValueAnimator valueAnimator = this.d;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.d.removeAllUpdateListeners();
        }
        this.d = null;
        this.c = null;
        this.i = false;
        k();
    }

    public void n() {
        if (this.i) {
            return;
        }
        if (getWidth() == 0) {
            this.p = new a();
            getViewTreeObserver().addOnPreDrawListener(this.p);
        } else {
            getShimmerAnimation().start();
            this.i = true;
        }
    }

    public void o() {
        if (this.p != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.p);
        }
        m();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        m();
        super.onDetachedFromWindow();
    }

    public void setAnimationReversed(boolean z) {
        this.h = z;
        l();
    }

    public void setGradientCenterColorWidth(float f) {
        if (f <= 0.0f || 1.0f <= f) {
            throw new IllegalArgumentException(String.format("gradientCenterColorWidth value must be higher than %d and less than %d", (byte) 0, (byte) 1));
        }
        this.o = f;
        l();
    }

    public void setMaskWidth(float f) {
        if (f <= 0.0f || 1.0f < f) {
            throw new IllegalArgumentException(String.format("maskWidth value must be higher than %d and less or equal to %d", (byte) 0, (byte) 1));
        }
        this.n = f;
        l();
    }

    public void setShimmerAngle(int i) {
        if (i < -45 || 45 < i) {
            throw new IllegalArgumentException(String.format("shimmerAngle value must be between %d and %d", (byte) -45, (byte) 45));
        }
        this.m = i;
        l();
    }

    public void setShimmerAnimationDuration(int i) {
        this.k = i;
        l();
    }

    public void setShimmerColor(int i) {
        this.l = i;
        l();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i != 0) {
            o();
        } else if (this.j) {
            n();
        }
    }

    public ShimmerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShimmerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setWillNotDraw(false);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, nx3.ShimmerLayout, 0, 0);
        try {
            this.m = typedArrayObtainStyledAttributes.getInteger(nx3.ShimmerLayout_shimmer_angle, 20);
            this.k = typedArrayObtainStyledAttributes.getInteger(nx3.ShimmerLayout_shimmer_animation_duration, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
            this.l = typedArrayObtainStyledAttributes.getColor(nx3.ShimmerLayout_shimmer_color, i(mx3.shimmer_color));
            this.j = typedArrayObtainStyledAttributes.getBoolean(nx3.ShimmerLayout_shimmer_auto_start, false);
            this.n = typedArrayObtainStyledAttributes.getFloat(nx3.ShimmerLayout_shimmer_mask_width, 0.5f);
            this.o = typedArrayObtainStyledAttributes.getFloat(nx3.ShimmerLayout_shimmer_gradient_center_color_width, 0.1f);
            this.h = typedArrayObtainStyledAttributes.getBoolean(nx3.ShimmerLayout_shimmer_reverse_animation, false);
            typedArrayObtainStyledAttributes.recycle();
            setMaskWidth(this.n);
            setGradientCenterColorWidth(this.o);
            setShimmerAngle(this.m);
            if (this.j && getVisibility() == 0) {
                n();
            }
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }
}
