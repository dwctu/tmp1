package com.huawei.hms.framework.network.grs.c;

/* loaded from: classes2.dex */
public class l implements Runnable {
    public final /* synthetic */ com.huawei.hms.framework.network.grs.c.b.c a;
    public final /* synthetic */ String b;
    public final /* synthetic */ com.huawei.hms.framework.network.grs.a.c c;
    public final /* synthetic */ com.huawei.hms.framework.network.grs.b d;
    public final /* synthetic */ m e;

    public l(m mVar, com.huawei.hms.framework.network.grs.c.b.c cVar, String str, com.huawei.hms.framework.network.grs.a.c cVar2, com.huawei.hms.framework.network.grs.b bVar) {
        this.e = mVar;
        this.a = cVar;
        this.b = str;
        this.c = cVar2;
        this.d = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        m mVar = this.e;
        mVar.a(mVar.a(this.a, this.b, this.c), this.d);
    }
}
