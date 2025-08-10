package com.huawei.hms.scankit.util;

import com.huawei.hms.scankit.k;

/* loaded from: classes3.dex */
public class OpencvJNI {
    static {
        a.c("OpencvJNI", "start load method");
        try {
            System.loadLibrary("scannative");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            a.b("OpencvJNI", "UnsatisfiedLinkError");
            k.a(false);
        }
    }

    public static native float[] QuadFitting(float[] fArr, int i, float[] fArr2);

    public static native byte[] adaptiveBinary(byte[] bArr, int i, int i2, int i3);

    public static native byte[] imageResize(byte[] bArr, int i, int i2, int i3, int i4);

    public static native byte[] imageRotate(byte[] bArr, int i, int i2, int i3, int i4, float f, double d);

    public static void init() {
        a.c("OpencvJNI", "init()");
    }

    public static native float[] multiBarcodeDetect(byte[] bArr, int i, int i2, int i3, boolean z);

    public static native void setModel(byte[] bArr, int i, float[] fArr, int i2, byte[] bArr2, int i3);
}
