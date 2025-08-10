package com.wear.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.widget.NestedScrollView;

/* loaded from: classes4.dex */
public class CustomNestedScrollView extends NestedScrollView {
    public int a;

    public CustomNestedScrollView(Context context) {
        super(context);
        a();
    }

    public final void a() {
        this.a = 0;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        int i5 = this.a;
        if (i2 > i5) {
            scrollTo(0, i5);
        }
        super.onScrollChanged(i, i2, i3, i4);
    }

    public void setMaxScrollDistance(int i) {
        this.a = i;
    }

    public CustomNestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public CustomNestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
