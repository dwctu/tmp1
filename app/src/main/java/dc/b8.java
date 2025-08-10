package dc;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import dc.p8;
import dc.ua;
import java.util.List;

/* compiled from: EllipseContent.java */
/* loaded from: classes.dex */
public class b8 implements i8, p8.b, g8 {
    public final String b;
    public final h7 c;
    public final p8<?, PointF> d;
    public final p8<?, PointF> e;
    public final ea f;
    public boolean h;
    public final Path a = new Path();
    public x7 g = new x7();

    public b8(h7 h7Var, va vaVar, ea eaVar) {
        this.b = eaVar.b();
        this.c = h7Var;
        p8<PointF, PointF> p8VarA = eaVar.d().a();
        this.d = p8VarA;
        p8<PointF, PointF> p8VarA2 = eaVar.c().a();
        this.e = p8VarA2;
        this.f = eaVar;
        vaVar.i(p8VarA);
        vaVar.i(p8VarA2);
        p8VarA.a(this);
        p8VarA2.a(this);
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
                    this.g.a(o8Var);
                    o8Var.c(this);
                }
            }
        }
    }

    @Override // dc.m9
    public <T> void c(T t, @Nullable kd<T> kdVar) {
        if (t == m7.i) {
            this.d.n(kdVar);
        } else if (t == m7.l) {
            this.e.n(kdVar);
        }
    }

    @Override // dc.m9
    public void d(l9 l9Var, int i, List<l9> list, l9 l9Var2) {
        gd.m(l9Var, i, list, l9Var2, this);
    }

    public final void f() {
        this.h = false;
        this.c.invalidateSelf();
    }

    @Override // dc.y7
    public String getName() {
        return this.b;
    }

    @Override // dc.i8
    public Path getPath() {
        if (this.h) {
            return this.a;
        }
        this.a.reset();
        if (this.f.e()) {
            this.h = true;
            return this.a;
        }
        PointF pointFH = this.d.h();
        float f = pointFH.x / 2.0f;
        float f2 = pointFH.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.a.reset();
        if (this.f.f()) {
            float f5 = -f2;
            this.a.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.a.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.a.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.a.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.a.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.a.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.a.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.a.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.a.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.a.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF pointFH2 = this.e.h();
        this.a.offset(pointFH2.x, pointFH2.y);
        this.a.close();
        this.g.b(this.a);
        this.h = true;
        return this.a;
    }
}
