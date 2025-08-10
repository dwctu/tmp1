package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0309a;
import com.huawei.hms.scankit.aiscan.common.C0313e;
import com.huawei.hms.scankit.aiscan.common.EnumC0312d;
import java.util.Map;

/* compiled from: DataMatrixReader.java */
/* loaded from: classes3.dex */
public final class E implements com.huawei.hms.scankit.aiscan.common.t {
    private static final com.huawei.hms.scankit.aiscan.common.z[] a = new com.huawei.hms.scankit.aiscan.common.z[0];
    private final H b = new H();

    @Override // com.huawei.hms.scankit.aiscan.common.t
    public com.huawei.hms.scankit.aiscan.common.x a(C0409w c0409w, Map<EnumC0312d, ?> map) throws Exception {
        com.huawei.hms.scankit.aiscan.common.g gVarA = new I(c0409w.b()).a();
        try {
            C0313e c0313eA = this.b.a(gVarA.a(), map);
            return new com.huawei.hms.scankit.aiscan.common.x(c0313eA.d(), c0313eA.c(), gVarA.d(), BarcodeFormat.DATA_MATRIX);
        } catch (C0309a e) {
            if (gVarA.d() == null || _a.c) {
                throw e;
            }
            double dSqrt = Math.sqrt(Math.pow(gVarA.d()[0].b() - gVarA.d()[1].b(), 2.0d) + Math.pow(gVarA.d()[0].c() - gVarA.d()[1].c(), 2.0d));
            double dSqrt2 = Math.sqrt(Math.pow(gVarA.d()[0].b() - gVarA.d()[3].b(), 2.0d) + Math.pow(gVarA.d()[0].c() - gVarA.d()[3].c(), 2.0d));
            if (this.b.a() == null || Math.abs(dSqrt - dSqrt2) / dSqrt >= 0.1d) {
                throw e;
            }
            return new com.huawei.hms.scankit.aiscan.common.x(null, null, gVarA.d(), BarcodeFormat.DATA_MATRIX);
        }
    }
}
