package dc;

import org.slf4j.helpers.MessageFormatter;

/* compiled from: ShapePath.java */
/* loaded from: classes.dex */
public class sa implements fa {
    public final String a;
    public final int b;
    public final x9 c;
    public final boolean d;

    public sa(String str, int i, x9 x9Var, boolean z) {
        this.a = str;
        this.b = i;
        this.c = x9Var;
        this.d = z;
    }

    @Override // dc.fa
    public y7 a(h7 h7Var, va vaVar) {
        return new m8(h7Var, vaVar, this);
    }

    public String b() {
        return this.a;
    }

    public x9 c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    public String toString() {
        return "ShapePath{name=" + this.a + ", index=" + this.b + MessageFormatter.DELIM_STOP;
    }
}
