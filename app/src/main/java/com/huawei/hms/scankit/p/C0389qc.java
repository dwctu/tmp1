package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0309a;
import java.util.Map;

/* compiled from: EAN13Writer.java */
/* renamed from: com.huawei.hms.scankit.p.qc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0389qc extends AbstractC0408vc {
    @Override // com.huawei.hms.scankit.p.AbstractC0400tc, com.huawei.hms.scankit.p.Pb
    public C0417y a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<Jc, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_13) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got " + barcodeFormat);
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0400tc
    public boolean[] a(String str) {
        int length = str.length();
        if (length == 12) {
            try {
                str = str + AbstractC0335da.b(str);
            } catch (C0309a e) {
                throw new IllegalArgumentException(e);
            }
        } else if (length == 13) {
            try {
                if (!AbstractC0335da.a((CharSequence) str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (C0309a unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got " + length);
        }
        int i = T.h[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int iA = AbstractC0400tc.a(zArr, 0, AbstractC0335da.a, true) + 0;
        for (int i2 = 1; i2 <= 6; i2++) {
            int iDigit = Character.digit(str.charAt(i2), 10);
            if (((i >> (6 - i2)) & 1) == 1) {
                iDigit += 10;
            }
            iA += AbstractC0400tc.a(zArr, iA, AbstractC0335da.e[iDigit], false);
        }
        int iA2 = iA + AbstractC0400tc.a(zArr, iA, AbstractC0335da.b, false);
        for (int i3 = 7; i3 <= 12; i3++) {
            iA2 += AbstractC0400tc.a(zArr, iA2, AbstractC0335da.d[Character.digit(str.charAt(i3), 10)], true);
        }
        AbstractC0400tc.a(zArr, iA2, AbstractC0335da.a, true);
        return zArr;
    }
}
