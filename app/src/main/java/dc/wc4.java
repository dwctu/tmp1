package dc;

import java.io.IOException;

/* compiled from: Protocol.java */
/* loaded from: classes5.dex */
public enum wc4 {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");

    private final String protocol;

    wc4(String str) {
        this.protocol = str;
    }

    public static wc4 get(String str) throws IOException {
        wc4 wc4Var = HTTP_1_0;
        if (str.equals(wc4Var.protocol)) {
            return wc4Var;
        }
        wc4 wc4Var2 = HTTP_1_1;
        if (str.equals(wc4Var2.protocol)) {
            return wc4Var2;
        }
        wc4 wc4Var3 = H2_PRIOR_KNOWLEDGE;
        if (str.equals(wc4Var3.protocol)) {
            return wc4Var3;
        }
        wc4 wc4Var4 = HTTP_2;
        if (str.equals(wc4Var4.protocol)) {
            return wc4Var4;
        }
        wc4 wc4Var5 = SPDY_3;
        if (str.equals(wc4Var5.protocol)) {
            return wc4Var5;
        }
        wc4 wc4Var6 = QUIC;
        if (str.equals(wc4Var6.protocol)) {
            return wc4Var6;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
