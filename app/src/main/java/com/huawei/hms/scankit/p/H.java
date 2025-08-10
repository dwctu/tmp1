package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0309a;
import com.huawei.hms.scankit.aiscan.common.C0313e;
import com.huawei.hms.scankit.aiscan.common.EnumC0312d;
import java.util.Map;

/* compiled from: Decoder.java */
/* loaded from: classes3.dex */
public final class H {
    private K b = null;
    private final com.huawei.hms.scankit.aiscan.common.u a = new com.huawei.hms.scankit.aiscan.common.u(com.huawei.hms.scankit.aiscan.common.h.f);

    public C0313e a(C0417y c0417y, Map<EnumC0312d, ?> map) throws Exception {
        C c = new C(c0417y);
        K kA = c.a();
        this.b = kA;
        D[] dArrA = D.a(c.b(), kA);
        int iB = 0;
        for (D d : dArrA) {
            iB += d.b();
        }
        byte[] bArr = new byte[iB];
        int length = dArrA.length;
        for (int i = 0; i < length; i++) {
            D d2 = dArrA[i];
            byte[] bArrA = d2.a();
            int iB2 = d2.b();
            a(bArrA, iB2);
            for (int i2 = 0; i2 < iB2; i2++) {
                bArr[(i2 * length) + i] = bArrA[i2];
            }
        }
        return G.a(bArr, map);
    }

    private void a(byte[] bArr, int i) throws Exception {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        try {
            this.a.a(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (C0309a unused) {
            throw C0309a.a();
        }
    }

    public K a() {
        return this.b;
    }
}
