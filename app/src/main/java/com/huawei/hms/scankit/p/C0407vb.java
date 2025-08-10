package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: BookmarkDoCoMoResultParser.java */
/* renamed from: com.huawei.hms.scankit.p.vb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0407vb extends Fb {
    private static final Pattern g = Pattern.compile("(?:MEBKM:)([\\s\\S]+)", 2);
    private static final Pattern h = Pattern.compile("(?:http:/?(?!/)|http//)([\\s\\S]+)", 2);

    private static String a(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2.startsWith(str)) {
                return Fb.b(str2.substring(str.length()));
            }
        }
        return "";
    }

    @Override // com.huawei.hms.scankit.p.Fb
    public HmsScan b(com.huawei.hms.scankit.aiscan.common.x xVar) {
        String strA = Fb.a(xVar);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        Matcher matcher = g.matcher(strA);
        if (!matcher.matches()) {
            return null;
        }
        String[] strArrSplit = matcher.group(1).split("(?<=(?<!\\\\)(?:\\\\\\\\){0,100});");
        String strA2 = a(strArrSplit, "TITLE:");
        String strA3 = Fb.a(a(strArrSplit, "URL:"));
        if (strA3.length() == 0) {
            return null;
        }
        Matcher matcher2 = h.matcher(strA3);
        if (matcher2.matches()) {
            strA3 = strA3.substring(0, 4) + "://" + matcher2.group(1);
        }
        String str = strA3;
        return new HmsScan(xVar.i(), Fb.a(xVar.b()), str, HmsScan.URL_FORM, xVar.g(), Fb.a(xVar.h()), null, new com.huawei.hms.scankit.F(new HmsScan.LinkUrl(strA2, str)));
    }
}
