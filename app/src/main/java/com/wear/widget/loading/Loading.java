package com.wear.widget.loading;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.lovense.wear.R;
import dc.ce3;
import dc.ss3;
import dc.ts3;
import dc.us3;
import java.util.Objects;

/* loaded from: classes4.dex */
public class Loading extends View {
    public static int d = 1;
    public static int e = 2;
    public ts3 a;
    public boolean b;
    public boolean c;

    public Loading(Context context) throws Resources.NotFoundException {
        super(context);
        b(null, R.attr.gLoadingStyle, R.style.Genius_Widget_Loading);
    }

    public final void a(int i) {
        ts3 ts3Var = this.a;
        if (ts3Var == null) {
            return;
        }
        if (i == 0) {
            if (this.c) {
                c();
            }
        } else if (ts3Var.isRunning()) {
            this.c = true;
            this.a.stop();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(android.util.AttributeSet r17, int r18, int r19) throws android.content.res.Resources.NotFoundException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            android.content.Context r2 = r16.getContext()
            android.content.res.Resources r3 = r16.getResources()
            if (r1 != 0) goto L14
            int r1 = com.wear.widget.loading.Loading.d
            r0.setProgressStyle(r1)
            return
        L14:
            android.util.DisplayMetrics r4 = r3.getDisplayMetrics()
            float r4 = r4.density
            r5 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 * r5
            int r4 = (int) r4
            int[] r5 = dc.vi1.Loading
            r6 = r18
            r7 = r19
            android.content.res.TypedArray r1 = r2.obtainStyledAttributes(r1, r5, r6, r7)
            r2 = 2
            int r2 = r1.getDimensionPixelOffset(r2, r4)
            r5 = 4
            int r4 = r1.getDimensionPixelOffset(r5, r4)
            r5 = 1
            android.content.res.ColorStateList r6 = r1.getColorStateList(r5)
            r7 = 0
            if (r6 == 0) goto L40
            int r6 = r6.getDefaultColor()
            goto L41
        L40:
            r6 = 0
        L41:
            r9 = 3
            r10 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            int r10 = r1.getColor(r9, r7)     // Catch: java.lang.Exception -> L4b
        L48:
            r8 = 0
            goto Lb5
        L4b:
            r11 = 2130903049(0x7f030009, float:1.7412905E38)
            int r9 = r1.getResourceId(r9, r11)
            boolean r12 = r16.isInEditMode()
            if (r12 != 0) goto L48
            android.content.res.TypedArray r12 = r3.obtainTypedArray(r9)
            int r13 = r12.length()
            if (r13 <= 0) goto L72
            int[] r3 = new int[r13]
            r8 = 0
        L65:
            if (r8 >= r13) goto L70
            int r9 = r12.getColor(r8, r10)
            r3[r8] = r9
            int r8 = r8 + 1
            goto L65
        L70:
            r8 = r3
            goto Lb2
        L72:
            java.lang.String r13 = r3.getResourceTypeName(r9)
            r14 = -1
            int r15 = r13.hashCode()     // Catch: java.lang.Exception -> Lad
            r8 = 93090393(0x58c7259, float:1.3207541E-35)
            if (r15 == r8) goto L90
            r8 = 94842723(0x5a72f63, float:1.5722012E-35)
            if (r15 == r8) goto L86
            goto L99
        L86:
            java.lang.String r8 = "color"
            boolean r8 = r13.equals(r8)     // Catch: java.lang.Exception -> Lad
            if (r8 == 0) goto L99
            r14 = 0
            goto L99
        L90:
            java.lang.String r8 = "array"
            boolean r8 = r13.equals(r8)     // Catch: java.lang.Exception -> Lad
            if (r8 == 0) goto L99
            r14 = 1
        L99:
            if (r14 == 0) goto La7
            if (r14 == r5) goto La2
            int[] r8 = r3.getIntArray(r11)     // Catch: java.lang.Exception -> Lad
            goto Lb2
        La2:
            int[] r8 = r3.getIntArray(r9)     // Catch: java.lang.Exception -> Lad
            goto Lb2
        La7:
            int r10 = r3.getColor(r9)     // Catch: java.lang.Exception -> Lad
            r8 = 0
            goto Lb2
        Lad:
            int[] r3 = r3.getIntArray(r11)
            goto L70
        Lb2:
            r12.recycle()
        Lb5:
            r3 = 6
            int r3 = r1.getInt(r3, r5)
            boolean r5 = r1.getBoolean(r7, r5)
            r7 = 5
            r9 = 0
            float r7 = r1.getFloat(r7, r9)
            r1.recycle()
            r0.setProgressStyle(r3)
            r0.setAutoRun(r5)
            r0.setProgress(r7)
            r0.setBackgroundLineSize(r2)
            r0.setForegroundLineSize(r4)
            r0.setBackgroundColor(r6)
            if (r8 != 0) goto Ldf
            r0.setForegroundColor(r10)
            goto Le2
        Ldf:
            r0.setForegroundColor(r8)
        Le2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.loading.Loading.b(android.util.AttributeSet, int, int):void");
    }

    public void c() {
        this.a.start();
        this.c = false;
    }

    public int getBackgroundColor() {
        return this.a.d();
    }

    public float getBackgroundLineSize() {
        return this.a.e();
    }

    public int[] getForegroundColor() {
        return this.a.f();
    }

    public float getForegroundLineSize() {
        return this.a.g();
    }

    public float getProgress() {
        return this.a.i();
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.b && this.a.i() == 0.0f) {
            if (getVisibility() == 0) {
                this.a.start();
            } else {
                this.c = true;
            }
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a.stop();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.a.draw(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int intrinsicHeight = this.a.getIntrinsicHeight() + getPaddingTop() + getPaddingBottom();
        int intrinsicWidth = this.a.getIntrinsicWidth() + getPaddingLeft() + getPaddingRight();
        if (mode != 1073741824) {
            size = mode == Integer.MIN_VALUE ? Math.min(size, intrinsicWidth) : intrinsicWidth;
        }
        if (mode2 != 1073741824) {
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(size2, intrinsicHeight) : intrinsicHeight;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.a.setBounds(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), i2 - getPaddingBottom());
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        a(i);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        a(i);
    }

    public void setAutoRun(boolean z) {
        this.b = z;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.a.l(i);
        invalidate();
    }

    public void setBackgroundColorRes(int i) {
        ColorStateList colorStateListB = ce3.b(getResources(), i);
        if (colorStateListB == null) {
            setBackgroundColor(0);
        } else {
            setBackgroundColor(colorStateListB.getDefaultColor());
        }
    }

    public void setBackgroundLineSize(int i) {
        this.a.m(i);
        invalidate();
        requestLayout();
    }

    public void setForegroundColor(int i) {
        setForegroundColor(new int[]{i});
    }

    public void setForegroundLineSize(int i) {
        this.a.o(i);
        invalidate();
        requestLayout();
    }

    public void setLoadingDrawable(ts3 ts3Var) {
        Objects.requireNonNull(ts3Var, "LoadingDrawable is null, You can only set the STYLE_CIRCLE and STYLE_LINE parameters.");
        ts3Var.setCallback(this);
        this.a = ts3Var;
        invalidate();
        requestLayout();
    }

    public void setProgress(float f) {
        this.a.p(f);
        invalidate();
    }

    public void setProgressStyle(int i) {
        ts3 us3Var;
        if (i == d) {
            Resources resources = getResources();
            us3Var = new ss3(resources.getDimensionPixelOffset(R.dimen.g_loading_minSize), resources.getDimensionPixelOffset(R.dimen.g_loading_maxSize));
        } else {
            us3Var = i == e ? new us3() : null;
        }
        setLoadingDrawable(us3Var);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.a || super.verifyDrawable(drawable);
    }

    public void setForegroundColor(int[] iArr) {
        this.a.n(iArr);
        invalidate();
    }

    public Loading(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        b(attributeSet, R.attr.gLoadingStyle, R.style.Genius_Widget_Loading);
    }

    public Loading(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        b(attributeSet, i, R.style.Genius_Widget_Loading);
    }
}
