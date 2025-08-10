package okhttp3.internal.http1;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.os.EnvironmentCompat;
import dc.ad4;
import dc.ee4;
import dc.fe4;
import dc.ge4;
import dc.nd4;
import dc.od4;
import dc.pd4;
import dc.qc4;
import dc.rc4;
import dc.td4;
import dc.vc4;
import dc.yc4;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;

/* loaded from: classes5.dex */
public final class Http1ExchangeCodec implements ExchangeCodec {
    private static final int HEADER_LIMIT = 262144;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    private final vc4 client;
    private final RealConnection realConnection;
    private final od4 sink;
    private final pd4 source;
    private qc4 trailers;
    private int state = 0;
    private long headerLimit = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    public abstract class AbstractSource implements fe4 {
        public boolean closed;
        public final td4 timeout;

        private AbstractSource() {
            this.timeout = new td4(Http1ExchangeCodec.this.source.timeout());
        }

        @Override // dc.fe4, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
        public abstract /* synthetic */ void close() throws IOException;

        @Override // dc.fe4
        public long read(nd4 nd4Var, long j) throws IOException {
            try {
                return Http1ExchangeCodec.this.source.read(nd4Var, j);
            } catch (IOException e) {
                Http1ExchangeCodec.this.realConnection.noNewExchanges();
                responseBodyComplete();
                throw e;
            }
        }

        public final void responseBodyComplete() {
            if (Http1ExchangeCodec.this.state == 6) {
                return;
            }
            if (Http1ExchangeCodec.this.state == 5) {
                Http1ExchangeCodec.this.detachTimeout(this.timeout);
                Http1ExchangeCodec.this.state = 6;
            } else {
                throw new IllegalStateException("state: " + Http1ExchangeCodec.this.state);
            }
        }

        @Override // dc.fe4
        public ge4 timeout() {
            return this.timeout;
        }
    }

    public final class ChunkedSink implements ee4 {
        private boolean closed;
        private final td4 timeout;

        public ChunkedSink() {
            this.timeout = new td4(Http1ExchangeCodec.this.sink.timeout());
        }

        @Override // dc.ee4, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Http1ExchangeCodec.this.sink.s("0\r\n\r\n");
            Http1ExchangeCodec.this.detachTimeout(this.timeout);
            Http1ExchangeCodec.this.state = 3;
        }

        @Override // dc.ee4, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.closed) {
                return;
            }
            Http1ExchangeCodec.this.sink.flush();
        }

        @Override // dc.ee4
        public ge4 timeout() {
            return this.timeout;
        }

        @Override // dc.ee4
        public void write(nd4 nd4Var, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            Http1ExchangeCodec.this.sink.R(j);
            Http1ExchangeCodec.this.sink.s("\r\n");
            Http1ExchangeCodec.this.sink.write(nd4Var, j);
            Http1ExchangeCodec.this.sink.s("\r\n");
        }
    }

    public class ChunkedSource extends AbstractSource {
        private static final long NO_CHUNK_YET = -1;
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        private final rc4 url;

        public ChunkedSource(rc4 rc4Var) {
            super();
            this.bytesRemainingInChunk = -1L;
            this.hasMoreChunks = true;
            this.url = rc4Var;
        }

        private void readChunkSize() throws IOException {
            if (this.bytesRemainingInChunk != -1) {
                Http1ExchangeCodec.this.source.z();
            }
            try {
                this.bytesRemainingInChunk = Http1ExchangeCodec.this.source.Z();
                String strTrim = Http1ExchangeCodec.this.source.z().trim();
                if (this.bytesRemainingInChunk < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + strTrim + "\"");
                }
                if (this.bytesRemainingInChunk == 0) {
                    this.hasMoreChunks = false;
                    Http1ExchangeCodec http1ExchangeCodec = Http1ExchangeCodec.this;
                    http1ExchangeCodec.trailers = http1ExchangeCodec.readHeaders();
                    HttpHeaders.receiveHeaders(Http1ExchangeCodec.this.client.i(), this.url, Http1ExchangeCodec.this.trailers);
                    responseBodyComplete();
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, dc.fe4, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                Http1ExchangeCodec.this.realConnection.noNewExchanges();
                responseBodyComplete();
            }
            this.closed = true;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, dc.fe4
        public long read(nd4 nd4Var, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (!this.hasMoreChunks) {
                return -1L;
            }
            long j2 = this.bytesRemainingInChunk;
            if (j2 == 0 || j2 == -1) {
                readChunkSize();
                if (!this.hasMoreChunks) {
                    return -1L;
                }
            }
            long j3 = super.read(nd4Var, Math.min(j, this.bytesRemainingInChunk));
            if (j3 != -1) {
                this.bytesRemainingInChunk -= j3;
                return j3;
            }
            Http1ExchangeCodec.this.realConnection.noNewExchanges();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            responseBodyComplete();
            throw protocolException;
        }
    }

    public class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;

        public FixedLengthSource(long j) {
            super();
            this.bytesRemaining = j;
            if (j == 0) {
                responseBodyComplete();
            }
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, dc.fe4, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (this.bytesRemaining != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                Http1ExchangeCodec.this.realConnection.noNewExchanges();
                responseBodyComplete();
            }
            this.closed = true;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, dc.fe4
        public long read(nd4 nd4Var, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            long j2 = this.bytesRemaining;
            if (j2 == 0) {
                return -1L;
            }
            long j3 = super.read(nd4Var, Math.min(j2, j));
            if (j3 == -1) {
                Http1ExchangeCodec.this.realConnection.noNewExchanges();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                responseBodyComplete();
                throw protocolException;
            }
            long j4 = this.bytesRemaining - j3;
            this.bytesRemaining = j4;
            if (j4 == 0) {
                responseBodyComplete();
            }
            return j3;
        }
    }

    public final class KnownLengthSink implements ee4 {
        private boolean closed;
        private final td4 timeout;

        private KnownLengthSink() {
            this.timeout = new td4(Http1ExchangeCodec.this.sink.timeout());
        }

        @Override // dc.ee4, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Http1ExchangeCodec.this.detachTimeout(this.timeout);
            Http1ExchangeCodec.this.state = 3;
        }

        @Override // dc.ee4, java.io.Flushable
        public void flush() throws IOException {
            if (this.closed) {
                return;
            }
            Http1ExchangeCodec.this.sink.flush();
        }

        @Override // dc.ee4
        public ge4 timeout() {
            return this.timeout;
        }

        @Override // dc.ee4
        public void write(nd4 nd4Var, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            Util.checkOffsetAndCount(nd4Var.f0(), 0L, j);
            Http1ExchangeCodec.this.sink.write(nd4Var, j);
        }
    }

    public class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;

        private UnknownLengthSource() {
            super();
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, dc.fe4, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (!this.inputExhausted) {
                responseBodyComplete();
            }
            this.closed = true;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, dc.fe4
        public long read(nd4 nd4Var, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (this.inputExhausted) {
                return -1L;
            }
            long j2 = super.read(nd4Var, j);
            if (j2 != -1) {
                return j2;
            }
            this.inputExhausted = true;
            responseBodyComplete();
            return -1L;
        }
    }

    public Http1ExchangeCodec(vc4 vc4Var, RealConnection realConnection, pd4 pd4Var, od4 od4Var) {
        this.client = vc4Var;
        this.realConnection = realConnection;
        this.source = pd4Var;
        this.sink = od4Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void detachTimeout(td4 td4Var) {
        ge4 ge4VarA = td4Var.a();
        td4Var.b(ge4.NONE);
        ge4VarA.clearDeadline();
        ge4VarA.clearTimeout();
    }

    private ee4 newChunkedSink() {
        if (this.state == 1) {
            this.state = 2;
            return new ChunkedSink();
        }
        throw new IllegalStateException("state: " + this.state);
    }

    private fe4 newChunkedSource(rc4 rc4Var) {
        if (this.state == 4) {
            this.state = 5;
            return new ChunkedSource(rc4Var);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    private fe4 newFixedLengthSource(long j) {
        if (this.state == 4) {
            this.state = 5;
            return new FixedLengthSource(j);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    private ee4 newKnownLengthSink() {
        if (this.state == 1) {
            this.state = 2;
            return new KnownLengthSink();
        }
        throw new IllegalStateException("state: " + this.state);
    }

    private fe4 newUnknownLengthSource() {
        if (this.state == 4) {
            this.state = 5;
            this.realConnection.noNewExchanges();
            return new UnknownLengthSource();
        }
        throw new IllegalStateException("state: " + this.state);
    }

    private String readHeaderLine() throws IOException {
        String strN = this.source.n(this.headerLimit);
        this.headerLimit -= strN.length();
        return strN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public qc4 readHeaders() throws IOException {
        qc4.a aVar = new qc4.a();
        while (true) {
            String headerLine = readHeaderLine();
            if (headerLine.length() == 0) {
                return aVar.f();
            }
            Internal.instance.addLenient(aVar, headerLine);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() throws IOException {
        RealConnection realConnection = this.realConnection;
        if (realConnection != null) {
            realConnection.cancel();
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public RealConnection connection() {
        return this.realConnection;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public ee4 createRequestBody(yc4 yc4Var, long j) throws IOException {
        if (yc4Var.a() != null && yc4Var.a().isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if ("chunked".equalsIgnoreCase(yc4Var.c(com.google.common.net.HttpHeaders.TRANSFER_ENCODING))) {
            return newChunkedSink();
        }
        if (j != -1) {
            return newKnownLengthSink();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() throws IOException {
        this.sink.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() throws IOException {
        this.sink.flush();
    }

    public boolean isClosed() {
        return this.state == 6;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public fe4 openResponseBodySource(ad4 ad4Var) {
        if (!HttpHeaders.hasBody(ad4Var)) {
            return newFixedLengthSource(0L);
        }
        if ("chunked".equalsIgnoreCase(ad4Var.m(com.google.common.net.HttpHeaders.TRANSFER_ENCODING))) {
            return newChunkedSource(ad4Var.L().j());
        }
        long jContentLength = HttpHeaders.contentLength(ad4Var);
        return jContentLength != -1 ? newFixedLengthSource(jContentLength) : newUnknownLengthSource();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public ad4.a readResponseHeaders(boolean z) throws IOException {
        int i = this.state;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.state);
        }
        try {
            StatusLine statusLine = StatusLine.parse(readHeaderLine());
            ad4.a aVar = new ad4.a();
            aVar.o(statusLine.protocol);
            aVar.g(statusLine.code);
            aVar.l(statusLine.message);
            aVar.j(readHeaders());
            if (z && statusLine.code == 100) {
                return null;
            }
            if (statusLine.code == 100) {
                this.state = 3;
                return aVar;
            }
            this.state = 4;
            return aVar;
        } catch (EOFException e) {
            RealConnection realConnection = this.realConnection;
            throw new IOException("unexpected end of stream on " + (realConnection != null ? realConnection.route().a().l().E() : EnvironmentCompat.MEDIA_UNKNOWN), e);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(ad4 ad4Var) {
        if (!HttpHeaders.hasBody(ad4Var)) {
            return 0L;
        }
        if ("chunked".equalsIgnoreCase(ad4Var.m(com.google.common.net.HttpHeaders.TRANSFER_ENCODING))) {
            return -1L;
        }
        return HttpHeaders.contentLength(ad4Var);
    }

    public void skipConnectBody(ad4 ad4Var) throws IOException {
        long jContentLength = HttpHeaders.contentLength(ad4Var);
        if (jContentLength == -1) {
            return;
        }
        fe4 fe4VarNewFixedLengthSource = newFixedLengthSource(jContentLength);
        Util.skipAll(fe4VarNewFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        fe4VarNewFixedLengthSource.close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public qc4 trailers() {
        if (this.state != 6) {
            throw new IllegalStateException("too early; can't read the trailers yet");
        }
        qc4 qc4Var = this.trailers;
        return qc4Var != null ? qc4Var : Util.EMPTY_HEADERS;
    }

    public void writeRequest(qc4 qc4Var, String str) throws IOException {
        if (this.state != 0) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.sink.s(str).s("\r\n");
        int iH = qc4Var.h();
        for (int i = 0; i < iH; i++) {
            this.sink.s(qc4Var.e(i)).s(": ").s(qc4Var.j(i)).s("\r\n");
        }
        this.sink.s("\r\n");
        this.state = 1;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(yc4 yc4Var) throws IOException {
        writeRequest(yc4Var.e(), RequestLine.get(yc4Var, this.realConnection.route().b().type()));
    }
}
