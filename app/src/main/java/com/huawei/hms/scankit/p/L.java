package com.huawei.hms.scankit.p;

/* compiled from: DetectorResult.java */
/* loaded from: classes3.dex */
public class L implements Comparable<L> {
    private float a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    public C0409w l;
    public float[] m = new float[5];
    public float n = 0.0f;
    public float o = 0.0f;
    public int p = 0;
    public int q = 0;
    public int r = 0;
    public int s = 0;
    public int t = 0;
    public int u = 0;
    public float v = 0.0f;

    public L(boolean z, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = f5;
        this.f = f6;
        this.k = f10;
        if (!z) {
            this.i = f9;
            this.j = f8;
        } else {
            this.g = f7;
            this.h = f8;
            this.j = f9;
        }
    }

    private float a(float f, int i, int i2) {
        float f2 = i;
        if (f <= f2) {
            f = f2;
        }
        float f3 = i2 - 1;
        return f < f3 ? f : f3;
    }

    public void a(int i, int i2, float f, float f2) {
        float f3 = this.a + f;
        this.a = f3;
        float f4 = this.b + f2;
        this.b = f4;
        if (f3 < 0.0f) {
            this.c += f3;
        }
        if (f4 < 0.0f) {
            this.d += f4;
        }
        this.e += f;
        this.f += f2;
        this.a = a(f3, 0, i);
        this.e = a(this.e, 0, i);
        this.b = a(this.b, 0, i2);
        this.f = a(this.f, 0, i2);
        float f5 = this.a;
        float f6 = i - f;
        if (this.c + f5 >= f6) {
            this.c = (f6 - 1.0f) - f5;
        }
        float f7 = this.b;
        float f8 = i2 - f2;
        if (this.d + f7 >= f8) {
            this.d = (f8 - 1.0f) - f7;
        }
    }

    public void b(float f, float f2) {
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = f;
        this.d = f2;
        this.e = f / 2.0f;
        this.f = f2 / 2.0f;
        this.g = f;
        this.h = f2;
        this.j = 0.0f;
    }

    public float c() {
        return this.d;
    }

    public float d() {
        return this.a;
    }

    public float e() {
        return this.b;
    }

    public float f() {
        return this.c;
    }

    public float g() {
        return this.k;
    }

    public float h() {
        return this.i;
    }

    public float i() {
        return this.j;
    }

    public float j() {
        return this.e;
    }

    public float k() {
        return this.f;
    }

    public float l() {
        return this.h;
    }

    public float m() {
        return this.g;
    }

    public float n() {
        return this.v;
    }

    public float b() {
        return this.n;
    }

    public void a(float f, float f2) {
        this.a += f;
        this.b += f2;
        this.e += f;
        this.f += f2;
    }

    public float a() {
        return this.o;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(L l) {
        return Float.compare((-l.g()) + l.h(), (-g()) + h());
    }
}
