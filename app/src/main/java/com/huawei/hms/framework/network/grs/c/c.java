package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import org.json.JSONException;
import org.slf4j.Logger;

/* loaded from: classes2.dex */
public class c {
    private Context a;
    private GrsBaseInfo b;
    private com.huawei.hms.framework.network.grs.a.a c;

    public c(Context context, com.huawei.hms.framework.network.grs.a.a aVar, GrsBaseInfo grsBaseInfo) {
        this.a = context;
        this.b = grsBaseInfo;
        this.c = aVar;
    }

    public String a(boolean z) {
        String strA;
        String strA2 = com.huawei.hms.framework.network.grs.a.a(this.c.a().a("geoipCountryCode", ""), "geoip.countrycode", Logger.ROOT_LOGGER_NAME);
        com.huawei.hms.framework.common.Logger.i("GeoipCountry", "geoIpCountry is: " + strA2);
        String strA3 = this.c.a().a("geoipCountryCodetime", "0");
        long j = 0;
        if (!TextUtils.isEmpty(strA3) && strA3.matches("\\d+")) {
            try {
                j = Long.parseLong(strA3);
            } catch (NumberFormatException e) {
                com.huawei.hms.framework.common.Logger.w("GeoipCountry", "convert urlParamKey from String to Long catch NumberFormatException.", e);
            }
        }
        if (TextUtils.isEmpty(strA2) || com.huawei.hms.framework.network.grs.d.e.a(Long.valueOf(j))) {
            com.huawei.hms.framework.network.grs.c.b.c cVar = new com.huawei.hms.framework.network.grs.c.b.c(this.b, this.a);
            cVar.a("geoip.countrycode");
            com.huawei.hms.framework.network.grs.a.c cVarC = this.c.c();
            if (cVarC != null) {
                try {
                    strA = n.a(cVarC.a("services", ""), cVar.c());
                } catch (JSONException e2) {
                    com.huawei.hms.framework.common.Logger.w("GeoipCountry", "getGeoipCountry merge services occure jsonException.", e2);
                    strA = null;
                }
                if (!TextUtils.isEmpty(strA)) {
                    cVarC.b("services", strA);
                }
            }
            if (z) {
                f fVarA = this.c.b().a(cVar, "geoip.countrycode", cVarC);
                if (fVarA != null) {
                    strA2 = com.huawei.hms.framework.network.grs.a.a(fVarA.i(), "geoip.countrycode", Logger.ROOT_LOGGER_NAME);
                }
                com.huawei.hms.framework.common.Logger.i("GeoipCountry", "sync request to query geoip.countrycode is:" + strA2);
            } else {
                com.huawei.hms.framework.common.Logger.i("GeoipCountry", "async request to query geoip.countrycode");
                this.c.b().a(cVar, null, "geoip.countrycode", cVarC);
            }
        }
        return strA2;
    }
}
