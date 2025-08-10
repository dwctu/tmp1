package com.wear.widget;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.google.android.exoplayer2.PlaybackException;
import com.lovense.wear.R;

/* loaded from: classes4.dex */
public class FloatNormalView extends LinearLayout {
    public static WindowManager i;
    public WindowManager.LayoutParams a;
    public float b;
    public float c;
    public float d;
    public float e;
    public int f;
    public float g;
    public float h;

    public FloatNormalView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.debug_window, this);
        i = (WindowManager) context.getSystemService("window");
        this.a = new WindowManager.LayoutParams();
        a();
        this.f = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public final void a() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.a.type = 2038;
        } else {
            this.a.type = PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT;
        }
        WindowManager.LayoutParams layoutParams = this.a;
        layoutParams.flags = 40;
        layoutParams.gravity = 53;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -2;
        i.addView(this, layoutParams);
    }

    public final void b() {
        WindowManager.LayoutParams layoutParams = this.a;
        layoutParams.x = (int) (this.b - this.d);
        layoutParams.y = (int) (this.e - this.c);
        i.updateViewLayout(this, layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.g = x;
            this.h = y;
        } else if (action == 2) {
            if (Math.max((int) Math.abs(x - this.g), (int) Math.abs(y - this.h)) > this.f) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.b += motionEvent.getRawX() - this.d;
            this.c += motionEvent.getRawY() - this.e;
            return true;
        }
        if (action != 2) {
            return true;
        }
        this.d = motionEvent.getRawX();
        this.e = motionEvent.getRawY();
        b();
        return true;
    }
}
