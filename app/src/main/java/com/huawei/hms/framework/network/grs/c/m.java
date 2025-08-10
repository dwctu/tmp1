package com.huawei.hms.framework.network.grs.c;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.network.grs.d.d;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public class m {
    private ExecutorService a = ExecutorsUtils.newCachedThreadPool("GRS_RequestController-Task");
    private Map<String, com.huawei.hms.framework.network.grs.c.b.b> b = new ConcurrentHashMap(16);
    private final Object c = new Object();
    private com.huawei.hms.framework.network.grs.a.a d;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar, com.huawei.hms.framework.network.grs.b bVar) {
        if (bVar != null) {
            if (fVar == null) {
                Logger.v("RequestController", "GrsResponse is null");
                bVar.a();
            } else {
                Logger.v("RequestController", "GrsResponse is not null");
                bVar.a(fVar);
            }
        }
    }

    public f a(com.huawei.hms.framework.network.grs.c.b.c cVar, String str, com.huawei.hms.framework.network.grs.a.c cVar2) {
        Future<f> futureSubmit;
        String str2;
        String str3;
        Logger.d("RequestController", "request to server with service name is: " + str);
        String grsParasTag = cVar.b().getGrsParasTag(false, true, cVar.a());
        Logger.v("RequestController", "request spUrlKey: " + grsParasTag);
        synchronized (this.c) {
            if (!NetworkUtil.isNetworkAvailable(cVar.a())) {
                return null;
            }
            d.a aVarA = com.huawei.hms.framework.network.grs.d.d.a(grsParasTag);
            com.huawei.hms.framework.network.grs.c.b.b bVar = this.b.get(grsParasTag);
            if (bVar == null || !bVar.b()) {
                if (aVarA != null && aVarA.a()) {
                    return null;
                }
                Logger.d("RequestController", "hitGrsRequestBean == null or request block is released.");
                futureSubmit = this.a.submit(new k(this, cVar, str, cVar2));
                this.b.put(grsParasTag, new com.huawei.hms.framework.network.grs.c.b.b(futureSubmit));
            } else {
                futureSubmit = bVar.a();
            }
            try {
                return futureSubmit.get();
            } catch (InterruptedException e) {
                e = e;
                str2 = "RequestController";
                str3 = "when check result, find InterruptedException, check others";
                Logger.w(str2, str3, e);
                return null;
            } catch (CancellationException e2) {
                e = e2;
                str2 = "RequestController";
                str3 = "when check result, find CancellationException, check others";
                Logger.w(str2, str3, e);
                return null;
            } catch (ExecutionException e3) {
                e = e3;
                str2 = "RequestController";
                str3 = "when check result, find ExecutionException, check others";
                Logger.w(str2, str3, e);
                return null;
            }
        }
    }

    public void a(com.huawei.hms.framework.network.grs.a.a aVar) {
        this.d = aVar;
    }

    public void a(com.huawei.hms.framework.network.grs.c.b.c cVar, com.huawei.hms.framework.network.grs.b bVar, String str, com.huawei.hms.framework.network.grs.a.c cVar2) {
        this.a.execute(new l(this, cVar, str, cVar2, bVar));
    }

    public void a(String str) {
        synchronized (this.c) {
            this.b.remove(str);
        }
    }
}
