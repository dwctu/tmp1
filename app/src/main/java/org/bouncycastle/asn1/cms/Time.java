package org.bouncycastle.asn1.cms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERUTCTime;

/* loaded from: classes5.dex */
public class Time extends ASN1Object implements ASN1Choice {
    public ASN1Primitive time;

    public Time(Date date) throws NumberFormatException {
        SimpleTimeZone simpleTimeZone = new SimpleTimeZone(0, "Z");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        simpleDateFormat.setTimeZone(simpleTimeZone);
        String str = simpleDateFormat.format(date) + "Z";
        int i = Integer.parseInt(str.substring(0, 4));
        this.time = (i < 1950 || i > 2049) ? new DERGeneralizedTime(str) : new DERUTCTime(str.substring(2));
    }

    public Time(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERUTCTime) && !(aSN1Primitive instanceof DERGeneralizedTime)) {
            throw new IllegalArgumentException("unknown object passed to Time");
        }
        this.time = aSN1Primitive;
    }

    public static Time getInstance(Object obj) {
        if (obj == null || (obj instanceof Time)) {
            return (Time) obj;
        }
        if (obj instanceof DERUTCTime) {
            return new Time((DERUTCTime) obj);
        }
        if (obj instanceof DERGeneralizedTime) {
            return new Time((DERGeneralizedTime) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public static Time getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    public Date getDate() {
        try {
            ASN1Primitive aSN1Primitive = this.time;
            return aSN1Primitive instanceof DERUTCTime ? ((DERUTCTime) aSN1Primitive).getAdjustedDate() : ((DERGeneralizedTime) aSN1Primitive).getDate();
        } catch (ParseException e) {
            throw new IllegalStateException("invalid date string: " + e.getMessage());
        }
    }

    public String getTime() {
        ASN1Primitive aSN1Primitive = this.time;
        return aSN1Primitive instanceof DERUTCTime ? ((DERUTCTime) aSN1Primitive).getAdjustedTime() : ((DERGeneralizedTime) aSN1Primitive).getTime();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.time;
    }
}
