package dc;

import java.util.concurrent.TimeUnit;

/* compiled from: CacheControl.java */
/* loaded from: classes5.dex */
public final class zb4 {
    public final boolean a;
    public final boolean b;
    public final int c;
    public final int d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final int h;
    public final int i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public String m;

    /* compiled from: CacheControl.java */
    public static final class a {
        public boolean a;
        public boolean b;
        public int c = -1;
        public int d = -1;
        public int e = -1;
        public boolean f;
        public boolean g;
        public boolean h;

        public zb4 a() {
            return new zb4(this);
        }

        public a b(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds(i);
                this.d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i);
        }

        public a c() {
            this.a = true;
            return this;
        }

        public a d() {
            this.f = true;
            return this;
        }
    }

    static {
        a aVar = new a();
        aVar.c();
        aVar.a();
        a aVar2 = new a();
        aVar2.d();
        aVar2.b(Integer.MAX_VALUE, TimeUnit.SECONDS);
        aVar2.a();
    }

    public zb4(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.a = z;
        this.b = z2;
        this.c = i;
        this.d = i2;
        this.e = z3;
        this.f = z4;
        this.g = z5;
        this.h = i3;
        this.i = i4;
        this.j = z6;
        this.k = z7;
        this.l = z8;
        this.m = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static dc.zb4 k(dc.qc4 r22) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.zb4.k(dc.qc4):dc.zb4");
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        if (this.a) {
            sb.append("no-cache, ");
        }
        if (this.b) {
            sb.append("no-store, ");
        }
        if (this.c != -1) {
            sb.append("max-age=");
            sb.append(this.c);
            sb.append(", ");
        }
        if (this.d != -1) {
            sb.append("s-maxage=");
            sb.append(this.d);
            sb.append(", ");
        }
        if (this.e) {
            sb.append("private, ");
        }
        if (this.f) {
            sb.append("public, ");
        }
        if (this.g) {
            sb.append("must-revalidate, ");
        }
        if (this.h != -1) {
            sb.append("max-stale=");
            sb.append(this.h);
            sb.append(", ");
        }
        if (this.i != -1) {
            sb.append("min-fresh=");
            sb.append(this.i);
            sb.append(", ");
        }
        if (this.j) {
            sb.append("only-if-cached, ");
        }
        if (this.k) {
            sb.append("no-transform, ");
        }
        if (this.l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public boolean b() {
        return this.e;
    }

    public boolean c() {
        return this.f;
    }

    public int d() {
        return this.c;
    }

    public int e() {
        return this.h;
    }

    public int f() {
        return this.i;
    }

    public boolean g() {
        return this.g;
    }

    public boolean h() {
        return this.a;
    }

    public boolean i() {
        return this.b;
    }

    public boolean j() {
        return this.j;
    }

    public String toString() {
        String str = this.m;
        if (str != null) {
            return str;
        }
        String strA = a();
        this.m = strA;
        return strA;
    }

    public zb4(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = -1;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = aVar.d;
        this.i = aVar.e;
        this.j = aVar.f;
        this.k = aVar.g;
        this.l = aVar.h;
    }
}
