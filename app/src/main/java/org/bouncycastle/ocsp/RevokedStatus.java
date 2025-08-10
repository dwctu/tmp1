package org.bouncycastle.ocsp;

import java.text.ParseException;
import java.util.Date;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ocsp.RevokedInfo;
import org.bouncycastle.asn1.x509.CRLReason;

/* loaded from: classes5.dex */
public class RevokedStatus implements CertificateStatus {
    public RevokedInfo info;

    public RevokedStatus(Date date, int i) {
        this.info = new RevokedInfo(new ASN1GeneralizedTime(date), CRLReason.lookup(i));
    }

    public RevokedStatus(RevokedInfo revokedInfo) {
        this.info = revokedInfo;
    }

    public int getRevocationReason() {
        if (this.info.getRevocationReason() != null) {
            return this.info.getRevocationReason().getValue().intValue();
        }
        throw new IllegalStateException("attempt to get a reason where none is available");
    }

    public Date getRevocationTime() {
        try {
            return this.info.getRevocationTime().getDate();
        } catch (ParseException e) {
            throw new IllegalStateException("ParseException:" + e.getMessage());
        }
    }

    public boolean hasRevocationReason() {
        return this.info.getRevocationReason() != null;
    }
}
