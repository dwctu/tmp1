package com.wear.ui.longDistance.imagepicker.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import pl.droidsonroids.gif.GifImageView;

/* loaded from: classes4.dex */
public class SquareImageView extends GifImageView {
    public SquareImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i);
    }

    public SquareImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SquareImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
