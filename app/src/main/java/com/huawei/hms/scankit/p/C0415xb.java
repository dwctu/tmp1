package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.List;

/* compiled from: DriverInfoResultParser.java */
/* renamed from: com.huawei.hms.scankit.p.xb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0415xb extends Fb {
    private static final List<String> g = new C0411wb();
    private String h = "";

    public HmsScan.DriverInfo a(String[] strArr, String str) {
        String[] strArr2 = {"", "", "", "", "", "", "", "", "", "", "", "", "", ""};
        strArr2[0] = str;
        boolean z = false;
        for (String str2 : strArr) {
            if (str2.length() <= 3) {
                return null;
            }
            int iIndexOf = g.indexOf(str2.substring(0, 3));
            if (iIndexOf != -1) {
                strArr2[iIndexOf] = str2.substring(3).trim();
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        this.h = strArr2[0] + " " + strArr2[3] + " " + strArr2[1];
        return new HmsScan.DriverInfo(strArr2[0], strArr2[1], strArr2[2], strArr2[3], strArr2[4], strArr2[5], strArr2[6], strArr2[7], strArr2[8], strArr2[9], strArr2[10], strArr2[11], strArr2[12], strArr2[13], null, null, null, null);
    }

    @Override // com.huawei.hms.scankit.p.Fb
    public HmsScan b(com.huawei.hms.scankit.aiscan.common.x xVar) {
        String strA = Fb.a(xVar);
        if (!TextUtils.isEmpty(strA) && strA.startsWith("@") && strA.length() > 34 && strA.substring(4, 8).equals("ANSI")) {
            String strValueOf = String.valueOf(strA.charAt(1));
            String strValueOf2 = String.valueOf(strA.charAt(3));
            String strSubstring = strA.substring(21, 23);
            HmsScan.DriverInfo driverInfoA = a(strA.substring(strA.indexOf(strSubstring, 23) + 2).split(strValueOf2)[0].split(strValueOf), strSubstring);
            if (driverInfoA != null) {
                return new HmsScan(xVar.i(), Fb.a(xVar.b()), this.h, HmsScan.DRIVER_INFO_FORM, xVar.g(), Fb.a(xVar.h()), null, new com.huawei.hms.scankit.F(driverInfoA));
            }
        }
        return null;
    }
}
