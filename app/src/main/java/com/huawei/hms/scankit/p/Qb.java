package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* compiled from: AztecWriter.java */
/* loaded from: classes3.dex */
public final class Qb implements Pb {
    @Override // com.huawei.hms.scankit.p.Pb
    public C0417y a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<Jc, ?> map) throws Exception {
        Charset charset;
        int i3;
        int i4;
        int i5;
        Charset charsetForName = StandardCharsets.ISO_8859_1;
        int i6 = 33;
        int i7 = 0;
        if (map != null) {
            Jc jc = Jc.CHARACTER_SET;
            if (map.containsKey(jc)) {
                charsetForName = Charset.forName(map.get(jc).toString());
            }
            Jc jc2 = Jc.ERROR_CORRECTION;
            if (map.containsKey(jc2)) {
                try {
                    i6 = Integer.parseInt(map.get(jc2).toString());
                } catch (Exception e) {
                    throw e;
                }
            }
            Jc jc3 = Jc.AZTEC_LAYERS;
            if (map.containsKey(jc3)) {
                try {
                    i7 = Integer.parseInt(map.get(jc3).toString());
                } catch (Exception e2) {
                    throw e2;
                }
            }
            Jc jc4 = Jc.MARGIN;
            if (map.containsKey(jc4)) {
                try {
                    int i8 = Integer.parseInt(map.get(jc4).toString());
                    charset = charsetForName;
                    i3 = i6;
                    i4 = i7;
                    i5 = i8;
                    return a(str, barcodeFormat, i, i2, charset, i3, i4, i5);
                } catch (Exception e3) {
                    throw e3;
                }
            }
            charset = charsetForName;
            i3 = i6;
            i4 = i7;
        } else {
            charset = charsetForName;
            i3 = 33;
            i4 = 0;
        }
        i5 = 4;
        return a(str, barcodeFormat, i, i2, charset, i3, i4, i5);
    }

    private static C0417y a(String str, BarcodeFormat barcodeFormat, int i, int i2, Charset charset, int i3, int i4, int i5) throws Exception {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return a(Tb.a(str.getBytes(charset), i3, i4), i, i2, i5);
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Can only encode AZTEC, but got ");
            sb.append(barcodeFormat);
            throw new IllegalArgumentException(sb.toString());
        } catch (Exception e) {
            throw e;
        }
    }

    private static C0417y a(Rb rb, int i, int i2, int i3) {
        C0417y c0417yA = rb.a();
        if (c0417yA != null) {
            int iD = c0417yA.d();
            int iB = c0417yA.b();
            int i4 = i3 * 2;
            int i5 = iD + i4;
            int i6 = i4 + iB;
            int iMax = Math.max(i, i5);
            int iMax2 = Math.max(i2, i6);
            int iMin = Math.min(iMax / i5, iMax2 / i6);
            int i7 = (iMax - (iD * iMin)) / 2;
            int i8 = (iMax2 - (iB * iMin)) / 2;
            C0417y c0417y = new C0417y(iMax, iMax2);
            int i9 = 0;
            while (i9 < iB) {
                int i10 = i7;
                int i11 = 0;
                while (i11 < iD) {
                    if (c0417yA.b(i11, i9)) {
                        c0417y.a(i10, i8, iMin, iMin);
                    }
                    i11++;
                    i10 += iMin;
                }
                i9++;
                i8 += iMin;
            }
            return c0417y;
        }
        throw new IllegalStateException();
    }
}
