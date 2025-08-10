package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Vector;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.crypto.util.PublicKeyFactory;

/* loaded from: classes5.dex */
public class TlsDHKeyExchange extends AbstractTlsKeyExchange {
    public static final BigInteger ONE = BigInteger.valueOf(1);
    public static final BigInteger TWO = BigInteger.valueOf(2);
    public TlsAgreementCredentials agreementCredentials;
    public DHPrivateKeyParameters dhAgreeClientPrivateKey;
    public DHPublicKeyParameters dhAgreeClientPublicKey;
    public DHPrivateKeyParameters dhAgreeServerPrivateKey;
    public DHPublicKeyParameters dhAgreeServerPublicKey;
    public DHParameters dhParameters;
    public AsymmetricKeyParameter serverPublicKey;
    public TlsSigner tlsSigner;

    public TlsDHKeyExchange(int i, Vector vector, DHParameters dHParameters) {
        TlsSigner tlsDSSSigner;
        super(i, vector);
        if (i == 3) {
            tlsDSSSigner = new TlsDSSSigner();
        } else if (i == 5) {
            tlsDSSSigner = new TlsRSASigner();
        } else {
            if (i != 7 && i != 9) {
                throw new IllegalArgumentException("unsupported key exchange algorithm");
            }
            tlsDSSSigner = null;
        }
        this.tlsSigner = tlsDSSSigner;
        this.dhParameters = dHParameters;
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void generateClientKeyExchange(OutputStream outputStream) throws IOException {
        if (this.agreementCredentials == null) {
            this.dhAgreeClientPrivateKey = TlsDHUtils.generateEphemeralClientKeyExchange(this.context.getSecureRandom(), this.dhAgreeServerPublicKey.getParameters(), outputStream);
        }
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public byte[] generatePremasterSecret() throws IOException {
        TlsAgreementCredentials tlsAgreementCredentials = this.agreementCredentials;
        if (tlsAgreementCredentials != null) {
            return tlsAgreementCredentials.generateAgreement(this.dhAgreeServerPublicKey);
        }
        DHPrivateKeyParameters dHPrivateKeyParameters = this.dhAgreeServerPrivateKey;
        if (dHPrivateKeyParameters != null) {
            return TlsDHUtils.calculateDHBasicAgreement(this.dhAgreeClientPublicKey, dHPrivateKeyParameters);
        }
        DHPrivateKeyParameters dHPrivateKeyParameters2 = this.dhAgreeClientPrivateKey;
        if (dHPrivateKeyParameters2 != null) {
            return TlsDHUtils.calculateDHBasicAgreement(this.dhAgreeServerPublicKey, dHPrivateKeyParameters2);
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

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void processClientCredentials(TlsCredentials tlsCredentials) throws IOException {
        if (tlsCredentials instanceof TlsAgreementCredentials) {
            this.agreementCredentials = (TlsAgreementCredentials) tlsCredentials;
        } else if (!(tlsCredentials instanceof TlsSignerCredentials)) {
            throw new TlsFatalAlert((short) 80);
        }
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
                    this.dhAgreeServerPublicKey = TlsDHUtils.validateDHPublicKey((DHPublicKeyParameters) asymmetricKeyParameterCreateKey);
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
        return i == 3 || i == 5 || i == 11;
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void skipServerCredentials() throws IOException {
        throw new TlsFatalAlert((short) 10);
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void validateCertificateRequest(CertificateRequest certificateRequest) throws IOException {
        for (short s : certificateRequest.getCertificateTypes()) {
            if (s != 1 && s != 2 && s != 3 && s != 4 && s != 64) {
                throw new TlsFatalAlert((short) 47);
            }
        }
    }
}
