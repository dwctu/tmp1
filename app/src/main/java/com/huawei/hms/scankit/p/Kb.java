package com.huawei.hms.scankit.p;

import com.broadcom.bt.util.io.IOUtils;
import com.google.android.gms.stats.CodePackage;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.List;

/* compiled from: VEventResultParser.java */
/* loaded from: classes3.dex */
public final class Kb extends Fb {
    private static void a(String[] strArr, HmsScan.EventTime eventTime) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        for (String str : strArr) {
            C0423zb.a(str, eventTime);
        }
    }

    @Override // com.huawei.hms.scankit.p.Fb
    public HmsScan b(com.huawei.hms.scankit.aiscan.common.x xVar) {
        String strA = Fb.a(xVar);
        if (!strA.startsWith("BEGIN:VEVENT")) {
            return null;
        }
        String str = strA + IOUtils.LINE_SEPARATOR_UNIX;
        String strA2 = a("SUMMARY", str, true);
        String strA3 = a(CodePackage.LOCATION, str, true);
        String strA4 = a("ORGANIZER", str, true);
        String strA5 = a("DESCRIPTION", str, true);
        String strA6 = a("STATUS", str, true);
        String[] strArrB = b("DTSTART", str, true);
        String[] strArrB2 = b("DTEND", str, true);
        HmsScan.EventTime eventTime = new HmsScan.EventTime(-1, -1, -1, -1, -1, -1, false, "");
        HmsScan.EventTime eventTime2 = new HmsScan.EventTime(-1, -1, -1, -1, -1, -1, false, "");
        a(strArrB, eventTime);
        a(strArrB2, eventTime2);
        return new HmsScan(xVar.i(), Fb.a(xVar.b()), strA2, HmsScan.EVENT_INFO_FORM, xVar.g(), Fb.a(xVar.h()), null, new com.huawei.hms.scankit.F(new HmsScan.EventInfo(strA2, eventTime, eventTime2, strA3, strA5, strA4, strA6)));
    }

    private static String a(CharSequence charSequence, String str, boolean z) {
        List<List<String>> listA = Jb.a(charSequence, str, z, false);
        return (listA == null || listA.isEmpty()) ? "" : listA.get(listA.size() - 1).get(0);
    }

    private static String[] b(CharSequence charSequence, String str, boolean z) {
        List<List<String>> listA = Jb.a(charSequence, str, z, false);
        if (listA == null || listA.isEmpty()) {
            return new String[0];
        }
        int size = listA.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = listA.get(i).get(0);
        }
        return strArr;
    }
}
