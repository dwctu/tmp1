package org.bouncycastle.jcajce.provider.symmetric;

import com.google.android.gms.stats.CodePackage;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.bc.BCObjectIdentifiers;
import org.bouncycastle.asn1.cms.GCMParameters;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherKeyGenerator;
import org.bouncycastle.crypto.engines.AESFastEngine;
import org.bouncycastle.crypto.engines.AESWrapEngine;
import org.bouncycastle.crypto.engines.RFC3211WrapEngine;
import org.bouncycastle.crypto.generators.Poly1305KeyGenerator;
import org.bouncycastle.crypto.macs.CMac;
import org.bouncycastle.crypto.macs.GMac;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
import org.bouncycastle.crypto.modes.GCMBlockCipher;
import org.bouncycastle.crypto.modes.OFBBlockCipher;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseMac;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import org.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;
import org.bouncycastle.jcajce.provider.symmetric.util.PBESecretKeyFactory;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Integers;

/* loaded from: classes5.dex */
public final class AES {
    private static final Class gcmSpecClass = lookup("javax.crypto.spec.GCMParameterSpec");

    public static class AESCMAC extends BaseMac {
        public AESCMAC() {
            super(new CMac(new AESFastEngine()));
        }
    }

    public static class AESGMAC extends BaseMac {
        public AESGMAC() {
            super(new GMac(new GCMBlockCipher(new AESFastEngine())));
        }
    }

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() throws NoSuchAlgorithmException, InvalidParameterSpecException, NoSuchProviderException {
            byte[] bArr = new byte[16];
            if (this.random == null) {
                this.random = new SecureRandom();
            }
            this.random.nextBytes(bArr);
            try {
                AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance("AES", BouncyCastleProvider.PROVIDER_NAME);
                algorithmParameters.init(new IvParameterSpec(bArr));
                return algorithmParameters;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for AES parameter generation.");
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        @Override // org.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "AES IV";
        }
    }

    public static class AlgParamsGCM extends BaseAlgorithmParameters {
        private GCMParameters gcmParams;

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded() throws IOException {
            return this.gcmParams.getEncoded();
        }

        @Override // java.security.AlgorithmParametersSpi
        public byte[] engineGetEncoded(String str) throws IOException {
            if (isASN1FormatString(str)) {
                return this.gcmParams.getEncoded();
            }
            throw new IOException("unknown format specified");
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws NoSuchMethodException, InvalidParameterSpecException, SecurityException {
            if (AES.gcmSpecClass != null) {
                try {
                    this.gcmParams = new GCMParameters((byte[]) AES.gcmSpecClass.getDeclaredMethod("getIV", new Class[0]).invoke(algorithmParameterSpec, new Object[0]), ((Integer) AES.gcmSpecClass.getDeclaredMethod("getTLen", new Class[0]).invoke(algorithmParameterSpec, new Object[0])).intValue());
                } catch (Exception unused) {
                    throw new InvalidParameterSpecException("Cannot process GCMParameterSpec.");
                }
            }
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr) throws IOException {
            this.gcmParams = GCMParameters.getInstance(bArr);
        }

        @Override // java.security.AlgorithmParametersSpi
        public void engineInit(byte[] bArr, String str) throws IOException {
            if (!isASN1FormatString(str)) {
                throw new IOException("unknown format specified");
            }
            this.gcmParams = GCMParameters.getInstance(bArr);
        }

        @Override // java.security.AlgorithmParametersSpi
        public String engineToString() {
            return CodePackage.GCM;
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters
        public AlgorithmParameterSpec localEngineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
            if (AES.gcmSpecClass == null) {
                throw new InvalidParameterSpecException("unknown parameter spec: " + cls.getName());
            }
            try {
                return (AlgorithmParameterSpec) AES.gcmSpecClass.getConstructor(byte[].class, Integer.class).newInstance(this.gcmParams.getNonce(), Integers.valueOf(this.gcmParams.getIcvLen()));
            } catch (NoSuchMethodException unused) {
                throw new InvalidParameterSpecException("no constructor found!");
            } catch (Exception e) {
                throw new InvalidParameterSpecException("construction failed: " + e.getMessage());
            }
        }
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new AESFastEngine()), 128);
        }
    }

    public static class CFB extends BaseBlockCipher {
        public CFB() {
            super(new BufferedBlockCipher(new CFBBlockCipher(new AESFastEngine(), 128)), 128);
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super(new BlockCipherProvider() { // from class: org.bouncycastle.jcajce.provider.symmetric.AES.ECB.1
                @Override // org.bouncycastle.jcajce.provider.symmetric.util.BlockCipherProvider
                public BlockCipher get() {
                    return new AESFastEngine();
                }
            });
        }
    }

    public static class GCM extends BaseBlockCipher {
        public GCM() {
            super(new GCMBlockCipher(new AESFastEngine()));
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            this(192);
        }

        public KeyGen(int i) {
            super("AES", i, new CipherKeyGenerator());
        }
    }

    public static class KeyGen128 extends KeyGen {
        public KeyGen128() {
            super(128);
        }
    }

    public static class KeyGen192 extends KeyGen {
        public KeyGen192() {
            super(192);
        }
    }

    public static class KeyGen256 extends KeyGen {
        public KeyGen256() {
            super(256);
        }
    }

    public static class Mappings extends SymmetricAlgorithmProvider {
        private static final String PREFIX = AES.class.getName();
        private static final String wrongAES128 = "2.16.840.1.101.3.4.2";
        private static final String wrongAES192 = "2.16.840.1.101.3.4.22";
        private static final String wrongAES256 = "2.16.840.1.101.3.4.42";

        @Override // org.bouncycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = PREFIX;
            sb.append(str);
            sb.append("$AlgParams");
            configurableProvider.addAlgorithm("AlgorithmParameters.AES", sb.toString());
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.2", "AES");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.22", "AES");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.2.16.840.1.101.3.4.42", "AES");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_aes128_CBC;
            sb2.append(aSN1ObjectIdentifier);
            configurableProvider.addAlgorithm(sb2.toString(), "AES");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_aes192_CBC;
            sb3.append(aSN1ObjectIdentifier2);
            configurableProvider.addAlgorithm(sb3.toString(), "AES");
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_aes256_CBC;
            sb4.append(aSN1ObjectIdentifier3);
            configurableProvider.addAlgorithm(sb4.toString(), "AES");
            configurableProvider.addAlgorithm("AlgorithmParameters.GCM", str + "$AlgParamsGCM");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.id_aes128_GCM;
            sb5.append(aSN1ObjectIdentifier4);
            configurableProvider.addAlgorithm(sb5.toString(), CodePackage.GCM);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = NISTObjectIdentifiers.id_aes192_GCM;
            sb6.append(aSN1ObjectIdentifier5);
            configurableProvider.addAlgorithm(sb6.toString(), CodePackage.GCM);
            StringBuilder sb7 = new StringBuilder();
            sb7.append("Alg.Alias.AlgorithmParameters.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = NISTObjectIdentifiers.id_aes256_GCM;
            sb7.append(aSN1ObjectIdentifier6);
            configurableProvider.addAlgorithm(sb7.toString(), CodePackage.GCM);
            configurableProvider.addAlgorithm("AlgorithmParameterGenerator.AES", str + "$AlgParamGen");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.2", "AES");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.22", "AES");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator.2.16.840.1.101.3.4.42", "AES");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier, "AES");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier2, "AES");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier3, "AES");
            configurableProvider.addAlgorithm("Cipher.AES", str + "$ECB");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.2.16.840.1.101.3.4.2", "AES");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.2.16.840.1.101.3.4.22", "AES");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.2.16.840.1.101.3.4.42", "AES");
            StringBuilder sb8 = new StringBuilder();
            sb8.append("Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier7 = NISTObjectIdentifiers.id_aes128_ECB;
            sb8.append(aSN1ObjectIdentifier7);
            configurableProvider.addAlgorithm(sb8.toString(), str + "$ECB");
            StringBuilder sb9 = new StringBuilder();
            sb9.append("Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier8 = NISTObjectIdentifiers.id_aes192_ECB;
            sb9.append(aSN1ObjectIdentifier8);
            configurableProvider.addAlgorithm(sb9.toString(), str + "$ECB");
            StringBuilder sb10 = new StringBuilder();
            sb10.append("Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier9 = NISTObjectIdentifiers.id_aes256_ECB;
            sb10.append(aSN1ObjectIdentifier9);
            configurableProvider.addAlgorithm(sb10.toString(), str + "$ECB");
            configurableProvider.addAlgorithm("Cipher." + aSN1ObjectIdentifier, str + "$CBC");
            configurableProvider.addAlgorithm("Cipher." + aSN1ObjectIdentifier2, str + "$CBC");
            configurableProvider.addAlgorithm("Cipher." + aSN1ObjectIdentifier3, str + "$CBC");
            StringBuilder sb11 = new StringBuilder();
            sb11.append("Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier10 = NISTObjectIdentifiers.id_aes128_OFB;
            sb11.append(aSN1ObjectIdentifier10);
            configurableProvider.addAlgorithm(sb11.toString(), str + "$OFB");
            StringBuilder sb12 = new StringBuilder();
            sb12.append("Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier11 = NISTObjectIdentifiers.id_aes192_OFB;
            sb12.append(aSN1ObjectIdentifier11);
            configurableProvider.addAlgorithm(sb12.toString(), str + "$OFB");
            StringBuilder sb13 = new StringBuilder();
            sb13.append("Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier12 = NISTObjectIdentifiers.id_aes256_OFB;
            sb13.append(aSN1ObjectIdentifier12);
            configurableProvider.addAlgorithm(sb13.toString(), str + "$OFB");
            StringBuilder sb14 = new StringBuilder();
            sb14.append("Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier13 = NISTObjectIdentifiers.id_aes128_CFB;
            sb14.append(aSN1ObjectIdentifier13);
            configurableProvider.addAlgorithm(sb14.toString(), str + "$CFB");
            StringBuilder sb15 = new StringBuilder();
            sb15.append("Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier14 = NISTObjectIdentifiers.id_aes192_CFB;
            sb15.append(aSN1ObjectIdentifier14);
            configurableProvider.addAlgorithm(sb15.toString(), str + "$CFB");
            StringBuilder sb16 = new StringBuilder();
            sb16.append("Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier15 = NISTObjectIdentifiers.id_aes256_CFB;
            sb16.append(aSN1ObjectIdentifier15);
            configurableProvider.addAlgorithm(sb16.toString(), str + "$CFB");
            configurableProvider.addAlgorithm("Cipher.AESWRAP", str + "$Wrap");
            StringBuilder sb17 = new StringBuilder();
            sb17.append("Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier16 = NISTObjectIdentifiers.id_aes128_wrap;
            sb17.append(aSN1ObjectIdentifier16);
            configurableProvider.addAlgorithm(sb17.toString(), "AESWRAP");
            StringBuilder sb18 = new StringBuilder();
            sb18.append("Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier17 = NISTObjectIdentifiers.id_aes192_wrap;
            sb18.append(aSN1ObjectIdentifier17);
            configurableProvider.addAlgorithm(sb18.toString(), "AESWRAP");
            StringBuilder sb19 = new StringBuilder();
            sb19.append("Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier18 = NISTObjectIdentifiers.id_aes256_wrap;
            sb19.append(aSN1ObjectIdentifier18);
            configurableProvider.addAlgorithm(sb19.toString(), "AESWRAP");
            configurableProvider.addAlgorithm("Cipher.AESRFC3211WRAP", str + "$RFC3211Wrap");
            configurableProvider.addAlgorithm("Cipher.GCM", str + "$GCM");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher." + aSN1ObjectIdentifier4, CodePackage.GCM);
            configurableProvider.addAlgorithm("Alg.Alias.Cipher." + aSN1ObjectIdentifier5, CodePackage.GCM);
            configurableProvider.addAlgorithm("Alg.Alias.Cipher." + aSN1ObjectIdentifier6, CodePackage.GCM);
            configurableProvider.addAlgorithm("KeyGenerator.AES", str + "$KeyGen");
            configurableProvider.addAlgorithm("KeyGenerator.2.16.840.1.101.3.4.2", str + "$KeyGen128");
            configurableProvider.addAlgorithm("KeyGenerator.2.16.840.1.101.3.4.22", str + "$KeyGen192");
            configurableProvider.addAlgorithm("KeyGenerator.2.16.840.1.101.3.4.42", str + "$KeyGen256");
            configurableProvider.addAlgorithm("KeyGenerator." + aSN1ObjectIdentifier7, str + "$KeyGen128");
            configurableProvider.addAlgorithm("KeyGenerator." + aSN1ObjectIdentifier, str + "$KeyGen128");
            configurableProvider.addAlgorithm("KeyGenerator." + aSN1ObjectIdentifier10, str + "$KeyGen128");
            configurableProvider.addAlgorithm("KeyGenerator." + aSN1ObjectIdentifier13, str + "$KeyGen128");
            configurableProvider.addAlgorithm("KeyGenerator." + aSN1ObjectIdentifier8, str + "$KeyGen192");
            configurableProvider.addAlgorithm("KeyGenerator." + aSN1ObjectIdentifier2, str + "$KeyGen192");
            configurableProvider.addAlgorithm("KeyGenerator." + aSN1ObjectIdentifier11, str + "$KeyGen192");
            configurableProvider.addAlgorithm("KeyGenerator." + aSN1ObjectIdentifier14, str + "$KeyGen192");
            configurableProvider.addAlgorithm("KeyGenerator." + aSN1ObjectIdentifier9, str + "$KeyGen256");
            configurableProvider.addAlgorithm("KeyGenerator." + aSN1ObjectIdentifier3, str + "$KeyGen256");
            configurableProvider.addAlgorithm("KeyGenerator." + aSN1ObjectIdentifier12, str + "$KeyGen256");
            configurableProvider.addAlgorithm("KeyGenerator." + aSN1ObjectIdentifier15, str + "$KeyGen256");
            configurableProvider.addAlgorithm("KeyGenerator.AESWRAP", str + "$KeyGen");
            configurableProvider.addAlgorithm("KeyGenerator." + aSN1ObjectIdentifier16, str + "$KeyGen128");
            configurableProvider.addAlgorithm("KeyGenerator." + aSN1ObjectIdentifier17, str + "$KeyGen192");
            configurableProvider.addAlgorithm("KeyGenerator." + aSN1ObjectIdentifier18, str + "$KeyGen256");
            configurableProvider.addAlgorithm("Mac.AESCMAC", str + "$AESCMAC");
            StringBuilder sb20 = new StringBuilder();
            sb20.append("Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier19 = BCObjectIdentifiers.bc_pbe_sha1_pkcs12_aes128_cbc;
            sb20.append(aSN1ObjectIdentifier19.getId());
            configurableProvider.addAlgorithm(sb20.toString(), "PBEWITHSHAAND128BITAES-CBC-BC");
            StringBuilder sb21 = new StringBuilder();
            sb21.append("Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier20 = BCObjectIdentifiers.bc_pbe_sha1_pkcs12_aes192_cbc;
            sb21.append(aSN1ObjectIdentifier20.getId());
            configurableProvider.addAlgorithm(sb21.toString(), "PBEWITHSHAAND192BITAES-CBC-BC");
            StringBuilder sb22 = new StringBuilder();
            sb22.append("Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier21 = BCObjectIdentifiers.bc_pbe_sha1_pkcs12_aes256_cbc;
            sb22.append(aSN1ObjectIdentifier21.getId());
            configurableProvider.addAlgorithm(sb22.toString(), "PBEWITHSHAAND256BITAES-CBC-BC");
            StringBuilder sb23 = new StringBuilder();
            sb23.append("Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier22 = BCObjectIdentifiers.bc_pbe_sha256_pkcs12_aes128_cbc;
            sb23.append(aSN1ObjectIdentifier22.getId());
            configurableProvider.addAlgorithm(sb23.toString(), "PBEWITHSHA256AND128BITAES-CBC-BC");
            StringBuilder sb24 = new StringBuilder();
            sb24.append("Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier23 = BCObjectIdentifiers.bc_pbe_sha256_pkcs12_aes192_cbc;
            sb24.append(aSN1ObjectIdentifier23.getId());
            configurableProvider.addAlgorithm(sb24.toString(), "PBEWITHSHA256AND192BITAES-CBC-BC");
            StringBuilder sb25 = new StringBuilder();
            sb25.append("Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier24 = BCObjectIdentifiers.bc_pbe_sha256_pkcs12_aes256_cbc;
            sb25.append(aSN1ObjectIdentifier24.getId());
            configurableProvider.addAlgorithm(sb25.toString(), "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Cipher.PBEWITHSHAAND128BITAES-CBC-BC", str + "$PBEWithAESCBC");
            configurableProvider.addAlgorithm("Cipher.PBEWITHSHAAND192BITAES-CBC-BC", str + "$PBEWithAESCBC");
            configurableProvider.addAlgorithm("Cipher.PBEWITHSHAAND256BITAES-CBC-BC", str + "$PBEWithAESCBC");
            configurableProvider.addAlgorithm("Cipher.PBEWITHSHA256AND128BITAES-CBC-BC", str + "$PBEWithAESCBC");
            configurableProvider.addAlgorithm("Cipher.PBEWITHSHA256AND192BITAES-CBC-BC", str + "$PBEWithAESCBC");
            configurableProvider.addAlgorithm("Cipher.PBEWITHSHA256AND256BITAES-CBC-BC", str + "$PBEWithAESCBC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-256AND128BITAES-CBC-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-256AND192BITAES-CBC-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.PBEWITHSHA-256AND256BITAES-CBC-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Cipher.PBEWITHMD5AND128BITAES-CBC-OPENSSL", str + "$PBEWithAESCBC");
            configurableProvider.addAlgorithm("Cipher.PBEWITHMD5AND192BITAES-CBC-OPENSSL", str + "$PBEWithAESCBC");
            configurableProvider.addAlgorithm("Cipher.PBEWITHMD5AND256BITAES-CBC-OPENSSL", str + "$PBEWithAESCBC");
            configurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHMD5AND128BITAES-CBC-OPENSSL", str + "$PBEWithMD5And128BitAESCBCOpenSSL");
            configurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHMD5AND192BITAES-CBC-OPENSSL", str + "$PBEWithMD5And192BitAESCBCOpenSSL");
            configurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHMD5AND256BITAES-CBC-OPENSSL", str + "$PBEWithMD5And256BitAESCBCOpenSSL");
            configurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHSHAAND128BITAES-CBC-BC", str + "$PBEWithSHAAnd128BitAESBC");
            configurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHSHAAND192BITAES-CBC-BC", str + "$PBEWithSHAAnd192BitAESBC");
            configurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHSHAAND256BITAES-CBC-BC", str + "$PBEWithSHAAnd256BitAESBC");
            configurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHSHA256AND128BITAES-CBC-BC", str + "$PBEWithSHA256And128BitAESBC");
            configurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHSHA256AND192BITAES-CBC-BC", str + "$PBEWithSHA256And192BitAESBC");
            configurableProvider.addAlgorithm("SecretKeyFactory.PBEWITHSHA256AND256BITAES-CBC-BC", str + "$PBEWithSHA256And256BitAESBC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND128BITAES-CBC-BC", "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND192BITAES-CBC-BC", "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-1AND256BITAES-CBC-BC", "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND128BITAES-CBC-BC", "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND192BITAES-CBC-BC", "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory.PBEWITHSHA-256AND256BITAES-CBC-BC", "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory." + aSN1ObjectIdentifier19.getId(), "PBEWITHSHAAND128BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory." + aSN1ObjectIdentifier20.getId(), "PBEWITHSHAAND192BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory." + aSN1ObjectIdentifier21.getId(), "PBEWITHSHAAND256BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory." + aSN1ObjectIdentifier22.getId(), "PBEWITHSHA256AND128BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory." + aSN1ObjectIdentifier23.getId(), "PBEWITHSHA256AND192BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.SecretKeyFactory." + aSN1ObjectIdentifier24.getId(), "PBEWITHSHA256AND256BITAES-CBC-BC");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND128BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND192BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND256BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND128BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND192BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA256AND256BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND128BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND192BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA1AND256BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND128BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND192BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA-1AND256BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND128BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND192BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.PBEWITHSHA-256AND256BITAES-CBC-BC", "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters." + aSN1ObjectIdentifier19.getId(), "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters." + aSN1ObjectIdentifier20.getId(), "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters." + aSN1ObjectIdentifier21.getId(), "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters." + aSN1ObjectIdentifier22.getId(), "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters." + aSN1ObjectIdentifier23.getId(), "PKCS12PBE");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters." + aSN1ObjectIdentifier24.getId(), "PKCS12PBE");
            addGMacAlgorithm(configurableProvider, "AES", str + "$AESGMAC", str + "$KeyGen128");
            addPoly1305Algorithm(configurableProvider, "AES", str + "$Poly1305", str + "$Poly1305KeyGen");
        }
    }

    public static class OFB extends BaseBlockCipher {
        public OFB() {
            super(new BufferedBlockCipher(new OFBBlockCipher(new AESFastEngine(), 128)), 128);
        }
    }

    public static class PBEWithAESCBC extends BaseBlockCipher {
        public PBEWithAESCBC() {
            super(new CBCBlockCipher(new AESFastEngine()));
        }
    }

    public static class PBEWithMD5And128BitAESCBCOpenSSL extends PBESecretKeyFactory {
        public PBEWithMD5And128BitAESCBCOpenSSL() {
            super("PBEWithMD5And128BitAES-CBC-OpenSSL", null, true, 3, 0, 128, 128);
        }
    }

    public static class PBEWithMD5And192BitAESCBCOpenSSL extends PBESecretKeyFactory {
        public PBEWithMD5And192BitAESCBCOpenSSL() {
            super("PBEWithMD5And192BitAES-CBC-OpenSSL", null, true, 3, 0, 192, 128);
        }
    }

    public static class PBEWithMD5And256BitAESCBCOpenSSL extends PBESecretKeyFactory {
        public PBEWithMD5And256BitAESCBCOpenSSL() {
            super("PBEWithMD5And256BitAES-CBC-OpenSSL", null, true, 3, 0, 256, 128);
        }
    }

    public static class PBEWithSHA256And128BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHA256And128BitAESBC() {
            super("PBEWithSHA256And128BitAES-CBC-BC", null, true, 2, 4, 128, 128);
        }
    }

    public static class PBEWithSHA256And192BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHA256And192BitAESBC() {
            super("PBEWithSHA256And192BitAES-CBC-BC", null, true, 2, 4, 192, 128);
        }
    }

    public static class PBEWithSHA256And256BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHA256And256BitAESBC() {
            super("PBEWithSHA256And256BitAES-CBC-BC", null, true, 2, 4, 256, 128);
        }
    }

    public static class PBEWithSHAAnd128BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHAAnd128BitAESBC() {
            super("PBEWithSHA1And128BitAES-CBC-BC", null, true, 2, 1, 128, 128);
        }
    }

    public static class PBEWithSHAAnd192BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHAAnd192BitAESBC() {
            super("PBEWithSHA1And192BitAES-CBC-BC", null, true, 2, 1, 192, 128);
        }
    }

    public static class PBEWithSHAAnd256BitAESBC extends PBESecretKeyFactory {
        public PBEWithSHAAnd256BitAESBC() {
            super("PBEWithSHA1And256BitAES-CBC-BC", null, true, 2, 1, 256, 128);
        }
    }

    public static class Poly1305 extends BaseMac {
        public Poly1305() {
            super(new org.bouncycastle.crypto.macs.Poly1305(new AESFastEngine()));
        }
    }

    public static class Poly1305KeyGen extends BaseKeyGenerator {
        public Poly1305KeyGen() {
            super("Poly1305-AES", 256, new Poly1305KeyGenerator());
        }
    }

    public static class RFC3211Wrap extends BaseWrapCipher {
        public RFC3211Wrap() {
            super(new RFC3211WrapEngine(new AESFastEngine()), 16);
        }
    }

    public static class Wrap extends BaseWrapCipher {
        public Wrap() {
            super(new AESWrapEngine());
        }
    }

    private AES() {
    }

    private static Class lookup(String str) {
        try {
            return AES.class.getClassLoader().loadClass(str);
        } catch (Exception unused) {
            return null;
        }
    }
}
