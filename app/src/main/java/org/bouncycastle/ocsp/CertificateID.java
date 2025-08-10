package org.bouncycastle.ocsp;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.cert.X509Certificate;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.ocsp.CertID;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jce.PrincipalUtil;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* loaded from: classes5.dex */
public class CertificateID {
    public static final String HASH_SHA1 = "1.3.14.3.2.26";
    private final CertID id;

    public CertificateID(String str, X509Certificate x509Certificate, BigInteger bigInteger) throws OCSPException {
        this(str, x509Certificate, bigInteger, BouncyCastleProvider.PROVIDER_NAME);
    }

    public CertificateID(String str, X509Certificate x509Certificate, BigInteger bigInteger, String str2) throws OCSPException {
        this.id = createCertID(new AlgorithmIdentifier(new DERObjectIdentifier(str), DERNull.INSTANCE), x509Certificate, new ASN1Integer(bigInteger), str2);
    }

    public CertificateID(CertID certID) {
        if (certID == null) {
            throw new IllegalArgumentException("'id' cannot be null");
        }
        this.id = certID;
    }

    private static CertID createCertID(AlgorithmIdentifier algorithmIdentifier, X509Certificate x509Certificate, ASN1Integer aSN1Integer, String str) throws OCSPException {
        try {
            MessageDigest messageDigestCreateDigestInstance = OCSPUtil.createDigestInstance(algorithmIdentifier.getAlgorithm().getId(), str);
            messageDigestCreateDigestInstance.update(PrincipalUtil.getSubjectX509Principal(x509Certificate).getEncoded());
            DEROctetString dEROctetString = new DEROctetString(messageDigestCreateDigestInstance.digest());
            messageDigestCreateDigestInstance.update(SubjectPublicKeyInfo.getInstance(new ASN1InputStream(x509Certificate.getPublicKey().getEncoded()).readObject()).getPublicKeyData().getBytes());
            return new CertID(algorithmIdentifier, dEROctetString, new DEROctetString(messageDigestCreateDigestInstance.digest()), aSN1Integer);
        } catch (Exception e) {
            throw new OCSPException("problem creating ID: " + e, e);
        }
    }

    public static CertificateID deriveCertificateID(CertificateID certificateID, BigInteger bigInteger) {
        return new CertificateID(new CertID(certificateID.id.getHashAlgorithm(), certificateID.id.getIssuerNameHash(), certificateID.id.getIssuerKeyHash(), new ASN1Integer(bigInteger)));
    }

    public boolean equals(Object obj) {
        if (obj instanceof CertificateID) {
            return this.id.toASN1Primitive().equals(((CertificateID) obj).id.toASN1Primitive());
        }
        return false;
    }

    public String getHashAlgOID() {
        return this.id.getHashAlgorithm().getObjectId().getId();
    }

    public byte[] getIssuerKeyHash() {
        return this.id.getIssuerKeyHash().getOctets();
    }

    public byte[] getIssuerNameHash() {
        return this.id.getIssuerNameHash().getOctets();
    }

    public BigInteger getSerialNumber() {
        return this.id.getSerialNumber().getValue();
    }

    public int hashCode() {
        return this.id.toASN1Primitive().hashCode();
    }

    public boolean matchesIssuer(X509Certificate x509Certificate, String str) throws OCSPException {
        return createCertID(this.id.getHashAlgorithm(), x509Certificate, this.id.getSerialNumber(), str).equals(this.id);
    }

    public CertID toASN1Object() {
        return this.id;
    }
}
