package org.bouncycastle.asn1.ua;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Ascii;
import org.apache.commons.codec.net.URLCodec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

/* loaded from: classes5.dex */
public class DSTU4145Params extends ASN1Object {
    private static final byte[] DEFAULT_DKE = {-87, -42, -21, 69, -15, 60, 112, -126, Byte.MIN_VALUE, -60, -106, 123, 35, Ascii.US, 94, -83, -10, 88, -21, -92, -64, 55, 41, Ascii.GS, 56, ExifInterface.MARKER_EOI, 107, -16, URLCodec.ESCAPE_CHAR, -54, 78, Ascii.ETB, -8, -23, 114, 13, -58, Ascii.NAK, -76, 58, 40, -105, 95, 11, -63, -34, -93, 100, 56, -75, 100, -22, 44, Ascii.ETB, -97, -48, Ascii.DC2, 62, 109, -72, -6, -59, 121, 4};
    private byte[] dke = DEFAULT_DKE;
    private DSTU4145ECBinary ecbinary;
    private ASN1ObjectIdentifier namedCurve;

    public DSTU4145Params(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.namedCurve = aSN1ObjectIdentifier;
    }

    public DSTU4145Params(DSTU4145ECBinary dSTU4145ECBinary) {
        this.ecbinary = dSTU4145ECBinary;
    }

    public static byte[] getDefaultDKE() {
        return DEFAULT_DKE;
    }

    public static DSTU4145Params getInstance(Object obj) {
        if (obj instanceof DSTU4145Params) {
            return (DSTU4145Params) obj;
        }
        if (obj == null) {
            throw new IllegalArgumentException("object parse error");
        }
        ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(obj);
        DSTU4145Params dSTU4145Params = aSN1Sequence.getObjectAt(0) instanceof ASN1ObjectIdentifier ? new DSTU4145Params(DERObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0))) : new DSTU4145Params(DSTU4145ECBinary.getInstance(aSN1Sequence.getObjectAt(0)));
        if (aSN1Sequence.size() == 2) {
            byte[] octets = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets();
            dSTU4145Params.dke = octets;
            if (octets.length != DEFAULT_DKE.length) {
                throw new IllegalArgumentException("object parse error");
            }
        }
        return dSTU4145Params;
    }

    public byte[] getDKE() {
        return this.dke;
    }

    public DSTU4145ECBinary getECBinary() {
        return this.ecbinary;
    }

    public ASN1ObjectIdentifier getNamedCurve() {
        return this.namedCurve;
    }

    public boolean isNamedCurve() {
        return this.namedCurve != null;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1Encodable aSN1Encodable = this.namedCurve;
        if (aSN1Encodable == null) {
            aSN1Encodable = this.ecbinary;
        }
        aSN1EncodableVector.add(aSN1Encodable);
        if (!Arrays.areEqual(this.dke, DEFAULT_DKE)) {
            aSN1EncodableVector.add(new DEROctetString(this.dke));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
