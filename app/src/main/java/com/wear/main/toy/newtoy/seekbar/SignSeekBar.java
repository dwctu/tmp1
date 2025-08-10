package com.wear.main.toy.newtoy.seekbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Html;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.content.ContextCompat;
import com.lovense.wear.R;
import dc.ak2;
import dc.bk2;
import dc.vi1;
import java.math.BigDecimal;
import java.text.NumberFormat;

/* loaded from: classes3.dex */
public class SignSeekBar extends View {
    public int A;
    public Path A0;
    public boolean B;
    public String B0;
    public int C;
    public boolean C0;
    public int D;
    public TextPaint D0;
    public int E;
    public NumberFormat E0;
    public int F;
    public g F0;
    public int G;
    public float G0;
    public int K;
    public int L;
    public float M;
    public float N;
    public float O;
    public float P;
    public float Q;
    public boolean R;
    public int S;
    public boolean T;
    public f U;
    public float V;
    public float W;
    public float a;
    public Paint a0;
    public float b;
    public Rect b0;
    public float c;
    public boolean c0;
    public boolean d;
    public float d0;
    public int e;
    public ak2 e0;
    public int f;
    public String[] f0;
    public int g;
    public boolean g0;
    public int h;
    public float h0;
    public int i;
    public float i0;
    public int j;
    public boolean j0;
    public int k;
    public boolean k0;
    public int l;
    public boolean l0;
    public boolean m;
    public boolean m0;
    public boolean n;
    public Rect n0;
    public boolean o;
    public RectF o0;
    public int p;
    public int p0;
    public int q;
    public int q0;
    public int r;
    public int r0;
    public int s;
    public int s0;
    public boolean t;
    public Point t0;
    public int u;
    public Point u0;
    public int v;
    public Point v0;
    public boolean w;
    public Paint w0;
    public boolean x;
    public Paint x0;
    public boolean y;
    public StaticLayout y0;
    public long z;
    public Path z0;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SignSeekBar.this.requestLayout();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SignSeekBar.this.c0 = false;
            SignSeekBar.this.l();
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            SignSeekBar.this.R = false;
            SignSeekBar.this.invalidate();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SignSeekBar.this.R = false;
            SignSeekBar.this.invalidate();
            if (SignSeekBar.this.U != null) {
                f fVar = SignSeekBar.this.U;
                SignSeekBar signSeekBar = SignSeekBar.this;
                fVar.c(signSeekBar, signSeekBar.getProgress(), SignSeekBar.this.getProgressFloat(), true);
                f fVar2 = SignSeekBar.this.U;
                SignSeekBar signSeekBar2 = SignSeekBar.this;
                fVar2.a(signSeekBar2, signSeekBar2.getProgress(), SignSeekBar.this.getProgressFloat(), true);
            }
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SignSeekBar.this.O = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SignSeekBar signSeekBar = SignSeekBar.this;
            signSeekBar.c = (((signSeekBar.O - SignSeekBar.this.V) * SignSeekBar.this.M) / SignSeekBar.this.P) + SignSeekBar.this.a;
            SignSeekBar.this.invalidate();
            if (SignSeekBar.this.U != null) {
                f fVar = SignSeekBar.this.U;
                SignSeekBar signSeekBar2 = SignSeekBar.this;
                fVar.c(signSeekBar2, signSeekBar2.getProgress(), SignSeekBar.this.getProgressFloat(), true);
            }
        }
    }

    public class e extends AnimatorListenerAdapter {
        public e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            SignSeekBar signSeekBar = SignSeekBar.this;
            signSeekBar.c = (((signSeekBar.O - SignSeekBar.this.V) * SignSeekBar.this.M) / SignSeekBar.this.P) + SignSeekBar.this.a;
            SignSeekBar.this.R = false;
            SignSeekBar.this.c0 = true;
            SignSeekBar.this.invalidate();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SignSeekBar signSeekBar = SignSeekBar.this;
            signSeekBar.c = (((signSeekBar.O - SignSeekBar.this.V) * SignSeekBar.this.M) / SignSeekBar.this.P) + SignSeekBar.this.a;
            SignSeekBar.this.R = false;
            SignSeekBar.this.c0 = true;
            SignSeekBar.this.invalidate();
            if (SignSeekBar.this.U != null) {
                f fVar = SignSeekBar.this.U;
                SignSeekBar signSeekBar2 = SignSeekBar.this;
                fVar.a(signSeekBar2, signSeekBar2.getProgress(), SignSeekBar.this.getProgressFloat(), true);
            }
        }
    }

    public interface f {
        void a(SignSeekBar signSeekBar, int i, float f, boolean z);

        void b(SignSeekBar signSeekBar, int i, float f);

        void c(SignSeekBar signSeekBar, int i, float f, boolean z);
    }

    public interface g {
        String a(float f);
    }

    public SignSeekBar(Context context) {
        this(context, null);
    }

    private String getMaxText() {
        return this.d ? u(this.b) : String.valueOf((int) this.b);
    }

    private String getMinText() {
        return this.d ? u(this.a) : String.valueOf((int) this.a);
    }

    public final boolean A(MotionEvent motionEvent) {
        return isEnabled() && motionEvent.getX() >= ((float) getPaddingLeft()) && motionEvent.getX() <= ((float) (getMeasuredWidth() - getPaddingRight())) && motionEvent.getY() >= ((float) getPaddingTop()) && motionEvent.getY() <= ((float) (getMeasuredHeight() - getPaddingBottom()));
    }

    public ak2 getConfigBuilder() {
        if (this.e0 == null) {
            this.e0 = new ak2(this);
        }
        ak2 ak2Var = this.e0;
        ak2Var.a = this.a;
        ak2Var.b = this.b;
        ak2Var.c = this.c;
        ak2Var.d = this.d;
        ak2Var.e = this.e;
        ak2Var.f = this.f;
        ak2Var.g = this.g;
        ak2Var.h = this.h;
        ak2Var.i = this.i;
        ak2Var.j = this.j;
        ak2Var.k = this.k;
        ak2Var.l = this.l;
        ak2Var.m = this.m;
        ak2Var.n = this.n;
        ak2Var.o = this.o;
        ak2Var.p = this.p;
        ak2Var.q = this.q;
        ak2Var.r = this.r;
        ak2Var.s = this.s;
        ak2Var.t = this.t;
        ak2Var.u = this.u;
        ak2Var.v = this.v;
        ak2Var.w = this.w;
        ak2Var.x = this.z;
        ak2Var.y = this.x;
        ak2 ak2Var2 = this.e0;
        ak2Var2.z = this.y;
        ak2Var2.F = this.f0;
        ak2Var2.G = this.h0;
        ak2Var2.H = this.i0;
        ak2Var2.I = this.j0;
        ak2Var2.K = this.B0;
        ak2Var2.V = this.C0;
        ak2Var2.U = this.E0;
        ak2Var2.A = this.E;
        ak2Var2.B = this.F;
        ak2Var2.C = this.G;
        ak2Var2.D = this.k0;
        ak2Var2.E = this.l0;
        ak2Var2.L = this.p0;
        ak2Var2.M = this.q0;
        ak2Var2.N = this.r0;
        ak2Var2.O = this.K;
        ak2Var2.P = this.L;
        ak2Var2.R = this.B;
        ak2Var2.Q = this.A;
        ak2Var2.T = this.C;
        ak2Var2.S = this.m0;
        return ak2Var2;
    }

    public float getMax() {
        return this.b;
    }

    public float getMin() {
        return this.a;
    }

    public int getProgress() {
        if (!this.y || !this.T) {
            return Math.round(this.c);
        }
        float f2 = this.N;
        float f3 = f2 / 2.0f;
        float f4 = this.c;
        float f5 = this.d0;
        if (f4 >= f5) {
            if (f4 < f3 + f5) {
                return Math.round(f5);
            }
            float f6 = f5 + f2;
            this.d0 = f6;
            return Math.round(f6);
        }
        if (f4 >= f5 - f3) {
            return Math.round(f5);
        }
        float f7 = f5 - f2;
        this.d0 = f7;
        return Math.round(f7);
    }

    public float getProgressFloat() {
        return v(this.c);
    }

    public final void l() {
        float f2 = 0.0f;
        int i = 0;
        while (i <= this.l) {
            float f3 = this.Q;
            f2 = (i * f3) + this.V;
            float f4 = this.O;
            if (f2 <= f4 && f4 - f2 <= f3) {
                break;
            } else {
                i++;
            }
        }
        boolean z = BigDecimal.valueOf((double) this.O).setScale(1, 4).floatValue() == f2;
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator valueAnimatorOfFloat = null;
        if (!z) {
            float f5 = this.O;
            float f6 = f5 - f2;
            float f7 = this.Q;
            valueAnimatorOfFloat = f6 <= f7 / 2.0f ? ValueAnimator.ofFloat(f5, f2) : ValueAnimator.ofFloat(f5, ((i + 1) * f7) + this.V);
            valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new d());
        }
        if (!z) {
            animatorSet.setDuration(this.z).playTogether(valueAnimatorOfFloat);
        }
        animatorSet.addListener(new e());
        animatorSet.start();
    }

    public void m(ak2 ak2Var) {
        this.a = ak2Var.a;
        this.b = ak2Var.b;
        this.c = ak2Var.c;
        this.d = ak2Var.d;
        this.e = ak2Var.e;
        this.f = ak2Var.f;
        this.g = ak2Var.g;
        this.h = ak2Var.h;
        this.i = ak2Var.i;
        this.j = ak2Var.j;
        this.k = ak2Var.k;
        this.l = ak2Var.l;
        this.m = ak2Var.m;
        this.n = ak2Var.n;
        this.o = ak2Var.o;
        this.p = ak2Var.p;
        this.q = ak2Var.q;
        this.r = ak2Var.r;
        this.s = ak2Var.s;
        this.t = ak2Var.t;
        this.u = ak2Var.u;
        this.v = ak2Var.v;
        this.w = ak2Var.w;
        this.z = ak2Var.x;
        this.x = ak2Var.y;
        this.y = ak2Var.z;
        ak2 ak2Var2 = this.e0;
        String[] strArr = ak2Var2.F;
        this.f0 = strArr;
        this.g0 = strArr != null && strArr.length > 0;
        this.h0 = ak2Var2.G;
        this.i0 = ak2Var2.H;
        this.j0 = ak2Var2.I;
        this.B0 = ak2Var2.K;
        this.C0 = ak2Var2.V;
        this.E0 = ak2Var2.U;
        this.E = ak2Var.A;
        this.F = ak2Var.B;
        this.G = ak2Var.C;
        this.k0 = ak2Var.D;
        this.l0 = ak2Var.E;
        this.q0 = ak2Var.M;
        this.p0 = ak2Var.L;
        this.r0 = ak2Var.N;
        this.K = ak2Var.O;
        this.L = ak2Var.P;
        this.B = ak2Var.R;
        this.A = ak2Var.Q;
        this.C = ak2Var.T;
        this.m0 = ak2Var.S;
        x();
        y();
        n();
        f fVar = this.U;
        if (fVar != null) {
            fVar.c(this, getProgress(), getProgressFloat(), false);
            this.U.a(this, getProgress(), getProgressFloat(), false);
        }
        this.e0 = null;
        requestLayout();
    }

    public final void n() {
        String strValueOf;
        String str;
        if (this.w) {
            float progressFloat = getProgressFloat();
            strValueOf = String.valueOf(progressFloat);
            NumberFormat numberFormat = this.E0;
            if (numberFormat != null) {
                strValueOf = numberFormat.format(progressFloat);
            }
        } else {
            int progress = getProgress();
            strValueOf = String.valueOf(progress);
            NumberFormat numberFormat2 = this.E0;
            if (numberFormat2 != null) {
                strValueOf = numberFormat2.format(progress);
            }
        }
        g gVar = this.F0;
        if (gVar != null) {
            strValueOf = gVar.a(Float.parseFloat(strValueOf));
        } else if (strValueOf != null && (str = this.B0) != null && !str.isEmpty()) {
            if (this.C0) {
                strValueOf = String.format(" %s ", this.B0) + strValueOf;
            } else {
                strValueOf = strValueOf + String.format("%s", this.B0);
            }
        }
        this.y0 = new StaticLayout(Html.fromHtml(strValueOf + "%"), this.D0, this.L, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void o(android.graphics.Canvas r15, float r16, float r17, boolean r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.main.toy.newtoy.seekbar.SignSeekBar.o(android.graphics.Canvas, float, float, boolean, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0118  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onDraw(android.graphics.Canvas r13) {
        /*
            Method dump skipped, instructions count: 515
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.main.toy.newtoy.seekbar.SignSeekBar.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        String maxText;
        super.onMeasure(i, i2);
        int iMax = this.h * 2;
        if (this.t) {
            this.a0.setTextSize(this.u);
            this.a0.getTextBounds("j", 0, 1, this.b0);
            iMax += this.b0.height() + this.S;
        }
        if (this.o && this.r >= 1) {
            String str = this.g0 ? this.f0[0] : "j";
            this.a0.setTextSize(this.p);
            this.a0.getTextBounds(str, 0, str.length(), this.b0);
            iMax = Math.max(iMax, (this.h * 2) + this.b0.height() + this.S);
        }
        int i3 = iMax + this.K;
        if (this.B) {
            i3 += this.A;
        }
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i), i3);
        this.V = getPaddingLeft() + this.h;
        this.W = (getMeasuredWidth() - getPaddingRight()) - this.h;
        if (this.o) {
            this.a0.setTextSize(this.p);
            int i4 = this.r;
            if (i4 == 0) {
                String minText = getMinText();
                this.a0.getTextBounds(minText, 0, minText.length(), this.b0);
                this.V += this.b0.width() + this.S;
                String maxText2 = getMaxText();
                this.a0.getTextBounds(maxText2, 0, maxText2.length(), this.b0);
                this.W -= this.b0.width() + this.S;
            } else if (i4 >= 1) {
                String minText2 = this.g0 ? this.f0[0] : getMinText();
                this.a0.getTextBounds(minText2, 0, minText2.length(), this.b0);
                this.V = getPaddingLeft() + Math.max(this.h, this.b0.width() / 2.0f) + this.S;
                if (this.g0) {
                    String[] strArr = this.f0;
                    maxText = strArr[strArr.length - 1];
                } else {
                    maxText = getMaxText();
                }
                this.a0.getTextBounds(maxText, 0, maxText.length(), this.b0);
                this.W = ((getMeasuredWidth() - getPaddingRight()) - Math.max(this.h, this.b0.width() / 2.0f)) - this.S;
            }
        } else if (this.t && this.r == -1) {
            this.a0.setTextSize(this.u);
            String minText3 = getMinText();
            this.a0.getTextBounds(minText3, 0, minText3.length(), this.b0);
            this.V = getPaddingLeft() + Math.max(this.h, this.b0.width() / 2.0f) + this.S;
            String maxText3 = getMaxText();
            this.a0.getTextBounds(maxText3, 0, maxText3.length(), this.b0);
            this.W = ((getMeasuredWidth() - getPaddingRight()) - Math.max(this.h, this.b0.width() / 2.0f)) - this.S;
        }
        if (this.k0 && !this.m0) {
            this.V = Math.max(this.V, getPaddingLeft() + (this.L / 2) + this.A);
            this.W = Math.min(this.W, ((getMeasuredWidth() - getPaddingRight()) - (this.L / 2)) - this.A);
        }
        float f2 = this.W - this.V;
        this.P = f2;
        this.Q = (f2 * 1.0f) / this.l;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.c = bundle.getFloat("progress");
        super.onRestoreInstanceState(bundle.getParcelable("save_instance"));
        setProgress(this.c);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("save_instance", super.onSaveInstanceState());
        bundle.putFloat("progress", this.c);
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        post(new a());
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.main.toy.newtoy.seekbar.SignSeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void p(Canvas canvas, String str, float f2, float f3, Paint paint) {
        canvas.drawText(str, f2, f3, paint);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0047, code lost:
    
        if (r12 != r10.b) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void q(android.graphics.Canvas r11, float r12) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.main.toy.newtoy.seekbar.SignSeekBar.q(android.graphics.Canvas, float):void");
    }

    public final void r(Canvas canvas, Point point, Point point2, Point point3, Paint paint) {
        this.z0.reset();
        this.z0.moveTo(point.x, point.y);
        this.z0.lineTo(point2.x, point2.y);
        this.z0.lineTo(point3.x, point3.y);
        this.z0.lineTo(point.x, point.y);
        this.z0.close();
        canvas.drawPath(this.z0, paint);
    }

    public final void s(Canvas canvas, Point point, Point point2, Point point3, Paint paint) {
        this.A0.reset();
        this.A0.moveTo(point.x, point.y);
        this.A0.lineTo(point2.x, point2.y);
        paint.setColor(this.w0.getColor());
        int i = this.A;
        float f2 = i / 6;
        paint.setStrokeWidth(i + 1.0f);
        canvas.drawPath(this.A0, paint);
        this.A0.reset();
        paint.setStrokeWidth(this.A);
        this.A0.moveTo(point.x - f2, point.y - f2);
        this.A0.lineTo(point3.x, point3.y);
        this.A0.lineTo(point2.x + f2, point2.y - f2);
        paint.setColor(this.C);
        canvas.drawPath(this.A0, paint);
    }

    public void setOnProgressChangedListener(f fVar) {
        this.U = fVar;
    }

    public void setProgress(float f2) {
        this.c = f2;
        f fVar = this.U;
        if (fVar != null) {
            fVar.c(this, getProgress(), getProgressFloat(), false);
            this.U.a(this, getProgress(), getProgressFloat(), false);
        }
        postInvalidate();
    }

    public void setProgressWithUnit(float f2, String str) {
        setProgress(f2);
        this.B0 = str;
        n();
        invalidate();
        requestLayout();
    }

    public void setUnit(String str) {
        this.B0 = str;
        n();
        invalidate();
        requestLayout();
    }

    public void setValueFormatListener(g gVar) {
        this.F0 = gVar;
    }

    public final void t(Canvas canvas, int i, int i2) {
        if (this.k0) {
            if (!this.l0 || this.R) {
                this.n0.set(i2 - (this.L / 2), getPaddingTop(), (this.L / 2) + i2, (this.K - this.p0) + getPaddingTop());
                int measuredWidth = 0;
                int i3 = this.B ? this.A : 0;
                if (this.n0.left < getPaddingLeft()) {
                    int paddingLeft = (-this.n0.left) + getPaddingLeft() + i3;
                    RectF rectF = this.o0;
                    Rect rect = this.n0;
                    rectF.set(rect.left + paddingLeft, rect.top, rect.right + paddingLeft, rect.bottom);
                } else if (this.n0.right > getMeasuredWidth() - getPaddingRight()) {
                    int measuredWidth2 = (this.n0.right - getMeasuredWidth()) + getPaddingRight() + i3;
                    RectF rectF2 = this.o0;
                    Rect rect2 = this.n0;
                    rectF2.set(rect2.left - measuredWidth2, rect2.top, rect2.right - measuredWidth2, rect2.bottom);
                } else {
                    RectF rectF3 = this.o0;
                    Rect rect3 = this.n0;
                    rectF3.set(rect3.left, rect3.top, rect3.right, rect3.bottom);
                }
                RectF rectF4 = this.o0;
                int i4 = this.r0;
                canvas.drawRoundRect(rectF4, i4, i4, this.w0);
                if (this.B) {
                    RectF rectF5 = this.o0;
                    rectF5.top += this.A / 2;
                    int i5 = this.r0;
                    canvas.drawRoundRect(rectF5, i5, i5, this.x0);
                }
                int i6 = this.R ? this.h : this.g;
                this.s0 = i6;
                if (i2 - (this.q0 / 2) < i6 + getPaddingLeft() + this.S + i3) {
                    measuredWidth = (this.s0 - i2) + getPaddingLeft() + i3 + this.S;
                } else if ((this.q0 / 2) + i2 > (((getMeasuredWidth() - this.s0) - getPaddingRight()) - this.S) - i3) {
                    measuredWidth = ((((getMeasuredWidth() - this.s0) - i2) - getPaddingRight()) - i3) - this.S;
                }
                this.t0.set((i2 - (this.q0 / 2)) + measuredWidth, (i - this.p0) + getPaddingTop());
                this.u0.set((this.q0 / 2) + i2 + measuredWidth, (i - this.p0) + getPaddingTop());
                this.v0.set(i2 + measuredWidth, i + getPaddingTop());
                r(canvas, this.t0, this.u0, this.v0, this.w0);
                if (this.B) {
                    s(canvas, this.t0, this.u0, this.v0, this.x0);
                }
                n();
                if (this.y0 != null) {
                    RectF rectF6 = this.o0;
                    canvas.translate(rectF6.left, (rectF6.top + (rectF6.height() / 2.0f)) - (this.y0.getHeight() / 2));
                    this.y0.draw(canvas);
                }
            }
        }
    }

    public final String u(float f2) {
        return String.valueOf(v(f2));
    }

    public final float v(float f2) {
        return BigDecimal.valueOf(f2).setScale(1, 4).floatValue();
    }

    public int w(int i, float f2) {
        return Color.argb(Math.round(Color.alpha(i) * f2), Color.red(i), Color.green(i), Color.blue(i));
    }

    public final void x() {
        Paint paint = new Paint(1);
        this.w0 = paint;
        paint.setStyle(Paint.Style.FILL);
        this.w0.setAntiAlias(true);
        this.w0.setColor(this.E);
        Paint paint2 = new Paint(1);
        this.x0 = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.x0.setStrokeWidth(this.A);
        this.x0.setColor(this.C);
        this.x0.setAntiAlias(true);
        TextPaint textPaint = new TextPaint(1);
        this.D0 = textPaint;
        textPaint.setStyle(Paint.Style.FILL);
        this.D0.setTextSize(this.F);
        this.D0.setColor(this.G);
    }

    public final void y() {
        if (this.a == this.b) {
            this.a = 0.0f;
            this.b = 100.0f;
        }
        float f2 = this.a;
        float f3 = this.b;
        if (f2 > f3) {
            this.b = f2;
            this.a = f3;
        }
        float f4 = this.c;
        float f5 = this.a;
        if (f4 < f5) {
            this.c = f5;
        }
        float f6 = this.c;
        float f7 = this.b;
        if (f6 > f7) {
            this.c = f7;
        }
        int i = this.f;
        int i2 = this.e;
        if (i < i2) {
            this.f = i2 + bk2.a(2);
        }
        int i3 = this.g;
        int i4 = this.f;
        if (i3 <= i4) {
            this.g = i4 + bk2.a(2);
        }
        int i5 = this.h;
        int i6 = this.f;
        if (i5 <= i6) {
            this.h = i6 * 2;
        }
        if (this.l <= 0) {
            this.l = 10;
        }
        float f8 = this.b;
        float f9 = this.a;
        float f10 = f8 - f9;
        this.M = f10;
        float f11 = f10 / this.l;
        this.N = f11;
        if (f11 < 1.0f) {
            this.d = true;
        }
        if (this.d) {
            this.w = true;
        }
        int i7 = this.r;
        if (i7 != -1) {
            this.o = true;
        }
        if (this.o) {
            if (i7 == -1) {
                this.r = 0;
            }
            if (this.r == 2) {
                this.m = true;
            }
        }
        if (this.s < 1) {
            this.s = 1;
        }
        if (this.n && !this.m) {
            this.n = false;
        }
        if (this.y) {
            this.d0 = f9;
            if (this.c != f9) {
                this.d0 = f11;
            }
            this.m = true;
            this.n = true;
            this.x = false;
        }
        setProgress(this.c);
        this.u = (this.d || this.y || (this.o && this.r == 2)) ? this.p : this.u;
    }

    public final boolean z(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float f2 = this.R ? this.h : this.g;
        float f3 = ((this.P / this.M) * (this.c - this.a)) + this.V;
        float measuredHeight = getMeasuredHeight() / 2.0f;
        float x = ((motionEvent.getX() - f3) * (motionEvent.getX() - f3)) + ((motionEvent.getY() - measuredHeight) * (motionEvent.getY() - measuredHeight));
        float f4 = this.V;
        return x <= (f4 + f2) * (f4 + f2);
    }

    public SignSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.r = -1;
        this.c0 = true;
        this.s0 = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vi1.SignSeekBar, i, 0);
        this.a = typedArrayObtainStyledAttributes.getFloat(4, 0.0f);
        this.b = typedArrayObtainStyledAttributes.getFloat(3, 100.0f);
        this.c = typedArrayObtainStyledAttributes.getFloat(5, this.a);
        this.d = typedArrayObtainStyledAttributes.getBoolean(2, false);
        this.e = typedArrayObtainStyledAttributes.getDimensionPixelSize(44, bk2.a(2));
        this.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(34, bk2.a(2));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, this.e + bk2.a(2));
        this.f = dimensionPixelSize;
        this.g = typedArrayObtainStyledAttributes.getDimensionPixelSize(37, dimensionPixelSize + bk2.a(2));
        this.h = typedArrayObtainStyledAttributes.getDimensionPixelSize(37, this.f * 2);
        this.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(26, bk2.a(1));
        this.l = typedArrayObtainStyledAttributes.getInteger(8, 10);
        this.i = typedArrayObtainStyledAttributes.getColor(43, ContextCompat.getColor(context, R.color.colorPrimary));
        int color = typedArrayObtainStyledAttributes.getColor(6, ContextCompat.getColor(context, R.color.colorAccent));
        this.j = color;
        this.k = typedArrayObtainStyledAttributes.getColor(36, color);
        this.o = typedArrayObtainStyledAttributes.getBoolean(16, false);
        this.p = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, bk2.b(14));
        this.q = typedArrayObtainStyledAttributes.getColor(9, this.i);
        this.y = typedArrayObtainStyledAttributes.getBoolean(13, false);
        int integer = typedArrayObtainStyledAttributes.getInteger(11, -1);
        if (integer == 0) {
            this.r = 0;
        } else if (integer == 1) {
            this.r = 1;
        } else if (integer == 2) {
            this.r = 2;
        } else {
            this.r = -1;
        }
        this.s = typedArrayObtainStyledAttributes.getInteger(10, 1);
        this.t = typedArrayObtainStyledAttributes.getBoolean(20, false);
        this.u = typedArrayObtainStyledAttributes.getDimensionPixelSize(41, bk2.b(14));
        this.v = typedArrayObtainStyledAttributes.getColor(40, this.j);
        this.E = typedArrayObtainStyledAttributes.getColor(27, this.j);
        this.C = typedArrayObtainStyledAttributes.getColor(25, this.j);
        this.D = typedArrayObtainStyledAttributes.getColor(45, -7829368);
        this.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(32, bk2.b(14));
        this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(28, bk2.a(32));
        this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(33, bk2.a(72));
        this.p0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(23, bk2.a(3));
        this.q0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(24, bk2.a(5));
        this.r0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(29, bk2.a(3));
        this.G = typedArrayObtainStyledAttributes.getColor(31, -1);
        this.m = typedArrayObtainStyledAttributes.getBoolean(15, false);
        this.n = typedArrayObtainStyledAttributes.getBoolean(1, false);
        this.w = typedArrayObtainStyledAttributes.getBoolean(14, false);
        int integer2 = typedArrayObtainStyledAttributes.getInteger(0, -1);
        this.z = integer2 < 0 ? 200L : integer2;
        this.x = typedArrayObtainStyledAttributes.getBoolean(42, false);
        this.B = typedArrayObtainStyledAttributes.getBoolean(30, false);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(21, 0);
        this.h0 = typedArrayObtainStyledAttributes.getFloat(35, 0.2f);
        this.i0 = typedArrayObtainStyledAttributes.getFloat(39, 0.7f);
        this.j0 = typedArrayObtainStyledAttributes.getBoolean(19, false);
        this.k0 = typedArrayObtainStyledAttributes.getBoolean(17, false);
        this.l0 = typedArrayObtainStyledAttributes.getBoolean(18, false);
        this.m0 = typedArrayObtainStyledAttributes.getBoolean(22, true);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.a0 = paint;
        paint.setAntiAlias(true);
        this.a0.setStrokeCap(Paint.Cap.ROUND);
        this.a0.setTextAlign(Paint.Align.CENTER);
        this.b0 = new Rect();
        if (resourceId > 0) {
            this.f0 = getResources().getStringArray(resourceId);
        }
        String[] strArr = this.f0;
        this.g0 = strArr != null && strArr.length > 0;
        this.o0 = new RectF();
        this.n0 = new Rect();
        this.t0 = new Point();
        this.u0 = new Point();
        this.v0 = new Point();
        Path path = new Path();
        this.z0 = path;
        path.setFillType(Path.FillType.EVEN_ODD);
        this.A0 = new Path();
        x();
        y();
    }
}
