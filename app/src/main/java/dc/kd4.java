package dc;

import com.google.common.net.HttpHeaders;
import dc.sc4;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* compiled from: HttpLoggingInterceptor.java */
/* loaded from: classes5.dex */
public final class kd4 implements sc4 {
    public static final Charset c = Charset.forName("UTF-8");
    public final b a;
    public volatile a b = a.NONE;

    /* compiled from: HttpLoggingInterceptor.java */
    public enum a {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* compiled from: HttpLoggingInterceptor.java */
    public interface b {
        void log(String str);
    }

    public kd4(b bVar) {
        this.a = bVar;
    }

    public static boolean b(nd4 nd4Var) {
        try {
            nd4 nd4Var2 = new nd4();
            nd4Var.m(nd4Var2, 0L, nd4Var.f0() < 64 ? nd4Var.f0() : 64L);
            for (int i = 0; i < 16; i++) {
                if (nd4Var2.N()) {
                    return true;
                }
                int iB0 = nd4Var2.b0();
                if (Character.isISOControl(iB0) && !Character.isWhitespace(iB0)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public final boolean a(qc4 qc4Var) {
        String strC = qc4Var.c(HttpHeaders.CONTENT_ENCODING);
        return (strC == null || strC.equalsIgnoreCase("identity") || strC.equalsIgnoreCase("gzip")) ? false : true;
    }

    public kd4 c(a aVar) {
        Objects.requireNonNull(aVar, "level == null. Use Level.NONE instead.");
        this.b = aVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v29, types: [java.lang.Long] */
    @Override // dc.sc4
    public ad4 intercept(sc4.a aVar) throws Exception {
        boolean z;
        long j;
        char c2;
        String string;
        boolean z2;
        a aVar2 = this.b;
        yc4 yc4VarRequest = aVar.request();
        if (aVar2 == a.NONE) {
            return aVar.proceed(yc4VarRequest);
        }
        boolean z3 = aVar2 == a.BODY;
        boolean z4 = z3 || aVar2 == a.HEADERS;
        zc4 zc4VarA = yc4VarRequest.a();
        boolean z5 = zc4VarA != null;
        fc4 fc4VarConnection = aVar.connection();
        StringBuilder sb = new StringBuilder();
        sb.append("--> ");
        sb.append(yc4VarRequest.g());
        sb.append(' ');
        sb.append(yc4VarRequest.j());
        sb.append(fc4VarConnection != null ? " " + fc4VarConnection.protocol() : "");
        String string2 = sb.toString();
        if (!z4 && z5) {
            string2 = string2 + " (" + zc4VarA.contentLength() + "-byte body)";
        }
        this.a.log(string2);
        if (z4) {
            if (z5) {
                if (zc4VarA.contentType() != null) {
                    this.a.log("Content-Type: " + zc4VarA.contentType());
                }
                if (zc4VarA.contentLength() != -1) {
                    this.a.log("Content-Length: " + zc4VarA.contentLength());
                }
            }
            qc4 qc4VarE = yc4VarRequest.e();
            int iH = qc4VarE.h();
            int i = 0;
            while (i < iH) {
                String strE = qc4VarE.e(i);
                int i2 = iH;
                if ("Content-Type".equalsIgnoreCase(strE) || HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(strE)) {
                    z2 = z4;
                } else {
                    z2 = z4;
                    this.a.log(strE + ": " + qc4VarE.j(i));
                }
                i++;
                iH = i2;
                z4 = z2;
            }
            z = z4;
            if (!z3 || !z5) {
                this.a.log("--> END " + yc4VarRequest.g());
            } else if (a(yc4VarRequest.e())) {
                this.a.log("--> END " + yc4VarRequest.g() + " (encoded body omitted)");
            } else {
                nd4 nd4Var = new nd4();
                zc4VarA.writeTo(nd4Var);
                Charset charsetB = c;
                tc4 tc4VarContentType = zc4VarA.contentType();
                if (tc4VarContentType != null) {
                    charsetB = tc4VarContentType.b(charsetB);
                }
                this.a.log("");
                if (b(nd4Var)) {
                    this.a.log(nd4Var.Q(charsetB));
                    this.a.log("--> END " + yc4VarRequest.g() + " (" + zc4VarA.contentLength() + "-byte body)");
                } else {
                    this.a.log("--> END " + yc4VarRequest.g() + " (binary " + zc4VarA.contentLength() + "-byte body omitted)");
                }
            }
        } else {
            z = z4;
        }
        long jNanoTime = System.nanoTime();
        try {
            ad4 ad4VarProceed = aVar.proceed(yc4VarRequest);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
            bd4 bd4VarB = ad4VarProceed.b();
            long jContentLength = bd4VarB.contentLength();
            String str = jContentLength != -1 ? jContentLength + "-byte" : "unknown-length";
            b bVar = this.a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("<-- ");
            sb2.append(ad4VarProceed.f());
            if (ad4VarProceed.x().isEmpty()) {
                j = jContentLength;
                string = "";
                c2 = ' ';
            } else {
                StringBuilder sb3 = new StringBuilder();
                j = jContentLength;
                c2 = ' ';
                sb3.append(' ');
                sb3.append(ad4VarProceed.x());
                string = sb3.toString();
            }
            sb2.append(string);
            sb2.append(c2);
            sb2.append(ad4VarProceed.L().j());
            sb2.append(" (");
            sb2.append(millis);
            sb2.append("ms");
            sb2.append(z ? "" : ", " + str + " body");
            sb2.append(')');
            bVar.log(sb2.toString());
            if (z) {
                qc4 qc4VarQ = ad4VarProceed.q();
                int iH2 = qc4VarQ.h();
                for (int i3 = 0; i3 < iH2; i3++) {
                    this.a.log(qc4VarQ.e(i3) + ": " + qc4VarQ.j(i3));
                }
                if (!z3 || !okhttp3.internal.http.HttpHeaders.hasBody(ad4VarProceed)) {
                    this.a.log("<-- END HTTP");
                } else if (a(ad4VarProceed.q())) {
                    this.a.log("<-- END HTTP (encoded body omitted)");
                } else {
                    pd4 pd4VarSource = bd4VarB.source();
                    pd4VarSource.request(Long.MAX_VALUE);
                    nd4 nd4VarA = pd4VarSource.a();
                    ud4 ud4Var = null;
                    if ("gzip".equalsIgnoreCase(qc4VarQ.c(HttpHeaders.CONTENT_ENCODING))) {
                        ?? ValueOf = Long.valueOf(nd4VarA.f0());
                        try {
                            ud4 ud4Var2 = new ud4(nd4VarA.clone());
                            try {
                                nd4VarA = new nd4();
                                nd4VarA.w(ud4Var2);
                                ud4Var2.close();
                                ud4Var = ValueOf;
                            } catch (Throwable th) {
                                th = th;
                                ud4Var = ud4Var2;
                                if (ud4Var != null) {
                                    ud4Var.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    Charset charsetB2 = c;
                    tc4 tc4VarContentType2 = bd4VarB.contentType();
                    if (tc4VarContentType2 != null) {
                        charsetB2 = tc4VarContentType2.b(charsetB2);
                    }
                    if (!b(nd4VarA)) {
                        this.a.log("");
                        this.a.log("<-- END HTTP (binary " + nd4VarA.f0() + "-byte body omitted)");
                        return ad4VarProceed;
                    }
                    if (j != 0) {
                        this.a.log("");
                        this.a.log(nd4VarA.clone().Q(charsetB2));
                    }
                    if (ud4Var != null) {
                        this.a.log("<-- END HTTP (" + nd4VarA.f0() + "-byte, " + ud4Var + "-gzipped-byte body)");
                    } else {
                        this.a.log("<-- END HTTP (" + nd4VarA.f0() + "-byte body)");
                    }
                }
            }
            return ad4VarProceed;
        } catch (Exception e) {
            this.a.log("<-- HTTP FAILED: " + e);
            throw e;
        }
    }
}
