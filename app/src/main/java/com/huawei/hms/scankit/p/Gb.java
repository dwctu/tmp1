package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.broadcom.bt.util.io.IOUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.regex.Pattern;

/* compiled from: SMSTOMMSTOResultParser.java */
/* loaded from: classes3.dex */
public final class Gb extends Fb {
    private static final Pattern g = Pattern.compile("(?:mmsto|smsto):([\\s\\S]+)", 2);

    @Override // com.huawei.hms.scankit.p.Fb
    public HmsScan b(com.huawei.hms.scankit.aiscan.common.x xVar) {
        String strSubstring;
        String strSubstring2;
        String str;
        String strA = Fb.a(xVar);
        if (TextUtils.isEmpty(strA) || !g.matcher(strA).matches()) {
            return null;
        }
        String strSubstring3 = strA.substring(6);
        int iIndexOf = strSubstring3.indexOf(58);
        if (iIndexOf >= 0) {
            strSubstring = strSubstring3.substring(0, iIndexOf);
            strSubstring2 = strSubstring3.substring(iIndexOf + 1);
        } else {
            strSubstring = strSubstring3;
            strSubstring2 = "";
        }
        if (strSubstring2.isEmpty()) {
            str = strSubstring;
        } else {
            str = strSubstring + IOUtils.LINE_SEPARATOR_UNIX + strSubstring2;
        }
        return new HmsScan(xVar.i(), Fb.a(xVar.b()), str, HmsScan.SMS_FORM, xVar.g(), Fb.a(xVar.h()), null, new com.huawei.hms.scankit.F(new HmsScan.SmsContent(strSubstring2, strSubstring)));
    }
}
