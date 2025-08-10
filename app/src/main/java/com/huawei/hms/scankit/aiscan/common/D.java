package com.huawei.hms.scankit.aiscan.common;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.huawei.hms.scankit.p.C0409w;
import com.huawei.hms.scankit.p._a;
import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import java.util.Collection;
import java.util.Map;
import java.util.Vector;

/* compiled from: TwoDimDecoder.java */
/* loaded from: classes3.dex */
public class D {
    public static byte[] a(C0409w c0409w, Map<EnumC0312d, Object> map, x xVar, int[] iArr, double[] dArr) throws C0309a {
        if (c0409w == null) {
            return null;
        }
        Collection collection = map != null ? (Collection) map.get(EnumC0312d.POSSIBLE_FORMATS) : null;
        if (!(collection == null || collection.contains(BarcodeFormat.QR_CODE) || collection.contains(BarcodeFormat.PDF_417)) || xVar == null || xVar.i() != null) {
            iArr[0] = c0409w.e();
            iArr[1] = c0409w.c();
            return c0409w.d();
        }
        if (collection != null) {
            collection.clear();
            EnumC0312d enumC0312d = EnumC0312d.POSSIBLE_FORMATS;
            map.remove(enumC0312d);
            collection.add(xVar.b());
            map.put(enumC0312d, collection);
        } else if (map != null) {
            EnumC0312d enumC0312d2 = EnumC0312d.POSSIBLE_FORMATS;
            map.remove(enumC0312d2);
            Vector vector = new Vector();
            vector.add(xVar.b());
            map.put(enumC0312d2, vector);
        }
        float f = 3.0f / _a.e;
        if (f < 1.0f) {
            f = 1.0f;
        }
        dArr[5] = f;
        return a(c0409w, xVar.h(), dArr, iArr);
    }

    private static byte[] a(C0409w c0409w, z[] zVarArr, double[] dArr, int[] iArr) throws C0309a {
        if (zVarArr == null) {
            iArr[0] = c0409w.e();
            iArr[1] = c0409w.c();
            return c0409w.d();
        }
        int iE = c0409w.e();
        int iB = iE;
        int iC = c0409w.c();
        int iB2 = 0;
        int iC2 = 0;
        for (z zVar : zVarArr) {
            if (zVar != null) {
                if (((int) zVar.b()) < iB) {
                    iB = (int) zVar.b();
                }
                if (((int) zVar.c()) < iC) {
                    iC = (int) zVar.c();
                }
                if (((int) zVar.b()) > iB2) {
                    iB2 = (int) zVar.b();
                }
                if (((int) zVar.c()) > iC2) {
                    iC2 = (int) zVar.c();
                }
            }
        }
        return a(zVarArr, c0409w, iArr, Math.max(iB2 - iB, iC2 - iC), dArr);
    }

    private static byte[] a(z[] zVarArr, C0409w c0409w, int[] iArr, float f, double[] dArr) throws C0309a {
        float fB = zVarArr[0].b();
        float fB2 = zVarArr[1].b();
        float fB3 = zVarArr[2].b();
        float fC = zVarArr[0].c();
        float fC2 = zVarArr[1].c();
        float fC3 = zVarArr[2].c();
        if (fB >= 0.0f && fB2 >= 0.0f && fB3 >= 0.0f && fC >= 0.0f && fC2 >= 0.0f && fC3 >= 0.0f && fB <= c0409w.e() && fB2 <= c0409w.e() && fB3 <= c0409w.e() && fC <= c0409w.c() && fC2 <= c0409w.c() && fC3 <= c0409w.c()) {
            int i = ((int) (fC + fC3)) / 2;
            int i2 = (int) ((((int) (fB + fB3)) / 2) - f);
            if (i2 < 0) {
                i2 = 0;
            }
            int i3 = (int) (i - f);
            if (i3 < 0) {
                i3 = 0;
            }
            int iC = ((int) f) * 2;
            int iE = i2 + iC <= c0409w.e() ? iC : c0409w.e() - i2;
            if (i3 + iC > c0409w.c()) {
                iC = c0409w.c() - i3;
            }
            C0409w c0409wA = c0409w.a(i2, i3, iE, iC);
            dArr[0] = dArr[0] + Math.toDegrees(a(zVarArr[0], zVarArr[1])) + 90.0d;
            dArr[1] = i2;
            dArr[2] = i3;
            double d = iE;
            dArr[3] = d;
            double d2 = iC;
            dArr[4] = d2;
            double radians = Math.toRadians(dArr[0]);
            int iAbs = (int) (((Math.abs(Math.sin(radians)) * d) + (Math.abs(Math.cos(radians)) * d2)) * dArr[5]);
            int iAbs2 = (int) (((d2 * Math.abs(Math.sin(radians))) + (d * Math.abs(Math.cos(radians)))) * dArr[5]);
            iArr[0] = iAbs2;
            iArr[1] = iAbs;
            byte[] bArrImageRotate = LoadOpencvJNIUtil.imageRotate(c0409wA.d(), c0409wA.c(), c0409wA.e(), iAbs, iAbs2, (float) dArr[0], dArr[5]);
            if (bArrImageRotate != null) {
                return bArrImageRotate;
            }
            iArr[0] = c0409w.e();
            iArr[1] = c0409w.c();
            return c0409w.d();
        }
        iArr[0] = c0409w.e();
        iArr[1] = c0409w.c();
        throw C0309a.a();
    }

    public static double a(z zVar, z zVar2) {
        return Math.atan2(zVar2.c() - zVar.c(), zVar2.b() - zVar.b());
    }

    public static z[] a(z[] zVarArr, int i, int i2, double[] dArr) {
        z zVar;
        z[] zVarArr2;
        double d;
        z[] zVarArr3 = zVarArr;
        z zVar2 = null;
        if (zVarArr3 == null) {
            return null;
        }
        int i3 = dArr[3] != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? (int) dArr[3] : i;
        int i4 = dArr[4] != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? (int) dArr[4] : i2;
        double d2 = dArr[5];
        z[] zVarArr4 = new z[zVarArr3.length];
        int i5 = 0;
        double radians = Math.toRadians(dArr[0]);
        double dCos = Math.cos(radians) * d2;
        double dSin = Math.sin(radians) * d2;
        double d3 = i4;
        double d4 = i3;
        double dAbs = (((Math.abs(dSin) - dSin) * d3) + ((Math.abs(dCos) - dCos) * d4)) / 2.0d;
        double d5 = -dSin;
        double dAbs2 = ((d3 * (Math.abs(dCos) - dCos)) + (d4 * (Math.abs(dSin) + dSin))) / 2.0d;
        while (i5 < zVarArr3.length) {
            if (zVarArr3[i5] != null) {
                zVarArr2 = zVarArr4;
                double dB = (((r2.b() - dAbs) * dCos) + ((dAbs2 - r2.c()) * dSin)) / ((dCos * dCos) - (dSin * d5));
                d = d5;
                zVarArr2[i5] = new z(Math.round(dB) + ((int) dArr[1]), Math.round(dSin == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? (r2.c() - dAbs2) / dCos : ((r2.b() - dAbs) - (dCos * dB)) / dSin) + ((int) dArr[2]));
                zVar = null;
            } else {
                zVar = zVar2;
                zVarArr2 = zVarArr4;
                d = d5;
                zVarArr2[i5] = zVar;
            }
            i5++;
            d5 = d;
            zVar2 = zVar;
            zVarArr4 = zVarArr2;
            zVarArr3 = zVarArr;
        }
        return zVarArr4;
    }
}
