package com.huawei.hms.framework.network.grs.c.b;

import android.os.SystemClock;
import com.huawei.hms.framework.network.grs.c.f;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public class b {
    private Future<f> a;
    private long b = SystemClock.elapsedRealtime();

    public b(Future<f> future) {
        this.a = future;
    }

    public Future<f> a() {
        return this.a;
    }

    public boolean b() {
        return SystemClock.elapsedRealtime() - this.b <= 300000;
    }
}
