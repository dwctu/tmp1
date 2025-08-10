package com.huawei.hms.scankit.aiscan.common;

/* compiled from: GenericGF.java */
/* loaded from: classes3.dex */
public final class h {
    public static final h a = new h(4201, 4096, 1);
    public static final h b = new h(1033, 1024, 1);
    public static final h c;
    public static final h d;
    public static final h e;
    public static final h f;
    public static final h g;
    public static final h h;
    private final int[] i;
    private final int[] j;
    private final i k;
    private final i l;
    private final int m;
    private final int n;
    private final int o;

    static {
        h hVar = new h(67, 64, 1);
        c = hVar;
        d = new h(19, 16, 1);
        e = new h(285, 256, 0);
        h hVar2 = new h(301, 256, 1);
        f = hVar2;
        g = hVar2;
        h = hVar;
    }

    public h(int i, int i2, int i3) {
        this.n = i;
        this.m = i2;
        this.o = i3;
        this.i = new int[i2];
        this.j = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.i[i5] = i4;
            i4 *= 2;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.j[this.i[i6]] = i6;
        }
        this.k = new i(this, new int[]{0});
        this.l = new i(this, new int[]{1});
    }

    public static int a(int i, int i2) {
        return i ^ i2;
    }

    public int a(int i) {
        if (com.huawei.hms.scankit.util.b.a(this.i, i)) {
            return this.i[i];
        }
        return -1;
    }

    public i b() {
        return this.l;
    }

    public int c(int i) {
        if (i != 0) {
            return this.j[i];
        }
        try {
            throw new IllegalArgumentException();
        } catch (Exception e2) {
            throw e2;
        }
    }

    public i d() {
        return this.k;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.n) + ',' + this.m + ')';
    }

    public i b(int i, int i2) throws Exception {
        if (i < 0) {
            try {
                throw new IllegalArgumentException();
            } catch (Exception e2) {
                throw e2;
            }
        }
        if (i2 == 0) {
            return this.k;
        }
        int[] iArr = new int[i + 1];
        iArr[0] = i2;
        return new i(this, iArr);
    }

    public int a() {
        return this.o;
    }

    public int c(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.i;
        int[] iArr2 = this.j;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.m - 1)];
    }

    public int c() {
        return this.m;
    }

    public int b(int i) {
        if (i != 0) {
            return this.i[(this.m - this.j[i]) - 1];
        }
        try {
            throw new ArithmeticException();
        } catch (Exception e2) {
            throw e2;
        }
    }
}
