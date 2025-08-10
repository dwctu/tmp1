package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class j extends b implements Callable<f> {
    private static final String i = "j";

    public j(String str, int i2, a aVar, Context context, String str2, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.a.c cVar) {
        super(str, i2, aVar, context, str2, grsBaseInfo, cVar);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
    /* JADX WARN: Type inference failed for: r0v17, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r12v2 */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.framework.network.grs.c.f call() throws java.io.IOException {
        /*
            r19 = this;
            r1 = r19
            java.lang.String r0 = com.huawei.hms.framework.network.grs.c.j.i
            java.lang.String r2 = "Post call execute"
            com.huawei.hms.framework.common.Logger.i(r0, r2)
            r2 = 0
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch: java.io.IOException -> La1
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.io.IOException -> L9a
            java.lang.String r6 = r19.c()     // Catch: java.io.IOException -> L9a
            android.content.Context r7 = r19.b()     // Catch: java.io.IOException -> L9a
            java.lang.String r8 = r19.e()     // Catch: java.io.IOException -> L9a
            javax.net.ssl.HttpsURLConnection r6 = com.huawei.hms.framework.network.grs.d.a.a.a(r6, r7, r8)     // Catch: java.io.IOException -> L9a
            r7 = 0
            if (r6 != 0) goto L2c
            java.lang.String r6 = "create HttpsURLConnection instance by url return null."
            com.huawei.hms.framework.common.Logger.w(r0, r6)     // Catch: java.io.IOException -> L9a
            return r7
        L2c:
            java.lang.String r0 = "Content-Type"
            java.lang.String r8 = "application/json; charset=UTF-8"
            r6.setRequestProperty(r0, r8)     // Catch: java.io.IOException -> L9a
            java.lang.String r0 = "POST"
            r6.setRequestMethod(r0)     // Catch: java.io.IOException -> L9a
            r0 = 1
            r6.setDoOutput(r0)     // Catch: java.io.IOException -> L9a
            r6.setDoInput(r0)     // Catch: java.io.IOException -> L9a
            r6.connect()     // Catch: java.io.IOException -> L9a
            java.io.OutputStream r0 = r6.getOutputStream()     // Catch: java.io.IOException -> L9a
            com.huawei.hms.framework.network.grs.a.c r8 = r19.f()     // Catch: java.io.IOException -> L9a
            java.lang.String r9 = "services"
            java.lang.String r10 = ""
            java.lang.String r8 = r8.a(r9, r10)     // Catch: java.io.IOException -> L9a
            java.lang.String r9 = "UTF-8"
            byte[] r8 = r8.getBytes(r9)     // Catch: java.io.IOException -> L9a
            r0.write(r8)     // Catch: java.io.IOException -> L9a
            r0.close()     // Catch: java.io.IOException -> L9a
            int r10 = r6.getResponseCode()     // Catch: java.io.IOException -> L9a
            r0 = 200(0xc8, float:2.8E-43)
            if (r10 != r0) goto L78
            java.io.InputStream r7 = r6.getInputStream()     // Catch: java.lang.Throwable -> L73
            byte[] r0 = com.huawei.hms.framework.common.IoUtils.toByteArray(r7)     // Catch: java.lang.Throwable -> L73
            com.huawei.hms.framework.common.IoUtils.closeSecure(r7)     // Catch: java.io.IOException -> L9a
            r7 = r0
            goto L78
        L73:
            r0 = move-exception
            com.huawei.hms.framework.common.IoUtils.closeSecure(r7)     // Catch: java.io.IOException -> L9a
            throw r0     // Catch: java.io.IOException -> L9a
        L78:
            java.util.Map r11 = r6.getHeaderFields()     // Catch: java.io.IOException -> L9a
            r6.disconnect()     // Catch: java.io.IOException -> L9a
            long r8 = android.os.SystemClock.elapsedRealtime()     // Catch: java.io.IOException -> L9a
            long r15 = java.lang.System.currentTimeMillis()     // Catch: java.io.IOException -> L9a
            if (r7 != 0) goto L8e
            r0 = 0
            byte[] r0 = new byte[r0]     // Catch: java.io.IOException -> L9a
            r12 = r0
            goto L8f
        L8e:
            r12 = r7
        L8f:
            com.huawei.hms.framework.network.grs.c.f r0 = new com.huawei.hms.framework.network.grs.c.f     // Catch: java.io.IOException -> L9a
            long r13 = r8 - r4
            r9 = r0
            r9.<init>(r10, r11, r12, r13)     // Catch: java.io.IOException -> L9a
            r1.a = r0     // Catch: java.io.IOException -> L9a
            goto Lbb
        L9a:
            r0 = move-exception
            r17 = r2
            r2 = r4
            r4 = r17
            goto La3
        La1:
            r0 = move-exception
            r4 = r2
        La3:
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r15 = java.lang.System.currentTimeMillis()
            java.lang.String r8 = com.huawei.hms.framework.network.grs.c.j.i
            java.lang.String r9 = "RequestCallableV2 run task catch IOException"
            com.huawei.hms.framework.common.Logger.w(r8, r9, r0)
            com.huawei.hms.framework.network.grs.c.f r8 = new com.huawei.hms.framework.network.grs.c.f
            long r6 = r6 - r2
            r8.<init>(r0, r6)
            r1.a = r8
            r2 = r4
        Lbb:
            r4 = r15
            com.huawei.hms.framework.network.grs.c.f r0 = r1.a
            java.lang.String r6 = r19.c()
            r0.a(r6)
            com.huawei.hms.framework.network.grs.c.f r0 = r1.a
            int r6 = r19.d()
            r0.a(r6)
            com.huawei.hms.framework.network.grs.c.f r0 = r1.a
            r0.b(r2)
            com.huawei.hms.framework.network.grs.c.f r0 = r1.a
            r0.a(r4)
            com.huawei.hms.framework.network.grs.c.a r0 = r19.a()
            if (r0 == 0) goto Le7
            com.huawei.hms.framework.network.grs.c.a r0 = r19.a()
            com.huawei.hms.framework.network.grs.c.f r2 = r1.a
            r0.a(r2)
        Le7:
            com.huawei.hms.framework.network.grs.c.f r0 = r1.a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.c.j.call():com.huawei.hms.framework.network.grs.c.f");
    }
}
