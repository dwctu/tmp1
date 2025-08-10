package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.EnumC0311c;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Encoder.java */
/* loaded from: classes3.dex */
public final class Lc {
    private static final int[] a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    private static int a(Ic ic) {
        return Mc.a(ic) + Mc.b(ic) + Mc.c(ic) + Mc.d(ic);
    }

    public static void b(CharSequence charSequence, C0413x c0413x) throws Exception {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int iCharAt = charSequence.charAt(i) - '0';
            int i2 = i + 2;
            if (i2 < length) {
                c0413x.a((iCharAt * 100) + ((charSequence.charAt(i + 1) - '0') * 10) + (charSequence.charAt(i2) - '0'), 10);
                i += 3;
            } else {
                i++;
                if (i < length) {
                    c0413x.a((iCharAt * 10) + (charSequence.charAt(i) - '0'), 7);
                    i = i2;
                } else {
                    c0413x.a(iCharAt, 4);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.hms.scankit.p.Oc a(java.lang.String r7, com.huawei.hms.scankit.p.Pa r8, java.util.Map<com.huawei.hms.scankit.p.Jc, ?> r9) throws java.lang.Exception {
        /*
            r0 = 1
            r1 = 0
            if (r9 == 0) goto Le
            com.huawei.hms.scankit.p.Jc r2 = com.huawei.hms.scankit.p.Jc.CHARACTER_SET
            boolean r2 = r9.containsKey(r2)
            if (r2 == 0) goto Le
            r2 = 1
            goto Lf
        Le:
            r2 = 0
        Lf:
            if (r2 == 0) goto L1c
            com.huawei.hms.scankit.p.Jc r3 = com.huawei.hms.scankit.p.Jc.CHARACTER_SET
            java.lang.Object r3 = r9.get(r3)
            java.lang.String r3 = r3.toString()
            goto L1e
        L1c:
            java.lang.String r3 = "ISO-8859-1"
        L1e:
            com.huawei.hms.scankit.p.Va r4 = a(r7, r3)
            com.huawei.hms.scankit.p.x r5 = new com.huawei.hms.scankit.p.x
            r5.<init>()
            com.huawei.hms.scankit.p.Va r6 = com.huawei.hms.scankit.p.Va.BYTE
            if (r4 != r6) goto L36
            if (r2 == 0) goto L36
            com.huawei.hms.scankit.aiscan.common.c r2 = com.huawei.hms.scankit.aiscan.common.EnumC0311c.a(r3)
            if (r2 == 0) goto L36
            a(r2, r5)
        L36:
            if (r9 == 0) goto L41
            com.huawei.hms.scankit.p.Jc r2 = com.huawei.hms.scankit.p.Jc.GS1_FORMAT
            boolean r2 = r9.containsKey(r2)
            if (r2 == 0) goto L41
            goto L42
        L41:
            r0 = 0
        L42:
            if (r0 == 0) goto L5d
            com.huawei.hms.scankit.p.Jc r0 = com.huawei.hms.scankit.p.Jc.GS1_FORMAT
            java.lang.Object r0 = r9.get(r0)
            java.lang.String r0 = r0.toString()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L5d
            com.huawei.hms.scankit.p.Va r0 = com.huawei.hms.scankit.p.Va.FNC1_FIRST_POSITION
            a(r0, r5)
        L5d:
            a(r4, r5)
            com.huawei.hms.scankit.p.x r0 = new com.huawei.hms.scankit.p.x
            r0.<init>()
            a(r7, r4, r0, r3)
            if (r9 == 0) goto L97
            com.huawei.hms.scankit.p.Jc r1 = com.huawei.hms.scankit.p.Jc.QR_VERSION
            boolean r2 = r9.containsKey(r1)
            if (r2 == 0) goto L97
            java.lang.Object r9 = r9.get(r1)     // Catch: java.lang.Exception -> L95
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> L95
            int r9 = java.lang.Integer.parseInt(r9)     // Catch: java.lang.Exception -> L95
            com.huawei.hms.scankit.p.Ya r9 = com.huawei.hms.scankit.p.Ya.c(r9)     // Catch: java.lang.Exception -> L95
            int r1 = a(r4, r5, r0, r9)
            boolean r1 = a(r1, r9, r8)
            if (r1 == 0) goto L8d
            goto L9b
        L8d:
            com.huawei.hms.hmsscankit.WriterException r7 = new com.huawei.hms.hmsscankit.WriterException
            java.lang.String r8 = "Data too big for requested version"
            r7.<init>(r8)
            throw r7
        L95:
            r7 = move-exception
            throw r7
        L97:
            com.huawei.hms.scankit.p.Ya r9 = a(r8, r4, r5, r0)
        L9b:
            com.huawei.hms.scankit.p.x r1 = new com.huawei.hms.scankit.p.x
            r1.<init>()
            r1.a(r5)
            if (r4 != r6) goto Laa
            int r7 = r0.e()
            goto Lae
        Laa:
            int r7 = r7.length()
        Lae:
            a(r7, r9, r4, r1)
            r1.a(r0)
            com.huawei.hms.scankit.p.Ya$b r7 = r9.a(r8)
            int r0 = r9.d()
            int r2 = r7.d()
            int r0 = r0 - r2
            a(r0, r1)
            int r2 = r9.d()
            int r7 = r7.c()
            com.huawei.hms.scankit.p.x r7 = a(r1, r2, r0, r7)
            com.huawei.hms.scankit.p.Oc r0 = new com.huawei.hms.scankit.p.Oc
            r0.<init>()
            r0.a(r8)
            r0.a(r4)
            r0.a(r9)
            int r1 = r9.c()
            com.huawei.hms.scankit.p.Ic r2 = new com.huawei.hms.scankit.p.Ic
            r2.<init>(r1, r1)
            int r1 = a(r7, r8, r9, r2)
            r0.b(r1)
            com.huawei.hms.scankit.p.Nc.a(r7, r8, r9, r1, r2)
            r0.a(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.Lc.a(java.lang.String, com.huawei.hms.scankit.p.Pa, java.util.Map):com.huawei.hms.scankit.p.Oc");
    }

    private static Ya a(Pa pa, Va va, C0413x c0413x, C0413x c0413x2) throws WriterException {
        return a(a(va, c0413x, c0413x2, a(a(va, c0413x, c0413x2, Ya.c(1)), pa)), pa);
    }

    private static int a(Va va, C0413x c0413x, C0413x c0413x2, Ya ya) {
        return c0413x.d() + va.a(ya) + c0413x2.d();
    }

    public static int a(int i) {
        int[] iArr = a;
        if (i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    private static Va a(String str, String str2) {
        if ("Shift_JIS".equals(str2) && a(str)) {
            return Va.KANJI;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= '0' && cCharAt <= '9') {
                z2 = true;
            } else {
                if (a(cCharAt) == -1) {
                    return Va.BYTE;
                }
                z = true;
            }
        }
        if (z) {
            return Va.ALPHANUMERIC;
        }
        if (z2) {
            return Va.NUMERIC;
        }
        return Va.BYTE;
    }

    private static boolean a(String str) throws UnsupportedEncodingException {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & 255;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static int a(C0413x c0413x, Pa pa, Ya ya, Ic ic) throws Exception {
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        for (int i3 = 0; i3 < 8; i3++) {
            Nc.a(c0413x, pa, ya, i3, ic);
            int iA = a(ic);
            if (iA < i) {
                i2 = i3;
                i = iA;
            }
        }
        return i2;
    }

    private static Ya a(int i, Pa pa) throws Exception {
        for (int i2 = 1; i2 <= 40; i2++) {
            Ya yaC = Ya.c(i2);
            if (a(i, yaC, pa)) {
                return yaC;
            }
        }
        throw new WriterException("Data too big");
    }

    private static boolean a(int i, Ya ya, Pa pa) {
        return ya.d() - ya.a(pa).d() >= (i + 7) / 8;
    }

    public static void a(int i, C0413x c0413x) throws Exception {
        int i2 = i * 8;
        if (c0413x.d() <= i2) {
            for (int i3 = 0; i3 < 4 && c0413x.d() < i2; i3++) {
                c0413x.a(false);
            }
            int iD = c0413x.d() & 7;
            if (iD > 0) {
                while (iD < 8) {
                    c0413x.a(false);
                    iD++;
                }
            }
            int iE = i - c0413x.e();
            for (int i4 = 0; i4 < iE; i4++) {
                c0413x.a((i4 & 1) == 0 ? 236 : 17, 8);
            }
            if (c0413x.d() != i2) {
                throw new WriterException("Bits size does not equal capacity");
            }
            return;
        }
        throw new WriterException("data bits cannot fit in the QR Code" + c0413x.d() + " > " + i2);
    }

    public static void a(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) throws WriterException {
        if (i4 < i3) {
            int i5 = i % i3;
            int i6 = i3 - i5;
            int i7 = i / i3;
            int i8 = i7 + 1;
            int i9 = i2 / i3;
            int i10 = i9 + 1;
            int i11 = i7 - i9;
            int i12 = i8 - i10;
            if (i11 != i12) {
                throw new WriterException("EC bytes mismatch");
            }
            if (i3 != i6 + i5) {
                throw new WriterException("RS blocks mismatch");
            }
            if (i != ((i9 + i11) * i6) + ((i10 + i12) * i5)) {
                throw new WriterException("Total bytes mismatch");
            }
            if (i4 < i6) {
                iArr[0] = i9;
                iArr2[0] = i11;
                return;
            } else {
                iArr[0] = i10;
                iArr2[0] = i12;
                return;
            }
        }
        throw new WriterException("Block ID too large");
    }

    public static C0413x a(C0413x c0413x, int i, int i2, int i3) throws Exception {
        if (c0413x.e() == i2) {
            ArrayList arrayList = new ArrayList(i3);
            int i4 = 0;
            int iMax = 0;
            int iMax2 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                a(i, i2, i3, i5, iArr, iArr2);
                int i6 = iArr[0];
                byte[] bArr = new byte[i6];
                c0413x.a(i4 * 8, bArr, 0, i6);
                byte[] bArrA = a(bArr, iArr2[0]);
                arrayList.add(new Hc(bArr, bArrA));
                iMax2 = Math.max(iMax2, i6);
                iMax = Math.max(iMax, bArrA.length);
                i4 += iArr[0];
            }
            if (i2 == i4) {
                C0413x c0413x2 = new C0413x();
                for (int i7 = 0; i7 < iMax2; i7++) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        byte[] bArrA2 = ((Hc) it.next()).a();
                        if (i7 < bArrA2.length) {
                            c0413x2.a(bArrA2[i7], 8);
                        }
                    }
                }
                for (int i8 = 0; i8 < iMax; i8++) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        byte[] bArrB = ((Hc) it2.next()).b();
                        if (i8 < bArrB.length) {
                            c0413x2.a(bArrB[i8], 8);
                        }
                    }
                }
                if (i == c0413x2.e()) {
                    return c0413x2;
                }
                throw new WriterException("Interleaving error: " + i + " and " + c0413x2.e() + " differ.");
            }
            throw new WriterException("Data bytes does not match offset");
        }
        throw new WriterException("Number of bits and data bytes does not match");
    }

    public static byte[] a(byte[] bArr, int i) throws Exception {
        int length = bArr.length;
        int[] iArr = new int[length + i];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        new com.huawei.hms.scankit.aiscan.common.v(com.huawei.hms.scankit.aiscan.common.h.e).a(iArr, i);
        byte[] bArr2 = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr2[i3] = (byte) iArr[length + i3];
        }
        return bArr2;
    }

    public static void a(Va va, C0413x c0413x) throws Exception {
        c0413x.a(va.a(), 4);
    }

    public static void a(int i, Ya ya, Va va, C0413x c0413x) throws Exception {
        int iA = va.a(ya);
        int i2 = 1 << iA;
        if (i < i2) {
            c0413x.a(i, iA);
            return;
        }
        throw new WriterException(i + " is bigger than " + (i2 - 1));
    }

    public static void a(String str, Va va, C0413x c0413x, String str2) throws Exception {
        int i = Kc.a[va.ordinal()];
        if (i == 1) {
            b(str, c0413x);
            return;
        }
        if (i == 2) {
            a((CharSequence) str, c0413x);
            return;
        }
        if (i == 3) {
            a(str, c0413x, str2);
        } else {
            if (i == 4) {
                a(str, c0413x);
                return;
            }
            throw new WriterException("Invalid mode: " + va);
        }
    }

    public static void a(CharSequence charSequence, C0413x c0413x) throws Exception {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int iA = a(charSequence.charAt(i));
            if (iA == -1) {
                throw new WriterException();
            }
            int i2 = i + 1;
            if (i2 < length) {
                int iA2 = a(charSequence.charAt(i2));
                if (iA2 != -1) {
                    c0413x.a((iA * 45) + iA2, 11);
                    i += 2;
                } else {
                    throw new WriterException();
                }
            } else {
                c0413x.a(iA, 6);
                i = i2;
            }
        }
    }

    public static void a(String str, C0413x c0413x, String str2) throws Exception {
        try {
            for (byte b : str.getBytes(str2)) {
                c0413x.a(b, 8);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e);
        }
    }

    public static void a(String str, C0413x c0413x) throws Exception {
        int i;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i2 = 0; i2 < length; i2 += 2) {
                int i3 = ((bytes[i2] & 255) << 8) | (bytes[i2 + 1] & 255);
                int i4 = 33088;
                if (i3 >= 33088 && i3 <= 40956) {
                    i = i3 - i4;
                } else if (i3 < 57408 || i3 > 60351) {
                    i = -1;
                } else {
                    i4 = 49472;
                    i = i3 - i4;
                }
                if (i != -1) {
                    c0413x.a(((i >> 8) * 192) + (i & 255), 13);
                } else {
                    throw new WriterException("Invalid byte sequence");
                }
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e);
        }
    }

    private static void a(EnumC0311c enumC0311c, C0413x c0413x) throws Exception {
        c0413x.a(Va.ECI.a(), 4);
        c0413x.a(enumC0311c.a(), 8);
    }
}
