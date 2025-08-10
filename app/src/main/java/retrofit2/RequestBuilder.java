package retrofit2;

import dc.nd4;
import dc.oc4;
import dc.od4;
import dc.qc4;
import dc.rc4;
import dc.tc4;
import dc.uc4;
import dc.yc4;
import dc.zc4;
import java.io.IOException;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public final class RequestBuilder {
    private static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
    private final rc4 baseUrl;
    private zc4 body;
    private tc4 contentType;
    private oc4.a formBuilder;
    private final boolean hasBody;
    private final qc4.a headersBuilder;
    private final String method;
    private uc4.a multipartBuilder;
    private String relativeUrl;
    private final yc4.a requestBuilder = new yc4.a();
    private rc4.a urlBuilder;
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final Pattern PATH_TRAVERSAL = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    public static class ContentTypeOverridingRequestBody extends zc4 {
        private final tc4 contentType;
        private final zc4 delegate;

        public ContentTypeOverridingRequestBody(zc4 zc4Var, tc4 tc4Var) {
            this.delegate = zc4Var;
            this.contentType = tc4Var;
        }

        @Override // dc.zc4
        public long contentLength() throws IOException {
            return this.delegate.contentLength();
        }

        @Override // dc.zc4
        public tc4 contentType() {
            return this.contentType;
        }

        @Override // dc.zc4
        public void writeTo(od4 od4Var) throws IOException {
            this.delegate.writeTo(od4Var);
        }
    }

    public RequestBuilder(String str, rc4 rc4Var, String str2, qc4 qc4Var, tc4 tc4Var, boolean z, boolean z2, boolean z3) {
        this.method = str;
        this.baseUrl = rc4Var;
        this.relativeUrl = str2;
        this.contentType = tc4Var;
        this.hasBody = z;
        if (qc4Var != null) {
            this.headersBuilder = qc4Var.f();
        } else {
            this.headersBuilder = new qc4.a();
        }
        if (z2) {
            this.formBuilder = new oc4.a();
        } else if (z3) {
            uc4.a aVar = new uc4.a();
            this.multipartBuilder = aVar;
            aVar.f(uc4.g);
        }
    }

    private static String canonicalizeForPath(String str, boolean z) {
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(iCodePointAt) != -1 || (!z && (iCodePointAt == 47 || iCodePointAt == 37))) {
                nd4 nd4Var = new nd4();
                nd4Var.v0(str, 0, iCharCount);
                canonicalizeForPath(nd4Var, str, iCharCount, length, z);
                return nd4Var.V();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str;
    }

    public void addFormField(String str, String str2, boolean z) {
        if (z) {
            this.formBuilder.b(str, str2);
        } else {
            this.formBuilder.a(str, str2);
        }
    }

    public void addHeader(String str, String str2) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            this.headersBuilder.a(str, str2);
            return;
        }
        try {
            this.contentType = tc4.c(str2);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Malformed content type: " + str2, e);
        }
    }

    public void addHeaders(qc4 qc4Var) {
        this.headersBuilder.b(qc4Var);
    }

    public void addPart(qc4 qc4Var, zc4 zc4Var) {
        this.multipartBuilder.c(qc4Var, zc4Var);
    }

    public void addPathParam(String str, String str2, boolean z) {
        if (this.relativeUrl == null) {
            throw new AssertionError();
        }
        String strCanonicalizeForPath = canonicalizeForPath(str2, z);
        String strReplace = this.relativeUrl.replace("{" + str + "}", strCanonicalizeForPath);
        if (!PATH_TRAVERSAL.matcher(strReplace).matches()) {
            this.relativeUrl = strReplace;
            return;
        }
        throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
    }

    public void addQueryParam(String str, String str2, boolean z) {
        String str3 = this.relativeUrl;
        if (str3 != null) {
            rc4.a aVarR = this.baseUrl.r(str3);
            this.urlBuilder = aVarR;
            if (aVarR == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
            this.relativeUrl = null;
        }
        if (z) {
            this.urlBuilder.b(str, str2);
        } else {
            this.urlBuilder.c(str, str2);
        }
    }

    public <T> void addTag(Class<T> cls, T t) {
        this.requestBuilder.j(cls, t);
    }

    public yc4.a get() {
        rc4 rc4VarF;
        rc4.a aVar = this.urlBuilder;
        if (aVar != null) {
            rc4VarF = aVar.d();
        } else {
            rc4VarF = this.baseUrl.F(this.relativeUrl);
            if (rc4VarF == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
        }
        zc4 contentTypeOverridingRequestBody = this.body;
        if (contentTypeOverridingRequestBody == null) {
            oc4.a aVar2 = this.formBuilder;
            if (aVar2 != null) {
                contentTypeOverridingRequestBody = aVar2.c();
            } else {
                uc4.a aVar3 = this.multipartBuilder;
                if (aVar3 != null) {
                    contentTypeOverridingRequestBody = aVar3.e();
                } else if (this.hasBody) {
                    contentTypeOverridingRequestBody = zc4.create((tc4) null, new byte[0]);
                }
            }
        }
        tc4 tc4Var = this.contentType;
        if (tc4Var != null) {
            if (contentTypeOverridingRequestBody != null) {
                contentTypeOverridingRequestBody = new ContentTypeOverridingRequestBody(contentTypeOverridingRequestBody, tc4Var);
            } else {
                this.headersBuilder.a("Content-Type", tc4Var.toString());
            }
        }
        yc4.a aVar4 = this.requestBuilder;
        aVar4.l(rc4VarF);
        aVar4.f(this.headersBuilder.f());
        aVar4.g(this.method, contentTypeOverridingRequestBody);
        return aVar4;
    }

    public void setBody(zc4 zc4Var) {
        this.body = zc4Var;
    }

    public void setRelativeUrl(Object obj) {
        this.relativeUrl = obj.toString();
    }

    public void addPart(uc4.b bVar) {
        this.multipartBuilder.d(bVar);
    }

    private static void canonicalizeForPath(nd4 nd4Var, String str, int i, int i2, boolean z) {
        nd4 nd4Var2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt >= 32 && iCodePointAt < 127 && PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(iCodePointAt) == -1 && (z || (iCodePointAt != 47 && iCodePointAt != 37))) {
                    nd4Var.w0(iCodePointAt);
                } else {
                    if (nd4Var2 == null) {
                        nd4Var2 = new nd4();
                    }
                    nd4Var2.w0(iCodePointAt);
                    while (!nd4Var2.N()) {
                        int i3 = nd4Var2.readByte() & 255;
                        nd4Var.m0(37);
                        char[] cArr = HEX_DIGITS;
                        nd4Var.m0(cArr[(i3 >> 4) & 15]);
                        nd4Var.m0(cArr[i3 & 15]);
                    }
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }
}
