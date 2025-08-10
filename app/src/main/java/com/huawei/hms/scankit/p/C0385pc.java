package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: Code93Writer.java */
/* renamed from: com.huawei.hms.scankit.p.pc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0385pc extends AbstractC0400tc {
    @Override // com.huawei.hms.scankit.p.AbstractC0400tc, com.huawei.hms.scankit.p.Pb
    public C0417y a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<Jc, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_93) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_93, but got " + barcodeFormat);
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0400tc
    public boolean[] a(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            int length2 = ((str.length() + 2 + 2) * 9) + 1;
            a(S.b[47], iArr);
            boolean[] zArr = new boolean[length2];
            int iA = a(zArr, 0, iArr);
            for (int i = 0; i < length; i++) {
                int iIndexOf = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i));
                if (iIndexOf >= 0) {
                    a(S.b[iIndexOf], iArr);
                    iA += a(zArr, iA, iArr);
                } else {
                    throw new IllegalArgumentException("Bad contents: please check contents");
                }
            }
            int iA2 = a(str, 20);
            int[] iArr2 = S.b;
            a(iArr2[iA2], iArr);
            int iA3 = iA + a(zArr, iA, iArr);
            a(iArr2[a(str + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(iA2), 15)], iArr);
            int iA4 = iA3 + a(zArr, iA3, iArr);
            a(iArr2[47], iArr);
            zArr[iA4 + a(zArr, iA4, iArr)] = true;
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
    }

    private static void a(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) == 0) {
                i3 = 0;
            }
            iArr[i2] = i3;
        }
    }

    private static int a(boolean[] zArr, int i, int[] iArr) {
        int length = iArr.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i + 1;
            zArr[i] = iArr[i2] != 0;
            i2++;
            i = i3;
        }
        return 9;
    }

    private static int a(String str, int i) {
        int iIndexOf = 0;
        int i2 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i2;
            i2++;
            if (i2 > i) {
                i2 = 1;
            }
        }
        return iIndexOf % 47;
    }
}
