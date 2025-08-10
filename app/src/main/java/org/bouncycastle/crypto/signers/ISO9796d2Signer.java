package org.bouncycastle.crypto.signers;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Hashtable;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.SignerWithRecovery;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;

/* loaded from: classes5.dex */
public class ISO9796d2Signer implements SignerWithRecovery {
    public static final int TRAILER_IMPLICIT = 188;
    public static final int TRAILER_RIPEMD128 = 13004;
    public static final int TRAILER_RIPEMD160 = 12748;
    public static final int TRAILER_SHA1 = 13260;
    public static final int TRAILER_SHA256 = 13516;
    public static final int TRAILER_SHA384 = 14028;
    public static final int TRAILER_SHA512 = 13772;
    public static final int TRAILER_WHIRLPOOL = 14284;
    private static Hashtable trailerMap;
    private byte[] block;
    private AsymmetricBlockCipher cipher;
    private Digest digest;
    private boolean fullMessage;
    private int keyBits;
    private byte[] mBuf;
    private int messageLength;
    private byte[] preBlock;
    private byte[] preSig;
    private byte[] recoveredMessage;
    private int trailer;

    static {
        Hashtable hashtable = new Hashtable();
        trailerMap = hashtable;
        hashtable.put("RIPEMD128", Integers.valueOf(13004));
        trailerMap.put("RIPEMD160", Integers.valueOf(12748));
        trailerMap.put("SHA-1", Integers.valueOf(13260));
        trailerMap.put(MessageDigestAlgorithms.SHA_256, Integers.valueOf(13516));
        trailerMap.put(MessageDigestAlgorithms.SHA_384, Integers.valueOf(14028));
        trailerMap.put(MessageDigestAlgorithms.SHA_512, Integers.valueOf(13772));
        trailerMap.put("Whirlpool", Integers.valueOf(14284));
    }

    public ISO9796d2Signer(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest) {
        this(asymmetricBlockCipher, digest, false);
    }

    public ISO9796d2Signer(AsymmetricBlockCipher asymmetricBlockCipher, Digest digest, boolean z) {
        int iIntValue;
        this.cipher = asymmetricBlockCipher;
        this.digest = digest;
        if (z) {
            iIntValue = 188;
        } else {
            Integer num = (Integer) trailerMap.get(digest.getAlgorithmName());
            if (num == null) {
                throw new IllegalArgumentException("no valid trailer for digest");
            }
            iIntValue = num.intValue();
        }
        this.trailer = iIntValue;
    }

    private void clearBlock(byte[] bArr) {
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = 0;
        }
    }

    private boolean isSameAs(byte[] bArr, byte[] bArr2) {
        boolean z;
        int i = this.messageLength;
        byte[] bArr3 = this.mBuf;
        if (i > bArr3.length) {
            z = bArr3.length <= bArr2.length;
            for (int i2 = 0; i2 != this.mBuf.length; i2++) {
                if (bArr[i2] != bArr2[i2]) {
                    z = false;
                }
            }
        } else {
            z = i == bArr2.length;
            for (int i3 = 0; i3 != bArr2.length; i3++) {
                if (bArr[i3] != bArr2[i3]) {
                    z = false;
                }
            }
        }
        return z;
    }

    private boolean returnFalse(byte[] bArr) {
        clearBlock(this.mBuf);
        clearBlock(bArr);
        return false;
    }

    @Override // org.bouncycastle.crypto.Signer
    public byte[] generateSignature() throws CryptoException {
        int i;
        int length;
        byte b;
        int i2;
        int digestSize = this.digest.getDigestSize();
        if (this.trailer == 188) {
            byte[] bArr = this.block;
            length = (bArr.length - digestSize) - 1;
            this.digest.doFinal(bArr, length);
            this.block[r1.length - 1] = PSSSigner.TRAILER_IMPLICIT;
            i = 8;
        } else {
            i = 16;
            byte[] bArr2 = this.block;
            int length2 = (bArr2.length - digestSize) - 2;
            this.digest.doFinal(bArr2, length2);
            byte[] bArr3 = this.block;
            int length3 = bArr3.length - 2;
            int i3 = this.trailer;
            bArr3[length3] = (byte) (i3 >>> 8);
            bArr3[bArr3.length - 1] = (byte) i3;
            length = length2;
        }
        int i4 = this.messageLength;
        int i5 = ((((digestSize + i4) * 8) + i) + 4) - this.keyBits;
        if (i5 > 0) {
            int i6 = i4 - ((i5 + 7) / 8);
            b = 96;
            i2 = length - i6;
            System.arraycopy(this.mBuf, 0, this.block, i2, i6);
        } else {
            b = SignedBytes.MAX_POWER_OF_TWO;
            i2 = length - i4;
            System.arraycopy(this.mBuf, 0, this.block, i2, i4);
        }
        int i7 = i2 - 1;
        if (i7 > 0) {
            for (int i8 = i7; i8 != 0; i8--) {
                this.block[i8] = -69;
            }
            byte[] bArr4 = this.block;
            bArr4[i7] = (byte) (bArr4[i7] ^ 1);
            bArr4[0] = 11;
            bArr4[0] = (byte) (b | bArr4[0]);
        } else {
            byte[] bArr5 = this.block;
            bArr5[0] = 10;
            bArr5[0] = (byte) (b | bArr5[0]);
        }
        AsymmetricBlockCipher asymmetricBlockCipher = this.cipher;
        byte[] bArr6 = this.block;
        byte[] bArrProcessBlock = asymmetricBlockCipher.processBlock(bArr6, 0, bArr6.length);
        clearBlock(this.mBuf);
        clearBlock(this.block);
        return bArrProcessBlock;
    }

    @Override // org.bouncycastle.crypto.SignerWithRecovery
    public byte[] getRecoveredMessage() {
        return this.recoveredMessage;
    }

    @Override // org.bouncycastle.crypto.SignerWithRecovery
    public boolean hasFullMessage() {
        return this.fullMessage;
    }

    @Override // org.bouncycastle.crypto.Signer
    public void init(boolean z, CipherParameters cipherParameters) {
        RSAKeyParameters rSAKeyParameters = (RSAKeyParameters) cipherParameters;
        this.cipher.init(z, rSAKeyParameters);
        int iBitLength = rSAKeyParameters.getModulus().bitLength();
        this.keyBits = iBitLength;
        byte[] bArr = new byte[(iBitLength + 7) / 8];
        this.block = bArr;
        int i = this.trailer;
        int length = bArr.length;
        if (i == 188) {
            this.mBuf = new byte[(length - this.digest.getDigestSize()) - 2];
        } else {
            this.mBuf = new byte[(length - this.digest.getDigestSize()) - 3];
        }
        reset();
    }

    @Override // org.bouncycastle.crypto.Signer
    public void reset() {
        this.digest.reset();
        this.messageLength = 0;
        clearBlock(this.mBuf);
        byte[] bArr = this.recoveredMessage;
        if (bArr != null) {
            clearBlock(bArr);
        }
        this.recoveredMessage = null;
        this.fullMessage = false;
        if (this.preSig != null) {
            this.preSig = null;
            clearBlock(this.preBlock);
            this.preBlock = null;
        }
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte b) {
        this.digest.update(b);
        int i = this.messageLength;
        byte[] bArr = this.mBuf;
        if (i < bArr.length) {
            bArr[i] = b;
        }
        this.messageLength = i + 1;
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte[] bArr, int i, int i2) {
        while (i2 > 0 && this.messageLength < this.mBuf.length) {
            update(bArr[i]);
            i++;
            i2--;
        }
        this.digest.update(bArr, i, i2);
        this.messageLength += i2;
    }

    @Override // org.bouncycastle.crypto.SignerWithRecovery
    public void updateWithRecoveredMessage(byte[] bArr) throws InvalidCipherTextException {
        byte[] bArrProcessBlock = this.cipher.processBlock(bArr, 0, bArr.length);
        if (((bArrProcessBlock[0] & 192) ^ 64) != 0) {
            throw new InvalidCipherTextException("malformed signature");
        }
        if (((bArrProcessBlock[bArrProcessBlock.length - 1] & Ascii.SI) ^ 12) != 0) {
            throw new InvalidCipherTextException("malformed signature");
        }
        int i = 2;
        if (((bArrProcessBlock[bArrProcessBlock.length - 1] & 255) ^ 188) == 0) {
            i = 1;
        } else {
            int i2 = ((bArrProcessBlock[bArrProcessBlock.length - 2] & 255) << 8) | (bArrProcessBlock[bArrProcessBlock.length - 1] & 255);
            Integer num = (Integer) trailerMap.get(this.digest.getAlgorithmName());
            if (num == null) {
                throw new IllegalArgumentException("unrecognised hash in signature");
            }
            if (i2 != num.intValue()) {
                throw new IllegalStateException("signer initialised with wrong digest for trailer " + i2);
            }
        }
        int i3 = 0;
        while (i3 != bArrProcessBlock.length && ((bArrProcessBlock[i3] & Ascii.SI) ^ 10) != 0) {
            i3++;
        }
        int i4 = i3 + 1;
        int length = ((bArrProcessBlock.length - i) - this.digest.getDigestSize()) - i4;
        if (length <= 0) {
            throw new InvalidCipherTextException("malformed block");
        }
        if ((bArrProcessBlock[0] & 32) == 0) {
            this.fullMessage = true;
            byte[] bArr2 = new byte[length];
            this.recoveredMessage = bArr2;
            System.arraycopy(bArrProcessBlock, i4, bArr2, 0, bArr2.length);
        } else {
            this.fullMessage = false;
            byte[] bArr3 = new byte[length];
            this.recoveredMessage = bArr3;
            System.arraycopy(bArrProcessBlock, i4, bArr3, 0, bArr3.length);
        }
        this.preSig = bArr;
        this.preBlock = bArrProcessBlock;
        Digest digest = this.digest;
        byte[] bArr4 = this.recoveredMessage;
        digest.update(bArr4, 0, bArr4.length);
        byte[] bArr5 = this.recoveredMessage;
        this.messageLength = bArr5.length;
        System.arraycopy(bArr5, 0, this.mBuf, 0, bArr5.length);
    }

    @Override // org.bouncycastle.crypto.Signer
    public boolean verifySignature(byte[] bArr) {
        byte[] bArrProcessBlock;
        byte[] bArr2 = this.preSig;
        if (bArr2 == null) {
            try {
                bArrProcessBlock = this.cipher.processBlock(bArr, 0, bArr.length);
            } catch (Exception unused) {
                return false;
            }
        } else {
            if (!Arrays.areEqual(bArr2, bArr)) {
                throw new IllegalStateException("updateWithRecoveredMessage called on different signature");
            }
            bArrProcessBlock = this.preBlock;
            this.preSig = null;
            this.preBlock = null;
        }
        if (((bArrProcessBlock[0] & 192) ^ 64) == 0 && ((bArrProcessBlock[bArrProcessBlock.length - 1] & Ascii.SI) ^ 12) == 0) {
            int i = 2;
            if (((bArrProcessBlock[bArrProcessBlock.length - 1] & 255) ^ 188) == 0) {
                i = 1;
            } else {
                int i2 = ((bArrProcessBlock[bArrProcessBlock.length - 2] & 255) << 8) | (bArrProcessBlock[bArrProcessBlock.length - 1] & 255);
                Integer num = (Integer) trailerMap.get(this.digest.getAlgorithmName());
                if (num == null) {
                    throw new IllegalArgumentException("unrecognised hash in signature");
                }
                if (i2 != num.intValue()) {
                    throw new IllegalStateException("signer initialised with wrong digest for trailer " + i2);
                }
            }
            int i3 = 0;
            while (i3 != bArrProcessBlock.length && ((bArrProcessBlock[i3] & Ascii.SI) ^ 10) != 0) {
                i3++;
            }
            int i4 = i3 + 1;
            int digestSize = this.digest.getDigestSize();
            byte[] bArr3 = new byte[digestSize];
            int length = (bArrProcessBlock.length - i) - digestSize;
            int i5 = length - i4;
            if (i5 <= 0) {
                return returnFalse(bArrProcessBlock);
            }
            if ((bArrProcessBlock[0] & 32) == 0) {
                this.fullMessage = true;
                if (this.messageLength > i5) {
                    return returnFalse(bArrProcessBlock);
                }
                this.digest.reset();
                this.digest.update(bArrProcessBlock, i4, i5);
                this.digest.doFinal(bArr3, 0);
                boolean z = true;
                for (int i6 = 0; i6 != digestSize; i6++) {
                    int i7 = length + i6;
                    bArrProcessBlock[i7] = (byte) (bArrProcessBlock[i7] ^ bArr3[i6]);
                    if (bArrProcessBlock[i7] != 0) {
                        z = false;
                    }
                }
                if (!z) {
                    return returnFalse(bArrProcessBlock);
                }
                byte[] bArr4 = new byte[i5];
                this.recoveredMessage = bArr4;
                System.arraycopy(bArrProcessBlock, i4, bArr4, 0, bArr4.length);
            } else {
                this.fullMessage = false;
                this.digest.doFinal(bArr3, 0);
                boolean z2 = true;
                for (int i8 = 0; i8 != digestSize; i8++) {
                    int i9 = length + i8;
                    bArrProcessBlock[i9] = (byte) (bArrProcessBlock[i9] ^ bArr3[i8]);
                    if (bArrProcessBlock[i9] != 0) {
                        z2 = false;
                    }
                }
                if (!z2) {
                    return returnFalse(bArrProcessBlock);
                }
                byte[] bArr5 = new byte[i5];
                this.recoveredMessage = bArr5;
                System.arraycopy(bArrProcessBlock, i4, bArr5, 0, bArr5.length);
            }
            if (this.messageLength != 0 && !isSameAs(this.mBuf, this.recoveredMessage)) {
                return returnFalse(bArrProcessBlock);
            }
            clearBlock(this.mBuf);
            clearBlock(bArrProcessBlock);
            return true;
        }
        return returnFalse(bArrProcessBlock);
    }
}
