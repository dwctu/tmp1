package com.wear.widget;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.google.android.exoplayer2.PlaybackException;
import com.wear.widget.BaseFloatIngView;
import dc.ce3;
import dc.fv1;
import dc.gg3;
import dc.xe3;

/* loaded from: classes4.dex */
public class FloatingNewControlView extends BaseFloatIngView {
    public static int q;
    public static int r;
    public static int s;
    public WindowManager.LayoutParams h;
    public WindowManager i;
    public Context j;
    public int k;
    public float l;
    public float m;
    public boolean n;
    public int o;
    public int p;

    public FloatingNewControlView(Context context) {
        super(context);
        this.j = context;
        r = gg3.e(context);
        s = gg3.c(context);
        this.i = (WindowManager) context.getSystemService("window");
        this.h = new WindowManager.LayoutParams();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        a(-2, -2);
        this.k = viewConfiguration.getScaledTouchSlop();
    }

    public final void a(int i, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.h.type = 2038;
        } else {
            this.h.type = PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT;
        }
        WindowManager.LayoutParams layoutParams = this.h;
        layoutParams.flags = 40;
        layoutParams.gravity = 51;
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.format = -2;
    }

    public void b() {
        try {
            this.b.c = false;
            WindowManager.LayoutParams layoutParams = this.h;
            layoutParams.x = r - layoutParams.width;
            layoutParams.y = ce3.a(this.j, 70.0f);
            fv1 fv1Var = this.a;
            if (fv1Var != null) {
                fv1Var.b(this.b.c);
            }
            if (getParent() != null) {
                this.i.updateViewLayout(this, this.h);
            }
            WindowManager.LayoutParams layoutParams2 = this.h;
            BaseFloatIngView.e = layoutParams2.x;
            BaseFloatIngView.f = layoutParams2.y;
            BaseFloatIngView.g = false;
        } catch (Exception unused) {
        }
    }

    public boolean c() {
        WindowManager.LayoutParams layoutParams = this.h;
        BaseFloatIngView.e = layoutParams.x;
        BaseFloatIngView.f = layoutParams.y;
        if (this.c.isRunning()) {
            return true;
        }
        if (this.h.x < (r / 2) - (getWidth() / 2)) {
            this.d.b(true);
            BaseFloatIngView.g = true;
            this.c.playTogether(ObjectAnimator.ofFloat(this, "pointX", this.h.x, 0.0f));
            this.c.setDuration(200L);
            this.c.start();
            return false;
        }
        this.d.b(false);
        BaseFloatIngView.g = false;
        this.c.playTogether(ObjectAnimator.ofFloat(this, "pointX", this.h.x, r - getWidth()));
        this.c.setDuration(200L);
        this.c.start();
        return true;
    }

    @Override // com.wear.widget.BaseFloatIngView
    public BaseFloatIngView.b getData() {
        BaseFloatIngView.b bVar = this.b;
        WindowManager.LayoutParams layoutParams = this.h;
        bVar.a = layoutParams.x;
        bVar.b = layoutParams.y;
        return bVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.l = motionEvent.getRawX();
            this.m = motionEvent.getRawY();
            WindowManager.LayoutParams layoutParams = this.h;
            this.o = layoutParams.x;
            this.p = layoutParams.y;
            this.n = false;
            this.c.cancel();
        } else if (action != 1) {
            if (action == 2) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (Math.max((int) Math.abs(rawX - this.l), (int) Math.abs(rawY - this.m)) > this.k) {
                    fv1 fv1Var = this.a;
                    if (fv1Var != null && !this.n) {
                        fv1Var.a();
                    }
                    this.n = true;
                }
                if (this.n) {
                    WindowManager.LayoutParams layoutParams2 = this.h;
                    int i = ((int) (rawX - this.l)) + this.o;
                    layoutParams2.x = i;
                    int i2 = ((int) (rawY - this.m)) + this.p;
                    layoutParams2.y = i2;
                    if (i < 0) {
                        layoutParams2.x = 0;
                    } else {
                        int i3 = r;
                        if (i > i3) {
                            layoutParams2.x = i3;
                        }
                    }
                    int i4 = q;
                    if (i2 < i4) {
                        layoutParams2.y = i4;
                    } else {
                        int i5 = s;
                        if (i2 > i5) {
                            layoutParams2.y = i5;
                        }
                    }
                    xe3.a("FloatingNewControlView", "ACTION_MOVE " + this.h.x);
                    this.i.updateViewLayout(this, this.h);
                }
            } else if (action == 3 && this.n) {
                c();
            }
        } else if (this.n) {
            c();
        } else {
            performClick();
        }
        return true;
    }

    public void setPointX(float f) {
        WindowManager.LayoutParams layoutParams = this.h;
        layoutParams.x = (int) f;
        this.i.updateViewLayout(this, layoutParams);
    }

    @Override // com.wear.widget.BaseFloatIngView
    public void setPointX(int i, int i2, boolean z) {
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        try {
            if (i == 0) {
                if (getParent() != null) {
                    WindowManager.LayoutParams layoutParams = this.h;
                    layoutParams.flags = 40;
                    this.i.updateViewLayout(this, layoutParams);
                }
            } else if (getParent() != null) {
                WindowManager.LayoutParams layoutParams2 = this.h;
                layoutParams2.flags = 16;
                this.i.updateViewLayout(this, layoutParams2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.wear.widget.BaseFloatIngView
    public void setWidthAndHeight(Activity activity, int i, int i2) {
        try {
            if (Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(this.j)) {
                WindowManager.LayoutParams layoutParams = this.h;
                layoutParams.width = i;
                layoutParams.height = i2;
                if (getParent() != null) {
                    this.i.updateViewLayout(this, this.h);
                } else {
                    this.i.addView(this, this.h);
                    b();
                }
            }
        } catch (Exception unused) {
        }
    }
}
