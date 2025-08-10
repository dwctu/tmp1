package org.bouncycastle.math.ec;

import java.math.BigInteger;

/* loaded from: classes5.dex */
public abstract class AbstractECMultiplier implements ECMultiplier {
    @Override // org.bouncycastle.math.ec.ECMultiplier
    public ECPoint multiply(ECPoint eCPoint, BigInteger bigInteger) {
        int iSignum = bigInteger.signum();
        if (iSignum == 0 || eCPoint.isInfinity()) {
            return eCPoint.getCurve().getInfinity();
        }
        ECPoint eCPointMultiplyPositive = multiplyPositive(eCPoint, bigInteger.abs());
        return iSignum > 0 ? eCPointMultiplyPositive : eCPointMultiplyPositive.negate();
    }

    public abstract ECPoint multiplyPositive(ECPoint eCPoint, BigInteger bigInteger);
}
