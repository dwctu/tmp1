package dc;

import android.graphics.PointF;

/* compiled from: PolystarShape.java */
/* loaded from: classes.dex */
public class ma implements fa {
    public final String a;
    public final a b;
    public final r9 c;
    public final ca<PointF, PointF> d;
    public final r9 e;
    public final r9 f;
    public final r9 g;
    public final r9 h;
    public final r9 i;
    public final boolean j;

    /* compiled from: PolystarShape.java */
    public enum a {
        STAR(1),
        POLYGON(2);

        private final int value;

        a(int i) {
            this.value = i;
        }

        public static a forValue(int i) {
            for (a aVar : values()) {
                if (aVar.value == i) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public ma(String str, a aVar, r9 r9Var, ca<PointF, PointF> caVar, r9 r9Var2, r9 r9Var3, r9 r9Var4, r9 r9Var5, r9 r9Var6, boolean z) {
        this.a = str;
        this.b = aVar;
        this.c = r9Var;
        this.d = caVar;
        this.e = r9Var2;
        this.f = r9Var3;
        this.g = r9Var4;
        this.h = r9Var5;
        this.i = r9Var6;
        this.j = z;
    }

    @Override // dc.fa
    public y7 a(h7 h7Var, va vaVar) {
        return new j8(h7Var, vaVar, this);
    }

    public r9 b() {
        return this.f;
    }

    public r9 c() {
        return this.h;
    }

    public String d() {
        return this.a;
    }

    public r9 e() {
        return this.g;
    }

    public r9 f() {
        return this.i;
    }

    public r9 g() {
        return this.c;
    }

    public ca<PointF, PointF> h() {
        return this.d;
    }

    public r9 i() {
        return this.e;
    }

    public a j() {
        return this.b;
    }

    public boolean k() {
        return this.j;
    }
}
