package com.wear.ui.longDistance.imagepicker.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import skin.support.widget.SkinAutoRelativeLayout;

/* loaded from: classes4.dex */
public class SquareRelativeLayout extends SkinAutoRelativeLayout {
    public SquareRelativeLayout(Context context) {
        this(context, null);
    }

    @Override // com.zhy.autolayout.AutoRelativeLayout, android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i);
    }

    public SquareRelativeLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SquareRelativeLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
