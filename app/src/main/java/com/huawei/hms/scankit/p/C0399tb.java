package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: AddressBookDoCoMoResultParser.java */
/* renamed from: com.huawei.hms.scankit.p.tb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0399tb extends Fb {
    private static final Pattern g = Pattern.compile("(?:MECARD:)([\\s\\S]+)", 2);

    private static HmsScan.PeopleName a(String str, String str2) {
        HmsScan.PeopleName peopleName = new HmsScan.PeopleName("", "", "", "", "", "", "");
        peopleName.spelling = str2;
        int iIndexOf = str.indexOf(",");
        if (iIndexOf < 0) {
            peopleName.fullName = str;
            String[] strArrSplit = str.split(" ");
            if (strArrSplit.length > 0) {
                peopleName.givenName = strArrSplit[0];
            }
            if (strArrSplit.length > 1) {
                peopleName.familyName = strArrSplit[1];
            }
        } else {
            peopleName.familyName = str.substring(0, iIndexOf);
            int i = iIndexOf + 1;
            int iIndexOf2 = str.indexOf(",", i);
            if (iIndexOf2 < 0) {
                peopleName.givenName = str.substring(i);
            } else {
                peopleName.givenName = str.substring(i, iIndexOf2);
            }
            peopleName.fullName = peopleName.givenName + " " + peopleName.familyName;
        }
        return peopleName;
    }

    private static HmsScan.TelPhoneNumber[] c(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new HmsScan.TelPhoneNumber[0];
        }
        HmsScan.TelPhoneNumber[] telPhoneNumberArr = new HmsScan.TelPhoneNumber[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            telPhoneNumberArr[i] = new HmsScan.TelPhoneNumber(HmsScan.TelPhoneNumber.OTHER_USE_TYPE, strArr[i]);
        }
        return telPhoneNumberArr;
    }

    @Override // com.huawei.hms.scankit.p.Fb
    public HmsScan b(com.huawei.hms.scankit.aiscan.common.x xVar) {
        String strA = Fb.a(xVar);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        Matcher matcher = g.matcher(strA);
        if (!matcher.matches()) {
            return null;
        }
        String[] strArrSplit = matcher.group(1).split("(?<=(?<!\\\\)(?:\\\\\\\\){0,100});");
        String strA2 = a(strArrSplit, "N:");
        if (strA2.length() == 0) {
            return null;
        }
        String[] strArrB = b(strArrSplit, "TEL:");
        String[] strArrB2 = b(strArrSplit, "EMAIL:");
        String[] strArrB3 = b(strArrSplit, "ADR:");
        String[] strArrB4 = b(strArrSplit, "URL:");
        String strA3 = a(strArrSplit, "SOUND:");
        HmsScan.ContactDetail contactDetail = new HmsScan.ContactDetail(a(strA2, strA3), "", a(strArrSplit, "ORG:"), c(strArrB), b(strArrB2), a(strArrB3), strArrB4, a(strArrSplit, "NOTE:"));
        return new HmsScan(xVar.i(), Fb.a(xVar.b()), contactDetail.peopleName.fullName, HmsScan.CONTACT_DETAIL_FORM, xVar.g(), Fb.a(xVar.h()), null, new com.huawei.hms.scankit.F(contactDetail));
    }

    private static HmsScan.AddressInfo[] a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new HmsScan.AddressInfo[0];
        }
        HmsScan.AddressInfo[] addressInfoArr = new HmsScan.AddressInfo[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            addressInfoArr[i] = new HmsScan.AddressInfo(new String[]{strArr[i]}, HmsScan.AddressInfo.OTHER_USE_TYPE);
        }
        return addressInfoArr;
    }

    private static String a(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2.startsWith(str)) {
                return Fb.b(str2.substring(str.length()));
            }
        }
        return "";
    }

    private static HmsScan.EmailContent[] b(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new HmsScan.EmailContent[0];
        }
        HmsScan.EmailContent[] emailContentArr = new HmsScan.EmailContent[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            emailContentArr[i] = new HmsScan.EmailContent(strArr[i], "", "", HmsScan.EmailContent.OTHER_USE_TYPE);
        }
        return emailContentArr;
    }

    private static String[] b(String[] strArr, String str) {
        ArrayList arrayList = new ArrayList(5);
        for (String str2 : strArr) {
            if (str2.startsWith(str)) {
                arrayList.add(Fb.b(str2.substring(str.length())));
            }
        }
        return (String[]) arrayList.toArray(Fb.f);
    }
}
