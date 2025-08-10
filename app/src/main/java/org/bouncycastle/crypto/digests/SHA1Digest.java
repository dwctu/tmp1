package org.bouncycastle.crypto.digests;

import com.google.common.base.Ascii;
import org.bouncycastle.crypto.util.Pack;
import org.bouncycastle.util.Memoable;

/* loaded from: classes5.dex */
public class SHA1Digest extends GeneralDigest {
    private static final int DIGEST_LENGTH = 20;
    private static final int Y1 = 1518500249;
    private static final int Y2 = 1859775393;
    private static final int Y3 = -1894007588;
    private static final int Y4 = -899497514;
    private int H1;
    private int H2;
    private int H3;
    private int H4;
    private int H5;
    private int[] X;
    private int xOff;

    public SHA1Digest() {
        this.X = new int[80];
        reset();
    }

    public SHA1Digest(SHA1Digest sHA1Digest) {
        super(sHA1Digest);
        this.X = new int[80];
        copyIn(sHA1Digest);
    }

    private void copyIn(SHA1Digest sHA1Digest) {
        this.H1 = sHA1Digest.H1;
        this.H2 = sHA1Digest.H2;
        this.H3 = sHA1Digest.H3;
        this.H4 = sHA1Digest.H4;
        this.H5 = sHA1Digest.H5;
        int[] iArr = sHA1Digest.X;
        System.arraycopy(iArr, 0, this.X, 0, iArr.length);
        this.xOff = sHA1Digest.xOff;
    }

    private int f(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    private int g(int i, int i2, int i3) {
        return (i & i3) | (i & i2) | (i2 & i3);
    }

    private int h(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new SHA1Digest(this);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i) {
        finish();
        Pack.intToBigEndian(this.H1, bArr, i);
        Pack.intToBigEndian(this.H2, bArr, i + 4);
        Pack.intToBigEndian(this.H3, bArr, i + 8);
        Pack.intToBigEndian(this.H4, bArr, i + 12);
        Pack.intToBigEndian(this.H5, bArr, i + 16);
        reset();
        return 20;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHA-1";
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 20;
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        for (int i = 16; i < 80; i++) {
            int[] iArr = this.X;
            int i2 = ((iArr[i - 3] ^ iArr[i - 8]) ^ iArr[i - 14]) ^ iArr[i - 16];
            iArr[i] = (i2 >>> 31) | (i2 << 1);
        }
        int iH = this.H1;
        int iH2 = this.H2;
        int i3 = this.H3;
        int i4 = this.H4;
        int i5 = this.H5;
        int i6 = 0;
        int i7 = 0;
        while (i6 < 4) {
            int i8 = i7 + 1;
            int iF = i5 + ((iH << 5) | (iH >>> 27)) + f(iH2, i3, i4) + this.X[i7] + Y1;
            int i9 = (iH2 >>> 2) | (iH2 << 30);
            int i10 = i8 + 1;
            int iF2 = i4 + ((iF << 5) | (iF >>> 27)) + f(iH, i9, i3) + this.X[i8] + Y1;
            int i11 = (iH >>> 2) | (iH << 30);
            int i12 = i10 + 1;
            int iF3 = i3 + ((iF2 << 5) | (iF2 >>> 27)) + f(iF, i11, i9) + this.X[i10] + Y1;
            i5 = (iF >>> 2) | (iF << 30);
            int i13 = i12 + 1;
            iH2 = i9 + ((iF3 << 5) | (iF3 >>> 27)) + f(iF2, i5, i11) + this.X[i12] + Y1;
            i4 = (iF2 >>> 2) | (iF2 << 30);
            iH = i11 + ((iH2 << 5) | (iH2 >>> 27)) + f(iF3, i4, i5) + this.X[i13] + Y1;
            i3 = (iF3 >>> 2) | (iF3 << 30);
            i6++;
            i7 = i13 + 1;
        }
        int i14 = 0;
        while (i14 < 4) {
            int i15 = i7 + 1;
            int iH3 = i5 + ((iH << 5) | (iH >>> 27)) + h(iH2, i3, i4) + this.X[i7] + Y2;
            int i16 = (iH2 >>> 2) | (iH2 << 30);
            int i17 = i15 + 1;
            int iH4 = i4 + ((iH3 << 5) | (iH3 >>> 27)) + h(iH, i16, i3) + this.X[i15] + Y2;
            int i18 = (iH >>> 2) | (iH << 30);
            int i19 = i17 + 1;
            int iH5 = i3 + ((iH4 << 5) | (iH4 >>> 27)) + h(iH3, i18, i16) + this.X[i17] + Y2;
            i5 = (iH3 >>> 2) | (iH3 << 30);
            int i20 = i19 + 1;
            iH2 = i16 + ((iH5 << 5) | (iH5 >>> 27)) + h(iH4, i5, i18) + this.X[i19] + Y2;
            i4 = (iH4 >>> 2) | (iH4 << 30);
            iH = i18 + ((iH2 << 5) | (iH2 >>> 27)) + h(iH5, i4, i5) + this.X[i20] + Y2;
            i3 = (iH5 >>> 2) | (iH5 << 30);
            i14++;
            i7 = i20 + 1;
        }
        int i21 = 0;
        while (i21 < 4) {
            int i22 = i7 + 1;
            int iG = i5 + ((iH << 5) | (iH >>> 27)) + g(iH2, i3, i4) + this.X[i7] + Y3;
            int i23 = (iH2 >>> 2) | (iH2 << 30);
            int i24 = i22 + 1;
            int iG2 = i4 + ((iG << 5) | (iG >>> 27)) + g(iH, i23, i3) + this.X[i22] + Y3;
            int i25 = (iH >>> 2) | (iH << 30);
            int i26 = i24 + 1;
            int iG3 = i3 + ((iG2 << 5) | (iG2 >>> 27)) + g(iG, i25, i23) + this.X[i24] + Y3;
            i5 = (iG >>> 2) | (iG << 30);
            int i27 = i26 + 1;
            iH2 = i23 + ((iG3 << 5) | (iG3 >>> 27)) + g(iG2, i5, i25) + this.X[i26] + Y3;
            i4 = (iG2 >>> 2) | (iG2 << 30);
            iH = i25 + ((iH2 << 5) | (iH2 >>> 27)) + g(iG3, i4, i5) + this.X[i27] + Y3;
            i3 = (iG3 >>> 2) | (iG3 << 30);
            i21++;
            i7 = i27 + 1;
        }
        int i28 = 0;
        while (i28 <= 3) {
            int i29 = i7 + 1;
            int iH6 = i5 + ((iH << 5) | (iH >>> 27)) + h(iH2, i3, i4) + this.X[i7] + Y4;
            int i30 = (iH2 >>> 2) | (iH2 << 30);
            int i31 = i29 + 1;
            int iH7 = i4 + ((iH6 << 5) | (iH6 >>> 27)) + h(iH, i30, i3) + this.X[i29] + Y4;
            int i32 = (iH >>> 2) | (iH << 30);
            int i33 = i31 + 1;
            int iH8 = i3 + ((iH7 << 5) | (iH7 >>> 27)) + h(iH6, i32, i30) + this.X[i31] + Y4;
            i5 = (iH6 >>> 2) | (iH6 << 30);
            int i34 = i33 + 1;
            iH2 = i30 + ((iH8 << 5) | (iH8 >>> 27)) + h(iH7, i5, i32) + this.X[i33] + Y4;
            i4 = (iH7 >>> 2) | (iH7 << 30);
            iH = i32 + ((iH2 << 5) | (iH2 >>> 27)) + h(iH8, i4, i5) + this.X[i34] + Y4;
            i3 = (iH8 >>> 2) | (iH8 << 30);
            i28++;
            i7 = i34 + 1;
        }
        this.H1 += iH;
        this.H2 += iH2;
        this.H3 += i3;
        this.H4 += i4;
        this.H5 += i5;
        this.xOff = 0;
        for (int i35 = 0; i35 < 16; i35++) {
            this.X[i35] = 0;
        }
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processLength(long j) {
        if (this.xOff > 14) {
            processBlock();
        }
        int[] iArr = this.X;
        iArr[14] = (int) (j >>> 32);
        iArr[15] = (int) (j & (-1));
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest
    public void processWord(byte[] bArr, int i) {
        int i2 = bArr[i] << Ascii.CAN;
        int i3 = i + 1;
        int i4 = i2 | ((bArr[i3] & 255) << 16);
        int i5 = i3 + 1;
        int i6 = (bArr[i5 + 1] & 255) | i4 | ((bArr[i5] & 255) << 8);
        int[] iArr = this.X;
        int i7 = this.xOff;
        iArr[i7] = i6;
        int i8 = i7 + 1;
        this.xOff = i8;
        if (i8 == 16) {
            processBlock();
        }
    }

    @Override // org.bouncycastle.crypto.digests.GeneralDigest, org.bouncycastle.crypto.Digest
    public void reset() {
        super.reset();
        this.H1 = 1732584193;
        this.H2 = -271733879;
        this.H3 = -1732584194;
        this.H4 = 271733878;
        this.H5 = -1009589776;
        this.xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.X;
            if (i == iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable memoable) {
        SHA1Digest sHA1Digest = (SHA1Digest) memoable;
        super.copyIn((GeneralDigest) sHA1Digest);
        copyIn(sHA1Digest);
    }
}
