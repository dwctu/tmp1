package org.bouncycastle.asn1.dvcs;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEREnumerated;

/* loaded from: classes5.dex */
public class ServiceType extends ASN1Object {
    private ASN1Enumerated value;
    public static final ServiceType CPD = new ServiceType(1);
    public static final ServiceType VSD = new ServiceType(2);
    public static final ServiceType VPKC = new ServiceType(3);
    public static final ServiceType CCPD = new ServiceType(4);

    public ServiceType(int i) {
        this.value = new ASN1Enumerated(i);
    }

    private ServiceType(ASN1Enumerated aSN1Enumerated) {
        this.value = aSN1Enumerated;
    }

    public static ServiceType getInstance(Object obj) {
        if (obj instanceof ServiceType) {
            return (ServiceType) obj;
        }
        if (obj != null) {
            return new ServiceType(DEREnumerated.getInstance(obj));
        }
        return null;
    }

    public static ServiceType getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(DEREnumerated.getInstance(aSN1TaggedObject, z));
    }

    public BigInteger getValue() {
        return this.value.getValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.value;
    }

    public String toString() {
        int iIntValue = this.value.getValue().intValue();
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(iIntValue);
        sb.append(iIntValue == CPD.getValue().intValue() ? "(CPD)" : iIntValue == VSD.getValue().intValue() ? "(VSD)" : iIntValue == VPKC.getValue().intValue() ? "(VPKC)" : iIntValue == CCPD.getValue().intValue() ? "(CCPD)" : "?");
        return sb.toString();
    }
}
