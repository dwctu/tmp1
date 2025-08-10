package dc;

import android.graphics.PointF;

/* compiled from: CircleShape.java */
/* loaded from: classes.dex */
public class ea implements fa {
    public final String a;
    public final ca<PointF, PointF> b;
    public final v9 c;
    public final boolean d;
    public final boolean e;

    public ea(String str, ca<PointF, PointF> caVar, v9 v9Var, boolean z, boolean z2) {
        this.a = str;
        this.b = caVar;
        this.c = v9Var;
        this.d = z;
        this.e = z2;
    }

    @Override // dc.fa
    public y7 a(h7 h7Var, va vaVar) {
        return new b8(h7Var, vaVar, this);
    }

    public String b() {
        return this.a;
    }

    public ca<PointF, PointF> c() {
        return this.b;
    }

    public v9 d() {
        return this.c;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.d;
    }
}
