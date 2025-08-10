package com.huawei.hms.scankit.aiscan.common;

/* compiled from: ReedSolomonDecoder.java */
/* loaded from: classes3.dex */
public final class u {
    private final h a;

    public u(h hVar) {
        this.a = hVar;
    }

    public void a(int[] iArr, int i) throws Exception {
        i iVar = new i(this.a, iArr);
        int[] iArr2 = new int[i];
        boolean z = true;
        for (int i2 = 0; i2 < i; i2++) {
            h hVar = this.a;
            int iA = iVar.a(hVar.a(hVar.a() + i2));
            iArr2[(i - 1) - i2] = iA;
            if (iA != 0) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        i[] iVarArrA = a(this.a.b(i, 1), new i(this.a, iArr2), i);
        i iVar2 = iVarArrA[0];
        i iVar3 = iVarArrA[1];
        int[] iArrA = a(iVar2);
        int[] iArrA2 = a(iVar3, iArrA);
        for (int i3 = 0; i3 < iArrA.length; i3++) {
            int length = (iArr.length - 1) - this.a.c(iArrA[i3]);
            if (length < 0) {
                throw C0309a.a("Bad error location");
            }
            iArr[length] = h.a(iArr[length], iArrA2[i3]);
        }
    }

    private i[] a(i iVar, i iVar2, int i) throws Exception {
        if (iVar.b() >= iVar2.b()) {
            iVar2 = iVar;
            iVar = iVar2;
        }
        i iVarD = this.a.d();
        i iVarB = this.a.b();
        while (iVar.b() >= i / 2) {
            if (!iVar.c()) {
                i iVarD2 = this.a.d();
                int iB = this.a.b(iVar.b(iVar.b()));
                while (iVar2.b() >= iVar.b() && !iVar2.c()) {
                    int iB2 = iVar2.b() - iVar.b();
                    int iC = this.a.c(iVar2.b(iVar2.b()), iB);
                    iVarD2 = iVarD2.a(this.a.b(iB2, iC));
                    iVar2 = iVar2.a(iVar.a(iB2, iC));
                }
                i iVarA = iVarD2.c(iVarB).a(iVarD);
                if (iVar2.b() >= iVar.b()) {
                    throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
                }
                i iVar3 = iVar2;
                iVar2 = iVar;
                iVar = iVar3;
                iVarD = iVarB;
                iVarB = iVarA;
            } else {
                throw C0309a.a("r_{i-1} was zero");
            }
        }
        int iB3 = iVarB.b(0);
        if (iB3 != 0) {
            int iB4 = this.a.b(iB3);
            return new i[]{iVarB.c(iB4), iVar.c(iB4)};
        }
        throw C0309a.a("sigmaTilde(0) was zero");
    }

    private int[] a(i iVar) throws C0309a {
        int iB = iVar.b();
        int i = 0;
        if (iB == 1) {
            return new int[]{iVar.b(1)};
        }
        int[] iArr = new int[iB];
        for (int i2 = 1; i2 < this.a.c() && i < iB; i2++) {
            if (iVar.a(i2) == 0) {
                iArr[i] = this.a.b(i2);
                i++;
            }
        }
        if (i == iB) {
            return iArr;
        }
        throw C0309a.a("Error locator degree does not match number of roots");
    }

    private int[] a(i iVar, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            int iB = this.a.b(iArr[i]);
            int iC = 1;
            for (int i2 = 0; i2 < length; i2++) {
                if (i != i2) {
                    int iC2 = this.a.c(iArr[i2], iB);
                    iC = this.a.c(iC, (iC2 & 1) == 0 ? iC2 | 1 : iC2 & (-2));
                }
            }
            iArr2[i] = this.a.c(iVar.a(iB), this.a.b(iC));
            if (this.a.a() != 0) {
                iArr2[i] = this.a.c(iArr2[i], iB);
            }
        }
        return iArr2;
    }
}
