package org.bouncycastle.jce.provider;

import androidx.core.os.EnvironmentCompat;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
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
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.CRLDistPoint;
import org.bouncycastle.asn1.x509.DistributionPoint;
import org.bouncycastle.asn1.x509.DistributionPointName;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.GeneralSubtree;
import org.bouncycastle.asn1.x509.IssuingDistributionPoint;
import org.bouncycastle.asn1.x509.NameConstraints;
import org.bouncycastle.asn1.x509.PolicyInformation;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.asn1.x509.X509Name;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.x509.ExtendedPKIXBuilderParameters;
import org.bouncycastle.x509.ExtendedPKIXParameters;
import org.bouncycastle.x509.X509CRLStoreSelector;
import org.bouncycastle.x509.X509CertStoreSelector;

/* loaded from: classes5.dex */
public class RFC3280CertPathUtilities {
    public static final String ANY_POLICY = "2.5.29.32.0";
    public static final int CRL_SIGN = 6;
    public static final int KEY_CERT_SIGN = 5;
    private static final PKIXCRLUtil CRL_UTIL = new PKIXCRLUtil();
    public static final String CERTIFICATE_POLICIES = X509Extensions.CertificatePolicies.getId();
    public static final String POLICY_MAPPINGS = X509Extensions.PolicyMappings.getId();
    public static final String INHIBIT_ANY_POLICY = X509Extensions.InhibitAnyPolicy.getId();
    public static final String ISSUING_DISTRIBUTION_POINT = X509Extensions.IssuingDistributionPoint.getId();
    public static final String FRESHEST_CRL = X509Extensions.FreshestCRL.getId();
    public static final String DELTA_CRL_INDICATOR = X509Extensions.DeltaCRLIndicator.getId();
    public static final String POLICY_CONSTRAINTS = X509Extensions.PolicyConstraints.getId();
    public static final String BASIC_CONSTRAINTS = X509Extensions.BasicConstraints.getId();
    public static final String CRL_DISTRIBUTION_POINTS = X509Extensions.CRLDistributionPoints.getId();
    public static final String SUBJECT_ALTERNATIVE_NAME = X509Extensions.SubjectAlternativeName.getId();
    public static final String NAME_CONSTRAINTS = X509Extensions.NameConstraints.getId();
    public static final String AUTHORITY_KEY_IDENTIFIER = X509Extensions.AuthorityKeyIdentifier.getId();
    public static final String KEY_USAGE = X509Extensions.KeyUsage.getId();
    public static final String CRL_NUMBER = X509Extensions.CRLNumber.getId();
    public static final String[] crlReasons = {"unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", EnvironmentCompat.MEDIA_UNKNOWN, "removeFromCRL", "privilegeWithdrawn", "aACompromise"};

    private static void checkCRL(DistributionPoint distributionPoint, ExtendedPKIXParameters extendedPKIXParameters, X509Certificate x509Certificate, Date date, X509Certificate x509Certificate2, PublicKey publicKey, CertStatus certStatus, ReasonsMask reasonsMask, List list) throws AnnotatedException {
        Iterator it;
        Set<String> criticalExtensionOIDs;
        Date date2 = new Date(System.currentTimeMillis());
        if (date.getTime() > date2.getTime()) {
            throw new AnnotatedException("Validation time is in future.");
        }
        Iterator it2 = CertPathValidatorUtilities.getCompleteCRLs(distributionPoint, x509Certificate, date2, extendedPKIXParameters).iterator();
        AnnotatedException e = null;
        boolean z = false;
        while (it2.hasNext() && certStatus.getCertStatus() == 11 && !reasonsMask.isAllReasons()) {
            try {
                X509CRL x509crl = (X509CRL) it2.next();
                ReasonsMask reasonsMaskProcessCRLD = processCRLD(x509crl, distributionPoint);
                if (reasonsMaskProcessCRLD.hasNewReasons(reasonsMask)) {
                    it = it2;
                    try {
                        X509CRL x509crlProcessCRLH = extendedPKIXParameters.isUseDeltasEnabled() ? processCRLH(CertPathValidatorUtilities.getDeltaCRLs(date2, extendedPKIXParameters, x509crl), processCRLG(x509crl, processCRLF(x509crl, x509Certificate, x509Certificate2, publicKey, extendedPKIXParameters, list))) : null;
                        if (extendedPKIXParameters.getValidityModel() != 1) {
                            try {
                                if (x509Certificate.getNotAfter().getTime() < x509crl.getThisUpdate().getTime()) {
                                    throw new AnnotatedException("No valid CRL for current time found.");
                                }
                            } catch (AnnotatedException e2) {
                                e = e2;
                                it2 = it;
                            }
                        }
                        processCRLB1(distributionPoint, x509Certificate, x509crl);
                        processCRLB2(distributionPoint, x509Certificate, x509crl);
                        processCRLC(x509crlProcessCRLH, x509crl, extendedPKIXParameters);
                        processCRLI(date, x509crlProcessCRLH, x509Certificate, certStatus, extendedPKIXParameters);
                        processCRLJ(date, x509crl, x509Certificate, certStatus);
                        if (certStatus.getCertStatus() == 8) {
                            certStatus.setCertStatus(11);
                        }
                        reasonsMask.addReasons(reasonsMaskProcessCRLD);
                        Set<String> criticalExtensionOIDs2 = x509crl.getCriticalExtensionOIDs();
                        if (criticalExtensionOIDs2 != null) {
                            HashSet hashSet = new HashSet(criticalExtensionOIDs2);
                            hashSet.remove(X509Extensions.IssuingDistributionPoint.getId());
                            hashSet.remove(X509Extensions.DeltaCRLIndicator.getId());
                            if (!hashSet.isEmpty()) {
                                throw new AnnotatedException("CRL contains unsupported critical extensions.");
                            }
                        }
                        if (x509crlProcessCRLH != null && (criticalExtensionOIDs = x509crlProcessCRLH.getCriticalExtensionOIDs()) != null) {
                            HashSet hashSet2 = new HashSet(criticalExtensionOIDs);
                            hashSet2.remove(X509Extensions.IssuingDistributionPoint.getId());
                            hashSet2.remove(X509Extensions.DeltaCRLIndicator.getId());
                            if (!hashSet2.isEmpty()) {
                                throw new AnnotatedException("Delta CRL contains unsupported critical extension.");
                            }
                        }
                        it2 = it;
                        z = true;
                    } catch (AnnotatedException e3) {
                        e = e3;
                        it2 = it;
                    }
                } else {
                    continue;
                }
            } catch (AnnotatedException e4) {
                e = e4;
                it = it2;
            }
        }
        if (!z) {
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void checkCRLs(org.bouncycastle.x509.ExtendedPKIXParameters r19, java.security.cert.X509Certificate r20, java.util.Date r21, java.security.cert.X509Certificate r22, java.security.PublicKey r23, java.util.List r24) throws org.bouncycastle.jce.provider.AnnotatedException {
        /*
            Method dump skipped, instructions count: 341
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jce.provider.RFC3280CertPathUtilities.checkCRLs(org.bouncycastle.x509.ExtendedPKIXParameters, java.security.cert.X509Certificate, java.util.Date, java.security.cert.X509Certificate, java.security.PublicKey, java.util.List):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00cb, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d4, code lost:
    
        r7 = ((org.bouncycastle.asn1.ASN1Sequence) org.bouncycastle.jce.provider.CertPathValidatorUtilities.getExtensionValue(r4, org.bouncycastle.jce.provider.RFC3280CertPathUtilities.CERTIFICATE_POLICIES)).getObjects();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00dc, code lost:
    
        if (r7.hasMoreElements() == false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00de, code lost:
    
        r9 = org.bouncycastle.asn1.x509.PolicyInformation.getInstance(r7.nextElement());
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00f2, code lost:
    
        if ("2.5.29.32.0".equals(r9.getPolicyIdentifier().getId()) == false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00f4, code lost:
    
        r5 = org.bouncycastle.jce.provider.CertPathValidatorUtilities.getQualifierSet(r9.getPolicyQualifiers());
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00fd, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0105, code lost:
    
        throw new org.bouncycastle.jce.exception.ExtCertPathValidatorException("Policy qualifier info set could not be decoded.", r0, r19, r20);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0106, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x010e, code lost:
    
        throw new java.security.cert.CertPathValidatorException("Policy information could not be decoded.", r0, r19, r20);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x010f, code lost:
    
        r10 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0114, code lost:
    
        if (r4.getCriticalExtensionOIDs() == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0116, code lost:
    
        r12 = r4.getCriticalExtensionOIDs().contains(org.bouncycastle.jce.provider.RFC3280CertPathUtilities.CERTIFICATE_POLICIES);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0122, code lost:
    
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0123, code lost:
    
        r9 = (org.bouncycastle.jce.provider.PKIXPolicyNode) r6.getParent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0132, code lost:
    
        if ("2.5.29.32.0".equals(r9.getValidPolicy()) == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0134, code lost:
    
        r8 = new org.bouncycastle.jce.provider.PKIXPolicyNode(new java.util.ArrayList(), r3, (java.util.Set) r13.get(r11), r9, r10, r11, r12);
        r9.addChild(r8);
        r21[r3].add(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0158, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0160, code lost:
    
        throw new org.bouncycastle.jce.exception.ExtCertPathValidatorException("Certificate policies extension could not be decoded.", r0, r19, r20);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01b5, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.bouncycastle.jce.provider.PKIXPolicyNode prepareCertB(java.security.cert.CertPath r19, int r20, java.util.List[] r21, org.bouncycastle.jce.provider.PKIXPolicyNode r22, int r23) throws java.security.cert.CertPathValidatorException {
        /*
            Method dump skipped, instructions count: 452
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jce.provider.RFC3280CertPathUtilities.prepareCertB(java.security.cert.CertPath, int, java.util.List[], org.bouncycastle.jce.provider.PKIXPolicyNode, int):org.bouncycastle.jce.provider.PKIXPolicyNode");
    }

    public static void prepareNextCertA(CertPath certPath, int i) throws CertPathValidatorException {
        try {
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Certificate) certPath.getCertificates().get(i), POLICY_MAPPINGS));
            if (aSN1Sequence != null) {
                for (int i2 = 0; i2 < aSN1Sequence.size(); i2++) {
                    try {
                        ASN1Sequence aSN1Sequence2 = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(i2));
                        ASN1ObjectIdentifier dERObjectIdentifier = DERObjectIdentifier.getInstance(aSN1Sequence2.getObjectAt(0));
                        ASN1ObjectIdentifier dERObjectIdentifier2 = DERObjectIdentifier.getInstance(aSN1Sequence2.getObjectAt(1));
                        if ("2.5.29.32.0".equals(dERObjectIdentifier.getId())) {
                            throw new CertPathValidatorException("IssuerDomainPolicy is anyPolicy", null, certPath, i);
                        }
                        if ("2.5.29.32.0".equals(dERObjectIdentifier2.getId())) {
                            throw new CertPathValidatorException("SubjectDomainPolicy is anyPolicy,", null, certPath, i);
                        }
                    } catch (Exception e) {
                        throw new ExtCertPathValidatorException("Policy mappings extension contents could not be decoded.", e, certPath, i);
                    }
                }
            }
        } catch (AnnotatedException e2) {
            throw new ExtCertPathValidatorException("Policy mappings extension could not be decoded.", e2, certPath, i);
        }
    }

    public static void prepareNextCertG(CertPath certPath, int i, PKIXNameConstraintValidator pKIXNameConstraintValidator) throws CertPathValidatorException {
        try {
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Certificate) certPath.getCertificates().get(i), NAME_CONSTRAINTS));
            NameConstraints nameConstraints = aSN1Sequence != null ? NameConstraints.getInstance(aSN1Sequence) : null;
            if (nameConstraints != null) {
                GeneralSubtree[] permittedSubtrees = nameConstraints.getPermittedSubtrees();
                if (permittedSubtrees != null) {
                    try {
                        pKIXNameConstraintValidator.intersectPermittedSubtree(permittedSubtrees);
                    } catch (Exception e) {
                        throw new ExtCertPathValidatorException("Permitted subtrees cannot be build from name constraints extension.", e, certPath, i);
                    }
                }
                GeneralSubtree[] excludedSubtrees = nameConstraints.getExcludedSubtrees();
                if (excludedSubtrees != null) {
                    for (int i2 = 0; i2 != excludedSubtrees.length; i2++) {
                        try {
                            pKIXNameConstraintValidator.addExcludedSubtree(excludedSubtrees[i2]);
                        } catch (Exception e2) {
                            throw new ExtCertPathValidatorException("Excluded subtrees cannot be build from name constraints extension.", e2, certPath, i);
                        }
                    }
                }
            }
        } catch (Exception e3) {
            throw new ExtCertPathValidatorException("Name constraints extension could not be decoded.", e3, certPath, i);
        }
    }

    public static int prepareNextCertH1(CertPath certPath, int i, int i2) {
        return (CertPathValidatorUtilities.isSelfIssued((X509Certificate) certPath.getCertificates().get(i)) || i2 == 0) ? i2 : i2 - 1;
    }

    public static int prepareNextCertH2(CertPath certPath, int i, int i2) {
        return (CertPathValidatorUtilities.isSelfIssued((X509Certificate) certPath.getCertificates().get(i)) || i2 == 0) ? i2 : i2 - 1;
    }

    public static int prepareNextCertH3(CertPath certPath, int i, int i2) {
        return (CertPathValidatorUtilities.isSelfIssued((X509Certificate) certPath.getCertificates().get(i)) || i2 == 0) ? i2 : i2 - 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002e, code lost:
    
        r3 = org.bouncycastle.asn1.DERInteger.getInstance(r1, false).getValue().intValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003b, code lost:
    
        if (r3 >= r5) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int prepareNextCertI1(java.security.cert.CertPath r3, int r4, int r5) throws java.security.cert.CertPathValidatorException {
        /*
            java.util.List r0 = r3.getCertificates()
            java.lang.Object r0 = r0.get(r4)
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0
            java.lang.String r1 = org.bouncycastle.jce.provider.RFC3280CertPathUtilities.POLICY_CONSTRAINTS     // Catch: java.lang.Exception -> L48
            org.bouncycastle.asn1.ASN1Primitive r0 = org.bouncycastle.jce.provider.CertPathValidatorUtilities.getExtensionValue(r0, r1)     // Catch: java.lang.Exception -> L48
            org.bouncycastle.asn1.ASN1Sequence r0 = org.bouncycastle.asn1.ASN1Sequence.getInstance(r0)     // Catch: java.lang.Exception -> L48
            if (r0 == 0) goto L47
            java.util.Enumeration r0 = r0.getObjects()
        L1a:
            boolean r1 = r0.hasMoreElements()
            if (r1 == 0) goto L47
            java.lang.Object r1 = r0.nextElement()     // Catch: java.lang.IllegalArgumentException -> L3e
            org.bouncycastle.asn1.ASN1TaggedObject r1 = org.bouncycastle.asn1.ASN1TaggedObject.getInstance(r1)     // Catch: java.lang.IllegalArgumentException -> L3e
            int r2 = r1.getTagNo()     // Catch: java.lang.IllegalArgumentException -> L3e
            if (r2 != 0) goto L1a
            r0 = 0
            org.bouncycastle.asn1.ASN1Integer r0 = org.bouncycastle.asn1.DERInteger.getInstance(r1, r0)     // Catch: java.lang.IllegalArgumentException -> L3e
            java.math.BigInteger r0 = r0.getValue()     // Catch: java.lang.IllegalArgumentException -> L3e
            int r3 = r0.intValue()     // Catch: java.lang.IllegalArgumentException -> L3e
            if (r3 >= r5) goto L47
            return r3
        L3e:
            r5 = move-exception
            org.bouncycastle.jce.exception.ExtCertPathValidatorException r0 = new org.bouncycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r1 = "Policy constraints extension contents cannot be decoded."
            r0.<init>(r1, r5, r3, r4)
            throw r0
        L47:
            return r5
        L48:
            r5 = move-exception
            org.bouncycastle.jce.exception.ExtCertPathValidatorException r0 = new org.bouncycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r1 = "Policy constraints extension cannot be decoded."
            r0.<init>(r1, r5, r3, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jce.provider.RFC3280CertPathUtilities.prepareNextCertI1(java.security.cert.CertPath, int, int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002f, code lost:
    
        r4 = org.bouncycastle.asn1.DERInteger.getInstance(r1, false).getValue().intValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003c, code lost:
    
        if (r4 >= r6) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003e, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int prepareNextCertI2(java.security.cert.CertPath r4, int r5, int r6) throws java.security.cert.CertPathValidatorException {
        /*
            java.util.List r0 = r4.getCertificates()
            java.lang.Object r0 = r0.get(r5)
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0
            java.lang.String r1 = org.bouncycastle.jce.provider.RFC3280CertPathUtilities.POLICY_CONSTRAINTS     // Catch: java.lang.Exception -> L49
            org.bouncycastle.asn1.ASN1Primitive r0 = org.bouncycastle.jce.provider.CertPathValidatorUtilities.getExtensionValue(r0, r1)     // Catch: java.lang.Exception -> L49
            org.bouncycastle.asn1.ASN1Sequence r0 = org.bouncycastle.asn1.ASN1Sequence.getInstance(r0)     // Catch: java.lang.Exception -> L49
            if (r0 == 0) goto L48
            java.util.Enumeration r0 = r0.getObjects()
        L1a:
            boolean r1 = r0.hasMoreElements()
            if (r1 == 0) goto L48
            java.lang.Object r1 = r0.nextElement()     // Catch: java.lang.IllegalArgumentException -> L3f
            org.bouncycastle.asn1.ASN1TaggedObject r1 = org.bouncycastle.asn1.ASN1TaggedObject.getInstance(r1)     // Catch: java.lang.IllegalArgumentException -> L3f
            int r2 = r1.getTagNo()     // Catch: java.lang.IllegalArgumentException -> L3f
            r3 = 1
            if (r2 != r3) goto L1a
            r0 = 0
            org.bouncycastle.asn1.ASN1Integer r0 = org.bouncycastle.asn1.DERInteger.getInstance(r1, r0)     // Catch: java.lang.IllegalArgumentException -> L3f
            java.math.BigInteger r0 = r0.getValue()     // Catch: java.lang.IllegalArgumentException -> L3f
            int r4 = r0.intValue()     // Catch: java.lang.IllegalArgumentException -> L3f
            if (r4 >= r6) goto L48
            return r4
        L3f:
            r6 = move-exception
            org.bouncycastle.jce.exception.ExtCertPathValidatorException r0 = new org.bouncycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r1 = "Policy constraints extension contents cannot be decoded."
            r0.<init>(r1, r6, r4, r5)
            throw r0
        L48:
            return r6
        L49:
            r6 = move-exception
            org.bouncycastle.jce.exception.ExtCertPathValidatorException r0 = new org.bouncycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r1 = "Policy constraints extension cannot be decoded."
            r0.<init>(r1, r6, r4, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jce.provider.RFC3280CertPathUtilities.prepareNextCertI2(java.security.cert.CertPath, int, int):int");
    }

    public static int prepareNextCertJ(CertPath certPath, int i, int i2) throws CertPathValidatorException {
        int iIntValue;
        try {
            ASN1Integer dERInteger = DERInteger.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Certificate) certPath.getCertificates().get(i), INHIBIT_ANY_POLICY));
            return (dERInteger == null || (iIntValue = dERInteger.getValue().intValue()) >= i2) ? i2 : iIntValue;
        } catch (Exception e) {
            throw new ExtCertPathValidatorException("Inhibit any-policy extension cannot be decoded.", e, certPath, i);
        }
    }

    public static void prepareNextCertK(CertPath certPath, int i) throws CertPathValidatorException {
        try {
            BasicConstraints basicConstraints = BasicConstraints.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Certificate) certPath.getCertificates().get(i), BASIC_CONSTRAINTS));
            if (basicConstraints == null) {
                throw new CertPathValidatorException("Intermediate certificate lacks BasicConstraints");
            }
            if (!basicConstraints.isCA()) {
                throw new CertPathValidatorException("Not a CA certificate");
            }
        } catch (Exception e) {
            throw new ExtCertPathValidatorException("Basic constraints extension cannot be decoded.", e, certPath, i);
        }
    }

    public static int prepareNextCertL(CertPath certPath, int i, int i2) throws CertPathValidatorException {
        if (CertPathValidatorUtilities.isSelfIssued((X509Certificate) certPath.getCertificates().get(i))) {
            return i2;
        }
        if (i2 > 0) {
            return i2 - 1;
        }
        throw new ExtCertPathValidatorException("Max path length not greater than zero", null, certPath, i);
    }

    public static int prepareNextCertM(CertPath certPath, int i, int i2) throws CertPathValidatorException {
        BigInteger pathLenConstraint;
        int iIntValue;
        try {
            BasicConstraints basicConstraints = BasicConstraints.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Certificate) certPath.getCertificates().get(i), BASIC_CONSTRAINTS));
            return (basicConstraints == null || (pathLenConstraint = basicConstraints.getPathLenConstraint()) == null || (iIntValue = pathLenConstraint.intValue()) >= i2) ? i2 : iIntValue;
        } catch (Exception e) {
            throw new ExtCertPathValidatorException("Basic constraints extension cannot be decoded.", e, certPath, i);
        }
    }

    public static void prepareNextCertN(CertPath certPath, int i) throws CertPathValidatorException {
        boolean[] keyUsage = ((X509Certificate) certPath.getCertificates().get(i)).getKeyUsage();
        if (keyUsage != null && !keyUsage[5]) {
            throw new ExtCertPathValidatorException("Issuer certificate keyusage extension is critical and does not permit key signing.", null, certPath, i);
        }
    }

    public static void prepareNextCertO(CertPath certPath, int i, Set set, List list) throws CertPathValidatorException {
        X509Certificate x509Certificate = (X509Certificate) certPath.getCertificates().get(i);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                ((PKIXCertPathChecker) it.next()).check(x509Certificate, set);
            } catch (CertPathValidatorException e) {
                throw new CertPathValidatorException(e.getMessage(), e.getCause(), certPath, i);
            }
        }
        if (set.isEmpty()) {
            return;
        }
        throw new ExtCertPathValidatorException("Certificate has unsupported critical extension: " + set, null, certPath, i);
    }

    public static Set processCRLA1i(Date date, ExtendedPKIXParameters extendedPKIXParameters, X509Certificate x509Certificate, X509CRL x509crl) throws AnnotatedException {
        HashSet hashSet = new HashSet();
        if (extendedPKIXParameters.isUseDeltasEnabled()) {
            try {
                String str = FRESHEST_CRL;
                CRLDistPoint cRLDistPoint = CRLDistPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(x509Certificate, str));
                if (cRLDistPoint == null) {
                    try {
                        cRLDistPoint = CRLDistPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(x509crl, str));
                    } catch (AnnotatedException e) {
                        throw new AnnotatedException("Freshest CRL extension could not be decoded from CRL.", e);
                    }
                }
                if (cRLDistPoint != null) {
                    try {
                        CertPathValidatorUtilities.addAdditionalStoresFromCRLDistributionPoint(cRLDistPoint, extendedPKIXParameters);
                        try {
                            hashSet.addAll(CertPathValidatorUtilities.getDeltaCRLs(date, extendedPKIXParameters, x509crl));
                        } catch (AnnotatedException e2) {
                            throw new AnnotatedException("Exception obtaining delta CRLs.", e2);
                        }
                    } catch (AnnotatedException e3) {
                        throw new AnnotatedException("No new delta CRL locations could be added from Freshest CRL extension.", e3);
                    }
                }
            } catch (AnnotatedException e4) {
                throw new AnnotatedException("Freshest CRL extension could not be decoded from certificate.", e4);
            }
        }
        return hashSet;
    }

    public static Set[] processCRLA1ii(Date date, ExtendedPKIXParameters extendedPKIXParameters, X509Certificate x509Certificate, X509CRL x509crl) throws AnnotatedException, IOException {
        HashSet hashSet = new HashSet();
        X509CRLStoreSelector x509CRLStoreSelector = new X509CRLStoreSelector();
        x509CRLStoreSelector.setCertificateChecking(x509Certificate);
        try {
            x509CRLStoreSelector.addIssuerName(x509crl.getIssuerX500Principal().getEncoded());
            x509CRLStoreSelector.setCompleteCRLEnabled(true);
            Set setFindCRLs = CRL_UTIL.findCRLs(x509CRLStoreSelector, extendedPKIXParameters, date);
            if (extendedPKIXParameters.isUseDeltasEnabled()) {
                try {
                    hashSet.addAll(CertPathValidatorUtilities.getDeltaCRLs(date, extendedPKIXParameters, x509crl));
                } catch (AnnotatedException e) {
                    throw new AnnotatedException("Exception obtaining delta CRLs.", e);
                }
            }
            return new Set[]{setFindCRLs, hashSet};
        } catch (IOException e2) {
            throw new AnnotatedException("Cannot extract issuer from CRL." + e2, e2);
        }
    }

    public static void processCRLB1(DistributionPoint distributionPoint, Object obj, X509CRL x509crl) throws AnnotatedException {
        ASN1Primitive extensionValue = CertPathValidatorUtilities.getExtensionValue(x509crl, ISSUING_DISTRIBUTION_POINT);
        int i = 0;
        boolean z = extensionValue != null && IssuingDistributionPoint.getInstance(extensionValue).isIndirectCRL();
        byte[] encoded = CertPathValidatorUtilities.getIssuerPrincipal(x509crl).getEncoded();
        if (distributionPoint.getCRLIssuer() != null) {
            GeneralName[] names = distributionPoint.getCRLIssuer().getNames();
            int i2 = 0;
            while (i < names.length) {
                if (names[i].getTagNo() == 4) {
                    try {
                        if (Arrays.areEqual(names[i].getName().toASN1Primitive().getEncoded(), encoded)) {
                            i2 = 1;
                        }
                    } catch (IOException e) {
                        throw new AnnotatedException("CRL issuer information from distribution point cannot be decoded.", e);
                    }
                }
                i++;
            }
            if (i2 != 0 && !z) {
                throw new AnnotatedException("Distribution point contains cRLIssuer field but CRL is not indirect.");
            }
            if (i2 == 0) {
                throw new AnnotatedException("CRL issuer of CRL does not match CRL issuer of distribution point.");
            }
            i = i2;
        } else if (CertPathValidatorUtilities.getIssuerPrincipal(x509crl).equals(CertPathValidatorUtilities.getEncodedIssuerPrincipal(obj))) {
            i = 1;
        }
        if (i == 0) {
            throw new AnnotatedException("Cannot find matching CRL issuer for certificate.");
        }
    }

    public static void processCRLB2(DistributionPoint distributionPoint, Object obj, X509CRL x509crl) throws AnnotatedException {
        GeneralName[] names;
        try {
            IssuingDistributionPoint issuingDistributionPoint = IssuingDistributionPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(x509crl, ISSUING_DISTRIBUTION_POINT));
            if (issuingDistributionPoint != null) {
                if (issuingDistributionPoint.getDistributionPoint() != null) {
                    DistributionPointName distributionPoint2 = IssuingDistributionPoint.getInstance(issuingDistributionPoint).getDistributionPoint();
                    ArrayList arrayList = new ArrayList();
                    boolean z = false;
                    if (distributionPoint2.getType() == 0) {
                        for (GeneralName generalName : GeneralNames.getInstance(distributionPoint2.getName()).getNames()) {
                            arrayList.add(generalName);
                        }
                    }
                    if (distributionPoint2.getType() == 1) {
                        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                        try {
                            Enumeration objects = ASN1Sequence.getInstance(ASN1Primitive.fromByteArray(CertPathValidatorUtilities.getIssuerPrincipal(x509crl).getEncoded())).getObjects();
                            while (objects.hasMoreElements()) {
                                aSN1EncodableVector.add((ASN1Encodable) objects.nextElement());
                            }
                            aSN1EncodableVector.add(distributionPoint2.getName());
                            arrayList.add(new GeneralName(X509Name.getInstance(new DERSequence(aSN1EncodableVector))));
                        } catch (IOException e) {
                            throw new AnnotatedException("Could not read CRL issuer.", e);
                        }
                    }
                    if (distributionPoint.getDistributionPoint() != null) {
                        DistributionPointName distributionPoint3 = distributionPoint.getDistributionPoint();
                        GeneralName[] names2 = distributionPoint3.getType() == 0 ? GeneralNames.getInstance(distributionPoint3.getName()).getNames() : null;
                        if (distributionPoint3.getType() == 1) {
                            if (distributionPoint.getCRLIssuer() != null) {
                                names = distributionPoint.getCRLIssuer().getNames();
                            } else {
                                names = new GeneralName[1];
                                try {
                                    names[0] = new GeneralName(new X509Name((ASN1Sequence) ASN1Primitive.fromByteArray(CertPathValidatorUtilities.getEncodedIssuerPrincipal(obj).getEncoded())));
                                } catch (IOException e2) {
                                    throw new AnnotatedException("Could not read certificate issuer.", e2);
                                }
                            }
                            names2 = names;
                            for (int i = 0; i < names2.length; i++) {
                                Enumeration objects2 = ASN1Sequence.getInstance(names2[i].getName().toASN1Primitive()).getObjects();
                                ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                                while (objects2.hasMoreElements()) {
                                    aSN1EncodableVector2.add((ASN1Encodable) objects2.nextElement());
                                }
                                aSN1EncodableVector2.add(distributionPoint3.getName());
                                names2[i] = new GeneralName(new X509Name(new DERSequence(aSN1EncodableVector2)));
                            }
                        }
                        if (names2 != null) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= names2.length) {
                                    break;
                                }
                                if (arrayList.contains(names2[i2])) {
                                    z = true;
                                    break;
                                }
                                i2++;
                            }
                        }
                        if (!z) {
                            throw new AnnotatedException("No match for certificate CRL issuing distribution point name to cRLIssuer CRL distribution point.");
                        }
                    } else {
                        if (distributionPoint.getCRLIssuer() == null) {
                            throw new AnnotatedException("Either the cRLIssuer or the distributionPoint field must be contained in DistributionPoint.");
                        }
                        GeneralName[] names3 = distributionPoint.getCRLIssuer().getNames();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= names3.length) {
                                break;
                            }
                            if (arrayList.contains(names3[i3])) {
                                z = true;
                                break;
                            }
                            i3++;
                        }
                        if (!z) {
                            throw new AnnotatedException("No match for certificate CRL issuing distribution point name to cRLIssuer CRL distribution point.");
                        }
                    }
                }
                try {
                    BasicConstraints basicConstraints = BasicConstraints.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Extension) obj, BASIC_CONSTRAINTS));
                    if (obj instanceof X509Certificate) {
                        if (issuingDistributionPoint.onlyContainsUserCerts() && basicConstraints != null && basicConstraints.isCA()) {
                            throw new AnnotatedException("CA Cert CRL only contains user certificates.");
                        }
                        if (issuingDistributionPoint.onlyContainsCACerts() && (basicConstraints == null || !basicConstraints.isCA())) {
                            throw new AnnotatedException("End CRL only contains CA certificates.");
                        }
                    }
                    if (issuingDistributionPoint.onlyContainsAttributeCerts()) {
                        throw new AnnotatedException("onlyContainsAttributeCerts boolean is asserted.");
                    }
                } catch (Exception e3) {
                    throw new AnnotatedException("Basic constraints extension could not be decoded.", e3);
                }
            }
        } catch (Exception e4) {
            throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e4);
        }
    }

    public static void processCRLC(X509CRL x509crl, X509CRL x509crl2, ExtendedPKIXParameters extendedPKIXParameters) throws AnnotatedException {
        if (x509crl == null) {
            return;
        }
        try {
            String str = ISSUING_DISTRIBUTION_POINT;
            IssuingDistributionPoint issuingDistributionPoint = IssuingDistributionPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(x509crl2, str));
            if (extendedPKIXParameters.isUseDeltasEnabled()) {
                if (!x509crl.getIssuerX500Principal().equals(x509crl2.getIssuerX500Principal())) {
                    throw new AnnotatedException("Complete CRL issuer does not match delta CRL issuer.");
                }
                try {
                    IssuingDistributionPoint issuingDistributionPoint2 = IssuingDistributionPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(x509crl, str));
                    boolean z = false;
                    if (issuingDistributionPoint != null ? issuingDistributionPoint.equals(issuingDistributionPoint2) : issuingDistributionPoint2 == null) {
                        z = true;
                    }
                    if (!z) {
                        throw new AnnotatedException("Issuing distribution point extension from delta CRL and complete CRL does not match.");
                    }
                    try {
                        String str2 = AUTHORITY_KEY_IDENTIFIER;
                        ASN1Primitive extensionValue = CertPathValidatorUtilities.getExtensionValue(x509crl2, str2);
                        try {
                            ASN1Primitive extensionValue2 = CertPathValidatorUtilities.getExtensionValue(x509crl, str2);
                            if (extensionValue == null) {
                                throw new AnnotatedException("CRL authority key identifier is null.");
                            }
                            if (extensionValue2 == null) {
                                throw new AnnotatedException("Delta CRL authority key identifier is null.");
                            }
                            if (!extensionValue.equals(extensionValue2)) {
                                throw new AnnotatedException("Delta CRL authority key identifier does not match complete CRL authority key identifier.");
                            }
                        } catch (AnnotatedException e) {
                            throw new AnnotatedException("Authority key identifier extension could not be extracted from delta CRL.", e);
                        }
                    } catch (AnnotatedException e2) {
                        throw new AnnotatedException("Authority key identifier extension could not be extracted from complete CRL.", e2);
                    }
                } catch (Exception e3) {
                    throw new AnnotatedException("Issuing distribution point extension from delta CRL could not be decoded.", e3);
                }
            }
        } catch (Exception e4) {
            throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e4);
        }
    }

    public static ReasonsMask processCRLD(X509CRL x509crl, DistributionPoint distributionPoint) throws AnnotatedException {
        try {
            IssuingDistributionPoint issuingDistributionPoint = IssuingDistributionPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(x509crl, ISSUING_DISTRIBUTION_POINT));
            if (issuingDistributionPoint != null && issuingDistributionPoint.getOnlySomeReasons() != null && distributionPoint.getReasons() != null) {
                return new ReasonsMask(distributionPoint.getReasons()).intersect(new ReasonsMask(issuingDistributionPoint.getOnlySomeReasons()));
            }
            if ((issuingDistributionPoint == null || issuingDistributionPoint.getOnlySomeReasons() == null) && distributionPoint.getReasons() == null) {
                return ReasonsMask.allReasons;
            }
            return (distributionPoint.getReasons() == null ? ReasonsMask.allReasons : new ReasonsMask(distributionPoint.getReasons())).intersect(issuingDistributionPoint == null ? ReasonsMask.allReasons : new ReasonsMask(issuingDistributionPoint.getOnlySomeReasons()));
        } catch (Exception e) {
            throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e);
        }
    }

    public static Set processCRLF(X509CRL x509crl, Object obj, X509Certificate x509Certificate, PublicKey publicKey, ExtendedPKIXParameters extendedPKIXParameters, List list) throws NoSuchAlgorithmException, AnnotatedException, IOException, NoSuchProviderException {
        int i;
        X509CertStoreSelector x509CertStoreSelector = new X509CertStoreSelector();
        try {
            x509CertStoreSelector.setSubject(CertPathValidatorUtilities.getIssuerPrincipal(x509crl).getEncoded());
            try {
                Collection collectionFindCertificates = CertPathValidatorUtilities.findCertificates(x509CertStoreSelector, extendedPKIXParameters.getStores());
                collectionFindCertificates.addAll(CertPathValidatorUtilities.findCertificates(x509CertStoreSelector, extendedPKIXParameters.getAdditionalStores()));
                collectionFindCertificates.addAll(CertPathValidatorUtilities.findCertificates(x509CertStoreSelector, extendedPKIXParameters.getCertStores()));
                collectionFindCertificates.add(x509Certificate);
                Iterator it = collectionFindCertificates.iterator();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    X509Certificate x509Certificate2 = (X509Certificate) it.next();
                    if (x509Certificate2.equals(x509Certificate)) {
                        arrayList.add(x509Certificate2);
                        arrayList2.add(publicKey);
                    } else {
                        try {
                            CertPathBuilder certPathBuilder = CertPathBuilder.getInstance("PKIX", BouncyCastleProvider.PROVIDER_NAME);
                            X509CertStoreSelector x509CertStoreSelector2 = new X509CertStoreSelector();
                            x509CertStoreSelector2.setCertificate(x509Certificate2);
                            ExtendedPKIXParameters extendedPKIXParameters2 = (ExtendedPKIXParameters) extendedPKIXParameters.clone();
                            extendedPKIXParameters2.setTargetCertConstraints(x509CertStoreSelector2);
                            ExtendedPKIXBuilderParameters extendedPKIXBuilderParameters = (ExtendedPKIXBuilderParameters) ExtendedPKIXBuilderParameters.getInstance(extendedPKIXParameters2);
                            if (list.contains(x509Certificate2)) {
                                extendedPKIXBuilderParameters.setRevocationEnabled(false);
                            } else {
                                extendedPKIXBuilderParameters.setRevocationEnabled(true);
                            }
                            List<? extends Certificate> certificates = certPathBuilder.build(extendedPKIXBuilderParameters).getCertPath().getCertificates();
                            arrayList.add(x509Certificate2);
                            arrayList2.add(CertPathValidatorUtilities.getNextWorkingKey(certificates, 0));
                        } catch (CertPathBuilderException e) {
                            throw new AnnotatedException("Internal error.", e);
                        } catch (CertPathValidatorException e2) {
                            throw new AnnotatedException("Public key of issuer certificate of CRL could not be retrieved.", e2);
                        } catch (Exception e3) {
                            throw new RuntimeException(e3.getMessage());
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                AnnotatedException annotatedException = null;
                for (i = 0; i < arrayList.size(); i++) {
                    boolean[] keyUsage = ((X509Certificate) arrayList.get(i)).getKeyUsage();
                    if (keyUsage == null || (keyUsage.length >= 7 && keyUsage[6])) {
                        hashSet.add(arrayList2.get(i));
                    } else {
                        annotatedException = new AnnotatedException("Issuer certificate key usage extension does not permit CRL signing.");
                    }
                }
                if (hashSet.isEmpty() && annotatedException == null) {
                    throw new AnnotatedException("Cannot find a valid issuer certificate.");
                }
                if (!hashSet.isEmpty() || annotatedException == null) {
                    return hashSet;
                }
                throw annotatedException;
            } catch (AnnotatedException e4) {
                throw new AnnotatedException("Issuer certificate for CRL cannot be searched.", e4);
            }
        } catch (IOException e5) {
            throw new AnnotatedException("Subject criteria for certificate selector to find issuer certificate for CRL could not be set.", e5);
        }
    }

    public static PublicKey processCRLG(X509CRL x509crl, Set set) throws NoSuchAlgorithmException, SignatureException, AnnotatedException, InvalidKeyException, CRLException, NoSuchProviderException {
        Iterator it = set.iterator();
        Exception e = null;
        while (it.hasNext()) {
            PublicKey publicKey = (PublicKey) it.next();
            try {
                x509crl.verify(publicKey);
                return publicKey;
            } catch (Exception e2) {
                e = e2;
            }
        }
        throw new AnnotatedException("Cannot verify CRL.", e);
    }

    public static X509CRL processCRLH(Set set, PublicKey publicKey) throws NoSuchAlgorithmException, SignatureException, AnnotatedException, InvalidKeyException, CRLException, NoSuchProviderException {
        Iterator it = set.iterator();
        Exception e = null;
        while (it.hasNext()) {
            X509CRL x509crl = (X509CRL) it.next();
            try {
                x509crl.verify(publicKey);
                return x509crl;
            } catch (Exception e2) {
                e = e2;
            }
        }
        if (e == null) {
            return null;
        }
        throw new AnnotatedException("Cannot verify delta CRL.", e);
    }

    public static void processCRLI(Date date, X509CRL x509crl, Object obj, CertStatus certStatus, ExtendedPKIXParameters extendedPKIXParameters) throws AnnotatedException {
        if (!extendedPKIXParameters.isUseDeltasEnabled() || x509crl == null) {
            return;
        }
        CertPathValidatorUtilities.getCertStatus(date, x509crl, obj, certStatus);
    }

    public static void processCRLJ(Date date, X509CRL x509crl, Object obj, CertStatus certStatus) throws AnnotatedException {
        if (certStatus.getCertStatus() == 11) {
            CertPathValidatorUtilities.getCertStatus(date, x509crl, obj, certStatus);
        }
    }

    public static void processCertA(CertPath certPath, ExtendedPKIXParameters extendedPKIXParameters, int i, PublicKey publicKey, boolean z, X500Principal x500Principal, X509Certificate x509Certificate) throws CertificateNotYetValidException, ExtCertPathValidatorException, CertificateExpiredException {
        List<? extends Certificate> certificates = certPath.getCertificates();
        X509Certificate x509Certificate2 = (X509Certificate) certificates.get(i);
        if (!z) {
            try {
                CertPathValidatorUtilities.verifyX509Certificate(x509Certificate2, publicKey, extendedPKIXParameters.getSigProvider());
            } catch (GeneralSecurityException e) {
                throw new ExtCertPathValidatorException("Could not validate certificate signature.", e, certPath, i);
            }
        }
        try {
            x509Certificate2.checkValidity(CertPathValidatorUtilities.getValidCertDateFromValidityModel(extendedPKIXParameters, certPath, i));
            if (extendedPKIXParameters.isRevocationEnabled()) {
                try {
                    checkCRLs(extendedPKIXParameters, x509Certificate2, CertPathValidatorUtilities.getValidCertDateFromValidityModel(extendedPKIXParameters, certPath, i), x509Certificate, publicKey, certificates);
                } catch (AnnotatedException e2) {
                    throw new ExtCertPathValidatorException(e2.getMessage(), e2.getCause() != null ? e2.getCause() : e2, certPath, i);
                }
            }
            if (CertPathValidatorUtilities.getEncodedIssuerPrincipal(x509Certificate2).equals(x500Principal)) {
                return;
            }
            throw new ExtCertPathValidatorException("IssuerName(" + CertPathValidatorUtilities.getEncodedIssuerPrincipal(x509Certificate2) + ") does not match SubjectName(" + x500Principal + ") of signing certificate.", null, certPath, i);
        } catch (CertificateExpiredException e3) {
            throw new ExtCertPathValidatorException("Could not validate certificate: " + e3.getMessage(), e3, certPath, i);
        } catch (CertificateNotYetValidException e4) {
            throw new ExtCertPathValidatorException("Could not validate certificate: " + e4.getMessage(), e4, certPath, i);
        } catch (AnnotatedException e5) {
            throw new ExtCertPathValidatorException("Could not validate time of certificate.", e5, certPath, i);
        }
    }

    public static void processCertBC(CertPath certPath, int i, PKIXNameConstraintValidator pKIXNameConstraintValidator) throws CertPathValidatorException {
        List<? extends Certificate> certificates = certPath.getCertificates();
        X509Certificate x509Certificate = (X509Certificate) certificates.get(i);
        int size = certificates.size();
        int i2 = size - i;
        if (!CertPathValidatorUtilities.isSelfIssued(x509Certificate) || i2 >= size) {
            try {
                ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(new ASN1InputStream(CertPathValidatorUtilities.getSubjectPrincipal(x509Certificate).getEncoded()).readObject());
                try {
                    pKIXNameConstraintValidator.checkPermittedDN(aSN1Sequence);
                    pKIXNameConstraintValidator.checkExcludedDN(aSN1Sequence);
                    try {
                        GeneralNames generalNames = GeneralNames.getInstance(CertPathValidatorUtilities.getExtensionValue(x509Certificate, SUBJECT_ALTERNATIVE_NAME));
                        Enumeration enumerationElements = new X509Name(aSN1Sequence).getValues(X509Name.EmailAddress).elements();
                        while (enumerationElements.hasMoreElements()) {
                            GeneralName generalName = new GeneralName(1, (String) enumerationElements.nextElement());
                            try {
                                pKIXNameConstraintValidator.checkPermitted(generalName);
                                pKIXNameConstraintValidator.checkExcluded(generalName);
                            } catch (PKIXNameConstraintValidatorException e) {
                                throw new CertPathValidatorException("Subtree check for certificate subject alternative email failed.", e, certPath, i);
                            }
                        }
                        if (generalNames != null) {
                            try {
                                GeneralName[] names = generalNames.getNames();
                                for (int i3 = 0; i3 < names.length; i3++) {
                                    try {
                                        pKIXNameConstraintValidator.checkPermitted(names[i3]);
                                        pKIXNameConstraintValidator.checkExcluded(names[i3]);
                                    } catch (PKIXNameConstraintValidatorException e2) {
                                        throw new CertPathValidatorException("Subtree check for certificate subject alternative name failed.", e2, certPath, i);
                                    }
                                }
                            } catch (Exception e3) {
                                throw new CertPathValidatorException("Subject alternative name contents could not be decoded.", e3, certPath, i);
                            }
                        }
                    } catch (Exception e4) {
                        throw new CertPathValidatorException("Subject alternative name extension could not be decoded.", e4, certPath, i);
                    }
                } catch (PKIXNameConstraintValidatorException e5) {
                    throw new CertPathValidatorException("Subtree check for certificate subject failed.", e5, certPath, i);
                }
            } catch (Exception e6) {
                throw new CertPathValidatorException("Exception extracting subject name when checking subtrees.", e6, certPath, i);
            }
        }
    }

    public static PKIXPolicyNode processCertD(CertPath certPath, int i, Set set, PKIXPolicyNode pKIXPolicyNode, List[] listArr, int i2) throws CertPathValidatorException {
        String id;
        int i3;
        List<? extends Certificate> certificates = certPath.getCertificates();
        X509Certificate x509Certificate = (X509Certificate) certificates.get(i);
        int size = certificates.size();
        int i4 = size - i;
        try {
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(CertPathValidatorUtilities.getExtensionValue(x509Certificate, CERTIFICATE_POLICIES));
            if (aSN1Sequence == null || pKIXPolicyNode == null) {
                return null;
            }
            Enumeration objects = aSN1Sequence.getObjects();
            HashSet hashSet = new HashSet();
            while (objects.hasMoreElements()) {
                PolicyInformation policyInformation = PolicyInformation.getInstance(objects.nextElement());
                ASN1ObjectIdentifier policyIdentifier = policyInformation.getPolicyIdentifier();
                hashSet.add(policyIdentifier.getId());
                if (!"2.5.29.32.0".equals(policyIdentifier.getId())) {
                    try {
                        Set qualifierSet = CertPathValidatorUtilities.getQualifierSet(policyInformation.getPolicyQualifiers());
                        if (!CertPathValidatorUtilities.processCertD1i(i4, listArr, policyIdentifier, qualifierSet)) {
                            CertPathValidatorUtilities.processCertD1ii(i4, listArr, policyIdentifier, qualifierSet);
                        }
                    } catch (CertPathValidatorException e) {
                        throw new ExtCertPathValidatorException("Policy qualifier info set could not be build.", e, certPath, i);
                    }
                }
            }
            if (set.isEmpty() || set.contains("2.5.29.32.0")) {
                set.clear();
                set.addAll(hashSet);
            } else {
                HashSet hashSet2 = new HashSet();
                for (Object obj : set) {
                    if (hashSet.contains(obj)) {
                        hashSet2.add(obj);
                    }
                }
                set.clear();
                set.addAll(hashSet2);
            }
            if (i2 > 0 || (i4 < size && CertPathValidatorUtilities.isSelfIssued(x509Certificate))) {
                Enumeration objects2 = aSN1Sequence.getObjects();
                while (true) {
                    if (!objects2.hasMoreElements()) {
                        break;
                    }
                    PolicyInformation policyInformation2 = PolicyInformation.getInstance(objects2.nextElement());
                    if ("2.5.29.32.0".equals(policyInformation2.getPolicyIdentifier().getId())) {
                        Set qualifierSet2 = CertPathValidatorUtilities.getQualifierSet(policyInformation2.getPolicyQualifiers());
                        List list = listArr[i4 - 1];
                        for (int i5 = 0; i5 < list.size(); i5++) {
                            PKIXPolicyNode pKIXPolicyNode2 = (PKIXPolicyNode) list.get(i5);
                            for (Object obj2 : pKIXPolicyNode2.getExpectedPolicies()) {
                                if (obj2 instanceof String) {
                                    id = (String) obj2;
                                } else if (obj2 instanceof DERObjectIdentifier) {
                                    id = ((DERObjectIdentifier) obj2).getId();
                                }
                                String str = id;
                                Iterator children = pKIXPolicyNode2.getChildren();
                                boolean z = false;
                                while (children.hasNext()) {
                                    if (str.equals(((PKIXPolicyNode) children.next()).getValidPolicy())) {
                                        z = true;
                                    }
                                }
                                if (!z) {
                                    HashSet hashSet3 = new HashSet();
                                    hashSet3.add(str);
                                    PKIXPolicyNode pKIXPolicyNode3 = new PKIXPolicyNode(new ArrayList(), i4, hashSet3, pKIXPolicyNode2, qualifierSet2, str, false);
                                    pKIXPolicyNode2.addChild(pKIXPolicyNode3);
                                    listArr[i4].add(pKIXPolicyNode3);
                                }
                            }
                        }
                    }
                }
            }
            PKIXPolicyNode pKIXPolicyNodeRemovePolicyNode = pKIXPolicyNode;
            for (int i6 = i4 - 1; i6 >= 0; i6--) {
                List list2 = listArr[i6];
                while (i3 < list2.size()) {
                    PKIXPolicyNode pKIXPolicyNode4 = (PKIXPolicyNode) list2.get(i3);
                    i3 = (pKIXPolicyNode4.hasChildren() || (pKIXPolicyNodeRemovePolicyNode = CertPathValidatorUtilities.removePolicyNode(pKIXPolicyNodeRemovePolicyNode, listArr, pKIXPolicyNode4)) != null) ? i3 + 1 : 0;
                }
            }
            Set<String> criticalExtensionOIDs = x509Certificate.getCriticalExtensionOIDs();
            if (criticalExtensionOIDs != null) {
                boolean zContains = criticalExtensionOIDs.contains(CERTIFICATE_POLICIES);
                List list3 = listArr[i4];
                for (int i7 = 0; i7 < list3.size(); i7++) {
                    ((PKIXPolicyNode) list3.get(i7)).setCritical(zContains);
                }
            }
            return pKIXPolicyNodeRemovePolicyNode;
        } catch (AnnotatedException e2) {
            throw new ExtCertPathValidatorException("Could not read certificate policies extension from certificate.", e2, certPath, i);
        }
    }

    public static PKIXPolicyNode processCertE(CertPath certPath, int i, PKIXPolicyNode pKIXPolicyNode) throws CertPathValidatorException {
        try {
            if (ASN1Sequence.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Certificate) certPath.getCertificates().get(i), CERTIFICATE_POLICIES)) == null) {
                return null;
            }
            return pKIXPolicyNode;
        } catch (AnnotatedException e) {
            throw new ExtCertPathValidatorException("Could not read certificate policies extension from certificate.", e, certPath, i);
        }
    }

    public static void processCertF(CertPath certPath, int i, PKIXPolicyNode pKIXPolicyNode, int i2) throws CertPathValidatorException {
        if (i2 <= 0 && pKIXPolicyNode == null) {
            throw new ExtCertPathValidatorException("No valid policy tree found when one expected.", null, certPath, i);
        }
    }

    public static int wrapupCertA(int i, X509Certificate x509Certificate) {
        return (CertPathValidatorUtilities.isSelfIssued(x509Certificate) || i == 0) ? i : i - 1;
    }

    public static int wrapupCertB(CertPath certPath, int i, int i2) throws CertPathValidatorException {
        try {
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Certificate) certPath.getCertificates().get(i), POLICY_CONSTRAINTS));
            if (aSN1Sequence != null) {
                Enumeration objects = aSN1Sequence.getObjects();
                while (objects.hasMoreElements()) {
                    ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects.nextElement();
                    if (aSN1TaggedObject.getTagNo() == 0) {
                        try {
                            if (DERInteger.getInstance(aSN1TaggedObject, false).getValue().intValue() == 0) {
                                return 0;
                            }
                        } catch (Exception e) {
                            throw new ExtCertPathValidatorException("Policy constraints requireExplicitPolicy field could not be decoded.", e, certPath, i);
                        }
                    }
                }
            }
            return i2;
        } catch (AnnotatedException e2) {
            throw new ExtCertPathValidatorException("Policy constraints could not be decoded.", e2, certPath, i);
        }
    }

    public static void wrapupCertF(CertPath certPath, int i, List list, Set set) throws CertPathValidatorException {
        X509Certificate x509Certificate = (X509Certificate) certPath.getCertificates().get(i);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                ((PKIXCertPathChecker) it.next()).check(x509Certificate, set);
            } catch (CertPathValidatorException e) {
                throw new ExtCertPathValidatorException("Additional certificate path checker failed.", e, certPath, i);
            }
        }
        if (set.isEmpty()) {
            return;
        }
        throw new ExtCertPathValidatorException("Certificate has unsupported critical extension: " + set, null, certPath, i);
    }

    public static PKIXPolicyNode wrapupCertG(CertPath certPath, ExtendedPKIXParameters extendedPKIXParameters, Set set, int i, List[] listArr, PKIXPolicyNode pKIXPolicyNode, Set set2) throws CertPathValidatorException {
        int size = certPath.getCertificates().size();
        if (pKIXPolicyNode == null) {
            if (extendedPKIXParameters.isExplicitPolicyRequired()) {
                throw new ExtCertPathValidatorException("Explicit policy requested but none available.", null, certPath, i);
            }
            return null;
        }
        if (!CertPathValidatorUtilities.isAnyPolicy(set)) {
            HashSet<PKIXPolicyNode> hashSet = new HashSet();
            for (List list : listArr) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    PKIXPolicyNode pKIXPolicyNode2 = (PKIXPolicyNode) list.get(i2);
                    if ("2.5.29.32.0".equals(pKIXPolicyNode2.getValidPolicy())) {
                        Iterator children = pKIXPolicyNode2.getChildren();
                        while (children.hasNext()) {
                            PKIXPolicyNode pKIXPolicyNode3 = (PKIXPolicyNode) children.next();
                            if (!"2.5.29.32.0".equals(pKIXPolicyNode3.getValidPolicy())) {
                                hashSet.add(pKIXPolicyNode3);
                            }
                        }
                    }
                }
            }
            for (PKIXPolicyNode pKIXPolicyNode4 : hashSet) {
                if (!set.contains(pKIXPolicyNode4.getValidPolicy())) {
                    pKIXPolicyNode = CertPathValidatorUtilities.removePolicyNode(pKIXPolicyNode, listArr, pKIXPolicyNode4);
                }
            }
            if (pKIXPolicyNode != null) {
                for (int i3 = size - 1; i3 >= 0; i3--) {
                    List list2 = listArr[i3];
                    for (int i4 = 0; i4 < list2.size(); i4++) {
                        PKIXPolicyNode pKIXPolicyNode5 = (PKIXPolicyNode) list2.get(i4);
                        if (!pKIXPolicyNode5.hasChildren()) {
                            pKIXPolicyNode = CertPathValidatorUtilities.removePolicyNode(pKIXPolicyNode, listArr, pKIXPolicyNode5);
                        }
                    }
                }
            }
        } else if (extendedPKIXParameters.isExplicitPolicyRequired()) {
            if (set2.isEmpty()) {
                throw new ExtCertPathValidatorException("Explicit policy requested but none available.", null, certPath, i);
            }
            HashSet hashSet2 = new HashSet();
            for (List list3 : listArr) {
                for (int i5 = 0; i5 < list3.size(); i5++) {
                    PKIXPolicyNode pKIXPolicyNode6 = (PKIXPolicyNode) list3.get(i5);
                    if ("2.5.29.32.0".equals(pKIXPolicyNode6.getValidPolicy())) {
                        Iterator children2 = pKIXPolicyNode6.getChildren();
                        while (children2.hasNext()) {
                            hashSet2.add(children2.next());
                        }
                    }
                }
            }
            Iterator it = hashSet2.iterator();
            while (it.hasNext()) {
                set2.contains(((PKIXPolicyNode) it.next()).getValidPolicy());
            }
            if (pKIXPolicyNode != null) {
                for (int i6 = size - 1; i6 >= 0; i6--) {
                    List list4 = listArr[i6];
                    for (int i7 = 0; i7 < list4.size(); i7++) {
                        PKIXPolicyNode pKIXPolicyNode7 = (PKIXPolicyNode) list4.get(i7);
                        if (!pKIXPolicyNode7.hasChildren()) {
                            pKIXPolicyNode = CertPathValidatorUtilities.removePolicyNode(pKIXPolicyNode, listArr, pKIXPolicyNode7);
                        }
                    }
                }
            }
        }
        return pKIXPolicyNode;
    }
}
