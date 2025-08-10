package com.huawei.hms.scankit.p;

/* compiled from: EdifactEncoder.java */
/* renamed from: com.huawei.hms.scankit.p.dc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0337dc implements InterfaceC0341ec {
    public int a() {
        return 4;
    }

    @Override // com.huawei.hms.scankit.p.InterfaceC0341ec
    public void a(C0345fc c0345fc) throws Exception {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!c0345fc.h()) {
                break;
            }
            a(c0345fc.c(), sb);
            c0345fc.f++;
            if (sb.length() >= 4) {
                c0345fc.a(a(sb, 0));
                sb.delete(0, 4);
                if (C0353hc.a(c0345fc.d(), c0345fc.f, a()) != a()) {
                    c0345fc.b(0);
                    break;
                }
            }
        }
        sb.append((char) 31);
        a(c0345fc, sb);
    }

    private static void a(C0345fc c0345fc, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                return;
            }
            boolean z = true;
            if (length == 1) {
                c0345fc.k();
                int iA = c0345fc.g().a() - c0345fc.a();
                int iF = c0345fc.f();
                if (iF > iA) {
                    c0345fc.c(c0345fc.a() + 1);
                    iA = c0345fc.g().a() - c0345fc.a();
                }
                if (iF <= iA && iA <= 2) {
                    return;
                }
            }
            if (length <= 4) {
                int i = length - 1;
                String strA = a(charSequence, 0);
                if (!(!c0345fc.h()) || i > 2) {
                    z = false;
                }
                if (i <= 2) {
                    c0345fc.c(c0345fc.a() + i);
                    if (c0345fc.g().a() - c0345fc.a() >= 3) {
                        c0345fc.c(c0345fc.a() + strA.length());
                        z = false;
                    }
                }
                if (z) {
                    c0345fc.j();
                    c0345fc.f -= i;
                } else {
                    c0345fc.a(strA);
                }
                return;
            }
            throw new IllegalStateException("Count must not exceed 4");
        } finally {
            c0345fc.b(0);
        }
    }

    private static void a(char c, StringBuilder sb) throws Exception {
        if (c >= ' ' && c <= '?') {
            sb.append(c);
        } else if (c >= '@' && c <= '^') {
            sb.append((char) (c - '@'));
        } else {
            C0353hc.a(c);
            throw null;
        }
    }

    private static String a(CharSequence charSequence, int i) throws Exception {
        int length = charSequence.length() - i;
        if (length != 0) {
            int iCharAt = (charSequence.charAt(i) << 18) + ((length >= 2 ? charSequence.charAt(i + 1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(i + 2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(i + 3) : (char) 0);
            char c = (char) ((iCharAt >> 16) & 255);
            char c2 = (char) ((iCharAt >> 8) & 255);
            char c3 = (char) (iCharAt & 255);
            StringBuilder sb = new StringBuilder(3);
            sb.append(c);
            if (length >= 2) {
                sb.append(c2);
            }
            if (length >= 3) {
                sb.append(c3);
            }
            return sb.toString();
        }
        try {
            throw new IllegalStateException("StringBuilder must not be empty");
        } catch (Exception e) {
            throw e;
        }
    }
}
