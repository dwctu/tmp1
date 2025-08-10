package com.huawei.hms.scankit.p;

/* compiled from: C40Encoder.java */
/* renamed from: com.huawei.hms.scankit.p.ac, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0325ac implements InterfaceC0341ec {
    public static void b(C0345fc c0345fc, StringBuilder sb) {
        c0345fc.a(a(sb, 0));
        sb.delete(0, 3);
    }

    public int a() {
        return 1;
    }

    @Override // com.huawei.hms.scankit.p.InterfaceC0341ec
    public void a(C0345fc c0345fc) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!c0345fc.h()) {
                break;
            }
            char c = c0345fc.c();
            c0345fc.f++;
            int iA = a(c, sb);
            int iA2 = c0345fc.a() + ((sb.length() / 3) * 2);
            c0345fc.c(iA2);
            int iA3 = c0345fc.g().a() - iA2;
            if (!c0345fc.h()) {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (iA3 < 2 || iA3 > 2)) {
                    iA = a(c0345fc, sb, sb2, iA);
                }
                while (sb.length() % 3 == 1 && ((iA <= 3 && iA3 != 1) || iA > 3)) {
                    iA = a(c0345fc, sb, sb2, iA);
                }
            } else if (sb.length() % 3 == 0 && C0353hc.a(c0345fc.d(), c0345fc.f, a()) != a()) {
                c0345fc.b(0);
                break;
            }
        }
        a(c0345fc, sb);
    }

    private int a(C0345fc c0345fc, StringBuilder sb, StringBuilder sb2, int i) {
        int length = sb.length();
        sb.delete(length - i, length);
        c0345fc.f--;
        int iA = a(c0345fc.c(), sb2);
        c0345fc.j();
        return iA;
    }

    public void a(C0345fc c0345fc, StringBuilder sb) {
        int length = (sb.length() / 3) * 2;
        int length2 = sb.length() % 3;
        int iA = c0345fc.a() + length;
        c0345fc.c(iA);
        int iA2 = c0345fc.g().a() - iA;
        if (length2 == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                b(c0345fc, sb);
            }
            if (c0345fc.h()) {
                c0345fc.a((char) 254);
            }
        } else if (iA2 == 1 && length2 == 1) {
            while (sb.length() >= 3) {
                b(c0345fc, sb);
            }
            if (c0345fc.h()) {
                c0345fc.a((char) 254);
            }
            c0345fc.f--;
        } else if (length2 == 0) {
            while (sb.length() >= 3) {
                b(c0345fc, sb);
            }
            if (iA2 > 0 || c0345fc.h()) {
                c0345fc.a((char) 254);
            }
        } else {
            try {
                throw new IllegalStateException("Unexpected case. Please report!");
            } catch (Exception unused) {
                com.huawei.hms.scankit.util.a.b("exception", "Exception");
            }
        }
        c0345fc.b(0);
    }

    public int a(char c, StringBuilder sb) {
        if (c == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
            return 1;
        }
        if (c >= 'A' && c <= 'Z') {
            sb.append((char) ((c - 'A') + 14));
            return 1;
        }
        if (c < ' ') {
            sb.append((char) 0);
            sb.append(c);
            return 2;
        }
        if (c >= '!' && c <= '/') {
            sb.append((char) 1);
            sb.append((char) (c - '!'));
            return 2;
        }
        if (c >= ':' && c <= '@') {
            sb.append((char) 1);
            sb.append((char) ((c - ':') + 15));
            return 2;
        }
        if (c >= '[' && c <= '_') {
            sb.append((char) 1);
            sb.append((char) ((c - '[') + 22));
            return 2;
        }
        if (c >= '`' && c <= 127) {
            sb.append((char) 2);
            sb.append((char) (c - '`'));
            return 2;
        }
        sb.append("\u0001\u001e");
        return a((char) (c - 128), sb) + 2;
    }

    private static String a(CharSequence charSequence, int i) {
        int iCharAt = (charSequence.charAt(i) * 1600) + (charSequence.charAt(i + 1) * '(') + charSequence.charAt(i + 2) + 1;
        return new String(new char[]{(char) (iCharAt / 256), (char) (iCharAt % 256)});
    }
}
