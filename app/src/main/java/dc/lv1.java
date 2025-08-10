package dc;

import android.animation.Animator;

/* compiled from: SimpleAnimatorListener.java */
/* loaded from: classes3.dex */
public abstract class lv1 implements Animator.AnimatorListener {
    public boolean a = false;

    public abstract void a(boolean z);

    public void b(boolean z) {
        this.a = z;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        a(this.a);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
