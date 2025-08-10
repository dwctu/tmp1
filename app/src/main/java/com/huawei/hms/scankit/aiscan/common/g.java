package com.huawei.hms.scankit.aiscan.common;

import com.huawei.hms.scankit.p.C0417y;

/* compiled from: DetectorResult.java */
/* loaded from: classes3.dex */
public class g {
    private final C0417y a;
    private final z[] b;
    private z[] c;
    private float d;

    public g(C0417y c0417y, z[] zVarArr) {
        this.c = null;
        this.a = c0417y;
        this.b = zVarArr;
    }

    public final C0417y a() {
        return this.a;
    }

    public z[] b() {
        return this.c;
    }

    public float c() {
        return this.d;
    }

    public final z[] d() {
        return this.b;
    }

    public g(C0417y c0417y, z[] zVarArr, z[] zVarArr2, float f) {
        this.c = null;
        this.a = c0417y;
        this.b = zVarArr;
        this.c = zVarArr2;
        this.d = f;
    }
}
