package org.bouncycastle.asn1.eac;

import java.io.IOException;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERApplicationSpecific;
import org.bouncycastle.asn1.DEROctetString;

/* loaded from: classes5.dex */
public class CVCertificateRequest extends ASN1Object {
    public static byte[] ZeroArray = {0};
    private static int bodyValid = 1;
    private static int signValid = 2;
    public int ProfileId;
    private CertificateBody certificateBody;
    public byte[] encoded;
    public byte[] encodedAuthorityReference;
    private byte[] outerSignature;
    public String strCertificateHolderReference;
    private int valid;
    private byte[] innerSignature = null;
    public ASN1ObjectIdentifier signOid = null;
    public ASN1ObjectIdentifier keyOid = null;
    public byte[] certificate = null;
    public String overSignerReference = null;
    public PublicKeyDataObject iso7816PubKey = null;

    private CVCertificateRequest(DERApplicationSpecific dERApplicationSpecific) throws IOException {
        this.outerSignature = null;
        if (dERApplicationSpecific.getApplicationTag() != 103) {
            initCertBody(dERApplicationSpecific);
            return;
        }
        ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(dERApplicationSpecific.getObject(16));
        initCertBody(DERApplicationSpecific.getInstance(aSN1Sequence.getObjectAt(0)));
        this.outerSignature = DERApplicationSpecific.getInstance(aSN1Sequence.getObjectAt(aSN1Sequence.size() - 1)).getContents();
    }

    public static CVCertificateRequest getInstance(Object obj) {
        if (obj instanceof CVCertificateRequest) {
            return (CVCertificateRequest) obj;
        }
        if (obj == null) {
            return null;
        }
        try {
            return new CVCertificateRequest(DERApplicationSpecific.getInstance(obj));
        } catch (IOException e) {
            throw new ASN1ParsingException("unable to parse data: " + e.getMessage(), e);
        }
    }

    private void initCertBody(DERApplicationSpecific dERApplicationSpecific) throws IOException {
        int i;
        int i2;
        if (dERApplicationSpecific.getApplicationTag() != 33) {
            throw new IOException("not a CARDHOLDER_CERTIFICATE in request:" + dERApplicationSpecific.getApplicationTag());
        }
        Enumeration objects = ASN1Sequence.getInstance(dERApplicationSpecific.getObject(16)).getObjects();
        while (objects.hasMoreElements()) {
            DERApplicationSpecific dERApplicationSpecific2 = DERApplicationSpecific.getInstance(objects.nextElement());
            int applicationTag = dERApplicationSpecific2.getApplicationTag();
            if (applicationTag == 55) {
                this.innerSignature = dERApplicationSpecific2.getContents();
                i = this.valid;
                i2 = signValid;
            } else {
                if (applicationTag != 78) {
                    throw new IOException("Invalid tag, not an CV Certificate Request element:" + dERApplicationSpecific2.getApplicationTag());
                }
                this.certificateBody = CertificateBody.getInstance(dERApplicationSpecific2);
                i = this.valid;
                i2 = bodyValid;
            }
            this.valid = i | i2;
        }
    }

    public CertificateBody getCertificateBody() {
        return this.certificateBody;
    }

    public byte[] getInnerSignature() {
        return this.innerSignature;
    }

    public byte[] getOuterSignature() {
        return this.outerSignature;
    }

    public PublicKeyDataObject getPublicKey() {
        return this.certificateBody.getPublicKey();
    }

    public boolean hasOuterSignature() {
        return this.outerSignature != null;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.certificateBody);
        try {
            aSN1EncodableVector.add(new DERApplicationSpecific(false, 55, (ASN1Encodable) new DEROctetString(this.innerSignature)));
            return new DERApplicationSpecific(33, aSN1EncodableVector);
        } catch (IOException unused) {
            throw new IllegalStateException("unable to convert signature!");
        }
    }
}
