package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: URIResultParser.java */
/* loaded from: classes3.dex */
public final class Ib extends Fb {
    private static final Pattern g = Pattern.compile("(?:uri|url):([\\s\\S]*)", 2);
    private static final Pattern h = Pattern.compile("(?:http:/?(?!/)|http//)([\\s\\S]+)", 2);

    @Override // com.huawei.hms.scankit.p.Fb
    public HmsScan b(com.huawei.hms.scankit.aiscan.common.x xVar) {
        String strA = Fb.a(xVar);
        if (TextUtils.isEmpty(strA) || !g.matcher(strA).matches()) {
            return null;
        }
        String strSubstring = strA.substring(4);
        Matcher matcher = h.matcher(strSubstring);
        if (matcher.matches()) {
            strSubstring = strSubstring.substring(0, 4) + "://" + matcher.group(1);
        }
        return new HmsScan(xVar.i(), Fb.a(xVar.b()), Fb.a(strSubstring), HmsScan.URL_FORM, xVar.g(), Fb.a(xVar.h()), null, new com.huawei.hms.scankit.F(new HmsScan.LinkUrl("", "")));
    }
}
