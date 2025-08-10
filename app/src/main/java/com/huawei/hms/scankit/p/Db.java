package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.regex.Pattern;

/* compiled from: MarketResultParser.java */
/* loaded from: classes3.dex */
public final class Db extends Fb {
    private static final Pattern g = Pattern.compile("market://[\\s\\S]*", 2);

    @Override // com.huawei.hms.scankit.p.Fb
    public HmsScan b(com.huawei.hms.scankit.aiscan.common.x xVar) {
        String strA = Fb.a(xVar);
        if (TextUtils.isEmpty(strA) || !g.matcher(strA).matches()) {
            return null;
        }
        return new HmsScan(xVar.i(), Fb.a(xVar.b()), strA, HmsScan.URL_FORM, xVar.g(), Fb.a(xVar.h()), null, new com.huawei.hms.scankit.F(new HmsScan.LinkUrl("", "")));
    }
}
