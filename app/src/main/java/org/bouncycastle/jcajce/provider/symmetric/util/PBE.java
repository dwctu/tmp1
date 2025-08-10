package org.bouncycastle.jcajce.provider.symmetric.util;

import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.GOST3411Digest;
import org.bouncycastle.crypto.digests.MD2Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.TigerDigest;
import org.bouncycastle.crypto.generators.OpenSSLPBEParametersGenerator;
import org.bouncycastle.crypto.generators.PKCS12ParametersGenerator;
import org.bouncycastle.crypto.generators.PKCS5S1ParametersGenerator;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.params.DESParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

/* loaded from: classes5.dex */
public interface PBE {
    public static final int GOST3411 = 6;
    public static final int MD2 = 5;
    public static final int MD5 = 0;
    public static final int OPENSSL = 3;
    public static final int PKCS12 = 2;
    public static final int PKCS5S1 = 0;
    public static final int PKCS5S1_UTF8 = 4;
    public static final int PKCS5S2 = 1;
    public static final int PKCS5S2_UTF8 = 5;
    public static final int RIPEMD160 = 2;
    public static final int SHA1 = 1;
    public static final int SHA256 = 4;
    public static final int TIGER = 3;

    public static class Util {
        private static byte[] convertPassword(int i, PBEKeySpec pBEKeySpec) {
            return i == 2 ? PBEParametersGenerator.PKCS12PasswordToBytes(pBEKeySpec.getPassword()) : (i == 5 || i == 4) ? PBEParametersGenerator.PKCS5PasswordToUTF8Bytes(pBEKeySpec.getPassword()) : PBEParametersGenerator.PKCS5PasswordToBytes(pBEKeySpec.getPassword());
        }

        private static PBEParametersGenerator makePBEGenerator(int i, int i2) {
            if (i == 0 || i == 4) {
                if (i2 == 0) {
                    return new PKCS5S1ParametersGenerator(new MD5Digest());
                }
                if (i2 == 1) {
                    return new PKCS5S1ParametersGenerator(new SHA1Digest());
                }
                if (i2 == 5) {
                    return new PKCS5S1ParametersGenerator(new MD2Digest());
                }
                throw new IllegalStateException("PKCS5 scheme 1 only supports MD2, MD5 and SHA1.");
            }
            if (i == 1 || i == 5) {
                switch (i2) {
                    case 0:
                        return new PKCS5S2ParametersGenerator(new MD5Digest());
                    case 1:
                        return new PKCS5S2ParametersGenerator(new SHA1Digest());
                    case 2:
                        return new PKCS5S2ParametersGenerator(new RIPEMD160Digest());
                    case 3:
                        return new PKCS5S2ParametersGenerator(new TigerDigest());
                    case 4:
                        return new PKCS5S2ParametersGenerator(new SHA256Digest());
                    case 5:
                        return new PKCS5S2ParametersGenerator(new MD2Digest());
                    case 6:
                        return new PKCS5S2ParametersGenerator(new GOST3411Digest());
                    default:
                        throw new IllegalStateException("unknown digest scheme for PBE PKCS5S2 encryption.");
                }
            }
            if (i != 2) {
                return new OpenSSLPBEParametersGenerator();
            }
            switch (i2) {
                case 0:
                    return new PKCS12ParametersGenerator(new MD5Digest());
                case 1:
                    return new PKCS12ParametersGenerator(new SHA1Digest());
                case 2:
                    return new PKCS12ParametersGenerator(new RIPEMD160Digest());
                case 3:
                    return new PKCS12ParametersGenerator(new TigerDigest());
                case 4:
                    return new PKCS12ParametersGenerator(new SHA256Digest());
                case 5:
                    return new PKCS12ParametersGenerator(new MD2Digest());
                case 6:
                    return new PKCS12ParametersGenerator(new GOST3411Digest());
                default:
                    throw new IllegalStateException("unknown digest scheme for PBE encryption.");
            }
        }

        public static CipherParameters makePBEMacParameters(PBEKeySpec pBEKeySpec, int i, int i2, int i3) {
            PBEParametersGenerator pBEParametersGeneratorMakePBEGenerator = makePBEGenerator(i, i2);
            byte[] bArrConvertPassword = convertPassword(i, pBEKeySpec);
            pBEParametersGeneratorMakePBEGenerator.init(bArrConvertPassword, pBEKeySpec.getSalt(), pBEKeySpec.getIterationCount());
            CipherParameters cipherParametersGenerateDerivedMacParameters = pBEParametersGeneratorMakePBEGenerator.generateDerivedMacParameters(i3);
            for (int i4 = 0; i4 != bArrConvertPassword.length; i4++) {
                bArrConvertPassword[i4] = 0;
            }
            return cipherParametersGenerateDerivedMacParameters;
        }

        public static CipherParameters makePBEMacParameters(BCPBEKey bCPBEKey, AlgorithmParameterSpec algorithmParameterSpec) {
            if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            PBEParametersGenerator pBEParametersGeneratorMakePBEGenerator = makePBEGenerator(bCPBEKey.getType(), bCPBEKey.getDigest());
            byte[] encoded = bCPBEKey.getEncoded();
            if (bCPBEKey.shouldTryWrongPKCS12()) {
                encoded = new byte[2];
            }
            pBEParametersGeneratorMakePBEGenerator.init(encoded, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            CipherParameters cipherParametersGenerateDerivedMacParameters = pBEParametersGeneratorMakePBEGenerator.generateDerivedMacParameters(bCPBEKey.getKeySize());
            for (int i = 0; i != encoded.length; i++) {
                encoded[i] = 0;
            }
            return cipherParametersGenerateDerivedMacParameters;
        }

        public static CipherParameters makePBEParameters(PBEKeySpec pBEKeySpec, int i, int i2, int i3, int i4) {
            PBEParametersGenerator pBEParametersGeneratorMakePBEGenerator = makePBEGenerator(i, i2);
            byte[] bArrConvertPassword = convertPassword(i, pBEKeySpec);
            pBEParametersGeneratorMakePBEGenerator.init(bArrConvertPassword, pBEKeySpec.getSalt(), pBEKeySpec.getIterationCount());
            CipherParameters cipherParametersGenerateDerivedParameters = i4 != 0 ? pBEParametersGeneratorMakePBEGenerator.generateDerivedParameters(i3, i4) : pBEParametersGeneratorMakePBEGenerator.generateDerivedParameters(i3);
            for (int i5 = 0; i5 != bArrConvertPassword.length; i5++) {
                bArrConvertPassword[i5] = 0;
            }
            return cipherParametersGenerateDerivedParameters;
        }

        public static CipherParameters makePBEParameters(BCPBEKey bCPBEKey, AlgorithmParameterSpec algorithmParameterSpec, String str) {
            if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            PBEParametersGenerator pBEParametersGeneratorMakePBEGenerator = makePBEGenerator(bCPBEKey.getType(), bCPBEKey.getDigest());
            byte[] encoded = bCPBEKey.getEncoded();
            if (bCPBEKey.shouldTryWrongPKCS12()) {
                encoded = new byte[2];
            }
            pBEParametersGeneratorMakePBEGenerator.init(encoded, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            CipherParameters cipherParametersGenerateDerivedParameters = bCPBEKey.getIvSize() != 0 ? pBEParametersGeneratorMakePBEGenerator.generateDerivedParameters(bCPBEKey.getKeySize(), bCPBEKey.getIvSize()) : pBEParametersGeneratorMakePBEGenerator.generateDerivedParameters(bCPBEKey.getKeySize());
            if (str.startsWith("DES")) {
                if (cipherParametersGenerateDerivedParameters instanceof ParametersWithIV) {
                    DESParameters.setOddParity(((KeyParameter) ((ParametersWithIV) cipherParametersGenerateDerivedParameters).getParameters()).getKey());
                } else {
                    DESParameters.setOddParity(((KeyParameter) cipherParametersGenerateDerivedParameters).getKey());
                }
            }
            for (int i = 0; i != encoded.length; i++) {
                encoded[i] = 0;
            }
            return cipherParametersGenerateDerivedParameters;
        }
    }
}
