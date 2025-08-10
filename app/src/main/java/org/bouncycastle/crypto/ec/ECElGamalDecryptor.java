package org.bouncycastle.crypto.ec;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.math.ec.ECPoint;

/* loaded from: classes5.dex */
public class ECElGamalDecryptor implements ECDecryptor {
    private ECPrivateKeyParameters key;

    @Override // org.bouncycastle.crypto.ec.ECDecryptor
    public ECPoint decrypt(ECPair eCPair) {
        if (this.key == null) {
            throw new IllegalStateException("ECElGamalDecryptor not initialised");
        }
        return eCPair.getY().add(eCPair.getX().multiply(this.key.getD()).negate()).normalize();
    }

    @Override // org.bouncycastle.crypto.ec.ECDecryptor
    public void init(CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof ECPrivateKeyParameters)) {
            throw new IllegalArgumentException("ECPrivateKeyParameters are required for decryption.");
        }
        this.key = (ECPrivateKeyParameters) cipherParameters;
    }
}
