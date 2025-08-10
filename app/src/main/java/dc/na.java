package dc;

import android.graphics.PointF;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: RectangleShape.java */
/* loaded from: classes.dex */
public class na implements fa {
    public final String a;
    public final ca<PointF, PointF> b;
    public final ca<PointF, PointF> c;
    public final r9 d;
    public final boolean e;

    public na(String str, ca<PointF, PointF> caVar, ca<PointF, PointF> caVar2, r9 r9Var, boolean z) {
        this.a = str;
        this.b = caVar;
        this.c = caVar2;
        this.d = r9Var;
        this.e = z;
    }

    @Override // dc.fa
    public y7 a(h7 h7Var, va vaVar) {
        return new k8(h7Var, vaVar, this);
    }

    public r9 b() {
        return this.d;
    }

    public String c() {
        return this.a;
    }

    public ca<PointF, PointF> d() {
        return this.b;
    }

    public ca<PointF, PointF> e() {
        return this.c;
    }

    public boolean f() {
        return this.e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.b + ", size=" + this.c + MessageFormatter.DELIM_STOP;
    }
}
