package org.bouncycastle.x509;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXParameters;
import java.security.cert.PolicyNode;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.x509.AccessDescription;
import org.bouncycastle.asn1.x509.AuthorityInformationAccess;
import org.bouncycastle.asn1.x509.AuthorityKeyIdentifier;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.CRLDistPoint;
import org.bouncycastle.asn1.x509.DistributionPoint;
import org.bouncycastle.asn1.x509.DistributionPointName;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.GeneralSubtree;
import org.bouncycastle.asn1.x509.NameConstraints;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.asn1.x509.qualified.ETSIQCObjectIdentifiers;
import org.bouncycastle.asn1.x509.qualified.MonetaryValue;
import org.bouncycastle.asn1.x509.qualified.QCStatement;
import org.bouncycastle.asn1.x509.qualified.RFC3739QCObjectIdentifiers;
import org.bouncycastle.i18n.ErrorBundle;
import org.bouncycastle.i18n.filter.TrustedInput;
import org.bouncycastle.i18n.filter.UntrustedInput;
import org.bouncycastle.jce.provider.AnnotatedException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.provider.CertPathValidatorUtilities;
import org.bouncycastle.jce.provider.PKIXNameConstraintValidator;
import org.bouncycastle.jce.provider.PKIXNameConstraintValidatorException;
import org.bouncycastle.util.Integers;

/* loaded from: classes5.dex */
public class PKIXCertPathReviewer extends CertPathValidatorUtilities {
    private static final String RESOURCE_NAME = "org.bouncycastle.x509.CertPathReviewerMessages";
    public CertPath certPath;
    public List certs;
    public List[] errors;
    private boolean initialized;
    public int n;
    public List[] notifications;
    public PKIXParameters pkixParams;
    public PolicyNode policyTree;
    public PublicKey subjectPublicKey;
    public TrustAnchor trustAnchor;
    public Date validDate;
    private static final String QC_STATEMENT = X509Extensions.QCStatements.getId();
    private static final String CRL_DIST_POINTS = X509Extensions.CRLDistributionPoints.getId();
    private static final String AUTH_INFO_ACCESS = X509Extensions.AuthorityInfoAccess.getId();

    public PKIXCertPathReviewer() {
    }

    public PKIXCertPathReviewer(CertPath certPath, PKIXParameters pKIXParameters) throws CertPathReviewerException {
        init(certPath, pKIXParameters);
    }

    private String IPtoString(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr).getHostAddress();
        } catch (Exception unused) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i != bArr.length; i++) {
                stringBuffer.append(Integer.toHexString(bArr[i] & 255));
                stringBuffer.append(' ');
            }
            return stringBuffer.toString();
        }
    }

    private void checkCriticalExtensions() throws CertPathReviewerException, CertPathValidatorException {
        List<PKIXCertPathChecker> certPathCheckers = this.pkixParams.getCertPathCheckers();
        Iterator<PKIXCertPathChecker> it = certPathCheckers.iterator();
        while (it.hasNext()) {
            try {
                try {
                    it.next().init(false);
                } catch (CertPathValidatorException e) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.certPathCheckerError", new Object[]{e.getMessage(), e, e.getClass().getName()}), e);
                }
            } catch (CertPathReviewerException e2) {
                addError(e2.getErrorMessage(), e2.getIndex());
                return;
            }
        }
        for (int size = this.certs.size() - 1; size >= 0; size--) {
            X509Certificate x509Certificate = (X509Certificate) this.certs.get(size);
            Set<String> criticalExtensionOIDs = x509Certificate.getCriticalExtensionOIDs();
            if (criticalExtensionOIDs != null && !criticalExtensionOIDs.isEmpty()) {
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.KEY_USAGE);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.CERTIFICATE_POLICIES);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.POLICY_MAPPINGS);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.INHIBIT_ANY_POLICY);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.ISSUING_DISTRIBUTION_POINT);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.DELTA_CRL_INDICATOR);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.POLICY_CONSTRAINTS);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.BASIC_CONSTRAINTS);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.SUBJECT_ALTERNATIVE_NAME);
                criticalExtensionOIDs.remove(CertPathValidatorUtilities.NAME_CONSTRAINTS);
                String str = QC_STATEMENT;
                if (criticalExtensionOIDs.contains(str) && processQcStatements(x509Certificate, size)) {
                    criticalExtensionOIDs.remove(str);
                }
                Iterator<PKIXCertPathChecker> it2 = certPathCheckers.iterator();
                while (it2.hasNext()) {
                    try {
                        it2.next().check(x509Certificate, criticalExtensionOIDs);
                    } catch (CertPathValidatorException e3) {
                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.criticalExtensionError", new Object[]{e3.getMessage(), e3, e3.getClass().getName()}), e3.getCause(), this.certPath, size);
                    }
                }
                if (!criticalExtensionOIDs.isEmpty()) {
                    Iterator<String> it3 = criticalExtensionOIDs.iterator();
                    while (it3.hasNext()) {
                        addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.unknownCriticalExt", new Object[]{new DERObjectIdentifier(it3.next())}), size);
                    }
                }
            }
        }
    }

    private void checkNameConstraints() throws CertPathReviewerException {
        PKIXNameConstraintValidator pKIXNameConstraintValidator = new PKIXNameConstraintValidator();
        try {
            for (int size = this.certs.size() - 1; size > 0; size--) {
                X509Certificate x509Certificate = (X509Certificate) this.certs.get(size);
                if (!CertPathValidatorUtilities.isSelfIssued(x509Certificate)) {
                    X500Principal subjectPrincipal = CertPathValidatorUtilities.getSubjectPrincipal(x509Certificate);
                    try {
                        ASN1Sequence aSN1Sequence = (ASN1Sequence) new ASN1InputStream(new ByteArrayInputStream(subjectPrincipal.getEncoded())).readObject();
                        try {
                            pKIXNameConstraintValidator.checkPermittedDN(aSN1Sequence);
                            try {
                                pKIXNameConstraintValidator.checkExcludedDN(aSN1Sequence);
                                try {
                                    ASN1Sequence aSN1Sequence2 = (ASN1Sequence) CertPathValidatorUtilities.getExtensionValue(x509Certificate, CertPathValidatorUtilities.SUBJECT_ALTERNATIVE_NAME);
                                    if (aSN1Sequence2 != null) {
                                        for (int i = 0; i < aSN1Sequence2.size(); i++) {
                                            GeneralName generalName = GeneralName.getInstance(aSN1Sequence2.getObjectAt(i));
                                            try {
                                                pKIXNameConstraintValidator.checkPermitted(generalName);
                                                pKIXNameConstraintValidator.checkExcluded(generalName);
                                            } catch (PKIXNameConstraintValidatorException e) {
                                                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.notPermittedEmail", new Object[]{new UntrustedInput(generalName)}), e, this.certPath, size);
                                            }
                                        }
                                    }
                                } catch (AnnotatedException e2) {
                                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.subjAltNameExtError"), e2, this.certPath, size);
                                }
                            } catch (PKIXNameConstraintValidatorException e3) {
                                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.excludedDN", new Object[]{new UntrustedInput(subjectPrincipal.getName())}), e3, this.certPath, size);
                            }
                        } catch (PKIXNameConstraintValidatorException e4) {
                            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.notPermittedDN", new Object[]{new UntrustedInput(subjectPrincipal.getName())}), e4, this.certPath, size);
                        }
                    } catch (IOException e5) {
                        throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.ncSubjectNameError", new Object[]{new UntrustedInput(subjectPrincipal)}), e5, this.certPath, size);
                    }
                }
                try {
                    ASN1Sequence aSN1Sequence3 = (ASN1Sequence) CertPathValidatorUtilities.getExtensionValue(x509Certificate, CertPathValidatorUtilities.NAME_CONSTRAINTS);
                    if (aSN1Sequence3 != null) {
                        NameConstraints nameConstraints = NameConstraints.getInstance(aSN1Sequence3);
                        GeneralSubtree[] permittedSubtrees = nameConstraints.getPermittedSubtrees();
                        if (permittedSubtrees != null) {
                            pKIXNameConstraintValidator.intersectPermittedSubtree(permittedSubtrees);
                        }
                        GeneralSubtree[] excludedSubtrees = nameConstraints.getExcludedSubtrees();
                        if (excludedSubtrees != null) {
                            for (int i2 = 0; i2 != excludedSubtrees.length; i2++) {
                                pKIXNameConstraintValidator.addExcludedSubtree(excludedSubtrees[i2]);
                            }
                        }
                    }
                } catch (AnnotatedException e6) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.ncExtError"), e6, this.certPath, size);
                }
            }
        } catch (CertPathReviewerException e7) {
            addError(e7.getErrorMessage(), e7.getIndex());
        }
    }

    private void checkPathLength() {
        BasicConstraints basicConstraints;
        BigInteger pathLenConstraint;
        int iIntValue;
        int i = this.n;
        int i2 = 0;
        for (int size = this.certs.size() - 1; size > 0; size--) {
            X509Certificate x509Certificate = (X509Certificate) this.certs.get(size);
            if (!CertPathValidatorUtilities.isSelfIssued(x509Certificate)) {
                if (i <= 0) {
                    addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.pathLenghtExtended"));
                }
                i--;
                i2++;
            }
            try {
                basicConstraints = BasicConstraints.getInstance(CertPathValidatorUtilities.getExtensionValue(x509Certificate, CertPathValidatorUtilities.BASIC_CONSTRAINTS));
            } catch (AnnotatedException unused) {
                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.processLengthConstError"), size);
                basicConstraints = null;
            }
            if (basicConstraints != null && (pathLenConstraint = basicConstraints.getPathLenConstraint()) != null && (iIntValue = pathLenConstraint.intValue()) < i) {
                i = iIntValue;
            }
        }
        addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.totalPathLength", new Object[]{Integers.valueOf(i2)}));
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x023f A[Catch: CertPathReviewerException -> 0x0609, TryCatch #5 {CertPathReviewerException -> 0x0609, blocks: (B:17:0x006f, B:21:0x007f, B:23:0x008c, B:27:0x009c, B:28:0x00a7, B:30:0x00ad, B:32:0x00ce, B:33:0x00d6, B:35:0x00dc, B:37:0x00e1, B:38:0x00ed, B:42:0x00f9, B:45:0x0100, B:46:0x0109, B:48:0x010f, B:50:0x0119, B:53:0x0120, B:55:0x0124, B:95:0x0210, B:97:0x0216, B:98:0x0219, B:100:0x021f, B:102:0x022b, B:105:0x0233, B:106:0x0236, B:107:0x0239, B:109:0x023f, B:110:0x0248, B:112:0x024e, B:120:0x0271, B:121:0x027d, B:122:0x027e, B:124:0x0282, B:126:0x028a, B:127:0x028e, B:129:0x0294, B:132:0x02b6, B:134:0x02c0, B:135:0x02c5, B:136:0x02d1, B:137:0x02d2, B:138:0x02de, B:140:0x02e1, B:141:0x02ee, B:143:0x02f4, B:145:0x031a, B:147:0x0332, B:146:0x0329, B:148:0x0339, B:149:0x033f, B:151:0x0345, B:153:0x034d, B:164:0x0377, B:157:0x0355, B:158:0x0361, B:160:0x0363, B:161:0x0372, B:167:0x0380, B:178:0x039f, B:180:0x03a9, B:181:0x03ad, B:183:0x03b3, B:188:0x03c3, B:191:0x03d4, B:194:0x03e5, B:196:0x03ef, B:207:0x0431, B:199:0x03fb, B:200:0x0409, B:201:0x040a, B:202:0x0418, B:204:0x041a, B:205:0x0428, B:59:0x0133, B:60:0x0137, B:62:0x013d, B:64:0x0153, B:66:0x015d, B:67:0x0162, B:69:0x0168, B:70:0x0176, B:72:0x017c, B:74:0x0188, B:78:0x0195, B:79:0x019b, B:81:0x01a1, B:86:0x01ba, B:75:0x018b, B:77:0x018f, B:90:0x01f3, B:93:0x0203, B:94:0x020f, B:209:0x0440, B:210:0x044d, B:211:0x044e, B:215:0x045f, B:217:0x0469, B:218:0x046e, B:220:0x0474, B:223:0x0482, B:230:0x049b, B:309:0x05ef, B:310:0x05fb, B:233:0x04a6, B:234:0x04b2, B:235:0x04b3, B:237:0x04b9, B:239:0x04c1, B:241:0x04c7, B:244:0x04d1, B:245:0x04d4, B:247:0x04da, B:249:0x04ea, B:250:0x04ee, B:252:0x04f4, B:253:0x04fc, B:254:0x04ff, B:255:0x0504, B:256:0x0508, B:258:0x050e, B:260:0x051e, B:262:0x0526, B:263:0x0529, B:265:0x052f, B:267:0x053b, B:268:0x053f, B:269:0x0542, B:270:0x0545, B:271:0x0551, B:273:0x0556, B:275:0x0560, B:276:0x0563, B:278:0x0569, B:280:0x0579, B:281:0x057d, B:283:0x0583, B:285:0x0593, B:286:0x0597, B:287:0x059a, B:288:0x059d, B:289:0x05a3, B:291:0x05a9, B:293:0x05bb, B:296:0x05c5, B:298:0x05cb, B:299:0x05ce, B:301:0x05d4, B:303:0x05e0, B:304:0x05e4, B:305:0x05e7, B:311:0x05fc, B:312:0x0608), top: B:326:0x006f, inners: #0, #1, #2, #3, #4, #6, #7, #8, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0216 A[Catch: CertPathReviewerException -> 0x0609, TryCatch #5 {CertPathReviewerException -> 0x0609, blocks: (B:17:0x006f, B:21:0x007f, B:23:0x008c, B:27:0x009c, B:28:0x00a7, B:30:0x00ad, B:32:0x00ce, B:33:0x00d6, B:35:0x00dc, B:37:0x00e1, B:38:0x00ed, B:42:0x00f9, B:45:0x0100, B:46:0x0109, B:48:0x010f, B:50:0x0119, B:53:0x0120, B:55:0x0124, B:95:0x0210, B:97:0x0216, B:98:0x0219, B:100:0x021f, B:102:0x022b, B:105:0x0233, B:106:0x0236, B:107:0x0239, B:109:0x023f, B:110:0x0248, B:112:0x024e, B:120:0x0271, B:121:0x027d, B:122:0x027e, B:124:0x0282, B:126:0x028a, B:127:0x028e, B:129:0x0294, B:132:0x02b6, B:134:0x02c0, B:135:0x02c5, B:136:0x02d1, B:137:0x02d2, B:138:0x02de, B:140:0x02e1, B:141:0x02ee, B:143:0x02f4, B:145:0x031a, B:147:0x0332, B:146:0x0329, B:148:0x0339, B:149:0x033f, B:151:0x0345, B:153:0x034d, B:164:0x0377, B:157:0x0355, B:158:0x0361, B:160:0x0363, B:161:0x0372, B:167:0x0380, B:178:0x039f, B:180:0x03a9, B:181:0x03ad, B:183:0x03b3, B:188:0x03c3, B:191:0x03d4, B:194:0x03e5, B:196:0x03ef, B:207:0x0431, B:199:0x03fb, B:200:0x0409, B:201:0x040a, B:202:0x0418, B:204:0x041a, B:205:0x0428, B:59:0x0133, B:60:0x0137, B:62:0x013d, B:64:0x0153, B:66:0x015d, B:67:0x0162, B:69:0x0168, B:70:0x0176, B:72:0x017c, B:74:0x0188, B:78:0x0195, B:79:0x019b, B:81:0x01a1, B:86:0x01ba, B:75:0x018b, B:77:0x018f, B:90:0x01f3, B:93:0x0203, B:94:0x020f, B:209:0x0440, B:210:0x044d, B:211:0x044e, B:215:0x045f, B:217:0x0469, B:218:0x046e, B:220:0x0474, B:223:0x0482, B:230:0x049b, B:309:0x05ef, B:310:0x05fb, B:233:0x04a6, B:234:0x04b2, B:235:0x04b3, B:237:0x04b9, B:239:0x04c1, B:241:0x04c7, B:244:0x04d1, B:245:0x04d4, B:247:0x04da, B:249:0x04ea, B:250:0x04ee, B:252:0x04f4, B:253:0x04fc, B:254:0x04ff, B:255:0x0504, B:256:0x0508, B:258:0x050e, B:260:0x051e, B:262:0x0526, B:263:0x0529, B:265:0x052f, B:267:0x053b, B:268:0x053f, B:269:0x0542, B:270:0x0545, B:271:0x0551, B:273:0x0556, B:275:0x0560, B:276:0x0563, B:278:0x0569, B:280:0x0579, B:281:0x057d, B:283:0x0583, B:285:0x0593, B:286:0x0597, B:287:0x059a, B:288:0x059d, B:289:0x05a3, B:291:0x05a9, B:293:0x05bb, B:296:0x05c5, B:298:0x05cb, B:299:0x05ce, B:301:0x05d4, B:303:0x05e0, B:304:0x05e4, B:305:0x05e7, B:311:0x05fc, B:312:0x0608), top: B:326:0x006f, inners: #0, #1, #2, #3, #4, #6, #7, #8, #9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void checkPolicy() throws org.bouncycastle.x509.CertPathReviewerException {
        /*
            Method dump skipped, instructions count: 1558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.x509.PKIXCertPathReviewer.checkPolicy():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0285 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0176  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void checkSignatures() throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1027
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.x509.PKIXCertPathReviewer.checkSignatures():void");
    }

    private X509CRL getCRL(String str) throws Exception {
        try {
            URL url = new URL(str);
            if (!url.getProtocol().equals("http") && !url.getProtocol().equals("https")) {
                return null;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                return (X509CRL) CertificateFactory.getInstance("X.509", BouncyCastleProvider.PROVIDER_NAME).generateCRL(httpURLConnection.getInputStream());
            }
            throw new Exception(httpURLConnection.getResponseMessage());
        } catch (Exception e) {
            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.loadCrlDistPointError", new Object[]{new UntrustedInput(str), e.getMessage(), e, e.getClass().getName()}));
        }
    }

    private boolean processQcStatements(X509Certificate x509Certificate, int i) {
        ErrorBundle errorBundle;
        try {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) CertPathValidatorUtilities.getExtensionValue(x509Certificate, QC_STATEMENT);
            boolean z = false;
            for (int i2 = 0; i2 < aSN1Sequence.size(); i2++) {
                QCStatement qCStatement = QCStatement.getInstance(aSN1Sequence.getObjectAt(i2));
                if (ETSIQCObjectIdentifiers.id_etsi_qcs_QcCompliance.equals(qCStatement.getStatementId())) {
                    errorBundle = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcEuCompliance");
                } else {
                    if (!RFC3739QCObjectIdentifiers.id_qcs_pkixQCSyntax_v1.equals(qCStatement.getStatementId())) {
                        if (ETSIQCObjectIdentifiers.id_etsi_qcs_QcSSCD.equals(qCStatement.getStatementId())) {
                            errorBundle = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcSSCD");
                        } else if (ETSIQCObjectIdentifiers.id_etsi_qcs_LimiteValue.equals(qCStatement.getStatementId())) {
                            MonetaryValue monetaryValue = MonetaryValue.getInstance(qCStatement.getStatementInfo());
                            monetaryValue.getCurrency();
                            double dDoubleValue = monetaryValue.getAmount().doubleValue() * Math.pow(10.0d, monetaryValue.getExponent().doubleValue());
                            addNotification(monetaryValue.getCurrency().isAlphabetic() ? new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcLimitValueAlpha", new Object[]{monetaryValue.getCurrency().getAlphabetic(), new TrustedInput(new Double(dDoubleValue)), monetaryValue}) : new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcLimitValueNum", new Object[]{Integers.valueOf(monetaryValue.getCurrency().getNumeric()), new TrustedInput(new Double(dDoubleValue)), monetaryValue}), i);
                        } else {
                            addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcUnknownStatement", new Object[]{qCStatement.getStatementId(), new UntrustedInput(qCStatement)}), i);
                            z = true;
                        }
                    }
                }
                addNotification(errorBundle, i);
            }
            return true ^ z;
        } catch (AnnotatedException unused) {
            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcStatementExtError"), i);
            return false;
        }
    }

    public void addError(ErrorBundle errorBundle) {
        this.errors[0].add(errorBundle);
    }

    public void addError(ErrorBundle errorBundle, int i) {
        if (i < -1 || i >= this.n) {
            throw new IndexOutOfBoundsException();
        }
        this.errors[i + 1].add(errorBundle);
    }

    public void addNotification(ErrorBundle errorBundle) {
        this.notifications[0].add(errorBundle);
    }

    public void addNotification(ErrorBundle errorBundle, int i) {
        if (i < -1 || i >= this.n) {
            throw new IndexOutOfBoundsException();
        }
        this.notifications[i + 1].add(errorBundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x02b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void checkCRLs(java.security.cert.PKIXParameters r22, java.security.cert.X509Certificate r23, java.util.Date r24, java.security.cert.X509Certificate r25, java.security.PublicKey r26, java.util.Vector r27, int r28) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1191
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.x509.PKIXCertPathReviewer.checkCRLs(java.security.cert.PKIXParameters, java.security.cert.X509Certificate, java.util.Date, java.security.cert.X509Certificate, java.security.PublicKey, java.util.Vector, int):void");
    }

    public void checkRevocation(PKIXParameters pKIXParameters, X509Certificate x509Certificate, Date date, X509Certificate x509Certificate2, PublicKey publicKey, Vector vector, Vector vector2, int i) throws Exception {
        checkCRLs(pKIXParameters, x509Certificate, date, x509Certificate2, publicKey, vector, i);
    }

    public void doChecks() throws Exception {
        if (!this.initialized) {
            throw new IllegalStateException("Object not initialized. Call init() first.");
        }
        if (this.notifications != null) {
            return;
        }
        int i = this.n;
        this.notifications = new List[i + 1];
        this.errors = new List[i + 1];
        int i2 = 0;
        while (true) {
            List[] listArr = this.notifications;
            if (i2 >= listArr.length) {
                checkSignatures();
                checkNameConstraints();
                checkPathLength();
                checkPolicy();
                checkCriticalExtensions();
                return;
            }
            listArr[i2] = new ArrayList();
            this.errors[i2] = new ArrayList();
            i2++;
        }
    }

    public Vector getCRLDistUrls(CRLDistPoint cRLDistPoint) {
        Vector vector = new Vector();
        if (cRLDistPoint != null) {
            for (DistributionPoint distributionPoint : cRLDistPoint.getDistributionPoints()) {
                DistributionPointName distributionPoint2 = distributionPoint.getDistributionPoint();
                if (distributionPoint2.getType() == 0) {
                    GeneralName[] names = GeneralNames.getInstance(distributionPoint2.getName()).getNames();
                    for (int i = 0; i < names.length; i++) {
                        if (names[i].getTagNo() == 6) {
                            vector.add(((DERIA5String) names[i].getName()).getString());
                        }
                    }
                }
            }
        }
        return vector;
    }

    public CertPath getCertPath() {
        return this.certPath;
    }

    public int getCertPathSize() {
        return this.n;
    }

    public List getErrors(int i) throws Exception {
        doChecks();
        return this.errors[i + 1];
    }

    public List[] getErrors() throws Exception {
        doChecks();
        return this.errors;
    }

    public List getNotifications(int i) throws Exception {
        doChecks();
        return this.notifications[i + 1];
    }

    public List[] getNotifications() throws Exception {
        doChecks();
        return this.notifications;
    }

    public Vector getOCSPUrls(AuthorityInformationAccess authorityInformationAccess) {
        Vector vector = new Vector();
        if (authorityInformationAccess != null) {
            AccessDescription[] accessDescriptions = authorityInformationAccess.getAccessDescriptions();
            for (int i = 0; i < accessDescriptions.length; i++) {
                if (accessDescriptions[i].getAccessMethod().equals(AccessDescription.id_ad_ocsp)) {
                    GeneralName accessLocation = accessDescriptions[i].getAccessLocation();
                    if (accessLocation.getTagNo() == 6) {
                        vector.add(((DERIA5String) accessLocation.getName()).getString());
                    }
                }
            }
        }
        return vector;
    }

    public PolicyNode getPolicyTree() throws Exception {
        doChecks();
        return this.policyTree;
    }

    public PublicKey getSubjectPublicKey() throws Exception {
        doChecks();
        return this.subjectPublicKey;
    }

    public TrustAnchor getTrustAnchor() throws Exception {
        doChecks();
        return this.trustAnchor;
    }

    public Collection getTrustAnchors(X509Certificate x509Certificate, Set set) throws CertPathReviewerException, IOException {
        ArrayList arrayList = new ArrayList();
        Iterator it = set.iterator();
        X509CertSelector x509CertSelector = new X509CertSelector();
        try {
            x509CertSelector.setSubject(CertPathValidatorUtilities.getEncodedIssuerPrincipal(x509Certificate).getEncoded());
            byte[] extensionValue = x509Certificate.getExtensionValue(X509Extensions.AuthorityKeyIdentifier.getId());
            if (extensionValue != null) {
                AuthorityKeyIdentifier authorityKeyIdentifier = AuthorityKeyIdentifier.getInstance(ASN1Primitive.fromByteArray(((ASN1OctetString) ASN1Primitive.fromByteArray(extensionValue)).getOctets()));
                x509CertSelector.setSerialNumber(authorityKeyIdentifier.getAuthorityCertSerialNumber());
                byte[] keyIdentifier = authorityKeyIdentifier.getKeyIdentifier();
                if (keyIdentifier != null) {
                    x509CertSelector.setSubjectKeyIdentifier(new DEROctetString(keyIdentifier).getEncoded());
                }
            }
            while (it.hasNext()) {
                TrustAnchor trustAnchor = (TrustAnchor) it.next();
                if (trustAnchor.getTrustedCert() != null) {
                    if (x509CertSelector.match(trustAnchor.getTrustedCert())) {
                        arrayList.add(trustAnchor);
                    }
                } else if (trustAnchor.getCAName() != null && trustAnchor.getCAPublicKey() != null && CertPathValidatorUtilities.getEncodedIssuerPrincipal(x509Certificate).equals(new X500Principal(trustAnchor.getCAName()))) {
                    arrayList.add(trustAnchor);
                }
            }
            return arrayList;
        } catch (IOException unused) {
            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.trustAnchorIssuerError"));
        }
    }

    public void init(CertPath certPath, PKIXParameters pKIXParameters) throws CertPathReviewerException {
        if (this.initialized) {
            throw new IllegalStateException("object is already initialized!");
        }
        this.initialized = true;
        Objects.requireNonNull(certPath, "certPath was null");
        this.certPath = certPath;
        List<? extends Certificate> certificates = certPath.getCertificates();
        this.certs = certificates;
        this.n = certificates.size();
        if (this.certs.isEmpty()) {
            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.emptyCertPath"));
        }
        PKIXParameters pKIXParameters2 = (PKIXParameters) pKIXParameters.clone();
        this.pkixParams = pKIXParameters2;
        this.validDate = CertPathValidatorUtilities.getValidDate(pKIXParameters2);
        this.notifications = null;
        this.errors = null;
        this.trustAnchor = null;
        this.subjectPublicKey = null;
        this.policyTree = null;
    }

    public boolean isValidCertPath() throws Exception {
        doChecks();
        int i = 0;
        while (true) {
            List[] listArr = this.errors;
            if (i >= listArr.length) {
                return true;
            }
            if (!listArr[i].isEmpty()) {
                return false;
            }
            i++;
        }
    }
}
