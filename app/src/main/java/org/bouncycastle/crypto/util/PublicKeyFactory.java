package org.bouncycastle.crypto.util;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.oiw.ElGamalParameter;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.DHParameter;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSAPublicKey;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DSAParameter;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.asn1.x9.DHDomainParameters;
import org.bouncycastle.asn1.x9.DHPublicKey;
import org.bouncycastle.asn1.x9.DHValidationParms;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.crypto.params.DHValidationParameters;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ElGamalParameters;
import org.bouncycastle.crypto.params.ElGamalPublicKeyParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;

/* loaded from: classes5.dex */
public class PublicKeyFactory {
    public static AsymmetricKeyParameter createKey(InputStream inputStream) throws IOException {
        return createKey(SubjectPublicKeyInfo.getInstance(new ASN1InputStream(inputStream).readObject()));
    }

    public static AsymmetricKeyParameter createKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        AlgorithmIdentifier algorithm = subjectPublicKeyInfo.getAlgorithm();
        if (algorithm.getAlgorithm().equals(PKCSObjectIdentifiers.rsaEncryption) || algorithm.getAlgorithm().equals(X509ObjectIdentifiers.id_ea_rsa)) {
            RSAPublicKey rSAPublicKey = RSAPublicKey.getInstance(subjectPublicKeyInfo.parsePublicKey());
            return new RSAKeyParameters(false, rSAPublicKey.getModulus(), rSAPublicKey.getPublicExponent());
        }
        DSAParameters dSAParameters = null;
        if (algorithm.getAlgorithm().equals(X9ObjectIdentifiers.dhpublicnumber)) {
            BigInteger value = DHPublicKey.getInstance(subjectPublicKeyInfo.parsePublicKey()).getY().getValue();
            DHDomainParameters dHDomainParameters = DHDomainParameters.getInstance(algorithm.getParameters());
            BigInteger value2 = dHDomainParameters.getP().getValue();
            BigInteger value3 = dHDomainParameters.getG().getValue();
            BigInteger value4 = dHDomainParameters.getQ().getValue();
            BigInteger value5 = dHDomainParameters.getJ() != null ? dHDomainParameters.getJ().getValue() : null;
            DHValidationParms validationParms = dHDomainParameters.getValidationParms();
            return new DHPublicKeyParameters(value, new DHParameters(value2, value3, value4, value5, validationParms != null ? new DHValidationParameters(validationParms.getSeed().getBytes(), validationParms.getPgenCounter().getValue().intValue()) : null));
        }
        if (algorithm.getAlgorithm().equals(PKCSObjectIdentifiers.dhKeyAgreement)) {
            DHParameter dHParameter = DHParameter.getInstance(algorithm.getParameters());
            ASN1Integer aSN1Integer = (ASN1Integer) subjectPublicKeyInfo.parsePublicKey();
            BigInteger l = dHParameter.getL();
            return new DHPublicKeyParameters(aSN1Integer.getValue(), new DHParameters(dHParameter.getP(), dHParameter.getG(), null, l != null ? l.intValue() : 0));
        }
        if (algorithm.getAlgorithm().equals(OIWObjectIdentifiers.elGamalAlgorithm)) {
            ElGamalParameter elGamalParameter = new ElGamalParameter((ASN1Sequence) algorithm.getParameters());
            return new ElGamalPublicKeyParameters(((ASN1Integer) subjectPublicKeyInfo.parsePublicKey()).getValue(), new ElGamalParameters(elGamalParameter.getP(), elGamalParameter.getG()));
        }
        if (algorithm.getAlgorithm().equals(X9ObjectIdentifiers.id_dsa) || algorithm.getAlgorithm().equals(OIWObjectIdentifiers.dsaWithSHA1)) {
            ASN1Integer aSN1Integer2 = (ASN1Integer) subjectPublicKeyInfo.parsePublicKey();
            ASN1Encodable parameters = algorithm.getParameters();
            if (parameters != null) {
                DSAParameter dSAParameter = DSAParameter.getInstance(parameters.toASN1Primitive());
                dSAParameters = new DSAParameters(dSAParameter.getP(), dSAParameter.getQ(), dSAParameter.getG());
            }
            return new DSAPublicKeyParameters(aSN1Integer2.getValue(), dSAParameters);
        }
        if (!algorithm.getAlgorithm().equals(X9ObjectIdentifiers.id_ecPublicKey)) {
            throw new RuntimeException("algorithm identifier in key not recognised");
        }
        X962Parameters x962Parameters = X962Parameters.getInstance(algorithm.getParameters());
        boolean zIsNamedCurve = x962Parameters.isNamedCurve();
        ASN1Primitive parameters2 = x962Parameters.getParameters();
        X9ECParameters byOID = zIsNamedCurve ? ECNamedCurveTable.getByOID((ASN1ObjectIdentifier) parameters2) : X9ECParameters.getInstance(parameters2);
        return new ECPublicKeyParameters(new X9ECPoint(byOID.getCurve(), new DEROctetString(subjectPublicKeyInfo.getPublicKeyData().getBytes())).getPoint(), new ECDomainParameters(byOID.getCurve(), byOID.getG(), byOID.getN(), byOID.getH(), byOID.getSeed()));
    }

    public static AsymmetricKeyParameter createKey(byte[] bArr) throws IOException {
        return createKey(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(bArr)));
    }
}
