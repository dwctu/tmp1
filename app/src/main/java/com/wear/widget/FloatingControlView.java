package com.wear.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.lovense.wear.R;
import com.wear.widget.BaseFloatIngView;
import com.wear.widget.control.FingImageLayout;

/* loaded from: classes4.dex */
public class FloatingControlView extends BaseFloatIngView {
    public int h;
    public boolean i;

    public class a implements View.OnTouchListener {
        public float a;
        public float b;

        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            ViewGroup viewGroup = (ViewGroup) FloatingControlView.this.getParent();
            if (viewGroup == null) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                this.a = motionEvent.getRawX();
                this.b = motionEvent.getRawY();
                FloatingControlView.this.i = false;
                FloatingControlView.this.c.cancel();
            } else if (action != 1) {
                if (action == 2) {
                    float rawX = this.a - motionEvent.getRawX();
                    float rawY = this.b - motionEvent.getRawY();
                    if (((int) Math.max(Math.abs(rawX), Math.abs(rawY))) > FloatingControlView.this.h) {
                        FloatingControlView floatingControlView = FloatingControlView.this;
                        if (floatingControlView.a != null && !floatingControlView.i) {
                            FloatingControlView.this.a.a();
                        }
                        FloatingControlView.this.i = true;
                    }
                    if (FloatingControlView.this.i) {
                        float y = FloatingControlView.this.getY() - rawY;
                        float x = FloatingControlView.this.getX() - rawX;
                        if (y <= 0.0f) {
                            y = 0.0f;
                        } else if (y > viewGroup.getHeight() - FloatingControlView.this.getHeight()) {
                            y = viewGroup.getHeight() - FloatingControlView.this.getHeight();
                        }
                        if (x < 0.0f) {
                            x = 0.0f;
                        } else if (x > viewGroup.getWidth() - FloatingControlView.this.getWidth()) {
                            x = viewGroup.getWidth() - FloatingControlView.this.getWidth();
                        }
                        FloatingControlView floatingControlView2 = FloatingControlView.this;
                        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(floatingControlView2, FingImageLayout.ObjectAnimatorY, floatingControlView2.getY(), y);
                        FloatingControlView floatingControlView3 = FloatingControlView.this;
                        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(floatingControlView3, "x", floatingControlView3.getX(), x);
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat);
                        animatorSet.setDuration(0L);
                        animatorSet.start();
                        this.a = motionEvent.getRawX();
                        float rawY2 = motionEvent.getRawY();
                        this.b = rawY2;
                        BaseFloatIngView.b bVar = FloatingControlView.this.b;
                        bVar.a = (int) this.a;
                        bVar.b = (int) rawY2;
                    }
                } else if (action == 3 && FloatingControlView.this.i) {
                    FloatingControlView.this.e();
                }
            } else if (FloatingControlView.this.i) {
                FloatingControlView.this.e();
            } else {
                FloatingControlView.this.performClick();
            }
            return true;
        }
    }

    public FloatingControlView(Context context) {
        super(context);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        d();
        this.h = viewConfiguration.getScaledTouchSlop();
    }

    public final void d() {
        setOnTouchListener(new a());
    }

    public boolean e() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (!this.c.isRunning() && viewGroup != null) {
            if (this.b.a < (viewGroup.getWidth() / 2) - (getWidth() / 2)) {
                this.d.b(true);
                this.c.playTogether(ObjectAnimator.ofFloat(this, "x", this.b.a, 0.0f));
                this.c.setDuration(200L);
                this.c.start();
                return false;
            }
            this.d.b(false);
            this.c.playTogether(ObjectAnimator.ofFloat(this, "x", this.b.a, viewGroup.getWidth() - getWidth()));
            this.c.setDuration(200L);
            this.c.start();
        }
        return true;
    }

    @Override // com.wear.widget.BaseFloatIngView
    public BaseFloatIngView.b getData() {
        return this.b;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // com.wear.widget.BaseFloatIngView
    public void setWidthAndHeight(Activity activity, int i, int i2) {
        if (activity == null) {
            return;
        }
        try {
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView().findViewById(R.id.fl_root_view);
            if (viewGroup == null) {
                viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            }
            ViewGroup viewGroup2 = (ViewGroup) getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this);
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, i2);
            }
            viewGroup.addView(this, layoutParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
