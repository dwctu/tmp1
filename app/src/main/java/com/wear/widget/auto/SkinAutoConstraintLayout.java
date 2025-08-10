package com.wear.widget.auto;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.wear.widget.roundwidget.SkinRoundConstraintLayout;
import dc.cv3;
import dc.xv3;

/* loaded from: classes4.dex */
public class SkinAutoConstraintLayout extends SkinRoundConstraintLayout {
    public xv3 d;

    public static class LayoutParams extends ConstraintLayout.LayoutParams implements xv3.a {
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

    public SkinAutoConstraintLayout(Context context) {
        super(context);
        this.d = new xv3(this);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (!isInEditMode()) {
            this.d.a();
        }
        super.onMeasure(i, i2);
    }

    public SkinAutoConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new xv3(this);
    }

    @TargetApi(11)
    public SkinAutoConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new xv3(this);
    }
}
