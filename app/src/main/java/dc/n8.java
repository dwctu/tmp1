package dc;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import androidx.annotation.Nullable;

/* compiled from: StrokeContent.java */
/* loaded from: classes.dex */
public class n8 extends w7 {
    public final va o;
    public final String p;
    public final boolean q;
    public final p8<Integer, Integer> r;

    @Nullable
    public p8<ColorFilter, ColorFilter> s;

    public n8(h7 h7Var, va vaVar, ta taVar) {
        super(h7Var, vaVar, taVar.b().toPaintCap(), taVar.e().toPaintJoin(), taVar.g(), taVar.i(), taVar.j(), taVar.f(), taVar.d());
        this.o = vaVar;
        this.p = taVar.h();
        this.q = taVar.k();
        p8<Integer, Integer> p8VarA = taVar.c().a();
        this.r = p8VarA;
        p8VarA.a(this);
        vaVar.i(p8VarA);
    }

    @Override // dc.w7, dc.m9
    public <T> void c(T t, @Nullable kd<T> kdVar) {
        super.c(t, kdVar);
        if (t == m7.b) {
            this.r.n(kdVar);
            return;
        }
        if (t == m7.E) {
            p8<ColorFilter, ColorFilter> p8Var = this.s;
            if (p8Var != null) {
                this.o.C(p8Var);
            }
            if (kdVar == null) {
                this.s = null;
                return;
            }
            e9 e9Var = new e9(kdVar);
            this.s = e9Var;
            e9Var.a(this);
            this.o.i(this.r);
        }
    }

    @Override // dc.w7, dc.a8
    public void g(Canvas canvas, Matrix matrix, int i) {
        if (this.q) {
            return;
        }
        this.i.setColor(((q8) this.r).p());
        p8<ColorFilter, ColorFilter> p8Var = this.s;
        if (p8Var != null) {
            this.i.setColorFilter(p8Var.h());
        }
        super.g(canvas, matrix, i);
    }

    @Override // dc.y7
    public String getName() {
        return this.p;
    }
}
