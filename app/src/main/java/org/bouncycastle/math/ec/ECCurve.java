package org.bouncycastle.math.ec;

import java.math.BigInteger;
import java.util.Random;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.BigIntegers;

/* loaded from: classes5.dex */
public abstract class ECCurve {
    public static final int COORD_AFFINE = 0;
    public static final int COORD_HOMOGENEOUS = 1;
    public static final int COORD_JACOBIAN = 2;
    public static final int COORD_JACOBIAN_CHUDNOVSKY = 3;
    public static final int COORD_JACOBIAN_MODIFIED = 4;
    public static final int COORD_LAMBDA_AFFINE = 5;
    public static final int COORD_LAMBDA_PROJECTIVE = 6;
    public static final int COORD_SKEWED = 7;
    public ECFieldElement a;
    public ECFieldElement b;
    public int coord = 0;
    public ECMultiplier multiplier = null;

    public class Config {
        public int coord;
        public ECMultiplier multiplier;

        public Config(int i, ECMultiplier eCMultiplier) {
            this.coord = i;
            this.multiplier = eCMultiplier;
        }

        public ECCurve create() {
            if (!ECCurve.this.supportsCoordinateSystem(this.coord)) {
                throw new IllegalStateException("unsupported coordinate system");
            }
            ECCurve eCCurveCloneCurve = ECCurve.this.cloneCurve();
            if (eCCurveCloneCurve == ECCurve.this) {
                throw new IllegalStateException("implementation returned current curve");
            }
            eCCurveCloneCurve.coord = this.coord;
            eCCurveCloneCurve.multiplier = this.multiplier;
            return eCCurveCloneCurve;
        }

        public Config setCoordinateSystem(int i) {
            this.coord = i;
            return this;
        }

        public Config setMultiplier(ECMultiplier eCMultiplier) {
            this.multiplier = eCMultiplier;
            return this;
        }
    }

    public static class F2m extends ECCurve {
        private static final int F2M_DEFAULT_COORDS = 0;
        private BigInteger h;
        private ECPoint.F2m infinity;
        private int k1;
        private int k2;
        private int k3;
        private int m;
        private byte mu;
        private BigInteger n;
        private BigInteger[] si;

        public F2m(int i, int i2, int i3, int i4, BigInteger bigInteger, BigInteger bigInteger2) {
            this(i, i2, i3, i4, bigInteger, bigInteger2, (BigInteger) null, (BigInteger) null);
        }

        public F2m(int i, int i2, int i3, int i4, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            this.mu = (byte) 0;
            this.si = null;
            this.m = i;
            this.k1 = i2;
            this.k2 = i3;
            this.k3 = i4;
            this.n = bigInteger3;
            this.h = bigInteger4;
            if (i2 == 0) {
                throw new IllegalArgumentException("k1 must be > 0");
            }
            if (i3 == 0) {
                if (i4 != 0) {
                    throw new IllegalArgumentException("k3 must be 0 if k2 == 0");
                }
            } else {
                if (i3 <= i2) {
                    throw new IllegalArgumentException("k2 must be > k1");
                }
                if (i4 <= i3) {
                    throw new IllegalArgumentException("k3 must be > k2");
                }
            }
            this.infinity = new ECPoint.F2m(this, null, null);
            this.a = fromBigInteger(bigInteger);
            this.b = fromBigInteger(bigInteger2);
            this.coord = 0;
        }

        public F2m(int i, int i2, int i3, int i4, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, BigInteger bigInteger, BigInteger bigInteger2) {
            this.mu = (byte) 0;
            this.si = null;
            this.m = i;
            this.k1 = i2;
            this.k2 = i3;
            this.k3 = i4;
            this.n = bigInteger;
            this.h = bigInteger2;
            this.infinity = new ECPoint.F2m(this, null, null);
            this.a = eCFieldElement;
            this.b = eCFieldElement2;
            this.coord = 0;
        }

        public F2m(int i, int i2, BigInteger bigInteger, BigInteger bigInteger2) {
            this(i, i2, 0, 0, bigInteger, bigInteger2, (BigInteger) null, (BigInteger) null);
        }

        public F2m(int i, int i2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            this(i, i2, 0, 0, bigInteger, bigInteger2, bigInteger3, bigInteger4);
        }

        private ECFieldElement solveQuadraticEquation(ECFieldElement eCFieldElement) {
            ECFieldElement eCFieldElementAdd;
            if (eCFieldElement.isZero()) {
                return eCFieldElement;
            }
            ECFieldElement eCFieldElementFromBigInteger = fromBigInteger(ECConstants.ZERO);
            Random random = new Random();
            do {
                ECFieldElement eCFieldElementFromBigInteger2 = fromBigInteger(new BigInteger(this.m, random));
                ECFieldElement eCFieldElementAdd2 = eCFieldElement;
                eCFieldElementAdd = eCFieldElementFromBigInteger;
                for (int i = 1; i <= this.m - 1; i++) {
                    ECFieldElement eCFieldElementSquare = eCFieldElementAdd2.square();
                    eCFieldElementAdd = eCFieldElementAdd.square().add(eCFieldElementSquare.multiply(eCFieldElementFromBigInteger2));
                    eCFieldElementAdd2 = eCFieldElementSquare.add(eCFieldElement);
                }
                if (!eCFieldElementAdd2.isZero()) {
                    return null;
                }
            } while (eCFieldElementAdd.square().add(eCFieldElementAdd).isZero());
            return eCFieldElementAdd;
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECCurve cloneCurve() {
            return new F2m(this.m, this.k1, this.k2, this.k3, this.a, this.b, this.n, this.h);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECMultiplier createDefaultMultiplier() {
            return isKoblitz() ? new WTauNafMultiplier() : super.createDefaultMultiplier();
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint createPoint(BigInteger bigInteger, BigInteger bigInteger2, boolean z) {
            ECFieldElement eCFieldElementFromBigInteger = fromBigInteger(bigInteger);
            ECFieldElement eCFieldElementFromBigInteger2 = fromBigInteger(bigInteger2);
            int coordinateSystem = getCoordinateSystem();
            if ((coordinateSystem == 5 || coordinateSystem == 6) && !eCFieldElementFromBigInteger.isZero()) {
                eCFieldElementFromBigInteger2 = eCFieldElementFromBigInteger2.divide(eCFieldElementFromBigInteger).add(eCFieldElementFromBigInteger);
            }
            return createRawPoint(eCFieldElementFromBigInteger, eCFieldElementFromBigInteger2, z);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            return new ECPoint.F2m(this, eCFieldElement, eCFieldElement2, z);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint decompressPoint(int i, BigInteger bigInteger) {
            ECFieldElement eCFieldElementMultiply;
            ECFieldElement eCFieldElementFromBigInteger = fromBigInteger(bigInteger);
            if (eCFieldElementFromBigInteger.isZero()) {
                eCFieldElementMultiply = (ECFieldElement.F2m) this.b;
                while (i < this.m - 1) {
                    eCFieldElementMultiply = eCFieldElementMultiply.square();
                    i++;
                }
            } else {
                ECFieldElement eCFieldElementSolveQuadraticEquation = solveQuadraticEquation(eCFieldElementFromBigInteger.add(this.a).add(this.b.multiply(eCFieldElementFromBigInteger.square().invert())));
                if (eCFieldElementSolveQuadraticEquation == null) {
                    throw new IllegalArgumentException("Invalid point compression");
                }
                if (eCFieldElementSolveQuadraticEquation.testBitZero() != (i == 1 ? 1 : 0)) {
                    eCFieldElementSolveQuadraticEquation = eCFieldElementSolveQuadraticEquation.addOne();
                }
                eCFieldElementMultiply = eCFieldElementFromBigInteger.multiply(eCFieldElementSolveQuadraticEquation);
                int coordinateSystem = getCoordinateSystem();
                if (coordinateSystem == 5 || coordinateSystem == 6) {
                    eCFieldElementMultiply = eCFieldElementMultiply.divide(eCFieldElementFromBigInteger).add(eCFieldElementFromBigInteger);
                }
            }
            return new ECPoint.F2m(this, eCFieldElementFromBigInteger, eCFieldElementMultiply, true);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof F2m)) {
                return false;
            }
            F2m f2m = (F2m) obj;
            return this.m == f2m.m && this.k1 == f2m.k1 && this.k2 == f2m.k2 && this.k3 == f2m.k3 && this.a.equals(f2m.a) && this.b.equals(f2m.b);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECFieldElement fromBigInteger(BigInteger bigInteger) {
            return new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, bigInteger);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public int getFieldSize() {
            return this.m;
        }

        public BigInteger getH() {
            return this.h;
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint getInfinity() {
            return this.infinity;
        }

        public int getK1() {
            return this.k1;
        }

        public int getK2() {
            return this.k2;
        }

        public int getK3() {
            return this.k3;
        }

        public int getM() {
            return this.m;
        }

        public synchronized byte getMu() {
            if (this.mu == 0) {
                this.mu = Tnaf.getMu(this);
            }
            return this.mu;
        }

        public BigInteger getN() {
            return this.n;
        }

        public synchronized BigInteger[] getSi() {
            if (this.si == null) {
                this.si = Tnaf.getSi(this);
            }
            return this.si;
        }

        public int hashCode() {
            return ((((this.a.hashCode() ^ this.b.hashCode()) ^ this.m) ^ this.k1) ^ this.k2) ^ this.k3;
        }

        public boolean isKoblitz() {
            return this.n != null && this.h != null && this.a.bitLength() <= 1 && this.b.bitLength() == 1;
        }

        public boolean isTrinomial() {
            return this.k2 == 0 && this.k3 == 0;
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public boolean supportsCoordinateSystem(int i) {
            return i == 0 || i == 1 || i == 6;
        }
    }

    public static class Fp extends ECCurve {
        private static final int FP_DEFAULT_COORDS = 4;
        public ECPoint.Fp infinity = new ECPoint.Fp(this, null, null);
        public BigInteger q;
        public BigInteger r;

        public Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            this.q = bigInteger;
            this.r = ECFieldElement.Fp.calculateResidue(bigInteger);
            this.a = fromBigInteger(bigInteger2);
            this.b = fromBigInteger(bigInteger3);
            this.coord = 4;
        }

        public Fp(BigInteger bigInteger, BigInteger bigInteger2, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            this.q = bigInteger;
            this.r = bigInteger2;
            this.a = eCFieldElement;
            this.b = eCFieldElement2;
            this.coord = 4;
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECCurve cloneCurve() {
            return new Fp(this.q, this.r, this.a, this.b);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            return new ECPoint.Fp(this, eCFieldElement, eCFieldElement2, z);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint decompressPoint(int i, BigInteger bigInteger) {
            ECFieldElement eCFieldElementFromBigInteger = fromBigInteger(bigInteger);
            ECFieldElement eCFieldElementSqrt = eCFieldElementFromBigInteger.multiply(eCFieldElementFromBigInteger.square().add(this.a)).add(this.b).sqrt();
            if (eCFieldElementSqrt == null) {
                throw new RuntimeException("Invalid point compression");
            }
            BigInteger bigInteger2 = eCFieldElementSqrt.toBigInteger();
            if (bigInteger2.testBit(0) != (i == 1)) {
                eCFieldElementSqrt = fromBigInteger(this.q.subtract(bigInteger2));
            }
            return new ECPoint.Fp(this, eCFieldElementFromBigInteger, eCFieldElementSqrt, true);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Fp)) {
                return false;
            }
            Fp fp = (Fp) obj;
            return this.q.equals(fp.q) && this.a.equals(fp.a) && this.b.equals(fp.b);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECFieldElement fromBigInteger(BigInteger bigInteger) {
            return new ECFieldElement.Fp(this.q, this.r, bigInteger);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public int getFieldSize() {
            return this.q.bitLength();
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint getInfinity() {
            return this.infinity;
        }

        public BigInteger getQ() {
            return this.q;
        }

        public int hashCode() {
            return (this.a.hashCode() ^ this.b.hashCode()) ^ this.q.hashCode();
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint importPoint(ECPoint eCPoint) {
            int coordinateSystem;
            return (this == eCPoint.getCurve() || getCoordinateSystem() != 2 || eCPoint.isInfinity() || !((coordinateSystem = eCPoint.getCurve().getCoordinateSystem()) == 2 || coordinateSystem == 3 || coordinateSystem == 4)) ? super.importPoint(eCPoint) : new ECPoint.Fp(this, fromBigInteger(eCPoint.x.toBigInteger()), fromBigInteger(eCPoint.y.toBigInteger()), new ECFieldElement[]{fromBigInteger(eCPoint.zs[0].toBigInteger())}, eCPoint.withCompression);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public boolean supportsCoordinateSystem(int i) {
            return i == 0 || i == 1 || i == 2 || i == 4;
        }
    }

    public static int[] getAllCoordinateSystems() {
        return new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    }

    public void checkPoint(ECPoint eCPoint) {
        if (eCPoint == null || this != eCPoint.getCurve()) {
            throw new IllegalArgumentException("'point' must be non-null and on this curve");
        }
    }

    public void checkPoints(ECPoint[] eCPointArr) {
        if (eCPointArr == null) {
            throw new IllegalArgumentException("'points' cannot be null");
        }
        for (ECPoint eCPoint : eCPointArr) {
            if (eCPoint != null && this != eCPoint.getCurve()) {
                throw new IllegalArgumentException("'points' entries must be null or on this curve");
            }
        }
    }

    public abstract ECCurve cloneCurve();

    public Config configure() {
        return new Config(this.coord, this.multiplier);
    }

    public ECMultiplier createDefaultMultiplier() {
        return new WNafL2RMultiplier();
    }

    public ECPoint createPoint(BigInteger bigInteger, BigInteger bigInteger2) {
        return createPoint(bigInteger, bigInteger2, false);
    }

    public ECPoint createPoint(BigInteger bigInteger, BigInteger bigInteger2, boolean z) {
        return createRawPoint(fromBigInteger(bigInteger), fromBigInteger(bigInteger2), z);
    }

    public abstract ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z);

    public ECPoint decodePoint(byte[] bArr) {
        int fieldSize = (getFieldSize() + 7) / 8;
        byte b = bArr[0];
        if (b == 0) {
            if (bArr.length == 1) {
                return getInfinity();
            }
            throw new IllegalArgumentException("Incorrect length for infinity encoding");
        }
        if (b == 2 || b == 3) {
            if (bArr.length == fieldSize + 1) {
                return decompressPoint(bArr[0] & 1, BigIntegers.fromUnsignedByteArray(bArr, 1, fieldSize));
            }
            throw new IllegalArgumentException("Incorrect length for compressed encoding");
        }
        if (b == 4 || b == 6 || b == 7) {
            if (bArr.length == (fieldSize * 2) + 1) {
                return createPoint(BigIntegers.fromUnsignedByteArray(bArr, 1, fieldSize), BigIntegers.fromUnsignedByteArray(bArr, fieldSize + 1, fieldSize));
            }
            throw new IllegalArgumentException("Incorrect length for uncompressed/hybrid encoding");
        }
        throw new IllegalArgumentException("Invalid point encoding 0x" + Integer.toString(bArr[0], 16));
    }

    public abstract ECPoint decompressPoint(int i, BigInteger bigInteger);

    public abstract ECFieldElement fromBigInteger(BigInteger bigInteger);

    public ECFieldElement getA() {
        return this.a;
    }

    public ECFieldElement getB() {
        return this.b;
    }

    public int getCoordinateSystem() {
        return this.coord;
    }

    public abstract int getFieldSize();

    public abstract ECPoint getInfinity();

    public ECMultiplier getMultiplier() {
        if (this.multiplier == null) {
            this.multiplier = createDefaultMultiplier();
        }
        return this.multiplier;
    }

    public PreCompInfo getPreCompInfo(ECPoint eCPoint) {
        checkPoint(eCPoint);
        return eCPoint.preCompInfo;
    }

    public ECPoint importPoint(ECPoint eCPoint) {
        if (this == eCPoint.getCurve()) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return getInfinity();
        }
        ECPoint eCPointNormalize = eCPoint.normalize();
        return createPoint(eCPointNormalize.getXCoord().toBigInteger(), eCPointNormalize.getYCoord().toBigInteger(), eCPointNormalize.withCompression);
    }

    public void normalizeAll(ECPoint[] eCPointArr) {
        checkPoints(eCPointArr);
        if (getCoordinateSystem() == 0) {
            return;
        }
        ECFieldElement[] eCFieldElementArr = new ECFieldElement[eCPointArr.length];
        int[] iArr = new int[eCPointArr.length];
        int i = 0;
        for (int i2 = 0; i2 < eCPointArr.length; i2++) {
            ECPoint eCPoint = eCPointArr[i2];
            if (eCPoint != null && !eCPoint.isNormalized()) {
                eCFieldElementArr[i] = eCPoint.getZCoord(0);
                iArr[i] = i2;
                i++;
            }
        }
        if (i == 0) {
            return;
        }
        ECAlgorithms.implMontgomeryTrick(eCFieldElementArr, 0, i);
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = iArr[i3];
            eCPointArr[i4] = eCPointArr[i4].normalize(eCFieldElementArr[i3]);
        }
    }

    public void setPreCompInfo(ECPoint eCPoint, PreCompInfo preCompInfo) {
        checkPoint(eCPoint);
        eCPoint.preCompInfo = preCompInfo;
    }

    public boolean supportsCoordinateSystem(int i) {
        return i == 0;
    }
}
