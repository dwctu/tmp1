package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0309a;

/* compiled from: EAN8Reader.java */
/* loaded from: classes3.dex */
public final class U extends AbstractC0335da {
    private final int[] h = new int[4];

    private int b(C0413x c0413x, int[] iArr, int i, int[][] iArr2) throws C0309a {
        Y.a(c0413x, i, iArr);
        int length = iArr2.length;
        float f = 0.43f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float fA = Y.a(iArr, iArr2[i3], 0.7f);
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

    @Override // com.huawei.hms.scankit.p.AbstractC0335da
    public boolean a(int i, int i2, C0413x c0413x) {
        return c0413x.a(i2, ((int) ((i2 - i) * 1.5d)) + i2, false, true);
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0335da
    public int a(C0413x c0413x, int[] iArr, StringBuilder sb) throws C0309a {
        int[] iArr2 = this.h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iD = c0413x.d();
        int i = iArr[1];
        for (int i2 = 0; i2 < 4 && i < iD; i2++) {
            sb.append((char) (b(c0413x, iArr2, i, AbstractC0335da.d) + 48));
            for (int i3 : iArr2) {
                i += i3;
            }
        }
        int i4 = AbstractC0335da.a(c0413x, i, true, AbstractC0335da.b)[1];
        for (int i5 = 0; i5 < 4 && i4 < iD; i5++) {
            sb.append((char) (b(c0413x, iArr2, i4, AbstractC0335da.d) + 48));
            for (int i6 : iArr2) {
                i4 += i6;
            }
        }
        return i4;
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0335da
    public BarcodeFormat a() {
        return BarcodeFormat.EAN_8;
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0335da
    public boolean a(int[] iArr, int[] iArr2) throws C0309a {
        return ((double) Math.abs(((int) Math.round(((double) (iArr2[1] - iArr[0])) / (((double) ((iArr2[1] - iArr2[0]) + (iArr[1] - iArr[0]))) / 6.0d))) + (-67))) <= 6.7d && Math.abs(1.0d - ((((double) (iArr[1] - iArr[0])) / 3.0d) / (((double) (iArr2[1] - iArr2[0])) / 3.0d))) < 0.2d;
    }
}
