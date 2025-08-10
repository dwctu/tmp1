package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.tls.TlsProtocol;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.util.Arrays;

/* loaded from: classes5.dex */
public class TlsServerProtocol extends TlsProtocol {
    public CertificateRequest certificateRequest;
    public short clientCertificateType;
    public TlsKeyExchange keyExchange;
    public TlsHandshakeHash prepareFinishHash;
    public TlsCredentials serverCredentials;
    public TlsServer tlsServer;
    public TlsServerContextImpl tlsServerContext;

    public TlsServerProtocol(InputStream inputStream, OutputStream outputStream, SecureRandom secureRandom) {
        super(inputStream, outputStream, secureRandom);
        this.tlsServer = null;
        this.tlsServerContext = null;
        this.keyExchange = null;
        this.serverCredentials = null;
        this.certificateRequest = null;
        this.clientCertificateType = (short) -1;
        this.prepareFinishHash = null;
    }

    public void accept(TlsServer tlsServer) throws IOException {
        if (tlsServer == null) {
            throw new IllegalArgumentException("'tlsServer' cannot be null");
        }
        if (this.tlsServer != null) {
            throw new IllegalStateException("'accept' can only be called once");
        }
        this.tlsServer = tlsServer;
        SecurityParameters securityParameters = new SecurityParameters();
        this.securityParameters = securityParameters;
        securityParameters.entity = 0;
        securityParameters.serverRandom = TlsProtocol.createRandomBlock(this.secureRandom);
        TlsServerContextImpl tlsServerContextImpl = new TlsServerContextImpl(this.secureRandom, this.securityParameters);
        this.tlsServerContext = tlsServerContextImpl;
        this.tlsServer.init(tlsServerContextImpl);
        this.recordStream.init(this.tlsServerContext);
        this.recordStream.setRestrictReadVersion(false);
        completeHandshake();
    }

    @Override // org.bouncycastle.crypto.tls.TlsProtocol
    public void cleanupHandshake() {
        super.cleanupHandshake();
        this.keyExchange = null;
        this.serverCredentials = null;
        this.certificateRequest = null;
        this.prepareFinishHash = null;
    }

    public boolean expectCertificateVerifyMessage() {
        short s = this.clientCertificateType;
        return s >= 0 && TlsUtils.hasSigningCapability(s);
    }

    @Override // org.bouncycastle.crypto.tls.TlsProtocol
    public AbstractTlsContext getContext() {
        return this.tlsServerContext;
    }

    @Override // org.bouncycastle.crypto.tls.TlsProtocol
    public TlsPeer getPeer() {
        return this.tlsServer;
    }

    @Override // org.bouncycastle.crypto.tls.TlsProtocol
    public void handleHandshakeMessage(short s, byte[] bArr) throws Exception {
        CertificateStatus certificateStatus;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        Certificate certificate = null;
        if (s == 1) {
            if (this.connection_state != 0) {
                throw new TlsFatalAlert((short) 10);
            }
            receiveClientHelloMessage(byteArrayInputStream);
            this.connection_state = (short) 1;
            sendServerHelloMessage();
            this.connection_state = (short) 2;
            Vector serverSupplementalData = this.tlsServer.getServerSupplementalData();
            if (serverSupplementalData != null) {
                sendSupplementalDataMessage(serverSupplementalData);
            }
            this.connection_state = (short) 3;
            TlsKeyExchange keyExchange = this.tlsServer.getKeyExchange();
            this.keyExchange = keyExchange;
            keyExchange.init(getContext());
            TlsCredentials credentials = this.tlsServer.getCredentials();
            this.serverCredentials = credentials;
            if (credentials == null) {
                this.keyExchange.skipServerCredentials();
            } else {
                this.keyExchange.processServerCredentials(credentials);
                certificate = this.serverCredentials.getCertificate();
                sendCertificateMessage(certificate);
            }
            this.connection_state = (short) 4;
            if (certificate == null || certificate.isEmpty()) {
                this.allowCertificateStatus = false;
            }
            if (this.allowCertificateStatus && (certificateStatus = this.tlsServer.getCertificateStatus()) != null) {
                sendCertificateStatusMessage(certificateStatus);
            }
            this.connection_state = (short) 5;
            byte[] bArrGenerateServerKeyExchange = this.keyExchange.generateServerKeyExchange();
            if (bArrGenerateServerKeyExchange != null) {
                sendServerKeyExchangeMessage(bArrGenerateServerKeyExchange);
            }
            this.connection_state = (short) 6;
            if (this.serverCredentials != null) {
                CertificateRequest certificateRequest = this.tlsServer.getCertificateRequest();
                this.certificateRequest = certificateRequest;
                if (certificateRequest != null) {
                    this.keyExchange.validateCertificateRequest(certificateRequest);
                    sendCertificateRequestMessage(this.certificateRequest);
                    TlsUtils.trackHashAlgorithms(this.recordStream.getHandshakeHash(), this.certificateRequest.getSupportedSignatureAlgorithms());
                }
            }
            this.connection_state = (short) 7;
            sendServerHelloDoneMessage();
            this.connection_state = (short) 8;
            this.recordStream.getHandshakeHash().sealHashAlgorithms();
            return;
        }
        if (s == 11) {
            short s2 = this.connection_state;
            if (s2 == 8) {
                this.tlsServer.processClientSupplementalData(null);
            } else if (s2 != 9) {
                throw new TlsFatalAlert((short) 10);
            }
            if (this.certificateRequest == null) {
                throw new TlsFatalAlert((short) 10);
            }
            receiveCertificateMessage(byteArrayInputStream);
            this.connection_state = (short) 10;
            return;
        }
        if (s == 20) {
            short s3 = this.connection_state;
            if (s3 != 11) {
                if (s3 != 12) {
                    throw new TlsFatalAlert((short) 10);
                }
            } else if (expectCertificateVerifyMessage()) {
                throw new TlsFatalAlert((short) 10);
            }
            processFinishedMessage(byteArrayInputStream);
            this.connection_state = (short) 13;
            if (this.expectSessionTicket) {
                sendNewSessionTicketMessage(this.tlsServer.getNewSessionTicket());
                sendChangeCipherSpecMessage();
            }
            this.connection_state = (short) 14;
            sendFinishedMessage();
            this.connection_state = (short) 15;
            this.connection_state = (short) 16;
            return;
        }
        if (s == 23) {
            if (this.connection_state != 8) {
                throw new TlsFatalAlert((short) 10);
            }
            this.tlsServer.processClientSupplementalData(TlsProtocol.readSupplementalDataMessage(byteArrayInputStream));
            this.connection_state = (short) 9;
            return;
        }
        if (s == 15) {
            if (this.connection_state != 11) {
                throw new TlsFatalAlert((short) 10);
            }
            if (!expectCertificateVerifyMessage()) {
                throw new TlsFatalAlert((short) 10);
            }
            receiveCertificateVerifyMessage(byteArrayInputStream);
            this.connection_state = (short) 12;
            return;
        }
        if (s != 16) {
            throw new TlsFatalAlert((short) 10);
        }
        switch (this.connection_state) {
            case 8:
                this.tlsServer.processClientSupplementalData(null);
            case 9:
                if (this.certificateRequest == null) {
                    this.keyExchange.skipClientCredentials();
                } else {
                    if (TlsUtils.isTLSv12(getContext())) {
                        throw new TlsFatalAlert((short) 10);
                    }
                    if (!TlsUtils.isSSL(getContext())) {
                        notifyClientCertificate(Certificate.EMPTY_CHAIN);
                    } else if (this.peerCertificate == null) {
                        throw new TlsFatalAlert((short) 10);
                    }
                }
            case 10:
                receiveClientKeyExchangeMessage(byteArrayInputStream);
                this.connection_state = (short) 11;
                return;
            default:
                throw new TlsFatalAlert((short) 10);
        }
    }

    @Override // org.bouncycastle.crypto.tls.TlsProtocol
    public void handleWarningMessage(short s) throws IOException {
        if (s != 41) {
            super.handleWarningMessage(s);
        } else {
            if (!TlsUtils.isSSL(getContext()) || this.certificateRequest == null) {
                return;
            }
            notifyClientCertificate(Certificate.EMPTY_CHAIN);
        }
    }

    public void notifyClientCertificate(Certificate certificate) throws IOException {
        if (this.certificateRequest == null) {
            throw new IllegalStateException();
        }
        if (this.peerCertificate != null) {
            throw new TlsFatalAlert((short) 10);
        }
        this.peerCertificate = certificate;
        if (certificate.isEmpty()) {
            this.keyExchange.skipClientCredentials();
        } else {
            this.clientCertificateType = TlsUtils.getClientCertificateType(certificate, this.serverCredentials.getCertificate());
            this.keyExchange.processClientCertificate(certificate);
        }
        this.tlsServer.notifyClientCertificate(certificate);
    }

    public void receiveCertificateMessage(ByteArrayInputStream byteArrayInputStream) throws IOException {
        Certificate certificate = Certificate.parse(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        notifyClientCertificate(certificate);
    }

    public void receiveCertificateVerifyMessage(ByteArrayInputStream byteArrayInputStream) throws IOException {
        DigitallySigned digitallySigned = DigitallySigned.parse(getContext(), byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        try {
            byte[] currentPRFHash = TlsProtocol.getCurrentPRFHash(getContext(), this.prepareFinishHash, null);
            AsymmetricKeyParameter asymmetricKeyParameterCreateKey = PublicKeyFactory.createKey(this.peerCertificate.getCertificateAt(0).getSubjectPublicKeyInfo());
            TlsSigner tlsSignerCreateTlsSigner = TlsUtils.createTlsSigner(this.clientCertificateType);
            tlsSignerCreateTlsSigner.init(getContext());
            tlsSignerCreateTlsSigner.verifyRawSignature(digitallySigned.getAlgorithm(), digitallySigned.getSignature(), asymmetricKeyParameterCreateKey, currentPRFHash);
        } catch (Exception unused) {
            throw new TlsFatalAlert((short) 51);
        }
    }

    public void receiveClientHelloMessage(ByteArrayInputStream byteArrayInputStream) throws IOException {
        ProtocolVersion version = TlsUtils.readVersion(byteArrayInputStream);
        if (version.isDTLS()) {
            throw new TlsFatalAlert((short) 47);
        }
        byte[] fully = TlsUtils.readFully(32, byteArrayInputStream);
        if (TlsUtils.readOpaque8(byteArrayInputStream).length > 32) {
            throw new TlsFatalAlert((short) 47);
        }
        int uint16 = TlsUtils.readUint16(byteArrayInputStream);
        if (uint16 < 2 || (uint16 & 1) != 0) {
            throw new TlsFatalAlert((short) 50);
        }
        this.offeredCipherSuites = TlsUtils.readUint16Array(uint16 / 2, byteArrayInputStream);
        short uint8 = TlsUtils.readUint8(byteArrayInputStream);
        if (uint8 < 1) {
            throw new TlsFatalAlert((short) 47);
        }
        this.offeredCompressionMethods = TlsUtils.readUint8Array(uint8, byteArrayInputStream);
        this.clientExtensions = TlsProtocol.readExtensions(byteArrayInputStream);
        getContext().setClientVersion(version);
        this.tlsServer.notifyClientVersion(version);
        this.securityParameters.clientRandom = fully;
        this.tlsServer.notifyOfferedCipherSuites(this.offeredCipherSuites);
        this.tlsServer.notifyOfferedCompressionMethods(this.offeredCompressionMethods);
        if (Arrays.contains(this.offeredCipherSuites, 255)) {
            this.secure_renegotiation = true;
        }
        byte[] extensionData = TlsUtils.getExtensionData(this.clientExtensions, TlsProtocol.EXT_RenegotiationInfo);
        if (extensionData != null) {
            this.secure_renegotiation = true;
            if (!Arrays.constantTimeAreEqual(extensionData, TlsProtocol.createRenegotiationInfo(TlsUtils.EMPTY_BYTES))) {
                throw new TlsFatalAlert((short) 40);
            }
        }
        this.tlsServer.notifySecureRenegotiation(this.secure_renegotiation);
        Hashtable hashtable = this.clientExtensions;
        if (hashtable != null) {
            this.tlsServer.processClientExtensions(hashtable);
        }
    }

    public void receiveClientKeyExchangeMessage(ByteArrayInputStream byteArrayInputStream) throws Exception {
        this.keyExchange.processClientKeyExchange(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        TlsProtocol.establishMasterSecret(getContext(), this.keyExchange);
        this.recordStream.setPendingConnectionState(getPeer().getCompression(), getPeer().getCipher());
        this.prepareFinishHash = this.recordStream.prepareToFinish();
        if (this.expectSessionTicket) {
            return;
        }
        sendChangeCipherSpecMessage();
    }

    public void sendCertificateRequestMessage(CertificateRequest certificateRequest) throws Exception {
        TlsProtocol.HandshakeMessage handshakeMessage = new TlsProtocol.HandshakeMessage(this, (short) 13);
        certificateRequest.encode(handshakeMessage);
        handshakeMessage.writeToRecordStream();
    }

    public void sendCertificateStatusMessage(CertificateStatus certificateStatus) throws Exception {
        TlsProtocol.HandshakeMessage handshakeMessage = new TlsProtocol.HandshakeMessage(this, (short) 22);
        certificateStatus.encode(handshakeMessage);
        handshakeMessage.writeToRecordStream();
    }

    public void sendNewSessionTicketMessage(NewSessionTicket newSessionTicket) throws Exception {
        if (newSessionTicket == null) {
            throw new TlsFatalAlert((short) 80);
        }
        TlsProtocol.HandshakeMessage handshakeMessage = new TlsProtocol.HandshakeMessage(this, (short) 4);
        newSessionTicket.encode(handshakeMessage);
        handshakeMessage.writeToRecordStream();
    }

    public void sendServerHelloDoneMessage() throws Exception {
        byte[] bArr = new byte[4];
        TlsUtils.writeUint8((short) 14, bArr, 0);
        TlsUtils.writeUint24(0, bArr, 1);
        writeHandshakeMessage(bArr, 0, 4);
    }

    public void sendServerHelloMessage() throws Exception {
        TlsProtocol.HandshakeMessage handshakeMessage = new TlsProtocol.HandshakeMessage(this, (short) 2);
        ProtocolVersion serverVersion = this.tlsServer.getServerVersion();
        if (!serverVersion.isEqualOrEarlierVersionOf(getContext().getClientVersion())) {
            throw new TlsFatalAlert((short) 80);
        }
        this.recordStream.setReadVersion(serverVersion);
        this.recordStream.setWriteVersion(serverVersion);
        this.recordStream.setRestrictReadVersion(true);
        getContext().setServerVersion(serverVersion);
        TlsUtils.writeVersion(serverVersion, handshakeMessage);
        handshakeMessage.write(this.securityParameters.serverRandom);
        TlsUtils.writeOpaque8(TlsUtils.EMPTY_BYTES, handshakeMessage);
        int selectedCipherSuite = this.tlsServer.getSelectedCipherSuite();
        if (!Arrays.contains(this.offeredCipherSuites, selectedCipherSuite) || selectedCipherSuite == 0 || selectedCipherSuite == 255) {
            throw new TlsFatalAlert((short) 80);
        }
        this.securityParameters.cipherSuite = selectedCipherSuite;
        short selectedCompressionMethod = this.tlsServer.getSelectedCompressionMethod();
        if (!Arrays.contains(this.offeredCompressionMethods, selectedCompressionMethod)) {
            throw new TlsFatalAlert((short) 80);
        }
        this.securityParameters.compressionAlgorithm = selectedCompressionMethod;
        TlsUtils.writeUint16(selectedCipherSuite, handshakeMessage);
        TlsUtils.writeUint8(selectedCompressionMethod, (OutputStream) handshakeMessage);
        Hashtable serverExtensions = this.tlsServer.getServerExtensions();
        this.serverExtensions = serverExtensions;
        boolean z = false;
        if (this.secure_renegotiation) {
            Integer num = TlsProtocol.EXT_RenegotiationInfo;
            if (TlsUtils.getExtensionData(serverExtensions, num) == null) {
                Hashtable hashtableEnsureExtensionsInitialised = TlsExtensionsUtils.ensureExtensionsInitialised(this.serverExtensions);
                this.serverExtensions = hashtableEnsureExtensionsInitialised;
                hashtableEnsureExtensionsInitialised.put(num, TlsProtocol.createRenegotiationInfo(TlsUtils.EMPTY_BYTES));
            }
        }
        Hashtable hashtable = this.serverExtensions;
        if (hashtable != null) {
            this.securityParameters.maxFragmentLength = processMaxFragmentLengthExtension(this.clientExtensions, hashtable, (short) 80);
            this.securityParameters.truncatedHMac = TlsExtensionsUtils.hasTruncatedHMacExtension(this.serverExtensions);
            this.allowCertificateStatus = !this.resumedSession && TlsUtils.hasExpectedEmptyExtensionData(this.serverExtensions, TlsExtensionsUtils.EXT_status_request, (short) 80);
            if (!this.resumedSession && TlsUtils.hasExpectedEmptyExtensionData(this.serverExtensions, TlsProtocol.EXT_SessionTicket, (short) 80)) {
                z = true;
            }
            this.expectSessionTicket = z;
            TlsProtocol.writeExtensions(handshakeMessage, this.serverExtensions);
        }
        short s = this.securityParameters.maxFragmentLength;
        if (s >= 0) {
            this.recordStream.setPlaintextLimit(1 << (s + 8));
        }
        this.securityParameters.prfAlgorithm = TlsProtocol.getPRFAlgorithm(getContext(), this.securityParameters.getCipherSuite());
        this.securityParameters.verifyDataLength = 12;
        handshakeMessage.writeToRecordStream();
        this.recordStream.notifyHelloComplete();
    }

    public void sendServerKeyExchangeMessage(byte[] bArr) throws Exception {
        TlsProtocol.HandshakeMessage handshakeMessage = new TlsProtocol.HandshakeMessage((short) 12, bArr.length);
        handshakeMessage.write(bArr);
        handshakeMessage.writeToRecordStream();
    }
}
