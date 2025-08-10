package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0309a;

/* compiled from: Binarizer.java */
/* renamed from: com.huawei.hms.scankit.p.v, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0405v {
    private final com.huawei.hms.scankit.aiscan.common.m a;

    public AbstractC0405v(com.huawei.hms.scankit.aiscan.common.m mVar) {
        this.a = mVar;
    }

    public abstract AbstractC0405v a(com.huawei.hms.scankit.aiscan.common.m mVar);

    public abstract C0413x a(int i, C0413x c0413x) throws C0309a;

    public abstract C0417y a() throws C0309a;

    public final int b() {
        return this.a.a();
    }

    public final com.huawei.hms.scankit.aiscan.common.m c() {
        return this.a;
    }

    public final int d() {
        return this.a.c();
    }
}
