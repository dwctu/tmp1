package com.huawei.hms.scankit.p;

import android.view.animation.Interpolator;

/* compiled from: OpacityAnimator.java */
/* loaded from: classes3.dex */
public class Tc implements Sc {
    private final int a;
    private final int b;
    private final long c;
    private final long d;
    private final float e;
    private final Interpolator f;

    public Tc(int i, int i2, long j, long j2, Interpolator interpolator) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = j2;
        this.e = j2 - j;
        this.f = interpolator;
    }

    private int a(Pc pc) {
        int i = this.b;
        return i == -1 ? pc.e() : i;
    }

    private int b(Pc pc) {
        int i = this.a;
        return i == -1 ? pc.a() : i;
    }

    private int c(Pc pc) {
        return a(pc) - b(pc);
    }

    @Override // com.huawei.hms.scankit.p.Sc
    public void a(Pc pc, long j) {
        if (j < this.c || j > this.d || Float.compare(this.e, 0.0f) == 0) {
            return;
        }
        pc.a((int) (b(pc) + (c(pc) * this.f.getInterpolation((j - this.c) / this.e))));
    }
}
