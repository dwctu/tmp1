package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes2.dex */
public class f {
    private static final String a = "f";
    public static final Set<String> b = Collections.unmodifiableSet(new e(16));

    public static String a(Context context, com.huawei.hms.framework.network.grs.a.a aVar, String str, GrsBaseInfo grsBaseInfo, boolean z) {
        if (TextUtils.isEmpty(str)) {
            Logger.w(a, "routeBy must be not empty string or null.");
            return null;
        }
        if (!"no_route".equals(str) && !"unconditional".equals(str)) {
            return b(context, aVar, str, grsBaseInfo, z);
        }
        Logger.v(a, "routeBy equals NO_ROUTE_POLICY");
        return "no_route_country";
    }

    private static String b(Context context, com.huawei.hms.framework.network.grs.a.a aVar, String str, GrsBaseInfo grsBaseInfo, boolean z) {
        String str2;
        StringBuilder sb;
        String str3;
        String serCountry = grsBaseInfo.getSerCountry();
        String regCountry = grsBaseInfo.getRegCountry();
        String issueCountry = grsBaseInfo.getIssueCountry();
        for (String str4 : str.split(SimpleComparison.GREATER_THAN_OPERATION)) {
            if (b.contains(str4.trim())) {
                if (!"ser_country".equals(str4.trim()) || TextUtils.isEmpty(serCountry) || GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(serCountry)) {
                    if ("reg_country".equals(str4.trim()) && !TextUtils.isEmpty(regCountry) && !GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(regCountry)) {
                        Logger.i(a, "current route_by is regCountry and routerCountry is:" + regCountry);
                        return regCountry;
                    }
                    if ("issue_country".equals(str4.trim()) && !TextUtils.isEmpty(issueCountry) && !GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(issueCountry)) {
                        Logger.i(a, "current route_by is issueCountry and routerCountry is:" + issueCountry);
                        return issueCountry;
                    }
                    if ("geo_ip".equals(str4.trim())) {
                        serCountry = new com.huawei.hms.framework.network.grs.c.c(context, aVar, new GrsBaseInfo()).a(z);
                        str2 = a;
                        sb = new StringBuilder();
                        str3 = "current route_by is geo_ip and routerCountry is: ";
                    }
                } else {
                    str2 = a;
                    sb = new StringBuilder();
                    str3 = "current route_by is serCountry and routerCountry is:";
                }
                sb.append(str3);
                sb.append(serCountry);
                Logger.i(str2, sb.toString());
                return serCountry;
            }
        }
        return "";
    }
}
