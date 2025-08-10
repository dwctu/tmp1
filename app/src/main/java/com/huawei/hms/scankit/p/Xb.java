package com.huawei.hms.scankit.p;

/* compiled from: Token.java */
/* loaded from: classes3.dex */
public abstract class Xb {
    public static final Xb a = new Vb(null, 0, 0);
    private final Xb b;

    public Xb(Xb xb) {
        this.b = xb;
    }

    public final Xb a() {
        return this.b;
    }

    public abstract void a(C0413x c0413x, byte[] bArr);

    public final Xb b(int i, int i2) {
        return new Sb(this, i, i2);
    }

    public final Xb a(int i, int i2) {
        return new Vb(this, i, i2);
    }
}
