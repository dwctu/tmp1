package com.huawei.hms.scankit.aiscan.common;

import com.huawei.hms.scankit.p.C0417y;

/* compiled from: WhiteRectangleDetector.java */
/* loaded from: classes3.dex */
public final class F {
    private final C0417y a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    public F(C0417y c0417y) throws C0309a {
        this(c0417y, 10, c0417y.d() / 2, c0417y.b() / 2);
    }

    private z[] b(int[] iArr) throws C0309a {
        int i = iArr[1] - iArr[0];
        z zVarA = null;
        z zVarA2 = null;
        for (int i2 = 1; zVarA2 == null && i2 < i; i2++) {
            zVarA2 = a(iArr[0], iArr[3] - i2, iArr[0] + i2, iArr[3]);
        }
        if (zVarA2 == null) {
            throw C0309a.a();
        }
        z zVarA3 = null;
        for (int i3 = 1; zVarA3 == null && i3 < i; i3++) {
            zVarA3 = a(iArr[0], iArr[2] + i3, iArr[0] + i3, iArr[2]);
        }
        if (zVarA3 == null) {
            throw C0309a.a();
        }
        z zVarA4 = null;
        for (int i4 = 1; zVarA4 == null && i4 < i; i4++) {
            zVarA4 = a(iArr[1], iArr[2] + i4, iArr[1] - i4, iArr[2]);
        }
        if (zVarA4 == null) {
            throw C0309a.a();
        }
        for (int i5 = 1; zVarA == null && i5 < i; i5++) {
            zVarA = a(iArr[1], iArr[3] - i5, iArr[1] - i5, iArr[3]);
        }
        if (zVarA != null) {
            return a(zVarA, zVarA2, zVarA4, zVarA3);
        }
        throw C0309a.a();
    }

    private void c(int[] iArr) {
        boolean z = true;
        while (true) {
            if ((!z && iArr[9] == 1) || iArr[0] < 0) {
                return;
            }
            boolean zA = a(iArr[2], iArr[3], iArr[0], false);
            if (zA) {
                iArr[0] = iArr[0] - 1;
                iArr[5] = 1;
                iArr[9] = 1;
            } else if (iArr[9] != 1) {
                iArr[0] = iArr[0] - 1;
            }
            z = zA;
        }
    }

    private void d(int[] iArr) {
        boolean zA = true;
        while (true) {
            if ((!zA && iArr[7] == 1) || iArr[1] >= this.c) {
                return;
            }
            zA = a(iArr[2], iArr[3], iArr[1], false);
            if (zA) {
                iArr[1] = iArr[1] + 1;
                iArr[5] = 1;
                iArr[7] = 1;
            } else if (iArr[7] != 1) {
                iArr[1] = iArr[1] + 1;
            }
        }
    }

    private void e(int[] iArr) {
        boolean z = true;
        while (true) {
            if ((!z && iArr[10] == 1) || iArr[2] < 0) {
                return;
            }
            boolean zA = a(iArr[0], iArr[1], iArr[2], true);
            if (zA) {
                iArr[2] = iArr[2] - 1;
                iArr[5] = 1;
                iArr[10] = 1;
            } else if (iArr[10] != 1) {
                iArr[2] = iArr[2] - 1;
            }
            z = zA;
        }
    }

    public z[] a() throws C0309a {
        int[] iArr = {this.d, this.e, this.g, this.f, 0, 1, 0, 0, 0, 0, 0};
        while (true) {
            if (iArr[5] != 1) {
                break;
            }
            iArr[5] = 0;
            d(iArr);
            if (iArr[1] >= this.c) {
                iArr[4] = 1;
                break;
            }
            a(iArr);
            if (iArr[3] >= this.b) {
                iArr[4] = 1;
                break;
            }
            c(iArr);
            if (iArr[0] < 0) {
                iArr[4] = 1;
                break;
            }
            e(iArr);
            if (iArr[2] < 0) {
                iArr[4] = 1;
                break;
            }
            if (iArr[5] == 1) {
                iArr[6] = 1;
            }
        }
        if (iArr[4] == 1 || iArr[6] != 1) {
            throw C0309a.a();
        }
        return b(iArr);
    }

    public F(C0417y c0417y, int i, int i2, int i3) throws C0309a {
        this.a = c0417y;
        int iB = c0417y.b();
        this.b = iB;
        int iD = c0417y.d();
        this.c = iD;
        int i4 = i / 2;
        int i5 = i2 - i4;
        this.d = i5;
        int i6 = i2 + i4;
        this.e = i6;
        int i7 = i3 - i4;
        this.g = i7;
        int i8 = i3 + i4;
        this.f = i8;
        if (i7 < 0 || i5 < 0 || i8 >= iB || i6 >= iD) {
            throw C0309a.a();
        }
    }

    private void a(int[] iArr) {
        boolean z = true;
        while (true) {
            if ((!z && iArr[8] == 1) || iArr[3] >= this.b) {
                return;
            }
            boolean zA = a(iArr[0], iArr[1], iArr[3], true);
            if (zA) {
                iArr[3] = iArr[3] + 1;
                iArr[5] = 1;
                iArr[8] = 1;
            } else if (iArr[8] != 1) {
                iArr[3] = iArr[3] + 1;
            }
            z = zA;
        }
    }

    private z a(float f, float f2, float f3, float f4) {
        int iA = n.a(n.a(f, f2, f3, f4));
        float f5 = iA;
        float f6 = (f3 - f) / f5;
        float f7 = (f4 - f2) / f5;
        for (int i = 0; i < iA; i++) {
            float f8 = i;
            int iA2 = n.a((f8 * f6) + f);
            int iA3 = n.a((f8 * f7) + f2);
            if (this.a.b(iA2, iA3)) {
                return new z(iA2, iA3);
            }
        }
        return null;
    }

    private z[] a(z zVar, z zVar2, z zVar3, z zVar4) {
        float fB = zVar.b();
        float fC = zVar.c();
        float fB2 = zVar2.b();
        float fC2 = zVar2.c();
        float fB3 = zVar3.b();
        float fC3 = zVar3.c();
        float fB4 = zVar4.b();
        float fC4 = zVar4.c();
        return fB < ((float) this.c) / 2.0f ? new z[]{new z(fB4 - 1.0f, fC4 + 1.0f), new z(fB2 + 1.0f, fC2 + 1.0f), new z(fB3 - 1.0f, fC3 - 1.0f), new z(fB + 1.0f, fC - 1.0f)} : new z[]{new z(fB4 + 1.0f, fC4 + 1.0f), new z(fB2 + 1.0f, fC2 - 1.0f), new z(fB3 - 1.0f, fC3 + 1.0f), new z(fB - 1.0f, fC - 1.0f)};
    }

    private boolean a(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.a.b(i, i3)) {
                    return true;
                }
                i++;
            }
            return false;
        }
        while (i <= i2) {
            if (this.a.b(i3, i)) {
                return true;
            }
            i++;
        }
        return false;
    }
}
