package com.wear.component.ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import androidx.appcompat.app.AppCompatDialog;
import com.lovense.wear.R;

/* loaded from: classes3.dex */
public abstract class BaseCenterDialog extends AppCompatDialog {
    public View a;
    public boolean b;
    public long c;

    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            BaseCenterDialog.this.dismiss();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public BaseCenterDialog(Context context) {
        super(context, R.style.Fulldialog);
        this.b = true;
    }

    public void a() {
        if (!this.b) {
            super.cancel();
            return;
        }
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
        animationSet.addAnimation(new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f));
        animationSet.setInterpolator(new AccelerateInterpolator());
        animationSet.setDuration(200L);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new a());
        this.a.setAnimation(animationSet);
        setContentView(this.a);
    }

    public abstract View b();

    public abstract void c(View view);

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        if (d()) {
            return;
        }
        a();
    }

    public synchronized boolean d() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.c < 300) {
            return true;
        }
        this.c = jCurrentTimeMillis;
        return false;
    }

    public void e() {
        if (this.a == null || !this.b) {
            return;
        }
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
        animationSet.addAnimation(new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f));
        animationSet.setInterpolator(new AccelerateInterpolator());
        animationSet.setDuration(200L);
        animationSet.setFillAfter(true);
        this.a.setAnimation(animationSet);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.height = -2;
        attributes.width = -2;
        attributes.gravity = 17;
        getWindow().setAttributes(attributes);
        if (b() == null) {
            return;
        }
        View viewB = b();
        this.a = viewB;
        c(viewB);
        setContentView(this.a);
        e();
    }

    @Override // android.app.Dialog
    public void show() {
        if (d()) {
            return;
        }
        e();
        super.show();
    }
}
