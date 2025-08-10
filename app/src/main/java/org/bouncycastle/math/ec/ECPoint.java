package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;

/* loaded from: classes5.dex */
public abstract class ECPoint {
    public static ECFieldElement[] EMPTY_ZS = new ECFieldElement[0];
    public ECCurve curve;
    public PreCompInfo preCompInfo;
    public boolean withCompression;
    public ECFieldElement x;
    public ECFieldElement y;
    public ECFieldElement[] zs;

    public static class F2m extends ECPoint {
        public F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            this(eCCurve, eCFieldElement, eCFieldElement2, false);
        }

        public F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
            if ((eCFieldElement != null && eCFieldElement2 == null) || (eCFieldElement == null && eCFieldElement2 != null)) {
                throw new IllegalArgumentException("Exactly one of the field elements is null");
            }
            if (eCFieldElement != null) {
                ECFieldElement.F2m.checkFieldElements(this.x, this.y);
                if (eCCurve != null) {
                    ECFieldElement.F2m.checkFieldElements(this.x, this.curve.getA());
                }
            }
            this.withCompression = z;
        }

        public F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
            this.withCompression = z;
        }

        private static void checkPoints(ECPoint eCPoint, ECPoint eCPoint2) {
            if (eCPoint.curve != eCPoint2.curve) {
                throw new IllegalArgumentException("Only points on the same curve can be added or subtracted");
            }
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint add(ECPoint eCPoint) {
            checkPoints(this, eCPoint);
            return addSimple((F2m) eCPoint);
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0085  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public org.bouncycastle.math.ec.ECPoint.F2m addSimple(org.bouncycastle.math.ec.ECPoint.F2m r19) {
            /*
                Method dump skipped, instructions count: 546
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.math.ec.ECPoint.F2m.addSimple(org.bouncycastle.math.ec.ECPoint$F2m):org.bouncycastle.math.ec.ECPoint$F2m");
        }

        public void checkCurveEquation() {
            ECFieldElement eCFieldElementFromBigInteger;
            if (isInfinity()) {
                return;
            }
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem == 5) {
                eCFieldElementFromBigInteger = this.curve.fromBigInteger(ECConstants.ONE);
            } else if (curveCoordinateSystem != 6) {
                return;
            } else {
                eCFieldElementFromBigInteger = this.zs[0];
            }
            if (eCFieldElementFromBigInteger.isZero()) {
                throw new IllegalStateException();
            }
            ECFieldElement eCFieldElement = this.x;
            if (eCFieldElement.isZero()) {
                if (!this.y.square().equals(this.curve.getB().multiply(eCFieldElementFromBigInteger))) {
                    throw new IllegalStateException();
                }
                return;
            }
            ECFieldElement eCFieldElement2 = this.y;
            ECFieldElement eCFieldElementSquare = eCFieldElement.square();
            ECFieldElement eCFieldElementSquare2 = eCFieldElementFromBigInteger.square();
            if (!eCFieldElement2.square().add(eCFieldElement2.multiply(eCFieldElementFromBigInteger)).add(getCurve().getA().multiply(eCFieldElementSquare2)).multiply(eCFieldElementSquare).equals(eCFieldElementSquare2.square().multiply(getCurve().getB()).add(eCFieldElementSquare.square()))) {
                throw new IllegalStateException("F2m Lambda-Projective invariant broken");
            }
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public boolean getCompressionYTilde() {
            ECFieldElement rawXCoord = getRawXCoord();
            if (rawXCoord.isZero()) {
                return false;
            }
            ECFieldElement rawYCoord = getRawYCoord();
            int curveCoordinateSystem = getCurveCoordinateSystem();
            return ((curveCoordinateSystem == 5 || curveCoordinateSystem == 6) ? rawYCoord.subtract(rawXCoord) : rawYCoord.divide(rawXCoord)).testBitZero();
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECFieldElement getYCoord() {
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem != 5 && curveCoordinateSystem != 6) {
                return this.y;
            }
            if (isInfinity() || this.x.isZero()) {
                return this.y;
            }
            ECFieldElement eCFieldElement = this.x;
            ECFieldElement eCFieldElementMultiply = this.y.subtract(eCFieldElement).multiply(eCFieldElement);
            if (6 != curveCoordinateSystem) {
                return eCFieldElementMultiply;
            }
            ECFieldElement eCFieldElement2 = this.zs[0];
            return eCFieldElement2.bitLength() != 1 ? eCFieldElementMultiply.divide(eCFieldElement2) : eCFieldElementMultiply;
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint negate() {
            if (isInfinity()) {
                return this;
            }
            ECFieldElement eCFieldElement = this.x;
            if (eCFieldElement.isZero()) {
                return this;
            }
            int curveCoordinateSystem = getCurveCoordinateSystem();
            if (curveCoordinateSystem == 0) {
                return new F2m(this.curve, eCFieldElement, this.y.add(eCFieldElement), this.withCompression);
            }
            if (curveCoordinateSystem == 1) {
                return new F2m(this.curve, eCFieldElement, this.y.add(eCFieldElement), new ECFieldElement[]{this.zs[0]}, this.withCompression);
            }
            if (curveCoordinateSystem == 5) {
                return new F2m(this.curve, eCFieldElement, this.y.addOne(), this.withCompression);
            }
            if (curveCoordinateSystem != 6) {
                throw new IllegalStateException("unsupported coordinate system");
            }
            ECFieldElement eCFieldElement2 = this.y;
            ECFieldElement eCFieldElement3 = this.zs[0];
            return new F2m(this.curve, eCFieldElement, eCFieldElement2.add(eCFieldElement3), new ECFieldElement[]{eCFieldElement3}, this.withCompression);
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint subtract(ECPoint eCPoint) {
            checkPoints(this, eCPoint);
            return subtractSimple((F2m) eCPoint);
        }

        public F2m subtractSimple(F2m f2m) {
            return f2m.isInfinity() ? this : addSimple((F2m) f2m.negate());
        }

        public F2m tau() {
            if (isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            ECFieldElement eCFieldElement = this.x;
            if (coordinateSystem != 0) {
                if (coordinateSystem != 1) {
                    if (coordinateSystem != 5) {
                        if (coordinateSystem != 6) {
                            throw new IllegalStateException("unsupported coordinate system");
                        }
                    }
                }
                return new F2m(curve, eCFieldElement.square(), this.y.square(), new ECFieldElement[]{this.zs[0].square()}, this.withCompression);
            }
            return new F2m(curve, eCFieldElement.square(), this.y.square(), this.withCompression);
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint twice() {
            ECFieldElement eCFieldElementAdd;
            if (isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            ECFieldElement eCFieldElementMultiply = this.x;
            if (eCFieldElementMultiply.isZero()) {
                return curve.getInfinity();
            }
            int coordinateSystem = curve.getCoordinateSystem();
            if (coordinateSystem == 0) {
                ECFieldElement eCFieldElementAdd2 = this.y.divide(eCFieldElementMultiply).add(eCFieldElementMultiply);
                ECFieldElement eCFieldElementAdd3 = eCFieldElementAdd2.square().add(eCFieldElementAdd2).add(curve.getA());
                return new F2m(curve, eCFieldElementAdd3, eCFieldElementMultiply.square().add(eCFieldElementAdd3.multiply(eCFieldElementAdd2.addOne())), this.withCompression);
            }
            if (coordinateSystem == 1) {
                ECFieldElement eCFieldElementMultiply2 = this.y;
                ECFieldElement eCFieldElement = this.zs[0];
                boolean z = eCFieldElement.bitLength() == 1;
                ECFieldElement eCFieldElementMultiply3 = z ? eCFieldElementMultiply : eCFieldElementMultiply.multiply(eCFieldElement);
                if (!z) {
                    eCFieldElementMultiply2 = eCFieldElementMultiply2.multiply(eCFieldElement);
                }
                ECFieldElement eCFieldElementSquare = eCFieldElementMultiply.square();
                ECFieldElement eCFieldElementAdd4 = eCFieldElementSquare.add(eCFieldElementMultiply2);
                ECFieldElement eCFieldElementSquare2 = eCFieldElementMultiply3.square();
                ECFieldElement eCFieldElementAdd5 = eCFieldElementAdd4.square().add(eCFieldElementAdd4.multiply(eCFieldElementMultiply3)).add(curve.getA().multiply(eCFieldElementSquare2));
                return new F2m(curve, eCFieldElementMultiply3.multiply(eCFieldElementAdd5), eCFieldElementAdd5.multiply(eCFieldElementAdd4.add(eCFieldElementMultiply3)).add(eCFieldElementSquare.square().multiply(eCFieldElementMultiply3)), new ECFieldElement[]{eCFieldElementMultiply3.multiply(eCFieldElementSquare2)}, this.withCompression);
            }
            if (coordinateSystem != 6) {
                throw new IllegalStateException("unsupported coordinate system");
            }
            ECFieldElement eCFieldElement2 = this.y;
            ECFieldElement eCFieldElement3 = this.zs[0];
            boolean z2 = eCFieldElement3.bitLength() == 1;
            ECFieldElement eCFieldElementMultiply4 = z2 ? eCFieldElement2 : eCFieldElement2.multiply(eCFieldElement3);
            ECFieldElement eCFieldElementSquare3 = z2 ? eCFieldElement3 : eCFieldElement3.square();
            ECFieldElement a = curve.getA();
            ECFieldElement eCFieldElementMultiply5 = z2 ? a : a.multiply(eCFieldElementSquare3);
            ECFieldElement eCFieldElementAdd6 = eCFieldElement2.square().add(eCFieldElementMultiply4).add(eCFieldElementMultiply5);
            ECFieldElement eCFieldElementSquare4 = eCFieldElementAdd6.square();
            ECFieldElement eCFieldElementMultiply6 = z2 ? eCFieldElementAdd6 : eCFieldElementAdd6.multiply(eCFieldElementSquare3);
            if (curve.getB().bitLength() < (curve.getFieldSize() >> 1)) {
                ECFieldElement eCFieldElementSquare5 = eCFieldElement2.add(eCFieldElementMultiply).square();
                eCFieldElementAdd = eCFieldElementSquare5.add(eCFieldElementAdd6).add(eCFieldElementSquare3).multiply(eCFieldElementSquare5).add(eCFieldElementMultiply5.square().add(curve.getB().multiply(eCFieldElementSquare3.square()))).add(eCFieldElementSquare4).add(a.addOne().multiply(eCFieldElementMultiply6));
            } else {
                if (!z2) {
                    eCFieldElementMultiply = eCFieldElementMultiply.multiply(eCFieldElement3);
                }
                eCFieldElementAdd = eCFieldElementMultiply.square().add(eCFieldElementSquare4).add(eCFieldElementAdd6.multiply(eCFieldElementMultiply4)).add(eCFieldElementMultiply6);
            }
            return new F2m(curve, eCFieldElementSquare4, eCFieldElementAdd, new ECFieldElement[]{eCFieldElementMultiply6}, this.withCompression);
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint twicePlus(ECPoint eCPoint) {
            if (isInfinity()) {
                return eCPoint;
            }
            if (eCPoint.isInfinity()) {
                return twice();
            }
            ECCurve curve = getCurve();
            ECFieldElement eCFieldElement = this.x;
            if (eCFieldElement.isZero()) {
                return eCPoint;
            }
            if (curve.getCoordinateSystem() != 6) {
                return twice().add(eCPoint);
            }
            ECFieldElement eCFieldElement2 = eCPoint.x;
            ECFieldElement eCFieldElement3 = eCPoint.zs[0];
            if (eCFieldElement2.isZero() || eCFieldElement3.bitLength() != 1) {
                return twice().add(eCPoint);
            }
            ECFieldElement eCFieldElement4 = this.y;
            ECFieldElement eCFieldElement5 = this.zs[0];
            ECFieldElement eCFieldElement6 = eCPoint.y;
            ECFieldElement eCFieldElementSquare = eCFieldElement.square();
            ECFieldElement eCFieldElementSquare2 = eCFieldElement4.square();
            ECFieldElement eCFieldElementSquare3 = eCFieldElement5.square();
            ECFieldElement eCFieldElementAdd = curve.getA().multiply(eCFieldElementSquare3).add(eCFieldElementSquare2).add(eCFieldElement4.multiply(eCFieldElement5));
            ECFieldElement eCFieldElementAddOne = eCFieldElement6.addOne();
            ECFieldElement eCFieldElementAdd2 = curve.getA().add(eCFieldElementAddOne).multiply(eCFieldElementSquare3).add(eCFieldElementSquare2).multiply(eCFieldElementAdd).add(eCFieldElementSquare.multiply(eCFieldElementSquare3));
            ECFieldElement eCFieldElementMultiply = eCFieldElement2.multiply(eCFieldElementSquare3);
            ECFieldElement eCFieldElementSquare4 = eCFieldElementMultiply.add(eCFieldElementAdd).square();
            ECFieldElement eCFieldElementMultiply2 = eCFieldElementAdd2.square().multiply(eCFieldElementMultiply);
            ECFieldElement eCFieldElementMultiply3 = eCFieldElementAdd2.multiply(eCFieldElementSquare4).multiply(eCFieldElementSquare3);
            return new F2m(curve, eCFieldElementMultiply2, eCFieldElementAdd2.add(eCFieldElementSquare4).square().multiply(eCFieldElementAdd).add(eCFieldElementAddOne.multiply(eCFieldElementMultiply3)), new ECFieldElement[]{eCFieldElementMultiply3}, this.withCompression);
        }
    }

    public static class Fp extends ECPoint {
        public Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            this(eCCurve, eCFieldElement, eCFieldElement2, false);
        }

        public Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
            if ((eCFieldElement != null && eCFieldElement2 == null) || (eCFieldElement == null && eCFieldElement2 != null)) {
                throw new IllegalArgumentException("Exactly one of the field elements is null");
            }
            this.withCompression = z;
        }

        public Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
            this.withCompression = z;
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint add(ECPoint eCPoint) {
            ECFieldElement eCFieldElementMultiply;
            ECFieldElement eCFieldElement;
            ECFieldElement eCFieldElement2;
            ECFieldElement eCFieldElement3;
            if (isInfinity()) {
                return eCPoint;
            }
            if (eCPoint.isInfinity()) {
                return this;
            }
            if (this == eCPoint) {
                return twice();
            }
            ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            ECFieldElement eCFieldElementMultiply2 = this.x;
            ECFieldElement eCFieldElementMultiply3 = this.y;
            ECFieldElement eCFieldElementMultiply4 = eCPoint.x;
            ECFieldElement eCFieldElementMultiply5 = eCPoint.y;
            if (coordinateSystem == 0) {
                ECFieldElement eCFieldElementSubtract = eCFieldElementMultiply4.subtract(eCFieldElementMultiply2);
                ECFieldElement eCFieldElementSubtract2 = eCFieldElementMultiply5.subtract(eCFieldElementMultiply3);
                if (eCFieldElementSubtract.isZero()) {
                    return eCFieldElementSubtract2.isZero() ? twice() : curve.getInfinity();
                }
                ECFieldElement eCFieldElementDivide = eCFieldElementSubtract2.divide(eCFieldElementSubtract);
                ECFieldElement eCFieldElementSubtract3 = eCFieldElementDivide.square().subtract(eCFieldElementMultiply2).subtract(eCFieldElementMultiply4);
                return new Fp(curve, eCFieldElementSubtract3, eCFieldElementDivide.multiply(eCFieldElementMultiply2.subtract(eCFieldElementSubtract3)).subtract(eCFieldElementMultiply3), this.withCompression);
            }
            if (coordinateSystem == 1) {
                ECFieldElement eCFieldElementMultiply6 = this.zs[0];
                ECFieldElement eCFieldElement4 = eCPoint.zs[0];
                boolean z = eCFieldElementMultiply6.bitLength() == 1;
                boolean z2 = eCFieldElement4.bitLength() == 1;
                if (!z) {
                    eCFieldElementMultiply5 = eCFieldElementMultiply5.multiply(eCFieldElementMultiply6);
                }
                if (!z2) {
                    eCFieldElementMultiply3 = eCFieldElementMultiply3.multiply(eCFieldElement4);
                }
                ECFieldElement eCFieldElementSubtract4 = eCFieldElementMultiply5.subtract(eCFieldElementMultiply3);
                if (!z) {
                    eCFieldElementMultiply4 = eCFieldElementMultiply4.multiply(eCFieldElementMultiply6);
                }
                if (!z2) {
                    eCFieldElementMultiply2 = eCFieldElementMultiply2.multiply(eCFieldElement4);
                }
                ECFieldElement eCFieldElementSubtract5 = eCFieldElementMultiply4.subtract(eCFieldElementMultiply2);
                if (eCFieldElementSubtract5.isZero()) {
                    return eCFieldElementSubtract4.isZero() ? twice() : curve.getInfinity();
                }
                if (z) {
                    eCFieldElementMultiply6 = eCFieldElement4;
                } else if (!z2) {
                    eCFieldElementMultiply6 = eCFieldElementMultiply6.multiply(eCFieldElement4);
                }
                ECFieldElement eCFieldElementSquare = eCFieldElementSubtract5.square();
                ECFieldElement eCFieldElementMultiply7 = eCFieldElementSquare.multiply(eCFieldElementSubtract5);
                ECFieldElement eCFieldElementMultiply8 = eCFieldElementSquare.multiply(eCFieldElementMultiply2);
                ECFieldElement eCFieldElementSubtract6 = eCFieldElementSubtract4.square().multiply(eCFieldElementMultiply6).subtract(eCFieldElementMultiply7).subtract(two(eCFieldElementMultiply8));
                return new Fp(curve, eCFieldElementSubtract5.multiply(eCFieldElementSubtract6), eCFieldElementMultiply8.subtract(eCFieldElementSubtract6).multiply(eCFieldElementSubtract4).subtract(eCFieldElementMultiply7.multiply(eCFieldElementMultiply3)), new ECFieldElement[]{eCFieldElementMultiply7.multiply(eCFieldElementMultiply6)}, this.withCompression);
            }
            if (coordinateSystem != 2 && coordinateSystem != 4) {
                throw new IllegalStateException("unsupported coordinate system");
            }
            ECFieldElement eCFieldElement5 = this.zs[0];
            ECFieldElement eCFieldElement6 = eCPoint.zs[0];
            boolean z3 = eCFieldElement5.bitLength() == 1;
            if (z3 || !eCFieldElement5.equals(eCFieldElement6)) {
                if (!z3) {
                    ECFieldElement eCFieldElementSquare2 = eCFieldElement5.square();
                    eCFieldElementMultiply4 = eCFieldElementSquare2.multiply(eCFieldElementMultiply4);
                    eCFieldElementMultiply5 = eCFieldElementSquare2.multiply(eCFieldElement5).multiply(eCFieldElementMultiply5);
                }
                boolean z4 = eCFieldElement6.bitLength() == 1;
                if (!z4) {
                    ECFieldElement eCFieldElementSquare3 = eCFieldElement6.square();
                    eCFieldElementMultiply2 = eCFieldElementSquare3.multiply(eCFieldElementMultiply2);
                    eCFieldElementMultiply3 = eCFieldElementSquare3.multiply(eCFieldElement6).multiply(eCFieldElementMultiply3);
                }
                ECFieldElement eCFieldElementSubtract7 = eCFieldElementMultiply2.subtract(eCFieldElementMultiply4);
                ECFieldElement eCFieldElementSubtract8 = eCFieldElementMultiply3.subtract(eCFieldElementMultiply5);
                if (eCFieldElementSubtract7.isZero()) {
                    return eCFieldElementSubtract8.isZero() ? twice() : curve.getInfinity();
                }
                ECFieldElement eCFieldElementSquare4 = eCFieldElementSubtract7.square();
                ECFieldElement eCFieldElementMultiply9 = eCFieldElementSquare4.multiply(eCFieldElementSubtract7);
                ECFieldElement eCFieldElementMultiply10 = eCFieldElementSquare4.multiply(eCFieldElementMultiply2);
                ECFieldElement eCFieldElementSubtract9 = eCFieldElementSubtract8.square().add(eCFieldElementMultiply9).subtract(two(eCFieldElementMultiply10));
                ECFieldElement eCFieldElementSubtract10 = eCFieldElementMultiply10.subtract(eCFieldElementSubtract9).multiply(eCFieldElementSubtract8).subtract(eCFieldElementMultiply3.multiply(eCFieldElementMultiply9));
                ECFieldElement eCFieldElementMultiply11 = !z3 ? eCFieldElementSubtract7.multiply(eCFieldElement5) : eCFieldElementSubtract7;
                eCFieldElementMultiply = !z4 ? eCFieldElementMultiply11.multiply(eCFieldElement6) : eCFieldElementMultiply11;
                eCFieldElement = eCFieldElementSubtract10;
                eCFieldElement2 = eCFieldElementSubtract9;
                eCFieldElement3 = eCFieldElementMultiply == eCFieldElementSubtract7 ? eCFieldElementSquare4 : null;
            } else {
                eCFieldElementMultiply = eCFieldElementMultiply2.subtract(eCFieldElementMultiply4);
                ECFieldElement eCFieldElementSubtract11 = eCFieldElementMultiply3.subtract(eCFieldElementMultiply5);
                if (eCFieldElementMultiply.isZero()) {
                    return eCFieldElementSubtract11.isZero() ? twice() : curve.getInfinity();
                }
                ECFieldElement eCFieldElementSquare5 = eCFieldElementMultiply.square();
                ECFieldElement eCFieldElementMultiply12 = eCFieldElementMultiply2.multiply(eCFieldElementSquare5);
                ECFieldElement eCFieldElementMultiply13 = eCFieldElementMultiply4.multiply(eCFieldElementSquare5);
                ECFieldElement eCFieldElementMultiply14 = eCFieldElementMultiply12.subtract(eCFieldElementMultiply13).multiply(eCFieldElementMultiply3);
                ECFieldElement eCFieldElementSubtract12 = eCFieldElementSubtract11.square().subtract(eCFieldElementMultiply12).subtract(eCFieldElementMultiply13);
                ECFieldElement eCFieldElementSubtract13 = eCFieldElementMultiply12.subtract(eCFieldElementSubtract12).multiply(eCFieldElementSubtract11).subtract(eCFieldElementMultiply14);
                if (z3) {
                    eCFieldElement3 = eCFieldElementSquare5;
                } else {
                    eCFieldElementMultiply = eCFieldElementMultiply.multiply(eCFieldElement5);
                    eCFieldElement3 = null;
                }
                eCFieldElement = eCFieldElementSubtract13;
                eCFieldElement2 = eCFieldElementSubtract12;
            }
            return new Fp(curve, eCFieldElement2, eCFieldElement, coordinateSystem == 4 ? new ECFieldElement[]{eCFieldElementMultiply, calculateJacobianModifiedW(eCFieldElementMultiply, eCFieldElement3)} : new ECFieldElement[]{eCFieldElementMultiply}, this.withCompression);
        }

        public ECFieldElement calculateJacobianModifiedW(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            if (eCFieldElement2 == null) {
                eCFieldElement2 = eCFieldElement.square();
            }
            ECFieldElement eCFieldElementSquare = eCFieldElement2.square();
            ECFieldElement a = getCurve().getA();
            ECFieldElement eCFieldElementNegate = a.negate();
            return eCFieldElementNegate.bitLength() < a.bitLength() ? eCFieldElementSquare.multiply(eCFieldElementNegate).negate() : eCFieldElementSquare.multiply(a);
        }

        public ECFieldElement doubleProductFromSquares(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement eCFieldElement3, ECFieldElement eCFieldElement4) {
            return eCFieldElement.add(eCFieldElement2).square().subtract(eCFieldElement3).subtract(eCFieldElement4);
        }

        public ECFieldElement eight(ECFieldElement eCFieldElement) {
            return four(two(eCFieldElement));
        }

        public ECFieldElement four(ECFieldElement eCFieldElement) {
            return two(two(eCFieldElement));
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public boolean getCompressionYTilde() {
            return getAffineYCoord().testBitZero();
        }

        public ECFieldElement getJacobianModifiedW() {
            ECFieldElement[] eCFieldElementArr = this.zs;
            ECFieldElement eCFieldElement = eCFieldElementArr[1];
            if (eCFieldElement != null) {
                return eCFieldElement;
            }
            ECFieldElement eCFieldElementCalculateJacobianModifiedW = calculateJacobianModifiedW(eCFieldElementArr[0], null);
            eCFieldElementArr[1] = eCFieldElementCalculateJacobianModifiedW;
            return eCFieldElementCalculateJacobianModifiedW;
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECFieldElement getZCoord(int i) {
            return (i == 1 && 4 == getCurveCoordinateSystem()) ? getJacobianModifiedW() : super.getZCoord(i);
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint negate() {
            if (isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            return curve.getCoordinateSystem() != 0 ? new Fp(curve, this.x, this.y.negate(), this.zs, this.withCompression) : new Fp(curve, this.x, this.y.negate(), this.withCompression);
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint subtract(ECPoint eCPoint) {
            return eCPoint.isInfinity() ? this : add(eCPoint.negate());
        }

        public ECFieldElement three(ECFieldElement eCFieldElement) {
            return two(eCFieldElement).add(eCFieldElement);
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint threeTimes() {
            if (isInfinity() || this.y.isZero()) {
                return this;
            }
            ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            if (coordinateSystem != 0) {
                return coordinateSystem != 4 ? twice().add(this) : twiceJacobianModified(false).add(this);
            }
            ECFieldElement eCFieldElement = this.x;
            ECFieldElement eCFieldElement2 = this.y;
            ECFieldElement eCFieldElementTwo = two(eCFieldElement2);
            ECFieldElement eCFieldElementSquare = eCFieldElementTwo.square();
            ECFieldElement eCFieldElementAdd = three(eCFieldElement.square()).add(getCurve().getA());
            ECFieldElement eCFieldElementSubtract = three(eCFieldElement).multiply(eCFieldElementSquare).subtract(eCFieldElementAdd.square());
            if (eCFieldElementSubtract.isZero()) {
                return getCurve().getInfinity();
            }
            ECFieldElement eCFieldElementInvert = eCFieldElementSubtract.multiply(eCFieldElementTwo).invert();
            ECFieldElement eCFieldElementMultiply = eCFieldElementSubtract.multiply(eCFieldElementInvert).multiply(eCFieldElementAdd);
            ECFieldElement eCFieldElementSubtract2 = eCFieldElementSquare.square().multiply(eCFieldElementInvert).subtract(eCFieldElementMultiply);
            ECFieldElement eCFieldElementAdd2 = eCFieldElementSubtract2.subtract(eCFieldElementMultiply).multiply(eCFieldElementMultiply.add(eCFieldElementSubtract2)).add(eCFieldElement);
            return new Fp(curve, eCFieldElementAdd2, eCFieldElement.subtract(eCFieldElementAdd2).multiply(eCFieldElementSubtract2).subtract(eCFieldElement2), this.withCompression);
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint twice() {
            ECFieldElement eCFieldElementSubtract;
            ECFieldElement eCFieldElementTwo;
            if (isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            ECFieldElement eCFieldElement = this.y;
            if (eCFieldElement.isZero()) {
                return curve.getInfinity();
            }
            int coordinateSystem = curve.getCoordinateSystem();
            ECFieldElement eCFieldElement2 = this.x;
            if (coordinateSystem == 0) {
                ECFieldElement eCFieldElementDivide = three(eCFieldElement2.square()).add(getCurve().getA()).divide(two(eCFieldElement));
                ECFieldElement eCFieldElementSubtract2 = eCFieldElementDivide.square().subtract(two(eCFieldElement2));
                return new Fp(curve, eCFieldElementSubtract2, eCFieldElementDivide.multiply(eCFieldElement2.subtract(eCFieldElementSubtract2)).subtract(eCFieldElement), this.withCompression);
            }
            if (coordinateSystem == 1) {
                ECFieldElement eCFieldElement3 = this.zs[0];
                boolean z = eCFieldElement3.bitLength() == 1;
                ECFieldElement eCFieldElementSquare = z ? eCFieldElement3 : eCFieldElement3.square();
                ECFieldElement a = curve.getA();
                if (!z) {
                    a = a.multiply(eCFieldElementSquare);
                }
                ECFieldElement eCFieldElementAdd = a.add(three(eCFieldElement2.square()));
                ECFieldElement eCFieldElementMultiply = z ? eCFieldElement : eCFieldElement.multiply(eCFieldElement3);
                ECFieldElement eCFieldElementSquare2 = z ? eCFieldElement.square() : eCFieldElementMultiply.multiply(eCFieldElement);
                ECFieldElement eCFieldElementFour = four(eCFieldElement2.multiply(eCFieldElementSquare2));
                ECFieldElement eCFieldElementSubtract3 = eCFieldElementAdd.square().subtract(two(eCFieldElementFour));
                return new Fp(curve, two(eCFieldElementSubtract3.multiply(eCFieldElementMultiply)), eCFieldElementAdd.multiply(eCFieldElementFour.subtract(eCFieldElementSubtract3)).subtract(two(two(eCFieldElementSquare2).square())), new ECFieldElement[]{two(z ? four(eCFieldElementSquare2) : two(eCFieldElementMultiply).square()).multiply(eCFieldElementMultiply)}, this.withCompression);
            }
            if (coordinateSystem != 2) {
                if (coordinateSystem == 4) {
                    return twiceJacobianModified(true);
                }
                throw new IllegalStateException("unsupported coordinate system");
            }
            ECFieldElement eCFieldElement4 = this.zs[0];
            boolean z2 = eCFieldElement4.bitLength() == 1;
            ECFieldElement eCFieldElementSquare3 = z2 ? eCFieldElement4 : eCFieldElement4.square();
            ECFieldElement eCFieldElementSquare4 = eCFieldElement.square();
            ECFieldElement eCFieldElementSquare5 = eCFieldElementSquare4.square();
            ECFieldElement a2 = curve.getA();
            ECFieldElement eCFieldElementNegate = a2.negate();
            if (eCFieldElementNegate.toBigInteger().equals(BigInteger.valueOf(3L))) {
                eCFieldElementSubtract = three(eCFieldElement2.add(eCFieldElementSquare3).multiply(eCFieldElement2.subtract(eCFieldElementSquare3)));
                eCFieldElementTwo = four(eCFieldElementSquare4.multiply(eCFieldElement2));
            } else {
                ECFieldElement eCFieldElementSquare6 = eCFieldElement2.square();
                ECFieldElement eCFieldElementThree = three(eCFieldElementSquare6);
                if (z2) {
                    eCFieldElementSubtract = eCFieldElementThree.add(a2);
                } else {
                    ECFieldElement eCFieldElementSquare7 = eCFieldElementSquare3.square();
                    eCFieldElementSubtract = eCFieldElementNegate.bitLength() < a2.bitLength() ? eCFieldElementThree.subtract(eCFieldElementSquare7.multiply(eCFieldElementNegate)) : eCFieldElementThree.add(eCFieldElementSquare7.multiply(a2));
                }
                eCFieldElementTwo = two(doubleProductFromSquares(eCFieldElement2, eCFieldElementSquare4, eCFieldElementSquare6, eCFieldElementSquare5));
            }
            ECFieldElement eCFieldElementSubtract4 = eCFieldElementSubtract.square().subtract(two(eCFieldElementTwo));
            ECFieldElement eCFieldElementSubtract5 = eCFieldElementTwo.subtract(eCFieldElementSubtract4).multiply(eCFieldElementSubtract).subtract(eight(eCFieldElementSquare5));
            ECFieldElement eCFieldElementTwo2 = two(eCFieldElement);
            if (!z2) {
                eCFieldElementTwo2 = eCFieldElementTwo2.multiply(eCFieldElement4);
            }
            return new Fp(curve, eCFieldElementSubtract4, eCFieldElementSubtract5, new ECFieldElement[]{eCFieldElementTwo2}, this.withCompression);
        }

        public Fp twiceJacobianModified(boolean z) {
            ECFieldElement eCFieldElement = this.x;
            ECFieldElement eCFieldElementMultiply = this.y;
            ECFieldElement eCFieldElement2 = this.zs[0];
            ECFieldElement jacobianModifiedW = getJacobianModifiedW();
            ECFieldElement eCFieldElementSquare = eCFieldElement.square();
            ECFieldElement eCFieldElementAdd = three(eCFieldElementSquare).add(jacobianModifiedW);
            ECFieldElement eCFieldElementSquare2 = eCFieldElementMultiply.square();
            ECFieldElement eCFieldElementSquare3 = eCFieldElementSquare2.square();
            ECFieldElement eCFieldElementTwo = two(doubleProductFromSquares(eCFieldElement, eCFieldElementSquare2, eCFieldElementSquare, eCFieldElementSquare3));
            ECFieldElement eCFieldElementSubtract = eCFieldElementAdd.square().subtract(two(eCFieldElementTwo));
            ECFieldElement eCFieldElementEight = eight(eCFieldElementSquare3);
            ECFieldElement eCFieldElementSubtract2 = eCFieldElementAdd.multiply(eCFieldElementTwo.subtract(eCFieldElementSubtract)).subtract(eCFieldElementEight);
            ECFieldElement eCFieldElementTwo2 = z ? two(eCFieldElementEight.multiply(jacobianModifiedW)) : null;
            if (eCFieldElement2.bitLength() != 1) {
                eCFieldElementMultiply = eCFieldElementMultiply.multiply(eCFieldElement2);
            }
            return new Fp(getCurve(), eCFieldElementSubtract, eCFieldElementSubtract2, new ECFieldElement[]{two(eCFieldElementMultiply), eCFieldElementTwo2}, this.withCompression);
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint twicePlus(ECPoint eCPoint) {
            if (this == eCPoint) {
                return threeTimes();
            }
            if (isInfinity()) {
                return eCPoint;
            }
            if (eCPoint.isInfinity()) {
                return twice();
            }
            ECFieldElement eCFieldElement = this.y;
            if (eCFieldElement.isZero()) {
                return eCPoint;
            }
            ECCurve curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            if (coordinateSystem != 0) {
                return coordinateSystem != 4 ? twice().add(eCPoint) : twiceJacobianModified(false).add(eCPoint);
            }
            ECFieldElement eCFieldElement2 = this.x;
            ECFieldElement eCFieldElement3 = eCPoint.x;
            ECFieldElement eCFieldElement4 = eCPoint.y;
            ECFieldElement eCFieldElementSubtract = eCFieldElement3.subtract(eCFieldElement2);
            ECFieldElement eCFieldElementSubtract2 = eCFieldElement4.subtract(eCFieldElement);
            if (eCFieldElementSubtract.isZero()) {
                return eCFieldElementSubtract2.isZero() ? threeTimes() : this;
            }
            ECFieldElement eCFieldElementSquare = eCFieldElementSubtract.square();
            ECFieldElement eCFieldElementSubtract3 = eCFieldElementSquare.multiply(two(eCFieldElement2).add(eCFieldElement3)).subtract(eCFieldElementSubtract2.square());
            if (eCFieldElementSubtract3.isZero()) {
                return curve.getInfinity();
            }
            ECFieldElement eCFieldElementInvert = eCFieldElementSubtract3.multiply(eCFieldElementSubtract).invert();
            ECFieldElement eCFieldElementMultiply = eCFieldElementSubtract3.multiply(eCFieldElementInvert).multiply(eCFieldElementSubtract2);
            ECFieldElement eCFieldElementSubtract4 = two(eCFieldElement).multiply(eCFieldElementSquare).multiply(eCFieldElementSubtract).multiply(eCFieldElementInvert).subtract(eCFieldElementMultiply);
            ECFieldElement eCFieldElementAdd = eCFieldElementSubtract4.subtract(eCFieldElementMultiply).multiply(eCFieldElementMultiply.add(eCFieldElementSubtract4)).add(eCFieldElement3);
            return new Fp(curve, eCFieldElementAdd, eCFieldElement2.subtract(eCFieldElementAdd).multiply(eCFieldElementSubtract4).subtract(eCFieldElement), this.withCompression);
        }

        public ECFieldElement two(ECFieldElement eCFieldElement) {
            return eCFieldElement.add(eCFieldElement);
        }
    }

    public ECPoint(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, getInitialZCoords(eCCurve));
    }

    public ECPoint(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        this.preCompInfo = null;
        this.curve = eCCurve;
        this.x = eCFieldElement;
        this.y = eCFieldElement2;
        this.zs = eCFieldElementArr;
    }

    public static ECFieldElement[] getInitialZCoords(ECCurve eCCurve) {
        int coordinateSystem = eCCurve == null ? 0 : eCCurve.getCoordinateSystem();
        if (coordinateSystem == 0 || coordinateSystem == 5) {
            return EMPTY_ZS;
        }
        ECFieldElement eCFieldElementFromBigInteger = eCCurve.fromBigInteger(ECConstants.ONE);
        if (coordinateSystem != 1 && coordinateSystem != 2) {
            if (coordinateSystem == 3) {
                return new ECFieldElement[]{eCFieldElementFromBigInteger, eCFieldElementFromBigInteger, eCFieldElementFromBigInteger};
            }
            if (coordinateSystem == 4) {
                return new ECFieldElement[]{eCFieldElementFromBigInteger, eCCurve.getA()};
            }
            if (coordinateSystem != 6) {
                throw new IllegalArgumentException("unknown coordinate system");
            }
        }
        return new ECFieldElement[]{eCFieldElementFromBigInteger};
    }

    public abstract ECPoint add(ECPoint eCPoint);

    public void checkNormalized() {
        if (!isNormalized()) {
            throw new IllegalStateException("point not in normal form");
        }
    }

    public ECPoint createScaledPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return getCurve().createRawPoint(getRawXCoord().multiply(eCFieldElement), getRawYCoord().multiply(eCFieldElement2), this.withCompression);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ECPoint) {
            return equals((ECPoint) obj);
        }
        return false;
    }

    public boolean equals(ECPoint eCPoint) {
        ECPoint eCPointNormalize;
        if (eCPoint == null) {
            return false;
        }
        ECCurve curve = getCurve();
        ECCurve curve2 = eCPoint.getCurve();
        boolean z = curve == null;
        boolean z2 = curve2 == null;
        boolean zIsInfinity = isInfinity();
        boolean zIsInfinity2 = eCPoint.isInfinity();
        if (zIsInfinity || zIsInfinity2) {
            if (zIsInfinity && zIsInfinity2) {
                return z || z2 || curve.equals(curve2);
            }
            return false;
        }
        if (z && z2) {
            eCPointNormalize = this;
        } else if (z) {
            eCPoint = eCPoint.normalize();
            eCPointNormalize = this;
        } else if (z2) {
            eCPointNormalize = normalize();
        } else {
            if (!curve.equals(curve2)) {
                return false;
            }
            ECPoint[] eCPointArr = {this, curve.importPoint(eCPoint)};
            curve.normalizeAll(eCPointArr);
            eCPointNormalize = eCPointArr[0];
            eCPoint = eCPointArr[1];
        }
        return eCPointNormalize.getXCoord().equals(eCPoint.getXCoord()) && eCPointNormalize.getYCoord().equals(eCPoint.getYCoord());
    }

    public ECFieldElement getAffineXCoord() {
        checkNormalized();
        return getXCoord();
    }

    public ECFieldElement getAffineYCoord() {
        checkNormalized();
        return getYCoord();
    }

    public abstract boolean getCompressionYTilde();

    public ECCurve getCurve() {
        return this.curve;
    }

    public int getCurveCoordinateSystem() {
        ECCurve eCCurve = this.curve;
        if (eCCurve == null) {
            return 0;
        }
        return eCCurve.getCoordinateSystem();
    }

    public byte[] getEncoded() {
        return getEncoded(this.withCompression);
    }

    public byte[] getEncoded(boolean z) {
        if (isInfinity()) {
            return new byte[1];
        }
        ECPoint eCPointNormalize = normalize();
        byte[] encoded = eCPointNormalize.getXCoord().getEncoded();
        if (z) {
            byte[] bArr = new byte[encoded.length + 1];
            bArr[0] = (byte) (eCPointNormalize.getCompressionYTilde() ? 3 : 2);
            System.arraycopy(encoded, 0, bArr, 1, encoded.length);
            return bArr;
        }
        byte[] encoded2 = eCPointNormalize.getYCoord().getEncoded();
        byte[] bArr2 = new byte[encoded.length + encoded2.length + 1];
        bArr2[0] = 4;
        System.arraycopy(encoded, 0, bArr2, 1, encoded.length);
        System.arraycopy(encoded2, 0, bArr2, encoded.length + 1, encoded2.length);
        return bArr2;
    }

    public ECFieldElement getRawXCoord() {
        return this.x;
    }

    public ECFieldElement getRawYCoord() {
        return this.y;
    }

    public ECFieldElement getX() {
        return normalize().getXCoord();
    }

    public ECFieldElement getXCoord() {
        return this.x;
    }

    public ECFieldElement getY() {
        return normalize().getYCoord();
    }

    public ECFieldElement getYCoord() {
        return this.y;
    }

    public ECFieldElement getZCoord(int i) {
        if (i >= 0) {
            ECFieldElement[] eCFieldElementArr = this.zs;
            if (i < eCFieldElementArr.length) {
                return eCFieldElementArr[i];
            }
        }
        return null;
    }

    public ECFieldElement[] getZCoords() {
        ECFieldElement[] eCFieldElementArr = this.zs;
        int length = eCFieldElementArr.length;
        if (length == 0) {
            return eCFieldElementArr;
        }
        ECFieldElement[] eCFieldElementArr2 = new ECFieldElement[length];
        System.arraycopy(eCFieldElementArr, 0, eCFieldElementArr2, 0, length);
        return eCFieldElementArr2;
    }

    public int hashCode() {
        ECCurve curve = getCurve();
        int i = curve == null ? 0 : ~curve.hashCode();
        if (isInfinity()) {
            return i;
        }
        ECPoint eCPointNormalize = normalize();
        return (i ^ (eCPointNormalize.getXCoord().hashCode() * 17)) ^ (eCPointNormalize.getYCoord().hashCode() * 257);
    }

    public boolean isCompressed() {
        return this.withCompression;
    }

    public boolean isInfinity() {
        if (this.x != null && this.y != null) {
            ECFieldElement[] eCFieldElementArr = this.zs;
            if (eCFieldElementArr.length <= 0 || !eCFieldElementArr[0].isZero()) {
                return false;
            }
        }
        return true;
    }

    public boolean isNormalized() {
        int curveCoordinateSystem = getCurveCoordinateSystem();
        return curveCoordinateSystem == 0 || curveCoordinateSystem == 5 || isInfinity() || this.zs[0].bitLength() == 1;
    }

    public ECPoint multiply(BigInteger bigInteger) {
        return getCurve().getMultiplier().multiply(this, bigInteger);
    }

    public abstract ECPoint negate();

    public ECPoint normalize() {
        int curveCoordinateSystem;
        if (isInfinity() || (curveCoordinateSystem = getCurveCoordinateSystem()) == 0 || curveCoordinateSystem == 5) {
            return this;
        }
        ECFieldElement zCoord = getZCoord(0);
        return zCoord.bitLength() == 1 ? this : normalize(zCoord.invert());
    }

    public ECPoint normalize(ECFieldElement eCFieldElement) {
        int curveCoordinateSystem = getCurveCoordinateSystem();
        if (curveCoordinateSystem != 1) {
            if (curveCoordinateSystem == 2 || curveCoordinateSystem == 3 || curveCoordinateSystem == 4) {
                ECFieldElement eCFieldElementSquare = eCFieldElement.square();
                return createScaledPoint(eCFieldElementSquare, eCFieldElementSquare.multiply(eCFieldElement));
            }
            if (curveCoordinateSystem != 6) {
                throw new IllegalStateException("not a projective coordinate system");
            }
        }
        return createScaledPoint(eCFieldElement, eCFieldElement);
    }

    public abstract ECPoint subtract(ECPoint eCPoint);

    public ECPoint threeTimes() {
        return twicePlus(this);
    }

    public ECPoint timesPow2(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("'e' cannot be negative");
        }
        ECPoint eCPointTwice = this;
        while (true) {
            i--;
            if (i < 0) {
                return eCPointTwice;
            }
            eCPointTwice = eCPointTwice.twice();
        }
    }

    public String toString() {
        if (isInfinity()) {
            return "INF";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        stringBuffer.append(getRawXCoord());
        stringBuffer.append(',');
        stringBuffer.append(getRawYCoord());
        for (int i = 0; i < this.zs.length; i++) {
            stringBuffer.append(',');
            stringBuffer.append(this.zs[i]);
        }
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public abstract ECPoint twice();

    public ECPoint twicePlus(ECPoint eCPoint) {
        return twice().add(eCPoint);
    }
}
