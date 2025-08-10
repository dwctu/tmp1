package com.huawei.hms.scankit.p;

import java.util.Locale;

/* compiled from: Encoder.java */
/* loaded from: classes3.dex */
public final class Tb {
    private static final int[] a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private static int a(int i, boolean z) {
        return ((z ? 88 : 112) + (i * 16)) * i;
    }

    public static Rb a(byte[] bArr, int i, int i2) throws Exception {
        C0413x c0413xA;
        int i3;
        boolean z;
        int iAbs;
        int iA;
        int i4;
        C0413x c0413xA2 = new Ub(bArr).a();
        int iD = ((c0413xA2.d() * i) / 100) + 11;
        int iD2 = c0413xA2.d() + iD;
        int i5 = 0;
        if (i2 == 0) {
            C0413x c0413xA3 = null;
            int i6 = 0;
            int i7 = 0;
            while (i6 <= 32) {
                boolean z2 = i6 <= 3;
                int i8 = z2 ? i6 + 1 : i6;
                int iA2 = a(i8, z2);
                if (iD2 <= iA2) {
                    if (c0413xA3 == null || i7 != a[i8]) {
                        int i9 = a[i8];
                        i7 = i9;
                        c0413xA3 = a(c0413xA2, i9);
                    }
                    int i10 = iA2 - (iA2 % i7);
                    if ((!z2 || c0413xA3.d() <= i7 * 64) && c0413xA3.d() + iD <= i10) {
                        c0413xA = c0413xA3;
                        i3 = i7;
                        z = z2;
                        iAbs = i8;
                        iA = iA2;
                    }
                }
                i6++;
                i5 = 0;
            }
            try {
                throw new IllegalArgumentException("Data too large for an Aztec code");
            } catch (Exception e) {
                throw e;
            }
        }
        z = i2 < 0;
        iAbs = Math.abs(i2);
        if (iAbs > (z ? 4 : 32)) {
            try {
                throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Illegal value %s for layers", Integer.valueOf(i2)));
            } catch (Exception e2) {
                throw e2;
            }
        }
        iA = a(iAbs, z);
        i3 = a[iAbs];
        int i11 = iA - (iA % i3);
        c0413xA = a(c0413xA2, i3);
        if (c0413xA.d() + iD > i11) {
            try {
                throw new IllegalArgumentException("Data to large for user specified layer");
            } catch (Exception e3) {
                throw e3;
            }
        }
        if (z && c0413xA.d() > i3 * 64) {
            try {
                throw new IllegalArgumentException("Data to large for user specified layer");
            } catch (Exception e4) {
                throw e4;
            }
        }
        C0413x c0413xB = b(c0413xA, iA, i3);
        int iD3 = c0413xA != null ? c0413xA.d() / i3 : 0;
        C0413x c0413xA4 = a(z, iAbs, iD3);
        int i12 = (z ? 11 : 14) + (iAbs * 4);
        int[] iArr = new int[i12];
        int i13 = 2;
        if (z) {
            for (int i14 = 0; i14 < i12; i14++) {
                iArr[i14] = i14;
            }
            i4 = i12;
        } else {
            int i15 = i12 / 2;
            i4 = i12 + 1 + (((i15 - 1) / 15) * 2);
            int i16 = i4 / 2;
            for (int i17 = 0; i17 < i15; i17++) {
                iArr[(i15 - i17) - 1] = (i16 - r15) - 1;
                iArr[i15 + i17] = (i17 / 15) + i17 + i16 + 1;
            }
        }
        C0417y c0417y = new C0417y(i4);
        int i18 = 0;
        int i19 = 0;
        while (i18 < iAbs) {
            int i20 = ((iAbs - i18) * 4) + (z ? 9 : 12);
            int i21 = 0;
            while (i21 < i20) {
                int i22 = i21 * 2;
                while (i5 < i13) {
                    if (c0413xB.a(i19 + i22 + i5)) {
                        int i23 = i18 * 2;
                        c0417y.c(iArr[i23 + i5], iArr[i23 + i21]);
                    }
                    if (c0413xB.a((i20 * 2) + i19 + i22 + i5)) {
                        int i24 = i18 * 2;
                        c0417y.c(iArr[i24 + i21], iArr[((i12 - 1) - i24) - i5]);
                    }
                    if (c0413xB.a((i20 * 4) + i19 + i22 + i5)) {
                        int i25 = (i12 - 1) - (i18 * 2);
                        c0417y.c(iArr[i25 - i5], iArr[i25 - i21]);
                    }
                    if (c0413xB.a((i20 * 6) + i19 + i22 + i5)) {
                        int i26 = i18 * 2;
                        c0417y.c(iArr[((i12 - 1) - i26) - i21], iArr[i26 + i5]);
                    }
                    i5++;
                    i13 = 2;
                }
                i21++;
                i5 = 0;
                i13 = 2;
            }
            i19 += i20 * 8;
            i18++;
            i5 = 0;
            i13 = 2;
        }
        a(c0417y, z, i4, c0413xA4);
        if (z) {
            a(c0417y, i4 / 2, 5);
        } else {
            int i27 = i4 / 2;
            a(c0417y, i27, 7);
            int i28 = 0;
            int i29 = 0;
            while (i28 < (i12 / 2) - 1) {
                for (int i30 = i27 & 1; i30 < i4; i30 += 2) {
                    int i31 = i27 - i29;
                    c0417y.c(i31, i30);
                    int i32 = i27 + i29;
                    c0417y.c(i32, i30);
                    c0417y.c(i30, i31);
                    c0417y.c(i30, i32);
                }
                i28 += 15;
                i29 += 16;
            }
        }
        Rb rb = new Rb();
        rb.a(z);
        rb.c(i4);
        rb.b(iAbs);
        rb.a(iD3);
        rb.a(c0417y);
        return rb;
    }

    private static C0413x b(C0413x c0413x, int i, int i2) throws Exception {
        int iD = c0413x.d() / i2;
        com.huawei.hms.scankit.aiscan.common.v vVar = new com.huawei.hms.scankit.aiscan.common.v(a(i2));
        int i3 = i / i2;
        int[] iArrA = a(c0413x, i2, i3);
        vVar.a(iArrA, i3 - iD);
        C0413x c0413x2 = new C0413x();
        c0413x2.a(0, i % i2);
        for (int i4 : iArrA) {
            c0413x2.a(i4, i2);
        }
        return c0413x2;
    }

    private static void a(C0417y c0417y, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            int i4 = i - i3;
            int i5 = i4;
            while (true) {
                int i6 = i + i3;
                if (i5 <= i6) {
                    c0417y.c(i5, i4);
                    c0417y.c(i5, i6);
                    c0417y.c(i4, i5);
                    c0417y.c(i6, i5);
                    i5++;
                }
            }
        }
        int i7 = i - i2;
        c0417y.c(i7, i7);
        int i8 = i7 + 1;
        c0417y.c(i8, i7);
        c0417y.c(i7, i8);
        int i9 = i + i2;
        c0417y.c(i9, i7);
        c0417y.c(i9, i8);
        c0417y.c(i9, i9 - 1);
    }

    public static C0413x a(boolean z, int i, int i2) throws Exception {
        C0413x c0413x = new C0413x();
        if (z) {
            c0413x.a(i - 1, 2);
            c0413x.a(i2 - 1, 6);
            return b(c0413x, 28, 4);
        }
        c0413x.a(i - 1, 5);
        c0413x.a(i2 - 1, 11);
        return b(c0413x, 40, 4);
    }

    private static void a(C0417y c0417y, boolean z, int i, C0413x c0413x) {
        int i2 = i / 2;
        int i3 = 0;
        if (z) {
            while (i3 < 7) {
                int i4 = (i2 - 3) + i3;
                if (c0413x.a(i3)) {
                    c0417y.c(i4, i2 - 5);
                }
                if (c0413x.a(i3 + 7)) {
                    c0417y.c(i2 + 5, i4);
                }
                if (c0413x.a(20 - i3)) {
                    c0417y.c(i4, i2 + 5);
                }
                if (c0413x.a(27 - i3)) {
                    c0417y.c(i2 - 5, i4);
                }
                i3++;
            }
            return;
        }
        while (i3 < 10) {
            int i5 = (i2 - 5) + i3 + (i3 / 5);
            if (c0413x.a(i3)) {
                c0417y.c(i5, i2 - 7);
            }
            if (c0413x.a(i3 + 10)) {
                c0417y.c(i2 + 7, i5);
            }
            if (c0413x.a(29 - i3)) {
                c0417y.c(i5, i2 + 7);
            }
            if (c0413x.a(39 - i3)) {
                c0417y.c(i2 - 7, i5);
            }
            i3++;
        }
    }

    private static int[] a(C0413x c0413x, int i, int i2) {
        int[] iArr = new int[i2];
        int iD = c0413x.d() / i;
        for (int i3 = 0; i3 < iD; i3++) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                i4 |= c0413x.a((i3 * i) + i5) ? 1 << ((i - i5) - 1) : 0;
            }
            iArr[i3] = i4;
        }
        return iArr;
    }

    private static com.huawei.hms.scankit.aiscan.common.h a(int i) throws Exception {
        if (i == 4) {
            return com.huawei.hms.scankit.aiscan.common.h.d;
        }
        if (i == 6) {
            return com.huawei.hms.scankit.aiscan.common.h.c;
        }
        if (i == 8) {
            return com.huawei.hms.scankit.aiscan.common.h.g;
        }
        if (i == 10) {
            return com.huawei.hms.scankit.aiscan.common.h.b;
        }
        if (i == 12) {
            return com.huawei.hms.scankit.aiscan.common.h.a;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Unsupported word size ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        } catch (Exception e) {
            throw e;
        }
    }

    public static C0413x a(C0413x c0413x, int i) throws Exception {
        C0413x c0413x2 = new C0413x();
        int iD = c0413x.d();
        int i2 = (1 << i) - 2;
        int i3 = 0;
        while (i3 < iD) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i3 + i5;
                if (i6 >= iD || c0413x.a(i6)) {
                    i4 |= 1 << ((i - 1) - i5);
                }
            }
            int i7 = i4 & i2;
            if (i7 == i2) {
                c0413x2.a(i7, i);
            } else if (i7 == 0) {
                c0413x2.a(i4 | 1, i);
            } else {
                c0413x2.a(i4, i);
                i3 += i;
            }
            i3--;
            i3 += i;
        }
        return c0413x2;
    }
}
