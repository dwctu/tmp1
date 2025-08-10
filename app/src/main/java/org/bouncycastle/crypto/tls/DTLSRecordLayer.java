package org.bouncycastle.crypto.tls;

import java.io.IOException;

/* loaded from: classes5.dex */
public class DTLSRecordLayer implements DatagramTransport {
    private static final int MAX_FRAGMENT_LENGTH = 16384;
    private static final int RECORD_HEADER_LENGTH = 13;
    private static final long RETRANSMIT_TIMEOUT = 240000;
    private static final long TCP_MSL = 120000;
    private final TlsContext context;
    private DTLSEpoch currentEpoch;
    private final TlsPeer peer;
    private DTLSEpoch pendingEpoch;
    private volatile int plaintextLimit;
    private DTLSEpoch readEpoch;
    private final DatagramTransport transport;
    private DTLSEpoch writeEpoch;
    private final ByteQueue recordQueue = new ByteQueue();
    private volatile boolean closed = false;
    private volatile boolean failed = false;
    private volatile ProtocolVersion discoveredPeerVersion = null;
    private DTLSHandshakeRetransmit retransmit = null;
    private DTLSEpoch retransmitEpoch = null;
    private long retransmitExpiry = 0;
    private volatile boolean inHandshake = true;

    public DTLSRecordLayer(DatagramTransport datagramTransport, TlsContext tlsContext, TlsPeer tlsPeer, short s) {
        this.transport = datagramTransport;
        this.context = tlsContext;
        this.peer = tlsPeer;
        DTLSEpoch dTLSEpoch = new DTLSEpoch(0, new TlsNullCipher(tlsContext));
        this.currentEpoch = dTLSEpoch;
        this.pendingEpoch = null;
        this.readEpoch = dTLSEpoch;
        this.writeEpoch = dTLSEpoch;
        setPlaintextLimit(16384);
    }

    private void closeTransport() {
        if (this.closed) {
            return;
        }
        try {
            if (!this.failed) {
                warn((short) 0, null);
            }
            this.transport.close();
        } catch (Exception unused) {
        }
        this.closed = true;
    }

    private static long getMacSequenceNumber(int i, long j) {
        return (i << 48) | j;
    }

    private void raiseAlert(short s, short s2, String str, Exception exc) throws IOException {
        this.peer.notifyAlertRaised(s, s2, str, exc);
        sendRecord((short) 21, new byte[]{(byte) s, (byte) s2}, 0, 2);
    }

    private int receiveRecord(byte[] bArr, int i, int i2, int i3) throws IOException {
        int uint16;
        int uint162;
        if (this.recordQueue.size() <= 0) {
            int iReceive = this.transport.receive(bArr, i, i2, i3);
            if (iReceive < 13 || iReceive <= (uint16 = TlsUtils.readUint16(bArr, i + 11) + 13)) {
                return iReceive;
            }
            this.recordQueue.addData(bArr, i + uint16, iReceive - uint16);
            return uint16;
        }
        if (this.recordQueue.size() >= 13) {
            byte[] bArr2 = new byte[2];
            this.recordQueue.read(bArr2, 0, 2, 11);
            uint162 = TlsUtils.readUint16(bArr2, 0);
        } else {
            uint162 = 0;
        }
        int iMin = Math.min(this.recordQueue.size(), uint162 + 13);
        this.recordQueue.removeData(bArr, i, iMin, 0);
        return iMin;
    }

    private void sendRecord(short s, byte[] bArr, int i, int i2) throws IOException {
        if (i2 > this.plaintextLimit) {
            throw new TlsFatalAlert((short) 80);
        }
        if (i2 < 1 && s != 23) {
            throw new TlsFatalAlert((short) 80);
        }
        int epoch = this.writeEpoch.getEpoch();
        long jAllocateSequenceNumber = this.writeEpoch.allocateSequenceNumber();
        byte[] bArrEncodePlaintext = this.writeEpoch.getCipher().encodePlaintext(getMacSequenceNumber(epoch, jAllocateSequenceNumber), s, bArr, i, i2);
        int length = bArrEncodePlaintext.length + 13;
        byte[] bArr2 = new byte[length];
        TlsUtils.writeUint8(s, bArr2, 0);
        TlsUtils.writeVersion(this.discoveredPeerVersion != null ? this.discoveredPeerVersion : this.context.getClientVersion(), bArr2, 1);
        TlsUtils.writeUint16(epoch, bArr2, 3);
        TlsUtils.writeUint48(jAllocateSequenceNumber, bArr2, 5);
        TlsUtils.writeUint16(bArrEncodePlaintext.length, bArr2, 11);
        System.arraycopy(bArrEncodePlaintext, 0, bArr2, 13, bArrEncodePlaintext.length);
        this.transport.send(bArr2, 0, length);
    }

    @Override // org.bouncycastle.crypto.tls.DatagramTransport
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        if (this.inHandshake) {
            warn((short) 90, "User canceled handshake");
        }
        closeTransport();
    }

    public void fail(short s) {
        if (this.closed) {
            return;
        }
        try {
            raiseAlert((short) 2, s, null, null);
        } catch (Exception unused) {
        }
        this.failed = true;
        closeTransport();
    }

    public ProtocolVersion getDiscoveredPeerVersion() {
        return this.discoveredPeerVersion;
    }

    @Override // org.bouncycastle.crypto.tls.DatagramTransport
    public int getReceiveLimit() throws IOException {
        return Math.min(this.plaintextLimit, this.readEpoch.getCipher().getPlaintextLimit(this.transport.getReceiveLimit() - 13));
    }

    @Override // org.bouncycastle.crypto.tls.DatagramTransport
    public int getSendLimit() throws IOException {
        return Math.min(this.plaintextLimit, this.writeEpoch.getCipher().getPlaintextLimit(this.transport.getSendLimit() - 13));
    }

    public void handshakeSuccessful(DTLSHandshakeRetransmit dTLSHandshakeRetransmit) {
        DTLSEpoch dTLSEpoch = this.readEpoch;
        DTLSEpoch dTLSEpoch2 = this.currentEpoch;
        if (dTLSEpoch == dTLSEpoch2 || this.writeEpoch == dTLSEpoch2) {
            throw new IllegalStateException();
        }
        if (dTLSHandshakeRetransmit != null) {
            this.retransmit = dTLSHandshakeRetransmit;
            this.retransmitEpoch = dTLSEpoch2;
            this.retransmitExpiry = System.currentTimeMillis() + RETRANSMIT_TIMEOUT;
        }
        this.inHandshake = false;
        this.currentEpoch = this.pendingEpoch;
        this.pendingEpoch = null;
    }

    public void initPendingEpoch(TlsCipher tlsCipher) {
        if (this.pendingEpoch != null) {
            throw new IllegalStateException();
        }
        this.pendingEpoch = new DTLSEpoch(this.writeEpoch.getEpoch() + 1, tlsCipher);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x011b, code lost:
    
        if (r18.inHandshake != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x011f, code lost:
    
        if (r18.retransmit == null) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0121, code lost:
    
        r18.retransmit = null;
        r18.retransmitEpoch = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0126, code lost:
    
        java.lang.System.arraycopy(r3, 0, r19, r20, r3.length);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0130, code lost:
    
        return r3.length;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0075 A[Catch: IOException -> 0x0131, TryCatch #0 {IOException -> 0x0131, blocks: (B:8:0x0018, B:10:0x001c, B:12:0x0026, B:13:0x002a, B:18:0x003b, B:21:0x0045, B:22:0x0049, B:24:0x004d, B:26:0x005a, B:38:0x0075, B:41:0x0085, B:43:0x008e, B:46:0x0097, B:49:0x00c5, B:51:0x00c9, B:52:0x00cb, B:80:0x0119, B:82:0x011d, B:84:0x0121, B:85:0x0126, B:54:0x00cf, B:57:0x00d4, B:59:0x00d8, B:61:0x00dc, B:62:0x00e2, B:64:0x00e6, B:67:0x00f7, B:68:0x00fb, B:69:0x0103, B:71:0x0106, B:73:0x0109, B:79:0x0116, B:76:0x0110, B:78:0x0114, B:30:0x0063, B:32:0x0067, B:34:0x006d), top: B:89:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0074 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [org.bouncycastle.crypto.tls.DTLSEpoch, org.bouncycastle.crypto.tls.DTLSHandshakeRetransmit] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v3 */
    @Override // org.bouncycastle.crypto.tls.DatagramTransport
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int receive(byte[] r19, int r20, int r21, int r22) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.tls.DTLSRecordLayer.receive(byte[], int, int, int):int");
    }

    public ProtocolVersion resetDiscoveredPeerVersion() {
        ProtocolVersion protocolVersion = this.discoveredPeerVersion;
        this.discoveredPeerVersion = null;
        return protocolVersion;
    }

    public void resetWriteEpoch() {
        DTLSEpoch dTLSEpoch = this.retransmitEpoch;
        if (dTLSEpoch == null) {
            dTLSEpoch = this.currentEpoch;
        }
        this.writeEpoch = dTLSEpoch;
    }

    @Override // org.bouncycastle.crypto.tls.DatagramTransport
    public void send(byte[] bArr, int i, int i2) throws IOException {
        short s;
        if (this.inHandshake || this.writeEpoch == this.retransmitEpoch) {
            s = 22;
            if (TlsUtils.readUint8(bArr, i) == 20) {
                DTLSEpoch dTLSEpoch = null;
                if (this.inHandshake) {
                    dTLSEpoch = this.pendingEpoch;
                } else if (this.writeEpoch == this.retransmitEpoch) {
                    dTLSEpoch = this.currentEpoch;
                }
                if (dTLSEpoch == null) {
                    throw new IllegalStateException();
                }
                sendRecord((short) 20, new byte[]{1}, 0, 1);
                this.writeEpoch = dTLSEpoch;
            }
        } else {
            s = 23;
        }
        sendRecord(s, bArr, i, i2);
    }

    public void setPlaintextLimit(int i) {
        this.plaintextLimit = i;
    }

    public void warn(short s, String str) throws IOException {
        raiseAlert((short) 1, s, str, null);
    }
}
