package com.wear.widget.seekbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import dc.at3;
import dc.vi1;
import dc.xs3;
import dc.ys3;
import dc.zs3;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class RangeSeekBar extends View {
    public int A;
    public boolean B;
    public int C;
    public float D;
    public float E;
    public boolean F;
    public float G;
    public float K;
    public boolean L;
    public Paint M;
    public RectF N;
    public RectF O;
    public Rect P;
    public RectF Q;
    public Rect R;
    public ys3 S;
    public ys3 T;
    public ys3 U;
    public Bitmap V;
    public Bitmap W;
    public int a;
    public List<Bitmap> a0;
    public int b;
    public int b0;
    public int c;
    public xs3 c0;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public CharSequence[] m;
    public float n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public float u;
    public int v;
    public int w;
    public float x;
    public float y;
    public float z;

    public RangeSeekBar(Context context) {
        this(context, null);
    }

    private void h(AttributeSet attributeSet) {
        this.S = new ys3(this, attributeSet, true);
        ys3 ys3Var = new ys3(this, attributeSet, false);
        this.T = ys3Var;
        ys3Var.S(this.e != 1);
    }

    public float a(float f) {
        if (this.U == null) {
            return 0.0f;
        }
        float progressLeft = f >= ((float) getProgressLeft()) ? f > ((float) getProgressRight()) ? 1.0f : ((f - getProgressLeft()) * 1.0f) / this.t : 0.0f;
        if (this.e != 2) {
            return progressLeft;
        }
        ys3 ys3Var = this.U;
        ys3 ys3Var2 = this.S;
        if (ys3Var == ys3Var2) {
            float f2 = this.T.x;
            float f3 = this.K;
            return progressLeft > f2 - f3 ? f2 - f3 : progressLeft;
        }
        if (ys3Var != this.T) {
            return progressLeft;
        }
        float f4 = ys3Var2.x;
        float f5 = this.K;
        return progressLeft < f4 + f5 ? f4 + f5 : progressLeft;
    }

    public final void b(boolean z) {
        ys3 ys3Var;
        if (!z || (ys3Var = this.U) == null) {
            this.S.J(false);
            if (this.e == 2) {
                this.T.J(false);
                return;
            }
            return;
        }
        ys3 ys3Var2 = this.S;
        boolean z2 = ys3Var == ys3Var2;
        ys3Var2.J(z2);
        if (this.e == 2) {
            this.T.J(!z2);
        }
    }

    public float c(MotionEvent motionEvent) {
        return motionEvent.getX();
    }

    public float d(MotionEvent motionEvent) {
        return motionEvent.getY();
    }

    public final void e(AttributeSet attributeSet) {
        try {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, vi1.RangeSeekBar);
            this.e = typedArrayObtainStyledAttributes.getInt(18, 2);
            this.D = typedArrayObtainStyledAttributes.getFloat(16, 0.0f);
            this.E = typedArrayObtainStyledAttributes.getFloat(15, 100.0f);
            this.u = typedArrayObtainStyledAttributes.getFloat(17, 0.0f);
            this.v = typedArrayObtainStyledAttributes.getInt(0, 0);
            this.o = typedArrayObtainStyledAttributes.getColor(19, -11806366);
            this.n = (int) typedArrayObtainStyledAttributes.getDimension(24, -1.0f);
            this.p = typedArrayObtainStyledAttributes.getColor(20, -2631721);
            this.q = typedArrayObtainStyledAttributes.getResourceId(21, 0);
            this.r = typedArrayObtainStyledAttributes.getResourceId(22, 0);
            this.s = (int) typedArrayObtainStyledAttributes.getDimension(23, at3.b(getContext(), 2.0f));
            this.f = typedArrayObtainStyledAttributes.getInt(40, 0);
            this.i = typedArrayObtainStyledAttributes.getInt(37, 1);
            this.j = typedArrayObtainStyledAttributes.getInt(39, 0);
            this.m = typedArrayObtainStyledAttributes.getTextArray(42);
            this.g = (int) typedArrayObtainStyledAttributes.getDimension(44, at3.b(getContext(), 7.0f));
            this.h = (int) typedArrayObtainStyledAttributes.getDimension(45, at3.b(getContext(), 12.0f));
            this.k = typedArrayObtainStyledAttributes.getColor(43, this.p);
            this.l = typedArrayObtainStyledAttributes.getColor(38, this.o);
            this.A = typedArrayObtainStyledAttributes.getInt(31, 0);
            this.w = typedArrayObtainStyledAttributes.getColor(26, -6447715);
            this.z = typedArrayObtainStyledAttributes.getDimension(29, 0.0f);
            this.x = typedArrayObtainStyledAttributes.getDimension(30, 0.0f);
            this.y = typedArrayObtainStyledAttributes.getDimension(28, 0.0f);
            this.C = typedArrayObtainStyledAttributes.getResourceId(27, 0);
            this.B = typedArrayObtainStyledAttributes.getBoolean(25, true);
            typedArrayObtainStyledAttributes.recycle();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void f() {
        this.M.setStyle(Paint.Style.FILL);
        this.M.setColor(this.p);
        this.M.setTextSize(this.h);
    }

    public final void g() {
        if (this.V == null) {
            this.V = at3.f(getContext(), this.t, this.s, this.q);
        }
        if (this.W == null) {
            this.W = at3.f(getContext(), this.t, this.s, this.r);
        }
    }

    public int getGravity() {
        return this.v;
    }

    public ys3 getLeftSeekBar() {
        return this.S;
    }

    public float getMaxProgress() {
        return this.E;
    }

    public float getMinInterval() {
        return this.u;
    }

    public float getMinProgress() {
        return this.D;
    }

    public int getProgressBottom() {
        return this.b;
    }

    public int getProgressColor() {
        return this.o;
    }

    public int getProgressDefaultColor() {
        return this.p;
    }

    public int getProgressDefaultDrawableId() {
        return this.r;
    }

    public int getProgressDrawableId() {
        return this.q;
    }

    public int getProgressHeight() {
        return this.s;
    }

    public int getProgressLeft() {
        return this.c;
    }

    public int getProgressPaddingRight() {
        return this.b0;
    }

    public float getProgressRadius() {
        return this.n;
    }

    public int getProgressRight() {
        return this.d;
    }

    public int getProgressTop() {
        return this.a;
    }

    public int getProgressWidth() {
        return this.t;
    }

    public zs3[] getRangeSeekBarState() {
        zs3 zs3Var = new zs3();
        float fS = this.S.s();
        zs3Var.b = fS;
        zs3Var.a = String.valueOf(fS);
        if (at3.a(zs3Var.b, this.D) == 0) {
            zs3Var.c = true;
        } else if (at3.a(zs3Var.b, this.E) == 0) {
            zs3Var.d = true;
        }
        zs3 zs3Var2 = new zs3();
        if (this.e == 2) {
            float fS2 = this.T.s();
            zs3Var2.b = fS2;
            zs3Var2.a = String.valueOf(fS2);
            if (at3.a(this.T.x, this.D) == 0) {
                zs3Var2.c = true;
            } else if (at3.a(this.T.x, this.E) == 0) {
                zs3Var2.d = true;
            }
        }
        return new zs3[]{zs3Var, zs3Var2};
    }

    public float getRawHeight() {
        if (this.e == 1) {
            float fT = this.S.t();
            if (this.j != 1 || this.m == null) {
                return fT;
            }
            return (fT - (this.S.w() / 2.0f)) + (this.s / 2.0f) + Math.max((this.S.w() - this.s) / 2.0f, getTickMarkRawHeight());
        }
        float fMax = Math.max(this.S.t(), this.T.t());
        if (this.j != 1 || this.m == null) {
            return fMax;
        }
        float fMax2 = Math.max(this.S.w(), this.T.w());
        return (fMax - (fMax2 / 2.0f)) + (this.s / 2.0f) + Math.max((fMax2 - this.s) / 2.0f, getTickMarkRawHeight());
    }

    public ys3 getRightSeekBar() {
        return this.T;
    }

    public int getSeekBarMode() {
        return this.e;
    }

    public int getSteps() {
        return this.A;
    }

    public List<Bitmap> getStepsBitmaps() {
        return this.a0;
    }

    public int getStepsColor() {
        return this.w;
    }

    public int getStepsDrawableId() {
        return this.C;
    }

    public float getStepsHeight() {
        return this.y;
    }

    public float getStepsRadius() {
        return this.z;
    }

    public float getStepsWidth() {
        return this.x;
    }

    public int getTickMarkGravity() {
        return this.i;
    }

    public int getTickMarkInRangeTextColor() {
        return this.l;
    }

    public int getTickMarkLayoutGravity() {
        return this.j;
    }

    public int getTickMarkMode() {
        return this.f;
    }

    public int getTickMarkRawHeight() {
        CharSequence[] charSequenceArr = this.m;
        if (charSequenceArr == null || charSequenceArr.length <= 0) {
            return 0;
        }
        return this.g + at3.g(String.valueOf(charSequenceArr[0]), this.h).height() + 3;
    }

    public CharSequence[] getTickMarkTextArray() {
        return this.m;
    }

    public int getTickMarkTextColor() {
        return this.k;
    }

    public int getTickMarkTextMargin() {
        return this.g;
    }

    public int getTickMarkTextSize() {
        return this.h;
    }

    public final void i() {
        if (q() && this.C != 0 && this.a0.isEmpty()) {
            Bitmap bitmapF = at3.f(getContext(), (int) this.x, (int) this.y, this.C);
            for (int i = 0; i <= this.A; i++) {
                this.a0.add(bitmapF);
            }
        }
    }

    public void j(Canvas canvas, Paint paint) {
        if (at3.i(this.W)) {
            canvas.drawBitmap(this.W, (Rect) null, this.N, paint);
        } else {
            paint.setColor(this.p);
            RectF rectF = this.N;
            float f = this.n;
            canvas.drawRoundRect(rectF, f, f, paint);
        }
        if (this.e == 2) {
            this.O.top = getProgressTop();
            this.O.left = r4.t + (this.S.y() / 2.0f) + (this.t * this.S.x);
            this.O.right = r4.t + (this.T.y() / 2.0f) + (this.t * this.T.x);
            this.O.bottom = getProgressBottom();
        } else {
            this.O.top = getProgressTop();
            this.O.left = r4.t + (this.S.y() / 2.0f);
            this.O.right = r4.t + (this.S.y() / 2.0f) + (this.t * this.S.x);
            this.O.bottom = getProgressBottom();
        }
        if (!at3.i(this.V)) {
            paint.setColor(this.o);
            RectF rectF2 = this.O;
            float f2 = this.n;
            canvas.drawRoundRect(rectF2, f2, f2, paint);
            return;
        }
        Rect rect = this.P;
        rect.top = 0;
        rect.bottom = this.V.getHeight();
        int width = this.V.getWidth();
        if (this.e == 2) {
            Rect rect2 = this.P;
            float f3 = width;
            rect2.left = (int) (this.S.x * f3);
            rect2.right = (int) (f3 * this.T.x);
        } else {
            Rect rect3 = this.P;
            rect3.left = 0;
            rect3.right = (int) (width * this.S.x);
        }
        canvas.drawBitmap(this.V, this.P, this.O, (Paint) null);
    }

    public void k(Canvas canvas) {
        if (this.S.o() == 3) {
            this.S.P(true);
        }
        this.S.b(canvas);
        if (this.e == 2) {
            if (this.T.o() == 3) {
                this.T.P(true);
            }
            this.T.b(canvas);
        }
    }

    public void l(Canvas canvas, Paint paint) {
        if (q()) {
            int progressWidth = getProgressWidth() / this.A;
            float progressHeight = (this.y - getProgressHeight()) / 2.0f;
            for (int i = 0; i <= this.A; i++) {
                float progressLeft = (getProgressLeft() + (i * progressWidth)) - (this.x / 2.0f);
                this.Q.set(progressLeft, getProgressTop() - progressHeight, this.x + progressLeft, getProgressBottom() + progressHeight);
                if (this.a0.isEmpty() || this.a0.size() <= i) {
                    paint.setColor(this.w);
                    RectF rectF = this.Q;
                    float f = this.z;
                    canvas.drawRoundRect(rectF, f, f, paint);
                } else {
                    canvas.drawBitmap(this.a0.get(i), (Rect) null, this.Q, paint);
                }
            }
        }
    }

    public void m(Canvas canvas, Paint paint) {
        float fWidth;
        int progressLeft;
        CharSequence[] charSequenceArr = this.m;
        if (charSequenceArr == null) {
            return;
        }
        int length = this.t / (charSequenceArr.length - 1);
        int i = 0;
        while (true) {
            CharSequence[] charSequenceArr2 = this.m;
            if (i >= charSequenceArr2.length) {
                return;
            }
            String string = charSequenceArr2[i].toString();
            if (!TextUtils.isEmpty(string)) {
                paint.getTextBounds(string, 0, string.length(), this.R);
                paint.setColor(this.k);
                if (this.f == 1) {
                    int i2 = this.i;
                    if (i2 == 2) {
                        progressLeft = (getProgressLeft() + (i * length)) - this.R.width();
                    } else if (i2 == 1) {
                        fWidth = (getProgressLeft() + (i * length)) - (this.R.width() / 2.0f);
                    } else {
                        progressLeft = getProgressLeft() + (i * length);
                    }
                    fWidth = progressLeft;
                } else {
                    float fH = at3.h(string);
                    zs3[] rangeSeekBarState = getRangeSeekBarState();
                    if (at3.a(fH, rangeSeekBarState[0].b) != -1 && at3.a(fH, rangeSeekBarState[1].b) != 1 && this.e == 2) {
                        paint.setColor(this.l);
                    }
                    float progressLeft2 = getProgressLeft();
                    float f = this.t;
                    float f2 = this.D;
                    fWidth = (progressLeft2 + ((f * (fH - f2)) / (this.E - f2))) - (this.R.width() / 2.0f);
                }
                canvas.drawText(string, fWidth, this.j == 0 ? getProgressTop() - this.g : getProgressBottom() + this.g + this.R.height(), paint);
            }
            i++;
        }
    }

    public void n(int i, int i2) {
        int paddingBottom = (i2 - getPaddingBottom()) - getPaddingTop();
        if (i2 <= 0) {
            return;
        }
        int i3 = this.v;
        if (i3 == 0) {
            float fMax = (this.S.o() == 1 && this.T.o() == 1) ? 0.0f : Math.max(this.S.n(), this.T.n());
            float fMax2 = Math.max(this.S.w(), this.T.w());
            int i4 = this.s;
            float f = fMax2 - (i4 / 2.0f);
            this.a = (int) (((f - i4) / 2.0f) + fMax);
            if (this.m != null && this.j == 0) {
                this.a = (int) Math.max(getTickMarkRawHeight(), fMax + ((f - this.s) / 2.0f));
            }
            this.b = this.a + this.s;
        } else if (i3 == 1) {
            if (this.m == null || this.j != 1) {
                this.b = (int) ((paddingBottom - (Math.max(this.S.w(), this.T.w()) / 2.0f)) + (this.s / 2.0f));
            } else {
                this.b = paddingBottom - getTickMarkRawHeight();
            }
            this.a = this.b - this.s;
        } else {
            int i5 = this.s;
            int i6 = (paddingBottom - i5) / 2;
            this.a = i6;
            this.b = i6 + i5;
        }
        int iMax = ((int) Math.max(this.S.y(), this.T.y())) / 2;
        this.c = getPaddingLeft() + iMax;
        int paddingRight = (i - iMax) - getPaddingRight();
        this.d = paddingRight;
        this.t = paddingRight - this.c;
        this.N.set(getProgressLeft(), getProgressTop(), getProgressRight(), getProgressBottom());
        this.b0 = i - this.d;
        if (this.n <= 0.0f) {
            this.n = (int) ((getProgressBottom() - getProgressTop()) * 0.45f);
        }
        g();
    }

    public final void o() {
        ys3 ys3Var = this.U;
        if (ys3Var == null || ys3Var.x() <= 1.0f || !this.L) {
            return;
        }
        this.L = false;
        this.U.H();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m(canvas, this.M);
        j(canvas, this.M);
        l(canvas, this.M);
        k(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        float rawHeight;
        int iMakeMeasureSpec;
        float rawHeight2;
        float fMax;
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == 1073741824) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        } else if (mode == Integer.MIN_VALUE && (getParent() instanceof ViewGroup) && size == -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(((ViewGroup) getParent()).getMeasuredHeight(), Integer.MIN_VALUE);
        } else {
            if (this.v == 2) {
                if (this.m == null || this.j != 1) {
                    rawHeight2 = getRawHeight();
                    fMax = Math.max(this.S.w(), this.T.w()) / 2.0f;
                } else {
                    rawHeight2 = getRawHeight();
                    fMax = getTickMarkRawHeight();
                }
                rawHeight = (rawHeight2 - fMax) * 2.0f;
            } else {
                rawHeight = getRawHeight();
            }
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) rawHeight, 1073741824);
        }
        super.onMeasure(i, iMakeMeasureSpec);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        try {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setRange(savedState.a, savedState.b, savedState.c);
            setProgress(savedState.e, savedState.f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.D;
        savedState.b = this.E;
        savedState.c = this.u;
        zs3[] rangeSeekBarState = getRangeSeekBarState();
        savedState.e = rangeSeekBarState[0].b;
        savedState.f = rangeSeekBarState[1].b;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        n(i, i2);
        setRange(this.D, this.E, this.u);
        int progressBottom = (getProgressBottom() + getProgressTop()) / 2;
        this.S.G(getProgressLeft(), progressBottom);
        if (this.e == 2) {
            this.T.G(getProgressLeft(), progressBottom);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.F) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.G = c(motionEvent);
            d(motionEvent);
            if (this.e != 2) {
                this.U = this.S;
                p();
            } else if (this.T.x >= 1.0f && this.S.a(c(motionEvent), d(motionEvent))) {
                this.U = this.S;
                p();
            } else if (this.T.a(c(motionEvent), d(motionEvent))) {
                this.U = this.T;
                p();
            } else {
                float progressLeft = ((this.G - getProgressLeft()) * 1.0f) / this.t;
                if (Math.abs(this.S.x - progressLeft) < Math.abs(this.T.x - progressLeft)) {
                    this.U = this.S;
                } else {
                    this.U = this.T;
                }
                this.U.T(a(this.G));
            }
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            xs3 xs3Var = this.c0;
            if (xs3Var != null) {
                xs3Var.b(this, this.U == this.S);
            }
            b(true);
            return true;
        }
        if (action == 1) {
            if (q() && this.B) {
                float fA = a(c(motionEvent));
                this.U.T(new BigDecimal(fA / r2).setScale(0, RoundingMode.HALF_UP).intValue() * (1.0f / this.A));
            }
            if (this.e == 2) {
                this.T.P(false);
            }
            this.S.P(false);
            this.U.D();
            o();
            if (this.c0 != null) {
                zs3[] rangeSeekBarState = getRangeSeekBarState();
                this.c0.a(this, rangeSeekBarState[0].b, rangeSeekBarState[1].b, false);
            }
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            xs3 xs3Var2 = this.c0;
            if (xs3Var2 != null) {
                xs3Var2.c(this, this.U == this.S);
            }
            b(false);
        } else if (action == 2) {
            float fC = c(motionEvent);
            if (this.e == 2 && this.S.x == this.T.x) {
                this.U.D();
                xs3 xs3Var3 = this.c0;
                if (xs3Var3 != null) {
                    xs3Var3.c(this, this.U == this.S);
                }
                if (fC - this.G > 0.0f) {
                    ys3 ys3Var = this.U;
                    if (ys3Var != this.T) {
                        ys3Var.P(false);
                        o();
                        this.U = this.T;
                    }
                } else {
                    ys3 ys3Var2 = this.U;
                    if (ys3Var2 != this.S) {
                        ys3Var2.P(false);
                        o();
                        this.U = this.S;
                    }
                }
                xs3 xs3Var4 = this.c0;
                if (xs3Var4 != null) {
                    xs3Var4.b(this, this.U == this.S);
                }
            }
            p();
            ys3 ys3Var3 = this.U;
            float f = ys3Var3.y;
            ys3Var3.y = f < 1.0f ? 0.1f + f : 1.0f;
            this.G = fC;
            ys3Var3.T(a(fC));
            this.U.P(true);
            if (this.c0 != null) {
                zs3[] rangeSeekBarState2 = getRangeSeekBarState();
                this.c0.a(this, rangeSeekBarState2[0].b, rangeSeekBarState2[1].b, true);
            }
            invalidate();
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            b(true);
        } else if (action == 3) {
            if (this.e == 2) {
                this.T.P(false);
            }
            ys3 ys3Var4 = this.U;
            if (ys3Var4 == this.S || ys3Var4 == this.T) {
                o();
            }
            this.S.P(false);
            if (this.c0 != null) {
                zs3[] rangeSeekBarState3 = getRangeSeekBarState();
                this.c0.a(this, rangeSeekBarState3[0].b, rangeSeekBarState3[1].b, false);
            }
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            b(false);
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void p() {
        ys3 ys3Var = this.U;
        if (ys3Var == null || ys3Var.x() <= 1.0f || this.L) {
            return;
        }
        this.L = true;
        this.U.I();
    }

    public final boolean q() {
        return this.A >= 1 && this.y > 0.0f && this.x > 0.0f;
    }

    public void setEnableThumbOverlap(boolean z) {
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.F = z;
    }

    public void setGravity(int i) {
        this.v = i;
    }

    public void setIndicatorText(String str) {
        this.S.M(str);
        if (this.e == 2) {
            this.T.M(str);
        }
    }

    public void setIndicatorTextDecimalFormat(String str) {
        this.S.N(str);
        if (this.e == 2) {
            this.T.N(str);
        }
    }

    public void setIndicatorTextStringFormat(String str) {
        this.S.O(str);
        if (this.e == 2) {
            this.T.O(str);
        }
    }

    public void setOnRangeChangedListener(xs3 xs3Var) {
        this.c0 = xs3Var;
    }

    public void setProgress(float f) {
        setProgress(f, this.E);
    }

    public void setProgressBottom(int i) {
        this.b = i;
    }

    public void setProgressColor(@ColorInt int i, @ColorInt int i2) {
        this.p = i;
        this.o = i2;
    }

    public void setProgressDefaultColor(@ColorInt int i) {
        this.p = i;
    }

    public void setProgressDefaultDrawableId(@DrawableRes int i) {
        this.r = i;
        this.W = null;
        g();
    }

    public void setProgressDrawableId(@DrawableRes int i) {
        this.q = i;
        this.V = null;
        g();
    }

    public void setProgressHeight(int i) {
        this.s = i;
    }

    public void setProgressLeft(int i) {
        this.c = i;
    }

    public void setProgressRadius(float f) {
        this.n = f;
    }

    public void setProgressRight(int i) {
        this.d = i;
    }

    public void setProgressTop(int i) {
        this.a = i;
    }

    public void setProgressWidth(int i) {
        this.t = i;
    }

    public void setRange(float f, float f2) {
        setRange(f, f2, this.u);
    }

    public void setSeekBarMode(int i) {
        this.e = i;
        this.T.S(i != 1);
    }

    public void setSteps(int i) {
        this.A = i;
    }

    public void setStepsAutoBonding(boolean z) {
        this.B = z;
    }

    public void setStepsBitmaps(List<Bitmap> list) {
        if (list == null || list.isEmpty() || list.size() <= this.A) {
            throw new IllegalArgumentException("stepsBitmaps must > steps !");
        }
        this.a0.clear();
        this.a0.addAll(list);
    }

    public void setStepsColor(@ColorInt int i) {
        this.w = i;
    }

    public void setStepsDrawable(List<Integer> list) {
        if (list == null || list.isEmpty() || list.size() <= this.A) {
            throw new IllegalArgumentException("stepsDrawableIds must > steps !");
        }
        if (!q()) {
            throw new IllegalArgumentException("stepsWidth must > 0, stepsHeight must > 0,steps must > 0 First!!");
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(at3.f(getContext(), (int) this.x, (int) this.y, list.get(i).intValue()));
        }
        setStepsBitmaps(arrayList);
    }

    public void setStepsDrawableId(@DrawableRes int i) {
        this.a0.clear();
        this.C = i;
        i();
    }

    public void setStepsHeight(float f) {
        this.y = f;
    }

    public void setStepsRadius(float f) {
        this.z = f;
    }

    public void setStepsWidth(float f) {
        this.x = f;
    }

    public void setTickMarkGravity(int i) {
        this.i = i;
    }

    public void setTickMarkInRangeTextColor(@ColorInt int i) {
        this.l = i;
    }

    public void setTickMarkLayoutGravity(int i) {
        this.j = i;
    }

    public void setTickMarkMode(int i) {
        this.f = i;
    }

    public void setTickMarkTextArray(CharSequence[] charSequenceArr) {
        this.m = charSequenceArr;
    }

    public void setTickMarkTextColor(@ColorInt int i) {
        this.k = i;
    }

    public void setTickMarkTextMargin(int i) {
        this.g = i;
    }

    public void setTickMarkTextSize(int i) {
        this.h = i;
    }

    public void setTypeface(Typeface typeface) {
        this.M.setTypeface(typeface);
    }

    public RangeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = true;
        this.L = false;
        this.M = new Paint();
        this.N = new RectF();
        this.O = new RectF();
        this.P = new Rect();
        this.Q = new RectF();
        this.R = new Rect();
        this.a0 = new ArrayList();
        e(attributeSet);
        f();
        h(attributeSet);
        i();
    }

    public void setProgress(float f, float f2) {
        float fMin = Math.min(f, f2);
        float fMax = Math.max(fMin, f2);
        float f3 = fMax - fMin;
        float f4 = this.u;
        if (f3 < f4) {
            if (fMin - this.D > this.E - fMax) {
                fMin = fMax - f4;
            } else {
                fMax = fMin + f4;
            }
        }
        float f5 = this.D;
        if (fMin < f5) {
            throw new IllegalArgumentException("setProgress() min < (preset min - offsetValue) . #min:" + fMin + " #preset min:" + fMax);
        }
        float f6 = this.E;
        if (fMax > f6) {
            throw new IllegalArgumentException("setProgress() max > (preset max - offsetValue) . #max:" + fMax + " #preset max:" + fMax);
        }
        float f7 = f6 - f5;
        this.S.x = Math.abs(fMin - f5) / f7;
        if (this.e == 2) {
            this.T.x = Math.abs(fMax - this.D) / f7;
        }
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setRange(float r5, float r6, float r7) {
        /*
            r4 = this;
            int r0 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r0 <= 0) goto L84
            r0 = 0
            int r1 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r1 < 0) goto L6d
            float r1 = r6 - r5
            int r2 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r2 >= 0) goto L4e
            r4.E = r6
            r4.D = r5
            r4.u = r7
            float r7 = r7 / r1
            r4.K = r7
            int r5 = r4.e
            r6 = 2
            if (r5 != r6) goto L4a
            dc.ys3 r5 = r4.S
            float r6 = r5.x
            float r1 = r6 + r7
            r2 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 > 0) goto L37
            float r1 = r6 + r7
            dc.ys3 r2 = r4.T
            float r3 = r2.x
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L37
            float r6 = r6 + r7
            r2.x = r6
            goto L4a
        L37:
            dc.ys3 r1 = r4.T
            float r1 = r1.x
            float r2 = r1 - r7
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 < 0) goto L4a
            float r0 = r1 - r7
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 >= 0) goto L4a
            float r1 = r1 - r7
            r5.x = r1
        L4a:
            r4.invalidate()
            return
        L4e:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "setRange() interval must be less than (max - min) ! #minInterval:"
            r6.append(r0)
            r6.append(r7)
            java.lang.String r7 = " #max - min:"
            r6.append(r7)
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L6d:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "setRange() interval must be greater than zero ! #minInterval:"
            r6.append(r0)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L84:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "setRange() max must be greater than min ! #max:"
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = " #min:"
            r0.append(r6)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r7.<init>(r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.seekbar.RangeSeekBar.setRange(float, float, float):void");
    }

    public void setProgressColor(@ColorInt int i) {
        this.o = i;
    }
}
