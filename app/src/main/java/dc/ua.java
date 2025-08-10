package dc;

/* compiled from: ShapeTrimPath.java */
/* loaded from: classes.dex */
public class ua implements fa {
    public final String a;
    public final a b;
    public final r9 c;
    public final r9 d;
    public final r9 e;
    public final boolean f;

    /* compiled from: ShapeTrimPath.java */
    public enum a {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static a forId(int i) {
            if (i == 1) {
                return SIMULTANEOUSLY;
            }
            if (i == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i);
        }
    }

    public ua(String str, a aVar, r9 r9Var, r9 r9Var2, r9 r9Var3, boolean z) {
        this.a = str;
        this.b = aVar;
        this.c = r9Var;
        this.d = r9Var2;
        this.e = r9Var3;
        this.f = z;
    }

    @Override // dc.fa
    public y7 a(h7 h7Var, va vaVar) {
        return new o8(vaVar, this);
    }

    public r9 b() {
        return this.d;
    }

    public String c() {
        return this.a;
    }

    public r9 d() {
        return this.e;
    }

    public r9 e() {
        return this.c;
    }

    public a f() {
        return this.b;
    }

    public boolean g() {
        return this.f;
    }

    public String toString() {
        return "Trim Path: {start: " + this.c + ", end: " + this.d + ", offset: " + this.e + "}";
    }
}
