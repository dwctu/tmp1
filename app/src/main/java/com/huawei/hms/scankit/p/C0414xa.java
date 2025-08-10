package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0309a;
import com.huawei.hms.scankit.aiscan.common.C0313e;
import com.huawei.hms.scankit.aiscan.common.EnumC0312d;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: PDF417ScanningDecoder.java */
/* renamed from: com.huawei.hms.scankit.p.xa, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0414xa {
    private static final C0383pa a = new C0383pa();

    public static C0313e a(C0417y c0417y, com.huawei.hms.scankit.aiscan.common.z zVar, com.huawei.hms.scankit.aiscan.common.z zVar2, com.huawei.hms.scankit.aiscan.common.z zVar3, com.huawei.hms.scankit.aiscan.common.z zVar4, int i, int i2, Map<EnumC0312d, ?> map) throws C0309a {
        C0367la c0367laB;
        C0375na c0375naA = null;
        C0375na c0375naA2 = null;
        C0351ha c0351ha = new C0351ha(c0417y, zVar, zVar2, zVar3, zVar4);
        boolean z = true;
        while (true) {
            if (zVar != null) {
                c0375naA = a(c0417y, c0351ha, zVar, true, i, i2);
            }
            if (zVar3 != null) {
                c0375naA2 = a(c0417y, c0351ha, zVar3, false, i, i2);
            }
            c0367laB = b(c0375naA, c0375naA2);
            if (c0367laB == null) {
                throw C0309a.a();
            }
            C0351ha c0351haD = c0367laB.d();
            if (!z || c0351haD == null || (c0351haD.f() >= c0351ha.f() && c0351haD.d() <= c0351ha.d())) {
                break;
            }
            c0351ha = c0351haD;
            z = false;
        }
        c0367laB.a(c0351ha);
        int iA = c0367laB.a() + 1;
        c0367laB.a(0, c0375naA);
        c0367laB.a(iA, c0375naA2);
        a(c0367laB, c0375naA, c0351ha, iA, c0417y, i, i2);
        return a(c0367laB, map);
    }

    private static boolean a(int i, int i2, int i3) {
        return i2 + (-2) <= i && i <= i3 + 2;
    }

    private static C0367la b(C0375na c0375na, C0375na c0375na2) throws C0309a {
        C0343fa c0343faA;
        if ((c0375na == null && c0375na2 == null) || (c0343faA = a(c0375na, c0375na2)) == null) {
            return null;
        }
        return new C0367la(c0343faA, C0351ha.a(a(c0375na), a(c0375na2)));
    }

    private static int c(int i) {
        return 2 << i;
    }

    private static int b(int[] iArr) {
        int iMax = -1;
        for (int i : iArr) {
            iMax = Math.max(iMax, i);
        }
        return iMax;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int[] b(com.huawei.hms.scankit.p.C0417y r8, int r9, int r10, boolean r11, int r12, int r13) {
        /*
            r0 = 8
            int[] r1 = new int[r0]
            r2 = 1
            if (r11 == 0) goto L9
            r3 = 1
            goto La
        L9:
            r3 = -1
        La:
            r4 = 0
            r6 = r11
            r5 = 0
        Ld:
            if (r11 == 0) goto L12
            if (r12 >= r10) goto L2b
            goto L14
        L12:
            if (r12 < r9) goto L2b
        L14:
            if (r5 >= r0) goto L2b
            boolean r7 = r8.b(r12, r13)
            if (r7 != r6) goto L23
            r7 = r1[r5]
            int r7 = r7 + r2
            r1[r5] = r7
            int r12 = r12 + r3
            goto Ld
        L23:
            int r5 = r5 + 1
            if (r6 != 0) goto L29
            r6 = 1
            goto Ld
        L29:
            r6 = 0
            goto Ld
        L2b:
            if (r5 == r0) goto L38
            if (r11 == 0) goto L30
            r9 = r10
        L30:
            if (r12 != r9) goto L36
            r8 = 7
            if (r5 != r8) goto L36
            goto L38
        L36:
            r8 = 0
            return r8
        L38:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.C0414xa.b(com.huawei.hms.scankit.p.y, int, int, boolean, int, int):int[]");
    }

    private static int b(int i) {
        return a(a(i));
    }

    private static void a(C0367la c0367la, C0375na c0375na, C0351ha c0351ha, int i, C0417y c0417y, int i2, int i3) {
        C0371ma c0375na2;
        int i4;
        int i5;
        int i6;
        int i7;
        C0371ma c0371ma;
        boolean z = c0375na != null;
        int i8 = i2;
        int i9 = i3;
        for (int i10 = 1; i10 <= i; i10++) {
            int i11 = z ? i10 : i - i10;
            if (c0367la.a(i11) == null) {
                if (i11 != 0 && i11 != i) {
                    c0375na2 = new C0371ma(c0351ha);
                } else {
                    c0375na2 = new C0375na(c0351ha, i11 == 0);
                }
                C0371ma c0371ma2 = c0375na2;
                c0367la.a(i11, c0371ma2);
                int i12 = -1;
                int i13 = i8;
                int iMax = i9;
                int iF = c0351ha.f();
                int i14 = -1;
                while (iF <= c0351ha.d()) {
                    int iA = a(c0367la, i11, iF, z);
                    if (iA >= 0 && iA <= c0351ha.c()) {
                        i4 = iA;
                    } else if (i14 == i12) {
                        i5 = i14;
                        i6 = iF;
                        i7 = i13;
                        c0371ma = c0371ma2;
                        i13 = i7;
                        i4 = i5;
                        iF = i6 + 1;
                        c0371ma2 = c0371ma;
                        i14 = i4;
                        i12 = -1;
                    } else {
                        i4 = i14;
                    }
                    i5 = i14;
                    int i15 = iF;
                    int i16 = iMax;
                    int i17 = i13;
                    c0371ma = c0371ma2;
                    C0355ia c0355iaA = a(c0417y, c0351ha.e(), c0351ha.c(), z, i4, i15, i17, i16);
                    i6 = i15;
                    if (c0355iaA != null) {
                        c0371ma.a(i6, c0355iaA);
                        int iMin = Math.min(i17, c0355iaA.f());
                        iMax = Math.max(i16, c0355iaA.f());
                        i13 = iMin;
                        iF = i6 + 1;
                        c0371ma2 = c0371ma;
                        i14 = i4;
                        i12 = -1;
                    } else {
                        iMax = i16;
                        i7 = i17;
                        i13 = i7;
                        i4 = i5;
                        iF = i6 + 1;
                        c0371ma2 = c0371ma;
                        i14 = i4;
                        i12 = -1;
                    }
                }
                i8 = i13;
                i9 = iMax;
            }
        }
    }

    private static C0351ha a(C0375na c0375na) throws C0309a {
        int[] iArrD;
        if (c0375na == null || (iArrD = c0375na.d()) == null) {
            return null;
        }
        int iB = b(iArrD);
        int i = 0;
        int i2 = 0;
        for (int i3 : iArrD) {
            i2 += iB - i3;
            if (i3 > 0) {
                break;
            }
        }
        C0355ia[] c0355iaArrB = c0375na.b();
        for (int i4 = 0; i2 > 0 && c0355iaArrB[i4] == null; i4++) {
            i2--;
        }
        for (int length = iArrD.length - 1; length >= 0; length--) {
            i += iB - iArrD[length];
            if (iArrD[length] > 0) {
                break;
            }
        }
        for (int length2 = c0355iaArrB.length - 1; i > 0 && c0355iaArrB[length2] == null; length2--) {
            i--;
        }
        return c0375na.a().a(i2, i, c0375na.e());
    }

    private static C0343fa a(C0375na c0375na, C0375na c0375na2) throws C0309a {
        C0343fa c0343faC;
        C0343fa c0343faC2;
        if (c0375na == null || (c0343faC = c0375na.c()) == null) {
            if (c0375na2 == null) {
                return null;
            }
            return c0375na2.c();
        }
        if (c0375na2 == null || (c0343faC2 = c0375na2.c()) == null || c0343faC.a() == c0343faC2.a() || c0343faC.b() == c0343faC2.b() || c0343faC.c() == c0343faC2.c()) {
            return c0343faC;
        }
        return null;
    }

    private static C0375na a(C0417y c0417y, C0351ha c0351ha, com.huawei.hms.scankit.aiscan.common.z zVar, boolean z, int i, int i2) {
        int iB;
        C0375na c0375na = new C0375na(c0351ha, z);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = i3 == 0 ? 1 : -1;
            int iB2 = (int) zVar.b();
            for (int iC = (int) zVar.c(); iC <= c0351ha.d() && iC >= c0351ha.f(); iC += i4) {
                C0355ia c0355iaA = a(c0417y, 0, c0417y.d(), z, iB2, iC, i, i2);
                if (c0355iaA != null) {
                    c0375na.a(iC, c0355iaA);
                    if (z) {
                        iB = c0355iaA.d();
                    } else {
                        iB = c0355iaA.b();
                    }
                    iB2 = iB;
                }
            }
            i3++;
        }
        return c0375na;
    }

    private static void a(C0367la c0367la, C0347ga[][] c0347gaArr) throws C0309a {
        C0347ga c0347ga = c0347gaArr[0][1];
        int[] iArrA = c0347ga.a();
        int iA = (c0367la.a() * c0367la.c()) - c(c0367la.b());
        if (iArrA.length != 0) {
            if (iArrA[0] != iA) {
                c0347ga.a(iA);
            }
        } else {
            if (iA >= 1 && iA <= 928) {
                c0347ga.a(iA);
                return;
            }
            throw C0309a.a();
        }
    }

    private static C0313e a(C0367la c0367la, Map<EnumC0312d, ?> map) throws C0309a {
        C0347ga[][] c0347gaArrA = a(c0367la);
        a(c0367la, c0347gaArrA);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[c0367la.c() * c0367la.a()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < c0367la.c(); i++) {
            int i2 = 0;
            while (i2 < c0367la.a()) {
                int i3 = i2 + 1;
                int[] iArrA = c0347gaArrA[i][i3].a();
                int iA = (c0367la.a() * i) + i2;
                if (iArrA.length == 0) {
                    arrayList.add(Integer.valueOf(iA));
                } else if (iArrA.length == 1) {
                    iArr[iA] = iArrA[0];
                } else {
                    arrayList3.add(Integer.valueOf(iA));
                    arrayList2.add(iArrA);
                }
                i2 = i3;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size][];
        for (int i4 = 0; i4 < size; i4++) {
            iArr2[i4] = (int[]) arrayList2.get(i4);
        }
        return a(c0367la.b(), iArr, C0398ta.a(arrayList), C0398ta.a(arrayList3), iArr2, map);
    }

    private static C0313e a(int i, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4, Map<EnumC0312d, ?> map) throws C0309a {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i2 = 100;
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0) {
                for (int i4 = 0; i4 < length; i4++) {
                    iArr[iArr3[i4]] = iArr4[i4][iArr5[i4]];
                }
                try {
                    return a(iArr, i, iArr2, map);
                } catch (C0309a unused) {
                    if (length == 0) {
                        throw C0309a.a();
                    }
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        }
                        if (iArr5[i5] < iArr4[i5].length - 1) {
                            iArr5[i5] = iArr5[i5] + 1;
                            break;
                        }
                        iArr5[i5] = 0;
                        if (i5 == length - 1) {
                            throw C0309a.a();
                        }
                        i5++;
                    }
                    i2 = i3;
                }
            } else {
                throw C0309a.a();
            }
        }
    }

    private static C0347ga[][] a(C0367la c0367la) throws C0309a {
        int iC;
        C0347ga[][] c0347gaArr = (C0347ga[][]) Array.newInstance((Class<?>) C0347ga.class, c0367la.c(), c0367la.a() + 2);
        for (int i = 0; i < c0347gaArr.length; i++) {
            for (int i2 = 0; i2 < c0347gaArr[i].length; i2++) {
                c0347gaArr[i][i2] = new C0347ga();
            }
        }
        int i3 = 0;
        for (C0371ma c0371ma : c0367la.e()) {
            if (c0371ma != null) {
                for (C0355ia c0355ia : c0371ma.b()) {
                    if (c0355ia != null && (iC = c0355ia.c()) >= 0 && iC < c0347gaArr.length) {
                        c0347gaArr[iC][i3].a(c0355ia.e());
                    }
                }
            }
            i3++;
        }
        return c0347gaArr;
    }

    private static boolean a(C0367la c0367la, int i) {
        return i >= 0 && i <= c0367la.a() + 1;
    }

    private static int a(C0367la c0367la, int i, int i2, boolean z) {
        int i3 = z ? 1 : -1;
        int i4 = i - i3;
        C0355ia c0355iaA = a(c0367la, i4) ? c0367la.a(i4).a(i2) : null;
        if (c0355iaA != null) {
            return z ? c0355iaA.b() : c0355iaA.d();
        }
        C0355ia c0355iaB = c0367la.a(i).b(i2);
        if (c0355iaB != null) {
            return z ? c0355iaB.d() : c0355iaB.b();
        }
        if (a(c0367la, i4)) {
            c0355iaB = c0367la.a(i4).b(i2);
        }
        if (c0355iaB != null) {
            return z ? c0355iaB.b() : c0355iaB.d();
        }
        int i5 = 0;
        while (true) {
            i -= i3;
            if (!a(c0367la, i)) {
                return z ? c0367la.d().e() : c0367la.d().c();
            }
            for (C0355ia c0355ia : c0367la.a(i).b()) {
                if (c0355ia != null) {
                    return (z ? c0355ia.b() : c0355ia.d()) + (i3 * i5 * (c0355ia.b() - c0355ia.d()));
                }
            }
            i5++;
        }
    }

    private static C0355ia a(C0417y c0417y, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        int i7;
        int iA;
        int iA2;
        int iA3 = a(c0417y, i, i2, z, i3, i4);
        int[] iArrB = b(c0417y, i, i2, z, iA3, i4);
        if (iArrB == null) {
            return null;
        }
        int iA4 = com.huawei.hms.scankit.aiscan.common.n.a(iArrB);
        if (z) {
            i7 = iA3 + iA4;
        } else {
            for (int i8 = 0; i8 < iArrB.length / 2; i8++) {
                int i9 = iArrB[i8];
                iArrB[i8] = iArrB[(iArrB.length - 1) - i8];
                iArrB[(iArrB.length - 1) - i8] = i9;
            }
            iA3 -= iA4;
            i7 = iA3;
        }
        if (a(iA4, i5, i6) && (iA2 = C0398ta.a((iA = C0394sa.a(iArrB)))) != -1) {
            return new C0355ia(iA3, i7, b(iA), iA2);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0022, code lost:
    
        r0 = -r0;
        r8 = !r8;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(com.huawei.hms.scankit.p.C0417y r5, int r6, int r7, boolean r8, int r9, int r10) {
        /*
            if (r8 == 0) goto L4
            r0 = -1
            goto L5
        L4:
            r0 = 1
        L5:
            r1 = 0
            r2 = r9
        L7:
            r3 = 2
            if (r1 >= r3) goto L28
        La:
            if (r8 == 0) goto Lf
            if (r2 < r6) goto L22
            goto L11
        Lf:
            if (r2 >= r7) goto L22
        L11:
            boolean r4 = r5.b(r2, r10)
            if (r8 != r4) goto L22
            int r4 = r9 - r2
            int r4 = java.lang.Math.abs(r4)
            if (r4 <= r3) goto L20
            return r9
        L20:
            int r2 = r2 + r0
            goto La
        L22:
            int r0 = -r0
            r8 = r8 ^ 1
            int r1 = r1 + 1
            goto L7
        L28:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.C0414xa.a(com.huawei.hms.scankit.p.y, int, int, boolean, int, int):int");
    }

    private static C0313e a(int[] iArr, int i, int[] iArr2, Map<EnumC0312d, ?> map) throws C0309a {
        if (iArr.length != 0) {
            int i2 = 1 << (i + 1);
            int iA = a(iArr, iArr2, i2);
            a(iArr, i2);
            C0313e c0313eA = C0363ka.a(iArr, String.valueOf(i), map);
            c0313eA.b(Integer.valueOf(iA));
            c0313eA.a(Integer.valueOf(iArr2.length));
            return c0313eA;
        }
        throw C0309a.a();
    }

    private static int a(int[] iArr, int[] iArr2, int i) throws C0309a {
        if ((iArr2 == null || iArr2.length <= (i / 2) + 3) && i >= 0 && i <= 512) {
            return a.a(iArr, i, iArr2);
        }
        throw C0309a.a();
    }

    private static void a(int[] iArr, int i) throws C0309a {
        if (iArr.length >= 4) {
            int i2 = iArr[0];
            if (i2 > iArr.length) {
                throw C0309a.a();
            }
            if (i2 == 0) {
                if (i < iArr.length) {
                    iArr[0] = iArr.length - i;
                    return;
                }
                throw C0309a.a();
            }
            return;
        }
        throw C0309a.a();
    }

    private static int[] a(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int i3 = 7;
        while (true) {
            int i4 = i & 1;
            if (i4 != i2) {
                i3--;
                if (i3 < 0) {
                    return iArr;
                }
                i2 = i4;
            }
            iArr[i3] = iArr[i3] + 1;
            i >>= 1;
        }
    }

    private static int a(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }
}
