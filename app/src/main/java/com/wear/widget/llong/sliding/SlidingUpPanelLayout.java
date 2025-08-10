package com.wear.widget.llong.sliding;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import dc.qs3;
import dc.rs3;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class SlidingUpPanelLayout extends ViewGroup {
    public static final String L = SlidingUpPanelLayout.class.getSimpleName();
    public static d M = d.COLLAPSED;
    public static final int[] N = {R.attr.gravity};
    public float A;
    public float B;
    public boolean C;
    public final List<c> D;
    public View.OnClickListener E;
    public final rs3 F;
    public boolean G;
    public final Rect K;
    public int a;
    public int b;
    public final Paint c;
    public final Drawable d;
    public int e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public View k;
    public int l;
    public View m;
    public int n;
    public qs3 o;
    public View p;
    public View q;
    public d r;
    public d s;
    public float t;
    public int u;
    public float v;
    public boolean w;
    public boolean x;
    public float y;
    public float z;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.values().length];
            a = iArr;
            try {
                iArr[d.EXPANDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.ANCHORED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[d.HIDDEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[d.COLLAPSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public class b extends rs3.c {
        public b() {
        }

        @Override // dc.rs3.c
        public int b(View view, int i, int i2) {
            int iP = SlidingUpPanelLayout.this.p(0.0f);
            int iP2 = SlidingUpPanelLayout.this.p(1.0f);
            return SlidingUpPanelLayout.this.h ? Math.min(Math.max(i, iP2), iP) : Math.min(Math.max(i, iP), iP2);
        }

        @Override // dc.rs3.c
        public int e(View view) {
            return SlidingUpPanelLayout.this.u;
        }

        @Override // dc.rs3.c
        public void i(View view, int i) {
            SlidingUpPanelLayout.this.x();
        }

        @Override // dc.rs3.c
        public void j(int i) {
            if (SlidingUpPanelLayout.this.F == null || SlidingUpPanelLayout.this.F.x() != 0) {
                return;
            }
            SlidingUpPanelLayout slidingUpPanelLayout = SlidingUpPanelLayout.this;
            slidingUpPanelLayout.t = slidingUpPanelLayout.q(slidingUpPanelLayout.p.getTop());
            SlidingUpPanelLayout.this.o();
            if (SlidingUpPanelLayout.this.t == 1.0f) {
                SlidingUpPanelLayout.this.B();
                SlidingUpPanelLayout.this.setPanelStateInternal(d.EXPANDED);
            } else if (SlidingUpPanelLayout.this.t == 0.0f) {
                SlidingUpPanelLayout.this.setPanelStateInternal(d.COLLAPSED);
            } else if (SlidingUpPanelLayout.this.t < 0.0f) {
                SlidingUpPanelLayout.this.setPanelStateInternal(d.HIDDEN);
                SlidingUpPanelLayout.this.p.setVisibility(4);
            } else {
                SlidingUpPanelLayout.this.B();
                SlidingUpPanelLayout.this.setPanelStateInternal(d.ANCHORED);
            }
        }

        @Override // dc.rs3.c
        public void k(View view, int i, int i2, int i3, int i4) {
            SlidingUpPanelLayout.this.w(i2);
            SlidingUpPanelLayout.this.invalidate();
        }

        @Override // dc.rs3.c
        public void l(View view, float f, float f2) {
            int iP;
            if (SlidingUpPanelLayout.this.h) {
                f2 = -f2;
            }
            if (f2 > 0.0f && SlidingUpPanelLayout.this.t <= SlidingUpPanelLayout.this.v) {
                SlidingUpPanelLayout slidingUpPanelLayout = SlidingUpPanelLayout.this;
                iP = slidingUpPanelLayout.p(slidingUpPanelLayout.v);
            } else if (f2 > 0.0f && SlidingUpPanelLayout.this.t > SlidingUpPanelLayout.this.v) {
                iP = SlidingUpPanelLayout.this.p(1.0f);
            } else if (f2 < 0.0f && SlidingUpPanelLayout.this.t >= SlidingUpPanelLayout.this.v) {
                SlidingUpPanelLayout slidingUpPanelLayout2 = SlidingUpPanelLayout.this;
                iP = slidingUpPanelLayout2.p(slidingUpPanelLayout2.v);
            } else if (f2 < 0.0f && SlidingUpPanelLayout.this.t < SlidingUpPanelLayout.this.v) {
                iP = SlidingUpPanelLayout.this.p(0.0f);
            } else if (SlidingUpPanelLayout.this.t >= (SlidingUpPanelLayout.this.v + 1.0f) / 2.0f) {
                iP = SlidingUpPanelLayout.this.p(1.0f);
            } else if (SlidingUpPanelLayout.this.t >= SlidingUpPanelLayout.this.v / 2.0f) {
                SlidingUpPanelLayout slidingUpPanelLayout3 = SlidingUpPanelLayout.this;
                iP = slidingUpPanelLayout3.p(slidingUpPanelLayout3.v);
            } else {
                iP = SlidingUpPanelLayout.this.p(0.0f);
            }
            if (SlidingUpPanelLayout.this.F != null) {
                SlidingUpPanelLayout.this.F.I(view.getLeft(), iP);
            }
            SlidingUpPanelLayout.this.invalidate();
        }

        @Override // dc.rs3.c
        public boolean m(View view, int i) {
            return !SlidingUpPanelLayout.this.w && view == SlidingUpPanelLayout.this.p;
        }

        public /* synthetic */ b(SlidingUpPanelLayout slidingUpPanelLayout, a aVar) {
            this();
        }
    }

    public interface c {
        void a(View view, d dVar, d dVar2);

        void onPanelSlide(View view, float f);
    }

    public enum d {
        EXPANDED,
        COLLAPSED,
        ANCHORED,
        HIDDEN,
        DRAGGING
    }

    public SlidingUpPanelLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPanelStateInternal(d dVar) {
        d dVar2 = this.r;
        if (dVar2 == dVar) {
            return;
        }
        this.r = dVar;
        s(this, dVar2, dVar);
    }

    public static boolean t(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    public void A() {
        y(0.0f, 0);
    }

    public void B() {
        int left;
        int right;
        int top;
        int bottom;
        if (getChildCount() == 0) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        View view = this.p;
        int i = 0;
        if (view == null || !t(view)) {
            left = 0;
            right = 0;
            top = 0;
            bottom = 0;
        } else {
            left = this.p.getLeft();
            right = this.p.getRight();
            top = this.p.getTop();
            bottom = this.p.getBottom();
        }
        View childAt = getChildAt(0);
        int iMax = Math.max(paddingLeft, childAt.getLeft());
        int iMax2 = Math.max(paddingTop, childAt.getTop());
        int iMin = Math.min(width, childAt.getRight());
        int iMin2 = Math.min(height, childAt.getBottom());
        if (iMax >= left && iMax2 >= top && iMin <= right && iMin2 <= bottom) {
            i = 4;
        }
        childAt.setVisibility(i);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        rs3 rs3Var = this.F;
        if (rs3Var == null || !rs3Var.l(true)) {
            return;
        }
        if (isEnabled()) {
            ViewCompat.postInvalidateOnAnimation(this);
        } else {
            this.F.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (!isEnabled() || !u() || (this.w && actionMasked != 0)) {
            this.F.a();
            return super.dispatchTouchEvent(motionEvent);
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (actionMasked == 0) {
            this.C = false;
            this.y = x;
            this.z = y;
        } else if (actionMasked == 2) {
            float f = x - this.y;
            float f2 = y - this.z;
            this.y = x;
            this.z = y;
            if (Math.abs(f) > Math.abs(f2)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (!v(this.m, (int) this.A, (int) this.B)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            boolean z = this.h;
            if ((z ? 1 : -1) * f2 > 0.0f) {
                if (this.o.a(this.m, z) > 0) {
                    this.C = true;
                    return super.dispatchTouchEvent(motionEvent);
                }
                if (this.C) {
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    motionEventObtain.setAction(3);
                    super.dispatchTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    motionEvent.setAction(0);
                }
                this.C = false;
                return onTouchEvent(motionEvent);
            }
            if (f2 * (z ? 1 : -1) < 0.0f) {
                if (this.t < 1.0f) {
                    this.C = false;
                    return onTouchEvent(motionEvent);
                }
                if (!this.C && this.F.z()) {
                    this.F.b();
                    motionEvent.setAction(0);
                }
                this.C = true;
                return super.dispatchTouchEvent(motionEvent);
            }
        } else if (actionMasked == 1 && this.C) {
            this.F.G(0);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        View view;
        int bottom;
        int bottom2;
        super.draw(canvas);
        if (this.d == null || (view = this.p) == null) {
            return;
        }
        int right = view.getRight();
        if (this.h) {
            bottom = this.p.getTop() - this.f;
            bottom2 = this.p.getTop();
        } else {
            bottom = this.p.getBottom();
            bottom2 = this.p.getBottom() + this.f;
        }
        this.d.setBounds(this.p.getLeft(), bottom, right, bottom2);
        this.d.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean zDrawChild;
        int iSave = canvas.save();
        View view2 = this.p;
        if (view2 == null || view2 == view) {
            zDrawChild = super.drawChild(canvas, view, j);
        } else {
            canvas.getClipBounds(this.K);
            if (!this.i) {
                if (this.h) {
                    Rect rect = this.K;
                    rect.bottom = Math.min(rect.bottom, this.p.getTop());
                } else {
                    Rect rect2 = this.K;
                    rect2.top = Math.max(rect2.top, this.p.getBottom());
                }
            }
            if (this.j) {
                canvas.clipRect(this.K);
            }
            zDrawChild = super.drawChild(canvas, view, j);
            int i = this.b;
            if (i != 0) {
                float f = this.t;
                if (f > 0.0f) {
                    this.c.setColor((i & 16777215) | (((int) ((((-16777216) & i) >>> 24) * f)) << 24));
                    canvas.drawRect(this.K, this.c);
                }
            }
        }
        canvas.restoreToCount(iSave);
        return zDrawChild;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public float getAnchorPoint() {
        return this.v;
    }

    public int getCoveredFadeColor() {
        return this.b;
    }

    public int getCurrentParallaxOffset() {
        int iMax = (int) (this.g * Math.max(this.t, 0.0f));
        return this.h ? -iMax : iMax;
    }

    public int getMinFlingVelocity() {
        return this.a;
    }

    public int getPanelHeight() {
        return this.e;
    }

    public d getPanelState() {
        return this.r;
    }

    public int getShadowHeight() {
        return this.f;
    }

    public void n(c cVar) {
        synchronized (this.D) {
            this.D.add(cVar);
        }
    }

    @SuppressLint({"NewApi"})
    public final void o() {
        if (this.g > 0) {
            ViewCompat.setTranslationY(this.q, getCurrentParallaxOffset());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.G = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.G = true;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.l;
        if (i != -1) {
            setDragView(findViewById(i));
        }
        int i2 = this.n;
        if (i2 != -1) {
            setScrollableView(findViewById(i2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004c  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            boolean r0 = r8.C
            r1 = 0
            if (r0 != 0) goto La4
            boolean r0 = r8.u()
            if (r0 != 0) goto Ld
            goto La4
        Ld:
            int r0 = androidx.core.view.MotionEventCompat.getActionMasked(r9)
            float r2 = r9.getX()
            float r3 = r9.getY()
            float r4 = r8.A
            float r4 = r2 - r4
            float r4 = java.lang.Math.abs(r4)
            float r5 = r8.B
            float r5 = r3 - r5
            float r5 = java.lang.Math.abs(r5)
            dc.rs3 r6 = r8.F
            int r6 = r6.w()
            r7 = 1
            if (r0 == 0) goto L85
            if (r0 == r7) goto L4c
            r2 = 2
            if (r0 == r2) goto L3b
            r2 = 3
            if (r0 == r2) goto L4c
            goto L9d
        L3b:
            float r0 = (float) r6
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 <= 0) goto L9d
            int r0 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r0 <= 0) goto L9d
            dc.rs3 r9 = r8.F
            r9.b()
            r8.w = r7
            return r1
        L4c:
            dc.rs3 r0 = r8.F
            boolean r0 = r0.z()
            if (r0 == 0) goto L5a
            dc.rs3 r0 = r8.F
            r0.B(r9)
            return r7
        L5a:
            float r0 = (float) r6
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 > 0) goto L9d
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 > 0) goto L9d
            float r0 = r8.t
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L9d
            android.view.View r0 = r8.p
            float r2 = r8.A
            int r2 = (int) r2
            float r3 = r8.B
            int r3 = (int) r3
            boolean r0 = r8.v(r0, r2, r3)
            if (r0 != 0) goto L9d
            android.view.View$OnClickListener r0 = r8.E
            if (r0 == 0) goto L9d
            r8.playSoundEffect(r1)
            android.view.View$OnClickListener r9 = r8.E
            r9.onClick(r8)
            return r7
        L85:
            r8.w = r1
            r8.A = r2
            r8.B = r3
            android.view.View r0 = r8.k
            int r2 = (int) r2
            int r3 = (int) r3
            boolean r0 = r8.v(r0, r2, r3)
            if (r0 != 0) goto L9d
            dc.rs3 r9 = r8.F
            r9.b()
            r8.w = r7
            return r1
        L9d:
            dc.rs3 r0 = r8.F
            boolean r9 = r0.J(r9)
            return r9
        La4:
            dc.rs3 r9 = r8.F
            r9.a()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.llong.sliding.SlidingUpPanelLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.G) {
            int i5 = a.a[this.r.ordinal()];
            if (i5 == 1) {
                this.t = 1.0f;
            } else if (i5 == 2) {
                this.t = this.v;
            } else if (i5 != 3) {
                this.t = 0.0f;
            } else {
                this.t = q(p(0.0f) + (this.h ? this.e : -this.e));
            }
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 || (i6 != 0 && !this.G)) {
                int measuredHeight = childAt.getMeasuredHeight();
                int iP = childAt == this.p ? p(this.t) : paddingTop;
                if (!this.h && childAt == this.q && !this.i) {
                    iP = p(this.t) + this.p.getMeasuredHeight();
                }
                int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                childAt.layout(i7, iP, childAt.getMeasuredWidth() + i7, measuredHeight + iP);
            }
        }
        if (this.G) {
            B();
        }
        o();
        this.G = false;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int iMakeMeasureSpec;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824 && mode != Integer.MIN_VALUE) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        }
        if (mode2 != 1073741824 && mode2 != Integer.MIN_VALUE) {
            throw new IllegalStateException("Height must have an exact value or MATCH_PARENT");
        }
        int childCount = getChildCount();
        if (childCount != 2) {
            throw new IllegalStateException("Sliding up panel layout must have exactly 2 children!");
        }
        this.q = getChildAt(0);
        if (this.p == null) {
            this.p = getChildAt(1);
        }
        if (this.k == null) {
            setDragView(this.p);
        }
        if (this.p.getVisibility() != 0) {
            this.r = d.HIDDEN;
        }
        int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 || i5 != 0) {
                if (childAt == this.q) {
                    i3 = (this.i || this.r == d.HIDDEN) ? paddingTop : paddingTop - this.e;
                    i4 = paddingLeft - (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                } else {
                    i3 = childAt == this.p ? paddingTop - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin : paddingTop;
                    i4 = paddingLeft;
                }
                int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                int iMakeMeasureSpec2 = i6 == -2 ? View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE) : i6 == -1 ? View.MeasureSpec.makeMeasureSpec(i4, 1073741824) : View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                if (i7 == -2) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
                } else {
                    float f = layoutParams.a;
                    if (f > 0.0f && f < 1.0f) {
                        i3 = (int) (i3 * f);
                    } else if (i7 != -1) {
                        i3 = i7;
                    }
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                }
                childAt.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
                View view = this.p;
                if (childAt == view) {
                    this.u = view.getMeasuredHeight() - this.e;
                }
            }
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            d dVar = (d) bundle.getSerializable("sliding_state");
            this.r = dVar;
            if (dVar == null) {
                dVar = M;
            }
            this.r = dVar;
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        d dVar = this.r;
        if (dVar == d.DRAGGING) {
            dVar = this.s;
        }
        bundle.putSerializable("sliding_state", dVar);
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i2 != i4) {
            this.G = true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !u()) {
            return super.onTouchEvent(motionEvent);
        }
        try {
            this.F.B(motionEvent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final int p(float f) {
        View view = this.p;
        int i = (int) (f * this.u);
        return this.h ? ((getMeasuredHeight() - getPaddingBottom()) - this.e) - i : (getPaddingTop() - (view != null ? view.getMeasuredHeight() : 0)) + this.e + i;
    }

    public final float q(int i) {
        float f;
        int i2;
        int iP = p(0.0f);
        if (this.h) {
            f = iP - i;
            i2 = this.u;
        } else {
            f = i - iP;
            i2 = this.u;
        }
        return f / i2;
    }

    public void r(View view) {
        synchronized (this.D) {
            Iterator<c> it = this.D.iterator();
            while (it.hasNext()) {
                it.next().onPanelSlide(view, this.t);
            }
        }
    }

    public void s(View view, d dVar, d dVar2) {
        synchronized (this.D) {
            Iterator<c> it = this.D.iterator();
            while (it.hasNext()) {
                it.next().a(view, dVar, dVar2);
            }
        }
        sendAccessibilityEvent(32);
    }

    public void setAnchorPoint(float f) {
        if (f <= 0.0f || f > 1.0f) {
            return;
        }
        this.v = f;
        this.G = true;
        requestLayout();
    }

    public void setClipPanel(boolean z) {
        this.j = z;
    }

    public void setCoveredFadeColor(int i) {
        this.b = i;
        requestLayout();
    }

    public void setDragView(View view) {
        View view2 = this.k;
        if (view2 != null) {
            view2.setOnClickListener(null);
        }
        this.k = view;
        if (view != null) {
            view.setClickable(true);
            this.k.setFocusable(false);
            this.k.setFocusableInTouchMode(false);
        }
    }

    public void setFadeOnClickListener(View.OnClickListener onClickListener) {
        this.E = onClickListener;
    }

    public void setGravity(int i) {
        if (i != 48 && i != 80) {
            throw new IllegalArgumentException("gravity must be set to either top or bottom");
        }
        this.h = i == 80;
        if (this.G) {
            return;
        }
        requestLayout();
    }

    public void setMinFlingVelocity(int i) {
        this.a = i;
    }

    public void setOverlayed(boolean z) {
        this.i = z;
    }

    public void setPanelHeight(int i) {
        if (getPanelHeight() == i) {
            return;
        }
        this.e = i;
        if (!this.G) {
            requestLayout();
        }
        if (getPanelState() == d.COLLAPSED) {
            A();
            invalidate();
        }
    }

    public void setPanelState(d dVar) {
        setPanelState(dVar, false);
    }

    public void setParallaxOffset(int i) {
        this.g = i;
        if (this.G) {
            return;
        }
        requestLayout();
    }

    public void setScrollableView(View view) {
        this.m = view;
    }

    public void setScrollableViewHelper(qs3 qs3Var) {
        this.o = qs3Var;
    }

    public void setShadowHeight(int i) {
        this.f = i;
        if (this.G) {
            return;
        }
        invalidate();
    }

    public void setTouchEnabled(boolean z) {
        this.x = z;
    }

    public boolean u() {
        return (!this.x || this.p == null || this.r == d.HIDDEN) ? false : true;
    }

    public final boolean v(View view, int i, int i2) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr2);
        int i3 = iArr2[0] + i;
        int i4 = iArr2[1] + i2;
        return i3 >= iArr[0] && i3 < iArr[0] + view.getWidth() && i4 >= iArr[1] && i4 < iArr[1] + view.getHeight();
    }

    public final void w(int i) {
        d dVar = this.r;
        d dVar2 = d.DRAGGING;
        if (dVar != dVar2) {
            this.s = dVar;
        }
        setPanelStateInternal(dVar2);
        this.t = q(i);
        o();
        r(this.p);
        LayoutParams layoutParams = (LayoutParams) this.q.getLayoutParams();
        int height = ((getHeight() - getPaddingBottom()) - getPaddingTop()) - this.e;
        if (this.t > 0.0f || this.i) {
            if (((ViewGroup.MarginLayoutParams) layoutParams).height == -1 || this.i) {
                return;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).height = -1;
            this.q.requestLayout();
            return;
        }
        int paddingBottom = this.h ? i - getPaddingBottom() : ((getHeight() - getPaddingBottom()) - this.p.getMeasuredHeight()) - i;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = paddingBottom;
        if (paddingBottom == height) {
            ((ViewGroup.MarginLayoutParams) layoutParams).height = -1;
        }
        this.q.requestLayout();
    }

    public void x() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    public boolean y(float f, int i) {
        return z(f, i, false);
    }

    public boolean z(float f, int i, boolean z) {
        if (isEnabled() && this.p != null) {
            int iP = p(f);
            rs3 rs3Var = this.F;
            View view = this.p;
            if (rs3Var.K(view, view.getLeft(), iP, z)) {
                x();
                ViewCompat.postInvalidateOnAnimation(this);
                return true;
            }
        }
        return false;
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int[] b = {R.attr.layout_weight};
        public float a;

        public LayoutParams() {
            super(-1, -1);
            this.a = 0.0f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0.0f;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b);
            if (typedArrayObtainStyledAttributes != null) {
                this.a = typedArrayObtainStyledAttributes.getFloat(0, 0.0f);
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }

    public SlidingUpPanelLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setPanelState(d dVar, boolean z) {
        d dVar2;
        d dVar3;
        if (this.F.x() == 2) {
            this.F.a();
        }
        if (dVar == null || dVar == (dVar2 = d.DRAGGING)) {
            throw new IllegalArgumentException("Panel state cannot be null or DRAGGING.");
        }
        if (isEnabled()) {
            boolean z2 = this.G;
            if ((!z2 && this.p == null) || dVar == (dVar3 = this.r) || dVar3 == dVar2) {
                return;
            }
            if (z2) {
                setPanelStateInternal(dVar);
                return;
            }
            if (dVar3 == d.HIDDEN) {
                this.p.setVisibility(0);
                requestLayout();
            }
            int i = a.a[dVar.ordinal()];
            if (i == 1) {
                y(1.0f, 0);
                return;
            }
            if (i == 2) {
                y(this.v, 0);
            } else if (i == 3) {
                y(q(p(0.0f) + (this.h ? this.e : -this.e)), 0);
            } else {
                if (i != 4) {
                    return;
                }
                z(0.0f, 0, z);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SlidingUpPanelLayout(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.llong.sliding.SlidingUpPanelLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setDragView(int i) {
        this.l = i;
        setDragView(findViewById(i));
    }
}
