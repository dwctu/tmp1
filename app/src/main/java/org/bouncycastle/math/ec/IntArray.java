package org.bouncycastle.math.ec;

import androidx.media.AudioAttributesCompat;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.gms.auth.api.accounttransfer.AccountTransferStatusCodes;
import com.google.common.base.Ascii;
import io.agora.rtc2.internal.RtcEngineEvent;
import java.math.BigInteger;
import no.nordicsemi.android.dfu.DfuBaseService;
import org.bouncycastle.util.Arrays;

/* loaded from: classes5.dex */
public class IntArray {
    private static final String ZEROES = "00000000000000000000000000000000";
    private int[] m_ints;
    private static final int[] INTERLEAVE_TABLE = {0, 1, 4, 5, 16, 17, 20, 21, 64, 65, 68, 69, 80, 81, 84, 85, 256, 257, 260, 261, 272, AudioAttributesCompat.FLAG_ALL_PUBLIC, 276, 277, 320, 321, 324, 325, 336, 337, 340, 341, 1024, 1025, AnalyticsListener.EVENT_VIDEO_SIZE_CHANGED, AnalyticsListener.EVENT_SURFACE_SIZE_CHANGED, 1040, 1041, 1044, 1045, 1088, 1089, 1092, 1093, 1104, RtcEngineEvent.EvtType.EVT_AUDIO_DEVICE_STATE_CHANGED, RtcEngineEvent.EvtType.EVT_REQUEST_TOKEN, RtcEngineEvent.EvtType.EVT_CLIENT_ROLE_CHANGED, 1280, 1281, 1284, 1285, 1296, 1297, 1300, 1301, 1344, 1345, 1348, 1349, 1360, 1361, 1364, 1365, 4096, 4097, 4100, DfuBaseService.ERROR_SERVICE_DISCOVERY_NOT_STARTED, 4112, 4113, 4116, 4117, 4160, 4161, 4164, 4165, 4176, 4177, 4180, 4181, 4352, 4353, 4356, 4357, 4368, 4369, 4372, 4373, 4416, 4417, 4420, 4421, 4432, 4433, 4436, 4437, 5120, 5121, 5124, 5125, 5136, 5137, 5140, 5141, 5184, 5185, 5188, 5189, 5200, 5201, 5204, 5205, 5376, 5377, 5380, 5381, 5392, 5393, 5396, 5397, 5440, 5441, 5444, 5445, 5456, 5457, 5460, 5461, 16384, 16385, 16388, 16389, 16400, 16401, 16404, 16405, 16448, 16449, 16452, 16453, 16464, 16465, 16468, 16469, 16640, 16641, 16644, 16645, 16656, 16657, 16660, 16661, 16704, 16705, 16708, 16709, 16720, 16721, 16724, 16725, 17408, 17409, 17412, 17413, 17424, 17425, 17428, 17429, 17472, 17473, 17476, 17477, 17488, 17489, 17492, 17493, 17664, 17665, 17668, 17669, 17680, 17681, 17684, 17685, 17728, 17729, 17732, 17733, 17744, 17745, 17748, 17749, CacheDataSink.DEFAULT_BUFFER_SIZE, 20481, 20484, 20485, 20496, 20497, AccountTransferStatusCodes.NOT_ALLOWED_SECURITY, AccountTransferStatusCodes.NO_DATA_AVAILABLE, 20544, 20545, 20548, 20549, 20560, 20561, 20564, 20565, 20736, 20737, 20740, 20741, 20752, 20753, 20756, 20757, 20800, 20801, 20804, 20805, 20816, 20817, 20820, 20821, 21504, 21505, 21508, 21509, 21520, 21521, 21524, 21525, 21568, 21569, 21572, 21573, 21584, 21585, 21588, 21589, 21760, 21761, 21764, 21765, 21776, 21777, 21780, 21781, 21824, 21825, 21828, 21829, 21840, 21841, 21844, 21845};
    private static final byte[] bitLengths = {0, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8};

    public IntArray(int i) {
        this.m_ints = new int[i];
    }

    public IntArray(BigInteger bigInteger) {
        int i;
        if (bigInteger == null || bigInteger.signum() < 0) {
            throw new IllegalArgumentException("invalid F2m field value");
        }
        if (bigInteger.signum() == 0) {
            this.m_ints = new int[]{0};
            return;
        }
        byte[] byteArray = bigInteger.toByteArray();
        int length = byteArray.length;
        if (byteArray[0] == 0) {
            length--;
            i = 1;
        } else {
            i = 0;
        }
        int i2 = (length + 3) / 4;
        this.m_ints = new int[i2];
        int i3 = i2 - 1;
        int i4 = (length % 4) + i;
        if (i < i4) {
            int i5 = 0;
            while (i < i4) {
                i5 = (i5 << 8) | (byteArray[i] & 255);
                i++;
            }
            this.m_ints[i3] = i5;
            i3--;
        }
        while (i3 >= 0) {
            int i6 = 0;
            int i7 = 0;
            while (i6 < 4) {
                i7 = (i7 << 8) | (byteArray[i] & 255);
                i6++;
                i++;
            }
            this.m_ints[i3] = i7;
            i3--;
        }
    }

    public IntArray(int[] iArr) {
        this.m_ints = iArr;
    }

    private static void add(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = iArr[i2] ^ iArr2[i2];
        }
    }

    private static int addShiftedByBits(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4) {
        int i5 = 32 - i4;
        int i6 = 0;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = iArr2[i2 + i7];
            int i9 = i + i7;
            iArr[i9] = (i6 | (i8 << i4)) ^ iArr[i9];
            i6 = i8 >>> i5;
        }
        return i6;
    }

    private static int addShiftedByBits(int[] iArr, int[] iArr2, int i, int i2) {
        int i3 = 32 - i2;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = iArr2[i5];
            iArr[i5] = (i4 | (i6 << i2)) ^ iArr[i5];
            i4 = i6 >>> i3;
        }
        return i4;
    }

    private void addShiftedByBits(IntArray intArray, int i) {
        int i2 = i >>> 5;
        int i3 = i & 31;
        if (i3 == 0) {
            addShiftedByWords(intArray, i2);
            return;
        }
        int usedLength = intArray.getUsedLength();
        if (usedLength == 0) {
            return;
        }
        int i4 = usedLength + i2;
        int i5 = i4 + 1;
        if (i5 > this.m_ints.length) {
            this.m_ints = resizedInts(i5);
        }
        int i6 = 32 - i3;
        int i7 = 0;
        for (int i8 = 0; i8 < usedLength; i8++) {
            int i9 = intArray.m_ints[i8];
            int[] iArr = this.m_ints;
            int i10 = i8 + i2;
            iArr[i10] = (i7 | (i9 << i3)) ^ iArr[i10];
            i7 = i9 >>> i6;
        }
        int[] iArr2 = this.m_ints;
        iArr2[i4] = iArr2[i4] ^ i7;
    }

    private static void addShiftedByWords(int[] iArr, int i, int[] iArr2, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i + i3;
            iArr[i4] = iArr[i4] ^ iArr2[i3];
        }
    }

    private static int bitLength(int i) {
        int i2 = i >>> 16;
        if (i2 == 0) {
            int i3 = i >>> 8;
            return i3 == 0 ? bitLengths[i] : bitLengths[i3] + 8;
        }
        int i4 = i2 >>> 8;
        return i4 == 0 ? bitLengths[i2] + 16 : bitLengths[i4] + Ascii.CAN;
    }

    private static void distribute(int[] iArr, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = iArr[i3 + i5];
            int i7 = i + i5;
            iArr[i7] = iArr[i7] ^ i6;
            int i8 = i2 + i5;
            iArr[i8] = i6 ^ iArr[i8];
        }
    }

    public static int getWordLength(int i) {
        return (i + 31) >>> 5;
    }

    private static int interleave(int i, int i2) {
        while (true) {
            i2--;
            if (i2 < 0) {
                return i;
            }
            i = (interleave16(i >>> 16) << 1) | interleave16(65535 & i);
        }
    }

    private static void interleave(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < i3; i5++) {
            iArr2[i2 + i5] = interleave(iArr[i + i5], i4);
        }
    }

    private static int interleave16(int i) {
        int[] iArr = INTERLEAVE_TABLE;
        return (iArr[i >>> 8] << 16) | iArr[i & 255];
    }

    private void reduceBitWise(int i, int i2, int[] iArr) {
        while (i >= i2) {
            if (testBit(i)) {
                int i3 = i - i2;
                flipBit(i3);
                int length = iArr.length;
                while (true) {
                    length--;
                    if (length >= 0) {
                        flipBit(iArr[length] + i3);
                    }
                }
            }
            i--;
        }
    }

    private void reduceWordWise(int i, int i2, int[] iArr) {
        for (int i3 = ((i - i2) & (-32)) + i2; i3 >= i2; i3 -= 32) {
            int word = getWord(i3);
            if (word != 0) {
                int i4 = i3 - i2;
                flipWord(i4, word);
                int length = iArr.length;
                while (true) {
                    length--;
                    if (length >= 0) {
                        flipWord(iArr[length] + i4, word);
                    }
                }
            }
        }
    }

    private int[] resizedInts(int i) {
        int[] iArr = new int[i];
        int[] iArr2 = this.m_ints;
        System.arraycopy(iArr2, 0, iArr, 0, Math.min(iArr2.length, i));
        return iArr;
    }

    private static int shiftLeft(int[] iArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = iArr[i3];
            iArr[i3] = i2 | (i4 << 1);
            i2 = i4 >>> 31;
        }
        return i2;
    }

    public void addOneShifted(int i) {
        if (i >= this.m_ints.length) {
            this.m_ints = resizedInts(i + 1);
        }
        int[] iArr = this.m_ints;
        iArr[i] = iArr[i] ^ 1;
    }

    public void addShiftedByWords(IntArray intArray, int i) {
        int usedLength = intArray.getUsedLength();
        if (usedLength == 0) {
            return;
        }
        int i2 = usedLength + i;
        if (i2 > this.m_ints.length) {
            this.m_ints = resizedInts(i2);
        }
        for (int i3 = 0; i3 < usedLength; i3++) {
            int[] iArr = this.m_ints;
            int i4 = i + i3;
            iArr[i4] = iArr[i4] ^ intArray.m_ints[i3];
        }
    }

    public void clearBit(int i) {
        int i2 = i >>> 5;
        int[] iArr = this.m_ints;
        iArr[i2] = (~(1 << (i & 31))) & iArr[i2];
    }

    public Object clone() {
        return new IntArray(Arrays.clone(this.m_ints));
    }

    public int degree() {
        int length = this.m_ints.length;
        while (length != 0) {
            length--;
            int i = this.m_ints[length];
            if (i != 0) {
                return (length << 5) + bitLength(i);
            }
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IntArray)) {
            return false;
        }
        IntArray intArray = (IntArray) obj;
        int usedLength = getUsedLength();
        if (intArray.getUsedLength() != usedLength) {
            return false;
        }
        for (int i = 0; i < usedLength; i++) {
            if (this.m_ints[i] != intArray.m_ints[i]) {
                return false;
            }
        }
        return true;
    }

    public void flipBit(int i) {
        int i2 = i >>> 5;
        int[] iArr = this.m_ints;
        iArr[i2] = (1 << (i & 31)) ^ iArr[i2];
    }

    public void flipWord(int i, int i2) {
        int[] iArr = this.m_ints;
        int length = iArr.length;
        int i3 = i >>> 5;
        if (i3 < length) {
            int i4 = i & 31;
            if (i4 == 0) {
                iArr[i3] = iArr[i3] ^ i2;
                return;
            }
            iArr[i3] = iArr[i3] ^ (i2 << i4);
            int i5 = i3 + 1;
            if (i5 < length) {
                iArr[i5] = (i2 >>> (32 - i4)) ^ iArr[i5];
            }
        }
    }

    public int getLength() {
        return this.m_ints.length;
    }

    public int getUsedLength() {
        return getUsedLengthFrom(this.m_ints.length);
    }

    public int getUsedLengthFrom(int i) {
        int[] iArr = this.m_ints;
        int iMin = Math.min(i, iArr.length);
        if (iMin < 1) {
            return 0;
        }
        if (iArr[0] != 0) {
            do {
                iMin--;
            } while (iArr[iMin] == 0);
            return iMin + 1;
        }
        do {
            iMin--;
            if (iArr[iMin] != 0) {
                return iMin + 1;
            }
        } while (iMin > 0);
        return 0;
    }

    public int getWord(int i) {
        int[] iArr = this.m_ints;
        int length = iArr.length;
        int i2 = i >>> 5;
        if (i2 >= length) {
            return 0;
        }
        int i3 = i & 31;
        if (i3 == 0) {
            return iArr[i2];
        }
        int i4 = iArr[i2] >>> i3;
        int i5 = i2 + 1;
        return i5 < length ? i4 | (iArr[i5] << (32 - i3)) : i4;
    }

    public int hashCode() {
        int usedLength = getUsedLength();
        int i = 1;
        for (int i2 = 0; i2 < usedLength; i2++) {
            i = (i * 31) ^ this.m_ints[i2];
        }
        return i;
    }

    public boolean isZero() {
        for (int i : this.m_ints) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public IntArray modInverse(int i, int[] iArr) {
        int iDegree = degree();
        if (iDegree == 1) {
            return this;
        }
        IntArray intArray = (IntArray) clone();
        int wordLength = getWordLength(i);
        IntArray intArray2 = new IntArray(wordLength);
        intArray2.setBit(i);
        intArray2.setBit(0);
        intArray2.setBit(iArr[0]);
        if (iArr.length > 1) {
            intArray2.setBit(iArr[1]);
            intArray2.setBit(iArr[2]);
        }
        IntArray intArray3 = new IntArray(wordLength);
        intArray3.setBit(0);
        IntArray intArray4 = new IntArray(wordLength);
        while (iDegree != 0) {
            int iDegree2 = iDegree - intArray2.degree();
            if (iDegree2 < 0) {
                iDegree2 = -iDegree2;
                IntArray intArray5 = intArray3;
                intArray3 = intArray4;
                intArray4 = intArray5;
                IntArray intArray6 = intArray2;
                intArray2 = intArray;
                intArray = intArray6;
            }
            intArray.addShiftedByBits(intArray2, iDegree2);
            int iDegree3 = intArray.degree();
            if (iDegree3 != 0) {
                intArray3.addShiftedByBits(intArray4, iDegree2);
            }
            iDegree = iDegree3;
        }
        return intArray4;
    }

    public IntArray multiply(IntArray intArray, int i) {
        int usedLength;
        int i2;
        int i3;
        IntArray intArray2;
        IntArray intArray3;
        int usedLength2 = getUsedLength();
        if (usedLength2 != 0 && (usedLength = intArray.getUsedLength()) != 0) {
            if (usedLength2 > usedLength) {
                i3 = usedLength2;
                i2 = usedLength;
                intArray3 = this;
                intArray2 = intArray;
            } else {
                i2 = usedLength2;
                i3 = usedLength;
                intArray2 = this;
                intArray3 = intArray;
            }
            if (i2 == 1) {
                int i4 = intArray2.m_ints[0];
                int[] iArr = intArray3.m_ints;
                int[] iArr2 = new int[i2 + i3];
                if ((i4 & 1) != 0) {
                    add(iArr2, iArr, i3);
                }
                int i5 = 1;
                while (true) {
                    i4 >>>= 1;
                    if (i4 == 0) {
                        return new IntArray(iArr2);
                    }
                    if ((i4 & 1) != 0) {
                        addShiftedByBits(iArr2, iArr, i3, i5);
                    }
                    i5++;
                }
            } else {
                int i6 = i2 <= 8 ? 1 : 2;
                int i7 = 1 << i6;
                int i8 = 32;
                int i9 = 32 >>> i6;
                int[] iArr3 = intArray3.m_ints;
                int i10 = (iArr3[i3 + (-1)] >>> (33 - i9)) != 0 ? i3 + 1 : i3;
                int i11 = i10 + i2;
                int[] iArr4 = new int[i11 << i7];
                System.arraycopy(iArr3, 0, iArr4, 0, i3);
                interleave(intArray2.m_ints, 0, iArr4, i10, i2, i6);
                int i12 = 1 << i7;
                int[] iArr5 = new int[i12];
                for (int i13 = 1; i13 < i12; i13++) {
                    iArr5[i13] = iArr5[i13 - 1] + i11;
                }
                int i14 = i12 - 1;
                int i15 = 0;
                while (true) {
                    for (int i16 = 0; i16 < i2; i16++) {
                        int i17 = (iArr4[i10 + i16] >>> i15) & i14;
                        if (i17 != 0) {
                            addShiftedByWords(iArr4, iArr5[i17] + i16, iArr4, i10);
                        }
                    }
                    i15 += i7;
                    if (i15 >= 32) {
                        break;
                    }
                    shiftLeft(iArr4, i10);
                }
                int i18 = i12 >>> 1;
                while (true) {
                    i12--;
                    if (i12 <= 1) {
                        int i19 = i11;
                        IntArray intArray4 = new IntArray(i19);
                        System.arraycopy(iArr4, iArr5[1], intArray4.m_ints, 0, i19);
                        return intArray4;
                    }
                    if (i12 == i18) {
                        i8 -= i9;
                        int i20 = i11;
                        addShiftedByBits(iArr4, iArr5[1], iArr4, iArr5[i18], i20, i8);
                        i18 >>>= 1;
                        i11 = i20;
                    } else {
                        distribute(iArr4, iArr5[i18], iArr5[i12 - i18], iArr5[i12], i11);
                    }
                }
            }
        }
        return new IntArray(1);
    }

    public void reduce(int i, int[] iArr) {
        int usedLength = getUsedLength();
        int i2 = (i + 31) >>> 5;
        if (usedLength < i2) {
            return;
        }
        int iMin = Math.min((i << 1) - 2, (usedLength << 5) - 1);
        if (iArr[iArr.length - 1] < i - 31) {
            reduceWordWise(iMin, i, iArr);
        } else {
            reduceBitWise(iMin, i, iArr);
        }
        int i3 = i & 31;
        if (i3 != 0) {
            int[] iArr2 = this.m_ints;
            int i4 = i2 - 1;
            iArr2[i4] = ((1 << i3) - 1) & iArr2[i4];
        }
        if (usedLength > i2) {
            this.m_ints = resizedInts(i2);
        }
    }

    public void setBit(int i) {
        int i2 = i >>> 5;
        int[] iArr = this.m_ints;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    public IntArray square(int i) {
        int usedLength = getUsedLength();
        if (usedLength == 0) {
            return this;
        }
        int i2 = usedLength << 1;
        int[] iArr = new int[i2];
        int i3 = 0;
        while (i3 < i2) {
            int i4 = this.m_ints[i3 >>> 1];
            int i5 = i3 + 1;
            iArr[i3] = interleave16(65535 & i4);
            i3 = i5 + 1;
            iArr[i5] = interleave16(i4 >>> 16);
        }
        return new IntArray(iArr);
    }

    public boolean testBit(int i) {
        return ((1 << (i & 31)) & this.m_ints[i >>> 5]) != 0;
    }

    public boolean testBitZero() {
        int[] iArr = this.m_ints;
        return iArr.length > 0 && (iArr[0] & 1) != 0;
    }

    public BigInteger toBigInteger() {
        int usedLength = getUsedLength();
        if (usedLength == 0) {
            return ECConstants.ZERO;
        }
        int i = usedLength - 1;
        int i2 = this.m_ints[i];
        byte[] bArr = new byte[4];
        int i3 = 0;
        boolean z = false;
        for (int i4 = 3; i4 >= 0; i4--) {
            byte b = (byte) (i2 >>> (i4 * 8));
            if (z || b != 0) {
                bArr[i3] = b;
                i3++;
                z = true;
            }
        }
        byte[] bArr2 = new byte[(i * 4) + i3];
        for (int i5 = 0; i5 < i3; i5++) {
            bArr2[i5] = bArr[i5];
        }
        for (int i6 = usedLength - 2; i6 >= 0; i6--) {
            int i7 = 3;
            while (i7 >= 0) {
                bArr2[i3] = (byte) (this.m_ints[i6] >>> (i7 * 8));
                i7--;
                i3++;
            }
        }
        return new BigInteger(1, bArr2);
    }

    public String toString() {
        int usedLength = getUsedLength();
        if (usedLength == 0) {
            return "0";
        }
        int i = usedLength - 1;
        StringBuffer stringBuffer = new StringBuffer(Integer.toBinaryString(this.m_ints[i]));
        while (true) {
            i--;
            if (i < 0) {
                return stringBuffer.toString();
            }
            String binaryString = Integer.toBinaryString(this.m_ints[i]);
            int length = binaryString.length();
            if (length < 32) {
                stringBuffer.append(ZEROES.substring(length));
            }
            stringBuffer.append(binaryString);
        }
    }
}
