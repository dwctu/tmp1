package dc;

/* compiled from: DimensionStatus.java */
/* loaded from: classes3.dex */
public class be1 {
    public static final be1 c;
    public static final be1 d;
    public static final be1 e;
    public static final be1 f;
    public static final be1 g;
    public static final be1 h;
    public static final be1 i;
    public static final be1 j;
    public static final be1 k;
    public static final be1 l;
    public static final be1 m;
    public static final be1 n;
    public static final be1[] o;
    public final int a;
    public final boolean b;

    static {
        be1 be1Var = new be1(0, false);
        c = be1Var;
        be1 be1Var2 = new be1(1, true);
        d = be1Var2;
        be1 be1Var3 = new be1(2, false);
        e = be1Var3;
        be1 be1Var4 = new be1(3, true);
        f = be1Var4;
        be1 be1Var5 = new be1(4, false);
        g = be1Var5;
        be1 be1Var6 = new be1(5, true);
        h = be1Var6;
        be1 be1Var7 = new be1(6, false);
        i = be1Var7;
        be1 be1Var8 = new be1(7, true);
        j = be1Var8;
        be1 be1Var9 = new be1(8, false);
        k = be1Var9;
        be1 be1Var10 = new be1(9, true);
        l = be1Var10;
        be1 be1Var11 = new be1(10, false);
        m = be1Var11;
        be1 be1Var12 = new be1(10, true);
        n = be1Var12;
        o = new be1[]{be1Var, be1Var2, be1Var3, be1Var4, be1Var5, be1Var6, be1Var7, be1Var8, be1Var9, be1Var10, be1Var11, be1Var12};
    }

    public be1(int i2, boolean z) {
        this.a = i2;
        this.b = z;
    }

    public boolean a(be1 be1Var) {
        int i2 = this.a;
        int i3 = be1Var.a;
        return i2 < i3 || ((!this.b || l == this) && i2 == i3);
    }

    public be1 b() {
        return !this.b ? o[this.a + 1] : this;
    }
}
