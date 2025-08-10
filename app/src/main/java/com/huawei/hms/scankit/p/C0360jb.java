package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.p.C0356ib;
import java.util.TimerTask;

/* compiled from: HaLog60001.java */
/* renamed from: com.huawei.hms.scankit.p.jb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0360jb extends TimerTask {
    public final /* synthetic */ C0356ib.b a;

    public C0360jb(C0356ib.b bVar) {
        this.a = bVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            this.a.c = true;
            this.a.a();
        } catch (Exception unused) {
            com.huawei.hms.scankit.util.a.b(this.a.a, "onLog Exception");
        }
    }
}
