package org.bouncycastle.asn1.ess;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;

/* loaded from: classes5.dex */
public class ContentHints extends ASN1Object {
    private DERUTF8String contentDescription;
    private ASN1ObjectIdentifier contentType;

    public ContentHints(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.contentType = aSN1ObjectIdentifier;
        this.contentDescription = null;
    }

    public ContentHints(ASN1ObjectIdentifier aSN1ObjectIdentifier, DERUTF8String dERUTF8String) {
        this.contentType = aSN1ObjectIdentifier;
        this.contentDescription = dERUTF8String;
    }

    private ContentHints(ASN1Sequence aSN1Sequence) {
        int i = 0;
        ASN1Encodable objectAt = aSN1Sequence.getObjectAt(0);
        if (objectAt.toASN1Primitive() instanceof DERUTF8String) {
            this.contentDescription = DERUTF8String.getInstance(objectAt);
            i = 1;
        }
        this.contentType = DERObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(i));
    }

    public ContentHints(DERObjectIdentifier dERObjectIdentifier) {
        this(new ASN1ObjectIdentifier(dERObjectIdentifier.getId()));
    }

    public ContentHints(DERObjectIdentifier dERObjectIdentifier, DERUTF8String dERUTF8String) {
        this(new ASN1ObjectIdentifier(dERObjectIdentifier.getId()), dERUTF8String);
    }

    public static ContentHints getInstance(Object obj) {
        if (obj instanceof ContentHints) {
            return (ContentHints) obj;
        }
        if (obj != null) {
            return new ContentHints(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public DERUTF8String getContentDescription() {
        return this.contentDescription;
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.contentType;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        DERUTF8String dERUTF8String = this.contentDescription;
        if (dERUTF8String != null) {
            aSN1EncodableVector.add(dERUTF8String);
        }
        aSN1EncodableVector.add(this.contentType);
        return new DERSequence(aSN1EncodableVector);
    }
}
