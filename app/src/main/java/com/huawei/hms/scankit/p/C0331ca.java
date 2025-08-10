package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0309a;

/* compiled from: UPCEANExtensionSupport.java */
/* renamed from: com.huawei.hms.scankit.p.ca, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0331ca {
    private static final int[] a = {1, 1, 2};
    private final C0323aa b = new C0323aa();
    private final C0327ba c = new C0327ba();

    public com.huawei.hms.scankit.aiscan.common.x a(int i, C0413x c0413x, int i2) throws C0309a {
        int[] iArrA = AbstractC0335da.a(c0413x, i2, false, a);
        try {
            return this.c.a(i, c0413x, iArrA);
        } catch (C0309a unused) {
            return this.b.a(i, c0413x, iArrA);
        }
    }
}
