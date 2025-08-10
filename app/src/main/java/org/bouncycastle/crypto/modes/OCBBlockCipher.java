package org.bouncycastle.crypto.modes;

import java.util.Vector;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

/* loaded from: classes5.dex */
public class OCBBlockCipher implements AEADBlockCipher {
    private static final int BLOCK_SIZE = 16;
    private byte[] Checksum;
    private Vector L;
    private byte[] L_Asterisk;
    private byte[] L_Dollar;
    private byte[] OffsetHASH;
    private byte[] OffsetMAIN;
    private byte[] OffsetMAIN_0;
    private byte[] Sum;
    private boolean forEncryption;
    private byte[] hashBlock;
    private long hashBlockCount;
    private int hashBlockPos;
    private BlockCipher hashCipher;
    private byte[] initialAssociatedText;
    private byte[] macBlock;
    private int macSize;
    private byte[] mainBlock;
    private long mainBlockCount;
    private int mainBlockPos;
    private BlockCipher mainCipher;

    public OCBBlockCipher(BlockCipher blockCipher, BlockCipher blockCipher2) {
        if (blockCipher == null) {
            throw new IllegalArgumentException("'hashCipher' cannot be null");
        }
        if (blockCipher.getBlockSize() != 16) {
            throw new IllegalArgumentException("'hashCipher' must have a block size of 16");
        }
        if (blockCipher2 == null) {
            throw new IllegalArgumentException("'mainCipher' cannot be null");
        }
        if (blockCipher2.getBlockSize() != 16) {
            throw new IllegalArgumentException("'mainCipher' must have a block size of 16");
        }
        if (!blockCipher.getAlgorithmName().equals(blockCipher2.getAlgorithmName())) {
            throw new IllegalArgumentException("'hashCipher' and 'mainCipher' must be the same algorithm");
        }
        this.hashCipher = blockCipher;
        this.mainCipher = blockCipher2;
    }

    public static byte[] OCB_double(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) ((135 >>> ((1 - shiftLeft(bArr, bArr2)) << 3)) ^ bArr2[15]);
        return bArr2;
    }

    public static void OCB_extend(byte[] bArr, int i) {
        bArr[i] = Byte.MIN_VALUE;
        while (true) {
            i++;
            if (i >= 16) {
                return;
            } else {
                bArr[i] = 0;
            }
        }
    }

    public static int OCB_ntz(long j) {
        if (j == 0) {
            return 64;
        }
        int i = 0;
        while ((1 & j) == 0) {
            i++;
            j >>= 1;
        }
        return i;
    }

    public static int shiftLeft(byte[] bArr, byte[] bArr2) {
        int i = 16;
        int i2 = 0;
        while (true) {
            i--;
            if (i < 0) {
                return i2;
            }
            int i3 = bArr[i] & 255;
            bArr2[i] = (byte) (i2 | (i3 << 1));
            i2 = (i3 >>> 7) & 1;
        }
    }

    public static void xor(byte[] bArr, byte[] bArr2) {
        for (int i = 15; i >= 0; i--) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
    }

    public void clear(byte[] bArr) {
        if (bArr != null) {
            Arrays.fill(bArr, (byte) 0);
        }
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public int doFinal(byte[] bArr, int i) throws InvalidCipherTextException, IllegalStateException, DataLengthException {
        byte[] bArr2;
        if (this.forEncryption) {
            bArr2 = null;
        } else {
            int i2 = this.mainBlockPos;
            int i3 = this.macSize;
            if (i2 < i3) {
                throw new InvalidCipherTextException("data too short");
            }
            int i4 = i2 - i3;
            this.mainBlockPos = i4;
            bArr2 = new byte[i3];
            System.arraycopy(this.mainBlock, i4, bArr2, 0, i3);
        }
        int i5 = this.hashBlockPos;
        if (i5 > 0) {
            OCB_extend(this.hashBlock, i5);
            updateHASH(this.L_Asterisk);
        }
        int i6 = this.mainBlockPos;
        if (i6 > 0) {
            if (this.forEncryption) {
                OCB_extend(this.mainBlock, i6);
                xor(this.Checksum, this.mainBlock);
            }
            xor(this.OffsetMAIN, this.L_Asterisk);
            byte[] bArr3 = new byte[16];
            this.hashCipher.processBlock(this.OffsetMAIN, 0, bArr3, 0);
            xor(this.mainBlock, bArr3);
            System.arraycopy(this.mainBlock, 0, bArr, i, this.mainBlockPos);
            if (!this.forEncryption) {
                OCB_extend(this.mainBlock, this.mainBlockPos);
                xor(this.Checksum, this.mainBlock);
            }
        }
        xor(this.Checksum, this.OffsetMAIN);
        xor(this.Checksum, this.L_Dollar);
        BlockCipher blockCipher = this.hashCipher;
        byte[] bArr4 = this.Checksum;
        blockCipher.processBlock(bArr4, 0, bArr4, 0);
        xor(this.Checksum, this.Sum);
        int i7 = this.macSize;
        byte[] bArr5 = new byte[i7];
        this.macBlock = bArr5;
        System.arraycopy(this.Checksum, 0, bArr5, 0, i7);
        int i8 = this.mainBlockPos;
        if (this.forEncryption) {
            System.arraycopy(this.macBlock, 0, bArr, i + i8, this.macSize);
            i8 += this.macSize;
        } else if (!Arrays.constantTimeAreEqual(this.macBlock, bArr2)) {
            throw new InvalidCipherTextException("mac check in OCB failed");
        }
        reset(false);
        return i8;
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public String getAlgorithmName() {
        return this.mainCipher.getAlgorithmName() + "/OCB";
    }

    public byte[] getLSub(int i) {
        while (i >= this.L.size()) {
            Vector vector = this.L;
            vector.addElement(OCB_double((byte[]) vector.lastElement()));
        }
        return (byte[]) this.L.elementAt(i);
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public byte[] getMac() {
        return Arrays.clone(this.macBlock);
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public int getOutputSize(int i) {
        int i2 = i + this.mainBlockPos;
        if (this.forEncryption) {
            return i2 + this.macSize;
        }
        int i3 = this.macSize;
        if (i2 < i3) {
            return 0;
        }
        return i2 - i3;
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public BlockCipher getUnderlyingCipher() {
        return this.mainCipher;
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public int getUpdateOutputSize(int i) {
        int i2 = i + this.mainBlockPos;
        if (!this.forEncryption) {
            int i3 = this.macSize;
            if (i2 < i3) {
                return 0;
            }
            i2 -= i3;
        }
        return i2 - (i2 % 16);
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalStateException, DataLengthException, IllegalArgumentException {
        KeyParameter key;
        byte[] nonce;
        this.forEncryption = z;
        this.macBlock = null;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            nonce = aEADParameters.getNonce();
            this.initialAssociatedText = aEADParameters.getAssociatedText();
            int macSize = aEADParameters.getMacSize();
            if (macSize < 64 || macSize > 128 || macSize % 8 != 0) {
                throw new IllegalArgumentException("Invalid value for MAC size: " + macSize);
            }
            this.macSize = macSize / 8;
            key = aEADParameters.getKey();
        } else {
            if (!(cipherParameters instanceof ParametersWithIV)) {
                throw new IllegalArgumentException("invalid parameters passed to OCB");
            }
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            this.initialAssociatedText = null;
            this.macSize = 16;
            key = (KeyParameter) parametersWithIV.getParameters();
            nonce = iv;
        }
        this.hashBlock = new byte[16];
        this.mainBlock = new byte[z ? 16 : this.macSize + 16];
        if (nonce == null) {
            nonce = new byte[0];
        }
        if (nonce.length > 15) {
            throw new IllegalArgumentException("IV must be no more than 15 bytes");
        }
        this.hashCipher.init(true, key);
        this.mainCipher.init(z, key);
        byte[] bArr = new byte[16];
        this.L_Asterisk = bArr;
        this.hashCipher.processBlock(bArr, 0, bArr, 0);
        this.L_Dollar = OCB_double(this.L_Asterisk);
        Vector vector = new Vector();
        this.L = vector;
        vector.addElement(OCB_double(this.L_Dollar));
        byte[] bArr2 = new byte[16];
        System.arraycopy(nonce, 0, bArr2, 16 - nonce.length, nonce.length);
        bArr2[0] = (byte) (this.macSize << 4);
        int length = 15 - nonce.length;
        bArr2[length] = (byte) (bArr2[length] | 1);
        int i = bArr2[15] & 63;
        byte[] bArr3 = new byte[16];
        bArr2[15] = (byte) (bArr2[15] & 192);
        this.hashCipher.processBlock(bArr2, 0, bArr3, 0);
        byte[] bArr4 = new byte[24];
        System.arraycopy(bArr3, 0, bArr4, 0, 16);
        int i2 = 0;
        while (i2 < 8) {
            int i3 = i2 + 16;
            byte b = bArr3[i2];
            i2++;
            bArr4[i3] = (byte) (b ^ bArr3[i2]);
        }
        byte[] bArr5 = new byte[16];
        this.OffsetMAIN_0 = bArr5;
        int i4 = i % 8;
        int i5 = i / 8;
        if (i4 == 0) {
            System.arraycopy(bArr4, i5, bArr5, 0, 16);
        } else {
            for (int i6 = 0; i6 < 16; i6++) {
                int i7 = bArr4[i5] & 255;
                i5++;
                this.OffsetMAIN_0[i6] = (byte) ((i7 << i4) | ((bArr4[i5] & 255) >>> (8 - i4)));
            }
        }
        this.hashBlockPos = 0;
        this.mainBlockPos = 0;
        this.hashBlockCount = 0L;
        this.mainBlockCount = 0L;
        this.OffsetHASH = new byte[16];
        this.Sum = new byte[16];
        this.OffsetMAIN = Arrays.clone(this.OffsetMAIN_0);
        this.Checksum = new byte[16];
        byte[] bArr6 = this.initialAssociatedText;
        if (bArr6 != null) {
            processAADBytes(bArr6, 0, bArr6.length);
        }
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public void processAADByte(byte b) throws IllegalStateException, DataLengthException {
        byte[] bArr = this.hashBlock;
        int i = this.hashBlockPos;
        bArr[i] = b;
        int i2 = i + 1;
        this.hashBlockPos = i2;
        if (i2 == bArr.length) {
            processHashBlock();
        }
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public void processAADBytes(byte[] bArr, int i, int i2) throws IllegalStateException, DataLengthException {
        for (int i3 = 0; i3 < i2; i3++) {
            byte[] bArr2 = this.hashBlock;
            int i4 = this.hashBlockPos;
            bArr2[i4] = bArr[i + i3];
            int i5 = i4 + 1;
            this.hashBlockPos = i5;
            if (i5 == bArr2.length) {
                processHashBlock();
            }
        }
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public int processByte(byte b, byte[] bArr, int i) throws IllegalStateException, DataLengthException {
        byte[] bArr2 = this.mainBlock;
        int i2 = this.mainBlockPos;
        bArr2[i2] = b;
        int i3 = i2 + 1;
        this.mainBlockPos = i3;
        if (i3 != bArr2.length) {
            return 0;
        }
        processMainBlock(bArr, i);
        return 16;
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IllegalStateException, DataLengthException {
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            byte[] bArr3 = this.mainBlock;
            int i6 = this.mainBlockPos;
            bArr3[i6] = bArr[i + i5];
            int i7 = i6 + 1;
            this.mainBlockPos = i7;
            if (i7 == bArr3.length) {
                processMainBlock(bArr2, i3 + i4);
                i4 += 16;
            }
        }
        return i4;
    }

    public void processHashBlock() throws IllegalStateException, DataLengthException {
        long j = this.hashBlockCount + 1;
        this.hashBlockCount = j;
        updateHASH(getLSub(OCB_ntz(j)));
        this.hashBlockPos = 0;
    }

    public void processMainBlock(byte[] bArr, int i) throws IllegalStateException, DataLengthException {
        if (this.forEncryption) {
            xor(this.Checksum, this.mainBlock);
            this.mainBlockPos = 0;
        }
        byte[] bArr2 = this.OffsetMAIN;
        long j = this.mainBlockCount + 1;
        this.mainBlockCount = j;
        xor(bArr2, getLSub(OCB_ntz(j)));
        xor(this.mainBlock, this.OffsetMAIN);
        BlockCipher blockCipher = this.mainCipher;
        byte[] bArr3 = this.mainBlock;
        blockCipher.processBlock(bArr3, 0, bArr3, 0);
        xor(this.mainBlock, this.OffsetMAIN);
        System.arraycopy(this.mainBlock, 0, bArr, i, 16);
        if (this.forEncryption) {
            return;
        }
        xor(this.Checksum, this.mainBlock);
        byte[] bArr4 = this.mainBlock;
        System.arraycopy(bArr4, 16, bArr4, 0, this.macSize);
        this.mainBlockPos = this.macSize;
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public void reset() throws IllegalStateException, DataLengthException {
        reset(true);
    }

    public void reset(boolean z) throws IllegalStateException, DataLengthException {
        this.hashCipher.reset();
        this.mainCipher.reset();
        clear(this.hashBlock);
        clear(this.mainBlock);
        this.hashBlockPos = 0;
        this.mainBlockPos = 0;
        this.hashBlockCount = 0L;
        this.mainBlockCount = 0L;
        clear(this.OffsetHASH);
        clear(this.Sum);
        System.arraycopy(this.OffsetMAIN_0, 0, this.OffsetMAIN, 0, 16);
        clear(this.Checksum);
        if (z) {
            this.macBlock = null;
        }
        byte[] bArr = this.initialAssociatedText;
        if (bArr != null) {
            processAADBytes(bArr, 0, bArr.length);
        }
    }

    public void updateHASH(byte[] bArr) throws IllegalStateException, DataLengthException {
        xor(this.OffsetHASH, bArr);
        xor(this.hashBlock, this.OffsetHASH);
        BlockCipher blockCipher = this.hashCipher;
        byte[] bArr2 = this.hashBlock;
        blockCipher.processBlock(bArr2, 0, bArr2, 0);
        xor(this.Sum, this.hashBlock);
    }
}
