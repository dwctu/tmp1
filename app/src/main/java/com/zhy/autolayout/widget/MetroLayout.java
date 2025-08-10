package com.zhy.autolayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import dc.cv3;
import dc.dv3;
import dc.xv3;
import dc.yv3;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* loaded from: classes4.dex */
public class MetroLayout extends ViewGroup {
    public final xv3 a;
    public List<b> b;
    public int c;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements xv3.a {
        public cv3 a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = xv3.b(context, attributeSet);
        }

        @Override // dc.xv3.a
        public cv3 a() {
            return this.a;
        }
    }

    public static class b {
        public int a;
        public int b;
        public int c;

        public b() {
        }
    }

    public MetroLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new xv3(this);
        this.b = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, dv3.MetroLayout);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(dv3.MetroLayout_metro_divider, 0);
        this.c = dimensionPixelOffset;
        this.c = yv3.h(dimensionPixelOffset);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final b a(View view) {
        b bVar = new b();
        if (this.b.size() == 0) {
            bVar.a = getPaddingLeft();
            bVar.b = getPaddingTop();
            bVar.c = getMeasuredWidth();
            return bVar;
        }
        int i = this.b.get(0).b;
        b bVar2 = this.b.get(0);
        for (b bVar3 : this.b) {
            int i2 = bVar3.b;
            if (i2 < i) {
                bVar2 = bVar3;
                i = i2;
            }
        }
        return bVar2;
    }

    @Override // android.view.ViewGroup
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public final void c() {
        this.b.clear();
        b bVar = new b();
        bVar.a = getPaddingLeft();
        bVar.b = getPaddingTop();
        bVar.c = getMeasuredWidth();
        this.b.add(bVar);
    }

    public final void d() {
        b bVar;
        if (this.b.size() <= 1) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        b bVar2 = this.b.get(0);
        b bVar3 = this.b.get(1);
        int size = this.b.size();
        for (int i = 1; i < size - 1; i++) {
            if (bVar2.b == bVar3.b) {
                bVar2.c += bVar3.c;
                arrayList.add(bVar2);
                bVar3.a = bVar2.a;
                bVar = this.b.get(i + 1);
            } else {
                bVar2 = this.b.get(i);
                bVar = this.b.get(i + 1);
            }
            bVar3 = bVar;
        }
        this.b.removeAll(arrayList);
    }

    public final void e() {
        Random random = new Random(255L);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setBackgroundColor(Color.argb(100, random.nextInt(), random.nextInt(), random.nextInt()));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        c();
        int i5 = this.c;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                b bVarA = a(childAt);
                int i7 = bVarA.a;
                int i8 = bVarA.b;
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight() + i8;
                childAt.layout(i7, i8, i7 + measuredWidth, measuredHeight);
                int i9 = measuredWidth + i5;
                int i10 = bVarA.c;
                if (i9 < i10) {
                    bVarA.a += i9;
                    bVarA.c = i10 - i9;
                } else {
                    this.b.remove(bVarA);
                }
                b bVar = new b();
                bVar.a = i7;
                bVar.b = measuredHeight + i5;
                bVar.c = measuredWidth;
                this.b.add(bVar);
                d();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        e();
        if (!isInEditMode()) {
            this.a.a();
        }
        measureChildren(i, i2);
        super.onMeasure(i, i2);
    }
}
