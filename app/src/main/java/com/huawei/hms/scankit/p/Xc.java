package com.huawei.hms.scankit.p;

/* compiled from: ParticleScale.java */
/* loaded from: classes3.dex */
public class Xc implements Vc {
    private final float a;
    private final float b;

    public Xc(float f, float f2) {
        this.b = f;
        this.a = f2;
    }

    @Override // com.huawei.hms.scankit.p.Vc
    public void a(Pc pc) {
        float fA = this.a;
        float f = this.b;
        if (fA != f) {
            fA = Yc.a(fA - f) + this.b;
        }
        pc.b(fA);
        pc.a(fA);
    }
}
