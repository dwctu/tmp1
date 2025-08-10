package org.jivesoftware.smackx.bytestreams.ibb;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.ws.WebSocketProtocol;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.filter.StanzaTypeFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.XMPPError;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jivesoftware.smackx.bytestreams.BytestreamSession;
import org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Data;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Open;

/* loaded from: classes5.dex */
public class InBandBytestreamSession implements BytestreamSession {
    private final Open byteStreamRequest;
    private final XMPPConnection connection;
    private IBBInputStream inputStream;
    private IBBOutputStream outputStream;
    private String remoteJID;
    private boolean closeBothStreamsEnabled = false;
    private boolean isClosed = false;

    /* renamed from: org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smackx$bytestreams$ibb$InBandBytestreamManager$StanzaType;

        static {
            int[] iArr = new int[InBandBytestreamManager.StanzaType.values().length];
            $SwitchMap$org$jivesoftware$smackx$bytestreams$ibb$InBandBytestreamManager$StanzaType = iArr;
            try {
                iArr[InBandBytestreamManager.StanzaType.IQ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smackx$bytestreams$ibb$InBandBytestreamManager$StanzaType[InBandBytestreamManager.StanzaType.MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public class IBBDataPacketFilter implements StanzaFilter {
        private IBBDataPacketFilter() {
        }

        @Override // org.jivesoftware.smack.filter.StanzaFilter
        public boolean accept(Stanza stanza) {
            DataPacketExtension dataPacketExtension;
            if (!stanza.getFrom().equalsIgnoreCase(InBandBytestreamSession.this.remoteJID)) {
                return false;
            }
            if (stanza instanceof Data) {
                dataPacketExtension = ((Data) stanza).getDataPacketExtension();
            } else {
                dataPacketExtension = (DataPacketExtension) stanza.getExtension("data", "http://jabber.org/protocol/ibb");
                if (dataPacketExtension == null) {
                    return false;
                }
            }
            return dataPacketExtension.getSessionID().equals(InBandBytestreamSession.this.byteStreamRequest.getSessionID());
        }

        public /* synthetic */ IBBDataPacketFilter(InBandBytestreamSession inBandBytestreamSession, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public class IQIBBInputStream extends IBBInputStream {
        private IQIBBInputStream() {
            super();
        }

        @Override // org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession.IBBInputStream
        public StanzaFilter getDataPacketFilter() {
            return new AndFilter(new StanzaTypeFilter(Data.class), new IBBDataPacketFilter(InBandBytestreamSession.this, null));
        }

        @Override // org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession.IBBInputStream
        public StanzaListener getDataPacketListener() {
            return new StanzaListener() { // from class: org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession.IQIBBInputStream.1
                private long lastSequence = -1;

                @Override // org.jivesoftware.smack.StanzaListener
                public void processPacket(Stanza stanza) throws SmackException.NotConnectedException {
                    DataPacketExtension dataPacketExtension = ((Data) stanza).getDataPacketExtension();
                    if (dataPacketExtension.getSeq() <= this.lastSequence) {
                        InBandBytestreamSession.this.connection.sendStanza(IQ.createErrorResponse((IQ) stanza, new XMPPError(XMPPError.Condition.unexpected_request)));
                        return;
                    }
                    if (dataPacketExtension.getDecodedData() == null) {
                        InBandBytestreamSession.this.connection.sendStanza(IQ.createErrorResponse((IQ) stanza, new XMPPError(XMPPError.Condition.bad_request)));
                        return;
                    }
                    IQIBBInputStream.this.dataQueue.offer(dataPacketExtension);
                    InBandBytestreamSession.this.connection.sendStanza(IQ.createResultIQ((IQ) stanza));
                    long seq = dataPacketExtension.getSeq();
                    this.lastSequence = seq;
                    if (seq == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                        this.lastSequence = -1L;
                    }
                }
            };
        }

        public /* synthetic */ IQIBBInputStream(InBandBytestreamSession inBandBytestreamSession, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public class IQIBBOutputStream extends IBBOutputStream {
        private IQIBBOutputStream() {
            super();
        }

        @Override // org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession.IBBOutputStream
        public synchronized void writeToXML(DataPacketExtension dataPacketExtension) throws IOException {
            Data data = new Data(dataPacketExtension);
            data.setTo(InBandBytestreamSession.this.remoteJID);
            try {
                InBandBytestreamSession.this.connection.createPacketCollectorAndSend(data).nextResultOrThrow();
            } catch (Exception e) {
                if (!this.isClosed) {
                    InBandBytestreamSession.this.close();
                    IOException iOException = new IOException();
                    iOException.initCause(e);
                    throw iOException;
                }
            }
        }

        public /* synthetic */ IQIBBOutputStream(InBandBytestreamSession inBandBytestreamSession, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public class MessageIBBInputStream extends IBBInputStream {
        private MessageIBBInputStream() {
            super();
        }

        @Override // org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession.IBBInputStream
        public StanzaFilter getDataPacketFilter() {
            return new AndFilter(new StanzaTypeFilter(Message.class), new IBBDataPacketFilter(InBandBytestreamSession.this, null));
        }

        @Override // org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession.IBBInputStream
        public StanzaListener getDataPacketListener() {
            return new StanzaListener() { // from class: org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession.MessageIBBInputStream.1
                @Override // org.jivesoftware.smack.StanzaListener
                public void processPacket(Stanza stanza) {
                    DataPacketExtension dataPacketExtension = (DataPacketExtension) stanza.getExtension("data", "http://jabber.org/protocol/ibb");
                    if (dataPacketExtension.getDecodedData() == null) {
                        return;
                    }
                    MessageIBBInputStream.this.dataQueue.offer(dataPacketExtension);
                }
            };
        }

        public /* synthetic */ MessageIBBInputStream(InBandBytestreamSession inBandBytestreamSession, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public class MessageIBBOutputStream extends IBBOutputStream {
        private MessageIBBOutputStream() {
            super();
        }

        @Override // org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamSession.IBBOutputStream
        public synchronized void writeToXML(DataPacketExtension dataPacketExtension) throws SmackException.NotConnectedException {
            Message message = new Message(InBandBytestreamSession.this.remoteJID);
            message.addExtension(dataPacketExtension);
            InBandBytestreamSession.this.connection.sendStanza(message);
        }

        public /* synthetic */ MessageIBBOutputStream(InBandBytestreamSession inBandBytestreamSession, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public InBandBytestreamSession(XMPPConnection xMPPConnection, Open open, String str) {
        this.connection = xMPPConnection;
        this.byteStreamRequest = open;
        this.remoteJID = str;
        int i = AnonymousClass1.$SwitchMap$org$jivesoftware$smackx$bytestreams$ibb$InBandBytestreamManager$StanzaType[open.getStanza().ordinal()];
        AnonymousClass1 anonymousClass1 = null;
        if (i == 1) {
            this.inputStream = new IQIBBInputStream(this, anonymousClass1);
            this.outputStream = new IQIBBOutputStream(this, anonymousClass1);
        } else {
            if (i != 2) {
                return;
            }
            this.inputStream = new MessageIBBInputStream(this, anonymousClass1);
            this.outputStream = new MessageIBBOutputStream(this, anonymousClass1);
        }
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamSession
    public void close() throws IOException {
        closeByLocal(true);
        closeByLocal(false);
    }

    public synchronized void closeByLocal(boolean z) throws IOException {
        if (this.isClosed) {
            return;
        }
        if (this.closeBothStreamsEnabled) {
            this.inputStream.closeInternal();
            this.outputStream.closeInternal(true);
        } else if (z) {
            this.inputStream.closeInternal();
        } else {
            this.outputStream.closeInternal(true);
        }
        if (this.inputStream.isClosed && this.outputStream.isClosed) {
            this.isClosed = true;
            Close close = new Close(this.byteStreamRequest.getSessionID());
            close.setTo(this.remoteJID);
            try {
                this.connection.createPacketCollectorAndSend(close).nextResultOrThrow();
                this.inputStream.cleanup();
                InBandBytestreamManager.getByteStreamManager(this.connection).getSessions().remove(this);
            } catch (Exception e) {
                IOException iOException = new IOException();
                iOException.initCause(e);
                throw iOException;
            }
        }
    }

    public void closeByPeer(Close close) throws SmackException.NotConnectedException {
        this.inputStream.closeInternal();
        this.inputStream.cleanup();
        this.outputStream.closeInternal(false);
        this.connection.sendStanza(IQ.createResultIQ(close));
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamSession
    public InputStream getInputStream() {
        return this.inputStream;
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamSession
    public OutputStream getOutputStream() {
        return this.outputStream;
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamSession
    public int getReadTimeout() {
        return this.inputStream.readTimeout;
    }

    public boolean isCloseBothStreamsEnabled() {
        return this.closeBothStreamsEnabled;
    }

    public void processIQPacket(Data data) throws SmackException.NotConnectedException {
        this.inputStream.dataPacketListener.processPacket(data);
    }

    public void setCloseBothStreamsEnabled(boolean z) {
        this.closeBothStreamsEnabled = z;
    }

    @Override // org.jivesoftware.smackx.bytestreams.BytestreamSession
    public void setReadTimeout(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Timeout must be >= 0");
        }
        this.inputStream.readTimeout = i;
    }

    public abstract class IBBInputStream extends InputStream {
        private byte[] buffer;
        private final StanzaListener dataPacketListener;
        public final BlockingQueue<DataPacketExtension> dataQueue = new LinkedBlockingQueue();
        private int bufferPointer = -1;
        private long seq = -1;
        private boolean isClosed = false;
        private boolean closeInvoked = false;
        private int readTimeout = 0;

        public IBBInputStream() {
            StanzaListener dataPacketListener = getDataPacketListener();
            this.dataPacketListener = dataPacketListener;
            InBandBytestreamSession.this.connection.addSyncStanzaListener(dataPacketListener, getDataPacketFilter());
        }

        private void checkClosed() throws IOException {
            if (this.closeInvoked) {
                this.dataQueue.clear();
                throw new IOException("Stream is closed");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cleanup() {
            InBandBytestreamSession.this.connection.removeSyncStanzaListener(this.dataPacketListener);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void closeInternal() {
            if (this.isClosed) {
                return;
            }
            this.isClosed = true;
        }

        private synchronized boolean loadBuffer() throws IOException {
            DataPacketExtension dataPacketExtensionPoll;
            try {
                int i = this.readTimeout;
                if (i == 0) {
                    dataPacketExtensionPoll = null;
                    while (dataPacketExtensionPoll == null) {
                        if (this.isClosed && this.dataQueue.isEmpty()) {
                            return false;
                        }
                        dataPacketExtensionPoll = this.dataQueue.poll(1000L, TimeUnit.MILLISECONDS);
                    }
                } else {
                    dataPacketExtensionPoll = this.dataQueue.poll(i, TimeUnit.MILLISECONDS);
                    if (dataPacketExtensionPoll == null) {
                        throw new SocketTimeoutException();
                    }
                }
                if (this.seq == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                    this.seq = -1L;
                }
                long seq = dataPacketExtensionPoll.getSeq();
                if (seq - 1 != this.seq) {
                    InBandBytestreamSession.this.close();
                    throw new IOException("Packets out of sequence");
                }
                this.seq = seq;
                this.buffer = dataPacketExtensionPoll.getDecodedData();
                this.bufferPointer = 0;
                return true;
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return false;
            }
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closeInvoked) {
                return;
            }
            this.closeInvoked = true;
            InBandBytestreamSession.this.closeByLocal(true);
        }

        public abstract StanzaFilter getDataPacketFilter();

        public abstract StanzaListener getDataPacketListener();

        @Override // java.io.InputStream
        public boolean markSupported() {
            return false;
        }

        @Override // java.io.InputStream
        public synchronized int read() throws IOException {
            checkClosed();
            int i = this.bufferPointer;
            if ((i == -1 || i >= this.buffer.length) && !loadBuffer()) {
                return -1;
            }
            byte[] bArr = this.buffer;
            int i2 = this.bufferPointer;
            this.bufferPointer = i2 + 1;
            return bArr[i2] & 255;
        }

        @Override // java.io.InputStream
        public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
            int i3;
            if (bArr != null) {
                if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
                    throw new IndexOutOfBoundsException();
                }
                if (i2 == 0) {
                    return 0;
                }
                checkClosed();
                int i4 = this.bufferPointer;
                if ((i4 == -1 || i4 >= this.buffer.length) && !loadBuffer()) {
                    return -1;
                }
                byte[] bArr2 = this.buffer;
                int length = bArr2.length;
                int i5 = this.bufferPointer;
                int i6 = length - i5;
                if (i2 > i6) {
                    i2 = i6;
                }
                System.arraycopy(bArr2, i5, bArr, i, i2);
                this.bufferPointer += i2;
                return i2;
            }
            throw new NullPointerException();
        }

        @Override // java.io.InputStream
        public synchronized int read(byte[] bArr) throws IOException {
            return read(bArr, 0, bArr.length);
        }
    }

    public abstract class IBBOutputStream extends OutputStream {
        public final byte[] buffer;
        public int bufferPointer = 0;
        public long seq = 0;
        public boolean isClosed = false;

        public IBBOutputStream() {
            this.buffer = new byte[InBandBytestreamSession.this.byteStreamRequest.getBlockSize()];
        }

        private synchronized void flushBuffer() throws IOException {
            int i = this.bufferPointer;
            if (i == 0) {
                return;
            }
            try {
                writeToXML(new DataPacketExtension(InBandBytestreamSession.this.byteStreamRequest.getSessionID(), this.seq, Base64.encodeToString(this.buffer, 0, i)));
                this.bufferPointer = 0;
                long j = this.seq;
                this.seq = j + 1 == WebSocketProtocol.PAYLOAD_SHORT_MAX ? 0L : j + 1;
            } catch (SmackException.NotConnectedException e) {
                IOException iOException = new IOException();
                iOException.initCause(e);
                throw iOException;
            }
        }

        private synchronized void writeOut(byte[] bArr, int i, int i2) throws IOException {
            if (this.isClosed) {
                throw new IOException("Stream is closed");
            }
            int length = 0;
            byte[] bArr2 = this.buffer;
            int length2 = bArr2.length;
            int i3 = this.bufferPointer;
            if (i2 > length2 - i3) {
                length = bArr2.length - i3;
                System.arraycopy(bArr, i, bArr2, i3, length);
                this.bufferPointer += length;
                flushBuffer();
            }
            int i4 = i2 - length;
            System.arraycopy(bArr, i + length, this.buffer, this.bufferPointer, i4);
            this.bufferPointer += i4;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.isClosed) {
                return;
            }
            InBandBytestreamSession.this.closeByLocal(false);
        }

        public void closeInternal(boolean z) {
            if (this.isClosed) {
                return;
            }
            this.isClosed = true;
            if (z) {
                try {
                    flushBuffer();
                } catch (IOException unused) {
                }
            }
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.isClosed) {
                throw new IOException("Stream is closed");
            }
            flushBuffer();
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i) throws IOException {
            if (this.isClosed) {
                throw new IOException("Stream is closed");
            }
            if (this.bufferPointer >= this.buffer.length) {
                flushBuffer();
            }
            byte[] bArr = this.buffer;
            int i2 = this.bufferPointer;
            this.bufferPointer = i2 + 1;
            bArr[i2] = (byte) i;
        }

        public abstract void writeToXML(DataPacketExtension dataPacketExtension) throws SmackException.NotConnectedException, IOException;

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
            int i3;
            if (bArr != null) {
                if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
                    throw new IndexOutOfBoundsException();
                }
                if (i2 == 0) {
                    return;
                }
                if (!this.isClosed) {
                    byte[] bArr2 = this.buffer;
                    if (i2 >= bArr2.length) {
                        writeOut(bArr, i, bArr2.length);
                        byte[] bArr3 = this.buffer;
                        write(bArr, i + bArr3.length, i2 - bArr3.length);
                    } else {
                        writeOut(bArr, i, i2);
                    }
                    return;
                }
                throw new IOException("Stream is closed");
            }
            throw new NullPointerException();
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr) throws IOException {
            write(bArr, 0, bArr.length);
        }
    }
}
