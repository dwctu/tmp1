package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

/* loaded from: classes5.dex */
public class WTauNafMultiplier extends AbstractECMultiplier {
    private static ECPoint.F2m multiplyFromWTnaf(ECPoint.F2m f2m, byte[] bArr, PreCompInfo preCompInfo) {
        ECPoint.F2m[] preComp;
        ECCurve.F2m f2m2 = (ECCurve.F2m) f2m.getCurve();
        byte bByteValue = f2m2.getA().toBigInteger().byteValue();
        if (preCompInfo == null || !(preCompInfo instanceof WTauNafPreCompInfo)) {
            preComp = Tnaf.getPreComp(f2m, bByteValue);
            f2m2.setPreCompInfo(f2m, new WTauNafPreCompInfo(preComp));
        } else {
            preComp = ((WTauNafPreCompInfo) preCompInfo).getPreComp();
        }
        ECPoint.F2m f2mTau = (ECPoint.F2m) f2m.getCurve().getInfinity();
        for (int length = bArr.length - 1; length >= 0; length--) {
            f2mTau = Tnaf.tau(f2mTau);
            if (bArr[length] != 0) {
                f2mTau = bArr[length] > 0 ? f2mTau.addSimple(preComp[bArr[length]]) : f2mTau.subtractSimple(preComp[-bArr[length]]);
            }
        }
        return f2mTau;
    }

    private ECPoint.F2m multiplyWTnaf(ECPoint.F2m f2m, ZTauElement zTauElement, PreCompInfo preCompInfo, byte b, byte b2) {
        ZTauElement[] zTauElementArr = b == 0 ? Tnaf.alpha0 : Tnaf.alpha1;
        return multiplyFromWTnaf(f2m, Tnaf.tauAdicWNaf(b2, zTauElement, (byte) 4, BigInteger.valueOf(16L), Tnaf.getTw(b2, 4), zTauElementArr), preCompInfo);
    }

    @Override // org.bouncycastle.math.ec.AbstractECMultiplier
    public ECPoint multiplyPositive(ECPoint eCPoint, BigInteger bigInteger) {
        if (!(eCPoint instanceof ECPoint.F2m)) {
            throw new IllegalArgumentException("Only ECPoint.F2m can be used in WTauNafMultiplier");
        }
        ECPoint.F2m f2m = (ECPoint.F2m) eCPoint;
        ECCurve.F2m f2m2 = (ECCurve.F2m) f2m.getCurve();
        int m = f2m2.getM();
        byte bByteValue = f2m2.getA().toBigInteger().byteValue();
        byte mu = f2m2.getMu();
        return multiplyWTnaf(f2m, Tnaf.partModReduction(bigInteger, m, bByteValue, f2m2.getSi(), mu, (byte) 10), f2m2.getPreCompInfo(f2m), bByteValue, mu);
    }
}
