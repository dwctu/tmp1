package dc;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

/* compiled from: LoadingDrawable.java */
/* loaded from: classes4.dex */
public abstract class ts3 extends Drawable implements Animatable {
    public Paint a = new Paint(1);
    public Paint b;
    public boolean c;
    public int[] d;
    public int e;
    public float f;
    public final Runnable g;

    /* compiled from: LoadingDrawable.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!ts3.this.c) {
                ts3.this.unscheduleSelf(this);
            } else {
                ts3.this.k();
                ts3.this.invalidateSelf();
            }
        }
    }

    public ts3() {
        Paint paint = new Paint(1);
        this.b = paint;
        this.d = new int[]{-872415232, -100251, -8117352};
        this.e = 0;
        this.g = new a();
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStrokeWidth(4.0f);
        paint.setColor(838860800);
        Paint paint2 = this.a;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setDither(true);
        paint2.setStrokeWidth(4.0f);
        paint2.setColor(this.d[0]);
    }

    public abstract void b(Canvas canvas, Paint paint);

    public abstract void c(Canvas canvas, Paint paint);

    public int d() {
        return this.b.getColor();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int iSave = canvas.save();
        Paint paint = this.b;
        if (paint.getColor() != 0 && paint.getStrokeWidth() > 0.0f) {
            b(canvas, paint);
        }
        Paint paint2 = this.a;
        if (this.c) {
            if (paint2.getColor() != 0 && paint2.getStrokeWidth() > 0.0f) {
                c(canvas, paint2);
            }
            scheduleSelf(this.g, SystemClock.uptimeMillis() + 16);
        } else if (this.f > 0.0f && paint2.getColor() != 0 && paint2.getStrokeWidth() > 0.0f) {
            c(canvas, paint2);
        }
        canvas.restoreToCount(iSave);
    }

    public float e() {
        return this.b.getStrokeWidth();
    }

    public int[] f() {
        return this.d;
    }

    public float g() {
        return this.a.getStrokeWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public abstract int getIntrinsicHeight();

    @Override // android.graphics.drawable.Drawable
    public abstract int getIntrinsicWidth();

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Paint paint = this.b;
        Paint paint2 = this.a;
        if (paint.getXfermode() != null || paint2.getXfermode() != null) {
            return -3;
        }
        int iAlpha = Color.alpha(paint2.getColor());
        if (iAlpha == 0) {
            return -2;
        }
        return iAlpha == 255 ? -1 : -3;
    }

    public int h() {
        int[] iArr = this.d;
        Paint paint = this.a;
        if (iArr.length > 1) {
            int i = this.e + 1;
            int i2 = i < iArr.length ? i : 0;
            paint.setColor(iArr[i2]);
            this.e = i2;
        } else {
            paint.setColor(iArr[0]);
        }
        return paint.getColor();
    }

    public float i() {
        return this.f;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.c;
    }

    public abstract void j(float f);

    public abstract void k();

    public void l(int i) {
        this.b.setColor(i);
    }

    public void m(float f) {
        this.b.setStrokeWidth(f);
        onBoundsChange(getBounds());
    }

    public void n(int[] iArr) {
        if (iArr == null) {
            return;
        }
        this.d = iArr;
        this.e = -1;
        h();
    }

    public void o(float f) {
        this.a.setStrokeWidth(f);
        onBoundsChange(getBounds());
    }

    public void p(float f) {
        if (f < 0.0f) {
            this.f = 0.0f;
        } else if (this.f > 1.0f) {
            this.f = 1.0f;
        } else {
            this.f = f;
        }
        stop();
        j(this.f);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        boolean z;
        Paint paint = this.b;
        boolean z2 = true;
        if (paint.getColorFilter() != colorFilter) {
            paint.setColorFilter(colorFilter);
            z = true;
        } else {
            z = false;
        }
        Paint paint2 = this.a;
        if (paint2.getColorFilter() != colorFilter) {
            paint2.setColorFilter(colorFilter);
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.c) {
            return;
        }
        this.c = true;
        scheduleSelf(this.g, SystemClock.uptimeMillis() + 16);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.c) {
            this.c = false;
            unscheduleSelf(this.g);
            invalidateSelf();
        }
    }
}
