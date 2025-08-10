package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: HTTPResultParser.java */
/* loaded from: classes3.dex */
public final class Ab extends Fb {
    private static final Pattern g = Pattern.compile("(?:http:|http//|https://)([\\s\\S]+)", 2);
    private static final Pattern h = Pattern.compile("(?:http:/?(?!/)|http//)([\\s\\S]+)", 2);

    @Override // com.huawei.hms.scankit.p.Fb
    public HmsScan b(com.huawei.hms.scankit.aiscan.common.x xVar) {
        String strA = Fb.a(xVar);
        if (!g.matcher(strA).matches()) {
            return null;
        }
        Matcher matcher = h.matcher(strA);
        if (matcher.matches()) {
            strA = strA.substring(0, 4) + "://" + matcher.group(1);
        }
        String strA2 = Fb.a(strA);
        if (strA2.length() == 7) {
            return null;
        }
        return new HmsScan(xVar.i(), Fb.a(xVar.b()), strA2, HmsScan.URL_FORM, xVar.g(), Fb.a(xVar.h()), null, new com.huawei.hms.scankit.F(new HmsScan.LinkUrl("", strA2)));
    }
}
