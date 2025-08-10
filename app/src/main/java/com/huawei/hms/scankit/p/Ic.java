package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;
import java.util.Arrays;

/* compiled from: ByteMatrix.java */
/* loaded from: classes3.dex */
public final class Ic {
    private final byte[][] a;
    private final int b;
    private final int c;

    public Ic(int i, int i2) {
        this.a = (byte[][]) Array.newInstance((Class<?>) byte.class, i2, i);
        this.b = i;
        this.c = i2;
    }

    public byte a(int i, int i2) {
        try {
            if (com.huawei.hms.scankit.util.b.a(this.a, i2) && com.huawei.hms.scankit.util.b.a(this.a[i2], i)) {
                return this.a[i2][i];
            }
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        }
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.b * 2 * this.c) + 2);
        for (int i = 0; i < this.c; i++) {
            byte[] bArr = this.a[i];
            for (int i2 = 0; i2 < this.b; i2++) {
                byte b = bArr[i2];
                if (b == 0) {
                    sb.append(" 0");
                } else if (b != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public byte[][] a() {
        return this.a;
    }

    public void a(int i, int i2, int i3) {
        try {
            if (com.huawei.hms.scankit.util.b.a(this.a, i2) && com.huawei.hms.scankit.util.b.a(this.a[i2], i)) {
                this.a[i2][i] = (byte) i3;
                return;
            }
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        }
    }

    public void a(int i, int i2, boolean z) {
        try {
            if (com.huawei.hms.scankit.util.b.a(this.a, i2) && com.huawei.hms.scankit.util.b.a(this.a[i2], i)) {
                this.a[i2][i] = z ? (byte) 1 : (byte) 0;
                return;
            }
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        }
    }

    public void a(byte b) {
        for (byte[] bArr : this.a) {
            Arrays.fill(bArr, b);
        }
    }
}
