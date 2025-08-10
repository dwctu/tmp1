package dc;

import com.broadcom.bt.util.mime4j.field.ContentTypeField;
import com.google.common.net.HttpHeaders;
import dc.qc4;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import kotlin.text.Typography;
import okhttp3.internal.Util;

/* compiled from: MultipartBody.java */
/* loaded from: classes5.dex */
public final class uc4 extends zc4 {
    public static final tc4 e = tc4.c("multipart/mixed");
    public static final tc4 f = tc4.c("multipart/alternative");
    public static final tc4 g;
    public static final byte[] h;
    public static final byte[] i;
    public static final byte[] j;
    public final qd4 a;
    public final tc4 b;
    public final List<b> c;
    public long d = -1;

    /* compiled from: MultipartBody.java */
    public static final class a {
        public final qd4 a;
        public tc4 b;
        public final List<b> c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a a(String str, String str2) {
            d(b.b(str, str2));
            return this;
        }

        public a b(String str, String str2, zc4 zc4Var) {
            d(b.c(str, str2, zc4Var));
            return this;
        }

        public a c(qc4 qc4Var, zc4 zc4Var) {
            d(b.a(qc4Var, zc4Var));
            return this;
        }

        public a d(b bVar) {
            Objects.requireNonNull(bVar, "part == null");
            this.c.add(bVar);
            return this;
        }

        public uc4 e() {
            if (this.c.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new uc4(this.a, this.b, this.c);
        }

        public a f(tc4 tc4Var) {
            Objects.requireNonNull(tc4Var, "type == null");
            if (tc4Var.f().equals("multipart")) {
                this.b = tc4Var;
                return this;
            }
            throw new IllegalArgumentException("multipart != " + tc4Var);
        }

        public a(String str) {
            this.b = uc4.e;
            this.c = new ArrayList();
            this.a = qd4.h(str);
        }
    }

    /* compiled from: MultipartBody.java */
    public static final class b {
        public final qc4 a;
        public final zc4 b;

        public b(qc4 qc4Var, zc4 zc4Var) {
            this.a = qc4Var;
            this.b = zc4Var;
        }

        public static b a(qc4 qc4Var, zc4 zc4Var) {
            Objects.requireNonNull(zc4Var, "body == null");
            if (qc4Var != null && qc4Var.c("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (qc4Var == null || qc4Var.c(HttpHeaders.CONTENT_LENGTH) == null) {
                return new b(qc4Var, zc4Var);
            }
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }

        public static b b(String str, String str2) {
            return c(str, null, zc4.create((tc4) null, str2));
        }

        public static b c(String str, String str2, zc4 zc4Var) {
            Objects.requireNonNull(str, "name == null");
            StringBuilder sb = new StringBuilder("form-data; name=");
            uc4.a(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                uc4.a(sb, str2);
            }
            qc4.a aVar = new qc4.a();
            aVar.e("Content-Disposition", sb.toString());
            return a(aVar.f(), zc4Var);
        }
    }

    static {
        tc4.c(ContentTypeField.TYPE_MULTIPART_DIGEST);
        tc4.c("multipart/parallel");
        g = tc4.c("multipart/form-data");
        h = new byte[]{58, 32};
        i = new byte[]{13, 10};
        j = new byte[]{45, 45};
    }

    public uc4(qd4 qd4Var, tc4 tc4Var, List<b> list) {
        this.a = qd4Var;
        this.b = tc4.c(tc4Var + "; boundary=" + qd4Var.x());
        this.c = Util.immutableList(list);
    }

    public static void a(StringBuilder sb, String str) {
        sb.append(Typography.quote);
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '\n') {
                sb.append("%0A");
            } else if (cCharAt == '\r') {
                sb.append("%0D");
            } else if (cCharAt != '\"') {
                sb.append(cCharAt);
            } else {
                sb.append("%22");
            }
        }
        sb.append(Typography.quote);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long b(od4 od4Var, boolean z) throws IOException {
        nd4 nd4Var;
        if (z) {
            od4Var = new nd4();
            nd4Var = od4Var;
        } else {
            nd4Var = 0;
        }
        int size = this.c.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.c.get(i2);
            qc4 qc4Var = bVar.a;
            zc4 zc4Var = bVar.b;
            od4Var.write(j);
            od4Var.U(this.a);
            od4Var.write(i);
            if (qc4Var != null) {
                int iH = qc4Var.h();
                for (int i3 = 0; i3 < iH; i3++) {
                    od4Var.s(qc4Var.e(i3)).write(h).s(qc4Var.j(i3)).write(i);
                }
            }
            tc4 tc4VarContentType = zc4Var.contentType();
            if (tc4VarContentType != null) {
                od4Var.s("Content-Type: ").s(tc4VarContentType.toString()).write(i);
            }
            long jContentLength = zc4Var.contentLength();
            if (jContentLength != -1) {
                od4Var.s("Content-Length: ").F(jContentLength).write(i);
            } else if (z) {
                nd4Var.b();
                return -1L;
            }
            byte[] bArr = i;
            od4Var.write(bArr);
            if (z) {
                j2 += jContentLength;
            } else {
                zc4Var.writeTo(od4Var);
            }
            od4Var.write(bArr);
        }
        byte[] bArr2 = j;
        od4Var.write(bArr2);
        od4Var.U(this.a);
        od4Var.write(bArr2);
        od4Var.write(i);
        if (!z) {
            return j2;
        }
        long jF0 = j2 + nd4Var.f0();
        nd4Var.b();
        return jF0;
    }

    @Override // dc.zc4
    public long contentLength() throws IOException {
        long j2 = this.d;
        if (j2 != -1) {
            return j2;
        }
        long jB = b(null, true);
        this.d = jB;
        return jB;
    }

    @Override // dc.zc4
    public tc4 contentType() {
        return this.b;
    }

    @Override // dc.zc4
    public void writeTo(od4 od4Var) throws IOException {
        b(od4Var, false);
    }
}
