package dc;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import dc.p8;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FillContent.java */
/* loaded from: classes.dex */
public class c8 implements a8, p8.b, g8 {
    public final Path a;
    public final Paint b;
    public final va c;
    public final String d;
    public final boolean e;
    public final List<i8> f;
    public final p8<Integer, Integer> g;
    public final p8<Integer, Integer> h;

    @Nullable
    public p8<ColorFilter, ColorFilter> i;
    public final h7 j;

    public c8(h7 h7Var, va vaVar, qa qaVar) {
        Path path = new Path();
        this.a = path;
        this.b = new v7(1);
        this.f = new ArrayList();
        this.c = vaVar;
        this.d = qaVar.d();
        this.e = qaVar.f();
        this.j = h7Var;
        if (qaVar.b() == null || qaVar.e() == null) {
            this.g = null;
            this.h = null;
            return;
        }
        path.setFillType(qaVar.c());
        p8<Integer, Integer> p8VarA = qaVar.b().a();
        this.g = p8VarA;
        p8VarA.a(this);
        vaVar.i(p8VarA);
        p8<Integer, Integer> p8VarA2 = qaVar.e().a();
        this.h = p8VarA2;
        p8VarA2.a(this);
        vaVar.i(p8VarA2);
    }

    @Override // dc.p8.b
    public void a() {
        this.j.invalidateSelf();
    }

    @Override // dc.y7
    public void b(List<y7> list, List<y7> list2) {
        for (int i = 0; i < list2.size(); i++) {
            y7 y7Var = list2.get(i);
            if (y7Var instanceof i8) {
                this.f.add((i8) y7Var);
            }
        }
    }

    @Override // dc.m9
    public <T> void c(T t, @Nullable kd<T> kdVar) {
        if (t == m7.a) {
            this.g.n(kdVar);
            return;
        }
        if (t == m7.d) {
            this.h.n(kdVar);
            return;
        }
        if (t == m7.E) {
            p8<ColorFilter, ColorFilter> p8Var = this.i;
            if (p8Var != null) {
                this.c.C(p8Var);
            }
            if (kdVar == null) {
                this.i = null;
                return;
            }
            e9 e9Var = new e9(kdVar);
            this.i = e9Var;
            e9Var.a(this);
            this.c.i(this.i);
        }
    }

    @Override // dc.m9
    public void d(l9 l9Var, int i, List<l9> list, l9 l9Var2) {
        gd.m(l9Var, i, list, l9Var2, this);
    }

    @Override // dc.a8
    public void e(RectF rectF, Matrix matrix, boolean z) {
        this.a.reset();
        for (int i = 0; i < this.f.size(); i++) {
            this.a.addPath(this.f.get(i).getPath(), matrix);
        }
        this.a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // dc.a8
    public void g(Canvas canvas, Matrix matrix, int i) {
        if (this.e) {
            return;
        }
        e7.a("FillContent#draw");
        this.b.setColor(((q8) this.g).p());
        this.b.setAlpha(gd.d((int) ((((i / 255.0f) * this.h.h().intValue()) / 100.0f) * 255.0f), 0, 255));
        p8<ColorFilter, ColorFilter> p8Var = this.i;
        if (p8Var != null) {
            this.b.setColorFilter(p8Var.h());
        }
        this.a.reset();
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            this.a.addPath(this.f.get(i2).getPath(), matrix);
        }
        canvas.drawPath(this.a, this.b);
        e7.b("FillContent#draw");
    }

    @Override // dc.y7
    public String getName() {
        return this.d;
    }
}
