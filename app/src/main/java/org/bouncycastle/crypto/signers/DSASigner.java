package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DSA;
import org.bouncycastle.crypto.params.DSAKeyParameters;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;

/* loaded from: classes5.dex */
public class DSASigner implements DSA {
    private final DSAKCalculator kCalculator;
    private DSAKeyParameters key;
    private SecureRandom random;

    public DSASigner() {
        this.kCalculator = new RandomDSAKCalculator();
    }

    public DSASigner(DSAKCalculator dSAKCalculator) {
        this.kCalculator = dSAKCalculator;
    }

    private BigInteger calculateE(BigInteger bigInteger, byte[] bArr) {
        if (bigInteger.bitLength() >= bArr.length * 8) {
            return new BigInteger(1, bArr);
        }
        int iBitLength = bigInteger.bitLength() / 8;
        byte[] bArr2 = new byte[iBitLength];
        System.arraycopy(bArr, 0, bArr2, 0, iBitLength);
        return new BigInteger(1, bArr2);
    }

    @Override // org.bouncycastle.crypto.DSA
    public BigInteger[] generateSignature(byte[] bArr) {
        DSAParameters parameters = this.key.getParameters();
        BigInteger bigIntegerCalculateE = calculateE(parameters.getQ(), bArr);
        if (this.kCalculator.isDeterministic()) {
            this.kCalculator.init(parameters.getQ(), ((DSAPrivateKeyParameters) this.key).getX(), bArr);
        } else {
            this.kCalculator.init(parameters.getQ(), this.random);
        }
        BigInteger bigIntegerNextK = this.kCalculator.nextK();
        BigInteger bigIntegerMod = parameters.getG().modPow(bigIntegerNextK, parameters.getP()).mod(parameters.getQ());
        return new BigInteger[]{bigIntegerMod, bigIntegerNextK.modInverse(parameters.getQ()).multiply(bigIntegerCalculateE.add(((DSAPrivateKeyParameters) this.key).getX().multiply(bigIntegerMod))).mod(parameters.getQ())};
    }

    @Override // org.bouncycastle.crypto.DSA
    public void init(boolean z, CipherParameters cipherParameters) {
        DSAKeyParameters dSAKeyParameters;
        if (!z) {
            dSAKeyParameters = (DSAPublicKeyParameters) cipherParameters;
        } else {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.random = parametersWithRandom.getRandom();
                this.key = (DSAPrivateKeyParameters) parametersWithRandom.getParameters();
                return;
            }
            this.random = new SecureRandom();
            dSAKeyParameters = (DSAPrivateKeyParameters) cipherParameters;
        }
        this.key = dSAKeyParameters;
    }

    @Override // org.bouncycastle.crypto.DSA
    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        DSAParameters parameters = this.key.getParameters();
        BigInteger bigIntegerCalculateE = calculateE(parameters.getQ(), bArr);
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        if (bigIntegerValueOf.compareTo(bigInteger) >= 0 || parameters.getQ().compareTo(bigInteger) <= 0 || bigIntegerValueOf.compareTo(bigInteger2) >= 0 || parameters.getQ().compareTo(bigInteger2) <= 0) {
            return false;
        }
        BigInteger bigIntegerModInverse = bigInteger2.modInverse(parameters.getQ());
        return parameters.getG().modPow(bigIntegerCalculateE.multiply(bigIntegerModInverse).mod(parameters.getQ()), parameters.getP()).multiply(((DSAPublicKeyParameters) this.key).getY().modPow(bigInteger.multiply(bigIntegerModInverse).mod(parameters.getQ()), parameters.getP())).mod(parameters.getP()).mod(parameters.getQ()).equals(bigInteger);
    }
}
