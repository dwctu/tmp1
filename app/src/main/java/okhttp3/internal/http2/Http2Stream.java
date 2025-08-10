package okhttp3.internal.http2;

import dc.ee4;
import dc.fe4;
import dc.ge4;
import dc.ld4;
import dc.nd4;
import dc.pd4;
import dc.qc4;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import okhttp3.internal.Util;

/* loaded from: classes5.dex */
public final class Http2Stream {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public long bytesLeftInWriteWindow;
    public final Http2Connection connection;
    public ErrorCode errorCode;
    public IOException errorException;
    private boolean hasResponseHeaders;
    private final Deque<qc4> headersQueue;
    public final int id;
    public final StreamTimeout readTimeout;
    public final FramingSink sink;
    private final FramingSource source;
    public long unacknowledgedBytesRead = 0;
    public final StreamTimeout writeTimeout;

    public final class FramingSink implements ee4 {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long EMIT_BUFFER_SIZE = 16384;
        public boolean closed;
        public boolean finished;
        private final nd4 sendBuffer = new nd4();
        private qc4 trailers;

        public FramingSink() {
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void emitFrame(boolean r12) throws java.io.IOException {
            /*
                r11 = this;
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r0)
                okhttp3.internal.http2.Http2Stream r1 = okhttp3.internal.http2.Http2Stream.this     // Catch: java.lang.Throwable -> L80
                okhttp3.internal.http2.Http2Stream$StreamTimeout r1 = r1.writeTimeout     // Catch: java.lang.Throwable -> L80
                r1.enter()     // Catch: java.lang.Throwable -> L80
            La:
                okhttp3.internal.http2.Http2Stream r1 = okhttp3.internal.http2.Http2Stream.this     // Catch: java.lang.Throwable -> L77
                long r2 = r1.bytesLeftInWriteWindow     // Catch: java.lang.Throwable -> L77
                r4 = 0
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 > 0) goto L24
                boolean r2 = r11.finished     // Catch: java.lang.Throwable -> L77
                if (r2 != 0) goto L24
                boolean r2 = r11.closed     // Catch: java.lang.Throwable -> L77
                if (r2 != 0) goto L24
                okhttp3.internal.http2.ErrorCode r2 = r1.errorCode     // Catch: java.lang.Throwable -> L77
                if (r2 != 0) goto L24
                r1.waitForIo()     // Catch: java.lang.Throwable -> L77
                goto La
            L24:
                okhttp3.internal.http2.Http2Stream$StreamTimeout r1 = r1.writeTimeout     // Catch: java.lang.Throwable -> L80
                r1.exitAndThrowIfTimedOut()     // Catch: java.lang.Throwable -> L80
                okhttp3.internal.http2.Http2Stream r1 = okhttp3.internal.http2.Http2Stream.this     // Catch: java.lang.Throwable -> L80
                r1.checkOutNotClosed()     // Catch: java.lang.Throwable -> L80
                okhttp3.internal.http2.Http2Stream r1 = okhttp3.internal.http2.Http2Stream.this     // Catch: java.lang.Throwable -> L80
                long r1 = r1.bytesLeftInWriteWindow     // Catch: java.lang.Throwable -> L80
                dc.nd4 r3 = r11.sendBuffer     // Catch: java.lang.Throwable -> L80
                long r3 = r3.f0()     // Catch: java.lang.Throwable -> L80
                long r9 = java.lang.Math.min(r1, r3)     // Catch: java.lang.Throwable -> L80
                okhttp3.internal.http2.Http2Stream r1 = okhttp3.internal.http2.Http2Stream.this     // Catch: java.lang.Throwable -> L80
                long r2 = r1.bytesLeftInWriteWindow     // Catch: java.lang.Throwable -> L80
                long r2 = r2 - r9
                r1.bytesLeftInWriteWindow = r2     // Catch: java.lang.Throwable -> L80
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L80
                okhttp3.internal.http2.Http2Stream$StreamTimeout r0 = r1.writeTimeout
                r0.enter()
                if (r12 == 0) goto L5a
                dc.nd4 r12 = r11.sendBuffer     // Catch: java.lang.Throwable -> L58
                long r0 = r12.f0()     // Catch: java.lang.Throwable -> L58
                int r12 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r12 != 0) goto L5a
                r12 = 1
                r7 = 1
                goto L5c
            L58:
                r12 = move-exception
                goto L6f
            L5a:
                r12 = 0
                r7 = 0
            L5c:
                okhttp3.internal.http2.Http2Stream r12 = okhttp3.internal.http2.Http2Stream.this     // Catch: java.lang.Throwable -> L58
                okhttp3.internal.http2.Http2Connection r5 = r12.connection     // Catch: java.lang.Throwable -> L58
                int r6 = r12.id     // Catch: java.lang.Throwable -> L58
                dc.nd4 r8 = r11.sendBuffer     // Catch: java.lang.Throwable -> L58
                r5.writeData(r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L58
                okhttp3.internal.http2.Http2Stream r12 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Stream$StreamTimeout r12 = r12.writeTimeout
                r12.exitAndThrowIfTimedOut()
                return
            L6f:
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Stream$StreamTimeout r0 = r0.writeTimeout
                r0.exitAndThrowIfTimedOut()
                throw r12
            L77:
                r12 = move-exception
                okhttp3.internal.http2.Http2Stream r1 = okhttp3.internal.http2.Http2Stream.this     // Catch: java.lang.Throwable -> L80
                okhttp3.internal.http2.Http2Stream$StreamTimeout r1 = r1.writeTimeout     // Catch: java.lang.Throwable -> L80
                r1.exitAndThrowIfTimedOut()     // Catch: java.lang.Throwable -> L80
                throw r12     // Catch: java.lang.Throwable -> L80
            L80:
                r12 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L80
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.FramingSink.emitFrame(boolean):void");
        }

        @Override // dc.ee4, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (Http2Stream.this) {
                if (this.closed) {
                    return;
                }
                if (!Http2Stream.this.sink.finished) {
                    boolean z = this.sendBuffer.f0() > 0;
                    if (this.trailers != null) {
                        while (this.sendBuffer.f0() > 0) {
                            emitFrame(false);
                        }
                        Http2Stream http2Stream = Http2Stream.this;
                        http2Stream.connection.writeHeaders(http2Stream.id, true, Util.toHeaderBlock(this.trailers));
                    } else if (z) {
                        while (this.sendBuffer.f0() > 0) {
                            emitFrame(true);
                        }
                    } else {
                        Http2Stream http2Stream2 = Http2Stream.this;
                        http2Stream2.connection.writeData(http2Stream2.id, true, null, 0L);
                    }
                }
                synchronized (Http2Stream.this) {
                    this.closed = true;
                }
                Http2Stream.this.connection.flush();
                Http2Stream.this.cancelStreamIfNecessary();
            }
        }

        @Override // dc.ee4, java.io.Flushable
        public void flush() throws IOException {
            synchronized (Http2Stream.this) {
                Http2Stream.this.checkOutNotClosed();
            }
            while (this.sendBuffer.f0() > 0) {
                emitFrame(false);
                Http2Stream.this.connection.flush();
            }
        }

        @Override // dc.ee4
        public ge4 timeout() {
            return Http2Stream.this.writeTimeout;
        }

        @Override // dc.ee4
        public void write(nd4 nd4Var, long j) throws IOException {
            this.sendBuffer.write(nd4Var, j);
            while (this.sendBuffer.f0() >= 16384) {
                emitFrame(false);
            }
        }
    }

    public final class FramingSource implements fe4 {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        public boolean closed;
        public boolean finished;
        private final long maxByteCount;
        private qc4 trailers;
        private final nd4 receiveBuffer = new nd4();
        private final nd4 readBuffer = new nd4();

        public FramingSource(long j) {
            this.maxByteCount = j;
        }

        private void updateConnectionFlowControl(long j) {
            Http2Stream.this.connection.updateConnectionFlowControl(j);
        }

        @Override // dc.fe4, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() throws IOException {
            long jF0;
            synchronized (Http2Stream.this) {
                this.closed = true;
                jF0 = this.readBuffer.f0();
                this.readBuffer.b();
                Http2Stream.this.notifyAll();
            }
            if (jF0 > 0) {
                updateConnectionFlowControl(jF0);
            }
            Http2Stream.this.cancelStreamIfNecessary();
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0090  */
        @Override // dc.fe4
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long read(dc.nd4 r11, long r12) throws java.lang.Throwable {
            /*
                r10 = this;
                r0 = 0
                int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
                if (r2 < 0) goto La8
            L6:
                r2 = 0
                okhttp3.internal.http2.Http2Stream r3 = okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r3)
                okhttp3.internal.http2.Http2Stream r4 = okhttp3.internal.http2.Http2Stream.this     // Catch: java.lang.Throwable -> La5
                okhttp3.internal.http2.Http2Stream$StreamTimeout r4 = r4.readTimeout     // Catch: java.lang.Throwable -> La5
                r4.enter()     // Catch: java.lang.Throwable -> La5
                okhttp3.internal.http2.Http2Stream r4 = okhttp3.internal.http2.Http2Stream.this     // Catch: java.lang.Throwable -> L9c
                okhttp3.internal.http2.ErrorCode r5 = r4.errorCode     // Catch: java.lang.Throwable -> L9c
                if (r5 == 0) goto L25
                java.io.IOException r2 = r4.errorException     // Catch: java.lang.Throwable -> L9c
                if (r2 == 0) goto L1c
                goto L25
            L1c:
                okhttp3.internal.http2.StreamResetException r2 = new okhttp3.internal.http2.StreamResetException     // Catch: java.lang.Throwable -> L9c
                okhttp3.internal.http2.Http2Stream r4 = okhttp3.internal.http2.Http2Stream.this     // Catch: java.lang.Throwable -> L9c
                okhttp3.internal.http2.ErrorCode r4 = r4.errorCode     // Catch: java.lang.Throwable -> L9c
                r2.<init>(r4)     // Catch: java.lang.Throwable -> L9c
            L25:
                boolean r4 = r10.closed     // Catch: java.lang.Throwable -> L9c
                if (r4 != 0) goto L94
                dc.nd4 r4 = r10.readBuffer     // Catch: java.lang.Throwable -> L9c
                long r4 = r4.f0()     // Catch: java.lang.Throwable -> L9c
                r6 = -1
                int r8 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r8 <= 0) goto L6b
                dc.nd4 r4 = r10.readBuffer     // Catch: java.lang.Throwable -> L9c
                long r8 = r4.f0()     // Catch: java.lang.Throwable -> L9c
                long r12 = java.lang.Math.min(r12, r8)     // Catch: java.lang.Throwable -> L9c
                long r11 = r4.read(r11, r12)     // Catch: java.lang.Throwable -> L9c
                okhttp3.internal.http2.Http2Stream r13 = okhttp3.internal.http2.Http2Stream.this     // Catch: java.lang.Throwable -> L9c
                long r4 = r13.unacknowledgedBytesRead     // Catch: java.lang.Throwable -> L9c
                long r4 = r4 + r11
                r13.unacknowledgedBytesRead = r4     // Catch: java.lang.Throwable -> L9c
                if (r2 != 0) goto L80
                okhttp3.internal.http2.Http2Connection r13 = r13.connection     // Catch: java.lang.Throwable -> L9c
                okhttp3.internal.http2.Settings r13 = r13.okHttpSettings     // Catch: java.lang.Throwable -> L9c
                int r13 = r13.getInitialWindowSize()     // Catch: java.lang.Throwable -> L9c
                int r13 = r13 / 2
                long r8 = (long) r13     // Catch: java.lang.Throwable -> L9c
                int r13 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
                if (r13 < 0) goto L80
                okhttp3.internal.http2.Http2Stream r13 = okhttp3.internal.http2.Http2Stream.this     // Catch: java.lang.Throwable -> L9c
                okhttp3.internal.http2.Http2Connection r4 = r13.connection     // Catch: java.lang.Throwable -> L9c
                int r5 = r13.id     // Catch: java.lang.Throwable -> L9c
                long r8 = r13.unacknowledgedBytesRead     // Catch: java.lang.Throwable -> L9c
                r4.writeWindowUpdateLater(r5, r8)     // Catch: java.lang.Throwable -> L9c
                okhttp3.internal.http2.Http2Stream r13 = okhttp3.internal.http2.Http2Stream.this     // Catch: java.lang.Throwable -> L9c
                r13.unacknowledgedBytesRead = r0     // Catch: java.lang.Throwable -> L9c
                goto L80
            L6b:
                boolean r4 = r10.finished     // Catch: java.lang.Throwable -> L9c
                if (r4 != 0) goto L7f
                if (r2 != 0) goto L7f
                okhttp3.internal.http2.Http2Stream r2 = okhttp3.internal.http2.Http2Stream.this     // Catch: java.lang.Throwable -> L9c
                r2.waitForIo()     // Catch: java.lang.Throwable -> L9c
                okhttp3.internal.http2.Http2Stream r2 = okhttp3.internal.http2.Http2Stream.this     // Catch: java.lang.Throwable -> La5
                okhttp3.internal.http2.Http2Stream$StreamTimeout r2 = r2.readTimeout     // Catch: java.lang.Throwable -> La5
                r2.exitAndThrowIfTimedOut()     // Catch: java.lang.Throwable -> La5
                monitor-exit(r3)     // Catch: java.lang.Throwable -> La5
                goto L6
            L7f:
                r11 = r6
            L80:
                okhttp3.internal.http2.Http2Stream r13 = okhttp3.internal.http2.Http2Stream.this     // Catch: java.lang.Throwable -> La5
                okhttp3.internal.http2.Http2Stream$StreamTimeout r13 = r13.readTimeout     // Catch: java.lang.Throwable -> La5
                r13.exitAndThrowIfTimedOut()     // Catch: java.lang.Throwable -> La5
                monitor-exit(r3)     // Catch: java.lang.Throwable -> La5
                int r13 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r13 == 0) goto L90
                r10.updateConnectionFlowControl(r11)
                return r11
            L90:
                if (r2 != 0) goto L93
                return r6
            L93:
                throw r2
            L94:
                java.io.IOException r11 = new java.io.IOException     // Catch: java.lang.Throwable -> L9c
                java.lang.String r12 = "stream closed"
                r11.<init>(r12)     // Catch: java.lang.Throwable -> L9c
                throw r11     // Catch: java.lang.Throwable -> L9c
            L9c:
                r11 = move-exception
                okhttp3.internal.http2.Http2Stream r12 = okhttp3.internal.http2.Http2Stream.this     // Catch: java.lang.Throwable -> La5
                okhttp3.internal.http2.Http2Stream$StreamTimeout r12 = r12.readTimeout     // Catch: java.lang.Throwable -> La5
                r12.exitAndThrowIfTimedOut()     // Catch: java.lang.Throwable -> La5
                throw r11     // Catch: java.lang.Throwable -> La5
            La5:
                r11 = move-exception
                monitor-exit(r3)     // Catch: java.lang.Throwable -> La5
                throw r11
            La8:
                java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "byteCount < 0: "
                r0.append(r1)
                r0.append(r12)
                java.lang.String r12 = r0.toString()
                r11.<init>(r12)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.FramingSource.read(dc.nd4, long):long");
        }

        public void receive(pd4 pd4Var, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            long jF0;
            while (j > 0) {
                synchronized (Http2Stream.this) {
                    z = this.finished;
                    z2 = true;
                    z3 = this.readBuffer.f0() + j > this.maxByteCount;
                }
                if (z3) {
                    pd4Var.skip(j);
                    Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    pd4Var.skip(j);
                    return;
                }
                long j2 = pd4Var.read(this.receiveBuffer, j);
                if (j2 == -1) {
                    throw new EOFException();
                }
                j -= j2;
                synchronized (Http2Stream.this) {
                    if (this.closed) {
                        jF0 = this.receiveBuffer.f0();
                        this.receiveBuffer.b();
                    } else {
                        if (this.readBuffer.f0() != 0) {
                            z2 = false;
                        }
                        this.readBuffer.w(this.receiveBuffer);
                        if (z2) {
                            Http2Stream.this.notifyAll();
                        }
                        jF0 = 0;
                    }
                }
                if (jF0 > 0) {
                    updateConnectionFlowControl(jF0);
                }
            }
        }

        @Override // dc.fe4
        public ge4 timeout() {
            return Http2Stream.this.readTimeout;
        }
    }

    public class StreamTimeout extends ld4 {
        public StreamTimeout() {
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        @Override // dc.ld4
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // dc.ld4
        public void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
            Http2Stream.this.connection.sendDegradedPingLater();
        }
    }

    public Http2Stream(int i, Http2Connection http2Connection, boolean z, boolean z2, qc4 qc4Var) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.headersQueue = arrayDeque;
        this.readTimeout = new StreamTimeout();
        this.writeTimeout = new StreamTimeout();
        Objects.requireNonNull(http2Connection, "connection == null");
        this.id = i;
        this.connection = http2Connection;
        this.bytesLeftInWriteWindow = http2Connection.peerSettings.getInitialWindowSize();
        FramingSource framingSource = new FramingSource(http2Connection.okHttpSettings.getInitialWindowSize());
        this.source = framingSource;
        FramingSink framingSink = new FramingSink();
        this.sink = framingSink;
        framingSource.finished = z2;
        framingSink.finished = z;
        if (qc4Var != null) {
            arrayDeque.add(qc4Var);
        }
        if (isLocallyInitiated() && qc4Var != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!isLocallyInitiated() && qc4Var == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    private boolean closeInternal(ErrorCode errorCode, IOException iOException) {
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            if (this.source.finished && this.sink.finished) {
                return false;
            }
            this.errorCode = errorCode;
            this.errorException = iOException;
            notifyAll();
            this.connection.removeStream(this.id);
            return true;
        }
    }

    public void addBytesToWriteWindow(long j) {
        this.bytesLeftInWriteWindow += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void cancelStreamIfNecessary() throws java.io.IOException {
        /*
            r2 = this;
            monitor-enter(r2)
            okhttp3.internal.http2.Http2Stream$FramingSource r0 = r2.source     // Catch: java.lang.Throwable -> L30
            boolean r1 = r0.finished     // Catch: java.lang.Throwable -> L30
            if (r1 != 0) goto L17
            boolean r0 = r0.closed     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto L17
            okhttp3.internal.http2.Http2Stream$FramingSink r0 = r2.sink     // Catch: java.lang.Throwable -> L30
            boolean r1 = r0.finished     // Catch: java.lang.Throwable -> L30
            if (r1 != 0) goto L15
            boolean r0 = r0.closed     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto L17
        L15:
            r0 = 1
            goto L18
        L17:
            r0 = 0
        L18:
            boolean r1 = r2.isOpen()     // Catch: java.lang.Throwable -> L30
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto L26
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.CANCEL
            r1 = 0
            r2.close(r0, r1)
            goto L2f
        L26:
            if (r1 != 0) goto L2f
            okhttp3.internal.http2.Http2Connection r0 = r2.connection
            int r1 = r2.id
            r0.removeStream(r1)
        L2f:
            return
        L30:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L30
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.cancelStreamIfNecessary():void");
    }

    public void checkOutNotClosed() throws IOException {
        FramingSink framingSink = this.sink;
        if (framingSink.closed) {
            throw new IOException("stream closed");
        }
        if (framingSink.finished) {
            throw new IOException("stream finished");
        }
        if (this.errorCode != null) {
            IOException iOException = this.errorException;
            if (iOException == null) {
                throw new StreamResetException(this.errorCode);
            }
        }
    }

    public void close(ErrorCode errorCode, IOException iOException) throws IOException {
        if (closeInternal(errorCode, iOException)) {
            this.connection.writeSynReset(this.id, errorCode);
        }
    }

    public void closeLater(ErrorCode errorCode) {
        if (closeInternal(errorCode, null)) {
            this.connection.writeSynResetLater(this.id, errorCode);
        }
    }

    public void enqueueTrailers(qc4 qc4Var) {
        synchronized (this) {
            if (this.sink.finished) {
                throw new IllegalStateException("already finished");
            }
            if (qc4Var.h() == 0) {
                throw new IllegalArgumentException("trailers.size() == 0");
            }
            this.sink.trailers = qc4Var;
        }
    }

    public Http2Connection getConnection() {
        return this.connection;
    }

    public synchronized ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public int getId() {
        return this.id;
    }

    public ee4 getSink() {
        synchronized (this) {
            if (!this.hasResponseHeaders && !isLocallyInitiated()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.sink;
    }

    public fe4 getSource() {
        return this.source;
    }

    public boolean isLocallyInitiated() {
        return this.connection.client == ((this.id & 1) == 1);
    }

    public synchronized boolean isOpen() {
        if (this.errorCode != null) {
            return false;
        }
        FramingSource framingSource = this.source;
        if (framingSource.finished || framingSource.closed) {
            FramingSink framingSink = this.sink;
            if (framingSink.finished || framingSink.closed) {
                if (this.hasResponseHeaders) {
                    return false;
                }
            }
        }
        return true;
    }

    public ge4 readTimeout() {
        return this.readTimeout;
    }

    public void receiveData(pd4 pd4Var, int i) throws IOException {
        this.source.receive(pd4Var, i);
    }

    public void receiveHeaders(qc4 qc4Var, boolean z) {
        boolean zIsOpen;
        synchronized (this) {
            if (this.hasResponseHeaders && z) {
                this.source.trailers = qc4Var;
            } else {
                this.hasResponseHeaders = true;
                this.headersQueue.add(qc4Var);
            }
            if (z) {
                this.source.finished = true;
            }
            zIsOpen = isOpen();
            notifyAll();
        }
        if (zIsOpen) {
            return;
        }
        this.connection.removeStream(this.id);
    }

    public synchronized void receiveRstStream(ErrorCode errorCode) {
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            notifyAll();
        }
    }

    public synchronized qc4 takeHeaders() throws IOException {
        this.readTimeout.enter();
        while (this.headersQueue.isEmpty() && this.errorCode == null) {
            try {
                waitForIo();
            } catch (Throwable th) {
                this.readTimeout.exitAndThrowIfTimedOut();
                throw th;
            }
        }
        this.readTimeout.exitAndThrowIfTimedOut();
        if (this.headersQueue.isEmpty()) {
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            throw new StreamResetException(this.errorCode);
        }
        return this.headersQueue.removeFirst();
    }

    public synchronized qc4 trailers() throws IOException {
        if (this.errorCode != null) {
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            throw new StreamResetException(this.errorCode);
        }
        FramingSource framingSource = this.source;
        if (!framingSource.finished || !framingSource.receiveBuffer.N() || !this.source.readBuffer.N()) {
            throw new IllegalStateException("too early; can't read the trailers yet");
        }
        return this.source.trailers != null ? this.source.trailers : Util.EMPTY_HEADERS;
    }

    public void waitForIo() throws InterruptedException, InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public void writeHeaders(List<Header> list, boolean z, boolean z2) throws IOException {
        Objects.requireNonNull(list, "headers == null");
        synchronized (this) {
            this.hasResponseHeaders = true;
            if (z) {
                this.sink.finished = true;
            }
        }
        if (!z2) {
            synchronized (this.connection) {
                z2 = this.connection.bytesLeftInWriteWindow == 0;
            }
        }
        this.connection.writeHeaders(this.id, z, list);
        if (z2) {
            this.connection.flush();
        }
    }

    public ge4 writeTimeout() {
        return this.writeTimeout;
    }
}
