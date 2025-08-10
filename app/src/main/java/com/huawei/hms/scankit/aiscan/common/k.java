package com.huawei.hms.scankit.aiscan.common;

import com.huawei.hms.scankit.p.C0409w;
import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;

/* compiled from: ImageResize.java */
/* loaded from: classes3.dex */
public class k {
    public static int a(int i, int i2, int i3) {
        return i >= i2 ? i2 : i <= i3 ? i3 : i;
    }

    public static C0409w a(C0409w c0409w) {
        int iE = c0409w.e();
        int iC = c0409w.c();
        byte[] bArrD = c0409w.d();
        byte[] bArr = new byte[iE * iC];
        for (int i = 0; i < iC; i++) {
            for (int i2 = 0; i2 < iE; i2++) {
                bArr[(((i2 * iC) + iC) - i) - 1] = bArrD[(i * iE) + i2];
            }
        }
        return new C0409w(new com.huawei.hms.scankit.p.B(new r(bArr, iC, iE, 0, 0, iC, iE, false)));
    }

    public static C0409w a(C0409w c0409w, float f) {
        if (f == 1.0f) {
            return c0409w;
        }
        int iC = c0409w.c();
        int iE = c0409w.e();
        int i = (int) (iE / f);
        int i2 = (int) (iC / f);
        byte[] bArrD = c0409w.d();
        int i3 = i * i2;
        byte[] bArr = new byte[i3];
        int i4 = 0;
        int i5 = 0;
        while (i5 < i3) {
            double dA = a(i5 % i, i - 1, i4) * f;
            double dA2 = a(i5 / i, i2 - 1, i4) * f;
            double dFloor = Math.floor(dA);
            int i6 = i5;
            double dFloor2 = Math.floor(dA2);
            double d = dA - dFloor;
            double d2 = dA2 - dFloor2;
            int i7 = i3;
            int iA = a((int) dFloor, iE - 1, 0);
            int iA2 = a((int) dFloor2, iC - 1, 0);
            int i8 = iA2 * iE;
            int i9 = iC;
            int i10 = i;
            double d3 = 1.0d - d;
            double d4 = 1.0d - d2;
            int i11 = iA + 1;
            byte[] bArr2 = bArr;
            int i12 = iA2 + 1;
            bArr2[i6] = (byte) (((int) (((bArrD[i8 + iA] & 255) * d3 * d4) + ((bArrD[i8 + a(i11, r14, 0)] & 255) * d * d4) + ((bArrD[(a(i12, r6, 0) * iE) + iA] & 255) * d3 * d2) + ((bArrD[(a(i12, r6, 0) * iE) + a(i11, r14, 0)] & 255) * d * d2))) & 255);
            i5 = i6 + 1;
            i3 = i7;
            i = i10;
            iC = i9;
            i2 = i2;
            bArr = bArr2;
            i4 = 0;
        }
        return new C0409w(new com.huawei.hms.scankit.p.B(new r(bArr, i, i2, 0, 0, i, i2, false)));
    }

    public static C0409w a(boolean z, C0409w c0409w, float f) {
        if (f == 1.0f) {
            return c0409w;
        }
        int iC = c0409w.c();
        int iE = c0409w.e();
        int i = (int) (iE / f);
        int i2 = (int) (iC / f);
        return new C0409w(new com.huawei.hms.scankit.p.B(new r(LoadOpencvJNIUtil.imageResize(c0409w.d(), iC, iE, i2, i), i, i2, 0, 0, i, i2, false)));
    }
}
