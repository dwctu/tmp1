package dc;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import dc.p8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* compiled from: RepeaterContent.java */
/* loaded from: classes.dex */
public class l8 implements a8, i8, f8, p8.b, g8 {
    public final Matrix a = new Matrix();
    public final Path b = new Path();
    public final h7 c;
    public final va d;
    public final String e;
    public final boolean f;
    public final p8<Float, Float> g;
    public final p8<Float, Float> h;
    public final d9 i;
    public z7 j;

    public l8(h7 h7Var, va vaVar, oa oaVar) {
        this.c = h7Var;
        this.d = vaVar;
        this.e = oaVar.c();
        this.f = oaVar.f();
        p8<Float, Float> p8VarA = oaVar.b().a();
        this.g = p8VarA;
        vaVar.i(p8VarA);
        p8VarA.a(this);
        p8<Float, Float> p8VarA2 = oaVar.d().a();
        this.h = p8VarA2;
        vaVar.i(p8VarA2);
        p8VarA2.a(this);
        d9 d9VarB = oaVar.e().b();
        this.i = d9VarB;
        d9VarB.a(vaVar);
        d9VarB.b(this);
    }

    @Override // dc.p8.b
    public void a() {
        this.c.invalidateSelf();
    }

    @Override // dc.y7
    public void b(List<y7> list, List<y7> list2) {
        this.j.b(list, list2);
    }

    @Override // dc.m9
    public <T> void c(T t, @Nullable kd<T> kdVar) {
        if (this.i.c(t, kdVar)) {
            return;
        }
        if (t == m7.s) {
            this.g.n(kdVar);
        } else if (t == m7.t) {
            this.h.n(kdVar);
        }
    }

    @Override // dc.m9
    public void d(l9 l9Var, int i, List<l9> list, l9 l9Var2) {
        gd.m(l9Var, i, list, l9Var2, this);
    }

    @Override // dc.a8
    public void e(RectF rectF, Matrix matrix, boolean z) {
        this.j.e(rectF, matrix, z);
    }

    @Override // dc.f8
    public void f(ListIterator<y7> listIterator) {
        if (this.j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.j = new z7(this.c, this.d, "Repeater", this.f, arrayList, null);
    }

    @Override // dc.a8
    public void g(Canvas canvas, Matrix matrix, int i) {
        float fFloatValue = this.g.h().floatValue();
        float fFloatValue2 = this.h.h().floatValue();
        float fFloatValue3 = this.i.i().h().floatValue() / 100.0f;
        float fFloatValue4 = this.i.e().h().floatValue() / 100.0f;
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.a.set(matrix);
            float f = i2;
            this.a.preConcat(this.i.g(f + fFloatValue2));
            this.j.g(canvas, this.a, (int) (i * gd.k(fFloatValue3, fFloatValue4, f / fFloatValue)));
        }
    }

    @Override // dc.y7
    public String getName() {
        return this.e;
    }

    @Override // dc.i8
    public Path getPath() {
        Path path = this.j.getPath();
        this.b.reset();
        float fFloatValue = this.g.h().floatValue();
        float fFloatValue2 = this.h.h().floatValue();
        for (int i = ((int) fFloatValue) - 1; i >= 0; i--) {
            this.a.set(this.i.g(i + fFloatValue2));
            this.b.addPath(path, this.a);
        }
        return this.b;
    }
}
