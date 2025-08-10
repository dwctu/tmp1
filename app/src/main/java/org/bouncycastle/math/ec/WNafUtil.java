package org.bouncycastle.math.ec;

import java.math.BigInteger;

/* loaded from: classes5.dex */
public abstract class WNafUtil {
    private static int[] DEFAULT_WINDOW_SIZE_CUTOFFS = {13, 41, 121, 337, 897, 2305};

    public static int[] generateCompactNaf(BigInteger bigInteger) {
        if ((bigInteger.bitLength() >>> 16) != 0) {
            throw new IllegalArgumentException("'k' must have bitlength < 2^16");
        }
        BigInteger bigIntegerAdd = bigInteger.shiftLeft(1).add(bigInteger);
        int iBitLength = bigIntegerAdd.bitLength() - 1;
        int i = (iBitLength + 1) >> 1;
        int[] iArr = new int[i];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 1; i4 <= iBitLength; i4++) {
            boolean zTestBit = bigIntegerAdd.testBit(i4);
            boolean zTestBit2 = bigInteger.testBit(i4);
            if (zTestBit == zTestBit2) {
                i3++;
            } else {
                iArr[i2] = i3 | ((zTestBit2 ? -1 : 1) << 16);
                i2++;
                i3 = 0;
            }
        }
        return i > i2 ? trim(iArr, i2) : iArr;
    }

    public static int[] generateCompactWindowNaf(int i, BigInteger bigInteger) {
        if (i == 2) {
            return generateCompactNaf(bigInteger);
        }
        if (i < 2 || i > 16) {
            throw new IllegalArgumentException("'width' must be in the range [2, 16]");
        }
        if ((bigInteger.bitLength() >>> 16) != 0) {
            throw new IllegalArgumentException("'k' must have bitlength < 2^16");
        }
        int iBitLength = (bigInteger.bitLength() / i) + 1;
        int[] iArr = new int[iBitLength];
        int i2 = 1 << i;
        int i3 = i2 - 1;
        int i4 = i2 >>> 1;
        int i5 = 0;
        int i6 = 0;
        boolean z = false;
        while (i5 <= bigInteger.bitLength()) {
            if (bigInteger.testBit(i5) == z) {
                i5++;
            } else {
                bigInteger = bigInteger.shiftRight(i5);
                int iIntValue = bigInteger.intValue() & i3;
                if (z) {
                    iIntValue++;
                }
                z = (iIntValue & i4) != 0;
                if (z) {
                    iIntValue -= i2;
                }
                if (i6 > 0) {
                    i5--;
                }
                iArr[i6] = i5 | (iIntValue << 16);
                i5 = i;
                i6++;
            }
        }
        return iBitLength > i6 ? trim(iArr, i6) : iArr;
    }

    public static byte[] generateJSF(BigInteger bigInteger, BigInteger bigInteger2) {
        int iMax = Math.max(bigInteger.bitLength(), bigInteger2.bitLength()) + 1;
        byte[] bArr = new byte[iMax];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (bigInteger.signum() <= 0 && bigInteger2.signum() <= 0 && i <= 0 && i2 <= 0) {
                break;
            }
            int iIntValue = (bigInteger.intValue() + i) & 7;
            int iIntValue2 = (bigInteger2.intValue() + i2) & 7;
            int i4 = iIntValue & 1;
            if (i4 != 0) {
                i4 -= iIntValue & 2;
                if (iIntValue + i4 == 4 && (iIntValue2 & 3) == 2) {
                    i4 = -i4;
                }
            }
            int i5 = iIntValue2 & 1;
            if (i5 != 0) {
                i5 -= iIntValue2 & 2;
                if (iIntValue2 + i5 == 4 && (iIntValue & 3) == 2) {
                    i5 = -i5;
                }
            }
            if ((i << 1) == i4 + 1) {
                i = 1 - i;
            }
            if ((i2 << 1) == i5 + 1) {
                i2 = 1 - i2;
            }
            bigInteger = bigInteger.shiftRight(1);
            bigInteger2 = bigInteger2.shiftRight(1);
            bArr[i3] = (byte) ((i4 << 4) | (i5 & 15));
            i3++;
        }
        return iMax > i3 ? trim(bArr, i3) : bArr;
    }

    public static byte[] generateNaf(BigInteger bigInteger) {
        BigInteger bigIntegerAdd = bigInteger.shiftLeft(1).add(bigInteger);
        int iBitLength = bigIntegerAdd.bitLength() - 1;
        byte[] bArr = new byte[iBitLength];
        for (int i = 1; i <= iBitLength; i++) {
            boolean zTestBit = bigIntegerAdd.testBit(i);
            boolean zTestBit2 = bigInteger.testBit(i);
            bArr[i - 1] = (byte) (zTestBit == zTestBit2 ? 0 : zTestBit2 ? -1 : 1);
        }
        return bArr;
    }

    public static byte[] generateWindowNaf(int i, BigInteger bigInteger) {
        if (i == 2) {
            return generateNaf(bigInteger);
        }
        if (i < 2 || i > 8) {
            throw new IllegalArgumentException("'width' must be in the range [2, 8]");
        }
        int iBitLength = bigInteger.bitLength() + 1;
        byte[] bArr = new byte[iBitLength];
        int i2 = 1 << i;
        int i3 = i2 - 1;
        int i4 = i2 >>> 1;
        int i5 = 0;
        int i6 = 0;
        boolean z = false;
        while (i5 <= bigInteger.bitLength()) {
            if (bigInteger.testBit(i5) == z) {
                i5++;
            } else {
                bigInteger = bigInteger.shiftRight(i5);
                int iIntValue = bigInteger.intValue() & i3;
                if (z) {
                    iIntValue++;
                }
                z = (iIntValue & i4) != 0;
                if (z) {
                    iIntValue -= i2;
                }
                if (i6 > 0) {
                    i5--;
                }
                int i7 = i6 + i5;
                bArr[i7] = (byte) iIntValue;
                i6 = i7 + 1;
                i5 = i;
            }
        }
        return iBitLength > i6 ? trim(bArr, i6) : bArr;
    }

    public static WNafPreCompInfo getWNafPreCompInfo(PreCompInfo preCompInfo) {
        return (preCompInfo == null || !(preCompInfo instanceof WNafPreCompInfo)) ? new WNafPreCompInfo() : (WNafPreCompInfo) preCompInfo;
    }

    public static int getWindowSize(int i) {
        return getWindowSize(i, DEFAULT_WINDOW_SIZE_CUTOFFS);
    }

    public static int getWindowSize(int i, int[] iArr) {
        int i2 = 0;
        while (i2 < iArr.length && i >= iArr[i2]) {
            i2++;
        }
        return i2 + 2;
    }

    public static WNafPreCompInfo precompute(ECPoint eCPoint, int i, boolean z) {
        ECCurve curve = eCPoint.getCurve();
        WNafPreCompInfo wNafPreCompInfo = getWNafPreCompInfo(curve.getPreCompInfo(eCPoint));
        ECPoint[] preComp = wNafPreCompInfo.getPreComp();
        int length = 0;
        if (preComp == null) {
            preComp = new ECPoint[]{eCPoint};
        }
        int length2 = preComp.length;
        int iMax = 1 << Math.max(0, i - 2);
        if (length2 < iMax) {
            ECPoint twiceP = wNafPreCompInfo.getTwiceP();
            if (twiceP == null) {
                twiceP = preComp[0].twice().normalize();
                wNafPreCompInfo.setTwiceP(twiceP);
            }
            preComp = resizeTable(preComp, iMax);
            while (length2 < iMax) {
                preComp[length2] = twiceP.add(preComp[length2 - 1]);
                length2++;
            }
            curve.normalizeAll(preComp);
        }
        wNafPreCompInfo.setPreComp(preComp);
        if (z) {
            ECPoint[] preCompNeg = wNafPreCompInfo.getPreCompNeg();
            if (preCompNeg == null) {
                preCompNeg = new ECPoint[iMax];
            } else {
                length = preCompNeg.length;
                if (length < iMax) {
                    preCompNeg = resizeTable(preCompNeg, iMax);
                }
            }
            while (length < iMax) {
                preCompNeg[length] = preComp[length].negate();
                length++;
            }
            wNafPreCompInfo.setPreCompNeg(preCompNeg);
        }
        curve.setPreCompInfo(eCPoint, wNafPreCompInfo);
        return wNafPreCompInfo;
    }

    private static ECPoint[] resizeTable(ECPoint[] eCPointArr, int i) {
        ECPoint[] eCPointArr2 = new ECPoint[i];
        System.arraycopy(eCPointArr, 0, eCPointArr2, 0, eCPointArr.length);
        return eCPointArr2;
    }

    private static byte[] trim(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }

    private static int[] trim(int[] iArr, int i) {
        int[] iArr2 = new int[i];
        System.arraycopy(iArr, 0, iArr2, 0, i);
        return iArr2;
    }
}
