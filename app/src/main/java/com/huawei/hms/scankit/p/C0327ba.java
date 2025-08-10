package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0309a;

/* compiled from: UPCEANExtension5Support.java */
/* renamed from: com.huawei.hms.scankit.p.ba, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0327ba {
    private static final int[] a = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};
    private final int[] b = new int[4];
    private final StringBuilder c = new StringBuilder();

    public com.huawei.hms.scankit.aiscan.common.x a(int i, C0413x c0413x, int[] iArr) throws C0309a {
        StringBuilder sb = this.c;
        sb.setLength(0);
        float f = i;
        return new com.huawei.hms.scankit.aiscan.common.x(sb.toString(), null, new com.huawei.hms.scankit.aiscan.common.z[]{new com.huawei.hms.scankit.aiscan.common.z((iArr[0] + iArr[1]) / 2.0f, f), new com.huawei.hms.scankit.aiscan.common.z(a(c0413x, iArr, sb), f)}, BarcodeFormat.UPC_EAN_EXTENSION);
    }

    private int a(C0413x c0413x, int[] iArr, StringBuilder sb) throws C0309a {
        int[] iArr2 = this.b;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iD = c0413x.d();
        int iC = iArr[1];
        int i = 0;
        for (int i2 = 0; i2 < 5 && iC < iD; i2++) {
            int iA = AbstractC0335da.a(c0413x, iArr2, iC, AbstractC0335da.e);
            sb.append((char) ((iA % 10) + 48));
            for (int i3 : iArr2) {
                iC += i3;
            }
            if (iA >= 10) {
                i |= 1 << (4 - i2);
            }
            if (i2 != 4) {
                iC = c0413x.c(c0413x.b(iC));
            }
        }
        if (sb.length() == 5) {
            if (a(sb.toString()) == a(i)) {
                return iC;
            }
            throw C0309a.a();
        }
        throw C0309a.a();
    }

    private static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int iCharAt = 0;
        for (int i = length - 2; i >= 0; i -= 2) {
            iCharAt += charSequence.charAt(i) - '0';
        }
        int iCharAt2 = iCharAt * 3;
        for (int i2 = length - 1; i2 >= 0; i2 -= 2) {
            iCharAt2 += charSequence.charAt(i2) - '0';
        }
        return (iCharAt2 * 3) % 10;
    }

    private static int a(int i) throws C0309a {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == a[i2]) {
                return i2;
            }
        }
        throw C0309a.a();
    }
}
