package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0309a;

/* compiled from: DetectionResultRowIndicatorColumn.java */
/* renamed from: com.huawei.hms.scankit.p.na, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0375na extends C0371ma {
    private final boolean c;

    public C0375na(C0351ha c0351ha, boolean z) {
        super(c0351ha);
        this.c = z;
    }

    private void b(C0343fa c0343fa) {
        C0351ha c0351haA = a();
        com.huawei.hms.scankit.aiscan.common.z zVarG = this.c ? c0351haA.g() : c0351haA.h();
        com.huawei.hms.scankit.aiscan.common.z zVarA = this.c ? c0351haA.a() : c0351haA.b();
        int iC = c((int) zVarA.c());
        C0355ia[] c0355iaArrB = b();
        int iC2 = -1;
        int i = 0;
        int iMax = 1;
        for (int iC3 = c((int) zVarG.c()); iC3 < iC; iC3++) {
            if (c0355iaArrB[iC3] != null) {
                C0355ia c0355ia = c0355iaArrB[iC3];
                c0355ia.h();
                int iC4 = c0355ia.c() - iC2;
                if (iC4 == 0) {
                    i++;
                } else {
                    if (iC4 == 1) {
                        iMax = Math.max(iMax, i);
                        iC2 = c0355ia.c();
                    } else if (c0355ia.c() >= c0343fa.c()) {
                        c0355iaArrB[iC3] = null;
                    } else {
                        iC2 = c0355ia.c();
                    }
                    i = 1;
                }
            }
        }
    }

    private void f() {
        for (C0355ia c0355ia : b()) {
            if (c0355ia != null) {
                c0355ia.h();
            }
        }
    }

    public void a(C0343fa c0343fa) throws C0309a {
        C0355ia[] c0355iaArrB = b();
        f();
        a(c0355iaArrB, c0343fa);
        C0351ha c0351haA = a();
        com.huawei.hms.scankit.aiscan.common.z zVarG = this.c ? c0351haA.g() : c0351haA.h();
        com.huawei.hms.scankit.aiscan.common.z zVarA = this.c ? c0351haA.a() : c0351haA.b();
        int iC = c((int) zVarG.c());
        int iC2 = c((int) zVarA.c());
        int iC3 = -1;
        int i = 0;
        int iMax = 1;
        while (iC < iC2) {
            if (c0355iaArrB[iC] != null) {
                C0355ia c0355ia = c0355iaArrB[iC];
                int iC4 = c0355ia.c() - iC3;
                if (iC4 == 0) {
                    i++;
                } else {
                    if (iC4 == 1) {
                        iMax = Math.max(iMax, i);
                        iC3 = c0355ia.c();
                    } else if (iC4 < 0 || c0355ia.c() >= c0343fa.c() || iC4 > iC) {
                        c0355iaArrB[iC] = null;
                    } else {
                        if (iMax > 2) {
                            iC4 *= iMax - 2;
                        }
                        boolean z = iC4 >= iC;
                        for (int i2 = 1; i2 <= iC4 && !z; i2++) {
                            z = c0355iaArrB[iC - i2] != null;
                        }
                        if (z) {
                            c0355iaArrB[iC] = null;
                        } else {
                            iC3 = c0355ia.c();
                        }
                    }
                    i = 1;
                }
            }
            iC++;
        }
    }

    public C0343fa c() throws C0309a {
        C0355ia[] c0355iaArrB = b();
        C0347ga c0347ga = new C0347ga();
        C0347ga c0347ga2 = new C0347ga();
        C0347ga c0347ga3 = new C0347ga();
        C0347ga c0347ga4 = new C0347ga();
        for (C0355ia c0355ia : c0355iaArrB) {
            if (c0355ia != null) {
                c0355ia.h();
                int iE = c0355ia.e() % 30;
                int iC = c0355ia.c();
                if (!this.c) {
                    iC += 2;
                }
                int i = iC % 3;
                if (i == 0) {
                    c0347ga2.a((iE * 3) + 1);
                } else if (i == 1) {
                    c0347ga4.a(iE / 3);
                    c0347ga3.a(iE % 3);
                } else {
                    if (i != 2) {
                        throw C0309a.a();
                    }
                    c0347ga.a(iE + 1);
                }
            }
        }
        if (c0347ga.a().length == 0 || c0347ga2.a().length == 0 || c0347ga3.a().length == 0 || c0347ga4.a().length == 0 || c0347ga.a()[0] < 1 || c0347ga2.a()[0] + c0347ga3.a()[0] < 3 || c0347ga2.a()[0] + c0347ga3.a()[0] > 90) {
            return null;
        }
        C0343fa c0343fa = new C0343fa(c0347ga.a()[0], c0347ga2.a()[0], c0347ga3.a()[0], c0347ga4.a()[0]);
        a(c0355iaArrB, c0343fa);
        return c0343fa;
    }

    public int[] d() throws C0309a {
        int iC;
        C0343fa c0343faC = c();
        if (c0343faC == null) {
            return null;
        }
        b(c0343faC);
        int iC2 = c0343faC.c();
        int[] iArr = new int[iC2];
        for (C0355ia c0355ia : b()) {
            if (c0355ia != null && (iC = c0355ia.c()) < iC2) {
                iArr[iC] = iArr[iC] + 1;
            }
        }
        return iArr;
    }

    public boolean e() {
        return this.c;
    }

    @Override // com.huawei.hms.scankit.p.C0371ma
    public String toString() {
        return "IsLeft: " + this.c + '\n' + super.toString();
    }

    private void a(C0355ia[] c0355iaArr, C0343fa c0343fa) throws C0309a {
        for (int i = 0; i < c0355iaArr.length; i++) {
            C0355ia c0355ia = c0355iaArr[i];
            if (c0355iaArr[i] != null) {
                int iE = c0355ia.e() % 30;
                int iC = c0355ia.c();
                if (iC > c0343fa.c()) {
                    c0355iaArr[i] = null;
                } else {
                    if (!this.c) {
                        iC += 2;
                    }
                    int i2 = iC % 3;
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 == 2) {
                                if (iE + 1 != c0343fa.a()) {
                                    c0355iaArr[i] = null;
                                }
                            } else {
                                throw C0309a.a();
                            }
                        } else if (iE / 3 != c0343fa.b() || iE % 3 != c0343fa.d()) {
                            c0355iaArr[i] = null;
                        }
                    } else if ((iE * 3) + 1 != c0343fa.e()) {
                        c0355iaArr[i] = null;
                    }
                }
            }
        }
    }
}
