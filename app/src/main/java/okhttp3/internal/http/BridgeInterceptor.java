package okhttp3.internal.http;

import dc.ad4;
import dc.ic4;
import dc.jc4;
import dc.qc4;
import dc.sc4;
import dc.tc4;
import dc.ud4;
import dc.wd4;
import dc.yc4;
import dc.zc4;
import java.io.IOException;
import java.util.List;
import okhttp3.internal.Util;
import okhttp3.internal.Version;

/* loaded from: classes5.dex */
public final class BridgeInterceptor implements sc4 {
    private final jc4 cookieJar;

    public BridgeInterceptor(jc4 jc4Var) {
        this.cookieJar = jc4Var;
    }

    private String cookieHeader(List<ic4> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            ic4 ic4Var = list.get(i);
            sb.append(ic4Var.h());
            sb.append('=');
            sb.append(ic4Var.t());
        }
        return sb.toString();
    }

    @Override // dc.sc4
    public ad4 intercept(sc4.a aVar) throws IOException {
        yc4 yc4VarRequest = aVar.request();
        yc4.a aVarH = yc4VarRequest.h();
        zc4 zc4VarA = yc4VarRequest.a();
        if (zc4VarA != null) {
            tc4 tc4VarContentType = zc4VarA.contentType();
            if (tc4VarContentType != null) {
                aVarH.e("Content-Type", tc4VarContentType.toString());
            }
            long jContentLength = zc4VarA.contentLength();
            if (jContentLength != -1) {
                aVarH.e(com.google.common.net.HttpHeaders.CONTENT_LENGTH, Long.toString(jContentLength));
                aVarH.i(com.google.common.net.HttpHeaders.TRANSFER_ENCODING);
            } else {
                aVarH.e(com.google.common.net.HttpHeaders.TRANSFER_ENCODING, "chunked");
                aVarH.i(com.google.common.net.HttpHeaders.CONTENT_LENGTH);
            }
        }
        boolean z = false;
        if (yc4VarRequest.c(com.google.common.net.HttpHeaders.HOST) == null) {
            aVarH.e(com.google.common.net.HttpHeaders.HOST, Util.hostHeader(yc4VarRequest.j(), false));
        }
        if (yc4VarRequest.c(com.google.common.net.HttpHeaders.CONNECTION) == null) {
            aVarH.e(com.google.common.net.HttpHeaders.CONNECTION, "Keep-Alive");
        }
        if (yc4VarRequest.c(com.google.common.net.HttpHeaders.ACCEPT_ENCODING) == null && yc4VarRequest.c(com.google.common.net.HttpHeaders.RANGE) == null) {
            z = true;
            aVarH.e(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
        }
        List<ic4> listLoadForRequest = this.cookieJar.loadForRequest(yc4VarRequest.j());
        if (!listLoadForRequest.isEmpty()) {
            aVarH.e(com.google.common.net.HttpHeaders.COOKIE, cookieHeader(listLoadForRequest));
        }
        if (yc4VarRequest.c("User-Agent") == null) {
            aVarH.e("User-Agent", Version.userAgent());
        }
        ad4 ad4VarProceed = aVar.proceed(aVarH.b());
        HttpHeaders.receiveHeaders(this.cookieJar, yc4VarRequest.j(), ad4VarProceed.q());
        ad4.a aVarA = ad4VarProceed.A();
        aVarA.q(yc4VarRequest);
        if (z && "gzip".equalsIgnoreCase(ad4VarProceed.m(com.google.common.net.HttpHeaders.CONTENT_ENCODING)) && HttpHeaders.hasBody(ad4VarProceed)) {
            ud4 ud4Var = new ud4(ad4VarProceed.b().source());
            qc4.a aVarF = ad4VarProceed.q().f();
            aVarF.h(com.google.common.net.HttpHeaders.CONTENT_ENCODING);
            aVarF.h(com.google.common.net.HttpHeaders.CONTENT_LENGTH);
            aVarA.j(aVarF.f());
            aVarA.b(new RealResponseBody(ad4VarProceed.m("Content-Type"), -1L, wd4.d(ud4Var)));
        }
        return aVarA.c();
    }
}
