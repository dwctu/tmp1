package com.huawei.hms.scankit.p;

/* compiled from: AlignmentPattern.java */
/* renamed from: com.huawei.hms.scankit.p.ya, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0418ya extends com.huawei.hms.scankit.aiscan.common.z {
    private final float e;

    public C0418ya(float f, float f2, float f3) {
        super(f, f2);
        this.e = f3;
    }

    public boolean a(float f, float f2, float f3) {
        if (Math.abs(f2 - c()) > f || Math.abs(f3 - b()) > f) {
            return false;
        }
        float fAbs = Math.abs(f - this.e);
        return fAbs <= 1.0f || fAbs <= this.e;
    }

    public C0418ya b(float f, float f2, float f3) {
        return new C0418ya((b() + f2) / 2.0f, (c() + f) / 2.0f, (this.e + f3) / 2.0f);
    }
}
