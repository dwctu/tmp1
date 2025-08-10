package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0309a;
import com.huawei.hms.scankit.aiscan.common.EnumC0312d;
import java.util.Map;

/* compiled from: UPCAReader.java */
/* loaded from: classes3.dex */
public final class Z extends AbstractC0335da {
    private final AbstractC0335da h = new T();

    @Override // com.huawei.hms.scankit.p.AbstractC0335da
    public boolean a(int i, int i2, C0413x c0413x) {
        return c0413x.a(i2, (i2 - i) + i2, false, false);
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0335da
    public com.huawei.hms.scankit.aiscan.common.x a(int i, C0413x c0413x, int[] iArr, Map<EnumC0312d, ?> map) throws C0309a {
        return a(this.h.a(i, c0413x, iArr, map));
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0335da, com.huawei.hms.scankit.p.Y
    public com.huawei.hms.scankit.aiscan.common.x a(int i, C0413x c0413x, Map<EnumC0312d, ?> map) throws C0309a {
        return a(this.h.a(i, c0413x, map));
    }

    @Override // com.huawei.hms.scankit.p.Y, com.huawei.hms.scankit.aiscan.common.t
    public com.huawei.hms.scankit.aiscan.common.x a(C0409w c0409w, Map<EnumC0312d, ?> map) throws C0309a {
        return a(this.h.a(c0409w, map));
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0335da
    public BarcodeFormat a() {
        return BarcodeFormat.UPC_A;
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0335da
    public int a(C0413x c0413x, int[] iArr, StringBuilder sb) throws C0309a {
        return this.h.a(c0413x, iArr, sb);
    }

    private static com.huawei.hms.scankit.aiscan.common.x a(com.huawei.hms.scankit.aiscan.common.x xVar) throws C0309a {
        String strI = xVar.i();
        if (strI.charAt(0) == '0') {
            return new com.huawei.hms.scankit.aiscan.common.x(strI.substring(1), null, xVar.h(), BarcodeFormat.UPC_A);
        }
        throw C0309a.a();
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0335da
    public boolean a(int[] iArr, int[] iArr2) throws C0309a {
        return Math.abs(((int) Math.round(((double) (iArr2[1] - iArr[0])) / (((double) ((iArr2[1] - iArr2[0]) + (iArr[1] - iArr[0]))) / 6.0d))) + (-113)) <= 5;
    }
}
