package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;

/* compiled from: ProductResultParser.java */
/* loaded from: classes3.dex */
public final class Eb extends Fb {
    @Override // com.huawei.hms.scankit.p.Fb
    public HmsScan b(com.huawei.hms.scankit.aiscan.common.x xVar) {
        int iA = Fb.a(xVar.b());
        if (iA != HmsScanBase.EAN13_SCAN_TYPE && iA != HmsScanBase.EAN8_SCAN_TYPE && iA != HmsScanBase.UPCCODE_A_SCAN_TYPE && iA != HmsScanBase.UPCCODE_E_SCAN_TYPE) {
            return null;
        }
        String strA = Fb.a(xVar);
        if (Fb.a(strA, strA.length())) {
            return new HmsScan(strA, Fb.a(xVar.b()), strA, HmsScan.ARTICLE_NUMBER_FORM, xVar.g(), Fb.a(xVar.h()), null, null);
        }
        return null;
    }
}
