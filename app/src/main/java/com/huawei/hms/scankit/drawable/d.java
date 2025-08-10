package com.huawei.hms.scankit.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.huawei.hms.scankit.p.Yc;

/* compiled from: ScanDrawable.java */
/* loaded from: classes3.dex */
public class d extends AnimatorListenerAdapter {
    public final /* synthetic */ ScanDrawable a;

    public d(ScanDrawable scanDrawable) {
        this.a = scanDrawable;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        super.onAnimationRepeat(animator);
        float fAbs = Math.abs(((Float) this.a.f.getAnimatedValue()).floatValue() - 0.5f);
        this.a.x = !r1.x;
        if (this.a.x) {
            if (fAbs > 0.35f) {
                this.a.r = 0.0f;
            } else {
                this.a.r = Yc.a(0.5f);
            }
        }
    }
}
