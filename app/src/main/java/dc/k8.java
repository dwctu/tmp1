package dc;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import dc.p8;
import dc.ua;
import java.util.List;

/* compiled from: RectangleContent.java */
/* loaded from: classes.dex */
public class k8 implements p8.b, g8, i8 {
    public final String c;
    public final boolean d;
    public final h7 e;
    public final p8<?, PointF> f;
    public final p8<?, PointF> g;
    public final p8<?, Float> h;
    public boolean j;
    public final Path a = new Path();
    public final RectF b = new RectF();
    public x7 i = new x7();

    public k8(h7 h7Var, va vaVar, na naVar) {
        this.c = naVar.c();
        this.d = naVar.f();
        this.e = h7Var;
        p8<PointF, PointF> p8VarA = naVar.d().a();
        this.f = p8VarA;
        p8<PointF, PointF> p8VarA2 = naVar.e().a();
        this.g = p8VarA2;
        p8<Float, Float> p8VarA3 = naVar.b().a();
        this.h = p8VarA3;
        vaVar.i(p8VarA);
        vaVar.i(p8VarA2);
        vaVar.i(p8VarA3);
        p8VarA.a(this);
        p8VarA2.a(this);
        p8VarA3.a(this);
    }

    @Override // dc.p8.b
    public void a() {
        f();
    }

    @Override // dc.y7
    public void b(List<y7> list, List<y7> list2) {
        for (int i = 0; i < list.size(); i++) {
            y7 y7Var = list.get(i);
            if (y7Var instanceof o8) {
                o8 o8Var = (o8) y7Var;
                if (o8Var.i() == ua.a.SIMULTANEOUSLY) {
                    this.i.a(o8Var);
                    o8Var.c(this);
                }
            }
        }
    }

    @Override // dc.m9
    public <T> void c(T t, @Nullable kd<T> kdVar) {
        if (t == m7.j) {
            this.g.n(kdVar);
        } else if (t == m7.l) {
            this.f.n(kdVar);
        } else if (t == m7.k) {
            this.h.n(kdVar);
        }
    }

    @Override // dc.m9
    public void d(l9 l9Var, int i, List<l9> list, l9 l9Var2) {
        gd.m(l9Var, i, list, l9Var2, this);
    }

    public final void f() {
        this.j = false;
        this.e.invalidateSelf();
    }

    @Override // dc.y7
    public String getName() {
        return this.c;
    }

    @Override // dc.i8
    public Path getPath() {
        if (this.j) {
            return this.a;
        }
        this.a.reset();
        if (this.d) {
            this.j = true;
            return this.a;
        }
        PointF pointFH = this.g.h();
        float f = pointFH.x / 2.0f;
        float f2 = pointFH.y / 2.0f;
        p8<?, Float> p8Var = this.h;
        float fP = p8Var == null ? 0.0f : ((r8) p8Var).p();
        float fMin = Math.min(f, f2);
        if (fP > fMin) {
            fP = fMin;
        }
        PointF pointFH2 = this.f.h();
        this.a.moveTo(pointFH2.x + f, (pointFH2.y - f2) + fP);
        this.a.lineTo(pointFH2.x + f, (pointFH2.y + f2) - fP);
        if (fP > 0.0f) {
            RectF rectF = this.b;
            float f3 = pointFH2.x;
            float f4 = fP * 2.0f;
            float f5 = pointFH2.y;
            rectF.set((f3 + f) - f4, (f5 + f2) - f4, f3 + f, f5 + f2);
            this.a.arcTo(this.b, 0.0f, 90.0f, false);
        }
        this.a.lineTo((pointFH2.x - f) + fP, pointFH2.y + f2);
        if (fP > 0.0f) {
            RectF rectF2 = this.b;
            float f6 = pointFH2.x;
            float f7 = pointFH2.y;
            float f8 = fP * 2.0f;
            rectF2.set(f6 - f, (f7 + f2) - f8, (f6 - f) + f8, f7 + f2);
            this.a.arcTo(this.b, 90.0f, 90.0f, false);
        }
        this.a.lineTo(pointFH2.x - f, (pointFH2.y - f2) + fP);
        if (fP > 0.0f) {
            RectF rectF3 = this.b;
            float f9 = pointFH2.x;
            float f10 = pointFH2.y;
            float f11 = fP * 2.0f;
            rectF3.set(f9 - f, f10 - f2, (f9 - f) + f11, (f10 - f2) + f11);
            this.a.arcTo(this.b, 180.0f, 90.0f, false);
        }
        this.a.lineTo((pointFH2.x + f) - fP, pointFH2.y - f2);
        if (fP > 0.0f) {
            RectF rectF4 = this.b;
            float f12 = pointFH2.x;
            float f13 = fP * 2.0f;
            float f14 = pointFH2.y;
            rectF4.set((f12 + f) - f13, f14 - f2, f12 + f, (f14 - f2) + f13);
            this.a.arcTo(this.b, 270.0f, 90.0f, false);
        }
        this.a.close();
        this.i.b(this.a);
        this.j = true;
        return this.a;
    }
}
