package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class i extends b implements Callable<f> {
    private static final String i = "i";

    public i(String str, int i2, a aVar, Context context, String str2, GrsBaseInfo grsBaseInfo) {
        super(str, i2, aVar, context, str2, grsBaseInfo, null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b3  */
    /* JADX WARN: Type inference failed for: r0v14, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v18, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r11v1, types: [byte[]] */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.framework.network.grs.c.f call() {
        /*
            r18 = this;
            r1 = r18
            java.lang.String r0 = com.huawei.hms.framework.network.grs.c.i.i
            java.lang.String r2 = "Get call execute"
            com.huawei.hms.framework.common.Logger.i(r0, r2)
            r2 = 0
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch: java.io.IOException -> L77
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.io.IOException -> L70
            java.lang.String r6 = r18.c()     // Catch: java.io.IOException -> L70
            android.content.Context r7 = r18.b()     // Catch: java.io.IOException -> L70
            java.lang.String r8 = r18.e()     // Catch: java.io.IOException -> L70
            javax.net.ssl.HttpsURLConnection r6 = com.huawei.hms.framework.network.grs.d.a.a.a(r6, r7, r8)     // Catch: java.io.IOException -> L70
            r7 = 0
            if (r6 != 0) goto L2c
            java.lang.String r6 = "create HttpsURLConnection instance by url return null."
            com.huawei.hms.framework.common.Logger.w(r0, r6)     // Catch: java.io.IOException -> L70
            return r7
        L2c:
            java.lang.String r0 = "GET"
            r6.setRequestMethod(r0)     // Catch: java.io.IOException -> L70
            r6.connect()     // Catch: java.io.IOException -> L70
            int r9 = r6.getResponseCode()     // Catch: java.io.IOException -> L70
            r0 = 200(0xc8, float:2.8E-43)
            if (r9 != r0) goto L4e
            java.io.InputStream r7 = r6.getInputStream()     // Catch: java.lang.Throwable -> L49
            byte[] r0 = com.huawei.hms.framework.common.IoUtils.toByteArray(r7)     // Catch: java.lang.Throwable -> L49
            com.huawei.hms.framework.common.IoUtils.closeSecure(r7)     // Catch: java.io.IOException -> L70
            r7 = r0
            goto L4e
        L49:
            r0 = move-exception
            com.huawei.hms.framework.common.IoUtils.closeSecure(r7)     // Catch: java.io.IOException -> L70
            throw r0     // Catch: java.io.IOException -> L70
        L4e:
            java.util.Map r10 = r6.getHeaderFields()     // Catch: java.io.IOException -> L70
            r6.disconnect()     // Catch: java.io.IOException -> L70
            long r11 = android.os.SystemClock.elapsedRealtime()     // Catch: java.io.IOException -> L70
            long r14 = java.lang.System.currentTimeMillis()     // Catch: java.io.IOException -> L70
            if (r7 != 0) goto L63
            r0 = 0
            byte[] r0 = new byte[r0]     // Catch: java.io.IOException -> L70
            goto L64
        L63:
            r0 = r7
        L64:
            com.huawei.hms.framework.network.grs.c.f r6 = new com.huawei.hms.framework.network.grs.c.f     // Catch: java.io.IOException -> L70
            long r12 = r11 - r4
            r8 = r6
            r11 = r0
            r8.<init>(r9, r10, r11, r12)     // Catch: java.io.IOException -> L70
            r1.a = r6     // Catch: java.io.IOException -> L70
            goto L91
        L70:
            r0 = move-exception
            r16 = r2
            r2 = r4
            r4 = r16
            goto L79
        L77:
            r0 = move-exception
            r4 = r2
        L79:
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r14 = java.lang.System.currentTimeMillis()
            java.lang.String r8 = com.huawei.hms.framework.network.grs.c.i.i
            java.lang.String r9 = "RequestCallable run task catch IOException"
            com.huawei.hms.framework.common.Logger.w(r8, r9, r0)
            com.huawei.hms.framework.network.grs.c.f r8 = new com.huawei.hms.framework.network.grs.c.f
            long r6 = r6 - r2
            r8.<init>(r0, r6)
            r1.a = r8
            r2 = r4
        L91:
            com.huawei.hms.framework.network.grs.c.f r0 = r1.a
            java.lang.String r4 = r18.c()
            r0.a(r4)
            com.huawei.hms.framework.network.grs.c.f r0 = r1.a
            int r4 = r18.d()
            r0.a(r4)
            com.huawei.hms.framework.network.grs.c.f r0 = r1.a
            r0.b(r2)
            com.huawei.hms.framework.network.grs.c.f r0 = r1.a
            r0.a(r14)
            com.huawei.hms.framework.network.grs.c.a r0 = r18.a()
            if (r0 == 0) goto Lbc
            com.huawei.hms.framework.network.grs.c.a r0 = r18.a()
            com.huawei.hms.framework.network.grs.c.f r2 = r1.a
            r0.a(r2)
        Lbc:
            com.huawei.hms.framework.network.grs.c.f r0 = r1.a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.c.i.call():com.huawei.hms.framework.network.grs.c.f");
    }
}
