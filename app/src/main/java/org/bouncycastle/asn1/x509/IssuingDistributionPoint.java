package org.bouncycastle.asn1.x509;

import org.aspectj.runtime.reflect.SignatureImpl;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERBoolean;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* loaded from: classes5.dex */
public class IssuingDistributionPoint extends ASN1Object {
    private DistributionPointName distributionPoint;
    private boolean indirectCRL;
    private boolean onlyContainsAttributeCerts;
    private boolean onlyContainsCACerts;
    private boolean onlyContainsUserCerts;
    private ReasonFlags onlySomeReasons;
    private ASN1Sequence seq;

    private IssuingDistributionPoint(ASN1Sequence aSN1Sequence) {
        this.seq = aSN1Sequence;
        for (int i = 0; i != aSN1Sequence.size(); i++) {
            ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(i));
            int tagNo = aSN1TaggedObject.getTagNo();
            if (tagNo == 0) {
                this.distributionPoint = DistributionPointName.getInstance(aSN1TaggedObject, true);
            } else if (tagNo == 1) {
                this.onlyContainsUserCerts = DERBoolean.getInstance(aSN1TaggedObject, false).isTrue();
            } else if (tagNo == 2) {
                this.onlyContainsCACerts = DERBoolean.getInstance(aSN1TaggedObject, false).isTrue();
            } else if (tagNo == 3) {
                this.onlySomeReasons = new ReasonFlags(DERBitString.getInstance(aSN1TaggedObject, false));
            } else if (tagNo == 4) {
                this.indirectCRL = DERBoolean.getInstance(aSN1TaggedObject, false).isTrue();
            } else {
                if (tagNo != 5) {
                    throw new IllegalArgumentException("unknown tag in IssuingDistributionPoint");
                }
                this.onlyContainsAttributeCerts = DERBoolean.getInstance(aSN1TaggedObject, false).isTrue();
            }
        }
    }

    public IssuingDistributionPoint(DistributionPointName distributionPointName, boolean z, boolean z2) {
        this(distributionPointName, false, false, null, z, z2);
    }

    public IssuingDistributionPoint(DistributionPointName distributionPointName, boolean z, boolean z2, ReasonFlags reasonFlags, boolean z3, boolean z4) {
        this.distributionPoint = distributionPointName;
        this.indirectCRL = z3;
        this.onlyContainsAttributeCerts = z4;
        this.onlyContainsCACerts = z2;
        this.onlyContainsUserCerts = z;
        this.onlySomeReasons = reasonFlags;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (distributionPointName != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, distributionPointName));
        }
        if (z) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, DERBoolean.getInstance(true)));
        }
        if (z2) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 2, DERBoolean.getInstance(true)));
        }
        if (reasonFlags != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 3, reasonFlags));
        }
        if (z3) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 4, DERBoolean.getInstance(true)));
        }
        if (z4) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 5, DERBoolean.getInstance(true)));
        }
        this.seq = new DERSequence(aSN1EncodableVector);
    }

    private void appendObject(StringBuffer stringBuffer, String str, String str2, String str3) {
        stringBuffer.append("    ");
        stringBuffer.append(str2);
        stringBuffer.append(SignatureImpl.INNER_SEP);
        stringBuffer.append(str);
        stringBuffer.append("    ");
        stringBuffer.append("    ");
        stringBuffer.append(str3);
        stringBuffer.append(str);
    }

    private String booleanToString(boolean z) {
        return z ? "true" : "false";
    }

    public static IssuingDistributionPoint getInstance(Object obj) {
        if (obj instanceof IssuingDistributionPoint) {
            return (IssuingDistributionPoint) obj;
        }
        if (obj != null) {
            return new IssuingDistributionPoint(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static IssuingDistributionPoint getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public DistributionPointName getDistributionPoint() {
        return this.distributionPoint;
    }

    public ReasonFlags getOnlySomeReasons() {
        return this.onlySomeReasons;
    }

    public boolean isIndirectCRL() {
        return this.indirectCRL;
    }

    public boolean onlyContainsAttributeCerts() {
        return this.onlyContainsAttributeCerts;
    }

    public boolean onlyContainsCACerts() {
        return this.onlyContainsCACerts;
    }

    public boolean onlyContainsUserCerts() {
        return this.onlyContainsUserCerts;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }

    public String toString() {
        String property = System.getProperty("line.separator");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("IssuingDistributionPoint: [");
        stringBuffer.append(property);
        DistributionPointName distributionPointName = this.distributionPoint;
        if (distributionPointName != null) {
            appendObject(stringBuffer, property, "distributionPoint", distributionPointName.toString());
        }
        boolean z = this.onlyContainsUserCerts;
        if (z) {
            appendObject(stringBuffer, property, "onlyContainsUserCerts", booleanToString(z));
        }
        boolean z2 = this.onlyContainsCACerts;
        if (z2) {
            appendObject(stringBuffer, property, "onlyContainsCACerts", booleanToString(z2));
        }
        ReasonFlags reasonFlags = this.onlySomeReasons;
        if (reasonFlags != null) {
            appendObject(stringBuffer, property, "onlySomeReasons", reasonFlags.toString());
        }
        boolean z3 = this.onlyContainsAttributeCerts;
        if (z3) {
            appendObject(stringBuffer, property, "onlyContainsAttributeCerts", booleanToString(z3));
        }
        boolean z4 = this.indirectCRL;
        if (z4) {
            appendObject(stringBuffer, property, "indirectCRL", booleanToString(z4));
        }
        stringBuffer.append("]");
        stringBuffer.append(property);
        return stringBuffer.toString();
    }
}
