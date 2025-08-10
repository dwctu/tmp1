package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;

/* compiled from: ISBNResultParser.java */
/* loaded from: classes3.dex */
public final class Bb extends Fb {
    @Override // com.huawei.hms.scankit.p.Fb
    public HmsScan b(com.huawei.hms.scankit.aiscan.common.x xVar) {
        if (Fb.a(xVar.b()) != HmsScanBase.EAN13_SCAN_TYPE) {
            return null;
        }
        String strA = Fb.a(xVar);
        if (strA.length() != 13) {
            return null;
        }
        if (strA.startsWith("978") || strA.startsWith("979")) {
            return new HmsScan(xVar.i(), Fb.a(xVar.b()), strA, HmsScan.ISBN_NUMBER_FORM, xVar.g(), Fb.a(xVar.h()), null, null);
        }
        return null;
    }
}
