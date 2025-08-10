package com.huawei.hms.scankit.p;

import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: TelPhoneNumberResultParser.java */
/* loaded from: classes3.dex */
public final class Hb extends Fb {
    private static final Pattern g = Pattern.compile("tel:([\\s\\S]+)", 2);

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
        String strGroup = matcher.group(1);
        return new HmsScan(xVar.i(), Fb.a(xVar.b()), strGroup, HmsScan.TEL_PHONE_NUMBER_FORM, xVar.g(), Fb.a(xVar.h()), null, new com.huawei.hms.scankit.F(new HmsScan.TelPhoneNumber(HmsScan.TelPhoneNumber.OTHER_USE_TYPE, strGroup)));
    }
}
