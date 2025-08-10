package com.huawei.hms.scankit.p;

/* compiled from: HiAnalyticsLogExecutor.java */
/* renamed from: com.huawei.hms.scankit.p.qb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0388qb extends Thread {
    public final /* synthetic */ C0391rb a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0388qb(C0391rb c0391rb, String str) {
        super(str);
        this.a = c0391rb;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.a.d();
    }
}
