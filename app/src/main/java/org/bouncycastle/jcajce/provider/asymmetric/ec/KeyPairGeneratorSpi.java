package org.bouncycastle.jcajce.provider.asymmetric.ec;

import com.sun.jna.Function;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveGenParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.util.Integers;

/* loaded from: classes5.dex */
public abstract class KeyPairGeneratorSpi extends KeyPairGenerator {

    public static class EC extends KeyPairGeneratorSpi {
        private static Hashtable ecParameters;
        public String algorithm;
        public int certainty;
        public ProviderConfiguration configuration;
        public Object ecParams;
        public ECKeyPairGenerator engine;
        public boolean initialised;
        public ECKeyGenerationParameters param;
        public SecureRandom random;
        public int strength;

        static {
            Hashtable hashtable = new Hashtable();
            ecParameters = hashtable;
            hashtable.put(Integers.valueOf(192), new ECGenParameterSpec("prime192v1"));
            ecParameters.put(Integers.valueOf(239), new ECGenParameterSpec("prime239v1"));
            ecParameters.put(Integers.valueOf(256), new ECGenParameterSpec("prime256v1"));
            ecParameters.put(Integers.valueOf(224), new ECGenParameterSpec("P-224"));
            ecParameters.put(Integers.valueOf(Function.USE_VARARGS), new ECGenParameterSpec("P-384"));
            ecParameters.put(Integers.valueOf(521), new ECGenParameterSpec("P-521"));
        }

        public EC() {
            super("EC");
            this.engine = new ECKeyPairGenerator();
            this.ecParams = null;
            this.strength = 239;
            this.certainty = 50;
            this.random = new SecureRandom();
            this.initialised = false;
            this.algorithm = "EC";
            this.configuration = BouncyCastleProvider.CONFIGURATION;
        }

        public EC(String str, ProviderConfiguration providerConfiguration) {
            super(str);
            this.engine = new ECKeyPairGenerator();
            this.ecParams = null;
            this.strength = 239;
            this.certainty = 50;
            this.random = new SecureRandom();
            this.initialised = false;
            this.algorithm = str;
            this.configuration = providerConfiguration;
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public KeyPair generateKeyPair() {
            if (!this.initialised) {
                initialize(this.strength, new SecureRandom());
            }
            AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.engine.generateKeyPair();
            ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic();
            ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate();
            Object obj = this.ecParams;
            if (obj instanceof ECParameterSpec) {
                ECParameterSpec eCParameterSpec = (ECParameterSpec) obj;
                BCECPublicKey bCECPublicKey = new BCECPublicKey(this.algorithm, eCPublicKeyParameters, eCParameterSpec, this.configuration);
                return new KeyPair(bCECPublicKey, new BCECPrivateKey(this.algorithm, eCPrivateKeyParameters, bCECPublicKey, eCParameterSpec, this.configuration));
            }
            if (obj == null) {
                return new KeyPair(new BCECPublicKey(this.algorithm, eCPublicKeyParameters, this.configuration), new BCECPrivateKey(this.algorithm, eCPrivateKeyParameters, this.configuration));
            }
            java.security.spec.ECParameterSpec eCParameterSpec2 = (java.security.spec.ECParameterSpec) obj;
            BCECPublicKey bCECPublicKey2 = new BCECPublicKey(this.algorithm, eCPublicKeyParameters, eCParameterSpec2, this.configuration);
            return new KeyPair(bCECPublicKey2, new BCECPrivateKey(this.algorithm, eCPrivateKeyParameters, bCECPublicKey2, eCParameterSpec2, this.configuration));
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public void initialize(int i, SecureRandom secureRandom) {
            this.strength = i;
            this.random = secureRandom;
            ECGenParameterSpec eCGenParameterSpec = (ECGenParameterSpec) ecParameters.get(Integers.valueOf(i));
            if (eCGenParameterSpec == null) {
                throw new InvalidParameterException("unknown key size.");
            }
            try {
                initialize(eCGenParameterSpec, secureRandom);
            } catch (InvalidAlgorithmParameterException unused) {
                throw new InvalidParameterException("key size not configurable.");
            }
        }

        @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
        public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            ECKeyGenerationParameters eCKeyGenerationParameters;
            ECKeyGenerationParameters eCKeyGenerationParameters2;
            if (!(algorithmParameterSpec instanceof ECParameterSpec)) {
                if (algorithmParameterSpec instanceof java.security.spec.ECParameterSpec) {
                    java.security.spec.ECParameterSpec eCParameterSpec = (java.security.spec.ECParameterSpec) algorithmParameterSpec;
                    this.ecParams = algorithmParameterSpec;
                    ECCurve eCCurveConvertCurve = EC5Util.convertCurve(eCParameterSpec.getCurve());
                    eCKeyGenerationParameters = new ECKeyGenerationParameters(new ECDomainParameters(eCCurveConvertCurve, EC5Util.convertPoint(eCCurveConvertCurve, eCParameterSpec.getGenerator(), false), eCParameterSpec.getOrder(), BigInteger.valueOf(eCParameterSpec.getCofactor())), secureRandom);
                } else {
                    boolean z = algorithmParameterSpec instanceof ECGenParameterSpec;
                    if (z || (algorithmParameterSpec instanceof ECNamedCurveGenParameterSpec)) {
                        String name = z ? ((ECGenParameterSpec) algorithmParameterSpec).getName() : ((ECNamedCurveGenParameterSpec) algorithmParameterSpec).getName();
                        X9ECParameters byName = ECNamedCurveTable.getByName(name);
                        if (byName == null) {
                            try {
                                byName = ECNamedCurveTable.getByOID(new ASN1ObjectIdentifier(name));
                                if (byName == null) {
                                    throw new InvalidAlgorithmParameterException("unknown curve OID: " + name);
                                }
                            } catch (IllegalArgumentException unused) {
                                throw new InvalidAlgorithmParameterException("unknown curve name: " + name);
                            }
                        }
                        ECNamedCurveSpec eCNamedCurveSpec = new ECNamedCurveSpec(name, byName.getCurve(), byName.getG(), byName.getN(), byName.getH(), null);
                        this.ecParams = eCNamedCurveSpec;
                        ECNamedCurveSpec eCNamedCurveSpec2 = eCNamedCurveSpec;
                        ECCurve eCCurveConvertCurve2 = EC5Util.convertCurve(eCNamedCurveSpec2.getCurve());
                        eCKeyGenerationParameters = new ECKeyGenerationParameters(new ECDomainParameters(eCCurveConvertCurve2, EC5Util.convertPoint(eCCurveConvertCurve2, eCNamedCurveSpec2.getGenerator(), false), eCNamedCurveSpec2.getOrder(), BigInteger.valueOf(eCNamedCurveSpec2.getCofactor())), secureRandom);
                    } else {
                        if (algorithmParameterSpec != null || this.configuration.getEcImplicitlyCa() == null) {
                            if (algorithmParameterSpec != null || this.configuration.getEcImplicitlyCa() != null) {
                                throw new InvalidAlgorithmParameterException("parameter object not a ECParameterSpec");
                            }
                            throw new InvalidAlgorithmParameterException("null parameter passed but no implicitCA set");
                        }
                        ECParameterSpec ecImplicitlyCa = this.configuration.getEcImplicitlyCa();
                        this.ecParams = algorithmParameterSpec;
                        eCKeyGenerationParameters2 = new ECKeyGenerationParameters(new ECDomainParameters(ecImplicitlyCa.getCurve(), ecImplicitlyCa.getG(), ecImplicitlyCa.getN()), secureRandom);
                    }
                }
                this.param = eCKeyGenerationParameters;
                this.engine.init(eCKeyGenerationParameters);
                this.initialised = true;
            }
            ECParameterSpec eCParameterSpec2 = (ECParameterSpec) algorithmParameterSpec;
            this.ecParams = algorithmParameterSpec;
            eCKeyGenerationParameters2 = new ECKeyGenerationParameters(new ECDomainParameters(eCParameterSpec2.getCurve(), eCParameterSpec2.getG(), eCParameterSpec2.getN()), secureRandom);
            this.param = eCKeyGenerationParameters2;
            this.engine.init(eCKeyGenerationParameters2);
            this.initialised = true;
        }
    }

    public static class ECDH extends EC {
        public ECDH() {
            super("ECDH", BouncyCastleProvider.CONFIGURATION);
        }
    }

    public static class ECDHC extends EC {
        public ECDHC() {
            super("ECDHC", BouncyCastleProvider.CONFIGURATION);
        }
    }

    public static class ECDSA extends EC {
        public ECDSA() {
            super("ECDSA", BouncyCastleProvider.CONFIGURATION);
        }
    }

    public static class ECMQV extends EC {
        public ECMQV() {
            super("ECMQV", BouncyCastleProvider.CONFIGURATION);
        }
    }

    public KeyPairGeneratorSpi(String str) {
        super(str);
    }
}
