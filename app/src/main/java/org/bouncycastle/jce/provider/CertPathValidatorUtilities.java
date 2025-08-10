package org.bouncycastle.jce.provider;

import androidx.core.os.EnvironmentCompat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.PKIXParameters;
import java.security.cert.PolicyQualifierInfo;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509Certificate;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAPublicKeySpec;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1OutputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEREnumerated;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.isismtt.ISISMTTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.CRLDistPoint;
import org.bouncycastle.asn1.x509.DistributionPoint;
import org.bouncycastle.asn1.x509.DistributionPointName;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.X509Extension;
import org.bouncycastle.jce.X509LDAPCertStoreParameters;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.StoreException;
import org.bouncycastle.x509.ExtendedPKIXBuilderParameters;
import org.bouncycastle.x509.ExtendedPKIXParameters;
import org.bouncycastle.x509.X509AttributeCertStoreSelector;
import org.bouncycastle.x509.X509AttributeCertificate;
import org.bouncycastle.x509.X509CRLStoreSelector;
import org.bouncycastle.x509.X509CertStoreSelector;
import org.bouncycastle.x509.X509Store;

/* loaded from: classes5.dex */
public class CertPathValidatorUtilities {
    public static final String ANY_POLICY = "2.5.29.32.0";
    public static final int CRL_SIGN = 6;
    public static final int KEY_CERT_SIGN = 5;
    public static final PKIXCRLUtil CRL_UTIL = new PKIXCRLUtil();
    public static final String CERTIFICATE_POLICIES = Extension.certificatePolicies.getId();
    public static final String BASIC_CONSTRAINTS = Extension.basicConstraints.getId();
    public static final String POLICY_MAPPINGS = Extension.policyMappings.getId();
    public static final String SUBJECT_ALTERNATIVE_NAME = Extension.subjectAlternativeName.getId();
    public static final String NAME_CONSTRAINTS = Extension.nameConstraints.getId();
    public static final String KEY_USAGE = Extension.keyUsage.getId();
    public static final String INHIBIT_ANY_POLICY = Extension.inhibitAnyPolicy.getId();
    public static final String ISSUING_DISTRIBUTION_POINT = Extension.issuingDistributionPoint.getId();
    public static final String DELTA_CRL_INDICATOR = Extension.deltaCRLIndicator.getId();
    public static final String POLICY_CONSTRAINTS = Extension.policyConstraints.getId();
    public static final String FRESHEST_CRL = Extension.freshestCRL.getId();
    public static final String CRL_DISTRIBUTION_POINTS = Extension.cRLDistributionPoints.getId();
    public static final String AUTHORITY_KEY_IDENTIFIER = Extension.authorityKeyIdentifier.getId();
    public static final String CRL_NUMBER = Extension.cRLNumber.getId();
    public static final String[] crlReasons = {"unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", EnvironmentCompat.MEDIA_UNKNOWN, "removeFromCRL", "privilegeWithdrawn", "aACompromise"};

    public static void addAdditionalStoreFromLocation(String str, ExtendedPKIXParameters extendedPKIXParameters) {
        String str2;
        if (extendedPKIXParameters.isAdditionalLocationsEnabled()) {
            try {
                if (str.startsWith("ldap://")) {
                    String strSubstring = str.substring(7);
                    String strSubstring2 = null;
                    if (strSubstring.indexOf("/") != -1) {
                        strSubstring2 = strSubstring.substring(strSubstring.indexOf("/"));
                        str2 = "ldap://" + strSubstring.substring(0, strSubstring.indexOf("/"));
                    } else {
                        str2 = "ldap://" + strSubstring;
                    }
                    X509LDAPCertStoreParameters x509LDAPCertStoreParametersBuild = new X509LDAPCertStoreParameters.Builder(str2, strSubstring2).build();
                    extendedPKIXParameters.addAdditionalStore(X509Store.getInstance("CERTIFICATE/LDAP", x509LDAPCertStoreParametersBuild, BouncyCastleProvider.PROVIDER_NAME));
                    extendedPKIXParameters.addAdditionalStore(X509Store.getInstance("CRL/LDAP", x509LDAPCertStoreParametersBuild, BouncyCastleProvider.PROVIDER_NAME));
                    extendedPKIXParameters.addAdditionalStore(X509Store.getInstance("ATTRIBUTECERTIFICATE/LDAP", x509LDAPCertStoreParametersBuild, BouncyCastleProvider.PROVIDER_NAME));
                    extendedPKIXParameters.addAdditionalStore(X509Store.getInstance("CERTIFICATEPAIR/LDAP", x509LDAPCertStoreParametersBuild, BouncyCastleProvider.PROVIDER_NAME));
                }
            } catch (Exception unused) {
                throw new RuntimeException("Exception adding X.509 stores.");
            }
        }
    }

    public static void addAdditionalStoresFromAltNames(X509Certificate x509Certificate, ExtendedPKIXParameters extendedPKIXParameters) throws CertificateParsingException {
        if (x509Certificate.getIssuerAlternativeNames() != null) {
            for (List<?> list : x509Certificate.getIssuerAlternativeNames()) {
                if (list.get(0).equals(Integers.valueOf(6))) {
                    addAdditionalStoreFromLocation((String) list.get(1), extendedPKIXParameters);
                }
            }
        }
    }

    public static void addAdditionalStoresFromCRLDistributionPoint(CRLDistPoint cRLDistPoint, ExtendedPKIXParameters extendedPKIXParameters) throws AnnotatedException {
        if (cRLDistPoint != null) {
            try {
                for (DistributionPoint distributionPoint : cRLDistPoint.getDistributionPoints()) {
                    DistributionPointName distributionPoint2 = distributionPoint.getDistributionPoint();
                    if (distributionPoint2 != null && distributionPoint2.getType() == 0) {
                        GeneralName[] names = GeneralNames.getInstance(distributionPoint2.getName()).getNames();
                        for (int i = 0; i < names.length; i++) {
                            if (names[i].getTagNo() == 6) {
                                addAdditionalStoreFromLocation(DERIA5String.getInstance(names[i].getName()).getString(), extendedPKIXParameters);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                throw new AnnotatedException("Distribution points could not be read.", e);
            }
        }
    }

    public static Collection findCertificates(X509AttributeCertStoreSelector x509AttributeCertStoreSelector, List list) throws AnnotatedException {
        HashSet hashSet = new HashSet();
        for (Object obj : list) {
            if (obj instanceof X509Store) {
                try {
                    hashSet.addAll(((X509Store) obj).getMatches(x509AttributeCertStoreSelector));
                } catch (StoreException e) {
                    throw new AnnotatedException("Problem while picking certificates from X.509 store.", e);
                }
            }
        }
        return hashSet;
    }

    public static Collection findCertificates(X509CertStoreSelector x509CertStoreSelector, List list) throws AnnotatedException {
        HashSet hashSet = new HashSet();
        for (Object obj : list) {
            if (obj instanceof X509Store) {
                try {
                    hashSet.addAll(((X509Store) obj).getMatches(x509CertStoreSelector));
                } catch (StoreException e) {
                    throw new AnnotatedException("Problem while picking certificates from X.509 store.", e);
                }
            } else {
                try {
                    hashSet.addAll(((CertStore) obj).getCertificates(x509CertStoreSelector));
                } catch (CertStoreException e2) {
                    throw new AnnotatedException("Problem while picking certificates from certificate store.", e2);
                }
            }
        }
        return hashSet;
    }

    public static Collection findIssuerCerts(X509Certificate x509Certificate, ExtendedPKIXBuilderParameters extendedPKIXBuilderParameters) throws AnnotatedException, IOException {
        X509CertStoreSelector x509CertStoreSelector = new X509CertStoreSelector();
        HashSet hashSet = new HashSet();
        try {
            x509CertStoreSelector.setSubject(x509Certificate.getIssuerX500Principal().getEncoded());
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(findCertificates(x509CertStoreSelector, extendedPKIXBuilderParameters.getCertStores()));
                arrayList.addAll(findCertificates(x509CertStoreSelector, extendedPKIXBuilderParameters.getStores()));
                arrayList.addAll(findCertificates(x509CertStoreSelector, extendedPKIXBuilderParameters.getAdditionalStores()));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    hashSet.add((X509Certificate) it.next());
                }
                return hashSet;
            } catch (AnnotatedException e) {
                throw new AnnotatedException("Issuer certificate cannot be searched.", e);
            }
        } catch (IOException e2) {
            throw new AnnotatedException("Subject criteria for certificate selector to find issuer certificate could not be set.", e2);
        }
    }

    public static TrustAnchor findTrustAnchor(X509Certificate x509Certificate, Set set) throws AnnotatedException {
        return findTrustAnchor(x509Certificate, set, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.security.cert.TrustAnchor findTrustAnchor(java.security.cert.X509Certificate r8, java.util.Set r9, java.lang.String r10) throws org.bouncycastle.jce.provider.AnnotatedException, java.io.IOException {
        /*
            java.security.cert.X509CertSelector r0 = new java.security.cert.X509CertSelector
            r0.<init>()
            javax.security.auth.x500.X500Principal r1 = getEncodedIssuerPrincipal(r8)
            byte[] r2 = r1.getEncoded()     // Catch: java.io.IOException -> L78
            r0.setSubject(r2)     // Catch: java.io.IOException -> L78
            java.util.Iterator r9 = r9.iterator()
            r2 = 0
            r3 = r2
            r4 = r3
            r5 = r4
        L18:
            boolean r6 = r9.hasNext()
            if (r6 == 0) goto L6a
            if (r3 != 0) goto L6a
            java.lang.Object r3 = r9.next()
            java.security.cert.TrustAnchor r3 = (java.security.cert.TrustAnchor) r3
            java.security.cert.X509Certificate r6 = r3.getTrustedCert()
            if (r6 == 0) goto L3f
            java.security.cert.X509Certificate r6 = r3.getTrustedCert()
            boolean r6 = r0.match(r6)
            if (r6 == 0) goto L5f
            java.security.cert.X509Certificate r5 = r3.getTrustedCert()
            java.security.PublicKey r5 = r5.getPublicKey()
            goto L60
        L3f:
            java.lang.String r6 = r3.getCAName()
            if (r6 == 0) goto L5f
            java.security.PublicKey r6 = r3.getCAPublicKey()
            if (r6 == 0) goto L5f
            javax.security.auth.x500.X500Principal r6 = new javax.security.auth.x500.X500Principal     // Catch: java.lang.IllegalArgumentException -> L5f
            java.lang.String r7 = r3.getCAName()     // Catch: java.lang.IllegalArgumentException -> L5f
            r6.<init>(r7)     // Catch: java.lang.IllegalArgumentException -> L5f
            boolean r6 = r1.equals(r6)     // Catch: java.lang.IllegalArgumentException -> L5f
            if (r6 == 0) goto L5f
            java.security.PublicKey r5 = r3.getCAPublicKey()     // Catch: java.lang.IllegalArgumentException -> L5f
            goto L60
        L5f:
            r3 = r2
        L60:
            if (r5 == 0) goto L18
            verifyX509Certificate(r8, r5, r10)     // Catch: java.lang.Exception -> L66
            goto L18
        L66:
            r4 = move-exception
            r3 = r2
            r5 = r3
            goto L18
        L6a:
            if (r3 != 0) goto L77
            if (r4 != 0) goto L6f
            goto L77
        L6f:
            org.bouncycastle.jce.provider.AnnotatedException r8 = new org.bouncycastle.jce.provider.AnnotatedException
            java.lang.String r9 = "TrustAnchor found but certificate validation failed."
            r8.<init>(r9, r4)
            throw r8
        L77:
            return r3
        L78:
            r8 = move-exception
            org.bouncycastle.jce.provider.AnnotatedException r9 = new org.bouncycastle.jce.provider.AnnotatedException
            java.lang.String r10 = "Cannot set subject search criteria for trust anchor."
            r9.<init>(r10, r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jce.provider.CertPathValidatorUtilities.findTrustAnchor(java.security.cert.X509Certificate, java.util.Set, java.lang.String):java.security.cert.TrustAnchor");
    }

    public static AlgorithmIdentifier getAlgorithmIdentifier(PublicKey publicKey) throws CertPathValidatorException {
        try {
            return SubjectPublicKeyInfo.getInstance(new ASN1InputStream(publicKey.getEncoded()).readObject()).getAlgorithmId();
        } catch (Exception e) {
            throw new ExtCertPathValidatorException("Subject public key cannot be decoded.", e);
        }
    }

    public static void getCRLIssuersFromDistributionPoint(DistributionPoint distributionPoint, Collection collection, X509CRLSelector x509CRLSelector, ExtendedPKIXParameters extendedPKIXParameters) throws AnnotatedException, IOException {
        ArrayList arrayList = new ArrayList();
        if (distributionPoint.getCRLIssuer() != null) {
            GeneralName[] names = distributionPoint.getCRLIssuer().getNames();
            for (int i = 0; i < names.length; i++) {
                if (names[i].getTagNo() == 4) {
                    try {
                        arrayList.add(new X500Principal(names[i].getName().toASN1Primitive().getEncoded()));
                    } catch (IOException e) {
                        throw new AnnotatedException("CRL issuer information from distribution point cannot be decoded.", e);
                    }
                }
            }
        } else {
            if (distributionPoint.getDistributionPoint() == null) {
                throw new AnnotatedException("CRL issuer is omitted from distribution point but no distributionPoint field present.");
            }
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add((X500Principal) it.next());
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            try {
                x509CRLSelector.addIssuerName(((X500Principal) it2.next()).getEncoded());
            } catch (IOException e2) {
                throw new AnnotatedException("Cannot decode CRL issuer information.", e2);
            }
        }
    }

    public static void getCertStatus(Date date, X509CRL x509crl, Object obj, CertStatus certStatus) throws AnnotatedException {
        X509CRLEntry revokedCertificate;
        try {
            if (X509CRLObject.isIndirectCRL(x509crl)) {
                revokedCertificate = x509crl.getRevokedCertificate(getSerialNumber(obj));
                if (revokedCertificate == null) {
                    return;
                }
                X500Principal certificateIssuer = revokedCertificate.getCertificateIssuer();
                if (certificateIssuer == null) {
                    certificateIssuer = getIssuerPrincipal(x509crl);
                }
                if (!getEncodedIssuerPrincipal(obj).equals(certificateIssuer)) {
                    return;
                }
            } else if (!getEncodedIssuerPrincipal(obj).equals(getIssuerPrincipal(x509crl)) || (revokedCertificate = x509crl.getRevokedCertificate(getSerialNumber(obj))) == null) {
                return;
            }
            ASN1Enumerated dEREnumerated = null;
            if (revokedCertificate.hasExtensions()) {
                try {
                    dEREnumerated = DEREnumerated.getInstance(getExtensionValue(revokedCertificate, X509Extension.reasonCode.getId()));
                } catch (Exception e) {
                    throw new AnnotatedException("Reason code CRL entry extension could not be decoded.", e);
                }
            }
            if (date.getTime() >= revokedCertificate.getRevocationDate().getTime() || dEREnumerated == null || dEREnumerated.getValue().intValue() == 0 || dEREnumerated.getValue().intValue() == 1 || dEREnumerated.getValue().intValue() == 2 || dEREnumerated.getValue().intValue() == 8) {
                certStatus.setCertStatus(dEREnumerated != null ? dEREnumerated.getValue().intValue() : 0);
                certStatus.setRevocationDate(revokedCertificate.getRevocationDate());
            }
        } catch (CRLException e2) {
            throw new AnnotatedException("Failed check for indirect CRL.", e2);
        }
    }

    public static Set getCompleteCRLs(DistributionPoint distributionPoint, Object obj, Date date, ExtendedPKIXParameters extendedPKIXParameters) throws AnnotatedException, IOException {
        X509CRLStoreSelector x509CRLStoreSelector = new X509CRLStoreSelector();
        try {
            HashSet hashSet = new HashSet();
            hashSet.add(obj instanceof X509AttributeCertificate ? ((X509AttributeCertificate) obj).getIssuer().getPrincipals()[0] : getEncodedIssuerPrincipal(obj));
            getCRLIssuersFromDistributionPoint(distributionPoint, hashSet, x509CRLStoreSelector, extendedPKIXParameters);
            if (obj instanceof X509Certificate) {
                x509CRLStoreSelector.setCertificateChecking((X509Certificate) obj);
            } else if (obj instanceof X509AttributeCertificate) {
                x509CRLStoreSelector.setAttrCertificateChecking((X509AttributeCertificate) obj);
            }
            x509CRLStoreSelector.setCompleteCRLEnabled(true);
            Set setFindCRLs = CRL_UTIL.findCRLs(x509CRLStoreSelector, extendedPKIXParameters, date);
            if (!setFindCRLs.isEmpty()) {
                return setFindCRLs;
            }
            if (obj instanceof X509AttributeCertificate) {
                throw new AnnotatedException("No CRLs found for issuer \"" + ((X509AttributeCertificate) obj).getIssuer().getPrincipals()[0] + "\"");
            }
            throw new AnnotatedException("No CRLs found for issuer \"" + ((X509Certificate) obj).getIssuerX500Principal() + "\"");
        } catch (AnnotatedException e) {
            throw new AnnotatedException("Could not get issuer information from distribution point.", e);
        }
    }

    public static Set getDeltaCRLs(Date date, ExtendedPKIXParameters extendedPKIXParameters, X509CRL x509crl) throws AnnotatedException, IOException {
        X509CRLStoreSelector x509CRLStoreSelector = new X509CRLStoreSelector();
        try {
            x509CRLStoreSelector.addIssuerName(getIssuerPrincipal(x509crl).getEncoded());
            try {
                ASN1Primitive extensionValue = getExtensionValue(x509crl, CRL_NUMBER);
                BigInteger positiveValue = extensionValue != null ? DERInteger.getInstance(extensionValue).getPositiveValue() : null;
                try {
                    byte[] extensionValue2 = x509crl.getExtensionValue(ISSUING_DISTRIBUTION_POINT);
                    x509CRLStoreSelector.setMinCRLNumber(positiveValue != null ? positiveValue.add(BigInteger.valueOf(1L)) : null);
                    x509CRLStoreSelector.setIssuingDistributionPoint(extensionValue2);
                    x509CRLStoreSelector.setIssuingDistributionPointEnabled(true);
                    x509CRLStoreSelector.setMaxBaseCRLNumber(positiveValue);
                    Set<X509CRL> setFindCRLs = CRL_UTIL.findCRLs(x509CRLStoreSelector, extendedPKIXParameters, date);
                    HashSet hashSet = new HashSet();
                    for (X509CRL x509crl2 : setFindCRLs) {
                        if (isDeltaCRL(x509crl2)) {
                            hashSet.add(x509crl2);
                        }
                    }
                    return hashSet;
                } catch (Exception e) {
                    throw new AnnotatedException("Issuing distribution point extension value could not be read.", e);
                }
            } catch (Exception e2) {
                throw new AnnotatedException("CRL number extension could not be extracted from CRL.", e2);
            }
        } catch (IOException e3) {
            throw new AnnotatedException("Cannot extract issuer from CRL.", e3);
        }
    }

    public static X500Principal getEncodedIssuerPrincipal(Object obj) {
        return obj instanceof X509Certificate ? ((X509Certificate) obj).getIssuerX500Principal() : (X500Principal) ((X509AttributeCertificate) obj).getIssuer().getPrincipals()[0];
    }

    public static ASN1Primitive getExtensionValue(java.security.cert.X509Extension x509Extension, String str) throws AnnotatedException {
        byte[] extensionValue = x509Extension.getExtensionValue(str);
        if (extensionValue == null) {
            return null;
        }
        return getObject(str, extensionValue);
    }

    public static X500Principal getIssuerPrincipal(X509CRL x509crl) {
        return x509crl.getIssuerX500Principal();
    }

    public static PublicKey getNextWorkingKey(List list, int i) throws CertPathValidatorException {
        DSAPublicKey dSAPublicKey;
        PublicKey publicKey = ((Certificate) list.get(i)).getPublicKey();
        if (!(publicKey instanceof DSAPublicKey)) {
            return publicKey;
        }
        DSAPublicKey dSAPublicKey2 = (DSAPublicKey) publicKey;
        if (dSAPublicKey2.getParams() != null) {
            return dSAPublicKey2;
        }
        do {
            i++;
            if (i >= list.size()) {
                throw new CertPathValidatorException("DSA parameters cannot be inherited from previous certificate.");
            }
            PublicKey publicKey2 = ((X509Certificate) list.get(i)).getPublicKey();
            if (!(publicKey2 instanceof DSAPublicKey)) {
                throw new CertPathValidatorException("DSA parameters cannot be inherited from previous certificate.");
            }
            dSAPublicKey = (DSAPublicKey) publicKey2;
        } while (dSAPublicKey.getParams() == null);
        DSAParams params = dSAPublicKey.getParams();
        try {
            return KeyFactory.getInstance("DSA", BouncyCastleProvider.PROVIDER_NAME).generatePublic(new DSAPublicKeySpec(dSAPublicKey2.getY(), params.getP(), params.getQ(), params.getG()));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static ASN1Primitive getObject(String str, byte[] bArr) throws AnnotatedException {
        try {
            return new ASN1InputStream(((ASN1OctetString) new ASN1InputStream(bArr).readObject()).getOctets()).readObject();
        } catch (Exception e) {
            throw new AnnotatedException("exception processing extension " + str, e);
        }
    }

    public static final Set getQualifierSet(ASN1Sequence aSN1Sequence) throws CertPathValidatorException {
        HashSet hashSet = new HashSet();
        if (aSN1Sequence == null) {
            return hashSet;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(byteArrayOutputStream);
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            try {
                aSN1OutputStream.writeObject((ASN1Encodable) objects.nextElement());
                hashSet.add(new PolicyQualifierInfo(byteArrayOutputStream.toByteArray()));
                byteArrayOutputStream.reset();
            } catch (IOException e) {
                throw new ExtCertPathValidatorException("Policy qualifier info cannot be decoded.", e);
            }
        }
        return hashSet;
    }

    private static BigInteger getSerialNumber(Object obj) {
        return obj instanceof X509Certificate ? ((X509Certificate) obj).getSerialNumber() : ((X509AttributeCertificate) obj).getSerialNumber();
    }

    public static X500Principal getSubjectPrincipal(X509Certificate x509Certificate) {
        return x509Certificate.getSubjectX500Principal();
    }

    public static Date getValidCertDateFromValidityModel(ExtendedPKIXParameters extendedPKIXParameters, CertPath certPath, int i) throws AnnotatedException {
        if (extendedPKIXParameters.getValidityModel() == 1 && i > 0) {
            int i2 = i - 1;
            if (i2 == 0) {
                try {
                    byte[] extensionValue = ((X509Certificate) certPath.getCertificates().get(i2)).getExtensionValue(ISISMTTObjectIdentifiers.id_isismtt_at_dateOfCertGen.getId());
                    ASN1GeneralizedTime dERGeneralizedTime = extensionValue != null ? DERGeneralizedTime.getInstance(ASN1Primitive.fromByteArray(extensionValue)) : null;
                    if (dERGeneralizedTime != null) {
                        try {
                            return dERGeneralizedTime.getDate();
                        } catch (ParseException e) {
                            throw new AnnotatedException("Date from date of cert gen extension could not be parsed.", e);
                        }
                    }
                } catch (IOException unused) {
                    throw new AnnotatedException("Date of cert gen extension could not be read.");
                } catch (IllegalArgumentException unused2) {
                    throw new AnnotatedException("Date of cert gen extension could not be read.");
                }
            }
            return ((X509Certificate) certPath.getCertificates().get(i2)).getNotBefore();
        }
        return getValidDate(extendedPKIXParameters);
    }

    public static Date getValidDate(PKIXParameters pKIXParameters) {
        Date date = pKIXParameters.getDate();
        return date == null ? new Date() : date;
    }

    public static boolean isAnyPolicy(Set set) {
        return set == null || set.contains("2.5.29.32.0") || set.isEmpty();
    }

    private static boolean isDeltaCRL(X509CRL x509crl) {
        Set<String> criticalExtensionOIDs = x509crl.getCriticalExtensionOIDs();
        if (criticalExtensionOIDs == null) {
            return false;
        }
        return criticalExtensionOIDs.contains(RFC3280CertPathUtilities.DELTA_CRL_INDICATOR);
    }

    public static boolean isSelfIssued(X509Certificate x509Certificate) {
        return x509Certificate.getSubjectDN().equals(x509Certificate.getIssuerDN());
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x008e, code lost:
    
        r5 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0093, code lost:
    
        if (r13.getCriticalExtensionOIDs() == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0095, code lost:
    
        r7 = r13.getCriticalExtensionOIDs().contains(org.bouncycastle.jce.provider.CertPathValidatorUtilities.CERTIFICATE_POLICIES);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a1, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a2, code lost:
    
        r13 = (org.bouncycastle.jce.provider.PKIXPolicyNode) r1.getParent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b0, code lost:
    
        if ("2.5.29.32.0".equals(r13.getValidPolicy()) == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b2, code lost:
    
        r8 = new org.bouncycastle.jce.provider.PKIXPolicyNode(new java.util.ArrayList(), r9, (java.util.Set) r12.get(r11), r13, r5, r11, r7);
        r13.addChild(r8);
        r10[r9].add(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void prepareNextCertB1(int r9, java.util.List[] r10, java.lang.String r11, java.util.Map r12, java.security.cert.X509Certificate r13) throws org.bouncycastle.jce.provider.AnnotatedException, java.security.cert.CertPathValidatorException {
        /*
            r0 = r10[r9]
            java.util.Iterator r0 = r0.iterator()
        L6:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L27
            java.lang.Object r1 = r0.next()
            org.bouncycastle.jce.provider.PKIXPolicyNode r1 = (org.bouncycastle.jce.provider.PKIXPolicyNode) r1
            java.lang.String r3 = r1.getValidPolicy()
            boolean r3 = r3.equals(r11)
            if (r3 == 0) goto L6
            r0 = 1
            java.lang.Object r3 = r12.get(r11)
            java.util.Set r3 = (java.util.Set) r3
            r1.expectedPolicies = r3
            goto L28
        L27:
            r0 = 0
        L28:
            if (r0 != 0) goto Ld9
            r0 = r10[r9]
            java.util.Iterator r0 = r0.iterator()
        L30:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Ld9
            java.lang.Object r1 = r0.next()
            org.bouncycastle.jce.provider.PKIXPolicyNode r1 = (org.bouncycastle.jce.provider.PKIXPolicyNode) r1
            java.lang.String r3 = r1.getValidPolicy()
            java.lang.String r4 = "2.5.29.32.0"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L30
            r0 = 0
            java.lang.String r3 = org.bouncycastle.jce.provider.CertPathValidatorUtilities.CERTIFICATE_POLICIES     // Catch: java.lang.Exception -> Ld0
            org.bouncycastle.asn1.ASN1Primitive r3 = getExtensionValue(r13, r3)     // Catch: java.lang.Exception -> Ld0
            org.bouncycastle.asn1.ASN1Sequence r3 = org.bouncycastle.asn1.ASN1Sequence.getInstance(r3)     // Catch: java.lang.Exception -> Ld0
            java.util.Enumeration r3 = r3.getObjects()
        L57:
            boolean r5 = r3.hasMoreElements()
            if (r5 == 0) goto L8e
            java.lang.Object r5 = r3.nextElement()     // Catch: java.lang.Exception -> L85
            org.bouncycastle.asn1.x509.PolicyInformation r5 = org.bouncycastle.asn1.x509.PolicyInformation.getInstance(r5)     // Catch: java.lang.Exception -> L85
            org.bouncycastle.asn1.ASN1ObjectIdentifier r6 = r5.getPolicyIdentifier()
            java.lang.String r6 = r6.getId()
            boolean r6 = r4.equals(r6)
            if (r6 == 0) goto L57
            org.bouncycastle.asn1.ASN1Sequence r0 = r5.getPolicyQualifiers()     // Catch: java.security.cert.CertPathValidatorException -> L7c
            java.util.Set r0 = getQualifierSet(r0)     // Catch: java.security.cert.CertPathValidatorException -> L7c
            goto L8e
        L7c:
            r9 = move-exception
            org.bouncycastle.jce.exception.ExtCertPathValidatorException r10 = new org.bouncycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r11 = "Policy qualifier info set could not be built."
            r10.<init>(r11, r9)
            throw r10
        L85:
            r9 = move-exception
            org.bouncycastle.jce.provider.AnnotatedException r10 = new org.bouncycastle.jce.provider.AnnotatedException
            java.lang.String r11 = "Policy information cannot be decoded."
            r10.<init>(r11, r9)
            throw r10
        L8e:
            r5 = r0
            java.util.Set r0 = r13.getCriticalExtensionOIDs()
            if (r0 == 0) goto La1
            java.util.Set r13 = r13.getCriticalExtensionOIDs()
            java.lang.String r0 = org.bouncycastle.jce.provider.CertPathValidatorUtilities.CERTIFICATE_POLICIES
            boolean r2 = r13.contains(r0)
            r7 = r2
            goto La2
        La1:
            r7 = 0
        La2:
            java.security.cert.PolicyNode r13 = r1.getParent()
            org.bouncycastle.jce.provider.PKIXPolicyNode r13 = (org.bouncycastle.jce.provider.PKIXPolicyNode) r13
            java.lang.String r0 = r13.getValidPolicy()
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Ld9
            org.bouncycastle.jce.provider.PKIXPolicyNode r8 = new org.bouncycastle.jce.provider.PKIXPolicyNode
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.Object r12 = r12.get(r11)
            r3 = r12
            java.util.Set r3 = (java.util.Set) r3
            r0 = r8
            r2 = r9
            r4 = r13
            r6 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r13.addChild(r8)
            r9 = r10[r9]
            r9.add(r8)
            goto Ld9
        Ld0:
            r9 = move-exception
            org.bouncycastle.jce.provider.AnnotatedException r10 = new org.bouncycastle.jce.provider.AnnotatedException
            java.lang.String r11 = "Certificate policies cannot be decoded."
            r10.<init>(r11, r9)
            throw r10
        Ld9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jce.provider.CertPathValidatorUtilities.prepareNextCertB1(int, java.util.List[], java.lang.String, java.util.Map, java.security.cert.X509Certificate):void");
    }

    public static PKIXPolicyNode prepareNextCertB2(int i, List[] listArr, String str, PKIXPolicyNode pKIXPolicyNode) {
        int i2;
        Iterator it = listArr[i].iterator();
        while (it.hasNext()) {
            PKIXPolicyNode pKIXPolicyNode2 = (PKIXPolicyNode) it.next();
            if (pKIXPolicyNode2.getValidPolicy().equals(str)) {
                ((PKIXPolicyNode) pKIXPolicyNode2.getParent()).removeChild(pKIXPolicyNode2);
                it.remove();
                for (int i3 = i - 1; i3 >= 0; i3--) {
                    List list = listArr[i3];
                    while (i2 < list.size()) {
                        PKIXPolicyNode pKIXPolicyNode3 = (PKIXPolicyNode) list.get(i2);
                        i2 = (pKIXPolicyNode3.hasChildren() || (pKIXPolicyNode = removePolicyNode(pKIXPolicyNode, listArr, pKIXPolicyNode3)) != null) ? i2 + 1 : 0;
                    }
                }
            }
        }
        return pKIXPolicyNode;
    }

    public static boolean processCertD1i(int i, List[] listArr, DERObjectIdentifier dERObjectIdentifier, Set set) {
        List list = listArr[i - 1];
        for (int i2 = 0; i2 < list.size(); i2++) {
            PKIXPolicyNode pKIXPolicyNode = (PKIXPolicyNode) list.get(i2);
            if (pKIXPolicyNode.getExpectedPolicies().contains(dERObjectIdentifier.getId())) {
                HashSet hashSet = new HashSet();
                hashSet.add(dERObjectIdentifier.getId());
                PKIXPolicyNode pKIXPolicyNode2 = new PKIXPolicyNode(new ArrayList(), i, hashSet, pKIXPolicyNode, set, dERObjectIdentifier.getId(), false);
                pKIXPolicyNode.addChild(pKIXPolicyNode2);
                listArr[i].add(pKIXPolicyNode2);
                return true;
            }
        }
        return false;
    }

    public static void processCertD1ii(int i, List[] listArr, DERObjectIdentifier dERObjectIdentifier, Set set) {
        List list = listArr[i - 1];
        for (int i2 = 0; i2 < list.size(); i2++) {
            PKIXPolicyNode pKIXPolicyNode = (PKIXPolicyNode) list.get(i2);
            if ("2.5.29.32.0".equals(pKIXPolicyNode.getValidPolicy())) {
                HashSet hashSet = new HashSet();
                hashSet.add(dERObjectIdentifier.getId());
                PKIXPolicyNode pKIXPolicyNode2 = new PKIXPolicyNode(new ArrayList(), i, hashSet, pKIXPolicyNode, set, dERObjectIdentifier.getId(), false);
                pKIXPolicyNode.addChild(pKIXPolicyNode2);
                listArr[i].add(pKIXPolicyNode2);
                return;
            }
        }
    }

    public static PKIXPolicyNode removePolicyNode(PKIXPolicyNode pKIXPolicyNode, List[] listArr, PKIXPolicyNode pKIXPolicyNode2) {
        PKIXPolicyNode pKIXPolicyNode3 = (PKIXPolicyNode) pKIXPolicyNode2.getParent();
        if (pKIXPolicyNode == null) {
            return null;
        }
        if (pKIXPolicyNode3 != null) {
            pKIXPolicyNode3.removeChild(pKIXPolicyNode2);
            removePolicyNodeRecurse(listArr, pKIXPolicyNode2);
            return pKIXPolicyNode;
        }
        for (int i = 0; i < listArr.length; i++) {
            listArr[i] = new ArrayList();
        }
        return null;
    }

    private static void removePolicyNodeRecurse(List[] listArr, PKIXPolicyNode pKIXPolicyNode) {
        listArr[pKIXPolicyNode.getDepth()].remove(pKIXPolicyNode);
        if (pKIXPolicyNode.hasChildren()) {
            Iterator children = pKIXPolicyNode.getChildren();
            while (children.hasNext()) {
                removePolicyNodeRecurse(listArr, (PKIXPolicyNode) children.next());
            }
        }
    }

    public static void verifyX509Certificate(X509Certificate x509Certificate, PublicKey publicKey, String str) throws GeneralSecurityException {
        if (str == null) {
            x509Certificate.verify(publicKey);
        } else {
            x509Certificate.verify(publicKey, str);
        }
    }
}
