package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: Code39Writer.java */
/* renamed from: com.huawei.hms.scankit.p.oc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0381oc extends AbstractC0400tc {
    @Override // com.huawei.hms.scankit.p.AbstractC0400tc, com.huawei.hms.scankit.p.Pb
    public C0417y a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<Jc, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_39) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got " + barcodeFormat);
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0400tc
    public boolean[] a(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            int i = length + 25;
            for (int i2 = 0; i2 < length; i2++) {
                int iIndexOf = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i2));
                if (iIndexOf >= 0) {
                    a(Q.a[iIndexOf], iArr);
                    for (int i3 = 0; i3 < 9; i3++) {
                        i += iArr[i3];
                    }
                } else {
                    throw new IllegalArgumentException("Bad contents: error contents");
                }
            }
            boolean[] zArr = new boolean[i];
            a(148, iArr);
            int iA = AbstractC0400tc.a(zArr, 0, iArr, true);
            int[] iArr2 = {1};
            int iA2 = iA + AbstractC0400tc.a(zArr, iA, iArr2, false);
            for (int i4 = 0; i4 < length; i4++) {
                a(Q.a["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i4))], iArr);
                int iA3 = iA2 + AbstractC0400tc.a(zArr, iA2, iArr, true);
                iA2 = iA3 + AbstractC0400tc.a(zArr, iA3, iArr2, false);
            }
            a(148, iArr);
            AbstractC0400tc.a(zArr, iA2, iArr, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
    }

    private static void a(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) != 0) {
                i3 = 2;
            }
            iArr[i2] = i3;
        }
    }
}
