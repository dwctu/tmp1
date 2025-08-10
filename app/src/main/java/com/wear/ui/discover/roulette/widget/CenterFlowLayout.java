package com.wear.ui.discover.roulette.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import dc.vi1;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class CenterFlowLayout extends ViewGroup {
    public int a;
    public int b;
    public List<Integer> c;
    public List<Integer> d;
    public int e;

    public static class CenterLayoutParams extends ViewGroup.MarginLayoutParams {
        public CenterLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public CenterLayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public CenterFlowLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof CenterLayoutParams;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new CenterLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int measuredWidth = (getMeasuredWidth() - getPaddingRight()) - paddingLeft;
        int i8 = 0;
        int i9 = 0;
        while (i8 < this.e) {
            Integer num = this.d.get(i8);
            int iIntValue = ((measuredWidth - this.c.get(i8).intValue()) / 2) + paddingLeft;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (i10 < num.intValue()) {
                int i13 = i9 + 1;
                View childAt = getChildAt(i9);
                if (childAt.getVisibility() == 8) {
                    i5 = paddingLeft;
                    i6 = measuredWidth;
                } else {
                    int measuredWidth2 = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    CenterLayoutParams centerLayoutParams = (CenterLayoutParams) childAt.getLayoutParams();
                    if (centerLayoutParams != null) {
                        int i14 = ((ViewGroup.MarginLayoutParams) centerLayoutParams).rightMargin;
                        i5 = paddingLeft;
                        int i15 = ((ViewGroup.MarginLayoutParams) centerLayoutParams).topMargin;
                        int i16 = ((ViewGroup.MarginLayoutParams) centerLayoutParams).bottomMargin;
                        i6 = measuredWidth;
                        if (num.intValue() <= 1 || i10 != 0) {
                            i7 = i14;
                        } else {
                            i7 = i14;
                            i12 = i15 + i16;
                        }
                    } else {
                        i5 = paddingLeft;
                        i6 = measuredWidth;
                        i7 = 0;
                    }
                    childAt.layout(iIntValue, paddingTop, iIntValue + measuredWidth2, paddingTop + measuredHeight);
                    if (i11 < measuredHeight) {
                        i11 = measuredHeight;
                    }
                    iIntValue += measuredWidth2 + this.a + i7;
                }
                i10++;
                paddingLeft = i5;
                measuredWidth = i6;
                i9 = i13;
            }
            paddingTop += i11 + this.b + i12;
            i8++;
            paddingLeft = paddingLeft;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        View view;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        super.onMeasure(i, i2);
        this.d.clear();
        this.c.clear();
        this.e = 0;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        int iMax = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (i12 < childCount) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() == 8) {
                i7 = i12;
            } else {
                CenterLayoutParams centerLayoutParams = (CenterLayoutParams) childAt.getLayoutParams();
                if (centerLayoutParams instanceof ViewGroup.MarginLayoutParams) {
                    i5 = iMax;
                    i6 = i11;
                    i7 = i12;
                    measureChildWithMargins(childAt, i, 0, i2, 0);
                    int i19 = ((ViewGroup.MarginLayoutParams) centerLayoutParams).rightMargin;
                    int i20 = ((ViewGroup.MarginLayoutParams) centerLayoutParams).topMargin;
                    i10 = ((ViewGroup.MarginLayoutParams) centerLayoutParams).bottomMargin;
                    i9 = i20;
                    i8 = i19;
                    view = childAt;
                } else {
                    view = childAt;
                    i5 = iMax;
                    i6 = i11;
                    i7 = i12;
                    measureChild(view, i, i2);
                    i8 = 0;
                    i9 = 0;
                    i10 = 0;
                }
                int measuredWidth = view.getMeasuredWidth() + this.a + i8;
                int measuredHeight = view.getMeasuredHeight() + this.b + i10 + i9;
                i15 += measuredWidth;
                int i21 = i6;
                int iMax2 = Math.max(i21, measuredWidth) + i21;
                int i22 = i16 + measuredWidth;
                if (i22 > paddingLeft) {
                    this.c.add(Integer.valueOf(((i15 - measuredWidth) - this.a) - i8));
                    i17++;
                    iMax = i5 + measuredHeight;
                    this.d.add(Integer.valueOf(i18));
                    i14 += i18;
                    i15 = measuredWidth;
                    i16 = i15;
                    i13 = i7;
                    i18 = 1;
                    i11 = iMax2;
                } else {
                    i18++;
                    i11 = iMax2;
                    i16 = i22;
                    iMax = Math.max(i5, measuredHeight);
                }
            }
            i12 = i7 + 1;
        }
        int i23 = iMax;
        int i24 = i11;
        int i25 = i13;
        int measuredWidth2 = 0;
        int i26 = 0;
        while (i25 < childCount) {
            View childAt2 = getChildAt(i25);
            CenterLayoutParams centerLayoutParams2 = (CenterLayoutParams) childAt2.getLayoutParams();
            if (centerLayoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                i4 = ((ViewGroup.MarginLayoutParams) centerLayoutParams2).rightMargin;
                i3 = i4;
            } else {
                i3 = i26;
                i4 = 0;
            }
            measuredWidth2 += childAt2.getMeasuredWidth() + this.a + i4;
            i25++;
            i26 = i3;
        }
        int i27 = childCount - i14;
        int i28 = this.a;
        if (i28 != 0) {
            i26 = i28;
        }
        this.c.add(Integer.valueOf(measuredWidth2 - i26));
        this.d.add(Integer.valueOf(i27));
        this.e = i17 + 1;
        int iMax3 = Math.max(i24, getSuggestedMinimumWidth()) + getPaddingRight() + getPaddingLeft();
        int iMax4 = Math.max(i23, getSuggestedMinimumHeight()) + getPaddingTop() + getPaddingBottom();
        if (mode != 1073741824) {
            size = iMax3;
        }
        if (mode2 != 1073741824) {
            size2 = iMax4;
        }
        setMeasuredDimension(ViewGroup.resolveSize(size, i), ViewGroup.resolveSize(size2, i2));
    }

    public void setChildSpacing(int i) {
        this.a = i;
        requestLayout();
    }

    public void setRowSpacing(int i) {
        this.b = i;
        requestLayout();
    }

    public CenterFlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new CenterLayoutParams(getContext(), attributeSet);
    }

    public CenterFlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        this.b = 0;
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = 0;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, vi1.CenterFlowLayout, 0, 0);
        this.a = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.b = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        typedArrayObtainStyledAttributes.recycle();
    }
}
