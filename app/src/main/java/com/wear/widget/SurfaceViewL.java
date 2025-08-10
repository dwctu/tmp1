package com.wear.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import dc.gh3;
import dc.xe3;

/* loaded from: classes4.dex */
public class SurfaceViewL extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    public SurfaceHolder a;
    public gh3 b;
    public int c;
    public Runnable d;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SurfaceViewL.this.b.a.postDelayed(SurfaceViewL.this.d, SurfaceViewL.this.c);
            xe3.a("SurfaceViewL", "开始");
        }
    }

    public SurfaceViewL(Context context) {
        super(context);
        this.c = 100;
        this.d = new a();
    }

    public final void d() {
        SurfaceHolder holder = getHolder();
        this.a = holder;
        holder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setKeepScreenOn(true);
    }

    @Override // java.lang.Runnable
    public void run() {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.b = new gh3();
        new gh3();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public SurfaceViewL(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 100;
        this.d = new a();
        d();
    }

    public SurfaceViewL(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = 100;
        this.d = new a();
    }
}
