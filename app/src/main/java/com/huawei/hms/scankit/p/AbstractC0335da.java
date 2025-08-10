package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0309a;
import com.huawei.hms.scankit.aiscan.common.EnumC0312d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* compiled from: UPCEANReader.java */
/* renamed from: com.huawei.hms.scankit.p.da, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0335da extends Y {
    public static final int[] a = {1, 1, 1};
    public static final int[] b = {1, 1, 1, 1, 1};
    public static final int[] c = {1, 1, 1, 1, 1, 1};
    public static final int[][] d;
    public static final int[][] e;
    private final StringBuilder f = new StringBuilder(20);
    private final C0331ca g = new C0331ca();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        d = iArr;
        int[][] iArr2 = new int[20][];
        e = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr3 = d[i - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i2 = 0; i2 < iArr3.length; i2++) {
                iArr4[i2] = iArr3[(iArr3.length - i2) - 1];
            }
            e[i] = iArr4;
        }
    }

    public static int[] a(C0413x c0413x) throws C0309a {
        return b(c0413x, 0);
    }

    public static ArrayList<int[]> b(C0413x c0413x) throws C0309a {
        int iD = c0413x.d() / 2;
        ArrayList<int[]> arrayList = new ArrayList<>();
        int i = 0;
        while (i < iD) {
            try {
                int[] iArrB = b(c0413x, i);
                arrayList.add(iArrB);
                i = iArrB[0] + 1;
            } catch (C0309a unused) {
            }
        }
        if (arrayList.size() != 0) {
            return arrayList;
        }
        throw C0309a.a();
    }

    public abstract int a(C0413x c0413x, int[] iArr, StringBuilder sb) throws C0309a;

    public abstract BarcodeFormat a();

    public abstract boolean a(int i, int i2, C0413x c0413x);

    public abstract boolean a(int[] iArr, int[] iArr2) throws C0309a;

    @Override // com.huawei.hms.scankit.p.Y
    public com.huawei.hms.scankit.aiscan.common.x a(int i, C0413x c0413x, Map<EnumC0312d, ?> map) throws C0309a {
        return a(i, c0413x, a(c0413x), map);
    }

    public com.huawei.hms.scankit.aiscan.common.x a(int i, C0413x c0413x, int[] iArr, Map<EnumC0312d, ?> map) throws C0309a {
        com.huawei.hms.scankit.aiscan.common.A a2 = map == null ? null : (com.huawei.hms.scankit.aiscan.common.A) map.get(EnumC0312d.NEED_RESULT_POINT_CALLBACK);
        if (a2 != null) {
            a2.a(new com.huawei.hms.scankit.aiscan.common.z((iArr[0] + iArr[1]) / 2.0f, i));
        }
        StringBuilder sb = this.f;
        sb.setLength(0);
        int iA = a(c0413x, iArr, sb);
        if (a2 != null) {
            a2.a(new com.huawei.hms.scankit.aiscan.common.z(iA, i));
        }
        int[] iArrA = a(c0413x, iA);
        if (iArrA[0] - iA <= 1) {
            if (a2 != null) {
                a2.a(new com.huawei.hms.scankit.aiscan.common.z((iArrA[0] + iArrA[1]) / 2.0f, i));
            }
            if (a(iArr, iArrA)) {
                int i2 = iArrA[1];
                if ((i2 - iArrA[0]) + i2 < c0413x.d() && a(iArrA[0], i2, c0413x)) {
                    String string = sb.toString();
                    if (string.length() >= 8) {
                        if (a(string)) {
                            float f = i;
                            com.huawei.hms.scankit.aiscan.common.x xVar = new com.huawei.hms.scankit.aiscan.common.x(string, null, new com.huawei.hms.scankit.aiscan.common.z[]{new com.huawei.hms.scankit.aiscan.common.z(iArr[0], f), new com.huawei.hms.scankit.aiscan.common.z(iArrA[1], f)}, a());
                            a(xVar, iArrA, i, c0413x, map);
                            return xVar;
                        }
                        throw C0309a.a();
                    }
                    throw C0309a.a();
                }
                throw C0309a.a();
            }
            throw C0309a.a();
        }
        throw C0309a.a();
    }

    public static int[] b(C0413x c0413x, int i) throws C0309a {
        int[] iArr = new int[a.length];
        int[] iArrA = null;
        boolean zA = false;
        while (!zA) {
            int[] iArr2 = a;
            Arrays.fill(iArr, 0, iArr2.length, 0);
            iArrA = a(c0413x, i, false, iArr2, iArr);
            int i2 = iArrA[0];
            int i3 = iArrA[1];
            int i4 = i2 - (i3 - i2);
            int i5 = i4 + 3;
            while (i4 <= i5 && (i4 < 0 || !(zA = c0413x.a(i4, i2, false, true)))) {
                i4++;
            }
            i = i3;
        }
        return iArrA;
    }

    public static int b(CharSequence charSequence) throws C0309a {
        int length = charSequence.length();
        int i = 0;
        for (int i2 = length - 1; i2 >= 0; i2 -= 2) {
            int iCharAt = charSequence.charAt(i2) - '0';
            if (iCharAt < 0 || iCharAt > 9) {
                throw C0309a.a();
            }
            i += iCharAt;
        }
        int i3 = i * 3;
        for (int i4 = length - 2; i4 >= 0; i4 -= 2) {
            int iCharAt2 = charSequence.charAt(i4) - '0';
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                throw C0309a.a();
            }
            i3 += iCharAt2;
        }
        return (1000 - i3) % 10;
    }

    private void a(com.huawei.hms.scankit.aiscan.common.x xVar, int[] iArr, int i, C0413x c0413x, Map<EnumC0312d, ?> map) throws C0309a {
        int length;
        boolean z = true;
        try {
            com.huawei.hms.scankit.aiscan.common.x xVarA = this.g.a(i, c0413x, iArr[1]);
            xVar.a(xVarA.h());
            length = xVarA.i().length();
        } catch (C0309a unused) {
            length = 0;
        }
        int[] iArr2 = map == null ? null : (int[]) map.get(EnumC0312d.ALLOWED_EAN_EXTENSIONS);
        if (iArr2 != null) {
            int length2 = iArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    z = false;
                    break;
                } else if (length == iArr2[i2]) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                throw C0309a.a();
            }
        }
    }

    public boolean a(String str) throws C0309a {
        return a((CharSequence) str);
    }

    public static boolean a(CharSequence charSequence) throws C0309a {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i = length - 1;
        return b(charSequence.subSequence(0, i)) == Character.digit(charSequence.charAt(i), 10);
    }

    public int[] a(C0413x c0413x, int i) throws C0309a {
        return a(c0413x, i, false, a);
    }

    public static int[] a(C0413x c0413x, int i, boolean z, int[] iArr) throws C0309a {
        return a(c0413x, i, z, iArr, new int[iArr.length]);
    }

    private static int[] a(C0413x c0413x, int i, boolean z, int[] iArr, int[] iArr2) throws C0309a {
        int iD = c0413x.d();
        int iC = z ? c0413x.c(i) : c0413x.b(i);
        int length = iArr.length;
        boolean z2 = z;
        int i2 = 0;
        int i3 = iC;
        while (iC < iD) {
            if (c0413x.a(iC) != z2) {
                if (i2 >= 0 && i2 < iArr2.length) {
                    iArr2[i2] = iArr2[i2] + 1;
                } else {
                    throw C0309a.a();
                }
            } else {
                if (i2 != length - 1) {
                    i2++;
                } else {
                    if (Y.a(iArr2, iArr, 0.8f) < 0.46f) {
                        return new int[]{i3, iC};
                    }
                    i3 += iArr2[0] + iArr2[1];
                    int i4 = i2 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i4);
                    iArr2[i4] = 0;
                    iArr2[i2] = 0;
                    i2--;
                }
                iArr2[i2] = 1;
                z2 = !z2;
            }
            iC++;
        }
        throw C0309a.a();
    }

    public static int a(C0413x c0413x, int[] iArr, int i, int[][] iArr2) throws C0309a {
        Y.a(c0413x, i, iArr);
        int length = iArr2.length;
        float f = 0.46f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float fA = Y.a(iArr, iArr2[i3], 0.8f);
            if (fA < f) {
                i2 = i3;
                f = fA;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw C0309a.a();
    }
}
