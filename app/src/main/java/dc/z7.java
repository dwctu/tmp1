package dc;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import dc.p8;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ContentGroup.java */
/* loaded from: classes.dex */
public class z7 implements a8, i8, p8.b, m9 {
    public Paint a;
    public RectF b;
    public final Matrix c;
    public final Path d;
    public final RectF e;
    public final String f;
    public final boolean g;
    public final List<y7> h;
    public final h7 i;

    @Nullable
    public List<i8> j;

    @Nullable
    public d9 k;

    public z7(h7 h7Var, va vaVar, ra raVar) {
        this(h7Var, vaVar, raVar.c(), raVar.d(), f(h7Var, vaVar, raVar.b()), h(raVar.b()));
    }

    public static List<y7> f(h7 h7Var, va vaVar, List<fa> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            y7 y7VarA = list.get(i).a(h7Var, vaVar);
            if (y7VarA != null) {
                arrayList.add(y7VarA);
            }
        }
        return arrayList;
    }

    @Nullable
    public static ba h(List<fa> list) {
        for (int i = 0; i < list.size(); i++) {
            fa faVar = list.get(i);
            if (faVar instanceof ba) {
                return (ba) faVar;
            }
        }
        return null;
    }

    @Override // dc.p8.b
    public void a() {
        this.i.invalidateSelf();
    }

    @Override // dc.y7
    public void b(List<y7> list, List<y7> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.h.size());
        arrayList.addAll(list);
        for (int size = this.h.size() - 1; size >= 0; size--) {
            y7 y7Var = this.h.get(size);
            y7Var.b(arrayList, this.h.subList(0, size));
            arrayList.add(y7Var);
        }
    }

    @Override // dc.m9
    public <T> void c(T t, @Nullable kd<T> kdVar) {
        d9 d9Var = this.k;
        if (d9Var != null) {
            d9Var.c(t, kdVar);
        }
    }

    @Override // dc.m9
    public void d(l9 l9Var, int i, List<l9> list, l9 l9Var2) {
        if (l9Var.g(getName(), i) || "__container".equals(getName())) {
            if (!"__container".equals(getName())) {
                l9Var2 = l9Var2.a(getName());
                if (l9Var.c(getName(), i)) {
                    list.add(l9Var2.i(this));
                }
            }
            if (l9Var.h(getName(), i)) {
                int iE = i + l9Var.e(getName(), i);
                for (int i2 = 0; i2 < this.h.size(); i2++) {
                    y7 y7Var = this.h.get(i2);
                    if (y7Var instanceof m9) {
                        ((m9) y7Var).d(l9Var, iE, list, l9Var2);
                    }
                }
            }
        }
    }

    @Override // dc.a8
    public void e(RectF rectF, Matrix matrix, boolean z) {
        this.c.set(matrix);
        d9 d9Var = this.k;
        if (d9Var != null) {
            this.c.preConcat(d9Var.f());
        }
        this.e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.h.size() - 1; size >= 0; size--) {
            y7 y7Var = this.h.get(size);
            if (y7Var instanceof a8) {
                ((a8) y7Var).e(this.e, this.c, z);
                rectF.union(this.e);
            }
        }
    }

    @Override // dc.a8
    public void g(Canvas canvas, Matrix matrix, int i) {
        if (this.g) {
            return;
        }
        this.c.set(matrix);
        d9 d9Var = this.k;
        if (d9Var != null) {
            this.c.preConcat(d9Var.f());
            i = (int) (((((this.k.h() == null ? 100 : this.k.h().h().intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        boolean z = this.i.J() && k() && i != 255;
        if (z) {
            this.b.set(0.0f, 0.0f, 0.0f, 0.0f);
            e(this.b, this.c, true);
            this.a.setAlpha(i);
            hd.m(canvas, this.b, this.a);
        }
        if (z) {
            i = 255;
        }
        for (int size = this.h.size() - 1; size >= 0; size--) {
            y7 y7Var = this.h.get(size);
            if (y7Var instanceof a8) {
                ((a8) y7Var).g(canvas, this.c, i);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    @Override // dc.y7
    public String getName() {
        return this.f;
    }

    @Override // dc.i8
    public Path getPath() {
        this.c.reset();
        d9 d9Var = this.k;
        if (d9Var != null) {
            this.c.set(d9Var.f());
        }
        this.d.reset();
        if (this.g) {
            return this.d;
        }
        for (int size = this.h.size() - 1; size >= 0; size--) {
            y7 y7Var = this.h.get(size);
            if (y7Var instanceof i8) {
                this.d.addPath(((i8) y7Var).getPath(), this.c);
            }
        }
        return this.d;
    }

    public List<i8> i() {
        if (this.j == null) {
            this.j = new ArrayList();
            for (int i = 0; i < this.h.size(); i++) {
                y7 y7Var = this.h.get(i);
                if (y7Var instanceof i8) {
                    this.j.add((i8) y7Var);
                }
            }
        }
        return this.j;
    }

    public Matrix j() {
        d9 d9Var = this.k;
        if (d9Var != null) {
            return d9Var.f();
        }
        this.c.reset();
        return this.c;
    }

    public final boolean k() {
        int i = 0;
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            if ((this.h.get(i2) instanceof a8) && (i = i + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    public z7(h7 h7Var, va vaVar, String str, boolean z, List<y7> list, @Nullable ba baVar) {
        this.a = new v7();
        this.b = new RectF();
        this.c = new Matrix();
        this.d = new Path();
        this.e = new RectF();
        this.f = str;
        this.i = h7Var;
        this.g = z;
        this.h = list;
        if (baVar != null) {
            d9 d9VarB = baVar.b();
            this.k = d9VarB;
            d9VarB.a(vaVar);
            this.k.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            y7 y7Var = list.get(size);
            if (y7Var instanceof f8) {
                arrayList.add((f8) y7Var);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((f8) arrayList.get(size2)).f(list.listIterator(list.size()));
        }
    }
}
