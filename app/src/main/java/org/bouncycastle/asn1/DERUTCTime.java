package org.bouncycastle.asn1;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* loaded from: classes5.dex */
public class DERUTCTime extends ASN1Primitive {
    private byte[] time;

    public DERUTCTime(String str) {
        this.time = Strings.toByteArray(str);
        try {
            getDate();
        } catch (ParseException e) {
            throw new IllegalArgumentException("invalid date string: " + e.getMessage());
        }
    }

    public DERUTCTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss'Z'");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.time = Strings.toByteArray(simpleDateFormat.format(date));
    }

    public DERUTCTime(byte[] bArr) {
        this.time = bArr;
    }

    public static ASN1UTCTime getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1UTCTime)) {
            return (ASN1UTCTime) obj;
        }
        if (obj instanceof DERUTCTime) {
            return new ASN1UTCTime(((DERUTCTime) obj).time);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (ASN1UTCTime) ASN1Primitive.fromByteArray((byte[]) obj);
        } catch (Exception e) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
        }
    }

    public static ASN1UTCTime getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        return (z || (object instanceof ASN1UTCTime)) ? getInstance(object) : new ASN1UTCTime(((ASN1OctetString) object).getOctets());
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof DERUTCTime) {
            return Arrays.areEqual(this.time, ((DERUTCTime) aSN1Primitive).time);
        }
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.write(23);
        int length = this.time.length;
        aSN1OutputStream.writeLength(length);
        for (int i = 0; i != length; i++) {
            aSN1OutputStream.write(this.time[i]);
        }
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() {
        int length = this.time.length;
        return StreamUtil.calculateBodyLength(length) + 1 + length;
    }

    public Date getAdjustedDate() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssz");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        return simpleDateFormat.parse(getAdjustedTime());
    }

    public String getAdjustedTime() {
        StringBuilder sb;
        String str;
        String time = getTime();
        if (time.charAt(0) < '5') {
            sb = new StringBuilder();
            str = "20";
        } else {
            sb = new StringBuilder();
            str = "19";
        }
        sb.append(str);
        sb.append(time);
        return sb.toString();
    }

    public Date getDate() throws ParseException {
        return new SimpleDateFormat("yyMMddHHmmssz").parse(getTime());
    }

    public String getTime() {
        StringBuilder sb;
        String strSubstring;
        String strFromByteArray = Strings.fromByteArray(this.time);
        if (strFromByteArray.indexOf(45) >= 0 || strFromByteArray.indexOf(43) >= 0) {
            int iIndexOf = strFromByteArray.indexOf(45);
            if (iIndexOf < 0) {
                iIndexOf = strFromByteArray.indexOf(43);
            }
            if (iIndexOf == strFromByteArray.length() - 3) {
                strFromByteArray = strFromByteArray + "00";
            }
            if (iIndexOf == 10) {
                sb = new StringBuilder();
                sb.append(strFromByteArray.substring(0, 10));
                sb.append("00GMT");
                sb.append(strFromByteArray.substring(10, 13));
                sb.append(SignatureImpl.INNER_SEP);
                strSubstring = strFromByteArray.substring(13, 15);
            } else {
                sb = new StringBuilder();
                sb.append(strFromByteArray.substring(0, 12));
                sb.append("GMT");
                sb.append(strFromByteArray.substring(12, 15));
                sb.append(SignatureImpl.INNER_SEP);
                strSubstring = strFromByteArray.substring(15, 17);
            }
        } else if (strFromByteArray.length() == 11) {
            sb = new StringBuilder();
            sb.append(strFromByteArray.substring(0, 10));
            strSubstring = "00GMT+00:00";
        } else {
            sb = new StringBuilder();
            sb.append(strFromByteArray.substring(0, 12));
            strSubstring = "GMT+00:00";
        }
        sb.append(strSubstring);
        return sb.toString();
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(this.time);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    public String toString() {
        return Strings.fromByteArray(this.time);
    }
}
