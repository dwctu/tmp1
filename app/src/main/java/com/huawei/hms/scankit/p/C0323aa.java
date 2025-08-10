package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0309a;

/* compiled from: UPCEANExtension2Support.java */
/* renamed from: com.huawei.hms.scankit.p.aa, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0323aa {
    private final int[] a = new int[4];
    private final StringBuilder b = new StringBuilder();

    public com.huawei.hms.scankit.aiscan.common.x a(int i, C0413x c0413x, int[] iArr) throws C0309a {
        StringBuilder sb = this.b;
        sb.setLength(0);
        float f = i;
        return new com.huawei.hms.scankit.aiscan.common.x(sb.toString(), null, new com.huawei.hms.scankit.aiscan.common.z[]{new com.huawei.hms.scankit.aiscan.common.z((iArr[0] + iArr[1]) / 2.0f, f), new com.huawei.hms.scankit.aiscan.common.z(a(c0413x, iArr, sb), f)}, BarcodeFormat.UPC_EAN_EXTENSION);
    }

    private int a(C0413x c0413x, int[] iArr, StringBuilder sb) throws C0309a {
        int[] iArr2 = this.a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iD = c0413x.d();
        int iC = iArr[1];
        int i = 0;
        for (int i2 = 0; i2 < 2 && iC < iD; i2++) {
            int iA = AbstractC0335da.a(c0413x, iArr2, iC, AbstractC0335da.e);
            sb.append((char) ((iA % 10) + 48));
            for (int i3 : iArr2) {
                iC += i3;
            }
            if (iA >= 10) {
                i |= 1 << (1 - i2);
            }
            if (i2 != 1) {
                iC = c0413x.c(c0413x.b(iC));
            }
        }
        if (sb.length() == 2) {
            try {
                if (Integer.parseInt(sb.toString()) % 4 == i) {
                    return iC;
                }
                throw C0309a.a();
            } catch (NumberFormatException unused) {
                throw C0309a.a();
            }
        }
        throw C0309a.a();
    }
}
