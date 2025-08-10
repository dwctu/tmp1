package com.huawei.hms.scankit.aiscan.common;

import java.util.HashMap;

/* compiled from: ToneMapping.java */
/* loaded from: classes3.dex */
public class C {
    private static float a = 2.51f;
    private static float b = 0.03f;
    private static float c = 2.43f;
    private static float d = 0.59f;
    private static float e = 0.14f;
    private static HashMap<Integer, Integer> f = new HashMap<>(255);

    private static int a(int i, float f2) {
        if (f.containsKey(Integer.valueOf(i))) {
            return f.get(Integer.valueOf(i)).intValue();
        }
        float f3 = i / f2;
        int i2 = (int) ((f2 * (((a * f3) + b) * f3)) / ((f3 * ((c * f3) + d)) + e));
        f.put(Integer.valueOf(i), Integer.valueOf(i2));
        return i2;
    }

    private static int b(m mVar) {
        if (mVar.b() == null) {
            return 1;
        }
        long j = 0;
        int iC = mVar.c();
        int iA = mVar.a();
        for (int i = iA / 4; i < (iA * 3) / 4; i++) {
            for (int i2 = iC / 4; i2 < (iC * 3) / 4; i2++) {
                j += r0[(i * iC) + i2] & 255;
            }
        }
        return (int) ((j / r0.length) * 4);
    }

    public static m a(m mVar) {
        int iB = b(mVar);
        int iC = mVar.c();
        int iA = mVar.a();
        byte[] bArrB = mVar.b();
        byte[] bArr = new byte[iA * iC];
        for (int i = 0; i < iA; i++) {
            for (int i2 = 0; i2 < iC; i2++) {
                int i3 = (i * iC) + i2;
                bArr[i3] = (byte) (a(bArrB[i3] & 255, iB) & 255);
            }
        }
        f = new HashMap<>(255);
        return new r(bArr, iC, iA, 0, 0, iC, iA, false);
    }
}
