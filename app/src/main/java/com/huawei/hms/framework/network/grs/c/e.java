package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.d.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;

/* loaded from: classes2.dex */
public class e implements a {
    private static final String a = "e";
    private GrsBaseInfo b;
    private Context c;
    private com.huawei.hms.framework.network.grs.a.a d;
    private f e;
    private com.huawei.hms.framework.network.grs.c.b.d k;
    private com.huawei.hms.framework.network.grs.c.b.c l;
    private ArrayList<Future<f>> f = new ArrayList<>();
    private ArrayList<f> g = new ArrayList<>();
    private JSONArray h = new JSONArray();
    private ArrayList<String> i = new ArrayList<>();
    private ArrayList<String> j = new ArrayList<>();
    private long m = 1;

    public e(com.huawei.hms.framework.network.grs.c.b.c cVar, com.huawei.hms.framework.network.grs.a.a aVar) {
        this.l = cVar;
        this.b = cVar.b();
        this.c = cVar.a();
        this.d = aVar;
        b();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0091 A[LOOP:0: B:3:0x0005->B:34:0x0091, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0089 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.framework.network.grs.c.f a(java.util.concurrent.ExecutorService r16, java.util.ArrayList<java.lang.String> r17, java.lang.String r18, com.huawei.hms.framework.network.grs.a.c r19) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        /*
            r15 = this;
            r9 = r15
            r10 = 0
            r0 = 0
            r11 = r0
            r12 = 0
        L5:
            int r0 = r17.size()
            if (r12 >= r0) goto L95
            r13 = r17
            java.lang.Object r0 = r13.get(r12)
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            r14 = 1
            if (r0 != 0) goto L84
            com.huawei.hms.framework.network.grs.c.b r0 = new com.huawei.hms.framework.network.grs.c.b
            android.content.Context r5 = r9.c
            com.huawei.hms.framework.network.grs.GrsBaseInfo r7 = r9.b
            r1 = r0
            r3 = r12
            r4 = r15
            r6 = r18
            r8 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            java.util.concurrent.Callable r0 = r0.g()
            r1 = r16
            java.util.concurrent.Future r0 = r1.submit(r0)
            java.util.ArrayList<java.util.concurrent.Future<com.huawei.hms.framework.network.grs.c.f>> r2 = r9.f
            r2.add(r0)
            long r2 = r9.m     // Catch: java.util.concurrent.TimeoutException -> L62 java.lang.InterruptedException -> L6a java.util.concurrent.ExecutionException -> L73 java.util.concurrent.CancellationException -> L7c
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.util.concurrent.TimeoutException -> L62 java.lang.InterruptedException -> L6a java.util.concurrent.ExecutionException -> L73 java.util.concurrent.CancellationException -> L7c
            java.lang.Object r0 = r0.get(r2, r4)     // Catch: java.util.concurrent.TimeoutException -> L62 java.lang.InterruptedException -> L6a java.util.concurrent.ExecutionException -> L73 java.util.concurrent.CancellationException -> L7c
            r2 = r0
            com.huawei.hms.framework.network.grs.c.f r2 = (com.huawei.hms.framework.network.grs.c.f) r2     // Catch: java.util.concurrent.TimeoutException -> L62 java.lang.InterruptedException -> L6a java.util.concurrent.ExecutionException -> L73 java.util.concurrent.CancellationException -> L7c
            if (r2 == 0) goto L5f
            boolean r0 = r2.m()     // Catch: java.util.concurrent.TimeoutException -> L55 java.lang.InterruptedException -> L57 java.util.concurrent.ExecutionException -> L5a java.util.concurrent.CancellationException -> L5d
            if (r0 == 0) goto L5f
            java.lang.String r0 = com.huawei.hms.framework.network.grs.c.e.a     // Catch: java.util.concurrent.TimeoutException -> L55 java.lang.InterruptedException -> L57 java.util.concurrent.ExecutionException -> L5a java.util.concurrent.CancellationException -> L5d
            java.lang.String r3 = "grs request return body is not null and is OK."
            com.huawei.hms.framework.common.Logger.i(r0, r3)     // Catch: java.util.concurrent.TimeoutException -> L55 java.lang.InterruptedException -> L57 java.util.concurrent.ExecutionException -> L5a java.util.concurrent.CancellationException -> L5d
            goto L60
        L55:
            r11 = r2
            goto L62
        L57:
            r0 = move-exception
            r11 = r2
            goto L6b
        L5a:
            r0 = move-exception
            r11 = r2
            goto L74
        L5d:
            r11 = r2
            goto L7c
        L5f:
            r14 = 0
        L60:
            r11 = r2
            goto L87
        L62:
            java.lang.String r0 = com.huawei.hms.framework.network.grs.c.e.a
            java.lang.String r2 = "the wait timed out"
            com.huawei.hms.framework.common.Logger.w(r0, r2)
            goto L86
        L6a:
            r0 = move-exception
        L6b:
            java.lang.String r2 = com.huawei.hms.framework.network.grs.c.e.a
            java.lang.String r3 = "the current thread was interrupted while waiting"
            com.huawei.hms.framework.common.Logger.w(r2, r3, r0)
            goto L87
        L73:
            r0 = move-exception
        L74:
            java.lang.String r2 = com.huawei.hms.framework.network.grs.c.e.a
            java.lang.String r3 = "the computation threw an ExecutionException"
            com.huawei.hms.framework.common.Logger.w(r2, r3, r0)
            goto L86
        L7c:
            java.lang.String r0 = com.huawei.hms.framework.network.grs.c.e.a
            java.lang.String r2 = "{requestServer} the computation was cancelled"
            com.huawei.hms.framework.common.Logger.i(r0, r2)
            goto L87
        L84:
            r1 = r16
        L86:
            r14 = 0
        L87:
            if (r14 == 0) goto L91
            java.lang.String r0 = com.huawei.hms.framework.network.grs.c.e.a
            java.lang.String r1 = "needBreak is true so need break current circulation"
            com.huawei.hms.framework.common.Logger.v(r0, r1)
            goto L95
        L91:
            int r12 = r12 + 1
            goto L5
        L95:
            com.huawei.hms.framework.network.grs.c.f r0 = r15.b(r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.c.e.a(java.util.concurrent.ExecutorService, java.util.ArrayList, java.lang.String, com.huawei.hms.framework.network.grs.a.c):com.huawei.hms.framework.network.grs.c.f");
    }

    private f b(f fVar) throws ExecutionException, InterruptedException, TimeoutException {
        String str;
        String str2;
        int size = this.f.size();
        for (int i = 0; i < size && (fVar == null || !fVar.m()); i++) {
            try {
                fVar = this.f.get(i).get(40000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e = e;
                str = a;
                str2 = "{checkResponse} when check result, find InterruptedException, check others";
                Logger.w(str, str2, e);
            } catch (CancellationException unused) {
                Logger.i(a, "{checkResponse} when check result, find CancellationException, check others");
            } catch (ExecutionException e2) {
                e = e2;
                str = a;
                str2 = "{checkResponse} when check result, find ExecutionException, check others";
                Logger.w(str, str2, e);
            } catch (TimeoutException unused2) {
                Logger.w(a, "{checkResponse} when check result, find TimeoutException, cancel current request task");
                if (!this.f.get(i).isCancelled()) {
                    this.f.get(i).cancel(true);
                }
            }
        }
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f b(ExecutorService executorService, String str, com.huawei.hms.framework.network.grs.a.c cVar) throws ExecutionException, InterruptedException, TimeoutException {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        f fVarA = a(executorService, this.j, str, cVar);
        int iB = fVarA == null ? 0 : fVarA.b();
        String str2 = a;
        Logger.v(str2, "use 2.0 interface return http's code is：{%s}", Integer.valueOf(iB));
        if (iB == 404 || iB == 401) {
            if (TextUtils.isEmpty(c()) && TextUtils.isEmpty(this.b.getAppName())) {
                Logger.i(str2, "request grs server use 1.0 API must set appName,please check.");
                return null;
            }
            this.f.clear();
            Logger.i(str2, "this env has not deploy new interface,so use old interface.");
            fVarA = a(executorService, this.i, str, cVar);
        }
        h.a(new ArrayList(this.g), SystemClock.elapsedRealtime() - jElapsedRealtime, this.h, this.c);
        return fVarA;
    }

    private void b() {
        com.huawei.hms.framework.network.grs.c.b.d dVarA = com.huawei.hms.framework.network.grs.c.a.a.a(this.c);
        if (dVarA == null) {
            Logger.w(a, "g*s***_se****er_conf*** maybe has a big error");
            return;
        }
        a(dVarA);
        List<String> listA = dVarA.a();
        if (listA == null || listA.size() <= 0) {
            Logger.v(a, "maybe grs_base_url config with [],please check.");
            return;
        }
        if (listA.size() > 10) {
            throw new IllegalArgumentException("grs_base_url's count is larger than MAX value 10");
        }
        String strC = dVarA.c();
        String strB = dVarA.b();
        if (listA.size() > 0) {
            for (String str : listA) {
                if (str.startsWith("https://")) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    Locale locale = Locale.ROOT;
                    Object[] objArr = new Object[1];
                    objArr[0] = TextUtils.isEmpty(c()) ? this.b.getAppName() : c();
                    sb.append(String.format(locale, strC, objArr));
                    String grsReqParamJoint = this.b.getGrsReqParamJoint(false, false, "1.0", this.c);
                    if (!TextUtils.isEmpty(grsReqParamJoint)) {
                        sb.append("?");
                        sb.append(grsReqParamJoint);
                    }
                    this.i.add(sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(strB);
                    String grsReqParamJoint2 = this.b.getGrsReqParamJoint(false, false, c(), this.c);
                    if (!TextUtils.isEmpty(grsReqParamJoint2)) {
                        sb2.append("?");
                        sb2.append(grsReqParamJoint2);
                    }
                    this.j.add(sb2.toString());
                } else {
                    Logger.w(a, "grs server just support https scheme url,please check.");
                }
            }
        }
        Logger.v(a, "request to GRS server url is{%s} and {%s}", this.i, this.j);
    }

    private String c() {
        com.huawei.hms.framework.network.grs.b.b bVarA = com.huawei.hms.framework.network.grs.b.b.a(this.c.getPackageName(), this.b);
        com.huawei.hms.framework.network.grs.local.model.a aVarA = bVarA != null ? bVarA.a() : null;
        if (aVarA == null) {
            return "";
        }
        String strB = aVarA.b();
        Logger.v(a, "get appName from local assets is{%s}", strB);
        return strB;
    }

    public com.huawei.hms.framework.network.grs.c.b.d a() {
        return this.k;
    }

    public f a(ExecutorService executorService, String str, com.huawei.hms.framework.network.grs.a.c cVar) {
        String str2;
        String str3;
        if (this.i == null || this.j == null) {
            return null;
        }
        try {
            return (f) executorService.submit(new d(this, executorService, str, cVar)).get(a() != null ? r0.d() : 10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e = e;
            str2 = a;
            str3 = "{submitExcutorTaskWithTimeout} the current thread was interrupted while waiting";
            Logger.w(str2, str3, e);
            return null;
        } catch (CancellationException unused) {
            Logger.i(a, "{submitExcutorTaskWithTimeout} the computation was cancelled");
            return null;
        } catch (ExecutionException e2) {
            e = e2;
            str2 = a;
            str3 = "{submitExcutorTaskWithTimeout} the computation threw an ExecutionException";
            Logger.w(str2, str3, e);
            return null;
        } catch (TimeoutException unused2) {
            Logger.w(a, "{submitExcutorTaskWithTimeout} the wait timed out");
            return null;
        } catch (Exception e3) {
            e = e3;
            str2 = a;
            str3 = "{submitExcutorTaskWithTimeout} catch Exception";
            Logger.w(str2, str3, e);
            return null;
        }
    }

    public void a(com.huawei.hms.framework.network.grs.c.b.d dVar) {
        this.k = dVar;
    }

    @Override // com.huawei.hms.framework.network.grs.c.a
    public synchronized void a(f fVar) {
        this.g.add(fVar);
        f fVar2 = this.e;
        if (fVar2 != null && fVar2.m()) {
            Logger.v(a, "grsResponseResult is ok");
            return;
        }
        if (fVar.l()) {
            Logger.i(a, "GRS server open 503 limiting strategy.");
            com.huawei.hms.framework.network.grs.d.d.a(this.b.getGrsParasKey(false, true, this.c), new d.a(fVar.j(), SystemClock.elapsedRealtime()));
            return;
        }
        if (!fVar.m()) {
            Logger.v(a, "grsResponseResult has exception so need return");
            return;
        }
        this.e = fVar;
        this.d.a(this.b, fVar, this.c, this.l);
        for (int i = 0; i < this.f.size(); i++) {
            if (!this.i.get(i).equals(fVar.k()) && !this.j.get(i).equals(fVar.k()) && !this.f.get(i).isCancelled()) {
                Logger.i(a, "future cancel");
                this.f.get(i).cancel(true);
            }
        }
    }
}
