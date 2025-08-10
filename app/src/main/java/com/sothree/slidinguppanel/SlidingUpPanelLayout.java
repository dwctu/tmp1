package com.sothree.slidinguppanel;

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
import dc.ue1;
import dc.ve1;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class SlidingUpPanelLayout extends ViewGroup {
    public static final String L = SlidingUpPanelLayout.class.getSimpleName();
    public static e M = e.COLLAPSED;
    public static final int[] N = {R.attr.gravity};
    public float A;
    public float B;
    public boolean C;
    public final List<d> D;
    public View.OnClickListener E;
    public final ve1 F;
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
    public ue1 o;
    public View p;
    public View q;
    public e r;
    public e s;
    public float t;
    public int u;
    public float v;
    public boolean w;
    public boolean x;
    public float y;
    public float z;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SlidingUpPanelLayout.this.isEnabled() && SlidingUpPanelLayout.this.v()) {
                e eVar = SlidingUpPanelLayout.this.r;
                e eVar2 = e.EXPANDED;
                if (eVar != eVar2) {
                    e eVar3 = SlidingUpPanelLayout.this.r;
                    e eVar4 = e.ANCHORED;
                    if (eVar3 != eVar4) {
                        if (SlidingUpPanelLayout.this.v < 1.0f) {
                            SlidingUpPanelLayout.this.setPanelState(eVar4);
                            return;
                        } else {
                            SlidingUpPanelLayout.this.setPanelState(eVar2);
                            return;
                        }
                    }
                }
                SlidingUpPanelLayout.this.setPanelState(e.COLLAPSED);
            }
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[e.values().length];
            a = iArr;
            try {
                iArr[e.EXPANDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[e.ANCHORED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[e.HIDDEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[e.COLLAPSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public class c extends ve1.c {
        public c() {
        }

        @Override // dc.ve1.c
        public int b(View view, int i, int i2) {
            int iQ = SlidingUpPanelLayout.this.q(0.0f);
            int iQ2 = SlidingUpPanelLayout.this.q(1.0f);
            return SlidingUpPanelLayout.this.h ? Math.min(Math.max(i, iQ2), iQ) : Math.min(Math.max(i, iQ), iQ2);
        }

        @Override // dc.ve1.c
        public int e(View view) {
            return SlidingUpPanelLayout.this.u;
        }

        @Override // dc.ve1.c
        public void i(View view, int i) {
            SlidingUpPanelLayout.this.y();
        }

        @Override // dc.ve1.c
        public void j(int i) {
            if (SlidingUpPanelLayout.this.F == null || SlidingUpPanelLayout.this.F.w() != 0) {
                return;
            }
            SlidingUpPanelLayout slidingUpPanelLayout = SlidingUpPanelLayout.this;
            slidingUpPanelLayout.t = slidingUpPanelLayout.r(slidingUpPanelLayout.p.getTop());
            SlidingUpPanelLayout.this.p();
            if (SlidingUpPanelLayout.this.t == 1.0f) {
                SlidingUpPanelLayout.this.B();
                SlidingUpPanelLayout.this.setPanelStateInternal(e.EXPANDED);
            } else if (SlidingUpPanelLayout.this.t == 0.0f) {
                SlidingUpPanelLayout.this.setPanelStateInternal(e.COLLAPSED);
            } else if (SlidingUpPanelLayout.this.t < 0.0f) {
                SlidingUpPanelLayout.this.setPanelStateInternal(e.HIDDEN);
                SlidingUpPanelLayout.this.p.setVisibility(4);
            } else {
                SlidingUpPanelLayout.this.B();
                SlidingUpPanelLayout.this.setPanelStateInternal(e.ANCHORED);
            }
        }

        @Override // dc.ve1.c
        public void k(View view, int i, int i2, int i3, int i4) {
            SlidingUpPanelLayout.this.x(i2);
            SlidingUpPanelLayout.this.invalidate();
        }

        @Override // dc.ve1.c
        public void l(View view, float f, float f2) {
            int iQ;
            if (SlidingUpPanelLayout.this.h) {
                f2 = -f2;
            }
            if (f2 > 0.0f && SlidingUpPanelLayout.this.t <= SlidingUpPanelLayout.this.v) {
                SlidingUpPanelLayout slidingUpPanelLayout = SlidingUpPanelLayout.this;
                iQ = slidingUpPanelLayout.q(slidingUpPanelLayout.v);
            } else if (f2 > 0.0f && SlidingUpPanelLayout.this.t > SlidingUpPanelLayout.this.v) {
                iQ = SlidingUpPanelLayout.this.q(1.0f);
            } else if (f2 < 0.0f && SlidingUpPanelLayout.this.t >= SlidingUpPanelLayout.this.v) {
                SlidingUpPanelLayout slidingUpPanelLayout2 = SlidingUpPanelLayout.this;
                iQ = slidingUpPanelLayout2.q(slidingUpPanelLayout2.v);
            } else if (f2 < 0.0f && SlidingUpPanelLayout.this.t < SlidingUpPanelLayout.this.v) {
                iQ = SlidingUpPanelLayout.this.q(0.0f);
            } else if (SlidingUpPanelLayout.this.t >= (SlidingUpPanelLayout.this.v + 1.0f) / 2.0f) {
                iQ = SlidingUpPanelLayout.this.q(1.0f);
            } else if (SlidingUpPanelLayout.this.t >= SlidingUpPanelLayout.this.v / 2.0f) {
                SlidingUpPanelLayout slidingUpPanelLayout3 = SlidingUpPanelLayout.this;
                iQ = slidingUpPanelLayout3.q(slidingUpPanelLayout3.v);
            } else {
                iQ = SlidingUpPanelLayout.this.q(0.0f);
            }
            if (SlidingUpPanelLayout.this.F != null) {
                SlidingUpPanelLayout.this.F.H(view.getLeft(), iQ);
            }
            SlidingUpPanelLayout.this.invalidate();
        }

        @Override // dc.ve1.c
        public boolean m(View view, int i) {
            return !SlidingUpPanelLayout.this.w && view == SlidingUpPanelLayout.this.p;
        }

        public /* synthetic */ c(SlidingUpPanelLayout slidingUpPanelLayout, a aVar) {
            this();
        }
    }

    public interface d {
        void a(View view, e eVar, e eVar2);

        void onPanelSlide(View view, float f);
    }

    public enum e {
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
    public void setPanelStateInternal(e eVar) {
        e eVar2 = this.r;
        if (eVar2 == eVar) {
            return;
        }
        this.r = eVar;
        t(this, eVar2, eVar);
    }

    public static boolean u(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    public void A() {
        z(0.0f, 0);
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
        if (view == null || !u(view)) {
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
        ve1 ve1Var = this.F;
        if (ve1Var == null || !ve1Var.l(true)) {
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
        if (!isEnabled() || !v() || (this.w && actionMasked != 0)) {
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
            if (!w(this.m, (int) this.A, (int) this.B)) {
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
                if (!this.C && this.F.y()) {
                    this.F.b();
                    motionEvent.setAction(0);
                }
                this.C = true;
                return super.dispatchTouchEvent(motionEvent);
            }
        } else if (actionMasked == 1 && this.C) {
            this.F.F(0);
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
        int iSave = canvas.save(2);
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

    public e getPanelState() {
        return this.r;
    }

    public int getShadowHeight() {
        return this.f;
    }

    public void o(d dVar) {
        synchronized (this.D) {
            this.D.add(dVar);
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
            boolean r0 = r8.v()
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
            dc.ve1 r6 = r8.F
            int r6 = r6.v()
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
            dc.ve1 r9 = r8.F
            r9.b()
            r8.w = r7
            return r1
        L4c:
            dc.ve1 r0 = r8.F
            boolean r0 = r0.y()
            if (r0 == 0) goto L5a
            dc.ve1 r0 = r8.F
            r0.A(r9)
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
            boolean r0 = r8.w(r0, r2, r3)
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
            boolean r0 = r8.w(r0, r2, r3)
            if (r0 != 0) goto L9d
            dc.ve1 r9 = r8.F
            r9.b()
            r8.w = r7
            return r1
        L9d:
            dc.ve1 r0 = r8.F
            boolean r9 = r0.I(r9)
            return r9
        La4:
            dc.ve1 r9 = r8.F
            r9.a()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sothree.slidinguppanel.SlidingUpPanelLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.G) {
            int i5 = b.a[this.r.ordinal()];
            if (i5 == 1) {
                this.t = 1.0f;
            } else if (i5 == 2) {
                this.t = this.v;
            } else if (i5 != 3) {
                this.t = 0.0f;
            } else {
                this.t = r(q(0.0f) + (this.h ? this.e : -this.e));
            }
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 || (i6 != 0 && !this.G)) {
                int measuredHeight = childAt.getMeasuredHeight();
                int iQ = childAt == this.p ? q(this.t) : paddingTop;
                if (!this.h && childAt == this.q && !this.i) {
                    iQ = q(this.t) + this.p.getMeasuredHeight();
                }
                int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                childAt.layout(i7, iQ, childAt.getMeasuredWidth() + i7, measuredHeight + iQ);
            }
        }
        if (this.G) {
            B();
        }
        p();
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
        View childAt = getChildAt(1);
        this.p = childAt;
        if (this.k == null) {
            setDragView(childAt);
        }
        if (this.p.getVisibility() != 0) {
            this.r = e.HIDDEN;
        }
        int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt2 = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
            if (childAt2.getVisibility() != 8 || i5 != 0) {
                if (childAt2 == this.q) {
                    i3 = (this.i || this.r == e.HIDDEN) ? paddingTop : paddingTop - this.e;
                    i4 = paddingLeft - (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                } else {
                    i3 = childAt2 == this.p ? paddingTop - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin : paddingTop;
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
                childAt2.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
                View view = this.p;
                if (childAt2 == view) {
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
            e eVar = (e) bundle.getSerializable("sliding_state");
            this.r = eVar;
            if (eVar == null) {
                eVar = M;
            }
            this.r = eVar;
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        e eVar = this.r;
        if (eVar == e.DRAGGING) {
            eVar = this.s;
        }
        bundle.putSerializable("sliding_state", eVar);
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
        if (!isEnabled() || !v()) {
            return super.onTouchEvent(motionEvent);
        }
        try {
            this.F.A(motionEvent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public final void p() {
        if (this.g > 0) {
            ViewCompat.setTranslationY(this.q, getCurrentParallaxOffset());
        }
    }

    public final int q(float f) {
        View view = this.p;
        int i = (int) (f * this.u);
        return this.h ? ((getMeasuredHeight() - getPaddingBottom()) - this.e) - i : (getPaddingTop() - (view != null ? view.getMeasuredHeight() : 0)) + this.e + i;
    }

    public final float r(int i) {
        int iQ = q(0.0f);
        return (this.h ? iQ - i : i - iQ) / this.u;
    }

    public void s(View view) {
        synchronized (this.D) {
            Iterator<d> it = this.D.iterator();
            while (it.hasNext()) {
                it.next().onPanelSlide(view, this.t);
            }
        }
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
            this.k.setOnClickListener(new a());
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
        if (getPanelState() == e.COLLAPSED) {
            A();
            invalidate();
        }
    }

    public void setPanelState(e eVar) {
        e eVar2;
        e eVar3;
        if (this.F.w() == 2) {
            this.F.a();
        }
        if (eVar == null || eVar == (eVar2 = e.DRAGGING)) {
            throw new IllegalArgumentException("Panel state cannot be null or DRAGGING.");
        }
        if (isEnabled()) {
            boolean z = this.G;
            if ((!z && this.p == null) || eVar == (eVar3 = this.r) || eVar3 == eVar2) {
                return;
            }
            if (z) {
                setPanelStateInternal(eVar);
                return;
            }
            if (eVar3 == e.HIDDEN) {
                this.p.setVisibility(0);
                requestLayout();
            }
            int i = b.a[eVar.ordinal()];
            if (i == 1) {
                z(1.0f, 0);
                return;
            }
            if (i == 2) {
                z(this.v, 0);
            } else if (i == 3) {
                z(r(q(0.0f) + (this.h ? this.e : -this.e)), 0);
            } else {
                if (i != 4) {
                    return;
                }
                z(0.0f, 0);
            }
        }
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

    public void setScrollableViewHelper(ue1 ue1Var) {
        this.o = ue1Var;
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

    public void t(View view, e eVar, e eVar2) {
        synchronized (this.D) {
            Iterator<d> it = this.D.iterator();
            while (it.hasNext()) {
                it.next().a(view, eVar, eVar2);
            }
        }
        sendAccessibilityEvent(32);
    }

    public boolean v() {
        return (!this.x || this.p == null || this.r == e.HIDDEN) ? false : true;
    }

    public final boolean w(View view, int i, int i2) {
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

    public final void x(int i) {
        e eVar = this.r;
        e eVar2 = e.DRAGGING;
        if (eVar != eVar2) {
            this.s = eVar;
        }
        setPanelStateInternal(eVar2);
        this.t = r(i);
        p();
        s(this.p);
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

    public void y() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    public boolean z(float f, int i) {
        if (isEnabled() && this.p != null) {
            int iQ = q(f);
            ve1 ve1Var = this.F;
            View view = this.p;
            if (ve1Var.J(view, view.getLeft(), iQ)) {
                y();
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

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SlidingUpPanelLayout(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sothree.slidinguppanel.SlidingUpPanelLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setDragView(int i) {
        this.l = i;
        setDragView(findViewById(i));
    }
}
