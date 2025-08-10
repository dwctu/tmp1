package org.bouncycastle.jcajce.provider.asymmetric.ec;

import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.KeyEncoder;
import org.bouncycastle.crypto.agreement.ECDHBasicAgreement;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.engines.DESedeEngine;
import org.bouncycastle.crypto.engines.IESEngine;
import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.crypto.generators.EphemeralKeyPairGenerator;
import org.bouncycastle.crypto.generators.KDF2BytesGenerator;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.IESWithCipherParameters;
import org.bouncycastle.crypto.parsers.ECIESPublicKeyParser;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.IESUtil;
import org.bouncycastle.jce.interfaces.ECKey;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.interfaces.IESKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.IESParameterSpec;
import org.bouncycastle.util.Strings;

/* loaded from: classes5.dex */
public class IESCipher extends CipherSpi {
    private IESEngine engine;
    private AsymmetricKeyParameter key;
    private SecureRandom random;
    private int state = -1;
    private ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private AlgorithmParameters engineParam = null;
    private IESParameterSpec engineSpec = null;
    private boolean dhaesMode = false;
    private AsymmetricKeyParameter otherKeyParameter = null;

    public static class ECIES extends IESCipher {
        public ECIES() {
            super(new IESEngine(new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }

    public static class ECIESwithAES extends IESCipher {
        public ECIESwithAES() {
            super(new IESEngine(new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest()), new PaddedBufferedBlockCipher(new AESEngine())));
        }
    }

    public static class ECIESwithDESede extends IESCipher {
        public ECIESwithDESede() {
            super(new IESEngine(new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest()), new PaddedBufferedBlockCipher(new DESedeEngine())));
        }
    }

    public IESCipher(IESEngine iESEngine) {
        this.engine = iESEngine;
    }

    @Override // javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        byte[] bArrEngineDoFinal = engineDoFinal(bArr, i, i2);
        System.arraycopy(bArrEngineDoFinal, 0, bArr2, i3, bArrEngineDoFinal.length);
        return bArrEngineDoFinal.length;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws BadPaddingException, IllegalBlockSizeException {
        if (i2 != 0) {
            this.buffer.write(bArr, i, i2);
        }
        byte[] byteArray = this.buffer.toByteArray();
        this.buffer.reset();
        IESWithCipherParameters iESWithCipherParameters = new IESWithCipherParameters(this.engineSpec.getDerivationV(), this.engineSpec.getEncodingV(), this.engineSpec.getMacKeySize(), this.engineSpec.getCipherKeySize());
        ECDomainParameters parameters = ((ECKeyParameters) this.key).getParameters();
        AsymmetricKeyParameter asymmetricKeyParameter = this.otherKeyParameter;
        if (asymmetricKeyParameter != null) {
            try {
                int i3 = this.state;
                if (i3 == 1 || i3 == 3) {
                    this.engine.init(true, asymmetricKeyParameter, this.key, iESWithCipherParameters);
                } else {
                    this.engine.init(false, this.key, asymmetricKeyParameter, iESWithCipherParameters);
                }
                return this.engine.processBlock(byteArray, 0, byteArray.length);
            } catch (Exception e) {
                throw new BadPaddingException(e.getMessage());
            }
        }
        int i4 = this.state;
        if (i4 == 1 || i4 == 3) {
            ECKeyPairGenerator eCKeyPairGenerator = new ECKeyPairGenerator();
            eCKeyPairGenerator.init(new ECKeyGenerationParameters(parameters, this.random));
            try {
                this.engine.init(this.key, iESWithCipherParameters, new EphemeralKeyPairGenerator(eCKeyPairGenerator, new KeyEncoder() { // from class: org.bouncycastle.jcajce.provider.asymmetric.ec.IESCipher.1
                    @Override // org.bouncycastle.crypto.KeyEncoder
                    public byte[] getEncoded(AsymmetricKeyParameter asymmetricKeyParameter2) {
                        return ((ECPublicKeyParameters) asymmetricKeyParameter2).getQ().getEncoded();
                    }
                }));
                return this.engine.processBlock(byteArray, 0, byteArray.length);
            } catch (Exception e2) {
                throw new BadPaddingException(e2.getMessage());
            }
        }
        if (i4 != 2 && i4 != 4) {
            throw new IllegalStateException("cipher not initialised");
        }
        try {
            this.engine.init(this.key, iESWithCipherParameters, new ECIESPublicKeyParser(parameters));
            return this.engine.processBlock(byteArray, 0, byteArray.length);
        } catch (InvalidCipherTextException e3) {
            throw new BadPaddingException(e3.getMessage());
        }
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        if (this.engine.getCipher() != null) {
            return this.engine.getCipher().getBlockSize();
        }
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetKeySize(Key key) {
        if (key instanceof ECKey) {
            return ((ECKey) key).getParameters().getCurve().getFieldSize();
        }
        throw new IllegalArgumentException("not an EC key");
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetOutputSize(int i) {
        int size;
        BufferedBlockCipher cipher;
        int macSize = this.engine.getMac().getMacSize();
        Object obj = this.key;
        if (obj == null) {
            throw new IllegalStateException("cipher not initialised");
        }
        int fieldSize = (((((ECKey) obj).getParameters().getCurve().getFieldSize() + 7) * 2) / 8) + 1;
        if (this.engine.getCipher() != null) {
            int i2 = this.state;
            if (i2 == 1 || i2 == 3) {
                cipher = this.engine.getCipher();
            } else {
                if (i2 != 2 && i2 != 4) {
                    throw new IllegalStateException("cipher not initialised");
                }
                cipher = this.engine.getCipher();
                i = (i - macSize) - fieldSize;
            }
            i = cipher.getOutputSize(i);
        }
        int i3 = this.state;
        if (i3 == 1 || i3 == 3) {
            size = this.buffer.size() + macSize + fieldSize;
        } else {
            if (i3 != 2 && i3 != 4) {
                throw new IllegalStateException("cipher not initialised");
            }
            size = (this.buffer.size() - macSize) - fieldSize;
        }
        return size + i;
    }

    @Override // javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() throws NoSuchAlgorithmException, InvalidParameterSpecException, NoSuchProviderException {
        if (this.engineParam == null && this.engineSpec != null) {
            try {
                AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance("IES", BouncyCastleProvider.PROVIDER_NAME);
                this.engineParam = algorithmParameters;
                algorithmParameters.init(this.engineSpec);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.engineParam;
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidParameterSpecException, InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec parameterSpec;
        if (algorithmParameters != null) {
            try {
                parameterSpec = algorithmParameters.getParameterSpec(IESParameterSpec.class);
            } catch (Exception e) {
                throw new InvalidAlgorithmParameterException("cannot recognise parameters: " + e.toString());
            }
        } else {
            parameterSpec = null;
        }
        this.engineParam = algorithmParameters;
        engineInit(i, key, parameterSpec, secureRandom);
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException unused) {
            throw new IllegalArgumentException("can't handle supplied parameter spec");
        }
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        IESParameterSpec iESParameterSpecGuessParameterSpec;
        AsymmetricKeyParameter asymmetricKeyParameterGeneratePublicKeyParameter;
        PrivateKey privateKey;
        this.otherKeyParameter = null;
        if (algorithmParameterSpec == null) {
            iESParameterSpecGuessParameterSpec = IESUtil.guessParameterSpec(this.engine);
        } else {
            if (!(algorithmParameterSpec instanceof IESParameterSpec)) {
                throw new InvalidAlgorithmParameterException("must be passed IES parameters");
            }
            iESParameterSpecGuessParameterSpec = (IESParameterSpec) algorithmParameterSpec;
        }
        this.engineSpec = iESParameterSpecGuessParameterSpec;
        if (i == 1 || i == 3) {
            if (!(key instanceof ECPublicKey)) {
                if (!(key instanceof IESKey)) {
                    throw new InvalidKeyException("must be passed recipient's public EC key for encryption");
                }
                IESKey iESKey = (IESKey) key;
                this.key = ECUtil.generatePublicKeyParameter(iESKey.getPublic());
                this.otherKeyParameter = ECUtil.generatePrivateKeyParameter(iESKey.getPrivate());
                this.random = secureRandom;
                this.state = i;
                this.buffer.reset();
            }
            asymmetricKeyParameterGeneratePublicKeyParameter = ECUtil.generatePublicKeyParameter((PublicKey) key);
        } else {
            if (i != 2 && i != 4) {
                throw new InvalidKeyException("must be passed EC key");
            }
            if (key instanceof ECPrivateKey) {
                privateKey = (PrivateKey) key;
            } else {
                if (!(key instanceof IESKey)) {
                    throw new InvalidKeyException("must be passed recipient's private EC key for decryption");
                }
                IESKey iESKey2 = (IESKey) key;
                this.otherKeyParameter = ECUtil.generatePublicKeyParameter(iESKey2.getPublic());
                privateKey = iESKey2.getPrivate();
            }
            asymmetricKeyParameterGeneratePublicKeyParameter = ECUtil.generatePrivateKeyParameter(privateKey);
        }
        this.key = asymmetricKeyParameterGeneratePublicKeyParameter;
        this.random = secureRandom;
        this.state = i;
        this.buffer.reset();
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        boolean z;
        String upperCase = Strings.toUpperCase(str);
        if (upperCase.equals("NONE")) {
            z = false;
        } else {
            if (!upperCase.equals("DHAES")) {
                throw new IllegalArgumentException("can't support mode " + str);
            }
            z = true;
        }
        this.dhaesMode = z;
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        String upperCase = Strings.toUpperCase(str);
        if (!upperCase.equals("NOPADDING") && !upperCase.equals("PKCS5PADDING") && !upperCase.equals("PKCS7PADDING")) {
            throw new NoSuchPaddingException("padding not available with IESCipher");
        }
    }

    @Override // javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.buffer.write(bArr, i, i2);
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        this.buffer.write(bArr, i, i2);
        return null;
    }
}
