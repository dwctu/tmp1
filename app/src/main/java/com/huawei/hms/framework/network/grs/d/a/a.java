package com.huawei.hms.framework.network.grs.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes2.dex */
public class a {
    public static HttpsURLConnection a(String str, Context context, String str2) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
        if (!(uRLConnectionOpenConnection instanceof HttpsURLConnection)) {
            Logger.w("URLConnectionHelper", "urlConnection is not an instance of HttpsURLConnection");
            return null;
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
        try {
            httpsURLConnection.setSSLSocketFactory(com.huawei.hms.framework.network.grs.d.b.a.a(context));
            httpsURLConnection.setHostnameVerifier(com.huawei.hms.framework.network.grs.d.b.a.a());
        } catch (IllegalArgumentException unused) {
            Logger.w("URLConnectionHelper", "init https ssl socket failed.");
        }
        httpsURLConnection.setConnectTimeout(10000);
        httpsURLConnection.setReadTimeout(10000);
        String strB = com.huawei.hms.framework.network.grs.d.a.b(context, "NetworkKit-grs", str2);
        Logger.d("URLConnectionHelper", "request to grs server with a User-Agent header is:" + strB);
        httpsURLConnection.setRequestProperty("User-Agent", strB);
        return httpsURLConnection;
    }
}
