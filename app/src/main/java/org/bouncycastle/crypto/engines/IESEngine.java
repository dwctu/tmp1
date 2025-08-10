package org.bouncycastle.crypto.engines;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.EphemeralKeyPair;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.KeyParser;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.generators.EphemeralKeyPairGenerator;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.IESParameters;
import org.bouncycastle.crypto.params.IESWithCipherParameters;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.util.Pack;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

/* loaded from: classes5.dex */
public class IESEngine {
    public byte[] V;
    public BasicAgreement agree;
    public BufferedBlockCipher cipher;
    public boolean forEncryption;
    public DerivationFunction kdf;
    private EphemeralKeyPairGenerator keyPairGenerator;
    private KeyParser keyParser;
    public Mac mac;
    public byte[] macBuf;
    public IESParameters param;
    public CipherParameters privParam;
    public CipherParameters pubParam;

    public IESEngine(BasicAgreement basicAgreement, DerivationFunction derivationFunction, Mac mac) {
        this.agree = basicAgreement;
        this.kdf = derivationFunction;
        this.mac = mac;
        this.macBuf = new byte[mac.getMacSize()];
        this.cipher = null;
    }

    public IESEngine(BasicAgreement basicAgreement, DerivationFunction derivationFunction, Mac mac, BufferedBlockCipher bufferedBlockCipher) {
        this.agree = basicAgreement;
        this.kdf = derivationFunction;
        this.mac = mac;
        this.macBuf = new byte[mac.getMacSize()];
        this.cipher = bufferedBlockCipher;
    }

    private byte[] decryptBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException, IllegalStateException, DataLengthException, IllegalArgumentException {
        byte[] bArr2;
        byte[] bArr3;
        int iDoFinal;
        if (this.cipher == null) {
            iDoFinal = (i2 - this.V.length) - this.mac.getMacSize();
            byte[] bArr4 = new byte[iDoFinal];
            int macKeySize = this.param.getMacKeySize() / 8;
            bArr2 = new byte[macKeySize];
            int i3 = iDoFinal + macKeySize;
            byte[] bArr5 = new byte[i3];
            this.kdf.generateBytes(bArr5, 0, i3);
            if (this.V.length != 0) {
                System.arraycopy(bArr5, 0, bArr2, 0, macKeySize);
                System.arraycopy(bArr5, macKeySize, bArr4, 0, iDoFinal);
            } else {
                System.arraycopy(bArr5, 0, bArr4, 0, iDoFinal);
                System.arraycopy(bArr5, iDoFinal, bArr2, 0, macKeySize);
            }
            bArr3 = new byte[iDoFinal];
            for (int i4 = 0; i4 != iDoFinal; i4++) {
                bArr3[i4] = (byte) (bArr[(this.V.length + i) + i4] ^ bArr4[i4]);
            }
        } else {
            int cipherKeySize = ((IESWithCipherParameters) this.param).getCipherKeySize() / 8;
            byte[] bArr6 = new byte[cipherKeySize];
            int macKeySize2 = this.param.getMacKeySize() / 8;
            bArr2 = new byte[macKeySize2];
            int i5 = cipherKeySize + macKeySize2;
            byte[] bArr7 = new byte[i5];
            this.kdf.generateBytes(bArr7, 0, i5);
            System.arraycopy(bArr7, 0, bArr6, 0, cipherKeySize);
            System.arraycopy(bArr7, cipherKeySize, bArr2, 0, macKeySize2);
            this.cipher.init(false, new KeyParameter(bArr6));
            bArr3 = new byte[this.cipher.getOutputSize((i2 - this.V.length) - this.mac.getMacSize())];
            BufferedBlockCipher bufferedBlockCipher = this.cipher;
            byte[] bArr8 = this.V;
            int iProcessBytes = bufferedBlockCipher.processBytes(bArr, i + bArr8.length, (i2 - bArr8.length) - this.mac.getMacSize(), bArr3, 0);
            iDoFinal = iProcessBytes + this.cipher.doFinal(bArr3, iProcessBytes);
        }
        byte[] encodingV = this.param.getEncodingV();
        byte[] bArr9 = new byte[4];
        if (this.V.length != 0 && encodingV != null) {
            Pack.intToBigEndian(encodingV.length * 8, bArr9, 0);
        }
        int i6 = i + i2;
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i6 - this.mac.getMacSize(), i6);
        int length = bArrCopyOfRange.length;
        byte[] bArr10 = new byte[length];
        this.mac.init(new KeyParameter(bArr2));
        Mac mac = this.mac;
        byte[] bArr11 = this.V;
        mac.update(bArr, i + bArr11.length, (i2 - bArr11.length) - length);
        if (encodingV != null) {
            this.mac.update(encodingV, 0, encodingV.length);
        }
        if (this.V.length != 0) {
            this.mac.update(bArr9, 0, 4);
        }
        this.mac.doFinal(bArr10, 0);
        if (Arrays.constantTimeAreEqual(bArrCopyOfRange, bArr10)) {
            return Arrays.copyOfRange(bArr3, 0, iDoFinal);
        }
        throw new InvalidCipherTextException("Invalid MAC.");
    }

    private byte[] encryptBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException, IllegalStateException, DataLengthException, IllegalArgumentException {
        byte[] bArr2;
        byte[] bArr3;
        if (this.cipher == null) {
            byte[] bArr4 = new byte[i2];
            int macKeySize = this.param.getMacKeySize() / 8;
            bArr3 = new byte[macKeySize];
            int i3 = i2 + macKeySize;
            byte[] bArr5 = new byte[i3];
            this.kdf.generateBytes(bArr5, 0, i3);
            if (this.V.length != 0) {
                System.arraycopy(bArr5, 0, bArr3, 0, macKeySize);
                System.arraycopy(bArr5, macKeySize, bArr4, 0, i2);
            } else {
                System.arraycopy(bArr5, 0, bArr4, 0, i2);
                System.arraycopy(bArr5, i2, bArr3, 0, macKeySize);
            }
            bArr2 = new byte[i2];
            for (int i4 = 0; i4 != i2; i4++) {
                bArr2[i4] = (byte) (bArr[i + i4] ^ bArr4[i4]);
            }
        } else {
            int cipherKeySize = ((IESWithCipherParameters) this.param).getCipherKeySize() / 8;
            byte[] bArr6 = new byte[cipherKeySize];
            int macKeySize2 = this.param.getMacKeySize() / 8;
            byte[] bArr7 = new byte[macKeySize2];
            int i5 = cipherKeySize + macKeySize2;
            byte[] bArr8 = new byte[i5];
            this.kdf.generateBytes(bArr8, 0, i5);
            System.arraycopy(bArr8, 0, bArr6, 0, cipherKeySize);
            System.arraycopy(bArr8, cipherKeySize, bArr7, 0, macKeySize2);
            this.cipher.init(true, new KeyParameter(bArr6));
            bArr2 = new byte[this.cipher.getOutputSize(i2)];
            int iProcessBytes = this.cipher.processBytes(bArr, i, i2, bArr2, 0);
            i2 = iProcessBytes + this.cipher.doFinal(bArr2, iProcessBytes);
            bArr3 = bArr7;
        }
        byte[] encodingV = this.param.getEncodingV();
        byte[] bArr9 = new byte[4];
        if (this.V.length != 0 && encodingV != null) {
            Pack.intToBigEndian(encodingV.length * 8, bArr9, 0);
        }
        int macSize = this.mac.getMacSize();
        byte[] bArr10 = new byte[macSize];
        this.mac.init(new KeyParameter(bArr3));
        this.mac.update(bArr2, 0, bArr2.length);
        if (encodingV != null) {
            this.mac.update(encodingV, 0, encodingV.length);
        }
        if (this.V.length != 0) {
            this.mac.update(bArr9, 0, 4);
        }
        this.mac.doFinal(bArr10, 0);
        byte[] bArr11 = this.V;
        byte[] bArr12 = new byte[bArr11.length + i2 + macSize];
        System.arraycopy(bArr11, 0, bArr12, 0, bArr11.length);
        System.arraycopy(bArr2, 0, bArr12, this.V.length, i2);
        System.arraycopy(bArr10, 0, bArr12, this.V.length + i2, macSize);
        return bArr12;
    }

    public BufferedBlockCipher getCipher() {
        return this.cipher;
    }

    public Mac getMac() {
        return this.mac;
    }

    public void init(AsymmetricKeyParameter asymmetricKeyParameter, CipherParameters cipherParameters, KeyParser keyParser) {
        this.forEncryption = false;
        this.privParam = asymmetricKeyParameter;
        this.param = (IESParameters) cipherParameters;
        this.keyParser = keyParser;
    }

    public void init(AsymmetricKeyParameter asymmetricKeyParameter, CipherParameters cipherParameters, EphemeralKeyPairGenerator ephemeralKeyPairGenerator) {
        this.forEncryption = true;
        this.pubParam = asymmetricKeyParameter;
        this.param = (IESParameters) cipherParameters;
        this.keyPairGenerator = ephemeralKeyPairGenerator;
    }

    public void init(boolean z, CipherParameters cipherParameters, CipherParameters cipherParameters2, CipherParameters cipherParameters3) {
        this.forEncryption = z;
        this.privParam = cipherParameters;
        this.pubParam = cipherParameters2;
        this.param = (IESParameters) cipherParameters3;
        this.V = new byte[0];
    }

    public byte[] processBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        if (this.forEncryption) {
            EphemeralKeyPairGenerator ephemeralKeyPairGenerator = this.keyPairGenerator;
            if (ephemeralKeyPairGenerator != null) {
                EphemeralKeyPair ephemeralKeyPairGenerate = ephemeralKeyPairGenerator.generate();
                this.privParam = ephemeralKeyPairGenerate.getKeyPair().getPrivate();
                this.V = ephemeralKeyPairGenerate.getEncodedPublicKey();
            }
        } else if (this.keyParser != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
            try {
                this.pubParam = this.keyParser.readKey(byteArrayInputStream);
                this.V = Arrays.copyOfRange(bArr, i, (i2 - byteArrayInputStream.available()) + i);
            } catch (IOException e) {
                throw new InvalidCipherTextException("unable to recover ephemeral public key: " + e.getMessage(), e);
            }
        }
        this.agree.init(this.privParam);
        byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(this.agree.getFieldSize(), this.agree.calculateAgreement(this.pubParam));
        byte[] bArr2 = this.V;
        if (bArr2.length != 0) {
            byte[] bArr3 = new byte[bArr2.length + bArrAsUnsignedByteArray.length];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            System.arraycopy(bArrAsUnsignedByteArray, 0, bArr3, this.V.length, bArrAsUnsignedByteArray.length);
            bArrAsUnsignedByteArray = bArr3;
        }
        this.kdf.init(new KDFParameters(bArrAsUnsignedByteArray, this.param.getDerivationV()));
        return this.forEncryption ? encryptBlock(bArr, i, i2) : decryptBlock(bArr, i, i2);
    }
}
