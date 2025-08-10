package dc;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import dc.p8;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseStrokeContent.java */
/* loaded from: classes.dex */
public abstract class w7 implements p8.b, g8, a8 {
    public final h7 e;
    public final va f;
    public final float[] h;
    public final Paint i;
    public final p8<?, Float> j;
    public final p8<?, Integer> k;
    public final List<p8<?, Float>> l;

    @Nullable
    public final p8<?, Float> m;

    @Nullable
    public p8<ColorFilter, ColorFilter> n;
    public final PathMeasure a = new PathMeasure();
    public final Path b = new Path();
    public final Path c = new Path();
    public final RectF d = new RectF();
    public final List<b> g = new ArrayList();

    /* compiled from: BaseStrokeContent.java */
    public static final class b {
        public final List<i8> a;

        @Nullable
        public final o8 b;

        public b(@Nullable o8 o8Var) {
            this.a = new ArrayList();
            this.b = o8Var;
        }
    }

    public w7(h7 h7Var, va vaVar, Paint.Cap cap, Paint.Join join, float f, t9 t9Var, r9 r9Var, List<r9> list, r9 r9Var2) {
        v7 v7Var = new v7(1);
        this.i = v7Var;
        this.e = h7Var;
        this.f = vaVar;
        v7Var.setStyle(Paint.Style.STROKE);
        v7Var.setStrokeCap(cap);
        v7Var.setStrokeJoin(join);
        v7Var.setStrokeMiter(f);
        this.k = t9Var.a();
        this.j = r9Var.a();
        if (r9Var2 == null) {
            this.m = null;
        } else {
            this.m = r9Var2.a();
        }
        this.l = new ArrayList(list.size());
        this.h = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.l.add(list.get(i).a());
        }
        vaVar.i(this.k);
        vaVar.i(this.j);
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            vaVar.i(this.l.get(i2));
        }
        p8<?, Float> p8Var = this.m;
        if (p8Var != null) {
            vaVar.i(p8Var);
        }
        this.k.a(this);
        this.j.a(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.l.get(i3).a(this);
        }
        p8<?, Float> p8Var2 = this.m;
        if (p8Var2 != null) {
            p8Var2.a(this);
        }
    }

    @Override // dc.p8.b
    public void a() {
        this.e.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    @Override // dc.y7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(java.util.List<dc.y7> r8, java.util.List<dc.y7> r9) {
        /*
            r7 = this;
            int r0 = r8.size()
            int r0 = r0 + (-1)
            r1 = 0
            r2 = r1
        L8:
            if (r0 < 0) goto L22
            java.lang.Object r3 = r8.get(r0)
            dc.y7 r3 = (dc.y7) r3
            boolean r4 = r3 instanceof dc.o8
            if (r4 == 0) goto L1f
            dc.o8 r3 = (dc.o8) r3
            dc.ua$a r4 = r3.i()
            dc.ua$a r5 = dc.ua.a.INDIVIDUALLY
            if (r4 != r5) goto L1f
            r2 = r3
        L1f:
            int r0 = r0 + (-1)
            goto L8
        L22:
            if (r2 == 0) goto L27
            r2.c(r7)
        L27:
            int r8 = r9.size()
            int r8 = r8 + (-1)
            r0 = r1
        L2e:
            if (r8 < 0) goto L6c
            java.lang.Object r3 = r9.get(r8)
            dc.y7 r3 = (dc.y7) r3
            boolean r4 = r3 instanceof dc.o8
            if (r4 == 0) goto L55
            r4 = r3
            dc.o8 r4 = (dc.o8) r4
            dc.ua$a r5 = r4.i()
            dc.ua$a r6 = dc.ua.a.INDIVIDUALLY
            if (r5 != r6) goto L55
            if (r0 == 0) goto L4c
            java.util.List<dc.w7$b> r3 = r7.g
            r3.add(r0)
        L4c:
            dc.w7$b r0 = new dc.w7$b
            r0.<init>(r4)
            r4.c(r7)
            goto L69
        L55:
            boolean r4 = r3 instanceof dc.i8
            if (r4 == 0) goto L69
            if (r0 != 0) goto L60
            dc.w7$b r0 = new dc.w7$b
            r0.<init>(r2)
        L60:
            java.util.List r4 = dc.w7.b.a(r0)
            dc.i8 r3 = (dc.i8) r3
            r4.add(r3)
        L69:
            int r8 = r8 + (-1)
            goto L2e
        L6c:
            if (r0 == 0) goto L73
            java.util.List<dc.w7$b> r8 = r7.g
            r8.add(r0)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.w7.b(java.util.List, java.util.List):void");
    }

    @CallSuper
    public <T> void c(T t, @Nullable kd<T> kdVar) {
        if (t == m7.d) {
            this.k.n(kdVar);
            return;
        }
        if (t == m7.q) {
            this.j.n(kdVar);
            return;
        }
        if (t == m7.E) {
            p8<ColorFilter, ColorFilter> p8Var = this.n;
            if (p8Var != null) {
                this.f.C(p8Var);
            }
            if (kdVar == null) {
                this.n = null;
                return;
            }
            e9 e9Var = new e9(kdVar);
            this.n = e9Var;
            e9Var.a(this);
            this.f.i(this.n);
        }
    }

    @Override // dc.m9
    public void d(l9 l9Var, int i, List<l9> list, l9 l9Var2) {
        gd.m(l9Var, i, list, l9Var2, this);
    }

    @Override // dc.a8
    public void e(RectF rectF, Matrix matrix, boolean z) {
        e7.a("StrokeContent#getBounds");
        this.b.reset();
        for (int i = 0; i < this.g.size(); i++) {
            b bVar = this.g.get(i);
            for (int i2 = 0; i2 < bVar.a.size(); i2++) {
                this.b.addPath(((i8) bVar.a.get(i2)).getPath(), matrix);
            }
        }
        this.b.computeBounds(this.d, false);
        float fP = ((r8) this.j).p();
        RectF rectF2 = this.d;
        float f = fP / 2.0f;
        rectF2.set(rectF2.left - f, rectF2.top - f, rectF2.right + f, rectF2.bottom + f);
        rectF.set(this.d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        e7.b("StrokeContent#getBounds");
    }

    public final void f(Matrix matrix) {
        e7.a("StrokeContent#applyDashPattern");
        if (this.l.isEmpty()) {
            e7.b("StrokeContent#applyDashPattern");
            return;
        }
        float fG = hd.g(matrix);
        for (int i = 0; i < this.l.size(); i++) {
            this.h[i] = this.l.get(i).h().floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.h;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.h;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.h;
            fArr3[i] = fArr3[i] * fG;
        }
        p8<?, Float> p8Var = this.m;
        this.i.setPathEffect(new DashPathEffect(this.h, p8Var == null ? 0.0f : fG * p8Var.h().floatValue()));
        e7.b("StrokeContent#applyDashPattern");
    }

    public void g(Canvas canvas, Matrix matrix, int i) {
        e7.a("StrokeContent#draw");
        if (hd.h(matrix)) {
            e7.b("StrokeContent#draw");
            return;
        }
        this.i.setAlpha(gd.d((int) ((((i / 255.0f) * ((t8) this.k).p()) / 100.0f) * 255.0f), 0, 255));
        this.i.setStrokeWidth(((r8) this.j).p() * hd.g(matrix));
        if (this.i.getStrokeWidth() <= 0.0f) {
            e7.b("StrokeContent#draw");
            return;
        }
        f(matrix);
        p8<ColorFilter, ColorFilter> p8Var = this.n;
        if (p8Var != null) {
            this.i.setColorFilter(p8Var.h());
        }
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            b bVar = this.g.get(i2);
            if (bVar.b != null) {
                h(canvas, bVar, matrix);
            } else {
                e7.a("StrokeContent#buildPath");
                this.b.reset();
                for (int size = bVar.a.size() - 1; size >= 0; size--) {
                    this.b.addPath(((i8) bVar.a.get(size)).getPath(), matrix);
                }
                e7.b("StrokeContent#buildPath");
                e7.a("StrokeContent#drawPath");
                canvas.drawPath(this.b, this.i);
                e7.b("StrokeContent#drawPath");
            }
        }
        e7.b("StrokeContent#draw");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void h(android.graphics.Canvas r13, dc.w7.b r14, android.graphics.Matrix r15) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.w7.h(android.graphics.Canvas, dc.w7$b, android.graphics.Matrix):void");
    }
}
