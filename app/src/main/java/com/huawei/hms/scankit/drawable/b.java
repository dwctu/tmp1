package com.huawei.hms.scankit.drawable;

import android.animation.ValueAnimator;

/* compiled from: ScanDrawable.java */
/* loaded from: classes3.dex */
public class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ScanDrawable a;

    public b(ScanDrawable scanDrawable) {
        this.a = scanDrawable;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) this.a.f.getAnimatedValue()).floatValue();
        ScanDrawable scanDrawable = this.a;
        scanDrawable.u = scanDrawable.o.top + ((int) (this.a.o.height() * ScanDrawable.b.getInterpolation(fFloatValue)));
        if (fFloatValue < 0.389f) {
            this.a.t = ScanDrawable.c.getInterpolation(fFloatValue / 0.389f);
        } else {
            this.a.t = 1.0f - ScanDrawable.d.getInterpolation((fFloatValue - 0.389f) / 0.611f);
        }
        this.a.invalidateSelf();
    }
}
