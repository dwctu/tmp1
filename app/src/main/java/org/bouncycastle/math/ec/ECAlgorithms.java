package org.bouncycastle.math.ec;

import com.google.common.base.Ascii;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;

/* loaded from: classes5.dex */
public class ECAlgorithms {
    public static void implMontgomeryTrick(ECFieldElement[] eCFieldElementArr, int i, int i2) {
        ECFieldElement[] eCFieldElementArr2 = new ECFieldElement[i2];
        int i3 = 0;
        eCFieldElementArr2[0] = eCFieldElementArr[i];
        while (true) {
            i3++;
            if (i3 >= i2) {
                break;
            } else {
                eCFieldElementArr2[i3] = eCFieldElementArr2[i3 - 1].multiply(eCFieldElementArr[i + i3]);
            }
        }
        int i4 = i3 - 1;
        ECFieldElement eCFieldElementInvert = eCFieldElementArr2[i4].invert();
        while (i4 > 0) {
            int i5 = i4 - 1;
            int i6 = i4 + i;
            ECFieldElement eCFieldElement = eCFieldElementArr[i6];
            eCFieldElementArr[i6] = eCFieldElementArr2[i5].multiply(eCFieldElementInvert);
            eCFieldElementInvert = eCFieldElementInvert.multiply(eCFieldElement);
            i4 = i5;
        }
        eCFieldElementArr[i] = eCFieldElementInvert;
    }

    public static ECPoint implShamirsTrick(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        ECCurve curve = eCPoint.getCurve();
        ECPoint infinity = curve.getInfinity();
        ECPoint[] eCPointArr = {eCPoint2, eCPoint.subtract(eCPoint2), eCPoint, eCPoint.add(eCPoint2)};
        curve.normalizeAll(eCPointArr);
        ECPoint[] eCPointArr2 = {eCPointArr[3].negate(), eCPointArr[2].negate(), eCPointArr[1].negate(), eCPointArr[0].negate(), infinity, eCPointArr[0], eCPointArr[1], eCPointArr[2], eCPointArr[3]};
        byte[] bArrGenerateJSF = WNafUtil.generateJSF(bigInteger, bigInteger2);
        int length = bArrGenerateJSF.length;
        while (true) {
            length--;
            if (length < 0) {
                return infinity;
            }
            byte b = bArrGenerateJSF[length];
            infinity = infinity.twicePlus(eCPointArr2[((b >> 4) * 3) + 4 + ((b << Ascii.FS) >> 28)]);
        }
    }

    public static ECPoint importPoint(ECCurve eCCurve, ECPoint eCPoint) {
        if (eCCurve.equals(eCPoint.getCurve())) {
            return eCCurve.importPoint(eCPoint);
        }
        throw new IllegalArgumentException("Point must be on the same curve");
    }

    public static ECPoint shamirsTrick(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        return implShamirsTrick(eCPoint, bigInteger, importPoint(eCPoint.getCurve(), eCPoint2), bigInteger2);
    }

    public static ECPoint sumOfTwoMultiplies(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        ECCurve curve = eCPoint.getCurve();
        ECPoint eCPointImportPoint = importPoint(curve, eCPoint2);
        return ((curve instanceof ECCurve.F2m) && ((ECCurve.F2m) curve).isKoblitz()) ? eCPoint.multiply(bigInteger).add(eCPointImportPoint.multiply(bigInteger2)) : implShamirsTrick(eCPoint, bigInteger, eCPointImportPoint, bigInteger2);
    }
}
