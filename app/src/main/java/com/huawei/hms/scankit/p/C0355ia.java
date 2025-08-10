package com.huawei.hms.scankit.p;

/* compiled from: Codeword.java */
/* renamed from: com.huawei.hms.scankit.p.ia, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0355ia {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private int e = -1;

    public C0355ia(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public boolean a(int i) {
        return i != -1 && this.c == (i % 3) * 3;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.e;
    }

    public int d() {
        return this.a;
    }

    public int e() {
        return this.d;
    }

    public int f() {
        return this.b - this.a;
    }

    public boolean g() {
        return a(this.e);
    }

    public void h() {
        this.e = ((this.d / 30) * 3) + (this.c / 3);
    }

    public String toString() {
        return this.e + "|" + this.d;
    }

    public int a() {
        return this.c;
    }

    public void b(int i) {
        this.e = i;
    }
}
