package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Vector;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.agreement.srp.SRP6Client;
import org.bouncycastle.crypto.agreement.srp.SRP6Util;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.io.TeeInputStream;

/* loaded from: classes5.dex */
public class TlsSRPKeyExchange extends AbstractTlsKeyExchange {
    public BigInteger B;
    public byte[] identity;
    public byte[] password;
    public byte[] s;
    public AsymmetricKeyParameter serverPublicKey;
    public SRP6Client srpClient;
    public TlsSigner tlsSigner;

    public TlsSRPKeyExchange(int i, Vector vector, byte[] bArr, byte[] bArr2) {
        super(i, vector);
        TlsSigner tlsDSSSigner = null;
        this.serverPublicKey = null;
        this.s = null;
        this.B = null;
        this.srpClient = new SRP6Client();
        switch (i) {
            case 21:
                break;
            case 22:
                tlsDSSSigner = new TlsDSSSigner();
                break;
            case 23:
                tlsDSSSigner = new TlsRSASigner();
                break;
            default:
                throw new IllegalArgumentException("unsupported key exchange algorithm");
        }
        this.tlsSigner = tlsDSSSigner;
        this.keyExchange = i;
        this.identity = bArr;
        this.password = bArr2;
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void generateClientKeyExchange(OutputStream outputStream) throws IOException {
        TlsUtils.writeOpaque16(BigIntegers.asUnsignedByteArray(this.srpClient.generateClientCredentials(this.s, this.identity, this.password)), outputStream);
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public byte[] generatePremasterSecret() throws IOException {
        try {
            return BigIntegers.asUnsignedByteArray(this.srpClient.calculateSecret(this.B));
        } catch (CryptoException unused) {
            throw new TlsFatalAlert((short) 47);
        }
    }

    @Override // org.bouncycastle.crypto.tls.AbstractTlsKeyExchange, org.bouncycastle.crypto.tls.TlsKeyExchange
    public void init(TlsContext tlsContext) {
        super.init(tlsContext);
        TlsSigner tlsSigner = this.tlsSigner;
        if (tlsSigner != null) {
            tlsSigner.init(tlsContext);
        }
    }

    public Signer initVerifyer(TlsSigner tlsSigner, SignatureAndHashAlgorithm signatureAndHashAlgorithm, SecurityParameters securityParameters) {
        Signer signerCreateVerifyer = tlsSigner.createVerifyer(signatureAndHashAlgorithm, this.serverPublicKey);
        byte[] bArr = securityParameters.clientRandom;
        signerCreateVerifyer.update(bArr, 0, bArr.length);
        byte[] bArr2 = securityParameters.serverRandom;
        signerCreateVerifyer.update(bArr2, 0, bArr2.length);
        return signerCreateVerifyer;
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void processClientCredentials(TlsCredentials tlsCredentials) throws IOException {
        throw new TlsFatalAlert((short) 80);
    }

    @Override // org.bouncycastle.crypto.tls.AbstractTlsKeyExchange, org.bouncycastle.crypto.tls.TlsKeyExchange
    public void processServerCertificate(Certificate certificate) throws IOException {
        if (this.tlsSigner == null) {
            throw new TlsFatalAlert((short) 10);
        }
        if (certificate.isEmpty()) {
            throw new TlsFatalAlert((short) 42);
        }
        org.bouncycastle.asn1.x509.Certificate certificateAt = certificate.getCertificateAt(0);
        try {
            AsymmetricKeyParameter asymmetricKeyParameterCreateKey = PublicKeyFactory.createKey(certificateAt.getSubjectPublicKeyInfo());
            this.serverPublicKey = asymmetricKeyParameterCreateKey;
            if (!this.tlsSigner.isValidPublicKey(asymmetricKeyParameterCreateKey)) {
                throw new TlsFatalAlert((short) 46);
            }
            TlsUtils.validateKeyUsage(certificateAt, 128);
            super.processServerCertificate(certificate);
        } catch (RuntimeException unused) {
            throw new TlsFatalAlert((short) 43);
        }
    }

    @Override // org.bouncycastle.crypto.tls.AbstractTlsKeyExchange, org.bouncycastle.crypto.tls.TlsKeyExchange
    public void processServerKeyExchange(InputStream inputStream) throws IOException {
        SignerInputBuffer signerInputBuffer;
        InputStream teeInputStream;
        SecurityParameters securityParameters = this.context.getSecurityParameters();
        if (this.tlsSigner != null) {
            signerInputBuffer = new SignerInputBuffer();
            teeInputStream = new TeeInputStream(inputStream, signerInputBuffer);
        } else {
            signerInputBuffer = null;
            teeInputStream = inputStream;
        }
        byte[] opaque16 = TlsUtils.readOpaque16(teeInputStream);
        byte[] opaque162 = TlsUtils.readOpaque16(teeInputStream);
        byte[] opaque8 = TlsUtils.readOpaque8(teeInputStream);
        byte[] opaque163 = TlsUtils.readOpaque16(teeInputStream);
        if (signerInputBuffer != null) {
            DigitallySigned digitallySigned = DigitallySigned.parse(this.context, inputStream);
            Signer signerInitVerifyer = initVerifyer(this.tlsSigner, digitallySigned.getAlgorithm(), securityParameters);
            signerInputBuffer.updateSigner(signerInitVerifyer);
            if (!signerInitVerifyer.verifySignature(digitallySigned.getSignature())) {
                throw new TlsFatalAlert((short) 51);
            }
        }
        BigInteger bigInteger = new BigInteger(1, opaque16);
        BigInteger bigInteger2 = new BigInteger(1, opaque162);
        this.s = opaque8;
        try {
            this.B = SRP6Util.validatePublicValue(bigInteger, new BigInteger(1, opaque163));
            this.srpClient.init(bigInteger, bigInteger2, new SHA1Digest(), this.context.getSecureRandom());
        } catch (CryptoException unused) {
            throw new TlsFatalAlert((short) 47);
        }
    }

    @Override // org.bouncycastle.crypto.tls.AbstractTlsKeyExchange, org.bouncycastle.crypto.tls.TlsKeyExchange
    public boolean requiresServerKeyExchange() {
        return true;
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void skipServerCredentials() throws IOException {
        if (this.tlsSigner != null) {
            throw new TlsFatalAlert((short) 10);
        }
    }

    @Override // org.bouncycastle.crypto.tls.TlsKeyExchange
    public void validateCertificateRequest(CertificateRequest certificateRequest) throws IOException {
        throw new TlsFatalAlert((short) 10);
    }
}
