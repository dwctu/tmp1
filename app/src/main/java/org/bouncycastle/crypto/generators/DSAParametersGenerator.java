package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.params.DSAParameterGenerationParameters;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAValidationParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes5.dex */
public class DSAParametersGenerator {
    private int L;
    private int N;
    private int certainty;
    private Digest digest;
    private SecureRandom random;
    private int usageIndex;
    private boolean use186_3;
    private static final BigInteger ZERO = BigInteger.valueOf(0);
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);

    public DSAParametersGenerator() {
        this(new SHA1Digest());
    }

    public DSAParametersGenerator(Digest digest) {
        this.digest = digest;
    }

    private static BigInteger calculateGenerator_FIPS186_2(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        BigInteger bigIntegerModPow;
        BigInteger bigIntegerDivide = bigInteger.subtract(ONE).divide(bigInteger2);
        BigInteger bigIntegerSubtract = bigInteger.subtract(TWO);
        do {
            bigIntegerModPow = BigIntegers.createRandomInRange(TWO, bigIntegerSubtract, secureRandom).modPow(bigIntegerDivide, bigInteger);
        } while (bigIntegerModPow.bitLength() <= 1);
        return bigIntegerModPow;
    }

    private static BigInteger calculateGenerator_FIPS186_3_Unverifiable(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        return calculateGenerator_FIPS186_2(bigInteger, bigInteger2, secureRandom);
    }

    private static BigInteger calculateGenerator_FIPS186_3_Verifiable(Digest digest, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr, int i) {
        BigInteger bigIntegerDivide = bigInteger.subtract(ONE).divide(bigInteger2);
        byte[] bArrDecode = Hex.decode("6767656E");
        int length = bArr.length + bArrDecode.length + 1 + 2;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(bArrDecode, 0, bArr2, bArr.length, bArrDecode.length);
        bArr2[length - 3] = (byte) i;
        byte[] bArr3 = new byte[digest.getDigestSize()];
        for (int i2 = 1; i2 < 65536; i2++) {
            inc(bArr2);
            hash(digest, bArr2, bArr3);
            BigInteger bigIntegerModPow = new BigInteger(1, bArr3).modPow(bigIntegerDivide, bigInteger);
            if (bigIntegerModPow.compareTo(TWO) >= 0) {
                return bigIntegerModPow;
            }
        }
        return null;
    }

    private DSAParameters generateParameters_FIPS186_2() {
        int i = 20;
        byte[] bArr = new byte[20];
        byte[] bArr2 = new byte[20];
        byte[] bArr3 = new byte[20];
        byte[] bArr4 = new byte[20];
        int i2 = this.L;
        int i3 = (i2 - 1) / 160;
        int i4 = i2 / 8;
        byte[] bArr5 = new byte[i4];
        if (!(this.digest instanceof SHA1Digest)) {
            throw new IllegalStateException("can only use SHA-1 for generating FIPS 186-2 parameters");
        }
        while (true) {
            this.random.nextBytes(bArr);
            hash(this.digest, bArr, bArr2);
            System.arraycopy(bArr, 0, bArr3, 0, i);
            inc(bArr3);
            hash(this.digest, bArr3, bArr3);
            for (int i5 = 0; i5 != i; i5++) {
                bArr4[i5] = (byte) (bArr2[i5] ^ bArr3[i5]);
            }
            bArr4[0] = (byte) (bArr4[0] | Byte.MIN_VALUE);
            bArr4[19] = (byte) (bArr4[19] | 1);
            BigInteger bigInteger = new BigInteger(1, bArr4);
            if (bigInteger.isProbablePrime(this.certainty)) {
                byte[] bArrClone = Arrays.clone(bArr);
                inc(bArrClone);
                int i6 = 0;
                while (i6 < 4096) {
                    int i7 = 0;
                    while (true) {
                        inc(bArrClone);
                        if (i7 >= i3) {
                            break;
                        }
                        hash(this.digest, bArrClone, bArr2);
                        i7++;
                        System.arraycopy(bArr2, 0, bArr5, i4 - (i7 * 20), i);
                    }
                    hash(this.digest, bArrClone, bArr2);
                    int i8 = i4 - (i3 * 20);
                    System.arraycopy(bArr2, 20 - i8, bArr5, 0, i8);
                    bArr5[0] = (byte) (bArr5[0] | Byte.MIN_VALUE);
                    BigInteger bigInteger2 = new BigInteger(1, bArr5);
                    BigInteger bigIntegerSubtract = bigInteger2.subtract(bigInteger2.mod(bigInteger.shiftLeft(1)).subtract(ONE));
                    if (bigIntegerSubtract.bitLength() == this.L && bigIntegerSubtract.isProbablePrime(this.certainty)) {
                        return new DSAParameters(bigIntegerSubtract, bigInteger, calculateGenerator_FIPS186_2(bigIntegerSubtract, bigInteger, this.random), new DSAValidationParameters(bArr, i6));
                    }
                    i6++;
                    i = 20;
                }
            }
        }
    }

    private DSAParameters generateParameters_FIPS186_3() {
        BigInteger bigIntegerSubtract;
        int i;
        BigInteger bigIntegerSubtract2;
        BigInteger bigIntegerCalculateGenerator_FIPS186_3_Verifiable;
        Digest digest = this.digest;
        int digestSize = digest.getDigestSize() * 8;
        byte[] bArr = new byte[this.N / 8];
        int i2 = this.L;
        int i3 = (i2 - 1) / digestSize;
        int i4 = 1;
        int i5 = (i2 - 1) % digestSize;
        byte[] bArr2 = new byte[digest.getDigestSize()];
        loop0: while (true) {
            this.random.nextBytes(bArr);
            hash(digest, bArr, bArr2);
            BigInteger bigInteger = new BigInteger(i4, bArr2);
            BigInteger bigInteger2 = ONE;
            BigInteger bigIntegerMod = bigInteger.mod(bigInteger2.shiftLeft(this.N - i4));
            bigIntegerSubtract = bigInteger2.shiftLeft(this.N - i4).add(bigIntegerMod).add(bigInteger2).subtract(bigIntegerMod.mod(TWO));
            if (bigIntegerSubtract.isProbablePrime(this.certainty)) {
                byte[] bArrClone = Arrays.clone(bArr);
                int i6 = this.L * 4;
                i = 0;
                while (i < i6) {
                    BigInteger bigIntegerAdd = ZERO;
                    int i7 = 0;
                    int i8 = 0;
                    while (i7 <= i3) {
                        inc(bArrClone);
                        hash(digest, bArrClone, bArr2);
                        BigInteger bigInteger3 = new BigInteger(i4, bArr2);
                        if (i7 == i3) {
                            bigInteger3 = bigInteger3.mod(ONE.shiftLeft(i5));
                        }
                        bigIntegerAdd = bigIntegerAdd.add(bigInteger3.shiftLeft(i8));
                        i7++;
                        i8 += digestSize;
                        i4 = 1;
                    }
                    BigInteger bigInteger4 = ONE;
                    BigInteger bigIntegerAdd2 = bigIntegerAdd.add(bigInteger4.shiftLeft(this.L - 1));
                    bigIntegerSubtract2 = bigIntegerAdd2.subtract(bigIntegerAdd2.mod(bigIntegerSubtract.shiftLeft(1)).subtract(bigInteger4));
                    if (bigIntegerSubtract2.bitLength() == this.L && bigIntegerSubtract2.isProbablePrime(this.certainty)) {
                        break loop0;
                    }
                    i++;
                    i4 = 1;
                }
            }
        }
        int i9 = this.usageIndex;
        return (i9 < 0 || (bigIntegerCalculateGenerator_FIPS186_3_Verifiable = calculateGenerator_FIPS186_3_Verifiable(digest, bigIntegerSubtract2, bigIntegerSubtract, bArr, i9)) == null) ? new DSAParameters(bigIntegerSubtract2, bigIntegerSubtract, calculateGenerator_FIPS186_3_Unverifiable(bigIntegerSubtract2, bigIntegerSubtract, this.random), new DSAValidationParameters(bArr, i)) : new DSAParameters(bigIntegerSubtract2, bigIntegerSubtract, bigIntegerCalculateGenerator_FIPS186_3_Verifiable, new DSAValidationParameters(bArr, i, this.usageIndex));
    }

    private static int getDefaultN(int i) {
        return i > 1024 ? 256 : 160;
    }

    private static void hash(Digest digest, byte[] bArr, byte[] bArr2) {
        digest.update(bArr, 0, bArr.length);
        digest.doFinal(bArr2, 0);
    }

    private static void inc(byte[] bArr) {
        for (int length = bArr.length - 1; length >= 0; length--) {
            byte b = (byte) ((bArr[length] + 1) & 255);
            bArr[length] = b;
            if (b != 0) {
                return;
            }
        }
    }

    public DSAParameters generateParameters() {
        return this.use186_3 ? generateParameters_FIPS186_3() : generateParameters_FIPS186_2();
    }

    public void init(int i, int i2, SecureRandom secureRandom) {
        this.use186_3 = false;
        this.L = i;
        this.N = getDefaultN(i);
        this.certainty = i2;
        this.random = secureRandom;
    }

    public void init(DSAParameterGenerationParameters dSAParameterGenerationParameters) {
        int i;
        this.use186_3 = true;
        this.L = dSAParameterGenerationParameters.getL();
        this.N = dSAParameterGenerationParameters.getN();
        this.certainty = dSAParameterGenerationParameters.getCertainty();
        this.random = dSAParameterGenerationParameters.getRandom();
        this.usageIndex = dSAParameterGenerationParameters.getUsageIndex();
        int i2 = this.L;
        if (i2 < 1024 || i2 > 3072 || i2 % 1024 != 0) {
            throw new IllegalArgumentException("L values must be between 1024 and 3072 and a multiple of 1024");
        }
        if (i2 == 1024 && this.N != 160) {
            throw new IllegalArgumentException("N must be 160 for L = 1024");
        }
        if (i2 == 2048 && (i = this.N) != 224 && i != 256) {
            throw new IllegalArgumentException("N must be 224 or 256 for L = 2048");
        }
        if (i2 == 3072 && this.N != 256) {
            throw new IllegalArgumentException("N must be 256 for L = 3072");
        }
        if (this.digest.getDigestSize() * 8 < this.N) {
            throw new IllegalStateException("Digest output size too small for value of N");
        }
    }
}
