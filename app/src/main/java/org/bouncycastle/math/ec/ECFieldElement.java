package org.bouncycastle.math.ec;

import java.math.BigInteger;
import java.util.Random;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

/* loaded from: classes5.dex */
public abstract class ECFieldElement implements ECConstants {

    public static class F2m extends ECFieldElement {
        public static final int GNB = 1;
        public static final int PPB = 3;
        public static final int TPB = 2;
        private int[] ks;
        private int m;
        private int representation;
        private LongArray x;

        public F2m(int i, int i2, int i3, int i4, BigInteger bigInteger) {
            if (i3 == 0 && i4 == 0) {
                this.representation = 2;
                this.ks = new int[]{i2};
            } else {
                if (i3 >= i4) {
                    throw new IllegalArgumentException("k2 must be smaller than k3");
                }
                if (i3 <= 0) {
                    throw new IllegalArgumentException("k2 must be larger than 0");
                }
                this.representation = 3;
                this.ks = new int[]{i2, i3, i4};
            }
            this.m = i;
            this.x = new LongArray(bigInteger);
        }

        public F2m(int i, int i2, BigInteger bigInteger) {
            this(i, i2, 0, 0, bigInteger);
        }

        private F2m(int i, int[] iArr, LongArray longArray) {
            this.m = i;
            this.representation = iArr.length == 1 ? 2 : 3;
            this.ks = iArr;
            this.x = longArray;
        }

        public static void checkFieldElements(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            if (!(eCFieldElement instanceof F2m) || !(eCFieldElement2 instanceof F2m)) {
                throw new IllegalArgumentException("Field elements are not both instances of ECFieldElement.F2m");
            }
            F2m f2m = (F2m) eCFieldElement;
            F2m f2m2 = (F2m) eCFieldElement2;
            if (f2m.representation != f2m2.representation) {
                throw new IllegalArgumentException("One of the F2m field elements has incorrect representation");
            }
            if (f2m.m != f2m2.m || !Arrays.areEqual(f2m.ks, f2m2.ks)) {
                throw new IllegalArgumentException("Field elements are not elements of the same field F2m");
            }
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement add(ECFieldElement eCFieldElement) {
            LongArray longArray = (LongArray) this.x.clone();
            longArray.addShiftedByWords(((F2m) eCFieldElement).x, 0);
            return new F2m(this.m, this.ks, longArray);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement addOne() {
            return new F2m(this.m, this.ks, this.x.addOne());
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public int bitLength() {
            return this.x.degree();
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement divide(ECFieldElement eCFieldElement) {
            return multiply(eCFieldElement.invert());
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof F2m)) {
                return false;
            }
            F2m f2m = (F2m) obj;
            return this.m == f2m.m && this.representation == f2m.representation && Arrays.areEqual(this.ks, f2m.ks) && this.x.equals(f2m.x);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public String getFieldName() {
            return "F2m";
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public int getFieldSize() {
            return this.m;
        }

        public int getK1() {
            return this.ks[0];
        }

        public int getK2() {
            int[] iArr = this.ks;
            if (iArr.length >= 2) {
                return iArr[1];
            }
            return 0;
        }

        public int getK3() {
            int[] iArr = this.ks;
            if (iArr.length >= 3) {
                return iArr[2];
            }
            return 0;
        }

        public int getM() {
            return this.m;
        }

        public int getRepresentation() {
            return this.representation;
        }

        public int hashCode() {
            return (this.x.hashCode() ^ this.m) ^ Arrays.hashCode(this.ks);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement invert() {
            int i = this.m;
            int[] iArr = this.ks;
            return new F2m(i, iArr, this.x.modInverse(i, iArr));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public boolean isZero() {
            return this.x.isZero();
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement multiply(ECFieldElement eCFieldElement) {
            int i = this.m;
            int[] iArr = this.ks;
            return new F2m(i, iArr, this.x.modMultiply(((F2m) eCFieldElement).x, i, iArr));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement negate() {
            return this;
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement sqrt() {
            throw new RuntimeException("Not implemented");
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement square() {
            int i = this.m;
            int[] iArr = this.ks;
            return new F2m(i, iArr, this.x.modSquare(i, iArr));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement subtract(ECFieldElement eCFieldElement) {
            return add(eCFieldElement);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public boolean testBitZero() {
            return this.x.testBitZero();
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public BigInteger toBigInteger() {
            return this.x.toBigInteger();
        }
    }

    public static class Fp extends ECFieldElement {
        public BigInteger q;
        public BigInteger r;
        public BigInteger x;

        public Fp(BigInteger bigInteger, BigInteger bigInteger2) {
            this(bigInteger, calculateResidue(bigInteger), bigInteger2);
        }

        public Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            if (bigInteger3 == null || bigInteger3.signum() < 0 || bigInteger3.compareTo(bigInteger) >= 0) {
                throw new IllegalArgumentException("x value invalid in Fp field element");
            }
            this.q = bigInteger;
            this.r = bigInteger2;
            this.x = bigInteger3;
        }

        public static BigInteger calculateResidue(BigInteger bigInteger) {
            int iBitLength = bigInteger.bitLength();
            if (iBitLength <= 128 || bigInteger.shiftRight(iBitLength - 64).longValue() != -1) {
                return null;
            }
            return ECConstants.ONE.shiftLeft(iBitLength).subtract(bigInteger);
        }

        private BigInteger[] lucasSequence(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            int iBitLength = bigInteger3.bitLength();
            int lowestSetBit = bigInteger3.getLowestSetBit();
            BigInteger bigIntegerModMult = ECConstants.ONE;
            BigInteger bigIntegerModReduce = bigInteger;
            BigInteger bigIntegerModMult2 = bigIntegerModMult;
            BigInteger bigIntegerModReduce2 = ECConstants.TWO;
            BigInteger bigIntegerModMult3 = bigIntegerModMult2;
            for (int i = iBitLength - 1; i >= lowestSetBit + 1; i--) {
                bigIntegerModMult = modMult(bigIntegerModMult, bigIntegerModMult3);
                if (bigInteger3.testBit(i)) {
                    bigIntegerModMult3 = modMult(bigIntegerModMult, bigInteger2);
                    bigIntegerModMult2 = modMult(bigIntegerModMult2, bigIntegerModReduce);
                    bigIntegerModReduce2 = modReduce(bigIntegerModReduce.multiply(bigIntegerModReduce2).subtract(bigInteger.multiply(bigIntegerModMult)));
                    bigIntegerModReduce = modReduce(bigIntegerModReduce.multiply(bigIntegerModReduce).subtract(bigIntegerModMult3.shiftLeft(1)));
                } else {
                    BigInteger bigIntegerModReduce3 = modReduce(bigIntegerModMult2.multiply(bigIntegerModReduce2).subtract(bigIntegerModMult));
                    BigInteger bigIntegerModReduce4 = modReduce(bigIntegerModReduce.multiply(bigIntegerModReduce2).subtract(bigInteger.multiply(bigIntegerModMult)));
                    bigIntegerModReduce2 = modReduce(bigIntegerModReduce2.multiply(bigIntegerModReduce2).subtract(bigIntegerModMult.shiftLeft(1)));
                    bigIntegerModReduce = bigIntegerModReduce4;
                    bigIntegerModMult2 = bigIntegerModReduce3;
                    bigIntegerModMult3 = bigIntegerModMult;
                }
            }
            BigInteger bigIntegerModMult4 = modMult(bigIntegerModMult, bigIntegerModMult3);
            BigInteger bigIntegerModMult5 = modMult(bigIntegerModMult4, bigInteger2);
            BigInteger bigIntegerModReduce5 = modReduce(bigIntegerModMult2.multiply(bigIntegerModReduce2).subtract(bigIntegerModMult4));
            BigInteger bigIntegerModReduce6 = modReduce(bigIntegerModReduce.multiply(bigIntegerModReduce2).subtract(bigInteger.multiply(bigIntegerModMult4)));
            BigInteger bigIntegerModMult6 = modMult(bigIntegerModMult4, bigIntegerModMult5);
            for (int i2 = 1; i2 <= lowestSetBit; i2++) {
                bigIntegerModReduce5 = modMult(bigIntegerModReduce5, bigIntegerModReduce6);
                bigIntegerModReduce6 = modReduce(bigIntegerModReduce6.multiply(bigIntegerModReduce6).subtract(bigIntegerModMult6.shiftLeft(1)));
                bigIntegerModMult6 = modMult(bigIntegerModMult6, bigIntegerModMult6);
            }
            return new BigInteger[]{bigIntegerModReduce5, bigIntegerModReduce6};
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement add(ECFieldElement eCFieldElement) {
            return new Fp(this.q, this.r, modAdd(this.x, eCFieldElement.toBigInteger()));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement addOne() {
            BigInteger bigIntegerAdd = this.x.add(ECConstants.ONE);
            if (bigIntegerAdd.compareTo(this.q) == 0) {
                bigIntegerAdd = ECConstants.ZERO;
            }
            return new Fp(this.q, this.r, bigIntegerAdd);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement divide(ECFieldElement eCFieldElement) {
            return new Fp(this.q, modMult(this.x, eCFieldElement.toBigInteger().modInverse(this.q)));
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Fp)) {
                return false;
            }
            Fp fp = (Fp) obj;
            return this.q.equals(fp.q) && this.x.equals(fp.x);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public String getFieldName() {
            return "Fp";
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public int getFieldSize() {
            return this.q.bitLength();
        }

        public BigInteger getQ() {
            return this.q;
        }

        public int hashCode() {
            return this.q.hashCode() ^ this.x.hashCode();
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement invert() {
            BigInteger bigInteger = this.q;
            return new Fp(bigInteger, this.r, this.x.modInverse(bigInteger));
        }

        public BigInteger modAdd(BigInteger bigInteger, BigInteger bigInteger2) {
            BigInteger bigIntegerAdd = bigInteger.add(bigInteger2);
            return bigIntegerAdd.compareTo(this.q) >= 0 ? bigIntegerAdd.subtract(this.q) : bigIntegerAdd;
        }

        public BigInteger modDouble(BigInteger bigInteger) {
            BigInteger bigIntegerShiftLeft = bigInteger.shiftLeft(1);
            return bigIntegerShiftLeft.compareTo(this.q) >= 0 ? bigIntegerShiftLeft.subtract(this.q) : bigIntegerShiftLeft;
        }

        public BigInteger modMult(BigInteger bigInteger, BigInteger bigInteger2) {
            return modReduce(bigInteger.multiply(bigInteger2));
        }

        public BigInteger modReduce(BigInteger bigInteger) {
            if (this.r == null) {
                return bigInteger.mod(this.q);
            }
            int iBitLength = this.q.bitLength();
            while (bigInteger.bitLength() > iBitLength + 1) {
                BigInteger bigIntegerShiftRight = bigInteger.shiftRight(iBitLength);
                BigInteger bigIntegerSubtract = bigInteger.subtract(bigIntegerShiftRight.shiftLeft(iBitLength));
                if (!this.r.equals(ECConstants.ONE)) {
                    bigIntegerShiftRight = bigIntegerShiftRight.multiply(this.r);
                }
                bigInteger = bigIntegerShiftRight.add(bigIntegerSubtract);
            }
            while (bigInteger.compareTo(this.q) >= 0) {
                bigInteger = bigInteger.subtract(this.q);
            }
            return bigInteger;
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement multiply(ECFieldElement eCFieldElement) {
            return new Fp(this.q, this.r, modMult(this.x, eCFieldElement.toBigInteger()));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement negate() {
            return new Fp(this.q, this.r, this.x.signum() == 0 ? this.x : ECConstants.ONE.equals(this.r) ? this.q.xor(this.x) : this.q.subtract(this.x));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement sqrt() {
            if (!this.q.testBit(0)) {
                throw new RuntimeException("not done yet");
            }
            if (this.q.testBit(1)) {
                BigInteger bigInteger = this.q;
                Fp fp = new Fp(bigInteger, this.r, this.x.modPow(bigInteger.shiftRight(2).add(ECConstants.ONE), this.q));
                if (fp.square().equals(this)) {
                    return fp;
                }
                return null;
            }
            BigInteger bigInteger2 = this.q;
            BigInteger bigInteger3 = ECConstants.ONE;
            BigInteger bigIntegerSubtract = bigInteger2.subtract(bigInteger3);
            BigInteger bigIntegerShiftRight = bigIntegerSubtract.shiftRight(1);
            if (!this.x.modPow(bigIntegerShiftRight, this.q).equals(bigInteger3)) {
                return null;
            }
            BigInteger bigIntegerAdd = bigIntegerSubtract.shiftRight(2).shiftLeft(1).add(bigInteger3);
            BigInteger bigInteger4 = this.x;
            BigInteger bigIntegerModDouble = modDouble(modDouble(bigInteger4));
            Random random = new Random();
            while (true) {
                BigInteger bigInteger5 = new BigInteger(this.q.bitLength(), random);
                if (bigInteger5.compareTo(this.q) < 0 && bigInteger5.multiply(bigInteger5).subtract(bigIntegerModDouble).modPow(bigIntegerShiftRight, this.q).equals(bigIntegerSubtract)) {
                    BigInteger[] bigIntegerArrLucasSequence = lucasSequence(bigInteger5, bigInteger4, bigIntegerAdd);
                    BigInteger bigInteger6 = bigIntegerArrLucasSequence[0];
                    BigInteger bigIntegerAdd2 = bigIntegerArrLucasSequence[1];
                    if (modMult(bigIntegerAdd2, bigIntegerAdd2).equals(bigIntegerModDouble)) {
                        if (bigIntegerAdd2.testBit(0)) {
                            bigIntegerAdd2 = bigIntegerAdd2.add(this.q);
                        }
                        return new Fp(this.q, this.r, bigIntegerAdd2.shiftRight(1));
                    }
                    if (!bigInteger6.equals(ECConstants.ONE) && !bigInteger6.equals(bigIntegerSubtract)) {
                        return null;
                    }
                }
            }
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement square() {
            BigInteger bigInteger = this.q;
            BigInteger bigInteger2 = this.r;
            BigInteger bigInteger3 = this.x;
            return new Fp(bigInteger, bigInteger2, modMult(bigInteger3, bigInteger3));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement subtract(ECFieldElement eCFieldElement) {
            BigInteger bigIntegerSubtract = this.x.subtract(eCFieldElement.toBigInteger());
            if (bigIntegerSubtract.signum() < 0) {
                bigIntegerSubtract = bigIntegerSubtract.add(this.q);
            }
            return new Fp(this.q, this.r, bigIntegerSubtract);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public BigInteger toBigInteger() {
            return this.x;
        }
    }

    public abstract ECFieldElement add(ECFieldElement eCFieldElement);

    public abstract ECFieldElement addOne();

    public int bitLength() {
        return toBigInteger().bitLength();
    }

    public abstract ECFieldElement divide(ECFieldElement eCFieldElement);

    public byte[] getEncoded() {
        return BigIntegers.asUnsignedByteArray((getFieldSize() + 7) / 8, toBigInteger());
    }

    public abstract String getFieldName();

    public abstract int getFieldSize();

    public abstract ECFieldElement invert();

    public boolean isZero() {
        return toBigInteger().signum() == 0;
    }

    public abstract ECFieldElement multiply(ECFieldElement eCFieldElement);

    public abstract ECFieldElement negate();

    public abstract ECFieldElement sqrt();

    public abstract ECFieldElement square();

    public abstract ECFieldElement subtract(ECFieldElement eCFieldElement);

    public boolean testBitZero() {
        return toBigInteger().testBit(0);
    }

    public abstract BigInteger toBigInteger();

    public String toString() {
        return toBigInteger().toString(16);
    }
}
