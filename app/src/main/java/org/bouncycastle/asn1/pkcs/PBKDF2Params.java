package org.bouncycastle.asn1.pkcs;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* loaded from: classes5.dex */
public class PBKDF2Params extends ASN1Object {
    private static final AlgorithmIdentifier algid_hmacWithSHA1 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA1, (ASN1Encodable) DERNull.INSTANCE);
    private ASN1Integer iterationCount;
    private ASN1Integer keyLength;
    private ASN1OctetString octStr;
    private AlgorithmIdentifier prf;

    private PBKDF2Params(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.octStr = (ASN1OctetString) objects.nextElement();
        this.iterationCount = (ASN1Integer) objects.nextElement();
        if (objects.hasMoreElements()) {
            Object objNextElement = objects.nextElement();
            if (objNextElement instanceof ASN1Integer) {
                this.keyLength = DERInteger.getInstance(objNextElement);
                objNextElement = objects.hasMoreElements() ? objects.nextElement() : null;
            } else {
                this.keyLength = null;
            }
            if (objNextElement != null) {
                this.prf = AlgorithmIdentifier.getInstance(objNextElement);
            }
        }
    }

    public PBKDF2Params(byte[] bArr, int i) {
        this.octStr = new DEROctetString(bArr);
        this.iterationCount = new ASN1Integer(i);
    }

    public PBKDF2Params(byte[] bArr, int i, int i2) {
        this(bArr, i);
        this.keyLength = new ASN1Integer(i2);
    }

    public PBKDF2Params(byte[] bArr, int i, int i2, AlgorithmIdentifier algorithmIdentifier) {
        this(bArr, i);
        this.keyLength = new ASN1Integer(i2);
        this.prf = algorithmIdentifier;
    }

    public PBKDF2Params(byte[] bArr, int i, AlgorithmIdentifier algorithmIdentifier) {
        this(bArr, i);
        this.prf = algorithmIdentifier;
    }

    public static PBKDF2Params getInstance(Object obj) {
        if (obj instanceof PBKDF2Params) {
            return (PBKDF2Params) obj;
        }
        if (obj != null) {
            return new PBKDF2Params(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BigInteger getIterationCount() {
        return this.iterationCount.getValue();
    }

    public BigInteger getKeyLength() {
        ASN1Integer aSN1Integer = this.keyLength;
        if (aSN1Integer != null) {
            return aSN1Integer.getValue();
        }
        return null;
    }

    public AlgorithmIdentifier getPrf() {
        AlgorithmIdentifier algorithmIdentifier = this.prf;
        return algorithmIdentifier != null ? algorithmIdentifier : algid_hmacWithSHA1;
    }

    public byte[] getSalt() {
        return this.octStr.getOctets();
    }

    public boolean isDefaultPrf() {
        AlgorithmIdentifier algorithmIdentifier = this.prf;
        return algorithmIdentifier == null || algorithmIdentifier.equals(algid_hmacWithSHA1);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.octStr);
        aSN1EncodableVector.add(this.iterationCount);
        ASN1Integer aSN1Integer = this.keyLength;
        if (aSN1Integer != null) {
            aSN1EncodableVector.add(aSN1Integer);
        }
        AlgorithmIdentifier algorithmIdentifier = this.prf;
        if (algorithmIdentifier != null && !algorithmIdentifier.equals(algid_hmacWithSHA1)) {
            aSN1EncodableVector.add(this.prf);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
