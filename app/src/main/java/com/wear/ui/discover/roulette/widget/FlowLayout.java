package com.wear.ui.discover.roulette.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.internal.view.SupportMenu;
import dc.vi1;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class FlowLayout extends ViewGroup {
    public boolean a;
    public int b;
    public int c;
    public int d;
    public float e;
    public float f;
    public boolean g;
    public int h;
    public int i;
    public int j;
    public int k;
    public List<Float> l;
    public List<Integer> m;
    public List<Integer> n;
    public List<Integer> o;

    public FlowLayout(Context context) {
        this(context, null);
    }

    public final float a(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    public final int b(TypedArray typedArray, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        return typedValue.type == 5 ? typedArray.getDimensionPixelSize(i, i2) : typedArray.getInt(i, i2);
    }

    public final int c(int i, int i2, int i3, int i4) {
        if (this.b == -65536 || i4 >= this.n.size() || i4 >= this.o.size() || this.o.get(i4).intValue() <= 0) {
            return 0;
        }
        if (i == 1) {
            return ((i2 - i3) - this.n.get(i4).intValue()) / 2;
        }
        if (i != 5) {
            return 0;
        }
        return (i2 - i3) - this.n.get(i4).intValue();
    }

    public final float d(int i, int i2, int i3, int i4) {
        if (i != -65536) {
            return i;
        }
        if (i4 > 1) {
            return (i2 - i3) / (i4 - 1);
        }
        return 0.0f;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public int getChildSpacing() {
        return this.b;
    }

    public int getChildSpacingForLastRow() {
        return this.d;
    }

    public int getMaxRows() {
        return this.h;
    }

    public int getMinChildSpacing() {
        return this.c;
    }

    public float getRowSpacing() {
        return this.e;
    }

    public int getRowsCount() {
        return this.o.size();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0172  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r24, int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.roulette.widget.FlowLayout.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int iMin;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        float f;
        int i10;
        int i11;
        int i12;
        int i13;
        View view;
        int i14;
        int i15;
        int measuredWidth;
        int i16;
        int i17;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        this.l.clear();
        this.m.clear();
        this.n.clear();
        this.o.clear();
        int childCount = getChildCount();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        boolean z = mode != 0 && this.a;
        int i18 = this.b;
        int i19 = (i18 == -65536 && mode == 0) ? 0 : i18;
        float f2 = i19 == -65536 ? this.c : i19;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int iMax = 0;
        int i23 = 0;
        int i24 = 0;
        int iMax2 = 0;
        while (i22 < childCount) {
            float f3 = f2;
            View childAt = getChildAt(i22);
            int i25 = i20;
            if (childAt.getVisibility() == 8) {
                i5 = i22;
                i16 = i19;
                i7 = mode;
                i8 = mode2;
                i9 = childCount;
                f = f3;
                measuredWidth = i21;
                i11 = size;
                i17 = i25;
                i12 = size2;
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    i9 = childCount;
                    i10 = i25;
                    i12 = size2;
                    i13 = i21;
                    i5 = i22;
                    i8 = mode2;
                    f = f3;
                    i11 = size;
                    view = childAt;
                    i6 = i19;
                    i7 = mode;
                    measureChildWithMargins(childAt, i, 0, i2, i24);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i14 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                    i15 = marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                } else {
                    i5 = i22;
                    i6 = i19;
                    i7 = mode;
                    i8 = mode2;
                    i9 = childCount;
                    f = f3;
                    i10 = i25;
                    i11 = size;
                    i12 = size2;
                    i13 = i21;
                    view = childAt;
                    measureChild(view, i, i2);
                    i14 = 0;
                    i15 = 0;
                }
                measuredWidth = i14 + view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight() + i15;
                if (!z || i23 + measuredWidth <= paddingLeft) {
                    i16 = i6;
                    i17 = i10 + 1;
                    i23 = (int) (i23 + measuredWidth + f);
                    measuredWidth += i13;
                    iMax2 = Math.max(iMax2, measuredHeight);
                } else {
                    i16 = i6;
                    this.l.add(Float.valueOf(d(i16, paddingLeft, i13, i10)));
                    this.o.add(Integer.valueOf(i10));
                    this.m.add(Integer.valueOf(iMax2));
                    int i26 = (int) f;
                    this.n.add(Integer.valueOf(i23 - i26));
                    if (this.l.size() <= this.h) {
                        i24 += iMax2;
                    }
                    iMax = Math.max(iMax, i23);
                    i23 = measuredWidth + i26;
                    iMax2 = measuredHeight;
                    i17 = 1;
                }
            }
            i21 = measuredWidth;
            i22 = i5 + 1;
            i19 = i16;
            i20 = i17;
            f2 = f;
            size = i11;
            size2 = i12;
            mode = i7;
            childCount = i9;
            mode2 = i8;
        }
        int i27 = i20;
        int i28 = i19;
        int i29 = size;
        int i30 = mode;
        int i31 = size2;
        int i32 = mode2;
        int i33 = i21;
        float f4 = f2;
        int i34 = iMax2;
        int i35 = this.d;
        if (i35 == -65537) {
            if (this.l.size() >= 1) {
                List<Float> list = this.l;
                list.add(list.get(list.size() - 1));
            } else {
                this.l.add(Float.valueOf(d(i28, paddingLeft, i33, i27)));
            }
        } else if (i35 != -65538) {
            this.l.add(Float.valueOf(d(i35, paddingLeft, i33, i27)));
        } else {
            this.l.add(Float.valueOf(d(i28, paddingLeft, i33, i27)));
        }
        this.o.add(Integer.valueOf(i27));
        this.m.add(Integer.valueOf(i34));
        this.n.add(Integer.valueOf(i23 - ((int) f4)));
        if (this.l.size() <= this.h) {
            i24 += i34;
        }
        int iMax3 = Math.max(iMax, i23);
        if (i28 == -65536) {
            iMin = i29;
            i3 = iMin;
        } else if (i30 == 0) {
            iMin = iMax3 + getPaddingLeft() + getPaddingRight();
            i3 = i29;
        } else {
            i3 = i29;
            iMin = Math.min(iMax3 + getPaddingLeft() + getPaddingRight(), i3);
        }
        int paddingTop = i24 + getPaddingTop() + getPaddingBottom();
        int iMin2 = Math.min(this.l.size(), this.h);
        float f5 = this.e;
        if (f5 == -65536.0f && i32 == 0) {
            f5 = 0.0f;
        }
        if (f5 == -65536.0f) {
            if (iMin2 > 1) {
                this.f = (i31 - paddingTop) / (iMin2 - 1);
            } else {
                this.f = 0.0f;
            }
            paddingTop = i31;
            i4 = paddingTop;
        } else {
            this.f = f5;
            if (iMin2 <= 1) {
                i4 = i31;
            } else if (i32 == 0) {
                paddingTop = (int) (paddingTop + (f5 * (iMin2 - 1)));
                i4 = i31;
            } else {
                int i36 = (int) (paddingTop + (f5 * (iMin2 - 1)));
                i4 = i31;
                paddingTop = Math.min(i36, i4);
            }
        }
        this.k = paddingTop;
        setMeasuredDimension(i30 == 1073741824 ? i3 : iMin, i32 == 1073741824 ? i4 : paddingTop);
    }

    public void setChildSpacing(int i) {
        this.b = i;
        requestLayout();
    }

    public void setChildSpacingForLastRow(int i) {
        this.d = i;
        requestLayout();
    }

    public void setFlow(boolean z) {
        this.a = z;
        requestLayout();
    }

    public void setGravity(int i) {
        if (this.i != i) {
            this.i = i;
            requestLayout();
        }
    }

    public void setMaxRows(int i) {
        this.h = i;
        requestLayout();
    }

    public void setMinChildSpacing(int i) {
        this.c = i;
        requestLayout();
    }

    public void setRowSpacing(float f) {
        this.e = f;
        requestLayout();
    }

    public void setRowVerticalGravity(int i) {
        if (this.j != i) {
            this.j = i;
            requestLayout();
        }
    }

    public void setRtl(boolean z) {
        this.g = z;
        requestLayout();
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
        this.b = 0;
        this.c = 0;
        this.d = -65538;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = false;
        this.h = Integer.MAX_VALUE;
        this.i = -1;
        this.j = SupportMenu.CATEGORY_MASK;
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, vi1.FlowLayout, 0, 0);
        try {
            this.a = typedArrayObtainStyledAttributes.getBoolean(3, true);
            this.b = b(typedArrayObtainStyledAttributes, 1, (int) a(0.0f));
            this.c = b(typedArrayObtainStyledAttributes, 5, (int) a(0.0f));
            this.d = b(typedArrayObtainStyledAttributes, 2, -65538);
            this.e = b(typedArrayObtainStyledAttributes, 6, (int) a(0.0f));
            this.h = typedArrayObtainStyledAttributes.getInt(4, Integer.MAX_VALUE);
            this.g = typedArrayObtainStyledAttributes.getBoolean(8, false);
            this.i = typedArrayObtainStyledAttributes.getInt(0, -1);
            this.j = typedArrayObtainStyledAttributes.getInt(7, SupportMenu.CATEGORY_MASK);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }
}
