package com.wear.widget.swipe;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import dc.ft3;
import dc.vi1;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class EasySwipeMenuLayout extends ViewGroup {
    public static EasySwipeMenuLayout s;
    public static ft3 t;
    public final ArrayList<View> a;
    public int b;
    public int c;
    public int d;
    public View e;
    public View f;
    public View g;
    public ViewGroup.MarginLayoutParams h;
    public boolean i;
    public PointF j;
    public PointF k;
    public float l;
    public boolean m;
    public boolean n;
    public int o;
    public Scroller p;
    public float q;
    public ft3 r;

    public EasySwipeMenuLayout(Context context) {
        this(context, null);
    }

    public static ft3 getStateCache() {
        return t;
    }

    public static EasySwipeMenuLayout getViewCache() {
        return s;
    }

    public final void a(ft3 ft3Var) {
        if (ft3Var == ft3.LEFTOPEN) {
            this.p.startScroll(getScrollX(), 0, this.e.getLeft() - getScrollX(), 0);
            s = this;
            t = ft3Var;
        } else if (ft3Var == ft3.RIGHTOPEN) {
            s = this;
            this.p.startScroll(getScrollX(), 0, ((this.f.getRight() - this.g.getRight()) - this.h.rightMargin) - getScrollX(), 0);
            t = ft3Var;
        } else {
            this.p.startScroll(getScrollX(), 0, -getScrollX(), 0);
            s = null;
            t = null;
        }
        invalidate();
    }

    public final void b(Context context, AttributeSet attributeSet, int i) {
        this.o = ViewConfiguration.get(context).getScaledTouchSlop();
        this.p = new Scroller(context);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, vi1.EasySwipeMenuLayout, i, 0);
        try {
            try {
                int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
                for (int i2 = 0; i2 < indexCount; i2++) {
                    int index = typedArrayObtainStyledAttributes.getIndex(i2);
                    if (index == 4) {
                        this.b = typedArrayObtainStyledAttributes.getResourceId(4, -1);
                    } else if (index == 5) {
                        this.c = typedArrayObtainStyledAttributes.getResourceId(5, -1);
                    } else if (index == 2) {
                        this.d = typedArrayObtainStyledAttributes.getResourceId(2, -1);
                    } else if (index == 0) {
                        this.m = typedArrayObtainStyledAttributes.getBoolean(0, true);
                    } else if (index == 1) {
                        this.n = typedArrayObtainStyledAttributes.getBoolean(1, true);
                    } else if (index == 3) {
                        this.l = typedArrayObtainStyledAttributes.getFloat(3, 0.5f);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final ft3 c(int i) {
        View view;
        View view2;
        if (this.o >= Math.abs(this.q)) {
            return t;
        }
        String str = ">>>finalyDistanceX:" + this.q;
        float f = this.q;
        if (f < 0.0f) {
            if (getScrollX() < 0 && (view2 = this.e) != null && Math.abs(view2.getWidth() * this.l) < Math.abs(getScrollX())) {
                return ft3.LEFTOPEN;
            }
            if (getScrollX() > 0 && this.f != null) {
                return ft3.CLOSE;
            }
        } else if (f > 0.0f) {
            if (getScrollX() > 0 && (view = this.f) != null && Math.abs(view.getWidth() * this.l) < Math.abs(getScrollX())) {
                return ft3.RIGHTOPEN;
            }
            if (getScrollX() < 0 && this.e != null) {
                return ft3.CLOSE;
            }
        }
        return ft3.CLOSE;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.p.computeScrollOffset()) {
            scrollTo(this.p.getCurrX(), this.p.getCurrY());
            invalidate();
        }
    }

    public void d() {
        ft3 ft3Var;
        Scroller scroller;
        if (s == null || (ft3Var = t) == null || ft3Var == ft3.CLOSE || (scroller = this.p) == null) {
            return;
        }
        scroller.startScroll(s.getScrollX(), 0, -s.getScrollX(), 0);
        s.invalidate();
        s = null;
        t = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00ca  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.swipe.EasySwipeMenuLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public float getFraction() {
        return this.l;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        EasySwipeMenuLayout easySwipeMenuLayout = s;
        if (this == easySwipeMenuLayout) {
            easySwipeMenuLayout.a(t);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        EasySwipeMenuLayout easySwipeMenuLayout = s;
        if (this == easySwipeMenuLayout) {
            easySwipeMenuLayout.a(ft3.CLOSE);
        }
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            int r0 = r4.getAction()
            r1 = 1
            if (r0 == r1) goto L1c
            r2 = 2
            if (r0 == r2) goto Le
            r2 = 3
            if (r0 == r2) goto L1c
            goto L27
        Le:
            float r0 = r3.q
            float r0 = java.lang.Math.abs(r0)
            int r2 = r3.o
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L27
            return r1
        L1c:
            boolean r0 = r3.i
            if (r0 == 0) goto L27
            r4 = 0
            r3.i = r4
            r4 = 0
            r3.q = r4
            return r1
        L27:
            boolean r4 = super.onInterceptTouchEvent(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.widget.swipe.EasySwipeMenuLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft() + 0;
        getPaddingLeft();
        int paddingTop = getPaddingTop() + 0;
        getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (this.e == null && childAt.getId() == this.b) {
                this.e = childAt;
                childAt.setClickable(true);
            } else if (this.f == null && childAt.getId() == this.c) {
                this.f = childAt;
                childAt.setClickable(true);
            } else if (this.g == null && childAt.getId() == this.d) {
                this.g = childAt;
                childAt.setClickable(true);
            }
        }
        View view = this.g;
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            this.h = marginLayoutParams;
            int i6 = marginLayoutParams.topMargin + paddingTop;
            int i7 = marginLayoutParams.leftMargin;
            this.g.layout(paddingLeft + i7, i6, paddingLeft + i7 + this.g.getMeasuredWidth(), this.g.getMeasuredHeight() + i6);
        }
        View view2 = this.e;
        if (view2 != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            int i8 = marginLayoutParams2.topMargin + paddingTop;
            int measuredWidth = (0 - this.e.getMeasuredWidth()) + marginLayoutParams2.leftMargin;
            int i9 = marginLayoutParams2.rightMargin;
            this.e.layout(measuredWidth + i9, i8, 0 - i9, this.e.getMeasuredHeight() + i8);
        }
        View view3 = this.f;
        if (view3 != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) view3.getLayoutParams();
            int i10 = paddingTop + marginLayoutParams3.topMargin;
            int right = this.g.getRight() + this.h.rightMargin + marginLayoutParams3.leftMargin;
            this.f.layout(right, i10, this.f.getMeasuredWidth() + right, this.f.getMeasuredHeight() + i10);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setClickable(true);
        int childCount = getChildCount();
        boolean z = (View.MeasureSpec.getMode(i) == 1073741824 && View.MeasureSpec.getMode(i2) == 1073741824) ? false : true;
        this.a.clear();
        int iCombineMeasuredStates = 0;
        int iMax = 0;
        int iMax2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                measureChildWithMargins(childAt, i, 0, i2, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                iMax = Math.max(iMax, childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
                iMax2 = Math.max(iMax2, childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
                iCombineMeasuredStates = ViewGroup.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
                if (z && (marginLayoutParams.width == -1 || marginLayoutParams.height == -1)) {
                    this.a.add(childAt);
                }
            }
        }
        int i4 = iCombineMeasuredStates;
        setMeasuredDimension(ViewGroup.resolveSizeAndState(Math.max(iMax, getSuggestedMinimumWidth()), i, i4), ViewGroup.resolveSizeAndState(Math.max(iMax2, getSuggestedMinimumHeight()), i2, i4 << 16));
        int size = this.a.size();
        if (size > 1) {
            for (int i5 = 0; i5 < size; i5++) {
                View view = this.a.get(i5);
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int i6 = marginLayoutParams2.width;
                int iMakeMeasureSpec = i6 == -1 ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (getMeasuredWidth() - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin), 1073741824) : ViewGroup.getChildMeasureSpec(i, marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin, i6);
                int i7 = marginLayoutParams2.height;
                view.measure(iMakeMeasureSpec, i7 == -1 ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (getMeasuredHeight() - marginLayoutParams2.topMargin) - marginLayoutParams2.bottomMargin), 1073741824) : ViewGroup.getChildMeasureSpec(i2, marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin, i7));
            }
        }
    }

    public void setCanLeftSwipe(boolean z) {
        this.m = z;
    }

    public void setCanRightSwipe(boolean z) {
        this.n = z;
    }

    public void setFraction(float f) {
        this.l = f;
    }

    public EasySwipeMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EasySwipeMenuLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new ArrayList<>(1);
        this.l = 0.3f;
        this.m = true;
        this.n = true;
        b(context, attributeSet, i);
    }
}
