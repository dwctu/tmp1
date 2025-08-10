package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.X500Name;

/* loaded from: classes5.dex */
public class ServiceLocator extends ASN1Object {
    public X500Name issuer;
    public ASN1Primitive locator;

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.issuer);
        ASN1Primitive aSN1Primitive = this.locator;
        if (aSN1Primitive != null) {
            aSN1EncodableVector.add(aSN1Primitive);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
