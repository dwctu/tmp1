package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;

/* compiled from: PDF417CodewordDecoder.java */
/* renamed from: com.huawei.hms.scankit.p.sa, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0394sa {
    private static final float[][] a = (float[][]) Array.newInstance((Class<?>) float.class, C0398ta.b.length, 8);

    static {
        int i;
        int i2 = 0;
        while (true) {
            int[] iArr = C0398ta.b;
            if (i2 >= iArr.length) {
                return;
            }
            int i3 = iArr[i2];
            int i4 = i3 & 1;
            int i5 = 0;
            while (i5 < 8) {
                float f = 0.0f;
                while (true) {
                    i = i3 & 1;
                    if (i == i4) {
                        f += 1.0f;
                        i3 >>= 1;
                    }
                }
                a[i2][(8 - i5) - 1] = f / 17.0f;
                i5++;
                i4 = i;
            }
            i2++;
        }
    }

    public static int a(int[] iArr) {
        int iD = d(e(iArr));
        return iD != -1 ? iD : c(iArr);
    }

    private static int b(int[] iArr) {
        long j = 0;
        for (int i = 0; i < iArr.length; i++) {
            for (int i2 = 0; i2 < iArr[i]; i2++) {
                int i3 = 1;
                long j2 = j << 1;
                if (i % 2 != 0) {
                    i3 = 0;
                }
                j = j2 | i3;
            }
        }
        return (int) j;
    }

    private static int c(int[] iArr) {
        int iA = com.huawei.hms.scankit.aiscan.common.n.a(iArr);
        float[] fArr = new float[8];
        if (iA > 1) {
            for (int i = 0; i < 8; i++) {
                fArr[i] = iArr[i] / iA;
            }
        }
        float f = Float.MAX_VALUE;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            float[][] fArr2 = a;
            if (i3 >= fArr2.length) {
                return i2;
            }
            float f2 = 0.0f;
            float[] fArr3 = fArr2[i3];
            for (int i4 = 0; i4 < 8; i4++) {
                float f3 = fArr3[i4] - fArr[i4];
                f2 += f3 * f3;
                if (f2 >= f) {
                    break;
                }
            }
            if (f2 < f) {
                i2 = C0398ta.b[i3];
                f = f2;
            }
            i3++;
        }
    }

    private static int d(int[] iArr) {
        int iB = b(iArr);
        if (C0398ta.a(iB) == -1) {
            return -1;
        }
        return iB;
    }

    private static int[] e(int[] iArr) {
        float fA = com.huawei.hms.scankit.aiscan.common.n.a(iArr);
        int[] iArr2 = new int[8];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 17; i3++) {
            if (iArr[i2] + i <= (fA / 34.0f) + ((i3 * fA) / 17.0f)) {
                i += iArr[i2];
                i2++;
            }
            iArr2[i2] = iArr2[i2] + 1;
        }
        return iArr2;
    }
}
