package com.huawei.hms.scankit.p;

import java.util.Stack;

/* compiled from: GlobalVariable.java */
/* loaded from: classes3.dex */
public class _a {
    public static boolean a = true;
    public static boolean c = false;
    public static boolean d = false;
    public static float e = -1.0f;
    public static int f = 0;
    public static int g = 0;
    public static boolean h = false;
    public static boolean i = false;
    public static boolean j = false;
    public static boolean k = false;
    public static boolean l = false;
    public static boolean m = false;
    public static boolean n = false;
    public static boolean o = false;
    public static boolean p = false;
    public static boolean[] q = new boolean[8];
    public static Stack<Integer> r = new Stack<>();
    public static boolean s = true;
    public static boolean b = true;

    static {
        com.huawei.hms.scankit.util.a.c("BUILDING FLAG", "use lite sdk");
    }

    public static void a() {
        d = false;
        e = -1.0f;
        f = 0;
        k = false;
        l = false;
        m = false;
        o = false;
        h = false;
        i = false;
        j = false;
        n = false;
        q = new boolean[8];
        r = new Stack<>();
        s = true;
    }

    public static void a(int i2) {
        if (i2 % 2 == 1) {
            k = true;
        }
        if (i2 % 3 == 2) {
            l = true;
        }
        if (i2 % 5 == 4) {
            m = true;
        }
    }

    public static void a(com.huawei.hms.scankit.E e2) {
        a();
        boolean z = e2.e;
        c = z;
        s = e2.g;
        if (!z) {
            a(e2.f);
        } else {
            a(1);
        }
    }
}
