package com.wear.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import androidx.appcompat.app.AppCompatDialog;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public abstract class BottomDialog extends AppCompatDialog {
    public View a;
    public Context b;

    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            BottomDialog.this.dismiss();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public BottomDialog(Context context) {
        super(context, R.style.newBottomDialog);
        this.b = context;
    }

    public void a() {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
        animationSet.addAnimation(new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f));
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
        a();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.height = -2;
        attributes.width = -1;
        attributes.gravity = 81;
        getWindow().setAttributes(attributes);
        if (b() == null) {
            return;
        }
        this.a = b();
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
        animationSet.addAnimation(new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f));
        animationSet.setInterpolator(new AccelerateInterpolator());
        animationSet.setDuration(200L);
        animationSet.setFillAfter(true);
        this.a.setAnimation(animationSet);
        c(this.a);
        setContentView(this.a);
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            if (this.b != null) {
                super.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
