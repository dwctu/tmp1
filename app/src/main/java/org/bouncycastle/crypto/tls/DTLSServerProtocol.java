package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.tls.DTLSReliableHandshake;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.util.Arrays;

/* loaded from: classes5.dex */
public class DTLSServerProtocol extends DTLSProtocol {
    public boolean verifyRequests;

    public static class ServerHandshakeState {
        public Hashtable clientExtensions;
        public int[] offeredCipherSuites;
        public short[] offeredCompressionMethods;
        public TlsServer server = null;
        public TlsServerContextImpl serverContext = null;
        public int selectedCipherSuite = -1;
        public short selectedCompressionMethod = -1;
        public boolean secure_renegotiation = false;
        public short maxFragmentLength = -1;
        public boolean allowCertificateStatus = false;
        public boolean expectSessionTicket = false;
        public Hashtable serverExtensions = null;
        public TlsKeyExchange keyExchange = null;
        public TlsCredentials serverCredentials = null;
        public CertificateRequest certificateRequest = null;
        public short clientCertificateType = -1;
        public Certificate clientCertificate = null;
    }

    public DTLSServerProtocol(SecureRandom secureRandom) {
        super(secureRandom);
        this.verifyRequests = true;
    }

    public DTLSTransport accept(TlsServer tlsServer, DatagramTransport datagramTransport) throws IOException {
        if (tlsServer == null) {
            throw new IllegalArgumentException("'server' cannot be null");
        }
        if (datagramTransport == null) {
            throw new IllegalArgumentException("'transport' cannot be null");
        }
        SecurityParameters securityParameters = new SecurityParameters();
        securityParameters.entity = 0;
        securityParameters.serverRandom = TlsProtocol.createRandomBlock(this.secureRandom);
        ServerHandshakeState serverHandshakeState = new ServerHandshakeState();
        serverHandshakeState.server = tlsServer;
        TlsServerContextImpl tlsServerContextImpl = new TlsServerContextImpl(this.secureRandom, securityParameters);
        serverHandshakeState.serverContext = tlsServerContextImpl;
        tlsServer.init(tlsServerContextImpl);
        DTLSRecordLayer dTLSRecordLayer = new DTLSRecordLayer(datagramTransport, serverHandshakeState.serverContext, tlsServer, (short) 22);
        try {
            return serverHandshake(serverHandshakeState, dTLSRecordLayer);
        } catch (IOException e) {
            dTLSRecordLayer.fail((short) 80);
            throw e;
        } catch (RuntimeException unused) {
            dTLSRecordLayer.fail((short) 80);
            throw new TlsFatalAlert((short) 80);
        } catch (TlsFatalAlert e2) {
            dTLSRecordLayer.fail(e2.getAlertDescription());
            throw e2;
        }
    }

    public boolean expectCertificateVerifyMessage(ServerHandshakeState serverHandshakeState) {
        short s = serverHandshakeState.clientCertificateType;
        return s >= 0 && TlsUtils.hasSigningCapability(s);
    }

    public byte[] generateCertificateRequest(ServerHandshakeState serverHandshakeState, CertificateRequest certificateRequest) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        certificateRequest.encode(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] generateCertificateStatus(ServerHandshakeState serverHandshakeState, CertificateStatus certificateStatus) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        certificateStatus.encode(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] generateNewSessionTicket(ServerHandshakeState serverHandshakeState, NewSessionTicket newSessionTicket) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        newSessionTicket.encode(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] generateServerHello(ServerHandshakeState serverHandshakeState) throws IOException {
        int i;
        SecurityParameters securityParameters = serverHandshakeState.serverContext.getSecurityParameters();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ProtocolVersion serverVersion = serverHandshakeState.server.getServerVersion();
        if (!serverVersion.isEqualOrEarlierVersionOf(serverHandshakeState.serverContext.getClientVersion())) {
            throw new TlsFatalAlert((short) 80);
        }
        serverHandshakeState.serverContext.setServerVersion(serverVersion);
        TlsUtils.writeVersion(serverHandshakeState.serverContext.getServerVersion(), byteArrayOutputStream);
        byteArrayOutputStream.write(securityParameters.getServerRandom());
        TlsUtils.writeOpaque8(TlsUtils.EMPTY_BYTES, byteArrayOutputStream);
        int selectedCipherSuite = serverHandshakeState.server.getSelectedCipherSuite();
        serverHandshakeState.selectedCipherSuite = selectedCipherSuite;
        if (!Arrays.contains(serverHandshakeState.offeredCipherSuites, selectedCipherSuite) || (i = serverHandshakeState.selectedCipherSuite) == 0 || i == 255) {
            throw new TlsFatalAlert((short) 80);
        }
        DTLSProtocol.validateSelectedCipherSuite(i, (short) 80);
        short selectedCompressionMethod = serverHandshakeState.server.getSelectedCompressionMethod();
        serverHandshakeState.selectedCompressionMethod = selectedCompressionMethod;
        if (!Arrays.contains(serverHandshakeState.offeredCompressionMethods, selectedCompressionMethod)) {
            throw new TlsFatalAlert((short) 80);
        }
        TlsUtils.writeUint16(serverHandshakeState.selectedCipherSuite, byteArrayOutputStream);
        TlsUtils.writeUint8(serverHandshakeState.selectedCompressionMethod, (OutputStream) byteArrayOutputStream);
        Hashtable serverExtensions = serverHandshakeState.server.getServerExtensions();
        serverHandshakeState.serverExtensions = serverExtensions;
        if (serverHandshakeState.secure_renegotiation) {
            Integer num = TlsProtocol.EXT_RenegotiationInfo;
            if (TlsUtils.getExtensionData(serverExtensions, num) == null) {
                Hashtable hashtableEnsureExtensionsInitialised = TlsExtensionsUtils.ensureExtensionsInitialised(serverHandshakeState.serverExtensions);
                serverHandshakeState.serverExtensions = hashtableEnsureExtensionsInitialised;
                hashtableEnsureExtensionsInitialised.put(num, TlsProtocol.createRenegotiationInfo(TlsUtils.EMPTY_BYTES));
            }
        }
        Hashtable hashtable = serverHandshakeState.serverExtensions;
        if (hashtable != null) {
            serverHandshakeState.maxFragmentLength = DTLSProtocol.evaluateMaxFragmentLengthExtension(serverHandshakeState.clientExtensions, hashtable, (short) 80);
            securityParameters.truncatedHMac = TlsExtensionsUtils.hasTruncatedHMacExtension(serverHandshakeState.serverExtensions);
            serverHandshakeState.allowCertificateStatus = TlsUtils.hasExpectedEmptyExtensionData(serverHandshakeState.serverExtensions, TlsExtensionsUtils.EXT_status_request, (short) 80);
            serverHandshakeState.expectSessionTicket = TlsUtils.hasExpectedEmptyExtensionData(serverHandshakeState.serverExtensions, TlsProtocol.EXT_SessionTicket, (short) 80);
            TlsProtocol.writeExtensions(byteArrayOutputStream, serverHandshakeState.serverExtensions);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public boolean getVerifyRequests() {
        return this.verifyRequests;
    }

    public void notifyClientCertificate(ServerHandshakeState serverHandshakeState, Certificate certificate) throws IOException {
        if (serverHandshakeState.certificateRequest == null) {
            throw new IllegalStateException();
        }
        if (serverHandshakeState.clientCertificate != null) {
            throw new TlsFatalAlert((short) 10);
        }
        serverHandshakeState.clientCertificate = certificate;
        if (certificate.isEmpty()) {
            serverHandshakeState.keyExchange.skipClientCredentials();
        } else {
            serverHandshakeState.clientCertificateType = TlsUtils.getClientCertificateType(certificate, serverHandshakeState.serverCredentials.getCertificate());
            serverHandshakeState.keyExchange.processClientCertificate(certificate);
        }
        serverHandshakeState.server.notifyClientCertificate(certificate);
    }

    public void processCertificateVerify(ServerHandshakeState serverHandshakeState, byte[] bArr, TlsHandshakeHash tlsHandshakeHash) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        DigitallySigned digitallySigned = DigitallySigned.parse(serverHandshakeState.serverContext, byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        try {
            byte[] currentPRFHash = TlsProtocol.getCurrentPRFHash(serverHandshakeState.serverContext, tlsHandshakeHash, null);
            AsymmetricKeyParameter asymmetricKeyParameterCreateKey = PublicKeyFactory.createKey(serverHandshakeState.clientCertificate.getCertificateAt(0).getSubjectPublicKeyInfo());
            TlsSigner tlsSignerCreateTlsSigner = TlsUtils.createTlsSigner(serverHandshakeState.clientCertificateType);
            tlsSignerCreateTlsSigner.init(serverHandshakeState.serverContext);
            tlsSignerCreateTlsSigner.verifyRawSignature(digitallySigned.getAlgorithm(), digitallySigned.getSignature(), asymmetricKeyParameterCreateKey, currentPRFHash);
        } catch (Exception unused) {
            throw new TlsFatalAlert((short) 51);
        }
    }

    public void processClientCertificate(ServerHandshakeState serverHandshakeState, byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        Certificate certificate = Certificate.parse(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        notifyClientCertificate(serverHandshakeState, certificate);
    }

    public void processClientHello(ServerHandshakeState serverHandshakeState, byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ProtocolVersion version = TlsUtils.readVersion(byteArrayInputStream);
        if (!version.isDTLS()) {
            throw new TlsFatalAlert((short) 47);
        }
        byte[] fully = TlsUtils.readFully(32, byteArrayInputStream);
        if (TlsUtils.readOpaque8(byteArrayInputStream).length > 32) {
            throw new TlsFatalAlert((short) 47);
        }
        TlsUtils.readOpaque8(byteArrayInputStream);
        int uint16 = TlsUtils.readUint16(byteArrayInputStream);
        if (uint16 < 2 || (uint16 & 1) != 0) {
            throw new TlsFatalAlert((short) 50);
        }
        serverHandshakeState.offeredCipherSuites = TlsUtils.readUint16Array(uint16 / 2, byteArrayInputStream);
        short uint8 = TlsUtils.readUint8(byteArrayInputStream);
        if (uint8 < 1) {
            throw new TlsFatalAlert((short) 47);
        }
        serverHandshakeState.offeredCompressionMethods = TlsUtils.readUint8Array(uint8, byteArrayInputStream);
        serverHandshakeState.clientExtensions = TlsProtocol.readExtensions(byteArrayInputStream);
        serverHandshakeState.serverContext.setClientVersion(version);
        serverHandshakeState.server.notifyClientVersion(version);
        serverHandshakeState.serverContext.getSecurityParameters().clientRandom = fully;
        serverHandshakeState.server.notifyOfferedCipherSuites(serverHandshakeState.offeredCipherSuites);
        serverHandshakeState.server.notifyOfferedCompressionMethods(serverHandshakeState.offeredCompressionMethods);
        if (Arrays.contains(serverHandshakeState.offeredCipherSuites, 255)) {
            serverHandshakeState.secure_renegotiation = true;
        }
        byte[] extensionData = TlsUtils.getExtensionData(serverHandshakeState.clientExtensions, TlsProtocol.EXT_RenegotiationInfo);
        if (extensionData != null) {
            serverHandshakeState.secure_renegotiation = true;
            if (!Arrays.constantTimeAreEqual(extensionData, TlsProtocol.createRenegotiationInfo(TlsUtils.EMPTY_BYTES))) {
                throw new TlsFatalAlert((short) 40);
            }
        }
        serverHandshakeState.server.notifySecureRenegotiation(serverHandshakeState.secure_renegotiation);
        Hashtable hashtable = serverHandshakeState.clientExtensions;
        if (hashtable != null) {
            serverHandshakeState.server.processClientExtensions(hashtable);
        }
    }

    public void processClientKeyExchange(ServerHandshakeState serverHandshakeState, byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        serverHandshakeState.keyExchange.processClientKeyExchange(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
    }

    public void processClientSupplementalData(ServerHandshakeState serverHandshakeState, byte[] bArr) throws IOException {
        serverHandshakeState.server.processClientSupplementalData(TlsProtocol.readSupplementalDataMessage(new ByteArrayInputStream(bArr)));
    }

    public DTLSTransport serverHandshake(ServerHandshakeState serverHandshakeState, DTLSRecordLayer dTLSRecordLayer) throws IOException {
        Certificate certificate;
        CertificateStatus certificateStatus;
        SecurityParameters securityParameters = serverHandshakeState.serverContext.getSecurityParameters();
        DTLSReliableHandshake dTLSReliableHandshake = new DTLSReliableHandshake(serverHandshakeState.serverContext, dTLSRecordLayer);
        DTLSReliableHandshake.Message messageReceiveMessage = dTLSReliableHandshake.receiveMessage();
        serverHandshakeState.serverContext.setClientVersion(dTLSRecordLayer.getDiscoveredPeerVersion());
        if (messageReceiveMessage.getType() != 1) {
            throw new TlsFatalAlert((short) 10);
        }
        processClientHello(serverHandshakeState, messageReceiveMessage.getBody());
        byte[] bArrGenerateServerHello = generateServerHello(serverHandshakeState);
        short s = serverHandshakeState.maxFragmentLength;
        if (s >= 0) {
            dTLSRecordLayer.setPlaintextLimit(1 << (s + 8));
        }
        int i = serverHandshakeState.selectedCipherSuite;
        securityParameters.cipherSuite = i;
        securityParameters.compressionAlgorithm = serverHandshakeState.selectedCompressionMethod;
        securityParameters.prfAlgorithm = TlsProtocol.getPRFAlgorithm(serverHandshakeState.serverContext, i);
        securityParameters.verifyDataLength = 12;
        dTLSReliableHandshake.sendMessage((short) 2, bArrGenerateServerHello);
        dTLSReliableHandshake.notifyHelloComplete();
        Vector serverSupplementalData = serverHandshakeState.server.getServerSupplementalData();
        if (serverSupplementalData != null) {
            dTLSReliableHandshake.sendMessage((short) 23, DTLSProtocol.generateSupplementalData(serverSupplementalData));
        }
        TlsKeyExchange keyExchange = serverHandshakeState.server.getKeyExchange();
        serverHandshakeState.keyExchange = keyExchange;
        keyExchange.init(serverHandshakeState.serverContext);
        TlsCredentials credentials = serverHandshakeState.server.getCredentials();
        serverHandshakeState.serverCredentials = credentials;
        if (credentials == null) {
            serverHandshakeState.keyExchange.skipServerCredentials();
            certificate = null;
        } else {
            serverHandshakeState.keyExchange.processServerCredentials(credentials);
            certificate = serverHandshakeState.serverCredentials.getCertificate();
            dTLSReliableHandshake.sendMessage((short) 11, DTLSProtocol.generateCertificate(certificate));
        }
        if (certificate == null || certificate.isEmpty()) {
            serverHandshakeState.allowCertificateStatus = false;
        }
        if (serverHandshakeState.allowCertificateStatus && (certificateStatus = serverHandshakeState.server.getCertificateStatus()) != null) {
            dTLSReliableHandshake.sendMessage((short) 22, generateCertificateStatus(serverHandshakeState, certificateStatus));
        }
        byte[] bArrGenerateServerKeyExchange = serverHandshakeState.keyExchange.generateServerKeyExchange();
        if (bArrGenerateServerKeyExchange != null) {
            dTLSReliableHandshake.sendMessage((short) 12, bArrGenerateServerKeyExchange);
        }
        if (serverHandshakeState.serverCredentials != null) {
            CertificateRequest certificateRequest = serverHandshakeState.server.getCertificateRequest();
            serverHandshakeState.certificateRequest = certificateRequest;
            if (certificateRequest != null) {
                serverHandshakeState.keyExchange.validateCertificateRequest(certificateRequest);
                dTLSReliableHandshake.sendMessage((short) 13, generateCertificateRequest(serverHandshakeState, serverHandshakeState.certificateRequest));
                TlsUtils.trackHashAlgorithms(dTLSReliableHandshake.getHandshakeHash(), serverHandshakeState.certificateRequest.getSupportedSignatureAlgorithms());
            }
        }
        dTLSReliableHandshake.sendMessage((short) 14, TlsUtils.EMPTY_BYTES);
        dTLSReliableHandshake.getHandshakeHash().sealHashAlgorithms();
        DTLSReliableHandshake.Message messageReceiveMessage2 = dTLSReliableHandshake.receiveMessage();
        if (messageReceiveMessage2.getType() == 23) {
            processClientSupplementalData(serverHandshakeState, messageReceiveMessage2.getBody());
            messageReceiveMessage2 = dTLSReliableHandshake.receiveMessage();
        } else {
            serverHandshakeState.server.processClientSupplementalData(null);
        }
        if (serverHandshakeState.certificateRequest == null) {
            serverHandshakeState.keyExchange.skipClientCredentials();
        } else if (messageReceiveMessage2.getType() == 11) {
            processClientCertificate(serverHandshakeState, messageReceiveMessage2.getBody());
            messageReceiveMessage2 = dTLSReliableHandshake.receiveMessage();
        } else {
            if (TlsUtils.isTLSv12(serverHandshakeState.serverContext)) {
                throw new TlsFatalAlert((short) 10);
            }
            notifyClientCertificate(serverHandshakeState, Certificate.EMPTY_CHAIN);
        }
        if (messageReceiveMessage2.getType() != 16) {
            throw new TlsFatalAlert((short) 10);
        }
        processClientKeyExchange(serverHandshakeState, messageReceiveMessage2.getBody());
        TlsProtocol.establishMasterSecret(serverHandshakeState.serverContext, serverHandshakeState.keyExchange);
        dTLSRecordLayer.initPendingEpoch(serverHandshakeState.server.getCipher());
        TlsHandshakeHash tlsHandshakeHashPrepareToFinish = dTLSReliableHandshake.prepareToFinish();
        if (expectCertificateVerifyMessage(serverHandshakeState)) {
            processCertificateVerify(serverHandshakeState, dTLSReliableHandshake.receiveMessageBody((short) 15), tlsHandshakeHashPrepareToFinish);
        }
        TlsServerContextImpl tlsServerContextImpl = serverHandshakeState.serverContext;
        processFinished(dTLSReliableHandshake.receiveMessageBody((short) 20), TlsUtils.calculateVerifyData(tlsServerContextImpl, ExporterLabel.client_finished, TlsProtocol.getCurrentPRFHash(tlsServerContextImpl, dTLSReliableHandshake.getHandshakeHash(), null)));
        if (serverHandshakeState.expectSessionTicket) {
            dTLSReliableHandshake.sendMessage((short) 4, generateNewSessionTicket(serverHandshakeState, serverHandshakeState.server.getNewSessionTicket()));
        }
        TlsServerContextImpl tlsServerContextImpl2 = serverHandshakeState.serverContext;
        dTLSReliableHandshake.sendMessage((short) 20, TlsUtils.calculateVerifyData(tlsServerContextImpl2, ExporterLabel.server_finished, TlsProtocol.getCurrentPRFHash(tlsServerContextImpl2, dTLSReliableHandshake.getHandshakeHash(), null)));
        dTLSReliableHandshake.finish();
        serverHandshakeState.server.notifyHandshakeComplete();
        return new DTLSTransport(dTLSRecordLayer);
    }

    public void setVerifyRequests(boolean z) {
        this.verifyRequests = z;
    }
}
