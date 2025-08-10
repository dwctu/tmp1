package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: WifiResultParser.java */
/* loaded from: classes3.dex */
public final class Lb extends Fb {
    private static final Pattern g = Pattern.compile("WIFI:[^:]", 2);

    private static int c(String str) {
        if (str == null) {
            return 0;
        }
        if (str.equalsIgnoreCase("WEP")) {
            return 2;
        }
        if ((str.equalsIgnoreCase("WPA") | str.equalsIgnoreCase("WPA2") | str.equalsIgnoreCase("WPA/WPA2")) || str.equalsIgnoreCase("WPA2/WPA")) {
            return 1;
        }
        return str.equalsIgnoreCase("SAE") ? 3 : 0;
    }

    @Override // com.huawei.hms.scankit.p.Fb
    public HmsScan b(com.huawei.hms.scankit.aiscan.common.x xVar) {
        String str;
        String strA = Fb.a(xVar);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        Matcher matcher = g.matcher(strA);
        if (matcher.find() && matcher.start() == 0) {
            String strSubstring = strA.substring(5);
            if (!strSubstring.endsWith(";")) {
                strSubstring = strSubstring + ";";
            }
            String strB = Fb.b("S:", strSubstring, ';', false);
            if (strB != null && !strB.isEmpty()) {
                String strB2 = Fb.b("P:", strSubstring, ';', false);
                String strB3 = Fb.b("T:", strSubstring, ';', false);
                StringBuilder sb = new StringBuilder();
                sb.append(strB);
                if (strB2 == null || strB2.isEmpty()) {
                    str = "";
                } else {
                    str = " " + strB2;
                }
                sb.append(str);
                return new HmsScan(xVar.i(), Fb.a(xVar.b()), sb.toString(), HmsScan.WIFI_CONNECT_INFO_FORM, xVar.g(), Fb.a(xVar.h()), null, new com.huawei.hms.scankit.F(new HmsScan.WiFiConnectionInfo(strB, strB2, c(strB3))));
            }
        }
        return null;
    }
}
