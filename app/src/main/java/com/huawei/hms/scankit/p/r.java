package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0309a;
import com.huawei.hms.scankit.aiscan.common.C0313e;
import com.huawei.hms.scankit.aiscan.common.EnumC0312d;
import java.util.Map;

/* compiled from: AztecReader.java */
/* loaded from: classes3.dex */
public final class r implements com.huawei.hms.scankit.aiscan.common.t {
    @Override // com.huawei.hms.scankit.aiscan.common.t
    public com.huawei.hms.scankit.aiscan.common.x a(C0409w c0409w, Map<EnumC0312d, ?> map) throws Exception {
        com.huawei.hms.scankit.aiscan.common.z[] zVarArrD;
        com.huawei.hms.scankit.aiscan.common.A a;
        C0401u c0401u = new C0401u(c0409w.b());
        C0313e c0313eA = null;
        try {
            C0386q c0386qA = c0401u.a(false);
            zVarArrD = c0386qA.d();
            try {
                C0313e c0313eA2 = new C0397t().a(c0386qA, map);
                e = null;
                c0313eA = c0313eA2;
            } catch (C0309a e) {
                e = e;
            }
        } catch (C0309a e2) {
            e = e2;
            zVarArrD = null;
        }
        if (c0313eA == null) {
            try {
                C0386q c0386qA2 = c0401u.a(true);
                zVarArrD = c0386qA2.d();
                c0313eA = new C0397t().a(c0386qA2, map);
            } catch (C0309a e3) {
                if (zVarArrD != null && !_a.c) {
                    return new com.huawei.hms.scankit.aiscan.common.x(null, null, 0, (com.huawei.hms.scankit.aiscan.common.z[]) zVarArrD.clone(), BarcodeFormat.AZTEC, System.currentTimeMillis());
                }
                if (e != null) {
                    throw e;
                }
                throw e3;
            }
        }
        com.huawei.hms.scankit.aiscan.common.z[] zVarArr = zVarArrD;
        if (map != null && (a = (com.huawei.hms.scankit.aiscan.common.A) map.get(EnumC0312d.NEED_RESULT_POINT_CALLBACK)) != null && zVarArr != null) {
            for (com.huawei.hms.scankit.aiscan.common.z zVar : zVarArr) {
                a.a(zVar);
            }
        }
        return new com.huawei.hms.scankit.aiscan.common.x(c0313eA.d(), c0313eA.c(), c0313eA.a(), zVarArr, BarcodeFormat.AZTEC, System.currentTimeMillis());
    }
}
