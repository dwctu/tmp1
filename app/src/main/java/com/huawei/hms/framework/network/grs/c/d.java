package com.huawei.hms.framework.network.grs.c;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class d implements Callable<f> {
    public final /* synthetic */ ExecutorService a;
    public final /* synthetic */ String b;
    public final /* synthetic */ com.huawei.hms.framework.network.grs.a.c c;
    public final /* synthetic */ e d;

    public d(e eVar, ExecutorService executorService, String str, com.huawei.hms.framework.network.grs.a.c cVar) {
        this.d = eVar;
        this.a = executorService;
        this.b = str;
        this.c = cVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public f call() {
        return this.d.b(this.a, this.b, this.c);
    }
}
