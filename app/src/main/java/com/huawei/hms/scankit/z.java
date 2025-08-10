package com.huawei.hms.scankit;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: MsModel.java */
/* loaded from: classes3.dex */
public class z {
    private static byte[] a = null;
    private static byte[] b = null;
    private static float[] c = null;
    private static int d = 8136;

    public static int a() {
        return d;
    }

    public static void b(Context context, String str) throws IOException {
        com.huawei.hms.scankit.util.a.c("MsModel", "load model...." + str);
        if (a != null) {
            return;
        }
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            StringBuilder sb = new StringBuilder();
            sb.append("inputStream");
            sb.append(inputStreamOpen);
            com.huawei.hms.scankit.util.a.c("MsModel", sb.toString());
            byte[] bArr = new byte[inputStreamOpen.available()];
            inputStreamOpen.read(bArr);
            inputStreamOpen.close();
            a = bArr;
        } catch (IOException unused) {
            com.huawei.hms.scankit.util.a.b("MsModel", "loadModel IOException");
        } catch (Exception unused2) {
            com.huawei.hms.scankit.util.a.b("MsModel", "loadModel Exception");
        }
    }

    public static byte[] c() {
        return a;
    }

    public static float[] d() {
        return c;
    }

    public static float a(byte[] bArr, int i) {
        return Float.intBitsToFloat((int) ((bArr[i + 3] << 24) | (16777215 & ((int) ((65535 & ((int) ((bArr[i + 0] & 255) | (bArr[i + 1] << 8)))) | (bArr[i + 2] << 16))))));
    }

    public static void c(Context context, String str) throws IOException {
        com.huawei.hms.scankit.util.a.c("MsModel", "ms anrchos...." + str);
        if (c != null) {
            return;
        }
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            StringBuilder sb = new StringBuilder();
            sb.append("2inputStream");
            sb.append(inputStreamOpen);
            com.huawei.hms.scankit.util.a.c("MsModel", sb.toString());
            int iAvailable = inputStreamOpen.available();
            byte[] bArr = new byte[iAvailable];
            inputStreamOpen.read(bArr);
            inputStreamOpen.close();
            c = new float[iAvailable / 4];
            int i = 0;
            while (true) {
                float[] fArr = c;
                if (i >= fArr.length) {
                    return;
                }
                fArr[i] = a(bArr, i * 4);
                i++;
            }
        } catch (IOException unused) {
            com.huawei.hms.scankit.util.a.b("MsModel", "loadMsAnchors IOException");
        } catch (Exception unused2) {
            com.huawei.hms.scankit.util.a.b("MsModel", "loadMsAnchors Exception");
        }
    }

    public static void a(Context context, String str) throws IOException {
        com.huawei.hms.scankit.util.a.c("MsModel", "load angle model...." + str);
        if (b != null) {
            return;
        }
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            StringBuilder sb = new StringBuilder();
            sb.append("3inputStream");
            sb.append(inputStreamOpen);
            com.huawei.hms.scankit.util.a.c("MsModel", sb.toString());
            byte[] bArr = new byte[inputStreamOpen.available()];
            inputStreamOpen.read(bArr);
            inputStreamOpen.close();
            b = bArr;
        } catch (IOException unused) {
            com.huawei.hms.scankit.util.a.b("MsModel", "loadAngleModel IOException");
        } catch (Exception unused2) {
            com.huawei.hms.scankit.util.a.b("MsModel", "loadAngleModel Exception");
        }
    }

    public static byte[] b() {
        return b;
    }
}
