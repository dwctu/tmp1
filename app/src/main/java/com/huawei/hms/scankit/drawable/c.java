package com.huawei.hms.scankit.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ScanDrawable.java */
/* loaded from: classes3.dex */
public class c extends AnimatorListenerAdapter {
    public final /* synthetic */ ScanDrawable a;

    public c(ScanDrawable scanDrawable) {
        this.a = scanDrawable;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        super.onAnimationRepeat(animator);
        this.a.s = !r2.s;
    }
}
