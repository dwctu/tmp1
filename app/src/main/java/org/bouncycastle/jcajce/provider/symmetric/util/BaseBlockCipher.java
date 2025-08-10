package org.bouncycastle.jcajce.provider.symmetric.util;

import com.google.android.gms.stats.CodePackage;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.bouncycastle.asn1.cms.GCMParameters;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.modes.AEADBlockCipher;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.modes.CCMBlockCipher;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
import org.bouncycastle.crypto.modes.CTSBlockCipher;
import org.bouncycastle.crypto.modes.EAXBlockCipher;
import org.bouncycastle.crypto.modes.GCFBBlockCipher;
import org.bouncycastle.crypto.modes.GCMBlockCipher;
import org.bouncycastle.crypto.modes.GOFBBlockCipher;
import org.bouncycastle.crypto.modes.OCBBlockCipher;
import org.bouncycastle.crypto.modes.OFBBlockCipher;
import org.bouncycastle.crypto.modes.OpenPGPCFBBlockCipher;
import org.bouncycastle.crypto.modes.PGPCFBBlockCipher;
import org.bouncycastle.crypto.modes.SICBlockCipher;
import org.bouncycastle.crypto.paddings.BlockCipherPadding;
import org.bouncycastle.crypto.paddings.ISO10126d2Padding;
import org.bouncycastle.crypto.paddings.ISO7816d4Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.paddings.TBCPadding;
import org.bouncycastle.crypto.paddings.X923Padding;
import org.bouncycastle.crypto.paddings.ZeroBytePadding;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.ParametersWithSBox;
import org.bouncycastle.crypto.params.RC2Parameters;
import org.bouncycastle.crypto.params.RC5Parameters;
import org.bouncycastle.jcajce.provider.symmetric.util.PBE;
import org.bouncycastle.jcajce.spec.GOST28147ParameterSpec;
import org.bouncycastle.jcajce.spec.RepeatedSecretKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Strings;

/* loaded from: classes5.dex */
public class BaseBlockCipher extends BaseWrapCipher implements PBE {
    private static final Class gcmSpecClass = lookup("javax.crypto.spec.GCMParameterSpec");
    private AEADParameters aeadParams;
    private Class[] availableSpecs;
    private BlockCipher baseEngine;
    private GenericBlockCipher cipher;
    private BlockCipherProvider engineProvider;
    private int ivLength;
    private ParametersWithIV ivParam;
    private String modeName;
    private boolean padded;
    private String pbeAlgorithm;
    private PBEParameterSpec pbeSpec;

    public static class AEADGenericBlockCipher implements GenericBlockCipher {
        private AEADBlockCipher cipher;

        public AEADGenericBlockCipher(AEADBlockCipher aEADBlockCipher) {
            this.cipher = aEADBlockCipher;
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int doFinal(byte[] bArr, int i) throws InvalidCipherTextException, IllegalStateException {
            return this.cipher.doFinal(bArr, i);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public String getAlgorithmName() {
            return this.cipher.getUnderlyingCipher().getAlgorithmName();
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int getOutputSize(int i) {
            return this.cipher.getOutputSize(i);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public BlockCipher getUnderlyingCipher() {
            return this.cipher.getUnderlyingCipher();
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int getUpdateOutputSize(int i) {
            return this.cipher.getUpdateOutputSize(i);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
            this.cipher.init(z, cipherParameters);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int processByte(byte b, byte[] bArr, int i) throws DataLengthException {
            return this.cipher.processByte(b, bArr, i);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
            return this.cipher.processBytes(bArr, i, i2, bArr2, i3);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public void updateAAD(byte[] bArr, int i, int i2) {
            this.cipher.processAADBytes(bArr, i, i2);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public boolean wrapOnNoPadding() {
            return false;
        }
    }

    public static class BufferedGenericBlockCipher implements GenericBlockCipher {
        private BufferedBlockCipher cipher;

        public BufferedGenericBlockCipher(BlockCipher blockCipher) {
            this.cipher = new PaddedBufferedBlockCipher(blockCipher);
        }

        public BufferedGenericBlockCipher(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
            this.cipher = new PaddedBufferedBlockCipher(blockCipher, blockCipherPadding);
        }

        public BufferedGenericBlockCipher(BufferedBlockCipher bufferedBlockCipher) {
            this.cipher = bufferedBlockCipher;
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int doFinal(byte[] bArr, int i) throws InvalidCipherTextException, IllegalStateException {
            return this.cipher.doFinal(bArr, i);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public String getAlgorithmName() {
            return this.cipher.getUnderlyingCipher().getAlgorithmName();
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int getOutputSize(int i) {
            return this.cipher.getOutputSize(i);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public BlockCipher getUnderlyingCipher() {
            return this.cipher.getUnderlyingCipher();
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int getUpdateOutputSize(int i) {
            return this.cipher.getUpdateOutputSize(i);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
            this.cipher.init(z, cipherParameters);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int processByte(byte b, byte[] bArr, int i) throws DataLengthException {
            return this.cipher.processByte(b, bArr, i);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
            return this.cipher.processBytes(bArr, i, i2, bArr2, i3);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public void updateAAD(byte[] bArr, int i, int i2) {
            throw new UnsupportedOperationException("AAD is not supported in the current mode.");
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public boolean wrapOnNoPadding() {
            return !(this.cipher instanceof CTSBlockCipher);
        }
    }

    public interface GenericBlockCipher {
        int doFinal(byte[] bArr, int i) throws InvalidCipherTextException, IllegalStateException;

        String getAlgorithmName();

        int getOutputSize(int i);

        BlockCipher getUnderlyingCipher();

        int getUpdateOutputSize(int i);

        void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException;

        int processByte(byte b, byte[] bArr, int i) throws DataLengthException;

        int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException;

        void updateAAD(byte[] bArr, int i, int i2);

        boolean wrapOnNoPadding();
    }

    public BaseBlockCipher(BlockCipher blockCipher) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class, GOST28147ParameterSpec.class, gcmSpecClass};
        this.ivLength = 0;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = blockCipher;
        this.cipher = new BufferedGenericBlockCipher(blockCipher);
    }

    public BaseBlockCipher(BlockCipher blockCipher, int i) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class, GOST28147ParameterSpec.class, gcmSpecClass};
        this.ivLength = 0;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = blockCipher;
        this.cipher = new BufferedGenericBlockCipher(blockCipher);
        this.ivLength = i / 8;
    }

    public BaseBlockCipher(BufferedBlockCipher bufferedBlockCipher, int i) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class, GOST28147ParameterSpec.class, gcmSpecClass};
        this.ivLength = 0;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = bufferedBlockCipher.getUnderlyingCipher();
        this.cipher = new BufferedGenericBlockCipher(bufferedBlockCipher);
        this.ivLength = i / 8;
    }

    public BaseBlockCipher(AEADBlockCipher aEADBlockCipher) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class, GOST28147ParameterSpec.class, gcmSpecClass};
        this.ivLength = 0;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        BlockCipher underlyingCipher = aEADBlockCipher.getUnderlyingCipher();
        this.baseEngine = underlyingCipher;
        this.ivLength = underlyingCipher.getBlockSize();
        this.cipher = new AEADGenericBlockCipher(aEADBlockCipher);
    }

    public BaseBlockCipher(BlockCipherProvider blockCipherProvider) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class, GOST28147ParameterSpec.class, gcmSpecClass};
        this.ivLength = 0;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = blockCipherProvider.get();
        this.engineProvider = blockCipherProvider;
        this.cipher = new BufferedGenericBlockCipher(blockCipherProvider.get());
    }

    private boolean isAEADModeName(String str) {
        return "CCM".equals(str) || "EAX".equals(str) || CodePackage.GCM.equals(str) || "OCB".equals(str);
    }

    private static Class lookup(String str) {
        try {
            return BaseBlockCipher.class.getClassLoader().loadClass(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        int iProcessBytes = 0;
        if (i2 != 0) {
            try {
                iProcessBytes = this.cipher.processBytes(bArr, i, i2, bArr2, i3);
            } catch (InvalidCipherTextException e) {
                throw new BadPaddingException(e.getMessage());
            } catch (OutputLengthException e2) {
                throw new ShortBufferException(e2.getMessage());
            } catch (DataLengthException e3) {
                throw new IllegalBlockSizeException(e3.getMessage());
            }
        }
        return iProcessBytes + this.cipher.doFinal(bArr2, i3 + iProcessBytes);
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws BadPaddingException, IllegalBlockSizeException {
        int iEngineGetOutputSize = engineGetOutputSize(i2);
        byte[] bArr2 = new byte[iEngineGetOutputSize];
        int iProcessBytes = i2 != 0 ? this.cipher.processBytes(bArr, i, i2, bArr2, 0) : 0;
        try {
            int iDoFinal = iProcessBytes + this.cipher.doFinal(bArr2, iProcessBytes);
            if (iDoFinal == iEngineGetOutputSize) {
                return bArr2;
            }
            byte[] bArr3 = new byte[iDoFinal];
            System.arraycopy(bArr2, 0, bArr3, 0, iDoFinal);
            return bArr3;
        } catch (DataLengthException e) {
            throw new IllegalBlockSizeException(e.getMessage());
        } catch (InvalidCipherTextException e2) {
            throw new BadPaddingException(e2.getMessage());
        }
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        return this.baseEngine.getBlockSize();
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        ParametersWithIV parametersWithIV = this.ivParam;
        if (parametersWithIV != null) {
            return parametersWithIV.getIV();
        }
        return null;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineGetKeySize(Key key) {
        return key.getEncoded().length * 8;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineGetOutputSize(int i) {
        return this.cipher.getOutputSize(i);
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() throws NoSuchAlgorithmException, InvalidParameterSpecException, IOException, NoSuchProviderException {
        if (this.engineParams == null) {
            if (this.pbeSpec != null) {
                try {
                    AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance(this.pbeAlgorithm, BouncyCastleProvider.PROVIDER_NAME);
                    this.engineParams = algorithmParameters;
                    algorithmParameters.init(this.pbeSpec);
                } catch (Exception unused) {
                    return null;
                }
            } else if (this.ivParam != null) {
                String algorithmName = this.cipher.getUnderlyingCipher().getAlgorithmName();
                if (algorithmName.indexOf(47) >= 0) {
                    algorithmName = algorithmName.substring(0, algorithmName.indexOf(47));
                }
                try {
                    AlgorithmParameters algorithmParameters2 = AlgorithmParameters.getInstance(algorithmName, BouncyCastleProvider.PROVIDER_NAME);
                    this.engineParams = algorithmParameters2;
                    algorithmParameters2.init(this.ivParam.getIV());
                } catch (Exception e) {
                    throw new RuntimeException(e.toString());
                }
            } else if (this.aeadParams != null) {
                try {
                    AlgorithmParameters algorithmParameters3 = AlgorithmParameters.getInstance(CodePackage.GCM, BouncyCastleProvider.PROVIDER_NAME);
                    this.engineParams = algorithmParameters3;
                    algorithmParameters3.init(new GCMParameters(this.aeadParams.getNonce(), this.aeadParams.getMacSize()).getEncoded());
                } catch (Exception e2) {
                    throw new RuntimeException(e2.toString());
                }
            }
        }
        return this.engineParams;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws NoSuchMethodException, InvalidParameterSpecException, InvalidKeyException, SecurityException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec parameterSpec = null;
        if (algorithmParameters != null) {
            int i2 = 0;
            while (true) {
                Class[] clsArr = this.availableSpecs;
                if (i2 == clsArr.length) {
                    break;
                }
                if (clsArr[i2] != null) {
                    try {
                        parameterSpec = algorithmParameters.getParameterSpec(clsArr[i2]);
                        break;
                    } catch (Exception unused) {
                        continue;
                    }
                }
                i2++;
            }
            if (parameterSpec == null) {
                throw new InvalidAlgorithmParameterException("can't handle parameter " + algorithmParameters.toString());
            }
        }
        engineInit(i, key, parameterSpec, secureRandom);
        this.engineParams = algorithmParameters;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineInit(int i, Key key, SecureRandom secureRandom) throws NoSuchMethodException, InvalidKeyException, SecurityException {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            throw new InvalidKeyException(e.getMessage());
        }
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws NoSuchMethodException, InvalidKeyException, SecurityException, InvalidAlgorithmParameterException {
        CipherParameters cipherParameters;
        CipherParameters cipherParameters2;
        ParametersWithIV parametersWithIV;
        CipherParameters keyParameter;
        CipherParameters cipherParametersMakePBEParameters;
        CipherParameters parametersWithSBox;
        this.pbeSpec = null;
        this.pbeAlgorithm = null;
        this.engineParams = null;
        this.aeadParams = null;
        if (!(key instanceof SecretKey)) {
            throw new InvalidKeyException("Key for algorithm " + key.getAlgorithm() + " not suitable for symmetric enryption.");
        }
        if (algorithmParameterSpec == null && this.baseEngine.getAlgorithmName().startsWith("RC5-64")) {
            throw new InvalidAlgorithmParameterException("RC5 requires an RC5ParametersSpec to be passed in.");
        }
        if (key instanceof BCPBEKey) {
            BCPBEKey bCPBEKey = (BCPBEKey) key;
            this.pbeAlgorithm = bCPBEKey.getOID() != null ? bCPBEKey.getOID().getId() : bCPBEKey.getAlgorithm();
            if (bCPBEKey.getParam() != null) {
                CipherParameters param = bCPBEKey.getParam();
                if (algorithmParameterSpec instanceof IvParameterSpec) {
                    parametersWithSBox = new ParametersWithIV(param, ((IvParameterSpec) algorithmParameterSpec).getIV());
                } else {
                    cipherParametersMakePBEParameters = param;
                    if (algorithmParameterSpec instanceof GOST28147ParameterSpec) {
                        GOST28147ParameterSpec gOST28147ParameterSpec = (GOST28147ParameterSpec) algorithmParameterSpec;
                        parametersWithSBox = new ParametersWithSBox(param, gOST28147ParameterSpec.getSbox());
                        if (gOST28147ParameterSpec.getIV() != null && this.ivLength != 0) {
                            cipherParametersMakePBEParameters = new ParametersWithIV(parametersWithSBox, gOST28147ParameterSpec.getIV());
                        }
                    }
                }
                cipherParametersMakePBEParameters = parametersWithSBox;
            } else {
                if (!(algorithmParameterSpec instanceof PBEParameterSpec)) {
                    throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
                }
                this.pbeSpec = (PBEParameterSpec) algorithmParameterSpec;
                cipherParametersMakePBEParameters = PBE.Util.makePBEParameters(bCPBEKey, algorithmParameterSpec, this.cipher.getUnderlyingCipher().getAlgorithmName());
            }
            boolean z = cipherParametersMakePBEParameters instanceof ParametersWithIV;
            cipherParameters2 = cipherParametersMakePBEParameters;
            if (z) {
                this.ivParam = (ParametersWithIV) cipherParametersMakePBEParameters;
                cipherParameters2 = cipherParametersMakePBEParameters;
            }
        } else {
            if (algorithmParameterSpec == null) {
                keyParameter = new KeyParameter(key.getEncoded());
            } else if (algorithmParameterSpec instanceof IvParameterSpec) {
                if (this.ivLength != 0) {
                    IvParameterSpec ivParameterSpec = (IvParameterSpec) algorithmParameterSpec;
                    if (ivParameterSpec.getIV().length != this.ivLength && !isAEADModeName(this.modeName)) {
                        throw new InvalidAlgorithmParameterException("IV must be " + this.ivLength + " bytes long.");
                    }
                    if (key instanceof RepeatedSecretKeySpec) {
                        parametersWithIV = new ParametersWithIV(null, ivParameterSpec.getIV());
                        this.ivParam = parametersWithIV;
                        cipherParameters2 = parametersWithIV;
                    } else {
                        ParametersWithIV parametersWithIV2 = new ParametersWithIV(new KeyParameter(key.getEncoded()), ivParameterSpec.getIV());
                        this.ivParam = parametersWithIV2;
                        cipherParameters = parametersWithIV2;
                        cipherParameters2 = cipherParameters;
                    }
                } else {
                    String str = this.modeName;
                    if (str != null && str.equals("ECB")) {
                        throw new InvalidAlgorithmParameterException("ECB mode does not use an IV");
                    }
                    keyParameter = new KeyParameter(key.getEncoded());
                }
            } else if (algorithmParameterSpec instanceof GOST28147ParameterSpec) {
                GOST28147ParameterSpec gOST28147ParameterSpec2 = (GOST28147ParameterSpec) algorithmParameterSpec;
                CipherParameters parametersWithSBox2 = new ParametersWithSBox(new KeyParameter(key.getEncoded()), gOST28147ParameterSpec2.getSbox());
                cipherParameters = parametersWithSBox2;
                if (gOST28147ParameterSpec2.getIV() != null) {
                    cipherParameters = parametersWithSBox2;
                    if (this.ivLength != 0) {
                        parametersWithIV = new ParametersWithIV(parametersWithSBox2, gOST28147ParameterSpec2.getIV());
                        this.ivParam = parametersWithIV;
                        cipherParameters2 = parametersWithIV;
                    }
                }
                cipherParameters2 = cipherParameters;
            } else if (algorithmParameterSpec instanceof RC2ParameterSpec) {
                RC2ParameterSpec rC2ParameterSpec = (RC2ParameterSpec) algorithmParameterSpec;
                CipherParameters rC2Parameters = new RC2Parameters(key.getEncoded(), rC2ParameterSpec.getEffectiveKeyBits());
                cipherParameters = rC2Parameters;
                if (rC2ParameterSpec.getIV() != null) {
                    cipherParameters = rC2Parameters;
                    if (this.ivLength != 0) {
                        parametersWithIV = new ParametersWithIV(rC2Parameters, rC2ParameterSpec.getIV());
                        this.ivParam = parametersWithIV;
                        cipherParameters2 = parametersWithIV;
                    }
                }
                cipherParameters2 = cipherParameters;
            } else {
                if (algorithmParameterSpec instanceof RC5ParameterSpec) {
                    RC5ParameterSpec rC5ParameterSpec = (RC5ParameterSpec) algorithmParameterSpec;
                    CipherParameters rC5Parameters = new RC5Parameters(key.getEncoded(), rC5ParameterSpec.getRounds());
                    if (!this.baseEngine.getAlgorithmName().startsWith("RC5")) {
                        throw new InvalidAlgorithmParameterException("RC5 parameters passed to a cipher that is not RC5.");
                    }
                    if (this.baseEngine.getAlgorithmName().equals("RC5-32")) {
                        if (rC5ParameterSpec.getWordSize() != 32) {
                            throw new InvalidAlgorithmParameterException("RC5 already set up for a word size of 32 not " + rC5ParameterSpec.getWordSize() + ".");
                        }
                    } else if (this.baseEngine.getAlgorithmName().equals("RC5-64") && rC5ParameterSpec.getWordSize() != 64) {
                        throw new InvalidAlgorithmParameterException("RC5 already set up for a word size of 64 not " + rC5ParameterSpec.getWordSize() + ".");
                    }
                    cipherParameters = rC5Parameters;
                    if (rC5ParameterSpec.getIV() != null) {
                        cipherParameters = rC5Parameters;
                        if (this.ivLength != 0) {
                            parametersWithIV = new ParametersWithIV(rC5Parameters, rC5ParameterSpec.getIV());
                            this.ivParam = parametersWithIV;
                            cipherParameters2 = parametersWithIV;
                        }
                    }
                } else {
                    Class cls = gcmSpecClass;
                    if (cls == null || !cls.isInstance(algorithmParameterSpec)) {
                        throw new InvalidAlgorithmParameterException("unknown parameter type.");
                    }
                    if (!isAEADModeName(this.modeName) && !(this.cipher instanceof AEADGenericBlockCipher)) {
                        throw new InvalidAlgorithmParameterException("GCMParameterSpec can only be used with AEAD modes.");
                    }
                    try {
                        Method declaredMethod = cls.getDeclaredMethod("getTLen", new Class[0]);
                        Method declaredMethod2 = cls.getDeclaredMethod("getIV", new Class[0]);
                        if (key instanceof RepeatedSecretKeySpec) {
                            AEADParameters aEADParameters = new AEADParameters(null, ((Integer) declaredMethod.invoke(algorithmParameterSpec, new Object[0])).intValue(), (byte[]) declaredMethod2.invoke(algorithmParameterSpec, new Object[0]));
                            this.aeadParams = aEADParameters;
                            cipherParameters2 = aEADParameters;
                        } else {
                            AEADParameters aEADParameters2 = new AEADParameters(new KeyParameter(key.getEncoded()), ((Integer) declaredMethod.invoke(algorithmParameterSpec, new Object[0])).intValue(), (byte[]) declaredMethod2.invoke(algorithmParameterSpec, new Object[0]));
                            this.aeadParams = aEADParameters2;
                            cipherParameters = aEADParameters2;
                        }
                    } catch (Exception unused) {
                        throw new InvalidAlgorithmParameterException("Cannot process GCMParameterSpec.");
                    }
                }
                cipherParameters2 = cipherParameters;
            }
            cipherParameters2 = keyParameter;
        }
        CipherParameters parametersWithRandom = cipherParameters2;
        if (this.ivLength != 0) {
            boolean z2 = cipherParameters2 instanceof ParametersWithIV;
            parametersWithRandom = cipherParameters2;
            if (!z2) {
                boolean z3 = cipherParameters2 instanceof AEADParameters;
                parametersWithRandom = cipherParameters2;
                if (!z3) {
                    SecureRandom secureRandom2 = secureRandom == null ? new SecureRandom() : secureRandom;
                    if (i == 1 || i == 3) {
                        byte[] bArr = new byte[this.ivLength];
                        secureRandom2.nextBytes(bArr);
                        ParametersWithIV parametersWithIV3 = new ParametersWithIV(cipherParameters2, bArr);
                        this.ivParam = parametersWithIV3;
                        parametersWithRandom = parametersWithIV3;
                    } else {
                        parametersWithRandom = cipherParameters2;
                        if (this.cipher.getUnderlyingCipher().getAlgorithmName().indexOf("PGPCFB") < 0) {
                            throw new InvalidAlgorithmParameterException("no IV set when one expected");
                        }
                    }
                }
            }
        }
        if (secureRandom != null && this.padded) {
            parametersWithRandom = new ParametersWithRandom(parametersWithRandom, secureRandom);
        }
        try {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            throw new InvalidParameterException("unknown opmode " + i + " passed");
                        }
                    }
                }
                this.cipher.init(false, parametersWithRandom);
                return;
            }
            this.cipher.init(true, parametersWithRandom);
        } catch (Exception e) {
            throw new InvalidKeyException(e.getMessage());
        }
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineSetMode(String str) throws NoSuchAlgorithmException, NumberFormatException {
        GenericBlockCipher aEADGenericBlockCipher;
        BufferedGenericBlockCipher bufferedGenericBlockCipher;
        String upperCase = Strings.toUpperCase(str);
        this.modeName = upperCase;
        if (upperCase.equals("ECB")) {
            this.ivLength = 0;
            aEADGenericBlockCipher = new BufferedGenericBlockCipher(this.baseEngine);
        } else if (this.modeName.equals("CBC")) {
            this.ivLength = this.baseEngine.getBlockSize();
            aEADGenericBlockCipher = new BufferedGenericBlockCipher(new CBCBlockCipher(this.baseEngine));
        } else if (this.modeName.startsWith("OFB")) {
            this.ivLength = this.baseEngine.getBlockSize();
            if (this.modeName.length() != 3) {
                bufferedGenericBlockCipher = new BufferedGenericBlockCipher(new OFBBlockCipher(this.baseEngine, Integer.parseInt(this.modeName.substring(3))));
                this.cipher = bufferedGenericBlockCipher;
                return;
            }
            BlockCipher blockCipher = this.baseEngine;
            aEADGenericBlockCipher = new BufferedGenericBlockCipher(new OFBBlockCipher(blockCipher, blockCipher.getBlockSize() * 8));
        } else if (this.modeName.startsWith("CFB")) {
            this.ivLength = this.baseEngine.getBlockSize();
            if (this.modeName.length() != 3) {
                bufferedGenericBlockCipher = new BufferedGenericBlockCipher(new CFBBlockCipher(this.baseEngine, Integer.parseInt(this.modeName.substring(3))));
                this.cipher = bufferedGenericBlockCipher;
                return;
            }
            BlockCipher blockCipher2 = this.baseEngine;
            aEADGenericBlockCipher = new BufferedGenericBlockCipher(new CFBBlockCipher(blockCipher2, blockCipher2.getBlockSize() * 8));
        } else {
            if (this.modeName.startsWith("PGP")) {
                boolean zEqualsIgnoreCase = this.modeName.equalsIgnoreCase("PGPCFBwithIV");
                this.ivLength = this.baseEngine.getBlockSize();
                bufferedGenericBlockCipher = new BufferedGenericBlockCipher(new PGPCFBBlockCipher(this.baseEngine, zEqualsIgnoreCase));
                this.cipher = bufferedGenericBlockCipher;
                return;
            }
            if (this.modeName.equalsIgnoreCase("OpenPGPCFB")) {
                this.ivLength = 0;
                aEADGenericBlockCipher = new BufferedGenericBlockCipher(new OpenPGPCFBBlockCipher(this.baseEngine));
            } else if (this.modeName.startsWith("SIC")) {
                int blockSize = this.baseEngine.getBlockSize();
                this.ivLength = blockSize;
                if (blockSize < 16) {
                    throw new IllegalArgumentException("Warning: SIC-Mode can become a twotime-pad if the blocksize of the cipher is too small. Use a cipher with a block size of at least 128 bits (e.g. AES)");
                }
                aEADGenericBlockCipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(new SICBlockCipher(this.baseEngine)));
            } else if (this.modeName.startsWith("CTR")) {
                this.ivLength = this.baseEngine.getBlockSize();
                aEADGenericBlockCipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(new SICBlockCipher(this.baseEngine)));
            } else if (this.modeName.startsWith("GOFB")) {
                this.ivLength = this.baseEngine.getBlockSize();
                aEADGenericBlockCipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(new GOFBBlockCipher(this.baseEngine)));
            } else if (this.modeName.startsWith("GCFB")) {
                this.ivLength = this.baseEngine.getBlockSize();
                aEADGenericBlockCipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(new GCFBBlockCipher(this.baseEngine)));
            } else if (this.modeName.startsWith("CTS")) {
                this.ivLength = this.baseEngine.getBlockSize();
                aEADGenericBlockCipher = new BufferedGenericBlockCipher(new CTSBlockCipher(new CBCBlockCipher(this.baseEngine)));
            } else if (this.modeName.startsWith("CCM")) {
                this.ivLength = 13;
                aEADGenericBlockCipher = new AEADGenericBlockCipher(new CCMBlockCipher(this.baseEngine));
            } else if (this.modeName.startsWith("OCB")) {
                BlockCipherProvider blockCipherProvider = this.engineProvider;
                if (blockCipherProvider == null) {
                    throw new NoSuchAlgorithmException("can't support mode " + str);
                }
                this.ivLength = 15;
                aEADGenericBlockCipher = new AEADGenericBlockCipher(new OCBBlockCipher(this.baseEngine, blockCipherProvider.get()));
            } else if (this.modeName.startsWith("EAX")) {
                this.ivLength = this.baseEngine.getBlockSize();
                aEADGenericBlockCipher = new AEADGenericBlockCipher(new EAXBlockCipher(this.baseEngine));
            } else {
                if (!this.modeName.startsWith(CodePackage.GCM)) {
                    throw new NoSuchAlgorithmException("can't support mode " + str);
                }
                this.ivLength = this.baseEngine.getBlockSize();
                aEADGenericBlockCipher = new AEADGenericBlockCipher(new GCMBlockCipher(this.baseEngine));
            }
        }
        this.cipher = aEADGenericBlockCipher;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        BufferedGenericBlockCipher bufferedGenericBlockCipher;
        String upperCase = Strings.toUpperCase(str);
        if (upperCase.equals("NOPADDING")) {
            if (!this.cipher.wrapOnNoPadding()) {
                return;
            } else {
                bufferedGenericBlockCipher = new BufferedGenericBlockCipher(new BufferedBlockCipher(this.cipher.getUnderlyingCipher()));
            }
        } else if (upperCase.equals("WITHCTS")) {
            bufferedGenericBlockCipher = new BufferedGenericBlockCipher(new CTSBlockCipher(this.cipher.getUnderlyingCipher()));
        } else {
            this.padded = true;
            if (isAEADModeName(this.modeName)) {
                throw new NoSuchPaddingException("Only NoPadding can be used with AEAD modes.");
            }
            if (upperCase.equals("PKCS5PADDING") || upperCase.equals("PKCS7PADDING")) {
                bufferedGenericBlockCipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher());
            } else if (upperCase.equals("ZEROBYTEPADDING")) {
                bufferedGenericBlockCipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ZeroBytePadding());
            } else if (upperCase.equals("ISO10126PADDING") || upperCase.equals("ISO10126-2PADDING")) {
                bufferedGenericBlockCipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ISO10126d2Padding());
            } else if (upperCase.equals("X9.23PADDING") || upperCase.equals("X923PADDING")) {
                bufferedGenericBlockCipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new X923Padding());
            } else if (upperCase.equals("ISO7816-4PADDING") || upperCase.equals("ISO9797-1PADDING")) {
                bufferedGenericBlockCipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ISO7816d4Padding());
            } else {
                if (!upperCase.equals("TBCPADDING")) {
                    throw new NoSuchPaddingException("Padding " + str + " unknown.");
                }
                bufferedGenericBlockCipher = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new TBCPadding());
            }
        }
        this.cipher = bufferedGenericBlockCipher;
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException {
        try {
            return this.cipher.processBytes(bArr, i, i2, bArr2, i3);
        } catch (DataLengthException e) {
            throw new ShortBufferException(e.getMessage());
        }
    }

    @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher, javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] bArr, int i, int i2) throws DataLengthException {
        int updateOutputSize = this.cipher.getUpdateOutputSize(i2);
        if (updateOutputSize <= 0) {
            this.cipher.processBytes(bArr, i, i2, null, 0);
            return null;
        }
        byte[] bArr2 = new byte[updateOutputSize];
        int iProcessBytes = this.cipher.processBytes(bArr, i, i2, bArr2, 0);
        if (iProcessBytes == 0) {
            return null;
        }
        if (iProcessBytes == updateOutputSize) {
            return bArr2;
        }
        byte[] bArr3 = new byte[iProcessBytes];
        System.arraycopy(bArr2, 0, bArr3, 0, iProcessBytes);
        return bArr3;
    }

    @Override // javax.crypto.CipherSpi
    public void engineUpdateAAD(ByteBuffer byteBuffer) {
        engineUpdateAAD(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.limit() - byteBuffer.position());
    }

    @Override // javax.crypto.CipherSpi
    public void engineUpdateAAD(byte[] bArr, int i, int i2) {
        this.cipher.updateAAD(bArr, i, i2);
    }
}
