package dc;

import android.graphics.Path;

/* compiled from: GradientFill.java */
/* loaded from: classes.dex */
public class ha implements fa {
    public final ja a;
    public final Path.FillType b;
    public final s9 c;
    public final t9 d;
    public final v9 e;
    public final v9 f;
    public final String g;
    public final boolean h;

    public ha(String str, ja jaVar, Path.FillType fillType, s9 s9Var, t9 t9Var, v9 v9Var, v9 v9Var2, r9 r9Var, r9 r9Var2, boolean z) {
        this.a = jaVar;
        this.b = fillType;
        this.c = s9Var;
        this.d = t9Var;
        this.e = v9Var;
        this.f = v9Var2;
        this.g = str;
        this.h = z;
    }

    @Override // dc.fa
    public y7 a(h7 h7Var, va vaVar) {
        return new d8(h7Var, vaVar, this);
    }

    public v9 b() {
        return this.f;
    }

    public Path.FillType c() {
        return this.b;
    }

    public s9 d() {
        return this.c;
    }

    public ja e() {
        return this.a;
    }

    public String f() {
        return this.g;
    }

    public t9 g() {
        return this.d;
    }

    public v9 h() {
        return this.e;
    }

    public boolean i() {
        return this.h;
    }
}
