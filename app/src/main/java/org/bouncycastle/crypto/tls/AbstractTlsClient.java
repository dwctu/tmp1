package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

/* loaded from: classes5.dex */
public abstract class AbstractTlsClient extends AbstractTlsPeer implements TlsClient {
    public TlsCipherFactory cipherFactory;
    public short[] clientECPointFormats;
    public TlsClientContext context;
    public int[] namedCurves;
    public int selectedCipherSuite;
    public short selectedCompressionMethod;
    public short[] serverECPointFormats;
    public Vector supportedSignatureAlgorithms;

    public AbstractTlsClient() {
        this(new DefaultTlsCipherFactory());
    }

    public AbstractTlsClient(TlsCipherFactory tlsCipherFactory) {
        this.cipherFactory = tlsCipherFactory;
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public Hashtable getClientExtensions() throws IOException {
        Hashtable hashtableEnsureExtensionsInitialised = null;
        if (TlsUtils.isSignatureAlgorithmsExtensionAllowed(this.context.getClientVersion())) {
            short[] sArr = {6, 5, 4, 3, 2};
            short[] sArr2 = {1};
            this.supportedSignatureAlgorithms = new Vector();
            for (int i = 0; i < 5; i++) {
                for (int i2 = 0; i2 < 1; i2++) {
                    this.supportedSignatureAlgorithms.addElement(new SignatureAndHashAlgorithm(sArr[i], sArr2[i2]));
                }
            }
            this.supportedSignatureAlgorithms.addElement(new SignatureAndHashAlgorithm((short) 2, (short) 2));
            hashtableEnsureExtensionsInitialised = TlsExtensionsUtils.ensureExtensionsInitialised(null);
            TlsUtils.addSignatureAlgorithmsExtension(hashtableEnsureExtensionsInitialised, this.supportedSignatureAlgorithms);
        }
        if (!TlsECCUtils.containsECCCipherSuites(getCipherSuites())) {
            return hashtableEnsureExtensionsInitialised;
        }
        this.namedCurves = new int[]{23, 24};
        this.clientECPointFormats = new short[]{0, 1, 2};
        Hashtable hashtableEnsureExtensionsInitialised2 = TlsExtensionsUtils.ensureExtensionsInitialised(hashtableEnsureExtensionsInitialised);
        TlsECCUtils.addSupportedEllipticCurvesExtension(hashtableEnsureExtensionsInitialised2, this.namedCurves);
        TlsECCUtils.addSupportedPointFormatsExtension(hashtableEnsureExtensionsInitialised2, this.clientECPointFormats);
        return hashtableEnsureExtensionsInitialised2;
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public ProtocolVersion getClientHelloRecordLayerVersion() {
        return getClientVersion();
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public Vector getClientSupplementalData() throws IOException {
        return null;
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public ProtocolVersion getClientVersion() {
        return ProtocolVersion.TLSv12;
    }

    @Override // org.bouncycastle.crypto.tls.TlsPeer
    public TlsCompression getCompression() throws IOException {
        if (this.selectedCompressionMethod == 0) {
            return new TlsNullCompression();
        }
        throw new TlsFatalAlert((short) 80);
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public short[] getCompressionMethods() {
        return new short[]{0};
    }

    public ProtocolVersion getMinimumVersion() {
        return ProtocolVersion.TLSv10;
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public TlsSession getSessionToResume() {
        return null;
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public void init(TlsClientContext tlsClientContext) {
        this.context = tlsClientContext;
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public void notifyNewSessionTicket(NewSessionTicket newSessionTicket) throws IOException {
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public void notifySelectedCipherSuite(int i) {
        this.selectedCipherSuite = i;
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public void notifySelectedCompressionMethod(short s) {
        this.selectedCompressionMethod = s;
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public void notifyServerVersion(ProtocolVersion protocolVersion) throws IOException {
        if (!getMinimumVersion().isEqualOrEarlierVersionOf(protocolVersion)) {
            throw new TlsFatalAlert((short) 70);
        }
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public void notifySessionID(byte[] bArr) {
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public void processServerExtensions(Hashtable hashtable) throws IOException {
        if (hashtable != null) {
            if (hashtable.containsKey(TlsUtils.EXT_signature_algorithms)) {
                throw new TlsFatalAlert((short) 47);
            }
            if (TlsECCUtils.getSupportedEllipticCurvesExtension(hashtable) != null) {
                throw new TlsFatalAlert((short) 47);
            }
            short[] supportedPointFormatsExtension = TlsECCUtils.getSupportedPointFormatsExtension(hashtable);
            this.serverECPointFormats = supportedPointFormatsExtension;
            if (supportedPointFormatsExtension != null && !TlsECCUtils.isECCCipherSuite(this.selectedCipherSuite)) {
                throw new TlsFatalAlert((short) 47);
            }
        }
    }

    @Override // org.bouncycastle.crypto.tls.TlsClient
    public void processServerSupplementalData(Vector vector) throws IOException {
        if (vector != null) {
            throw new TlsFatalAlert((short) 10);
        }
    }
}
