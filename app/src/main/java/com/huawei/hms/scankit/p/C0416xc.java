package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.nio.charset.Charset;
import java.util.Map;

/* compiled from: PDF417Writer.java */
/* renamed from: com.huawei.hms.scankit.p.xc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0416xc implements Pb {
    @Override // com.huawei.hms.scankit.p.Pb
    public C0417y a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<Jc, ?> map) throws Exception {
        int i3;
        int i4;
        if (barcodeFormat != BarcodeFormat.PDF_417) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got " + barcodeFormat);
        }
        Cc cc = new Cc();
        int i5 = 30;
        int i6 = 2;
        if (map != null) {
            Jc jc = Jc.PDF417_COMPACT;
            if (map.containsKey(jc)) {
                cc.a(Boolean.valueOf(map.get(jc).toString()).booleanValue());
            }
            Jc jc2 = Jc.PDF417_COMPACTION;
            if (map.containsKey(jc2)) {
                cc.a(Ac.valueOf(map.get(jc2).toString()));
            }
            Jc jc3 = Jc.PDF417_DIMENSIONS;
            if (map.containsKey(jc3)) {
                Bc bc = (Bc) map.get(jc3);
                cc.a(bc.a(), bc.c(), bc.b(), bc.d());
            }
            Jc jc4 = Jc.MARGIN;
            if (map.containsKey(jc4)) {
                try {
                    i5 = Integer.parseInt(map.get(jc4).toString());
                } catch (Exception e) {
                    throw e;
                }
            }
            Jc jc5 = Jc.ERROR_CORRECTION;
            if (map.containsKey(jc5)) {
                try {
                    i6 = Integer.parseInt(map.get(jc5).toString());
                } catch (Exception e2) {
                    throw e2;
                }
            }
            Jc jc6 = Jc.CHARACTER_SET;
            if (map.containsKey(jc6)) {
                cc.a(Charset.forName(map.get(jc6).toString()));
            }
            i4 = i5;
            i3 = i6;
        } else {
            i3 = 2;
            i4 = 30;
        }
        return a(cc, str, i3, i, i2, i4);
    }

    private static C0417y a(Cc cc, String str, int i, int i2, int i3, int i4) throws Exception {
        cc.a(str, i);
        byte[][] bArrA = cc.a().a(1, 4);
        int length = i2 / bArrA[0].length;
        int length2 = i3 / bArrA.length;
        if (length >= length2) {
            length = length2;
        }
        if (length > 1) {
            return a(cc.a().a(length, length * 4), i4);
        }
        return a(bArrA, i4);
    }

    private static C0417y a(byte[][] bArr, int i) {
        int i2 = i * 2;
        C0417y c0417y = new C0417y(bArr[0].length + i2, bArr.length + i2);
        c0417y.a();
        int iB = (c0417y.b() - i) - 1;
        int i3 = 0;
        while (i3 < bArr.length) {
            byte[] bArr2 = bArr[i3];
            for (int i4 = 0; i4 < bArr[0].length; i4++) {
                if (bArr2[i4] == 1) {
                    c0417y.c(i4 + i, iB);
                }
            }
            i3++;
            iB--;
        }
        return c0417y;
    }
}
