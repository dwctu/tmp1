package com.yydcdut.sdlv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import dc.av3;
import dc.zu3;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class ItemBackGroundLayout extends ViewGroup implements View.OnClickListener {
    public int a;
    public int b;
    public Map<View, Integer> c;
    public int d;
    public a e;

    public interface a {
        void i(int i, int i2, View view);
    }

    public ItemBackGroundLayout(Context context) {
        this(context, null);
    }

    public void a(zu3 zu3Var, int i) {
        int childCount = getChildCount();
        av3 av3Var = new av3(getContext(), zu3Var);
        av3Var.a();
        addView(av3Var, childCount);
        this.c.put(av3Var, Integer.valueOf(i));
        av3Var.setOnClickListener(this);
    }

    public boolean b() {
        return this.c.size() != 0;
    }

    public void c(int i) {
        this.d = i;
    }

    public void d(a aVar) {
        this.e = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer num = this.c.get(view);
        a aVar = this.e;
        if (aVar != null) {
            aVar.i(num.intValue(), this.d, view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        this.a = 0;
        this.b = getMeasuredWidth();
        for (int i5 = 0; i5 < childCount; i5++) {
            BaseLayout baseLayout = (BaseLayout) getChildAt(i5);
            zu3 zu3Var = baseLayout.a;
            if (zu3Var.g == 1) {
                int i6 = this.a;
                baseLayout.layout(i6, i2, zu3Var.a + i6, i4);
                this.a += zu3Var.a;
            } else {
                int i7 = this.b;
                baseLayout.layout(i7 - zu3Var.a, i2, i7, i4);
                this.b -= zu3Var.a;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            BaseLayout baseLayout = (BaseLayout) getChildAt(i3);
            measureChild(baseLayout, View.MeasureSpec.makeMeasureSpec(baseLayout.a.a, 1073741824), i2);
        }
    }

    public ItemBackGroundLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemBackGroundLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        this.b = 0;
        this.d = -1;
        this.c = new HashMap();
        setVisibility(8);
    }
}
