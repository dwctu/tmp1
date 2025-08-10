package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.engines.RSABlindedEngine;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSAKeyParameters;

/* loaded from: classes5.dex */
public class DefaultTlsEncryptionCredentials extends AbstractTlsEncryptionCredentials {
    public Certificate certificate;
    public TlsContext context;
    public AsymmetricKeyParameter privateKey;

    public DefaultTlsEncryptionCredentials(TlsContext tlsContext, Certificate certificate, AsymmetricKeyParameter asymmetricKeyParameter) {
        if (certificate == null) {
            throw new IllegalArgumentException("'certificate' cannot be null");
        }
        if (certificate.isEmpty()) {
            throw new IllegalArgumentException("'certificate' cannot be empty");
        }
        if (asymmetricKeyParameter == null) {
            throw new IllegalArgumentException("'privateKey' cannot be null");
        }
        if (!asymmetricKeyParameter.isPrivate()) {
            throw new IllegalArgumentException("'privateKey' must be private");
        }
        if (asymmetricKeyParameter instanceof RSAKeyParameters) {
            this.context = tlsContext;
            this.certificate = certificate;
            this.privateKey = asymmetricKeyParameter;
        } else {
            throw new IllegalArgumentException("'privateKey' type not supported: " + asymmetricKeyParameter.getClass().getName());
        }
    }

    @Override // org.bouncycastle.crypto.tls.TlsEncryptionCredentials
    public byte[] decryptPreMasterSecret(byte[] bArr) throws IOException {
        PKCS1Encoding pKCS1Encoding = new PKCS1Encoding(new RSABlindedEngine());
        pKCS1Encoding.init(false, new ParametersWithRandom(this.privateKey, this.context.getSecureRandom()));
        try {
            return pKCS1Encoding.processBlock(bArr, 0, bArr.length);
        } catch (InvalidCipherTextException unused) {
            throw new TlsFatalAlert((short) 47);
        }
    }

    @Override // org.bouncycastle.crypto.tls.TlsCredentials
    public Certificate getCertificate() {
        return this.certificate;
    }
}
