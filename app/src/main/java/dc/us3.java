package dc;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* compiled from: LoadingLineDrawable.java */
/* loaded from: classes4.dex */
public class us3 extends ts3 {
    public float h;
    public float i;
    public float j;
    public float l;
    public float m;
    public float n;
    public float k = 400.0f;
    public float o = 0.008f;
    public int p = 1;

    @Override // dc.ts3
    public void b(Canvas canvas, Paint paint) {
        float f = this.i;
        float f2 = this.h;
        canvas.drawLine(f, f2, this.j, f2, paint);
    }

    @Override // dc.ts3
    public void c(Canvas canvas, Paint paint) {
        float f = this.l;
        float f2 = this.h;
        canvas.drawLine(f, f2, this.m, f2, paint);
    }

    @Override // dc.ts3, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) Math.max(this.b.getStrokeWidth(), this.a.getStrokeWidth());
    }

    @Override // dc.ts3, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return 32767;
    }

    @Override // dc.ts3
    public int h() {
        int i = this.p + 1;
        this.p = i;
        if (i > 3) {
            this.p = 1;
        }
        return super.h();
    }

    @Override // dc.ts3
    public void j(float f) {
        float f2 = this.i;
        this.l = f2;
        this.m = f2 + ((this.j - f2) * f);
    }

    @Override // dc.ts3
    public void k() {
        float f;
        float f2 = this.n + this.o;
        this.n = f2;
        if (f2 > 1.0f) {
            this.n = f2 - 1.0f;
            h();
        }
        float f3 = this.n;
        float f4 = this.k;
        float f5 = this.j;
        float f6 = this.i;
        float f7 = (f5 - f6) * f3;
        float f8 = f6 + f7;
        int i = this.p;
        if (i == 1) {
            f = f3 > 0.5f ? f4 * (1.0f - f3) : f4 * f3;
        } else if (i == 2) {
            f = (f4 * f3) / 2.0f;
            if (f8 + f > f5) {
                f = f5 - f8;
            }
        } else {
            if (f7 + f7 > f4) {
                f7 = f4 / 2.0f;
            }
            f = f8 + f7 > f5 ? f5 - f8 : f7;
        }
        this.l = f8 - f;
        this.m = f8 + f;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int i = rect.left;
        if (i == 0 && rect.top == 0 && rect.right == 0 && rect.bottom == 0) {
            return;
        }
        this.i = i;
        this.j = rect.right;
        this.h = rect.centerY();
        this.k = (this.j - this.i) * 0.5f;
        float f = this.f;
        if (f != 0.0f) {
            j(f);
        }
    }
}
