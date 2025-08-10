package com.component.dxdtxutils.lib;

/* loaded from: classes.dex */
public class D {
    static {
        try {
            System.loadLibrary("dxdtx");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static native String _free(String str);

    public static native String _malloc();

    public static native String _rand(String str);

    public static native int _sprintf();
}
