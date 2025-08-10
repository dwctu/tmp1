package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0309a;

/* compiled from: ErrorCorrection.java */
/* renamed from: com.huawei.hms.scankit.p.pa, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0383pa {
    private final C0387qa a = C0387qa.a;

    public int a(int[] iArr, int i, int[] iArr2) throws C0309a {
        C0390ra c0390ra = new C0390ra(this.a, iArr);
        int[] iArr3 = new int[i];
        boolean z = false;
        for (int i2 = i; i2 > 0; i2--) {
            int iA = c0390ra.a(this.a.a(i2));
            iArr3[i - i2] = iA;
            if (iA != 0) {
                z = true;
            }
        }
        if (!z) {
            return 0;
        }
        C0390ra c0390raA = this.a.a();
        if (iArr2 != null) {
            for (int i3 : iArr2) {
                int iA2 = this.a.a((iArr.length - 1) - i3);
                C0387qa c0387qa = this.a;
                c0390raA = c0390raA.b(new C0390ra(c0387qa, new int[]{c0387qa.d(0, iA2), 1}));
            }
        }
        C0390ra[] c0390raArrA = a(this.a.b(i, 1), new C0390ra(this.a, iArr3), i);
        C0390ra c0390ra2 = c0390raArrA[0];
        C0390ra c0390ra3 = c0390raArrA[1];
        int[] iArrA = a(c0390ra2);
        int[] iArrA2 = a(c0390ra3, c0390ra2, iArrA);
        for (int i4 = 0; i4 < iArrA.length; i4++) {
            int length = (iArr.length - 1) - this.a.c(iArrA[i4]);
            if (length < 0) {
                throw C0309a.a();
            }
            iArr[length] = this.a.d(iArr[length], iArrA2[i4]);
        }
        return iArrA.length;
    }

    private C0390ra[] a(C0390ra c0390ra, C0390ra c0390ra2, int i) throws C0309a {
        if (c0390ra.a() >= c0390ra2.a()) {
            c0390ra2 = c0390ra;
            c0390ra = c0390ra2;
        }
        C0390ra c0390raC = this.a.c();
        C0390ra c0390raA = this.a.a();
        while (c0390ra.a() >= i / 2) {
            if (!c0390ra.b()) {
                C0390ra c0390raC2 = this.a.c();
                int iB = this.a.b(c0390ra.b(c0390ra.a()));
                while (c0390ra2.a() >= c0390ra.a() && !c0390ra2.b()) {
                    int iA = c0390ra2.a() - c0390ra.a();
                    int iC = this.a.c(c0390ra2.b(c0390ra2.a()), iB);
                    c0390raC2 = c0390raC2.a(this.a.b(iA, iC));
                    c0390ra2 = c0390ra2.c(c0390ra.a(iA, iC));
                }
                C0390ra c0390raC3 = c0390raC2.b(c0390raA).c(c0390raC).c();
                C0390ra c0390ra3 = c0390ra2;
                c0390ra2 = c0390ra;
                c0390ra = c0390ra3;
                c0390raC = c0390raA;
                c0390raA = c0390raC3;
            } else {
                throw C0309a.a();
            }
        }
        int iB2 = c0390raA.b(0);
        if (iB2 != 0) {
            int iB3 = this.a.b(iB2);
            return new C0390ra[]{c0390raA.c(iB3), c0390ra.c(iB3)};
        }
        throw C0309a.a();
    }

    private int[] a(C0390ra c0390ra) throws C0309a {
        int iA = c0390ra.a();
        int[] iArr = new int[iA];
        int i = 0;
        for (int i2 = 1; i2 < this.a.b() && i < iA; i2++) {
            if (c0390ra.a(i2) == 0) {
                iArr[i] = this.a.b(i2);
                i++;
            }
        }
        if (i == iA) {
            return iArr;
        }
        throw C0309a.a();
    }

    private int[] a(C0390ra c0390ra, C0390ra c0390ra2, int[] iArr) {
        int iA = c0390ra2.a();
        int[] iArr2 = new int[iA];
        for (int i = 1; i <= iA; i++) {
            iArr2[iA - i] = this.a.c(i, c0390ra2.b(i));
        }
        C0390ra c0390ra3 = new C0390ra(this.a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int iB = this.a.b(iArr[i2]);
            iArr3[i2] = this.a.c(this.a.d(0, c0390ra.a(iB)), this.a.b(c0390ra3.a(iB)));
        }
        return iArr3;
    }
}
