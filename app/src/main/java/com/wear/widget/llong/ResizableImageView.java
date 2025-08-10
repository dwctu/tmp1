package com.wear.widget.llong;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: classes4.dex */
public class ResizableImageView extends AppCompatImageView {
    public ResizableImageView(Context context) {
        super(context);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        if (getDrawable() == null) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(View.MeasureSpec.getSize(i), (int) Math.ceil((r3 * r0.getIntrinsicHeight()) / r0.getIntrinsicWidth()));
        }
    }

    public ResizableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
