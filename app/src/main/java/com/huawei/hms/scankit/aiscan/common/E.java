package com.huawei.hms.scankit.aiscan.common;

import java.util.List;

/* compiled from: Util.java */
/* loaded from: classes3.dex */
public class E {
    public static List<x> a(List<x> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int size = list.size() - 1; size > i; size--) {
                if (list.get(i).i().equals(list.get(size).i()) && a(r2.h(), r3.h()) > 0.5d) {
                    list.remove(size);
                }
            }
        }
        return list;
    }

    public static float a(z[] zVarArr, z[] zVarArr2) {
        float fB = Float.MAX_VALUE;
        float fB2 = Float.MIN_VALUE;
        float fB3 = Float.MIN_VALUE;
        float fB4 = Float.MAX_VALUE;
        float fC = Float.MIN_VALUE;
        float fC2 = Float.MAX_VALUE;
        for (z zVar : zVarArr) {
            if (zVar.b() > fB3) {
                fB3 = zVar.b();
            }
            if (zVar.b() < fB4) {
                fB4 = zVar.b();
            }
            if (zVar.c() > fC) {
                fC = zVar.c();
            }
            if (zVar.c() < fC2) {
                fC2 = zVar.c();
            }
        }
        float fC3 = Float.MAX_VALUE;
        float fC4 = Float.MIN_VALUE;
        for (z zVar2 : zVarArr2) {
            if (zVar2.b() > fB2) {
                fB2 = zVar2.b();
            }
            if (zVar2.b() < fB) {
                fB = zVar2.b();
            }
            if (zVar2.c() > fC4) {
                fC4 = zVar2.c();
            }
            if (zVar2.c() < fC3) {
                fC3 = zVar2.c();
            }
        }
        float f = (fB2 < fB3 ? fB2 : fB3) - (fB > fB4 ? fB : fB4);
        float f2 = (fC4 < fC ? fC4 : fC) - (fC3 > fC2 ? fC3 : fC2);
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        float f3 = f * f2;
        return f3 / ((((fB3 - fB4) * (fC - fC2)) + ((fB2 - fB) * (fC4 - fC3))) - f3);
    }
}
