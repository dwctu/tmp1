package org.bouncycastle.math.ec;

import java.math.BigInteger;

/* loaded from: classes5.dex */
public class WNafL2RMultiplier extends AbstractECMultiplier {
    public int getWindowSize(int i) {
        return WNafUtil.getWindowSize(i);
    }

    @Override // org.bouncycastle.math.ec.AbstractECMultiplier
    public ECPoint multiplyPositive(ECPoint eCPoint, BigInteger bigInteger) {
        ECPoint eCPointAdd;
        int iMax = Math.max(2, Math.min(16, getWindowSize(bigInteger.bitLength())));
        WNafPreCompInfo wNafPreCompInfoPrecompute = WNafUtil.precompute(eCPoint, iMax, true);
        ECPoint[] preComp = wNafPreCompInfoPrecompute.getPreComp();
        ECPoint[] preCompNeg = wNafPreCompInfoPrecompute.getPreCompNeg();
        int[] iArrGenerateCompactWindowNaf = WNafUtil.generateCompactWindowNaf(iMax, bigInteger);
        ECPoint infinity = eCPoint.getCurve().getInfinity();
        int length = iArrGenerateCompactWindowNaf.length;
        if (length > 1) {
            length--;
            int i = iArrGenerateCompactWindowNaf[length];
            int i2 = i >> 16;
            int i3 = i & 65535;
            int iAbs = Math.abs(i2);
            ECPoint[] eCPointArr = i2 < 0 ? preCompNeg : preComp;
            if ((iAbs << 3) < (1 << iMax)) {
                byte b = LongArray.bitLengths[iAbs];
                int i4 = iAbs ^ (1 << (b - 1));
                int i5 = iMax - b;
                eCPointAdd = eCPointArr[((1 << (iMax - 1)) - 1) >>> 1].add(eCPointArr[((i4 << i5) + 1) >>> 1]);
                i3 -= i5;
            } else {
                eCPointAdd = eCPointArr[iAbs >>> 1];
            }
            infinity = eCPointAdd.timesPow2(i3);
        }
        while (length > 0) {
            length--;
            int i6 = iArrGenerateCompactWindowNaf[length];
            int i7 = i6 >> 16;
            infinity = infinity.twicePlus((i7 < 0 ? preCompNeg : preComp)[Math.abs(i7) >>> 1]).timesPow2(i6 & 65535);
        }
        return infinity;
    }
}
