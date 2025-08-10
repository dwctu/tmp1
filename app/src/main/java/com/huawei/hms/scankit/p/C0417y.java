package com.huawei.hms.scankit.p;

import com.broadcom.bt.util.io.IOUtils;
import java.util.Arrays;

/* compiled from: BitMatrix.java */
/* renamed from: com.huawei.hms.scankit.p.y, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0417y implements Cloneable {
    private final int a;
    private final int b;
    private final int c;
    private final int[] d;

    public C0417y(int i) {
        this(i, i);
    }

    public void a(int i, int i2) {
        int i3 = (i2 * this.c) + (i / 32);
        if (com.huawei.hms.scankit.util.b.a(this.d, i3)) {
            int[] iArr = this.d;
            iArr[i3] = (1 << (i & 31)) ^ iArr[i3];
        }
    }

    public boolean b(int i, int i2) {
        int i3 = (i2 * this.c) + (i / 32);
        return com.huawei.hms.scankit.util.b.a(this.d, i3) && ((this.d[i3] >>> (i & 31)) & 1) != 0;
    }

    public void c(int i, int i2) {
        int i3 = (i2 * this.c) + (i / 32);
        if (com.huawei.hms.scankit.util.b.a(this.d, i3)) {
            int[] iArr = this.d;
            iArr[i3] = (1 << (i & 31)) | iArr[i3];
        }
    }

    public int d() {
        return this.a;
    }

    public void e() {
        int iD = d();
        int iB = b();
        C0413x c0413x = new C0413x(iD);
        C0413x c0413x2 = new C0413x(iD);
        for (int i = 0; i < (iB + 1) / 2; i++) {
            c0413x = a(i, c0413x);
            int i2 = (iB - 1) - i;
            c0413x2 = a(i2, c0413x2);
            c0413x.g();
            c0413x2.g();
            b(i, c0413x2);
            b(i2, c0413x);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0417y)) {
            return false;
        }
        C0417y c0417y = (C0417y) obj;
        return this.a == c0417y.a && this.b == c0417y.b && this.c == c0417y.c && Arrays.equals(this.d, c0417y.d);
    }

    public int hashCode() {
        int i = this.a;
        return (((((((i * 31) + i) * 31) + this.b) * 31) + this.c) * 31) + Arrays.hashCode(this.d);
    }

    public String toString() {
        return a("X ", "  ");
    }

    public C0417y(int i, int i2) throws Exception {
        if (i < 1 || i2 < 1) {
            try {
                throw new IllegalArgumentException("Both dimensions must be greater than 0");
            } catch (Exception e) {
                throw e;
            }
        }
        this.a = i;
        this.b = i2;
        int i3 = (i + 31) / 32;
        this.c = i3;
        this.d = new int[i3 * i2];
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public C0417y m79clone() {
        return new C0417y(this.a, this.b, this.c, (int[]) this.d.clone());
    }

    public void a() {
        int length = this.d.length;
        for (int i = 0; i < length; i++) {
            this.d[i] = 0;
        }
    }

    public void b(int i, C0413x c0413x) {
        int[] iArrC = c0413x.c();
        int[] iArr = this.d;
        int i2 = this.c;
        System.arraycopy(iArrC, 0, iArr, i * i2, i2);
    }

    public C0417y c() {
        int[] iArr = new int[this.d.length];
        int i = 0;
        while (true) {
            int[] iArr2 = this.d;
            if (i < iArr2.length) {
                iArr[i] = ~iArr2[i];
                i++;
            } else {
                return new C0417y(this.a, this.b, this.c, iArr);
            }
        }
    }

    public int b() {
        return this.b;
    }

    public void a(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            try {
                throw new IllegalArgumentException("Left and top must be nonnegative");
            } catch (Exception e) {
                throw e;
            }
        }
        if (i4 >= 1 && i3 >= 1) {
            int i5 = i3 + i;
            int i6 = i4 + i2;
            if (i6 > this.b || i5 > this.a) {
                try {
                    throw new IllegalArgumentException("The region must fit inside the matrix");
                } catch (Exception e2) {
                    throw e2;
                }
            }
            while (i2 < i6) {
                int i7 = this.c * i2;
                for (int i8 = i; i8 < i5; i8++) {
                    int[] iArr = this.d;
                    int i9 = (i8 / 32) + i7;
                    iArr[i9] = iArr[i9] | (1 << (i8 & 31));
                }
                i2++;
            }
            return;
        }
        try {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } catch (Exception e3) {
            throw e3;
        }
    }

    public C0417y(int i, int i2, int i3, int[] iArr) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = iArr;
    }

    public C0413x a(int i, C0413x c0413x) {
        if (c0413x != null && c0413x.d() >= this.a) {
            c0413x.a();
        } else {
            c0413x = new C0413x(this.a);
        }
        int i2 = i * this.c;
        for (int i3 = 0; i3 < this.c; i3++) {
            c0413x.b(i3 * 32, this.d[i2 + i3]);
        }
        return c0413x;
    }

    public String a(String str, String str2) {
        return a(str, str2, IOUtils.LINE_SEPARATOR_UNIX);
    }

    private String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.b * (this.a + 1));
        for (int i = 0; i < this.b; i++) {
            for (int i2 = 0; i2 < this.a; i2++) {
                sb.append(b(i2, i) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }
}
