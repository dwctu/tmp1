package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0309a;

/* compiled from: HybridBinarizer.java */
/* loaded from: classes3.dex */
public final class B extends A {
    private static int f = 3;
    private static int g = 0;
    private static int h = 0;
    private static int i = 0;
    private static int j = 24;
    private C0417y k;

    static {
        int i2 = 1 << f;
        g = i2;
        h = i2 - 1;
        i = i2 * 5;
    }

    public B(com.huawei.hms.scankit.aiscan.common.m mVar) {
        super(mVar);
        a(_a.i);
    }

    private static int a(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    private void a(boolean z) {
        if (z) {
            f = 2;
            int i2 = 1 << 2;
            g = i2;
            h = i2 - 1;
            i = i2 * 5;
            return;
        }
        f = 3;
        int i3 = 1 << 3;
        g = i3;
        h = i3 - 1;
        i = i3 * 5;
    }

    @Override // com.huawei.hms.scankit.p.A, com.huawei.hms.scankit.p.AbstractC0405v
    public C0417y a() throws C0309a {
        C0417y c0417y = this.k;
        if (c0417y != null) {
            return c0417y;
        }
        com.huawei.hms.scankit.aiscan.common.m mVarC = c();
        int iC = mVarC.c();
        int iA = mVarC.a();
        int i2 = i;
        if (iC >= i2 && iA >= i2) {
            byte[] bArrB = mVarC.b();
            int i3 = f;
            int i4 = iC >> i3;
            int i5 = h;
            if ((iC & i5) != 0) {
                i4++;
            }
            int i6 = iA >> i3;
            if ((i5 & iA) != 0) {
                i6++;
            }
            int i7 = i6;
            this.k = a(bArrB, i4, i7, iC, iA, a(bArrB, i4, i7, iC, iA));
        } else {
            this.k = super.a();
        }
        return this.k;
    }

    @Override // com.huawei.hms.scankit.p.A, com.huawei.hms.scankit.p.AbstractC0405v
    public AbstractC0405v a(com.huawei.hms.scankit.aiscan.common.m mVar) {
        return new B(mVar);
    }

    private static C0417y a(byte[] bArr, int i2, int i3, int i4, int i5, int[][] iArr) {
        int i6;
        int i7;
        int i8;
        int[] iArr2 = new int[i2 * i3];
        for (int i9 = 0; i9 < i3; i9++) {
            int iA = a(i9, 2, i3 - 3);
            for (int i10 = 0; i10 < i2; i10++) {
                int iA2 = a(i10, 2, i2 - 3);
                int i11 = iA + 2;
                int i12 = iA2 + 2;
                int i13 = iArr[i11][i12];
                if (iA == 2 && iA2 == 2) {
                    i8 = 0;
                } else if (iA == 2) {
                    i7 = iArr[i11][iA2 - 3];
                    i8 = 0;
                    i6 = 0;
                    iArr2[(i9 * i2) + i10] = (((i13 + i6) - i8) - i7) / 25;
                } else if (iA2 == 2) {
                    i8 = iArr[iA - 3][i12];
                } else {
                    int i14 = iA - 3;
                    int i15 = iA2 - 3;
                    i6 = iArr[i14][i15];
                    int i16 = iArr[i14][i12];
                    i7 = iArr[i11][i15];
                    i8 = i16;
                    iArr2[(i9 * i2) + i10] = (((i13 + i6) - i8) - i7) / 25;
                }
                i7 = 0;
                i6 = 0;
                iArr2[(i9 * i2) + i10] = (((i13 + i6) - i8) - i7) / 25;
            }
        }
        return new C0417y(i4, i5, (i4 + 31) / 32, a(bArr, iArr2, i2, i3, i4, i5));
    }

    private static int[] a(byte[] bArr, int[] iArr, int i2, int i3, int i4, int i5) {
        int i6;
        int i7 = (i4 + 31) / 32;
        int i8 = i7 * i5;
        int[] iArr2 = new int[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            iArr2[i9] = 0;
        }
        int i10 = g;
        for (int i11 = 0; i11 < i5; i11++) {
            int i12 = i11 / i10;
            for (int i13 = 0; i13 < i4; i13++) {
                if ((bArr[(i11 * i4) + i13] & 255) <= iArr[(i12 * i2) + (i13 / i10)] && (i6 = (i11 * i7) + (i13 / 32)) < i8) {
                    iArr2[i6] = iArr2[i6] | (1 << (i13 & 31));
                }
            }
        }
        return iArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0075 A[PHI: r16
  0x0075: PHI (r16v2 int) = (r16v1 int), (r16v3 int), (r16v3 int), (r16v3 int) binds: [B:13:0x0053, B:15:0x0057, B:16:0x0059, B:18:0x0072] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int[][] a(byte[] r20, int r21, int r22, int r23, int r24) {
        /*
            r0 = r21
            r1 = r22
            r2 = r23
            java.lang.Class<int> r3 = int.class
            int r4 = com.huawei.hms.scankit.p.B.g
            int r5 = r24 - r4
            int r4 = r2 - r4
            r6 = 2
            int[] r7 = new int[r6]
            r8 = 1
            r7[r8] = r0
            r9 = 0
            r7[r9] = r1
            java.lang.Object r7 = java.lang.reflect.Array.newInstance(r3, r7)
            int[][] r7 = (int[][]) r7
            int[] r10 = new int[r6]
            r10[r8] = r0
            r10[r9] = r1
            java.lang.Object r3 = java.lang.reflect.Array.newInstance(r3, r10)
            int[][] r3 = (int[][]) r3
            r10 = 0
        L2a:
            if (r10 >= r1) goto La3
            int r11 = com.huawei.hms.scankit.p.B.f
            int r11 = r10 << r11
            if (r11 <= r5) goto L33
            r11 = r5
        L33:
            r12 = 0
            r13 = 0
        L35:
            if (r12 >= r0) goto L9c
            int r14 = com.huawei.hms.scankit.p.B.f
            int r14 = r12 << r14
            r15 = r20
            if (r14 <= r4) goto L40
            r14 = r4
        L40:
            int[] r14 = a(r14, r11, r2, r15)
            r16 = r14[r9]
            r9 = r14[r8]
            r14 = r14[r6]
            int r17 = com.huawei.hms.scankit.p.B.f
            int r17 = r17 * 2
            int r16 = r16 >> r17
            int r14 = r14 - r9
            int r8 = com.huawei.hms.scankit.p.B.j
            if (r14 > r8) goto L75
            int r16 = r9 / 2
            if (r10 <= 0) goto L75
            if (r12 <= 0) goto L75
            int r8 = r10 + (-1)
            r14 = r3[r8]
            r14 = r14[r12]
            r18 = r3[r10]
            int r19 = r12 + (-1)
            r18 = r18[r19]
            int r18 = r18 * 2
            int r14 = r14 + r18
            r8 = r3[r8]
            r8 = r8[r19]
            int r14 = r14 + r8
            int r14 = r14 / 4
            if (r9 >= r14) goto L75
            goto L77
        L75:
            r14 = r16
        L77:
            int r13 = r13 + r14
            r8 = r3[r10]
            r8[r12] = r14
            if (r10 != 0) goto L85
            if (r12 != 0) goto L85
            r8 = r7[r10]
            r8[r12] = r14
            goto L97
        L85:
            if (r10 != 0) goto L8c
            r8 = r7[r10]
            r8[r12] = r13
            goto L97
        L8c:
            r8 = r7[r10]
            int r9 = r10 + (-1)
            r9 = r7[r9]
            r9 = r9[r12]
            int r9 = r9 + r13
            r8[r12] = r9
        L97:
            int r12 = r12 + 1
            r8 = 1
            r9 = 0
            goto L35
        L9c:
            r15 = r20
            int r10 = r10 + 1
            r8 = 1
            r9 = 0
            goto L2a
        La3:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.B.a(byte[], int, int, int, int):int[][]");
    }

    private static int[] a(int i2, int i3, int i4, byte[] bArr) {
        int i5 = (i3 * i4) + i2;
        int i6 = 0;
        int i7 = 0;
        int i8 = 255;
        int i9 = 0;
        while (i6 < g) {
            for (int i10 = 0; i10 < g; i10++) {
                int i11 = bArr[i5 + i10] & 255;
                i7 += i11;
                if (i11 < i8) {
                    i8 = i11;
                }
                if (i11 > i9) {
                    i9 = i11;
                }
            }
            if (i9 - i8 > j) {
                while (true) {
                    i6++;
                    i5 += i4;
                    if (i6 < g) {
                        for (int i12 = 0; i12 < g; i12++) {
                            i7 += bArr[i5 + i12] & 255;
                        }
                    }
                }
            }
            i6++;
            i5 += i4;
        }
        return new int[]{i7, i8, i9};
    }
}
