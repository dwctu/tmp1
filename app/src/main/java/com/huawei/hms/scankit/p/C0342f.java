package com.huawei.hms.scankit.p;

import android.graphics.Rect;

/* compiled from: CameraMeteringData.java */
/* renamed from: com.huawei.hms.scankit.p.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0342f {
    private int a;
    private Rect b;

    /* compiled from: CameraMeteringData.java */
    /* renamed from: com.huawei.hms.scankit.p.f$a */
    public static class a {
        public Rect a;
        public int b;

        public a(Rect rect, int i) {
            this.a = rect;
            this.b = i;
        }
    }

    public C0342f(int i, Rect rect) {
        this.a = i;
        this.b = new Rect(rect);
    }

    public int a() {
        return this.a;
    }

    public Rect b() {
        return this.b;
    }
}
