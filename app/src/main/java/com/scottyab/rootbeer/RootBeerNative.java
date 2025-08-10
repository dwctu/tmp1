package com.scottyab.rootbeer;

import dc.jd1;

/* loaded from: classes3.dex */
public class RootBeerNative {
    public static boolean a = false;

    static {
        try {
            System.loadLibrary("toolChecker");
            a = true;
        } catch (UnsatisfiedLinkError e) {
            jd1.b(e);
        }
    }

    public boolean a() {
        return a;
    }

    public native int checkForRoot(Object[] objArr);

    public native int setLogDebugMessages(boolean z);
}
