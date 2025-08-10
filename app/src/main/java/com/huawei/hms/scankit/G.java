package com.huawei.hms.scankit;

import android.animation.ValueAnimator;

/* compiled from: ViewfinderView.java */
/* loaded from: classes3.dex */
public class G implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ViewfinderView a;

    public G(ViewfinderView viewfinderView) {
        this.a = viewfinderView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.m = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.a.invalidate();
    }
}
