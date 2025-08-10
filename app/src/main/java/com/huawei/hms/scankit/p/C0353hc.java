package com.huawei.hms.scankit.p;

import java.util.Arrays;

/* compiled from: HighLevelEncoder.java */
/* renamed from: com.huawei.hms.scankit.p.hc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0353hc {
    private static char a(char c, int i) {
        int i2 = c + ((i * 149) % 253) + 1;
        if (i2 > 254) {
            i2 -= 254;
        }
        return (char) i2;
    }

    public static boolean b(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean c(char c) {
        return c >= 128 && c <= 255;
    }

    private static boolean d(char c) {
        return c == ' ' || (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z');
    }

    private static boolean e(char c) {
        return c >= ' ' && c <= '^';
    }

    private static boolean f(char c) {
        return c == ' ' || (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }

    private static boolean g(char c) {
        return i(c) || c == ' ' || (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z');
    }

    private static boolean h(char c) {
        return false;
    }

    private static boolean i(char c) {
        return c == '\r' || c == '*' || c == '>';
    }

    public static String a(String str, EnumC0361jc enumC0361jc, Mb mb, Mb mb2) {
        int iE = 0;
        InterfaceC0341ec[] interfaceC0341ecArr = {new Zb(), new C0325ac(), new C0365kc(), new C0369lc(), new C0337dc(), new _b()};
        C0345fc c0345fc = new C0345fc(str);
        c0345fc.a(enumC0361jc);
        c0345fc.a(mb, mb2);
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            c0345fc.a((char) 236);
            c0345fc.a(2);
            c0345fc.f += 7;
        } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
            c0345fc.a((char) 237);
            c0345fc.a(2);
            c0345fc.f += 7;
        }
        while (c0345fc.h()) {
            if (iE >= 0 && iE < 6) {
                interfaceC0341ecArr[iE].a(c0345fc);
            }
            if (c0345fc.e() >= 0) {
                iE = c0345fc.e();
                c0345fc.i();
            }
        }
        int iA = c0345fc.a();
        c0345fc.k();
        int iA2 = c0345fc.g().a();
        if (iA < iA2 && iE != 0 && iE != 5 && iE != 4) {
            c0345fc.a((char) 254);
        }
        StringBuilder sbB = c0345fc.b();
        if (sbB.length() < iA2) {
            sbB.append((char) 129);
        }
        while (sbB.length() < iA2) {
            sbB.append(a((char) 129, sbB.length() + 1));
        }
        return c0345fc.b().toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:137:0x01ed, code lost:
    
        r1 = (r18 + r5) + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x01f3, code lost:
    
        if (r1 >= r17.length()) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x01f5, code lost:
    
        r2 = r17.charAt(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x01fd, code lost:
    
        if (i(r2) == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x01ff, code lost:
    
        return 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0204, code lost:
    
        if (g(r2) != false) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0207, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x020a, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(java.lang.CharSequence r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.C0353hc.a(java.lang.CharSequence, int, int):int");
    }

    private static int a(float[] fArr, int[] iArr, int i, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        for (int i2 = 0; i2 < 6; i2++) {
            iArr[i2] = (int) Math.ceil(fArr[i2]);
            int i3 = iArr[i2];
            if (i > i3) {
                Arrays.fill(bArr, (byte) 0);
                i = i3;
            }
            if (i == i3) {
                bArr[i2] = (byte) (bArr[i2] + 1);
            }
        }
        return i;
    }

    private static int a(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 6; i2++) {
            i += bArr[i2];
        }
        return i;
    }

    public static int a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        if (i < length) {
            char cCharAt = charSequence.charAt(i);
            while (b(cCharAt) && i < length) {
                i2++;
                i++;
                if (i < length) {
                    cCharAt = charSequence.charAt(i);
                }
            }
        }
        return i2;
    }

    public static void a(char c) throws Exception {
        String hexString = Integer.toHexString(c);
        String str = "0000".substring(0, 4 - hexString.length()) + hexString;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Illegal character: ");
            sb.append(c);
            sb.append(" (0x");
            sb.append(str);
            sb.append(')');
            throw new IllegalArgumentException(sb.toString());
        } catch (Exception e) {
            throw e;
        }
    }
}
