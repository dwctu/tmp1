package com.huawei.hms.scankit.p;

import com.broadcom.bt.util.io.IOUtils;
import com.huawei.hms.hmsscankit.WriterException;
import org.bouncycastle.crypto.tls.CipherSuite;

/* compiled from: MatrixUtil.java */
/* loaded from: classes3.dex */
public final class Nc {
    private static final int[][] a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA, -1}, new int[]{6, 30, 54, 78, 102, 126, CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};
    private static final int[][] d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    public static void a(Ic ic) {
        ic.a((byte) -1);
    }

    public static void b(Ya ya, Ic ic) throws Exception {
        if (ya.e() < 7) {
            return;
        }
        C0413x c0413x = new C0413x();
        a(ya, c0413x);
        int i = 17;
        for (int i2 = 0; i2 < 6; i2++) {
            for (int i3 = 0; i3 < 3; i3++) {
                boolean zA = c0413x.a(i);
                i--;
                ic.a(i2, (ic.b() - 11) + i3, zA);
                ic.a((ic.b() - 11) + i3, i2, zA);
            }
        }
    }

    private static boolean b(int i) {
        return i == -1;
    }

    private static void c(int i, int i2, Ic ic) {
        for (int i3 = 0; i3 < 7; i3++) {
            int[] iArr = a[i3];
            for (int i4 = 0; i4 < 7; i4++) {
                ic.a(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    private static void d(Ic ic) {
        int i = 8;
        while (i < ic.c() - 8) {
            int i2 = i + 1;
            int i3 = i2 % 2;
            if (b(ic.a(i, 6))) {
                ic.a(i, 6, i3);
            }
            if (b(ic.a(6, i))) {
                ic.a(6, i, i3);
            }
            i = i2;
        }
    }

    public static void a(C0413x c0413x, Pa pa, Ya ya, int i, Ic ic) throws Exception {
        a(ic);
        a(ya, ic);
        a(pa, i, ic);
        b(ya, ic);
        a(c0413x, i, ic);
    }

    private static void c(Ic ic) throws WriterException {
        int length = a[0].length;
        c(0, 0, ic);
        c(ic.c() - length, 0, ic);
        c(0, ic.c() - length, ic);
        a(0, 7, ic);
        a(ic.c() - 8, 7, ic);
        a(0, ic.c() - 8, ic);
        d(7, 0, ic);
        d((ic.b() - 7) - 1, 0, ic);
        d(7, ic.b() - 7, ic);
    }

    public static void a(Ya ya, Ic ic) throws WriterException {
        c(ic);
        b(ic);
        c(ya, ic);
        d(ic);
    }

    private static void b(Ic ic) throws WriterException {
        if (ic.a(8, ic.b() - 8) != 0) {
            ic.a(8, ic.b() - 8, 1);
            return;
        }
        throw new WriterException();
    }

    private static void d(int i, int i2, Ic ic) throws WriterException {
        for (int i3 = 0; i3 < 7; i3++) {
            int i4 = i2 + i3;
            if (b(ic.a(i, i4))) {
                ic.a(i, i4, 0);
            } else {
                throw new WriterException();
            }
        }
    }

    private static void b(int i, int i2, Ic ic) {
        for (int i3 = 0; i3 < 5; i3++) {
            int[] iArr = b[i3];
            for (int i4 = 0; i4 < 5; i4++) {
                ic.a(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    public static void a(Pa pa, int i, Ic ic) throws Exception {
        C0413x c0413x = new C0413x();
        a(pa, i, c0413x);
        for (int i2 = 0; i2 < c0413x.d(); i2++) {
            boolean zA = c0413x.a((c0413x.d() - 1) - i2);
            int[] iArr = d[i2];
            ic.a(iArr[0], iArr[1], zA);
            if (i2 < 8) {
                ic.a((ic.c() - i2) - 1, 8, zA);
            } else {
                ic.a(8, (ic.b() - 7) + (i2 - 8), zA);
            }
        }
    }

    private static void c(Ya ya, Ic ic) {
        if (ya.e() < 2) {
            return;
        }
        int iE = ya.e() - 1;
        int[][] iArr = c;
        if (iE < iArr.length) {
            int[] iArr2 = iArr[iE];
            for (int i : iArr2) {
                if (i >= 0) {
                    for (int i2 : iArr2) {
                        if (i2 >= 0 && b(ic.a(i2, i))) {
                            b(i2 - 2, i - 2, ic);
                        }
                    }
                }
            }
        }
    }

    public static void a(C0413x c0413x, int i, Ic ic) throws WriterException {
        boolean zA;
        int iC = ic.c() - 1;
        int iB = ic.b() - 1;
        int i2 = 0;
        int i3 = -1;
        while (iC > 0) {
            if (iC == 6) {
                iC--;
            }
            while (iB >= 0 && iB < ic.b()) {
                for (int i4 = 0; i4 < 2; i4++) {
                    int i5 = iC - i4;
                    if (b(ic.a(i5, iB))) {
                        if (i2 < c0413x.d()) {
                            zA = c0413x.a(i2);
                            i2++;
                        } else {
                            zA = false;
                        }
                        if (i != -1 && Mc.a(i, i5, iB)) {
                            zA = !zA;
                        }
                        ic.a(i5, iB, zA);
                    }
                }
                iB += i3;
            }
            i3 = -i3;
            iB += i3;
            iC -= 2;
        }
        if (i2 == c0413x.d()) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i2 + IOUtils.DIR_SEPARATOR_UNIX + c0413x.d());
    }

    public static int a(int i) {
        return 32 - Integer.numberOfLeadingZeros(i);
    }

    public static int a(int i, int i2) throws Exception {
        if (i2 != 0) {
            int iA = a(i2);
            int iA2 = i << (iA - 1);
            while (a(iA2) >= iA) {
                iA2 ^= i2 << (a(iA2) - iA);
            }
            return iA2;
        }
        try {
            throw new IllegalArgumentException("0 polynomial");
        } catch (Exception e) {
            throw e;
        }
    }

    public static void a(Pa pa, int i, C0413x c0413x) throws Exception {
        if (Oc.a(i)) {
            int iA = (pa.a() << 3) | i;
            c0413x.a(iA, 5);
            c0413x.a(a(iA, 1335), 10);
            C0413x c0413x2 = new C0413x();
            c0413x2.a(21522, 15);
            c0413x.b(c0413x2);
            if (c0413x.d() == 15) {
                return;
            }
            throw new WriterException("should not happen but we got: " + c0413x.d());
        }
        throw new WriterException("Invalid mask pattern");
    }

    public static void a(Ya ya, C0413x c0413x) throws Exception {
        c0413x.a(ya.e(), 6);
        c0413x.a(a(ya.e(), 7973), 12);
        if (c0413x.d() == 18) {
            return;
        }
        throw new WriterException("should not happen but we got: " + c0413x.d());
    }

    private static void a(int i, int i2, Ic ic) throws WriterException {
        for (int i3 = 0; i3 < 8; i3++) {
            int i4 = i + i3;
            if (b(ic.a(i4, i2))) {
                ic.a(i4, i2, 0);
            } else {
                throw new WriterException();
            }
        }
    }
}
