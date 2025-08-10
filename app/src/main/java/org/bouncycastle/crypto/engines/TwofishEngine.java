package org.bouncycastle.crypto.engines;

import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import org.apache.commons.codec.net.URLCodec;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;

/* loaded from: classes5.dex */
public final class TwofishEngine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;
    private static final int GF256_FDBK = 361;
    private static final int GF256_FDBK_2 = 180;
    private static final int GF256_FDBK_4 = 90;
    private static final int INPUT_WHITEN = 0;
    private static final int MAX_KEY_BITS = 256;
    private static final int MAX_ROUNDS = 16;
    private static final int OUTPUT_WHITEN = 4;
    private static final byte[][] P = {new byte[]{-87, 103, -77, -24, 4, -3, -93, 118, -102, -110, Byte.MIN_VALUE, 120, -28, -35, -47, 56, 13, -58, 53, -104, Ascii.CAN, -9, -20, 108, 67, 117, 55, 38, -6, 19, -108, 72, -14, -48, -117, 48, -124, 84, -33, 35, Ascii.EM, 91, 61, 89, -13, -82, -94, -126, 99, 1, -125, 46, ExifInterface.MARKER_EOI, 81, -101, 124, -90, -21, -91, -66, Ascii.SYN, 12, -29, 97, -64, -116, 58, -11, 115, 44, URLCodec.ESCAPE_CHAR, 11, -69, 78, -119, 107, 83, 106, -76, -15, ExifInterface.MARKER_APP1, -26, -67, 69, -30, -12, -74, 102, -52, -107, 3, 86, -44, Ascii.FS, Ascii.RS, -41, -5, -61, -114, -75, -23, -49, -65, -70, -22, 119, 57, -81, 51, -55, 98, 113, -127, 121, 9, -83, 36, -51, -7, -40, -27, -59, -71, 77, 68, 8, -122, -25, -95, Ascii.GS, -86, -19, 6, 112, -78, -46, 65, 123, -96, 17, 49, -62, 39, -112, 32, -10, 96, -1, -106, 92, -79, -85, -98, -100, 82, Ascii.ESC, 95, -109, 10, -17, -111, -123, 73, -18, 45, 79, -113, 59, 71, -121, 109, 70, -42, 62, 105, 100, ExifInterface.START_CODE, -50, -53, 47, -4, -105, 5, 122, -84, Byte.MAX_VALUE, -43, Ascii.SUB, 75, 14, -89, 90, 40, Ascii.DC4, 63, 41, -120, 60, 76, 2, -72, -38, -80, Ascii.ETB, 85, Ascii.US, -118, 125, 87, -57, -115, 116, -73, -60, -97, 114, 126, Ascii.NAK, 34, Ascii.DC2, 88, 7, -103, 52, 110, 80, -34, 104, 101, PSSSigner.TRAILER_IMPLICIT, -37, -8, -56, -88, 43, SignedBytes.MAX_POWER_OF_TWO, -36, -2, 50, -92, -54, 16, 33, -16, -45, 93, Ascii.SI, 0, 111, -99, 54, 66, 74, 94, -63, -32}, new byte[]{117, -13, -58, -12, -37, 123, -5, -56, 74, -45, -26, 107, 69, 125, -24, 75, -42, 50, -40, -3, 55, 113, -15, ExifInterface.MARKER_APP1, 48, Ascii.SI, -8, Ascii.ESC, -121, -6, 6, 63, 94, -70, -82, 91, -118, 0, PSSSigner.TRAILER_IMPLICIT, -99, 109, -63, -79, 14, Byte.MIN_VALUE, 93, -46, -43, -96, -124, 7, Ascii.DC4, -75, -112, 44, -93, -78, 115, 76, 84, -110, 116, 54, 81, 56, -80, -67, 90, -4, 96, 98, -106, 108, 66, -9, 16, 124, 40, 39, -116, 19, -107, -100, -57, 36, 70, 59, 112, -54, -29, -123, -53, 17, -48, -109, -72, -90, -125, 32, -1, -97, 119, -61, -52, 3, 111, 8, -65, SignedBytes.MAX_POWER_OF_TWO, -25, 43, -30, 121, 12, -86, -126, 65, 58, -22, -71, -28, -102, -92, -105, 126, -38, 122, Ascii.ETB, 102, -108, -95, Ascii.GS, 61, -16, -34, -77, 11, 114, -89, Ascii.FS, -17, -47, 83, 62, -113, 51, 38, 95, -20, 118, ExifInterface.START_CODE, 73, -127, -120, -18, 33, -60, Ascii.SUB, -21, ExifInterface.MARKER_EOI, -59, 57, -103, -51, -83, 49, -117, 1, Ascii.CAN, 35, -35, Ascii.US, 78, 45, -7, 72, 79, -14, 101, -114, 120, 92, 88, Ascii.EM, -115, -27, -104, 87, 103, Byte.MAX_VALUE, 5, 100, -81, 99, -74, -2, -11, -73, 60, -91, -50, -23, 104, 68, -32, 77, 67, 105, 41, 46, -84, Ascii.NAK, 89, -88, 10, -98, 110, 71, -33, 52, 53, 106, -49, -36, 34, -55, -64, -101, -119, -44, -19, -85, Ascii.DC2, -94, 13, 82, -69, 2, 47, -87, -41, 97, Ascii.RS, -76, 80, 4, -10, -62, Ascii.SYN, URLCodec.ESCAPE_CHAR, -122, 86, 85, 9, -66, -111}};
    private static final int P_00 = 1;
    private static final int P_01 = 0;
    private static final int P_02 = 0;
    private static final int P_03 = 1;
    private static final int P_04 = 1;
    private static final int P_10 = 0;
    private static final int P_11 = 0;
    private static final int P_12 = 1;
    private static final int P_13 = 1;
    private static final int P_14 = 0;
    private static final int P_20 = 1;
    private static final int P_21 = 1;
    private static final int P_22 = 0;
    private static final int P_23 = 0;
    private static final int P_24 = 0;
    private static final int P_30 = 0;
    private static final int P_31 = 1;
    private static final int P_32 = 1;
    private static final int P_33 = 0;
    private static final int P_34 = 1;
    private static final int ROUNDS = 16;
    private static final int ROUND_SUBKEYS = 8;
    private static final int RS_GF_FDBK = 333;
    private static final int SK_BUMP = 16843009;
    private static final int SK_ROTL = 9;
    private static final int SK_STEP = 33686018;
    private static final int TOTAL_SUBKEYS = 40;
    private int[] gSBox;
    private int[] gSubKeys;
    private boolean encrypting = false;
    private int[] gMDS0 = new int[256];
    private int[] gMDS1 = new int[256];
    private int[] gMDS2 = new int[256];
    private int[] gMDS3 = new int[256];
    private int k64Cnt = 0;
    private byte[] workingKey = null;

    public TwofishEngine() {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        int[] iArr3 = new int[2];
        for (int i = 0; i < 256; i++) {
            byte[][] bArr = P;
            int i2 = bArr[0][i] & 255;
            iArr[0] = i2;
            iArr2[0] = Mx_X(i2) & 255;
            iArr3[0] = Mx_Y(i2) & 255;
            int i3 = bArr[1][i] & 255;
            iArr[1] = i3;
            iArr2[1] = Mx_X(i3) & 255;
            iArr3[1] = Mx_Y(i3) & 255;
            this.gMDS0[i] = iArr[1] | (iArr2[1] << 8) | (iArr3[1] << 16) | (iArr3[1] << 24);
            this.gMDS1[i] = iArr3[0] | (iArr3[0] << 8) | (iArr2[0] << 16) | (iArr[0] << 24);
            this.gMDS2[i] = (iArr3[1] << 24) | iArr2[1] | (iArr3[1] << 8) | (iArr[1] << 16);
            this.gMDS3[i] = iArr2[0] | (iArr[0] << 8) | (iArr3[0] << 16) | (iArr2[0] << 24);
        }
    }

    private void Bits32ToBytes(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2 + 2] = (byte) (i >> 16);
        bArr[i2 + 3] = (byte) (i >> 24);
    }

    private int BytesTo32Bits(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private int F32(int i, int[] iArr) {
        int i2;
        int i3;
        int iB0 = b0(i);
        int iB1 = b1(i);
        int iB2 = b2(i);
        int iB3 = b3(i);
        int i4 = iArr[0];
        int i5 = iArr[1];
        int i6 = iArr[2];
        int i7 = iArr[3];
        int i8 = this.k64Cnt & 3;
        if (i8 != 0) {
            if (i8 == 1) {
                int[] iArr2 = this.gMDS0;
                byte[][] bArr = P;
                i2 = (iArr2[(bArr[0][iB0] & 255) ^ b0(i4)] ^ this.gMDS1[(bArr[0][iB1] & 255) ^ b1(i4)]) ^ this.gMDS2[(bArr[1][iB2] & 255) ^ b2(i4)];
                i3 = this.gMDS3[(bArr[1][iB3] & 255) ^ b3(i4)];
                return i2 ^ i3;
            }
            if (i8 != 2) {
                if (i8 != 3) {
                    return 0;
                }
            }
            int[] iArr3 = this.gMDS0;
            byte[][] bArr2 = P;
            i2 = (iArr3[(bArr2[0][(bArr2[0][iB0] & 255) ^ b0(i5)] & 255) ^ b0(i4)] ^ this.gMDS1[(bArr2[0][(bArr2[1][iB1] & 255) ^ b1(i5)] & 255) ^ b1(i4)]) ^ this.gMDS2[(bArr2[1][(bArr2[0][iB2] & 255) ^ b2(i5)] & 255) ^ b2(i4)];
            i3 = this.gMDS3[(bArr2[1][(bArr2[1][iB3] & 255) ^ b3(i5)] & 255) ^ b3(i4)];
            return i2 ^ i3;
        }
        byte[][] bArr3 = P;
        iB0 = (bArr3[1][iB0] & 255) ^ b0(i7);
        iB1 = (bArr3[0][iB1] & 255) ^ b1(i7);
        iB2 = (bArr3[0][iB2] & 255) ^ b2(i7);
        iB3 = (bArr3[1][iB3] & 255) ^ b3(i7);
        byte[][] bArr4 = P;
        iB0 = (bArr4[1][iB0] & 255) ^ b0(i6);
        iB1 = (bArr4[1][iB1] & 255) ^ b1(i6);
        iB2 = (bArr4[0][iB2] & 255) ^ b2(i6);
        iB3 = (bArr4[0][iB3] & 255) ^ b3(i6);
        int[] iArr32 = this.gMDS0;
        byte[][] bArr22 = P;
        i2 = (iArr32[(bArr22[0][(bArr22[0][iB0] & 255) ^ b0(i5)] & 255) ^ b0(i4)] ^ this.gMDS1[(bArr22[0][(bArr22[1][iB1] & 255) ^ b1(i5)] & 255) ^ b1(i4)]) ^ this.gMDS2[(bArr22[1][(bArr22[0][iB2] & 255) ^ b2(i5)] & 255) ^ b2(i4)];
        i3 = this.gMDS3[(bArr22[1][(bArr22[1][iB3] & 255) ^ b3(i5)] & 255) ^ b3(i4)];
        return i2 ^ i3;
    }

    private int Fe32_0(int i) {
        int[] iArr = this.gSBox;
        return iArr[(((i >>> 24) & 255) * 2) + InputDeviceCompat.SOURCE_DPAD] ^ ((iArr[((i & 255) * 2) + 0] ^ iArr[(((i >>> 8) & 255) * 2) + 1]) ^ iArr[(((i >>> 16) & 255) * 2) + 512]);
    }

    private int Fe32_3(int i) {
        int[] iArr = this.gSBox;
        return iArr[(((i >>> 16) & 255) * 2) + InputDeviceCompat.SOURCE_DPAD] ^ ((iArr[(((i >>> 24) & 255) * 2) + 0] ^ iArr[((i & 255) * 2) + 1]) ^ iArr[(((i >>> 8) & 255) * 2) + 512]);
    }

    private int LFSR1(int i) {
        return ((i & 1) != 0 ? 180 : 0) ^ (i >> 1);
    }

    private int LFSR2(int i) {
        return ((i >> 2) ^ ((i & 2) != 0 ? 180 : 0)) ^ ((i & 1) != 0 ? 90 : 0);
    }

    private int Mx_X(int i) {
        return i ^ LFSR2(i);
    }

    private int Mx_Y(int i) {
        return LFSR2(i) ^ (LFSR1(i) ^ i);
    }

    private int RS_MDS_Encode(int i, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            i2 = RS_rem(i2);
        }
        int iRS_rem = i ^ i2;
        for (int i4 = 0; i4 < 4; i4++) {
            iRS_rem = RS_rem(iRS_rem);
        }
        return iRS_rem;
    }

    private int RS_rem(int i) {
        int i2 = (i >>> 24) & 255;
        int i3 = ((i2 << 1) ^ ((i2 & 128) != 0 ? RS_GF_FDBK : 0)) & 255;
        int i4 = ((i2 >>> 1) ^ ((i2 & 1) != 0 ? 166 : 0)) ^ i3;
        return ((((i << 8) ^ (i4 << 24)) ^ (i3 << 16)) ^ (i4 << 8)) ^ i2;
    }

    private int b0(int i) {
        return i & 255;
    }

    private int b1(int i) {
        return (i >>> 8) & 255;
    }

    private int b2(int i) {
        return (i >>> 16) & 255;
    }

    private int b3(int i) {
        return (i >>> 24) & 255;
    }

    private void decryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int iBytesTo32Bits = BytesTo32Bits(bArr, i) ^ this.gSubKeys[4];
        int iBytesTo32Bits2 = BytesTo32Bits(bArr, i + 4) ^ this.gSubKeys[5];
        int iBytesTo32Bits3 = BytesTo32Bits(bArr, i + 8) ^ this.gSubKeys[6];
        int iBytesTo32Bits4 = BytesTo32Bits(bArr, i + 12) ^ this.gSubKeys[7];
        int i3 = 39;
        for (int i4 = 0; i4 < 16; i4 += 2) {
            int iFe32_0 = Fe32_0(iBytesTo32Bits);
            int iFe32_3 = Fe32_3(iBytesTo32Bits2);
            int[] iArr = this.gSubKeys;
            int i5 = i3 - 1;
            int i6 = iBytesTo32Bits4 ^ (((iFe32_3 * 2) + iFe32_0) + iArr[i3]);
            int i7 = i5 - 1;
            iBytesTo32Bits3 = ((iBytesTo32Bits3 >>> 31) | (iBytesTo32Bits3 << 1)) ^ ((iFe32_0 + iFe32_3) + iArr[i5]);
            iBytesTo32Bits4 = (i6 << 31) | (i6 >>> 1);
            int iFe32_02 = Fe32_0(iBytesTo32Bits3);
            int iFe32_32 = Fe32_3(iBytesTo32Bits4);
            int[] iArr2 = this.gSubKeys;
            int i8 = i7 - 1;
            int i9 = iBytesTo32Bits2 ^ (((iFe32_32 * 2) + iFe32_02) + iArr2[i7]);
            i3 = i8 - 1;
            iBytesTo32Bits = ((iBytesTo32Bits >>> 31) | (iBytesTo32Bits << 1)) ^ ((iFe32_02 + iFe32_32) + iArr2[i8]);
            iBytesTo32Bits2 = (i9 << 31) | (i9 >>> 1);
        }
        Bits32ToBytes(this.gSubKeys[0] ^ iBytesTo32Bits3, bArr2, i2);
        Bits32ToBytes(iBytesTo32Bits4 ^ this.gSubKeys[1], bArr2, i2 + 4);
        Bits32ToBytes(this.gSubKeys[2] ^ iBytesTo32Bits, bArr2, i2 + 8);
        Bits32ToBytes(this.gSubKeys[3] ^ iBytesTo32Bits2, bArr2, i2 + 12);
    }

    private void encryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = 0;
        int iBytesTo32Bits = BytesTo32Bits(bArr, i) ^ this.gSubKeys[0];
        int iBytesTo32Bits2 = BytesTo32Bits(bArr, i + 4) ^ this.gSubKeys[1];
        int iBytesTo32Bits3 = BytesTo32Bits(bArr, i + 8) ^ this.gSubKeys[2];
        int iBytesTo32Bits4 = BytesTo32Bits(bArr, i + 12) ^ this.gSubKeys[3];
        int i4 = 8;
        while (i3 < 16) {
            int iFe32_0 = Fe32_0(iBytesTo32Bits);
            int iFe32_3 = Fe32_3(iBytesTo32Bits2);
            int[] iArr = this.gSubKeys;
            int i5 = i4 + 1;
            int i6 = iBytesTo32Bits3 ^ ((iFe32_0 + iFe32_3) + iArr[i4]);
            iBytesTo32Bits3 = (i6 >>> 1) | (i6 << 31);
            int i7 = (iBytesTo32Bits4 >>> 31) | (iBytesTo32Bits4 << 1);
            int i8 = i5 + 1;
            iBytesTo32Bits4 = i7 ^ ((iFe32_0 + (iFe32_3 * 2)) + iArr[i5]);
            int iFe32_02 = Fe32_0(iBytesTo32Bits3);
            int iFe32_32 = Fe32_3(iBytesTo32Bits4);
            int[] iArr2 = this.gSubKeys;
            int i9 = i8 + 1;
            int i10 = iBytesTo32Bits ^ ((iFe32_02 + iFe32_32) + iArr2[i8]);
            iBytesTo32Bits = (i10 >>> 1) | (i10 << 31);
            i3 += 2;
            iBytesTo32Bits2 = ((iBytesTo32Bits2 << 1) | (iBytesTo32Bits2 >>> 31)) ^ ((iFe32_02 + (iFe32_32 * 2)) + iArr2[i9]);
            i4 = i9 + 1;
        }
        Bits32ToBytes(this.gSubKeys[4] ^ iBytesTo32Bits3, bArr2, i2);
        Bits32ToBytes(iBytesTo32Bits4 ^ this.gSubKeys[5], bArr2, i2 + 4);
        Bits32ToBytes(this.gSubKeys[6] ^ iBytesTo32Bits, bArr2, i2 + 8);
        Bits32ToBytes(this.gSubKeys[7] ^ iBytesTo32Bits2, bArr2, i2 + 12);
    }

    private void setKey(byte[] bArr) {
        int iB0;
        int iB1;
        int iB2;
        int iB3;
        int iB22;
        int iB12;
        int iB02;
        int iB32;
        int[] iArr = new int[4];
        int[] iArr2 = new int[4];
        int[] iArr3 = new int[4];
        this.gSubKeys = new int[40];
        int i = this.k64Cnt;
        if (i < 1) {
            throw new IllegalArgumentException("Key size less than 64 bits");
        }
        if (i > 4) {
            throw new IllegalArgumentException("Key size larger than 256 bits");
        }
        for (int i2 = 0; i2 < this.k64Cnt; i2++) {
            int i3 = i2 * 8;
            iArr[i2] = BytesTo32Bits(bArr, i3);
            iArr2[i2] = BytesTo32Bits(bArr, i3 + 4);
            iArr3[(this.k64Cnt - 1) - i2] = RS_MDS_Encode(iArr[i2], iArr2[i2]);
        }
        for (int i4 = 0; i4 < 20; i4++) {
            int i5 = SK_STEP * i4;
            int iF32 = F32(i5, iArr);
            int iF322 = F32(i5 + 16843009, iArr2);
            int i6 = (iF322 >>> 24) | (iF322 << 8);
            int i7 = iF32 + i6;
            int[] iArr4 = this.gSubKeys;
            int i8 = i4 * 2;
            iArr4[i8] = i7;
            int i9 = i7 + i6;
            iArr4[i8 + 1] = (i9 << 9) | (i9 >>> 23);
        }
        int i10 = iArr3[0];
        int i11 = iArr3[1];
        int i12 = 2;
        int i13 = iArr3[2];
        int i14 = iArr3[3];
        this.gSBox = new int[1024];
        int i15 = 0;
        while (i15 < 256) {
            int i16 = this.k64Cnt & 3;
            if (i16 != 0) {
                if (i16 == 1) {
                    int[] iArr5 = this.gSBox;
                    int i17 = i15 * 2;
                    int[] iArr6 = this.gMDS0;
                    byte[][] bArr2 = P;
                    iArr5[i17] = iArr6[(bArr2[0][i15] & 255) ^ b0(i10)];
                    this.gSBox[i17 + 1] = this.gMDS1[(bArr2[0][i15] & 255) ^ b1(i10)];
                    this.gSBox[i17 + 512] = this.gMDS2[(bArr2[1][i15] & 255) ^ b2(i10)];
                    this.gSBox[i17 + InputDeviceCompat.SOURCE_DPAD] = this.gMDS3[(bArr2[1][i15] & 255) ^ b3(i10)];
                } else if (i16 == i12) {
                    iB32 = i15;
                    iB02 = iB32;
                    iB12 = iB02;
                    iB22 = iB12;
                    int[] iArr7 = this.gSBox;
                    int i18 = i15 * 2;
                    int[] iArr8 = this.gMDS0;
                    byte[][] bArr3 = P;
                    iArr7[i18] = iArr8[(bArr3[0][(bArr3[0][iB02] & 255) ^ b0(i11)] & 255) ^ b0(i10)];
                    this.gSBox[i18 + 1] = this.gMDS1[(bArr3[0][(bArr3[1][iB12] & 255) ^ b1(i11)] & 255) ^ b1(i10)];
                    this.gSBox[i18 + 512] = this.gMDS2[(bArr3[1][(bArr3[0][iB22] & 255) ^ b2(i11)] & 255) ^ b2(i10)];
                    this.gSBox[i18 + InputDeviceCompat.SOURCE_DPAD] = this.gMDS3[(bArr3[1][(bArr3[1][iB32] & 255) ^ b3(i11)] & 255) ^ b3(i10)];
                } else if (i16 == 3) {
                    iB3 = i15;
                    iB0 = iB3;
                    iB1 = iB0;
                    iB2 = iB1;
                }
                i15++;
                i12 = 2;
            } else {
                byte[][] bArr4 = P;
                iB0 = (bArr4[1][i15] & 255) ^ b0(i14);
                iB1 = (bArr4[0][i15] & 255) ^ b1(i14);
                iB2 = (bArr4[0][i15] & 255) ^ b2(i14);
                iB3 = (bArr4[1][i15] & 255) ^ b3(i14);
            }
            byte[][] bArr5 = P;
            iB02 = (bArr5[1][iB0] & 255) ^ b0(i13);
            iB12 = (bArr5[1][iB1] & 255) ^ b1(i13);
            iB22 = (bArr5[0][iB2] & 255) ^ b2(i13);
            iB32 = (bArr5[0][iB3] & 255) ^ b3(i13);
            int[] iArr72 = this.gSBox;
            int i182 = i15 * 2;
            int[] iArr82 = this.gMDS0;
            byte[][] bArr32 = P;
            iArr72[i182] = iArr82[(bArr32[0][(bArr32[0][iB02] & 255) ^ b0(i11)] & 255) ^ b0(i10)];
            this.gSBox[i182 + 1] = this.gMDS1[(bArr32[0][(bArr32[1][iB12] & 255) ^ b1(i11)] & 255) ^ b1(i10)];
            this.gSBox[i182 + 512] = this.gMDS2[(bArr32[1][(bArr32[0][iB22] & 255) ^ b2(i11)] & 255) ^ b2(i10)];
            this.gSBox[i182 + InputDeviceCompat.SOURCE_DPAD] = this.gMDS3[(bArr32[1][(bArr32[1][iB32] & 255) ^ b3(i11)] & 255) ^ b3(i10)];
            i15++;
            i12 = 2;
        }
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Twofish";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("invalid parameter passed to Twofish init - " + cipherParameters.getClass().getName());
        }
        this.encrypting = z;
        byte[] key = ((KeyParameter) cipherParameters).getKey();
        this.workingKey = key;
        this.k64Cnt = key.length / 8;
        setKey(key);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.workingKey == null) {
            throw new IllegalStateException("Twofish not initialised");
        }
        if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i2 + 16 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        if (this.encrypting) {
            encryptBlock(bArr, i, bArr2, i2);
            return 16;
        }
        decryptBlock(bArr, i, bArr2, i2);
        return 16;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
        byte[] bArr = this.workingKey;
        if (bArr != null) {
            setKey(bArr);
        }
    }
}
