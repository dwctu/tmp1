package org.bouncycastle.asn1.nist;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.RoomMasterTable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* loaded from: classes5.dex */
public interface NISTObjectIdentifiers {
    public static final ASN1ObjectIdentifier aes;
    public static final ASN1ObjectIdentifier dsa_with_sha224;
    public static final ASN1ObjectIdentifier dsa_with_sha256;
    public static final ASN1ObjectIdentifier dsa_with_sha384;
    public static final ASN1ObjectIdentifier dsa_with_sha512;
    public static final ASN1ObjectIdentifier hashAlgs;
    public static final ASN1ObjectIdentifier id_aes128_CBC;
    public static final ASN1ObjectIdentifier id_aes128_CCM;
    public static final ASN1ObjectIdentifier id_aes128_CFB;
    public static final ASN1ObjectIdentifier id_aes128_ECB;
    public static final ASN1ObjectIdentifier id_aes128_GCM;
    public static final ASN1ObjectIdentifier id_aes128_OFB;
    public static final ASN1ObjectIdentifier id_aes128_wrap;
    public static final ASN1ObjectIdentifier id_aes192_CBC;
    public static final ASN1ObjectIdentifier id_aes192_CCM;
    public static final ASN1ObjectIdentifier id_aes192_CFB;
    public static final ASN1ObjectIdentifier id_aes192_ECB;
    public static final ASN1ObjectIdentifier id_aes192_GCM;
    public static final ASN1ObjectIdentifier id_aes192_OFB;
    public static final ASN1ObjectIdentifier id_aes192_wrap;
    public static final ASN1ObjectIdentifier id_aes256_CBC;
    public static final ASN1ObjectIdentifier id_aes256_CCM;
    public static final ASN1ObjectIdentifier id_aes256_CFB;
    public static final ASN1ObjectIdentifier id_aes256_ECB;
    public static final ASN1ObjectIdentifier id_aes256_GCM;
    public static final ASN1ObjectIdentifier id_aes256_OFB;
    public static final ASN1ObjectIdentifier id_aes256_wrap;
    public static final ASN1ObjectIdentifier id_dsa_with_sha2;
    public static final ASN1ObjectIdentifier id_sha224;
    public static final ASN1ObjectIdentifier id_sha256;
    public static final ASN1ObjectIdentifier id_sha384;
    public static final ASN1ObjectIdentifier id_sha512;
    public static final ASN1ObjectIdentifier id_sha512_224;
    public static final ASN1ObjectIdentifier id_sha512_256;
    public static final ASN1ObjectIdentifier nistAlgorithm;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("2.16.840.1.101.3.4");
        nistAlgorithm = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifierBranch = aSN1ObjectIdentifier.branch("2");
        hashAlgs = aSN1ObjectIdentifierBranch;
        id_sha256 = aSN1ObjectIdentifierBranch.branch("1");
        id_sha384 = aSN1ObjectIdentifierBranch.branch("2");
        id_sha512 = aSN1ObjectIdentifierBranch.branch(ExifInterface.GPS_MEASUREMENT_3D);
        id_sha224 = aSN1ObjectIdentifierBranch.branch("4");
        id_sha512_224 = aSN1ObjectIdentifierBranch.branch("5");
        id_sha512_256 = aSN1ObjectIdentifierBranch.branch("6");
        ASN1ObjectIdentifier aSN1ObjectIdentifierBranch2 = aSN1ObjectIdentifier.branch("1");
        aes = aSN1ObjectIdentifierBranch2;
        id_aes128_ECB = aSN1ObjectIdentifierBranch2.branch("1");
        id_aes128_CBC = aSN1ObjectIdentifierBranch2.branch("2");
        id_aes128_OFB = aSN1ObjectIdentifierBranch2.branch(ExifInterface.GPS_MEASUREMENT_3D);
        id_aes128_CFB = aSN1ObjectIdentifierBranch2.branch("4");
        id_aes128_wrap = aSN1ObjectIdentifierBranch2.branch("5");
        id_aes128_GCM = aSN1ObjectIdentifierBranch2.branch("6");
        id_aes128_CCM = aSN1ObjectIdentifierBranch2.branch("7");
        id_aes192_ECB = aSN1ObjectIdentifierBranch2.branch("21");
        id_aes192_CBC = aSN1ObjectIdentifierBranch2.branch("22");
        id_aes192_OFB = aSN1ObjectIdentifierBranch2.branch("23");
        id_aes192_CFB = aSN1ObjectIdentifierBranch2.branch("24");
        id_aes192_wrap = aSN1ObjectIdentifierBranch2.branch("25");
        id_aes192_GCM = aSN1ObjectIdentifierBranch2.branch("26");
        id_aes192_CCM = aSN1ObjectIdentifierBranch2.branch("27");
        id_aes256_ECB = aSN1ObjectIdentifierBranch2.branch("41");
        id_aes256_CBC = aSN1ObjectIdentifierBranch2.branch(RoomMasterTable.DEFAULT_ID);
        id_aes256_OFB = aSN1ObjectIdentifierBranch2.branch("43");
        id_aes256_CFB = aSN1ObjectIdentifierBranch2.branch("44");
        id_aes256_wrap = aSN1ObjectIdentifierBranch2.branch("45");
        id_aes256_GCM = aSN1ObjectIdentifierBranch2.branch("46");
        id_aes256_CCM = aSN1ObjectIdentifierBranch2.branch("47");
        ASN1ObjectIdentifier aSN1ObjectIdentifierBranch3 = aSN1ObjectIdentifier.branch(ExifInterface.GPS_MEASUREMENT_3D);
        id_dsa_with_sha2 = aSN1ObjectIdentifierBranch3;
        dsa_with_sha224 = aSN1ObjectIdentifierBranch3.branch("1");
        dsa_with_sha256 = aSN1ObjectIdentifierBranch3.branch("2");
        dsa_with_sha384 = aSN1ObjectIdentifierBranch3.branch(ExifInterface.GPS_MEASUREMENT_3D);
        dsa_with_sha512 = aSN1ObjectIdentifierBranch3.branch("4");
    }
}
