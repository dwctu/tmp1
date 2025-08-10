package com.youth.banner.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

/* loaded from: classes4.dex */
public class CircleIndicator extends BaseIndicator {
    private int mNormalRadius;
    private int mSelectedRadius;
    private int maxRadius;

    public CircleIndicator(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize <= 1) {
            return;
        }
        float indicatorSpace = 0.0f;
        int i = 0;
        while (i < indicatorSize) {
            this.mPaint.setColor(this.config.getCurrentPosition() == i ? this.config.getSelectedColor() : this.config.getNormalColor());
            int selectedWidth = this.config.getCurrentPosition() == i ? this.config.getSelectedWidth() : this.config.getNormalWidth();
            float f = this.config.getCurrentPosition() == i ? this.mSelectedRadius : this.mNormalRadius;
            canvas.drawCircle(indicatorSpace + f, this.maxRadius, f, this.mPaint);
            indicatorSpace += selectedWidth + this.config.getIndicatorSpace();
            i++;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize <= 1) {
            return;
        }
        this.mNormalRadius = this.config.getNormalWidth() / 2;
        int selectedWidth = this.config.getSelectedWidth() / 2;
        this.mSelectedRadius = selectedWidth;
        this.maxRadius = Math.max(selectedWidth, this.mNormalRadius);
        int i3 = indicatorSize - 1;
        setMeasuredDimension((this.config.getIndicatorSpace() * i3) + this.config.getSelectedWidth() + (this.config.getNormalWidth() * i3), Math.max(this.config.getNormalWidth(), this.config.getSelectedWidth()));
    }

    public CircleIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mNormalRadius = this.config.getNormalWidth() / 2;
        this.mSelectedRadius = this.config.getSelectedWidth() / 2;
    }
}
