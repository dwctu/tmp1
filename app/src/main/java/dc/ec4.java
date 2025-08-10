package dc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.bouncycastle.crypto.tls.CipherSuite;

/* compiled from: CipherSuite.java */
/* loaded from: classes5.dex */
public final class ec4 {
    public static final Comparator<String> b = new Comparator() { // from class: dc.sb4
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ec4.e((String) obj, (String) obj2);
        }
    };
    public static final Map<String, ec4> c = new LinkedHashMap();
    public static final ec4 d;
    public static final ec4 e;
    public static final ec4 f;
    public static final ec4 g;
    public static final ec4 h;
    public static final ec4 i;
    public static final ec4 j;
    public static final ec4 k;
    public static final ec4 l;
    public static final ec4 m;
    public static final ec4 n;
    public static final ec4 o;
    public static final ec4 p;
    public static final ec4 q;
    public static final ec4 r;
    public static final ec4 s;
    public final String a;

    static {
        c("SSL_RSA_WITH_NULL_MD5", 1);
        c("SSL_RSA_WITH_NULL_SHA", 2);
        c("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        c("SSL_RSA_WITH_RC4_128_MD5", 4);
        c("SSL_RSA_WITH_RC4_128_SHA", 5);
        c("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        c("SSL_RSA_WITH_DES_CBC_SHA", 9);
        d = c("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        c("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        c("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        c("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        c("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        c("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        c("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        c("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        c("SSL_DH_anon_WITH_RC4_128_MD5", 24);
        c("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        c("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        c("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        c("TLS_KRB5_WITH_DES_CBC_SHA", 30);
        c("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        c("TLS_KRB5_WITH_RC4_128_SHA", 32);
        c("TLS_KRB5_WITH_DES_CBC_MD5", 34);
        c("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        c("TLS_KRB5_WITH_RC4_128_MD5", 36);
        c("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        c("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        c("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        c("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        e = c("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        c("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        c("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        c("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        f = c("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        c("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        c("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        c("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        c("TLS_RSA_WITH_NULL_SHA256", 59);
        c("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        c("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        c("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        c("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        c("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        c("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        c("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        c("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        c("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        c("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        c("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        c("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
        c("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        c("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA);
        c("TLS_PSK_WITH_RC4_128_SHA", 138);
        c("TLS_PSK_WITH_3DES_EDE_CBC_SHA", CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA);
        c("TLS_PSK_WITH_AES_128_CBC_SHA", CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA);
        c("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
        c("TLS_RSA_WITH_SEED_CBC_SHA", CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA);
        g = c("TLS_RSA_WITH_AES_128_GCM_SHA256", CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256);
        h = c("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        c("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        c("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
        c("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        c("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        c("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
        c("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        c("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        c("TLS_FALLBACK_SCSV", 22016);
        c("TLS_ECDH_ECDSA_WITH_NULL_SHA", CipherSuite.TLS_ECDH_ECDSA_WITH_NULL_SHA);
        c("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", CipherSuite.TLS_ECDH_ECDSA_WITH_RC4_128_SHA);
        c("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", CipherSuite.TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA);
        c("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", CipherSuite.TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA);
        c("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", CipherSuite.TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA);
        c("TLS_ECDHE_ECDSA_WITH_NULL_SHA", CipherSuite.TLS_ECDHE_ECDSA_WITH_NULL_SHA);
        c("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", CipherSuite.TLS_ECDHE_ECDSA_WITH_RC4_128_SHA);
        c("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", CipherSuite.TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA);
        c("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA);
        c("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA);
        c("TLS_ECDH_RSA_WITH_NULL_SHA", CipherSuite.TLS_ECDH_RSA_WITH_NULL_SHA);
        c("TLS_ECDH_RSA_WITH_RC4_128_SHA", CipherSuite.TLS_ECDH_RSA_WITH_RC4_128_SHA);
        c("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", CipherSuite.TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA);
        c("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", CipherSuite.TLS_ECDH_RSA_WITH_AES_128_CBC_SHA);
        c("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", CipherSuite.TLS_ECDH_RSA_WITH_AES_256_CBC_SHA);
        c("TLS_ECDHE_RSA_WITH_NULL_SHA", CipherSuite.TLS_ECDHE_RSA_WITH_NULL_SHA);
        c("TLS_ECDHE_RSA_WITH_RC4_128_SHA", CipherSuite.TLS_ECDHE_RSA_WITH_RC4_128_SHA);
        c("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", CipherSuite.TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA);
        i = c("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA);
        j = c("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA);
        c("TLS_ECDH_anon_WITH_NULL_SHA", CipherSuite.TLS_ECDH_anon_WITH_NULL_SHA);
        c("TLS_ECDH_anon_WITH_RC4_128_SHA", CipherSuite.TLS_ECDH_anon_WITH_RC4_128_SHA);
        c("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", CipherSuite.TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA);
        c("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", CipherSuite.TLS_ECDH_anon_WITH_AES_128_CBC_SHA);
        c("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", CipherSuite.TLS_ECDH_anon_WITH_AES_256_CBC_SHA);
        c("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256);
        c("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384);
        c("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", CipherSuite.TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256);
        c("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", CipherSuite.TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384);
        c("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256);
        c("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384);
        c("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", CipherSuite.TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256);
        c("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", CipherSuite.TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384);
        k = c("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256);
        l = c("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384);
        c("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", CipherSuite.TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256);
        c("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", CipherSuite.TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384);
        m = c("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256);
        n = c("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384);
        c("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", CipherSuite.TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256);
        c("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", CipherSuite.TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384);
        c("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", CipherSuite.TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA);
        c("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", CipherSuite.TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA);
        o = c("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        p = c("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
        c("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        c("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
        q = c("TLS_AES_128_GCM_SHA256", 4865);
        r = c("TLS_AES_256_GCM_SHA384", 4866);
        s = c("TLS_CHACHA20_POLY1305_SHA256", 4867);
        c("TLS_AES_128_CCM_SHA256", 4868);
        c("TLS_AES_128_CCM_8_SHA256", 4869);
    }

    public ec4(String str) {
        Objects.requireNonNull(str);
        this.a = str;
    }

    public static synchronized ec4 a(String str) {
        ec4 ec4Var;
        Map<String, ec4> map = c;
        ec4Var = map.get(str);
        if (ec4Var == null) {
            ec4Var = map.get(f(str));
            if (ec4Var == null) {
                ec4Var = new ec4(str);
            }
            map.put(str, ec4Var);
        }
        return ec4Var;
    }

    public static List<ec4> b(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static ec4 c(String str, int i2) {
        ec4 ec4Var = new ec4(str);
        c.put(str, ec4Var);
        return ec4Var;
    }

    public static /* synthetic */ int e(String str, String str2) {
        int iMin = Math.min(str.length(), str2.length());
        for (int i2 = 4; i2 < iMin; i2++) {
            char cCharAt = str.charAt(i2);
            char cCharAt2 = str2.charAt(i2);
            if (cCharAt != cCharAt2) {
                return cCharAt < cCharAt2 ? -1 : 1;
            }
        }
        int length = str.length();
        int length2 = str2.length();
        if (length != length2) {
            return length < length2 ? -1 : 1;
        }
        return 0;
    }

    public static String f(String str) {
        if (str.startsWith("TLS_")) {
            return "SSL_" + str.substring(4);
        }
        if (!str.startsWith("SSL_")) {
            return str;
        }
        return "TLS_" + str.substring(4);
    }

    public String d() {
        return this.a;
    }

    public String toString() {
        return this.a;
    }
}
