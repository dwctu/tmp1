package com.huawei.hms.scankit.p;

/* compiled from: ModulusGF.java */
/* renamed from: com.huawei.hms.scankit.p.qa, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0387qa {
    public static final C0387qa a = new C0387qa(929, 3);
    private final int[] b;
    private final int[] c;
    private final C0390ra d;
    private final C0390ra e;
    private final int f;

    private C0387qa(int i, int i2) {
        this.f = i;
        this.b = new int[i];
        this.c = new int[i];
        int i3 = 1;
        for (int i4 = 0; i4 < i; i4++) {
            this.b[i4] = i3;
            i3 = (i3 * i2) % i;
        }
        for (int i5 = 0; i5 < i - 1; i5++) {
            this.c[this.b[i5]] = i5;
        }
        this.d = new C0390ra(this, new int[]{0});
        this.e = new C0390ra(this, new int[]{1});
    }

    public C0390ra a() {
        return this.e;
    }

    public C0390ra b(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.d;
        }
        int[] iArr = new int[i + 1];
        iArr[0] = i2;
        return new C0390ra(this, iArr);
    }

    public C0390ra c() {
        return this.d;
    }

    public int d(int i, int i2) {
        int i3 = this.f;
        return ((i + i3) - i2) % i3;
    }

    public int a(int i, int i2) {
        return (i + i2) % this.f;
    }

    public int c(int i) {
        if (i != 0) {
            return this.c[i];
        }
        throw new IllegalArgumentException();
    }

    public int a(int i) {
        return this.b[i];
    }

    public int c(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return 0;
        }
        int[] iArr = this.b;
        int[] iArr2 = this.c;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.f - 1)];
    }

    public int b(int i) {
        if (i != 0) {
            return this.b[(this.f - this.c[i]) - 1];
        }
        throw new ArithmeticException();
    }

    public int b() {
        return this.f;
    }
}
