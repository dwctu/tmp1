package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: QRCodeWriter.java */
/* loaded from: classes3.dex */
public final class Gc implements Pb {
    @Override // com.huawei.hms.scankit.p.Pb
    public C0417y a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<Jc, ?> map) throws Exception {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + barcodeFormat);
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        }
        Pa paValueOf = Pa.L;
        int i3 = 4;
        Boolean bool = Boolean.FALSE;
        if (map != null) {
            Jc jc = Jc.ERROR_CORRECTION;
            if (map.containsKey(jc)) {
                paValueOf = Pa.valueOf(map.get(jc).toString());
            }
            Jc jc2 = Jc.MARGIN;
            if (map.containsKey(jc2)) {
                try {
                    i3 = Integer.parseInt(map.get(jc2).toString());
                } catch (Exception e) {
                    throw e;
                }
            }
            Jc jc3 = Jc.LOGO;
            if (map.containsKey(jc3)) {
                try {
                    bool = (Boolean) map.get(jc3);
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }
        return a(Lc.a(str, paValueOf, map), i, i2, i3, bool.booleanValue());
    }

    private static C0417y a(Oc oc, int i, int i2, int i3, boolean z) {
        int iMax;
        int iMax2;
        int iMin;
        Ic icA = oc.a();
        if (icA != null) {
            int iC = icA.c();
            int iB = icA.b();
            if (z) {
                iMax = Math.max(i, iC);
                iMax2 = Math.max(i2, iB);
                int i4 = i3 * 2;
                iMin = Math.min((iMax - i4) / iC, (iMax2 - i4) / iB);
            } else {
                int i5 = i3 * 2;
                int i6 = iC + i5;
                int i7 = i5 + iB;
                iMax = Math.max(i, i6);
                iMax2 = Math.max(i2, i7);
                iMin = Math.min(iMax / i6, iMax2 / i7);
            }
            int i8 = (iMax - (iC * iMin)) / 2;
            int i9 = (iMax2 - (iB * iMin)) / 2;
            C0417y c0417y = new C0417y(iMax, iMax2);
            int i10 = 0;
            while (i10 < iB) {
                int i11 = i8;
                int i12 = 0;
                while (i12 < iC) {
                    if (icA.a(i12, i10) == 1) {
                        c0417y.a(i11, i9, iMin, iMin);
                    }
                    i12++;
                    i11 += iMin;
                }
                i10++;
                i9 += iMin;
            }
            return c0417y;
        }
        throw new IllegalStateException();
    }
}
