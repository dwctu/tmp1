package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;

/* loaded from: classes5.dex */
public class BCRSAPublicKey implements RSAPublicKey {
    private static final AlgorithmIdentifier DEFAULT_ALGORITHM_IDENTIFIER = new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, (ASN1Encodable) DERNull.INSTANCE);
    public static final long serialVersionUID = 2675817738516720772L;
    private transient AlgorithmIdentifier algorithmIdentifier;
    private BigInteger modulus;
    private BigInteger publicExponent;

    public BCRSAPublicKey(RSAPublicKey rSAPublicKey) {
        this.algorithmIdentifier = DEFAULT_ALGORITHM_IDENTIFIER;
        this.modulus = rSAPublicKey.getModulus();
        this.publicExponent = rSAPublicKey.getPublicExponent();
    }

    public BCRSAPublicKey(RSAPublicKeySpec rSAPublicKeySpec) {
        this.algorithmIdentifier = DEFAULT_ALGORITHM_IDENTIFIER;
        this.modulus = rSAPublicKeySpec.getModulus();
        this.publicExponent = rSAPublicKeySpec.getPublicExponent();
    }

    public BCRSAPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        populateFromPublicKeyInfo(subjectPublicKeyInfo);
    }

    public BCRSAPublicKey(RSAKeyParameters rSAKeyParameters) {
        this.algorithmIdentifier = DEFAULT_ALGORITHM_IDENTIFIER;
        this.modulus = rSAKeyParameters.getModulus();
        this.publicExponent = rSAKeyParameters.getExponent();
    }

    private void populateFromPublicKeyInfo(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        try {
            org.bouncycastle.asn1.pkcs.RSAPublicKey rSAPublicKey = org.bouncycastle.asn1.pkcs.RSAPublicKey.getInstance(subjectPublicKeyInfo.parsePublicKey());
            this.algorithmIdentifier = subjectPublicKeyInfo.getAlgorithm();
            this.modulus = rSAPublicKey.getModulus();
            this.publicExponent = rSAPublicKey.getPublicExponent();
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in RSA public key");
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        try {
            this.algorithmIdentifier = AlgorithmIdentifier.getInstance(objectInputStream.readObject());
        } catch (OptionalDataException unused) {
            this.algorithmIdentifier = DEFAULT_ALGORITHM_IDENTIFIER;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        if (this.algorithmIdentifier.equals(DEFAULT_ALGORITHM_IDENTIFIER)) {
            return;
        }
        objectOutputStream.writeObject(this.algorithmIdentifier.getEncoded());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RSAPublicKey)) {
            return false;
        }
        RSAPublicKey rSAPublicKey = (RSAPublicKey) obj;
        return getModulus().equals(rSAPublicKey.getModulus()) && getPublicExponent().equals(rSAPublicKey.getPublicExponent());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "RSA";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return KeyUtil.getEncodedSubjectPublicKeyInfo(this.algorithmIdentifier, new org.bouncycastle.asn1.pkcs.RSAPublicKey(getModulus(), getPublicExponent()));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // java.security.interfaces.RSAKey
    public BigInteger getModulus() {
        return this.modulus;
    }

    @Override // java.security.interfaces.RSAPublicKey
    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    public int hashCode() {
        return getModulus().hashCode() ^ getPublicExponent().hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String property = System.getProperty("line.separator");
        stringBuffer.append("RSA Public Key");
        stringBuffer.append(property);
        stringBuffer.append("            modulus: ");
        stringBuffer.append(getModulus().toString(16));
        stringBuffer.append(property);
        stringBuffer.append("    public exponent: ");
        stringBuffer.append(getPublicExponent().toString(16));
        stringBuffer.append(property);
        return stringBuffer.toString();
    }
}
