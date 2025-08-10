package org.bouncycastle.jcajce.provider.keystore.pkcs12;

import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.GOST28147Parameters;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.ntt.NTTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PBES2Parameters;
import org.bouncycastle.asn1.pkcs.PBKDF2Params;
import org.bouncycastle.asn1.pkcs.PKCS12PBEParams;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectKeyIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.jcajce.provider.config.PKCS12StoreParameter;
import org.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.bouncycastle.jcajce.spec.GOST28147ParameterSpec;
import org.bouncycastle.jcajce.spec.PBKDF2KeySpec;
import org.bouncycastle.jce.interfaces.BCKeyStore;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.provider.JDKPKCS12StoreParameter;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Strings;

/* loaded from: classes5.dex */
public class PKCS12KeyStoreSpi extends KeyStoreSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers, BCKeyStore {
    public static final int CERTIFICATE = 1;
    public static final int KEY = 2;
    public static final int KEY_PRIVATE = 0;
    public static final int KEY_PUBLIC = 1;
    public static final int KEY_SECRET = 2;
    private static final int MIN_ITERATIONS = 1024;
    public static final int NULL = 0;
    private static final int SALT_SIZE = 20;
    public static final int SEALED = 4;
    public static final int SECRET = 3;
    private static final Provider bcProvider = new BouncyCastleProvider();
    private static final DefaultSecretKeyProvider keySizeProvider = new DefaultSecretKeyProvider();
    private ASN1ObjectIdentifier certAlgorithm;
    private CertificateFactory certFact;
    private IgnoresCaseHashtable certs;
    private ASN1ObjectIdentifier keyAlgorithm;
    private IgnoresCaseHashtable keys;
    private Hashtable localIds = new Hashtable();
    private Hashtable chainCerts = new Hashtable();
    private Hashtable keyCerts = new Hashtable();
    public SecureRandom random = new SecureRandom();

    public static class BCPKCS12KeyStore extends PKCS12KeyStoreSpi {
        public BCPKCS12KeyStore() {
            super(PKCS12KeyStoreSpi.bcProvider, PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC, PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC2_CBC);
        }
    }

    public static class BCPKCS12KeyStore3DES extends PKCS12KeyStoreSpi {
        /* JADX WARN: Illegal instructions before constructor call */
        public BCPKCS12KeyStore3DES() {
            Provider provider = PKCS12KeyStoreSpi.bcProvider;
            ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC;
            super(provider, aSN1ObjectIdentifier, aSN1ObjectIdentifier);
        }
    }

    public class CertId {
        public byte[] id;

        public CertId(PublicKey publicKey) {
            this.id = PKCS12KeyStoreSpi.this.createSubjectKeyId(publicKey).getKeyIdentifier();
        }

        public CertId(byte[] bArr) {
            this.id = bArr;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof CertId) {
                return Arrays.areEqual(this.id, ((CertId) obj).id);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.id);
        }
    }

    public static class DefPKCS12KeyStore extends PKCS12KeyStoreSpi {
        public DefPKCS12KeyStore() {
            super(null, PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC, PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC2_CBC);
        }
    }

    public static class DefPKCS12KeyStore3DES extends PKCS12KeyStoreSpi {
        /* JADX WARN: Illegal instructions before constructor call */
        public DefPKCS12KeyStore3DES() {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC;
            super(null, aSN1ObjectIdentifier, aSN1ObjectIdentifier);
        }
    }

    public static class DefaultSecretKeyProvider {
        private final Map KEY_SIZES;

        public DefaultSecretKeyProvider() {
            HashMap map = new HashMap();
            map.put(new ASN1ObjectIdentifier("1.2.840.113533.7.66.10"), Integers.valueOf(128));
            map.put(PKCSObjectIdentifiers.des_EDE3_CBC.getId(), Integers.valueOf(192));
            map.put(NISTObjectIdentifiers.id_aes128_CBC, Integers.valueOf(128));
            map.put(NISTObjectIdentifiers.id_aes192_CBC, Integers.valueOf(192));
            map.put(NISTObjectIdentifiers.id_aes256_CBC, Integers.valueOf(256));
            map.put(NTTObjectIdentifiers.id_camellia128_cbc, Integers.valueOf(128));
            map.put(NTTObjectIdentifiers.id_camellia192_cbc, Integers.valueOf(192));
            map.put(NTTObjectIdentifiers.id_camellia256_cbc, Integers.valueOf(256));
            map.put(CryptoProObjectIdentifiers.gostR28147_gcfb, Integers.valueOf(256));
            this.KEY_SIZES = Collections.unmodifiableMap(map);
        }

        public int getKeySize(AlgorithmIdentifier algorithmIdentifier) {
            Integer num = (Integer) this.KEY_SIZES.get(algorithmIdentifier.getAlgorithm());
            if (num != null) {
                return num.intValue();
            }
            return -1;
        }
    }

    public static class IgnoresCaseHashtable {
        private Hashtable keys;
        private Hashtable orig;

        private IgnoresCaseHashtable() {
            this.orig = new Hashtable();
            this.keys = new Hashtable();
        }

        public Enumeration elements() {
            return this.orig.elements();
        }

        public Object get(String str) {
            String str2 = (String) this.keys.get(str == null ? null : Strings.toLowerCase(str));
            if (str2 == null) {
                return null;
            }
            return this.orig.get(str2);
        }

        public Enumeration keys() {
            return this.orig.keys();
        }

        public void put(String str, Object obj) {
            String lowerCase = str == null ? null : Strings.toLowerCase(str);
            String str2 = (String) this.keys.get(lowerCase);
            if (str2 != null) {
                this.orig.remove(str2);
            }
            this.keys.put(lowerCase, str);
            this.orig.put(str, obj);
        }

        public Object remove(String str) {
            String str2 = (String) this.keys.remove(str == null ? null : Strings.toLowerCase(str));
            if (str2 == null) {
                return null;
            }
            return this.orig.remove(str2);
        }
    }

    public PKCS12KeyStoreSpi(Provider provider, ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier2) {
        this.keys = new IgnoresCaseHashtable();
        this.certs = new IgnoresCaseHashtable();
        this.keyAlgorithm = aSN1ObjectIdentifier;
        this.certAlgorithm = aSN1ObjectIdentifier2;
        try {
            this.certFact = provider != null ? CertificateFactory.getInstance("X.509", provider) : CertificateFactory.getInstance("X.509");
        } catch (Exception e) {
            throw new IllegalArgumentException("can't create cert factory - " + e.toString());
        }
    }

    private static byte[] calculatePbeMac(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr, int i, char[] cArr, boolean z, byte[] bArr2) throws Exception {
        String id = aSN1ObjectIdentifier.getId();
        Provider provider = bcProvider;
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(id, provider);
        PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(bArr, i);
        BCPBEKey bCPBEKey = (BCPBEKey) secretKeyFactory.generateSecret(new PBEKeySpec(cArr));
        bCPBEKey.setTryWrongPKCS12Zero(z);
        Mac mac = Mac.getInstance(aSN1ObjectIdentifier.getId(), provider);
        mac.init(bCPBEKey, pBEParameterSpec);
        mac.update(bArr2);
        return mac.doFinal();
    }

    private Cipher createCipher(int i, char[] cArr, AlgorithmIdentifier algorithmIdentifier) throws NoSuchPaddingException, InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec gOST28147ParameterSpec;
        PBES2Parameters pBES2Parameters = PBES2Parameters.getInstance(algorithmIdentifier.getParameters());
        PBKDF2Params pBKDF2Params = PBKDF2Params.getInstance(pBES2Parameters.getKeyDerivationFunc().getParameters());
        AlgorithmIdentifier algorithmIdentifier2 = AlgorithmIdentifier.getInstance(pBES2Parameters.getEncryptionScheme());
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(pBES2Parameters.getKeyDerivationFunc().getAlgorithm().getId(), bcProvider);
        SecretKey secretKeyGenerateSecret = pBKDF2Params.isDefaultPrf() ? secretKeyFactory.generateSecret(new PBEKeySpec(cArr, pBKDF2Params.getSalt(), pBKDF2Params.getIterationCount().intValue(), keySizeProvider.getKeySize(algorithmIdentifier2))) : secretKeyFactory.generateSecret(new PBKDF2KeySpec(cArr, pBKDF2Params.getSalt(), pBKDF2Params.getIterationCount().intValue(), keySizeProvider.getKeySize(algorithmIdentifier2), pBKDF2Params.getPrf()));
        Cipher cipher = Cipher.getInstance(pBES2Parameters.getEncryptionScheme().getAlgorithm().getId());
        AlgorithmIdentifier.getInstance(pBES2Parameters.getEncryptionScheme());
        ASN1Encodable parameters = pBES2Parameters.getEncryptionScheme().getParameters();
        if (parameters instanceof ASN1OctetString) {
            gOST28147ParameterSpec = new IvParameterSpec(ASN1OctetString.getInstance(parameters).getOctets());
        } else {
            GOST28147Parameters gOST28147Parameters = GOST28147Parameters.getInstance(parameters);
            gOST28147ParameterSpec = new GOST28147ParameterSpec(gOST28147Parameters.getEncryptionParamSet(), gOST28147Parameters.getIV());
        }
        cipher.init(i, secretKeyGenerateSecret, gOST28147ParameterSpec);
        return cipher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SubjectKeyIdentifier createSubjectKeyId(PublicKey publicKey) {
        try {
            return new SubjectKeyIdentifier(new SubjectPublicKeyInfo((ASN1Sequence) ASN1Primitive.fromByteArray(publicKey.getEncoded())));
        } catch (Exception unused) {
            throw new RuntimeException("error creating key");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01ac A[Catch: CertificateEncodingException -> 0x0252, TryCatch #2 {CertificateEncodingException -> 0x0252, blocks: (B:26:0x015d, B:28:0x0180, B:30:0x018d, B:34:0x019c, B:35:0x01a4, B:37:0x01ac, B:38:0x01b7, B:39:0x01bc, B:41:0x01c2, B:44:0x01f1, B:45:0x0232), top: B:118:0x015d }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01c2 A[Catch: CertificateEncodingException -> 0x0252, LOOP:3: B:39:0x01bc->B:41:0x01c2, LOOP_END, TryCatch #2 {CertificateEncodingException -> 0x0252, blocks: (B:26:0x015d, B:28:0x0180, B:30:0x018d, B:34:0x019c, B:35:0x01a4, B:37:0x01ac, B:38:0x01b7, B:39:0x01bc, B:41:0x01c2, B:44:0x01f1, B:45:0x0232), top: B:118:0x015d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void doStore(java.io.OutputStream r19, char[] r20, boolean r21) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.io.IOException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            Method dump skipped, instructions count: 1230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.doStore(java.io.OutputStream, char[], boolean):void");
    }

    public byte[] cryptData(boolean z, AlgorithmIdentifier algorithmIdentifier, char[] cArr, boolean z2, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, InvalidAlgorithmParameterException {
        ASN1ObjectIdentifier algorithm = algorithmIdentifier.getAlgorithm();
        if (!algorithm.on(PKCSObjectIdentifiers.pkcs_12PbeIds)) {
            if (!algorithm.equals(PKCSObjectIdentifiers.id_PBES2)) {
                throw new IOException("unknown PBE algorithm: " + algorithm);
            }
            try {
                return createCipher(2, cArr, algorithmIdentifier).doFinal(bArr);
            } catch (Exception e) {
                throw new IOException("exception decrypting data - " + e.toString());
            }
        }
        PKCS12PBEParams pKCS12PBEParams = PKCS12PBEParams.getInstance(algorithmIdentifier.getParameters());
        PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr);
        try {
            String id = algorithm.getId();
            Provider provider = bcProvider;
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(id, provider);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(pKCS12PBEParams.getIV(), pKCS12PBEParams.getIterations().intValue());
            BCPBEKey bCPBEKey = (BCPBEKey) secretKeyFactory.generateSecret(pBEKeySpec);
            bCPBEKey.setTryWrongPKCS12Zero(z2);
            Cipher cipher = Cipher.getInstance(algorithm.getId(), provider);
            cipher.init(z ? 1 : 2, bCPBEKey, pBEParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Exception e2) {
            throw new IOException("exception decrypting data - " + e2.toString());
        }
    }

    @Override // java.security.KeyStoreSpi
    public Enumeration engineAliases() {
        Hashtable hashtable = new Hashtable();
        Enumeration enumerationKeys = this.certs.keys();
        while (enumerationKeys.hasMoreElements()) {
            hashtable.put(enumerationKeys.nextElement(), "cert");
        }
        Enumeration enumerationKeys2 = this.keys.keys();
        while (enumerationKeys2.hasMoreElements()) {
            String str = (String) enumerationKeys2.nextElement();
            if (hashtable.get(str) == null) {
                hashtable.put(str, "key");
            }
        }
        return hashtable.keys();
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineContainsAlias(String str) {
        return (this.certs.get(str) == null && this.keys.get(str) == null) ? false : true;
    }

    @Override // java.security.KeyStoreSpi
    public void engineDeleteEntry(String str) throws KeyStoreException {
        Key key = (Key) this.keys.remove(str);
        Certificate certificate = (Certificate) this.certs.remove(str);
        if (certificate != null) {
            this.chainCerts.remove(new CertId(certificate.getPublicKey()));
        }
        if (key != null) {
            String str2 = (String) this.localIds.remove(str);
            if (str2 != null) {
                certificate = (Certificate) this.keyCerts.remove(str2);
            }
            if (certificate != null) {
                this.chainCerts.remove(new CertId(certificate.getPublicKey()));
            }
        }
    }

    @Override // java.security.KeyStoreSpi
    public Certificate engineGetCertificate(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null alias passed to getCertificate.");
        }
        Certificate certificate = (Certificate) this.certs.get(str);
        if (certificate != null) {
            return certificate;
        }
        String str2 = (String) this.localIds.get(str);
        return (Certificate) (str2 != null ? this.keyCerts.get(str2) : this.keyCerts.get(str));
    }

    @Override // java.security.KeyStoreSpi
    public String engineGetCertificateAlias(Certificate certificate) {
        Enumeration enumerationElements = this.certs.elements();
        Enumeration enumerationKeys = this.certs.keys();
        while (enumerationElements.hasMoreElements()) {
            Certificate certificate2 = (Certificate) enumerationElements.nextElement();
            String str = (String) enumerationKeys.nextElement();
            if (certificate2.equals(certificate)) {
                return str;
            }
        }
        Enumeration enumerationElements2 = this.keyCerts.elements();
        Enumeration enumerationKeys2 = this.keyCerts.keys();
        while (enumerationElements2.hasMoreElements()) {
            Certificate certificate3 = (Certificate) enumerationElements2.nextElement();
            String str2 = (String) enumerationKeys2.nextElement();
            if (certificate3.equals(certificate)) {
                return str2;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0065  */
    @Override // java.security.KeyStoreSpi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.security.cert.Certificate[] engineGetCertificateChain(java.lang.String r9) {
        /*
            r8 = this;
            if (r9 == 0) goto Lc3
            boolean r0 = r8.engineIsKeyEntry(r9)
            r1 = 0
            if (r0 != 0) goto La
            return r1
        La:
            java.security.cert.Certificate r9 = r8.engineGetCertificate(r9)
            if (r9 == 0) goto Lc2
            java.util.Vector r0 = new java.util.Vector
            r0.<init>()
        L15:
            if (r9 == 0) goto Lae
            r2 = r9
            java.security.cert.X509Certificate r2 = (java.security.cert.X509Certificate) r2
            org.bouncycastle.asn1.ASN1ObjectIdentifier r3 = org.bouncycastle.asn1.x509.Extension.authorityKeyIdentifier
            java.lang.String r3 = r3.getId()
            byte[] r3 = r2.getExtensionValue(r3)
            if (r3 == 0) goto L65
            org.bouncycastle.asn1.ASN1InputStream r4 = new org.bouncycastle.asn1.ASN1InputStream     // Catch: java.io.IOException -> L5a
            r4.<init>(r3)     // Catch: java.io.IOException -> L5a
            org.bouncycastle.asn1.ASN1Primitive r3 = r4.readObject()     // Catch: java.io.IOException -> L5a
            org.bouncycastle.asn1.ASN1OctetString r3 = (org.bouncycastle.asn1.ASN1OctetString) r3     // Catch: java.io.IOException -> L5a
            byte[] r3 = r3.getOctets()     // Catch: java.io.IOException -> L5a
            org.bouncycastle.asn1.ASN1InputStream r4 = new org.bouncycastle.asn1.ASN1InputStream     // Catch: java.io.IOException -> L5a
            r4.<init>(r3)     // Catch: java.io.IOException -> L5a
            org.bouncycastle.asn1.ASN1Primitive r3 = r4.readObject()     // Catch: java.io.IOException -> L5a
            org.bouncycastle.asn1.x509.AuthorityKeyIdentifier r3 = org.bouncycastle.asn1.x509.AuthorityKeyIdentifier.getInstance(r3)     // Catch: java.io.IOException -> L5a
            byte[] r4 = r3.getKeyIdentifier()     // Catch: java.io.IOException -> L5a
            if (r4 == 0) goto L65
            java.util.Hashtable r4 = r8.chainCerts     // Catch: java.io.IOException -> L5a
            org.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$CertId r5 = new org.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$CertId     // Catch: java.io.IOException -> L5a
            byte[] r3 = r3.getKeyIdentifier()     // Catch: java.io.IOException -> L5a
            r5.<init>(r3)     // Catch: java.io.IOException -> L5a
            java.lang.Object r3 = r4.get(r5)     // Catch: java.io.IOException -> L5a
            java.security.cert.Certificate r3 = (java.security.cert.Certificate) r3     // Catch: java.io.IOException -> L5a
            goto L66
        L5a:
            r9 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r9 = r9.toString()
            r0.<init>(r9)
            throw r0
        L65:
            r3 = r1
        L66:
            if (r3 != 0) goto La3
            java.security.Principal r4 = r2.getIssuerDN()
            java.security.Principal r5 = r2.getSubjectDN()
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto La3
            java.util.Hashtable r5 = r8.chainCerts
            java.util.Enumeration r5 = r5.keys()
        L7c:
            boolean r6 = r5.hasMoreElements()
            if (r6 == 0) goto La3
            java.util.Hashtable r6 = r8.chainCerts
            java.lang.Object r7 = r5.nextElement()
            java.lang.Object r6 = r6.get(r7)
            java.security.cert.X509Certificate r6 = (java.security.cert.X509Certificate) r6
            java.security.Principal r7 = r6.getSubjectDN()
            boolean r7 = r7.equals(r4)
            if (r7 == 0) goto L7c
            java.security.PublicKey r7 = r6.getPublicKey()     // Catch: java.lang.Exception -> La1
            r2.verify(r7)     // Catch: java.lang.Exception -> La1
            r3 = r6
            goto La3
        La1:
            goto L7c
        La3:
            r0.addElement(r9)
            if (r3 == r9) goto Lab
            r9 = r3
            goto L15
        Lab:
            r9 = r1
            goto L15
        Lae:
            int r9 = r0.size()
            java.security.cert.Certificate[] r1 = new java.security.cert.Certificate[r9]
            r2 = 0
        Lb5:
            if (r2 == r9) goto Lc2
            java.lang.Object r3 = r0.elementAt(r2)
            java.security.cert.Certificate r3 = (java.security.cert.Certificate) r3
            r1[r2] = r3
            int r2 = r2 + 1
            goto Lb5
        Lc2:
            return r1
        Lc3:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "null alias passed to getCertificateChain."
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.engineGetCertificateChain(java.lang.String):java.security.cert.Certificate[]");
    }

    @Override // java.security.KeyStoreSpi
    public Date engineGetCreationDate(String str) {
        Objects.requireNonNull(str, "alias == null");
        if (this.keys.get(str) == null && this.certs.get(str) == null) {
            return null;
        }
        return new Date();
    }

    @Override // java.security.KeyStoreSpi
    public Key engineGetKey(String str, char[] cArr) throws NoSuchAlgorithmException, UnrecoverableKeyException {
        if (str != null) {
            return (Key) this.keys.get(str);
        }
        throw new IllegalArgumentException("null alias passed to getKey.");
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsCertificateEntry(String str) {
        return this.certs.get(str) != null && this.keys.get(str) == null;
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsKeyEntry(String str) {
        return this.keys.get(str) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c6  */
    /* JADX WARN: Type inference failed for: r0v20, types: [org.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable] */
    /* JADX WARN: Type inference failed for: r10v22, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v16, types: [org.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable] */
    /* JADX WARN: Type inference failed for: r18v11, types: [org.bouncycastle.asn1.ASN1OctetString] */
    /* JADX WARN: Type inference failed for: r18v12 */
    /* JADX WARN: Type inference failed for: r18v13 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r18v9 */
    /* JADX WARN: Type inference failed for: r1v40, types: [org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object, java.security.cert.Certificate] */
    /* JADX WARN: Type inference failed for: r4v16, types: [org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier] */
    @Override // java.security.KeyStoreSpi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void engineLoad(java.io.InputStream r21, char[] r22) throws java.security.spec.InvalidKeySpecException, javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.io.IOException, java.security.InvalidKeyException, java.security.cert.CertificateException, java.security.InvalidAlgorithmParameterException {
        /*
            Method dump skipped, instructions count: 1476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.engineLoad(java.io.InputStream, char[]):void");
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
        if (this.keys.get(str) == null) {
            this.certs.put(str, certificate);
            this.chainCerts.put(new CertId(certificate.getPublicKey()), certificate);
        } else {
            throw new KeyStoreException("There is a key entry with the name " + str + ".");
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
        boolean z = key instanceof PrivateKey;
        if (!z) {
            throw new KeyStoreException("PKCS12 does not support non-PrivateKeys");
        }
        if (z && certificateArr == null) {
            throw new KeyStoreException("no certificate chain for private key");
        }
        if (this.keys.get(str) != null) {
            engineDeleteEntry(str);
        }
        this.keys.put(str, key);
        if (certificateArr != null) {
            this.certs.put(str, certificateArr[0]);
            for (int i = 0; i != certificateArr.length; i++) {
                this.chainCerts.put(new CertId(certificateArr[i].getPublicKey()), certificateArr[i]);
            }
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
        throw new RuntimeException("operation not supported");
    }

    @Override // java.security.KeyStoreSpi
    public int engineSize() {
        Hashtable hashtable = new Hashtable();
        Enumeration enumerationKeys = this.certs.keys();
        while (enumerationKeys.hasMoreElements()) {
            hashtable.put(enumerationKeys.nextElement(), "cert");
        }
        Enumeration enumerationKeys2 = this.keys.keys();
        while (enumerationKeys2.hasMoreElements()) {
            String str = (String) enumerationKeys2.nextElement();
            if (hashtable.get(str) == null) {
                hashtable.put(str, "key");
            }
        }
        return hashtable.size();
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(OutputStream outputStream, char[] cArr) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidKeyException, InvalidAlgorithmParameterException {
        doStore(outputStream, cArr, false);
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(KeyStore.LoadStoreParameter loadStoreParameter) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidKeyException, CertificateException, InvalidAlgorithmParameterException {
        PKCS12StoreParameter pKCS12StoreParameter;
        char[] password;
        if (loadStoreParameter == null) {
            throw new IllegalArgumentException("'param' arg cannot be null");
        }
        boolean z = loadStoreParameter instanceof PKCS12StoreParameter;
        if (!z && !(loadStoreParameter instanceof JDKPKCS12StoreParameter)) {
            throw new IllegalArgumentException("No support for 'param' of type " + loadStoreParameter.getClass().getName());
        }
        if (z) {
            pKCS12StoreParameter = (PKCS12StoreParameter) loadStoreParameter;
        } else {
            JDKPKCS12StoreParameter jDKPKCS12StoreParameter = (JDKPKCS12StoreParameter) loadStoreParameter;
            pKCS12StoreParameter = new PKCS12StoreParameter(jDKPKCS12StoreParameter.getOutputStream(), loadStoreParameter.getProtectionParameter(), jDKPKCS12StoreParameter.isUseDEREncoding());
        }
        KeyStore.ProtectionParameter protectionParameter = loadStoreParameter.getProtectionParameter();
        if (protectionParameter == null) {
            password = null;
        } else {
            if (!(protectionParameter instanceof KeyStore.PasswordProtection)) {
                throw new IllegalArgumentException("No support for protection parameter of type " + protectionParameter.getClass().getName());
            }
            password = ((KeyStore.PasswordProtection) protectionParameter).getPassword();
        }
        doStore(pKCS12StoreParameter.getOutputStream(), password, pKCS12StoreParameter.isForDEREncoding());
    }

    @Override // org.bouncycastle.jce.interfaces.BCKeyStore
    public void setRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
    }

    public PrivateKey unwrapKey(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, char[] cArr, boolean z) throws InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, InvalidAlgorithmParameterException {
        ASN1ObjectIdentifier algorithm = algorithmIdentifier.getAlgorithm();
        try {
            if (!algorithm.on(PKCSObjectIdentifiers.pkcs_12PbeIds)) {
                if (algorithm.equals(PKCSObjectIdentifiers.id_PBES2)) {
                    return (PrivateKey) createCipher(4, cArr, algorithmIdentifier).unwrap(bArr, "", 2);
                }
                throw new IOException("exception unwrapping private key - cannot recognise: " + algorithm);
            }
            PKCS12PBEParams pKCS12PBEParams = PKCS12PBEParams.getInstance(algorithmIdentifier.getParameters());
            PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr);
            String id = algorithm.getId();
            Provider provider = bcProvider;
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(id, provider);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(pKCS12PBEParams.getIV(), pKCS12PBEParams.getIterations().intValue());
            SecretKey secretKeyGenerateSecret = secretKeyFactory.generateSecret(pBEKeySpec);
            ((BCPBEKey) secretKeyGenerateSecret).setTryWrongPKCS12Zero(z);
            Cipher cipher = Cipher.getInstance(algorithm.getId(), provider);
            cipher.init(4, secretKeyGenerateSecret, pBEParameterSpec);
            return (PrivateKey) cipher.unwrap(bArr, "", 2);
        } catch (Exception e) {
            throw new IOException("exception unwrapping private key - " + e.toString());
        }
    }

    public byte[] wrapKey(String str, Key key, PKCS12PBEParams pKCS12PBEParams, char[] cArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, InvalidAlgorithmParameterException {
        PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr);
        try {
            Provider provider = bcProvider;
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(str, provider);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(pKCS12PBEParams.getIV(), pKCS12PBEParams.getIterations().intValue());
            Cipher cipher = Cipher.getInstance(str, provider);
            cipher.init(3, secretKeyFactory.generateSecret(pBEKeySpec), pBEParameterSpec);
            return cipher.wrap(key);
        } catch (Exception e) {
            throw new IOException("exception encrypting data - " + e.toString());
        }
    }
}
