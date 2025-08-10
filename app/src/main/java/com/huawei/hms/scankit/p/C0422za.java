package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0309a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AlignmentPatternFinder.java */
/* renamed from: com.huawei.hms.scankit.p.za, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0422za {
    private final C0417y a;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final float g;
    private final com.huawei.hms.scankit.aiscan.common.A i;
    private final List<C0418ya> b = new ArrayList(5);
    private final int[] h = new int[3];

    public C0422za(C0417y c0417y, int i, int i2, int i3, int i4, float f, com.huawei.hms.scankit.aiscan.common.A a) {
        this.a = c0417y;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = f;
        this.i = a;
    }

    public C0418ya a() throws C0309a {
        C0418ya c0418yaA;
        int i = this.c;
        int i2 = this.f;
        int i3 = this.e + i;
        int i4 = this.d + (i2 / 2);
        int[] iArr = new int[3];
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = ((i5 & 1) == 0 ? (i5 + 1) / 2 : -((i5 + 1) / 2)) + i4;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i7 = i;
            while (i7 < i3 && !this.a.b(i7, i6)) {
                i7++;
            }
            C0418ya c0418yaA2 = a(i6, i7, i3, iArr);
            if (c0418yaA2 != null) {
                return c0418yaA2;
            }
            if (a(iArr) && (c0418yaA = a(iArr, i6, i3)) != null) {
                return c0418yaA;
            }
        }
        if (this.b.isEmpty()) {
            throw C0309a.a();
        }
        return this.b.get(0);
    }

    private C0418ya a(int i, int i2, int i3, int[] iArr) {
        C0418ya c0418yaA;
        int i4 = 0;
        while (i2 < i3) {
            if (!this.a.b(i2, i)) {
                if (i4 == 1) {
                    i4++;
                }
                iArr[i4] = iArr[i4] + 1;
            } else if (i4 == 1) {
                iArr[1] = iArr[1] + 1;
            } else if (i4 == 2) {
                if (a(iArr) && (c0418yaA = a(iArr, i, i2)) != null) {
                    return c0418yaA;
                }
                iArr[0] = iArr[2];
                iArr[1] = 1;
                iArr[2] = 0;
                i4 = 1;
            } else {
                i4++;
                iArr[i4] = iArr[i4] + 1;
            }
            i2++;
        }
        return null;
    }

    private static float a(int[] iArr, int i) {
        return (i - iArr[2]) - (iArr[1] / 2.0f);
    }

    private boolean a(int[] iArr) {
        float f = this.g;
        float f2 = (3.0f * f) / 4.0f;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(f - iArr[i]) >= f2) {
                return false;
            }
        }
        return true;
    }

    private float a(int i, int i2, int i3, int i4) {
        int i5;
        C0417y c0417y = this.a;
        int iB = c0417y.b();
        int[] iArr = this.h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i6 = i;
        while (i6 >= 0 && c0417y.b(i2, i6) && iArr[1] <= i3) {
            iArr[1] = iArr[1] + 1;
            i6--;
        }
        if (i6 < 0 || iArr[1] > i3) {
            return Float.NaN;
        }
        while (i6 >= 0 && !c0417y.b(i2, i6) && iArr[0] <= i3) {
            iArr[0] = iArr[0] + 1;
            i6--;
        }
        if (iArr[0] > i3) {
            return Float.NaN;
        }
        int i7 = i + 1;
        while (i7 < iB && c0417y.b(i2, i7) && iArr[1] <= i3) {
            iArr[1] = iArr[1] + 1;
            i7++;
        }
        if (i7 == iB || iArr[1] > i3) {
            return Float.NaN;
        }
        while (i7 < iB && !c0417y.b(i2, i7) && iArr[2] <= i3) {
            iArr[2] = iArr[2] + 1;
            i7++;
        }
        if (iArr[2] <= i3 && (i5 = iArr[0] + iArr[1] + iArr[2]) < i4 * 3 && i5 * 3 > i4 && a(iArr)) {
            return a(iArr, i7);
        }
        return Float.NaN;
    }

    private C0418ya a(int[] iArr, int i, int i2) {
        int i3 = iArr[0] + iArr[1] + iArr[2];
        float fA = a(iArr, i2);
        float fA2 = a(i, (int) fA, iArr[1] * 3, i3);
        if (Float.isNaN(fA2)) {
            return null;
        }
        float f = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (C0418ya c0418ya : this.b) {
            if (c0418ya.a(f, fA2, fA)) {
                return c0418ya.b(fA2, fA, f);
            }
        }
        C0418ya c0418ya2 = new C0418ya(fA, fA2, f);
        this.b.add(c0418ya2);
        com.huawei.hms.scankit.aiscan.common.A a = this.i;
        if (a == null) {
            return null;
        }
        a.a(c0418ya2);
        return null;
    }
}
