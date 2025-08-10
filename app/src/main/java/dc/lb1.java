package dc;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: RoundHelperImpl.java */
/* loaded from: classes3.dex */
public class lb1 implements kb1 {
    public Context a;
    public View b;
    public Paint c;
    public RectF d;
    public RectF e;
    public RectF f;
    public Path g;
    public Path h;
    public Xfermode i;
    public boolean j;
    public float[] k;
    public float[] l;
    public int m;
    public int n;
    public int o;
    public float p;
    public float q;
    public float r;
    public float s;
    public float t;

    @Override // dc.kb1
    public void a(float f) {
        Context context = this.a;
        if (context == null) {
            return;
        }
        this.s = mb1.a(context, f);
        if (this.b != null) {
            k(this.m, this.n);
            this.b.invalidate();
        }
    }

    @Override // dc.kb1
    public void b(float f, int i) {
        Context context = this.a;
        if (context == null) {
            return;
        }
        this.p = mb1.a(context, f);
        this.o = i;
        if (this.b != null) {
            k(this.m, this.n);
            this.b.invalidate();
        }
    }

    @Override // dc.kb1
    public void c(boolean z) {
        this.j = z;
    }

    @Override // dc.kb1
    public void d(float f) {
        Context context = this.a;
        if (context == null) {
            return;
        }
        this.q = mb1.a(context, f);
        if (this.b != null) {
            k(this.m, this.n);
            this.b.invalidate();
        }
    }

    @Override // dc.kb1
    public void e(float f) {
        Context context = this.a;
        if (context == null) {
            return;
        }
        float fA = mb1.a(context, f);
        this.s = fA;
        this.t = fA;
        if (this.b != null) {
            k(this.m, this.n);
            this.b.invalidate();
        }
    }

    @Override // dc.kb1
    public void f(float f) {
        Context context = this.a;
        if (context == null) {
            return;
        }
        float fA = mb1.a(context, f);
        this.q = fA;
        this.r = fA;
        if (this.b != null) {
            k(this.m, this.n);
            this.b.invalidate();
        }
    }

    @Override // dc.kb1
    public void g(Canvas canvas) {
        canvas.saveLayer(this.d, null, 31);
    }

    @Override // dc.kb1
    public void h(float f) {
        Context context = this.a;
        if (context == null) {
            return;
        }
        this.r = mb1.a(context, f);
        if (this.b != null) {
            k(this.m, this.n);
            this.b.invalidate();
        }
    }

    @Override // dc.kb1
    public void i(Context context, AttributeSet attributeSet, View view) {
        if (view.getBackground() == null) {
            view.setBackgroundColor(Color.parseColor("#00000000"));
        }
        view.setLayerType(0, null);
        this.a = context;
        this.b = view;
        this.k = new float[8];
        this.l = new float[8];
        this.c = new Paint();
        this.d = new RectF();
        this.e = new RectF();
        this.f = new RectF();
        this.g = new Path();
        this.h = new Path();
        this.i = new PorterDuffXfermode(Build.VERSION.SDK_INT >= 23 ? PorterDuff.Mode.DST_OUT : PorterDuff.Mode.DST_IN);
        this.o = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jb1.RoundCorner);
        if (typedArrayObtainStyledAttributes == null) {
            return;
        }
        float dimension = typedArrayObtainStyledAttributes.getDimension(jb1.RoundCorner_rRadius, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(jb1.RoundCorner_rLeftRadius, dimension);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(jb1.RoundCorner_rRightRadius, dimension);
        float dimension4 = typedArrayObtainStyledAttributes.getDimension(jb1.RoundCorner_rTopRadius, dimension);
        float dimension5 = typedArrayObtainStyledAttributes.getDimension(jb1.RoundCorner_rBottomRadius, dimension);
        this.q = typedArrayObtainStyledAttributes.getDimension(jb1.RoundCorner_rTopLeftRadius, dimension4 > 0.0f ? dimension4 : dimension2);
        int i = jb1.RoundCorner_rTopRightRadius;
        if (dimension4 <= 0.0f) {
            dimension4 = dimension3;
        }
        this.r = typedArrayObtainStyledAttributes.getDimension(i, dimension4);
        int i2 = jb1.RoundCorner_rBottomLeftRadius;
        if (dimension5 > 0.0f) {
            dimension2 = dimension5;
        }
        this.s = typedArrayObtainStyledAttributes.getDimension(i2, dimension2);
        int i3 = jb1.RoundCorner_rBottomRightRadius;
        if (dimension5 > 0.0f) {
            dimension3 = dimension5;
        }
        this.t = typedArrayObtainStyledAttributes.getDimension(i3, dimension3);
        this.p = typedArrayObtainStyledAttributes.getDimension(jb1.RoundButton_rStrokeWidth, 0.0f);
        this.o = typedArrayObtainStyledAttributes.getColor(jb1.RoundButton_rStrokeColor, this.o);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // dc.kb1
    public void j(float f) {
        Context context = this.a;
        if (context == null) {
            return;
        }
        float fA = mb1.a(context, f);
        this.q = fA;
        this.r = fA;
        this.s = fA;
        this.t = fA;
        if (this.b != null) {
            k(this.m, this.n);
            this.b.invalidate();
        }
    }

    @Override // dc.kb1
    public void k(int i, int i2) {
        this.m = i;
        this.n = i2;
        if (this.j) {
            float fMin = (Math.min(i2, i) * 1.0f) / 2.0f;
            this.q = fMin;
            this.r = fMin;
            this.t = fMin;
            this.s = fMin;
        }
        s();
        RectF rectF = this.d;
        if (rectF != null) {
            float f = this.p;
            rectF.set(f, f, i - f, i2 - f);
        }
        RectF rectF2 = this.e;
        if (rectF2 != null) {
            float f2 = this.p;
            rectF2.set(f2 / 2.0f, f2 / 2.0f, i - (f2 / 2.0f), i2 - (f2 / 2.0f));
        }
        RectF rectF3 = this.f;
        if (rectF3 != null) {
            rectF3.set(0.0f, 0.0f, i, i2);
        }
    }

    @Override // dc.kb1
    public void l(int i) {
        this.o = i;
        if (this.b != null) {
            k(this.m, this.n);
            this.b.invalidate();
        }
    }

    @Override // dc.kb1
    public void m(Canvas canvas) {
        this.c.reset();
        this.g.reset();
        this.c.setAntiAlias(true);
        this.c.setStyle(Paint.Style.FILL);
        this.c.setXfermode(this.i);
        this.g.addRoundRect(this.d, this.k, Path.Direction.CCW);
        if (Build.VERSION.SDK_INT >= 23) {
            this.h.reset();
            this.h.addRect(this.f, Path.Direction.CCW);
            this.h.op(this.g, Path.Op.DIFFERENCE);
            canvas.drawPath(this.h, this.c);
        } else {
            canvas.drawPath(this.g, this.c);
        }
        this.c.setXfermode(null);
        canvas.restore();
        this.c.setXfermode(null);
        if (this.p > 0.0f) {
            this.c.setStyle(Paint.Style.STROKE);
            this.c.setStrokeWidth(this.p);
            this.c.setColor(this.o);
            this.g.reset();
            this.g.addRoundRect(this.e, this.l, Path.Direction.CCW);
            canvas.drawPath(this.g, this.c);
        }
    }

    @Override // dc.kb1
    public void n(float f, float f2, float f3, float f4) {
        Context context = this.a;
        if (context == null) {
            return;
        }
        this.q = mb1.a(context, f);
        this.r = mb1.a(this.a, f2);
        this.s = mb1.a(this.a, f3);
        this.t = mb1.a(this.a, f4);
        if (this.b != null) {
            k(this.m, this.n);
            this.b.invalidate();
        }
    }

    @Override // dc.kb1
    public void o(float f) {
        Context context = this.a;
        if (context == null) {
            return;
        }
        float fA = mb1.a(context, f);
        this.r = fA;
        this.t = fA;
        if (this.b != null) {
            k(this.m, this.n);
            this.b.invalidate();
        }
    }

    @Override // dc.kb1
    public void p(float f) {
        Context context = this.a;
        if (context == null) {
            return;
        }
        float fA = mb1.a(context, f);
        this.q = fA;
        this.s = fA;
        if (this.b != null) {
            k(this.m, this.n);
            this.b.invalidate();
        }
    }

    @Override // dc.kb1
    public void q(float f) {
        Context context = this.a;
        if (context == null) {
            return;
        }
        this.t = mb1.a(context, f);
        if (this.b != null) {
            k(this.m, this.n);
            this.b.invalidate();
        }
    }

    @Override // dc.kb1
    public void r(float f) {
        Context context = this.a;
        if (context == null) {
            return;
        }
        this.p = mb1.a(context, f);
        if (this.b != null) {
            k(this.m, this.n);
            this.b.invalidate();
        }
    }

    public final void s() {
        float[] fArr = this.k;
        float f = this.q;
        float f2 = this.p;
        float f3 = f - f2;
        fArr[1] = f3;
        fArr[0] = f3;
        float f4 = this.r;
        float f5 = f4 - f2;
        fArr[3] = f5;
        fArr[2] = f5;
        float f6 = this.t;
        float f7 = f6 - f2;
        fArr[5] = f7;
        fArr[4] = f7;
        float f8 = this.s;
        float f9 = f8 - f2;
        fArr[7] = f9;
        fArr[6] = f9;
        float[] fArr2 = this.l;
        float f10 = f - (f2 / 2.0f);
        fArr2[1] = f10;
        fArr2[0] = f10;
        float f11 = f4 - (f2 / 2.0f);
        fArr2[3] = f11;
        fArr2[2] = f11;
        float f12 = f6 - (f2 / 2.0f);
        fArr2[5] = f12;
        fArr2[4] = f12;
        float f13 = f8 - (f2 / 2.0f);
        fArr2[7] = f13;
        fArr2[6] = f13;
    }
}
