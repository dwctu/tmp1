package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0309a;
import com.huawei.hms.scankit.aiscan.common.C0313e;
import com.huawei.hms.scankit.aiscan.common.EnumC0311c;
import com.huawei.hms.scankit.aiscan.common.EnumC0312d;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: DecodedBitStreamParser.java */
/* loaded from: classes3.dex */
public final class Ma {
    private static final char[] a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    public static C0313e a(byte[] bArr, Ya ya, Pa pa, Map<EnumC0312d, ?> map) throws Exception {
        int i;
        int i2;
        C0421z c0421z = new C0421z(bArr);
        StringBuilder sb = new StringBuilder(50);
        ArrayList arrayList = new ArrayList(1);
        int i3 = -1;
        int i4 = -1;
        int i5 = 0;
        while (true) {
            try {
                Va vaA = c0421z.a() < 4 ? Va.TERMINATOR : Va.a(c0421z.a(4));
                int[] iArr = {i5, i3, i4};
                a(vaA, c0421z, sb, ya, iArr, null, arrayList, map);
                i5 = iArr[0] == 1 ? 1 : 0;
                i = iArr[1];
                i2 = iArr[2];
                if (vaA == Va.TERMINATOR) {
                    break;
                }
                i3 = i;
                i4 = i2;
            } catch (IllegalArgumentException unused) {
                throw C0309a.a();
            }
        }
        return new C0313e(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, pa == null ? null : pa.toString(), i, i2);
    }

    private static void b(C0421z c0421z, StringBuilder sb, int i) throws Exception {
        if (i * 13 > c0421z.a()) {
            throw C0309a.a();
        }
        byte[] bArr = new byte[i * 2];
        int i2 = 0;
        while (i > 0) {
            int iA = c0421z.a(13);
            int i3 = (iA % 192) | ((iA / 192) << 8);
            int i4 = i3 + (i3 < 7936 ? 33088 : 49472);
            try {
                if (com.huawei.hms.scankit.util.b.a(bArr, i2)) {
                    int i5 = i2 + 1;
                    if (com.huawei.hms.scankit.util.b.a(bArr, i5)) {
                        bArr[i2] = (byte) (i4 >> 8);
                        bArr[i5] = (byte) i4;
                        i2 += 2;
                        i--;
                    }
                }
                throw new ArrayIndexOutOfBoundsException();
            } catch (ArrayIndexOutOfBoundsException e) {
                throw e;
            }
        }
        try {
            sb.append(new String(bArr, "SJIS"));
        } catch (UnsupportedEncodingException unused) {
            throw C0309a.a();
        }
    }

    private static void c(C0421z c0421z, StringBuilder sb, int i) throws Exception {
        while (i >= 3) {
            if (c0421z.a() < 10) {
                throw C0309a.a();
            }
            int iA = c0421z.a(10);
            if (iA >= 1000) {
                throw C0309a.a();
            }
            sb.append(a(iA / 100));
            sb.append(a((iA / 10) % 10));
            sb.append(a(iA % 10));
            i -= 3;
        }
        if (i == 2) {
            if (c0421z.a() < 7) {
                throw C0309a.a();
            }
            int iA2 = c0421z.a(7);
            if (iA2 >= 100) {
                throw C0309a.a();
            }
            sb.append(a(iA2 / 10));
            sb.append(a(iA2 % 10));
            return;
        }
        if (i == 1) {
            if (c0421z.a() < 4) {
                throw C0309a.a();
            }
            int iA3 = c0421z.a(4);
            if (iA3 >= 10) {
                throw C0309a.a();
            }
            sb.append(a(iA3));
        }
    }

    private static void a(Va va, C0421z c0421z, StringBuilder sb, Ya ya, int[] iArr, EnumC0311c enumC0311c, List<byte[]> list, Map<EnumC0312d, ?> map) throws Exception {
        int[] iArr2 = La.a;
        switch (iArr2[va.ordinal()]) {
            case 5:
                return;
            case 6:
            case 7:
                iArr[0] = 1;
                return;
            case 8:
                if (c0421z.a() >= 16) {
                    iArr[1] = c0421z.a(8);
                    iArr[2] = c0421z.a(8);
                    return;
                }
                throw C0309a.a();
            case 9:
                if (EnumC0311c.a(a(c0421z)) == null) {
                    throw C0309a.a();
                }
                return;
            case 10:
                int iA = c0421z.a(4);
                int iA2 = c0421z.a(va.a(ya));
                if (iA == 1) {
                    a(c0421z, sb, iA2);
                    return;
                }
                return;
            default:
                int iA3 = c0421z.a(va.a(ya));
                int i = iArr2[va.ordinal()];
                if (i == 1) {
                    c(c0421z, sb, iA3);
                    return;
                }
                if (i == 2) {
                    a(c0421z, sb, iA3, iArr[0] == 1);
                    return;
                } else if (i == 3) {
                    a(c0421z, sb, iA3, enumC0311c, list, map);
                    return;
                } else {
                    if (i == 4) {
                        b(c0421z, sb, iA3);
                        return;
                    }
                    throw C0309a.a();
                }
        }
    }

    private static void a(C0421z c0421z, StringBuilder sb, int i) throws Exception {
        if (i * 13 <= c0421z.a()) {
            byte[] bArr = new byte[i * 2];
            int i2 = 0;
            while (i > 0) {
                int iA = c0421z.a(13);
                int i3 = (iA % 96) | ((iA / 96) << 8);
                int i4 = i3 + (i3 < 959 ? 41377 : 42657);
                try {
                    if (com.huawei.hms.scankit.util.b.a(bArr, i2)) {
                        int i5 = i2 + 1;
                        if (com.huawei.hms.scankit.util.b.a(bArr, i5)) {
                            bArr[i2] = (byte) ((i4 >> 8) & 255);
                            bArr[i5] = (byte) (i4 & 255);
                            i2 += 2;
                            i--;
                        }
                    }
                    throw new ArrayIndexOutOfBoundsException();
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw e;
                }
            }
            try {
                sb.append(new String(bArr, "GB2312"));
                return;
            } catch (UnsupportedEncodingException unused) {
                throw C0309a.a();
            }
        }
        throw C0309a.a();
    }

    private static void a(C0421z c0421z, StringBuilder sb, int i, EnumC0311c enumC0311c, Collection<byte[]> collection, Map<EnumC0312d, ?> map) throws C0309a {
        String strName;
        if (i * 8 <= c0421z.a()) {
            byte[] bArr = new byte[i];
            for (int i2 = 0; i2 < i; i2++) {
                bArr[i2] = (byte) c0421z.a(8);
            }
            if (enumC0311c == null) {
                strName = com.huawei.hms.scankit.aiscan.common.B.a(bArr, map);
            } else {
                strName = enumC0311c.name();
            }
            try {
                sb.append(new String(bArr, strName));
                collection.add(bArr);
                return;
            } catch (UnsupportedEncodingException unused) {
                throw C0309a.a();
            }
        }
        throw C0309a.a();
    }

    private static char a(int i) throws C0309a {
        char[] cArr = a;
        if (i < cArr.length) {
            return cArr[i];
        }
        throw C0309a.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.huawei.hms.scankit.p.C0421z r3, java.lang.StringBuilder r4, int r5, boolean r6) throws java.lang.Exception {
        /*
            int r0 = r4.length()
        L4:
            r1 = 1
            if (r5 <= r1) goto L2d
            int r1 = r3.a()
            r2 = 11
            if (r1 < r2) goto L28
            int r1 = r3.a(r2)
            int r2 = r1 / 45
            char r2 = a(r2)
            r4.append(r2)
            int r1 = r1 % 45
            char r1 = a(r1)
            r4.append(r1)
            int r5 = r5 + (-2)
            goto L4
        L28:
            com.huawei.hms.scankit.aiscan.common.a r3 = com.huawei.hms.scankit.aiscan.common.C0309a.a()
            throw r3
        L2d:
            if (r5 != r1) goto L47
            int r5 = r3.a()
            r2 = 6
            if (r5 < r2) goto L42
            int r3 = r3.a(r2)
            char r3 = a(r3)
            r4.append(r3)
            goto L47
        L42:
            com.huawei.hms.scankit.aiscan.common.a r3 = com.huawei.hms.scankit.aiscan.common.C0309a.a()
            throw r3
        L47:
            if (r6 == 0) goto L72
        L49:
            int r3 = r4.length()
            if (r0 >= r3) goto L72
            char r3 = r4.charAt(r0)
            r5 = 37
            if (r3 != r5) goto L6f
            int r3 = r4.length()
            int r3 = r3 - r1
            if (r0 >= r3) goto L6a
            int r3 = r0 + 1
            char r6 = r4.charAt(r3)
            if (r6 != r5) goto L6a
            r4.deleteCharAt(r3)
            goto L6f
        L6a:
            r3 = 29
            r4.setCharAt(r0, r3)
        L6f:
            int r0 = r0 + 1
            goto L49
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.Ma.a(com.huawei.hms.scankit.p.z, java.lang.StringBuilder, int, boolean):void");
    }

    private static int a(C0421z c0421z) throws Exception {
        int iA = c0421z.a(8);
        if ((iA & 128) == 0) {
            return iA & 127;
        }
        if ((iA & 192) == 128) {
            return c0421z.a(8) | ((iA & 63) << 8);
        }
        if ((iA & 224) == 192) {
            return c0421z.a(16) | ((iA & 31) << 16);
        }
        throw C0309a.a();
    }
}
