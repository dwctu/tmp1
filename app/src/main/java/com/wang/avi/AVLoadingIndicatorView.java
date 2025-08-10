package com.wang.avi;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import dc.oi1;
import dc.pi1;
import dc.qi1;
import dc.ri1;

/* loaded from: classes3.dex */
public class AVLoadingIndicatorView extends View {
    public static final ri1 n = new ri1();
    public long a;
    public boolean b;
    public boolean c;
    public boolean d;
    public final Runnable e;
    public final Runnable f;
    public int g;
    public int h;
    public int i;
    public int j;
    public oi1 k;
    public int l;
    public boolean m;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AVLoadingIndicatorView.this.b = false;
            AVLoadingIndicatorView.this.a = -1L;
            AVLoadingIndicatorView.this.setVisibility(8);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AVLoadingIndicatorView.this.c = false;
            if (AVLoadingIndicatorView.this.d) {
                return;
            }
            AVLoadingIndicatorView.this.a = System.currentTimeMillis();
            AVLoadingIndicatorView.this.setVisibility(0);
        }
    }

    public AVLoadingIndicatorView(Context context) {
        super(context);
        this.d = false;
        this.e = new a();
        this.f = new b();
        f(context, null, 0, 0);
    }

    @Override // android.view.View
    @TargetApi(21)
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        oi1 oi1Var = this.k;
        if (oi1Var != null) {
            oi1Var.setHotspot(f, f2);
        }
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        k();
    }

    public void e(Canvas canvas) {
        oi1 oi1Var = this.k;
        if (oi1Var != null) {
            int iSave = canvas.save();
            canvas.translate(getPaddingLeft(), getPaddingTop());
            oi1Var.draw(canvas);
            canvas.restoreToCount(iSave);
            if (this.m && (oi1Var instanceof Animatable)) {
                oi1Var.start();
                this.m = false;
            }
        }
    }

    public final void f(Context context, AttributeSet attributeSet, int i, int i2) {
        this.g = 24;
        this.h = 48;
        this.i = 24;
        this.j = 48;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, qi1.AVLoadingIndicatorView, i, i2);
        this.g = typedArrayObtainStyledAttributes.getDimensionPixelSize(qi1.AVLoadingIndicatorView_minWidth, this.g);
        this.h = typedArrayObtainStyledAttributes.getDimensionPixelSize(qi1.AVLoadingIndicatorView_maxWidth, this.h);
        this.i = typedArrayObtainStyledAttributes.getDimensionPixelSize(qi1.AVLoadingIndicatorView_minHeight, this.i);
        this.j = typedArrayObtainStyledAttributes.getDimensionPixelSize(qi1.AVLoadingIndicatorView_maxHeight, this.j);
        String string = typedArrayObtainStyledAttributes.getString(qi1.AVLoadingIndicatorView_indicatorName);
        this.l = typedArrayObtainStyledAttributes.getColor(qi1.AVLoadingIndicatorView_indicatorColor, -1);
        setIndicator(string);
        if (this.k == null) {
            setIndicator(n);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void g() {
        removeCallbacks(this.e);
        removeCallbacks(this.f);
    }

    public oi1 getIndicator() {
        return this.k;
    }

    public void h() {
        if (getVisibility() != 0) {
            return;
        }
        if (this.k instanceof Animatable) {
            this.m = true;
        }
        postInvalidate();
    }

    public void i() {
        oi1 oi1Var = this.k;
        if (oi1Var instanceof Animatable) {
            oi1Var.stop();
            this.m = false;
        }
        postInvalidate();
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        if (!verifyDrawable(drawable)) {
            super.invalidateDrawable(drawable);
            return;
        }
        Rect bounds = drawable.getBounds();
        int scrollX = getScrollX() + getPaddingLeft();
        int scrollY = getScrollY() + getPaddingTop();
        invalidate(bounds.left + scrollX, bounds.top + scrollY, bounds.right + scrollX, bounds.bottom + scrollY);
    }

    public final void j(int i, int i2) {
        int i3;
        int paddingRight = i - (getPaddingRight() + getPaddingLeft());
        int paddingTop = i2 - (getPaddingTop() + getPaddingBottom());
        if (this.k != null) {
            float intrinsicWidth = r0.getIntrinsicWidth() / this.k.getIntrinsicHeight();
            float f = paddingRight;
            float f2 = paddingTop;
            float f3 = f / f2;
            int i4 = 0;
            if (intrinsicWidth == f3) {
                i3 = 0;
            } else if (f3 > intrinsicWidth) {
                int i5 = (int) (f2 * intrinsicWidth);
                int i6 = (paddingRight - i5) / 2;
                i4 = i6;
                paddingRight = i5 + i6;
                i3 = 0;
            } else {
                int i7 = (int) (f * (1.0f / intrinsicWidth));
                int i8 = (paddingTop - i7) / 2;
                int i9 = i7 + i8;
                i3 = i8;
                paddingTop = i9;
            }
            this.k.setBounds(i4, i3, paddingRight, paddingTop);
        }
    }

    public final void k() {
        int[] drawableState = getDrawableState();
        oi1 oi1Var = this.k;
        if (oi1Var == null || !oi1Var.isStateful()) {
            return;
        }
        this.k.setState(drawableState);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
        g();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        i();
        super.onDetachedFromWindow();
        g();
    }

    @Override // android.view.View
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        e(canvas);
    }

    @Override // android.view.View
    public synchronized void onMeasure(int i, int i2) {
        int iMax;
        int iMax2;
        oi1 oi1Var = this.k;
        if (oi1Var != null) {
            iMax2 = Math.max(this.g, Math.min(this.h, oi1Var.getIntrinsicWidth()));
            iMax = Math.max(this.i, Math.min(this.j, oi1Var.getIntrinsicHeight()));
        } else {
            iMax = 0;
            iMax2 = 0;
        }
        k();
        setMeasuredDimension(View.resolveSizeAndState(iMax2 + getPaddingLeft() + getPaddingRight(), i, 0), View.resolveSizeAndState(iMax + getPaddingTop() + getPaddingBottom(), i2, 0));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        j(i, i2);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 8 || i == 4) {
            i();
        } else {
            h();
        }
    }

    public void setIndicator(oi1 oi1Var) {
        oi1 oi1Var2 = this.k;
        if (oi1Var2 != oi1Var) {
            if (oi1Var2 != null) {
                oi1Var2.setCallback(null);
                unscheduleDrawable(this.k);
            }
            this.k = oi1Var;
            setIndicatorColor(this.l);
            if (oi1Var != null) {
                oi1Var.setCallback(this);
            }
            postInvalidate();
        }
    }

    public void setIndicatorColor(int i) {
        this.l = i;
        this.k.i(i);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (getVisibility() != i) {
            super.setVisibility(i);
            if (i == 8 || i == 4) {
                i();
            } else {
                h();
            }
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.k || super.verifyDrawable(drawable);
    }

    public AVLoadingIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = false;
        this.e = new a();
        this.f = new b();
        f(context, attributeSet, 0, pi1.AVLoadingIndicatorView);
    }

    public void setIndicator(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (!str.contains(".")) {
            sb.append(getClass().getPackage().getName());
            sb.append(".indicators");
            sb.append(".");
        }
        sb.append(str);
        try {
            setIndicator((oi1) Class.forName(sb.toString()).newInstance());
        } catch (ClassNotFoundException unused) {
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e2) {
            e2.printStackTrace();
        }
    }

    public AVLoadingIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = false;
        this.e = new a();
        this.f = new b();
        f(context, attributeSet, i, pi1.AVLoadingIndicatorView);
    }
}
