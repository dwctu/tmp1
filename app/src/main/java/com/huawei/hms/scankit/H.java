package com.huawei.hms.scankit;

import android.graphics.Rect;
import com.huawei.hms.scankit.p._a;

/* compiled from: Zoom.java */
/* loaded from: classes3.dex */
public class H {
    public static float a(int i, int i2, com.huawei.hms.scankit.aiscan.common.z[] zVarArr) {
        float fAbs;
        float fAbs2;
        float f = 1.0f;
        if (zVarArr.length < 3) {
            return 1.0f;
        }
        int i3 = 0;
        for (com.huawei.hms.scankit.aiscan.common.z zVar : zVarArr) {
            if (zVar.d()) {
                i3++;
            }
        }
        if (_a.a && !_a.b && i3 < 2) {
            return 1.0f;
        }
        float fB = zVarArr[0].b();
        float fB2 = zVarArr[1].b();
        float fB3 = zVarArr[2].b();
        float fC = zVarArr[0].c();
        float fC2 = zVarArr[1].c();
        float fC3 = zVarArr[2].c();
        com.huawei.hms.scankit.aiscan.common.z zVarA = a(fB, fC, fB2, fC2, fB3, fC3);
        float fB4 = zVarA.b();
        float fC4 = zVarA.c();
        float fMax = Math.max(Math.max(Math.max(fB, fB2), fB3), fB4);
        float fMin = Math.min(Math.min(Math.min(fB, fB2), fB3), fB4);
        float fMax2 = Math.max(Math.max(Math.max(fC, fC2), fC3), fC4);
        float fMin2 = Math.min(Math.min(Math.min(fC, fC2), fC3), fC4);
        int iMin = (int) (Math.min(i2, i) * 0.85f);
        int i4 = (i - iMin) / 2;
        int i5 = (i2 - iMin) / 2;
        Rect rect = new Rect(i4, i5, iMin + i4, iMin + i5);
        if (fMin < rect.left && fMin2 < rect.top && fMax > rect.right && fMax2 > rect.bottom) {
            return 1.0f;
        }
        float fAbs3 = Math.abs(fMin2 - rect.top);
        float fAbs4 = Math.abs(fMin - rect.left);
        float fAbs5 = Math.abs(fMax - rect.right);
        float fAbs6 = Math.abs(fMax2 - rect.bottom);
        float f2 = (rect.left + rect.right) / 2.0f;
        float f3 = (rect.top + rect.bottom) / 2.0f;
        float fMin3 = Math.min(Math.min(Math.min(fAbs4, fAbs5), fAbs3), fAbs6);
        if (0.01f > Math.abs(fAbs4 - fMin3)) {
            fAbs = Math.abs(f2 - rect.left) * 1.0f;
            fAbs2 = Math.abs(f2 - fMin);
        } else if (0.01f > Math.abs(fAbs5 - fMin3)) {
            fAbs = Math.abs(f2 - rect.right) * 1.0f;
            fAbs2 = Math.abs(f2 - fMax);
        } else {
            if (0.01f <= Math.abs(fAbs3 - fMin3)) {
                if (0.01f > Math.abs(fAbs6 - fMin3)) {
                    fAbs = Math.abs(f3 - rect.bottom) * 1.0f;
                    fAbs2 = Math.abs(f3 - fMax2);
                }
                return Math.min(f, 2.0f) * 0.9f;
            }
            fAbs = Math.abs(f3 - rect.top) * 1.0f;
            fAbs2 = Math.abs(f3 - fMin2);
        }
        f = fAbs / fAbs2;
        return Math.min(f, 2.0f) * 0.9f;
    }

    public static float b(int i, int i2, com.huawei.hms.scankit.aiscan.common.z[] zVarArr) {
        float fAbs;
        float fAbs2;
        float f = 1.0f;
        if (zVarArr.length < 3) {
            return 1.0f;
        }
        float fB = zVarArr[0].b();
        float fB2 = zVarArr[1].b();
        float fB3 = zVarArr[2].b();
        float fC = zVarArr[0].c();
        float fC2 = zVarArr[1].c();
        float fC3 = zVarArr[2].c();
        float fMax = Math.max(Math.max(fB, fB2), fB3);
        float fMin = Math.min(Math.min(fB, fB2), fB3);
        float fMax2 = Math.max(Math.max(fC, fC2), fC3);
        float fMin2 = Math.min(Math.min(fC, fC2), fC3);
        int iMin = (int) (Math.min(i2, i) * 0.1f);
        Rect rect = new Rect(iMin, iMin, i - iMin, i2 - iMin);
        if (fMin < rect.left && fMin2 < rect.top && fMax > rect.right && fMax2 > rect.bottom) {
            return 1.0f;
        }
        float fAbs3 = Math.abs(fMax - rect.right);
        float fAbs4 = Math.abs(fMax2 - rect.bottom);
        float fAbs5 = Math.abs(fMin2 - rect.top);
        float fAbs6 = Math.abs(fMin - rect.left);
        float f2 = (rect.left + rect.right) / 2.0f;
        float f3 = (rect.top + rect.bottom) / 2.0f;
        float fMin3 = Math.min(Math.min(Math.min(fAbs6, fAbs3), fAbs5), fAbs4);
        if (0.01f > Math.abs(fAbs6 - fMin3)) {
            fAbs = Math.abs(f2 - rect.left);
            fAbs2 = Math.abs(f2 - fMin);
        } else if (0.01f > Math.abs(fAbs3 - fMin3)) {
            fAbs = Math.abs(f2 - rect.right);
            fAbs2 = Math.abs(f2 - fMax);
        } else {
            if (0.01f <= Math.abs(fAbs5 - fMin3)) {
                if (0.01f > Math.abs(fAbs4 - fMin3)) {
                    fAbs = Math.abs(f3 - rect.bottom);
                    fAbs2 = Math.abs(f3 - fMax2);
                }
                return Math.min(f, 2.0f) * 0.9f;
            }
            fAbs = Math.abs(f3 - rect.top);
            fAbs2 = Math.abs(f3 - fMin2);
        }
        f = fAbs / fAbs2;
        return Math.min(f, 2.0f) * 0.9f;
    }

    private static com.huawei.hms.scankit.aiscan.common.z a(float f, float f2, float f3, float f4, float f5, float f6) {
        return new com.huawei.hms.scankit.aiscan.common.z((f + f5) - f3, (f2 + f6) - f4);
    }
}
