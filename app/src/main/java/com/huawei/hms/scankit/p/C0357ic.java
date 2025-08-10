package com.huawei.hms.scankit.p;

import org.bouncycastle.crypto.tls.CipherSuite;

/* compiled from: SymbolInfo.java */
/* renamed from: com.huawei.hms.scankit.p.ic, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0357ic {
    public static final C0357ic[] a;
    private static C0357ic[] b;
    private final boolean c;
    private final int d;
    private final int e;
    public final int f;
    public final int g;
    private final int h;
    private final int i;
    private final int j;

    static {
        C0357ic[] c0357icArr = {new C0357ic(false, 3, 5, 8, 8, 1), new C0357ic(false, 5, 7, 10, 10, 1), new C0357ic(true, 5, 7, 16, 6, 1), new C0357ic(false, 8, 10, 12, 12, 1), new C0357ic(true, 10, 11, 14, 6, 2), new C0357ic(false, 12, 12, 14, 14, 1), new C0357ic(true, 16, 14, 24, 10, 1), new C0357ic(false, 18, 14, 16, 16, 1), new C0357ic(false, 22, 18, 18, 18, 1), new C0357ic(true, 22, 18, 16, 10, 2), new C0357ic(false, 30, 20, 20, 20, 1), new C0357ic(true, 32, 24, 16, 14, 2), new C0357ic(false, 36, 24, 22, 22, 1), new C0357ic(false, 44, 28, 24, 24, 1), new C0357ic(true, 49, 28, 22, 14, 2), new C0357ic(false, 62, 36, 14, 14, 4), new C0357ic(false, 86, 42, 16, 16, 4), new C0357ic(false, 114, 48, 18, 18, 4), new C0357ic(false, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 56, 20, 20, 4), new C0357ic(false, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256, 68, 22, 22, 4), new C0357ic(false, 204, 84, 24, 24, 4, 102, 42), new C0357ic(false, 280, 112, 14, 14, 16, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA, 56), new C0357ic(false, 368, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 16, 16, 16, 92, 36), new C0357ic(false, 456, 192, 18, 18, 16, 114, 48), new C0357ic(false, 576, 224, 20, 20, 16, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 56), new C0357ic(false, 696, 272, 22, 22, 16, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA256, 68), new C0357ic(false, 816, 336, 24, 24, 16, CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA, 56), new C0357ic(false, 1050, 408, 18, 18, 36, 175, 68), new C0357ic(false, 1304, 496, 20, 20, 36, 163, 62), new C0329bc()};
        a = c0357icArr;
        b = c0357icArr;
    }

    public C0357ic(boolean z, int i, int i2, int i3, int i4, int i5) {
        this(z, i, i2, i3, i4, i5, i, i2);
    }

    public static C0357ic a(int i, EnumC0361jc enumC0361jc, Mb mb, Mb mb2, boolean z) throws Exception {
        for (C0357ic c0357ic : b) {
            if (!(enumC0361jc == EnumC0361jc.FORCE_SQUARE && c0357ic.c) && ((enumC0361jc != EnumC0361jc.FORCE_RECTANGLE || c0357ic.c) && ((mb == null || (c0357ic.g() >= mb.b() && c0357ic.f() >= mb.a())) && ((mb2 == null || (c0357ic.g() <= mb2.b() && c0357ic.f() <= mb2.a())) && i <= c0357ic.d)))) {
                return c0357ic;
            }
        }
        if (!z) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Can't find a symbol arrangement that matches the message. Data codewords: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        } catch (Exception e) {
            throw e;
        }
    }

    private int h() throws Exception {
        int i = this.h;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2 && i != 4) {
                if (i == 16) {
                    return 4;
                }
                if (i == 36) {
                    return 6;
                }
                try {
                    throw new IllegalStateException("Cannot handle this number of data regions");
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        return i2;
    }

    private int i() throws Exception {
        int i = this.h;
        if (i == 1 || i == 2) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 36) {
            return 6;
        }
        try {
            throw new IllegalStateException("Cannot handle this number of data regions");
        } catch (Exception e) {
            throw e;
        }
    }

    public final int b() {
        return this.e;
    }

    public int c() {
        return this.d / this.i;
    }

    public final int d() {
        return i() * this.g;
    }

    public final int e() {
        return h() * this.f;
    }

    public final int f() {
        return d() + (i() * 2);
    }

    public final int g() {
        return e() + (h() * 2);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.c ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        sb.append(this.f);
        sb.append('x');
        sb.append(this.g);
        sb.append(", symbol size ");
        sb.append(g());
        sb.append('x');
        sb.append(f());
        sb.append(", symbol data size ");
        sb.append(e());
        sb.append('x');
        sb.append(d());
        sb.append(", codewords ");
        sb.append(this.d);
        sb.append('+');
        sb.append(this.e);
        return sb.toString();
    }

    public C0357ic(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.c = z;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        this.h = i5;
        this.i = i6;
        this.j = i7;
    }

    public final int b(int i) {
        return this.j;
    }

    public final int a() {
        return this.d;
    }

    public int a(int i) {
        return this.i;
    }
}
