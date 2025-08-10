package okhttp3.internal.ws;

import dc.nd4;
import dc.pd4;
import dc.qd4;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public final class WebSocketReader {
    public boolean closed;
    public final FrameCallback frameCallback;
    public long frameLength;
    public final boolean isClient;
    public boolean isControlFrame;
    public boolean isFinalFrame;
    private final nd4.c maskCursor;
    private final byte[] maskKey;
    public int opcode;
    public final pd4 source;
    private final nd4 controlFrameBuffer = new nd4();
    private final nd4 messageFrameBuffer = new nd4();

    public interface FrameCallback {
        void onReadClose(int i, String str);

        void onReadMessage(qd4 qd4Var) throws IOException;

        void onReadMessage(String str) throws IOException;

        void onReadPing(qd4 qd4Var);

        void onReadPong(qd4 qd4Var);
    }

    public WebSocketReader(boolean z, pd4 pd4Var, FrameCallback frameCallback) {
        Objects.requireNonNull(pd4Var, "source == null");
        Objects.requireNonNull(frameCallback, "frameCallback == null");
        this.isClient = z;
        this.source = pd4Var;
        this.frameCallback = frameCallback;
        this.maskKey = z ? null : new byte[4];
        this.maskCursor = z ? null : new nd4.c();
    }

    private void readControlFrame() throws IOException {
        String strV;
        long j = this.frameLength;
        if (j > 0) {
            this.source.i(this.controlFrameBuffer, j);
            if (!this.isClient) {
                this.controlFrameBuffer.K(this.maskCursor);
                this.maskCursor.e(0L);
                WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                short s = 1005;
                long jF0 = this.controlFrameBuffer.f0();
                if (jF0 == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (jF0 != 0) {
                    s = this.controlFrameBuffer.readShort();
                    strV = this.controlFrameBuffer.V();
                    String strCloseCodeExceptionMessage = WebSocketProtocol.closeCodeExceptionMessage(s);
                    if (strCloseCodeExceptionMessage != null) {
                        throw new ProtocolException(strCloseCodeExceptionMessage);
                    }
                } else {
                    strV = "";
                }
                this.frameCallback.onReadClose(s, strV);
                this.closed = true;
                return;
            case 9:
                this.frameCallback.onReadPing(this.controlFrameBuffer.L());
                return;
            case 10:
                this.frameCallback.onReadPong(this.controlFrameBuffer.L());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.opcode));
        }
    }

    /* JADX WARN: Finally extract failed */
    private void readHeader() throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        long jTimeoutNanos = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        try {
            int i = this.source.readByte() & 255;
            this.source.timeout().timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            this.opcode = i & 15;
            boolean z = (i & 128) != 0;
            this.isFinalFrame = z;
            boolean z2 = (i & 8) != 0;
            this.isControlFrame = z2;
            if (z2 && !z) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z3 = (i & 64) != 0;
            boolean z4 = (i & 32) != 0;
            boolean z5 = (i & 16) != 0;
            if (z3 || z4 || z5) {
                throw new ProtocolException("Reserved flags are unsupported.");
            }
            int i2 = this.source.readByte() & 255;
            boolean z6 = (i2 & 128) != 0;
            if (z6 == this.isClient) {
                throw new ProtocolException(this.isClient ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j = i2 & 127;
            this.frameLength = j;
            if (j == 126) {
                this.frameLength = this.source.readShort() & WebSocketProtocol.PAYLOAD_SHORT_MAX;
            } else if (j == 127) {
                long j2 = this.source.readLong();
                this.frameLength = j2;
                if (j2 < 0) {
                    throw new ProtocolException("Frame length 0x" + Long.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.isControlFrame && this.frameLength > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z6) {
                this.source.readFully(this.maskKey);
            }
        } catch (Throwable th) {
            this.source.timeout().timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    private void readMessage() throws IOException {
        while (!this.closed) {
            long j = this.frameLength;
            if (j > 0) {
                this.source.i(this.messageFrameBuffer, j);
                if (!this.isClient) {
                    this.messageFrameBuffer.K(this.maskCursor);
                    this.maskCursor.e(this.messageFrameBuffer.f0() - this.frameLength);
                    WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            if (this.isFinalFrame) {
                return;
            }
            readUntilNonControlFrame();
            if (this.opcode != 0) {
                throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.opcode));
            }
        }
        throw new IOException("closed");
    }

    private void readMessageFrame() throws IOException {
        int i = this.opcode;
        if (i != 1 && i != 2) {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i));
        }
        readMessage();
        if (i == 1) {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.V());
        } else {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.L());
        }
    }

    private void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            readHeader();
            if (!this.isControlFrame) {
                return;
            } else {
                readControlFrame();
            }
        }
    }

    public void processNextFrame() throws IOException {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }
}
