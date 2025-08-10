package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0309a;
import com.huawei.hms.scankit.aiscan.common.EnumC0312d;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: Detector.java */
/* renamed from: com.huawei.hms.scankit.p.oa, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0379oa {
    private static final int[] a = {0, 4, 1, 5};
    private static final int[] b = {6, 2, 7, 3};
    private static final int[] c = {8, 1, 1, 1, 1, 1, 1, 3};
    private static final int[] d = {7, 1, 1, 3, 1, 1, 1, 2, 1};
    private static boolean e = false;

    public static C0402ua a(C0409w c0409w, Map<EnumC0312d, ?> map, boolean z) throws C0309a {
        C0417y c0417yB = c0409w.b();
        a(false);
        List<com.huawei.hms.scankit.aiscan.common.z[]> listA = a(z, c0417yB);
        if (listA.isEmpty()) {
            c0417yB = c0417yB.m79clone();
            c0417yB.e();
            listA = a(z, c0417yB);
            a(true);
        }
        return new C0402ua(c0417yB, listA);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r5 != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        r4 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
    
        if (r4.hasNext() == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
    
        r5 = (com.huawei.hms.scankit.aiscan.common.z[]) r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        if (r5[1] == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
    
        r3 = (int) java.lang.Math.max(r3, r5[1].c());
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
    
        if (r5[3] == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
    
        r3 = java.lang.Math.max(r3, (int) r5[3].c());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<com.huawei.hms.scankit.aiscan.common.z[]> a(boolean r8, com.huawei.hms.scankit.p.C0417y r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 1
            r2 = 0
            r3 = 0
        L8:
            r4 = 0
            r5 = 0
        La:
            int r6 = r9.b()
            if (r3 >= r6) goto L7e
            com.huawei.hms.scankit.aiscan.common.z[] r4 = a(r9, r3, r4)
            r6 = r4[r2]
            if (r6 != 0) goto L53
            r6 = 3
            r7 = r4[r6]
            if (r7 != 0) goto L53
            if (r5 != 0) goto L20
            goto L7e
        L20:
            java.util.Iterator r4 = r0.iterator()
        L24:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L50
            java.lang.Object r5 = r4.next()
            com.huawei.hms.scankit.aiscan.common.z[] r5 = (com.huawei.hms.scankit.aiscan.common.z[]) r5
            r7 = r5[r1]
            if (r7 == 0) goto L40
            float r3 = (float) r3
            r7 = r5[r1]
            float r7 = r7.c()
            float r3 = java.lang.Math.max(r3, r7)
            int r3 = (int) r3
        L40:
            r7 = r5[r6]
            if (r7 == 0) goto L24
            r5 = r5[r6]
            float r5 = r5.c()
            int r5 = (int) r5
            int r3 = java.lang.Math.max(r3, r5)
            goto L24
        L50:
            int r3 = r3 + 5
            goto L8
        L53:
            r0.add(r4)
            if (r8 != 0) goto L59
            goto L7e
        L59:
            r3 = 2
            r5 = r4[r3]
            if (r5 == 0) goto L6c
            r5 = r4[r3]
            float r5 = r5.b()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.c()
            goto L7a
        L6c:
            r3 = 4
            r5 = r4[r3]
            float r5 = r5.b()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.c()
        L7a:
            int r3 = (int) r3
            r4 = r5
            r5 = 1
            goto La
        L7e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.C0379oa.a(boolean, com.huawei.hms.scankit.p.y):java.util.List");
    }

    private static com.huawei.hms.scankit.aiscan.common.z[] a(C0417y c0417y, int i, int i2) {
        int iB = c0417y.b();
        int iD = c0417y.d();
        com.huawei.hms.scankit.aiscan.common.z[] zVarArr = new com.huawei.hms.scankit.aiscan.common.z[8];
        a(zVarArr, a(c0417y, iB, iD, i, i2, c), a);
        if (zVarArr[4] != null) {
            i2 = (int) zVarArr[4].b();
            i = (int) zVarArr[4].c();
        }
        a(zVarArr, a(c0417y, iB, iD, i, i2, d), b);
        return zVarArr;
    }

    private static void a(com.huawei.hms.scankit.aiscan.common.z[] zVarArr, com.huawei.hms.scankit.aiscan.common.z[] zVarArr2, int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            zVarArr[iArr[i]] = zVarArr2[i];
        }
    }

    private static com.huawei.hms.scankit.aiscan.common.z[] a(C0417y c0417y, int i, int i2, int i3, int i4, int[] iArr) {
        boolean z;
        int i5;
        int i6;
        int i7;
        com.huawei.hms.scankit.aiscan.common.z[] zVarArr = new com.huawei.hms.scankit.aiscan.common.z[4];
        int[] iArr2 = new int[iArr.length];
        int i8 = i3;
        while (true) {
            if (i8 >= i) {
                z = false;
                break;
            }
            int[] iArrA = a(c0417y, i4, i8, i2, false, iArr, iArr2);
            if (iArrA != null) {
                int i9 = i8;
                int[] iArr3 = iArrA;
                int i10 = i9;
                while (true) {
                    if (i10 <= 0) {
                        i7 = i10;
                        break;
                    }
                    int i11 = i10 - 1;
                    int[] iArrA2 = a(c0417y, i4, i11, i2, false, iArr, iArr2);
                    if (iArrA2 == null) {
                        i7 = i11 + 1;
                        break;
                    }
                    iArr3 = iArrA2;
                    i10 = i11;
                }
                float f = i7;
                zVarArr[0] = new com.huawei.hms.scankit.aiscan.common.z(iArr3[0], f);
                zVarArr[1] = new com.huawei.hms.scankit.aiscan.common.z(iArr3[1], f);
                i8 = i7;
                z = true;
            } else {
                i8 += 5;
            }
        }
        int i12 = i8 + 1;
        if (z) {
            int[] iArr4 = {(int) zVarArr[0].b(), (int) zVarArr[1].b()};
            int i13 = i12;
            int i14 = 0;
            while (true) {
                if (i13 >= i) {
                    i5 = i14;
                    i6 = i13;
                    break;
                }
                i5 = i14;
                i6 = i13;
                int[] iArrA3 = a(c0417y, iArr4[0], i13, i2, false, iArr, iArr2);
                if (iArrA3 != null && Math.abs(iArr4[0] - iArrA3[0]) < 5 && Math.abs(iArr4[1] - iArrA3[1]) < 5) {
                    iArr4 = iArrA3;
                    i14 = 0;
                } else {
                    if (i5 > 25) {
                        break;
                    }
                    i14 = i5 + 1;
                }
                i13 = i6 + 1;
            }
            i12 = i6 - (i5 + 1);
            float f2 = i12;
            zVarArr[2] = new com.huawei.hms.scankit.aiscan.common.z(iArr4[0], f2);
            zVarArr[3] = new com.huawei.hms.scankit.aiscan.common.z(iArr4[1], f2);
        }
        if (i12 - i8 < 10) {
            Arrays.fill(zVarArr, (Object) null);
        }
        return zVarArr;
    }

    private static int[] a(C0417y c0417y, int i, int i2, int i3, boolean z, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i4 = 0;
        while (c0417y.b(i, i2) && i > 0) {
            int i5 = i4 + 1;
            if (i4 >= 3) {
                break;
            }
            i--;
            i4 = i5;
        }
        int length = iArr.length;
        boolean z2 = z;
        int i6 = 0;
        int i7 = i;
        while (i < i3) {
            if (c0417y.b(i, i2) != z2) {
                iArr2[i6] = iArr2[i6] + 1;
            } else {
                if (i6 != length - 1) {
                    i6++;
                } else {
                    if (a(iArr2, iArr, 0.8f) < 0.42f) {
                        return new int[]{i7, i};
                    }
                    i7 += iArr2[0] + iArr2[1];
                    int i8 = i6 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i8);
                    iArr2[i8] = 0;
                    iArr2[i6] = 0;
                    i6--;
                }
                iArr2[i6] = 1;
                z2 = !z2;
            }
            i++;
        }
        if (i6 != length - 1 || a(iArr2, iArr, 0.8f) >= 0.42f) {
            return null;
        }
        return new int[]{i7, i - 1};
    }

    private static float a(int[] iArr, int[] iArr2, float f) {
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

    public static void a(boolean z) {
        e = z;
    }

    public static boolean a() {
        return e;
    }
}
