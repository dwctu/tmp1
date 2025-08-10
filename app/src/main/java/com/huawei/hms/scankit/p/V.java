package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0309a;
import com.huawei.hms.scankit.aiscan.common.EnumC0312d;
import java.util.Arrays;
import java.util.Map;

/* compiled from: ITFReader.java */
/* loaded from: classes3.dex */
public final class V extends Y {
    private static final int[] a = {6, 8, 10, 12, 14};
    private static final int[] b = {1, 1, 1, 1};
    private static final int[][] c = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};
    public static final int[][] d = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};
    private int e = -1;
    private int f = -1;

    private int[] b(C0413x c0413x) throws C0309a {
        int iC = c(c0413x);
        while (true) {
            int[] iArrC = c(c0413x, iC, b);
            this.e = (iArrC[1] - iArrC[0]) / 4;
            if (a(c0413x, iArrC[0])) {
                return iArrC;
            }
            iC = iArrC[2];
        }
    }

    private static int c(C0413x c0413x) throws C0309a {
        int iD = c0413x.d();
        int iB = c0413x.b(0);
        if (iB != iD) {
            return iB;
        }
        throw C0309a.a();
    }

    @Override // com.huawei.hms.scankit.p.Y
    public com.huawei.hms.scankit.aiscan.common.x a(int i, C0413x c0413x, Map<EnumC0312d, ?> map) throws C0309a {
        boolean z;
        int[] iArrB = b(c0413x);
        int[] iArrA = a(c0413x);
        StringBuilder sb = new StringBuilder(20);
        a(c0413x, iArrB[1], iArrA[0], sb);
        String string = sb.toString();
        int[] iArr = a;
        int length = string.length();
        int length2 = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length2) {
                z = false;
                break;
            }
            int i4 = iArr[i2];
            if (length == i4) {
                z = true;
                break;
            }
            if (i4 > i3) {
                i3 = i4;
            }
            i2++;
        }
        if (!z && length > i3) {
            z = true;
        }
        if (!z) {
            throw C0309a.a();
        }
        float f = i;
        return new com.huawei.hms.scankit.aiscan.common.x(string, null, new com.huawei.hms.scankit.aiscan.common.z[]{new com.huawei.hms.scankit.aiscan.common.z(iArrB[0], f), new com.huawei.hms.scankit.aiscan.common.z(iArrA[1], f)}, BarcodeFormat.ITF);
    }

    private int[] c(C0413x c0413x, int i, int[] iArr) throws C0309a {
        int i2;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int iD = c0413x.d();
        char c2 = 0;
        int i3 = i;
        int i4 = i3;
        boolean z = false;
        int i5 = 0;
        while (i3 < iD) {
            if (c0413x.a(i3) == z) {
                if (i5 == length - 1) {
                    Arrays.sort((int[]) iArr2.clone());
                    i2 = iD;
                    if (((r10[2] + r10[3]) * 0.5d) / ((r10[c2] + r10[1]) * 0.5d) < 4.0d && (r10[3] * 1.0d) / r10[0] <= 3.0d) {
                        int[] iArr3 = new int[10];
                        Y.a(c0413x, i3, iArr3);
                        this.f = -1;
                        for (int i6 = 0; i6 < 10; i6++) {
                            if (iArr3[i6] > this.f) {
                                this.f = iArr3[i6];
                            }
                        }
                        return new int[]{i4, i3, i4 + iArr2[0] + iArr2[1]};
                    }
                    i4 += iArr2[0] + iArr2[1];
                    int i7 = i5 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i7);
                    iArr2[i7] = 0;
                    iArr2[i5] = 0;
                    i5--;
                } else {
                    i2 = iD;
                    i5++;
                }
                iArr2[i5] = 1;
                z = !z;
            } else if (i5 >= 0 && i5 < length) {
                iArr2[i5] = iArr2[i5] + 1;
                i2 = iD;
            } else {
                throw C0309a.a();
            }
            i3++;
            iD = i2;
            c2 = 0;
        }
        throw C0309a.a();
    }

    private int[] b(C0413x c0413x, int i, int[] iArr) throws C0309a {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int iD = c0413x.d();
        int i2 = i;
        int i3 = i2;
        boolean z = false;
        int i4 = 0;
        while (i2 < iD) {
            if (c0413x.a(i2) == z) {
                if (i4 != length - 1) {
                    i4++;
                } else if (Math.min(iArr2[0], iArr2[1]) != 0 && Math.max(iArr2[0], iArr2[1]) != 0) {
                    float f = (iArr2[2] * 2.0f) / (iArr2[0] + iArr2[1]);
                    if (Math.max(iArr2[0], iArr2[1]) / Math.min(iArr2[0], iArr2[1]) <= 3.0f && ((double) f) > 1.5d && f < 4.0f) {
                        return new int[]{i3, i2, i3 + iArr2[0] + iArr2[1]};
                    }
                    i3 += iArr2[0] + iArr2[1];
                    int i5 = i4 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i4] = 0;
                    i4--;
                } else {
                    throw C0309a.a();
                }
                iArr2[i4] = 1;
                z = !z;
            } else if (i4 >= 0 && i4 < length) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                throw C0309a.a();
            }
            i2++;
        }
        throw C0309a.a();
    }

    private static void a(C0413x c0413x, int i, int i2, StringBuilder sb) throws C0309a {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i < i2) {
            Y.a(c0413x, i, iArr);
            int i3 = -1;
            int i4 = 10000;
            for (int i5 = 0; i5 < 10; i5++) {
                if (i3 <= iArr[i5]) {
                    i3 = iArr[i5];
                }
                if (i4 >= iArr[i5]) {
                    i4 = iArr[i5];
                }
            }
            if (i3 / i4 <= 8) {
                for (int i6 = 0; i6 < 5; i6++) {
                    int i7 = i6 * 2;
                    iArr2[i6] = iArr[i7];
                    iArr3[i6] = iArr[i7 + 1];
                }
                sb.append((char) (b(iArr2) + 48));
                sb.append((char) (b(iArr3) + 48));
                for (int i8 = 0; i8 < 10; i8++) {
                    i += iArr[i8];
                }
            } else {
                throw C0309a.a();
            }
        }
        if (i != i2) {
            throw C0309a.a();
        }
    }

    private static int b(int[] iArr) throws C0309a {
        int length = d.length;
        float f = 0.3f;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            float fA = Y.a(iArr, d[i2], 0.75f);
            if (fA < f) {
                i = i2;
                f = fA;
            } else if (Math.abs(fA - f) < 1.0E-7d) {
                i = -1;
            }
        }
        if (i >= 0) {
            return i % 10;
        }
        throw C0309a.a();
    }

    private boolean a(C0413x c0413x, int i) {
        int i2 = this.e * 10;
        int i3 = (int) (this.f * 1.5d);
        if (i2 < i3) {
            i2 = i3;
        }
        for (int i4 = i - 1; i2 > 0 && i4 >= 0 && !c0413x.a(i4); i4--) {
            i2--;
        }
        return i2 == 0;
    }

    private int[] a(C0413x c0413x) throws C0309a {
        try {
            c0413x.g();
            int iC = c(c0413x);
            while (true) {
                int[] iArrB = b(c0413x, iC, c[0]);
                if (a(c0413x, iArrB[0])) {
                    int i = iArrB[0];
                    iArrB[0] = c0413x.d() - iArrB[1];
                    iArrB[1] = c0413x.d() - i;
                    return iArrB;
                }
                iC = iArrB[2];
            }
        } finally {
            c0413x.g();
        }
    }
}
