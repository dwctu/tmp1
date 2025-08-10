package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0309a;
import com.huawei.hms.scankit.aiscan.common.C0313e;
import com.huawei.hms.scankit.aiscan.common.EnumC0312d;
import java.util.Map;

/* compiled from: Decoder.java */
/* loaded from: classes3.dex */
public final class Na {
    private final com.huawei.hms.scankit.aiscan.common.u a = new com.huawei.hms.scankit.aiscan.common.u(com.huawei.hms.scankit.aiscan.common.h.e);

    public C0313e a(C0417y c0417y, Map<EnumC0312d, ?> map) throws Exception {
        Aa aa = new Aa(c0417y);
        try {
            return a(aa, map);
        } catch (C0309a e) {
            try {
                aa.e();
                aa.a(true);
                aa.d();
                aa.c();
                aa.a();
                C0313e c0313eA = a(aa, map);
                c0313eA.a(new Wa(true));
                return c0313eA;
            } catch (C0309a unused) {
                throw e;
            }
        }
    }

    private C0313e a(Aa aa, Map<EnumC0312d, ?> map) throws Exception {
        Ya yaD = aa.d();
        Pa paB = aa.c().b();
        Ba[] baArrA = Ba.a(aa.b(), yaD, paB);
        int iB = 0;
        for (Ba ba : baArrA) {
            iB += ba.b();
        }
        byte[] bArr = new byte[iB];
        int i = 0;
        for (Ba ba2 : baArrA) {
            byte[] bArrA = ba2.a();
            int iB2 = ba2.b();
            a(bArrA, iB2);
            int i2 = 0;
            while (i2 < iB2) {
                bArr[i] = bArrA[i2];
                i2++;
                i++;
            }
        }
        return Ma.a(bArr, yaD, paB, map);
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
}
