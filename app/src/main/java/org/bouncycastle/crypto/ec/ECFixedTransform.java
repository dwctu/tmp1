package org.bouncycastle.crypto.ec;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;

/* loaded from: classes5.dex */
public class ECFixedTransform implements ECPairFactorTransform {
    private BigInteger k;
    private ECPublicKeyParameters key;

    public ECFixedTransform(BigInteger bigInteger) {
        this.k = bigInteger;
    }

    @Override // org.bouncycastle.crypto.ec.ECPairFactorTransform
    public BigInteger getTransformValue() {
        return this.k;
    }

    @Override // org.bouncycastle.crypto.ec.ECPairTransform
    public void init(CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof ECPublicKeyParameters)) {
            throw new IllegalArgumentException("ECPublicKeyParameters are required for fixed transform.");
        }
        this.key = (ECPublicKeyParameters) cipherParameters;
    }

    @Override // org.bouncycastle.crypto.ec.ECPairTransform
    public ECPair transform(ECPair eCPair) {
        ECPublicKeyParameters eCPublicKeyParameters = this.key;
        if (eCPublicKeyParameters == null) {
            throw new IllegalStateException("ECFixedTransform not initialised");
        }
        return new ECPair(eCPair.getX().add(eCPublicKeyParameters.getParameters().getG().multiply(this.k)).normalize(), this.key.getQ().multiply(this.k).add(eCPair.getY()).normalize());
    }
}
