package org.bouncycastle.crypto.tls;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.DSA;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.digests.NullDigest;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.signers.DSADigestSigner;

/* loaded from: classes5.dex */
public abstract class TlsDSASigner extends AbstractTlsSigner {
    public abstract DSA createDSAImpl();

    @Override // org.bouncycastle.crypto.tls.TlsSigner
    public Signer createSigner(SignatureAndHashAlgorithm signatureAndHashAlgorithm, AsymmetricKeyParameter asymmetricKeyParameter) {
        return makeSigner(signatureAndHashAlgorithm, false, true, new ParametersWithRandom(asymmetricKeyParameter, this.context.getSecureRandom()));
    }

    @Override // org.bouncycastle.crypto.tls.TlsSigner
    public Signer createVerifyer(SignatureAndHashAlgorithm signatureAndHashAlgorithm, AsymmetricKeyParameter asymmetricKeyParameter) {
        return makeSigner(signatureAndHashAlgorithm, false, false, asymmetricKeyParameter);
    }

    @Override // org.bouncycastle.crypto.tls.TlsSigner
    public byte[] generateRawSignature(SignatureAndHashAlgorithm signatureAndHashAlgorithm, AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr) throws CryptoException {
        int i;
        int length;
        Signer signerMakeSigner = makeSigner(signatureAndHashAlgorithm, true, true, new ParametersWithRandom(asymmetricKeyParameter, this.context.getSecureRandom()));
        if (signatureAndHashAlgorithm == null) {
            i = 16;
            length = 20;
        } else {
            i = 0;
            length = bArr.length;
        }
        signerMakeSigner.update(bArr, i, length);
        return signerMakeSigner.generateSignature();
    }

    public abstract short getSignatureAlgorithm();

    public Signer makeSigner(SignatureAndHashAlgorithm signatureAndHashAlgorithm, boolean z, boolean z2, CipherParameters cipherParameters) {
        if ((signatureAndHashAlgorithm != null) != TlsUtils.isTLSv12(this.context)) {
            throw new IllegalStateException();
        }
        if (signatureAndHashAlgorithm != null && (signatureAndHashAlgorithm.getHash() != 2 || signatureAndHashAlgorithm.getSignature() != getSignatureAlgorithm())) {
            throw new IllegalStateException();
        }
        DSADigestSigner dSADigestSigner = new DSADigestSigner(createDSAImpl(), z ? new NullDigest() : TlsUtils.createHash((short) 2));
        dSADigestSigner.init(z2, cipherParameters);
        return dSADigestSigner;
    }

    @Override // org.bouncycastle.crypto.tls.TlsSigner
    public boolean verifyRawSignature(SignatureAndHashAlgorithm signatureAndHashAlgorithm, byte[] bArr, AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr2) throws CryptoException {
        Signer signerMakeSigner = makeSigner(signatureAndHashAlgorithm, true, false, asymmetricKeyParameter);
        if (signatureAndHashAlgorithm == null) {
            signerMakeSigner.update(bArr2, 16, 20);
        } else {
            signerMakeSigner.update(bArr2, 0, bArr2.length);
        }
        return signerMakeSigner.verifySignature(bArr);
    }
}
