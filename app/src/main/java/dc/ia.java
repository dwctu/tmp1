package dc;

import androidx.annotation.Nullable;
import dc.ta;
import java.util.List;

/* compiled from: GradientStroke.java */
/* loaded from: classes.dex */
public class ia implements fa {
    public final String a;
    public final ja b;
    public final s9 c;
    public final t9 d;
    public final v9 e;
    public final v9 f;
    public final r9 g;
    public final ta.b h;
    public final ta.c i;
    public final float j;
    public final List<r9> k;

    @Nullable
    public final r9 l;
    public final boolean m;

    public ia(String str, ja jaVar, s9 s9Var, t9 t9Var, v9 v9Var, v9 v9Var2, r9 r9Var, ta.b bVar, ta.c cVar, float f, List<r9> list, @Nullable r9 r9Var2, boolean z) {
        this.a = str;
        this.b = jaVar;
        this.c = s9Var;
        this.d = t9Var;
        this.e = v9Var;
        this.f = v9Var2;
        this.g = r9Var;
        this.h = bVar;
        this.i = cVar;
        this.j = f;
        this.k = list;
        this.l = r9Var2;
        this.m = z;
    }

    @Override // dc.fa
    public y7 a(h7 h7Var, va vaVar) {
        return new e8(h7Var, vaVar, this);
    }

    public ta.b b() {
        return this.h;
    }

    @Nullable
    public r9 c() {
        return this.l;
    }

    public v9 d() {
        return this.f;
    }

    public s9 e() {
        return this.c;
    }

    public ja f() {
        return this.b;
    }

    public ta.c g() {
        return this.i;
    }

    public List<r9> h() {
        return this.k;
    }

    public float i() {
        return this.j;
    }

    public String j() {
        return this.a;
    }

    public t9 k() {
        return this.d;
    }

    public v9 l() {
        return this.e;
    }

    public r9 m() {
        return this.g;
    }

    public boolean n() {
        return this.m;
    }
}
