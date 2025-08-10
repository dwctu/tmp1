package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.tls.SessionParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;

/* loaded from: classes5.dex */
public abstract class TlsProtocol {
    public static final short CS_CERTIFICATE_REQUEST = 7;
    public static final short CS_CERTIFICATE_STATUS = 5;
    public static final short CS_CERTIFICATE_VERIFY = 12;
    public static final short CS_CLIENT_CERTIFICATE = 10;
    public static final short CS_CLIENT_FINISHED = 13;
    public static final short CS_CLIENT_HELLO = 1;
    public static final short CS_CLIENT_KEY_EXCHANGE = 11;
    public static final short CS_CLIENT_SUPPLEMENTAL_DATA = 9;
    public static final short CS_END = 16;
    public static final short CS_SERVER_CERTIFICATE = 4;
    public static final short CS_SERVER_FINISHED = 15;
    public static final short CS_SERVER_HELLO = 2;
    public static final short CS_SERVER_HELLO_DONE = 8;
    public static final short CS_SERVER_KEY_EXCHANGE = 6;
    public static final short CS_SERVER_SESSION_TICKET = 14;
    public static final short CS_SERVER_SUPPLEMENTAL_DATA = 3;
    public static final short CS_START = 0;
    public static final Integer EXT_RenegotiationInfo = Integers.valueOf(65281);
    public static final Integer EXT_SessionTicket = Integers.valueOf(35);
    private static final String TLS_ERROR_MESSAGE = "Internal TLS error, this could be an attack";
    public RecordStream recordStream;
    public SecureRandom secureRandom;
    private ByteQueue applicationDataQueue = new ByteQueue();
    private ByteQueue alertQueue = new ByteQueue(2);
    private ByteQueue handshakeQueue = new ByteQueue();
    private TlsInputStream tlsInputStream = null;
    private TlsOutputStream tlsOutputStream = null;
    private volatile boolean closed = false;
    private volatile boolean failedWithError = false;
    private volatile boolean appDataReady = false;
    private volatile boolean splitApplicationDataRecords = true;
    private byte[] expected_verify_data = null;
    public TlsSession tlsSession = null;
    public SessionParameters sessionParameters = null;
    public SecurityParameters securityParameters = null;
    public Certificate peerCertificate = null;
    public int[] offeredCipherSuites = null;
    public short[] offeredCompressionMethods = null;
    public Hashtable clientExtensions = null;
    public Hashtable serverExtensions = null;
    public short connection_state = 0;
    public boolean resumedSession = false;
    public boolean receivedChangeCipherSpec = false;
    public boolean secure_renegotiation = false;
    public boolean allowCertificateStatus = false;
    public boolean expectSessionTicket = false;

    public class HandshakeMessage extends ByteArrayOutputStream {
        public HandshakeMessage(TlsProtocol tlsProtocol, short s) throws IOException {
            this(s, 60);
        }

        public HandshakeMessage(short s, int i) throws IOException {
            super(i + 4);
            TlsUtils.writeUint8(s, (OutputStream) this);
            ((ByteArrayOutputStream) this).count += 3;
        }

        public void writeToRecordStream() throws Exception {
            int i = ((ByteArrayOutputStream) this).count - 4;
            TlsUtils.checkUint24(i);
            TlsUtils.writeUint24(i, ((ByteArrayOutputStream) this).buf, 1);
            TlsProtocol.this.writeHandshakeMessage(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count);
            ((ByteArrayOutputStream) this).buf = null;
        }
    }

    public TlsProtocol(InputStream inputStream, OutputStream outputStream, SecureRandom secureRandom) {
        this.recordStream = new RecordStream(this, inputStream, outputStream);
        this.secureRandom = secureRandom;
    }

    public static void assertEmpty(ByteArrayInputStream byteArrayInputStream) throws IOException {
        if (byteArrayInputStream.available() > 0) {
            throw new TlsFatalAlert((short) 50);
        }
    }

    public static byte[] createRandomBlock(SecureRandom secureRandom) {
        secureRandom.setSeed(System.currentTimeMillis());
        byte[] bArr = new byte[32];
        secureRandom.nextBytes(bArr);
        return bArr;
    }

    public static byte[] createRenegotiationInfo(byte[] bArr) throws IOException {
        return TlsUtils.encodeOpaque8(bArr);
    }

    public static void establishMasterSecret(TlsContext tlsContext, TlsKeyExchange tlsKeyExchange) throws IOException {
        byte[] bArrGeneratePremasterSecret = tlsKeyExchange.generatePremasterSecret();
        try {
            tlsContext.getSecurityParameters().masterSecret = TlsUtils.calculateMasterSecret(tlsContext, bArrGeneratePremasterSecret);
        } finally {
            if (bArrGeneratePremasterSecret != null) {
                Arrays.fill(bArrGeneratePremasterSecret, (byte) 0);
            }
        }
    }

    public static byte[] getCurrentPRFHash(TlsContext tlsContext, TlsHandshakeHash tlsHandshakeHash, byte[] bArr) {
        Digest digestForkPRFHash = tlsHandshakeHash.forkPRFHash();
        if (bArr != null && TlsUtils.isSSL(tlsContext)) {
            digestForkPRFHash.update(bArr, 0, bArr.length);
        }
        byte[] bArr2 = new byte[digestForkPRFHash.getDigestSize()];
        digestForkPRFHash.doFinal(bArr2, 0);
        return bArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getPRFAlgorithm(org.bouncycastle.crypto.tls.TlsContext r4, int r5) throws java.io.IOException {
        /*
            boolean r4 = org.bouncycastle.crypto.tls.TlsUtils.isTLSv12(r4)
            r0 = 175(0xaf, float:2.45E-43)
            r1 = 0
            r2 = 2
            if (r5 == r0) goto L53
            r0 = 177(0xb1, float:2.48E-43)
            if (r5 == r0) goto L53
            r0 = 179(0xb3, float:2.51E-43)
            if (r5 == r0) goto L53
            r0 = 181(0xb5, float:2.54E-43)
            if (r5 == r0) goto L53
            r0 = 183(0xb7, float:2.56E-43)
            if (r5 == r0) goto L53
            r0 = 185(0xb9, float:2.59E-43)
            if (r5 == r0) goto L53
            r0 = 49208(0xc038, float:6.8955E-41)
            if (r5 == r0) goto L53
            r0 = 49211(0xc03b, float:6.8959E-41)
            if (r5 == r0) goto L53
            r0 = 1
            r3 = 47
            switch(r5) {
                case 59: goto L4a;
                case 60: goto L4a;
                case 61: goto L4a;
                case 62: goto L4a;
                case 63: goto L4a;
                case 64: goto L4a;
                default: goto L2e;
            }
        L2e:
            switch(r5) {
                case 103: goto L4a;
                case 104: goto L4a;
                case 105: goto L4a;
                case 106: goto L4a;
                case 107: goto L4a;
                default: goto L31;
            }
        L31:
            switch(r5) {
                case 156: goto L4a;
                case 157: goto L41;
                case 158: goto L4a;
                case 159: goto L41;
                case 160: goto L4a;
                case 161: goto L41;
                case 162: goto L4a;
                case 163: goto L41;
                case 164: goto L4a;
                case 165: goto L41;
                default: goto L34;
            }
        L34:
            switch(r5) {
                case 168: goto L4a;
                case 169: goto L41;
                case 170: goto L4a;
                case 171: goto L41;
                case 172: goto L4a;
                case 173: goto L41;
                default: goto L37;
            }
        L37:
            switch(r5) {
                case 49187: goto L4a;
                case 49188: goto L41;
                case 49189: goto L4a;
                case 49190: goto L41;
                case 49191: goto L4a;
                case 49192: goto L41;
                case 49193: goto L4a;
                case 49194: goto L41;
                case 49195: goto L4a;
                case 49196: goto L41;
                case 49197: goto L4a;
                case 49198: goto L41;
                case 49199: goto L4a;
                case 49200: goto L41;
                case 49201: goto L4a;
                case 49202: goto L41;
                default: goto L3a;
            }
        L3a:
            switch(r5) {
                case 49308: goto L4a;
                case 49309: goto L4a;
                case 49310: goto L4a;
                case 49311: goto L4a;
                case 49312: goto L4a;
                case 49313: goto L4a;
                case 49314: goto L4a;
                case 49315: goto L4a;
                case 49316: goto L4a;
                case 49317: goto L4a;
                case 49318: goto L4a;
                case 49319: goto L4a;
                case 49320: goto L4a;
                case 49321: goto L4a;
                case 49322: goto L4a;
                case 49323: goto L4a;
                default: goto L3d;
            }
        L3d:
            if (r4 == 0) goto L40
            return r0
        L40:
            return r1
        L41:
            if (r4 == 0) goto L44
            return r2
        L44:
            org.bouncycastle.crypto.tls.TlsFatalAlert r4 = new org.bouncycastle.crypto.tls.TlsFatalAlert
            r4.<init>(r3)
            throw r4
        L4a:
            if (r4 == 0) goto L4d
            return r0
        L4d:
            org.bouncycastle.crypto.tls.TlsFatalAlert r4 = new org.bouncycastle.crypto.tls.TlsFatalAlert
            r4.<init>(r3)
            throw r4
        L53:
            if (r4 == 0) goto L56
            return r2
        L56:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.tls.TlsProtocol.getPRFAlgorithm(org.bouncycastle.crypto.tls.TlsContext, int):int");
    }

    private void processAlert() throws IOException {
        while (this.alertQueue.size() >= 2) {
            byte[] bArrRemoveData = this.alertQueue.removeData(2, 0);
            short s = bArrRemoveData[0];
            short s2 = bArrRemoveData[1];
            getPeer().notifyAlertReceived(s, s2);
            if (s == 2) {
                invalidateSession();
                this.failedWithError = true;
                this.closed = true;
                this.recordStream.safeClose();
                throw new IOException(TLS_ERROR_MESSAGE);
            }
            if (s2 == 0) {
                handleClose(false);
            }
            handleWarningMessage(s2);
        }
    }

    private void processApplicationData() {
    }

    private void processChangeCipherSpec(byte[] bArr, int i, int i2) throws IOException {
        for (int i3 = 0; i3 < i2; i3++) {
            if (TlsUtils.readUint8(bArr, i + i3) != 1) {
                throw new TlsFatalAlert((short) 50);
            }
            if (this.receivedChangeCipherSpec) {
                throw new TlsFatalAlert((short) 10);
            }
            this.receivedChangeCipherSpec = true;
            this.recordStream.receivedReadCipherSpec();
            handleChangeCipherSpecMessage();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void processHandshake() throws java.io.IOException {
        /*
            r8 = this;
        L0:
            org.bouncycastle.crypto.tls.ByteQueue r0 = r8.handshakeQueue
            int r0 = r0.size()
            r1 = 1
            r2 = 0
            r3 = 4
            if (r0 < r3) goto L57
            byte[] r0 = new byte[r3]
            org.bouncycastle.crypto.tls.ByteQueue r4 = r8.handshakeQueue
            r4.read(r0, r2, r3, r2)
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream
            r4.<init>(r0)
            short r5 = org.bouncycastle.crypto.tls.TlsUtils.readUint8(r4)
            int r4 = org.bouncycastle.crypto.tls.TlsUtils.readUint24(r4)
            org.bouncycastle.crypto.tls.ByteQueue r6 = r8.handshakeQueue
            int r6 = r6.size()
            int r7 = r4 + 4
            if (r6 < r7) goto L57
            org.bouncycastle.crypto.tls.ByteQueue r6 = r8.handshakeQueue
            byte[] r6 = r6.removeData(r4, r3)
            if (r5 == 0) goto L53
            r7 = 20
            if (r5 == r7) goto L36
            goto L49
        L36:
            byte[] r7 = r8.expected_verify_data
            if (r7 != 0) goto L49
            org.bouncycastle.crypto.tls.AbstractTlsContext r7 = r8.getContext()
            boolean r7 = r7.isServer()
            r7 = r7 ^ r1
            byte[] r7 = r8.createVerifyData(r7)
            r8.expected_verify_data = r7
        L49:
            org.bouncycastle.crypto.tls.RecordStream r7 = r8.recordStream
            r7.updateHandshakeData(r0, r2, r3)
            org.bouncycastle.crypto.tls.RecordStream r0 = r8.recordStream
            r0.updateHandshakeData(r6, r2, r4)
        L53:
            r8.handleHandshakeMessage(r5, r6)
            goto L58
        L57:
            r1 = 0
        L58:
            if (r1 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.tls.TlsProtocol.processHandshake():void");
    }

    public static Hashtable readExtensions(ByteArrayInputStream byteArrayInputStream) throws IOException {
        if (byteArrayInputStream.available() < 1) {
            return null;
        }
        byte[] opaque16 = TlsUtils.readOpaque16(byteArrayInputStream);
        assertEmpty(byteArrayInputStream);
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(opaque16);
        Hashtable hashtable = new Hashtable();
        while (byteArrayInputStream2.available() > 0) {
            if (hashtable.put(Integers.valueOf(TlsUtils.readUint16(byteArrayInputStream2)), TlsUtils.readOpaque16(byteArrayInputStream2)) != null) {
                throw new TlsFatalAlert((short) 47);
            }
        }
        return hashtable;
    }

    public static Vector readSupplementalDataMessage(ByteArrayInputStream byteArrayInputStream) throws IOException {
        byte[] opaque24 = TlsUtils.readOpaque24(byteArrayInputStream);
        assertEmpty(byteArrayInputStream);
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(opaque24);
        Vector vector = new Vector();
        while (byteArrayInputStream2.available() > 0) {
            vector.addElement(new SupplementalDataEntry(TlsUtils.readUint16(byteArrayInputStream2), TlsUtils.readOpaque16(byteArrayInputStream2)));
        }
        return vector;
    }

    public static void writeExtensions(OutputStream outputStream, Hashtable hashtable) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Enumeration enumerationKeys = hashtable.keys();
        while (enumerationKeys.hasMoreElements()) {
            Integer num = (Integer) enumerationKeys.nextElement();
            int iIntValue = num.intValue();
            byte[] bArr = (byte[]) hashtable.get(num);
            TlsUtils.checkUint16(iIntValue);
            TlsUtils.writeUint16(iIntValue, byteArrayOutputStream);
            TlsUtils.writeOpaque16(bArr, byteArrayOutputStream);
        }
        TlsUtils.writeOpaque16(byteArrayOutputStream.toByteArray(), outputStream);
    }

    public static void writeSupplementalData(OutputStream outputStream, Vector vector) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < vector.size(); i++) {
            SupplementalDataEntry supplementalDataEntry = (SupplementalDataEntry) vector.elementAt(i);
            int dataType = supplementalDataEntry.getDataType();
            TlsUtils.checkUint16(dataType);
            TlsUtils.writeUint16(dataType, byteArrayOutputStream);
            TlsUtils.writeOpaque16(supplementalDataEntry.getData(), byteArrayOutputStream);
        }
        TlsUtils.writeOpaque24(byteArrayOutputStream.toByteArray(), outputStream);
    }

    public void cleanupHandshake() {
        byte[] bArr = this.expected_verify_data;
        if (bArr != null) {
            Arrays.fill(bArr, (byte) 0);
            this.expected_verify_data = null;
        }
        this.securityParameters.clear();
        this.peerCertificate = null;
        this.offeredCipherSuites = null;
        this.offeredCompressionMethods = null;
        this.clientExtensions = null;
        this.serverExtensions = null;
        this.resumedSession = false;
        this.receivedChangeCipherSpec = false;
        this.secure_renegotiation = false;
        this.allowCertificateStatus = false;
        this.expectSessionTicket = false;
    }

    public void close() throws IOException {
        handleClose(true);
    }

    public void completeHandshake() throws IOException {
        while (this.connection_state != 16) {
            try {
                safeReadRecord();
            } finally {
                cleanupHandshake();
            }
        }
        this.recordStream.finaliseHandshake();
        this.splitApplicationDataRecords = !TlsUtils.isTLSv11(getContext());
        if (!this.appDataReady) {
            this.appDataReady = true;
            this.tlsInputStream = new TlsInputStream(this);
            this.tlsOutputStream = new TlsOutputStream(this);
        }
        if (this.tlsSession != null) {
            if (this.sessionParameters == null) {
                this.sessionParameters = new SessionParameters.Builder().setCipherSuite(this.securityParameters.cipherSuite).setCompressionAlgorithm(this.securityParameters.compressionAlgorithm).setMasterSecret(this.securityParameters.masterSecret).setPeerCertificate(this.peerCertificate).setServerExtensions(this.serverExtensions).build();
                this.tlsSession = new TlsSessionImpl(this.tlsSession.getSessionID(), this.sessionParameters);
            }
            getContext().setResumableSession(this.tlsSession);
        }
        getPeer().notifyHandshakeComplete();
    }

    public byte[] createVerifyData(boolean z) {
        AbstractTlsContext context = getContext();
        return z ? TlsUtils.calculateVerifyData(context, ExporterLabel.server_finished, getCurrentPRFHash(getContext(), this.recordStream.getHandshakeHash(), TlsUtils.SSL_SERVER)) : TlsUtils.calculateVerifyData(context, ExporterLabel.client_finished, getCurrentPRFHash(getContext(), this.recordStream.getHandshakeHash(), TlsUtils.SSL_CLIENT));
    }

    public void failWithError(short s, short s2, String str, Exception exc) throws IOException {
        if (!this.closed) {
            this.closed = true;
            if (s == 2) {
                invalidateSession();
                this.failedWithError = true;
            }
            raiseAlert(s, s2, str, exc);
            this.recordStream.safeClose();
            if (s != 2) {
                return;
            }
        }
        throw new IOException(TLS_ERROR_MESSAGE);
    }

    public void flush() throws IOException {
        this.recordStream.flush();
    }

    public abstract AbstractTlsContext getContext();

    public InputStream getInputStream() {
        return this.tlsInputStream;
    }

    public OutputStream getOutputStream() {
        return this.tlsOutputStream;
    }

    public abstract TlsPeer getPeer();

    public void handleChangeCipherSpecMessage() throws IOException {
    }

    public void handleClose(boolean z) throws IOException {
        if (this.closed) {
            return;
        }
        if (z && !this.appDataReady) {
            raiseWarning((short) 90, "User canceled handshake");
        }
        failWithError((short) 1, (short) 0, "Connection closed", null);
    }

    public abstract void handleHandshakeMessage(short s, byte[] bArr) throws IOException;

    public void handleWarningMessage(short s) throws IOException {
    }

    public void invalidateSession() {
        SessionParameters sessionParameters = this.sessionParameters;
        if (sessionParameters != null) {
            sessionParameters.clear();
            this.sessionParameters = null;
        }
        TlsSession tlsSession = this.tlsSession;
        if (tlsSession != null) {
            tlsSession.invalidate();
            this.tlsSession = null;
        }
    }

    public void processFinishedMessage(ByteArrayInputStream byteArrayInputStream) throws IOException {
        byte[] fully = TlsUtils.readFully(this.expected_verify_data.length, byteArrayInputStream);
        assertEmpty(byteArrayInputStream);
        if (!Arrays.constantTimeAreEqual(this.expected_verify_data, fully)) {
            throw new TlsFatalAlert((short) 51);
        }
    }

    public short processMaxFragmentLengthExtension(Hashtable hashtable, Hashtable hashtable2, short s) throws IOException {
        short maxFragmentLengthExtension = TlsExtensionsUtils.getMaxFragmentLengthExtension(hashtable2);
        if (maxFragmentLengthExtension < 0 || this.resumedSession || maxFragmentLengthExtension == TlsExtensionsUtils.getMaxFragmentLengthExtension(hashtable)) {
            return maxFragmentLengthExtension;
        }
        throw new TlsFatalAlert(s);
    }

    public void processRecord(short s, byte[] bArr, int i, int i2) throws IOException {
        switch (s) {
            case 20:
                processChangeCipherSpec(bArr, i, i2);
                return;
            case 21:
                this.alertQueue.addData(bArr, i, i2);
                processAlert();
                return;
            case 22:
                this.handshakeQueue.addData(bArr, i, i2);
                processHandshake();
                return;
            case 23:
                if (!this.appDataReady) {
                    throw new TlsFatalAlert((short) 10);
                }
                this.applicationDataQueue.addData(bArr, i, i2);
                processApplicationData();
                return;
            default:
                return;
        }
    }

    public void raiseAlert(short s, short s2, String str, Exception exc) throws IOException {
        getPeer().notifyAlertRaised(s, s2, str, exc);
        safeWriteRecord((short) 21, new byte[]{(byte) s, (byte) s2}, 0, 2);
    }

    public void raiseWarning(short s, String str) throws IOException {
        raiseAlert((short) 1, s, str, null);
    }

    public int readApplicationData(byte[] bArr, int i, int i2) throws Exception {
        if (i2 < 1) {
            return 0;
        }
        while (this.applicationDataQueue.size() == 0) {
            if (this.closed) {
                if (this.failedWithError) {
                    throw new IOException(TLS_ERROR_MESSAGE);
                }
                return -1;
            }
            safeReadRecord();
        }
        int iMin = Math.min(i2, this.applicationDataQueue.size());
        this.applicationDataQueue.removeData(bArr, i, iMin, 0);
        return iMin;
    }

    public void safeReadRecord() throws Exception {
        try {
            if (this.recordStream.readRecord()) {
            } else {
                throw new EOFException();
            }
        } catch (IOException e) {
            if (!this.closed) {
                failWithError((short) 2, (short) 80, "Failed to read record", e);
            }
            throw e;
        } catch (RuntimeException e2) {
            if (!this.closed) {
                failWithError((short) 2, (short) 80, "Failed to read record", e2);
            }
            throw e2;
        } catch (TlsFatalAlert e3) {
            if (!this.closed) {
                failWithError((short) 2, e3.getAlertDescription(), "Failed to read record", e3);
            }
            throw e3;
        }
    }

    public void safeWriteRecord(short s, byte[] bArr, int i, int i2) throws Exception {
        try {
            this.recordStream.writeRecord(s, bArr, i, i2);
        } catch (RuntimeException e) {
            if (!this.closed) {
                failWithError((short) 2, (short) 80, "Failed to write record", e);
            }
            throw e;
        } catch (TlsFatalAlert e2) {
            if (!this.closed) {
                failWithError((short) 2, e2.getAlertDescription(), "Failed to write record", e2);
            }
            throw e2;
        } catch (IOException e3) {
            if (!this.closed) {
                failWithError((short) 2, (short) 80, "Failed to write record", e3);
            }
            throw e3;
        }
    }

    public void sendCertificateMessage(Certificate certificate) throws Exception {
        if (certificate == null) {
            certificate = Certificate.EMPTY_CHAIN;
        }
        if (certificate.getLength() == 0 && !getContext().isServer()) {
            ProtocolVersion serverVersion = getContext().getServerVersion();
            if (serverVersion.isSSL()) {
                raiseWarning((short) 41, serverVersion.toString() + " client didn't provide credentials");
                return;
            }
        }
        HandshakeMessage handshakeMessage = new HandshakeMessage(this, (short) 11);
        certificate.encode(handshakeMessage);
        handshakeMessage.writeToRecordStream();
    }

    public void sendChangeCipherSpecMessage() throws Exception {
        safeWriteRecord((short) 20, new byte[]{1}, 0, 1);
        this.recordStream.sentWriteCipherSpec();
    }

    public void sendFinishedMessage() throws Exception {
        byte[] bArrCreateVerifyData = createVerifyData(getContext().isServer());
        HandshakeMessage handshakeMessage = new HandshakeMessage((short) 20, bArrCreateVerifyData.length);
        handshakeMessage.write(bArrCreateVerifyData);
        handshakeMessage.writeToRecordStream();
    }

    public void sendSupplementalDataMessage(Vector vector) throws Exception {
        HandshakeMessage handshakeMessage = new HandshakeMessage(this, (short) 23);
        writeSupplementalData(handshakeMessage, vector);
        handshakeMessage.writeToRecordStream();
    }

    public void writeData(byte[] bArr, int i, int i2) throws Exception {
        if (this.closed) {
            if (!this.failedWithError) {
                throw new IOException("Sorry, connection has been closed, you cannot write more data");
            }
            throw new IOException(TLS_ERROR_MESSAGE);
        }
        while (i2 > 0) {
            if (this.splitApplicationDataRecords) {
                safeWriteRecord((short) 23, bArr, i, 1);
                i++;
                i2--;
            }
            if (i2 > 0) {
                int iMin = Math.min(i2, this.recordStream.getPlaintextLimit());
                safeWriteRecord((short) 23, bArr, i, iMin);
                i += iMin;
                i2 -= iMin;
            }
        }
    }

    public void writeHandshakeMessage(byte[] bArr, int i, int i2) throws Exception {
        while (i2 > 0) {
            int iMin = Math.min(i2, this.recordStream.getPlaintextLimit());
            safeWriteRecord((short) 22, bArr, i, iMin);
            i += iMin;
            i2 -= iMin;
        }
    }
}
