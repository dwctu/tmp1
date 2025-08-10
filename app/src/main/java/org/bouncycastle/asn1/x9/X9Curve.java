package org.bouncycastle.asn1.x9;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.math.ec.ECCurve;

/* loaded from: classes5.dex */
public class X9Curve extends ASN1Object implements X9ObjectIdentifiers {
    private ECCurve curve;
    private ASN1ObjectIdentifier fieldIdentifier;
    private byte[] seed;

    public X9Curve(X9FieldID x9FieldID, ASN1Sequence aSN1Sequence) {
        int iIntValue;
        int iIntValue2;
        int i;
        ECCurve f2m;
        this.fieldIdentifier = null;
        ASN1ObjectIdentifier identifier = x9FieldID.getIdentifier();
        this.fieldIdentifier = identifier;
        if (identifier.equals(X9ObjectIdentifiers.prime_field)) {
            BigInteger value = ((ASN1Integer) x9FieldID.getParameters()).getValue();
            f2m = new ECCurve.Fp(value, new X9FieldElement(value, (ASN1OctetString) aSN1Sequence.getObjectAt(0)).getValue().toBigInteger(), new X9FieldElement(value, (ASN1OctetString) aSN1Sequence.getObjectAt(1)).getValue().toBigInteger());
        } else {
            if (!this.fieldIdentifier.equals(X9ObjectIdentifiers.characteristic_two_field)) {
                throw new IllegalArgumentException("This type of ECCurve is not implemented");
            }
            ASN1Sequence aSN1Sequence2 = ASN1Sequence.getInstance(x9FieldID.getParameters());
            int iIntValue3 = ((ASN1Integer) aSN1Sequence2.getObjectAt(0)).getValue().intValue();
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) aSN1Sequence2.getObjectAt(1);
            if (aSN1ObjectIdentifier.equals(X9ObjectIdentifiers.tpBasis)) {
                iIntValue2 = DERInteger.getInstance(aSN1Sequence2.getObjectAt(2)).getValue().intValue();
                i = 0;
                iIntValue = 0;
            } else {
                if (!aSN1ObjectIdentifier.equals(X9ObjectIdentifiers.ppBasis)) {
                    throw new IllegalArgumentException("This type of EC basis is not implemented");
                }
                ASN1Sequence aSN1Sequence3 = ASN1Sequence.getInstance(aSN1Sequence2.getObjectAt(2));
                int iIntValue4 = DERInteger.getInstance(aSN1Sequence3.getObjectAt(0)).getValue().intValue();
                int iIntValue5 = DERInteger.getInstance(aSN1Sequence3.getObjectAt(1)).getValue().intValue();
                iIntValue = DERInteger.getInstance(aSN1Sequence3.getObjectAt(2)).getValue().intValue();
                iIntValue2 = iIntValue4;
                i = iIntValue5;
            }
            int i2 = iIntValue2;
            int i3 = i;
            int i4 = iIntValue;
            f2m = new ECCurve.F2m(iIntValue3, i2, i3, i4, new X9FieldElement(iIntValue3, i2, i3, i4, (ASN1OctetString) aSN1Sequence.getObjectAt(0)).getValue().toBigInteger(), new X9FieldElement(iIntValue3, i2, i3, i4, (ASN1OctetString) aSN1Sequence.getObjectAt(1)).getValue().toBigInteger());
        }
        this.curve = f2m;
        if (aSN1Sequence.size() == 3) {
            this.seed = ((DERBitString) aSN1Sequence.getObjectAt(2)).getBytes();
        }
    }

    public X9Curve(ECCurve eCCurve) {
        this.fieldIdentifier = null;
        this.curve = eCCurve;
        this.seed = null;
        setFieldIdentifier();
    }

    public X9Curve(ECCurve eCCurve, byte[] bArr) {
        this.fieldIdentifier = null;
        this.curve = eCCurve;
        this.seed = bArr;
        setFieldIdentifier();
    }

    private void setFieldIdentifier() {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        ECCurve eCCurve = this.curve;
        if (eCCurve instanceof ECCurve.Fp) {
            aSN1ObjectIdentifier = X9ObjectIdentifiers.prime_field;
        } else {
            if (!(eCCurve instanceof ECCurve.F2m)) {
                throw new IllegalArgumentException("This type of ECCurve is not implemented");
            }
            aSN1ObjectIdentifier = X9ObjectIdentifiers.characteristic_two_field;
        }
        this.fieldIdentifier = aSN1ObjectIdentifier;
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public byte[] getSeed() {
        return this.seed;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.fieldIdentifier.equals(X9ObjectIdentifiers.prime_field) || this.fieldIdentifier.equals(X9ObjectIdentifiers.characteristic_two_field)) {
            aSN1EncodableVector.add(new X9FieldElement(this.curve.getA()).toASN1Primitive());
            X9FieldElement x9FieldElement = new X9FieldElement(this.curve.getB());
            aSN1EncodableVector.add(x9FieldElement.toASN1Primitive());
        }
        if (this.seed != null) {
            aSN1EncodableVector.add(new DERBitString(this.seed));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
