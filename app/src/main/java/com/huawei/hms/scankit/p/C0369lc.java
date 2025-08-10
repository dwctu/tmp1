package com.huawei.hms.scankit.p;

/* compiled from: X12Encoder.java */
/* renamed from: com.huawei.hms.scankit.p.lc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0369lc extends C0325ac {
    @Override // com.huawei.hms.scankit.p.C0325ac
    public int a() {
        return 3;
    }

    @Override // com.huawei.hms.scankit.p.C0325ac, com.huawei.hms.scankit.p.InterfaceC0341ec
    public void a(C0345fc c0345fc) throws Exception {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!c0345fc.h()) {
                break;
            }
            char c = c0345fc.c();
            c0345fc.f++;
            a(c, sb);
            if (sb.length() % 3 == 0) {
                C0325ac.b(c0345fc, sb);
                if (C0353hc.a(c0345fc.d(), c0345fc.f, a()) != a()) {
                    c0345fc.b(0);
                    break;
                }
            }
        }
        a(c0345fc, sb);
    }

    @Override // com.huawei.hms.scankit.p.C0325ac
    public int a(char c, StringBuilder sb) throws Exception {
        if (c == '\r') {
            sb.append((char) 0);
        } else if (c == ' ') {
            sb.append((char) 3);
        } else if (c == '*') {
            sb.append((char) 1);
        } else if (c == '>') {
            sb.append((char) 2);
        } else if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
        } else if (c >= 'A' && c <= 'Z') {
            sb.append((char) ((c - 'A') + 14));
        } else {
            C0353hc.a(c);
            throw null;
        }
        return 1;
    }

    @Override // com.huawei.hms.scankit.p.C0325ac
    public void a(C0345fc c0345fc, StringBuilder sb) {
        c0345fc.k();
        int iA = c0345fc.g().a() - c0345fc.a();
        c0345fc.f -= sb.length();
        if (c0345fc.f() > 1 || iA > 1 || c0345fc.f() != iA) {
            c0345fc.a((char) 254);
        }
        if (c0345fc.e() < 0) {
            c0345fc.b(0);
        }
    }
}
