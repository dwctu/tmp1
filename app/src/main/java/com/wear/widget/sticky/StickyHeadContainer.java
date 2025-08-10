package com.wear.widget.sticky;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes4.dex */
public class StickyHeadContainer extends ViewGroup {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public a g;

    public interface a {
        void a(int i);
    }

    public StickyHeadContainer(Context context) {
        this(context, null);
    }

    public void a(int i) {
        a aVar = this.g;
        if (aVar != null && this.b != i) {
            aVar.a(i);
        }
        this.b = i;
    }

    public void b() {
        this.b = Integer.MIN_VALUE;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public int getChildHeight() {
        return getChildAt(0).getHeight();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        this.c = paddingLeft + marginLayoutParams.leftMargin;
        this.d = childAt.getMeasuredWidth() + this.c;
        this.e = paddingTop + marginLayoutParams.topMargin + this.a;
        int measuredHeight = childAt.getMeasuredHeight();
        int i5 = this.e;
        int i6 = measuredHeight + i5;
        this.f = i6;
        childAt.layout(this.c, i5, this.d, i6);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (getChildCount() != 1) {
            throw new IllegalArgumentException("只允许容器添加1个子View！");
        }
        View childAt = getChildAt(0);
        measureChildWithMargins(childAt, i, 0, i2, 0);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
        int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
        int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(ViewGroup.resolveSize(Math.max(paddingLeft, getSuggestedMinimumWidth()), i), ViewGroup.resolveSize(Math.max(paddingTop, getSuggestedMinimumHeight()), i2));
    }

    public void setDataCallback(a aVar) {
        this.g = aVar;
    }

    public StickyHeadContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public StickyHeadContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = Integer.MIN_VALUE;
    }
}
