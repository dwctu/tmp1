package org.bouncycastle.apache.bzip2;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;

/* loaded from: classes5.dex */
public class CBZip2InputStream extends InputStream implements BZip2Constants {
    private static final int NO_RAND_PART_A_STATE = 5;
    private static final int NO_RAND_PART_B_STATE = 6;
    private static final int NO_RAND_PART_C_STATE = 7;
    private static final int RAND_PART_A_STATE = 2;
    private static final int RAND_PART_B_STATE = 3;
    private static final int RAND_PART_C_STATE = 4;
    private static final int START_BLOCK_STATE = 1;
    private boolean blockRandomised;
    private int blockSize100k;
    private int bsBuff;
    private int bsLive;
    private InputStream bsStream;
    public int ch2;
    public int chPrev;
    private int computedBlockCRC;
    private int computedCombinedCRC;
    public int count;
    public int i;
    public int i2;
    public int j2;
    private int last;
    private int nInUse;
    private int origPtr;
    private int storedBlockCRC;
    private int storedCombinedCRC;
    public int tPos;
    public char z;
    private CRC mCrc = new CRC();
    private boolean[] inUse = new boolean[256];
    private char[] seqToUnseq = new char[256];
    private char[] unseqToSeq = new char[256];
    private char[] selector = new char[BZip2Constants.MAX_SELECTORS];
    private char[] selectorMtf = new char[BZip2Constants.MAX_SELECTORS];
    private int[] unzftab = new int[256];
    private int[][] limit = (int[][]) Array.newInstance((Class<?>) int.class, 6, BZip2Constants.MAX_ALPHA_SIZE);
    private int[][] base = (int[][]) Array.newInstance((Class<?>) int.class, 6, BZip2Constants.MAX_ALPHA_SIZE);
    private int[][] perm = (int[][]) Array.newInstance((Class<?>) int.class, 6, BZip2Constants.MAX_ALPHA_SIZE);
    private int[] minLens = new int[6];
    private boolean streamEnd = false;
    private int currentChar = -1;
    private int currentState = 1;
    public int rNToGo = 0;
    public int rTPos = 0;
    private char[] ll8 = null;
    private int[] tt = null;

    public CBZip2InputStream(InputStream inputStream) throws IOException {
        bsSetStream(inputStream);
        initialize();
        initBlock();
        setupBlock();
    }

    private static void badBlockHeader() {
        cadvise();
    }

    private static void blockOverrun() {
        cadvise();
    }

    private void bsFinishedWithStream() throws IOException {
        try {
            InputStream inputStream = this.bsStream;
            if (inputStream == null || inputStream == System.in) {
                return;
            }
            inputStream.close();
            this.bsStream = null;
        } catch (IOException unused) {
        }
    }

    private int bsGetInt32() {
        return bsGetint();
    }

    private int bsGetIntVS(int i) {
        return bsR(i);
    }

    private char bsGetUChar() {
        return (char) bsR(8);
    }

    private int bsGetint() {
        return bsR(8) | ((((((bsR(8) | 0) << 8) | bsR(8)) << 8) | bsR(8)) << 8);
    }

    private int bsR(int i) {
        while (true) {
            int i2 = this.bsLive;
            if (i2 >= i) {
                int i3 = (this.bsBuff >> (i2 - i)) & ((1 << i) - 1);
                this.bsLive = i2 - i;
                return i3;
            }
            char c = 0;
            try {
                c = (char) this.bsStream.read();
            } catch (IOException unused) {
                compressedStreamEOF();
            }
            if (c == 65535) {
                compressedStreamEOF();
            }
            this.bsBuff = (c & 255) | (this.bsBuff << 8);
            this.bsLive += 8;
        }
    }

    private void bsSetStream(InputStream inputStream) {
        this.bsStream = inputStream;
        this.bsLive = 0;
        this.bsBuff = 0;
    }

    private static void cadvise() {
        System.out.println("CRC Error");
    }

    private void complete() throws IOException {
        int iBsGetInt32 = bsGetInt32();
        this.storedCombinedCRC = iBsGetInt32;
        if (iBsGetInt32 != this.computedCombinedCRC) {
            crcError();
        }
        bsFinishedWithStream();
        this.streamEnd = true;
    }

    private static void compressedStreamEOF() {
        cadvise();
    }

    private static void crcError() {
        cadvise();
    }

    private void endBlock() {
        int finalCRC = this.mCrc.getFinalCRC();
        this.computedBlockCRC = finalCRC;
        if (this.storedBlockCRC != finalCRC) {
            crcError();
        }
        int i = this.computedCombinedCRC;
        int i2 = (i >>> 31) | (i << 1);
        this.computedCombinedCRC = i2;
        this.computedCombinedCRC = i2 ^ this.computedBlockCRC;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0169  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void getAndMoveToFrontDecode() {
        /*
            Method dump skipped, instructions count: 481
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.apache.bzip2.CBZip2InputStream.getAndMoveToFrontDecode():void");
    }

    private void hbCreateDecodeTables(int[] iArr, int[] iArr2, int[] iArr3, char[] cArr, int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        for (int i6 = i; i6 <= i2; i6++) {
            for (int i7 = 0; i7 < i3; i7++) {
                if (cArr[i7] == i6) {
                    iArr3[i5] = i7;
                    i5++;
                }
            }
        }
        for (int i8 = 0; i8 < 23; i8++) {
            iArr2[i8] = 0;
        }
        for (int i9 = 0; i9 < i3; i9++) {
            int i10 = cArr[i9] + 1;
            iArr2[i10] = iArr2[i10] + 1;
        }
        for (int i11 = 1; i11 < 23; i11++) {
            iArr2[i11] = iArr2[i11] + iArr2[i11 - 1];
        }
        for (int i12 = 0; i12 < 23; i12++) {
            iArr[i12] = 0;
        }
        int i13 = i;
        while (i13 <= i2) {
            int i14 = i13 + 1;
            int i15 = i4 + (iArr2[i14] - iArr2[i13]);
            iArr[i13] = i15 - 1;
            i4 = i15 << 1;
            i13 = i14;
        }
        for (int i16 = i + 1; i16 <= i2; i16++) {
            iArr2[i16] = ((iArr[i16 - 1] + 1) << 1) - iArr2[i16];
        }
    }

    private void initBlock() throws IOException {
        char cBsGetUChar = bsGetUChar();
        char cBsGetUChar2 = bsGetUChar();
        char cBsGetUChar3 = bsGetUChar();
        char cBsGetUChar4 = bsGetUChar();
        char cBsGetUChar5 = bsGetUChar();
        char cBsGetUChar6 = bsGetUChar();
        if (cBsGetUChar == 23 && cBsGetUChar2 == 'r' && cBsGetUChar3 == 'E' && cBsGetUChar4 == '8' && cBsGetUChar5 == 'P' && cBsGetUChar6 == 144) {
            complete();
            return;
        }
        if (cBsGetUChar != '1' || cBsGetUChar2 != 'A' || cBsGetUChar3 != 'Y' || cBsGetUChar4 != '&' || cBsGetUChar5 != 'S' || cBsGetUChar6 != 'Y') {
            badBlockHeader();
            this.streamEnd = true;
            return;
        }
        this.storedBlockCRC = bsGetInt32();
        if (bsR(1) == 1) {
            this.blockRandomised = true;
        } else {
            this.blockRandomised = false;
        }
        getAndMoveToFrontDecode();
        this.mCrc.initialiseCRC();
        this.currentState = 1;
    }

    private void initialize() throws IOException {
        char cBsGetUChar = bsGetUChar();
        char cBsGetUChar2 = bsGetUChar();
        if (cBsGetUChar != 'B' && cBsGetUChar2 != 'Z') {
            throw new IOException("Not a BZIP2 marked stream");
        }
        char cBsGetUChar3 = bsGetUChar();
        char cBsGetUChar4 = bsGetUChar();
        if (cBsGetUChar3 != 'h' || cBsGetUChar4 < '1' || cBsGetUChar4 > '9') {
            bsFinishedWithStream();
            this.streamEnd = true;
        } else {
            setDecompressStructureSizes(cBsGetUChar4 - '0');
            this.computedCombinedCRC = 0;
        }
    }

    private void makeMaps() {
        this.nInUse = 0;
        for (int i = 0; i < 256; i++) {
            if (this.inUse[i]) {
                char[] cArr = this.seqToUnseq;
                int i2 = this.nInUse;
                cArr[i2] = (char) i;
                this.unseqToSeq[i] = (char) i2;
                this.nInUse = i2 + 1;
            }
        }
    }

    private void recvDecodingTables() {
        char[][] cArr = (char[][]) Array.newInstance((Class<?>) char.class, 6, BZip2Constants.MAX_ALPHA_SIZE);
        boolean[] zArr = new boolean[16];
        for (int i = 0; i < 16; i++) {
            if (bsR(1) == 1) {
                zArr[i] = true;
            } else {
                zArr[i] = false;
            }
        }
        for (int i2 = 0; i2 < 256; i2++) {
            this.inUse[i2] = false;
        }
        for (int i3 = 0; i3 < 16; i3++) {
            if (zArr[i3]) {
                for (int i4 = 0; i4 < 16; i4++) {
                    if (bsR(1) == 1) {
                        this.inUse[(i3 * 16) + i4] = true;
                    }
                }
            }
        }
        makeMaps();
        int i5 = this.nInUse + 2;
        int iBsR = bsR(3);
        int iBsR2 = bsR(15);
        for (int i6 = 0; i6 < iBsR2; i6++) {
            int i7 = 0;
            while (bsR(1) == 1) {
                i7++;
            }
            this.selectorMtf[i6] = (char) i7;
        }
        char[] cArr2 = new char[6];
        for (char c = 0; c < iBsR; c = (char) (c + 1)) {
            cArr2[c] = c;
        }
        for (int i8 = 0; i8 < iBsR2; i8++) {
            char c2 = this.selectorMtf[i8];
            char c3 = cArr2[c2];
            while (c2 > 0) {
                int i9 = c2 - 1;
                cArr2[c2] = cArr2[i9];
                c2 = (char) i9;
            }
            cArr2[0] = c3;
            this.selector[i8] = c3;
        }
        for (int i10 = 0; i10 < iBsR; i10++) {
            int iBsR3 = bsR(5);
            for (int i11 = 0; i11 < i5; i11++) {
                while (bsR(1) == 1) {
                    iBsR3 = bsR(1) == 0 ? iBsR3 + 1 : iBsR3 - 1;
                }
                cArr[i10][i11] = (char) iBsR3;
            }
        }
        for (int i12 = 0; i12 < iBsR; i12++) {
            char c4 = ' ';
            char c5 = 0;
            for (int i13 = 0; i13 < i5; i13++) {
                if (cArr[i12][i13] > c5) {
                    c5 = cArr[i12][i13];
                }
                if (cArr[i12][i13] < c4) {
                    c4 = cArr[i12][i13];
                }
            }
            hbCreateDecodeTables(this.limit[i12], this.base[i12], this.perm[i12], cArr[i12], c4, c5, i5);
            this.minLens[i12] = c4;
        }
    }

    private void setDecompressStructureSizes(int i) {
        if (i >= 0 && i <= 9) {
            int i2 = this.blockSize100k;
        }
        this.blockSize100k = i;
        if (i == 0) {
            return;
        }
        int i3 = i * 100000;
        this.ll8 = new char[i3];
        this.tt = new int[i3];
    }

    private void setupBlock() throws IOException {
        int[] iArr = new int[257];
        iArr[0] = 0;
        this.i = 1;
        while (true) {
            int i = this.i;
            if (i > 256) {
                break;
            }
            iArr[i] = this.unzftab[i - 1];
            this.i = i + 1;
        }
        this.i = 1;
        while (true) {
            int i2 = this.i;
            if (i2 > 256) {
                break;
            }
            iArr[i2] = iArr[i2] + iArr[i2 - 1];
            this.i = i2 + 1;
        }
        this.i = 0;
        while (true) {
            int i3 = this.i;
            if (i3 > this.last) {
                break;
            }
            char c = this.ll8[i3];
            this.tt[iArr[c]] = i3;
            iArr[c] = iArr[c] + 1;
            this.i = i3 + 1;
        }
        this.tPos = this.tt[this.origPtr];
        this.count = 0;
        this.i2 = 0;
        this.ch2 = 256;
        if (!this.blockRandomised) {
            setupNoRandPartA();
            return;
        }
        this.rNToGo = 0;
        this.rTPos = 0;
        setupRandPartA();
    }

    private void setupNoRandPartA() throws IOException {
        int i = this.i2;
        if (i > this.last) {
            endBlock();
            initBlock();
            setupBlock();
            return;
        }
        this.chPrev = this.ch2;
        char[] cArr = this.ll8;
        int i2 = this.tPos;
        char c = cArr[i2];
        this.ch2 = c;
        this.tPos = this.tt[i2];
        this.i2 = i + 1;
        this.currentChar = c;
        this.currentState = 6;
        this.mCrc.updateCRC(c);
    }

    private void setupNoRandPartB() throws IOException {
        if (this.ch2 != this.chPrev) {
            this.currentState = 5;
            this.count = 1;
        } else {
            int i = this.count + 1;
            this.count = i;
            if (i >= 4) {
                char[] cArr = this.ll8;
                int i2 = this.tPos;
                this.z = cArr[i2];
                this.tPos = this.tt[i2];
                this.currentState = 7;
                this.j2 = 0;
                setupNoRandPartC();
                return;
            }
            this.currentState = 5;
        }
        setupNoRandPartA();
    }

    private void setupNoRandPartC() throws IOException {
        if (this.j2 < this.z) {
            int i = this.ch2;
            this.currentChar = i;
            this.mCrc.updateCRC(i);
            this.j2++;
            return;
        }
        this.currentState = 5;
        this.i2++;
        this.count = 0;
        setupNoRandPartA();
    }

    private void setupRandPartA() throws IOException {
        int i = this.i2;
        if (i > this.last) {
            endBlock();
            initBlock();
            setupBlock();
            return;
        }
        this.chPrev = this.ch2;
        char[] cArr = this.ll8;
        int i2 = this.tPos;
        char c = cArr[i2];
        this.ch2 = c;
        this.tPos = this.tt[i2];
        if (this.rNToGo == 0) {
            int[] iArr = BZip2Constants.rNums;
            int i3 = this.rTPos;
            this.rNToGo = iArr[i3];
            int i4 = i3 + 1;
            this.rTPos = i4;
            if (i4 == 512) {
                this.rTPos = 0;
            }
        }
        int i5 = this.rNToGo - 1;
        this.rNToGo = i5;
        int i6 = c ^ (i5 == 1 ? (char) 1 : (char) 0);
        this.ch2 = i6;
        this.i2 = i + 1;
        this.currentChar = i6;
        this.currentState = 3;
        this.mCrc.updateCRC(i6);
    }

    private void setupRandPartB() throws IOException {
        if (this.ch2 != this.chPrev) {
            this.currentState = 2;
            this.count = 1;
        } else {
            int i = this.count + 1;
            this.count = i;
            if (i >= 4) {
                char[] cArr = this.ll8;
                int i2 = this.tPos;
                char c = cArr[i2];
                this.z = c;
                this.tPos = this.tt[i2];
                if (this.rNToGo == 0) {
                    int[] iArr = BZip2Constants.rNums;
                    int i3 = this.rTPos;
                    this.rNToGo = iArr[i3];
                    int i4 = i3 + 1;
                    this.rTPos = i4;
                    if (i4 == 512) {
                        this.rTPos = 0;
                    }
                }
                int i5 = this.rNToGo - 1;
                this.rNToGo = i5;
                this.z = (char) (c ^ (i5 != 1 ? (char) 0 : (char) 1));
                this.j2 = 0;
                this.currentState = 4;
                setupRandPartC();
                return;
            }
            this.currentState = 2;
        }
        setupRandPartA();
    }

    private void setupRandPartC() throws IOException {
        if (this.j2 < this.z) {
            int i = this.ch2;
            this.currentChar = i;
            this.mCrc.updateCRC(i);
            this.j2++;
            return;
        }
        this.currentState = 2;
        this.i2++;
        this.count = 0;
        setupRandPartA();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.streamEnd) {
            return -1;
        }
        int i = this.currentChar;
        int i2 = this.currentState;
        if (i2 == 3) {
            setupRandPartB();
        } else if (i2 == 4) {
            setupRandPartC();
        } else if (i2 == 6) {
            setupNoRandPartB();
        } else if (i2 == 7) {
            setupNoRandPartC();
        }
        return i;
    }
}
