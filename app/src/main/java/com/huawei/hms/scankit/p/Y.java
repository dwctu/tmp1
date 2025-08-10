package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0309a;
import com.huawei.hms.scankit.aiscan.common.EnumC0312d;
import java.util.Arrays;
import java.util.Map;

/* compiled from: OneDReader.java */
/* loaded from: classes3.dex */
public abstract class Y implements com.huawei.hms.scankit.aiscan.common.t {
    private com.huawei.hms.scankit.aiscan.common.x b(C0409w c0409w, Map<EnumC0312d, ?> map) throws C0309a {
        int iE = c0409w.e();
        int iC = c0409w.c();
        C0413x c0413x = new C0413x(iE);
        int iMax = Math.max(1, iC >> 5);
        int iIntValue = iC / 2;
        if (map != null) {
            EnumC0312d enumC0312d = EnumC0312d.PHOTO_MODE_NUM;
            if (map.containsKey(enumC0312d)) {
                iIntValue += (((Integer) map.get(enumC0312d)).intValue() * iMax) / 3;
            }
        }
        int i = iIntValue;
        int i2 = 0;
        while (i2 < 15) {
            int i3 = i2 + 1;
            int i4 = i3 / 2;
            if (!((i2 & 1) == 0)) {
                i4 = -i4;
            }
            int i5 = i + (i4 * iMax);
            if (i5 < 0 || i5 >= iC) {
                break;
            }
            com.huawei.hms.scankit.aiscan.common.x xVarA = a(c0409w, c0413x, map, i5, iE);
            if (xVarA != null && xVarA.i() != null) {
                return xVarA;
            }
            i2 = i3;
        }
        throw C0309a.a();
    }

    public abstract com.huawei.hms.scankit.aiscan.common.x a(int i, C0413x c0413x, Map<EnumC0312d, ?> map) throws C0309a;

    @Override // com.huawei.hms.scankit.aiscan.common.t
    public com.huawei.hms.scankit.aiscan.common.x a(C0409w c0409w, Map<EnumC0312d, ?> map) throws C0309a {
        return b(c0409w, map);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0048 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.scankit.aiscan.common.x a(com.huawei.hms.scankit.p.C0409w r10, com.huawei.hms.scankit.p.C0413x r11, java.util.Map<com.huawei.hms.scankit.aiscan.common.EnumC0312d, ?> r12, int r13, int r14) throws com.huawei.hms.scankit.aiscan.common.C0309a {
        /*
            r9 = this;
            r0 = 0
        L1:
            r1 = 3
            if (r0 >= r1) goto L4b
            r2 = 1
            if (r0 != 0) goto Lc
            com.huawei.hms.scankit.p.x r11 = r10.a(r13, r11)     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L48
            goto L24
        Lc:
            if (r0 != r2) goto L18
            com.huawei.hms.scankit.p.y r1 = r10.b()
            com.huawei.hms.scankit.p.x r11 = r1.a(r13, r11)
            r1 = 1
            goto L24
        L18:
            r3 = 2
            if (r0 != r3) goto L24
            boolean r3 = com.huawei.hms.scankit.p._a.o
            if (r3 != 0) goto L20
            goto L48
        L20:
            com.huawei.hms.scankit.p.x r11 = r10.a(r13, r2)
        L24:
            int[] r3 = r11.c()
            boolean r3 = a(r3)
            if (r3 != 0) goto L2f
            goto L48
        L2f:
            boolean r3 = com.huawei.hms.scankit.p._a.c
            if (r3 != 0) goto L35
            r5 = 1
            goto L36
        L35:
            r5 = r1
        L36:
            r3 = r9
            r4 = r11
            r6 = r12
            r7 = r13
            r8 = r14
            com.huawei.hms.scankit.aiscan.common.x r1 = r3.a(r4, r5, r6, r7, r8)
            if (r1 == 0) goto L48
            java.lang.String r2 = r1.i()
            if (r2 == 0) goto L48
            return r1
        L48:
            int r0 = r0 + 1
            goto L1
        L4b:
            r10 = 0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.Y.a(com.huawei.hms.scankit.p.w, com.huawei.hms.scankit.p.x, java.util.Map, int, int):com.huawei.hms.scankit.aiscan.common.x");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.scankit.aiscan.common.x a(com.huawei.hms.scankit.p.C0413x r19, int r20, java.util.Map<com.huawei.hms.scankit.aiscan.common.EnumC0312d, ?> r21, int r22, int r23) {
        /*
            r18 = this;
            r0 = r23
            r1 = 0
            r3 = r20
            r2 = r21
            r4 = 0
        L8:
            if (r4 >= r3) goto La3
            if (r4 != 0) goto Lf
            r19.b()
        Lf:
            r5 = 1
            if (r4 != r5) goto L15
            r19.h()
        L15:
            r6 = 2
            if (r4 != r6) goto L1e
            r19.f()
            r19.i()
        L1e:
            r7 = 0
        L1f:
            if (r7 >= r6) goto L99
            if (r7 != r5) goto L45
            r19.g()
            if (r2 == 0) goto L45
            com.huawei.hms.scankit.aiscan.common.d r8 = com.huawei.hms.scankit.aiscan.common.EnumC0312d.NEED_RESULT_POINT_CALLBACK
            boolean r9 = r2.containsKey(r8)
            if (r9 == 0) goto L45
            java.util.EnumMap r9 = new java.util.EnumMap
            java.lang.Class<com.huawei.hms.scankit.aiscan.common.d> r10 = com.huawei.hms.scankit.aiscan.common.EnumC0312d.class
            r9.<init>(r10)
            r9.putAll(r2)
            r9.remove(r8)
            r8 = r18
            r10 = r22
            r2 = r9
            r9 = r19
            goto L4b
        L45:
            r8 = r18
            r9 = r19
            r10 = r22
        L4b:
            com.huawei.hms.scankit.aiscan.common.x r11 = r8.a(r10, r9, r2)     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8f
            if (r7 != r5) goto L87
            com.huawei.hms.scankit.aiscan.common.z[] r12 = r11.h()     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8f
            if (r12 == 0) goto L87
            com.huawei.hms.scankit.aiscan.common.z r13 = new com.huawei.hms.scankit.aiscan.common.z     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8f
            float r14 = (float) r0     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8f
            r15 = r12[r1]     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8f
            float r15 = r15.b()     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8f
            float r15 = r14 - r15
            r16 = 1065353216(0x3f800000, float:1.0)
            float r15 = r15 - r16
            r17 = r12[r1]     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8f
            float r6 = r17.c()     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8f
            r13.<init>(r15, r6)     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8f
            r12[r1] = r13     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8f
            com.huawei.hms.scankit.aiscan.common.z r6 = new com.huawei.hms.scankit.aiscan.common.z     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8f
            r13 = r12[r5]     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8f
            float r13 = r13.b()     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8f
            float r14 = r14 - r13
            float r14 = r14 - r16
            r13 = r12[r5]     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8f
            float r13 = r13.c()     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8f
            r6.<init>(r14, r13)     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8f
            r12[r5] = r6     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8f
        L87:
            boolean r6 = a(r11, r0)     // Catch: com.huawei.hms.scankit.aiscan.common.C0309a -> L8f
            if (r6 != 0) goto L8e
            goto L95
        L8e:
            return r11
        L8f:
            if (r7 != r5) goto L95
            r19.g()
        L95:
            int r7 = r7 + 1
            r6 = 2
            goto L1f
        L99:
            r8 = r18
            r9 = r19
            r10 = r22
            int r4 = r4 + 1
            goto L8
        La3:
            r8 = r18
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.Y.a(com.huawei.hms.scankit.p.x, int, java.util.Map, int, int):com.huawei.hms.scankit.aiscan.common.x");
    }

    private static boolean a(int[] iArr) {
        int iBitCount = 0;
        int i = 0;
        for (int i2 = 0; i2 < iArr.length && iBitCount < 20; i2++) {
            iBitCount += Integer.bitCount((i | (iArr[i2] << 1)) ^ iArr[i2]);
            i = (iArr[i2] >> 31) & 1;
        }
        return iBitCount >= 20;
    }

    private static boolean a(com.huawei.hms.scankit.aiscan.common.x xVar, int i) {
        com.huawei.hms.scankit.aiscan.common.z[] zVarArrH = xVar.h();
        return Math.abs(((double) zVarArrH[1].b()) - ((double) zVarArrH[0].b())) / ((double) i) > 0.4d;
    }

    public static void a(C0413x c0413x, int i, int[] iArr) throws C0309a {
        int length = iArr.length;
        Arrays.fill(iArr, 0, length, 0);
        int iD = c0413x.d();
        if (i < iD) {
            boolean z = !c0413x.a(i);
            int i2 = 0;
            while (i < iD) {
                if (c0413x.a(i) == z) {
                    i2++;
                    if (i2 == length) {
                        break;
                    }
                    if (i2 >= 0 && i2 < iArr.length) {
                        iArr[i2] = 1;
                        z = !z;
                    } else {
                        throw C0309a.a();
                    }
                } else if (i2 >= 0 && i2 < iArr.length) {
                    iArr[i2] = iArr[i2] + 1;
                } else {
                    throw C0309a.a();
                }
                i++;
            }
            if (i2 != length) {
                if (i2 != length - 1 || i != iD) {
                    throw C0309a.a();
                }
                return;
            }
            return;
        }
        throw C0309a.a();
    }

    public static float a(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i;
        float f3 = f2 / i2;
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            float f6 = iArr2[i4] * f3;
            float f7 = iArr[i4];
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }
}
