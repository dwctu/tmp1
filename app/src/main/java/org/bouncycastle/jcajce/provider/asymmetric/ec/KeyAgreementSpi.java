package org.bouncycastle.jcajce.provider.asymmetric.ec;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x9.X9IntegerConverter;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.agreement.ECDHBasicAgreement;
import org.bouncycastle.crypto.agreement.ECDHCBasicAgreement;
import org.bouncycastle.crypto.agreement.ECMQVBasicAgreement;
import org.bouncycastle.crypto.agreement.kdf.DHKDFParameters;
import org.bouncycastle.crypto.agreement.kdf.ECDHKEKGenerator;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.MQVPrivateParameters;
import org.bouncycastle.crypto.params.MQVPublicParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.interfaces.MQVPrivateKey;
import org.bouncycastle.jce.interfaces.MQVPublicKey;
import org.bouncycastle.util.Integers;

/* loaded from: classes5.dex */
public class KeyAgreementSpi extends javax.crypto.KeyAgreementSpi {
    private static final Hashtable algorithms;
    private static final X9IntegerConverter converter = new X9IntegerConverter();
    private BasicAgreement agreement;
    private String kaAlgorithm;
    private DerivationFunction kdf;
    private ECDomainParameters parameters;
    private BigInteger result;

    public static class DH extends KeyAgreementSpi {
        public DH() {
            super("ECDH", new ECDHBasicAgreement(), null);
        }
    }

    public static class DHC extends KeyAgreementSpi {
        public DHC() {
            super("ECDHC", new ECDHCBasicAgreement(), null);
        }
    }

    public static class DHwithSHA1KDF extends KeyAgreementSpi {
        public DHwithSHA1KDF() {
            super("ECDHwithSHA1KDF", new ECDHBasicAgreement(), new ECDHKEKGenerator(new SHA1Digest()));
        }
    }

    public static class MQV extends KeyAgreementSpi {
        public MQV() {
            super("ECMQV", new ECMQVBasicAgreement(), null);
        }
    }

    public static class MQVwithSHA1KDF extends KeyAgreementSpi {
        public MQVwithSHA1KDF() {
            super("ECMQVwithSHA1KDF", new ECMQVBasicAgreement(), new ECDHKEKGenerator(new SHA1Digest()));
        }
    }

    static {
        Hashtable hashtable = new Hashtable();
        algorithms = hashtable;
        Integer numValueOf = Integers.valueOf(128);
        Integer numValueOf2 = Integers.valueOf(192);
        Integer numValueOf3 = Integers.valueOf(256);
        hashtable.put(NISTObjectIdentifiers.id_aes128_CBC.getId(), numValueOf);
        hashtable.put(NISTObjectIdentifiers.id_aes192_CBC.getId(), numValueOf2);
        hashtable.put(NISTObjectIdentifiers.id_aes256_CBC.getId(), numValueOf3);
        hashtable.put(NISTObjectIdentifiers.id_aes128_wrap.getId(), numValueOf);
        hashtable.put(NISTObjectIdentifiers.id_aes192_wrap.getId(), numValueOf2);
        hashtable.put(NISTObjectIdentifiers.id_aes256_wrap.getId(), numValueOf3);
        hashtable.put(PKCSObjectIdentifiers.id_alg_CMS3DESwrap.getId(), numValueOf2);
    }

    public KeyAgreementSpi(String str, BasicAgreement basicAgreement, DerivationFunction derivationFunction) {
        this.kaAlgorithm = str;
        this.agreement = basicAgreement;
        this.kdf = derivationFunction;
    }

    private byte[] bigIntToBytes(BigInteger bigInteger) {
        X9IntegerConverter x9IntegerConverter = converter;
        return x9IntegerConverter.integerToBytes(bigInteger, x9IntegerConverter.getByteLength(this.parameters.getG().getAffineXCoord()));
    }

    private static String getSimpleName(Class cls) {
        String name = cls.getName();
        return name.substring(name.lastIndexOf(46) + 1);
    }

    private void initFromKey(Key key) throws InvalidKeyException {
        ECDomainParameters parameters;
        CipherParameters cipherParameters;
        if (this.agreement instanceof ECMQVBasicAgreement) {
            if (!(key instanceof MQVPrivateKey)) {
                throw new InvalidKeyException(this.kaAlgorithm + " key agreement requires " + getSimpleName(MQVPrivateKey.class) + " for initialisation");
            }
            MQVPrivateKey mQVPrivateKey = (MQVPrivateKey) key;
            ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) ECUtil.generatePrivateKeyParameter(mQVPrivateKey.getStaticPrivateKey());
            CipherParameters mQVPrivateParameters = new MQVPrivateParameters(eCPrivateKeyParameters, (ECPrivateKeyParameters) ECUtil.generatePrivateKeyParameter(mQVPrivateKey.getEphemeralPrivateKey()), mQVPrivateKey.getEphemeralPublicKey() != null ? (ECPublicKeyParameters) ECUtil.generatePublicKeyParameter(mQVPrivateKey.getEphemeralPublicKey()) : null);
            parameters = eCPrivateKeyParameters.getParameters();
            cipherParameters = mQVPrivateParameters;
        } else {
            if (!(key instanceof PrivateKey)) {
                throw new InvalidKeyException(this.kaAlgorithm + " key agreement requires " + getSimpleName(ECPrivateKey.class) + " for initialisation");
            }
            ECPrivateKeyParameters eCPrivateKeyParameters2 = (ECPrivateKeyParameters) ECUtil.generatePrivateKeyParameter((PrivateKey) key);
            parameters = eCPrivateKeyParameters2.getParameters();
            cipherParameters = eCPrivateKeyParameters2;
        }
        this.parameters = parameters;
        this.agreement.init(cipherParameters);
    }

    @Override // javax.crypto.KeyAgreementSpi
    public Key engineDoPhase(Key key, boolean z) throws IllegalStateException, InvalidKeyException {
        CipherParameters cipherParametersGeneratePublicKeyParameter;
        if (this.parameters == null) {
            throw new IllegalStateException(this.kaAlgorithm + " not initialised.");
        }
        if (!z) {
            throw new IllegalStateException(this.kaAlgorithm + " can only be between two parties.");
        }
        if (this.agreement instanceof ECMQVBasicAgreement) {
            if (!(key instanceof MQVPublicKey)) {
                throw new InvalidKeyException(this.kaAlgorithm + " key agreement requires " + getSimpleName(MQVPublicKey.class) + " for doPhase");
            }
            MQVPublicKey mQVPublicKey = (MQVPublicKey) key;
            cipherParametersGeneratePublicKeyParameter = new MQVPublicParameters((ECPublicKeyParameters) ECUtil.generatePublicKeyParameter(mQVPublicKey.getStaticKey()), (ECPublicKeyParameters) ECUtil.generatePublicKeyParameter(mQVPublicKey.getEphemeralKey()));
        } else {
            if (!(key instanceof PublicKey)) {
                throw new InvalidKeyException(this.kaAlgorithm + " key agreement requires " + getSimpleName(ECPublicKey.class) + " for doPhase");
            }
            cipherParametersGeneratePublicKeyParameter = ECUtil.generatePublicKeyParameter((PublicKey) key);
        }
        this.result = this.agreement.calculateAgreement(cipherParametersGeneratePublicKeyParameter);
        return null;
    }

    @Override // javax.crypto.KeyAgreementSpi
    public int engineGenerateSecret(byte[] bArr, int i) throws IllegalStateException, ShortBufferException {
        byte[] bArrEngineGenerateSecret = engineGenerateSecret();
        if (bArr.length - i >= bArrEngineGenerateSecret.length) {
            System.arraycopy(bArrEngineGenerateSecret, 0, bArr, i, bArrEngineGenerateSecret.length);
            return bArrEngineGenerateSecret.length;
        }
        throw new ShortBufferException(this.kaAlgorithm + " key agreement: need " + bArrEngineGenerateSecret.length + " bytes");
    }

    @Override // javax.crypto.KeyAgreementSpi
    public SecretKey engineGenerateSecret(String str) throws DataLengthException, NoSuchAlgorithmException, IllegalArgumentException {
        byte[] bArrBigIntToBytes = bigIntToBytes(this.result);
        if (this.kdf != null) {
            Hashtable hashtable = algorithms;
            if (!hashtable.containsKey(str)) {
                throw new NoSuchAlgorithmException("unknown algorithm encountered: " + str);
            }
            int iIntValue = ((Integer) hashtable.get(str)).intValue();
            DHKDFParameters dHKDFParameters = new DHKDFParameters(new ASN1ObjectIdentifier(str), iIntValue, bArrBigIntToBytes);
            int i = iIntValue / 8;
            bArrBigIntToBytes = new byte[i];
            this.kdf.init(dHKDFParameters);
            this.kdf.generateBytes(bArrBigIntToBytes, 0, i);
        }
        return new SecretKeySpec(bArrBigIntToBytes, str);
    }

    @Override // javax.crypto.KeyAgreementSpi
    public byte[] engineGenerateSecret() throws IllegalStateException {
        if (this.kdf == null) {
            return bigIntToBytes(this.result);
        }
        throw new UnsupportedOperationException("KDF can only be used when algorithm is known");
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        initFromKey(key);
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        initFromKey(key);
    }
}
