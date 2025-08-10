package com.huawei.hms.scankit.aiscan.common;

import com.huawei.hms.scankit.p.C0417y;
import com.huawei.hms.scankit.p._a;

/* compiled from: DefaultGridSampler.java */
/* renamed from: com.huawei.hms.scankit.aiscan.common.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0314f extends j {
    @Override // com.huawei.hms.scankit.aiscan.common.j
    public C0417y a(C0417y c0417y, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) throws C0309a {
        return a(c0417y, i, i2, q.a(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16), false);
    }

    public C0417y b(C0417y c0417y, int i, int i2, q qVar) throws C0309a {
        if (i <= 0 || i2 <= 0) {
            throw C0309a.a();
        }
        C0417y c0417y2 = new C0417y(i, i2);
        int i3 = i * 2;
        float[] fArr = new float[i3];
        for (int i4 = 0; i4 < i2; i4++) {
            float f = i4 + 0.5f;
            for (int i5 = 0; i5 < i3; i5 += 2) {
                fArr[i5] = (i5 / 2) + 0.5f;
                fArr[i5 + 1] = f;
            }
            if (_a.k && _a.h) {
                qVar.b(fArr);
            } else {
                qVar.a(fArr);
            }
            int iD = c0417y.d();
            int iB = c0417y.b();
            for (int i6 = 0; i6 < i3; i6 += 2) {
                try {
                    int i7 = (int) fArr[i6];
                    int i8 = (int) fArr[i6 + 1];
                    if (i7 < -1 || i7 > iD || i8 < -1 || i8 > iB) {
                        c0417y2.c(i6 / 2, i4);
                    } else if (c0417y.b(i7, i8)) {
                        c0417y2.c(i6 / 2, i4);
                    }
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw C0309a.a();
                }
            }
        }
        return c0417y2;
    }

    @Override // com.huawei.hms.scankit.aiscan.common.j
    public C0417y a(C0417y c0417y, int i, int i2, q qVar, boolean z) throws C0309a {
        boolean z2 = _a.i;
        if ((z2 && z) || !(z2 || z) || _a.p) {
            return b(c0417y, i, i2, qVar);
        }
        return a(c0417y, i, i2, qVar);
    }

    public C0417y a(C0417y c0417y, int i, int i2, q qVar) throws C0309a {
        if (i > 0 && i2 > 0) {
            C0417y c0417y2 = new C0417y(i, i2);
            float[] fArr = new float[10];
            float f = 0.5f;
            char c = 0;
            int i3 = 0;
            while (i3 < i2) {
                int i4 = 0;
                while (i4 < i) {
                    float f2 = i4;
                    fArr[c] = (f2 - 0.2f) + f;
                    float f3 = i3;
                    float f4 = f3 + f;
                    fArr[1] = f4;
                    fArr[2] = f2 + 0.2f + f;
                    fArr[3] = f4;
                    float f5 = f2 + f;
                    fArr[4] = f5;
                    fArr[5] = (f3 - 0.2f) + f;
                    fArr[6] = f5;
                    fArr[7] = f3 + 0.2f + f;
                    fArr[8] = f5;
                    fArr[9] = f4;
                    if (_a.k && _a.h) {
                        qVar.b(fArr);
                    } else {
                        qVar.a(fArr);
                    }
                    int iD = c0417y.d();
                    int iB = c0417y.b();
                    int i5 = 0;
                    for (int i6 = 0; i6 < 5; i6++) {
                        int i7 = i6 * 2;
                        try {
                            int i8 = (int) fArr[i7];
                            int i9 = (int) fArr[i7 + 1];
                            if (i8 >= -1 && i8 <= iD && i9 >= -1 && i9 <= iB) {
                                if (c0417y.b(i8, i9)) {
                                    i5++;
                                }
                            }
                        } catch (ArrayIndexOutOfBoundsException unused) {
                            throw C0309a.a();
                        }
                    }
                    if (i5 >= 3) {
                        c0417y2.c(i4, i3);
                    }
                    i4++;
                    f = 0.5f;
                    c = 0;
                }
                i3++;
                f = 0.5f;
                c = 0;
            }
            return c0417y2;
        }
        throw C0309a.a();
    }
}
