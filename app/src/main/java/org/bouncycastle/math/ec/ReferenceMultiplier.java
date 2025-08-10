package org.bouncycastle.math.ec;

import java.math.BigInteger;

/* loaded from: classes5.dex */
public class ReferenceMultiplier extends AbstractECMultiplier {
    @Override // org.bouncycastle.math.ec.AbstractECMultiplier
    public ECPoint multiplyPositive(ECPoint eCPoint, BigInteger bigInteger) {
        ECPoint infinity = eCPoint.getCurve().getInfinity();
        int iBitLength = bigInteger.bitLength();
        if (iBitLength > 0) {
            if (bigInteger.testBit(0)) {
                infinity = eCPoint;
            }
            for (int i = 1; i < iBitLength; i++) {
                eCPoint = eCPoint.twice();
                if (bigInteger.testBit(i)) {
                    infinity = infinity.add(eCPoint);
                }
            }
        }
        return infinity;
    }
}
