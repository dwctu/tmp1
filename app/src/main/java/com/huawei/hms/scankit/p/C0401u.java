package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0309a;
import com.j256.ormlite.stmt.query.SimpleComparison;
import kotlin.text.Typography;

/* compiled from: Detector.java */
/* renamed from: com.huawei.hms.scankit.p.u, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0401u {
    private static final int[] a = {3808, 476, 2107, 1799};
    private final C0417y b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private int g;

    /* compiled from: Detector.java */
    /* renamed from: com.huawei.hms.scankit.p.u$a */
    public static final class a {
        private final int a;
        private final int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public com.huawei.hms.scankit.aiscan.common.z c() {
            return new com.huawei.hms.scankit.aiscan.common.z(this.a, this.b);
        }

        public String toString() {
            return SimpleComparison.LESS_THAN_OPERATION + this.a + ' ' + this.b + Typography.greater;
        }

        public int a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }
    }

    public C0401u(C0417y c0417y) {
        this.b = c0417y;
    }

    private a b() {
        com.huawei.hms.scankit.aiscan.common.z zVarC;
        com.huawei.hms.scankit.aiscan.common.z zVar;
        com.huawei.hms.scankit.aiscan.common.z zVar2;
        com.huawei.hms.scankit.aiscan.common.z zVar3;
        com.huawei.hms.scankit.aiscan.common.z zVarC2;
        com.huawei.hms.scankit.aiscan.common.z zVarC3;
        com.huawei.hms.scankit.aiscan.common.z zVarC4;
        com.huawei.hms.scankit.aiscan.common.z zVarC5;
        try {
            com.huawei.hms.scankit.aiscan.common.z[] zVarArrA = new com.huawei.hms.scankit.aiscan.common.F(this.b).a();
            zVar2 = zVarArrA[0];
            zVar3 = zVarArrA[1];
            zVar = zVarArrA[2];
            zVarC = zVarArrA[3];
        } catch (C0309a unused) {
            int iD = this.b.d() / 2;
            int iB = this.b.b() / 2;
            int i = iD + 7;
            int i2 = iB - 7;
            com.huawei.hms.scankit.aiscan.common.z zVarC6 = a(new a(i, i2), false, 1, -1).c();
            int i3 = iB + 7;
            com.huawei.hms.scankit.aiscan.common.z zVarC7 = a(new a(i, i3), false, 1, 1).c();
            int i4 = iD - 7;
            com.huawei.hms.scankit.aiscan.common.z zVarC8 = a(new a(i4, i3), false, -1, 1).c();
            zVarC = a(new a(i4, i2), false, -1, -1).c();
            zVar = zVarC8;
            zVar2 = zVarC6;
            zVar3 = zVarC7;
        }
        int iA = com.huawei.hms.scankit.aiscan.common.n.a((((zVar2.b() + zVarC.b()) + zVar3.b()) + zVar.b()) / 4.0f);
        int iA2 = com.huawei.hms.scankit.aiscan.common.n.a((((zVar2.c() + zVarC.c()) + zVar3.c()) + zVar.c()) / 4.0f);
        try {
            com.huawei.hms.scankit.aiscan.common.z[] zVarArrA2 = new com.huawei.hms.scankit.aiscan.common.F(this.b, 15, iA, iA2).a();
            zVarC2 = zVarArrA2[0];
            zVarC3 = zVarArrA2[1];
            zVarC4 = zVarArrA2[2];
            zVarC5 = zVarArrA2[3];
        } catch (C0309a unused2) {
            int i5 = iA + 7;
            int i6 = iA2 - 7;
            zVarC2 = a(new a(i5, i6), false, 1, -1).c();
            int i7 = iA2 + 7;
            zVarC3 = a(new a(i5, i7), false, 1, 1).c();
            int i8 = iA - 7;
            zVarC4 = a(new a(i8, i7), false, -1, 1).c();
            zVarC5 = a(new a(i8, i6), false, -1, -1).c();
        }
        return new a(com.huawei.hms.scankit.aiscan.common.n.a((((zVarC2.b() + zVarC5.b()) + zVarC3.b()) + zVarC4.b()) / 4.0f), com.huawei.hms.scankit.aiscan.common.n.a((((zVarC2.c() + zVarC5.c()) + zVarC3.c()) + zVarC4.c()) / 4.0f));
    }

    public C0386q a(boolean z) throws Exception {
        com.huawei.hms.scankit.aiscan.common.z[] zVarArrA = a(b());
        if (z) {
            com.huawei.hms.scankit.aiscan.common.z zVar = zVarArrA[0];
            zVarArrA[0] = zVarArrA[2];
            zVarArrA[2] = zVar;
        }
        a(zVarArrA);
        C0417y c0417y = this.b;
        int i = this.g;
        return new C0386q(a(c0417y, zVarArrA[i % 4], zVarArrA[(i + 1) % 4], zVarArrA[(i + 2) % 4], zVarArrA[(i + 3) % 4]), b(zVarArrA), this.c, this.e, this.d);
    }

    private void a(com.huawei.hms.scankit.aiscan.common.z[] zVarArr) throws Exception {
        long j;
        long j2;
        if (a(zVarArr[0]) && a(zVarArr[1]) && a(zVarArr[2]) && a(zVarArr[3])) {
            int i = this.f * 2;
            int[] iArr = {a(zVarArr[0], zVarArr[1], i), a(zVarArr[1], zVarArr[2], i), a(zVarArr[2], zVarArr[3], i), a(zVarArr[3], zVarArr[0], i)};
            this.g = a(iArr, i);
            long j3 = 0;
            for (int i2 = 0; i2 < 4; i2++) {
                int i3 = iArr[(this.g + i2) % 4];
                if (this.c) {
                    j = j3 << 7;
                    j2 = (i3 >> 1) & 127;
                } else {
                    j = j3 << 10;
                    j2 = ((i3 >> 2) & 992) + ((i3 >> 1) & 31);
                }
                j3 = j + j2;
            }
            int iA = a(j3, this.c);
            if (this.c) {
                this.d = (iA >> 6) + 1;
                this.e = (iA & 63) + 1;
                return;
            } else {
                this.d = (iA >> 11) + 1;
                this.e = (iA & 2047) + 1;
                return;
            }
        }
        throw C0309a.a();
    }

    private com.huawei.hms.scankit.aiscan.common.z[] b(com.huawei.hms.scankit.aiscan.common.z[] zVarArr) {
        return a(zVarArr, this.f * 2, a());
    }

    private boolean b(a aVar, a aVar2, a aVar3, a aVar4) {
        a aVar5 = new a(aVar.a() - 3, aVar.b() + 3);
        a aVar6 = new a(aVar2.a() - 3, aVar2.b() - 3);
        a aVar7 = new a(aVar3.a() + 3, aVar3.b() - 3);
        a aVar8 = new a(aVar4.a() + 3, aVar4.b() + 3);
        int iB = b(aVar8, aVar5);
        return iB != 0 && b(aVar5, aVar6) == iB && b(aVar6, aVar7) == iB && b(aVar7, aVar8) == iB;
    }

    private static int a(int[] iArr, int i) throws C0309a {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 = (i2 << 3) + ((i3 >> (i - 2)) << 1) + (i3 & 1);
        }
        int i4 = ((i2 & 1) << 11) + (i2 >> 1);
        for (int i5 = 0; i5 < 4; i5++) {
            if (Integer.bitCount(a[i5] ^ i4) <= 2) {
                return i5;
            }
        }
        throw C0309a.a();
    }

    private static int a(long j, boolean z) throws Exception {
        int i;
        int i2;
        if (z) {
            i = 7;
            i2 = 2;
        } else {
            i = 10;
            i2 = 4;
        }
        int i3 = i - i2;
        int[] iArr = new int[i];
        for (int i4 = i - 1; i4 >= 0; i4--) {
            iArr[i4] = ((int) j) & 15;
            j >>= 4;
        }
        try {
            new com.huawei.hms.scankit.aiscan.common.u(com.huawei.hms.scankit.aiscan.common.h.d).a(iArr, i3);
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                i5 = (i5 << 4) + iArr[i6];
            }
            return i5;
        } catch (C0309a unused) {
            throw C0309a.a();
        }
    }

    private int b(a aVar, a aVar2) {
        float fA = a(aVar, aVar2);
        float fA2 = (aVar2.a() - aVar.a()) / fA;
        float fB = (aVar2.b() - aVar.b()) / fA;
        float fA3 = aVar.a();
        float fB2 = aVar.b();
        boolean zB = this.b.b(aVar.a(), aVar.b());
        int iCeil = (int) Math.ceil(fA);
        int i = 0;
        for (int i2 = 0; i2 < iCeil; i2++) {
            fA3 += fA2;
            fB2 += fB;
            if (this.b.b(com.huawei.hms.scankit.aiscan.common.n.a(fA3), com.huawei.hms.scankit.aiscan.common.n.a(fB2)) != zB) {
                i++;
            }
        }
        float f = i / fA;
        if (f <= 0.1f || f >= 0.9f) {
            return (f <= 0.1f) == zB ? 1 : -1;
        }
        return 0;
    }

    private com.huawei.hms.scankit.aiscan.common.z[] a(a aVar) throws C0309a {
        int i;
        int i2 = 1;
        this.f = 1;
        a aVar2 = aVar;
        a aVar3 = aVar2;
        a aVar4 = aVar3;
        a aVar5 = aVar4;
        boolean z = true;
        while (this.f < 9) {
            a aVarA = a(aVar5, z, i2, -1);
            a aVarA2 = a(aVar4, z, i2, i2);
            a aVarA3 = a(aVar3, z, -1, i2);
            a aVarA4 = a(aVar2, z, -1, -1);
            if (this.f > 2) {
                double dA = (a(aVarA4, aVarA) * this.f) / (a(aVar2, aVar5) * (this.f + 2));
                if (dA < 0.75d || dA > 1.25d || !a(aVarA, aVarA2, aVarA3, aVarA4) || (!b(aVarA, aVarA2, aVarA3, aVarA4) && ((i = this.f) == 5 || i == 7))) {
                    break;
                }
            }
            z = !z;
            this.f++;
            aVar2 = aVarA4;
            aVar5 = aVarA;
            aVar4 = aVarA2;
            aVar3 = aVarA3;
            i2 = 1;
        }
        int i3 = this.f;
        if (i3 != 5 && i3 != 7) {
            throw C0309a.a();
        }
        this.c = i3 == 5;
        com.huawei.hms.scankit.aiscan.common.z[] zVarArr = {new com.huawei.hms.scankit.aiscan.common.z(aVar5.a() + 0.5f, aVar5.b() - 0.5f), new com.huawei.hms.scankit.aiscan.common.z(aVar4.a() + 0.5f, aVar4.b() + 0.5f), new com.huawei.hms.scankit.aiscan.common.z(aVar3.a() - 0.5f, aVar3.b() + 0.5f), new com.huawei.hms.scankit.aiscan.common.z(aVar2.a() - 0.5f, aVar2.b() - 0.5f)};
        int i4 = this.f * 2;
        return a(zVarArr, i4 - 3, i4);
    }

    private C0417y a(C0417y c0417y, com.huawei.hms.scankit.aiscan.common.z zVar, com.huawei.hms.scankit.aiscan.common.z zVar2, com.huawei.hms.scankit.aiscan.common.z zVar3, com.huawei.hms.scankit.aiscan.common.z zVar4) throws C0309a {
        com.huawei.hms.scankit.aiscan.common.j jVarA = com.huawei.hms.scankit.aiscan.common.j.a();
        int iA = a();
        float f = iA / 2.0f;
        float f2 = this.f;
        float f3 = f - f2;
        float f4 = f + f2;
        return jVarA.a(c0417y, iA, iA, f3, f3, f4, f3, f4, f4, f3, f4, zVar.b(), zVar.c(), zVar2.b(), zVar2.c(), zVar3.b(), zVar3.c(), zVar4.b(), zVar4.c());
    }

    private int a(com.huawei.hms.scankit.aiscan.common.z zVar, com.huawei.hms.scankit.aiscan.common.z zVar2, int i) {
        float fA = a(zVar, zVar2);
        float f = fA / i;
        float fB = zVar.b();
        float fC = zVar.c();
        float fB2 = ((zVar2.b() - zVar.b()) * f) / fA;
        float fC2 = (f * (zVar2.c() - zVar.c())) / fA;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            float f2 = i3;
            if (this.b.b(com.huawei.hms.scankit.aiscan.common.n.a((f2 * fB2) + fB), com.huawei.hms.scankit.aiscan.common.n.a((f2 * fC2) + fC))) {
                i2 |= 1 << ((i - i3) - 1);
            }
        }
        return i2;
    }

    private boolean a(a aVar, a aVar2, a aVar3, a aVar4) {
        a aVar5 = new a((int) Math.ceil((((aVar.a + aVar2.a) + aVar3.a) + aVar4.a) / 4.0f), (int) Math.ceil((((aVar.b + aVar2.b) + aVar3.b) + aVar4.b) / 4.0f));
        float fA = a(aVar5, aVar);
        float fA2 = a(aVar5, aVar2);
        float fA3 = a(aVar5, aVar3);
        float fA4 = a(aVar5, aVar4);
        double d = fA / fA2;
        if (d <= 0.75d || d >= 1.25d) {
            return false;
        }
        double d2 = fA / fA3;
        if (d2 <= 0.75d || d2 >= 1.25d) {
            return false;
        }
        double d3 = fA / fA4;
        return d3 > 0.75d && d3 < 1.25d;
    }

    private a a(a aVar, boolean z, int i, int i2) {
        int iA = aVar.a() + i;
        int iB = aVar.b();
        while (true) {
            iB += i2;
            if (!a(iA, iB) || this.b.b(iA, iB) != z) {
                break;
            }
            iA += i;
        }
        int i3 = iA - i;
        int i4 = iB - i2;
        while (a(i3, i4) && this.b.b(i3, i4) == z) {
            i3 += i;
        }
        int i5 = i3 - i;
        while (a(i5, i4) && this.b.b(i5, i4) == z) {
            i4 += i2;
        }
        return new a(i5, i4 - i2);
    }

    private static com.huawei.hms.scankit.aiscan.common.z[] a(com.huawei.hms.scankit.aiscan.common.z[] zVarArr, int i, int i2) {
        float f = i2 / (i * 2.0f);
        float fB = zVarArr[0].b() - zVarArr[2].b();
        float fC = zVarArr[0].c() - zVarArr[2].c();
        float fB2 = (zVarArr[0].b() + zVarArr[2].b()) / 2.0f;
        float fC2 = (zVarArr[0].c() + zVarArr[2].c()) / 2.0f;
        float f2 = fB * f;
        float f3 = fC * f;
        com.huawei.hms.scankit.aiscan.common.z zVar = new com.huawei.hms.scankit.aiscan.common.z(fB2 + f2, fC2 + f3);
        com.huawei.hms.scankit.aiscan.common.z zVar2 = new com.huawei.hms.scankit.aiscan.common.z(fB2 - f2, fC2 - f3);
        float fB3 = zVarArr[1].b() - zVarArr[3].b();
        float fC3 = zVarArr[1].c() - zVarArr[3].c();
        float fB4 = (zVarArr[1].b() + zVarArr[3].b()) / 2.0f;
        float fC4 = (zVarArr[1].c() + zVarArr[3].c()) / 2.0f;
        float f4 = fB3 * f;
        float f5 = f * fC3;
        return new com.huawei.hms.scankit.aiscan.common.z[]{zVar, new com.huawei.hms.scankit.aiscan.common.z(fB4 + f4, fC4 + f5), zVar2, new com.huawei.hms.scankit.aiscan.common.z(fB4 - f4, fC4 - f5)};
    }

    private boolean a(int i, int i2) {
        return i >= 0 && i < this.b.d() && i2 > 0 && i2 < this.b.b();
    }

    private boolean a(com.huawei.hms.scankit.aiscan.common.z zVar) {
        return a(com.huawei.hms.scankit.aiscan.common.n.a(zVar.b()), com.huawei.hms.scankit.aiscan.common.n.a(zVar.c()));
    }

    private static float a(a aVar, a aVar2) {
        return com.huawei.hms.scankit.aiscan.common.n.a(aVar.a(), aVar.b(), aVar2.a(), aVar2.b());
    }

    private static float a(com.huawei.hms.scankit.aiscan.common.z zVar, com.huawei.hms.scankit.aiscan.common.z zVar2) {
        return com.huawei.hms.scankit.aiscan.common.n.a(zVar.b(), zVar.c(), zVar2.b(), zVar2.c());
    }

    private int a() {
        if (this.c) {
            return (this.d * 4) + 11;
        }
        int i = this.d;
        return i <= 4 ? (i * 4) + 15 : (i * 4) + ((((i - 4) / 8) + 1) * 2) + 15;
    }
}
