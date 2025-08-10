package com.huawei.hms.scankit.p;

/* compiled from: ASCIIEncoder.java */
/* loaded from: classes3.dex */
public final class Zb implements InterfaceC0341ec {
    public int a() {
        return 0;
    }

    @Override // com.huawei.hms.scankit.p.InterfaceC0341ec
    public void a(C0345fc c0345fc) throws Exception {
        if (C0353hc.a(c0345fc.d(), c0345fc.f) >= 2) {
            c0345fc.a(a(c0345fc.d().charAt(c0345fc.f), c0345fc.d().charAt(c0345fc.f + 1)));
            c0345fc.f += 2;
            return;
        }
        char c = c0345fc.c();
        int iA = C0353hc.a(c0345fc.d(), c0345fc.f, a());
        if (iA == a()) {
            if (!C0353hc.c(c)) {
                c0345fc.a((char) (c + 1));
                c0345fc.f++;
                return;
            } else {
                c0345fc.a((char) 235);
                c0345fc.a((char) ((c - 128) + 1));
                c0345fc.f++;
                return;
            }
        }
        if (iA == 1) {
            c0345fc.a((char) 230);
            c0345fc.b(1);
            return;
        }
        if (iA == 2) {
            c0345fc.a((char) 239);
            c0345fc.b(2);
            return;
        }
        if (iA == 3) {
            c0345fc.a((char) 238);
            c0345fc.b(3);
            return;
        }
        if (iA == 4) {
            c0345fc.a((char) 240);
            c0345fc.b(4);
        } else {
            if (iA == 5) {
                c0345fc.a((char) 231);
                c0345fc.b(5);
                return;
            }
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("Illegal mode: ");
                sb.append(iA);
                throw new IllegalStateException(sb.toString());
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private static char a(char c, char c2) throws Exception {
        if (C0353hc.b(c) && C0353hc.b(c2)) {
            return (char) (((c - '0') * 10) + (c2 - '0') + 130);
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("not digits: ");
            sb.append(c);
            sb.append(c2);
            throw new IllegalArgumentException(sb.toString());
        } catch (Exception e) {
            throw e;
        }
    }
}
