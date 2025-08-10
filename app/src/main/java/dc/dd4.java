package dc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.util.TLSUtils;

/* compiled from: TlsVersion.java */
/* loaded from: classes5.dex */
public enum dd4 {
    TLS_1_3("TLSv1.3"),
    TLS_1_2(TLSUtils.PROTO_TLSV1_2),
    TLS_1_1(TLSUtils.PROTO_TLSV1_1),
    TLS_1_0(TLSUtils.PROTO_TLSV1),
    SSL_3_0(TLSUtils.PROTO_SSL3);

    public final String javaName;

    dd4(String str) {
        this.javaName = str;
    }

    public static dd4 forJavaName(String str) {
        str.hashCode();
        switch (str) {
            case "TLSv1.1":
                return TLS_1_1;
            case "TLSv1.2":
                return TLS_1_2;
            case "TLSv1.3":
                return TLS_1_3;
            case "SSLv3":
                return SSL_3_0;
            case "TLSv1":
                return TLS_1_0;
            default:
                throw new IllegalArgumentException("Unexpected TLS version: " + str);
        }
    }

    public static List<dd4> forJavaNames(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(forJavaName(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public String javaName() {
        return this.javaName;
    }
}
