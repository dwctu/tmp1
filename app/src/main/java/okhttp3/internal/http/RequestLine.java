package okhttp3.internal.http;

import dc.rc4;
import dc.yc4;
import java.net.Proxy;
import org.apache.commons.codec.net.RFC1522Codec;

/* loaded from: classes5.dex */
public final class RequestLine {
    private RequestLine() {
    }

    public static String get(yc4 yc4Var, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(yc4Var.g());
        sb.append(' ');
        if (includeAuthorityInRequestLine(yc4Var, type)) {
            sb.append(yc4Var.j());
        } else {
            sb.append(requestPath(yc4Var.j()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean includeAuthorityInRequestLine(yc4 yc4Var, Proxy.Type type) {
        return !yc4Var.f() && type == Proxy.Type.HTTP;
    }

    public static String requestPath(rc4 rc4Var) {
        String strH = rc4Var.h();
        String strJ = rc4Var.j();
        if (strJ == null) {
            return strH;
        }
        return strH + RFC1522Codec.SEP + strJ;
    }
}
