package org.bouncycastle.asn1.ua;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x9.X9IntegerConverter;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.util.Arrays;

/* loaded from: classes5.dex */
public class DSTU4145ECBinary extends ASN1Object {
    public ASN1Integer a;
    public ASN1OctetString b;
    public ASN1OctetString bp;
    public DSTU4145BinaryField f;
    public ASN1Integer n;
    public BigInteger version;

    private DSTU4145ECBinary(ASN1Sequence aSN1Sequence) {
        this.version = BigInteger.valueOf(0L);
        int i = 0;
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1TaggedObject) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(0);
            if (!aSN1TaggedObject.isExplicit() || aSN1TaggedObject.getTagNo() != 0) {
                throw new IllegalArgumentException("object parse error");
            }
            this.version = DERInteger.getInstance(aSN1TaggedObject.getLoadedObject()).getValue();
            i = 1;
        }
        this.f = DSTU4145BinaryField.getInstance(aSN1Sequence.getObjectAt(i));
        int i2 = i + 1;
        this.a = DERInteger.getInstance(aSN1Sequence.getObjectAt(i2));
        int i3 = i2 + 1;
        this.b = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(i3));
        int i4 = i3 + 1;
        this.n = DERInteger.getInstance(aSN1Sequence.getObjectAt(i4));
        this.bp = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(i4 + 1));
    }

    public DSTU4145ECBinary(ECDomainParameters eCDomainParameters) {
        this.version = BigInteger.valueOf(0L);
        if (!(eCDomainParameters.getCurve() instanceof ECCurve.F2m)) {
            throw new IllegalArgumentException("only binary domain is possible");
        }
        ECCurve.F2m f2m = (ECCurve.F2m) eCDomainParameters.getCurve();
        this.f = new DSTU4145BinaryField(f2m.getM(), f2m.getK1(), f2m.getK2(), f2m.getK3());
        this.a = new ASN1Integer(f2m.getA().toBigInteger());
        X9IntegerConverter x9IntegerConverter = new X9IntegerConverter();
        this.b = new DEROctetString(x9IntegerConverter.integerToBytes(f2m.getB().toBigInteger(), x9IntegerConverter.getByteLength(f2m)));
        this.n = new ASN1Integer(eCDomainParameters.getN());
        this.bp = new DEROctetString(DSTU4145PointEncoder.encodePoint(eCDomainParameters.getG()));
    }

    public static DSTU4145ECBinary getInstance(Object obj) {
        if (obj instanceof DSTU4145ECBinary) {
            return (DSTU4145ECBinary) obj;
        }
        if (obj != null) {
            return new DSTU4145ECBinary(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BigInteger getA() {
        return this.a.getValue();
    }

    public byte[] getB() {
        return Arrays.clone(this.b.getOctets());
    }

    public DSTU4145BinaryField getField() {
        return this.f;
    }

    public byte[] getG() {
        return Arrays.clone(this.bp.getOctets());
    }

    public BigInteger getN() {
        return this.n.getValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.version.compareTo(BigInteger.valueOf(0L)) != 0) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, new ASN1Integer(this.version)));
        }
        aSN1EncodableVector.add(this.f);
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        aSN1EncodableVector.add(this.n);
        aSN1EncodableVector.add(this.bp);
        return new DERSequence(aSN1EncodableVector);
    }
}
