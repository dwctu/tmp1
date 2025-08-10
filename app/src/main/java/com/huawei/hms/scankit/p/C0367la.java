package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0309a;
import java.util.Formatter;

/* compiled from: DetectionResult.java */
/* renamed from: com.huawei.hms.scankit.p.la, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0367la {
    private final C0343fa a;
    private final C0371ma[] b;
    private C0351ha c;
    private final int d;

    public C0367la(C0343fa c0343fa, C0351ha c0351ha) {
        this.a = c0343fa;
        int iA = c0343fa.a();
        this.d = iA;
        this.c = c0351ha;
        this.b = new C0371ma[iA + 2];
    }

    private void a(C0371ma c0371ma) throws C0309a {
        if (c0371ma != null) {
            try {
                ((C0375na) c0371ma).a(this.a);
            } catch (ClassCastException unused) {
                throw C0309a.a();
            }
        }
    }

    private int f() {
        int iG = g();
        if (iG == 0) {
            return 0;
        }
        for (int i = 1; i < this.d + 1; i++) {
            C0355ia[] c0355iaArrB = this.b[i].b();
            for (int i2 = 0; i2 < c0355iaArrB.length; i2++) {
                if (c0355iaArrB[i2] != null && !c0355iaArrB[i2].g()) {
                    a(i, i2, c0355iaArrB);
                }
            }
        }
        return iG;
    }

    private int g() {
        h();
        return i() + j();
    }

    private void h() {
        C0371ma[] c0371maArr = this.b;
        if (c0371maArr[0] == null || c0371maArr[this.d + 1] == null) {
            return;
        }
        C0355ia[] c0355iaArrB = c0371maArr[0].b();
        C0355ia[] c0355iaArrB2 = this.b[this.d + 1].b();
        for (int i = 0; i < c0355iaArrB.length; i++) {
            if (c0355iaArrB[i] != null && c0355iaArrB2[i] != null && c0355iaArrB[i].c() == c0355iaArrB2[i].c()) {
                for (int i2 = 1; i2 <= this.d; i2++) {
                    C0355ia c0355ia = this.b[i2].b()[i];
                    if (c0355ia != null) {
                        c0355ia.b(c0355iaArrB[i].c());
                        if (!c0355ia.g()) {
                            this.b[i2].b()[i] = null;
                        }
                    }
                }
            }
        }
    }

    private int i() {
        C0371ma[] c0371maArr = this.b;
        if (c0371maArr[0] == null) {
            return 0;
        }
        C0355ia[] c0355iaArrB = c0371maArr[0].b();
        int i = 0;
        for (int i2 = 0; i2 < c0355iaArrB.length; i2++) {
            if (c0355iaArrB[i2] != null) {
                int iC = c0355iaArrB[i2].c();
                int iA = 0;
                for (int i3 = 1; i3 < this.d + 1 && iA < 2; i3++) {
                    C0355ia c0355ia = this.b[i3].b()[i2];
                    if (c0355ia != null) {
                        iA = a(iC, iA, c0355ia);
                        if (!c0355ia.g()) {
                            i++;
                        }
                    }
                }
            }
        }
        return i;
    }

    private int j() {
        C0371ma[] c0371maArr = this.b;
        int i = this.d + 1;
        if (c0371maArr[i] == null) {
            return 0;
        }
        C0355ia[] c0355iaArrB = c0371maArr[i].b();
        int i2 = 0;
        for (int i3 = 0; i3 < c0355iaArrB.length; i3++) {
            if (c0355iaArrB[i3] != null) {
                int iC = c0355iaArrB[i3].c();
                int iA = 0;
                for (int i4 = this.d + 1; i4 > 0 && iA < 2; i4--) {
                    C0355ia c0355ia = this.b[i4].b()[i3];
                    if (c0355ia != null) {
                        iA = a(iC, iA, c0355ia);
                        if (!c0355ia.g()) {
                            i2++;
                        }
                    }
                }
            }
        }
        return i2;
    }

    public int b() {
        return this.a.b();
    }

    public int c() {
        return this.a.c();
    }

    public C0351ha d() {
        return this.c;
    }

    public C0371ma[] e() throws C0309a {
        a(this.b[0]);
        a(this.b[this.d + 1]);
        int i = 928;
        while (true) {
            int iF = f();
            if (iF <= 0 || iF >= i) {
                break;
            }
            i = iF;
        }
        return this.b;
    }

    public String toString() {
        C0371ma[] c0371maArr = this.b;
        C0371ma c0371ma = c0371maArr[0];
        if (c0371ma == null) {
            c0371ma = c0371maArr[this.d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i = 0; i < c0371ma.b().length; i++) {
            try {
                formatter.format("CW %3d:", Integer.valueOf(i));
                for (int i2 = 0; i2 < this.d + 2; i2++) {
                    C0371ma[] c0371maArr2 = this.b;
                    if (c0371maArr2[i2] == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        C0355ia c0355ia = c0371maArr2[i2].b()[i];
                        if (c0355ia == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", Integer.valueOf(c0355ia.c()), Integer.valueOf(c0355ia.e()));
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        formatter.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }

    private static int a(int i, int i2, C0355ia c0355ia) {
        if (c0355ia == null || c0355ia.g()) {
            return i2;
        }
        if (!c0355ia.a(i)) {
            return i2 + 1;
        }
        c0355ia.b(i);
        return 0;
    }

    private void a(int i, int i2, C0355ia[] c0355iaArr) {
        C0355ia c0355ia = c0355iaArr[i2];
        C0355ia[] c0355iaArrB = this.b[i - 1].b();
        C0371ma[] c0371maArr = this.b;
        int i3 = i + 1;
        C0355ia[] c0355iaArrB2 = c0371maArr[i3] != null ? c0371maArr[i3].b() : c0355iaArrB;
        C0355ia[] c0355iaArr2 = new C0355ia[14];
        c0355iaArr2[2] = c0355iaArrB[i2];
        c0355iaArr2[3] = c0355iaArrB2[i2];
        if (i2 > 0) {
            int i4 = i2 - 1;
            c0355iaArr2[0] = c0355iaArr[i4];
            c0355iaArr2[4] = c0355iaArrB[i4];
            c0355iaArr2[5] = c0355iaArrB2[i4];
        }
        if (i2 > 1) {
            int i5 = i2 - 2;
            c0355iaArr2[8] = c0355iaArr[i5];
            c0355iaArr2[10] = c0355iaArrB[i5];
            c0355iaArr2[11] = c0355iaArrB2[i5];
        }
        if (i2 < c0355iaArr.length - 1) {
            int i6 = i2 + 1;
            c0355iaArr2[1] = c0355iaArr[i6];
            c0355iaArr2[6] = c0355iaArrB[i6];
            c0355iaArr2[7] = c0355iaArrB2[i6];
        }
        if (i2 < c0355iaArr.length - 2) {
            int i7 = i2 + 2;
            c0355iaArr2[9] = c0355iaArr[i7];
            c0355iaArr2[12] = c0355iaArrB[i7];
            c0355iaArr2[13] = c0355iaArrB2[i7];
        }
        for (int i8 = 0; i8 < 14 && !a(c0355ia, c0355iaArr2[i8]); i8++) {
        }
    }

    private static boolean a(C0355ia c0355ia, C0355ia c0355ia2) {
        if (c0355ia2 == null || !c0355ia2.g() || c0355ia2.a() != c0355ia.a()) {
            return false;
        }
        c0355ia.b(c0355ia2.c());
        return true;
    }

    public int a() {
        return this.d;
    }

    public void a(C0351ha c0351ha) {
        this.c = c0351ha;
    }

    public void a(int i, C0371ma c0371ma) {
        this.b[i] = c0371ma;
    }

    public C0371ma a(int i) {
        return this.b[i];
    }
}
