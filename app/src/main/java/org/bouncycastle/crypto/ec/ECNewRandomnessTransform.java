package org.bouncycastle.crypto.ec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.math.ec.ECPoint;

/* loaded from: classes5.dex */
public class ECNewRandomnessTransform implements ECPairFactorTransform {
    private ECPublicKeyParameters key;
    private BigInteger lastK;
    private SecureRandom random;

    @Override // org.bouncycastle.crypto.ec.ECPairFactorTransform
    public BigInteger getTransformValue() {
        return this.lastK;
    }

    @Override // org.bouncycastle.crypto.ec.ECPairTransform
    public void init(CipherParameters cipherParameters) {
        SecureRandom secureRandom;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            if (!(parametersWithRandom.getParameters() instanceof ECPublicKeyParameters)) {
                throw new IllegalArgumentException("ECPublicKeyParameters are required for new randomness transform.");
            }
            this.key = (ECPublicKeyParameters) parametersWithRandom.getParameters();
            secureRandom = parametersWithRandom.getRandom();
        } else {
            if (!(cipherParameters instanceof ECPublicKeyParameters)) {
                throw new IllegalArgumentException("ECPublicKeyParameters are required for new randomness transform.");
            }
            this.key = (ECPublicKeyParameters) cipherParameters;
            secureRandom = new SecureRandom();
        }
        this.random = secureRandom;
    }

    @Override // org.bouncycastle.crypto.ec.ECPairTransform
    public ECPair transform(ECPair eCPair) {
        ECPublicKeyParameters eCPublicKeyParameters = this.key;
        if (eCPublicKeyParameters == null) {
            throw new IllegalStateException("ECNewRandomnessTransform not initialised");
        }
        BigInteger bigIntegerGenerateK = ECUtil.generateK(eCPublicKeyParameters.getParameters().getN(), this.random);
        ECPoint eCPointMultiply = this.key.getParameters().getG().multiply(bigIntegerGenerateK);
        ECPoint eCPointAdd = this.key.getQ().multiply(bigIntegerGenerateK).add(eCPair.getY());
        this.lastK = bigIntegerGenerateK;
        return new ECPair(eCPair.getX().add(eCPointMultiply).normalize(), eCPointAdd.normalize());
    }
}
