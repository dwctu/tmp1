package okhttp3.internal.http2;

import dc.qd4;
import okhttp3.internal.Util;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes5.dex */
public final class Header {
    public final int hpackSize;
    public final qd4 name;
    public final qd4 value;
    public static final qd4 PSEUDO_PREFIX = qd4.h(SignatureImpl.INNER_SEP);
    public static final String RESPONSE_STATUS_UTF8 = ":status";
    public static final qd4 RESPONSE_STATUS = qd4.h(RESPONSE_STATUS_UTF8);
    public static final String TARGET_METHOD_UTF8 = ":method";
    public static final qd4 TARGET_METHOD = qd4.h(TARGET_METHOD_UTF8);
    public static final String TARGET_PATH_UTF8 = ":path";
    public static final qd4 TARGET_PATH = qd4.h(TARGET_PATH_UTF8);
    public static final String TARGET_SCHEME_UTF8 = ":scheme";
    public static final qd4 TARGET_SCHEME = qd4.h(TARGET_SCHEME_UTF8);
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";
    public static final qd4 TARGET_AUTHORITY = qd4.h(TARGET_AUTHORITY_UTF8);

    public Header(String str, String str2) {
        this(qd4.h(str), qd4.h(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return this.name.equals(header.name) && this.value.equals(header.value);
    }

    public int hashCode() {
        return ((527 + this.name.hashCode()) * 31) + this.value.hashCode();
    }

    public String toString() {
        return Util.format("%s: %s", this.name.x(), this.value.x());
    }

    public Header(qd4 qd4Var, String str) {
        this(qd4Var, qd4.h(str));
    }

    public Header(qd4 qd4Var, qd4 qd4Var2) {
        this.name = qd4Var;
        this.value = qd4Var2;
        this.hpackSize = qd4Var.s() + 32 + qd4Var2.s();
    }
}
