package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: LocationCoordinateResultParser.java */
/* loaded from: classes3.dex */
public class Cb extends Fb {
    private static final Pattern g = Pattern.compile("geo:([\\s\\-0-9.]+),([\\s\\-0-9.]+)(?:[,?].*)?", 2);

    @Override // com.huawei.hms.scankit.p.Fb
    public HmsScan b(com.huawei.hms.scankit.aiscan.common.x xVar) {
        String strA = Fb.a(xVar);
        Matcher matcher = g.matcher(strA);
        if (!matcher.matches()) {
            return null;
        }
        try {
            return new HmsScan(xVar.i(), Fb.a(xVar.b()), strA, HmsScan.LOCATION_COORDINATE_FORM, xVar.g(), Fb.a(xVar.h()), null, new com.huawei.hms.scankit.F(new HmsScan.LocationCoordinate(Double.parseDouble(matcher.group(1)), Double.parseDouble(matcher.group(2)))));
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
