package dc;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: Indicator.java */
/* loaded from: classes3.dex */
public abstract class oi1 extends Drawable implements Animatable {
    public static final Rect g = new Rect();
    public ArrayList<ValueAnimator> b;
    public boolean e;
    public Paint f;
    public HashMap<ValueAnimator, ValueAnimator.AnimatorUpdateListener> a = new HashMap<>();
    public int c = 255;
    public Rect d = g;

    public oi1() {
        Paint paint = new Paint();
        this.f = paint;
        paint.setColor(-1);
        this.f.setStyle(Paint.Style.FILL);
        this.f.setAntiAlias(true);
    }

    public void a(ValueAnimator valueAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.a.put(valueAnimator, animatorUpdateListener);
    }

    public abstract void b(Canvas canvas, Paint paint);

    public final void c() {
        if (this.e) {
            return;
        }
        this.b = g();
        this.e = true;
    }

    public int d() {
        return this.d.height();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b(canvas, this.f);
    }

    public int e() {
        return this.d.width();
    }

    public final boolean f() {
        Iterator<ValueAnimator> it = this.b.iterator();
        if (it.hasNext()) {
            return it.next().isStarted();
        }
        return false;
    }

    public abstract ArrayList<ValueAnimator> g();

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    public void h() {
        invalidateSelf();
    }

    public void i(int i) {
        this.f.setColor(i);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Iterator<ValueAnimator> it = this.b.iterator();
        if (it.hasNext()) {
            return it.next().isRunning();
        }
        return false;
    }

    public void j(int i, int i2, int i3, int i4) {
        this.d = new Rect(i, i2, i3, i4);
    }

    public void k(Rect rect) {
        j(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final void l() {
        for (int i = 0; i < this.b.size(); i++) {
            ValueAnimator valueAnimator = this.b.get(i);
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.a.get(valueAnimator);
            if (animatorUpdateListener != null) {
                valueAnimator.addUpdateListener(animatorUpdateListener);
            }
            valueAnimator.start();
        }
    }

    public final void m() {
        ArrayList<ValueAnimator> arrayList = this.b;
        if (arrayList != null) {
            Iterator<ValueAnimator> it = arrayList.iterator();
            while (it.hasNext()) {
                ValueAnimator next = it.next();
                if (next != null && next.isStarted()) {
                    next.removeAllUpdateListeners();
                    next.end();
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        k(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.c = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        c();
        if (this.b == null || f()) {
            return;
        }
        l();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        m();
    }
}
