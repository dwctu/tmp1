package org.bouncycastle.crypto.tls;

import androidx.core.view.InputDeviceCompat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public class RecordStream {
    private static int DEFAULT_PLAINTEXT_LIMIT = 16384;
    private int ciphertextLimit;
    private int compressedLimit;
    private TlsProtocol handler;
    private InputStream input;
    private OutputStream output;
    private int plaintextLimit;
    private TlsCipher readCipher;
    private TlsCompression readCompression;
    private TlsCipher writeCipher;
    private TlsCompression writeCompression;
    private TlsCompression pendingCompression = null;
    private TlsCipher pendingCipher = null;
    private long readSeqNo = 0;
    private long writeSeqNo = 0;
    private ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private TlsContext context = null;
    private TlsHandshakeHash handshakeHash = null;
    private ProtocolVersion readVersion = null;
    private ProtocolVersion writeVersion = null;
    private boolean restrictReadVersion = true;

    public RecordStream(TlsProtocol tlsProtocol, InputStream inputStream, OutputStream outputStream) {
        this.readCompression = null;
        this.writeCompression = null;
        this.readCipher = null;
        this.writeCipher = null;
        this.handler = tlsProtocol;
        this.input = inputStream;
        this.output = outputStream;
        TlsNullCompression tlsNullCompression = new TlsNullCompression();
        this.readCompression = tlsNullCompression;
        this.writeCompression = tlsNullCompression;
        TlsNullCipher tlsNullCipher = new TlsNullCipher(this.context);
        this.readCipher = tlsNullCipher;
        this.writeCipher = tlsNullCipher;
        setPlaintextLimit(DEFAULT_PLAINTEXT_LIMIT);
    }

    private static void checkLength(int i, int i2, short s) throws IOException {
        if (i > i2) {
            throw new TlsFatalAlert(s);
        }
    }

    private static void checkType(short s, short s2) throws IOException {
        switch (s) {
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
                return;
            default:
                throw new TlsFatalAlert(s2);
        }
    }

    private byte[] getBufferContents() {
        byte[] byteArray = this.buffer.toByteArray();
        this.buffer.reset();
        return byteArray;
    }

    public byte[] decodeAndVerify(short s, InputStream inputStream, int i) throws IOException {
        checkLength(i, this.ciphertextLimit, (short) 22);
        byte[] fully = TlsUtils.readFully(i, inputStream);
        TlsCipher tlsCipher = this.readCipher;
        long j = this.readSeqNo;
        this.readSeqNo = 1 + j;
        byte[] bArrDecodeCiphertext = tlsCipher.decodeCiphertext(j, s, fully, 0, fully.length);
        checkLength(bArrDecodeCiphertext.length, this.compressedLimit, (short) 22);
        OutputStream outputStreamDecompress = this.readCompression.decompress(this.buffer);
        if (outputStreamDecompress != this.buffer) {
            outputStreamDecompress.write(bArrDecodeCiphertext, 0, bArrDecodeCiphertext.length);
            outputStreamDecompress.flush();
            bArrDecodeCiphertext = getBufferContents();
        }
        checkLength(bArrDecodeCiphertext.length, this.plaintextLimit, (short) 30);
        if (bArrDecodeCiphertext.length >= 1 || s == 23) {
            return bArrDecodeCiphertext;
        }
        throw new TlsFatalAlert((short) 47);
    }

    public void finaliseHandshake() throws IOException {
        TlsCompression tlsCompression = this.readCompression;
        TlsCompression tlsCompression2 = this.pendingCompression;
        if (tlsCompression == tlsCompression2 && this.writeCompression == tlsCompression2) {
            TlsCipher tlsCipher = this.readCipher;
            TlsCipher tlsCipher2 = this.pendingCipher;
            if (tlsCipher == tlsCipher2 && this.writeCipher == tlsCipher2) {
                this.pendingCompression = null;
                this.pendingCipher = null;
                return;
            }
        }
        throw new TlsFatalAlert((short) 40);
    }

    public void flush() throws IOException {
        this.output.flush();
    }

    public TlsHandshakeHash getHandshakeHash() {
        return this.handshakeHash;
    }

    public int getPlaintextLimit() {
        return this.plaintextLimit;
    }

    public ProtocolVersion getReadVersion() {
        return this.readVersion;
    }

    public void init(TlsContext tlsContext) {
        this.context = tlsContext;
        DeferredHash deferredHash = new DeferredHash();
        this.handshakeHash = deferredHash;
        deferredHash.init(tlsContext);
    }

    public void notifyHelloComplete() {
        this.handshakeHash = this.handshakeHash.notifyPRFDetermined();
    }

    public TlsHandshakeHash prepareToFinish() {
        TlsHandshakeHash tlsHandshakeHash = this.handshakeHash;
        this.handshakeHash = tlsHandshakeHash.stopTracking();
        return tlsHandshakeHash;
    }

    public boolean readRecord() throws IOException {
        byte[] allOrNothing = TlsUtils.readAllOrNothing(5, this.input);
        if (allOrNothing == null) {
            return false;
        }
        short uint8 = TlsUtils.readUint8(allOrNothing, 0);
        checkType(uint8, (short) 10);
        if (this.restrictReadVersion) {
            ProtocolVersion version = TlsUtils.readVersion(allOrNothing, 1);
            ProtocolVersion protocolVersion = this.readVersion;
            if (protocolVersion == null) {
                this.readVersion = version;
            } else if (!version.equals(protocolVersion)) {
                throw new TlsFatalAlert((short) 47);
            }
        } else if ((TlsUtils.readVersionRaw(allOrNothing, 1) & InputDeviceCompat.SOURCE_ANY) != 768) {
            throw new TlsFatalAlert((short) 47);
        }
        byte[] bArrDecodeAndVerify = decodeAndVerify(uint8, this.input, TlsUtils.readUint16(allOrNothing, 3));
        this.handler.processRecord(uint8, bArrDecodeAndVerify, 0, bArrDecodeAndVerify.length);
        return true;
    }

    public void receivedReadCipherSpec() throws IOException {
        TlsCipher tlsCipher;
        TlsCompression tlsCompression = this.pendingCompression;
        if (tlsCompression == null || (tlsCipher = this.pendingCipher) == null) {
            throw new TlsFatalAlert((short) 40);
        }
        this.readCompression = tlsCompression;
        this.readCipher = tlsCipher;
        this.readSeqNo = 0L;
    }

    public void safeClose() {
        try {
            this.input.close();
        } catch (IOException unused) {
        }
        try {
            this.output.close();
        } catch (IOException unused2) {
        }
    }

    public void sentWriteCipherSpec() throws IOException {
        TlsCipher tlsCipher;
        TlsCompression tlsCompression = this.pendingCompression;
        if (tlsCompression == null || (tlsCipher = this.pendingCipher) == null) {
            throw new TlsFatalAlert((short) 40);
        }
        this.writeCompression = tlsCompression;
        this.writeCipher = tlsCipher;
        this.writeSeqNo = 0L;
    }

    public void setPendingConnectionState(TlsCompression tlsCompression, TlsCipher tlsCipher) {
        this.pendingCompression = tlsCompression;
        this.pendingCipher = tlsCipher;
    }

    public void setPlaintextLimit(int i) {
        this.plaintextLimit = i;
        int i2 = i + 1024;
        this.compressedLimit = i2;
        this.ciphertextLimit = i2 + 1024;
    }

    public void setReadVersion(ProtocolVersion protocolVersion) {
        this.readVersion = protocolVersion;
    }

    public void setRestrictReadVersion(boolean z) {
        this.restrictReadVersion = z;
    }

    public void setWriteVersion(ProtocolVersion protocolVersion) {
        this.writeVersion = protocolVersion;
    }

    public void updateHandshakeData(byte[] bArr, int i, int i2) {
        this.handshakeHash.update(bArr, i, i2);
    }

    public void writeRecord(short s, byte[] bArr, int i, int i2) throws IOException {
        byte[] bArrEncodePlaintext;
        checkType(s, (short) 80);
        checkLength(i2, this.plaintextLimit, (short) 80);
        if (i2 < 1 && s != 23) {
            throw new TlsFatalAlert((short) 80);
        }
        if (s == 22) {
            updateHandshakeData(bArr, i, i2);
        }
        OutputStream outputStreamCompress = this.writeCompression.compress(this.buffer);
        if (outputStreamCompress == this.buffer) {
            TlsCipher tlsCipher = this.writeCipher;
            long j = this.writeSeqNo;
            this.writeSeqNo = 1 + j;
            bArrEncodePlaintext = tlsCipher.encodePlaintext(j, s, bArr, i, i2);
        } else {
            outputStreamCompress.write(bArr, i, i2);
            outputStreamCompress.flush();
            byte[] bufferContents = getBufferContents();
            checkLength(bufferContents.length, i2 + 1024, (short) 80);
            TlsCipher tlsCipher2 = this.writeCipher;
            long j2 = this.writeSeqNo;
            this.writeSeqNo = 1 + j2;
            bArrEncodePlaintext = tlsCipher2.encodePlaintext(j2, s, bufferContents, 0, bufferContents.length);
        }
        checkLength(bArrEncodePlaintext.length, this.ciphertextLimit, (short) 80);
        byte[] bArr2 = new byte[bArrEncodePlaintext.length + 5];
        TlsUtils.writeUint8(s, bArr2, 0);
        TlsUtils.writeVersion(this.writeVersion, bArr2, 1);
        TlsUtils.writeUint16(bArrEncodePlaintext.length, bArr2, 3);
        System.arraycopy(bArrEncodePlaintext, 0, bArr2, 5, bArrEncodePlaintext.length);
        this.output.write(bArr2);
        this.output.flush();
    }
}
