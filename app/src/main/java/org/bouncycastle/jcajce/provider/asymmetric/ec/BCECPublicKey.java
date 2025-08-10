package org.bouncycastle.jcajce.provider.asymmetric.ec;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.asn1.x9.X9IntegerConverter;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.interfaces.ECPointEncoder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

/* loaded from: classes5.dex */
public class BCECPublicKey implements ECPublicKey, org.bouncycastle.jce.interfaces.ECPublicKey, ECPointEncoder {
    public static final long serialVersionUID = 2422789860422731812L;
    private String algorithm;
    private transient ProviderConfiguration configuration;
    private transient ECParameterSpec ecSpec;
    private transient ECPoint q;
    private boolean withCompression;

    public BCECPublicKey(String str, ECPublicKeySpec eCPublicKeySpec, ProviderConfiguration providerConfiguration) {
        this.algorithm = "EC";
        this.algorithm = str;
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.ecSpec = params;
        this.q = EC5Util.convertPoint(params, eCPublicKeySpec.getW(), false);
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(String str, SubjectPublicKeyInfo subjectPublicKeyInfo, ProviderConfiguration providerConfiguration) {
        this.algorithm = "EC";
        this.algorithm = str;
        this.configuration = providerConfiguration;
        populateFromPubKeyInfo(subjectPublicKeyInfo);
    }

    public BCECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ECParameterSpec eCParameterSpec, ProviderConfiguration providerConfiguration) {
        this.algorithm = "EC";
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        this.q = eCPublicKeyParameters.getQ();
        if (eCParameterSpec == null) {
            this.ecSpec = createSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), parameters);
        } else {
            this.ecSpec = eCParameterSpec;
        }
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ProviderConfiguration providerConfiguration) {
        this.algorithm = "EC";
        this.algorithm = str;
        this.q = eCPublicKeyParameters.getQ();
        this.ecSpec = null;
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec, ProviderConfiguration providerConfiguration) {
        this.algorithm = "EC";
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        this.q = eCPublicKeyParameters.getQ();
        this.ecSpec = eCParameterSpec == null ? createSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), parameters) : EC5Util.convertSpec(EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.getSeed()), eCParameterSpec);
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(String str, BCECPublicKey bCECPublicKey) {
        this.algorithm = "EC";
        this.algorithm = str;
        this.q = bCECPublicKey.q;
        this.ecSpec = bCECPublicKey.ecSpec;
        this.withCompression = bCECPublicKey.withCompression;
        this.configuration = bCECPublicKey.configuration;
    }

    public BCECPublicKey(String str, org.bouncycastle.jce.spec.ECPublicKeySpec eCPublicKeySpec, ProviderConfiguration providerConfiguration) {
        ECParameterSpec eCParameterSpecConvertSpec;
        this.algorithm = "EC";
        this.algorithm = str;
        this.q = eCPublicKeySpec.getQ();
        if (eCPublicKeySpec.getParams() != null) {
            eCParameterSpecConvertSpec = EC5Util.convertSpec(EC5Util.convertCurve(eCPublicKeySpec.getParams().getCurve(), eCPublicKeySpec.getParams().getSeed()), eCPublicKeySpec.getParams());
        } else {
            if (this.q.getCurve() == null) {
                this.q = providerConfiguration.getEcImplicitlyCa().getCurve().createPoint(this.q.getXCoord().toBigInteger(), this.q.getYCoord().toBigInteger(), false);
            }
            eCParameterSpecConvertSpec = null;
        }
        this.ecSpec = eCParameterSpecConvertSpec;
        this.configuration = providerConfiguration;
    }

    public BCECPublicKey(ECPublicKey eCPublicKey, ProviderConfiguration providerConfiguration) {
        this.algorithm = "EC";
        this.algorithm = eCPublicKey.getAlgorithm();
        ECParameterSpec params = eCPublicKey.getParams();
        this.ecSpec = params;
        this.q = EC5Util.convertPoint(params, eCPublicKey.getW(), false);
    }

    private ECParameterSpec createSpec(EllipticCurve ellipticCurve, ECDomainParameters eCDomainParameters) {
        return new ECParameterSpec(ellipticCurve, new java.security.spec.ECPoint(eCDomainParameters.getG().getAffineXCoord().toBigInteger(), eCDomainParameters.getG().getAffineYCoord().toBigInteger()), eCDomainParameters.getN(), eCDomainParameters.getH().intValue());
    }

    private void extractBytes(byte[] bArr, int i, BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length < 32) {
            byte[] bArr2 = new byte[32];
            System.arraycopy(byteArray, 0, bArr2, 32 - byteArray.length, byteArray.length);
            byteArray = bArr2;
        }
        for (int i2 = 0; i2 != 32; i2++) {
            bArr[i + i2] = byteArray[(byteArray.length - 1) - i2];
        }
    }

    private void populateFromPubKeyInfo(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        ECCurve curve;
        ECParameterSpec eCParameterSpec;
        byte[] bytes;
        ASN1OctetString dEROctetString;
        X962Parameters x962Parameters = new X962Parameters((ASN1Primitive) subjectPublicKeyInfo.getAlgorithm().getParameters());
        if (x962Parameters.isNamedCurve()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) x962Parameters.getParameters();
            X9ECParameters namedCurveByOid = ECUtil.getNamedCurveByOid(aSN1ObjectIdentifier);
            curve = namedCurveByOid.getCurve();
            eCParameterSpec = new ECNamedCurveSpec(ECUtil.getCurveName(aSN1ObjectIdentifier), EC5Util.convertCurve(curve, namedCurveByOid.getSeed()), new java.security.spec.ECPoint(namedCurveByOid.getG().getAffineXCoord().toBigInteger(), namedCurveByOid.getG().getAffineYCoord().toBigInteger()), namedCurveByOid.getN(), namedCurveByOid.getH());
        } else {
            if (x962Parameters.isImplicitlyCA()) {
                this.ecSpec = null;
                curve = this.configuration.getEcImplicitlyCa().getCurve();
                bytes = subjectPublicKeyInfo.getPublicKeyData().getBytes();
                dEROctetString = new DEROctetString(bytes);
                if (bytes[0] == 4 && bytes[1] == bytes.length - 2 && ((bytes[2] == 2 || bytes[2] == 3) && new X9IntegerConverter().getByteLength(curve) >= bytes.length - 3)) {
                    try {
                        dEROctetString = (ASN1OctetString) ASN1Primitive.fromByteArray(bytes);
                    } catch (IOException unused) {
                        throw new IllegalArgumentException("error recovering public key");
                    }
                }
                this.q = new X9ECPoint(curve, dEROctetString).getPoint();
            }
            X9ECParameters x9ECParameters = X9ECParameters.getInstance(x962Parameters.getParameters());
            curve = x9ECParameters.getCurve();
            eCParameterSpec = new ECParameterSpec(EC5Util.convertCurve(curve, x9ECParameters.getSeed()), new java.security.spec.ECPoint(x9ECParameters.getG().getAffineXCoord().toBigInteger(), x9ECParameters.getG().getAffineYCoord().toBigInteger()), x9ECParameters.getN(), x9ECParameters.getH().intValue());
        }
        this.ecSpec = eCParameterSpec;
        bytes = subjectPublicKeyInfo.getPublicKeyData().getBytes();
        dEROctetString = new DEROctetString(bytes);
        if (bytes[0] == 4) {
            dEROctetString = (ASN1OctetString) ASN1Primitive.fromByteArray(bytes);
        }
        this.q = new X9ECPoint(curve, dEROctetString).getPoint();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) objectInputStream.readObject())));
        this.configuration = BouncyCastleProvider.CONFIGURATION;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public ECPoint engineGetQ() {
        return this.q;
    }

    public org.bouncycastle.jce.spec.ECParameterSpec engineGetSpec() {
        ECParameterSpec eCParameterSpec = this.ecSpec;
        return eCParameterSpec != null ? EC5Util.convertSpec(eCParameterSpec, this.withCompression) : this.configuration.getEcImplicitlyCa();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCECPublicKey)) {
            return false;
        }
        BCECPublicKey bCECPublicKey = (BCECPublicKey) obj;
        return engineGetQ().equals(bCECPublicKey.engineGetQ()) && engineGetSpec().equals(bCECPublicKey.engineGetSpec());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        X962Parameters x962Parameters;
        ECParameterSpec eCParameterSpec = this.ecSpec;
        if (eCParameterSpec instanceof ECNamedCurveSpec) {
            ASN1ObjectIdentifier namedCurveOid = ECUtil.getNamedCurveOid(((ECNamedCurveSpec) eCParameterSpec).getName());
            if (namedCurveOid == null) {
                namedCurveOid = new ASN1ObjectIdentifier(((ECNamedCurveSpec) this.ecSpec).getName());
            }
            x962Parameters = new X962Parameters(namedCurveOid);
        } else if (eCParameterSpec == null) {
            x962Parameters = new X962Parameters(DERNull.INSTANCE);
        } else {
            ECCurve eCCurveConvertCurve = EC5Util.convertCurve(eCParameterSpec.getCurve());
            x962Parameters = new X962Parameters(new X9ECParameters(eCCurveConvertCurve, EC5Util.convertPoint(eCCurveConvertCurve, this.ecSpec.getGenerator(), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
        }
        ECCurve curve = engineGetQ().getCurve();
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, (ASN1Encodable) x962Parameters), ((ASN1OctetString) (this.ecSpec == null ? new X9ECPoint(curve.createPoint(getQ().getXCoord().toBigInteger(), getQ().getYCoord().toBigInteger(), this.withCompression)) : new X9ECPoint(curve.createPoint(getQ().getAffineXCoord().toBigInteger(), getQ().getAffineYCoord().toBigInteger(), this.withCompression))).toASN1Primitive()).getOctets()));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.jce.interfaces.ECKey
    public org.bouncycastle.jce.spec.ECParameterSpec getParameters() {
        ECParameterSpec eCParameterSpec = this.ecSpec;
        if (eCParameterSpec == null) {
            return null;
        }
        return EC5Util.convertSpec(eCParameterSpec, this.withCompression);
    }

    @Override // java.security.interfaces.ECKey
    public ECParameterSpec getParams() {
        return this.ecSpec;
    }

    @Override // org.bouncycastle.jce.interfaces.ECPublicKey
    public ECPoint getQ() {
        return this.ecSpec == null ? this.q instanceof ECPoint.Fp ? new ECPoint.Fp(null, this.q.getAffineXCoord(), this.q.getAffineYCoord()) : new ECPoint.F2m(null, this.q.getAffineXCoord(), this.q.getAffineYCoord()) : this.q;
    }

    @Override // java.security.interfaces.ECPublicKey
    public java.security.spec.ECPoint getW() {
        return new java.security.spec.ECPoint(this.q.getAffineXCoord().toBigInteger(), this.q.getAffineYCoord().toBigInteger());
    }

    public int hashCode() {
        return engineGetQ().hashCode() ^ engineGetSpec().hashCode();
    }

    @Override // org.bouncycastle.jce.interfaces.ECPointEncoder
    public void setPointFormat(String str) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String property = System.getProperty("line.separator");
        stringBuffer.append("EC Public Key");
        stringBuffer.append(property);
        stringBuffer.append("            X: ");
        stringBuffer.append(this.q.getAffineXCoord().toBigInteger().toString(16));
        stringBuffer.append(property);
        stringBuffer.append("            Y: ");
        stringBuffer.append(this.q.getAffineYCoord().toBigInteger().toString(16));
        stringBuffer.append(property);
        return stringBuffer.toString();
    }
}
