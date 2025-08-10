package xyz.doikki.videocontroller.component;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dc.gk4;
import dc.hj4;
import dc.ij4;
import dc.jj4;
import dc.mj4;
import dc.oj4;

/* loaded from: classes5.dex */
public class GestureView extends FrameLayout implements oj4 {
    public mj4 a;
    public final ImageView b;
    public final ProgressBar c;
    public final TextView d;
    public final LinearLayout e;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            GestureView.this.e.setVisibility(8);
        }
    }

    public GestureView(@NonNull Context context) {
        super(context);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(jj4.dkplayer_layout_gesture_control_view, (ViewGroup) this, true);
        this.b = (ImageView) findViewById(ij4.iv_icon);
        this.c = (ProgressBar) findViewById(ij4.pro_percent);
        this.d = (TextView) findViewById(ij4.tv_percent);
        this.e = (LinearLayout) findViewById(ij4.center_container);
    }

    @Override // dc.nj4
    public void a(int i) {
        if (i == 0 || i == 8 || i == 1 || i == 2 || i == -1 || i == 5) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    @Override // dc.nj4
    public void b(int i) {
    }

    @Override // dc.oj4
    public void c(int i, int i2, int i3) {
        this.c.setVisibility(8);
        if (i > i2) {
            this.b.setImageResource(hj4.dkplayer_ic_action_fast_forward);
        } else {
            this.b.setImageResource(hj4.dkplayer_ic_action_fast_rewind);
        }
        this.d.setText(String.format("%s/%s", gk4.m(i), gk4.m(i3)));
    }

    @Override // dc.nj4
    public void d(boolean z, Animation animation) {
    }

    @Override // dc.nj4
    public void e(@NonNull mj4 mj4Var) {
        this.a = mj4Var;
    }

    @Override // dc.oj4
    public void f() {
        this.a.a();
        this.e.setVisibility(0);
        this.e.setAlpha(1.0f);
    }

    @Override // dc.oj4
    public void g() {
        this.e.animate().alpha(0.0f).setDuration(300L).setListener(new a()).start();
    }

    @Override // dc.nj4
    public View getView() {
        return this;
    }

    @Override // dc.oj4
    public void h(int i) {
        this.c.setVisibility(0);
        this.b.setImageResource(hj4.dkplayer_ic_action_brightness);
        this.d.setText(i + "%");
        this.c.setProgress(i);
    }

    @Override // dc.nj4
    public void i(boolean z) {
    }

    @Override // dc.oj4
    public void j(int i) {
        this.c.setVisibility(0);
        if (i <= 0) {
            this.b.setImageResource(hj4.dkplayer_ic_action_volume_off);
        } else {
            this.b.setImageResource(hj4.dkplayer_ic_action_volume_up);
        }
        this.d.setText(i + "%");
        this.c.setProgress(i);
    }

    @Override // dc.nj4
    public void setProgress(int i, int i2) {
    }

    public GestureView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(jj4.dkplayer_layout_gesture_control_view, (ViewGroup) this, true);
        this.b = (ImageView) findViewById(ij4.iv_icon);
        this.c = (ProgressBar) findViewById(ij4.pro_percent);
        this.d = (TextView) findViewById(ij4.tv_percent);
        this.e = (LinearLayout) findViewById(ij4.center_container);
    }

    public GestureView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setVisibility(8);
        LayoutInflater.from(getContext()).inflate(jj4.dkplayer_layout_gesture_control_view, (ViewGroup) this, true);
        this.b = (ImageView) findViewById(ij4.iv_icon);
        this.c = (ProgressBar) findViewById(ij4.pro_percent);
        this.d = (TextView) findViewById(ij4.tv_percent);
        this.e = (LinearLayout) findViewById(ij4.center_container);
    }
}
