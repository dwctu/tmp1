package org.bouncycastle.crypto.macs;

import com.google.common.primitives.UnsignedInts;
import io.agora.rtc2.internal.AudioRoutingController;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.generators.Poly1305KeyGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.util.Pack;

/* loaded from: classes5.dex */
public class Poly1305 implements Mac {
    private static final int BLOCK_SIZE = 16;
    private final BlockCipher cipher;
    private int h0;
    private int h1;
    private int h2;
    private int h3;
    private int h4;
    private int k0;
    private int k1;
    private int k2;
    private int k3;
    private int r0;
    private int r1;
    private int r2;
    private int r3;
    private int r4;
    private int s1;
    private int s2;
    private int s3;
    private int s4;
    private final byte[] singleByte = new byte[1];
    private final byte[] currentBlock = new byte[16];
    private int currentBlockOffset = 0;

    public Poly1305(BlockCipher blockCipher) {
        if (blockCipher.getBlockSize() != 16) {
            throw new IllegalArgumentException("Poly1305 requires a 128 bit block cipher.");
        }
        this.cipher = blockCipher;
    }

    private static final long mul32x32_64(int i, int i2) {
        return i * i2;
    }

    private void processBlock() {
        int i = this.currentBlockOffset;
        if (i < 16) {
            this.currentBlock[i] = 1;
            for (int i2 = i + 1; i2 < 16; i2++) {
                this.currentBlock[i2] = 0;
            }
        }
        long jLittleEndianToInt = Pack.littleEndianToInt(this.currentBlock, 0) & UnsignedInts.INT_MASK;
        long jLittleEndianToInt2 = Pack.littleEndianToInt(this.currentBlock, 4) & UnsignedInts.INT_MASK;
        long jLittleEndianToInt3 = Pack.littleEndianToInt(this.currentBlock, 8) & UnsignedInts.INT_MASK;
        long jLittleEndianToInt4 = UnsignedInts.INT_MASK & Pack.littleEndianToInt(this.currentBlock, 12);
        int i3 = (int) (this.h0 + (jLittleEndianToInt & 67108863));
        this.h0 = i3;
        this.h1 = (int) (this.h1 + ((((jLittleEndianToInt2 << 32) | jLittleEndianToInt) >>> 26) & 67108863));
        this.h2 = (int) (this.h2 + (((jLittleEndianToInt2 | (jLittleEndianToInt3 << 32)) >>> 20) & 67108863));
        this.h3 = (int) (this.h3 + ((((jLittleEndianToInt4 << 32) | jLittleEndianToInt3) >>> 14) & 67108863));
        int i4 = (int) (this.h4 + (jLittleEndianToInt4 >>> 8));
        this.h4 = i4;
        if (this.currentBlockOffset == 16) {
            this.h4 = i4 + 16777216;
        }
        long jMul32x32_64 = mul32x32_64(i3, this.r0) + mul32x32_64(this.h1, this.s4) + mul32x32_64(this.h2, this.s3) + mul32x32_64(this.h3, this.s2) + mul32x32_64(this.h4, this.s1);
        long jMul32x32_642 = mul32x32_64(this.h0, this.r1) + mul32x32_64(this.h1, this.r0) + mul32x32_64(this.h2, this.s4) + mul32x32_64(this.h3, this.s3) + mul32x32_64(this.h4, this.s2);
        long jMul32x32_643 = mul32x32_64(this.h0, this.r2) + mul32x32_64(this.h1, this.r1) + mul32x32_64(this.h2, this.r0) + mul32x32_64(this.h3, this.s4) + mul32x32_64(this.h4, this.s3);
        long jMul32x32_644 = mul32x32_64(this.h0, this.r3) + mul32x32_64(this.h1, this.r2) + mul32x32_64(this.h2, this.r1) + mul32x32_64(this.h3, this.r0) + mul32x32_64(this.h4, this.s4);
        long jMul32x32_645 = mul32x32_64(this.h0, this.r4) + mul32x32_64(this.h1, this.r3) + mul32x32_64(this.h2, this.r2) + mul32x32_64(this.h3, this.r1) + mul32x32_64(this.h4, this.r0);
        int i5 = ((int) jMul32x32_64) & 67108863;
        this.h0 = i5;
        long j = jMul32x32_642 + (jMul32x32_64 >>> 26);
        this.h1 = ((int) j) & 67108863;
        long j2 = jMul32x32_643 + ((j >>> 26) & (-1));
        this.h2 = ((int) j2) & 67108863;
        long j3 = jMul32x32_644 + ((j2 >>> 26) & (-1));
        this.h3 = ((int) j3) & 67108863;
        long j4 = jMul32x32_645 + (j3 >>> 26);
        this.h4 = ((int) j4) & 67108863;
        this.h0 = (int) (i5 + ((j4 >>> 26) * 5));
    }

    private void setKey(byte[] bArr, byte[] bArr2) throws IllegalStateException, DataLengthException, IllegalArgumentException {
        if (bArr2.length != 16) {
            throw new IllegalArgumentException("Poly1305 requires a 128 bit IV.");
        }
        Poly1305KeyGenerator.checkKey(bArr);
        int iLittleEndianToInt = Pack.littleEndianToInt(bArr, 16);
        int iLittleEndianToInt2 = Pack.littleEndianToInt(bArr, 20);
        int iLittleEndianToInt3 = Pack.littleEndianToInt(bArr, 24);
        int iLittleEndianToInt4 = Pack.littleEndianToInt(bArr, 28);
        this.r0 = 67108863 & iLittleEndianToInt;
        int i = ((iLittleEndianToInt >>> 26) | (iLittleEndianToInt2 << 6)) & 67108611;
        this.r1 = i;
        int i2 = ((iLittleEndianToInt2 >>> 20) | (iLittleEndianToInt3 << 12)) & 67092735;
        this.r2 = i2;
        int i3 = ((iLittleEndianToInt3 >>> 14) | (iLittleEndianToInt4 << 18)) & 66076671;
        this.r3 = i3;
        int i4 = (iLittleEndianToInt4 >>> 8) & 1048575;
        this.r4 = i4;
        this.s1 = i * 5;
        this.s2 = i2 * 5;
        this.s3 = i3 * 5;
        this.s4 = i4 * 5;
        byte[] bArr3 = new byte[16];
        System.arraycopy(bArr, 0, bArr3, 0, 16);
        this.cipher.init(true, new KeyParameter(bArr3));
        this.cipher.processBlock(bArr2, 0, bArr3, 0);
        this.k0 = Pack.littleEndianToInt(bArr3, 0);
        this.k1 = Pack.littleEndianToInt(bArr3, 4);
        this.k2 = Pack.littleEndianToInt(bArr3, 8);
        this.k3 = Pack.littleEndianToInt(bArr3, 12);
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i) throws IllegalStateException, DataLengthException {
        if (i + 16 > bArr.length) {
            throw new DataLengthException("Output buffer is too short.");
        }
        if (this.currentBlockOffset > 0) {
            processBlock();
        }
        int i2 = this.h0;
        int i3 = i2 >>> 26;
        int i4 = i2 & 67108863;
        this.h0 = i4;
        int i5 = this.h1 + i3;
        this.h1 = i5;
        int i6 = i5 >>> 26;
        int i7 = i5 & 67108863;
        this.h1 = i7;
        int i8 = this.h2 + i6;
        this.h2 = i8;
        int i9 = i8 >>> 26;
        int i10 = i8 & 67108863;
        this.h2 = i10;
        int i11 = this.h3 + i9;
        this.h3 = i11;
        int i12 = i11 >>> 26;
        int i13 = i11 & 67108863;
        this.h3 = i13;
        int i14 = this.h4 + i12;
        this.h4 = i14;
        int i15 = i14 >>> 26;
        int i16 = i14 & 67108863;
        this.h4 = i16;
        int i17 = i4 + (i15 * 5);
        this.h0 = i17;
        int i18 = i17 + 5;
        int i19 = (i18 >>> 26) + i7;
        int i20 = (i19 >>> 26) + i10;
        int i21 = (i20 >>> 26) + i13;
        int i22 = 67108863 & i21;
        int i23 = ((i21 >>> 26) + i16) - AudioRoutingController.DEVICE_OUT_USB_HEADSET;
        int i24 = (i23 >>> 31) - 1;
        int i25 = ~i24;
        this.h0 = (i17 & i25) | (i18 & 67108863 & i24);
        this.h1 = (i7 & i25) | (i19 & 67108863 & i24);
        this.h2 = (i10 & i25) | (i20 & 67108863 & i24);
        this.h3 = (i22 & i24) | (i13 & i25);
        this.h4 = (i16 & i25) | (i23 & i24);
        long j = ((r0 | (r1 << 26)) & UnsignedInts.INT_MASK) + (this.k0 & UnsignedInts.INT_MASK);
        long j2 = (((r1 >>> 6) | (r3 << 20)) & UnsignedInts.INT_MASK) + (this.k1 & UnsignedInts.INT_MASK);
        long j3 = (((r3 >>> 12) | (r2 << 14)) & UnsignedInts.INT_MASK) + (this.k2 & UnsignedInts.INT_MASK);
        long j4 = (((r2 >>> 18) | (r4 << 8)) & UnsignedInts.INT_MASK) + (UnsignedInts.INT_MASK & this.k3);
        Pack.intToLittleEndian((int) j, bArr, i);
        long j5 = j2 + (j >>> 32);
        Pack.intToLittleEndian((int) j5, bArr, i + 4);
        long j6 = j3 + (j5 >>> 32);
        Pack.intToLittleEndian((int) j6, bArr, i + 8);
        Pack.intToLittleEndian((int) (j4 + (j6 >>> 32)), bArr, i + 12);
        reset();
        return 16;
    }

    @Override // org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        return "Poly1305-" + this.cipher.getAlgorithmName();
    }

    @Override // org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) throws IllegalStateException, DataLengthException, IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            if (parametersWithIV.getParameters() instanceof KeyParameter) {
                setKey(((KeyParameter) parametersWithIV.getParameters()).getKey(), parametersWithIV.getIV());
                reset();
                return;
            }
        }
        throw new IllegalArgumentException("Poly1305 requires a key and and IV.");
    }

    @Override // org.bouncycastle.crypto.Mac
    public void reset() {
        this.currentBlockOffset = 0;
        this.h4 = 0;
        this.h3 = 0;
        this.h2 = 0;
        this.h1 = 0;
        this.h0 = 0;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte b) throws IllegalStateException, DataLengthException {
        byte[] bArr = this.singleByte;
        bArr[0] = b;
        update(bArr, 0, 1);
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte[] bArr, int i, int i2) throws IllegalStateException, DataLengthException {
        int i3 = 0;
        while (i2 > i3) {
            if (this.currentBlockOffset == 16) {
                processBlock();
                this.currentBlockOffset = 0;
            }
            int iMin = Math.min(i2 - i3, 16 - this.currentBlockOffset);
            System.arraycopy(bArr, i3 + i, this.currentBlock, this.currentBlockOffset, iMin);
            i3 += iMin;
            this.currentBlockOffset += iMin;
        }
    }
}
