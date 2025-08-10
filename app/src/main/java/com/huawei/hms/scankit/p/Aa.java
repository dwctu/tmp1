package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0309a;

/* compiled from: BitMatrixParser.java */
/* loaded from: classes3.dex */
public final class Aa {
    private final C0417y a;
    private Ya b;
    private Ua c;
    private boolean d;

    public Aa(C0417y c0417y) throws C0309a {
        int iB = c0417y.b();
        if (iB < 21 || (iB & 3) != 1) {
            throw C0309a.a();
        }
        this.a = c0417y;
    }

    private int a(int i, int i2, int i3) {
        return this.d ? this.a.b(i2, i) : this.a.b(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    public byte[] b() throws C0309a {
        Ua uaC = c();
        Ya yaD = d();
        Ka ka = Ka.values()[uaC.a()];
        int iB = this.a.b();
        ka.a(this.a, iB);
        C0417y c0417yA = yaD.a();
        byte[] bArr = new byte[yaD.d()];
        int i = iB - 1;
        boolean z = true;
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i2 > 0) {
            if (i2 == 6) {
                i2--;
            }
            for (int i6 = 0; i6 < iB; i6++) {
                int i7 = z ? i - i6 : i6;
                for (int i8 = 0; i8 < 2; i8++) {
                    int i9 = i2 - i8;
                    if (!c0417yA.b(i9, i7)) {
                        i5++;
                        i4 <<= 1;
                        if (this.a.b(i9, i7)) {
                            i4 |= 1;
                        }
                        if (i5 == 8) {
                            bArr[i3] = (byte) i4;
                            i3++;
                            i4 = 0;
                            i5 = 0;
                        }
                    }
                }
            }
            z = !z;
            i2 -= 2;
        }
        if (i3 == yaD.d()) {
            return bArr;
        }
        throw C0309a.a();
    }

    public Ua c() throws C0309a {
        Ua ua = this.c;
        if (ua != null) {
            return ua;
        }
        int iA = 0;
        int iA2 = 0;
        for (int i = 0; i < 6; i++) {
            iA2 = a(i, 8, iA2);
        }
        int iA3 = a(8, 7, a(8, 8, a(7, 8, iA2)));
        for (int i2 = 5; i2 >= 0; i2--) {
            iA3 = a(8, i2, iA3);
        }
        int iB = this.a.b();
        int i3 = iB - 7;
        for (int i4 = iB - 1; i4 >= i3; i4--) {
            iA = a(8, i4, iA);
        }
        for (int i5 = iB - 8; i5 < iB; i5++) {
            iA = a(i5, 8, iA);
        }
        Ua uaA = Ua.a(iA3, iA);
        this.c = uaA;
        if (uaA != null) {
            return uaA;
        }
        throw C0309a.a();
    }

    public Ya d() throws C0309a {
        Ya ya = this.b;
        if (ya != null) {
            return ya;
        }
        int iB = this.a.b();
        int i = (iB - 17) / 4;
        if (i <= 6) {
            return Ya.c(i);
        }
        int i2 = iB - 11;
        int iA = 0;
        int iA2 = 0;
        for (int i3 = 5; i3 >= 0; i3--) {
            for (int i4 = iB - 9; i4 >= i2; i4--) {
                iA2 = a(i4, i3, iA2);
            }
        }
        Ya yaA = Ya.a(iA2);
        if (yaA != null && yaA.c() == iB) {
            this.b = yaA;
            return yaA;
        }
        for (int i5 = 5; i5 >= 0; i5--) {
            for (int i6 = iB - 9; i6 >= i2; i6--) {
                iA = a(i5, i6, iA);
            }
        }
        Ya yaA2 = Ya.a(iA);
        if (yaA2 == null || yaA2.c() != iB) {
            throw C0309a.a();
        }
        this.b = yaA2;
        return yaA2;
    }

    public void e() {
        if (this.c == null) {
            return;
        }
        Ka.values()[this.c.a()].a(this.a, this.a.b());
    }

    public void a(boolean z) {
        this.b = null;
        this.c = null;
        this.d = z;
    }

    public void a() {
        int i = 0;
        while (i < this.a.d()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.a.b(); i3++) {
                if (this.a.b(i, i3) != this.a.b(i3, i)) {
                    this.a.a(i3, i);
                    this.a.a(i, i3);
                }
            }
            i = i2;
        }
    }
}
