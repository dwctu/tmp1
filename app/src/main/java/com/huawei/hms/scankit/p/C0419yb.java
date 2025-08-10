package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: EmailContentAddressResultParser.java */
/* renamed from: com.huawei.hms.scankit.p.yb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0419yb extends Fb {
    private static final Pattern g = Pattern.compile("(?:MATMSG:TO:|mailto:|SMTP:)([\\s\\S]+)", 2);
    private static final Pattern h = Pattern.compile("mailto:([\\s\\S]+)\\?subject=([\\s\\S]+)&body=([\\s\\S]+)", 2);
    private static final Pattern i = Pattern.compile("MATMSG:TO:([\\s\\S]+);SUB:([\\s\\S]+);BODY:([\\s\\S]+)", 2);
    private static final Pattern j = Pattern.compile("SMTP:([\\s\\S]+):([\\s\\S]+):([\\s\\S]+)", 2);

    public static String c(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    @Override // com.huawei.hms.scankit.p.Fb
    public HmsScan b(com.huawei.hms.scankit.aiscan.common.x xVar) {
        Matcher matcher;
        Matcher matcher2;
        Matcher matcher3;
        String strGroup;
        String str;
        String strGroup2;
        String strA = Fb.a(xVar);
        if (TextUtils.isEmpty(strA) || !g.matcher(strA).matches()) {
            return null;
        }
        try {
            matcher = h.matcher(strA);
            matcher2 = i.matcher(strA);
            matcher3 = j.matcher(strA);
        } catch (RuntimeException | Exception unused) {
        }
        if (matcher.matches()) {
            String strGroup3 = matcher.group(1);
            strGroup = matcher.group(2);
            strGroup2 = matcher.group(3);
            str = strGroup3;
        } else {
            if (!matcher2.matches()) {
                if (matcher3.matches()) {
                    String strGroup4 = matcher3.group(1);
                    strGroup = matcher3.group(2);
                    str = strGroup4;
                    strGroup2 = matcher3.group(3);
                }
                return null;
            }
            String strGroup5 = matcher2.group(1);
            String strGroup6 = matcher2.group(2);
            String strGroup7 = matcher2.group(3);
            str = strGroup5;
            strGroup = strGroup6;
            strGroup2 = strGroup7;
        }
        return new HmsScan(xVar.i(), Fb.a(xVar.b()), str, HmsScan.EMAIL_CONTENT_FORM, xVar.g(), Fb.a(xVar.h()), null, new com.huawei.hms.scankit.F(new HmsScan.EmailContent(str, c(strGroup), c(strGroup2), HmsScan.EmailContent.OTHER_USE_TYPE)));
    }
}
