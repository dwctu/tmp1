package org.bouncycastle.jcajce.provider.asymmetric.dh;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.pkcs.DHParameter;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.DHDomainParameters;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;

/* loaded from: classes5.dex */
public class BCDHPublicKey implements DHPublicKey {
    public static final long serialVersionUID = -216691575254424324L;
    private transient DHParameterSpec dhSpec;
    private transient SubjectPublicKeyInfo info;
    private BigInteger y;

    public BCDHPublicKey(BigInteger bigInteger, DHParameterSpec dHParameterSpec) {
        this.y = bigInteger;
        this.dhSpec = dHParameterSpec;
    }

    public BCDHPublicKey(DHPublicKey dHPublicKey) {
        this.y = dHPublicKey.getY();
        this.dhSpec = dHPublicKey.getParams();
    }

    public BCDHPublicKey(DHPublicKeySpec dHPublicKeySpec) {
        this.y = dHPublicKeySpec.getY();
        this.dhSpec = new DHParameterSpec(dHPublicKeySpec.getP(), dHPublicKeySpec.getG());
    }

    public BCDHPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        DHParameterSpec dHParameterSpec;
        this.info = subjectPublicKeyInfo;
        try {
            this.y = ((ASN1Integer) subjectPublicKeyInfo.parsePublicKey()).getValue();
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters());
            ASN1ObjectIdentifier algorithm = subjectPublicKeyInfo.getAlgorithm().getAlgorithm();
            if (algorithm.equals(PKCSObjectIdentifiers.dhKeyAgreement) || isPKCSParam(aSN1Sequence)) {
                DHParameter dHParameter = DHParameter.getInstance(aSN1Sequence);
                dHParameterSpec = dHParameter.getL() != null ? new DHParameterSpec(dHParameter.getP(), dHParameter.getG(), dHParameter.getL().intValue()) : new DHParameterSpec(dHParameter.getP(), dHParameter.getG());
            } else {
                if (!algorithm.equals(X9ObjectIdentifiers.dhpublicnumber)) {
                    throw new IllegalArgumentException("unknown algorithm type: " + algorithm);
                }
                DHDomainParameters dHDomainParameters = DHDomainParameters.getInstance(aSN1Sequence);
                dHParameterSpec = new DHParameterSpec(dHDomainParameters.getP().getValue(), dHDomainParameters.getG().getValue());
            }
            this.dhSpec = dHParameterSpec;
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DH public key");
        }
    }

    public BCDHPublicKey(DHPublicKeyParameters dHPublicKeyParameters) {
        this.y = dHPublicKeyParameters.getY();
        this.dhSpec = new DHParameterSpec(dHPublicKeyParameters.getParameters().getP(), dHPublicKeyParameters.getParameters().getG(), dHPublicKeyParameters.getParameters().getL());
    }

    private boolean isPKCSParam(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            return true;
        }
        if (aSN1Sequence.size() > 3) {
            return false;
        }
        return DERInteger.getInstance(aSN1Sequence.getObjectAt(2)).getValue().compareTo(BigInteger.valueOf((long) DERInteger.getInstance(aSN1Sequence.getObjectAt(0)).getValue().bitLength())) <= 0;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.dhSpec = new DHParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), objectInputStream.readInt());
        this.info = null;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.dhSpec.getP());
        objectOutputStream.writeObject(this.dhSpec.getG());
        objectOutputStream.writeInt(this.dhSpec.getL());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DHPublicKey)) {
            return false;
        }
        DHPublicKey dHPublicKey = (DHPublicKey) obj;
        return getY().equals(dHPublicKey.getY()) && getParams().getG().equals(dHPublicKey.getParams().getG()) && getParams().getP().equals(dHPublicKey.getParams().getP()) && getParams().getL() == dHPublicKey.getParams().getL();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DH";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        SubjectPublicKeyInfo subjectPublicKeyInfo = this.info;
        return subjectPublicKeyInfo != null ? KeyUtil.getEncodedSubjectPublicKeyInfo(subjectPublicKeyInfo) : KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.dhKeyAgreement, (ASN1Encodable) new DHParameter(this.dhSpec.getP(), this.dhSpec.getG(), this.dhSpec.getL()).toASN1Primitive()), new ASN1Integer(this.y));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return this.dhSpec;
    }

    @Override // javax.crypto.interfaces.DHPublicKey
    public BigInteger getY() {
        return this.y;
    }

    public int hashCode() {
        return ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getL();
    }
}
