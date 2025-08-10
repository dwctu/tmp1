package org.bouncycastle.crypto.ec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;

/* loaded from: classes5.dex */
public class ECNewPublicKeyTransform implements ECPairTransform {
    private ECPublicKeyParameters key;
    private SecureRandom random;

    @Override // org.bouncycastle.crypto.ec.ECPairTransform
    public void init(CipherParameters cipherParameters) {
        SecureRandom secureRandom;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            if (!(parametersWithRandom.getParameters() instanceof ECPublicKeyParameters)) {
                throw new IllegalArgumentException("ECPublicKeyParameters are required for new public key transform.");
            }
            this.key = (ECPublicKeyParameters) parametersWithRandom.getParameters();
            secureRandom = parametersWithRandom.getRandom();
        } else {
            if (!(cipherParameters instanceof ECPublicKeyParameters)) {
                throw new IllegalArgumentException("ECPublicKeyParameters are required for new public key transform.");
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
            throw new IllegalStateException("ECNewPublicKeyTransform not initialised");
        }
        BigInteger bigIntegerGenerateK = ECUtil.generateK(eCPublicKeyParameters.getParameters().getN(), this.random);
        return new ECPair(this.key.getParameters().getG().multiply(bigIntegerGenerateK).normalize(), this.key.getQ().multiply(bigIntegerGenerateK).add(eCPair.getY()).normalize());
    }
}
