package com.wear.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.core.view.ViewCompat;

/* loaded from: classes4.dex */
public class SurfaceViewSinFun extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    public SurfaceHolder a;
    public Canvas b;
    public boolean c;
    public Paint d;
    public Path e;
    public int f;
    public float[] g;

    public SurfaceViewSinFun(Context context) {
        this(context, null);
    }

    private void setPath(int i) {
        float[] fArr = this.g;
        if (i >= fArr.length) {
            return;
        }
        if (i < 16) {
            int i2 = i + 1;
            System.arraycopy(fArr, 0, new float[i2], 0, i2);
        }
        this.e.reset();
    }

    public final void a() {
        Canvas canvas;
        try {
            Canvas canvasLockCanvas = this.a.lockCanvas();
            this.b = canvasLockCanvas;
            canvasLockCanvas.drawColor(-1);
            this.b.drawPath(this.e, this.d);
            canvas = this.b;
            if (canvas == null) {
                return;
            }
        } catch (Exception unused) {
            canvas = this.b;
            if (canvas == null) {
                return;
            }
        } catch (Throwable th) {
            Canvas canvas2 = this.b;
            if (canvas2 != null) {
                this.a.unlockCanvasAndPost(canvas2);
            }
            throw th;
        }
        this.a.unlockCanvasAndPost(canvas);
    }

    public final void b() {
        SurfaceHolder holder = getHolder();
        this.a = holder;
        holder.addCallback(this);
        setFocusable(true);
        setKeepScreenOn(true);
        setFocusableInTouchMode(true);
        this.g = new float[10000];
        for (int i = 0; i < 10000; i++) {
            this.g[i] = ((float) (Math.random() * 100.0d)) + 400.0f;
        }
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException {
        while (this.c) {
            try {
                int i = this.f + 1;
                this.f = i;
                setPath(i);
                a();
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.c = true;
        new Thread(this).start();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.c = false;
    }

    public SurfaceViewSinFun(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SurfaceViewSinFun(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 0;
        Paint paint = new Paint();
        this.d = paint;
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setAntiAlias(true);
        this.d.setStrokeWidth(5.0f);
        this.e = new Path();
        new Path();
        b();
    }
}
