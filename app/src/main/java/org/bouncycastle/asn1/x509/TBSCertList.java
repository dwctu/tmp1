package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.DERUTCTime;
import org.bouncycastle.asn1.x500.X500Name;

/* loaded from: classes5.dex */
public class TBSCertList extends ASN1Object {
    public Extensions crlExtensions;
    public X500Name issuer;
    public Time nextUpdate;
    public ASN1Sequence revokedCertificates;
    public AlgorithmIdentifier signature;
    public Time thisUpdate;
    public ASN1Integer version;

    public static class CRLEntry extends ASN1Object {
        public Extensions crlEntryExtensions;
        public ASN1Sequence seq;

        private CRLEntry(ASN1Sequence aSN1Sequence) {
            if (aSN1Sequence.size() >= 2 && aSN1Sequence.size() <= 3) {
                this.seq = aSN1Sequence;
                return;
            }
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }

        public static CRLEntry getInstance(Object obj) {
            if (obj instanceof CRLEntry) {
                return (CRLEntry) obj;
            }
            if (obj != null) {
                return new CRLEntry(ASN1Sequence.getInstance(obj));
            }
            return null;
        }

        public Extensions getExtensions() {
            if (this.crlEntryExtensions == null && this.seq.size() == 3) {
                this.crlEntryExtensions = Extensions.getInstance(this.seq.getObjectAt(2));
            }
            return this.crlEntryExtensions;
        }

        public Time getRevocationDate() {
            return Time.getInstance(this.seq.getObjectAt(1));
        }

        public ASN1Integer getUserCertificate() {
            return DERInteger.getInstance(this.seq.getObjectAt(0));
        }

        public boolean hasExtensions() {
            return this.seq.size() == 3;
        }

        @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
        public ASN1Primitive toASN1Primitive() {
            return this.seq;
        }
    }

    public class EmptyEnumeration implements Enumeration {
        private EmptyEnumeration() {
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return false;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            return null;
        }
    }

    public class RevokedCertificatesEnumeration implements Enumeration {
        private final Enumeration en;

        public RevokedCertificatesEnumeration(Enumeration enumeration) {
            this.en = enumeration;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.en.hasMoreElements();
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            return CRLEntry.getInstance(this.en.nextElement());
        }
    }

    public TBSCertList(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 3 || aSN1Sequence.size() > 7) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
        int i = 0;
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1Integer) {
            this.version = DERInteger.getInstance(aSN1Sequence.getObjectAt(0));
            i = 1;
        } else {
            this.version = null;
        }
        int i2 = i + 1;
        this.signature = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i));
        int i3 = i2 + 1;
        this.issuer = X500Name.getInstance(aSN1Sequence.getObjectAt(i2));
        int i4 = i3 + 1;
        this.thisUpdate = Time.getInstance(aSN1Sequence.getObjectAt(i3));
        if (i4 < aSN1Sequence.size() && ((aSN1Sequence.getObjectAt(i4) instanceof DERUTCTime) || (aSN1Sequence.getObjectAt(i4) instanceof DERGeneralizedTime) || (aSN1Sequence.getObjectAt(i4) instanceof Time))) {
            this.nextUpdate = Time.getInstance(aSN1Sequence.getObjectAt(i4));
            i4++;
        }
        if (i4 < aSN1Sequence.size() && !(aSN1Sequence.getObjectAt(i4) instanceof DERTaggedObject)) {
            this.revokedCertificates = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(i4));
            i4++;
        }
        if (i4 >= aSN1Sequence.size() || !(aSN1Sequence.getObjectAt(i4) instanceof DERTaggedObject)) {
            return;
        }
        this.crlExtensions = Extensions.getInstance(ASN1Sequence.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(i4), true));
    }

    public static TBSCertList getInstance(Object obj) {
        if (obj instanceof TBSCertList) {
            return (TBSCertList) obj;
        }
        if (obj != null) {
            return new TBSCertList(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static TBSCertList getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public Extensions getExtensions() {
        return this.crlExtensions;
    }

    public X500Name getIssuer() {
        return this.issuer;
    }

    public Time getNextUpdate() {
        return this.nextUpdate;
    }

    public Enumeration getRevokedCertificateEnumeration() {
        ASN1Sequence aSN1Sequence = this.revokedCertificates;
        return aSN1Sequence == null ? new EmptyEnumeration() : new RevokedCertificatesEnumeration(aSN1Sequence.getObjects());
    }

    public CRLEntry[] getRevokedCertificates() {
        ASN1Sequence aSN1Sequence = this.revokedCertificates;
        if (aSN1Sequence == null) {
            return new CRLEntry[0];
        }
        int size = aSN1Sequence.size();
        CRLEntry[] cRLEntryArr = new CRLEntry[size];
        for (int i = 0; i < size; i++) {
            cRLEntryArr[i] = CRLEntry.getInstance(this.revokedCertificates.getObjectAt(i));
        }
        return cRLEntryArr;
    }

    public AlgorithmIdentifier getSignature() {
        return this.signature;
    }

    public Time getThisUpdate() {
        return this.thisUpdate;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    public int getVersionNumber() {
        ASN1Integer aSN1Integer = this.version;
        if (aSN1Integer == null) {
            return 1;
        }
        return aSN1Integer.getValue().intValue() + 1;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1Integer aSN1Integer = this.version;
        if (aSN1Integer != null) {
            aSN1EncodableVector.add(aSN1Integer);
        }
        aSN1EncodableVector.add(this.signature);
        aSN1EncodableVector.add(this.issuer);
        aSN1EncodableVector.add(this.thisUpdate);
        Time time = this.nextUpdate;
        if (time != null) {
            aSN1EncodableVector.add(time);
        }
        ASN1Sequence aSN1Sequence = this.revokedCertificates;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.add(aSN1Sequence);
        }
        if (this.crlExtensions != null) {
            aSN1EncodableVector.add(new DERTaggedObject(0, this.crlExtensions));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
