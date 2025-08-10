package com.youth.banner.indicator;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.badge.BadgeDrawable;
import com.youth.banner.config.IndicatorConfig;

/* loaded from: classes4.dex */
public class BaseIndicator extends View implements Indicator {
    public IndicatorConfig config;
    public Paint mPaint;
    public float offset;

    public BaseIndicator(Context context) {
        this(context, null);
    }

    @Override // com.youth.banner.indicator.Indicator
    public IndicatorConfig getIndicatorConfig() {
        return this.config;
    }

    @Override // com.youth.banner.indicator.Indicator
    @NonNull
    public View getIndicatorView() {
        if (this.config.isAttachToBanner()) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            int gravity = this.config.getGravity();
            if (gravity == 0) {
                layoutParams.gravity = BadgeDrawable.BOTTOM_START;
            } else if (gravity == 1) {
                layoutParams.gravity = 81;
            } else if (gravity == 2) {
                layoutParams.gravity = BadgeDrawable.BOTTOM_END;
            }
            layoutParams.leftMargin = this.config.getMargins().leftMargin;
            layoutParams.rightMargin = this.config.getMargins().rightMargin;
            layoutParams.topMargin = this.config.getMargins().topMargin;
            layoutParams.bottomMargin = this.config.getMargins().bottomMargin;
            setLayoutParams(layoutParams);
        }
        return this;
    }

    @Override // com.youth.banner.indicator.Indicator
    public void onPageChanged(int i, int i2) {
        this.config.setIndicatorSize(i);
        this.config.setCurrentPosition(i2);
        requestLayout();
    }

    @Override // com.youth.banner.listener.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // com.youth.banner.listener.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        this.offset = f;
        invalidate();
    }

    @Override // com.youth.banner.listener.OnPageChangeListener
    public void onPageSelected(int i) {
        this.config.setCurrentPosition(i);
        invalidate();
    }

    public BaseIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseIndicator(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.config = new IndicatorConfig();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(0);
        this.mPaint.setColor(this.config.getNormalColor());
    }
}
