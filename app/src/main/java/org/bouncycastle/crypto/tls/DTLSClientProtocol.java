package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.crypto.tls.DTLSReliableHandshake;
import org.bouncycastle.crypto.tls.SessionParameters;
import org.bouncycastle.util.Arrays;

/* loaded from: classes5.dex */
public class DTLSClientProtocol extends DTLSProtocol {

    public static class ClientHandshakeState {
        public TlsClient client = null;
        public TlsClientContextImpl clientContext = null;
        public TlsSession tlsSession = null;
        public SessionParameters sessionParameters = null;
        public SessionParameters.Builder sessionParametersBuilder = null;
        public int[] offeredCipherSuites = null;
        public short[] offeredCompressionMethods = null;
        public Hashtable clientExtensions = null;
        public byte[] selectedSessionID = null;
        public int selectedCipherSuite = -1;
        public short selectedCompressionMethod = -1;
        public boolean secure_renegotiation = false;
        public short maxFragmentLength = -1;
        public boolean allowCertificateStatus = false;
        public boolean expectSessionTicket = false;
        public TlsKeyExchange keyExchange = null;
        public TlsAuthentication authentication = null;
        public CertificateStatus certificateStatus = null;
        public CertificateRequest certificateRequest = null;
        public TlsCredentials clientCredentials = null;
    }

    public DTLSClientProtocol(SecureRandom secureRandom) {
        super(secureRandom);
    }

    public static byte[] patchClientHelloWithCookie(byte[] bArr, byte[] bArr2) throws IOException {
        int uint8 = 35 + TlsUtils.readUint8(bArr, 34);
        int i = uint8 + 1;
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, uint8);
        TlsUtils.checkUint8(bArr2.length);
        TlsUtils.writeUint8(bArr2.length, bArr3, uint8);
        System.arraycopy(bArr2, 0, bArr3, i, bArr2.length);
        System.arraycopy(bArr, i, bArr3, bArr2.length + i, bArr.length - i);
        return bArr3;
    }

    public DTLSTransport clientHandshake(ClientHandshakeState clientHandshakeState, DTLSRecordLayer dTLSRecordLayer) throws IOException {
        DTLSReliableHandshake.Message messageReceiveMessage;
        Certificate certificateProcessServerCertificate;
        byte[] currentPRFHash;
        SignatureAndHashAlgorithm signatureAndHashAlgorithm;
        TlsSession tlsSession;
        SecurityParameters securityParameters = clientHandshakeState.clientContext.getSecurityParameters();
        DTLSReliableHandshake dTLSReliableHandshake = new DTLSReliableHandshake(clientHandshakeState.clientContext, dTLSRecordLayer);
        byte[] bArrGenerateClientHello = generateClientHello(clientHandshakeState, clientHandshakeState.client);
        dTLSReliableHandshake.sendMessage((short) 1, bArrGenerateClientHello);
        while (true) {
            DTLSReliableHandshake.Message messageReceiveMessage2 = dTLSReliableHandshake.receiveMessage();
            if (messageReceiveMessage2.getType() != 3) {
                if (messageReceiveMessage2.getType() != 2) {
                    throw new TlsFatalAlert((short) 10);
                }
                reportServerVersion(clientHandshakeState, dTLSRecordLayer.getDiscoveredPeerVersion());
                processServerHello(clientHandshakeState, messageReceiveMessage2.getBody());
                short s = clientHandshakeState.maxFragmentLength;
                if (s >= 0) {
                    dTLSRecordLayer.setPlaintextLimit(1 << (s + 8));
                }
                int i = clientHandshakeState.selectedCipherSuite;
                securityParameters.cipherSuite = i;
                securityParameters.compressionAlgorithm = clientHandshakeState.selectedCompressionMethod;
                securityParameters.prfAlgorithm = TlsProtocol.getPRFAlgorithm(clientHandshakeState.clientContext, i);
                securityParameters.verifyDataLength = 12;
                dTLSReliableHandshake.notifyHelloComplete();
                byte[] bArr = clientHandshakeState.selectedSessionID;
                if (bArr.length > 0 && (tlsSession = clientHandshakeState.tlsSession) != null && Arrays.areEqual(bArr, tlsSession.getSessionID())) {
                    if (securityParameters.getCipherSuite() != clientHandshakeState.sessionParameters.getCipherSuite() || securityParameters.getCompressionAlgorithm() != clientHandshakeState.sessionParameters.getCompressionAlgorithm()) {
                        throw new TlsFatalAlert((short) 47);
                    }
                    securityParameters.masterSecret = Arrays.clone(clientHandshakeState.sessionParameters.getMasterSecret());
                    dTLSRecordLayer.initPendingEpoch(clientHandshakeState.client.getCipher());
                    TlsClientContextImpl tlsClientContextImpl = clientHandshakeState.clientContext;
                    processFinished(dTLSReliableHandshake.receiveMessageBody((short) 20), TlsUtils.calculateVerifyData(tlsClientContextImpl, ExporterLabel.server_finished, TlsProtocol.getCurrentPRFHash(tlsClientContextImpl, dTLSReliableHandshake.getHandshakeHash(), null)));
                    TlsClientContextImpl tlsClientContextImpl2 = clientHandshakeState.clientContext;
                    dTLSReliableHandshake.sendMessage((short) 20, TlsUtils.calculateVerifyData(tlsClientContextImpl2, ExporterLabel.client_finished, TlsProtocol.getCurrentPRFHash(tlsClientContextImpl2, dTLSReliableHandshake.getHandshakeHash(), null)));
                    dTLSReliableHandshake.finish();
                    clientHandshakeState.clientContext.setResumableSession(clientHandshakeState.tlsSession);
                    clientHandshakeState.client.notifyHandshakeComplete();
                    return new DTLSTransport(dTLSRecordLayer);
                }
                invalidateSession(clientHandshakeState);
                byte[] bArr2 = clientHandshakeState.selectedSessionID;
                if (bArr2.length > 0) {
                    clientHandshakeState.tlsSession = new TlsSessionImpl(bArr2, null);
                }
                DTLSReliableHandshake.Message messageReceiveMessage3 = dTLSReliableHandshake.receiveMessage();
                if (messageReceiveMessage3.getType() == 23) {
                    processServerSupplementalData(clientHandshakeState, messageReceiveMessage3.getBody());
                    messageReceiveMessage3 = dTLSReliableHandshake.receiveMessage();
                } else {
                    clientHandshakeState.client.processServerSupplementalData(null);
                }
                TlsKeyExchange keyExchange = clientHandshakeState.client.getKeyExchange();
                clientHandshakeState.keyExchange = keyExchange;
                keyExchange.init(clientHandshakeState.clientContext);
                if (messageReceiveMessage3.getType() == 11) {
                    certificateProcessServerCertificate = processServerCertificate(clientHandshakeState, messageReceiveMessage3.getBody());
                    messageReceiveMessage = dTLSReliableHandshake.receiveMessage();
                } else {
                    clientHandshakeState.keyExchange.skipServerCredentials();
                    messageReceiveMessage = messageReceiveMessage3;
                    certificateProcessServerCertificate = null;
                }
                if (certificateProcessServerCertificate == null || certificateProcessServerCertificate.isEmpty()) {
                    clientHandshakeState.allowCertificateStatus = false;
                }
                if (messageReceiveMessage.getType() == 22) {
                    processCertificateStatus(clientHandshakeState, messageReceiveMessage.getBody());
                    messageReceiveMessage = dTLSReliableHandshake.receiveMessage();
                }
                if (messageReceiveMessage.getType() == 12) {
                    processServerKeyExchange(clientHandshakeState, messageReceiveMessage.getBody());
                    messageReceiveMessage = dTLSReliableHandshake.receiveMessage();
                } else {
                    clientHandshakeState.keyExchange.skipServerKeyExchange();
                }
                if (messageReceiveMessage.getType() == 13) {
                    processCertificateRequest(clientHandshakeState, messageReceiveMessage.getBody());
                    TlsUtils.trackHashAlgorithms(dTLSReliableHandshake.getHandshakeHash(), clientHandshakeState.certificateRequest.getSupportedSignatureAlgorithms());
                    messageReceiveMessage = dTLSReliableHandshake.receiveMessage();
                }
                if (messageReceiveMessage.getType() != 14) {
                    throw new TlsFatalAlert((short) 10);
                }
                if (messageReceiveMessage.getBody().length != 0) {
                    throw new TlsFatalAlert((short) 50);
                }
                dTLSReliableHandshake.getHandshakeHash().sealHashAlgorithms();
                Vector clientSupplementalData = clientHandshakeState.client.getClientSupplementalData();
                if (clientSupplementalData != null) {
                    dTLSReliableHandshake.sendMessage((short) 23, DTLSProtocol.generateSupplementalData(clientSupplementalData));
                }
                CertificateRequest certificateRequest = clientHandshakeState.certificateRequest;
                if (certificateRequest != null) {
                    TlsCredentials clientCredentials = clientHandshakeState.authentication.getClientCredentials(certificateRequest);
                    clientHandshakeState.clientCredentials = clientCredentials;
                    Certificate certificate = clientCredentials != null ? clientCredentials.getCertificate() : null;
                    if (certificate == null) {
                        certificate = Certificate.EMPTY_CHAIN;
                    }
                    dTLSReliableHandshake.sendMessage((short) 11, DTLSProtocol.generateCertificate(certificate));
                }
                TlsCredentials tlsCredentials = clientHandshakeState.clientCredentials;
                if (tlsCredentials != null) {
                    clientHandshakeState.keyExchange.processClientCredentials(tlsCredentials);
                } else {
                    clientHandshakeState.keyExchange.skipClientCredentials();
                }
                dTLSReliableHandshake.sendMessage((short) 16, generateClientKeyExchange(clientHandshakeState));
                TlsProtocol.establishMasterSecret(clientHandshakeState.clientContext, clientHandshakeState.keyExchange);
                dTLSRecordLayer.initPendingEpoch(clientHandshakeState.client.getCipher());
                TlsHandshakeHash tlsHandshakeHashPrepareToFinish = dTLSReliableHandshake.prepareToFinish();
                TlsCredentials tlsCredentials2 = clientHandshakeState.clientCredentials;
                if (tlsCredentials2 != null && (tlsCredentials2 instanceof TlsSignerCredentials)) {
                    TlsSignerCredentials tlsSignerCredentials = (TlsSignerCredentials) tlsCredentials2;
                    if (TlsUtils.isTLSv12(clientHandshakeState.clientContext)) {
                        signatureAndHashAlgorithm = tlsSignerCredentials.getSignatureAndHashAlgorithm();
                        if (signatureAndHashAlgorithm == null) {
                            throw new TlsFatalAlert((short) 80);
                        }
                        currentPRFHash = tlsHandshakeHashPrepareToFinish.getFinalHash(signatureAndHashAlgorithm.getHash());
                    } else {
                        currentPRFHash = TlsProtocol.getCurrentPRFHash(clientHandshakeState.clientContext, tlsHandshakeHashPrepareToFinish, null);
                        signatureAndHashAlgorithm = null;
                    }
                    dTLSReliableHandshake.sendMessage((short) 15, generateCertificateVerify(clientHandshakeState, new DigitallySigned(signatureAndHashAlgorithm, tlsSignerCredentials.generateCertificateSignature(currentPRFHash))));
                }
                TlsClientContextImpl tlsClientContextImpl3 = clientHandshakeState.clientContext;
                dTLSReliableHandshake.sendMessage((short) 20, TlsUtils.calculateVerifyData(tlsClientContextImpl3, ExporterLabel.client_finished, TlsProtocol.getCurrentPRFHash(tlsClientContextImpl3, dTLSReliableHandshake.getHandshakeHash(), null)));
                if (clientHandshakeState.expectSessionTicket) {
                    DTLSReliableHandshake.Message messageReceiveMessage4 = dTLSReliableHandshake.receiveMessage();
                    if (messageReceiveMessage4.getType() != 4) {
                        throw new TlsFatalAlert((short) 10);
                    }
                    processNewSessionTicket(clientHandshakeState, messageReceiveMessage4.getBody());
                }
                TlsClientContextImpl tlsClientContextImpl4 = clientHandshakeState.clientContext;
                processFinished(dTLSReliableHandshake.receiveMessageBody((short) 20), TlsUtils.calculateVerifyData(tlsClientContextImpl4, ExporterLabel.server_finished, TlsProtocol.getCurrentPRFHash(tlsClientContextImpl4, dTLSReliableHandshake.getHandshakeHash(), null)));
                dTLSReliableHandshake.finish();
                if (clientHandshakeState.tlsSession != null) {
                    clientHandshakeState.sessionParameters = new SessionParameters.Builder().setCipherSuite(securityParameters.cipherSuite).setCompressionAlgorithm(securityParameters.compressionAlgorithm).setMasterSecret(securityParameters.masterSecret).setPeerCertificate(certificateProcessServerCertificate).build();
                    TlsSession tlsSessionImportSession = TlsUtils.importSession(clientHandshakeState.tlsSession.getSessionID(), clientHandshakeState.sessionParameters);
                    clientHandshakeState.tlsSession = tlsSessionImportSession;
                    clientHandshakeState.clientContext.setResumableSession(tlsSessionImportSession);
                }
                clientHandshakeState.client.notifyHandshakeComplete();
                return new DTLSTransport(dTLSRecordLayer);
            }
            if (!dTLSRecordLayer.resetDiscoveredPeerVersion().isEqualOrEarlierVersionOf(clientHandshakeState.clientContext.getClientVersion())) {
                throw new TlsFatalAlert((short) 47);
            }
            byte[] bArrPatchClientHelloWithCookie = patchClientHelloWithCookie(bArrGenerateClientHello, processHelloVerifyRequest(clientHandshakeState, messageReceiveMessage2.getBody()));
            dTLSReliableHandshake.resetHandshakeMessagesDigest();
            dTLSReliableHandshake.sendMessage((short) 1, bArrPatchClientHelloWithCookie);
        }
    }

    public DTLSTransport connect(TlsClient tlsClient, DatagramTransport datagramTransport) throws IOException {
        SessionParameters sessionParametersExportSessionParameters;
        if (tlsClient == null) {
            throw new IllegalArgumentException("'client' cannot be null");
        }
        if (datagramTransport == null) {
            throw new IllegalArgumentException("'transport' cannot be null");
        }
        SecurityParameters securityParameters = new SecurityParameters();
        securityParameters.entity = 1;
        securityParameters.clientRandom = TlsProtocol.createRandomBlock(this.secureRandom);
        ClientHandshakeState clientHandshakeState = new ClientHandshakeState();
        clientHandshakeState.client = tlsClient;
        TlsClientContextImpl tlsClientContextImpl = new TlsClientContextImpl(this.secureRandom, securityParameters);
        clientHandshakeState.clientContext = tlsClientContextImpl;
        tlsClient.init(tlsClientContextImpl);
        DTLSRecordLayer dTLSRecordLayer = new DTLSRecordLayer(datagramTransport, clientHandshakeState.clientContext, tlsClient, (short) 22);
        TlsSession sessionToResume = clientHandshakeState.client.getSessionToResume();
        if (sessionToResume != null && (sessionParametersExportSessionParameters = sessionToResume.exportSessionParameters()) != null) {
            clientHandshakeState.tlsSession = sessionToResume;
            clientHandshakeState.sessionParameters = sessionParametersExportSessionParameters;
        }
        try {
            return clientHandshake(clientHandshakeState, dTLSRecordLayer);
        } catch (RuntimeException unused) {
            dTLSRecordLayer.fail((short) 80);
            throw new TlsFatalAlert((short) 80);
        } catch (TlsFatalAlert e) {
            dTLSRecordLayer.fail(e.getAlertDescription());
            throw e;
        } catch (IOException e2) {
            dTLSRecordLayer.fail((short) 80);
            throw e2;
        }
    }

    public byte[] generateCertificateVerify(ClientHandshakeState clientHandshakeState, DigitallySigned digitallySigned) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        digitallySigned.encode(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] generateClientHello(ClientHandshakeState clientHandshakeState, TlsClient tlsClient) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ProtocolVersion clientVersion = tlsClient.getClientVersion();
        if (!clientVersion.isDTLS()) {
            throw new TlsFatalAlert((short) 80);
        }
        clientHandshakeState.clientContext.setClientVersion(clientVersion);
        TlsUtils.writeVersion(clientVersion, byteArrayOutputStream);
        byteArrayOutputStream.write(clientHandshakeState.clientContext.getSecurityParameters().getClientRandom());
        byte[] sessionID = TlsUtils.EMPTY_BYTES;
        TlsSession tlsSession = clientHandshakeState.tlsSession;
        if (tlsSession != null && ((sessionID = tlsSession.getSessionID()) == null || sessionID.length > 32)) {
            sessionID = TlsUtils.EMPTY_BYTES;
        }
        TlsUtils.writeOpaque8(sessionID, byteArrayOutputStream);
        TlsUtils.writeOpaque8(TlsUtils.EMPTY_BYTES, byteArrayOutputStream);
        clientHandshakeState.offeredCipherSuites = tlsClient.getCipherSuites();
        Hashtable clientExtensions = tlsClient.getClientExtensions();
        clientHandshakeState.clientExtensions = clientExtensions;
        boolean z = TlsUtils.getExtensionData(clientExtensions, TlsProtocol.EXT_RenegotiationInfo) == null;
        boolean z2 = !Arrays.contains(clientHandshakeState.offeredCipherSuites, 255);
        if (z && z2) {
            clientHandshakeState.offeredCipherSuites = Arrays.append(clientHandshakeState.offeredCipherSuites, 255);
        }
        TlsUtils.writeUint16ArrayWithUint16Length(clientHandshakeState.offeredCipherSuites, byteArrayOutputStream);
        short[] sArr = {0};
        clientHandshakeState.offeredCompressionMethods = sArr;
        TlsUtils.writeUint8ArrayWithUint8Length(sArr, byteArrayOutputStream);
        Hashtable hashtable = clientHandshakeState.clientExtensions;
        if (hashtable != null) {
            TlsProtocol.writeExtensions(byteArrayOutputStream, hashtable);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] generateClientKeyExchange(ClientHandshakeState clientHandshakeState) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        clientHandshakeState.keyExchange.generateClientKeyExchange(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public void invalidateSession(ClientHandshakeState clientHandshakeState) {
        SessionParameters sessionParameters = clientHandshakeState.sessionParameters;
        if (sessionParameters != null) {
            sessionParameters.clear();
            clientHandshakeState.sessionParameters = null;
        }
        TlsSession tlsSession = clientHandshakeState.tlsSession;
        if (tlsSession != null) {
            tlsSession.invalidate();
            clientHandshakeState.tlsSession = null;
        }
    }

    public void processCertificateRequest(ClientHandshakeState clientHandshakeState, byte[] bArr) throws IOException {
        if (clientHandshakeState.authentication == null) {
            throw new TlsFatalAlert((short) 40);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        clientHandshakeState.certificateRequest = CertificateRequest.parse(clientHandshakeState.clientContext, byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        clientHandshakeState.keyExchange.validateCertificateRequest(clientHandshakeState.certificateRequest);
    }

    public void processCertificateStatus(ClientHandshakeState clientHandshakeState, byte[] bArr) throws IOException {
        if (!clientHandshakeState.allowCertificateStatus) {
            throw new TlsFatalAlert((short) 10);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        clientHandshakeState.certificateStatus = CertificateStatus.parse(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
    }

    public byte[] processHelloVerifyRequest(ClientHandshakeState clientHandshakeState, byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ProtocolVersion version = TlsUtils.readVersion(byteArrayInputStream);
        byte[] opaque8 = TlsUtils.readOpaque8(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        if (!version.isEqualOrEarlierVersionOf(clientHandshakeState.clientContext.getClientVersion())) {
            throw new TlsFatalAlert((short) 47);
        }
        if (ProtocolVersion.DTLSv12.isEqualOrEarlierVersionOf(version) || opaque8.length <= 32) {
            return opaque8;
        }
        throw new TlsFatalAlert((short) 47);
    }

    public void processNewSessionTicket(ClientHandshakeState clientHandshakeState, byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        NewSessionTicket newSessionTicket = NewSessionTicket.parse(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        clientHandshakeState.client.notifyNewSessionTicket(newSessionTicket);
    }

    public Certificate processServerCertificate(ClientHandshakeState clientHandshakeState, byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        Certificate certificate = Certificate.parse(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        clientHandshakeState.keyExchange.processServerCertificate(certificate);
        TlsAuthentication authentication = clientHandshakeState.client.getAuthentication();
        clientHandshakeState.authentication = authentication;
        authentication.notifyServerCertificate(certificate);
        return certificate;
    }

    public void processServerHello(ClientHandshakeState clientHandshakeState, byte[] bArr) throws IOException {
        int i;
        SecurityParameters securityParameters = clientHandshakeState.clientContext.getSecurityParameters();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        reportServerVersion(clientHandshakeState, TlsUtils.readVersion(byteArrayInputStream));
        securityParameters.serverRandom = TlsUtils.readFully(32, byteArrayInputStream);
        byte[] opaque8 = TlsUtils.readOpaque8(byteArrayInputStream);
        clientHandshakeState.selectedSessionID = opaque8;
        if (opaque8.length > 32) {
            throw new TlsFatalAlert((short) 47);
        }
        clientHandshakeState.client.notifySessionID(opaque8);
        int uint16 = TlsUtils.readUint16(byteArrayInputStream);
        clientHandshakeState.selectedCipherSuite = uint16;
        if (!Arrays.contains(clientHandshakeState.offeredCipherSuites, uint16) || (i = clientHandshakeState.selectedCipherSuite) == 0 || i == 255) {
            throw new TlsFatalAlert((short) 47);
        }
        DTLSProtocol.validateSelectedCipherSuite(i, (short) 47);
        clientHandshakeState.client.notifySelectedCipherSuite(clientHandshakeState.selectedCipherSuite);
        short uint8 = TlsUtils.readUint8(byteArrayInputStream);
        clientHandshakeState.selectedCompressionMethod = uint8;
        if (!Arrays.contains(clientHandshakeState.offeredCompressionMethods, uint8)) {
            throw new TlsFatalAlert((short) 47);
        }
        clientHandshakeState.client.notifySelectedCompressionMethod(clientHandshakeState.selectedCompressionMethod);
        Hashtable extensions = TlsProtocol.readExtensions(byteArrayInputStream);
        if (extensions != null) {
            Enumeration enumerationKeys = extensions.keys();
            while (enumerationKeys.hasMoreElements()) {
                Integer num = (Integer) enumerationKeys.nextElement();
                if (!num.equals(TlsProtocol.EXT_RenegotiationInfo) && TlsUtils.getExtensionData(clientHandshakeState.clientExtensions, num) == null) {
                    throw new TlsFatalAlert(AlertDescription.unsupported_extension);
                }
            }
            byte[] bArr2 = (byte[]) extensions.get(TlsProtocol.EXT_RenegotiationInfo);
            if (bArr2 != null) {
                clientHandshakeState.secure_renegotiation = true;
                if (!Arrays.constantTimeAreEqual(bArr2, TlsProtocol.createRenegotiationInfo(TlsUtils.EMPTY_BYTES))) {
                    throw new TlsFatalAlert((short) 40);
                }
            }
            clientHandshakeState.maxFragmentLength = DTLSProtocol.evaluateMaxFragmentLengthExtension(clientHandshakeState.clientExtensions, extensions, (short) 47);
            securityParameters.truncatedHMac = TlsExtensionsUtils.hasTruncatedHMacExtension(extensions);
            clientHandshakeState.allowCertificateStatus = TlsUtils.hasExpectedEmptyExtensionData(extensions, TlsExtensionsUtils.EXT_status_request, (short) 47);
            clientHandshakeState.expectSessionTicket = TlsUtils.hasExpectedEmptyExtensionData(extensions, TlsProtocol.EXT_SessionTicket, (short) 47);
        }
        clientHandshakeState.client.notifySecureRenegotiation(clientHandshakeState.secure_renegotiation);
        if (clientHandshakeState.clientExtensions != null) {
            clientHandshakeState.client.processServerExtensions(extensions);
        }
    }

    public void processServerKeyExchange(ClientHandshakeState clientHandshakeState, byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        clientHandshakeState.keyExchange.processServerKeyExchange(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
    }

    public void processServerSupplementalData(ClientHandshakeState clientHandshakeState, byte[] bArr) throws IOException {
        clientHandshakeState.client.processServerSupplementalData(TlsProtocol.readSupplementalDataMessage(new ByteArrayInputStream(bArr)));
    }

    public void reportServerVersion(ClientHandshakeState clientHandshakeState, ProtocolVersion protocolVersion) throws IOException {
        TlsClientContextImpl tlsClientContextImpl = clientHandshakeState.clientContext;
        ProtocolVersion serverVersion = tlsClientContextImpl.getServerVersion();
        if (serverVersion == null) {
            tlsClientContextImpl.setServerVersion(protocolVersion);
            clientHandshakeState.client.notifyServerVersion(protocolVersion);
        } else if (!serverVersion.equals(protocolVersion)) {
            throw new TlsFatalAlert((short) 47);
        }
    }
}
