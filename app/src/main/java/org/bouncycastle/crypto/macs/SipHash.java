package org.bouncycastle.crypto.macs;

import com.google.android.vending.expansion.downloader.Constants;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.util.Pack;
import org.bouncycastle.util.Arrays;

/* loaded from: classes5.dex */
public class SipHash implements Mac {
    public byte[] buf;
    public int bufPos;
    public final int c;
    public final int d;
    public long k0;
    public long k1;
    public long v0;
    public long v1;
    public long v2;
    public long v3;
    public long v4;
    public int wordCount;

    public SipHash() {
        this.buf = new byte[8];
        this.bufPos = 0;
        this.wordCount = 0;
        this.c = 2;
        this.d = 4;
    }

    public SipHash(int i, int i2) {
        this.buf = new byte[8];
        this.bufPos = 0;
        this.wordCount = 0;
        this.c = i;
        this.d = i2;
    }

    public static long rotateLeft(long j, int i) {
        return (j >>> (64 - i)) | (j << i);
    }

    public void applySipRounds(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            long j = this.v0;
            long j2 = this.v1;
            this.v0 = j + j2;
            this.v2 += this.v3;
            this.v1 = rotateLeft(j2, 13);
            long jRotateLeft = rotateLeft(this.v3, 16);
            this.v3 = jRotateLeft;
            long j3 = this.v1;
            long j4 = this.v0;
            this.v1 = j3 ^ j4;
            this.v3 = jRotateLeft ^ this.v2;
            long jRotateLeft2 = rotateLeft(j4, 32);
            this.v0 = jRotateLeft2;
            long j5 = this.v2;
            long j6 = this.v1;
            this.v2 = j5 + j6;
            this.v0 = jRotateLeft2 + this.v3;
            this.v1 = rotateLeft(j6, 17);
            long jRotateLeft3 = rotateLeft(this.v3, 21);
            this.v3 = jRotateLeft3;
            long j7 = this.v1;
            long j8 = this.v2;
            this.v1 = j7 ^ j8;
            this.v3 = jRotateLeft3 ^ this.v0;
            this.v2 = rotateLeft(j8, 32);
        }
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i) throws IllegalStateException, DataLengthException {
        Pack.longToLittleEndian(doFinal(), bArr, i);
        return 8;
    }

    public long doFinal() throws IllegalStateException, DataLengthException {
        this.buf[7] = (byte) (((this.wordCount << 3) + this.bufPos) & 255);
        while (true) {
            int i = this.bufPos;
            if (i >= 7) {
                processMessageWord();
                this.v2 ^= 255;
                applySipRounds(this.d);
                long j = ((this.v0 ^ this.v1) ^ this.v2) ^ this.v3;
                reset();
                return j;
            }
            byte[] bArr = this.buf;
            this.bufPos = i + 1;
            bArr[i] = 0;
        }
    }

    @Override // org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        return "SipHash-" + this.c + Constants.FILENAME_SEQUENCE_SEPARATOR + this.d;
    }

    @Override // org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return 8;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("'params' must be an instance of KeyParameter");
        }
        byte[] key = ((KeyParameter) cipherParameters).getKey();
        if (key.length != 16) {
            throw new IllegalArgumentException("'params' must be a 128-bit key");
        }
        this.k0 = Pack.littleEndianToLong(key, 0);
        this.k1 = Pack.littleEndianToLong(key, 8);
        reset();
    }

    public void processMessageWord() {
        this.wordCount++;
        long jLittleEndianToLong = Pack.littleEndianToLong(this.buf, 0);
        this.v3 ^= jLittleEndianToLong;
        applySipRounds(this.c);
        this.v0 = jLittleEndianToLong ^ this.v0;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void reset() {
        long j = this.k0;
        this.v0 = 8317987319222330741L ^ j;
        long j2 = this.k1;
        this.v1 = 7237128888997146477L ^ j2;
        this.v2 = j ^ 7816392313619706465L;
        this.v3 = 8387220255154660723L ^ j2;
        Arrays.fill(this.buf, (byte) 0);
        this.bufPos = 0;
        this.wordCount = 0;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte b) throws IllegalStateException {
        byte[] bArr = this.buf;
        int i = this.bufPos;
        bArr[i] = b;
        int i2 = i + 1;
        this.bufPos = i2;
        if (i2 == bArr.length) {
            processMessageWord();
            this.bufPos = 0;
        }
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte[] bArr, int i, int i2) throws IllegalStateException, DataLengthException {
        for (int i3 = 0; i3 < i2; i3++) {
            byte[] bArr2 = this.buf;
            int i4 = this.bufPos;
            bArr2[i4] = bArr[i + i3];
            int i5 = i4 + 1;
            this.bufPos = i5;
            if (i5 == bArr2.length) {
                processMessageWord();
                this.bufPos = 0;
            }
        }
    }
}
