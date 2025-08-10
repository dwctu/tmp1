package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: DataMatrixWriter.java */
/* loaded from: classes3.dex */
public final class Yb implements Pb {
    @Override // com.huawei.hms.scankit.p.Pb
    public C0417y a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<Jc, ?> map) throws Exception {
        Mb mb;
        if (str.isEmpty()) {
            try {
                throw new IllegalArgumentException("Found empty contents");
            } catch (Exception e) {
                throw e;
            }
        }
        if (barcodeFormat != BarcodeFormat.DATA_MATRIX) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("Can only encode DATA_MATRIX, but got ");
                sb.append(barcodeFormat);
                throw new IllegalArgumentException(sb.toString());
            } catch (Exception e2) {
                throw e2;
            }
        }
        if (i < 0 || i2 < 0) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Requested dimensions can't be negative: ");
                sb2.append(i);
                sb2.append('x');
                sb2.append(i2);
                throw new IllegalArgumentException(sb2.toString());
            } catch (Exception e3) {
                throw e3;
            }
        }
        EnumC0361jc enumC0361jc = EnumC0361jc.FORCE_SQUARE;
        int i3 = 4;
        if (map != null) {
            EnumC0361jc enumC0361jc2 = (EnumC0361jc) map.get(Jc.DATA_MATRIX_SHAPE);
            if (enumC0361jc2 != null) {
                enumC0361jc = enumC0361jc2;
            }
            Mb mb2 = (Mb) map.get(Jc.MIN_SIZE);
            if (mb2 == null) {
                mb2 = null;
            }
            Mb mb3 = (Mb) map.get(Jc.MAX_SIZE);
            mb = mb3 != null ? mb3 : null;
            Jc jc = Jc.MARGIN;
            if (map.containsKey(jc)) {
                try {
                    i3 = Integer.parseInt(map.get(jc).toString());
                } catch (Exception e4) {
                    throw e4;
                }
            }
            mb = mb;
            mb = mb2;
        } else {
            mb = null;
        }
        String strA = C0353hc.a(str, enumC0361jc, mb, mb);
        C0357ic c0357icA = C0357ic.a(strA.length(), enumC0361jc, mb, mb, true);
        C0333cc c0333cc = new C0333cc(C0349gc.a(strA, c0357icA), c0357icA.e(), c0357icA.d());
        c0333cc.a();
        return a(c0333cc, c0357icA, i, i2, i3);
    }

    private static C0417y a(C0333cc c0333cc, C0357ic c0357ic, int i, int i2, int i3) {
        int iE = c0357ic.e();
        int iD = c0357ic.d();
        Ic ic = new Ic(c0357ic.g(), c0357ic.f());
        int i4 = 0;
        for (int i5 = 0; i5 < iD; i5++) {
            if (i5 % c0357ic.g == 0) {
                int i6 = 0;
                for (int i7 = 0; i7 < c0357ic.g(); i7++) {
                    ic.a(i6, i4, i7 % 2 == 0);
                    i6++;
                }
                i4++;
            }
            int i8 = 0;
            for (int i9 = 0; i9 < iE; i9++) {
                if (i9 % c0357ic.f == 0) {
                    ic.a(i8, i4, true);
                    i8++;
                }
                ic.a(i8, i4, c0333cc.a(i9, i5));
                i8++;
                int i10 = c0357ic.f;
                if (i9 % i10 == i10 - 1) {
                    ic.a(i8, i4, i5 % 2 == 0);
                    i8++;
                }
            }
            i4++;
            int i11 = c0357ic.g;
            if (i5 % i11 == i11 - 1) {
                int i12 = 0;
                for (int i13 = 0; i13 < c0357ic.g(); i13++) {
                    ic.a(i12, i4, true);
                    i12++;
                }
                i4++;
            }
        }
        return a(ic, i, i2, i3);
    }

    private static C0417y a(Ic ic, int i, int i2, int i3) {
        C0417y c0417y;
        int iC = ic.c();
        int iB = ic.b();
        int i4 = i3 * 2;
        int i5 = iC + i4;
        int i6 = i4 + iB;
        int iMax = Math.max(i, i5);
        int iMax2 = Math.max(i2, i6);
        int iMin = Math.min(iMax / i5, iMax2 / i6);
        int i7 = (iMax - (iC * iMin)) / 2;
        int i8 = (iMax2 - (iB * iMin)) / 2;
        if (i2 >= iB && i >= iC) {
            c0417y = new C0417y(i, i2);
        } else {
            c0417y = new C0417y(iC, iB);
            i7 = 0;
            i8 = 0;
        }
        c0417y.a();
        int i9 = 0;
        while (i9 < iB) {
            int i10 = i7;
            int i11 = 0;
            while (i11 < iC) {
                if (ic.a(i11, i9) == 1) {
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
}
