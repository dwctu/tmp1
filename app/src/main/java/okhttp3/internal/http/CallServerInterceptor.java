package okhttp3.internal.http;

import dc.ad4;
import dc.od4;
import dc.sc4;
import dc.wd4;
import dc.yc4;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;

/* loaded from: classes5.dex */
public final class CallServerInterceptor implements sc4 {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z) {
        this.forWebSocket = z;
    }

    @Override // dc.sc4
    public ad4 intercept(sc4.a aVar) throws IOException {
        boolean z;
        ad4 ad4VarC;
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) aVar;
        Exchange exchange = realInterceptorChain.exchange();
        yc4 yc4VarRequest = realInterceptorChain.request();
        long jCurrentTimeMillis = System.currentTimeMillis();
        exchange.writeRequestHeaders(yc4VarRequest);
        ad4.a responseHeaders = null;
        if (!HttpMethod.permitsRequestBody(yc4VarRequest.g()) || yc4VarRequest.a() == null) {
            exchange.noRequestBody();
            z = false;
        } else {
            if ("100-continue".equalsIgnoreCase(yc4VarRequest.c(com.google.common.net.HttpHeaders.EXPECT))) {
                exchange.flushRequest();
                exchange.responseHeadersStart();
                responseHeaders = exchange.readResponseHeaders(true);
                z = true;
            } else {
                z = false;
            }
            if (responseHeaders != null) {
                exchange.noRequestBody();
                if (!exchange.connection().isMultiplexed()) {
                    exchange.noNewExchangesOnConnection();
                }
            } else if (yc4VarRequest.a().isDuplex()) {
                exchange.flushRequest();
                yc4VarRequest.a().writeTo(wd4.c(exchange.createRequestBody(yc4VarRequest, true)));
            } else {
                od4 od4VarC = wd4.c(exchange.createRequestBody(yc4VarRequest, false));
                yc4VarRequest.a().writeTo(od4VarC);
                od4VarC.close();
            }
        }
        if (yc4VarRequest.a() == null || !yc4VarRequest.a().isDuplex()) {
            exchange.finishRequest();
        }
        if (!z) {
            exchange.responseHeadersStart();
        }
        if (responseHeaders == null) {
            responseHeaders = exchange.readResponseHeaders(false);
        }
        responseHeaders.q(yc4VarRequest);
        responseHeaders.h(exchange.connection().handshake());
        responseHeaders.r(jCurrentTimeMillis);
        responseHeaders.p(System.currentTimeMillis());
        ad4 ad4VarC2 = responseHeaders.c();
        int iF = ad4VarC2.f();
        if (iF == 100) {
            ad4.a responseHeaders2 = exchange.readResponseHeaders(false);
            responseHeaders2.q(yc4VarRequest);
            responseHeaders2.h(exchange.connection().handshake());
            responseHeaders2.r(jCurrentTimeMillis);
            responseHeaders2.p(System.currentTimeMillis());
            ad4VarC2 = responseHeaders2.c();
            iF = ad4VarC2.f();
        }
        exchange.responseHeadersEnd(ad4VarC2);
        if (this.forWebSocket && iF == 101) {
            ad4.a aVarA = ad4VarC2.A();
            aVarA.b(Util.EMPTY_RESPONSE);
            ad4VarC = aVarA.c();
        } else {
            ad4.a aVarA2 = ad4VarC2.A();
            aVarA2.b(exchange.openResponseBody(ad4VarC2));
            ad4VarC = aVarA2.c();
        }
        if (Close.ELEMENT.equalsIgnoreCase(ad4VarC.L().c(com.google.common.net.HttpHeaders.CONNECTION)) || Close.ELEMENT.equalsIgnoreCase(ad4VarC.m(com.google.common.net.HttpHeaders.CONNECTION))) {
            exchange.noNewExchangesOnConnection();
        }
        if ((iF != 204 && iF != 205) || ad4VarC.b().contentLength() <= 0) {
            return ad4VarC;
        }
        throw new ProtocolException("HTTP " + iF + " had non-zero Content-Length: " + ad4VarC.b().contentLength());
    }
}
