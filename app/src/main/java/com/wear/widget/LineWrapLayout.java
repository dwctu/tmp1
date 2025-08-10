package com.wear.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import dc.vi1;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class LineWrapLayout extends ViewGroup {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public List<Integer> g;
    public List<Integer> h;

    public LineWrapLayout(Context context) {
        super(context);
        this.a = 10;
        this.b = 10;
        this.c = 10;
        this.d = 10;
        this.e = 10;
        this.f = 5;
    }

    public final void a(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, vi1.AutoLineFeedLayout);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            switch (index) {
                case 1:
                    this.e = (int) typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
                    break;
                case 2:
                    this.d = (int) typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
                    break;
                case 3:
                    this.a = (int) typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
                    break;
                case 4:
                    this.b = (int) typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
                    break;
                case 5:
                    this.c = (int) typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
                    break;
                case 6:
                    this.f = (int) typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
                    break;
            }
        }
        this.g = new ArrayList();
        this.h = new ArrayList();
    }

    public final int b(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return size;
        }
        return 400;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        String str = "--- onLayout changed :" + z + " l :" + i + ",t :" + i2 + ",r :" + i3 + ",b :" + i4;
        int childCount = getChildCount();
        String str2 = "宽度 :" + getWidth();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int iIntValue = this.g.get(i5).intValue();
            int iIntValue2 = this.h.get(i5).intValue();
            childAt.layout(iIntValue, iIntValue2, measuredWidth + iIntValue, measuredHeight + iIntValue2);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int childCount = getChildCount();
        int iB = b(i);
        String str = "宽度 :" + iB;
        int i4 = this.a;
        int i5 = this.c + 0;
        this.g.clear();
        this.h.clear();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            childAt.measure(0, 0);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            String str2 = "childWidth :" + measuredWidth + " childHeight :" + measuredHeight;
            int i7 = i4 + measuredWidth;
            if (i7 > iB - this.b && i4 > (i3 = this.a)) {
                i5 += this.f + measuredHeight;
                i4 = i3;
            }
            String str3 = "measure child :" + i4 + ", " + i5 + ", " + i7 + ", " + (measuredHeight + i5);
            this.g.add(Integer.valueOf(i4));
            this.h.add(Integer.valueOf(i5));
            i4 = i4 + measuredWidth + this.e;
        }
        View childAt2 = getChildAt(childCount - 1);
        setMeasuredDimension(b(i), i5 + (childAt2 != null ? childAt2.getMeasuredHeight() : 0) + this.d);
    }

    public LineWrapLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 10;
        this.b = 10;
        this.c = 10;
        this.d = 10;
        this.e = 10;
        this.f = 5;
        a(attributeSet);
    }

    public LineWrapLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 10;
        this.b = 10;
        this.c = 10;
        this.d = 10;
        this.e = 10;
        this.f = 5;
        a(attributeSet);
    }
}
