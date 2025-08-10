package com.huawei.hms.scankit.p;

/* compiled from: MaskUtil.java */
/* loaded from: classes3.dex */
public final class Mc {
    public static int a(Ic ic) {
        return a(ic, true) + a(ic, false);
    }

    public static int b(Ic ic) {
        byte[][] bArrA = ic.a();
        int iC = ic.c();
        int iB = ic.b();
        int i = 0;
        for (int i2 = 0; i2 < iB - 1; i2++) {
            byte[] bArr = bArrA[i2];
            int i3 = 0;
            while (i3 < iC - 1) {
                byte b = bArr[i3];
                int i4 = i3 + 1;
                if (b == bArr[i4]) {
                    int i5 = i2 + 1;
                    if (b == bArrA[i5][i3] && b == bArrA[i5][i4]) {
                        i++;
                    }
                }
                i3 = i4;
            }
        }
        return i * 3;
    }

    public static int c(Ic ic) {
        byte[][] bArrA = ic.a();
        int iC = ic.c();
        int iB = ic.b();
        int i = 0;
        for (int i2 = 0; i2 < iB; i2++) {
            for (int i3 = 0; i3 < iC; i3++) {
                byte[] bArr = bArrA[i2];
                int i4 = i3 + 6;
                if (i4 < iC && bArr[i3] == 1 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 1 && bArr[i3 + 3] == 1 && bArr[i3 + 4] == 1 && bArr[i3 + 5] == 0 && bArr[i4] == 1 && (a(bArr, i3 - 4, i3) || a(bArr, i3 + 7, i3 + 11))) {
                    i++;
                }
                int i5 = i2 + 6;
                if (i5 < iB && bArrA[i2][i3] == 1 && bArrA[i2 + 1][i3] == 0 && bArrA[i2 + 2][i3] == 1 && bArrA[i2 + 3][i3] == 1 && bArrA[i2 + 4][i3] == 1 && bArrA[i2 + 5][i3] == 0 && bArrA[i5][i3] == 1 && (a(bArrA, i3, i2 - 4, i2) || a(bArrA, i3, i2 + 7, i2 + 11))) {
                    i++;
                }
            }
        }
        return i * 40;
    }

    public static int d(Ic ic) {
        byte[][] bArrA = ic.a();
        int iC = ic.c();
        int iB = ic.b();
        int i = 0;
        for (int i2 = 0; i2 < iB; i2++) {
            byte[] bArr = bArrA[i2];
            for (int i3 = 0; i3 < iC; i3++) {
                if (bArr[i3] == 1) {
                    i++;
                }
            }
        }
        int iB2 = ic.b() * ic.c();
        return ((Math.abs((i * 2) - iB2) * 10) / iB2) * 10;
    }

    private static boolean a(byte[] bArr, int i, int i2) {
        int iMin = Math.min(i2, bArr.length);
        for (int iMax = Math.max(i, 0); iMax < iMin; iMax++) {
            if (bArr[iMax] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(byte[][] bArr, int i, int i2, int i3) {
        int iMin = Math.min(i3, bArr.length);
        for (int iMax = Math.max(i2, 0); iMax < iMin; iMax++) {
            if (iMax < bArr.length && i < bArr[0].length && bArr[iMax][i] == 1) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(int r1, int r2, int r3) throws java.lang.Exception {
        /*
            r0 = 1
            switch(r1) {
                case 0: goto L2d;
                case 1: goto L2e;
                case 2: goto L2a;
                case 3: goto L26;
                case 4: goto L21;
                case 5: goto L19;
                case 6: goto L10;
                case 7: goto L7;
                default: goto L4;
            }
        L4:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch: java.lang.Exception -> L4a
            goto L35
        L7:
            int r1 = r3 * r2
            int r1 = r1 % 3
            int r3 = r3 + r2
            r2 = r3 & 1
            int r1 = r1 + r2
            goto L17
        L10:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
        L17:
            r1 = r1 & r0
            goto L30
        L19:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L30
        L21:
            int r3 = r3 / 2
            int r2 = r2 / 3
            goto L2d
        L26:
            int r3 = r3 + r2
            int r1 = r3 % 3
            goto L30
        L2a:
            int r1 = r2 % 3
            goto L30
        L2d:
            int r3 = r3 + r2
        L2e:
            r1 = r3 & 1
        L30:
            if (r1 != 0) goto L33
            goto L34
        L33:
            r0 = 0
        L34:
            return r0
        L35:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L4a
            r3.<init>()     // Catch: java.lang.Exception -> L4a
            java.lang.String r0 = "Invalid mask pattern: "
            r3.append(r0)     // Catch: java.lang.Exception -> L4a
            r3.append(r1)     // Catch: java.lang.Exception -> L4a
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Exception -> L4a
            r2.<init>(r1)     // Catch: java.lang.Exception -> L4a
            throw r2     // Catch: java.lang.Exception -> L4a
        L4a:
            r1 = move-exception
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.Mc.a(int, int, int):boolean");
    }

    private static int a(Ic ic, boolean z) {
        int iB = z ? ic.b() : ic.c();
        int iC = z ? ic.c() : ic.b();
        byte[][] bArrA = ic.a();
        int i = 0;
        for (int i2 = 0; i2 < iB; i2++) {
            byte b = -1;
            int i3 = 0;
            for (int i4 = 0; i4 < iC; i4++) {
                byte b2 = z ? bArrA[i2][i4] : bArrA[i4][i2];
                if (b2 == b) {
                    i3++;
                } else {
                    if (i3 >= 5) {
                        i += (i3 - 5) + 3;
                    }
                    b = b2;
                    i3 = 1;
                }
            }
            if (i3 >= 5) {
                i += (i3 - 5) + 3;
            }
        }
        return i;
    }
}
