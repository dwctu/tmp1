package org.bouncycastle.asn1.cmp;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERSequence;

/* loaded from: classes5.dex */
public class PKIStatusInfo extends ASN1Object {
    public DERBitString failInfo;
    public ASN1Integer status;
    public PKIFreeText statusString;

    private PKIStatusInfo(ASN1Sequence aSN1Sequence) {
        ASN1Encodable objectAt;
        this.status = DERInteger.getInstance(aSN1Sequence.getObjectAt(0));
        this.statusString = null;
        this.failInfo = null;
        if (aSN1Sequence.size() > 2) {
            this.statusString = PKIFreeText.getInstance(aSN1Sequence.getObjectAt(1));
            objectAt = aSN1Sequence.getObjectAt(2);
        } else {
            if (aSN1Sequence.size() <= 1) {
                return;
            }
            objectAt = aSN1Sequence.getObjectAt(1);
            if (!(objectAt instanceof DERBitString)) {
                this.statusString = PKIFreeText.getInstance(objectAt);
                return;
            }
        }
        this.failInfo = DERBitString.getInstance(objectAt);
    }

    public PKIStatusInfo(PKIStatus pKIStatus) {
        this.status = DERInteger.getInstance(pKIStatus.toASN1Primitive());
    }

    public PKIStatusInfo(PKIStatus pKIStatus, PKIFreeText pKIFreeText) {
        this.status = DERInteger.getInstance(pKIStatus.toASN1Primitive());
        this.statusString = pKIFreeText;
    }

    public PKIStatusInfo(PKIStatus pKIStatus, PKIFreeText pKIFreeText, PKIFailureInfo pKIFailureInfo) {
        this.status = DERInteger.getInstance(pKIStatus.toASN1Primitive());
        this.statusString = pKIFreeText;
        this.failInfo = pKIFailureInfo;
    }

    public static PKIStatusInfo getInstance(Object obj) {
        if (obj instanceof PKIStatusInfo) {
            return (PKIStatusInfo) obj;
        }
        if (obj != null) {
            return new PKIStatusInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static PKIStatusInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public DERBitString getFailInfo() {
        return this.failInfo;
    }

    public BigInteger getStatus() {
        return this.status.getValue();
    }

    public PKIFreeText getStatusString() {
        return this.statusString;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.status);
        PKIFreeText pKIFreeText = this.statusString;
        if (pKIFreeText != null) {
            aSN1EncodableVector.add(pKIFreeText);
        }
        DERBitString dERBitString = this.failInfo;
        if (dERBitString != null) {
            aSN1EncodableVector.add(dERBitString);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
