package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0309a;
import com.huawei.hms.scankit.aiscan.common.C0313e;
import com.huawei.hms.scankit.aiscan.common.EnumC0312d;
import java.util.Map;

/* compiled from: QRCodeReader.java */
/* loaded from: classes3.dex */
public class Xa implements com.huawei.hms.scankit.aiscan.common.t {
    private final Na a = new Na();

    public static void a(com.huawei.hms.scankit.aiscan.common.m mVar) {
        int iA = mVar.a();
        if (iA == mVar.c() && iA == 805) {
            _a.q[0] = true;
        }
    }

    public static void a(com.huawei.hms.scankit.aiscan.common.m mVar, com.huawei.hms.scankit.aiscan.common.x xVar) {
        boolean z;
        int iA = mVar.a();
        int iC = mVar.c();
        while (true) {
            if (_a.r.size() == 0) {
                z = false;
                break;
            }
            int iIntValue = _a.r.pop().intValue();
            if (iIntValue != 0 && iA % iIntValue == 0) {
                z = true;
                break;
            }
        }
        if (!(iA == iC && z) || xVar == null || xVar.h() == null) {
            return;
        }
        if ((Math.max(Math.max(xVar.h()[0].b(), xVar.h()[1].b()), xVar.h()[2].b()) - Math.min(Math.min(xVar.h()[0].b(), xVar.h()[1].b()), xVar.h()[2].b())) * (Math.max(Math.max(xVar.h()[0].c(), xVar.h()[1].c()), xVar.h()[2].c()) - Math.min(Math.min(xVar.h()[0].c(), xVar.h()[1].c()), xVar.h()[2].c())) > iA * iC * 0.8d) {
            _a.q[1] = true;
        }
    }

    @Override // com.huawei.hms.scankit.aiscan.common.t
    public final com.huawei.hms.scankit.aiscan.common.x a(C0409w c0409w, Map<EnumC0312d, ?> map) throws C0309a {
        C0313e c0313eA;
        boolean z = true;
        _a.f++;
        try {
            com.huawei.hms.scankit.aiscan.common.g gVarA = new Oa(c0409w.b()).a(map);
            int iA = a(gVarA);
            boolean z2 = iA > 0;
            try {
                c0313eA = this.a.a(gVarA.a(), map);
                z = false;
            } catch (Exception unused) {
                c0313eA = null;
            }
            if (_a.c) {
                if (z && iA >= 2) {
                    return new com.huawei.hms.scankit.aiscan.common.x(null, null, gVarA.b(), BarcodeFormat.QR_CODE);
                }
            } else if (z && z2) {
                return new com.huawei.hms.scankit.aiscan.common.x(null, null, gVarA.b(), BarcodeFormat.QR_CODE);
            }
            if (z) {
                throw C0309a.a();
            }
            if (c0313eA == null) {
                return null;
            }
            com.huawei.hms.scankit.aiscan.common.z[] zVarArrD = gVarA.d();
            if (c0313eA.b() instanceof Wa) {
                ((Wa) c0313eA.b()).a(zVarArrD);
            }
            com.huawei.hms.scankit.aiscan.common.x xVar = new com.huawei.hms.scankit.aiscan.common.x(c0313eA.d(), c0313eA.c(), zVarArrD, BarcodeFormat.QR_CODE);
            xVar.b(gVarA.b());
            return xVar;
        } catch (C0309a unused2) {
            throw C0309a.a();
        }
    }

    private int a(com.huawei.hms.scankit.aiscan.common.g gVar) {
        _a.e = gVar.c();
        C0417y c0417yA = gVar.a();
        int[] iArr = {3, c0417yA.d() - 4, 3};
        int[] iArr2 = {3, 3, c0417yA.b() - 4};
        int i = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            if (a(c0417yA, iArr[i2], iArr2[i2])) {
                i++;
            }
        }
        return i;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [boolean, int] */
    private boolean a(C0417y c0417y, int i, int i2) {
        if (c0417y == null || c0417y.b() < 21 || c0417y.d() < 21) {
            return false;
        }
        ?? B = c0417y.b(i, i2);
        int i3 = B;
        if (c0417y.b(i + 1, i2)) {
            i3 = B + 1;
        }
        int i4 = i3;
        if (!c0417y.b(i + 2, i2)) {
            i4 = i3 + 1;
        }
        int i5 = i4;
        if (c0417y.b(i + 3, i2)) {
            i5 = i4 + 1;
        }
        int i6 = i5;
        if (c0417y.b(i - 1, i2)) {
            i6 = i5 + 1;
        }
        int i7 = i6;
        if (!c0417y.b(i - 2, i2)) {
            i7 = i6 + 1;
        }
        int i8 = i7;
        if (c0417y.b(i - 3, i2)) {
            i8 = i7 + 1;
        }
        int i9 = i8;
        if (c0417y.b(i, i2 + 1)) {
            i9 = i8 + 1;
        }
        int i10 = i9;
        if (!c0417y.b(i, i2 + 2)) {
            i10 = i9 + 1;
        }
        int i11 = i10;
        if (c0417y.b(i, i2 + 3)) {
            i11 = i10 + 1;
        }
        int i12 = i11;
        if (c0417y.b(i, i2 - 1)) {
            i12 = i11 + 1;
        }
        int i13 = i12;
        if (!c0417y.b(i, i2 - 2)) {
            i13 = i12 + 1;
        }
        int i14 = i13;
        if (c0417y.b(i, i2 - 3)) {
            i14 = i13 + 1;
        }
        return i14 > 10;
    }
}
