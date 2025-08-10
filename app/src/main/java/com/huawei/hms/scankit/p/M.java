package com.huawei.hms.scankit.p;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.huawei.hms.scankit.aiscan.common.C0309a;
import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import java.util.List;

/* compiled from: DetectorRotate.java */
/* loaded from: classes3.dex */
public class M {
    private static N a;
    private static C0409w b;

    public static List<L> a(boolean z, C0409w c0409w, int i, boolean z2) {
        int iE = c0409w.e();
        int iC = c0409w.c();
        byte[] bArrB = c0409w.a().c().b();
        N n = new N();
        a = n;
        n.a(z, bArrB, iC, iE, i, z2);
        return a.a;
    }

    public static boolean a(boolean z, C0409w c0409w, L l) throws C0309a {
        float fI;
        int iE = c0409w.e();
        int iC = c0409w.c();
        float[] fArr = {l.j(), l.k(), l.f(), l.c()};
        if (z) {
            l.n = Math.max(l.m(), l.l());
            l.o = Math.min(l.m(), l.l());
            fI = l.i();
            if (l.g() == 11.0f || l.g() == 0.0f) {
                fI = 0.0f;
            }
            l.v = Math.max(fArr[2], fArr[3]);
            l.r = (int) Math.max(fArr[0] - (fArr[2] * 0.5d), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            l.s = (int) Math.max(fArr[1] - (fArr[3] * 0.5d), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        } else {
            fI = l.i();
            l.v = Math.max(fArr[2], fArr[3]);
            l.r = (int) l.d();
            l.s = (int) l.e();
        }
        l.p = Math.min(iE - l.r, (int) fArr[2]);
        int iMin = Math.min(iC - l.s, (int) fArr[3]);
        l.q = iMin;
        int i = l.p;
        if (i > 0 && iMin > 0) {
            C0409w c0409wA = c0409w.a(l.r, l.s, i, iMin);
            b = c0409wA;
            a(c0409wA, fI, l, fArr);
            return true;
        }
        throw C0309a.a("crop_w <= 0 || crop_h <= 0");
    }

    private static void a(C0409w c0409w, float f, L l, float[] fArr) {
        float fMin;
        float fMax;
        float radians = (float) Math.toRadians(f);
        double d = radians;
        int iAbs = (int) ((l.p * Math.abs(Math.sin(d))) + (l.q * Math.abs(Math.cos(d))));
        int iAbs2 = (int) ((l.q * Math.abs(Math.sin(d))) + (l.p * Math.abs(Math.cos(d))));
        float[] fArr2 = l.m;
        fArr2[0] = iAbs2 * 0.5f;
        fArr2[1] = iAbs * 0.5f;
        fArr2[2] = (iAbs2 - l.p) * 0.5f;
        fArr2[3] = (iAbs - l.q) * 0.5f;
        fArr2[4] = radians;
        if (f == 0.0f) {
            l.t = 0;
            l.u = 0;
            l.l = c0409w;
            return;
        }
        C0409w c0409w2 = new C0409w(new A(new com.huawei.hms.scankit.aiscan.common.r(LoadOpencvJNIUtil.imageRotate(c0409w.a().c().b(), l.q, l.p, iAbs, iAbs2, f, 1.0d), iAbs2, iAbs, 0, 0, iAbs2, iAbs, false)));
        if ((l.g() == 3.0f || l.g() == 4.0f) && c0409w2.c() > c0409w2.e()) {
            fMin = Math.min(fArr[2], fArr[3]);
            fMax = Math.max(fArr[2], fArr[3]);
        } else {
            fMin = Math.max(fArr[2], fArr[3]);
            fMax = Math.min(fArr[2], fArr[3]);
        }
        l.t = (int) Math.max((iAbs2 * 0.5d) - (fMin * 0.5d), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        l.u = (int) Math.max((iAbs * 0.5d) - (fMax * 0.5d), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        l.l = c0409w2.a(l.t, l.u, Math.min(iAbs2 - l.t, (int) fMin), Math.min(iAbs - l.u, (int) fMax));
    }

    public static void a(C0417y c0417y, com.huawei.hms.scankit.aiscan.common.x xVar, float f, L l) {
        int iC;
        int iC2;
        com.huawei.hms.scankit.aiscan.common.z[] zVarArrH = xVar.h();
        float fMin = Math.min(zVarArrH[0].b(), zVarArrH[1].b());
        float fMax = Math.max(zVarArrH[0].b(), zVarArrH[1].b());
        float fC = zVarArrH[0].c();
        if (fMax > c0417y.d() - 1) {
            fMax = c0417y.d() - 1;
        }
        float f2 = fMax;
        float fB = fC > ((float) (c0417y.b() - 1)) ? c0417y.b() - 1 : fC;
        int iB = c0417y.b();
        try {
            int[] iArrA = a(c0417y, zVarArrH, fMin, f2, fB, iB, new int[iB]);
            iC = iArrA[0];
            iC2 = iArrA[1];
        } catch (IndexOutOfBoundsException unused) {
            iC = (int) zVarArrH[0].c();
            iC2 = (int) zVarArrH[0].c();
        }
        float f3 = iC;
        float f4 = iC2;
        com.huawei.hms.scankit.aiscan.common.z[] zVarArr = {new com.huawei.hms.scankit.aiscan.common.z(fMin, f3), new com.huawei.hms.scankit.aiscan.common.z(f2, f3), new com.huawei.hms.scankit.aiscan.common.z(f2, f4), new com.huawei.hms.scankit.aiscan.common.z(fMin, f4)};
        if (l != null) {
            a(zVarArr, f, l);
        }
        xVar.a();
        xVar.a(zVarArr);
    }

    private static int[] a(C0417y c0417y, com.huawei.hms.scankit.aiscan.common.z[] zVarArr, float f, float f2, float f3, int i, int[] iArr) {
        int i2;
        int iC;
        int iC2;
        int i3 = (int) f;
        int i4 = i3;
        int i5 = 0;
        while (true) {
            i2 = ((int) f2) - 1;
            if (i4 >= i2) {
                break;
            }
            int i6 = (int) f3;
            boolean zB = c0417y.b(i4, i6);
            i4++;
            if (c0417y.b(i4, i6) ^ zB) {
                i5++;
            }
        }
        int i7 = 0;
        for (int i8 = 0; i8 < i; i8++) {
            int i9 = i3;
            int i10 = 0;
            while (i9 < i2) {
                boolean zB2 = c0417y.b(i9, i8);
                i9++;
                if (zB2 ^ c0417y.b(i9, i8)) {
                    i10++;
                }
            }
            float f4 = i5;
            if (i10 > 1.5f * f4) {
                i10 = 0;
            }
            if (i10 < f4 * 0.5f) {
                i10 = 0;
            }
            iArr[i8] = i10;
            if (iArr[i8] > i7) {
                i7 = iArr[i8];
            }
        }
        if (i7 > 0) {
            float[] fArr = new float[i];
            for (int i11 = 0; i11 < i; i11++) {
                fArr[i11] = iArr[i11] / i7;
            }
            float f5 = 0.0f;
            for (int i12 = 0; i12 < i; i12++) {
                f5 += fArr[i12];
            }
            float f6 = f5 / i;
            if (f6 > 1.0d) {
                f6 = 0.99f;
            }
            iC = (int) f3;
            iC2 = iC;
            while (true) {
                if (iC2 < 0) {
                    iC2 = 0;
                    break;
                }
                if (fArr[iC2] < f6) {
                    break;
                }
                iC2--;
            }
            while (true) {
                if (iC >= i) {
                    iC = 0;
                    break;
                }
                if (fArr[iC] < f6) {
                    break;
                }
                iC++;
            }
        } else {
            iC = 0;
            iC2 = 0;
        }
        if (iC2 == 0 && iC == 0) {
            iC2 = ((int) zVarArr[0].c()) + (-10) < 0 ? 0 : ((int) zVarArr[0].c()) - 10;
            iC = i - 1;
            if (((int) zVarArr[0].c()) + 10 <= iC) {
                iC = ((int) zVarArr[0].c()) + 10;
            }
        }
        return new int[]{iC2, iC};
    }

    private static com.huawei.hms.scankit.aiscan.common.z a(float f, float f2, L l) {
        float[] fArr = l.m;
        if (fArr != null && fArr.length == 5) {
            float f3 = -fArr[4];
            double d = f - fArr[0];
            double d2 = f3;
            double dCos = (d * Math.cos(d2)) + ((f2 - l.m[1]) * Math.sin(d2));
            float[] fArr2 = l.m;
            int i = (int) (dCos + fArr2[0]);
            double dSin = ((-(f - fArr2[0])) * Math.sin(d2)) + ((f2 - l.m[1]) * Math.cos(d2));
            float[] fArr3 = l.m;
            return new com.huawei.hms.scankit.aiscan.common.z((i - fArr3[2]) + l.r, (((int) (dSin + fArr3[1])) - fArr3[3]) + l.s);
        }
        return new com.huawei.hms.scankit.aiscan.common.z(f, f2);
    }

    public static void a(com.huawei.hms.scankit.aiscan.common.z[] zVarArr, float f, L l) {
        if (l == null || zVarArr == null) {
            return;
        }
        for (int i = 0; i < zVarArr.length; i++) {
            zVarArr[i] = a((zVarArr[i].b() * f) + l.t, (zVarArr[i].c() * f) + l.u, l);
        }
    }
}
