package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0309a;
import java.util.Map;

/* compiled from: EAN8Writer.java */
/* renamed from: com.huawei.hms.scankit.p.rc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0392rc extends AbstractC0408vc {
    @Override // com.huawei.hms.scankit.p.AbstractC0400tc, com.huawei.hms.scankit.p.Pb
    public C0417y a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<Jc, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_8) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got " + barcodeFormat);
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0400tc
    public boolean[] a(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + AbstractC0335da.b(str);
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
        boolean[] zArr = new boolean[67];
        int iA = AbstractC0400tc.a(zArr, 0, AbstractC0335da.a, true) + 0;
        for (int i = 0; i <= 3; i++) {
            iA += AbstractC0400tc.a(zArr, iA, AbstractC0335da.d[Character.digit(str.charAt(i), 10)], false);
        }
        int iA2 = iA + AbstractC0400tc.a(zArr, iA, AbstractC0335da.b, false);
        for (int i2 = 4; i2 <= 7; i2++) {
            iA2 += AbstractC0400tc.a(zArr, iA2, AbstractC0335da.d[Character.digit(str.charAt(i2), 10)], true);
        }
        AbstractC0400tc.a(zArr, iA2, AbstractC0335da.a, true);
        return zArr;
    }
}
