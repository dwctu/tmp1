package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.util.PublicKeyFactory;

/* loaded from: classes5.dex */
public class TlsECDHKeyExchange extends AbstractTlsKeyExchange {
    public TlsAgreementCredentials agreementCredentials;
    public short[] clientECPointFormats;
    public ECPrivateKeyParameters ecAgreePrivateKey;
    public ECPublicKeyParameters ecAgreePublicKey;
    public int[] namedCurves;
    public short[] serverECPointFormats;
    public AsymmetricKeyParameter serverPublicKey;
    public TlsSigner tlsSigner;

    public TlsECDHKeyExchange(int i, Vector vector, int[] iArr, short[] sArr, short[] sArr2) {
        TlsSigner tlsECDSASigner;
        super(i, vector);
        switch (i) {
            case 16:
            case 18:
                tlsECDSASigner = null;
                break;
            case 17:
                tlsECDSASigner = new TlsECDSASigner();
                break;
            case 19:
                tlsECDSASigner = new TlsRSASigner();
                break;
            default:
                throw new IllegalArgumentException("unsupported key exchange algorithm");
        }
        this.tlsSigner = tlsECDSASigner;
        this.keyExchange = i;
        this.namedCurves = iArr;
        this.clientECPointFormats = sArr;
        this.serverECPointFormats = sArr2;
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void generateClientKeyExchange(OutputStream outputStream) throws IOException {
        if (this.agreementCredentials == null) {
            this.ecAgreePrivateKey = TlsECCUtils.generateEphemeralClientKeyExchange(this.context.getSecureRandom(), this.serverECPointFormats, this.ecAgreePublicKey.getParameters(), outputStream);
        }
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public byte[] generatePremasterSecret() throws IOException {
        TlsAgreementCredentials tlsAgreementCredentials = this.agreementCredentials;
        if (tlsAgreementCredentials != null) {
            return tlsAgreementCredentials.generateAgreement(this.ecAgreePublicKey);
        }
        ECPrivateKeyParameters eCPrivateKeyParameters = this.ecAgreePrivateKey;
        if (eCPrivateKeyParameters != null) {
            return TlsECCUtils.calculateECDHBasicAgreement(this.ecAgreePublicKey, eCPrivateKeyParameters);
        }
        throw new TlsFatalAlert((short) 80);
    }

    @Override // org.bouncycastle.crypto.tls.AbstractTlsKeyExchange, org.bouncycastle.crypto.tls.TlsKeyExchange
    public void init(TlsContext tlsContext) {
        super.init(tlsContext);
        TlsSigner tlsSigner = this.tlsSigner;
        if (tlsSigner != null) {
            tlsSigner.init(tlsContext);
        }
    }

    @Override // org.bouncycastle.crypto.tls.AbstractTlsKeyExchange, org.bouncycastle.crypto.tls.TlsKeyExchange
    public void processClientCertificate(Certificate certificate) throws IOException {
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void processClientCredentials(TlsCredentials tlsCredentials) throws IOException {
        if (tlsCredentials instanceof TlsAgreementCredentials) {
            this.agreementCredentials = (TlsAgreementCredentials) tlsCredentials;
        } else if (!(tlsCredentials instanceof TlsSignerCredentials)) {
            throw new TlsFatalAlert((short) 80);
        }
    }

    @Override // org.bouncycastle.crypto.tls.AbstractTlsKeyExchange, org.bouncycastle.crypto.tls.TlsKeyExchange
    public void processClientKeyExchange(InputStream inputStream) throws IOException {
        if (this.ecAgreePublicKey != null) {
            return;
        }
        byte[] opaque8 = TlsUtils.readOpaque8(inputStream);
        this.ecAgreePublicKey = TlsECCUtils.validateECPublicKey(TlsECCUtils.deserializeECPublicKey(this.serverECPointFormats, this.ecAgreePrivateKey.getParameters(), opaque8));
    }

    @Override // org.bouncycastle.crypto.tls.AbstractTlsKeyExchange, org.bouncycastle.crypto.tls.TlsKeyExchange
    public void processServerCertificate(Certificate certificate) throws IOException {
        int i;
        if (certificate.isEmpty()) {
            throw new TlsFatalAlert((short) 42);
        }
        org.bouncycastle.asn1.x509.Certificate certificateAt = certificate.getCertificateAt(0);
        try {
            AsymmetricKeyParameter asymmetricKeyParameterCreateKey = PublicKeyFactory.createKey(certificateAt.getSubjectPublicKeyInfo());
            this.serverPublicKey = asymmetricKeyParameterCreateKey;
            TlsSigner tlsSigner = this.tlsSigner;
            if (tlsSigner == null) {
                try {
                    this.ecAgreePublicKey = TlsECCUtils.validateECPublicKey((ECPublicKeyParameters) asymmetricKeyParameterCreateKey);
                    i = 8;
                } catch (ClassCastException unused) {
                    throw new TlsFatalAlert((short) 46);
                }
            } else {
                if (!tlsSigner.isValidPublicKey(asymmetricKeyParameterCreateKey)) {
                    throw new TlsFatalAlert((short) 46);
                }
                i = 128;
            }
            TlsUtils.validateKeyUsage(certificateAt, i);
            super.processServerCertificate(certificate);
        } catch (RuntimeException unused2) {
            throw new TlsFatalAlert((short) 43);
        }
    }

    @Override // org.bouncycastle.crypto.tls.AbstractTlsKeyExchange, org.bouncycastle.crypto.tls.TlsKeyExchange
    public boolean requiresServerKeyExchange() {
        int i = this.keyExchange;
        return i == 17 || i == 19 || i == 20;
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void skipServerCredentials() throws IOException {
        throw new TlsFatalAlert((short) 10);
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void validateCertificateRequest(CertificateRequest certificateRequest) throws IOException {
        for (short s : certificateRequest.getCertificateTypes()) {
            if (s != 1 && s != 2) {
                switch (s) {
                    case 64:
                    case 65:
                    case 66:
                        break;
                    default:
                        throw new TlsFatalAlert((short) 47);
                }
            }
        }
    }
}
