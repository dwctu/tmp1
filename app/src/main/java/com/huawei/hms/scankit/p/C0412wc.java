package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0309a;
import java.util.Map;

/* compiled from: UPCEWriter.java */
/* renamed from: com.huawei.hms.scankit.p.wc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0412wc extends AbstractC0408vc {
    @Override // com.huawei.hms.scankit.p.AbstractC0400tc, com.huawei.hms.scankit.p.Pb
    public C0417y a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<Jc, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.UPC_E) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode UPC_E, but got " + barcodeFormat);
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0400tc
    public boolean[] a(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + AbstractC0335da.b(C0339ea.b(str));
            } catch (C0309a e) {
                throw new IllegalArgumentException(e);
            }
        } else if (length == 8) {
            try {
                if (!AbstractC0335da.a((CharSequence) str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (C0309a unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + length);
        }
        int iDigit = Character.digit(str.charAt(0), 10);
        if (iDigit != 0 && iDigit != 1) {
            throw new IllegalArgumentException("Number system must be 0 or 1");
        }
        int i = C0339ea.i[iDigit][Character.digit(str.charAt(7), 10)];
        boolean[] zArr = new boolean[51];
        int iA = AbstractC0400tc.a(zArr, 0, AbstractC0335da.a, true) + 0;
        for (int i2 = 1; i2 <= 6; i2++) {
            int iDigit2 = Character.digit(str.charAt(i2), 10);
            if (((i >> (6 - i2)) & 1) == 1) {
                iDigit2 += 10;
            }
            iA += AbstractC0400tc.a(zArr, iA, AbstractC0335da.e[iDigit2], false);
        }
        AbstractC0400tc.a(zArr, iA, AbstractC0335da.c, false);
        return zArr;
    }
}
