package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0309a;

/* compiled from: BitMatrixParser.java */
/* loaded from: classes3.dex */
public final class C {
    private final C0417y a;
    private final C0417y b;
    private final K c;

    public C(C0417y c0417y) throws C0309a {
        int iB = c0417y.b();
        if (iB < 8 || iB > 144 || (iB & 1) != 0) {
            throw C0309a.a();
        }
        this.c = b(c0417y);
        C0417y c0417yA = a(c0417y);
        this.a = c0417yA;
        this.b = new C0417y(c0417yA.d(), c0417yA.b());
    }

    private static K b(C0417y c0417y) throws C0309a {
        return K.a(c0417y.b(), c0417y.d());
    }

    private int c(int i, int i2) {
        int i3 = i - 1;
        int i4 = (a(i3, 0, i, i2) ? 1 : 0) << 1;
        int i5 = i2 - 1;
        if (a(i3, i5, i, i2)) {
            i4 |= 1;
        }
        int i6 = i4 << 1;
        int i7 = i2 - 3;
        if (a(0, i7, i, i2)) {
            i6 |= 1;
        }
        int i8 = i6 << 1;
        int i9 = i2 - 2;
        if (a(0, i9, i, i2)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        if (a(0, i5, i, i2)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (a(1, i7, i, i2)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (a(1, i9, i, i2)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        return a(1, i5, i, i2) ? i13 | 1 : i13;
    }

    private int d(int i, int i2) {
        int i3 = (a(i + (-3), 0, i, i2) ? 1 : 0) << 1;
        if (a(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (a(i - 1, 0, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (a(0, i2 - 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        int i7 = i2 - 1;
        if (a(0, i7, i, i2)) {
            i6 |= 1;
        }
        int i8 = i6 << 1;
        if (a(1, i7, i, i2)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        if (a(2, i7, i, i2)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        return a(3, i7, i, i2) ? i10 | 1 : i10;
    }

    public K a() {
        return this.c;
    }

    private int[] a(int i, int i2, int i3, int i4, byte[] bArr, int i5) {
        do {
            if (i < i2 && i3 >= 0 && !this.b.b(i3, i)) {
                bArr[i5] = (byte) b(i, i3, i2, i4);
                i5++;
            }
            i -= 2;
            i3 += 2;
            if (i < 0) {
                break;
            }
        } while (i3 < i4);
        int i6 = i + 1;
        int i7 = i3 + 3;
        do {
            if (i6 >= 0 && i7 < i4 && !this.b.b(i7, i6)) {
                bArr[i5] = (byte) b(i6, i7, i2, i4);
                i5++;
            }
            i6 += 2;
            i7 -= 2;
            if (i6 >= i2) {
                break;
            }
        } while (i7 >= 0);
        return new int[]{i6 + 3, i7 + 1, i5};
    }

    public byte[] b() throws C0309a {
        byte[] bArr = new byte[this.c.f()];
        int iB = this.a.b();
        int iD = this.a.d();
        int i = 4;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            if (i == iB && i2 == 0 && !z) {
                bArr[i3] = (byte) a(iB, iD);
                i -= 2;
                i2 += 2;
                i3++;
                z = true;
            } else {
                int i4 = iB - 2;
                if (i == i4 && i2 == 0 && (iD & 3) != 0 && !z2) {
                    bArr[i3] = (byte) b(iB, iD);
                    i -= 2;
                    i2 += 2;
                    i3++;
                    z2 = true;
                } else if (i == iB + 4 && i2 == 2 && (iD & 7) == 0 && !z3) {
                    bArr[i3] = (byte) c(iB, iD);
                    i -= 2;
                    i2 += 2;
                    i3++;
                    z3 = true;
                } else if (i == i4 && i2 == 0 && (iD & 7) == 4 && !z4) {
                    bArr[i3] = (byte) d(iB, iD);
                    i -= 2;
                    i2 += 2;
                    i3++;
                    z4 = true;
                } else {
                    int[] iArrA = a(i, iB, i2, iD, bArr, i3);
                    i = iArrA[0];
                    int i5 = iArrA[1];
                    i3 = iArrA[2];
                    i2 = i5;
                }
            }
            if (i >= iB && i2 >= iD) {
                break;
            }
        }
        if (i3 == this.c.f()) {
            return bArr;
        }
        throw C0309a.a();
    }

    private boolean a(int i, int i2, int i3, int i4) {
        if (i < 0) {
            i += i3;
            i2 += 4 - ((i3 + 4) & 7);
        }
        if (i2 < 0) {
            i2 += i4;
            i += 4 - ((i4 + 4) & 7);
        }
        this.b.c(i2, i);
        return this.a.b(i2, i);
    }

    private int a(int i, int i2) {
        int i3 = i - 1;
        int i4 = (a(i3, 0, i, i2) ? 1 : 0) << 1;
        if (a(i3, 1, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (a(i3, 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (a(0, i2 - 2, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        int i8 = i2 - 1;
        if (a(0, i8, i, i2)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        if (a(1, i8, i, i2)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (a(2, i8, i, i2)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        return a(3, i8, i, i2) ? i11 | 1 : i11;
    }

    private C0417y a(C0417y c0417y) {
        int iE = this.c.e();
        int iD = this.c.d();
        if (c0417y.b() == iE) {
            int iB = this.c.b();
            int iA = this.c.a();
            int i = iE / iB;
            int i2 = iD / iA;
            C0417y c0417y2 = new C0417y(i2 * iA, i * iB);
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = i3 * iB;
                for (int i5 = 0; i5 < i2; i5++) {
                    int i6 = i5 * iA;
                    for (int i7 = 0; i7 < iB; i7++) {
                        int i8 = ((iB + 2) * i3) + 1 + i7;
                        int i9 = i4 + i7;
                        for (int i10 = 0; i10 < iA; i10++) {
                            if (c0417y.b(((iA + 2) * i5) + 1 + i10, i8)) {
                                c0417y2.c(i6 + i10, i9);
                            }
                        }
                    }
                }
            }
            return c0417y2;
        }
        throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
    }

    private int b(int i, int i2, int i3, int i4) {
        int i5 = i - 2;
        int i6 = i2 - 2;
        int i7 = (a(i5, i6, i3, i4) ? 1 : 0) << 1;
        int i8 = i2 - 1;
        if (a(i5, i8, i3, i4)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        int i10 = i - 1;
        if (a(i10, i6, i3, i4)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        if (a(i10, i8, i3, i4)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (a(i10, i2, i3, i4)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (a(i, i6, i3, i4)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (a(i, i8, i3, i4)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        return a(i, i2, i3, i4) ? i15 | 1 : i15;
    }

    private int b(int i, int i2) {
        int i3 = (a(i + (-3), 0, i, i2) ? 1 : 0) << 1;
        if (a(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (a(i - 1, 0, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (a(0, i2 - 4, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (a(0, i2 - 3, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (a(0, i2 - 2, i, i2)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        int i9 = i2 - 1;
        if (a(0, i9, i, i2)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        return a(1, i9, i, i2) ? i10 | 1 : i10;
    }
}
