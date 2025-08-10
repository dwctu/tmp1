package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* loaded from: classes5.dex */
public class Poly1305KeyGenerator extends CipherKeyGenerator {
    private static final byte R_MASK_HIGH_4 = 15;
    private static final byte R_MASK_LOW_2 = -4;

    public static void checkKey(byte[] bArr) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
        }
        checkMask(bArr[19], (byte) 15);
        checkMask(bArr[23], (byte) 15);
        checkMask(bArr[27], (byte) 15);
        checkMask(bArr[31], (byte) 15);
        checkMask(bArr[20], R_MASK_LOW_2);
        checkMask(bArr[24], R_MASK_LOW_2);
        checkMask(bArr[28], R_MASK_LOW_2);
    }

    private static void checkMask(byte b, byte b2) {
        if ((b & (~b2)) != 0) {
            throw new IllegalArgumentException("Invalid format for r portion of Poly1305 key.");
        }
    }

    public static void clamp(byte[] bArr) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
        }
        bArr[19] = (byte) (bArr[19] & 15);
        bArr[23] = (byte) (bArr[23] & 15);
        bArr[27] = (byte) (bArr[27] & 15);
        bArr[31] = (byte) (bArr[31] & 15);
        bArr[20] = (byte) (bArr[20] & R_MASK_LOW_2);
        bArr[24] = (byte) (bArr[24] & R_MASK_LOW_2);
        bArr[28] = (byte) (bArr[28] & R_MASK_LOW_2);
    }

    @Override // org.bouncycastle.crypto.CipherKeyGenerator
    public byte[] generateKey() {
        byte[] bArrGenerateKey = super.generateKey();
        clamp(bArrGenerateKey);
        return bArrGenerateKey;
    }

    @Override // org.bouncycastle.crypto.CipherKeyGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        super.init(new KeyGenerationParameters(keyGenerationParameters.getRandom(), 256));
    }
}
