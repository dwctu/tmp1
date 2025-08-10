package dc;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.regex.Pattern;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: Url.java */
/* loaded from: classes4.dex */
public class ow3 {
    public static Pattern a = Pattern.compile("^http|ws$");
    public static Pattern b = Pattern.compile("^(http|ws)s$");

    public static String a(URL url) {
        String protocol = url.getProtocol();
        int port = url.getPort();
        if (port == -1) {
            if (a.matcher(protocol).matches()) {
                port = 80;
            } else if (b.matcher(protocol).matches()) {
                port = 443;
            }
        }
        return protocol + "://" + url.getHost() + SignatureImpl.INNER_SEP + port;
    }

    public static URL b(URI uri) {
        String str;
        String str2;
        String str3;
        String scheme = uri.getScheme();
        if (scheme == null || !scheme.matches("^https?|wss?$")) {
            scheme = "https";
        }
        int port = uri.getPort();
        if (port == -1) {
            if (a.matcher(scheme).matches()) {
                port = 80;
            } else if (b.matcher(scheme).matches()) {
                port = 443;
            }
        }
        String rawPath = uri.getRawPath();
        if (rawPath == null || rawPath.length() == 0) {
            rawPath = "/";
        }
        String rawUserInfo = uri.getRawUserInfo();
        String rawQuery = uri.getRawQuery();
        String rawFragment = uri.getRawFragment();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(scheme);
            sb.append("://");
            String str4 = "";
            if (rawUserInfo != null) {
                str = rawUserInfo + "@";
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(uri.getHost());
            if (port != -1) {
                str2 = SignatureImpl.INNER_SEP + port;
            } else {
                str2 = "";
            }
            sb.append(str2);
            sb.append(rawPath);
            if (rawQuery != null) {
                str3 = "?" + rawQuery;
            } else {
                str3 = "";
            }
            sb.append(str3);
            if (rawFragment != null) {
                str4 = "#" + rawFragment;
            }
            sb.append(str4);
            return new URL(sb.toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
