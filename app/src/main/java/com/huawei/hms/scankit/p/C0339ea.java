package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0309a;

/* compiled from: UPCEReader.java */
/* renamed from: com.huawei.hms.scankit.p.ea, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0339ea extends AbstractC0335da {
    private static final int[] h = {1, 1, 1, 1, 1, 1};
    public static final int[][] i = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};
    private final int[] j = new int[4];

    private int b(C0413x c0413x, int[] iArr, int i2, int[][] iArr2) throws C0309a {
        Y.a(c0413x, i2, iArr);
        int length = iArr2.length;
        float f = 0.45f;
        int i3 = -1;
        for (int i4 = 0; i4 < length; i4++) {
            float fA = Y.a(iArr, iArr2[i4], 0.7f);
            if (fA < f) {
                i3 = i4;
                f = fA;
            }
        }
        if (i3 >= 0) {
            return i3;
        }
        throw C0309a.a();
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0335da
    public boolean a(int i2, int i3, C0413x c0413x) {
        return c0413x.a(i3, (i3 - i2) + i3, false, true);
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0335da
    public int a(C0413x c0413x, int[] iArr, StringBuilder sb) throws C0309a {
        int[] iArr2 = this.j;
        int i2 = 0;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iD = c0413x.d();
        int i3 = iArr[1];
        float f = 10000.0f;
        int i4 = 0;
        int i5 = 0;
        float f2 = 0.0f;
        while (i4 < 6 && i3 < iD) {
            int iB = b(c0413x, iArr2, i3, AbstractC0335da.e);
            sb.append((char) ((iB % 10) + 48));
            int i6 = 0;
            float f3 = 0.0f;
            while (true) {
                if (i6 >= AbstractC0335da.e[iB].length) {
                    break;
                }
                f3 += r17[iB][i6];
                i6++;
            }
            float f4 = (((iArr2[i2] + iArr2[1]) + iArr2[2]) + iArr2[3]) / f3;
            if (f4 > f2) {
                f2 = f4;
            }
            if (f4 < f) {
                f = f4;
            }
            int length = iArr2.length;
            while (i2 < length) {
                i3 += iArr2[i2];
                i2++;
            }
            if (iB >= 10) {
                i5 |= 1 << (5 - i4);
            }
            i4++;
            i2 = 0;
        }
        if (f2 / f > 2.89d) {
            throw C0309a.a();
        }
        a(sb, i5);
        return i3;
    }

    public static String b(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb = new StringBuilder(12);
        sb.append(str.charAt(0));
        char c = cArr[5];
        switch (c) {
            case '0':
            case '1':
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case '3':
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case '4':
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c);
                break;
        }
        if (str.length() >= 8) {
            sb.append(str.charAt(7));
        }
        return sb.toString();
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0335da
    public int[] a(C0413x c0413x, int i2) throws C0309a {
        return AbstractC0335da.a(c0413x, i2, true, h);
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0335da
    public boolean a(String str) throws C0309a {
        return super.a(b(str));
    }

    private static void a(StringBuilder sb, int i2) throws C0309a {
        for (int i3 = 0; i3 <= 1; i3++) {
            for (int i4 = 0; i4 < 10; i4++) {
                if (i2 == i[i3][i4]) {
                    sb.insert(0, (char) (i3 + 48));
                    sb.append((char) (i4 + 48));
                    return;
                }
            }
        }
        throw C0309a.a();
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0335da
    public BarcodeFormat a() {
        return BarcodeFormat.UPC_E;
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0335da
    public boolean a(int[] iArr, int[] iArr2) throws C0309a {
        return ((double) Math.abs(((int) Math.round(((double) (iArr2[1] - iArr[0])) / (((double) ((iArr2[1] - iArr2[0]) + (iArr[1] - iArr[0]))) / 9.0d))) + (-51))) <= 10.200000000000001d && Math.abs(1.0d - ((((double) (iArr[1] - iArr[0])) / 3.0d) / (((double) (iArr2[1] - iArr2[0])) / 6.0d))) < 0.2d;
    }
}
