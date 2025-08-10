package com.zhy.autolayout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import dc.cv3;
import dc.xv3;

/* loaded from: classes4.dex */
public class AutoFrameLayout extends FrameLayout {
    public final xv3 a;

    public static class LayoutParams extends FrameLayout.LayoutParams implements xv3.a {
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

    public AutoFrameLayout(Context context) {
        super(context);
        this.a = new xv3(this);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (!isInEditMode()) {
            this.a.a();
        }
        super.onMeasure(i, i2);
    }

    public AutoFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new xv3(this);
    }

    public AutoFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new xv3(this);
    }
}
