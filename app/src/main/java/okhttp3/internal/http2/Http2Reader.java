package okhttp3.internal.http2;

import dc.fe4;
import dc.ge4;
import dc.nd4;
import dc.pd4;
import dc.qd4;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UShort;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;

/* loaded from: classes5.dex */
public final class Http2Reader implements Closeable {
    public static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private final ContinuationSource continuation;
    public final Hpack.Reader hpackReader;
    private final pd4 source;

    public static final class ContinuationSource implements fe4 {
        public byte flags;
        public int left;
        public int length;
        public short padding;
        private final pd4 source;
        public int streamId;

        public ContinuationSource(pd4 pd4Var) {
            this.source = pd4Var;
        }

        private void readContinuationHeader() throws IOException {
            int i = this.streamId;
            int medium = Http2Reader.readMedium(this.source);
            this.left = medium;
            this.length = medium;
            byte b = (byte) (this.source.readByte() & 255);
            this.flags = (byte) (this.source.readByte() & 255);
            Logger logger = Http2Reader.logger;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Http2.frameLog(true, this.streamId, this.length, b, this.flags));
            }
            int i2 = this.source.readInt() & Integer.MAX_VALUE;
            this.streamId = i2;
            if (b != 9) {
                throw Http2.ioException("%s != TYPE_CONTINUATION", Byte.valueOf(b));
            }
            if (i2 != i) {
                throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // dc.fe4, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() throws IOException {
        }

        @Override // dc.fe4
        public long read(nd4 nd4Var, long j) throws IOException {
            while (true) {
                int i = this.left;
                if (i != 0) {
                    long j2 = this.source.read(nd4Var, Math.min(j, i));
                    if (j2 == -1) {
                        return -1L;
                    }
                    this.left = (int) (this.left - j2);
                    return j2;
                }
                this.source.skip(this.padding);
                this.padding = (short) 0;
                if ((this.flags & 4) != 0) {
                    return -1L;
                }
                readContinuationHeader();
            }
        }

        @Override // dc.fe4
        public ge4 timeout() {
            return this.source.timeout();
        }
    }

    public interface Handler {
        void ackSettings();

        void alternateService(int i, String str, qd4 qd4Var, String str2, int i2, long j);

        void data(boolean z, int i, pd4 pd4Var, int i2) throws IOException;

        void goAway(int i, ErrorCode errorCode, qd4 qd4Var);

        void headers(boolean z, int i, int i2, List<Header> list);

        void ping(boolean z, int i, int i2);

        void priority(int i, int i2, int i3, boolean z);

        void pushPromise(int i, int i2, List<Header> list) throws IOException;

        void rstStream(int i, ErrorCode errorCode);

        void settings(boolean z, Settings settings);

        void windowUpdate(int i, long j);
    }

    public Http2Reader(pd4 pd4Var, boolean z) {
        this.source = pd4Var;
        this.client = z;
        ContinuationSource continuationSource = new ContinuationSource(pd4Var);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(4096, continuationSource);
    }

    public static int lengthWithoutPadding(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw Http2.ioException("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }

    private void readData(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        if ((b & 32) != 0) {
            throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short s = (b & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
        handler.data(z, i2, this.source, lengthWithoutPadding(i, b, s));
        this.source.skip(s);
    }

    private void readGoAway(Handler handler, int i, byte b, int i2) throws IOException {
        if (i < 8) {
            throw Http2.ioException("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int i3 = this.source.readInt();
        int i4 = this.source.readInt();
        int i5 = i - 8;
        ErrorCode errorCodeFromHttp2 = ErrorCode.fromHttp2(i4);
        if (errorCodeFromHttp2 == null) {
            throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i4));
        }
        qd4 qd4VarJ = qd4.d;
        if (i5 > 0) {
            qd4VarJ = this.source.J(i5);
        }
        handler.goAway(i3, errorCodeFromHttp2, qd4VarJ);
    }

    private List<Header> readHeaderBlock(int i, short s, byte b, int i2) throws IOException {
        ContinuationSource continuationSource = this.continuation;
        continuationSource.left = i;
        continuationSource.length = i;
        continuationSource.padding = s;
        continuationSource.flags = b;
        continuationSource.streamId = i2;
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private void readHeaders(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        short s = (b & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
        if ((b & 32) != 0) {
            readPriority(handler, i2);
            i -= 5;
        }
        handler.headers(z, i2, -1, readHeaderBlock(lengthWithoutPadding(i, b, s), s, b, i2));
    }

    public static int readMedium(pd4 pd4Var) throws IOException {
        return (pd4Var.readByte() & 255) | ((pd4Var.readByte() & 255) << 16) | ((pd4Var.readByte() & 255) << 8);
    }

    private void readPing(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 8) {
            throw Http2.ioException("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
        }
        handler.ping((b & 1) != 0, this.source.readInt(), this.source.readInt());
    }

    private void readPriority(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 5) {
            throw Http2.ioException("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        readPriority(handler, i2);
    }

    private void readPushPromise(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short s = (b & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
        handler.pushPromise(i2, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(lengthWithoutPadding(i - 4, b, s), s, b, i2));
    }

    private void readRstStream(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int i3 = this.source.readInt();
        ErrorCode errorCodeFromHttp2 = ErrorCode.fromHttp2(i3);
        if (errorCodeFromHttp2 == null) {
            throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i3));
        }
        handler.rstStream(i2, errorCodeFromHttp2);
    }

    private void readSettings(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            throw Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b & 1) != 0) {
            if (i != 0) {
                throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            handler.ackSettings();
            return;
        }
        if (i % 6 != 0) {
            throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
        Settings settings = new Settings();
        for (int i3 = 0; i3 < i; i3 += 6) {
            int i4 = this.source.readShort() & UShort.MAX_VALUE;
            int i5 = this.source.readInt();
            if (i4 == 2) {
                if (i5 != 0 && i5 != 1) {
                    throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
            } else if (i4 == 3) {
                i4 = 4;
            } else if (i4 == 4) {
                i4 = 7;
                if (i5 < 0) {
                    throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                }
            } else if (i4 == 5 && (i5 < 16384 || i5 > 16777215)) {
                throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i5));
            }
            settings.set(i4, i5);
        }
        handler.settings(false, settings);
    }

    private void readWindowUpdate(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long j = this.source.readInt() & 2147483647L;
        if (j == 0) {
            throw Http2.ioException("windowSizeIncrement was 0", Long.valueOf(j));
        }
        handler.windowUpdate(i2, j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }

    public boolean nextFrame(boolean z, Handler handler) throws IOException {
        try {
            this.source.E(9L);
            int medium = readMedium(this.source);
            if (medium < 0 || medium > 16384) {
                throw Http2.ioException("FRAME_SIZE_ERROR: %s", Integer.valueOf(medium));
            }
            byte b = (byte) (this.source.readByte() & 255);
            if (z && b != 4) {
                throw Http2.ioException("Expected a SETTINGS frame but was %s", Byte.valueOf(b));
            }
            byte b2 = (byte) (this.source.readByte() & 255);
            int i = this.source.readInt() & Integer.MAX_VALUE;
            Logger logger2 = logger;
            if (logger2.isLoggable(Level.FINE)) {
                logger2.fine(Http2.frameLog(true, i, medium, b, b2));
            }
            switch (b) {
                case 0:
                    readData(handler, medium, b2, i);
                    return true;
                case 1:
                    readHeaders(handler, medium, b2, i);
                    return true;
                case 2:
                    readPriority(handler, medium, b2, i);
                    return true;
                case 3:
                    readRstStream(handler, medium, b2, i);
                    return true;
                case 4:
                    readSettings(handler, medium, b2, i);
                    return true;
                case 5:
                    readPushPromise(handler, medium, b2, i);
                    return true;
                case 6:
                    readPing(handler, medium, b2, i);
                    return true;
                case 7:
                    readGoAway(handler, medium, b2, i);
                    return true;
                case 8:
                    readWindowUpdate(handler, medium, b2, i);
                    return true;
                default:
                    this.source.skip(medium);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public void readConnectionPreface(Handler handler) throws IOException {
        if (this.client) {
            if (!nextFrame(true, handler)) {
                throw Http2.ioException("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        pd4 pd4Var = this.source;
        qd4 qd4Var = Http2.CONNECTION_PREFACE;
        qd4 qd4VarJ = pd4Var.J(qd4Var.s());
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Util.format("<< CONNECTION %s", qd4VarJ.j()));
        }
        if (!qd4Var.equals(qd4VarJ)) {
            throw Http2.ioException("Expected a connection header but was %s", qd4VarJ.x());
        }
    }

    private void readPriority(Handler handler, int i) throws IOException {
        int i2 = this.source.readInt();
        handler.priority(i, i2 & Integer.MAX_VALUE, (this.source.readByte() & 255) + 1, (Integer.MIN_VALUE & i2) != 0);
    }
}
