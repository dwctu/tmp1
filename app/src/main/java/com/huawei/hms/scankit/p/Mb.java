package com.huawei.hms.scankit.p;

/* compiled from: Dimension.java */
/* loaded from: classes3.dex */
public final class Mb {
    private final int a;
    private final int b;

    public int a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Mb)) {
            return false;
        }
        Mb mb = (Mb) obj;
        return this.a == mb.a && this.b == mb.b;
    }

    public int hashCode() {
        return (this.a * 32713) + this.b;
    }

    public String toString() {
        return this.a + "x" + this.b;
    }
}
