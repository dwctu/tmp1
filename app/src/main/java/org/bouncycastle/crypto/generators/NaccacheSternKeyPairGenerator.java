package org.bouncycastle.crypto.generators;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.fastjson.asm.Opcodes;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import java.io.PrintStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Vector;
import no.nordicsemi.android.dfu.DfuBaseService;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.NaccacheSternKeyGenerationParameters;
import org.bouncycastle.crypto.params.NaccacheSternKeyParameters;
import org.bouncycastle.crypto.params.NaccacheSternPrivateKeyParameters;
import org.bouncycastle.crypto.tls.CipherSuite;

/* loaded from: classes5.dex */
public class NaccacheSternKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private NaccacheSternKeyGenerationParameters param;
    private static int[] smallPrimes = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA, CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA, 149, 151, 157, 163, 167, CipherSuite.TLS_RSA_PSK_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA384, 181, 191, 193, DownloaderService.STATUS_QUEUED_FOR_WIFI, Opcodes.IFNONNULL, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, DfuBaseService.NOTIFICATION_ID, 293, 307, 311, 313, TypedValues.AttributesType.TYPE_EASING, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, TypedValues.CycleType.TYPE_WAVE_SHAPE, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, DownloaderService.STATUS_FILE_DELIVERED_INCORRECTLY, 491, 499, 503, 509, 521, 523, 541, 547, 557};
    private static final BigInteger ONE = BigInteger.valueOf(1);

    private static Vector findFirstPrimes(int i) {
        Vector vector = new Vector(i);
        for (int i2 = 0; i2 != i; i2++) {
            vector.addElement(BigInteger.valueOf(smallPrimes[i2]));
        }
        return vector;
    }

    private static BigInteger generatePrime(int i, int i2, SecureRandom secureRandom) {
        BigInteger bigInteger = new BigInteger(i, i2, secureRandom);
        while (bigInteger.bitLength() != i) {
            bigInteger = new BigInteger(i, i2, secureRandom);
        }
        return bigInteger;
    }

    private static int getInt(SecureRandom secureRandom, int i) {
        int iNextInt;
        int i2;
        if (((-i) & i) == i) {
            return (int) ((i * (secureRandom.nextInt() & Integer.MAX_VALUE)) >> 31);
        }
        do {
            iNextInt = secureRandom.nextInt() & Integer.MAX_VALUE;
            i2 = iNextInt % i;
        } while ((iNextInt - i2) + (i - 1) < 0);
        return i2;
    }

    private static Vector permuteList(Vector vector, SecureRandom secureRandom) {
        Vector vector2 = new Vector();
        Vector vector3 = new Vector();
        for (int i = 0; i < vector.size(); i++) {
            vector3.addElement(vector.elementAt(i));
        }
        vector2.addElement(vector3.elementAt(0));
        while (true) {
            vector3.removeElementAt(0);
            if (vector3.size() == 0) {
                return vector2;
            }
            vector2.insertElementAt(vector3.elementAt(0), getInt(secureRandom, vector2.size() + 1));
        }
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        long j;
        BigInteger bigIntegerGeneratePrime;
        BigInteger bigIntegerAdd;
        BigInteger bigIntegerGeneratePrime2;
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigIntegerAdd2;
        BigInteger bigInteger3;
        BigInteger bigInteger4;
        BigInteger bigInteger5;
        BigInteger bigInteger6;
        BigInteger bigIntegerMod;
        boolean z;
        BigInteger bigInteger7;
        BigInteger bigInteger8;
        int i;
        PrintStream printStream;
        StringBuilder sb;
        String str;
        long j2;
        BigInteger bigInteger9;
        int i2;
        int strength = this.param.getStrength();
        SecureRandom random = this.param.getRandom();
        int certainty = this.param.getCertainty();
        boolean zIsDebug = this.param.isDebug();
        if (zIsDebug) {
            System.out.println("Fetching first " + this.param.getCntSmallPrimes() + " primes.");
        }
        Vector vectorPermuteList = permuteList(findFirstPrimes(this.param.getCntSmallPrimes()), random);
        BigInteger bigIntegerMultiply = ONE;
        BigInteger bigIntegerMultiply2 = bigIntegerMultiply;
        for (int i3 = 0; i3 < vectorPermuteList.size() / 2; i3++) {
            bigIntegerMultiply2 = bigIntegerMultiply2.multiply((BigInteger) vectorPermuteList.elementAt(i3));
        }
        for (int size = vectorPermuteList.size() / 2; size < vectorPermuteList.size(); size++) {
            bigIntegerMultiply = bigIntegerMultiply.multiply((BigInteger) vectorPermuteList.elementAt(size));
        }
        BigInteger bigIntegerMultiply3 = bigIntegerMultiply2.multiply(bigIntegerMultiply);
        int iBitLength = (((strength - bigIntegerMultiply3.bitLength()) - 48) / 2) + 1;
        BigInteger bigIntegerGeneratePrime3 = generatePrime(iBitLength, certainty, random);
        BigInteger bigIntegerGeneratePrime4 = generatePrime(iBitLength, certainty, random);
        if (zIsDebug) {
            System.out.println("generating p and q");
        }
        BigInteger bigIntegerShiftLeft = bigIntegerGeneratePrime3.multiply(bigIntegerMultiply2).shiftLeft(1);
        BigInteger bigIntegerShiftLeft2 = bigIntegerGeneratePrime4.multiply(bigIntegerMultiply).shiftLeft(1);
        long j3 = 0;
        while (true) {
            j = j3 + 1;
            bigIntegerGeneratePrime = generatePrime(24, certainty, random);
            bigIntegerAdd = bigIntegerGeneratePrime.multiply(bigIntegerShiftLeft).add(ONE);
            if (bigIntegerAdd.isProbablePrime(certainty)) {
                while (true) {
                    do {
                        bigIntegerGeneratePrime2 = generatePrime(24, certainty, random);
                    } while (bigIntegerGeneratePrime.equals(bigIntegerGeneratePrime2));
                    BigInteger bigIntegerMultiply4 = bigIntegerGeneratePrime2.multiply(bigIntegerShiftLeft2);
                    bigInteger = bigIntegerShiftLeft2;
                    bigInteger2 = ONE;
                    bigIntegerAdd2 = bigIntegerMultiply4.add(bigInteger2);
                    if (bigIntegerAdd2.isProbablePrime(certainty)) {
                        break;
                    }
                    bigIntegerShiftLeft2 = bigInteger;
                }
                bigInteger3 = bigIntegerShiftLeft;
                if (!bigIntegerMultiply3.gcd(bigIntegerGeneratePrime.multiply(bigIntegerGeneratePrime2)).equals(bigInteger2)) {
                    continue;
                } else {
                    if (bigIntegerAdd.multiply(bigIntegerAdd2).bitLength() >= strength) {
                        break;
                    }
                    if (zIsDebug) {
                        System.out.println("key size too small. Should be " + strength + " but is actually " + bigIntegerAdd.multiply(bigIntegerAdd2).bitLength());
                    }
                }
            } else {
                bigInteger = bigIntegerShiftLeft2;
                bigInteger3 = bigIntegerShiftLeft;
            }
            j3 = j;
            bigIntegerShiftLeft2 = bigInteger;
            bigIntegerShiftLeft = bigInteger3;
        }
        BigInteger bigInteger10 = bigIntegerGeneratePrime4;
        if (zIsDebug) {
            bigInteger4 = bigIntegerGeneratePrime3;
            System.out.println("needed " + j + " tries to generate p and q.");
        } else {
            bigInteger4 = bigIntegerGeneratePrime3;
        }
        BigInteger bigIntegerMultiply5 = bigIntegerAdd.multiply(bigIntegerAdd2);
        BigInteger bigIntegerMultiply6 = bigIntegerAdd.subtract(bigInteger2).multiply(bigIntegerAdd2.subtract(bigInteger2));
        if (zIsDebug) {
            System.out.println("generating g");
        }
        long j4 = 0;
        while (true) {
            Vector vector = new Vector();
            bigInteger5 = bigIntegerAdd;
            bigInteger6 = bigIntegerAdd2;
            int i4 = 0;
            while (i4 != vectorPermuteList.size()) {
                BigInteger bigIntegerDivide = bigIntegerMultiply6.divide((BigInteger) vectorPermuteList.elementAt(i4));
                while (true) {
                    j2 = j4 + 1;
                    bigInteger9 = new BigInteger(strength, certainty, random);
                    i2 = strength;
                    if (bigInteger9.modPow(bigIntegerDivide, bigIntegerMultiply5).equals(ONE)) {
                        j4 = j2;
                        strength = i2;
                    }
                }
                vector.addElement(bigInteger9);
                i4++;
                j4 = j2;
                strength = i2;
            }
            int i5 = strength;
            bigIntegerMod = ONE;
            int i6 = 0;
            while (i6 < vectorPermuteList.size()) {
                bigIntegerMod = bigIntegerMod.multiply(((BigInteger) vector.elementAt(i6)).modPow(bigIntegerMultiply3.divide((BigInteger) vectorPermuteList.elementAt(i6)), bigIntegerMultiply5)).mod(bigIntegerMultiply5);
                i6++;
                random = random;
            }
            SecureRandom secureRandom = random;
            int i7 = 0;
            while (true) {
                if (i7 >= vectorPermuteList.size()) {
                    z = false;
                    break;
                }
                if (bigIntegerMod.modPow(bigIntegerMultiply6.divide((BigInteger) vectorPermuteList.elementAt(i7)), bigIntegerMultiply5).equals(ONE)) {
                    if (zIsDebug) {
                        System.out.println("g has order phi(n)/" + vectorPermuteList.elementAt(i7) + "\n g: " + bigIntegerMod);
                    }
                    z = true;
                } else {
                    i7++;
                }
            }
            if (z) {
                bigInteger8 = bigInteger10;
                bigInteger7 = bigInteger4;
                i = certainty;
            } else {
                BigInteger bigIntegerModPow = bigIntegerMod.modPow(bigIntegerMultiply6.divide(BigInteger.valueOf(4L)), bigIntegerMultiply5);
                BigInteger bigInteger11 = ONE;
                if (bigIntegerModPow.equals(bigInteger11)) {
                    if (zIsDebug) {
                        printStream = System.out;
                        sb = new StringBuilder();
                        str = "g has order phi(n)/4\n g:";
                        sb.append(str);
                        sb.append(bigIntegerMod);
                        printStream.println(sb.toString());
                    }
                    bigInteger8 = bigInteger10;
                    bigInteger7 = bigInteger4;
                    i = certainty;
                } else if (bigIntegerMod.modPow(bigIntegerMultiply6.divide(bigIntegerGeneratePrime), bigIntegerMultiply5).equals(bigInteger11)) {
                    if (zIsDebug) {
                        printStream = System.out;
                        sb = new StringBuilder();
                        str = "g has order phi(n)/p'\n g: ";
                        sb.append(str);
                        sb.append(bigIntegerMod);
                        printStream.println(sb.toString());
                    }
                    bigInteger8 = bigInteger10;
                    bigInteger7 = bigInteger4;
                    i = certainty;
                } else if (bigIntegerMod.modPow(bigIntegerMultiply6.divide(bigIntegerGeneratePrime2), bigIntegerMultiply5).equals(bigInteger11)) {
                    if (zIsDebug) {
                        printStream = System.out;
                        sb = new StringBuilder();
                        str = "g has order phi(n)/q'\n g: ";
                        sb.append(str);
                        sb.append(bigIntegerMod);
                        printStream.println(sb.toString());
                    }
                    bigInteger8 = bigInteger10;
                    bigInteger7 = bigInteger4;
                    i = certainty;
                } else {
                    bigInteger7 = bigInteger4;
                    if (!bigIntegerMod.modPow(bigIntegerMultiply6.divide(bigInteger7), bigIntegerMultiply5).equals(bigInteger11)) {
                        bigInteger8 = bigInteger10;
                        if (!bigIntegerMod.modPow(bigIntegerMultiply6.divide(bigInteger8), bigIntegerMultiply5).equals(bigInteger11)) {
                            break;
                        }
                        if (zIsDebug) {
                            PrintStream printStream2 = System.out;
                            StringBuilder sb2 = new StringBuilder();
                            i = certainty;
                            sb2.append("g has order phi(n)/b\n g: ");
                            sb2.append(bigIntegerMod);
                            printStream2.println(sb2.toString());
                        }
                    } else {
                        if (zIsDebug) {
                            System.out.println("g has order phi(n)/a\n g: " + bigIntegerMod);
                        }
                        bigInteger8 = bigInteger10;
                    }
                    i = certainty;
                }
            }
            bigInteger4 = bigInteger7;
            certainty = i;
            bigIntegerAdd2 = bigInteger6;
            bigIntegerAdd = bigInteger5;
            strength = i5;
            random = secureRandom;
            bigInteger10 = bigInteger8;
        }
        if (zIsDebug) {
            System.out.println("needed " + j4 + " tries to generate g");
            System.out.println();
            System.out.println("found new NaccacheStern cipher variables:");
            System.out.println("smallPrimes: " + vectorPermuteList);
            System.out.println("sigma:...... " + bigIntegerMultiply3 + " (" + bigIntegerMultiply3.bitLength() + " bits)");
            PrintStream printStream3 = System.out;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("a:.......... ");
            sb3.append(bigInteger7);
            printStream3.println(sb3.toString());
            System.out.println("b:.......... " + bigInteger8);
            System.out.println("p':......... " + bigIntegerGeneratePrime);
            System.out.println("q':......... " + bigIntegerGeneratePrime2);
            System.out.println("p:.......... " + bigInteger5);
            System.out.println("q:.......... " + bigInteger6);
            System.out.println("n:.......... " + bigIntegerMultiply5);
            System.out.println("phi(n):..... " + bigIntegerMultiply6);
            System.out.println("g:.......... " + bigIntegerMod);
            System.out.println();
        }
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new NaccacheSternKeyParameters(false, bigIntegerMod, bigIntegerMultiply5, bigIntegerMultiply3.bitLength()), (AsymmetricKeyParameter) new NaccacheSternPrivateKeyParameters(bigIntegerMod, bigIntegerMultiply5, bigIntegerMultiply3.bitLength(), vectorPermuteList, bigIntegerMultiply6));
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.param = (NaccacheSternKeyGenerationParameters) keyGenerationParameters;
    }
}
