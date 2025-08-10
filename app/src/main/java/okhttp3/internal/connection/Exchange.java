package okhttp3.internal.connection;

import dc.ac4;
import dc.ad4;
import dc.bd4;
import dc.ee4;
import dc.fe4;
import dc.nc4;
import dc.nd4;
import dc.qc4;
import dc.rd4;
import dc.sd4;
import dc.wd4;
import dc.yc4;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketException;
import okhttp3.internal.Internal;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.ws.RealWebSocket;

/* loaded from: classes5.dex */
public final class Exchange {
    public final ac4 call;
    public final ExchangeCodec codec;
    private boolean duplex;
    public final nc4 eventListener;
    public final ExchangeFinder finder;
    public final Transmitter transmitter;

    public final class RequestBodySink extends rd4 {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private long contentLength;

        public RequestBodySink(ee4 ee4Var, long j) {
            super(ee4Var);
            this.contentLength = j;
        }

        private IOException complete(IOException iOException) {
            if (this.completed) {
                return iOException;
            }
            this.completed = true;
            return Exchange.this.bodyComplete(this.bytesReceived, false, true, iOException);
        }

        @Override // dc.rd4, dc.ee4, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            long j = this.contentLength;
            if (j != -1 && this.bytesReceived != j) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                complete(null);
            } catch (IOException e) {
                throw complete(e);
            }
        }

        @Override // dc.rd4, dc.ee4, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e) {
                throw complete(e);
            }
        }

        @Override // dc.rd4, dc.ee4
        public void write(nd4 nd4Var, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            long j2 = this.contentLength;
            if (j2 == -1 || this.bytesReceived + j <= j2) {
                try {
                    super.write(nd4Var, j);
                    this.bytesReceived += j;
                    return;
                } catch (IOException e) {
                    throw complete(e);
                }
            }
            throw new ProtocolException("expected " + this.contentLength + " bytes but received " + (this.bytesReceived + j));
        }
    }

    public final class ResponseBodySource extends sd4 {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;

        public ResponseBodySource(fe4 fe4Var, long j) {
            super(fe4Var);
            this.contentLength = j;
            if (j == 0) {
                complete(null);
            }
        }

        @Override // dc.sd4, dc.fe4, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            try {
                super.close();
                complete(null);
            } catch (IOException e) {
                throw complete(e);
            }
        }

        public IOException complete(IOException iOException) {
            if (this.completed) {
                return iOException;
            }
            this.completed = true;
            return Exchange.this.bodyComplete(this.bytesReceived, true, false, iOException);
        }

        @Override // dc.sd4, dc.fe4
        public long read(nd4 nd4Var, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            try {
                long j2 = delegate().read(nd4Var, j);
                if (j2 == -1) {
                    complete(null);
                    return -1L;
                }
                long j3 = this.bytesReceived + j2;
                long j4 = this.contentLength;
                if (j4 != -1 && j3 > j4) {
                    throw new ProtocolException("expected " + this.contentLength + " bytes but received " + j3);
                }
                this.bytesReceived = j3;
                if (j3 == j4) {
                    complete(null);
                }
                return j2;
            } catch (IOException e) {
                throw complete(e);
            }
        }
    }

    public Exchange(Transmitter transmitter, ac4 ac4Var, nc4 nc4Var, ExchangeFinder exchangeFinder, ExchangeCodec exchangeCodec) {
        this.transmitter = transmitter;
        this.call = ac4Var;
        this.eventListener = nc4Var;
        this.finder = exchangeFinder;
        this.codec = exchangeCodec;
    }

    public IOException bodyComplete(long j, boolean z, boolean z2, IOException iOException) {
        if (iOException != null) {
            trackFailure(iOException);
        }
        if (z2) {
            if (iOException != null) {
                this.eventListener.o(this.call, iOException);
            } else {
                this.eventListener.m(this.call, j);
            }
        }
        if (z) {
            if (iOException != null) {
                this.eventListener.t(this.call, iOException);
            } else {
                this.eventListener.r(this.call, j);
            }
        }
        return this.transmitter.exchangeMessageDone(this, z2, z, iOException);
    }

    public void cancel() {
        this.codec.cancel();
    }

    public RealConnection connection() {
        return this.codec.connection();
    }

    public ee4 createRequestBody(yc4 yc4Var, boolean z) throws IOException {
        this.duplex = z;
        long jContentLength = yc4Var.a().contentLength();
        this.eventListener.n(this.call);
        return new RequestBodySink(this.codec.createRequestBody(yc4Var, jContentLength), jContentLength);
    }

    public void detachWithViolence() {
        this.codec.cancel();
        this.transmitter.exchangeMessageDone(this, true, true, null);
    }

    public void finishRequest() throws IOException {
        try {
            this.codec.finishRequest();
        } catch (IOException e) {
            this.eventListener.o(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public void flushRequest() throws IOException {
        try {
            this.codec.flushRequest();
        } catch (IOException e) {
            this.eventListener.o(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public boolean isDuplex() {
        return this.duplex;
    }

    public RealWebSocket.Streams newWebSocketStreams() throws SocketException {
        this.transmitter.timeoutEarlyExit();
        return this.codec.connection().newWebSocketStreams(this);
    }

    public void noNewExchangesOnConnection() {
        this.codec.connection().noNewExchanges();
    }

    public void noRequestBody() {
        this.transmitter.exchangeMessageDone(this, true, false, null);
    }

    public bd4 openResponseBody(ad4 ad4Var) throws IOException {
        try {
            this.eventListener.s(this.call);
            String strM = ad4Var.m("Content-Type");
            long jReportedContentLength = this.codec.reportedContentLength(ad4Var);
            return new RealResponseBody(strM, jReportedContentLength, wd4.d(new ResponseBodySource(this.codec.openResponseBodySource(ad4Var), jReportedContentLength)));
        } catch (IOException e) {
            this.eventListener.t(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public ad4.a readResponseHeaders(boolean z) throws IOException {
        try {
            ad4.a responseHeaders = this.codec.readResponseHeaders(z);
            if (responseHeaders != null) {
                Internal.instance.initExchange(responseHeaders, this);
            }
            return responseHeaders;
        } catch (IOException e) {
            this.eventListener.t(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public void responseHeadersEnd(ad4 ad4Var) {
        this.eventListener.u(this.call, ad4Var);
    }

    public void responseHeadersStart() {
        this.eventListener.v(this.call);
    }

    public void timeoutEarlyExit() {
        this.transmitter.timeoutEarlyExit();
    }

    public void trackFailure(IOException iOException) {
        this.finder.trackFailure();
        this.codec.connection().trackFailure(iOException);
    }

    public qc4 trailers() throws IOException {
        return this.codec.trailers();
    }

    public void webSocketUpgradeFailed() {
        bodyComplete(-1L, true, true, null);
    }

    public void writeRequestHeaders(yc4 yc4Var) throws IOException {
        try {
            this.eventListener.q(this.call);
            this.codec.writeRequestHeaders(yc4Var);
            this.eventListener.p(this.call, yc4Var);
        } catch (IOException e) {
            this.eventListener.o(this.call, e);
            trackFailure(e);
            throw e;
        }
    }
}
