package dc;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;

/* compiled from: AnimationUtil.java */
/* loaded from: classes4.dex */
public class oj3 implements Animation.AnimationListener {
    public Animation a;
    public a b;
    public c c;
    public b d;

    /* compiled from: AnimationUtil.java */
    public interface a {
        void onAnimationEnd(Animation animation);
    }

    /* compiled from: AnimationUtil.java */
    public interface b {
        void onAnimationRepeat(Animation animation);
    }

    /* compiled from: AnimationUtil.java */
    public interface c {
        void onAnimationStart(Animation animation);
    }

    public oj3(Context context, int i) throws Resources.NotFoundException {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, i);
        this.a = animationLoadAnimation;
        animationLoadAnimation.setAnimationListener(this);
    }

    public oj3 a() {
        this.a.setInterpolator(new LinearInterpolator());
        return this;
    }

    public void b(View view) {
        view.startAnimation(this.a);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.onAnimationEnd(animation);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        b bVar = this.d;
        if (bVar != null) {
            bVar.onAnimationRepeat(animation);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.onAnimationStart(animation);
        }
    }
}
