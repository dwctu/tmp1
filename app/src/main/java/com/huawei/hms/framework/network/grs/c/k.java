package com.huawei.hms.framework.network.grs.c;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class k implements Callable<f> {
    public final /* synthetic */ com.huawei.hms.framework.network.grs.c.b.c a;
    public final /* synthetic */ String b;
    public final /* synthetic */ com.huawei.hms.framework.network.grs.a.c c;
    public final /* synthetic */ m d;

    public k(m mVar, com.huawei.hms.framework.network.grs.c.b.c cVar, String str, com.huawei.hms.framework.network.grs.a.c cVar2) {
        this.d = mVar;
        this.a = cVar;
        this.b = str;
        this.c = cVar2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public f call() {
        return new e(this.a, this.d.d).a(this.d.a, this.b, this.c);
    }
}
