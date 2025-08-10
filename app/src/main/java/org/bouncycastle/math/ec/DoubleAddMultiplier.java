package org.bouncycastle.math.ec;

import java.math.BigInteger;

/* loaded from: classes5.dex */
public class DoubleAddMultiplier extends AbstractECMultiplier {
    @Override // org.bouncycastle.math.ec.AbstractECMultiplier
    public ECPoint multiplyPositive(ECPoint eCPoint, BigInteger bigInteger) {
        ECPoint[] eCPointArr = new ECPoint[2];
        eCPointArr[0] = eCPoint.getCurve().getInfinity();
        eCPointArr[1] = eCPoint;
        int iBitLength = bigInteger.bitLength();
        for (int i = 0; i < iBitLength; i++) {
            boolean zTestBit = bigInteger.testBit(i);
            int i2 = 1 - (zTestBit ? 1 : 0);
            eCPointArr[i2] = eCPointArr[i2].twicePlus(eCPointArr[zTestBit ? 1 : 0]);
        }
        return eCPointArr[0];
    }
}
