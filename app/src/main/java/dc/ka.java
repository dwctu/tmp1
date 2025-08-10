package dc;

/* compiled from: Mask.java */
/* loaded from: classes.dex */
public class ka {
    public final a a;
    public final x9 b;
    public final t9 c;
    public final boolean d;

    /* compiled from: Mask.java */
    public enum a {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public ka(a aVar, x9 x9Var, t9 t9Var, boolean z) {
        this.a = aVar;
        this.b = x9Var;
        this.c = t9Var;
        this.d = z;
    }

    public a a() {
        return this.a;
    }

    public x9 b() {
        return this.b;
    }

    public t9 c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }
}
