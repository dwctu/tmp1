package org.bouncycastle.asn1;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.util.Arrays;

/* loaded from: classes5.dex */
public class DEREnumerated extends ASN1Primitive {
    private static ASN1Enumerated[] cache = new ASN1Enumerated[12];
    public byte[] bytes;

    public DEREnumerated(int i) {
        this.bytes = BigInteger.valueOf(i).toByteArray();
    }

    public DEREnumerated(BigInteger bigInteger) {
        this.bytes = bigInteger.toByteArray();
    }

    public DEREnumerated(byte[] bArr) {
        this.bytes = bArr;
    }

    public static ASN1Enumerated fromOctetString(byte[] bArr) {
        if (bArr.length > 1) {
            return new ASN1Enumerated(Arrays.clone(bArr));
        }
        if (bArr.length == 0) {
            throw new IllegalArgumentException("ENUMERATED has zero length");
        }
        int i = bArr[0] & 255;
        ASN1Enumerated[] aSN1EnumeratedArr = cache;
        if (i >= aSN1EnumeratedArr.length) {
            return new ASN1Enumerated(Arrays.clone(bArr));
        }
        ASN1Enumerated aSN1Enumerated = aSN1EnumeratedArr[i];
        if (aSN1Enumerated != null) {
            return aSN1Enumerated;
        }
        ASN1Enumerated aSN1Enumerated2 = new ASN1Enumerated(Arrays.clone(bArr));
        aSN1EnumeratedArr[i] = aSN1Enumerated2;
        return aSN1Enumerated2;
    }

    public static ASN1Enumerated getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Enumerated)) {
            return (ASN1Enumerated) obj;
        }
        if (obj instanceof DEREnumerated) {
            return new ASN1Enumerated(((DEREnumerated) obj).getValue());
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (ASN1Enumerated) ASN1Primitive.fromByteArray((byte[]) obj);
        } catch (Exception e) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
        }
    }

    public static ASN1Enumerated getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        return (z || (object instanceof DEREnumerated)) ? getInstance(object) : fromOctetString(((ASN1OctetString) object).getOctets());
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof DEREnumerated) {
            return Arrays.areEqual(this.bytes, ((DEREnumerated) aSN1Primitive).bytes);
        }
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeEncoded(10, this.bytes);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.bytes.length) + 1 + this.bytes.length;
    }

    public BigInteger getValue() {
        return new BigInteger(this.bytes);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(this.bytes);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }
}
