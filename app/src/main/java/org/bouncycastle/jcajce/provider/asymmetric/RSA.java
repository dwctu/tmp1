package org.bouncycastle.jcajce.provider.asymmetric;

import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.KeyFactorySpi;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2ParameterSpec;

/* loaded from: classes5.dex */
public class RSA {
    private static final String PREFIX = "org.bouncycastle.jcajce.provider.asymmetric.rsa.";

    public static class Mappings extends AsymmetricAlgorithmProvider {
        private void addDigestSignature(ConfigurableProvider configurableProvider, String str, String str2, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            String str3 = str + "WITHRSA";
            String str4 = str + "withRSA";
            String str5 = str + "WithRSA";
            String str6 = str + "/RSA";
            String str7 = str + "WITHRSAENCRYPTION";
            String str8 = str + "withRSAEncryption";
            configurableProvider.addAlgorithm("Signature." + str3, str2);
            configurableProvider.addAlgorithm("Alg.Alias.Signature." + str4, str3);
            configurableProvider.addAlgorithm("Alg.Alias.Signature." + str5, str3);
            configurableProvider.addAlgorithm("Alg.Alias.Signature." + str7, str3);
            configurableProvider.addAlgorithm("Alg.Alias.Signature." + str8, str3);
            configurableProvider.addAlgorithm("Alg.Alias.Signature." + (str + "WithRSAEncryption"), str3);
            configurableProvider.addAlgorithm("Alg.Alias.Signature." + str6, str3);
            if (aSN1ObjectIdentifier != null) {
                configurableProvider.addAlgorithm("Alg.Alias.Signature." + aSN1ObjectIdentifier, str3);
                configurableProvider.addAlgorithm("Alg.Alias.Signature.OID." + aSN1ObjectIdentifier, str3);
            }
        }

        @Override // org.bouncycastle.jcajce.provider.util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("AlgorithmParameters.OAEP", "org.bouncycastle.jcajce.provider.asymmetric.rsa.AlgorithmParametersSpi$OAEP");
            configurableProvider.addAlgorithm("AlgorithmParameters.PSS", "org.bouncycastle.jcajce.provider.asymmetric.rsa.AlgorithmParametersSpi$PSS");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.RSAPSS", "PSS");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.RSASSA-PSS", "PSS");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA224withRSA/PSS", "PSS");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA256withRSA/PSS", "PSS");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA384withRSA/PSS", "PSS");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA512withRSA/PSS", "PSS");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA224WITHRSAANDMGF1", "PSS");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA256WITHRSAANDMGF1", "PSS");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA384WITHRSAANDMGF1", "PSS");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA512WITHRSAANDMGF1", "PSS");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.RAWRSAPSS", "PSS");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.NONEWITHRSAPSS", "PSS");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.NONEWITHRSASSA-PSS", "PSS");
            configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.NONEWITHRSAANDMGF1", "PSS");
            configurableProvider.addAlgorithm("Cipher.RSA", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$NoPadding");
            configurableProvider.addAlgorithm("Cipher.RSA/RAW", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$NoPadding");
            configurableProvider.addAlgorithm("Cipher.RSA/PKCS1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding");
            configurableProvider.addAlgorithm("Cipher.1.2.840.113549.1.1.1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding");
            configurableProvider.addAlgorithm("Cipher.2.5.8.1.1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding");
            configurableProvider.addAlgorithm("Cipher.RSA/1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding_PrivateOnly");
            configurableProvider.addAlgorithm("Cipher.RSA/2", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding_PublicOnly");
            configurableProvider.addAlgorithm("Cipher.RSA/OAEP", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$OAEPPadding");
            StringBuilder sb = new StringBuilder();
            sb.append("Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.id_RSAES_OAEP;
            sb.append(aSN1ObjectIdentifier);
            configurableProvider.addAlgorithm(sb.toString(), "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$OAEPPadding");
            configurableProvider.addAlgorithm("Cipher.RSA/ISO9796-1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$ISO9796d1Padding");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.RSA//RAW", "RSA");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.RSA//NOPADDING", "RSA");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.RSA//PKCS1PADDING", "RSA/PKCS1");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.RSA//OAEPPADDING", "RSA/OAEP");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.RSA//ISO9796-1PADDING", "RSA/ISO9796-1");
            configurableProvider.addAlgorithm("KeyFactory.RSA", "org.bouncycastle.jcajce.provider.asymmetric.rsa.KeyFactorySpi");
            configurableProvider.addAlgorithm("KeyPairGenerator.RSA", "org.bouncycastle.jcajce.provider.asymmetric.rsa.KeyPairGeneratorSpi");
            KeyFactorySpi keyFactorySpi = new KeyFactorySpi();
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = PKCSObjectIdentifiers.rsaEncryption;
            registerOid(configurableProvider, aSN1ObjectIdentifier2, "RSA", keyFactorySpi);
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = X509ObjectIdentifiers.id_ea_rsa;
            registerOid(configurableProvider, aSN1ObjectIdentifier3, "RSA", keyFactorySpi);
            registerOid(configurableProvider, aSN1ObjectIdentifier, "RSA", keyFactorySpi);
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = PKCSObjectIdentifiers.id_RSASSA_PSS;
            registerOid(configurableProvider, aSN1ObjectIdentifier4, "RSA", keyFactorySpi);
            registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifier2, "RSA");
            registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifier3, "RSA");
            registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifier, "OAEP");
            registerOidAlgorithmParameters(configurableProvider, aSN1ObjectIdentifier4, "PSS");
            configurableProvider.addAlgorithm("Signature.RSASSA-PSS", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$PSSwithRSA");
            configurableProvider.addAlgorithm("Signature." + aSN1ObjectIdentifier4, "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$PSSwithRSA");
            configurableProvider.addAlgorithm("Signature.OID." + aSN1ObjectIdentifier4, "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$PSSwithRSA");
            configurableProvider.addAlgorithm("Signature.SHA224withRSA/PSS", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA224withRSA");
            configurableProvider.addAlgorithm("Signature.SHA256withRSA/PSS", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA256withRSA");
            configurableProvider.addAlgorithm("Signature.SHA384withRSA/PSS", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA384withRSA");
            configurableProvider.addAlgorithm("Signature.SHA512withRSA/PSS", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512withRSA");
            configurableProvider.addAlgorithm("Signature.RSA", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$noneRSA");
            configurableProvider.addAlgorithm("Signature.RAWRSASSA-PSS", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$nonePSS");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.RAWRSA", "RSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.NONEWITHRSA", "RSA");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.RAWRSAPSS", "RAWRSASSA-PSS");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.NONEWITHRSAPSS", "RAWRSASSA-PSS");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.NONEWITHRSASSA-PSS", "RAWRSASSA-PSS");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.NONEWITHRSAANDMGF1", "RAWRSASSA-PSS");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.RSAPSS", "RSASSA-PSS");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA224withRSAandMGF1", "SHA224withRSA/PSS");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA256withRSAandMGF1", "SHA256withRSA/PSS");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA384withRSAandMGF1", "SHA384withRSA/PSS");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA512withRSAandMGF1", "SHA512withRSA/PSS");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA224WITHRSAANDMGF1", "SHA224withRSA/PSS");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA256WITHRSAANDMGF1", "SHA256withRSA/PSS");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA384WITHRSAANDMGF1", "SHA384withRSA/PSS");
            configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA512WITHRSAANDMGF1", "SHA512withRSA/PSS");
            if (configurableProvider.hasAlgorithm("MessageDigest", MessageDigestAlgorithms.MD2)) {
                addDigestSignature(configurableProvider, MessageDigestAlgorithms.MD2, "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD2", PKCSObjectIdentifiers.md2WithRSAEncryption);
            }
            if (configurableProvider.hasAlgorithm("MessageDigest", "MD4")) {
                addDigestSignature(configurableProvider, "MD4", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD4", PKCSObjectIdentifiers.md4WithRSAEncryption);
            }
            if (configurableProvider.hasAlgorithm("MessageDigest", "MD5")) {
                addDigestSignature(configurableProvider, "MD5", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD5", PKCSObjectIdentifiers.md5WithRSAEncryption);
                configurableProvider.addAlgorithm("Signature.MD5withRSA/ISO9796-2", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$MD5WithRSAEncryption");
                configurableProvider.addAlgorithm("Alg.Alias.Signature.MD5WithRSA/ISO9796-2", "MD5withRSA/ISO9796-2");
            }
            if (configurableProvider.hasAlgorithm("MessageDigest", "SHA1")) {
                configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA1withRSA/PSS", "PSS");
                configurableProvider.addAlgorithm("Alg.Alias.AlgorithmParameters.SHA1WITHRSAANDMGF1", "PSS");
                configurableProvider.addAlgorithm("Signature.SHA1withRSA/PSS", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA1withRSA");
                configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA1withRSAandMGF1", "SHA1withRSA/PSS");
                configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA1WITHRSAANDMGF1", "SHA1withRSA/PSS");
                addDigestSignature(configurableProvider, "SHA1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA1", PKCSObjectIdentifiers.sha1WithRSAEncryption);
                configurableProvider.addAlgorithm("Alg.Alias.Signature.SHA1WithRSA/ISO9796-2", "SHA1withRSA/ISO9796-2");
                configurableProvider.addAlgorithm("Signature.SHA1withRSA/ISO9796-2", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA1WithRSAEncryption");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Alg.Alias.Signature.");
                ASN1ObjectIdentifier aSN1ObjectIdentifier5 = OIWObjectIdentifiers.sha1WithRSA;
                sb2.append(aSN1ObjectIdentifier5);
                configurableProvider.addAlgorithm(sb2.toString(), "SHA1WITHRSA");
                configurableProvider.addAlgorithm("Alg.Alias.Signature.OID." + aSN1ObjectIdentifier5, "SHA1WITHRSA");
            }
            addDigestSignature(configurableProvider, "SHA224", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA224", PKCSObjectIdentifiers.sha224WithRSAEncryption);
            addDigestSignature(configurableProvider, McElieceCCA2ParameterSpec.DEFAULT_MD, "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA256", PKCSObjectIdentifiers.sha256WithRSAEncryption);
            addDigestSignature(configurableProvider, "SHA384", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA384", PKCSObjectIdentifiers.sha384WithRSAEncryption);
            addDigestSignature(configurableProvider, "SHA512", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA512", PKCSObjectIdentifiers.sha512WithRSAEncryption);
            if (configurableProvider.hasAlgorithm("MessageDigest", "RIPEMD128")) {
                addDigestSignature(configurableProvider, "RIPEMD128", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD128", TeleTrusTObjectIdentifiers.rsaSignatureWithripemd128);
                addDigestSignature(configurableProvider, "RMD128", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD128", null);
            }
            if (configurableProvider.hasAlgorithm("MessageDigest", "RIPEMD160")) {
                addDigestSignature(configurableProvider, "RIPEMD160", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD160", TeleTrusTObjectIdentifiers.rsaSignatureWithripemd160);
                addDigestSignature(configurableProvider, "RMD160", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD160", null);
                configurableProvider.addAlgorithm("Alg.Alias.Signature.RIPEMD160WithRSA/ISO9796-2", "RIPEMD160withRSA/ISO9796-2");
                configurableProvider.addAlgorithm("Signature.RIPEMD160withRSA/ISO9796-2", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$RIPEMD160WithRSAEncryption");
            }
            if (configurableProvider.hasAlgorithm("MessageDigest", "RIPEMD256")) {
                addDigestSignature(configurableProvider, "RIPEMD256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD256", TeleTrusTObjectIdentifiers.rsaSignatureWithripemd256);
                addDigestSignature(configurableProvider, "RMD256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD256", null);
            }
        }
    }
}
