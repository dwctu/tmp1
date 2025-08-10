package org.bouncycastle.asn1;

import java.io.IOException;

/* loaded from: classes5.dex */
public class DLTaggedObject extends ASN1TaggedObject {
    private static final byte[] ZERO_BYTES = new byte[0];

    public DLTaggedObject(boolean z, int i, ASN1Encodable aSN1Encodable) {
        super(z, i, aSN1Encodable);
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObject, org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        if (this.empty) {
            aSN1OutputStream.writeEncoded(160, this.tagNo, ZERO_BYTES);
            return;
        }
        ASN1Primitive dLObject = this.obj.toASN1Primitive().toDLObject();
        if (!this.explicit) {
            aSN1OutputStream.writeTag(dLObject.isConstructed() ? 160 : 128, this.tagNo);
            aSN1OutputStream.writeImplicitObject(dLObject);
        } else {
            aSN1OutputStream.writeTag(160, this.tagNo);
            aSN1OutputStream.writeLength(dLObject.encodedLength());
            aSN1OutputStream.writeObject(dLObject);
        }
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() throws IOException {
        int iCalculateTagLength;
        if (this.empty) {
            return StreamUtil.calculateTagLength(this.tagNo) + 1;
        }
        int iEncodedLength = this.obj.toASN1Primitive().toDLObject().encodedLength();
        if (this.explicit) {
            iCalculateTagLength = StreamUtil.calculateTagLength(this.tagNo) + StreamUtil.calculateBodyLength(iEncodedLength);
        } else {
            iEncodedLength--;
            iCalculateTagLength = StreamUtil.calculateTagLength(this.tagNo);
        }
        return iCalculateTagLength + iEncodedLength;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        if (this.empty || this.explicit) {
            return true;
        }
        return this.obj.toASN1Primitive().toDLObject().isConstructed();
    }
}
