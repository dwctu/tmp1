package com.wear.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import androidx.constraintlayout.motion.widget.Key;
import com.makeramen.roundedimageview.RoundedImageView;

/* loaded from: classes4.dex */
public class RoateImageView extends RoundedImageView {
    public ObjectAnimator r;

    public RoateImageView(Context context) {
        super(context);
        h();
    }

    public final void h() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, Key.ROTATION, 0.0f, 360.0f);
        this.r = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(5000L);
        this.r.setInterpolator(new LinearInterpolator());
        this.r.setRepeatCount(-1);
        this.r.setRepeatMode(1);
    }

    public void i() {
        animate().rotation(0.0f).setDuration(0L);
        this.r.start();
    }

    public void j() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.r.pause();
        }
    }

    public RoateImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h();
    }

    public RoateImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        h();
    }
}
