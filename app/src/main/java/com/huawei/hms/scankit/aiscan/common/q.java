package com.huawei.hms.scankit.aiscan.common;

/* compiled from: PerspectiveTransform.java */
/* loaded from: classes3.dex */
public final class q {
    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    private final float f;
    private final float g;
    private final float h;
    private final float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s = 0.0f;
    private float t = 0.0f;
    private float u = 0.0f;
    private float v = 0.0f;
    private float w = 0.0f;

    public q(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.a = f;
        this.b = f4;
        this.c = f7;
        this.d = f2;
        this.e = f5;
        this.f = f8;
        this.g = f3;
        this.h = f6;
        this.i = f9;
        this.j = f;
        this.k = f2;
        this.l = f3;
        this.m = f4;
        this.n = f5;
        this.o = f6;
        this.p = f7;
        this.q = f8;
        this.r = f9;
    }

    public void a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14) {
        this.j = f;
        this.k = f2;
        this.l = f3;
        this.m = f4;
        this.n = f5;
        this.o = f6;
        this.p = f7;
        this.q = f8;
        this.r = f9;
        this.s = f10;
        this.t = f11;
        this.u = f12;
        this.v = f13;
        this.w = f14;
    }

    public void b(float[] fArr) {
        int length = fArr.length;
        for (int i = 0; i < length; i += 2) {
            float f = fArr[i];
            int i2 = i + 1;
            float f2 = fArr[i2];
            float f3 = (this.t * f) + (this.u * f2) + (this.v * f * f) + (this.w * f2 * f2) + 1.0f;
            fArr[i] = (((((this.j * f) + (this.k * f2)) + ((this.l * f) * f)) + ((this.m * f2) * f2)) + this.n) / f3;
            fArr[i2] = (((((this.o * f) + (this.p * f2)) + ((this.q * f) * f)) + ((this.r * f2) * f2)) + this.s) / f3;
        }
    }

    public static q b(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = ((f - f3) + f5) - f7;
        float f10 = ((f2 - f4) + f6) - f8;
        if (f9 == 0.0f && f10 == 0.0f) {
            return new q(f3 - f, f5 - f3, f, f4 - f2, f6 - f4, f2, 0.0f, 0.0f, 1.0f);
        }
        float f11 = f3 - f5;
        float f12 = f7 - f5;
        float f13 = f4 - f6;
        float f14 = f8 - f6;
        float f15 = (f11 * f14) - (f12 * f13);
        float f16 = ((f14 * f9) - (f12 * f10)) / f15;
        float f17 = ((f11 * f10) - (f9 * f13)) / f15;
        return new q((f16 * f3) + (f3 - f), (f17 * f7) + (f7 - f), f, (f4 - f2) + (f16 * f4), (f8 - f2) + (f17 * f8), f2, f16, f17, 1.0f);
    }

    public static q a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        return b(f9, f10, f11, f12, f13, f14, f15, f16).a(a(f, f2, f3, f4, f5, f6, f7, f8));
    }

    public void a(float[] fArr) {
        int length = fArr.length;
        float f = this.a;
        float f2 = this.b;
        float f3 = this.c;
        float f4 = this.d;
        float f5 = this.e;
        float f6 = this.f;
        float f7 = this.g;
        float f8 = this.h;
        float f9 = this.i;
        for (int i = 0; i < length; i += 2) {
            float f10 = fArr[i];
            int i2 = i + 1;
            float f11 = fArr[i2];
            float f12 = (f3 * f10) + (f6 * f11) + f9;
            fArr[i] = (((f * f10) + (f4 * f11)) + f7) / f12;
            fArr[i2] = (((f10 * f2) + (f11 * f5)) + f8) / f12;
        }
    }

    public static q a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        return b(f, f2, f3, f4, f5, f6, f7, f8).a();
    }

    public q a() {
        float f = this.e;
        float f2 = this.i;
        float f3 = this.f;
        float f4 = this.h;
        float f5 = (f * f2) - (f3 * f4);
        float f6 = this.g;
        float f7 = this.d;
        float f8 = (f3 * f6) - (f7 * f2);
        float f9 = (f7 * f4) - (f * f6);
        float f10 = this.c;
        float f11 = this.b;
        float f12 = (f10 * f4) - (f11 * f2);
        float f13 = this.a;
        return new q(f5, f8, f9, f12, (f2 * f13) - (f10 * f6), (f6 * f11) - (f4 * f13), (f11 * f3) - (f10 * f), (f10 * f7) - (f3 * f13), (f13 * f) - (f11 * f7));
    }

    public q a(q qVar) {
        float f = this.a;
        float f2 = qVar.a;
        float f3 = this.d;
        float f4 = qVar.b;
        float f5 = this.g;
        float f6 = qVar.c;
        float f7 = (f * f2) + (f3 * f4) + (f5 * f6);
        float f8 = qVar.d;
        float f9 = qVar.e;
        float f10 = qVar.f;
        float f11 = (f * f8) + (f3 * f9) + (f5 * f10);
        float f12 = qVar.g;
        float f13 = qVar.h;
        float f14 = qVar.i;
        float f15 = (f * f12) + (f3 * f13) + (f5 * f14);
        float f16 = this.b;
        float f17 = this.e;
        float f18 = this.h;
        float f19 = (f16 * f2) + (f17 * f4) + (f18 * f6);
        float f20 = (f16 * f8) + (f17 * f9) + (f18 * f10);
        float f21 = (f18 * f14) + (f16 * f12) + (f17 * f13);
        float f22 = this.c;
        float f23 = this.f;
        float f24 = (f2 * f22) + (f4 * f23);
        float f25 = this.i;
        return new q(f7, f11, f15, f19, f20, f21, (f6 * f25) + f24, (f8 * f22) + (f9 * f23) + (f10 * f25), (f22 * f12) + (f23 * f13) + (f25 * f14));
    }
}
