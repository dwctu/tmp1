package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* loaded from: classes5.dex */
public class UserNotice extends ASN1Object {
    private DisplayText explicitText;
    private NoticeReference noticeRef;

    private UserNotice(ASN1Sequence aSN1Sequence) {
        ASN1Encodable objectAt;
        if (aSN1Sequence.size() == 2) {
            this.noticeRef = NoticeReference.getInstance(aSN1Sequence.getObjectAt(0));
            objectAt = aSN1Sequence.getObjectAt(1);
        } else {
            if (aSN1Sequence.size() != 1) {
                throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
            }
            boolean z = aSN1Sequence.getObjectAt(0).toASN1Primitive() instanceof ASN1Sequence;
            objectAt = aSN1Sequence.getObjectAt(0);
            if (z) {
                this.noticeRef = NoticeReference.getInstance(objectAt);
                return;
            }
        }
        this.explicitText = DisplayText.getInstance(objectAt);
    }

    public UserNotice(NoticeReference noticeReference, String str) {
        this(noticeReference, new DisplayText(str));
    }

    public UserNotice(NoticeReference noticeReference, DisplayText displayText) {
        this.noticeRef = noticeReference;
        this.explicitText = displayText;
    }

    public static UserNotice getInstance(Object obj) {
        if (obj instanceof UserNotice) {
            return (UserNotice) obj;
        }
        if (obj != null) {
            return new UserNotice(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public DisplayText getExplicitText() {
        return this.explicitText;
    }

    public NoticeReference getNoticeRef() {
        return this.noticeRef;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        NoticeReference noticeReference = this.noticeRef;
        if (noticeReference != null) {
            aSN1EncodableVector.add(noticeReference);
        }
        DisplayText displayText = this.explicitText;
        if (displayText != null) {
            aSN1EncodableVector.add(displayText);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
