package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0309a;
import org.bouncycastle.crypto.tls.CipherSuite;

/* compiled from: Version.java */
/* loaded from: classes3.dex */
public final class K {
    private static final int[][] a = {new int[]{1, 10, 10, 8, 8, 5, 1, 3}, new int[]{2, 12, 12, 10, 10, 7, 1, 5}, new int[]{3, 14, 14, 12, 12, 10, 1, 8}, new int[]{4, 16, 16, 14, 14, 12, 1, 12}, new int[]{5, 18, 18, 16, 16, 14, 1, 18}, new int[]{6, 20, 20, 18, 18, 18, 1, 22}, new int[]{7, 22, 22, 20, 20, 20, 1, 30}, new int[]{8, 24, 24, 22, 22, 24, 1, 36}, new int[]{9, 26, 26, 24, 24, 28, 1, 44}, new int[]{10, 32, 32, 14, 14, 36, 1, 62}, new int[]{11, 36, 36, 16, 16, 42, 1, 86}, new int[]{12, 40, 40, 18, 18, 48, 1, 114}, new int[]{13, 44, 44, 20, 20, 56, 1, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA}, new int[]{14, 48, 48, 22, 22, 68, 1, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256}, new int[]{15, 52, 52, 24, 24, 42, 2, 102}, new int[]{16, 64, 64, 14, 14, 56, 2, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA}, new int[]{17, 72, 72, 16, 16, 36, 4, 92}, new int[]{18, 80, 80, 18, 18, 48, 4, 114}, new int[]{19, 88, 88, 20, 20, 56, 4, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA}, new int[]{20, 96, 96, 22, 22, 68, 4, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256}, new int[]{21, 104, 104, 24, 24, 56, 6, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA}, new int[]{22, 120, 120, 18, 18, 68, 6, 175}, new int[]{23, 132, 132, 20, 20, 62, 8, 163}, new int[]{24, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 22, 22, 62, 8, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, 2, CipherSuite.TLS_DH_anon_WITH_SEED_CBC_SHA}, new int[]{25, 8, 18, 6, 16, 7, 1, 5}, new int[]{26, 8, 32, 6, 14, 11, 1, 10}, new int[]{27, 12, 26, 10, 24, 14, 1, 16}, new int[]{28, 12, 36, 10, 16, 18, 1, 22}, new int[]{29, 16, 36, 14, 16, 24, 1, 32}, new int[]{30, 16, 48, 14, 22, 28, 1, 49}};
    private static final K[] b = h();
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final b h;
    private final int i;

    /* compiled from: Version.java */
    public static final class a {
        private final int a;
        private final int b;

        public int a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        private a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    private K(int i, int i2, int i3, int i4, int i5, b bVar) {
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = i5;
        this.h = bVar;
        int iB = bVar.b();
        int iA = 0;
        for (a aVar : bVar.a()) {
            iA += aVar.a() * (aVar.b() + iB);
        }
        this.i = iA;
    }

    private static K[] h() {
        K[] kArr = new K[a.length];
        int i = 0;
        while (true) {
            int[][] iArr = a;
            if (i >= iArr.length) {
                return kArr;
            }
            int[] iArr2 = iArr[i];
            if (i == 23) {
                kArr[i] = new K(iArr2[0], iArr2[1], iArr2[2], iArr2[3], iArr2[4], new b(iArr2[5], new a(iArr2[6], iArr2[7]), new a(iArr2[8], iArr2[9])));
            } else {
                kArr[i] = new K(iArr2[0], iArr2[1], iArr2[2], iArr2[3], iArr2[4], new b(iArr2[5], new a(iArr2[6], iArr2[7])));
            }
            i++;
        }
    }

    public int a() {
        return this.g;
    }

    public int b() {
        return this.f;
    }

    public b c() {
        return this.h;
    }

    public int d() {
        return this.e;
    }

    public int e() {
        return this.d;
    }

    public int f() {
        return this.i;
    }

    public int g() {
        return this.c;
    }

    public String toString() {
        return String.valueOf(this.c);
    }

    /* compiled from: Version.java */
    public static final class b {
        private final int a;
        private final a[] b;

        public a[] a() {
            return this.b;
        }

        public int b() {
            return this.a;
        }

        private b(int i, a aVar) {
            this.a = i;
            this.b = new a[]{aVar};
        }

        private b(int i, a aVar, a aVar2) {
            this.a = i;
            this.b = new a[]{aVar, aVar2};
        }
    }

    public static K a(int i, int i2) throws C0309a {
        if ((i & 1) != 0 || (i2 & 1) != 0) {
            throw C0309a.a();
        }
        for (K k : b) {
            if (k.d == i && k.e == i2) {
                return k;
            }
        }
        throw C0309a.a();
    }
}
