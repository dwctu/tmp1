package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERInteger;

/* loaded from: classes5.dex */
public class CRLNumber extends ASN1Object {
    private BigInteger number;

    public CRLNumber(BigInteger bigInteger) {
        this.number = bigInteger;
    }

    public static CRLNumber getInstance(Object obj) {
        if (obj instanceof CRLNumber) {
            return (CRLNumber) obj;
        }
        if (obj != null) {
            return new CRLNumber(DERInteger.getInstance(obj).getValue());
        }
        return null;
    }

    public BigInteger getCRLNumber() {
        return this.number;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new ASN1Integer(this.number);
    }

    public String toString() {
        return "CRLNumber: " + getCRLNumber();
    }
}
