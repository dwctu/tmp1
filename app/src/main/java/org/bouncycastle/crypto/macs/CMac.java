package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.ISO7816d4Padding;
import org.bouncycastle.crypto.params.KeyParameter;

/* loaded from: classes5.dex */
public class CMac implements Mac {
    private static final byte CONSTANT_128 = -121;
    private static final byte CONSTANT_64 = 27;
    private byte[] L;
    private byte[] Lu;
    private byte[] Lu2;
    private byte[] ZEROES;
    private byte[] buf;
    private int bufOff;
    private BlockCipher cipher;
    private byte[] mac;
    private int macSize;

    public CMac(BlockCipher blockCipher) {
        this(blockCipher, blockCipher.getBlockSize() * 8);
    }

    public CMac(BlockCipher blockCipher, int i) {
        if (i % 8 != 0) {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        }
        if (i > blockCipher.getBlockSize() * 8) {
            throw new IllegalArgumentException("MAC size must be less or equal to " + (blockCipher.getBlockSize() * 8));
        }
        if (blockCipher.getBlockSize() != 8 && blockCipher.getBlockSize() != 16) {
            throw new IllegalArgumentException("Block size must be either 64 or 128 bits");
        }
        this.cipher = new CBCBlockCipher(blockCipher);
        this.macSize = i / 8;
        this.mac = new byte[blockCipher.getBlockSize()];
        this.buf = new byte[blockCipher.getBlockSize()];
        this.ZEROES = new byte[blockCipher.getBlockSize()];
        this.bufOff = 0;
    }

    private static byte[] doubleLu(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int iShiftLeft = shiftLeft(bArr, bArr2);
        int i = bArr.length == 16 ? -121 : 27;
        int length = bArr.length - 1;
        bArr2[length] = (byte) (((i & 255) >>> ((1 - iShiftLeft) << 3)) ^ bArr2[length]);
        return bArr2;
    }

    private static int shiftLeft(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i = 0;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            int i2 = bArr[length] & 255;
            bArr2[length] = (byte) (i | (i2 << 1));
            i = (i2 >>> 7) & 1;
        }
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i) throws IllegalStateException, DataLengthException {
        byte[] bArr2;
        if (this.bufOff == this.cipher.getBlockSize()) {
            bArr2 = this.Lu;
        } else {
            new ISO7816d4Padding().addPadding(this.buf, this.bufOff);
            bArr2 = this.Lu2;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr3 = this.mac;
            if (i2 >= bArr3.length) {
                this.cipher.processBlock(this.buf, 0, bArr3, 0);
                System.arraycopy(this.mac, 0, bArr, i, this.macSize);
                reset();
                return this.macSize;
            }
            byte[] bArr4 = this.buf;
            bArr4[i2] = (byte) (bArr4[i2] ^ bArr2[i2]);
            i2++;
        }
    }

    @Override // org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName();
    }

    @Override // org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return this.macSize;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) throws IllegalStateException, DataLengthException, IllegalArgumentException {
        if (cipherParameters instanceof KeyParameter) {
            this.cipher.init(true, cipherParameters);
            byte[] bArr = this.ZEROES;
            byte[] bArr2 = new byte[bArr.length];
            this.L = bArr2;
            this.cipher.processBlock(bArr, 0, bArr2, 0);
            byte[] bArrDoubleLu = doubleLu(this.L);
            this.Lu = bArrDoubleLu;
            this.Lu2 = doubleLu(bArrDoubleLu);
        } else if (cipherParameters != null) {
            throw new IllegalArgumentException("CMac mode only permits key to be set.");
        }
        reset();
    }

    @Override // org.bouncycastle.crypto.Mac
    public void reset() {
        int i = 0;
        while (true) {
            byte[] bArr = this.buf;
            if (i >= bArr.length) {
                this.bufOff = 0;
                this.cipher.reset();
                return;
            } else {
                bArr[i] = 0;
                i++;
            }
        }
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte b) throws IllegalStateException, DataLengthException {
        int i = this.bufOff;
        byte[] bArr = this.buf;
        if (i == bArr.length) {
            this.cipher.processBlock(bArr, 0, this.mac, 0);
            this.bufOff = 0;
        }
        byte[] bArr2 = this.buf;
        int i2 = this.bufOff;
        this.bufOff = i2 + 1;
        bArr2[i2] = b;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte[] bArr, int i, int i2) throws IllegalStateException, DataLengthException {
        if (i2 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int blockSize = this.cipher.getBlockSize();
        int i3 = this.bufOff;
        int i4 = blockSize - i3;
        if (i2 > i4) {
            System.arraycopy(bArr, i, this.buf, i3, i4);
            this.cipher.processBlock(this.buf, 0, this.mac, 0);
            this.bufOff = 0;
            i2 -= i4;
            i += i4;
            while (i2 > blockSize) {
                this.cipher.processBlock(bArr, i, this.mac, 0);
                i2 -= blockSize;
                i += blockSize;
            }
        }
        System.arraycopy(bArr, i, this.buf, this.bufOff, i2);
        this.bufOff += i2;
    }
}
