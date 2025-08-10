package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0309a;
import com.huawei.hms.scankit.aiscan.common.C0313e;
import com.huawei.hms.scankit.aiscan.common.EnumC0312d;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: PDF417Reader.java */
/* renamed from: com.huawei.hms.scankit.p.va, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0406va implements com.huawei.hms.scankit.aiscan.common.t {
    private static final com.huawei.hms.scankit.aiscan.common.x[] a = new com.huawei.hms.scankit.aiscan.common.x[0];

    private static int b(com.huawei.hms.scankit.aiscan.common.z zVar, com.huawei.hms.scankit.aiscan.common.z zVar2) {
        if (zVar == null || zVar2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(zVar.b() - zVar2.b());
    }

    @Override // com.huawei.hms.scankit.aiscan.common.t
    public com.huawei.hms.scankit.aiscan.common.x a(C0409w c0409w, Map<EnumC0312d, ?> map) throws C0309a {
        com.huawei.hms.scankit.aiscan.common.x[] xVarArrA = a(c0409w, map, false);
        if (xVarArrA.length == 0 || xVarArrA[0] == null) {
            throw C0309a.a();
        }
        return xVarArrA[0];
    }

    private static int b(com.huawei.hms.scankit.aiscan.common.z[] zVarArr) {
        return Math.min(Math.min(b(zVarArr[0], zVarArr[4]), (b(zVarArr[6], zVarArr[2]) * 17) / 18), Math.min(b(zVarArr[1], zVarArr[5]), (b(zVarArr[7], zVarArr[3]) * 17) / 18));
    }

    private static com.huawei.hms.scankit.aiscan.common.x[] a(C0409w c0409w, Map<EnumC0312d, ?> map, boolean z) throws C0309a {
        ArrayList arrayList = new ArrayList();
        C0402ua c0402uaA = C0379oa.a(c0409w, map, z);
        for (com.huawei.hms.scankit.aiscan.common.z[] zVarArr : c0402uaA.b()) {
            C0313e c0313eA = C0414xa.a(c0402uaA.a(), zVarArr[4], zVarArr[5], zVarArr[6], zVarArr[7], b(zVarArr), a(zVarArr), map);
            if (C0379oa.a()) {
                for (int i = 0; i < zVarArr.length; i++) {
                    if (zVarArr[i] != null) {
                        zVarArr[i] = new com.huawei.hms.scankit.aiscan.common.z((c0409w.e() - 1) - zVarArr[i].b(), (c0409w.c() - 1) - zVarArr[i].c());
                    }
                }
            }
            if (zVarArr.length == 8) {
                if (zVarArr[0] == null && zVarArr[1] == null && zVarArr[4] == null && zVarArr[5] == null) {
                    zVarArr[0] = zVarArr[6];
                    zVarArr[1] = zVarArr[7];
                    zVarArr[4] = zVarArr[2];
                    zVarArr[5] = zVarArr[3];
                } else if (zVarArr[2] == null && zVarArr[3] == null && zVarArr[6] == null && zVarArr[7] == null) {
                    zVarArr[2] = zVarArr[4];
                    zVarArr[3] = zVarArr[5];
                    zVarArr[6] = zVarArr[0];
                    zVarArr[7] = zVarArr[1];
                }
                arrayList.add(new com.huawei.hms.scankit.aiscan.common.x(c0313eA.d(), c0313eA.c(), zVarArr, BarcodeFormat.PDF_417));
            } else {
                throw C0309a.a("pdf417 points size incorrect!");
            }
        }
        return (com.huawei.hms.scankit.aiscan.common.x[]) arrayList.toArray(a);
    }

    private static int a(com.huawei.hms.scankit.aiscan.common.z zVar, com.huawei.hms.scankit.aiscan.common.z zVar2) {
        if (zVar == null || zVar2 == null) {
            return 0;
        }
        return (int) Math.abs(zVar.b() - zVar2.b());
    }

    private static int a(com.huawei.hms.scankit.aiscan.common.z[] zVarArr) {
        return Math.max(Math.max(a(zVarArr[0], zVarArr[4]), (a(zVarArr[6], zVarArr[2]) * 17) / 18), Math.max(a(zVarArr[1], zVarArr[5]), (a(zVarArr[7], zVarArr[3]) * 17) / 18));
    }
}
