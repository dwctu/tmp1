package com.wear.widget.control;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;
import com.lovense.wear.R;
import dc.ce3;
import dc.th4;

/* loaded from: classes4.dex */
public class VerticalSeekBar extends SeekBar {
    public Handler a;
    public boolean b;
    public Paint c;
    public Context d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public int j;
    public Runnable k;

    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 153) {
                return;
            }
            VerticalSeekBar.this.setProgress(message.arg1);
            String str = VerticalSeekBar.this.getProgress() + "";
            VerticalSeekBar verticalSeekBar = VerticalSeekBar.this;
            verticalSeekBar.onSizeChanged(verticalSeekBar.getWidth(), VerticalSeekBar.this.getHeight(), 0, 0);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VerticalSeekBar.this.i = true;
            VerticalSeekBar.this.invalidate();
        }
    }

    public VerticalSeekBar(Context context) {
        super(context);
        this.b = false;
        this.j = 0;
        this.k = new b();
        c(context);
    }

    public final void b(Canvas canvas) {
        int iMin = Math.min(Math.max(this.j, 0), 100);
        int height = (getHeight() / 2) + this.e;
        int width = ((((getWidth() * (100 - iMin)) / 100) * getWidth()) / ((getWidth() + this.f) + this.g)) + this.h;
        if (this.i) {
            canvas.drawText("", height, width, this.c);
            return;
        }
        canvas.drawText(iMin + "%", height, width, this.c);
    }

    public final void c(Context context) {
        this.d = context;
        this.b = false;
        this.a = new a();
        d();
    }

    public final void d() {
        this.e = ce3.a(this.d, 48.0f) / 2;
        this.f = getPaddingRight();
        this.g = getPaddingLeft();
        this.h = ce3.g(this.d, 12.0f);
        this.i = true;
        Paint paint = new Paint();
        this.c = paint;
        paint.setColor(th4.b(this.d, R.color.text_color_85));
        this.c.setTextSize(this.h);
        this.c.setAntiAlias(true);
    }

    public void e(int i) {
        setProgress(i);
        onSizeChanged(getWidth(), getHeight(), 0, 0);
        this.j = i;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void onDraw(Canvas canvas) {
        b(canvas);
        canvas.rotate(-90.0f);
        canvas.translate(-getHeight(), 0.0f);
        super.onDraw(canvas);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i2, i);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i2, i, i4, i3);
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        removeCallbacks(this.k);
        int action = motionEvent.getAction();
        if (action == 0 || action == 1 || action == 2) {
            int max = getMax() - ((int) ((getMax() * motionEvent.getY()) / getHeight()));
            if (motionEvent.getAction() == 1) {
                this.b = false;
            } else {
                this.b = true;
            }
            if (this.j != max) {
                this.j = max;
                Message message = new Message();
                message.what = 153;
                message.arg1 = max;
                this.a.sendMessage(message);
            }
            motionEvent.getY();
        } else if (action == 3) {
            this.b = false;
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            postDelayed(this.k, 1000L);
        } else {
            this.i = false;
        }
        return true;
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = false;
        this.j = 0;
        this.k = new b();
        c(context);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = false;
        this.j = 0;
        this.k = new b();
        c(context);
    }
}
