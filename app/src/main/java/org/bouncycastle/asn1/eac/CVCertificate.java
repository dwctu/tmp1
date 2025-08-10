package org.bouncycastle.asn1.eac;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERApplicationSpecific;
import org.bouncycastle.asn1.DEROctetString;

/* loaded from: classes5.dex */
public class CVCertificate extends ASN1Object {
    public static String ReferenceEncoding = "ISO-8859-1";
    private static int bodyValid = 1;
    private static int signValid = 2;
    public static final byte version_1 = 0;
    private CertificateBody certificateBody;
    private byte[] signature;
    private int valid;

    public CVCertificate(ASN1InputStream aSN1InputStream) throws IOException {
        initFrom(aSN1InputStream);
    }

    private CVCertificate(DERApplicationSpecific dERApplicationSpecific) throws IOException {
        setPrivateData(dERApplicationSpecific);
    }

    public CVCertificate(CertificateBody certificateBody, byte[] bArr) throws IOException {
        this.certificateBody = certificateBody;
        this.signature = bArr;
        int i = this.valid | bodyValid;
        this.valid = i;
        this.valid = i | signValid;
    }

    public static CVCertificate getInstance(Object obj) {
        if (obj instanceof CVCertificate) {
            return (CVCertificate) obj;
        }
        if (obj == null) {
            return null;
        }
        try {
            return new CVCertificate(DERApplicationSpecific.getInstance(obj));
        } catch (IOException e) {
            throw new ASN1ParsingException("unable to parse data: " + e.getMessage(), e);
        }
    }

    private void initFrom(ASN1InputStream aSN1InputStream) throws IOException {
        while (true) {
            ASN1Primitive object = aSN1InputStream.readObject();
            if (object == null) {
                return;
            }
            if (!(object instanceof DERApplicationSpecific)) {
                throw new IOException("Invalid Input Stream for creating an Iso7816CertificateStructure");
            }
            setPrivateData((DERApplicationSpecific) object);
        }
    }

    private void setPrivateData(DERApplicationSpecific dERApplicationSpecific) throws IOException {
        int i;
        int i2;
        this.valid = 0;
        if (dERApplicationSpecific.getApplicationTag() != 33) {
            throw new IOException("not a CARDHOLDER_CERTIFICATE :" + dERApplicationSpecific.getApplicationTag());
        }
        ASN1InputStream aSN1InputStream = new ASN1InputStream(dERApplicationSpecific.getContents());
        while (true) {
            ASN1Primitive object = aSN1InputStream.readObject();
            if (object == null) {
                return;
            }
            if (!(object instanceof DERApplicationSpecific)) {
                throw new IOException("Invalid Object, not an Iso7816CertificateStructure");
            }
            DERApplicationSpecific dERApplicationSpecific2 = (DERApplicationSpecific) object;
            int applicationTag = dERApplicationSpecific2.getApplicationTag();
            if (applicationTag == 55) {
                this.signature = dERApplicationSpecific2.getContents();
                i = this.valid;
                i2 = signValid;
            } else {
                if (applicationTag != 78) {
                    throw new IOException("Invalid tag, not an Iso7816CertificateStructure :" + dERApplicationSpecific2.getApplicationTag());
                }
                this.certificateBody = CertificateBody.getInstance(dERApplicationSpecific2);
                i = this.valid;
                i2 = bodyValid;
            }
            this.valid = i | i2;
        }
    }

    public CertificationAuthorityReference getAuthorityReference() throws IOException {
        return this.certificateBody.getCertificationAuthorityReference();
    }

    public CertificateBody getBody() {
        return this.certificateBody;
    }

    public int getCertificateType() {
        return this.certificateBody.getCertificateType();
    }

    public PackedDate getEffectiveDate() throws IOException {
        return this.certificateBody.getCertificateEffectiveDate();
    }

    public PackedDate getExpirationDate() throws IOException {
        return this.certificateBody.getCertificateExpirationDate();
    }

    public ASN1ObjectIdentifier getHolderAuthorization() throws IOException {
        return this.certificateBody.getCertificateHolderAuthorization().getOid();
    }

    public Flags getHolderAuthorizationRights() throws IOException {
        return new Flags(this.certificateBody.getCertificateHolderAuthorization().getAccessRights() & 31);
    }

    public int getHolderAuthorizationRole() throws IOException {
        return this.certificateBody.getCertificateHolderAuthorization().getAccessRights() & 192;
    }

    public CertificateHolderReference getHolderReference() throws IOException {
        return this.certificateBody.getCertificateHolderReference();
    }

    public int getRole() throws IOException {
        return this.certificateBody.getCertificateHolderAuthorization().getAccessRights();
    }

    public byte[] getSignature() {
        return this.signature;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        if (this.valid != (signValid | bodyValid)) {
            return null;
        }
        aSN1EncodableVector.add(this.certificateBody);
        try {
            aSN1EncodableVector.add(new DERApplicationSpecific(false, 55, (ASN1Encodable) new DEROctetString(this.signature)));
            return new DERApplicationSpecific(33, aSN1EncodableVector);
        } catch (IOException unused) {
            throw new IllegalStateException("unable to convert signature!");
        }
    }
}
