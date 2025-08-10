package org.bouncycastle.math.ec;

import java.math.BigInteger;

/* loaded from: classes5.dex */
public class ZSignedDigitR2LMultiplier extends AbstractECMultiplier {
    @Override // org.bouncycastle.math.ec.AbstractECMultiplier
    public ECPoint multiplyPositive(ECPoint eCPoint, BigInteger bigInteger) {
        ECPoint infinity = eCPoint.getCurve().getInfinity();
        int iBitLength = bigInteger.bitLength();
        int lowestSetBit = bigInteger.getLowestSetBit();
        ECPoint eCPointTimesPow2 = eCPoint.timesPow2(lowestSetBit);
        while (true) {
            lowestSetBit++;
            if (lowestSetBit >= iBitLength) {
                return infinity.add(eCPointTimesPow2);
            }
            infinity = infinity.add(bigInteger.testBit(lowestSetBit) ? eCPointTimesPow2 : eCPointTimesPow2.negate());
            eCPointTimesPow2 = eCPointTimesPow2.twice();
        }
    }
}
