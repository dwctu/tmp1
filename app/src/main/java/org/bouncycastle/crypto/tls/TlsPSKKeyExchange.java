package org.bouncycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.util.PublicKeyFactory;

/* loaded from: classes5.dex */
public class TlsPSKKeyExchange extends AbstractTlsKeyExchange {
    public short[] clientECPointFormats;
    public DHPrivateKeyParameters dhAgreePrivateKey;
    public DHPublicKeyParameters dhAgreePublicKey;
    public DHParameters dhParameters;
    public int[] namedCurves;
    public byte[] premasterSecret;
    public TlsPSKIdentity pskIdentity;
    public byte[] psk_identity_hint;
    public RSAKeyParameters rsaServerPublicKey;
    public TlsEncryptionCredentials serverCredentials;
    public short[] serverECPointFormats;
    public AsymmetricKeyParameter serverPublicKey;

    public TlsPSKKeyExchange(int i, Vector vector, TlsPSKIdentity tlsPSKIdentity, DHParameters dHParameters, int[] iArr, short[] sArr, short[] sArr2) {
        super(i, vector);
        this.psk_identity_hint = null;
        this.dhAgreePrivateKey = null;
        this.dhAgreePublicKey = null;
        this.serverPublicKey = null;
        this.rsaServerPublicKey = null;
        this.serverCredentials = null;
        if (i != 24) {
            switch (i) {
                case 13:
                case 14:
                case 15:
                    break;
                default:
                    throw new IllegalArgumentException("unsupported key exchange algorithm");
            }
        }
        this.pskIdentity = tlsPSKIdentity;
        this.dhParameters = dHParameters;
        this.namedCurves = iArr;
        this.clientECPointFormats = sArr;
        this.serverECPointFormats = sArr2;
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void generateClientKeyExchange(OutputStream outputStream) throws IOException {
        byte[] bArr = this.psk_identity_hint;
        if (bArr == null) {
            this.pskIdentity.skipIdentityHint();
        } else {
            this.pskIdentity.notifyIdentityHint(bArr);
        }
        TlsUtils.writeOpaque16(this.pskIdentity.getPSKIdentity(), outputStream);
        int i = this.keyExchange;
        if (i == 14) {
            this.dhAgreePrivateKey = TlsDHUtils.generateEphemeralClientKeyExchange(this.context.getSecureRandom(), this.dhAgreePublicKey.getParameters(), outputStream);
        } else {
            if (i == 24) {
                throw new TlsFatalAlert((short) 80);
            }
            if (i == 15) {
                this.premasterSecret = TlsRSAUtils.generateEncryptedPreMasterSecret(this.context, this.rsaServerPublicKey, outputStream);
            }
        }
    }

    public byte[] generateOtherSecret(int i) throws IOException {
        int i2 = this.keyExchange;
        if (i2 != 14) {
            if (i2 != 24) {
                return i2 == 15 ? this.premasterSecret : new byte[i];
            }
            throw new TlsFatalAlert((short) 80);
        }
        DHPrivateKeyParameters dHPrivateKeyParameters = this.dhAgreePrivateKey;
        if (dHPrivateKeyParameters != null) {
            return TlsDHUtils.calculateDHBasicAgreement(this.dhAgreePublicKey, dHPrivateKeyParameters);
        }
        throw new TlsFatalAlert((short) 80);
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public byte[] generatePremasterSecret() throws IOException {
        byte[] psk = this.pskIdentity.getPSK();
        byte[] bArrGenerateOtherSecret = generateOtherSecret(psk.length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArrGenerateOtherSecret.length + 4 + psk.length);
        TlsUtils.writeOpaque16(bArrGenerateOtherSecret, byteArrayOutputStream);
        TlsUtils.writeOpaque16(psk, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @Override // org.bouncycastle.crypto.tls.AbstractTlsKeyExchange, org.bouncycastle.crypto.tls.TlsKeyExchange
    public byte[] generateServerKeyExchange() throws IOException {
        this.psk_identity_hint = null;
        if (!requiresServerKeyExchange()) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = this.psk_identity_hint;
        if (bArr == null) {
            TlsUtils.writeOpaque16(TlsUtils.EMPTY_BYTES, byteArrayOutputStream);
        } else {
            TlsUtils.writeOpaque16(bArr, byteArrayOutputStream);
        }
        if (this.keyExchange == 14) {
            if (this.dhParameters == null) {
                throw new TlsFatalAlert((short) 80);
            }
            this.dhAgreePrivateKey = TlsDHUtils.generateEphemeralServerKeyExchange(this.context.getSecureRandom(), this.dhParameters, byteArrayOutputStream);
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void processClientCredentials(TlsCredentials tlsCredentials) throws IOException {
        throw new TlsFatalAlert((short) 80);
    }

    @Override // org.bouncycastle.crypto.tls.AbstractTlsKeyExchange, org.bouncycastle.crypto.tls.TlsKeyExchange
    public void processServerCertificate(Certificate certificate) throws IOException {
        if (this.keyExchange != 15) {
            throw new TlsFatalAlert((short) 10);
        }
        if (certificate.isEmpty()) {
            throw new TlsFatalAlert((short) 42);
        }
        org.bouncycastle.asn1.x509.Certificate certificateAt = certificate.getCertificateAt(0);
        try {
            AsymmetricKeyParameter asymmetricKeyParameterCreateKey = PublicKeyFactory.createKey(certificateAt.getSubjectPublicKeyInfo());
            this.serverPublicKey = asymmetricKeyParameterCreateKey;
            if (asymmetricKeyParameterCreateKey.isPrivate()) {
                throw new TlsFatalAlert((short) 80);
            }
            this.rsaServerPublicKey = validateRSAPublicKey((RSAKeyParameters) this.serverPublicKey);
            TlsUtils.validateKeyUsage(certificateAt, 32);
            super.processServerCertificate(certificate);
        } catch (RuntimeException unused) {
            throw new TlsFatalAlert((short) 43);
        }
    }

    @Override // org.bouncycastle.crypto.tls.AbstractTlsKeyExchange, org.bouncycastle.crypto.tls.TlsKeyExchange
    public void processServerCredentials(TlsCredentials tlsCredentials) throws IOException {
        if (!(tlsCredentials instanceof TlsEncryptionCredentials)) {
            throw new TlsFatalAlert((short) 80);
        }
        processServerCertificate(tlsCredentials.getCertificate());
        this.serverCredentials = (TlsEncryptionCredentials) tlsCredentials;
    }

    @Override // org.bouncycastle.crypto.tls.AbstractTlsKeyExchange, org.bouncycastle.crypto.tls.TlsKeyExchange
    public void processServerKeyExchange(InputStream inputStream) throws IOException {
        this.psk_identity_hint = TlsUtils.readOpaque16(inputStream);
        if (this.keyExchange == 14) {
            this.dhAgreePublicKey = TlsDHUtils.validateDHPublicKey(ServerDHParams.parse(inputStream).getPublicKey());
        }
    }

    @Override // org.bouncycastle.crypto.tls.AbstractTlsKeyExchange, org.bouncycastle.crypto.tls.TlsKeyExchange
    public boolean requiresServerKeyExchange() {
        int i = this.keyExchange;
        return i == 14 || i == 24;
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void skipServerCredentials() throws IOException {
        if (this.keyExchange == 15) {
            throw new TlsFatalAlert((short) 10);
        }
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void validateCertificateRequest(CertificateRequest certificateRequest) throws IOException {
        throw new TlsFatalAlert((short) 10);
    }

    public RSAKeyParameters validateRSAPublicKey(RSAKeyParameters rSAKeyParameters) throws IOException {
        if (rSAKeyParameters.getExponent().isProbablePrime(2)) {
            return rSAKeyParameters;
        }
        throw new TlsFatalAlert((short) 47);
    }
}
