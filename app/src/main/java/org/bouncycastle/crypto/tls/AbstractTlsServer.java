package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.util.Arrays;

/* loaded from: classes5.dex */
public abstract class AbstractTlsServer extends AbstractTlsPeer implements TlsServer {
    public TlsCipherFactory cipherFactory;
    public short[] clientECPointFormats;
    public Hashtable clientExtensions;
    public ProtocolVersion clientVersion;
    public TlsServerContext context;
    public boolean eccCipherSuitesOffered;
    public short maxFragmentLengthOffered;
    public int[] namedCurves;
    public int[] offeredCipherSuites;
    public short[] offeredCompressionMethods;
    public int selectedCipherSuite;
    public short selectedCompressionMethod;
    public short[] serverECPointFormats;
    public Hashtable serverExtensions;
    public ProtocolVersion serverVersion;
    public Vector supportedSignatureAlgorithms;
    public boolean truncatedHMacOffered;

    public AbstractTlsServer() {
        this(new DefaultTlsCipherFactory());
    }

    public AbstractTlsServer(TlsCipherFactory tlsCipherFactory) {
        this.cipherFactory = tlsCipherFactory;
    }

    public boolean allowTruncatedHMac() {
        return false;
    }

    public Hashtable checkServerExtensions() {
        Hashtable hashtableEnsureExtensionsInitialised = TlsExtensionsUtils.ensureExtensionsInitialised(this.serverExtensions);
        this.serverExtensions = hashtableEnsureExtensionsInitialised;
        return hashtableEnsureExtensionsInitialised;
    }

    @Override // org.bouncycastle.crypto.tls.TlsServer
    public CertificateRequest getCertificateRequest() throws IOException {
        return null;
    }

    @Override // org.bouncycastle.crypto.tls.TlsServer
    public CertificateStatus getCertificateStatus() throws IOException {
        return null;
    }

    public abstract int[] getCipherSuites();

    @Override // org.bouncycastle.crypto.tls.TlsPeer
    public TlsCompression getCompression() throws IOException {
        if (this.selectedCompressionMethod == 0) {
            return new TlsNullCompression();
        }
        throw new TlsFatalAlert((short) 80);
    }

    public short[] getCompressionMethods() {
        return new short[]{0};
    }

    public ProtocolVersion getMaximumVersion() {
        return ProtocolVersion.TLSv11;
    }

    public ProtocolVersion getMinimumVersion() {
        return ProtocolVersion.TLSv10;
    }

    @Override // org.bouncycastle.crypto.tls.TlsServer
    public NewSessionTicket getNewSessionTicket() throws IOException {
        return new NewSessionTicket(0L, TlsUtils.EMPTY_BYTES);
    }

    @Override // org.bouncycastle.crypto.tls.TlsServer
    public int getSelectedCipherSuite() throws IOException {
        boolean zSupportsClientECCCapabilities = supportsClientECCCapabilities(this.namedCurves, this.clientECPointFormats);
        for (int i : getCipherSuites()) {
            if (Arrays.contains(this.offeredCipherSuites, i) && (zSupportsClientECCCapabilities || !TlsECCUtils.isECCCipherSuite(i))) {
                this.selectedCipherSuite = i;
                return i;
            }
        }
        throw new TlsFatalAlert((short) 40);
    }

    @Override // org.bouncycastle.crypto.tls.TlsServer
    public short getSelectedCompressionMethod() throws IOException {
        short[] compressionMethods = getCompressionMethods();
        for (int i = 0; i < compressionMethods.length; i++) {
            if (Arrays.contains(this.offeredCompressionMethods, compressionMethods[i])) {
                short s = compressionMethods[i];
                this.selectedCompressionMethod = s;
                return s;
            }
        }
        throw new TlsFatalAlert((short) 40);
    }

    @Override // org.bouncycastle.crypto.tls.TlsServer
    public Hashtable getServerExtensions() throws IOException {
        if (this.maxFragmentLengthOffered >= 0) {
            TlsExtensionsUtils.addMaxFragmentLengthExtension(checkServerExtensions(), this.maxFragmentLengthOffered);
        }
        if (this.truncatedHMacOffered && allowTruncatedHMac()) {
            TlsExtensionsUtils.addTruncatedHMacExtension(checkServerExtensions());
        }
        if (this.clientECPointFormats != null && TlsECCUtils.isECCCipherSuite(this.selectedCipherSuite)) {
            this.serverECPointFormats = new short[]{2, 1, 0};
            TlsECCUtils.addSupportedPointFormatsExtension(checkServerExtensions(), this.serverECPointFormats);
        }
        return this.serverExtensions;
    }

    @Override // org.bouncycastle.crypto.tls.TlsServer
    public Vector getServerSupplementalData() throws IOException {
        return null;
    }

    @Override // org.bouncycastle.crypto.tls.TlsServer
    public ProtocolVersion getServerVersion() throws IOException {
        if (getMinimumVersion().isEqualOrEarlierVersionOf(this.clientVersion)) {
            ProtocolVersion maximumVersion = getMaximumVersion();
            if (this.clientVersion.isEqualOrEarlierVersionOf(maximumVersion)) {
                ProtocolVersion protocolVersion = this.clientVersion;
                this.serverVersion = protocolVersion;
                return protocolVersion;
            }
            if (this.clientVersion.isLaterVersionOf(maximumVersion)) {
                this.serverVersion = maximumVersion;
                return maximumVersion;
            }
        }
        throw new TlsFatalAlert((short) 70);
    }

    @Override // org.bouncycastle.crypto.tls.TlsServer
    public void init(TlsServerContext tlsServerContext) {
        this.context = tlsServerContext;
    }

    @Override // org.bouncycastle.crypto.tls.TlsServer
    public void notifyClientCertificate(Certificate certificate) throws IOException {
        throw new TlsFatalAlert((short) 80);
    }

    @Override // org.bouncycastle.crypto.tls.TlsServer
    public void notifyClientVersion(ProtocolVersion protocolVersion) throws IOException {
        this.clientVersion = protocolVersion;
    }

    @Override // org.bouncycastle.crypto.tls.TlsServer
    public void notifyOfferedCipherSuites(int[] iArr) throws IOException {
        this.offeredCipherSuites = iArr;
        this.eccCipherSuitesOffered = TlsECCUtils.containsECCCipherSuites(iArr);
    }

    @Override // org.bouncycastle.crypto.tls.TlsServer
    public void notifyOfferedCompressionMethods(short[] sArr) throws IOException {
        this.offeredCompressionMethods = sArr;
    }

    @Override // org.bouncycastle.crypto.tls.TlsServer
    public void processClientExtensions(Hashtable hashtable) throws IOException {
        this.clientExtensions = hashtable;
        if (hashtable != null) {
            this.maxFragmentLengthOffered = TlsExtensionsUtils.getMaxFragmentLengthExtension(hashtable);
            this.truncatedHMacOffered = TlsExtensionsUtils.hasTruncatedHMacExtension(hashtable);
            Vector signatureAlgorithmsExtension = TlsUtils.getSignatureAlgorithmsExtension(hashtable);
            this.supportedSignatureAlgorithms = signatureAlgorithmsExtension;
            if (signatureAlgorithmsExtension != null && !TlsUtils.isSignatureAlgorithmsExtensionAllowed(this.clientVersion)) {
                throw new TlsFatalAlert((short) 47);
            }
            this.namedCurves = TlsECCUtils.getSupportedEllipticCurvesExtension(hashtable);
            this.clientECPointFormats = TlsECCUtils.getSupportedPointFormatsExtension(hashtable);
        }
        if (this.eccCipherSuitesOffered) {
            return;
        }
        if (this.namedCurves != null || this.clientECPointFormats != null) {
            throw new TlsFatalAlert((short) 47);
        }
    }

    @Override // org.bouncycastle.crypto.tls.TlsServer
    public void processClientSupplementalData(Vector vector) throws IOException {
        if (vector != null) {
            throw new TlsFatalAlert((short) 10);
        }
    }

    public boolean supportsClientECCCapabilities(int[] iArr, short[] sArr) {
        if (iArr == null) {
            return TlsECCUtils.hasAnySupportedNamedCurves();
        }
        for (int i : iArr) {
            if (!NamedCurve.refersToASpecificNamedCurve(i) || TlsECCUtils.isSupportedNamedCurve(i)) {
                return true;
            }
        }
        return false;
    }
}
