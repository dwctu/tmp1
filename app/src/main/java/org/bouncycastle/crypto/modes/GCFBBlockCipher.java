package org.bouncycastle.crypto.modes;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Ascii;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.ParametersWithSBox;

/* loaded from: classes5.dex */
public class GCFBBlockCipher implements BlockCipher {
    private static final byte[] C = {105, 0, 114, 34, 100, -55, 4, 35, -115, 58, -37, -106, 70, -23, ExifInterface.START_CODE, -60, Ascii.CAN, -2, -84, -108, 0, -19, 7, Ascii.DC2, -64, -122, -36, -62, -17, 76, -87, 43};
    private final CFBBlockCipher cfbEngine;
    private long counter = 0;
    private boolean forEncryption;
    private KeyParameter key;

    public GCFBBlockCipher(BlockCipher blockCipher) {
        this.cfbEngine = new CFBBlockCipher(blockCipher, blockCipher.getBlockSize() * 8);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "G" + this.cfbEngine.getAlgorithmName();
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.cfbEngine.getBlockSize();
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.counter = 0L;
        this.cfbEngine.init(z, cipherParameters);
        this.forEncryption = z;
        if (cipherParameters instanceof ParametersWithIV) {
            cipherParameters = ((ParametersWithIV) cipherParameters).getParameters();
        }
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        if (cipherParameters instanceof ParametersWithSBox) {
            cipherParameters = ((ParametersWithSBox) cipherParameters).getParameters();
        }
        this.key = (KeyParameter) cipherParameters;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws IllegalStateException, DataLengthException, IllegalArgumentException {
        long j = this.counter;
        if (j > 0 && j % 1024 == 0) {
            BlockCipher underlyingCipher = this.cfbEngine.getUnderlyingCipher();
            underlyingCipher.init(false, this.key);
            byte[] bArr3 = new byte[32];
            byte[] bArr4 = C;
            underlyingCipher.processBlock(bArr4, 0, bArr3, 0);
            underlyingCipher.processBlock(bArr4, 8, bArr3, 8);
            underlyingCipher.processBlock(bArr4, 16, bArr3, 16);
            underlyingCipher.processBlock(bArr4, 24, bArr3, 24);
            KeyParameter keyParameter = new KeyParameter(bArr3);
            this.key = keyParameter;
            byte[] bArr5 = new byte[8];
            underlyingCipher.init(true, keyParameter);
            underlyingCipher.processBlock(this.cfbEngine.getCurrentIV(), 0, bArr5, 0);
            this.cfbEngine.init(this.forEncryption, new ParametersWithIV(this.key, bArr5));
        }
        this.counter += this.cfbEngine.getBlockSize();
        return this.cfbEngine.processBlock(bArr, i, bArr2, i2);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
        this.counter = 0L;
        this.cfbEngine.reset();
    }
}
