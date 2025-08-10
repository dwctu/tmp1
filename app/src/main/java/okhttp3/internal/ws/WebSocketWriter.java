package okhttp3.internal.ws;

import android.support.v4.media.session.PlaybackStateCompat;
import dc.ee4;
import dc.ge4;
import dc.nd4;
import dc.od4;
import dc.qd4;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

/* loaded from: classes5.dex */
public final class WebSocketWriter {
    public boolean activeWriter;
    public final nd4 buffer = new nd4();
    public final FrameSink frameSink = new FrameSink();
    public final boolean isClient;
    private final nd4.c maskCursor;
    private final byte[] maskKey;
    public final Random random;
    public final od4 sink;
    public final nd4 sinkBuffer;
    public boolean writerClosed;

    public final class FrameSink implements ee4 {
        public boolean closed;
        public long contentLength;
        public int formatOpcode;
        public boolean isFirstFrame;

        public FrameSink() {
        }

        @Override // dc.ee4, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            WebSocketWriter webSocketWriter = WebSocketWriter.this;
            webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.f0(), this.isFirstFrame, true);
            this.closed = true;
            WebSocketWriter.this.activeWriter = false;
        }

        @Override // dc.ee4, java.io.Flushable
        public void flush() throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            WebSocketWriter webSocketWriter = WebSocketWriter.this;
            webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.f0(), this.isFirstFrame, false);
            this.isFirstFrame = false;
        }

        @Override // dc.ee4
        public ge4 timeout() {
            return WebSocketWriter.this.sink.timeout();
        }

        @Override // dc.ee4
        public void write(nd4 nd4Var, long j) throws IOException {
            if (this.closed) {
                throw new IOException("closed");
            }
            WebSocketWriter.this.buffer.write(nd4Var, j);
            boolean z = this.isFirstFrame && this.contentLength != -1 && WebSocketWriter.this.buffer.f0() > this.contentLength - PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            long jF = WebSocketWriter.this.buffer.f();
            if (jF <= 0 || z) {
                return;
            }
            WebSocketWriter.this.writeMessageFrame(this.formatOpcode, jF, this.isFirstFrame, false);
            this.isFirstFrame = false;
        }
    }

    public WebSocketWriter(boolean z, od4 od4Var, Random random) {
        Objects.requireNonNull(od4Var, "sink == null");
        Objects.requireNonNull(random, "random == null");
        this.isClient = z;
        this.sink = od4Var;
        this.sinkBuffer = od4Var.a();
        this.random = random;
        this.maskKey = z ? new byte[4] : null;
        this.maskCursor = z ? new nd4.c() : null;
    }

    private void writeControlFrame(int i, qd4 qd4Var) throws IOException {
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        int iS = qd4Var.s();
        if (iS > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.sinkBuffer.m0(i | 128);
        if (this.isClient) {
            this.sinkBuffer.m0(iS | 128);
            this.random.nextBytes(this.maskKey);
            this.sinkBuffer.k0(this.maskKey);
            if (iS > 0) {
                long jF0 = this.sinkBuffer.f0();
                this.sinkBuffer.j0(qd4Var);
                this.sinkBuffer.K(this.maskCursor);
                this.maskCursor.e(jF0);
                WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.m0(iS);
            this.sinkBuffer.j0(qd4Var);
        }
        this.sink.flush();
    }

    public ee4 newMessageSink(int i, long j) {
        if (this.activeWriter) {
            throw new IllegalStateException("Another message writer is active. Did you call close()?");
        }
        this.activeWriter = true;
        FrameSink frameSink = this.frameSink;
        frameSink.formatOpcode = i;
        frameSink.contentLength = j;
        frameSink.isFirstFrame = true;
        frameSink.closed = false;
        return frameSink;
    }

    public void writeClose(int i, qd4 qd4Var) throws IOException {
        qd4 qd4VarL = qd4.d;
        if (i != 0 || qd4Var != null) {
            if (i != 0) {
                WebSocketProtocol.validateCloseCode(i);
            }
            nd4 nd4Var = new nd4();
            nd4Var.r0(i);
            if (qd4Var != null) {
                nd4Var.j0(qd4Var);
            }
            qd4VarL = nd4Var.L();
        }
        try {
            writeControlFrame(8, qd4VarL);
        } finally {
            this.writerClosed = true;
        }
    }

    public void writeMessageFrame(int i, long j, boolean z, boolean z2) throws IOException {
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        if (!z) {
            i = 0;
        }
        if (z2) {
            i |= 128;
        }
        this.sinkBuffer.m0(i);
        int i2 = this.isClient ? 128 : 0;
        if (j <= 125) {
            this.sinkBuffer.m0(((int) j) | i2);
        } else if (j <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            this.sinkBuffer.m0(i2 | 126);
            this.sinkBuffer.r0((int) j);
        } else {
            this.sinkBuffer.m0(i2 | 127);
            this.sinkBuffer.q0(j);
        }
        if (this.isClient) {
            this.random.nextBytes(this.maskKey);
            this.sinkBuffer.k0(this.maskKey);
            if (j > 0) {
                long jF0 = this.sinkBuffer.f0();
                this.sinkBuffer.write(this.buffer, j);
                this.sinkBuffer.K(this.maskCursor);
                this.maskCursor.e(jF0);
                WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.write(this.buffer, j);
        }
        this.sink.d();
    }

    public void writePing(qd4 qd4Var) throws IOException {
        writeControlFrame(9, qd4Var);
    }

    public void writePong(qd4 qd4Var) throws IOException {
        writeControlFrame(10, qd4Var);
    }
}
