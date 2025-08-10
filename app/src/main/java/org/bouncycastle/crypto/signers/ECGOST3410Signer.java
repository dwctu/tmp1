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
public class ECGOST3410Signer implements DSA {
    public ECKeyParameters key;
    public SecureRandom random;

    @Override // org.bouncycastle.crypto.DSA
    public BigInteger[] generateSignature(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr2[i] = bArr[(length - 1) - i];
        }
        BigInteger bigInteger = new BigInteger(1, bArr2);
        BigInteger n = this.key.getParameters().getN();
        while (true) {
            BigInteger bigInteger2 = new BigInteger(n.bitLength(), this.random);
            BigInteger bigInteger3 = ECConstants.ZERO;
            if (!bigInteger2.equals(bigInteger3)) {
                BigInteger bigIntegerMod = this.key.getParameters().getG().multiply(bigInteger2).normalize().getAffineXCoord().toBigInteger().mod(n);
                if (bigIntegerMod.equals(bigInteger3)) {
                    continue;
                } else {
                    BigInteger bigIntegerMod2 = bigInteger2.multiply(bigInteger).add(((ECPrivateKeyParameters) this.key).getD().multiply(bigIntegerMod)).mod(n);
                    if (!bigIntegerMod2.equals(bigInteger3)) {
                        return new BigInteger[]{bigIntegerMod, bigIntegerMod2};
                    }
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
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr2[i] = bArr[(length - 1) - i];
        }
        BigInteger bigInteger3 = new BigInteger(1, bArr2);
        BigInteger n = this.key.getParameters().getN();
        BigInteger bigInteger4 = ECConstants.ONE;
        if (bigInteger.compareTo(bigInteger4) < 0 || bigInteger.compareTo(n) >= 0 || bigInteger2.compareTo(bigInteger4) < 0 || bigInteger2.compareTo(n) >= 0) {
            return false;
        }
        BigInteger bigIntegerModInverse = bigInteger3.modInverse(n);
        ECPoint eCPointNormalize = ECAlgorithms.sumOfTwoMultiplies(this.key.getParameters().getG(), bigInteger2.multiply(bigIntegerModInverse).mod(n), ((ECPublicKeyParameters) this.key).getQ(), n.subtract(bigInteger).multiply(bigIntegerModInverse).mod(n)).normalize();
        if (eCPointNormalize.isInfinity()) {
            return false;
        }
        return eCPointNormalize.getAffineXCoord().toBigInteger().mod(n).equals(bigInteger);
    }
}
