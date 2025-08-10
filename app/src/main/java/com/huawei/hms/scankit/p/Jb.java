package com.huawei.hms.scankit.p;

import com.broadcom.bt.util.io.IOUtils;
import com.google.android.vending.expansion.downloader.impl.DownloadsDB;
import com.huawei.hms.ml.scan.HmsScan;
import com.xtremeprog.sdk.ble.BleService;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: VCardResultParser.java */
/* loaded from: classes3.dex */
public final class Jb extends Fb {
    private static final Pattern g = Pattern.compile("\r?\n[ \t]");
    private static final Pattern h = Pattern.compile("=");
    private static final Pattern i = Pattern.compile(";");
    private static final Pattern j = Pattern.compile("(?<!\\\\);+");

    public static List<List<String>> a(CharSequence charSequence, String str, boolean z, boolean z2) {
        ArrayList arrayList;
        boolean z3;
        String str2;
        int iIndexOf;
        String strReplaceAll;
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        ArrayList arrayList2 = null;
        while (i3 < length) {
            Matcher matcher = Pattern.compile("(?:^|\n)" + ((Object) charSequence) + "(?:;([^:\n(?![ |\t])]*))?:").matcher(str);
            if (i3 > 0) {
                i3--;
            }
            if (!matcher.find(i3)) {
                break;
            }
            int iEnd = matcher.end(i2);
            String strGroup = matcher.group(1);
            if (strGroup != null) {
                String[] strArrSplit = i.split(strGroup);
                int length2 = strArrSplit.length;
                int i4 = 0;
                arrayList = null;
                z3 = false;
                str2 = null;
                while (i4 < length2) {
                    String str3 = strArrSplit[i4];
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(str3);
                    String[] strArrSplit2 = h.split(str3, 2);
                    if (strArrSplit2.length > 1) {
                        String str4 = strArrSplit2[i2];
                        String str5 = strArrSplit2[1];
                        if ("ENCODING".equalsIgnoreCase(str4) && "QUOTED-PRINTABLE".equalsIgnoreCase(str5)) {
                            z3 = true;
                        } else if ("CHARSET".equalsIgnoreCase(str4)) {
                            str2 = str5;
                        } else {
                            BleService.EXTRA_VALUE.equalsIgnoreCase(str4);
                        }
                    }
                    i4++;
                    i2 = 0;
                }
            } else {
                arrayList = null;
                z3 = false;
                str2 = null;
            }
            int i5 = iEnd;
            while (true) {
                iIndexOf = str.indexOf(10, i5);
                if (iIndexOf < 0) {
                    break;
                }
                if (iIndexOf < str.length() - 1) {
                    int i6 = iIndexOf + 1;
                    if (str.charAt(i6) == ' ' || str.charAt(i6) == '\t') {
                        i5 = iIndexOf + 2;
                    }
                }
                if (!z3 || ((iIndexOf < 1 || str.charAt(iIndexOf - 1) != '=') && (iIndexOf < 2 || str.charAt(iIndexOf - 2) != '='))) {
                    break;
                }
                i5 = iIndexOf + 1;
            }
            if (iIndexOf < 0) {
                i3 = length;
            } else if (iIndexOf <= iEnd) {
                i3 = iIndexOf + 1;
            } else {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                }
                if (iIndexOf >= 1 && str.charAt(iIndexOf - 1) == '\r') {
                    iIndexOf--;
                }
                String strSubstring = str.substring(iEnd, iIndexOf);
                if (z) {
                    strSubstring = strSubstring.trim();
                }
                if (z3) {
                    strReplaceAll = a((CharSequence) strSubstring, str2);
                    if (z2) {
                        strReplaceAll = j.matcher(strReplaceAll).replaceAll(" ").trim();
                    }
                } else {
                    if (z2) {
                        strSubstring = j.matcher(strSubstring).replaceAll(" ").trim();
                    }
                    strReplaceAll = g.matcher(strSubstring).replaceAll("");
                }
                if (arrayList == null) {
                    ArrayList arrayList3 = new ArrayList(1);
                    arrayList3.add(strReplaceAll);
                    arrayList2.add(arrayList3);
                    i3 = iIndexOf + 1;
                } else {
                    arrayList.add(0, strReplaceAll);
                    arrayList2.add(arrayList);
                    i3 = iIndexOf + 1;
                }
            }
            i2 = 0;
        }
        return arrayList2;
    }

    private static HmsScan.TelPhoneNumber[] c(String[] strArr, String[] strArr2) {
        if (strArr.length != strArr2.length) {
            return new HmsScan.TelPhoneNumber[0];
        }
        HmsScan.TelPhoneNumber[] telPhoneNumberArr = new HmsScan.TelPhoneNumber[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            int i3 = HmsScan.TelPhoneNumber.OTHER_USE_TYPE;
            HmsScan.TelPhoneNumber telPhoneNumber = new HmsScan.TelPhoneNumber(i3, strArr2[i2]);
            if (strArr[i2] != null) {
                if (strArr[i2].equals("WORK")) {
                    telPhoneNumber.useType = HmsScan.TelPhoneNumber.OFFICE_USE_TYPE;
                } else if (strArr[i2].equals("HOME")) {
                    telPhoneNumber.useType = HmsScan.TelPhoneNumber.RESIDENTIAL_USE_TYPE;
                } else if (strArr[i2].equals("CELL")) {
                    telPhoneNumber.useType = HmsScan.TelPhoneNumber.CELLPHONE_NUMBER_USE_TYPE;
                } else if (strArr[i2].equals("FAX")) {
                    telPhoneNumber.useType = HmsScan.TelPhoneNumber.FAX_USE_TYPE;
                } else {
                    telPhoneNumber.useType = i3;
                }
            }
            telPhoneNumberArr[i2] = telPhoneNumber;
        }
        return telPhoneNumberArr;
    }

    @Override // com.huawei.hms.scankit.p.Fb
    public HmsScan b(com.huawei.hms.scankit.aiscan.common.x xVar) {
        String strA = Fb.a(xVar);
        if (!strA.startsWith("BEGIN:VCARD")) {
            return null;
        }
        String str = strA + IOUtils.LINE_SEPARATOR_UNIX;
        String strB = b((CharSequence) "N", str, true, false);
        if (strB == null || strB.isEmpty() || strB.split(";").length == 0) {
            return null;
        }
        String strB2 = b((CharSequence) DownloadsDB.DownloadColumns.FILENAME, str, true, false);
        if (strB2 == null || strB2.isEmpty()) {
            strB2 = c(strB);
        }
        String str2 = strB2;
        List<List<String>> listA = a((CharSequence) "TEL", str, true, false);
        List<List<String>> listA2 = a((CharSequence) "EMAIL", str, true, false);
        List<List<String>> listA3 = a((CharSequence) "ADR", str, true, true);
        return new HmsScan(xVar.i(), Fb.a(xVar.b()), str2, HmsScan.CONTACT_DETAIL_FORM, xVar.g(), Fb.a(xVar.h()), null, new com.huawei.hms.scankit.F(new HmsScan.ContactDetail(a(strB, str2), b((CharSequence) "TITLE", str, true, false), b((CharSequence) "ORG", str, true, true), c(b(listA), a(listA)), b(b(listA2), a(listA2)), a(b(listA3), a(listA3)), a(a((CharSequence) "URL", str, true, false)), null)));
    }

    private static String c(String str) {
        int iIndexOf;
        if (str == null || str.isEmpty()) {
            return null;
        }
        String[] strArr = new String[5];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 4 && (iIndexOf = str.indexOf(59, i3)) >= 0) {
            strArr[i2] = str.substring(i3, iIndexOf);
            i2++;
            i3 = iIndexOf + 1;
        }
        strArr[i2] = str.substring(i3);
        StringBuilder sb = new StringBuilder(100);
        a(strArr, 3, sb);
        a(strArr, 1, sb);
        a(strArr, 2, sb);
        a(strArr, 0, sb);
        a(strArr, 4, sb);
        return sb.toString().trim();
    }

    private static String b(CharSequence charSequence, String str, boolean z, boolean z2) {
        List<List<String>> listA = a(charSequence, str, z, z2);
        String str2 = "";
        if (listA != null && !listA.isEmpty()) {
            for (List<String> list : listA) {
                if (list.get(0) != null && !list.get(0).isEmpty()) {
                    str2 = list.get(0);
                }
            }
        }
        return str2;
    }

    private static String[] b(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<String> list : collection) {
            String str = list.get(0);
            if (str != null && !str.isEmpty()) {
                String strSubstring = null;
                int i2 = 1;
                while (true) {
                    if (i2 >= list.size()) {
                        break;
                    }
                    String str2 = list.get(i2);
                    int iIndexOf = str2.indexOf(61);
                    if (iIndexOf < 0) {
                        strSubstring = str2;
                        break;
                    }
                    if ("TYPE".equals(str2.substring(0, iIndexOf))) {
                        strSubstring = str2.substring(iIndexOf + 1);
                        break;
                    }
                    i2++;
                }
                arrayList.add(strSubstring);
            }
        }
        return (String[]) arrayList.toArray(Fb.f);
    }

    private static String a(CharSequence charSequence, String str) {
        char cCharAt;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (i2 < length) {
            char cCharAt2 = charSequence.charAt(i2);
            if (cCharAt2 != '\n' && cCharAt2 != '\r') {
                if (cCharAt2 != '=') {
                    a(byteArrayOutputStream, str, sb);
                    sb.append(cCharAt2);
                } else if (i2 < length - 2 && (cCharAt = charSequence.charAt(i2 + 1)) != '\r' && cCharAt != '\n') {
                    i2 += 2;
                    char cCharAt3 = charSequence.charAt(i2);
                    int iA = Fb.a(cCharAt);
                    int iA2 = Fb.a(cCharAt3);
                    if (iA >= 0 && iA2 >= 0) {
                        byteArrayOutputStream.write((iA << 4) + iA2);
                    }
                }
            }
            i2++;
        }
        a(byteArrayOutputStream, str, sb);
        return sb.toString();
    }

    private static HmsScan.EmailContent[] b(String[] strArr, String[] strArr2) {
        if (strArr.length != strArr2.length) {
            return new HmsScan.EmailContent[0];
        }
        HmsScan.EmailContent[] emailContentArr = new HmsScan.EmailContent[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            HmsScan.EmailContent emailContent = new HmsScan.EmailContent(strArr2[i2], "", "", HmsScan.EmailContent.OTHER_USE_TYPE);
            if (strArr[i2] != null) {
                if (strArr[i2].equals("WORK")) {
                    emailContent.addressType = HmsScan.EmailContent.OFFICE_USE_TYPE;
                } else if (strArr[i2].equals("HOME")) {
                    emailContent.addressType = HmsScan.TelPhoneNumber.RESIDENTIAL_USE_TYPE;
                }
            }
            emailContentArr[i2] = emailContent;
        }
        return emailContentArr;
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuilder sb) {
        String str2;
        if (byteArrayOutputStream.size() > 0) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (str == null) {
                str2 = new String(byteArray, StandardCharsets.UTF_8);
            } else {
                try {
                    str2 = new String(byteArray, str);
                } catch (UnsupportedEncodingException unused) {
                    str2 = new String(byteArray, StandardCharsets.UTF_8);
                }
            }
            byteArrayOutputStream.reset();
            sb.append(str2);
        }
    }

    private static String[] a(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<List<String>> it = collection.iterator();
        while (it.hasNext()) {
            String str = it.next().get(0);
            if (str != null && !str.isEmpty()) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(Fb.f);
    }

    private static HmsScan.PeopleName a(String str, String str2) {
        HmsScan.PeopleName peopleName = new HmsScan.PeopleName("", "", "", "", "", "", "");
        if (str != null) {
            String[] strArrSplit = str.split(";");
            if (strArrSplit.length > 0) {
                peopleName.familyName = strArrSplit[0];
            }
            if (strArrSplit.length > 1) {
                peopleName.givenName = strArrSplit[1];
            }
            if (strArrSplit.length > 2) {
                peopleName.middleName = strArrSplit[2];
            }
            if (strArrSplit.length > 3) {
                peopleName.namePrefix = strArrSplit[3];
            }
            if (strArrSplit.length > 4) {
                peopleName.nameSuffix = strArrSplit[4];
            }
        }
        if (str2 != null) {
            peopleName.fullName = str2;
        }
        return peopleName;
    }

    private static HmsScan.AddressInfo[] a(String[] strArr, String[] strArr2) {
        if (strArr.length != strArr2.length) {
            return new HmsScan.AddressInfo[0];
        }
        HmsScan.AddressInfo[] addressInfoArr = new HmsScan.AddressInfo[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            HmsScan.AddressInfo addressInfo = new HmsScan.AddressInfo(new String[]{strArr2[i2]}, HmsScan.AddressInfo.OTHER_USE_TYPE);
            if (strArr[i2] != null) {
                if (strArr[i2].equals("WORK")) {
                    addressInfo.addressType = HmsScan.AddressInfo.OFFICE_TYPE;
                } else if (strArr[i2].equals("HOME")) {
                    addressInfo.addressType = HmsScan.AddressInfo.RESIDENTIAL_USE_TYPE;
                }
            }
            addressInfoArr[i2] = addressInfo;
        }
        return addressInfoArr;
    }

    private static void a(String[] strArr, int i2, StringBuilder sb) {
        if (strArr[i2] == null || strArr[i2].isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append(' ');
        }
        sb.append(strArr[i2]);
    }
}
