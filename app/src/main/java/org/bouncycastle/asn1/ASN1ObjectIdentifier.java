package org.bouncycastle.asn1;

/* loaded from: classes5.dex */
public class ASN1ObjectIdentifier extends DERObjectIdentifier {
    public ASN1ObjectIdentifier(String str) {
        super(str);
    }

    public ASN1ObjectIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        super(aSN1ObjectIdentifier, str);
    }

    public ASN1ObjectIdentifier(byte[] bArr) {
        super(bArr);
    }

    public ASN1ObjectIdentifier branch(String str) {
        return new ASN1ObjectIdentifier(this, str);
    }

    public boolean on(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String id = getId();
        String id2 = aSN1ObjectIdentifier.getId();
        return id.length() > id2.length() && id.charAt(id2.length()) == '.' && id.startsWith(id2);
    }
}
