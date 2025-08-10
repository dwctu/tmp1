package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DSA;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECPoint;

/* loaded from: classes5.dex */
public class ECDSASigner implements ECConstants, DSA {
    private final DSAKCalculator kCalculator;
    private ECKeyParameters key;
    private SecureRandom random;

    public ECDSASigner() {
        this.kCalculator = new RandomDSAKCalculator();
    }

    public ECDSASigner(DSAKCalculator dSAKCalculator) {
        this.kCalculator = dSAKCalculator;
    }

    private BigInteger calculateE(BigInteger bigInteger, byte[] bArr) {
        int iBitLength = bigInteger.bitLength();
        int length = bArr.length * 8;
        BigInteger bigInteger2 = new BigInteger(1, bArr);
        return iBitLength < length ? bigInteger2.shiftRight(length - iBitLength) : bigInteger2;
    }

    @Override // org.bouncycastle.crypto.DSA
    public BigInteger[] generateSignature(byte[] bArr) {
        BigInteger n = this.key.getParameters().getN();
        BigInteger bigIntegerCalculateE = calculateE(n, bArr);
        if (this.kCalculator.isDeterministic()) {
            this.kCalculator.init(n, ((ECPrivateKeyParameters) this.key).getD(), bArr);
        } else {
            this.kCalculator.init(n, this.random);
        }
        while (true) {
            BigInteger bigIntegerNextK = this.kCalculator.nextK();
            BigInteger bigIntegerMod = this.key.getParameters().getG().multiply(bigIntegerNextK).normalize().getAffineXCoord().toBigInteger().mod(n);
            BigInteger bigInteger = ECConstants.ZERO;
            if (!bigIntegerMod.equals(bigInteger)) {
                BigInteger bigIntegerMod2 = bigIntegerNextK.modInverse(n).multiply(bigIntegerCalculateE.add(((ECPrivateKeyParameters) this.key).getD().multiply(bigIntegerMod))).mod(n);
                if (!bigIntegerMod2.equals(bigInteger)) {
                    return new BigInteger[]{bigIntegerMod, bigIntegerMod2};
                }
            }
        }
    }

    @Override // org.bouncycastle.crypto.DSA
    public void init(boolean z, CipherParameters cipherParameters) {
        ECKeyParameters eCKeyParameters;
        if (!z) {
            eCKeyParameters = (ECPublicKeyParameters) cipherParameters;
        } else {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.random = parametersWithRandom.getRandom();
                this.key = (ECPrivateKeyParameters) parametersWithRandom.getParameters();
                return;
            }
            this.random = new SecureRandom();
            eCKeyParameters = (ECPrivateKeyParameters) cipherParameters;
        }
        this.key = eCKeyParameters;
    }

    @Override // org.bouncycastle.crypto.DSA
    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger n = this.key.getParameters().getN();
        BigInteger bigIntegerCalculateE = calculateE(n, bArr);
        BigInteger bigInteger3 = ECConstants.ONE;
        if (bigInteger.compareTo(bigInteger3) < 0 || bigInteger.compareTo(n) >= 0 || bigInteger2.compareTo(bigInteger3) < 0 || bigInteger2.compareTo(n) >= 0) {
            return false;
        }
        BigInteger bigIntegerModInverse = bigInteger2.modInverse(n);
        ECPoint eCPointNormalize = ECAlgorithms.sumOfTwoMultiplies(this.key.getParameters().getG(), bigIntegerCalculateE.multiply(bigIntegerModInverse).mod(n), ((ECPublicKeyParameters) this.key).getQ(), bigInteger.multiply(bigIntegerModInverse).mod(n)).normalize();
        if (eCPointNormalize.isInfinity()) {
            return false;
        }
        return eCPointNormalize.getAffineXCoord().toBigInteger().mod(n).equals(bigInteger);
    }
}
