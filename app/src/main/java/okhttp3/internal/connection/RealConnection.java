package okhttp3.internal.connection;

import com.google.common.net.HttpHeaders;
import dc.ac4;
import dc.ad4;
import dc.cc4;
import dc.cd4;
import dc.fc4;
import dc.ge4;
import dc.hc4;
import dc.nc4;
import dc.od4;
import dc.pc4;
import dc.pd4;
import dc.rc4;
import dc.sc4;
import dc.vb4;
import dc.vc4;
import dc.wc4;
import dc.wd4;
import dc.yc4;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes5.dex */
public final class RealConnection extends Http2Connection.Listener implements fc4 {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    public final RealConnectionPool connectionPool;
    private pc4 handshake;
    private Http2Connection http2Connection;
    public boolean noNewExchanges;
    private wc4 protocol;
    private Socket rawSocket;
    private int refusedStreamCount;
    private final cd4 route;
    public int routeFailureCount;
    private od4 sink;
    private Socket socket;
    private pd4 source;
    public int successCount;
    private int allocationLimit = 1;
    public final List<Reference<Transmitter>> transmitters = new ArrayList();
    public long idleAtNanos = Long.MAX_VALUE;

    public RealConnection(RealConnectionPool realConnectionPool, cd4 cd4Var) {
        this.connectionPool = realConnectionPool;
        this.route = cd4Var;
    }

    private void connectSocket(int i, int i2, ac4 ac4Var, nc4 nc4Var) throws IOException {
        Proxy proxyB = this.route.b();
        this.rawSocket = (proxyB.type() == Proxy.Type.DIRECT || proxyB.type() == Proxy.Type.HTTP) ? this.route.a().j().createSocket() : new Socket(proxyB);
        nc4Var.f(ac4Var, this.route.d(), proxyB);
        this.rawSocket.setSoTimeout(i2);
        try {
            Platform.get().connectSocket(this.rawSocket, this.route.d(), i);
            try {
                this.source = wd4.d(wd4.m(this.rawSocket));
                this.sink = wd4.c(wd4.i(this.rawSocket));
            } catch (NullPointerException e) {
                if (NPE_THROW_WITH_NULL.equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.route.d());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void connectTls(ConnectionSpecSelector connectionSpecSelector) throws Throwable {
        vb4 vb4VarA = this.route.a();
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) vb4VarA.k().createSocket(this.rawSocket, vb4VarA.l().n(), vb4VarA.l().B(), true);
                try {
                    hc4 hc4VarConfigureSecureSocket = connectionSpecSelector.configureSecureSocket(sSLSocket2);
                    if (hc4VarConfigureSecureSocket.f()) {
                        Platform.get().configureTlsExtensions(sSLSocket2, vb4VarA.l().n(), vb4VarA.f());
                    }
                    sSLSocket2.startHandshake();
                    SSLSession session = sSLSocket2.getSession();
                    pc4 pc4VarB = pc4.b(session);
                    if (vb4VarA.e().verify(vb4VarA.l().n(), session)) {
                        vb4VarA.a().a(vb4VarA.l().n(), pc4VarB.f());
                        String selectedProtocol = hc4VarConfigureSecureSocket.f() ? Platform.get().getSelectedProtocol(sSLSocket2) : null;
                        this.socket = sSLSocket2;
                        this.source = wd4.d(wd4.m(sSLSocket2));
                        this.sink = wd4.c(wd4.i(this.socket));
                        this.handshake = pc4VarB;
                        this.protocol = selectedProtocol != null ? wc4.get(selectedProtocol) : wc4.HTTP_1_1;
                        if (sSLSocket2 != null) {
                            Platform.get().afterHandshake(sSLSocket2);
                            return;
                        }
                        return;
                    }
                    List<Certificate> listF = pc4VarB.f();
                    if (listF.isEmpty()) {
                        throw new SSLPeerUnverifiedException("Hostname " + vb4VarA.l().n() + " not verified (no certificates)");
                    }
                    X509Certificate x509Certificate = (X509Certificate) listF.get(0);
                    throw new SSLPeerUnverifiedException("Hostname " + vb4VarA.l().n() + " not verified:\n    certificate: " + cc4.c(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + OkHostnameVerifier.allSubjectAltNames(x509Certificate));
                } catch (AssertionError e) {
                    e = e;
                    if (!Util.isAndroidGetsocknameError(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        Platform.get().afterHandshake(sSLSocket);
                    }
                    Util.closeQuietly((Socket) sSLSocket);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (AssertionError e2) {
            e = e2;
        }
    }

    private void connectTunnel(int i, int i2, int i3, ac4 ac4Var, nc4 nc4Var) throws IOException {
        yc4 yc4VarCreateTunnelRequest = createTunnelRequest();
        rc4 rc4VarJ = yc4VarCreateTunnelRequest.j();
        for (int i4 = 0; i4 < 21; i4++) {
            connectSocket(i, i2, ac4Var, nc4Var);
            yc4VarCreateTunnelRequest = createTunnel(i2, i3, yc4VarCreateTunnelRequest, rc4VarJ);
            if (yc4VarCreateTunnelRequest == null) {
                return;
            }
            Util.closeQuietly(this.rawSocket);
            this.rawSocket = null;
            this.sink = null;
            this.source = null;
            nc4Var.d(ac4Var, this.route.d(), this.route.b(), null);
        }
    }

    private yc4 createTunnel(int i, int i2, yc4 yc4Var, rc4 rc4Var) throws IOException {
        String str = "CONNECT " + Util.hostHeader(rc4Var, true) + " HTTP/1.1";
        while (true) {
            Http1ExchangeCodec http1ExchangeCodec = new Http1ExchangeCodec(null, null, this.source, this.sink);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.source.timeout().timeout(i, timeUnit);
            this.sink.timeout().timeout(i2, timeUnit);
            http1ExchangeCodec.writeRequest(yc4Var.e(), str);
            http1ExchangeCodec.finishRequest();
            ad4.a responseHeaders = http1ExchangeCodec.readResponseHeaders(false);
            responseHeaders.q(yc4Var);
            ad4 ad4VarC = responseHeaders.c();
            http1ExchangeCodec.skipConnectBody(ad4VarC);
            int iF = ad4VarC.f();
            if (iF == 200) {
                if (this.source.h().N() && this.sink.a().N()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iF != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + ad4VarC.f());
            }
            yc4 yc4VarA = this.route.a().h().a(this.route, ad4VarC);
            if (yc4VarA == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if (Close.ELEMENT.equalsIgnoreCase(ad4VarC.m(HttpHeaders.CONNECTION))) {
                return yc4VarA;
            }
            yc4Var = yc4VarA;
        }
    }

    private yc4 createTunnelRequest() throws IOException {
        yc4.a aVar = new yc4.a();
        aVar.l(this.route.a().l());
        aVar.g("CONNECT", null);
        aVar.e(HttpHeaders.HOST, Util.hostHeader(this.route.a().l(), true));
        aVar.e("Proxy-Connection", "Keep-Alive");
        aVar.e("User-Agent", Version.userAgent());
        yc4 yc4VarB = aVar.b();
        ad4.a aVar2 = new ad4.a();
        aVar2.q(yc4VarB);
        aVar2.o(wc4.HTTP_1_1);
        aVar2.g(407);
        aVar2.l("Preemptive Authenticate");
        aVar2.b(Util.EMPTY_RESPONSE);
        aVar2.r(-1L);
        aVar2.p(-1L);
        aVar2.i(HttpHeaders.PROXY_AUTHENTICATE, "OkHttp-Preemptive");
        yc4 yc4VarA = this.route.a().h().a(this.route, aVar2.c());
        return yc4VarA != null ? yc4VarA : yc4VarB;
    }

    private void establishProtocol(ConnectionSpecSelector connectionSpecSelector, int i, ac4 ac4Var, nc4 nc4Var) throws Throwable {
        if (this.route.a().k() != null) {
            nc4Var.x(ac4Var);
            connectTls(connectionSpecSelector);
            nc4Var.w(ac4Var, this.handshake);
            if (this.protocol == wc4.HTTP_2) {
                startHttp2(i);
                return;
            }
            return;
        }
        List<wc4> listF = this.route.a().f();
        wc4 wc4Var = wc4.H2_PRIOR_KNOWLEDGE;
        if (!listF.contains(wc4Var)) {
            this.socket = this.rawSocket;
            this.protocol = wc4.HTTP_1_1;
        } else {
            this.socket = this.rawSocket;
            this.protocol = wc4Var;
            startHttp2(i);
        }
    }

    private boolean routeMatchesAny(List<cd4> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            cd4 cd4Var = list.get(i);
            if (cd4Var.b().type() == Proxy.Type.DIRECT && this.route.b().type() == Proxy.Type.DIRECT && this.route.d().equals(cd4Var.d())) {
                return true;
            }
        }
        return false;
    }

    private void startHttp2(int i) throws IOException {
        this.socket.setSoTimeout(0);
        Http2Connection http2ConnectionBuild = new Http2Connection.Builder(true).socket(this.socket, this.route.a().l().n(), this.source, this.sink).listener(this).pingIntervalMillis(i).build();
        this.http2Connection = http2ConnectionBuild;
        http2ConnectionBuild.start();
    }

    public static RealConnection testConnection(RealConnectionPool realConnectionPool, cd4 cd4Var, Socket socket, long j) {
        RealConnection realConnection = new RealConnection(realConnectionPool, cd4Var);
        realConnection.socket = socket;
        realConnection.idleAtNanos = j;
        return realConnection;
    }

    public void cancel() throws IOException {
        Util.closeQuietly(this.rawSocket);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f4 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0142 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void connect(int r17, int r18, int r19, int r20, boolean r21, dc.ac4 r22, dc.nc4 r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.connect(int, int, int, int, boolean, dc.ac4, dc.nc4):void");
    }

    public pc4 handshake() {
        return this.handshake;
    }

    public boolean isEligible(vb4 vb4Var, List<cd4> list) {
        if (this.transmitters.size() >= this.allocationLimit || this.noNewExchanges || !Internal.instance.equalsNonHost(this.route.a(), vb4Var)) {
            return false;
        }
        if (vb4Var.l().n().equals(route().a().l().n())) {
            return true;
        }
        if (this.http2Connection == null || list == null || !routeMatchesAny(list) || vb4Var.e() != OkHostnameVerifier.INSTANCE || !supportsUrl(vb4Var.l())) {
            return false;
        }
        try {
            vb4Var.a().a(vb4Var.l().n(), handshake().f());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean isHealthy(boolean z) throws SocketException {
        if (this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.http2Connection;
        if (http2Connection != null) {
            return http2Connection.isHealthy(System.nanoTime());
        }
        if (z) {
            try {
                int soTimeout = this.socket.getSoTimeout();
                try {
                    this.socket.setSoTimeout(1);
                    return !this.source.N();
                } finally {
                    this.socket.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    public boolean isMultiplexed() {
        return this.http2Connection != null;
    }

    public ExchangeCodec newCodec(vc4 vc4Var, sc4.a aVar) throws SocketException {
        if (this.http2Connection != null) {
            return new Http2ExchangeCodec(vc4Var, this, aVar, this.http2Connection);
        }
        this.socket.setSoTimeout(aVar.readTimeoutMillis());
        ge4 ge4VarTimeout = this.source.timeout();
        long timeoutMillis = aVar.readTimeoutMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        ge4VarTimeout.timeout(timeoutMillis, timeUnit);
        this.sink.timeout().timeout(aVar.writeTimeoutMillis(), timeUnit);
        return new Http1ExchangeCodec(vc4Var, this, this.source, this.sink);
    }

    public RealWebSocket.Streams newWebSocketStreams(final Exchange exchange) throws SocketException {
        this.socket.setSoTimeout(0);
        noNewExchanges();
        return new RealWebSocket.Streams(true, this.source, this.sink) { // from class: okhttp3.internal.connection.RealConnection.1
            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                exchange.bodyComplete(-1L, true, true, null);
            }
        };
    }

    public void noNewExchanges() {
        synchronized (this.connectionPool) {
            this.noNewExchanges = true;
        }
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onSettings(Http2Connection http2Connection) {
        synchronized (this.connectionPool) {
            this.allocationLimit = http2Connection.maxConcurrentStreams();
        }
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onStream(Http2Stream http2Stream) throws IOException {
        http2Stream.close(ErrorCode.REFUSED_STREAM, null);
    }

    @Override // dc.fc4
    public wc4 protocol() {
        return this.protocol;
    }

    public cd4 route() {
        return this.route;
    }

    public Socket socket() {
        return this.socket;
    }

    public boolean supportsUrl(rc4 rc4Var) {
        if (rc4Var.B() != this.route.a().l().B()) {
            return false;
        }
        if (rc4Var.n().equals(this.route.a().l().n())) {
            return true;
        }
        return this.handshake != null && OkHostnameVerifier.INSTANCE.verify(rc4Var.n(), (X509Certificate) this.handshake.f().get(0));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.route.a().l().n());
        sb.append(SignatureImpl.INNER_SEP);
        sb.append(this.route.a().l().B());
        sb.append(", proxy=");
        sb.append(this.route.b());
        sb.append(" hostAddress=");
        sb.append(this.route.d());
        sb.append(" cipherSuite=");
        pc4 pc4Var = this.handshake;
        sb.append(pc4Var != null ? pc4Var.a() : "none");
        sb.append(" protocol=");
        sb.append(this.protocol);
        sb.append(MessageFormatter.DELIM_STOP);
        return sb.toString();
    }

    public void trackFailure(IOException iOException) {
        synchronized (this.connectionPool) {
            if (iOException instanceof StreamResetException) {
                ErrorCode errorCode = ((StreamResetException) iOException).errorCode;
                if (errorCode == ErrorCode.REFUSED_STREAM) {
                    int i = this.refusedStreamCount + 1;
                    this.refusedStreamCount = i;
                    if (i > 1) {
                        this.noNewExchanges = true;
                        this.routeFailureCount++;
                    }
                } else if (errorCode != ErrorCode.CANCEL) {
                    this.noNewExchanges = true;
                    this.routeFailureCount++;
                }
            } else if (!isMultiplexed() || (iOException instanceof ConnectionShutdownException)) {
                this.noNewExchanges = true;
                if (this.successCount == 0) {
                    if (iOException != null) {
                        this.connectionPool.connectFailed(this.route, iOException);
                    }
                    this.routeFailureCount++;
                }
            }
        }
    }
}
