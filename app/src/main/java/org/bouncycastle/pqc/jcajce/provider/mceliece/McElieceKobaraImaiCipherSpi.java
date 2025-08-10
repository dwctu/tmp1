package org.bouncycastle.pqc.jcajce.provider.mceliece;

import java.io.ByteArrayOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2KeyParameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceKobaraImaiCipher;
import org.bouncycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher;

/* loaded from: classes5.dex */
public class McElieceKobaraImaiCipherSpi extends AsymmetricHybridCipher implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    private ByteArrayOutputStream buf;
    private McElieceKobaraImaiCipher cipher;
    private Digest digest;

    public static class McElieceKobaraImai extends McElieceKobaraImaiCipherSpi {
        public McElieceKobaraImai() {
            super(new SHA1Digest(), new McElieceKobaraImaiCipher());
        }
    }

    public static class McElieceKobaraImai224 extends McElieceKobaraImaiCipherSpi {
        public McElieceKobaraImai224() {
            super(new SHA224Digest(), new McElieceKobaraImaiCipher());
        }
    }

    public static class McElieceKobaraImai256 extends McElieceKobaraImaiCipherSpi {
        public McElieceKobaraImai256() {
            super(new SHA256Digest(), new McElieceKobaraImaiCipher());
        }
    }

    public static class McElieceKobaraImai384 extends McElieceKobaraImaiCipherSpi {
        public McElieceKobaraImai384() {
            super(new SHA384Digest(), new McElieceKobaraImaiCipher());
        }
    }

    public static class McElieceKobaraImai512 extends McElieceKobaraImaiCipherSpi {
        public McElieceKobaraImai512() {
            super(new SHA512Digest(), new McElieceKobaraImaiCipher());
        }
    }

    public McElieceKobaraImaiCipherSpi() {
        this.buf = new ByteArrayOutputStream();
        this.buf = new ByteArrayOutputStream();
    }

    public McElieceKobaraImaiCipherSpi(Digest digest, McElieceKobaraImaiCipher mcElieceKobaraImaiCipher) {
        this.buf = new ByteArrayOutputStream();
        this.digest = digest;
        this.cipher = mcElieceKobaraImaiCipher;
        this.buf = new ByteArrayOutputStream();
    }

    private byte[] pad() {
        this.buf.write(1);
        byte[] byteArray = this.buf.toByteArray();
        this.buf.reset();
        return byteArray;
    }

    private byte[] unpad(byte[] bArr) throws BadPaddingException {
        int length = bArr.length - 1;
        while (length >= 0 && bArr[length] == 0) {
            length--;
        }
        if (bArr[length] != 1) {
            throw new BadPaddingException("invalid ciphertext");
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher
    public int decryptOutputSize(int i) {
        return 0;
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher, org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public byte[] doFinal(byte[] bArr, int i, int i2) throws BadPaddingException {
        update(bArr, i, i2);
        int i3 = this.opMode;
        try {
            if (i3 == 1) {
                return this.cipher.messageEncrypt(pad());
            }
            if (i3 != 2) {
                return null;
            }
            byte[] byteArray = this.buf.toByteArray();
            this.buf.reset();
            return unpad(this.cipher.messageDecrypt(byteArray));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher
    public int encryptOutputSize(int i) {
        return 0;
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public int getKeySize(Key key) throws InvalidKeyException {
        AsymmetricKeyParameter asymmetricKeyParameterGeneratePrivateKeyParameter;
        if (key instanceof PublicKey) {
            asymmetricKeyParameterGeneratePrivateKeyParameter = McElieceCCA2KeysToParams.generatePublicKeyParameter((PublicKey) key);
        } else {
            if (!(key instanceof PrivateKey)) {
                throw new InvalidKeyException();
            }
            asymmetricKeyParameterGeneratePrivateKeyParameter = McElieceCCA2KeysToParams.generatePrivateKeyParameter((PrivateKey) key);
        }
        return this.cipher.getKeySize((McElieceCCA2KeyParameters) asymmetricKeyParameterGeneratePrivateKeyParameter);
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public String getName() {
        return "McElieceKobaraImaiCipher";
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher
    public void initCipherDecrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.buf.reset();
        AsymmetricKeyParameter asymmetricKeyParameterGeneratePrivateKeyParameter = McElieceCCA2KeysToParams.generatePrivateKeyParameter((PrivateKey) key);
        this.digest.reset();
        this.cipher.init(false, asymmetricKeyParameterGeneratePrivateKeyParameter);
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher
    public void initCipherEncrypt(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.buf.reset();
        ParametersWithRandom parametersWithRandom = new ParametersWithRandom(McElieceCCA2KeysToParams.generatePublicKeyParameter((PublicKey) key), secureRandom);
        this.digest.reset();
        this.cipher.init(true, parametersWithRandom);
    }

    public byte[] messageDecrypt() throws BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException {
        byte[] byteArray = this.buf.toByteArray();
        this.buf.reset();
        try {
            return unpad(this.cipher.messageDecrypt(byteArray));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] messageEncrypt() throws BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException {
        try {
            return this.cipher.messageEncrypt(pad());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher, org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public byte[] update(byte[] bArr, int i, int i2) {
        this.buf.write(bArr, i, i2);
        return new byte[0];
    }
}
