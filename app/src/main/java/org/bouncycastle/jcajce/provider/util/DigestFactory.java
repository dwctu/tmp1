package org.bouncycastle.jcajce.provider.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2ParameterSpec;
import org.bouncycastle.util.Strings;

/* loaded from: classes5.dex */
public class DigestFactory {
    private static Set md5 = new HashSet();
    private static Set sha1 = new HashSet();
    private static Set sha224 = new HashSet();
    private static Set sha256 = new HashSet();
    private static Set sha384 = new HashSet();
    private static Set sha512 = new HashSet();
    private static Map oids = new HashMap();

    static {
        md5.add("MD5");
        Set set = md5;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.md5;
        set.add(aSN1ObjectIdentifier.getId());
        sha1.add("SHA1");
        sha1.add("SHA-1");
        Set set2 = sha1;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = OIWObjectIdentifiers.idSHA1;
        set2.add(aSN1ObjectIdentifier2.getId());
        sha224.add("SHA224");
        sha224.add("SHA-224");
        Set set3 = sha224;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_sha224;
        set3.add(aSN1ObjectIdentifier3.getId());
        sha256.add(McElieceCCA2ParameterSpec.DEFAULT_MD);
        sha256.add(MessageDigestAlgorithms.SHA_256);
        Set set4 = sha256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.id_sha256;
        set4.add(aSN1ObjectIdentifier4.getId());
        sha384.add("SHA384");
        sha384.add(MessageDigestAlgorithms.SHA_384);
        Set set5 = sha384;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = NISTObjectIdentifiers.id_sha384;
        set5.add(aSN1ObjectIdentifier5.getId());
        sha512.add("SHA512");
        sha512.add(MessageDigestAlgorithms.SHA_512);
        Set set6 = sha512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = NISTObjectIdentifiers.id_sha512;
        set6.add(aSN1ObjectIdentifier6.getId());
        oids.put("MD5", aSN1ObjectIdentifier);
        oids.put(aSN1ObjectIdentifier.getId(), aSN1ObjectIdentifier);
        oids.put("SHA1", aSN1ObjectIdentifier2);
        oids.put("SHA-1", aSN1ObjectIdentifier2);
        oids.put(aSN1ObjectIdentifier2.getId(), aSN1ObjectIdentifier2);
        oids.put("SHA224", aSN1ObjectIdentifier3);
        oids.put("SHA-224", aSN1ObjectIdentifier3);
        oids.put(aSN1ObjectIdentifier3.getId(), aSN1ObjectIdentifier3);
        oids.put(McElieceCCA2ParameterSpec.DEFAULT_MD, aSN1ObjectIdentifier4);
        oids.put(MessageDigestAlgorithms.SHA_256, aSN1ObjectIdentifier4);
        oids.put(aSN1ObjectIdentifier4.getId(), aSN1ObjectIdentifier4);
        oids.put("SHA384", aSN1ObjectIdentifier5);
        oids.put(MessageDigestAlgorithms.SHA_384, aSN1ObjectIdentifier5);
        oids.put(aSN1ObjectIdentifier5.getId(), aSN1ObjectIdentifier5);
        oids.put("SHA512", aSN1ObjectIdentifier6);
        oids.put(MessageDigestAlgorithms.SHA_512, aSN1ObjectIdentifier6);
        oids.put(aSN1ObjectIdentifier6.getId(), aSN1ObjectIdentifier6);
    }

    public static Digest getDigest(String str) {
        String upperCase = Strings.toUpperCase(str);
        if (sha1.contains(upperCase)) {
            return new SHA1Digest();
        }
        if (md5.contains(upperCase)) {
            return new MD5Digest();
        }
        if (sha224.contains(upperCase)) {
            return new SHA224Digest();
        }
        if (sha256.contains(upperCase)) {
            return new SHA256Digest();
        }
        if (sha384.contains(upperCase)) {
            return new SHA384Digest();
        }
        if (sha512.contains(upperCase)) {
            return new SHA512Digest();
        }
        return null;
    }

    public static ASN1ObjectIdentifier getOID(String str) {
        return (ASN1ObjectIdentifier) oids.get(str);
    }

    public static boolean isSameDigest(String str, String str2) {
        return (sha1.contains(str) && sha1.contains(str2)) || (sha224.contains(str) && sha224.contains(str2)) || ((sha256.contains(str) && sha256.contains(str2)) || ((sha384.contains(str) && sha384.contains(str2)) || ((sha512.contains(str) && sha512.contains(str2)) || (md5.contains(str) && md5.contains(str2)))));
    }
}
