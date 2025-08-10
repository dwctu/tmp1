package okhttp3.internal.http2;

import com.google.common.net.HttpHeaders;
import dc.ad4;
import dc.ee4;
import dc.fe4;
import dc.ge4;
import dc.qc4;
import dc.sc4;
import dc.vc4;
import dc.wc4;
import dc.yc4;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;

/* loaded from: classes5.dex */
public final class Http2ExchangeCodec implements ExchangeCodec {
    private volatile boolean canceled;
    private final sc4.a chain;
    private final Http2Connection connection;
    private final wc4 protocol;
    private final RealConnection realConnection;
    private volatile Http2Stream stream;
    private static final String CONNECTION = "connection";
    private static final String HOST = "host";
    private static final String KEEP_ALIVE = "keep-alive";
    private static final String PROXY_CONNECTION = "proxy-connection";
    private static final String TE = "te";
    private static final String TRANSFER_ENCODING = "transfer-encoding";
    private static final String ENCODING = "encoding";
    private static final String UPGRADE = "upgrade";
    private static final List<String> HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE, Header.TARGET_METHOD_UTF8, Header.TARGET_PATH_UTF8, Header.TARGET_SCHEME_UTF8, Header.TARGET_AUTHORITY_UTF8);
    private static final List<String> HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList(CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE);

    public Http2ExchangeCodec(vc4 vc4Var, RealConnection realConnection, sc4.a aVar, Http2Connection http2Connection) {
        this.realConnection = realConnection;
        this.chain = aVar;
        this.connection = http2Connection;
        List<wc4> listW = vc4Var.w();
        wc4 wc4Var = wc4.H2_PRIOR_KNOWLEDGE;
        this.protocol = listW.contains(wc4Var) ? wc4Var : wc4.HTTP_2;
    }

    public static List<Header> http2HeadersList(yc4 yc4Var) {
        qc4 qc4VarE = yc4Var.e();
        ArrayList arrayList = new ArrayList(qc4VarE.h() + 4);
        arrayList.add(new Header(Header.TARGET_METHOD, yc4Var.g()));
        arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(yc4Var.j())));
        String strC = yc4Var.c(HttpHeaders.HOST);
        if (strC != null) {
            arrayList.add(new Header(Header.TARGET_AUTHORITY, strC));
        }
        arrayList.add(new Header(Header.TARGET_SCHEME, yc4Var.j().G()));
        int iH = qc4VarE.h();
        for (int i = 0; i < iH; i++) {
            String lowerCase = qc4VarE.e(i).toLowerCase(Locale.US);
            if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(lowerCase) || (lowerCase.equals(TE) && qc4VarE.j(i).equals("trailers"))) {
                arrayList.add(new Header(lowerCase, qc4VarE.j(i)));
            }
        }
        return arrayList;
    }

    public static ad4.a readHttp2HeadersList(qc4 qc4Var, wc4 wc4Var) throws NumberFormatException, IOException {
        qc4.a aVar = new qc4.a();
        int iH = qc4Var.h();
        StatusLine statusLine = null;
        for (int i = 0; i < iH; i++) {
            String strE = qc4Var.e(i);
            String strJ = qc4Var.j(i);
            if (strE.equals(Header.RESPONSE_STATUS_UTF8)) {
                statusLine = StatusLine.parse("HTTP/1.1 " + strJ);
            } else if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(strE)) {
                Internal.instance.addLenient(aVar, strE, strJ);
            }
        }
        if (statusLine == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        ad4.a aVar2 = new ad4.a();
        aVar2.o(wc4Var);
        aVar2.g(statusLine.code);
        aVar2.l(statusLine.message);
        aVar2.j(aVar.f());
        return aVar2;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        this.canceled = true;
        if (this.stream != null) {
            this.stream.closeLater(ErrorCode.CANCEL);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public RealConnection connection() {
        return this.realConnection;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public ee4 createRequestBody(yc4 yc4Var, long j) {
        return this.stream.getSink();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() throws IOException {
        this.stream.getSink().close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() throws IOException {
        this.connection.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public fe4 openResponseBodySource(ad4 ad4Var) {
        return this.stream.getSource();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public ad4.a readResponseHeaders(boolean z) throws NumberFormatException, IOException {
        ad4.a http2HeadersList = readHttp2HeadersList(this.stream.takeHeaders(), this.protocol);
        if (z && Internal.instance.code(http2HeadersList) == 100) {
            return null;
        }
        return http2HeadersList;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(ad4 ad4Var) {
        return okhttp3.internal.http.HttpHeaders.contentLength(ad4Var);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public qc4 trailers() throws IOException {
        return this.stream.trailers();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(yc4 yc4Var) throws IOException {
        if (this.stream != null) {
            return;
        }
        this.stream = this.connection.newStream(http2HeadersList(yc4Var), yc4Var.a() != null);
        if (this.canceled) {
            this.stream.closeLater(ErrorCode.CANCEL);
            throw new IOException("Canceled");
        }
        ge4 timeout = this.stream.readTimeout();
        long timeoutMillis = this.chain.readTimeoutMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeout.timeout(timeoutMillis, timeUnit);
        this.stream.writeTimeout().timeout(this.chain.writeTimeoutMillis(), timeUnit);
    }
}
