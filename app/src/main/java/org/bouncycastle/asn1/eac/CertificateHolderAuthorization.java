package org.bouncycastle.asn1.eac;

import java.io.IOException;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERApplicationSpecific;
import org.bouncycastle.util.Integers;

/* loaded from: classes5.dex */
public class CertificateHolderAuthorization extends ASN1Object {
    public static final int CVCA = 192;
    public static final int DV_DOMESTIC = 128;
    public static final int DV_FOREIGN = 64;
    public static final int IS = 0;
    public static final int RADG3 = 1;
    public static final int RADG4 = 2;
    public DERApplicationSpecific accessRights;
    public ASN1ObjectIdentifier oid;
    public static final ASN1ObjectIdentifier id_role_EAC = EACObjectIdentifiers.bsi_de.branch("3.1.2.1");
    public static Hashtable RightsDecodeMap = new Hashtable();
    public static BidirectionalMap AuthorizationRole = new BidirectionalMap();
    public static Hashtable ReverseMap = new Hashtable();

    static {
        RightsDecodeMap.put(Integers.valueOf(2), "RADG4");
        RightsDecodeMap.put(Integers.valueOf(1), "RADG3");
        AuthorizationRole.put(Integers.valueOf(192), "CVCA");
        AuthorizationRole.put(Integers.valueOf(128), "DV_DOMESTIC");
        AuthorizationRole.put(Integers.valueOf(64), "DV_FOREIGN");
        AuthorizationRole.put(Integers.valueOf(0), "IS");
    }

    public CertificateHolderAuthorization(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i) throws IOException {
        setOid(aSN1ObjectIdentifier);
        setAccessRights((byte) i);
    }

    public CertificateHolderAuthorization(DERApplicationSpecific dERApplicationSpecific) throws IOException {
        if (dERApplicationSpecific.getApplicationTag() == 76) {
            setPrivateData(new ASN1InputStream(dERApplicationSpecific.getContents()));
        }
    }

    public static int GetFlag(String str) {
        Integer num = (Integer) AuthorizationRole.getReverse(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("Unknown value " + str);
    }

    public static String GetRoleDescription(int i) {
        return (String) AuthorizationRole.get(Integers.valueOf(i));
    }

    private void setAccessRights(byte b) {
        this.accessRights = new DERApplicationSpecific(EACTags.getTag(83), new byte[]{b});
    }

    private void setOid(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.oid = aSN1ObjectIdentifier;
    }

    private void setPrivateData(ASN1InputStream aSN1InputStream) throws IOException {
        ASN1Primitive object = aSN1InputStream.readObject();
        if (!(object instanceof ASN1ObjectIdentifier)) {
            throw new IllegalArgumentException("no Oid in CerticateHolderAuthorization");
        }
        this.oid = (ASN1ObjectIdentifier) object;
        ASN1Primitive object2 = aSN1InputStream.readObject();
        if (!(object2 instanceof DERApplicationSpecific)) {
            throw new IllegalArgumentException("No access rights in CerticateHolderAuthorization");
        }
        this.accessRights = (DERApplicationSpecific) object2;
    }

    public int getAccessRights() {
        return this.accessRights.getContents()[0] & 255;
    }

    public ASN1ObjectIdentifier getOid() {
        return this.oid;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.oid);
        aSN1EncodableVector.add(this.accessRights);
        return new DERApplicationSpecific(76, aSN1EncodableVector);
    }
}
