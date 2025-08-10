package io.agora.utils;

import android.text.TextUtils;
import io.agora.base.internal.CalledByNative;
import io.agora.base.internal.Logging;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;

/* loaded from: classes4.dex */
public class NetUtil {
    private static final String TAG = "NetUtil";

    public static boolean checkUrlEncoded(String str) {
        try {
            return !TextUtils.equals(str, URLDecoder.decode(str, "UTF-8"));
        } catch (Exception unused) {
            return false;
        }
    }

    public static String encodeUrl(String str) {
        Logging.d(TAG, "encodedUrl()");
        try {
            URL url = new URL(str);
            return new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toASCIIString();
        } catch (Exception unused) {
            return str;
        }
    }

    @CalledByNative
    public static String getDecodedUrl(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }

    @CalledByNative
    public static String getEncodedUrl(String str) {
        return checkUrlEncoded(str) ? str : encodeUrl(str);
    }

    public static boolean testNetworkUrlAvailable(String str) throws Throwable {
        Logging.d(TAG, "testNetworkUrlAvailable encodedUrl");
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setConnectTimeout(1000);
                httpURLConnection2.setReadTimeout(1000);
                z = httpURLConnection2.getResponseCode() != 404;
                InputStream inputStream = httpURLConnection2.getInputStream();
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Exception unused) {
                httpURLConnection = httpURLConnection2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return z;
            } catch (Throwable th) {
                th = th;
                httpURLConnection = httpURLConnection2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
        return z;
    }
}
