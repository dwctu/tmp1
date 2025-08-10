package org.bouncycastle.crypto.modes.gcm;

import org.bouncycastle.crypto.util.Pack;
import org.bouncycastle.util.Arrays;

/* loaded from: classes5.dex */
public abstract class GCMUtil {
    private static final int E1 = -520093696;
    private static final byte E1B = -31;
    private static final long E1L = 63331869759897600L;
    private static final int[] LOOKUP = generateLookup();

    public static void asBytes(int[] iArr, byte[] bArr) {
        Pack.intToBigEndian(iArr, bArr, 0);
    }

    public static void asBytes(long[] jArr, byte[] bArr) {
        Pack.longToBigEndian(jArr, bArr, 0);
    }

    public static byte[] asBytes(int[] iArr) {
        byte[] bArr = new byte[16];
        Pack.intToBigEndian(iArr, bArr, 0);
        return bArr;
    }

    public static byte[] asBytes(long[] jArr) {
        byte[] bArr = new byte[16];
        Pack.longToBigEndian(jArr, bArr, 0);
        return bArr;
    }

    public static void asInts(byte[] bArr, int[] iArr) {
        Pack.bigEndianToInt(bArr, 0, iArr);
    }

    public static int[] asInts(byte[] bArr) {
        int[] iArr = new int[4];
        Pack.bigEndianToInt(bArr, 0, iArr);
        return iArr;
    }

    public static void asLongs(byte[] bArr, long[] jArr) {
        Pack.bigEndianToLong(bArr, 0, jArr);
    }

    public static long[] asLongs(byte[] bArr) {
        long[] jArr = new long[2];
        Pack.bigEndianToLong(bArr, 0, jArr);
        return jArr;
    }

    private static int[] generateLookup() {
        int[] iArr = new int[256];
        for (int i = 0; i < 256; i++) {
            int i2 = 0;
            for (int i3 = 7; i3 >= 0; i3--) {
                if (((1 << i3) & i) != 0) {
                    i2 ^= E1 >>> (7 - i3);
                }
            }
            iArr[i] = i2;
        }
        return iArr;
    }

    public static void multiply(byte[] bArr, byte[] bArr2) {
        byte[] bArrClone = Arrays.clone(bArr);
        byte[] bArr3 = new byte[16];
        for (int i = 0; i < 16; i++) {
            byte b = bArr2[i];
            for (int i2 = 7; i2 >= 0; i2--) {
                if (((1 << i2) & b) != 0) {
                    xor(bArr3, bArrClone);
                }
                if (shiftRight(bArrClone) != 0) {
                    bArrClone[0] = (byte) (bArrClone[0] ^ (-31));
                }
            }
        }
        System.arraycopy(bArr3, 0, bArr, 0, 16);
    }

    public static void multiply(int[] iArr, int[] iArr2) {
        int[] iArrClone = Arrays.clone(iArr);
        int[] iArr3 = new int[4];
        for (int i = 0; i < 4; i++) {
            int i2 = iArr2[i];
            for (int i3 = 31; i3 >= 0; i3--) {
                if (((1 << i3) & i2) != 0) {
                    xor(iArr3, iArrClone);
                }
                if (shiftRight(iArrClone) != 0) {
                    iArrClone[0] = iArrClone[0] ^ E1;
                }
            }
        }
        System.arraycopy(iArr3, 0, iArr, 0, 4);
    }

    public static void multiply(long[] jArr, long[] jArr2) {
        long[] jArr3 = {jArr[0], jArr[1]};
        long[] jArr4 = new long[2];
        for (int i = 0; i < 2; i++) {
            long j = jArr2[i];
            for (int i2 = 63; i2 >= 0; i2--) {
                if (((1 << i2) & j) != 0) {
                    xor(jArr4, jArr3);
                }
                if (shiftRight(jArr3) != 0) {
                    jArr3[0] = jArr3[0] ^ E1L;
                }
            }
        }
        jArr[0] = jArr4[0];
        jArr[1] = jArr4[1];
    }

    public static void multiplyP(int[] iArr) {
        if (shiftRight(iArr) != 0) {
            iArr[0] = iArr[0] ^ E1;
        }
    }

    public static void multiplyP(int[] iArr, int[] iArr2) {
        if (shiftRight(iArr, iArr2) != 0) {
            iArr2[0] = iArr2[0] ^ E1;
        }
    }

    public static void multiplyP8(int[] iArr) {
        int iShiftRightN = shiftRightN(iArr, 8);
        iArr[0] = LOOKUP[iShiftRightN >>> 24] ^ iArr[0];
    }

    public static void multiplyP8(int[] iArr, int[] iArr2) {
        int iShiftRightN = shiftRightN(iArr, 8, iArr2);
        iArr2[0] = LOOKUP[iShiftRightN >>> 24] ^ iArr2[0];
    }

    public static byte[] oneAsBytes() {
        byte[] bArr = new byte[16];
        bArr[0] = Byte.MIN_VALUE;
        return bArr;
    }

    public static int[] oneAsInts() {
        int[] iArr = new int[4];
        iArr[0] = Integer.MIN_VALUE;
        return iArr;
    }

    public static long[] oneAsLongs() {
        return new long[]{Long.MIN_VALUE, 0};
    }

    public static byte shiftRight(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = bArr[i] & 255;
            int i4 = i + 1;
            bArr[i] = (byte) (i2 | (i3 >>> 1));
            int i5 = (i3 & 1) << 7;
            int i6 = bArr[i4] & 255;
            int i7 = i4 + 1;
            bArr[i4] = (byte) (i5 | (i6 >>> 1));
            int i8 = (i6 & 1) << 7;
            int i9 = bArr[i7] & 255;
            int i10 = i7 + 1;
            bArr[i7] = (byte) (i8 | (i9 >>> 1));
            int i11 = (i9 & 1) << 7;
            int i12 = bArr[i10] & 255;
            int i13 = i10 + 1;
            bArr[i10] = (byte) (i11 | (i12 >>> 1));
            i2 = (i12 & 1) << 7;
            if (i13 >= 16) {
                return (byte) i2;
            }
            i = i13;
        }
    }

    public static byte shiftRight(byte[] bArr, byte[] bArr2) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = bArr[i] & 255;
            int i4 = i + 1;
            bArr2[i] = (byte) (i2 | (i3 >>> 1));
            int i5 = (i3 & 1) << 7;
            int i6 = bArr[i4] & 255;
            int i7 = i4 + 1;
            bArr2[i4] = (byte) (i5 | (i6 >>> 1));
            int i8 = (i6 & 1) << 7;
            int i9 = bArr[i7] & 255;
            int i10 = i7 + 1;
            bArr2[i7] = (byte) (i8 | (i9 >>> 1));
            int i11 = (i9 & 1) << 7;
            int i12 = bArr[i10] & 255;
            int i13 = i10 + 1;
            bArr2[i10] = (byte) (i11 | (i12 >>> 1));
            i2 = (i12 & 1) << 7;
            if (i13 >= 16) {
                return (byte) i2;
            }
            i = i13;
        }
    }

    public static int shiftRight(int[] iArr) {
        int i = iArr[0];
        iArr[0] = i >>> 1;
        int i2 = iArr[1];
        iArr[1] = (i << 31) | (i2 >>> 1);
        int i3 = i2 << 31;
        int i4 = iArr[2];
        iArr[2] = i3 | (i4 >>> 1);
        int i5 = i4 << 31;
        int i6 = iArr[3];
        iArr[3] = i5 | (i6 >>> 1);
        return i6 << 31;
    }

    public static int shiftRight(int[] iArr, int[] iArr2) {
        int i = iArr[0];
        iArr2[0] = i >>> 1;
        int i2 = iArr[1];
        iArr2[1] = (i << 31) | (i2 >>> 1);
        int i3 = i2 << 31;
        int i4 = iArr[2];
        iArr2[2] = i3 | (i4 >>> 1);
        int i5 = iArr[3];
        iArr2[3] = (i4 << 31) | (i5 >>> 1);
        return i5 << 31;
    }

    public static long shiftRight(long[] jArr) {
        long j = jArr[0];
        jArr[0] = j >>> 1;
        long j2 = jArr[1];
        jArr[1] = (j << 63) | (j2 >>> 1);
        return j2 << 63;
    }

    public static long shiftRight(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        jArr2[0] = j >>> 1;
        long j2 = jArr[1];
        jArr2[1] = (j << 63) | (j2 >>> 1);
        return j2 << 63;
    }

    public static int shiftRightN(int[] iArr, int i) {
        int i2 = iArr[0];
        int i3 = 32 - i;
        iArr[0] = i2 >>> i;
        int i4 = iArr[1];
        iArr[1] = (i2 << i3) | (i4 >>> i);
        int i5 = i4 << i3;
        int i6 = iArr[2];
        iArr[2] = i5 | (i6 >>> i);
        int i7 = i6 << i3;
        int i8 = iArr[3];
        iArr[3] = (i8 >>> i) | i7;
        return i8 << i3;
    }

    public static int shiftRightN(int[] iArr, int i, int[] iArr2) {
        int i2 = iArr[0];
        int i3 = 32 - i;
        iArr2[0] = i2 >>> i;
        int i4 = iArr[1];
        iArr2[1] = (i2 << i3) | (i4 >>> i);
        int i5 = i4 << i3;
        int i6 = iArr[2];
        iArr2[2] = i5 | (i6 >>> i);
        int i7 = iArr[3];
        iArr2[3] = (i7 >>> i) | (i6 << i3);
        return i7 << i3;
    }

    public static void xor(byte[] bArr, byte[] bArr2) {
        int i = 0;
        do {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
            int i2 = i + 1;
            bArr[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
            int i3 = i2 + 1;
            bArr[i3] = (byte) (bArr[i3] ^ bArr2[i3]);
            int i4 = i3 + 1;
            bArr[i4] = (byte) (bArr[i4] ^ bArr2[i4]);
            i = i4 + 1;
        } while (i < 16);
    }

    public static void xor(byte[] bArr, byte[] bArr2, int i, int i2) {
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                return;
            }
            bArr[i3] = (byte) (bArr[i3] ^ bArr2[i + i3]);
            i2 = i3;
        }
    }

    public static void xor(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int i = 0;
        do {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
            int i2 = i + 1;
            bArr3[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
            int i3 = i2 + 1;
            bArr3[i3] = (byte) (bArr[i3] ^ bArr2[i3]);
            int i4 = i3 + 1;
            bArr3[i4] = (byte) (bArr[i4] ^ bArr2[i4]);
            i = i4 + 1;
        } while (i < 16);
    }

    public static void xor(int[] iArr, int[] iArr2) {
        iArr[0] = iArr[0] ^ iArr2[0];
        iArr[1] = iArr[1] ^ iArr2[1];
        iArr[2] = iArr[2] ^ iArr2[2];
        iArr[3] = iArr2[3] ^ iArr[3];
    }

    public static void xor(int[] iArr, int[] iArr2, int[] iArr3) {
        iArr3[0] = iArr[0] ^ iArr2[0];
        iArr3[1] = iArr[1] ^ iArr2[1];
        iArr3[2] = iArr[2] ^ iArr2[2];
        iArr3[3] = iArr[3] ^ iArr2[3];
    }

    public static void xor(long[] jArr, long[] jArr2) {
        jArr[0] = jArr[0] ^ jArr2[0];
        jArr[1] = jArr[1] ^ jArr2[1];
    }

    public static void xor(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr2[1] ^ jArr[1];
    }
}
