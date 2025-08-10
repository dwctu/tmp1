package com.huawei.hms.scankit.aiscan.common;

/* compiled from: AIScanException.java */
/* renamed from: com.huawei.hms.scankit.aiscan.common.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0309a extends Exception {
    public static final boolean a;
    public static final StackTraceElement[] b;
    private static final C0309a c;

    static {
        a = System.getProperty("surefire.test.class.path") != null;
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[0];
        b = stackTraceElementArr;
        C0309a c0309a = new C0309a();
        c = c0309a;
        c0309a.setStackTrace(stackTraceElementArr);
    }

    private C0309a() {
    }

    public static C0309a a() {
        return a ? new C0309a() : c;
    }

    private C0309a(String str) {
        super(str);
    }

    public static C0309a a(String str) {
        return new C0309a(str);
    }
}
