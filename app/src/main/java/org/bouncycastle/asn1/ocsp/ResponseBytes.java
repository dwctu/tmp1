package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

/* loaded from: classes5.dex */
public class ResponseBytes extends ASN1Object {
    public ASN1OctetString response;
    public ASN1ObjectIdentifier responseType;

    public ResponseBytes(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1OctetString aSN1OctetString) {
        this.responseType = aSN1ObjectIdentifier;
        this.response = aSN1OctetString;
    }

    public ResponseBytes(ASN1Sequence aSN1Sequence) {
        this.responseType = (ASN1ObjectIdentifier) aSN1Sequence.getObjectAt(0);
        this.response = (ASN1OctetString) aSN1Sequence.getObjectAt(1);
    }

    public static ResponseBytes getInstance(Object obj) {
        if (obj == null || (obj instanceof ResponseBytes)) {
            return (ResponseBytes) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new ResponseBytes((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public static ResponseBytes getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public ASN1OctetString getResponse() {
        return this.response;
    }

    public ASN1ObjectIdentifier getResponseType() {
        return this.responseType;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.responseType);
        aSN1EncodableVector.add(this.response);
        return new DERSequence(aSN1EncodableVector);
    }
}
