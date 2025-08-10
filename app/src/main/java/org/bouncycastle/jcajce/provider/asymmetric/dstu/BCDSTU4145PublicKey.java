package org.bouncycastle.jcajce.provider.asymmetric.dstu;

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
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.ua.DSTU4145BinaryField;
import org.bouncycastle.asn1.ua.DSTU4145ECBinary;
import org.bouncycastle.asn1.ua.DSTU4145NamedCurves;
import org.bouncycastle.asn1.ua.DSTU4145Params;
import org.bouncycastle.asn1.ua.DSTU4145PointEncoder;
import org.bouncycastle.asn1.ua.UAObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jce.interfaces.ECPointEncoder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

/* loaded from: classes5.dex */
public class BCDSTU4145PublicKey implements ECPublicKey, org.bouncycastle.jce.interfaces.ECPublicKey, ECPointEncoder {
    public static final long serialVersionUID = 7026240464295649314L;
    private String algorithm;
    private transient DSTU4145Params dstuParams;
    private transient ECParameterSpec ecSpec;
    private transient ECPoint q;
    private boolean withCompression;

    public BCDSTU4145PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters) {
        this.algorithm = "DSTU4145";
        this.algorithm = str;
        this.q = eCPublicKeyParameters.getQ();
        this.ecSpec = null;
    }

    public BCDSTU4145PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ECParameterSpec eCParameterSpec) {
        this.algorithm = "DSTU4145";
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        this.q = eCPublicKeyParameters.getQ();
        if (eCParameterSpec == null) {
            this.ecSpec = createSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), parameters);
        } else {
            this.ecSpec = eCParameterSpec;
        }
    }

    public BCDSTU4145PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        this.algorithm = "DSTU4145";
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        this.q = eCPublicKeyParameters.getQ();
        this.ecSpec = eCParameterSpec == null ? createSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), parameters) : EC5Util.convertSpec(EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.getSeed()), eCParameterSpec);
    }

    public BCDSTU4145PublicKey(ECPublicKey eCPublicKey) {
        this.algorithm = "DSTU4145";
        this.algorithm = eCPublicKey.getAlgorithm();
        ECParameterSpec params = eCPublicKey.getParams();
        this.ecSpec = params;
        this.q = EC5Util.convertPoint(params, eCPublicKey.getW(), false);
    }

    public BCDSTU4145PublicKey(ECPublicKeySpec eCPublicKeySpec) {
        this.algorithm = "DSTU4145";
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.ecSpec = params;
        this.q = EC5Util.convertPoint(params, eCPublicKeySpec.getW(), false);
    }

    public BCDSTU4145PublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.algorithm = "DSTU4145";
        populateFromPubKeyInfo(subjectPublicKeyInfo);
    }

    public BCDSTU4145PublicKey(BCDSTU4145PublicKey bCDSTU4145PublicKey) {
        this.algorithm = "DSTU4145";
        this.q = bCDSTU4145PublicKey.q;
        this.ecSpec = bCDSTU4145PublicKey.ecSpec;
        this.withCompression = bCDSTU4145PublicKey.withCompression;
        this.dstuParams = bCDSTU4145PublicKey.dstuParams;
    }

    public BCDSTU4145PublicKey(org.bouncycastle.jce.spec.ECPublicKeySpec eCPublicKeySpec) {
        ECParameterSpec eCParameterSpecConvertSpec;
        this.algorithm = "DSTU4145";
        this.q = eCPublicKeySpec.getQ();
        if (eCPublicKeySpec.getParams() != null) {
            eCParameterSpecConvertSpec = EC5Util.convertSpec(EC5Util.convertCurve(eCPublicKeySpec.getParams().getCurve(), eCPublicKeySpec.getParams().getSeed()), eCPublicKeySpec.getParams());
        } else {
            if (this.q.getCurve() == null) {
                this.q = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa().getCurve().createPoint(this.q.getAffineXCoord().toBigInteger(), this.q.getAffineYCoord().toBigInteger());
            }
            eCParameterSpecConvertSpec = null;
        }
        this.ecSpec = eCParameterSpecConvertSpec;
    }

    private ECParameterSpec createSpec(EllipticCurve ellipticCurve, ECDomainParameters eCDomainParameters) {
        return new ECParameterSpec(ellipticCurve, new java.security.spec.ECPoint(eCDomainParameters.getG().getAffineXCoord().toBigInteger(), eCDomainParameters.getG().getAffineYCoord().toBigInteger()), eCDomainParameters.getN(), eCDomainParameters.getH().intValue());
    }

    private void populateFromPubKeyInfo(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec;
        DERBitString publicKeyData = subjectPublicKeyInfo.getPublicKeyData();
        this.algorithm = "DSTU4145";
        try {
            byte[] octets = ((ASN1OctetString) ASN1Primitive.fromByteArray(publicKeyData.getBytes())).getOctets();
            ASN1ObjectIdentifier algorithm = subjectPublicKeyInfo.getAlgorithm().getAlgorithm();
            ASN1ObjectIdentifier aSN1ObjectIdentifier = UAObjectIdentifiers.dstu4145le;
            if (algorithm.equals(aSN1ObjectIdentifier)) {
                reverseBytes(octets);
            }
            DSTU4145Params dSTU4145Params = DSTU4145Params.getInstance((ASN1Sequence) subjectPublicKeyInfo.getAlgorithm().getParameters());
            this.dstuParams = dSTU4145Params;
            if (dSTU4145Params.isNamedCurve()) {
                ASN1ObjectIdentifier namedCurve = this.dstuParams.getNamedCurve();
                ECDomainParameters byOID = DSTU4145NamedCurves.getByOID(namedCurve);
                eCParameterSpec = new ECNamedCurveParameterSpec(namedCurve.getId(), byOID.getCurve(), byOID.getG(), byOID.getN(), byOID.getH(), byOID.getSeed());
            } else {
                DSTU4145ECBinary eCBinary = this.dstuParams.getECBinary();
                byte[] b = eCBinary.getB();
                if (subjectPublicKeyInfo.getAlgorithm().getAlgorithm().equals(aSN1ObjectIdentifier)) {
                    reverseBytes(b);
                }
                DSTU4145BinaryField field = eCBinary.getField();
                ECCurve.F2m f2m = new ECCurve.F2m(field.getM(), field.getK1(), field.getK2(), field.getK3(), eCBinary.getA(), new BigInteger(1, b));
                byte[] g = eCBinary.getG();
                if (subjectPublicKeyInfo.getAlgorithm().getAlgorithm().equals(aSN1ObjectIdentifier)) {
                    reverseBytes(g);
                }
                eCParameterSpec = new org.bouncycastle.jce.spec.ECParameterSpec(f2m, DSTU4145PointEncoder.decodePoint(f2m, g), eCBinary.getN());
            }
            ECCurve curve = eCParameterSpec.getCurve();
            EllipticCurve ellipticCurveConvertCurve = EC5Util.convertCurve(curve, eCParameterSpec.getSeed());
            this.q = DSTU4145PointEncoder.decodePoint(curve, octets);
            this.ecSpec = this.dstuParams.isNamedCurve() ? new ECNamedCurveSpec(this.dstuParams.getNamedCurve().getId(), ellipticCurveConvertCurve, new java.security.spec.ECPoint(eCParameterSpec.getG().getAffineXCoord().toBigInteger(), eCParameterSpec.getG().getAffineYCoord().toBigInteger()), eCParameterSpec.getN(), eCParameterSpec.getH()) : new ECParameterSpec(ellipticCurveConvertCurve, new java.security.spec.ECPoint(eCParameterSpec.getG().getAffineXCoord().toBigInteger(), eCParameterSpec.getG().getAffineYCoord().toBigInteger()), eCParameterSpec.getN(), eCParameterSpec.getH().intValue());
        } catch (IOException unused) {
            throw new IllegalArgumentException("error recovering public key");
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) objectInputStream.readObject())));
    }

    private void reverseBytes(byte[] bArr) {
        for (int i = 0; i < bArr.length / 2; i++) {
            byte b = bArr[i];
            bArr[i] = bArr[(bArr.length - 1) - i];
            bArr[(bArr.length - 1) - i] = b;
        }
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
        return eCParameterSpec != null ? EC5Util.convertSpec(eCParameterSpec, this.withCompression) : BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCDSTU4145PublicKey)) {
            return false;
        }
        BCDSTU4145PublicKey bCDSTU4145PublicKey = (BCDSTU4145PublicKey) obj;
        return engineGetQ().equals(bCDSTU4145PublicKey.engineGetQ()) && engineGetSpec().equals(bCDSTU4145PublicKey.engineGetSpec());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        ASN1Encodable x962Parameters = this.dstuParams;
        if (x962Parameters == null) {
            ECParameterSpec eCParameterSpec = this.ecSpec;
            if (eCParameterSpec instanceof ECNamedCurveSpec) {
                x962Parameters = new DSTU4145Params(new ASN1ObjectIdentifier(((ECNamedCurveSpec) this.ecSpec).getName()));
            } else {
                ECCurve eCCurveConvertCurve = EC5Util.convertCurve(eCParameterSpec.getCurve());
                x962Parameters = new X962Parameters(new X9ECParameters(eCCurveConvertCurve, EC5Util.convertPoint(eCCurveConvertCurve, this.ecSpec.getGenerator(), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
            }
        }
        try {
            return KeyUtil.getEncodedSubjectPublicKeyInfo(new SubjectPublicKeyInfo(new AlgorithmIdentifier(UAObjectIdentifiers.dstu4145be, x962Parameters), new DEROctetString(DSTU4145PointEncoder.encodePoint(this.q))));
        } catch (IOException unused) {
            return null;
        }
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

    public byte[] getSbox() {
        DSTU4145Params dSTU4145Params = this.dstuParams;
        return dSTU4145Params != null ? dSTU4145Params.getDKE() : DSTU4145Params.getDefaultDKE();
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
