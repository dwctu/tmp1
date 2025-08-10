package com.huawei.hms.scankit.p;

import java.security.SecureRandom;

/* compiled from: RandomUtil.java */
/* loaded from: classes3.dex */
public class Yc {
    private static final SecureRandom a = new SecureRandom();

    public static int a(int i) {
        return a.nextInt(i);
    }

    public static float a(float f) {
        return a.nextFloat() * f;
    }
}
