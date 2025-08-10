package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: BizcardResultParser.java */
/* renamed from: com.huawei.hms.scankit.p.ub, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0403ub extends Fb {
    private static final Pattern g = Pattern.compile("(?:BIZCARD:)([\\s\\S]+)", 2);

    private static HmsScan.PeopleName a(String str, String str2, String str3) {
        HmsScan.PeopleName peopleName = new HmsScan.PeopleName("", "", "", "", "", "", "");
        peopleName.givenName = str;
        peopleName.familyName = str2;
        peopleName.fullName = str3;
        return peopleName;
    }

    private static HmsScan.AddressInfo[] c(String str) {
        return (str == null || str.isEmpty()) ? new HmsScan.AddressInfo[0] : new HmsScan.AddressInfo[]{new HmsScan.AddressInfo(new String[]{str}, HmsScan.AddressInfo.OTHER_USE_TYPE)};
    }

    private static HmsScan.EmailContent[] d(String str) {
        return (str == null || str.isEmpty()) ? new HmsScan.EmailContent[0] : new HmsScan.EmailContent[]{new HmsScan.EmailContent(str, "", "", HmsScan.EmailContent.OTHER_USE_TYPE)};
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
        String strA3 = a(strArrSplit, "X:");
        String strTrim = (strA2 + " " + strA3).trim();
        String strA4 = a(strArrSplit, "T:");
        String strA5 = a(strArrSplit, "C:");
        String strA6 = a(strArrSplit, "A:");
        return new HmsScan(xVar.i(), Fb.a(xVar.b()), strTrim, HmsScan.CONTACT_DETAIL_FORM, xVar.g(), Fb.a(xVar.h()), null, new com.huawei.hms.scankit.F(new HmsScan.ContactDetail(a(strA2, strA3, strTrim), strA4, strA5, b(a(strArrSplit, "B:"), a(strArrSplit, "F:"), a(strArrSplit, "M:")), d(a(strArrSplit, "E:")), c(strA6), new String[0], null)));
    }

    private static String a(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2.startsWith(str)) {
                return Fb.b(str2.substring(str.length()));
            }
        }
        return "";
    }

    private static HmsScan.TelPhoneNumber[] b(String str, String str2, String str3) {
        HmsScan.TelPhoneNumber[] telPhoneNumberArr = new HmsScan.TelPhoneNumber[0];
        ArrayList arrayList = new ArrayList(3);
        if (str != null && !str.isEmpty()) {
            arrayList.add(new HmsScan.TelPhoneNumber(HmsScan.TelPhoneNumber.OFFICE_USE_TYPE, str));
        }
        if (str2 != null && !str2.isEmpty()) {
            arrayList.add(new HmsScan.TelPhoneNumber(HmsScan.TelPhoneNumber.FAX_USE_TYPE, str2));
        }
        if (str3 != null && !str3.isEmpty()) {
            arrayList.add(new HmsScan.TelPhoneNumber(HmsScan.TelPhoneNumber.CELLPHONE_NUMBER_USE_TYPE, str3));
        }
        return (HmsScan.TelPhoneNumber[]) arrayList.toArray(telPhoneNumberArr);
    }
}
