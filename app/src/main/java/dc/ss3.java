package dc;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* compiled from: LoadingCircleDrawable.java */
/* loaded from: classes4.dex */
public class ss3 extends ts3 {
    public static int n = 56;
    public int h;
    public int i;
    public RectF j;
    public float k;
    public float l;
    public int m;

    public ss3(int i, int i2) {
        int i3 = n;
        this.h = i3;
        this.i = i3;
        this.j = new RectF();
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = -3;
        this.h = i;
        this.i = i2;
    }

    @Override // dc.ts3
    public void b(Canvas canvas, Paint paint) {
        canvas.drawArc(this.j, 0.0f, 360.0f, false, paint);
    }

    @Override // dc.ts3
    public void c(Canvas canvas, Paint paint) {
        canvas.drawArc(this.j, this.k, -this.l, false, paint);
    }

    @Override // dc.ts3, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return Math.min(this.i, Math.max((int) ((Math.max(this.b.getStrokeWidth(), this.a.getStrokeWidth()) * 2.0f) + 10.0f), this.h));
    }

    @Override // dc.ts3, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(this.i, Math.max((int) ((Math.max(this.b.getStrokeWidth(), this.a.getStrokeWidth()) * 2.0f) + 10.0f), this.h));
    }

    @Override // dc.ts3
    public void j(float f) {
        this.k = 0.0f;
        this.l = f * 360.0f;
    }

    @Override // dc.ts3
    public void k() {
        float f = this.k + 10.0f;
        this.k = f;
        if (f > 360.0f) {
            this.k = f - 360.0f;
        }
        float f2 = this.l;
        if (f2 > 255.0f) {
            this.m = -this.m;
        } else if (f2 < 3.0f) {
            this.l = 3.0f;
            return;
        } else if (f2 == 3.0f) {
            this.m = -this.m;
            h();
        }
        this.l += this.m;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (rect.left == 0 && rect.top == 0 && rect.right == 0 && rect.bottom == 0) {
            return;
        }
        int iCenterX = rect.centerX();
        int iCenterY = rect.centerY();
        int iMin = (Math.min(rect.height(), rect.width()) >> 1) - ((((int) Math.max(g(), e())) >> 1) + 1);
        this.j.set(iCenterX - iMin, iCenterY - iMin, iCenterX + iMin, iCenterY + iMin);
    }
}
